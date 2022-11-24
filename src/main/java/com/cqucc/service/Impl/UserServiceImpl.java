package com.cqucc.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqucc.dao.UserDao;
import com.cqucc.pojo.User;
import com.cqucc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getIdAndName() {
        List<User> idAndName = userDao.getIdAndName();
        return idAndName;
    }
}
