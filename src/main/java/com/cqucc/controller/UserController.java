package com.cqucc.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cqucc.common.R;
import com.cqucc.pojo.Sort;
import com.cqucc.pojo.User;
import com.cqucc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 员工登录
     *
     * @param request
     * @param user
     * @return
     */
    @PostMapping("/login")
    public R<User> login(HttpServletRequest request, @RequestBody User user) {

        //1、提交密码
        String password = user.getUPassword();
        //2、根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUName, user.getUName());
        User emp = userService.getOne(queryWrapper);

        //3、如果没有查询到则返回登录失败结果
        if (emp == null) {
            return R.error("登录失败");
        }

        //4、密码比对，如果不一致则返回登录失败结果
        if (!emp.getUPassword().equals(password)) {
            return R.error("登录失败");
        }

        //6、登录成功，将员工id存入Session并返回登录成功结果
//        request.getSession().setAttribute("employee", emp.getId());
        return R.success(emp);
    }

    @GetMapping("/getIdAndName")
    public List<Sort> getIdAndName() {
        List<Sort> idAndName = userService.getIdAndName();
        return idAndName;
    }

}

