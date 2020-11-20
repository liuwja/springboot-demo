package com.liuwjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuwjg.common.Result;
import com.liuwjg.entity.User;
import com.liuwjg.service.IUserService;
import com.liuwjg.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("{id}")
    public Result detail(@PathVariable(name = "id") Long id) {
        User user = userService.getById(id);
        return Result.success(user);
    }

    @RequestMapping("list")
    public Result list(@RequestBody UserVo vo) {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().
                eq(vo.getName()!=null,User::getUserName, vo.getName()).
                eq(vo.getSex()!=null,User::getSex, vo.getSex()).
                eq(vo.getUsername()!=null,User::getUserName, vo.getUsername());
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<User> userList = userService.list(queryWrapper);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return Result.success(pageInfo);
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        Boolean result = userService.saveOrUpdate(user);
        return Result.success(result);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable(name = "id") Long id) {
        Boolean result = userService.removeById(id);
        return Result.success(result);
    }
}
