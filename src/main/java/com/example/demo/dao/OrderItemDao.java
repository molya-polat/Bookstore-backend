package com.example.demo.dao;

import com.example.demo.entity.OrderItem;

import java.util.Date;
import java.util.List;

public interface OrderItemDao {
    public void save(OrderItem orderItem);

    public List<OrderItem> findOrderItemByOrderId(int orderId);

    public List<OrderItem> bookHotList(Date date1, Date date2);
}
