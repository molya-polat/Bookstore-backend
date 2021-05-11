package com.example.demo.daoimpl;


import com.example.demo.dao.OrderDao;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order findOrderByUserId(int userId) {
        return orderRepository.findOrderByUserId(userId);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        System.out.println("777777");
        return orderRepository.findByUserId(userId);
    }

    @Override
    public List<Order> getOrdersByOrder_id(int order_id) {
        System.out.println("jhjhjhjhjh");
        return orderRepository.findByUserId(order_id);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }

    @Override
    public List<Order> consumptionList(Date date1, Date date2) {
        return orderRepository.findAllByBdateBetween(date1, date2);
    }
//    @Override
//    public void delete(Order order) {
//
//    }
//
//    @Override
//    public void update(Order order) {
//
//    }
//
//    @Override
//    public Order getOrderById(int id) {
//        return null;
//    }
//
//    @Override
//    public List<Order> getAllOrders() {
//        return null;
//    }
}
