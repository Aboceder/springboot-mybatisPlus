package com.demo.school.controller;

import com.demo.school.entity.dto.ClassStudentDto;
import com.demo.school.entity.qo.GetStudentQo;
import com.demo.school.service.ClassService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 班级表 前端控制器
 *
 * @author Aboceder
 * @since 2023-04-13
 */
@RestController
@RequestMapping("/school/class")
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    /**
     * 获取学生分页数据（xml文件写sql）
     */
    @PostMapping("/getStudentPage")
    public List<ClassStudentDto> getStudentPage(GetStudentQo qo) {
        return classService.getStudentPage(qo);
    }

    /**
     * 获取学生分页数据（baseMapper）
     */
    @PostMapping("/getStudentPage2")
    public List<ClassStudentDto> getStudentPage2(GetStudentQo qo) {
        return classService.getStudentPage2(qo);
    }
}
