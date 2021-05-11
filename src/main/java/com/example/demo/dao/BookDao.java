package com.example.demo.dao;

import com.example.demo.entity.Book;

import java.util.List;

public interface BookDao {
    Book findOne(Integer id);

    List<Book> getBooks();

    Book findBookByTitle(String title);

    void save(Book book);

    List<Book> bookHotList();
}
