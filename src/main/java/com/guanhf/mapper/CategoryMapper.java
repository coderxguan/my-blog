package com.guanhf.mapper;

import com.guanhf.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    // 查询所有分类
    @Select("select * from category")
    List<Category> getCategory();

    // 根据ID删除分类
    @Delete("delete from category where id = #{id}")
    int deleteCategoryById(Integer id);

    // 添加分类
    void addCategory(Category category);

    // 查询分类是否存在
    @Select("select count(*) > 0 from category where name = #{name}")
    boolean isExist(String name);

    // 编辑分类
    void updateCategory(Category category);

    // 查询是否要修改成其他已经存在的分类
    @Select("select count(*) > 0 from category where name = #{name} and id != #{id}")
    boolean isExistID(int id, String name);
}
