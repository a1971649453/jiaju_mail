package com.hspedu.furns.dao.impl;



import com.hspedu.furns.dao.BasicDao;
import com.hspedu.furns.dao.OrderDAO;
import com.hspedu.furns.entity.Order;

import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public class OrderDAOImpl extends BasicDao<Order> implements OrderDAO {
    @Override
    public int saveOrder(Order order) {
        String sql="INSERT INTO `order`(`id`,`create_time`,`price`,`status`,`member_id`) \n" +
                "VALUES(?,?,?,?,?)  ";
        return update(sql,order.getId(),order.getCreate_time(),order.getPrice(),order.getStatus(),order.getMemberId());
    }

    @Override
    public List<Order> showOrder() {
        String sql="SELECT `id`,`create_time`,`price`,`status`,`member_id` as memberId\n" +
                "FROM `order`";
        return queryMuti(sql, Order.class);
    }


}
