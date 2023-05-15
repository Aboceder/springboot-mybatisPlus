package com.demo.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.user.entity.po.User;
import com.demo.user.mapper.UserMapper;
import com.demo.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUserList(Long id) {
        return userMapper.getUserList(id);
    }

    @Override
    public User findById(String id) {
        if (!StringUtils.hasText(id)) {
            throw new RuntimeException("id不能为空");
        }
        return userMapper.selectById(id);
    }
}
