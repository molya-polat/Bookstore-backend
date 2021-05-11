package com.example.demo.repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookInfoRepository extends MongoRepository<BookInfo, Integer> {

}
