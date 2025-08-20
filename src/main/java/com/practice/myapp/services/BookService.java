package com.practice.myapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        try{
            //stream line function
        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return book;
        
    }

    //adding the book
    public Book addBook(Book b){
        list.add(b);
        return b;
    }

    //delete book
    public void deleteBook(int bid){
        list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
    }

    //update book
    public void updateBook(Book book,int bookId){
        list.stream().map(b->{
            if(b.getId()==bookId)
            {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
