package com.demo.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页qo
 */
@Data
public class PageRequestQo implements Serializable {
    private static final long serialVersionUID = -3253329528916466752L;

    private Integer page;

    private Integer size;

    public Integer getPage() {
        return page != null ? page : 1; // 如果 page 为 null，则返回默认值 1
    }
    public Integer getSize() {
        return size != null ? size : 10; // 如果 size 为 null，则返回默认值 10
    }
}
