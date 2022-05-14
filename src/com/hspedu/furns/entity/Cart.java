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

    public HashMap<Integer, CartItem> getItems() {
        return items;
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

    //删除家居到Cart方法
    public void deleteItem(CartItem cartItem){
        CartItem item = items.get(cartItem.getId());
        if (item != null){
            items.remove(cartItem.getId());
        }
    }

    //清空家居
    public void clear(){
        items.clear();
    }

    /**
     * 根据传入的id和count 修改指定的CartItem
     * @param id
     * @param count
     */
    public void updateCount(int id,int count){
        CartItem item = items.get(id);
        if (item != null){
            //先更新数量再更新总价
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }


    /**
     * 返回购物车所有的价格
     * @return
     */
    public BigDecimal getCartTotalPrice() {
        BigDecimal cartTotalPrice = new BigDecimal(0);
        //遍历items
        Set<Integer> keys = items.keySet();
        for (Integer id : keys) {
            CartItem item = items.get(id);
            //一定要把add后的值 重新赋值给cartTotalPrice
            cartTotalPrice = cartTotalPrice.add(item.getTotalPrice());
        }

        return  cartTotalPrice;
    }


}
