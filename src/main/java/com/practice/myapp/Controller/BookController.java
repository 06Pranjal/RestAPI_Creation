package com.practice.myapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.myapp.Entities.Book;
import com.practice.myapp.services.BookService;


@RestController
public class BookController {
    
    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public List getBooks(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id")int id){
        return bookService.getBookById(id);

    }
}
