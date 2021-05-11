package com.example.demo.serviceimpl;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.OrderItemDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Book;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.User;
import com.example.demo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Book findBookById(Integer id) {
        return bookDao.findOne(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookDao.findBookByTitle(title);
    }

    @Override
    public Boolean addNewBook(String title, String author, int isbn, String language, String published, int sales, int price, int stock, String info) {
        Book book = new Book(title, author, isbn, language, published, sales, price, stock, info);
        bookDao.save(book);
        return true;
    }

    @Override
    public List<Book> bookHotList(String date1, String date2) {
        System.out.println("There are dates");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date_1 = null, date_2 = null;
        try {
            date_1 = formatter.parse(date1);
            date_2 = formatter.parse(date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<OrderItem> l = orderItemDao.bookHotList(date_1, date_2);
        List<Book> books = bookDao.getBooks();
        for (Book book : books) {
            book.setTemp(0);
        }
        List<Book> books1 = new ArrayList<Book>();
        for (OrderItem element : l) {
            Book book = bookDao.findOne(element.getBookId());
            book.setTemp(book.getTemp() + 1);
            books1.add(book);
            bookDao.save(book);
        }
        books1 = bookDao.bookHotList();
        return books1;
    }

    @Override
    public List<User> consumptionList(String date1, String date2) {
        System.out.println("There are consumers");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date_1 = null, date_2 = null;
        try {
            date_1 = formatter.parse(date1);
            date_2 = formatter.parse(date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Order> l = orderDao.consumptionList(date_1, date_2);
        List<User> users = userDao.getUsers();
        for (User user : users) {
            user.setQuantity(0);
            user.setPurchases(0);
        }
        for (Order order : l) {
            User u = userDao.findOne(order.getUserId());
            u.setPurchases(u.getPurchases() + order.getTotalPrice());
            u.setQuantity(u.getQuantity() + order.getQuantity());
            userDao.save(u);
        }
        users = userDao.consumptionList();
        return users;
    }

}
