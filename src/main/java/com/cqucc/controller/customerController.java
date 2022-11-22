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

    @RequestMapping("/getCustomers")
    public Map<String, Object> getCustomers(Integer page, Integer limit) {
        //创建map对象，用来返回给前端
        HashMap<String, Object> map = new HashMap<>();
        //customerService调用分页查询方法，获取到分页对象
        IPage<Customer> onePage = customerService.getOnePage(page, limit);
        //用map构造返回的json数据
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", onePage.getTotal());//getTotal()获取查询的onePage中的总记录数
        map.put("data", onePage.getRecords());//getRecords()获取分页记录列表
        return map;
    }

    /**
     * 修改客户信息
     *
     * @param customer
     * @return
     */
    @PostMapping("/update")
    public Map<String, Object> update(Customer customer) {
        Boolean flag = customerService.update(customer);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("msg", "修改成功");
        } else{
            map.put("msg", "修改失败");
        }
        return map;
    }
}
