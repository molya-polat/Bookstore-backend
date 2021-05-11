//package com.example.demo.repository;
//
//import com.example.demo.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//public interface UserRepository extends JpaRepository<User,String> {
//    @Query(value = "from User where username = :username and password = :password")
//    User checkUser(@Param("username") String username, @Param("password") String password);
//}
package com.example.demo.repository;


import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "from User where username = :username and password = :password")
    User checkUser(@Param("username") String username, @Param("password") String password);

    @Query(value = "select tags from User tags WHERE tags.username=:username")
    User findUserByUsername(@Param("username") String username);

    @Query(value = "select b from User b")
    List<User> getUsers();

    @Query(value = "select b from User b where b.userId=:userId")
    User findUserByUserId(@Param("userId") int userId);

    @Query("select b from User b where b.type='user' order by b.quantity desc")
    List<User> consumptionList();
}
