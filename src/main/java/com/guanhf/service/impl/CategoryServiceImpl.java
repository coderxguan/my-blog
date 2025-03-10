package com.guanhf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.guanhf.entity.Category;
import com.guanhf.mapper.CategoryMapper;
import com.guanhf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/27 18:00
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    // 获取所有分类
    @Override
    public List<Category> getCategory() {
        return categoryMapper.selectList(null);
    }

    // 根据ID删除分类
    @Override
    public boolean deleteCategory(Integer id) {
        int result = categoryMapper.deleteById(id);
        return result > 0;
    }

    // 添加分类
    @Override
    public boolean addCategory(Category category) {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Category::getName, category.getName());
        if(categoryMapper.selectCount(wrapper) > 0){
            return false;
        }
        categoryMapper.insert(category);
        return true;
    }

    // 更新分类
    @Override
    public boolean updateCategory(Category category) {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Category::getName, category.getName())
                        .ne(Category::getId, category.getId());
        if(categoryMapper.selectCount(wrapper) > 0){
            return false;
        }

        categoryMapper.updateById(category);
        return true;
    }
}
