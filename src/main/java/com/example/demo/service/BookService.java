package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.utils.Consumer;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface BookService {
    Book findBookById(Integer id);

    List<Book> getBooks();

    Book findBookByTitle(String title);

    Boolean addNewBook(String title, String author, int isbn, String language, String published, int sales, int price, int stock, String info);

    List<Book> bookHotList(String date1, String date2);

    List<User> consumptionList(String date1, String date2);

}

