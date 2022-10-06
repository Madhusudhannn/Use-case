package com.example.demo.servicetest;


import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Payment;
import com.example.demo.Repository.Ipaymentrepo;
import com.example.demo.Services.Paymentservice;

@SpringBootTest
public class paymentserviceTest {
	
	Payment payment=new Payment();

	@Mock
	Ipaymentrepo paymentrepo;
	
	@InjectMocks 
	Paymentservice paymentsrvice;
	
	@Test
	public void saveTest()
	{ 
		payment.setBookID(1L);
		payment.setEmail("email");
		payment.setPaymentDate("2022-08-10");
		payment.setPrice(180);
		when(paymentrepo.save(payment)).thenReturn(payment);
		 
        		
	} 

}
