package com.guanhf.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("category")
public class Category {
    private Integer id;

    private String name;

    private Integer parentId; // 父分类ID
}
