package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Book;


public interface IBookrepo extends JpaRepository<Book, Long> {

	 public List<Book>  findByCategory(String category);
	 	 
	


}
