package com.cqucc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqucc.pojo.CusChance;
import com.cqucc.service.cusChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cusChance")
@CrossOrigin
public class cusChanceController {
    @Autowired
    private cusChanceService cusChanceService;

    @RequestMapping("/getCusChance")
    public Map<String, Object> getCusChance(Integer page, Integer limit) {
        //创建map对象，用来返回给前端
        HashMap<String, Object> map = new HashMap<>();
        //customerService调用分页查询方法，获取到分页对象
        IPage<CusChance> onePage = cusChanceService.getOnePage(page, limit);
        //用map构造返回的json数据
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", onePage.getTotal());//getTotal()获取查询的onePage中的总记录数
        map.put("data", onePage.getRecords());//getRecords()获取分页记录列表
        return map;
    }
}
