package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface UserDao {
    User checkUser(String username, String password);

    User findUserByUsername(String username);

    void save(User user);

    List<User> getUsers();

    User findOne(int userId);

    List<User> consumptionList();

}
