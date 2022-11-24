package com.cqucc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqucc.pojo.Customer;
import com.cqucc.pojo.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface customerDao extends BaseMapper<Customer> {

    @Select("select count(*) as num,cus_region as item\n" +
            "from t_customer group by cus_region;")
    List<Report> countRegion();

}
