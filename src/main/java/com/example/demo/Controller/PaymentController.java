package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Payment;
import com.example.demo.Services.Paymentservice;

@RestController
@RequestMapping("/api/auth")
public class PaymentController {
	
	@Autowired
	private Paymentservice paymentservice;
	
	@PreAuthorize("hasRole('ROLE_READER')")
	@PostMapping("/buybook")
	public String payfornewwbook(@RequestBody Payment payment)
	{
		paymentservice.savepayment(payment);
		return "Payment succesfull";
	}
	@PreAuthorize("hasRole('ROLE_READER')")
	@GetMapping("/bymail/{email}")
	public List<Payment> byemail(@PathVariable String mail)
	{
		return paymentservice.bymail(mail);
	}
	

	
	

}
