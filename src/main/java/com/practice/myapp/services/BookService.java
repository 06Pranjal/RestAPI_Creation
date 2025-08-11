package com.practice.myapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.practice.myapp.Entities.Book;

@Component
public class BookService {
    private static List<Book> list=new ArrayList<>();

    static{
        list.add(new Book(12,"Spring Reference","Prakash"));
        list.add(new Book(14,"DSA","Aakash"));
        list.add(new Book(15,"OOPS","Vikas"));
    }

    //get all books
    public List<Book> getAllBooks(){
        return list;
    }

    //get single book
    public Book getBookById(int id){
        Book book=null;
        //stream line function
        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

    //adding the book
    public Book addBook(Book b){
        list.add(b);
        return b;
    }
}
