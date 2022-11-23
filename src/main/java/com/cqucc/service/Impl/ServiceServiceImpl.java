package com.cqucc.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqucc.dao.ServicesDao;
import com.cqucc.pojo.Service;
import com.cqucc.service.ServiceService;

@org.springframework.stereotype.Service
public class ServiceServiceImpl extends ServiceImpl<ServicesDao, Service> implements ServiceService {

    /**
     * 根据id删除分类，删除之前需要进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {
        //正常删除分类
        super.removeById(id);

    }
}
