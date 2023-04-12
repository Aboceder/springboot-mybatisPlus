package com.demo.user.controller;

import com.demo.user.entity.po.User;
import com.demo.user.mapper.UserMapper;
import com.demo.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    /**
     * 自定义方法查询用户集合
     */
    @GetMapping("/getUserList")
    public List<User> getUserList(@RequestParam Long id) {
        return userService.getUserList(id);
    }

    /**
     * IService查询用户集合
     */
    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    /**
     * BaseMapper查询用户集合
     */
    @GetMapping("/selectList")
    public List<User> selectList() {
        return userMapper.selectList(null);
    }
}
