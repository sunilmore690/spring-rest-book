package com.example.sunilrestdemo.dao;

import com.example.sunilrestdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao  extends JpaRepository<Book,String> {
}
