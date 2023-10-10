package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User findByUserName(String userName);

    boolean existsByUserName(String UserName);

    User saveOrUpdate(User user);
}
