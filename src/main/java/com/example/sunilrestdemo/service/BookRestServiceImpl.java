package com.example.sunilrestdemo.service;

import com.example.sunilrestdemo.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Qualifier("bookrestservice")
public class BookRestServiceImpl implements  BookService{

    @Autowired
    RestTemplate restTemplate;

    private String baseUrl= "https://sunilmore-rest-api.herokuapp.com";
    @Override
    public List<Book> getBooks() {
        ResponseEntity<Object[]> responseEntity =  restTemplate.getForEntity(baseUrl +"/api/users",Object[].class);
        Object[] objects = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, Book.class))
                .collect(Collectors.toList());
    }

    @Override
    public Book saveBook(Book book) {
        return restTemplate.postForEntity(baseUrl +"/api/users",book,Book.class).getBody();
    }

    @Override
    public Book getBook(String id) {
        return restTemplate.getForEntity(baseUrl +"/api/users/"+id,Book.class).getBody();
    }

    @Override
    public Boolean deleteBook(String id) {
        restTemplate.delete(baseUrl +"/api/users/"+id);
        return true;
    }

    @Override
    public Book updateBook(String id, Book book) {
        HttpEntity<Book> httpEntity  = new HttpEntity<Book>(book);
        return restTemplate.exchange(baseUrl +"/api/users/"+id, HttpMethod.PUT,httpEntity,Book.class).getBody();
    }
}
