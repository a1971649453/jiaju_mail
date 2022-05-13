package com.hspedu.furns.test;

import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.entity.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author 金宗文
 * @version 1.0
 */
public class CartTest {
    private Cart cart = new Cart();
    @Test
    public void addItem(){
        cart.addItem(new CartItem(1,"沙发",13,new BigDecimal(10),new BigDecimal(130)));
        cart.addItem(new CartItem(2,"小椅子",13,new BigDecimal(10),new BigDecimal(130)));
        System.out.println(cart);

    }
}
