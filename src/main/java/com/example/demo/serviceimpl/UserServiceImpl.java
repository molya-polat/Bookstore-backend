//package com.example.demo.serviceimpl;
//
//import com.example.demo.dao.UserDao;
//import com.example.demo.entity.User;
//import com.example.demo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public User checkUser(String username, String password) {
//        return userDao.checkUser(username, password);
//    }
//
//
//}

package com.example.demo.serviceimpl;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.OrderItemDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Book;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private OrderItemDao orderItemDao;

    @Override
    public User checkUser(String username, String password) {
        return userDao.checkUser(username, password);
    }

    @Override
    public Boolean register(String username, String password, String email, String address) {
        User user = userDao.findUserByUsername(username);
//        System.out.println(user.getUsername());
        if (user == null) {
            //        System.out.println("555555");
            user = new User(username, password, email, "user", 1500, address);
            userDao.save(user);
            return true;
        }
//        System.out.println("444444444");
        return false;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public List<User> changeState(int userId) {
        User user = userDao.findOne(userId);
        if (user.getType().equals("user"))
            user.setType("disable");
        else if (user.getType().equals("disable"))
            user.setType("user");
        userDao.save(user);
        return userDao.getUsers();
    }

    @Override
    public List<Book> searchAnalyze(String username, String date1, String date2) {
        System.out.println("There is searchAnalyze");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date_1 = null, date_2 = null;
        try {
            date_1 = formatter.parse(date1);
            date_2 = formatter.parse(date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = userDao.findUserByUsername(username);
        user.setQuantity(0);
        user.setPurchases(0);
        List<Book> books = bookDao.getBooks();
        for (Book book : books) {
            book.setTemp(0);
        }
        int userId = user.getUserId();
        List<Order> m = orderDao.consumptionList(date_1, date_2);
        List<OrderItem> k;
        List<Book> b = new ArrayList<Book>();

        for (Order order : m) {
            if (order.getUserId() == userId) {
                k = orderItemDao.findOrderItemByOrderId(order.getOrder_id());
                for (OrderItem item : k) {
                    Book book = bookDao.findOne(item.getBookId());
                    book.setTemp(book.getTemp() + order.getQuantity());
                    b.add(book);
                    bookDao.save(book);
                }
            }

        }
        return b;
    }

    @Override
    public List<User> analyze(String username, String date1, String date2) {
        System.out.println("There is analyze");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date_1 = null, date_2 = null;
        try {
            date_1 = formatter.parse(date1);
            date_2 = formatter.parse(date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = userDao.findUserByUsername(username);
        user.setQuantity(0);
        user.setPurchases(0);

        int userId = user.getUserId();
        List<Order> m = orderDao.consumptionList(date_1, date_2);
        List<OrderItem> k;
        List<User> u = new ArrayList<User>();
        for (Order order : m) {
            if (order.getUserId() == userId) {
                user.setPurchases(user.getPurchases() + order.getTotalPrice());
                k = orderItemDao.findOrderItemByOrderId(order.getOrder_id());
                for (OrderItem item : k) {
                    user.setQuantity(user.getQuantity() + item.getQuantity());
                    userDao.save(user);
                }
            }
        }
        userDao.save(user);
        u.add(user);
        return u;
    }
}









