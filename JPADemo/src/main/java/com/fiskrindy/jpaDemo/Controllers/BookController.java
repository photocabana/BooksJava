package com.fiskrindy.jpaDemo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fiskrindy.jpaDemo.models.Book;
import com.fiskrindy.jpaDemo.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/index.jsp";
	}

}
