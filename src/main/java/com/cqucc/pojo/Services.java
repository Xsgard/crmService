package com.cqucc.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@TableName(value="t_services")
@Data
public class Services {
   private Integer serId;
   private Integer serType;
   private String serDescription;
   private Integer cusId;
   private Integer setCreater;
   private Integer serHandle;
   private String serHandleperson;
   private String serNote;
   private Integer serSatisfy;
   private LocalDateTime serTime;
   private String serDetail;
   private Integer serStatus;

   //将前端传入的日期字符串转换为Datetime类型
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   //把Datetime类型格式化为指定的字符串格式，传输到前端
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
   @TableField(value = "ser_createtime")
   private LocalDateTime serCreatetime;
   //将前端传入的日期字符串转换为Datetime类型
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   //把Datetime类型格式化为指定的字符串格式，传输到前端
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
   @TableField(value = "res_givetime")
   private LocalDateTime serGivetime;
   //将前端传入的日期字符串转换为Datetime类型
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   //把Datetime类型格式化为指定的字符串格式，传输到前端
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
   @TableField(value = "ser_handletime")
   private LocalDateTime serHandletime;




}
