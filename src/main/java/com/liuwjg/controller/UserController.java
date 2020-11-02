package com.liuwjg.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.liuwjg.common.CommonPage;
import com.liuwjg.common.Result;
import com.liuwjg.entity.User;
import com.liuwjg.service.IUserService;
import com.liuwjg.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("{id}")
    public Result detail(@PathVariable(name = "id") Integer id) {
        User user = userService.detail(id);
        return Result.success(user);
    }

    @RequestMapping("list")
    public Result list(@RequestBody UserVo vo) {
        PageInfo page = userService.list(vo);
        return Result.success(CommonPage.restPage(page));
    }

    @PostMapping("update")
    public Result update(@RequestBody User user) {
        Integer num = userService.update(user);
        return Result.success(num);
    }
}
