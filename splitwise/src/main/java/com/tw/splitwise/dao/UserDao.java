package com.tw.splitwise.dao;

import com.tw.splitwise.entity.User;

import java.util.List;

public interface UserDao {

    boolean add(User user);

    User findById(int id);

    List<User> findAll();

    List<User> findByName(String name);
}
