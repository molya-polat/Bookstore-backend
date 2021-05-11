package com.example.demo.dao;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;

import java.util.Date;
import java.util.List;

public interface OrderDao {

    public void save(Order order);

    public Order findOrderByUserId(int userId);

    public List<Order> getOrdersByUserId(int userId);

    public List<Order> getOrdersByOrder_id(int order_id);

    public List<Order> getOrders();

    public List<Order> consumptionList(Date date1, Date date2);
}
