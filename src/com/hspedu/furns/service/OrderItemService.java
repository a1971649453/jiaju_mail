package com.hspedu.furns.service;

import com.hspedu.furns.entity.OrderItem;

import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public interface OrderItemService {
    public void saveOrderItem(OrderItem orderItem);

    public List<OrderItem> listOrderItem(String order_id);
}
