package com.tw.splitwise.dao;

import com.tw.splitwise.entity.User;
import com.tw.splitwise.util.FileParser;

import java.util.List;
import java.util.stream.Collectors;

public class UserDaoImpl implements UserDao {

    private final List<User> users;

    public UserDaoImpl() {
       this.users = FileParser.getAllUsers();
    }

    @Override
    public boolean add(User user) {
        users.add(user);
        return true;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        return users.stream().filter(user -> user.getId() == id)
                            .findFirst()
                            .orElse(null);
    }

    @Override
    public List<User> findByName(String name) {
        return users.stream().filter(user -> user.getName().equals(name))
                             .collect(Collectors.toList());
    }
}
