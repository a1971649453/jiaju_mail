package com.hspedu.furns.test;

import java.util.HashMap;

/**
 * @author 金宗文
 * @version 1.0
 */
public class HashmapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1",1);

        objectObjectHashMap.clear();
        System.out.println(objectObjectHashMap);
        System.out.println();
        System.out.println(objectObjectHashMap.size() == 0);
    }
}
