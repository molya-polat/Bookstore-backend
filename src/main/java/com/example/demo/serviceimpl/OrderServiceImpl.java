package com.example.demo.serviceimpl;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.OrderItemDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Book;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.User;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    BookDao bookDao;
    @Autowired
    UserDao userDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderItemDao orderItemDao;

    @Override
    public List<Book> addToCart(int bookId, int quantity, String username) {
        User user = userDao.findUserByUsername(username);
//        System.out.println("111111");
        Book book = bookDao.findOne(bookId);
//        System.out.println("22222");
        Integer totPr = book.getPrice() * quantity;
//        System.out.println("33333");
        Order order = orderDao.findOrderByUserId(user.getUserId());
//        System.out.println("4444444");
        if ((order == null)) {
            order = new Order(user.getUserId(), totPr);

        } else if (!order.getIsPaid())
            order.setTotalPrice(order.getTotalPrice() + totPr);
        orderDao.save(order);
        System.out.println("the order is saved for user " + user.getUsername());
        OrderItem orderItem = new OrderItem(order.getOrder_id(), book.getId(), quantity, book.getPrice());
        orderItemDao.save(orderItem);

        List<Book> books = new ArrayList<Book>();
        List<OrderItem> ord = orderItemDao.findOrderItemByOrderId(order.getOrder_id());

        for (OrderItem element : ord) {
            Book book1 = bookDao.findOne(element.getBookId());
            books.add(book1);
        }
        return books;
    }

    @Override
    public List<Book> myCart(String username) {
        User user = userDao.findUserByUsername(username);
        Order order = orderDao.findOrderByUserId(user.getUserId());
        List<Book> books = new ArrayList<Book>();
        List<OrderItem> ord = orderItemDao.findOrderItemByOrderId(order.getOrder_id());
        for (OrderItem element : ord) {
            Book book1 = bookDao.findOne(element.getBookId());
            books.add(book1);
        }
        return books;
    }

    @Override
    public List<Order> getOrdersByUserId(String username) {
        User user = userDao.findUserByUsername(username);
        List<Order> o = orderDao.getOrdersByUserId(user.getUserId());
        System.out.println(o);
        return o;
    }

    @Override
    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

    @Override
    public Boolean buyBooks(String username) {
//        LocalDate localDate = LocalDate.now(ZoneId.of("GMT+12:30"));
        Date date = new Date(); //这里的date 不知道为什么会迟一天
        date.setDate(date.getDate() + 1);

        User user = userDao.findUserByUsername(username);
        Order order = orderDao.findOrderByUserId(user.getUserId());
        List<OrderItem> ord = orderItemDao.findOrderItemByOrderId(order.getOrder_id());
        int quant = ord.size();
        for (OrderItem element : ord) {
            Book book = bookDao.findOne(element.getBookId());
            book.setStock(book.getStock() - 1);
            book.setSales(book.getSales() + 1);
            bookDao.save(book);
            element.setBdate(date);
            orderItemDao.save(element);
        }
        if (user.getBalance() < order.getTotalPrice())
            return false;
        user.setBalance(user.getBalance() - order.getTotalPrice());
        userDao.save(user);
        order.setBdate(date);
        order.setIsPaid(true);
        order.setQuantity(quant);
        orderDao.save(order);
        return true;
    }

    @Override
    public List<Book> getBooksByOrderId(int orderId) {
        List<Book> books = new ArrayList<Book>();
        List<OrderItem> ord = orderItemDao.findOrderItemByOrderId(orderId);
        for (OrderItem element : ord) {
            Book book = bookDao.findOne(element.getBookId());
            books.add(book);
        }
        return books;
    }
}
