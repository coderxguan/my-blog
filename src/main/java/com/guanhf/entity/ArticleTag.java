package com.guanhf.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("article_tag")
public class ArticleTag {
    private Long articleId; // 对应article.id

    private Integer tagId; // 对应tag.id
}
