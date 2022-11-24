package com.cqucc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqucc.pojo.Customer;
import com.cqucc.pojo.Report;

import java.util.List;

public interface customerService extends IService<Customer> {

    IPage<Customer> getOnePage(Integer page, Integer limit);

    Boolean update(Customer customer);

    boolean add(Customer customer);

    List<Customer> findCusByName(String cusName);

    Boolean deleteByIds(List<Integer> cusIds);

    List<Report> getCusNumByCusRegion();
}
