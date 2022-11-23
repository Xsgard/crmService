package com.cqucc.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqucc.common.R;
import com.cqucc.pojo.Service;
import com.cqucc.service.ServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
@Slf4j
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    /**
     * 员工信息分页查询
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(Integer page, Integer limit){
        log.info("page = {},pageSize = {},name = {}" ,page,limit);
        //构造分页构造器
        Page pageInfo = new Page(page,limit);
        //执行查询
        serviceService.page(pageInfo);

        return R.success(pageInfo);
    }

}
