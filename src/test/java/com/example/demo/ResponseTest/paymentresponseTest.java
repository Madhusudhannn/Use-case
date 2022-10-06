package com.example.demo.ResponseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Response.PaymentResponse;

@SpringBootTest
public class paymentresponseTest {
	PaymentResponse payment = new PaymentResponse();

	@Test
	public void paymentIdtest() {
		payment.setPaymentId(1L);
		Long id = payment.getPaymentId();
		assertEquals(1L, id);
	}

	

	@Test
	public void bookidtest() {
		payment.setBookID(3L);
		Long id = payment.getBookID();
		assertEquals(3L, id);
	}



	@Test
	public void paymentdatetest() {
		payment.setPaymentDate("2022-09-19");
		String paymentdate = payment.getPaymentDate();
		assertEquals("2022-09-19", paymentdate);
	}

}
