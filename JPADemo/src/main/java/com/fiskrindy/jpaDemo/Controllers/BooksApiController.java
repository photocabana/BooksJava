package com.fiskrindy.jpaDemo.Controllers;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiskrindy.jpaDemo.models.Book;
import com.fiskrindy.jpaDemo.services.BookService;

@RestController
public class BooksApiController {
	
//	Connects to our Service
	private final BookService bookService;
    public BooksApiController(BookService bookService){
        this.bookService = bookService;
    }
    
//    Going to get all the books that are in our database
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
//    Creating books - with certain criteria - creates a book object which is then saved to our database.
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
    	
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
//    Show an individual book - pass in a primary key or id to find a specific book
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }

//    Update
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String description, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
    	
        Book book = new Book(title, description, lang, numOfPages);
        book.setId(id);
        		
        book = bookService.updateBook(book);
        return book;
    }
    
//    Delete
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
