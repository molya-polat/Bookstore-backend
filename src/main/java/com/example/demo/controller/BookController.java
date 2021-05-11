package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.service.BookService;
import com.example.demo.utils.Consumer;
import com.example.demo.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/getBooks")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @RequestMapping(value = "/getBook")
    public Book getBook(@RequestParam("id") Integer id) {
        return bookService.findBookById(id);
    }

    @RequestMapping(value = "/getBookByTitle")
    public Book getBook(@RequestParam("title") String title) {
        return bookService.findBookByTitle(title);
    }

    @RequestMapping(value = "/addNewBook")
    public Message getBook(@RequestParam("title") String title, @RequestParam("author") String author, @RequestParam("isbn") int isbn, @RequestParam("language") String language, @RequestParam("published") String published, @RequestParam("sales") int sales, @RequestParam("price") int price, @RequestParam("stock") int stock, @RequestParam("info") String info) {

        if (!bookService.addNewBook(title, author, isbn, language, published, sales, price, stock, info))
            return new Message(0, "error", null);
        else
            return new Message(1, "done", null);
    }

    @RequestMapping(value = "/bookHotList")
    public List<Book> bookHotList(@RequestParam("date1") String date1, @RequestParam("date2") String date2) {

        return bookService.bookHotList(date1, date2);
    }

    @RequestMapping(value = "/consumptionList")
    public List<User> consumptionList(@RequestParam("date1") String date1, @RequestParam("date2") String date2) {

        return bookService.consumptionList(date1, date2);
    }
}
