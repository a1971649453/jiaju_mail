package com.hspedu.furns.dao;

import com.hspedu.furns.entity.OrderItem;

import java.util.List;

/**
 * 表示一个订单项
 * @author 金宗文
 * @version 1.0
 */
public interface OrderItemDAO {

    /**
     * 将orderItem对象保存到表中
     * @param orderItem
     * @return
     */
    public int saveOrderItem(OrderItem orderItem);


    public List<OrderItem> listOrderItem(String member_id);
}
