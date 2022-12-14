package com.example.demo.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.Payment;
import com.example.demo.Repository.IBookrepo;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Services.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootTest
public class bookserviceTest {

	Book book=new Book();

	@Mock
	IBookrepo bookrepo;
	
	@InjectMocks
	BookService bookservice;
	@Mock
	UserRepository  userrepo;
	
	@Test
	public void savetest()
	{
		book.setAuthor("author");
		book.setCatagory("catagory");
		book.setPrice(150.00);
		book.setContent("content");
		when(bookrepo.save(book)).thenReturn(book);
		Book savebook=bookservice.savebook(book);
		assertThat(savebook.equals("Book is created succefully"));
		 
	} 
	@Test
	public void searchbycatpriceauthpublic1() throws JsonProcessingException {
		Book book = new Book();
		book.setAuthor("author");
		book.setCatagory("catagory");
		book.setPrice(150.00); 
		book.setPublisher("publisher");
		when(bookrepo.findByCatagoryAndAuthorAndPriceAndPublisher("catagory", "author", 150.00, "publisher")).thenReturn(null);
		assertThat(bookservice.findByCatagoryAndAuthorAndPriceAndPublisher("catagory", "author", 150.00, "publisher"));
	}

	@Test
	public void updatetest() {
		book.setBookID(2L);
		when(bookservice.updateBookService(book)).thenReturn(book);
		assertThat(bookservice.updateBookService(book));
    } 
	@Test
	public void byprice() {
		book.setPrice(179.00);
		Double price=book.getPrice();
		List<Book> book=new ArrayList<>();
		when(bookrepo.findByPrice(price)).thenReturn(book);
		List<Book> book1=bookservice.price(179.00);
		assertEquals(book1, book);

	}
	@Test
	public void searchbycategorytest() {
		book.setCatagory("category");
		String catagory=book.getCatagory();
		List<Book> book=new ArrayList<>();
		when(bookrepo.findByCatagory(catagory)).thenReturn(book);
		List<Book> book1=bookservice.getbycategory(catagory);
		assertEquals(book1, book);

	} 
	@Test
	public void searchbybooidtest() {
		book.setBookID(1L);
		Long id=book.getBookID();
		Book book1=new Book();
        when(bookrepo.findById(id)).thenReturn(null);
        assertThat(bookservice.byid(id));

	}
	@Test
	public void searchbycatpriceauthpublic() throws JsonProcessingException {
		Book book = new Book();
		book.setAuthor("author");
		book.setCatagory("catagory");
		book.setPrice(150.00);
		book.setPublisher("publisher");
		when(bookrepo.findByCatagoryAndAuthorAndPriceAndPublisher("catagory", "author", 150.00, "publisher")).thenReturn(null);
		assertThat(bookservice.findByCatagoryAndAuthorAndPriceAndPublisher("catagory", "author", 150.00, "publisher"));
	} 

//	@Test
//	public void isUserAvailableTest() {
//		String str="madhu";
//		when(userrepo.existsByUsername("madhu")).thenReturn(true);
//		assertTrue(bookservice.isUserAvailable(str));
//	}
	
	@Test
	public void getallbookstest1() {
		List<Book> book = new ArrayList<>();
		when(bookservice.allbooks()).thenReturn(book);
		List<Book> result = bookrepo.findAll();
		assertThat(result).isNotNull();
		assertEquals(0, book.size()); 
	}
	@Test
	public void searchbyauthortest1() {
		List<Book> book = new ArrayList<>();
		when(bookservice.byauthor("author")).thenReturn(book);
		List<Book> result = bookrepo.findByAuthor("author");
		assertThat(result.equals(book));
	}
//	@Test
//	public void byid() 
//	{
//		List<Book> book=new ArrayList<>();
//		when(bookservice.readBook(1L)).thenReturn((Book) book);
//		Optional<Book> list=bookrepo.findById(1L);
//		assertThat(list.equals(book));
//	}
	 
} 
