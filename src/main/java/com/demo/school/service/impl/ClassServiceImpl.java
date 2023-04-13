package com.demo.school.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.school.entity.dto.ClassStudentDto;
import com.demo.school.entity.po.Class;
import com.demo.school.entity.qo.GetStudentQo;
import com.demo.school.mapper.ClassMapper;
import com.demo.school.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 班级表 服务实现类
 * </p>
 *
 * @author Aboceder
 * @since 2023-04-13
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {
    private final ClassMapper classMapper;

    public ClassServiceImpl(ClassMapper classMapper) {
        this.classMapper = classMapper;
    }

    /**
     * 获取学生分页数据
     */
    @Override
    public List<ClassStudentDto> getStudentPage(GetStudentQo qo) {

        return classMapper.getStudentPage(qo);
    }
}
