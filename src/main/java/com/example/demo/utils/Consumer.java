package com.example.demo.utils;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;

import java.util.List;

public class Consumer {

    private User user;
    private List<Book> books;

    public Consumer() {
    }

    public Consumer(User user, List<Book> book) {
        this.user = user;
        this.books = book;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void setBook(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBook() {
        return this.books;
    }

}
