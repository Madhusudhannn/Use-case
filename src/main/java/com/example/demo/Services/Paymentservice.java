package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Payment;
import com.example.demo.Repository.Ipaymentrepo;

@Service
public class Paymentservice {
	
	@Autowired
	private Ipaymentrepo paymentrepo;
	
	public void savepayment(Payment pay)
	{
		paymentrepo.save(pay);
	}
	
	

}
