package com.cqucc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqucc.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> getIdAndName();
}
