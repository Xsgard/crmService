package com.cqucc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@TableName(value = "t_customer")//设置实体类和数据库表的映射关系
@Data
public class Customer {
    //设置实体类属性和数据库表的字段的映射关系
    //1.驼峰命名 字段cus_id -- 属性 cusId
    //2.使用注解映射  @TableField(value = "cus_id")
    //属性：修饰符 数据类型 属性名
    //数据库表的字段类型：varchar/char -实体类属性：String
    //                  int - Integer, datetime - LocalDateTime
    @TableId(value = "cus_id", type = IdType.AUTO)//主键id注解，value设置对应的字段名，type设置自动递增的方式
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

    //将前端传入的日期字符串转换为Datetime类型
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //把Datetime类型格式化为指定的字符串格式，传输到前端
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "cus_createtime")
    private LocalDateTime cusCreateTime;
}









