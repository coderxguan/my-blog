package com.guanhf.controller.admin;

import com.guanhf.DTO.CategoryDTO;
import com.guanhf.entity.Category;
import com.guanhf.result.Result;
import com.guanhf.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/27 17:47
 */
@RestController
@RequestMapping("/api/admin/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //获取所有分类
    @GetMapping
    public Result<List<Category>> getCategory() {
        List<Category> categories = categoryService.getCategory();
        log.info(categories.toString());
        return Result.success(categories);
    }

    //根据ID删除分类
    @DeleteMapping("/{id}")
    public Result deleteCategory(@PathVariable Integer id) {
        if(categoryService.deleteCategory(id)) {
            return Result.success();
        }
        else{
            return Result.error("删除失败");
        }
    }

    // 添加分类
    @PostMapping
    public Result addCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        boolean isAdd = categoryService.addCategory(category);
        // 添加成功, 返回添加的分类
        if(isAdd){
            return Result.success(category);
        }
        else{
            return Result.error("当前分类已存在");
        }
    }

    // 编辑分类
    @PutMapping("/{id}")
    public Result updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(id);
        category.setName(categoryDTO.getName());
        if(categoryService.updateCategory(category)) {
            return Result.success();
        }
        else {
            return Result.error("修改失败, 当前分类名已存在!");
        }
    }


}
