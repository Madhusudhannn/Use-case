package com.example.demo.ResponseTest;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Response.ErrorResponse;

@SpringBootTest
public class ErrorresponseTest { 
	
	ErrorResponse error=new ErrorResponse();
	
	@Test
	public void codetest() 
	{
		error.setErrocode("general");
		String code=error.getErrocode();
		assertEquals("general", code);
	}
	@Test
	public void descriptiontest()
	{
		error.setDescription("description");
		String code=error.getDescription();
		assertEquals("description", code);
	}
//	@Test
//	public void  Exceptiontest()
//	{
//		Exception exe=new Exception();
//		error.setException(exe); 
//		String code=error.getDescription();
//		assertEquals(code, exe);
//	}
//	
	

}
