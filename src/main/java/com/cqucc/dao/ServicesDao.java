package com.cqucc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqucc.pojo.Service;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ServicesDao extends BaseMapper<Service> {
}
