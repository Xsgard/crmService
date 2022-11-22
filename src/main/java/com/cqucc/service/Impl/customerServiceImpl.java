package com.cqucc.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqucc.dao.customerDao;
import com.cqucc.pojo.Customer;
import com.cqucc.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customerServiceImpl extends ServiceImpl<customerDao, Customer> implements customerService {

    @Autowired
    private customerDao customerDao;

    public IPage<Customer> getOnePage(Integer page, Integer limit) {
        Page<Customer> customerPage = new Page<>(page, limit);
        LambdaQueryWrapper<Customer> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Customer::getCusId);
        this.page(customerPage, queryWrapper);
        return customerPage;
    }
}
