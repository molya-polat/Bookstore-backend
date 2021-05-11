package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public Message login(@RequestParam("username") String username,
                         @RequestParam("password") String password) {
        User user = userService.checkUser(username, password);
        if (user == null) {
            return new Message(0, "error username or password", null);
        } else {
            if (user.getType().equals("admin")) {
                return new Message(2, "successful login!", user);
            } else if (user.getType().equals("disable")) {
                return new Message(-1, "Sorry, you are disabled", user);
            }
            return new Message(1, "successful login!", user);
        }
    }

    @PostMapping(value = "/checkSession")
    public int s() {
        return 1;
    }

    @RequestMapping(value = "/register")
    public Message register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("address") String address) {
        if (userService.register(username, password, email, address)) {
            return new Message(1, "successful register!", null);
        }

        return new Message(0, "fail register!", null);
    }

    @RequestMapping(value = "/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/changeState")
    public List<User> changeState(@RequestParam("userId") int userId) {
        System.out.println("change state" + userId);
        return userService.changeState(userId);
    }
}

