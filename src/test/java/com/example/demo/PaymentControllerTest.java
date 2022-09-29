package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Controller.PaymentController;
import com.example.demo.Entity.Payment;
import com.example.demo.Services.Paymentservice;

@SpringBootTest
public class PaymentControllerTest {
	
	@Mock
	Paymentservice paymentservice;
	@InjectMocks
	PaymentController paymentcontroller;
	
	@Test
	public void newbooktest()
	{
		Payment payment=new Payment();
		payment.setPaymentId(13L);
		
	}

}
