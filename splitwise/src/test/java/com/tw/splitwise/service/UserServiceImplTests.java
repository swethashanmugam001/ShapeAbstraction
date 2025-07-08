package com.tw.splitwise.service;

import com.tw.splitwise.dao.UserDao;
import com.tw.splitwise.dao.UserDaoImpl;
import com.tw.splitwise.entity.User;
import com.tw.splitwise.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceImplTests {
    private static UserService userService;

    @BeforeAll
    public static void setUp() {
        UserDao userDao = new UserDaoImpl();
        userService = new UserServiceImpl(userDao);
    }

    @Test
    public void shouldAdd() {
        User user = new User("Pradeep");
        assertTrue(userService.add(user));
        assertNotNull(userService.findById(user.getId()));
    }

    @Test
    public void shouldFindAll() {
        User user = new User("Ajay");
        userService.add(user);
        List<User> result = userService.findAll();
        boolean isFound = result.stream().anyMatch(x -> x.getName().equals("Ajay"));
        assertFalse(result.isEmpty());
        assertTrue(isFound);
    }

    @Test
    public void shouldFindById() {
        User user = new User("Vinay");
        assertTrue(userService.add(user));
        assertNotNull(userService.findById(user.getId()));
    }

    @Test
    public void shouldFindByName() {
        User user = new User("Leela");
        userService.add(user);
        assertNotNull(userService.findByName("Leela"));
        assertThrows(UserNotFoundException.class, () -> userService.findByName("Ramya"));
    }
}
