package com.example.demo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Controller.BooksController;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.User;
import com.example.demo.Services.BookService;

@SpringBootTest
public class ControllerTest {
	
	@Mock
	BookService bookservice;
	
	@InjectMocks
	BooksController bookscontroller;
	
	@Test
	void signupuser()
	{
		User user =new User();
		user.setEmail("madhu@123");
	}

}
