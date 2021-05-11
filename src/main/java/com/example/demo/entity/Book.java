package com.example.demo.entity;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//
//import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book", schema = "bookstore1")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Book {
    @Id
    @Column(name = "id")
    private int id;
    private String title;
    private String author;
    private String info;
    private int sales;
    private String published;
    private String language;
    private int price;
    private int stock;
    private String image;
    private int isbn;
    private int temp;

    public Book() {
    }

    public Book(String title, String author, int isbn, String language, String published, int sales, int price, int stock, String info) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.language = language;
        this.published = published;
        this.sales = sales;
        this.price = price;
        this.stock = stock;
        this.info = info;
        this.temp = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "sales")
    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Basic
    @Column(name = "published")
    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    @Basic
    @Column(name = "price")
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "isbn")
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "temp")
    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Transient
    private BookInfo icon;

    public BookInfo getIcon() {
        return icon;
    }

    public void setIcon(BookInfo icon) {
        this.icon = icon;
    }


}

