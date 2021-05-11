//package com.example.demo.daoimpl;
//
//import com.example.demo.dao.UserDao;
//import com.example.demo.entity.User;
//import com.example.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class UserDaoImpl implements UserDao {
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public User checkUser(String username, String password){
//        return userRepository.checkUser(username,password);
//    }
//}
package com.example.demo.daoimpl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        return userRepository.checkUser(username, password);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public User findOne(int userId) {
        return userRepository.findUserByUserId(userId);
    }

    @Override
    public List<User> consumptionList() {
        return userRepository.consumptionList();
    }
}
