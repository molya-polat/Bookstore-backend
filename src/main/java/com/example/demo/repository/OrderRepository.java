package com.example.demo.repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "select b from Order b where b.userId=:userId and b.isPaid=false")
    Order findOrderByUserId(int userId);

    @Query(value = "select b from Order b where b.userId=:userId and b.isPaid=true")
    List<Order> findByUserId(int userId);

    @Query(value = "select b from Order b where b.userId=:order_id and b.isPaid=true")
    List<Order> findByOrderId(int order_id);

    @Query(value = "select b from Order b")
    List<Order> getOrders();

    List<Order> findAllByBdateBetween(
            Date date1,
            Date date2);

}
