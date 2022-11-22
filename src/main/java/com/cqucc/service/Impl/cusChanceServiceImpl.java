package com.cqucc.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqucc.dao.cusChanceDao;
import com.cqucc.pojo.CusChance;
import com.cqucc.service.cusChanceService;
import org.springframework.stereotype.Service;

@Service
public class cusChanceServiceImpl extends ServiceImpl<cusChanceDao, CusChance> implements cusChanceService {
    /**
     * 销售机会分页
     * @param page
     * @param limit
     * @return
     */
    @Override
    public IPage<CusChance> getOnePage(Integer page, Integer limit) {
        Page<CusChance> cusChancePage=new Page<>(page,limit);
        LambdaQueryWrapper<CusChance> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(CusChance::getScCreatetime);
        this.page(cusChancePage,queryWrapper);

        return cusChancePage;
    }
}
