package com.guanhf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guanhf.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
