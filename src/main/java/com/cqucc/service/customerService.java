package com.cqucc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqucc.pojo.Customer;

public interface customerService extends IService<Customer> {

    IPage<Customer> getOnePage(Integer page, Integer limit);

    Boolean update(Customer customer);
}
