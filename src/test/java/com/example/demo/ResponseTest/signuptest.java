package com.example.demo.ResponseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.request.SignupRequest;

@SpringBootTest
public class signuptest {

	SignupRequest signup=new SignupRequest();
	
	@Test
	public void usertest()
	{
		signup.setUsername("madhu");
		String name =signup.getUsername();
		assertEquals("madhu", name);

	}
	@Test
	public void password()
	{
		signup.setPassword("password");
		String password =signup.getPassword();
		assertEquals("password", password);

	}
	@Test
	public void email()
	{
		signup.setEmail("email");
		String email =signup.getEmail();
		assertEquals("email", email);

	}
}
