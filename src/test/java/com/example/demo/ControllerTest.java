package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.example.demo.Controller.BooksController;
import com.example.demo.Entity.Book;
import com.example.demo.Repository.IBookrepo;
import com.example.demo.Services.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootTest
public class ControllerTest {  
	  
	
	
	@Mock
	private BookService bookservice;
	@Autowired
	private IBookrepo bookrepo;

	@InjectMocks
	private BooksController bookcontroller;

	@Test
	public void testsavebook() { 
		Book book = new Book();
		book.setAuthor("madhu");
		book.setCatagory("catagory");
		book.setContent("content");
		book.setPublisher("publisher");
		book.setTitle("title"); 
		book.setReleaseDate("1910-11-10");
		Mockito.when(bookservice.savebook(book)).thenReturn(book);
		String savebook = bookcontroller.newbook(book);
		assertThat(savebook.equals("Book is created succefully"));
	}

	@Test
	public void getallbookstest() {
		List<Book> book = new ArrayList<>();
		when(bookservice.allbooks()).thenReturn(book);
		List<Book> result = bookcontroller.allbooks();
		assertThat(result).isNotNull();
		assertEquals(0, book.size()); 
	}

	@Test
	public void searchbyauthortest() {
		List<Book> book = new ArrayList<>();
		when(bookservice.byauthor("author")).thenReturn(book);
		List<Book> result = bookcontroller.searchbooksbyauthor("");
		assertThat(result.equals(book));
	}

	@Test
	public void searchbybooidtest() {
		Book book = new Book();
		book.setBookID(1L);
		when(bookcontroller.readbookbyid(1L)).thenReturn(null);
		assertThat(bookservice.byid(1L));
	}

	@Test
	public void searchbycatpriceauthpublic() throws JsonProcessingException {
		Book book = new Book();
		book.setAuthor("author");
		book.setCatagory("catagory");
		book.setPrice(150.00);
		book.setPublisher("publisher");
		when(bookcontroller.SearchBooks("catagory", "author", 150.00, "publisher")).thenReturn(null);
		assertThat(bookservice.findByCatagoryAndAuthorAndPriceAndPublisher("catagory", "author", 150.00, "publisher"));
	}
 
	@Test
	public void searchbycategorytest() {
		Book book = new Book();
		book.setCatagory("category");
		when(bookcontroller.searchbooks("catagory")).thenReturn(null);
		assertThat(bookservice.getbycategory("catagory"));
	}

	@Test
	public void updatetest() {
		Book book = new Book();
		book.setBookID(2L);
		when(bookcontroller.updatebook(book, 2L)).thenReturn(book);
		assertThat(bookservice.updateBookService(book));
 
	}

	@Test
	public void readBookByEmailandBookidTest() throws JsonProcessingException {
		Map<String, String> map = new HashMap<String, String>();
		Book book = new Book();
		map.put("book is generated::", String.valueOf(book.getBookID()));
		when(bookservice.readContent("madhu@gmail.com", 1L)).thenReturn(map);
		ResponseEntity entity = bookcontroller.readBooks("madhu@gmail.com", String.valueOf(1));
		assertThat(entity.equals(map));

	}
 
	@Test
	public void readBookByEmailandPaymentidTest() throws JsonProcessingException {
		Map<String, String> map = new HashMap<String, String>();
		Book book = new Book();
		when(bookservice.findBookByPaymentId("madhu@gmail.com", 1L)).thenReturn(map);
		ResponseEntity entity = bookcontroller.getBookByPaymentid("madhu@gmail.com", String.valueOf(1L));
		assertThat(entity.equals(map));
 
	}
 
	@Test
	public void byprice() {
		Book book = new Book();
		book.setPrice(179.00);
		when(bookcontroller.searchbooksby(170.0)).thenReturn(null);
		assertThat(bookservice.price(179.00));

	}

}
