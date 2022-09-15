package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.IBookrepo;

@Service
public class BookService {

	@Autowired
	private IBookrepo bookrepo;
	
	public Book savebook(Book book)
	{
		bookrepo.save(book);
		return book;
	}

	public Book updateBookService(Book book) {
		return bookrepo.save(book);
	
		
	}

	public List<Book> getbycategory(String category) {
		List<Book> book=bookrepo.findByCategory(category);
		
		return book;
	}

	

	

}
