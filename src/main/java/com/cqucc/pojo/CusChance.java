package com.cqucc.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName(value = "t_sale_chance")//设置实体类和数据库表的映射关系
@Data
public class CusChance {

    private Integer scId;
    //客户名称
    private String scCusname;
    //机会来源（0促销、1广告、2搜索引擎、3线上咨询、4电话咨询、5邮件咨询、6客户介绍）
    private Integer scComming;
    //联系人
    private String scName;
    //联系电话
    private String scPhone;
    //成功几率(%)
    private String scSuccess;
    //概要
    private String scMessage;
    //机会描述
    private String scDesc;
    //创建人
    private Integer scCreateuserid;
    //创建时间
    private LocalDateTime scCreatetime;
    //指派给谁
    private Integer scGiveuserid;
    //指派时间
    private LocalDateTime scGivetime;
    //状态（0未分配、1已分配、2开发成功、3开发失败、4开发中）
    private Integer scStatus;

}
