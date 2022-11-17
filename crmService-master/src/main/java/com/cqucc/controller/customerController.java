package com.cqucc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqucc.pojo.Customer;
import com.cqucc.service.customerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@Slf4j
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


    public Map<String ,Object> getCustomers(Integer page, Integer limit){
        HashMap<String,Object> map=new HashMap<>();

        IPage<Customer> onePage = customerService.getOnePage(page, limit);

        return map;
    }
}
