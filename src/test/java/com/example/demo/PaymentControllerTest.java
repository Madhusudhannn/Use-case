package com.example.demo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
		payment.setPaymentId(1l);
		payment.setBookID(1L);
		payment.setReaderId(3L);
		payment.setEmail("email");
		payment.setPaymentDate("2022-10-12");
		payment.setPrice(150);
	//	when(paymentservice.savepayment(payment)).thenReturn(payment);
		String pay=paymentcontroller.payfornewwbook(payment);
		assertThat(pay.equals("New book"));
		
		
	} 
	
	

}
