package com.example.demo.servicetest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.Payment;
import com.example.demo.Repository.Ipaymentrepo;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Services.BookService;
import com.example.demo.Services.Paymentservice;
import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootTest
public class paymentserviceTest {
	
	Payment payment=new Payment();

	@Mock
	Ipaymentrepo paymentrepo;
	
	@InjectMocks 
	Paymentservice paymentsrvice;
	
	@Mock
	UserRepository userrepo;
	@Mock
	BookService bookservice;
	
	@Test
	public void saveTest()
	{ 
		payment.setBookID(1L);
		payment.setEmail("email");
		payment.setPaymentDate("2022-08-10");
		payment.setPrice(180);
		when(paymentrepo.save(payment)).thenReturn(payment);
		 
        		
	} 
	@Test
	public void getPaymentById() {
		
		payment.setPaymentId(1L);
		Long paymentid=payment.getPaymentId();
		when(paymentrepo.findByPaymentId(1L)).thenReturn(payment);
		Payment payser=paymentsrvice.bypaymentId(paymentid);
		assertEquals(payser,payment);
		
	}
	@Test
	public void savePaymentTest() {
		payment.setBookID(1L);
		Long bookid=payment.getBookID();
		payment.setEmail("madhu@gmail.com");
		String email=payment.getEmail();
		payment.setPaymentId(1L);
		Long paymentid=payment.getPaymentId();
		payment.setPrice(124); 
		int price=payment.getPrice();
		payment.setReaderId(1L);
		Long readerId=payment.getReaderId();
		when(paymentrepo.save(payment)).thenReturn(payment);
		
		assertEquals("madhu@gmail.com", payment.getEmail());
		
	}
//	@Test
//	public void isBookAvailableTest() {
//		int bookid=1;
//		when(paymentrepo.existsById(1L)).thenReturn(true);
//		assertTrue(paymentsrvice.isBookAvailable(bookid));
//	}
	
	@Test
	public void isPaymentAvailableByReaderIdTest() {
		Long readerId=1L;
		when(paymentrepo.existsByReaderId(1L)).thenReturn(true);
		assertTrue(paymentsrvice.isPaymentAvailableByReader(readerId));
	}
	@Test
	public void isUserAvailableByEmailTest() {
		String str="madhu@gmail.com";
		when(userrepo.existsByEmail("madhu@gmail.com")).thenReturn(true);
		Boolean true1=bookservice.isUserAvailableByEmail(str);
		assertNotEquals(true1, "madhu@gmail.com");
	}
	
	
	@Test
	public void findBookByPaymentIdTest() {
		String email="madhu@gmail.com";
		 Boolean isuser = bookservice.isUserAvailableByEmail(email);
		 Map<String, String> payload = new HashMap<String, String>();
		 if (isuser) {
			 Long paymentid=11L;
             Payment payment = bookservice.getPaymentById(paymentid);
             Long bookId = payment.getBookID();
             Book book = bookservice.readBook(bookId);
             payload.put("author", book.getAuthor());
             payload.put("catagory", book.getCatagory());
             payload.put("publishedDate", book.getPublisher());
             payload.put("publisher", book.getPublisher());
             payload.put("title", book.getTitle());
             payload.put("price", book.getPrice().toString());
         }
		 Map<String, String> payload1=bookservice.findBookByPaymentId(email, 28L);
		 assertEquals(payload1,payload);

 
		
	}

	
	
	
	
	

}
