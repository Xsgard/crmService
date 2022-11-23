package com.cqucc.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqucc.dao.ContactDao;
import com.cqucc.pojo.Contact;
import com.cqucc.pojo.Customer;
import com.cqucc.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl extends ServiceImpl<ContactDao, Contact> implements ContactService {
    @Autowired
    private ContactDao contactDao;

    /**
     * 分页查询某个客户的联系人信息
     *
     * @param page
     * @param limit
     * @return
     */
    public IPage<Contact> getOnePage(Integer page, Integer limit, Integer cusId) {
        //构造Page
        Page<Contact> contactPage = new Page<>(page, limit);
        //查询条件构造器
        LambdaQueryWrapper<Contact> queryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件
        queryWrapper.eq(Contact::getCusId, cusId);
        this.page(contactPage, queryWrapper);
        return contactPage;
    }
}
