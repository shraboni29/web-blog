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

@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	int user_id;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;
	
	@Column(name="username")
	String username;
	
	@Column(name="password")
	String password;
	
	@Column(name="role")
	String role;
	
	@Column(name="enabled")
	int enable;
	@Column(name="email")
	String email;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private Authorities authorities;

	public Users(String firstName, String lastName, String username, String password, String role, int enable, String email) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.role = role;
		this.enable = enable;
		this.email=email;
	}

	public Users() {
		// TODO Auto-generated constructor stub
	}
	


	public Users(Users u2) {
		this.firstName = u2.getFirstName();
		this.lastName = u2.getLastName();
		this.username = u2.getUsername();
		this.password = u2.getPassword();
		this.role = u2.getRole();
		this.enable = u2.getEnable();
		this.email=u2.getEmail();
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int i) {
		this.enable = i;
	}

	/**
	 * @return the authorities
	 */
	public Authorities getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", role=" + role + ", enable=" + enable + ", email=" + email
				+ ", authorities=" + authorities + "]";
	}

	
	

}
