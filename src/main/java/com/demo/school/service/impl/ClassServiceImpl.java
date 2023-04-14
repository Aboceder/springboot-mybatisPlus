package com.demo.school.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.school.entity.dto.ClassStudentDto;
import com.demo.school.entity.po.Class;
import com.demo.school.entity.qo.GetStudentQo;
import com.demo.school.mapper.ClassMapper;
import com.demo.school.service.ClassService;
import com.github.yulichang.query.MPJLambdaQueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
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

        return classMapper.getStudentPage(qo, (qo.getPage() - 1) * qo.getSize());
/*        Page<ClassStudentDto> page = new Page<>(qo.getPage(), qo.getSize());
        QueryWrapper<ClassStudentDto> wrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotEmpty(qo.getClassName())) {
            wrapper.like("name","%" + qo.getClassName() + "%");
        }
        if (ObjectUtil.isNotEmpty(qo.getGrade())) {
            wrapper.eq("grade", qo.getGrade());
        }
        IPage<ClassStudentDto> result = classMapper.getStudentPage1(page, wrapper);
        System.out.println("result.getRecords() = " + result.getRecords().size());
        System.out.println("result.getPages() = " + result.getPages());
        System.out.println("result.getSize() = " + result.getSize());
        System.out.println("result.getTotal() = " + result.getTotal());
        return result.getRecords();*/
    }

    /**
     * 获取学生分页数据（baseMapper）
     */
    @Override
    public List<ClassStudentDto> getStudentPage2(GetStudentQo qo) {
        MPJLambdaQueryWrapper<Class> wrapper = new MPJLambdaQueryWrapper<>();
        //wrapper.selectAll(Class.class).selectAs()
        if (ObjectUtil.isNotEmpty(qo.getClassName())) {
            wrapper.like(Class::getName,"%" + qo.getClassName() + "%");
        }
        if (ObjectUtil.isNotEmpty(qo.getGrade())) {
            wrapper.eq(Class::getGrade, qo.getGrade());
        }

        return null;
    }
}
