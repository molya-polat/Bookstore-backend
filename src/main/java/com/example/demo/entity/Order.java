package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "order1", schema = "bookstore1")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "order_id")
public class Order {
    @Id
    @Column(name = "_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;
    private int userId;
    private boolean isPaid;
    private int totalPrice;
    private int quantity;

    @Temporal(TemporalType.DATE)
    private Date bdate;


    public Order() {
    }

    public Order(int userId, int totalPrice) {
        this.userId = userId;
        this.isPaid = false;
//       if (this.totalPrice == 0)
        this.totalPrice = totalPrice;
        this.bdate = new Date(System.currentTimeMillis());
        this.quantity = 0;
//           this.totalPrice = this.getTotalPrice()+totalPrice;
//        this.date = date;
    }

    @Basic
    @Column(name = "_id")
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int id) {
        this.order_id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "is_paid")
    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    @Basic
    @Column(name = "total_price")
    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
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

}
