package com.hspedu.furns.dao;

import com.hspedu.furns.entity.Order;

import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public interface OrderDAO {


    public int saveOrder(Order order);

    public List<Order> showOrder();


}
