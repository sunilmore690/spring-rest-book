package com.example.sunilrestdemo.controller;

import com.example.sunilrestdemo.entity.Book;
import com.example.sunilrestdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public List<Book> getBooks(){
       return this.bookService.getBooks();
    }
    @GetMapping("/{bookId}")
    public Optional<Book> getBook(@PathVariable String bookId){
        return this.bookService.getBook(Long.parseLong(bookId));
    }
    @DeleteMapping("/{bookId}")
    public Boolean deleteBook(@PathVariable  String bookId){
        return this.bookService.deleteBook(Long.parseLong(bookId));
    }
    @PostMapping("")
    public Book saveBook(@RequestBody  Book book){
        return this.bookService.saveBook(book);
    }
    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable String bookId,@RequestBody Book book){
        book.setId(Long.parseLong(bookId));
        return this.bookService.updateBook(Long.parseLong(bookId),book);
    }
}
