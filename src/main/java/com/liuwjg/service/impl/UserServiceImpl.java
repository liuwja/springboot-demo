package com.liuwjg.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liuwjg.dao.UserMapper;
import com.liuwjg.entity.User;
import com.liuwjg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User detail(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page list(Integer pageNum, Integer pageSize) {
        Map<String, Object> params = new HashMap();
        Page page = PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("id ASC");
        userMapper.list(params);
        return page;
    }

    @Override
    public User findUser(User user) {
        return userMapper.findUser(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
