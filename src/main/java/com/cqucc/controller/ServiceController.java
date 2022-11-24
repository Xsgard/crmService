package com.cqucc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqucc.common.R;
import com.cqucc.pojo.Services;
import com.cqucc.service.ServicesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/services")
@CrossOrigin
@Slf4j
public class ServiceController {
    @Autowired
    private ServicesService service;

    @PostMapping("/add")
    public R<String> add(Services services) {
        //设置客户id
        services.setCusId(1);
        //设置创建时间
        services.setSerCreatetime(LocalDateTime.now());
        //设置创建人
        services.setSerCreater(1);

        service.save(services);

        return R.success("添加成功");
    }

    @GetMapping("/page")
    public R<Page> page(Integer page, Integer limit){
        log.info("page = {},pageSize = {},name = {}" ,page,limit);
        //构造分页构造器
        Page pageInfo = new Page(page,limit);
        //执行查询
        service.page(pageInfo);

        return R.success(pageInfo);
    }
}
