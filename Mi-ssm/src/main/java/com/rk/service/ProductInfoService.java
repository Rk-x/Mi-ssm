package com.rk.service;

import com.github.pagehelper.PageInfo;
import com.rk.pojo.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    //查询全部商品
    List<ProductInfo> getAll();

    //分页功能实现    返回值PageInfo   参数:当前页码   每页的条数
    PageInfo splitPage(int pageNum,int pageSize);

    //增加商品
    int save(ProductInfo info);

    //按主键id查询商品
    ProductInfo getByID(int pid);

    //更新商品
    int update(ProductInfo info);

    //单个商品删除
    int delete(int pid);

    int deleteBatch(String[] ids);
}
