package com.rk.listener;

import com.rk.pojo.ProductType;
import com.rk.service.ProductTypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class ProductTypeListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //手工从当前的spring容器中取出ProductTypeServiceImpl对象
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_*.xml");
        ProductTypeService productTypeService=(ProductTypeService)context.getBean("ProductTypeServiceImpl");
        List<ProductType> typelist=productTypeService.getAll();
        //放入全局应用的作用域中，共新增页面，修改页面，前台的查询功能提供全部商品分类
        servletContextEvent.getServletContext().setAttribute("typeList",typelist);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
