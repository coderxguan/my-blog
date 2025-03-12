package com.guanhf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guanhf.entity.Category;
import com.guanhf.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
