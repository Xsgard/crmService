package com.cqucc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_contact")
public class Contact {
    @TableId(value = "con_id",type = IdType.AUTO)
    private Integer conId;
    //联系人名字
    private String conName;
    //联系人性别
    private String conSex;
    //联系人职位
    private String conJob;
    //办公电话
    private String conTel;
    //联系人手机号
    private String conPhone;
    //备注
    private String conNote;
    //客户编号
    private Integer cusId;
}
