package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Author;
import com.example.demo.Repository.IAuthRepo;

@RestController
public class AuthController {
	@Autowired
	  private IAuthRepo repo;

	  @PostMapping("savedata")
	  public void savedata(@RequestBody Author author)
	  {
		  System.out.println(author);
		  repo.save(author);
	  }
	  
	
	  @PostMapping("savemultidata")
	  public void savemultidata(@RequestBody List<Author> author)
	  {
		  repo.saveAll(author);
	  }
	  
	  
		

}
