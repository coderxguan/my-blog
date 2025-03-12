package com.guanhf.entity;



import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tag")
public class Tag {
    private Integer id;

    private String name;
}
