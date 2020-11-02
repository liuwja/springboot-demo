package com.liuwjg.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.liuwjg.entity.User;
import com.liuwjg.vo.UserVo;

public interface IUserService {
    User detail(Integer id);

    PageInfo list(UserVo vo);

    User findUser(User user);

    int update(User user);
}
