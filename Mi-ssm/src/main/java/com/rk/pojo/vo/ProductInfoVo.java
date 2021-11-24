package com.rk.pojo.vo;

//封装查询条件
public class ProductInfoVo {
    //商品名称
    private String pname;
    //商品类型
    private Integer typeid;
    //最低价格
    private Double lprice;
    //最高价格
    private Double hprice;

    //当前页码
    private Integer page=1;

    public ProductInfoVo() {
    }

    public ProductInfoVo(String pname, Integer typeid, Double lprice, Double hprice, Integer page) {
        this.pname = pname;
        this.typeid = typeid;
        this.lprice = lprice;
        this.hprice = hprice;
        this.page = page;
    }

    @Override
    public String toString() {
        return "ProductInfoVo{" +
                "pname='" + pname + '\'' +
                ", typeid=" + typeid +
                ", lprice=" + lprice +
                ", hprice=" + hprice +
                ", page=" + page +
                '}';
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Double getLprice() {
        return lprice;
    }

    public void setLprice(Double lprice) {
        this.lprice = lprice;
    }

    public Double getHprice() {
        return hprice;
    }

    public void setHprice(Double hprice) {
        this.hprice = hprice;
    }


}
