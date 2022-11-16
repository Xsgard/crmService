package com.cqucc.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqucc.dao.customerDao;
import com.cqucc.pojo.Customer;
import com.cqucc.service.customerService;
import org.springframework.stereotype.Service;

@Service
public class customerServiceImpl extends ServiceImpl<customerDao, Customer> implements customerService {
}
