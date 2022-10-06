package com.example.demo.ResponseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Book;
import com.example.demo.Response.BookResponse;

@SpringBootTest
public class bookresponseTest {
	BookResponse book = new BookResponse();

	@Test
	public void bookIdTest() {
		book.setBookID(1L); 
		Long id = book.getBookID();
		assertEquals(1L, id); 
 
	}

	@Test
	public void authorTest() {
		book.setAuthor("madhu");
		String author = book.getAuthor();
		assertEquals("madhu", author);

	}

	@Test
	public void titleTest() {
		book.setTitle("Earth is Awesome");
		String title = book.getTitle();
		assertEquals("Earth is Awesome", title);

	}

	@Test
	public void catagoryTest() {
		book.setCategory("General");
		String catagory = book.getCategory();
		assertEquals("General", catagory);

	}

	@Test
	public void priceTest() {
		book.setPrice(125L);
		Long price = book.getPrice();
		assertEquals(125L, price);

	}

	@Test
	public void publisherTest() {
		book.setPublisher("madhu");
		String publisher = book.getPublisher();
		assertEquals("madhu", publisher);

	}

	@Test
	public void activeTest() {
		book.setActive(true);
		Boolean active = book.isActive();
		assertEquals(true, active);

	}

	@Test
	public void contentTest() {
		book.setContent("Awesome");
		String content = book.getContent();
		assertEquals("Awesome", content);

	}

	@Test
	public void publisherTest1() {
		book.setPublisher("sea");
		String publisher = book.getPublisher();
		assertEquals("sea", publisher);

	}

	@Test
	public void releasedatetest() {
		book.setReleaseDate("2000-09-10");
		String releasedate = book.getReleaseDate();
		assertEquals("2000-09-10", releasedate);
	}

	@Test
	public void contenttest() {
		book.setContent("mas");
		String content = book.getContent();
		assertEquals("mas", content);
	}

} 
