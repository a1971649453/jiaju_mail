package com.hspedu.furns.service;

import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.entity.Order;

import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public interface OrderService {

    //订单是根据购物车来生成的
    //cart对象在session 通过web层 传入saveOrder
    // 订单是和一个会员关联
    public String saveOrder(Cart cart,int member_id);


    public List<Order> showOrder();
}
