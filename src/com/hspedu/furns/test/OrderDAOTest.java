package com.hspedu.furns.test;

import com.hspedu.furns.dao.OrderDAO;
import com.hspedu.furns.dao.impl.OrderDAOImpl;
import com.hspedu.furns.entity.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public class OrderDAOTest {
    private OrderDAO orderDAO = new OrderDAOImpl();

    @Test
    public void testSaveOrder(){
        Order order = new Order("sn0002", new Date(), new BigDecimal(200), 0, 2);
        System.out.println(orderDAO.saveOrder(order));
    }

    @Test
    public void testQueryOrder(){
        List<Order> orders = orderDAO.showOrder();
        System.out.println(orders);
    }
}
