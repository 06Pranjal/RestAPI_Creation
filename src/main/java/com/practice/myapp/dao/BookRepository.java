package com.practice.myapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.practice.myapp.Entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{
   public Book findById(int id); 
}
