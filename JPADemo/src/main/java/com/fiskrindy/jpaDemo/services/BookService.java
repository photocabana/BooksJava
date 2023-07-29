package com.fiskrindy.jpaDemo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.fiskrindy.jpaDemo.Repositories.BookRepository;
import com.fiskrindy.jpaDemo.models.Book;

@Service
public class BookService {
	
//	Connection to our Repository - Where the Service speaks to our Repository
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
//    returns all the books - Our 1st Method - Uses the Repository method of "Find All"
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
//    creates a book object & will save it to our Database. A primary key will be assigned.
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    
//    Find Method - specific
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } 
        else {
            return null;
        }
	}
	  
//	  Finds something certain parameters
	  public List<Book> booksContaining(String search){
		  return bookRepository.findByDescriptionContaining(search);
	  }

//    updates a book object by the primary key & If not found, a new book will be created instead.
	  public Book updateBook(Book book) {
		  return bookRepository.save(book);
	  }
	  
//	  Delete
	public void deleteBook(Long id) {
			bookRepository.deleteById(id);
	}
	
//	public void deleteBook(Long id) {
//		Optional<Book> optionalBook = bookRepository.findById(id);
//		if(optionalBook.isPresent()) {
//			bookRepository.deleteById(id);
//		}
//		
//	}

}
