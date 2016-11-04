package cn.ucai.superwechat.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.utils.MFGT;

public class GuideActivity extends BaseActivity {

    @Bind(R.id.iv_splash_logo)
    ImageView ivSplashLogo;
    @Bind(R.id.img_login)
    Button imgLogin;
    @Bind(R.id.img_register)
    Button imgRegister;
    @Bind(R.id.splash_root)
    RelativeLayout splashRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_login, R.id.img_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_login:
                MFGT.gotoLogin(this);
                break;
            case R.id.img_register:
                MFGT.gotoRegister(this);
                break;
        }
    }
}
