package com.cqucc.pojo;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName(value="t_services")
@Data
public class Service {
   private Integer serId;
   private Integer serType;
   private String serDescription;
   private Integer cusId;
   private Integer setCreater;
   private Integer serHandle;
   private String serHandleperson;
   private String serNote;
   private Integer serSatisfy;
   private Integer serTime;
   private String serDetail;
   private Integer serStatus;

   @TableField(fill = FieldFill.INSERT) //创建时填充字段
   private LocalDateTime serCreatetime;

   @TableField(fill = FieldFill.INSERT)//提交时填充字段
   private LocalDateTime serGivetime;

   @TableField(fill = FieldFill.INSERT_UPDATE)//插入和更新时填充字段
   private LocalDateTime serHandletime;




}
