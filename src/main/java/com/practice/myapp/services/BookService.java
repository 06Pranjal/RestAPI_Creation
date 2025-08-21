package com.practice.myapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.myapp.Entities.Book;
import com.practice.myapp.dao.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list=new ArrayList<>();

    // static{
    //     list.add(new Book(12,"Spring Reference","Prakash"));
    //     list.add(new Book(14,"DSA","Aakash"));
    //     list.add(new Book(15,"OOPS","Vikas"));
    // }

    //get all books
    public List<Book> getAllBooks(){
        List<Book> list=(List<Book>) this.bookRepository.findAll();
    
        return list;
    }

    //get single book
    public Book getBookById(int id) {
    return bookRepository.findById(id).orElse(null);
}


    //adding the book
    public Book addBook(Book b){
        Book result=this.bookRepository.save(b);
        return result;
    }

    //delete book
    public void deleteBook(int bid){
        //list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    //update book
    public void updateBook(Book book,int bookId){
        // list.stream().map(b->{
        //     if(b.getId()==bookId)
        //     {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());
        book.setId(bookId);
        bookRepository.save(book);
    }
}
