package com.liuwjg.controller;

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
        User u = userService.findUser(user);
        return Result.success(u != null);

    }
}
