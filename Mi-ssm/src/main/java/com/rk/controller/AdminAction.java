package com.rk.controller;

import com.rk.pojo.Admin;
import com.rk.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    //切记:在所有的界面侧，一定会有业务逻辑层的对象
    @Autowired
    AdminService adminService;

    //实现登录判断，并进行相应的跳转
    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request)
    {
        Admin admin = adminService.login(name, pwd);
        if(admin!=null)
        {
            request.setAttribute("admin",admin);
            return "main";
        }
        else {
            request.setAttribute("errmsg","用户名或密码错误");
            return "login";
        }
    }
}
