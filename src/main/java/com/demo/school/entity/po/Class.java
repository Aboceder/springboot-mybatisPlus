package com.demo.school.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 班级表
 * </p>
 *
 * @author Aboceder
 * @since 2023-04-13
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("class")
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 班级ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 年级
     */
    @TableField("grade")
    private Integer grade;

    /**
     * 班级名称
     */
    @TableField("name")
    private String name;

    /**
     * 是否优秀班级，0：否，1：是
     */
    @TableField("excellent")
    private Boolean excellent;
}
