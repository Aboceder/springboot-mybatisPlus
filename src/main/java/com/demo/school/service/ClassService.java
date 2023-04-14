package com.demo.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.school.entity.dto.ClassStudentDto;
import com.demo.school.entity.po.Class;
import com.demo.school.entity.qo.GetStudentQo;

import java.util.List;

/**
 * <p>
 * 班级表 服务类
 * </p>
 *
 * @author Aboceder
 * @since 2023-04-13
 */
public interface ClassService extends IService<Class> {

    /**
     * 获取学生分页数据
     */
    List<ClassStudentDto> getStudentPage(GetStudentQo qo);

    /**
     * 获取学生分页数据（baseMapper）
     */
    List<ClassStudentDto> getStudentPage2(GetStudentQo qo);
}
