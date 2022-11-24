package com.cqucc.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.UpdateById;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqucc.common.R;
import com.cqucc.pojo.Services;
import com.cqucc.pojo.User;
import com.cqucc.service.ServicesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sun.security.jca.ServiceId;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/services")
@CrossOrigin
@RestController
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


    /**
     * 员工信息分页查询
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/page")
    public R<List> page(Integer page, Integer limit) {
        log.info("page = {},pageSize = {}", page, limit);
        //构造分页构造器
        Page pageInfo = new Page(page, limit);
        //执行查询
        service.page(pageInfo);

        return R.success(pageInfo.getRecords());
    }

    /**
     * 查询单个数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<Services> getById(@PathVariable Integer id) {
         LambdaQueryWrapper<Services> queryWrapper = new LambdaQueryWrapper<>();
         queryWrapper.eq(Services::getSerId,id);
         Services services = service.getOne(queryWrapper);
         return R.success(services);
    }

    /**
     * 修改页面
     * @param services
     * @return
     */
    @PutMapping
    @Transactional
    public R<String> update(@RequestBody Services services) {
        LambdaQueryWrapper<Services> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Services::getSerId, services.getSerId());
        service.remove(queryWrapper);

        service.save(services);
        return R.success("修改成功！");
    }

    /**
     * 根据id删除分类
     *
     * @param serId
     * @return
     */
    @GetMapping("/delete")
    @Transactional
    public R<String> delete(Integer serId) {
        service.remove(serId);
        return R.success("删除成功！");
    }

}
