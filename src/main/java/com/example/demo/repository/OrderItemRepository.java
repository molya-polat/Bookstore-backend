package com.example.demo.repository;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    @Query(value = "select b from OrderItem b where b.orderId=:orderId")
    List<OrderItem> findOrderItemByOrderId(int orderId);

    List<OrderItem> findAllByBdateBetween(
            Date date1,
            Date date2);
}
