package com.demo.school.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.school.entity.dto.ClassStudentDto;
import com.demo.school.entity.po.Class;
import com.demo.school.entity.qo.GetStudentQo;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 班级表 Mapper 接口
 * </p>
 *
 * @author Aboceder
 * @since 2023-04-13
 */
@Mapper
public interface ClassMapper extends MPJBaseMapper<Class> {

    /**
     * 获取学生分页数据
     */
    List<ClassStudentDto> getStudentPage(@Param("qo") GetStudentQo qo, @Param("page") Integer page);

    /**
     * 使用ew条件自动拼接
     */
    IPage<ClassStudentDto> getStudentPage1(Page<ClassStudentDto> page, @Param("ew") QueryWrapper<ClassStudentDto> wrapper);

    //List<ClassStudentDto> getStudentPage2(@Param("page") Integer page, @Param("size") Integer size, @Param("ew") LambdaQueryWrapper<Class> wrapper);
}
