package com.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.commandform.UserCommandForm;
import com.security.dao.UserDao;
import com.security.entity.Users;

@Service
public class UserServiceImp implements UserService {
  @Autowired
   public UserDao userDao;
	private final String ROLE = "ROLE_";
	
	@Override
	public void saveuserImp(UserCommandForm u1) {
		userDao.saveuserImp(u1);
	}

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users u = findByUserName(username);
		//Users u2=findByEmail(email);
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority> ();
		list.add(new SimpleGrantedAuthority(u.getAuthorities().getAuthority()));
		return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), list);
	}
	

	@Override
	public Users findByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username);
	}

	@Override
	public Users findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email);
	}


	@Override
	public Users findUserbyid(int user_id) {
		// TODO Auto-generated method stub
		return userDao.findUserbyid(user_id);
	}


	
}
