package com.cqucc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqucc.pojo.Customer;
import com.cqucc.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class customerController {
    @Autowired
    private customerService customerService;

    @GetMapping("/page")
    public IPage<Customer> page(Integer page, Integer limit) {
        page = 1;
        limit = 10;
        IPage<Customer> pageInfo = customerService.getOnePage(page, limit);
        return pageInfo;
    }
}
