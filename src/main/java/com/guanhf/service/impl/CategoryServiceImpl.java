package com.guanhf.service.impl;

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
        return categoryMapper.getCategory();
    }

    // 根据ID删除分类
    @Override
    public boolean deleteCategory(Integer id) {
        int result = categoryMapper.deleteCategoryById(id);
        return result > 0;
    }

    // 添加分类
    @Override
    public boolean addCategory(Category category) {
        if(categoryMapper.isExist(category.getName()))
            return false;
        categoryMapper.addCategory(category);
        return true;
    }

    @Override
    public boolean updateCategory(Category category) {
        if(categoryMapper.isExistID(category.getId(), category.getName())){
            return false;
        }
        categoryMapper.updateCategory(category);
        return true;

    }
}
