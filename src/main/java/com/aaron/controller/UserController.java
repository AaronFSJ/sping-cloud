package com.aaron.controller;

import com.aaron.common.page.Pager;
import com.aaron.entity.User;
import com.aaron.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

//    @RequestMapping("getUserList")
//    public List<User> getUserList(){
//        List<User> userList =userService.selectByPage();
//        return userList;
//    }

    @RequestMapping("getAll/{pageNum}/{pageSize}")
    public PageInfo<User> getAll(@PathVariable int pageNum,@PathVariable int pageSize) {
//        User user = new User();
        Pager pager = new Pager();
        pager.setPageNum(pageNum);
        pager.setPageSize(pageSize);
        List<User> userList = userService.getAll(pager);
        return new PageInfo<User>(userList);
    }


//    @RequestMapping("/query/{page}/{pageSize}")
//    public PageInfo query(@PathVariable Integer page, @PathVariable Integer pageSize) {
//        if(page!= null && pageSize!= null){
//            PageHelper.startPage(page, pageSize);
//        }
//        List<User> users = userService.list();
//        return new PageInfo(users);
//    }

}
