package com.cqucc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqucc.pojo.Contact;
import com.cqucc.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/contact")
@CrossOrigin
public class contactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/getContacts")
    public Map<String,Object> getContacts(Integer page, Integer limit, Integer cusId){
        HashMap<String, Object> map = new HashMap<>();
        IPage<Contact> onePage = contactService.getOnePage(page, limit, cusId);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", onePage.getTotal());//getTotal()获取查询的onePage中的总记录数
        map.put("data", onePage.getRecords());//getRecords()获取分页记录列表

        return map;
    }
}
