package com.hspedu.furns.service.impl;

import com.hspedu.furns.dao.OrderItemDAO;
import com.hspedu.furns.dao.impl.OrderItemDAOImpl;
import com.hspedu.furns.entity.OrderItem;
import com.hspedu.furns.service.OrderItemService;

import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    @Override
    public void saveOrderItem(OrderItem orderItem) {
        orderItemDAO.saveOrderItem(orderItem);
    }

    @Override
    public List<OrderItem> listOrderItem(String order_id) {
        return  orderItemDAO.listOrderItem(order_id);

    }
}
