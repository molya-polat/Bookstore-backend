package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.BookService;
import com.example.demo.service.OrderService;
import com.example.demo.utils.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/addToCart")
    public List<Book> addToCart(@RequestParam("id") Integer bookId, @RequestParam("username") String username) {
        int quantity = 1;
        System.out.println(bookId);
        System.out.println(username);
        System.out.println("adding to cart");
        return orderService.addToCart(bookId, quantity, username);
    }


    @RequestMapping(value = "/getAllOrders")
    public List<Order> getAllOrders() {
        return orderService.getOrders();
    }

    @RequestMapping(value = "/buyBooks")
    public Message buyBooks(@RequestParam("username") String username) {
        System.out.println("uuuuuu");
        if (!orderService.buyBooks(username))
            return new Message(0, "Something went wrong", null);
        else
            return new Message(1, "Transaction completed! Thank you for your order!", null);

    }

    @RequestMapping(value = "/getOrders")
    public List<Order> getOrders(@RequestParam("username") String username) {
        return orderService.getOrdersByUserId(username);
    }

    @RequestMapping(value = "/getOrderDetails")
    public List<Book> getOrders(@RequestParam("orderId") int orderId) {
        return orderService.getBooksByOrderId(orderId);
    }
}
