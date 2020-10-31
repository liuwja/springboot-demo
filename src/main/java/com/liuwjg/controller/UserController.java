package com.liuwjg.controller;

import com.github.pagehelper.Page;
import com.liuwjg.common.CommonPage;
import com.liuwjg.common.Result;
import com.liuwjg.entity.User;
import com.liuwjg.service.IUserService;
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

    @GetMapping("list")
    public Result list(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page page = userService.list(pageNum, pageSize);
        return Result.success(CommonPage.restPage(page));
    }

    @PostMapping("update")
    public Result update(@RequestBody User user) {
        Integer num = userService.update(user);
        return Result.success(num);
    }
}
