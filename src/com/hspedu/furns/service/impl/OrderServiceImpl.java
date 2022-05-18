package com.hspedu.furns.service.impl;

import com.hspedu.furns.dao.FurnDAO;
import com.hspedu.furns.dao.OrderDAO;
import com.hspedu.furns.dao.OrderItemDAO;
import com.hspedu.furns.dao.impl.FurnDAOImpl;
import com.hspedu.furns.dao.impl.OrderDAOImpl;
import com.hspedu.furns.dao.impl.OrderItemDAOImpl;
import com.hspedu.furns.entity.*;
import com.hspedu.furns.service.OrderService;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author 金宗文
 * @version 1.0
 */
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private FurnDAO furnDAO = new FurnDAOImpl();

    /**
     *
     * @param cart
     * @param member_id
     * @return
     */
    @Override
    public String saveOrder(Cart cart, int member_id) {
        //将cart购物车数据保存到 表

        //TODO 生成订单会操作多表 因此会涉及到多表事务问题 ThreadLocal + mysql + 过滤器

        //先通过cart构建对应的order对象
        //先生成uuid 对应唯一的cartId也就是订单号
        String orderId = System.currentTimeMillis() + "" + member_id;
        Order order = new Order(orderId, new Date(), cart.getCartTotalPrice(), 0, member_id);
        //保存到order表
        orderDAO.saveOrder(order);

        //通过cart对象 遍历出CartItem 构建OrderItem对象 保存到orderItem表
//        HashMap<Integer, CartItem> items = cart.getItems();
//        Set<Integer> keys = items.keySet();
//        for (Integer id : keys) {
//            CartItem item = items.get(id);
//            //通过cartItem 构建 orderItem对象
//            OrderItem orderItem = new OrderItem(null, item.getName(), item.getPrice(), item.getCount(), item.getTotalPrice(), orderId);
//            //保存
//            orderItemDAO.saveOrderItem(orderItem);
//
//
//            //更新furn表 数量的更新 1.得到对象
//            Furn furn = furnDAO.queryFurnById(id);
//            //更新
//            furn.setSales(furn.getSales() + item.getCount());
//            furn.setStock(furn.getStock() - item.getCount());
//            ///更新数据到表
//            furnDAO.updateFurn(furn);
//
//        }
        //通过entrySet方式 取出cart
        for (Map.Entry<Integer,CartItem> entry : cart.getItems().entrySet()) {
            CartItem item = entry.getValue();
            //通过cartItem 构建 orderItem对象
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getPrice(), item.getCount(), item.getTotalPrice(), orderId);
            //保存
            orderItemDAO.saveOrderItem(orderItem);


            //更新furn表 数量的更新 1.得到对象
            Furn furn = furnDAO.queryFurnById(item.getId());
            //更新
            furn.setSales(furn.getSales() + item.getCount());
            furn.setStock(furn.getStock() - item.getCount());
            ///更新数据到表
            furnDAO.updateFurn(furn);

        }
        //清空购物车
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showOrder() {
        return orderDAO.showOrder();
    }
}
