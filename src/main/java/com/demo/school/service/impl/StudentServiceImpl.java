package com.demo.school.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.school.entity.po.Student;
import com.demo.school.mapper.StudentMapper;
import com.demo.school.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生表 服务实现类
 * </p>
 *
 * @author Aboceder
 * @since 2023-04-13
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
