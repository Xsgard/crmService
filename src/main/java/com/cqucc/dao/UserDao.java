package com.cqucc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqucc.pojo.Sort;
import com.cqucc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<User> {

    @Select("select u_id,u_name from t_user;")
    List<Sort> getIdAndName();
}
