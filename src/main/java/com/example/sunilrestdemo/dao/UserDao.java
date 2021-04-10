package com.example.sunilrestdemo.dao;

import com.example.sunilrestdemo.entity.Book;
import com.example.sunilrestdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao  extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
