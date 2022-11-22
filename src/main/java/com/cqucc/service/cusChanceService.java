package com.cqucc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqucc.pojo.CusChance;

public interface cusChanceService extends IService<CusChance> {
    IPage<CusChance> getOnePage(Integer page,Integer limit);
}
