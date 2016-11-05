/**
 * Copyright (C) 2016 Hyphenate Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.ucai.superwechat.db;

import java.util.List;
import java.util.Map;

import android.content.Context;

import cn.ucai.superwechat.domain.RobotUser;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.domain.User;

public class UserDao {
	public static final String TABLE_NAME = "uers";
	public static final String COLUMN_NAME_ID = "username";
	public static final String COLUMN_NAME_NICK = "nick";
	public static final String COLUMN_NAME_AVATAR = "avatar";
	
	public static final String PREF_TABLE_NAME = "pref";
	public static final String COLUMN_NAME_DISABLED_GROUPS = "disabled_groups";
	public static final String COLUMN_NAME_DISABLED_IDS = "disabled_ids";

	public static final String ROBOT_TABLE_NAME = "robots";
	public static final String ROBOT_COLUMN_NAME_ID = "username";
	public static final String ROBOT_COLUMN_NAME_NICK = "nick";
	public static final String ROBOT_COLUMN_NAME_AVATAR = "avatar";

	public static final String TABLE_USER_NAME = "t_superwechat_user";
	public static final String TABLE_COLUMN_NAME = "m_user_name";
	public static final String TABLE_COLUMN_NICK = "m_user_nick";
	public static final String TABLE_COLUMN_AVATAR_ID = "m_avatar_user_id";
	public static final String TABLE_COLUMN_AVATAR_TYPE = "m_avatar_type";
	public static final String TABLE_COLUMN_AVATAR_PATH = "m_avatar_path";
	public static final String TABLE_COLUMN_SUFFIX = "m_user_avatar_suffix";
	public static final String TABLE_COLUMN_LASTUPDATE_TIME = "m_user_avatar_lastupdate_time";



	/**
	 * save contact list
	 * 
	 * @param contactList
	 */
	public void saveContactList(List<EaseUser> contactList) {
	    SuperWeChatManager.getInstance().saveContactList(contactList);
	}

	/**
	 * get contact list
	 * 
	 * @return
	 */
	public Map<String, EaseUser> getContactList() {
		
	    return SuperWeChatManager.getInstance().getContactList();
	}
	
	/**
	 * delete a contact
	 * @param username
	 */
	public void deleteContact(String username){
	    SuperWeChatManager.getInstance().deleteContact(username);
	}
	
	/**
	 * save a contact
	 * @param user
	 */
	public void saveContact(EaseUser user){
	    SuperWeChatManager.getInstance().saveContact(user);
	}
	
	public void setDisabledGroups(List<String> groups){
	    SuperWeChatManager.getInstance().setDisabledGroups(groups);
    }
    
    public List<String>  getDisabledGroups(){       
        return SuperWeChatManager.getInstance().getDisabledGroups();
    }
    
    public void setDisabledIds(List<String> ids){
        SuperWeChatManager.getInstance().setDisabledIds(ids);
    }
    
    public List<String> getDisabledIds(){
        return SuperWeChatManager.getInstance().getDisabledIds();
    }
    
    public Map<String, RobotUser> getRobotUser(){
    	return SuperWeChatManager.getInstance().getRobotList();
    }
    
    public void saveRobotUser(List<RobotUser> robotList){
    	SuperWeChatManager.getInstance().saveRobotList(robotList);
    }

	public boolean saveUser(User user) {
		return SuperWeChatManager.getInstance().saveUser(user);
	}

	public User getUser(String username) {

		return SuperWeChatManager.getInstance().getUser(username);
	}

	public boolean updateUser(User user) {

		return SuperWeChatManager.getInstance().updateUser(user);
	}
	public UserDao(Context context) {
	}

	public void saveAppContact(User user) {
		SuperWeChatManager.getInstance().saveAppContact(user);
	}
	public Map<String,User> getAppContactList(){
		return  SuperWeChatManager.getInstance().getAppContactList();

	}
	public void saveAppContactList(List<User> contactList) {
		SuperWeChatManager.getInstance().saveAppContactList(contactList);
	}
}
