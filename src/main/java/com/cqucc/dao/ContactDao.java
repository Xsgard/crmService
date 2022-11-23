package com.cqucc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqucc.pojo.Contact;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactDao extends BaseMapper<Contact> {
}
