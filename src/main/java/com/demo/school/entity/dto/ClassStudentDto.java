package com.demo.school.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ClassStudentDto implements Serializable {
    private static final long serialVersionUID = 8229490911245889302L;

    /**
     * 学生ID
     */
    private Integer id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生性别，0：男，1：女
     */
    private Boolean gender;

    /**
     * 出生年月
     */
    private LocalDate birthday;

    /**
     * 班级ID
     */
    private Integer classId;

    /**
     * 班级名称
     */
    private String className;
}
