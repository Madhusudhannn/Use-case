package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.ControllerAdvice.GeneralExceptionHandler;
import com.example.demo.Response.ErrorResponse;

@SpringBootTest
public class TestGeneralExceptionHandler {

	@InjectMocks
	GeneralExceptionHandler generalexception;
	
	@Test
	public void exceptionTest()
	{
		Exception exe=new Exception();
		ErrorResponse  erroor= generalexception.handleException(exe);
		ErrorResponse r=new ErrorResponse();
		r.setErrocode("General"); 
		r.setDescription(exe.getMessage());
		r.setException(exe);
		assertNotNull(erroor);
		 
		
		
	}
}
