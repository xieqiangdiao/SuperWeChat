package cn.ucai.superwechat.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.domain.User;
import com.hyphenate.easeui.utils.EaseUserUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.superwechat.I;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.SuperWeChatHelper;
import cn.ucai.superwechat.bean.Result;
import cn.ucai.superwechat.data.NetDao;
import cn.ucai.superwechat.data.OkHttpUtils;
import cn.ucai.superwechat.utils.L;
import cn.ucai.superwechat.utils.MFGT;
import cn.ucai.superwechat.utils.ResultUtils;

public class FriendProfileActivity extends AppCompatActivity {
    private final static String TAG = FriendProfileActivity.class.getSimpleName();
    String username = null;
    @Bind(R.id.img_back)
    ImageView imgBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.img_right)
    ImageView imgRight;
    @Bind(R.id.img_pop)
    ImageView imgPop;
    @Bind(R.id.tv_User_name)
    TextView tvUserName;
    @Bind(R.id.tvUser_info_Nick)
    TextView tvUserInfoNick;
    @Bind(R.id.add_contact)
    Button addContact;
    @Bind(R.id.butSendMsg)
    Button butSendMsg;
    @Bind(R.id.butSendVideo)
    Button butSendVideo;
    User user = null;
    boolean isFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firend_profile);
        ButterKnife.bind(this);
        username = getIntent().getStringExtra(I.User.USER_NAME);
        if (username == null) {
            MFGT.finish(this);
            return;
        }
        initView();
        user = SuperWeChatHelper.getInstance().getAppContactList().get(username);
        if (user == null) {
            isFriend = false;
        } else {
            setUserInfo();
            isFriend = true;
        }
        isFriend(isFriend);
        syncUserInfo();
    }



    private void initView() {
        imgBack.setVisibility(View.VISIBLE);
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(getString(R.string.userinfo_txt_profile));


    }

    private void setUserInfo() {
        EaseUserUtils.setAppUserAvatar(this, user.getMUserName(), imgPop);
        EaseUserUtils.setAppUserNick(user.getMUserNick(), tvUserInfoNick);
        EaseUserUtils.setAppUserNameWithNo(user.getMUserName(), tvUserName);

    }

    private void syncUserInfo() {
        NetDao.syncUserInfo(this, username, new OkHttpUtils.OnCompleteListener<String>() {
            @Override
            public void onSuccess(String s) {
                if (s != null) {
                    Result result = ResultUtils.getResultFromJson(s, User.class);
                    if (result != null && result.isRetMsg()) {
                        User u = (User) result.getRetData();
                        if (u != null) {
                            L.e(TAG,"u="+u.getAvatar());
                            if (isFriend) {
                                SuperWeChatHelper.getInstance().saveAppContact(user);
                            }
                            user=u;
                            setUserInfo();
                        } else {
                            syncFail();
                        }
                    } else {
                        syncFail();
                    }
                } else {
                    syncFail();
                }
            }

            @Override
            public void onError(String error) {
                syncFail();
            }
        });
    }

    private void syncFail() {
        if(!isFriend) {
            MFGT.finish(this);
            return;
        }
    }

    public void isFriend(boolean isFriend) {
        if (isFriend) {
            butSendMsg.setVisibility(View.VISIBLE);
            butSendVideo.setVisibility(View.VISIBLE);
        } else {
            addContact.setVisibility(View.VISIBLE);
        }

    }

    @OnClick({R.id.img_back, R.id.add_contact, R.id.butSendMsg, R.id.butSendVideo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                MFGT.finish(this);
                break;
            case R.id.add_contact:
                MFGT.gotoAddFrendrofile(this, user.getMUserName());
                break;
            case R.id.butSendMsg:
                MFGT.gotoChat(this, user.getMUserName());
                break;
            case R.id.butSendVideo:
                if (!EMClient.getInstance().isConnected())
                    Toast.makeText(this, R.string.not_connect_to_server, Toast.LENGTH_SHORT).show();
                else {
                    startActivity(new Intent(this, VideoCallActivity.class).putExtra("username", user.getMUserName())
                            .putExtra("isComingCall", false));
                    // videoCallBtn.setEnabled(false);
                }
                break;
        }

    }
}
