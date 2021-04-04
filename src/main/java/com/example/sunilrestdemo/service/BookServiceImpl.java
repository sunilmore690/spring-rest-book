package com.example.sunilrestdemo.service;

import com.example.sunilrestdemo.dao.BookDao;
import com.example.sunilrestdemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;
    @Override
    public List<Book> getBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return bookDao.findById(id);
    }

    @Override
    public Boolean deleteBook(Long id) {
        bookDao.deleteById(id);
        return true;
    }

    @Override
    public Book updateBook(Long id, Book book) {
        return bookDao.save(book);
    }

//    List<Book> books;
//    private Long getNextId(){
//        return new Long(books.size() + 1);
//
//    }
//    public BookServiceImpl(){
//        books = new ArrayList<>();
//        books.add(new Book(getNextId(),"Spring Boot","James","Technology"));
//        books.add(new Book(getNextId(),"Head First with Java","James","Technology"));
//        books.add(new Book(getNextId(),"Deep dive into Nodejs","James","Technology"));
//    }
//    @Override
//    public List<Book> getBooks() {
//        return books;
//    }
//
//    @Override
//    public Book saveBook(Book book) {
//        book.setId(getNextId());
//        books.add(book);
//        return book;
//    }
//
//    @Override
//    public Book getBook(Long id) {
//         ListIterator<Book> itr =  books.listIterator();
//         Boolean findBook = true;
//         while(findBook && itr.hasNext()){
//             Book book = itr.next();
//             if(book.getId().equals(id)){
//                 findBook = false;
//                 return book;
//             }
//         }
//         return null;
//    }
//
//    @Override
//    public Boolean deleteBook(Long id) {
//        ListIterator<Book> itr =  books.listIterator();
//        Boolean findBook = true;
//        while(findBook && itr.hasNext()){
//            Book book = itr.next();
//            if(book.getId().equals(id)){
//                findBook = false;
//                return books.remove(book);
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public Book updateBook(Long id,Book tempbook) {
//        ListIterator<Book> itr =  books.listIterator();
//        Boolean findBook = true;
//        while(findBook && itr.hasNext()){
//            Book book = itr.next();
//            if(book.getId().equals(id)){
//                book.setAuthor(tempbook.getAuthor());
//                book.setName(tempbook.getName());
//                book.setCategory(tempbook.getCategory());
//                findBook = false;
//                return book;
//            }
//        }
//        return null;
//    }
}
