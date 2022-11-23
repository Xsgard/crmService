package com.cqucc.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value="t_user")
@Data
public class User {
    @TableId(value = "u_id")
    private Integer id;
    @TableField(value = "u_name")
    private String name;
    @TableField(value = "u_password")
    private String password;

    private Integer r_id;
}
