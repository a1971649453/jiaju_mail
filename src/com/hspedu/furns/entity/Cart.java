package com.hspedu.furns.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Set;

/**
 * 购物车 包涵多个CartItems
 * @author 金宗文
 * @version 1.0
 */
public class Cart {
    //包涵多个CartItem
    private HashMap<Integer,CartItem> items = new HashMap<>();

    public Integer getTotalCount() {
        //遍历items 统计 totalCount
        int  totalCount = 0;
        Set<Integer> keys = items.keySet();
        for (Integer id : keys) {
                totalCount += items.get(id).getCount();
        }
        return totalCount;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }

    //添加家居到Cart方法
    public void addItem(CartItem cartItem){
        CartItem item = items.get(cartItem.getId());
        if (item == null) {//当前购物车没有此商品
            items.put(cartItem.getId(),cartItem);
        }else {//购物车有 增加数量
            item.setCount(item.getCount() + 1);
            //修改总价  报错? BigDecimal * Integer 需要用multiply 以下两种方式都可以
//            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
            item.setTotalPrice(item.getTotalPrice().add(item.getPrice()));

        }

    }
}
