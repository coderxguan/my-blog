package com.guanhf.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 功能: 文章控制器
 * 作者:
 * 日期:2024/09/24 16:34
 */
@RestController
public class ArticleController {

    @GetMapping("/api/articles")
    public List<Article> getArticles() {
        return Arrays.asList(
                new Article(1, "第一篇文章", "这是第一篇文章的摘要", "2024-09-24"),
                new Article(2, "第二篇文章", "这是第二篇文章的摘要", "2024-09-25"),
                new Article(3, "第三篇文章", "这是第三篇文章的摘要", "2024-09-26")
        );
    }

    @AllArgsConstructor
    @NoArgsConstructor // 添加无参构造函数
    @Getter // 使用Lombok生成getter方法
    @Setter // 使用Lombok生成setter方法
    public static class Article {
        private int id;
        private String title;
        private String summary;
        private String date;
    }
}
