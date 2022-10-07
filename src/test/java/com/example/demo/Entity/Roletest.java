package com.example.demo.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Roletest {
	
	Role role=new Role();
	
	@Test
	public void id()
	{
		role.setId(1);
		Integer id = role.getId();
		assertEquals(1, id);
	}
//	@Test
//	public void name()
//	{
//		role.setName(role);
//		ERole name = role.getName();
//		assertEquals(1, name);
//	}

}
