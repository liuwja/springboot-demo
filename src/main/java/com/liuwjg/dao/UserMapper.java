package com.liuwjg.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuwjg.entity.User;
import com.liuwjg.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}