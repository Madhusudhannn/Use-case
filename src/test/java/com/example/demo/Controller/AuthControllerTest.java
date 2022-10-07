package com.example.demo.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.jwt.JwtUtils;

class AuthControllerTest {
	@Mock
	UserRepository userRepository;

	@Mock
	RoleRepository roleRepository;

	@Mock
	PasswordEncoder encoder;

	@Mock 
	JwtUtils jwtUtils;

	@Test
	void testAuthenticateUser() {
		
	
	}

	@Test
	void testRegisterUser() {
		
	}

}
