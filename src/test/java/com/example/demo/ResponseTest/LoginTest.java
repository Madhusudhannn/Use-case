package com.example.demo.ResponseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.request.LoginRequest;

@SpringBootTest
public class LoginTest { 
	
	LoginRequest login = new LoginRequest();

	@Test
	public void userNameTest() {
		login.setUsername("madhu");
		String name = login.getUsername(); 
		assertEquals("madhu", name);
	}

	@Test
	public void passwordTest() {
		login.setPassword("password");
		String pass = login.getPassword();
		assertEquals("password", pass);

	}
 
}
