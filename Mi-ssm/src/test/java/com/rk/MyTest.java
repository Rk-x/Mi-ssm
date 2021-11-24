package com.rk;

import com.rk.mapper.ProductInfoMapper;
import com.rk.pojo.ProductInfo;
import com.rk.pojo.vo.ProductInfoVo;
import com.rk.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_dao.xml","classpath:applicationContext_service.xml"})
public class MyTest {
    @Test
    public void testMd5(){
        String md5 = MD5Util.getMD5("000000");
        System.out.println(md5);
    }


    @Autowired
    ProductInfoMapper mapper;

    @Test
    public void testSelectConditon(){
        //测试查询商品名称里包含4，商品类型为3，价格在3000-10000的
        ProductInfoVo vo=new ProductInfoVo();
        vo.setPname("4");
        vo.setTypeid(3);
        vo.setLprice((double) 3000);
        vo.setHprice((double) 10000);
        List<ProductInfo> list = mapper.selectCondition(vo);
        for (ProductInfo productInfo : list) {
            System.out.println(productInfo);
        }
    }

}
