package com.example.sunilrestdemo.dao;

import com.example.sunilrestdemo.entity.Book;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookMongoDao  extends MongoRepository<Book,String> {
}
