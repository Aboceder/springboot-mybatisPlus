package com.demo.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.user.entity.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> getUserList(@Param("id") Long id);
}
