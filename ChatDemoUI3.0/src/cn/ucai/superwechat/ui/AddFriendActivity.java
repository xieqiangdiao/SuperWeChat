package cn.ucai.superwechat.ui;

import android.os.Bundle;

import cn.ucai.superwechat.I;
import cn.ucai.superwechat.R;

/**
 * Created by Administrator on 2016/11/7.
 */
public class AddFriendActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firend_profile);
        getIntent().getStringArrayExtra(I.User.USER_NAME);
        initView();
    }

    private void initView() {
    }

    private void sendMsg() {

    }
}
