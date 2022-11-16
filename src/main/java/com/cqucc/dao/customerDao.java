package com.cqucc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqucc.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface customerDao extends BaseMapper<Customer> {
}
