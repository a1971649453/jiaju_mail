package com.hspedu.furns.test;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr;
import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.entity.CartItem;
import com.hspedu.furns.service.OrderService;
import com.hspedu.furns.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author 金宗文
 * @version 1.0
 */
public class OrderServiceTest {
    private OrderService orderService = new OrderServiceImpl();
    @Test
    public void orderServiceTest(){
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"北欧风格沙发",2,new BigDecimal(200.00),new BigDecimal(400)));
        cart.addItem(new CartItem(2,"北欧风格沙发",2,new BigDecimal(200.00),new BigDecimal(400)));

        //验证三张表是否对的
        System.out.println(orderService.saveOrder(cart,1));
    }
}
