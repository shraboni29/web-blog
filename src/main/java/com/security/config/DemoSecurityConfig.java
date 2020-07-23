package com.security.config;

import javax.sql.DataSource;
//
////import javax.activation.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.security.service.UserService;

@Configuration
@EnableWebSecurity

public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//inject data source
	@Autowired
	private DataSource securityDataSource;
	@Autowired
	private UserService userService;
	
	
	/*
// data define from this
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//add user for memory authentication
		UserBuilder users=User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("sra").password("1234").roles("employee","admin"))
		.withUser(users.username("runu").password("1234").roles("employee"))
		.withUser(users.username("munu").password("1234").roles("employee","manager"));		
	
		
		
		
	}
	*/
	//data retrived from db
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.print("<<<<< Test 01 cnfig... >>>>>>");
		//use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
	
		http.authorizeRequests()
		.antMatchers("/","/home").permitAll()
		
		.antMatchers("/addUser","/saveUser").permitAll()
		.antMatchers("/resources/**").permitAll()
		
	//	.antMatchers("/createBlog").hasAnyRole("BLOGGER","VIEWER")
		//.antMatchers("/index").hasRole("")
		//.antMatchers("/createBlog").permitAll()
//		.antMatchers("/leaders/**").hasRole("BLOGGER")
		
		.antMatchers("/createBlog","/saveBlog","/image/*","/upload").hasRole("BLOGGER")
		.anyRequest() //without any restriction
		.authenticated()
		.and()
		.formLogin().loginPage("/showLogin")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		 
		.and()
		.logout()
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
		
		
		
		
	}
	
	 @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
	  }
	  //authenticationProvider bean definition
	 
	 @Bean
		public DaoAuthenticationProvider authenticationProvider() {
			DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
			auth.setUserDetailsService(userService); //set the custom user details service
			auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
			return auth;
		}
}
