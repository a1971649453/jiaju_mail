package com.hspedu.furns.entity;

import java.math.BigDecimal;

/**
 * @author 金宗文
 * @version 1.0
 */
public class Furn {
    private Integer id;//为什么必须Integer 因为防止空指针 Integer可以放Null
    private String name;
    private String maker;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private String img_path;//如果不一样 需要将mysql语句 加上AS  将两者保持一致

    public Furn() {
    }

    public Furn(Integer id, String name, String maker, BigDecimal price, Integer sales, Integer stock, String img_path) {
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        //表字段 和Bean属性不同如何解决?
        this.img_path = img_path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    @Override
    public String toString() {
        return "Furn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maker='" + maker + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
