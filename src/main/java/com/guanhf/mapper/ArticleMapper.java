package com.guanhf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guanhf.entity.Article;
import com.guanhf.entity.ArticleTag;
import com.guanhf.entity.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
