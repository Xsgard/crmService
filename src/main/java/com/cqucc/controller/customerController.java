package com.cqucc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqucc.pojo.Customer;
import com.cqucc.service.customerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

    @PostMapping("/add")
    public Map<String, Object> add(Customer customer) {
        Map<String, Object> map = new HashMap<>();
        List<Customer> list = customerService.findCusByName(customer.getCusName());
        if (null != list && list.size() > 0) {
            map.put("msg", "该用户名称已存在！");
        } else {
            //如果没有，插入数据
            Boolean flag = customerService.add(customer);
            if (flag) {//flag位TRUE
                map.put("msg", "添加成功");
            } else {
                map.put("msg", "添加失败");
            }
        }
        return map;
    }

    @PostMapping("/deleteByIds")
    public Map<String, Object> deleteByIds(Integer[] cusIds) {
        Map<String, Object> map = new HashMap<>();
        Boolean flag = customerService.deleteByIds(Arrays.asList(cusIds));

        if (flag) {
            map.put("msg", "删除成功");
        } else {
            map.put("msg", "删除失败");
        }

        return map;
    }
}
