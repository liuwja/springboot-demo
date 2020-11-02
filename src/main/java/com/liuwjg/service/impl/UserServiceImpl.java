package com.liuwjg.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuwjg.dao.UserMapper;
import com.liuwjg.entity.User;
import com.liuwjg.service.IUserService;
import com.liuwjg.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
    public PageInfo<User> list( UserVo vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        PageHelper.orderBy("id ASC");
        List<User> userList =  userMapper.list(vo);
        PageInfo pageInfo = new PageInfo(userList);
        return pageInfo;
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
