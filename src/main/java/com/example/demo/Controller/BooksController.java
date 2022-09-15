package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.IBookrepo;
import com.example.demo.Services.BookService;
import com.example.demo.Services.Paymentservice;

@RestController
@RequestMapping("/api/book")
public class BooksController {
	
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private IBookrepo repo;
	
	@PostMapping("/createbook")
	public String  newbook(@RequestBody Book book)
	{
		bookservice.savebook(book);
		return "Book is created succsefully";
		
	}
	@PutMapping("/updatebook/{bookid}")
	public Book updatebook(@RequestBody Book book, @PathVariable("bookid") Long bookid)
	{
		book.setBookID(bookid);
		bookservice.updateBookService(book);
		return book;
		
	}
//	@GetMapping("/searchbook/{byauthor}")
//	public  Book getbyauthor(@RequestBody Book book,@PathVariable("byauthor") String author)
//	{
//		book.setAuthor(author);
//		
//		Book bk=new Book();
//		bk.getBookID();
//		bk.getAuthor();
//        bk.getTitle();
//        bk.getPublisher();
//        bk.getReleaseDate();
//        bk.getCategory();
//        bk.getPrice();
//        bk.getContent();
//        
//		
//        repo.findByAuthor(author);
//		return bk;
//	}
	@GetMapping("/searchbook/{category}")
	public List<Book> searchbooks(@PathVariable String category)
	{
		
		return bookservice.getbycategory(category);
		
	}
	
	
	
	
	

}
