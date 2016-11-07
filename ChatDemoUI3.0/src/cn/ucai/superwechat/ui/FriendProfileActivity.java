package cn.ucai.superwechat.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
    ImageView imgBack;
    @Bind(R.id.img_pop)
    ImageView imgPop;
    @Bind(R.id.view_user)
    RelativeLayout viewUser;
    @Bind(R.id.tv_User_name)
    TextView tvUserName;
    @Bind(R.id.tvUser_info_Nick)
    TextView tvUserInfoNick;
    @Bind(R.id.rv_title)
    RelativeLayout rvTitle;
    @Bind(R.id.tv_title)
    RelativeLayout tvTitle;
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
        EaseUserUtils.setAppUserNick(this, user.getMUserNick(), tvUserInfoNick);
        EaseUserUtils.setAppUserNameWithNo(this, user.getMUserName(), tvUserName);

    }


    public boolean isFriend() {
        if (SuperWeChatHelper.getInstance().getAppContactList().containsKey(user.getMUserName())) {

        }

    }

    @OnClick(R.id.img_back)
    public void onClick() {
        MFGT.finish(this);
    }


}
