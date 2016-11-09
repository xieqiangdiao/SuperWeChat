package cn.ucai.superwechat.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyphenate.easeui.domain.User;
import com.hyphenate.easeui.utils.EaseUserUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.superwechat.I;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.SuperWeChatHelper;
import cn.ucai.superwechat.utils.MFGT;

public class FriendProfileActivity extends AppCompatActivity {
    User user;
    @Bind(R.id.img_back)
    TextView imgBack;
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
    /*@Bind(R.id.iv_back)
    ImageView ivBack;*/
    @Bind(R.id.add_contact)
    Button addContact;
    @Bind(R.id.butSendMsg)
    Button butSendMsg;
    @Bind(R.id.butSendVideo)
    Button butSendVideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firend_profile);
        ButterKnife.bind(this);
        user = (User) getIntent().getSerializableExtra(I.User.USER_NAME);
        if (user == null) {
            MFGT.finish(this);
        }
        initView();
    }

    private void initView() {
        imgBack.setVisibility(View.VISIBLE);
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(getString(R.string.userinfo_txt_profile));
        setUserInfo();
        isFriend();
    }

    private void setUserInfo() {
        EaseUserUtils.setAppUserAvatar(this, user.getMUserName(), imgPop);
        EaseUserUtils.setAppUserNick( user.getMUserNick(), tvUserInfoNick);
        EaseUserUtils.setAppUserNameWithNo(user.getMUserName(), tvUserName);

    }


    public void isFriend() {
        if (SuperWeChatHelper.getInstance().getAppContactList().containsKey(user.getMUserName())) {
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
               MFGT.gotoAddFrendrofile(this,user.getMUserName());
                break;
            case R.id.butSendMsg:
                MFGT.gotoChat(this,user.getMUserName());
                break;
            case R.id.butSendVideo:
                break;
        }

    }
}
