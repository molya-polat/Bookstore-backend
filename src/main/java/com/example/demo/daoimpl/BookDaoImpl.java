package com.example.demo.daoimpl;

import com.example.demo.dao.BookDao;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookInfo;
import com.example.demo.repository.BookInfoRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookInfoRepository bookInfoRepository;

    @Override
    public Book findOne(Integer id){
        Book book = bookRepository.getOne(id);
        Optional<BookInfo> icon = bookInfoRepository.findById(id);

        if (icon.isPresent()){
            System.out.println("Not Null icon " + id + icon);
            book.setIcon(icon.get());
        }
        else {
            book.setIcon(null);
            System.out.println("It's Null icon");
        }
        return book;
    }
    @Override
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public Book findBookByTitle(String title) { return bookRepository.findBookByTitle(title); }
    @Override
    public void save (Book book) {  bookRepository.save(book);}
    @Override
    public List<Book> bookHotList() {
        return bookRepository.bookHotList();
    }

}




//        for (Book element : books) {
//            Optional<BookInfo> icon = bookInfoRepository.findById(element.getId());
////        Optional<BookInfo> intro = bookInfoRepository.findById(id);
//            if (icon.isPresent()) {
//                System.out.println("Not Null icon 111111");
//                element.setIcon(icon.get());
//            } else {
//                element.setIcon(null);
//                System.out.println("It's Null icon 11111");
//            }
//        }
