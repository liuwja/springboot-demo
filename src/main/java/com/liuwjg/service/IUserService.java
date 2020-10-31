package com.liuwjg.service;

import com.github.pagehelper.Page;
import com.liuwjg.entity.User;

public interface IUserService {
    User detail(Integer id);

    Page list(Integer pageNum, Integer pageSize);

    User findUser(User user);

    int update(User user);
}
