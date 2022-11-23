package com.cqucc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqucc.common.R;
import com.cqucc.pojo.Services;
import com.cqucc.service.ServicesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/services")
@CrossOrigin
@Slf4j
public class ServiceController {
    @Autowired
    private ServicesService service;

    @PostMapping("/add")
    public R<Services> add(Services services) {
        //设置客户id
        services.setCusId(1);
        //设置创建时间
        services.setSerCreatetime(LocalDateTime.now());
        //设置创建人
        services.setSetCreater(1);

        service.save(services);

        return null;
    }
}
