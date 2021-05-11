package com.example.demo.service;//package com.example.demo.service;


import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.utils.Consumer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User checkUser(String username, String password);

    Boolean register(String username, String password, String email, String address);

    List<User> getUsers();

    List<User> changeState(int userId);

    List<Book> searchAnalyze(String username, String date1, String date2);

    List<User> analyze(String username, String date1, String date2);
}
