package com.example.sunilrestdemo.dao;

import com.example.sunilrestdemo.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookDao  extends MongoRepository<Book,String> {
}
