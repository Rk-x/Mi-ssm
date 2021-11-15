package com.rk.service.impl;
import com.rk.mapper.AdminMapper;
import com.rk.pojo.Admin;
import com.rk.pojo.AdminExample;
import com.rk.service.AdminService;
import com.rk.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    //在业务逻辑层中，一定有数据访问，访问层的对象
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {
        //根据传入的用户 或者到 db中查询相应的对象
        //如果有条件，则一定要创建 adminExample对象，用来封装条件
        AdminExample example = new AdminExample();
        /*
         * 如何添加条件
         * select * from admin where a_name = `admin`
         * */
        //添加用户名 a_name条件
        example.createCriteria().andANameEqualTo(name);
        List<Admin> list = adminMapper.selectByExample(example);
        if (list.size() > 0) {
            Admin admin = list.get(0);
            //如果查询到用户对象，在进行密码的比对，注意密码是密文

            String miPwd= MD5Util.getMD5(pwd);
            if (miPwd.equals(admin.getaPass())){
                return admin;
            }
        }
        return null;
    }
}