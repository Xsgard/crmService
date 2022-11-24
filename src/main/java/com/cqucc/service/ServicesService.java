package com.cqucc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqucc.pojo.Services;

import javax.xml.ws.Service;

public interface ServicesService extends IService<Services> {
    public void remove(Integer serId);
}
