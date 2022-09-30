package com.example.demo.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

	User author = new User();

	@Test
	public void iDtest() {
		author.setId(1L);
		Long id = author.getId();
		assertEquals(1L, id);

	}

	@Test
	public void userNameTest() {
		author.setUsername("madhu");
		String name = author.getUsername();
		assertEquals("madhu", name);

	}

	@Test
	public void emailTest() {
		author.setEmail("madhu@gmail.com");
		String email = author.getEmail();
		assertEquals("madhu@gmail.com", email);

	}

	@Test
	public void passwordTest() {
		author.setPassword("password");
		String pass = author.getPassword();
		assertEquals("password", pass);

	}
}
