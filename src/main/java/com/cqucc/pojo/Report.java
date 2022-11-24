package com.cqucc.pojo;

import lombok.Data;

@Data
public class Report {
    //按地区查询客户数量 结果实体类
    //X轴数据
    private String item;
    //Y轴数据
    private Integer num;

}
