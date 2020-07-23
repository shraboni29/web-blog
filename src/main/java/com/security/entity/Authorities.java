package com.security.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;



@Entity
@Table(name="authorities")
public class Authorities implements GrantedAuthority{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="auth_id")
	
	int auth_id;
	@Column(name="username")
	String username;
	
	@Column(name="authority")
	String authority;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	Users user;
	public Authorities()
	{
		
	}
	
	public Authorities(String username, String authority, Users user) {
		super();
		this.username = username;
		this.authority = authority;
		this.user = user;
	}
	public int getAuth_id() {
		return auth_id;
	}
	public void setAuth_id(int auth_id) {
		this.auth_id = auth_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Authorities [auth_id=" + auth_id + ", username=" + username + ", authority=" + authority + ", user="
				+ user + "]";
	}
	
	
	
	

}
