package com.tw.splitwise.service;

import com.tw.splitwise.entity.User;

import java.util.List;

public interface UserService {

    boolean add(User user);

    User findById(int id);

    List<User> findAll();

    List<User> findByName(String name);
}
