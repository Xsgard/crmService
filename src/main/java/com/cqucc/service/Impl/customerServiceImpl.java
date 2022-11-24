package com.cqucc.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqucc.dao.customerDao;
import com.cqucc.pojo.Customer;
import com.cqucc.pojo.Report;
import com.cqucc.service.customerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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

    /**
     * 修改客户信息
     *
     * @param customer
     * @return
     */
    @Override
    public Boolean update(Customer customer) {
        boolean b = this.updateById(customer);
        return b;
    }

    @Override
    public boolean add(Customer customer) {
        boolean flag = this.save(customer);
        return flag;
    }

    @Override
    public List<Customer> findCusByName(String cusName) {
        LambdaQueryWrapper<Customer> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Customer::getCusName,cusName);
        List<Customer> list = this.list(queryWrapper);
        return list;
    }

    @Override
    public Boolean deleteByIds(List<Integer> cusIds) {
        int row = customerDao.deleteBatchIds(cusIds);
        return row==cusIds.size();
    }

    @Override
    public List<Report> getCusNumByCusRegion() {
        List<Report> reports = customerDao.countRegion();
        return reports;
    }


}
