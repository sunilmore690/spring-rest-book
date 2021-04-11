package com.example.sunilrestdemo.service;
import com.example.sunilrestdemo.dao.BookMongoDao;
import com.example.sunilrestdemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("bookmongodbservice")
public class BookMongoServiceImpl implements BookService{

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    BookMongoDao bookMongoDao;

    @Override
    public List<Book> getBooks() {
        return bookMongoDao.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookMongoDao.save(book);
    }

    @Override
    public Book getBook(String id) {
        return bookMongoDao.findById(id).orElse(new Book());
    }

    @Override
    public Boolean deleteBook(String id) {
        bookMongoDao.deleteById(id);
        return true;
    }

    @Override
    public Book updateBook(String id, Book book) {
        return bookMongoDao.save(book);
    }
}
