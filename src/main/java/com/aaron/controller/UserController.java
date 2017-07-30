package com.aaron.controller;

import com.aaron.entity.User;
import com.aaron.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aaron on 2017/7/22.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

   //http://localhost:8080/getUser/1
    @RequestMapping("getUser/{id}")
    public User getUser(@PathVariable Long id){
        User user = userService.selectById(id);
        return user;
    }
}
