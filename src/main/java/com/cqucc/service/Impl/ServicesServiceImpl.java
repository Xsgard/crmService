package com.cqucc.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqucc.dao.ServicesDao;
import com.cqucc.pojo.Services;
import com.cqucc.service.ServicesService;

@org.springframework.stereotype.Service
public class ServicesServiceImpl extends ServiceImpl<ServicesDao, Services> implements ServicesService {

    /**
     * 根据id删除分类，删除之前需要进行判断
     *
     * @param serId
     */
    @Override
    public void remove(Integer serId) {
        LambdaQueryWrapper<Services> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Services::getSerId, serId);
        this.remove(queryWrapper);
        //正常删除分类


    }


}
