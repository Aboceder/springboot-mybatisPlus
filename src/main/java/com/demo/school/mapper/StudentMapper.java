package com.demo.school.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.school.entity.po.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 学生表 Mapper 接口
 * </p>
 *
 * @author Aboceder
 * @since 2023-04-13
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
