package com.rk.service;

import com.github.pagehelper.PageInfo;
import com.rk.pojo.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    //查询全部商品
    List<ProductInfo> getAll();

    //分页功能实现    返回值PageInfo   参数:当前页码   每页的条数
    PageInfo splitPage(int pageNum,int pageSize);

    int save(ProductInfo info);
}
