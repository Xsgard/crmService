package com.cqucc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqucc.pojo.Contact;

public interface ContactService extends IService<Contact> {
    IPage<Contact>  getOnePage(Integer page, Integer limit, Integer cusId);
}
