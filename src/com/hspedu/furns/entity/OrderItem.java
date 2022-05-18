package com.hspedu.furns.entity;

import java.math.BigDecimal;

/**
 * 订单相信信息表
 * @author 金宗文
 * @version 1.0
 */
public class OrderItem {
//    CREATE TABLE `order_item`(
//    id INT PRIMARY KEY AUTO_INCREMENT, -- 订单项的id
//`name` VARCHAR(64) NOT NULL, -- 家居名
//`price` DECIMAL(11,2) NOT NULL, -- 家居价格
//`count` INT NOT NULL, -- 数量
//`total_price` DECIMAL(11,2) NOT NULL, -- 订单项的总价
//`order_id` VARCHAR(64) NOT NULL -- 对应的订单号
//)CHARSET utf8 ENGINE INNODB

    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer count;
    private BigDecimal totalPrice;
    private String order_id;

    public OrderItem() {
    }

    public OrderItem(Integer id, String name, BigDecimal price, Integer count, BigDecimal totalPrice, String order_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.totalPrice = totalPrice;
        this.order_id = order_id;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                ", order_id='" + order_id + '\'' +
                '}';
    }
}
