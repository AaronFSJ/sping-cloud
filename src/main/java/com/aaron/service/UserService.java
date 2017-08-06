package com.aaron.service;

import com.aaron.common.base.BaseService;
import com.aaron.common.base.BaseServiceImpl;
import com.aaron.common.page.Pager;
import com.aaron.entity.User;
import com.aaron.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Aaron on 2017/7/22.
 */
@SuppressWarnings("ALL")
@Service
public class UserService extends BaseServiceImpl<User,Long> {

    @Autowired
    private UserMapper userMapper;
    public List<User> getAll(Pager pager) {
       PageHelper.startPage(pager.getPageNum(),pager.getPageSize());
       List<User> userList= userMapper.getAll();

//       PageInfo pageInfo = new PageInfo(userList);
       return userList;
    }

}
