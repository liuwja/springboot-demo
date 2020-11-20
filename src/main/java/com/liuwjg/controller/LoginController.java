package com.liuwjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.liuwjg.common.Result;
import com.liuwjg.entity.User;
import com.liuwjg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    IUserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        QueryWrapper<User> queryWrapper = Wrappers.query(user);
        User u = userService.getOne(queryWrapper,false);
        return Result.success(u != null);

    }
}
