package com.demo.user.controller;

import com.demo.user.entity.po.User;
import com.demo.user.mapper.UserMapper;
import com.demo.user.service.UserService;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 获取服务器系统信息
     */
    @GetMapping("/system-info")
    public Map<String, String> getSystemInfo() {
        Map<String, String> result = new HashMap<>();
        // 获取系统名称
        result.put("os.name", System.getProperty("os.name"));
        // 获取系统架构
        result.put("os.arch", System.getProperty("os.arch"));
        // 获取系统版本号
        result.put("os.version", System.getProperty("os.version"));
        // 获取环境变量
        Map<String, String> env = System.getenv();
        for (String key : env.keySet()) {
            result.put(key, env.get(key));
        }
        // 获取操作系统MXBean
        OperatingSystemMXBean osMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        // 获取系统的物理内存大小
        long totalMemorySize = osMXBean.getTotalPhysicalMemorySize();
        // 获取系统的空闲物理内存大小
        long freeMemorySize = osMXBean.getFreePhysicalMemorySize();
        result.put("内存占用", freeMemorySize / 1024 / 1024 + " / " +totalMemorySize / 1024 / 1024 + " MB");
        // 获取系统的CPU占用率
        double cpuUsage = osMXBean.getProcessCpuLoad();
        result.put("CPU占用", cpuUsage * 100 + " %");
        return result;
    }


    @GetMapping("/findById")
    public User findById(String id) {
        return userService.findById(id);
    }
}
