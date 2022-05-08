package com.hspedu.furns.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author 金宗文
 * @version 1.0
 *
 */
public class DataUtils {
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static  int parseInt(String val,int defaultVal){
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            System.out.println(val + "格式不正确");
        }
        return defaultVal;
    }
}
