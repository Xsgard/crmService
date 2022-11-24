package com.cqucc.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqucc.common.R;
import com.cqucc.pojo.Services;
import com.cqucc.service.ServicesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
@Slf4j
public class ServicesController {
    @Autowired
    private ServicesService service;

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
        service.page(pageInfo);

        return R.success(pageInfo);
    }
    @PostMapping("/update")
    public R<String> update(Services service){

        return null;
    }

    /**
     * 根据id删除分类
     * @param id
     * @return
     */
    @DeleteMapping
    @Transactional
    public R<String> delete(Long id){

        service.remove(id);
        return R.success("删除成功！");
    }

}
