package com.example.demo.daoimpl;

import com.example.demo.dao.OrderItemDao;
import com.example.demo.entity.OrderItem;
import com.example.demo.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void save(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> findOrderItemByOrderId(int orderId) {
        return orderItemRepository.findOrderItemByOrderId(orderId);
    }

    @Override
    public List<OrderItem> bookHotList(Date date1, Date date2) {
        return orderItemRepository.findAllByBdateBetween(date1, date2);
    }
}
