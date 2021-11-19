package com.rk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rk.mapper.ProductInfoMapper;
import com.rk.pojo.ProductInfo;
import com.rk.pojo.ProductInfoExample;
import com.rk.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductInfoMapper productInfoMapper;
    @Override
    public List<ProductInfo> getAll() {
        List<ProductInfo> productInfos = productInfoMapper.selectByExample(new ProductInfoExample());
        return productInfos;
    }

    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        if(pageNum==0)
            pageNum=1;

        //使用分页插件的pageHelper工具类完成分页设置
        PageHelper.startPage(pageNum,pageSize);

        //进行PageInfo的数据封装
        //进行有条件的查询操作，进行条件添加
        ProductInfoExample example=new ProductInfoExample();
        //设置排序，降序排序
        example.setOrderByClause("p_id desc");
        //设置完排序后，获取当前页码的商品信息List<ProductInfo>
        List<ProductInfo> list = productInfoMapper.selectByExample(example);
        //将List<ProductInfo>放入到PageInfo对象中 此时pageinfo对象的其他数据会自动生成
        PageInfo<ProductInfo> pageInfo=new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public int save(ProductInfo info) {
        return productInfoMapper.insert(info);
    }

}