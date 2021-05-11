package com.example.demo.entity;

import com.example.demo.entity.Book;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "orderitem", schema = "bookstore")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "item_id")
public class OrderItem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int orderId;
    private int bookId;
    private Integer price;
    private int quantity;
    @Temporal(TemporalType.DATE)
    private Date bdate;

    public OrderItem() {
    }

    public OrderItem(int orderId, int bookId, int quantity, Integer price) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.price = price;

    }

    @Basic
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "book_id")
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "bdate")
    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date date_) {
        this.bdate = date_;
    }

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
//    public Order getOrderByOrderId() {
//        return orderByOrderId;
//    }
//
//    public void setOrderByOrderId(Order orderByOrderId) {
//        this.orderByOrderId = orderByOrderId;
//    }

}

