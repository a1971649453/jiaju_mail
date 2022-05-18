package com.hspedu.furns.dao.impl;

import com.hspedu.furns.dao.BasicDao;
import com.hspedu.furns.dao.OrderItemDAO;
import com.hspedu.furns.entity.OrderItem;

import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public class OrderItemDAOImpl extends BasicDao<OrderItem> implements OrderItemDAO {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO `order_item`(`id`,`name`,`price`,`count`,`total_price`,`order_id`) \n" +
                "VALUES(?,?,?,?,?,?) ";
        return update(sql,null,orderItem.getName(),orderItem.getPrice(),orderItem.getCount(),orderItem.getTotalPrice(),orderItem.getOrder_id());
    }

    @Override
    public List<OrderItem> listOrderItem(String order_id) {
        String sql = "SELECT `id`,`name`,`price`,`count`,`total_price` as totalPrice,`order_id` FROM `order_item` WHERE `order_id` = ?";
        return queryMuti(sql,OrderItem.class,order_id);
    }
}
