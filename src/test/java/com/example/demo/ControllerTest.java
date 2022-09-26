package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
	public void testsavebook()
	{
		Book book=new Book();
		book.setAuthor("madhu");
		book.setCatagory("catagory");  
		book.setContent("content");
		book.setPublisher("publisher"); 
		book.setTitle("title");
		book.setReleaseDate("1910-11-10");
		Mockito.when(bookservice.savebook(book)).thenReturn(book);
		String savebook=bookcontroller.newbook(book);
		assertThat(savebook.equals("Book is created succefully"));
	} 
    @Test
    public void getallbookstest()
    {
    	List<Book> book=new ArrayList<>();
    	when(bookservice.allbooks()).thenReturn(book);
    	List<Book> result=bookcontroller.allbooks();
    	assertThat(result).isNotNull();
    	assertEquals(0, book.size());
    } 
	@Test
	public void searchbytest() 
	{ 
		Book book=new Book();
		book.setAuthor("author");
		when(bookcontroller.searchbooksbyauthor("author")).thenReturn(null);
		assertThat(bookservice.byauthor("author"));
		 
	}
	@Test
	public void searchbybooidtest()
	{
		Book book=new Book();
		book.setBookID(1L);
		when(bookcontroller.readbookbyid(1L)).thenReturn(null);
		assertThat(bookservice.byid(1L));
	} 
	@Test
	public void searchbycatpriceauthpublic() throws JsonProcessingException
	{
		Book book=new Book();
		book.setAuthor("author");
		book.setCatagory("catagory");
		book.setPrice(150.00);
		book.setPublisher("publisher");
		when(bookcontroller.SearchBooks("catagory", "author", 150.00, "publisher")).thenReturn(null);
		assertThat(bookservice.findByCatagoryAndAuthorAndPriceAndPublisher("catagory", "author", 150.00, "publisher"));
	}
	@Test
	public void searchbycategorytest()
	{
		Book book=new Book();
		book.setCatagory("category");
		when(bookcontroller.searchbooks("catagory")).thenReturn(null);
		assertThat(bookservice.getbycategory("catagory"));
	}
	@Test
	public void updatetest()
	{
		Book book=new Book();
		book.setBookID(2L);
		when(bookcontroller.updatebook(book, 2L)).thenReturn(book);
		assertThat(bookservice.updateBookService(book));
		 
	} 
  
	
} 
