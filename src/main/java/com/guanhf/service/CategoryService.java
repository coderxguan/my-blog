package com.guanhf.service;

import com.guanhf.entity.Category;

import java.util.List;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/27 17:59
 */
public interface CategoryService {
    // 返回所有分类
    List<Category> getCategory();

    // 根据ID删除分类
    boolean deleteCategory(Integer id);

    // 添加分类
    boolean addCategory(Category category);

    // 编辑
    boolean updateCategory(Category category);
}
