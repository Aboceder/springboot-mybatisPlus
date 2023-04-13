package com.demo.school.entity.qo;

import com.demo.core.entity.PageRequestQo;
import lombok.Data;

@Data
public class GetStudentQo extends PageRequestQo {
    private static final long serialVersionUID = 1835759063258742346L;

    /**
     * 班级名称
     */
    private String ClassName;

    /**
     * 年级
     */
    private Integer grade;
}
