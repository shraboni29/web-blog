package com.security.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.annotation.PropertySource;
@PropertySource("classpath:database.properties")
public class TestDb {
    
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/demo_users?useSSL=false&serverTimezone=UTC";
		String user = "spring_security_demo";
		String pass = "spring_security_demo";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		

	}

}
