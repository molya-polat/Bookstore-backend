package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("select b from Book b")
    List<Book> getBooks();

    @Query("SELECT b from Book b WHERE b.title=:title")
    Book findBookByTitle(
            @Param("title") String title
    );

    @Query("select b from Book b order by b.temp desc")
    List<Book> bookHotList();

}
