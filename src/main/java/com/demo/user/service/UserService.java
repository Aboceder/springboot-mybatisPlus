package com.demo.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.user.entity.po.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> getUserList(Long id);
}
