package com.hspedu.furns.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 金宗文
 * @version 1.0
 *
 */
public abstract class BasicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码 必须到这里处理 因为request域是携带到这里的
        req.setCharacterEncoding("utf-8");
//        System.out.println("basic的dopost方法");
        String action = req.getParameter("action");
//        System.out.println(action);
        //使用反射获取当前
        //this重点 没有想到 getDeclaredMethod得到所有方法 包括private
        //体会:使用模板模式 + 反射 + 动态机制 简化多个if else if
        //action 和value值需要已知
        try {
            Method declaredMethod =
                    this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
                    declaredMethod.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
