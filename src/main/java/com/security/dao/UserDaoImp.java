package com.security.dao;

import javax.transaction.Transactional;

//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//import com.mysql.cj.Query;
import com.security.commandform.UserCommandForm;
import com.security.entity.Authorities;
import com.security.entity.Post;
//import com.mysql.cj.xdevapi.SessionFactory;
import com.security.entity.Users;
@Repository
@Component
public class UserDaoImp implements UserDao{
	@Autowired
	public SessionFactory sessionFactory;
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	private final String ROLE = "ROLE_";
	
	@Transactional
	@Override
	public void saveuserImp(UserCommandForm u1) {
		Users u2= new Users();
		u2.setFirstName(u1.getFirstName());
		u2.setLastName(u1.getLastName());
		u2.setEnable(1);
		u2.setPassword(passwordEncoder.encode(u1.getPassword()));
		System.out.println("<<<<<<<<<<<<hello>>>>>"+passwordEncoder.encode(u1.getPassword()));
		u2.setEmail(u1.getEmail());
		u2.setUsername(u1.getUsername());
		System.out.println(u1.toString());
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(u2);
		
		Authorities authorities = new Authorities();
		authorities.setUsername(u1.getUsername());
		authorities.setAuthority(ROLE.concat(u1.getRole()));
		authorities.setUser(u2);
		
		session.saveOrUpdate(authorities);
//		Post post=new Post();
//		post.setUser(u2.getUser_id());
//		
		
	}

	@Transactional
	@Override
	public Users findByUserName(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Users> theQuery = currentSession.createQuery("from Users where username=:uName", Users.class);
		theQuery.setParameter("uName",username);
		Users theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
		
		
		
		
		
	
	}
	@Transactional
	@Override
	public Users findByEmail(String email) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Users> query = currentSession.createQuery("from Users where email=:uemail", Users.class);
		query.setParameter("uemail",email);
		Users u2 = null;
		try {
			u2 = query.getSingleResult();
		} catch (Exception e) {
			u2 = null;
		}

		return u2;
	}
	
	@Transactional
	@Override
	public Users findUserbyid(int user_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Users> query = currentSession.createQuery("from Users where user_id=:uid", Users.class);
		query.setParameter("uid",user_id);
		Users u2 = null;
		try {
			u2 = query.getSingleResult();
		} catch (Exception e) {
			u2 = null;
		}

		return u2;
	}

}
