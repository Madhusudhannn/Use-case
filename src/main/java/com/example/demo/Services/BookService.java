package com.example.demo.Services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.Payment;
import com.example.demo.Entity.User;
import com.example.demo.Repository.IBookrepo;
import com.example.demo.Repository.Ipaymentrepo;
import com.example.demo.Repository.UserRepository;

@Service
public class BookService { 
  
	@Autowired
	private IBookrepo bookrepo;
	@Autowired
	private Ipaymentrepo paymentrepo;
	@Autowired
	private UserRepository userrepo;
	
	public Book savebook(Book book)
	{
		bookrepo.save(book);
		return book;
	}

	public Book updateBookService(Book book) {
		return bookrepo.save(book);
	
		
	}

	public List<Book> getbycategory(String category) {
		List<Book> book=bookrepo.findByCatagory(category);
		
		return book;
	}
	public List<Book> price(Double price)
	{
		List<Book> book=bookrepo.findByPrice(price);
		return book;
	}
	public List<Book> allbooks()
	{
		List<Book> book=bookrepo.findAll();
		return book;
	}
	public List<Book> byauthor(String author)
	{
		List<Book> book=bookrepo.findByAuthor(author);
		return book;
	}
	public List<Book> findByCatagoryAndAuthorAndPriceAndPublisher(String catagory, String author, Double price,
            String publisher) {
        return bookrepo.findByCatagoryAndAuthorAndPriceAndPublisher( catagory,  author,  price,
                 publisher);
    }

	public Optional<Book> byid(Long bookid) {
		
		return bookrepo.findById(bookid);
	}

	public Book readBook(Long bookid) {
        return bookrepo.findById(bookid).get();
    }
    
       public Optional<User> getByEmail1(String email) {
           return userrepo.findByEmail(email);
       }
       public Boolean isPaymentAvailableByReaderId1(Long readerid) {
           Boolean paymentAvaible = paymentrepo.existsByReaderId(readerid);
           return paymentAvaible;
}
       
        public Map<String, Set<Long>> getBookId1(Long readerid) {
           List<Payment> paymentList = paymentrepo.findAllByreaderId(readerid);
           Set<Long> bookIdList = new HashSet<Long>();
           Map<String, Set<Long>> map = new HashMap<String, Set<Long>>();
           paymentList.forEach(payment -> {
               bookIdList.add(payment.getBookID());
           });
           map.put("bookId", bookIdList);
           return map;
       }
       
       public Map<String, String> readContent(String email, Long bookId) {
           Boolean isuser = isUserAvailableByEmail1(email);
           Map<String, String> map = new HashMap<String, String>();
           if (isuser) {
               Book book = readBook(bookId);
               System.out.println("book is generated::" + book.getAuthor());
               map.put("catagory", book.getCatagory());
               map.put("content", book.getContent());
               map.put("Author", book.getAuthor());
           }
           return map;
       }
       public Boolean isUserAvailableByEmail1(String email) {
           return userrepo.existsByEmail(email);




       
     }

public Book readBook1(Long bookid) {
        return bookrepo.findById(bookid).get();
    }

       public Optional<User> getByEmail(String email) {
           return userrepo.findByEmail(email);
       }
       public Boolean isPaymentAvailableByReaderId(Long readerid) {
           Boolean paymentAvaible = paymentrepo.existsByReaderId(readerid);
           return paymentAvaible;
}

        public Map<String, Set<Long>> getBookId(Long readerid) {
           List<Payment> paymentList = paymentrepo.findAllByreaderId(readerid);
           Set<Long> bookIdList = new HashSet<Long>();
           Map<String, Set<Long>> map = new HashMap<String, Set<Long>>();
           paymentList.forEach(payment -> {
               bookIdList.add(payment.getBookID());
           });
           map.put("bookId", bookIdList);
           return map;
       }

       public Map<String, String> readContent1(String email, Long bookId) {
           Boolean isuser = isUserAvailableByEmail1(email);
           Map<String, String> map = new HashMap<String, String>();
           if (isuser) {
               Book book = readBook(bookId);
               System.out.println("book is generated::" + book.getAuthor());
               map.put("catagory", book.getCatagory());
               map.put("content", book.getContent());
               map.put("Author", book.getAuthor());
           }
           return map;
       }
       public Boolean isUserAvailableByEmail(String email) {
           return userrepo.existsByEmail(email);

      }
       
       
       public Map<String, String> findBookByPaymentId(String email, Long paymentId) {
           Boolean isuser = isUserAvailableByEmail(email);
           Map<String, String> payload = new HashMap<String, String>();
           if (isuser) {
               Payment payment = getPaymentById(paymentId);
               Long bookId = payment.getBookID();
               Book book = readBook1(bookId);
               payload.put("author", book.getAuthor());
               payload.put("catagory", book.getCatagory());
               payload.put("publishedDate", book.getReleaseDate());
               payload.put("publisher", book.getPublisher());
               payload.put("title", book.getTitle());
               payload.put("price", book.getPrice().toString());
           }
           return payload;
       }
       public Payment getPaymentById(Long paymentId)
       {
    	   Payment payment=paymentrepo.findByPaymentId(paymentId);
    	   return payment;
       }
      
       
       
}
