package com.demo.school.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.school.entity.dto.ClassStudentDto;
import com.demo.school.entity.po.Class;
import com.demo.school.entity.qo.GetStudentQo;
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
public interface ClassMapper extends BaseMapper<Class> {

    /**
     * 获取学生分页数据
     */
    List<ClassStudentDto> getStudentPage(@Param("qo") GetStudentQo qo);
}
