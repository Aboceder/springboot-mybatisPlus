package com.demo.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页qo
 */
@Data
public class PageRequestQo implements Serializable {
    private static final long serialVersionUID = -3253329528916466752L;

    private Integer page = 1;

    private Integer size = 10;
}
