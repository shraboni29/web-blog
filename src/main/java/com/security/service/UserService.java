package com.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.security.commandform.UserCommandForm;
import com.security.entity.Users;

public interface UserService extends UserDetailsService{
	
	Users findByUserName(String username);

	void saveuserImp(UserCommandForm u1);

	Users findByEmail(String email);

	Users findUserbyid(int user_id);

	
	
}
