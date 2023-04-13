package com.demo.school.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 学生表
 * </p>
 *
 * @author Aboceder
 * @since 2023-04-13
 */
@Data
@Accessors(chain = true)
@TableName("student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生姓名
     */
    @TableField("name")
    private String name;

    /**
     * 学生性别，0：男，1：女
     */
    @TableField("gender")
    private Boolean gender;

    /**
     * 出生年月
     */
    @TableField("birthday")
    private LocalDate birthday;

    /**
     * 班级ID
     */
    @TableField("class_id")
    private Integer classId;
}
