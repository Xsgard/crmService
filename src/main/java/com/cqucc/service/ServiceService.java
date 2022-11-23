package com.cqucc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqucc.pojo.Service;

public interface ServiceService extends IService<Service> {
    public void remove(Long id);
}
