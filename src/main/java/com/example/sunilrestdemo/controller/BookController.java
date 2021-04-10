package com.example.sunilrestdemo.controller;

import com.example.sunilrestdemo.entity.Book;
import com.example.sunilrestdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    @Qualifier("bookrestservice")
    private BookService bookService;

    @GetMapping("")
    public List<Book> getBooks(){
       return this.bookService.getBooks();
    }
    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable String bookId){
        return this.bookService.getBook(bookId);
    }
    @DeleteMapping("/{bookId}")
    public Boolean deleteBook(@PathVariable  String bookId){
        return this.bookService.deleteBook(bookId);
    }
    @PostMapping("")
    public Book saveBook(@RequestBody  Book book){
        return this.bookService.saveBook(book);
    }
    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable String bookId,@RequestBody Book book){
        book.setId(bookId);
        return this.bookService.updateBook(bookId,book);
    }
}
