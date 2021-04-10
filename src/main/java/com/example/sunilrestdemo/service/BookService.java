package com.example.sunilrestdemo.service;

import com.example.sunilrestdemo.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getBooks();
    public Book saveBook(Book book);
    public Book getBook(String id);
    public Boolean deleteBook(String id);
    public Book updateBook(String id,Book book);
}
