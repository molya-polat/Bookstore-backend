package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import com.example.demo.utils.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CartController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/myCart")
    public List<Book> addToCart(@RequestParam("username") String username) {
        return orderService.myCart(username);
    }

    @RequestMapping(value = "/search")
    public List<Book> searchAnalyze(@RequestParam("username") String username, @RequestParam("date1") String date1, @RequestParam("date2") String date2) {
        return userService.searchAnalyze(username, date1, date2);
    }

    @RequestMapping(value = "/analyze")
    public List<User> analyze(@RequestParam("username") String username, @RequestParam("date1") String date1, @RequestParam("date2") String date2) {
        return userService.analyze(username, date1, date2);
    }
}
