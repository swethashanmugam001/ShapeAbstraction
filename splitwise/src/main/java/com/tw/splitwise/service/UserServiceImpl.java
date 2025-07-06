package com.tw.splitwise.service;

import com.tw.splitwise.dao.UserDao;
import com.tw.splitwise.entity.User;
import com.tw.splitwise.exceptions.UserNotFoundException;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean add(User user) {
        return userDao.add(user);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findByName(String name) {
        List<User> users = userDao.findByName(name);
        if (users.isEmpty()) {
            throw new UserNotFoundException("No user found by name : " + name);
        }
        return users;
    }
}
