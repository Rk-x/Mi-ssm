package com.rk.service.impl;

import com.rk.mapper.ProductTypeMapper;
import com.rk.pojo.ProductType;
import com.rk.pojo.ProductTypeExample;
import com.rk.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    ProductTypeMapper productTypeMapper;
    @Override
    public List<ProductType> getAll() {
        List<ProductType> list = productTypeMapper.selectByExample(new ProductTypeExample());
        return list;
    }
}
