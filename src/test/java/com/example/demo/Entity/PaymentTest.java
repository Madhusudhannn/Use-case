package com.example.demo.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentTest {

	Payment payment = new Payment();

	@Test
	public void paymentIdtest() {
		payment.setPaymentId(1L);
		Long id = payment.getPaymentId();
		assertEquals(1L, id);
	}

	@Test
	public void readerIdtest() {
		payment.setReaderId(1L);
		Long id = payment.getReaderId();
		assertEquals(1L, id);
	}

	@Test
	public void bookidtest() {
		payment.setBookID(3L);
		Long id = payment.getBookID();
		assertEquals(3L, id);
	}

	@Test
	public void pricetest() {
		payment.setPrice(150);
		Integer price = payment.getPrice();
		assertEquals(150, price);
	}

	@Test
	public void emailtest() {
		payment.setEmail("madhu@gmail.com");
		String email = payment.getEmail();
		assertEquals("madhu@gmail.com", email);
	}

	@Test
	public void paymentdatetest() {
		payment.setPaymentDate("2022-09-19");
		String paymentdate = payment.getPaymentDate();
		assertEquals("2022-09-19", paymentdate);
	}
	
}
