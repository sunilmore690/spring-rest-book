package com.example.sunilrestdemo.dao;

import com.example.sunilrestdemo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao  extends MongoRepository<User,String> {
    User findByUsername(String username);
}
