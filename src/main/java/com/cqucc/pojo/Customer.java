package com.cqucc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName(value = "t_customer")
@Data
public class Customer {
    //设置主键id注解
    @TableId(value = "cus_id", type = IdType.AUTO)
    private Integer cusId;

    private String cusName;

    private Integer cusRegion;

    private Integer cusIndustry;

    private String cusLevel;

    private Integer cusSatisfy;

    private Integer cusCredit;

    private String cusAddr;

    private Integer cusZipcode;

    private String cusPhone;

    private String cusFax;

    private String cusUrl;

    private Integer userId;

    private Integer cusStatus;

    private LocalDateTime cusCreateTime;


}









