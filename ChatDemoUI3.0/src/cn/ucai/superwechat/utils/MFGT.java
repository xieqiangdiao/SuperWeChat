package cn.ucai.superwechat.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.hyphenate.easeui.domain.User;

import cn.ucai.superwechat.I;
import cn.ucai.superwechat.R;

import cn.ucai.superwechat.ui.AddContactActivity;
import cn.ucai.superwechat.ui.AddFriendActivity;
import cn.ucai.superwechat.ui.ChatActivity;
import cn.ucai.superwechat.ui.FriendProfileActivity;
import cn.ucai.superwechat.ui.GroupsActivity;
import cn.ucai.superwechat.ui.LoginActivity;
import cn.ucai.superwechat.ui.NewFriendsMsgActivity;
import cn.ucai.superwechat.ui.NewGroupActivity;
import cn.ucai.superwechat.ui.PublicGroupsActivity;
import cn.ucai.superwechat.ui.RegisterActivity;
import cn.ucai.superwechat.ui.SettingsActivity;
import cn.ucai.superwechat.ui.UserProfileActivity;


public class MFGT {
    public static void finish(Activity activity) {
        activity.finish();
        activity.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

    public static void startActivity(Activity context, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        startActivity(context, intent);
    }

    public static void startActivity(Context context, Intent intent) {
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public static void startActivityForResult(Activity context, Intent intent, int requestCode) {
        context.startActivityForResult(intent, requestCode);
        context.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public static void gotoLogin(Activity context) {
        startActivity(context, LoginActivity.class);

    }

    public static void gotoRegister(Activity context) {
        startActivity(context, RegisterActivity.class);

    }

    public static void gotoSettings(Activity context) {
        startActivity(context, SettingsActivity.class);

    }

    public static void gotoUserProfile(Activity context) {
        startActivity(context, UserProfileActivity.class);

    }

    public static void gotoAddFirend(Activity context) {
        startActivity(context, AddContactActivity.class);

    }

    public static void gotoFrendProfile(Activity context, String username) {
        Intent intent = new Intent();
        intent.setClass(context, FriendProfileActivity.class);
        intent.putExtra(I.User.USER_NAME, username);
        startActivity(context, intent);

    }

    public static void gotoAddFrendrofile(Activity context, String username) {
        Intent intent = new Intent();
        intent.setClass(context, AddFriendActivity.class);
        intent.putExtra(I.User.USER_NAME, username);
        startActivity(context, intent);

    }

    public static void gotoNewFriendsMsg(Activity context) {
        startActivity(context, NewFriendsMsgActivity.class);

    }

    public static void gotoChat(Activity context, String username) {
        Intent intent = new Intent();
        intent.setClass(context, ChatActivity.class);
        intent.putExtra("userId", username);
        startActivity(context, intent);
    }
    public static void gotoGroup(Activity context) {
        startActivity(context, GroupsActivity.class);

    }
    public static void gotoCreateNewGroup(Activity context) {
        startActivity(context, NewGroupActivity.class);

    }
    public static void gotoPublicGroup(Activity context) {
        startActivity(context, PublicGroupsActivity.class);

    }
}
