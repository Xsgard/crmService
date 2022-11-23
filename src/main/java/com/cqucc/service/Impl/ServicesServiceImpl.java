package com.cqucc.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqucc.dao.ServicesDao;
import com.cqucc.pojo.Services;
import com.cqucc.service.ServicesService;
import org.springframework.stereotype.Service;

@Service
public class ServicesServiceImpl extends ServiceImpl<ServicesDao, Services> implements ServicesService {
}
