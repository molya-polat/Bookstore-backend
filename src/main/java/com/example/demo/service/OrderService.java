package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Order;
import com.example.demo.utils.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Book> addToCart(int book, int quantity, String username);

    List<Book> myCart(String username);

    Boolean buyBooks(String username);

    List<Order> getOrdersByUserId(String username);

    List<Book> getBooksByOrderId(int orderId);

    List<Order> getOrders();
}

