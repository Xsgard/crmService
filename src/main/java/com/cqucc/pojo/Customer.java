package com.cqucc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    //将前端传入的日期字符串转换为DateTime格式
    @DateTimeFormat(pattern = "yyyy-MM--dd HH:mm:ss")
    //DateTime类型数据格式化为指定的字符串格式
    @JsonFormat(pattern = "yyyy-MM--dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "cus_createtime")
    private LocalDateTime cusCreateTime;


}









