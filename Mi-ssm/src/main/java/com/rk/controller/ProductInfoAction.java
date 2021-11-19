package com.rk.controller;
import com.github.pagehelper.PageInfo;
import com.rk.pojo.ProductInfo;
import com.rk.service.ProductInfoService;
import com.rk.service.impl.ProductInfoServiceImpl;
import com.rk.utils.FileNameUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.reflect.misc.FieldUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/prod")
public class ProductInfoAction {
    //每页显示的记录数
    public static final int PAGE_SIZE=5;

    @Autowired
    ProductInfoService productInfoService;

    //异步上传的图片的名称
    String saveFilename="";

    //显示全部商品
    @RequestMapping("/getAll")
    public  String getAll(HttpServletRequest request){
        List<ProductInfo> list = productInfoService.getAll();
        request.setAttribute("list",list);
        return "product";
    }

    //显示第一页商品
    @RequestMapping("/split")
    public String split(HttpServletRequest request){
        //得到第一页的数据
        PageInfo info=productInfoService.splitPage(1,PAGE_SIZE);
        request.setAttribute("info",info);
        return "product";
    }

    //ajax分页，翻页处理
    @ResponseBody
    @RequestMapping("/ajaxsplit")
    public void ajaxSplit(int page, HttpSession session)
    {
        //获取当前page参数的页面的数据
        PageInfo info=productInfoService.splitPage(page,PAGE_SIZE);
        session.setAttribute("info",info);
    }

    //异步ajax文件上传处理
    @ResponseBody
    @RequestMapping("/ajaxImg")
    public Object ajaxImg(MultipartFile pimage,HttpServletRequest request){

        //上传图片  存储图片

        //提取生成文件名UUID+上传图片的后缀.jpg   .png   getFileType()传入图片的名称，自动截取后缀
        saveFilename=FileNameUtil.getUUIDFileName()+ FileNameUtil.getFileType(pimage.getOriginalFilename());
        //获取图片要存储的路径
        String path = request.getServletContext().getRealPath("/image_big");
        //转存    路径+/+文件名    比如:E:\Mi-ssm\Image_big\slgjhakl234algjlajg.jpg
        try {
            pimage.transferTo(new File(path+File.separator+saveFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(path);
        System.out.println(saveFilename);
        //回显图片  返回客户端JSON对象，封装图片的路径，为了在页面实现立即回显
        JSONObject object=new JSONObject();
        object.put("imgurl",saveFilename);//imgurl保存图片名称

        return object.toString();
    }

    @RequestMapping("/save")
    public String save(ProductInfo info,HttpServletRequest request){
        info.setpImage(saveFilename);
        info.setpDate(new Date());
        //info对象中有表单提交上来的数据 还差pImage  Date
        int num=-1;
        try {
            num=productInfoService.save(info);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(num>0)
        {
            request.setAttribute("msg","添加成功");
        }else{
            request.setAttribute("msg","添加失败");
        }
        //增加成功会后，应该重新访问数据库，所以跳转到分页显示的action上
        return "forward:/prod/split.action";
    }
}
