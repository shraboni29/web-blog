package com.security.dao;

import com.security.commandform.UserCommandForm;
import com.security.entity.Users;

public interface UserDao {

	void saveuserImp(UserCommandForm u2);

	Users findByUserName(String username);

	Users findByEmail(String email);

	Users findUserbyid(int user_id);

}
