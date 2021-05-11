package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "bookstore1")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String username;
    private String password;
    private String email;
    private String type;
    private int balance;
    private String address;
    private int purchases;
    private int quantity;

    public User() {
    }


    public User(String username, String password, String email, String type, int balance, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;
        this.balance = balance;
        this.address = address;
        this.purchases = 0;
        this.quantity = 0;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPurchases(int pur) {
        this.purchases = pur;
    }

    public int getPurchases() {
        return this.purchases;
    }

    public void setQuantity(int quant) {
        this.quantity = quant;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
