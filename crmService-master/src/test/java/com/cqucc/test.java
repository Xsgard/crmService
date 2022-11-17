package com.cqucc;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqucc.pojo.Customer;
import com.cqucc.service.customerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class test {

    @Test
    void contextLoads() {
    }


    @Autowired
    customerService customerService;
    @Test
    void test(){
        IPage<Customer> onePage = customerService.getOnePage(1, 4);
        long total = onePage.getTotal();//查询到的记录总条数
        System.out.println("=======总记录数======"+total);
    }
}
