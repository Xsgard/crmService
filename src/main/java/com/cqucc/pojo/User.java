package com.cqucc.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value="t_user")
@Data
public class User {
   private Integer uId;
   private String uName;
   private String uPassword;
   private Integer rId;
}
