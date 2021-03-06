package com.example.sunilrestdemo.controller;

import com.example.sunilrestdemo.constants.BeanConstant;
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
    @Qualifier(BeanConstant.restbean)
    private BookService bookRestService;

    @Autowired
    @Qualifier(BeanConstant.dbbean)
    private BookService bookDbService;

    @GetMapping("")
    public List<Book> getBooks(@RequestHeader("bean") String bean){
        if(bean.equalsIgnoreCase(BeanConstant.restbean)){
            return this.bookRestService.getBooks();
        }
        return this.bookDbService.getBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable String bookId,@RequestHeader("bean") String bean){
        if(bean.equalsIgnoreCase(BeanConstant.restbean)){
            return this.bookRestService.getBook(bookId);
        }
        return this.bookDbService.getBook(bookId);
    }
    @DeleteMapping("/{bookId}")
    public Boolean deleteBook(@PathVariable  String bookId,@RequestHeader("bean") String bean){
        if(bean.equalsIgnoreCase(BeanConstant.restbean)){
            return this.bookRestService.deleteBook(bookId);
        }
        return this.bookDbService.deleteBook(bookId);

    }
    @PostMapping("")
    public Book saveBook(@RequestBody  Book book,@RequestHeader("bean") String bean){
        if(bean.equalsIgnoreCase(BeanConstant.restbean)){
            return this.bookRestService.saveBook(book);
        }
        return this.bookDbService.saveBook(book);
    }
    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable String bookId,@RequestBody Book book,@RequestHeader("bean") String bean){
        book.setId(bookId);
        if(bean.equalsIgnoreCase(BeanConstant.restbean)){
            return this.bookRestService.updateBook(bookId,book);
        }
        return this.bookDbService.updateBook(bookId,book);

    }
}
