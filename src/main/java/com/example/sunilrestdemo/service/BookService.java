package com.example.sunilrestdemo.service;

import com.example.sunilrestdemo.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getBooks();
    public Book saveBook(Book book);
    public Optional<Book> getBook(Long id);
    public Boolean deleteBook(Long id);
    public Book updateBook(Long id,Book book);
}
