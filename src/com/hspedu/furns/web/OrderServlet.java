package com.hspedu.furns.web; /**
 * @author 金宗文
 * @version 1.0
 */

import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.entity.Order;
import com.hspedu.furns.service.OrderService;
import com.hspedu.furns.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends BasicServlet {
    private OrderService orderService = new OrderServiceImpl();
    public void saveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //业务代码 生成订单
        //1.获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //如果cart为空 会员没有购买任何家具 转发到首页面
        if (null == cart || cart.isEmpty()){
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return;
        }
        //2.获取member对象
        Member member = (Member) request.getSession().getAttribute("member");
        if (null == member){
            //该用户没有登录 就转发到登录页面
            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
            return;
        }

        //3.生成订单
        String orderId = orderService.saveOrder(cart, member.getId());
        request.getSession().setAttribute("orderId",orderId);
        //3.获取到
        //返回到checkOut
        //使用重定向
        response.sendRedirect(request.getContextPath() + "/views/order/checkout.jsp");
    }

    public void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        //判断用户是否为空
        //获取member对象
        Member member = (Member) request.getSession().getAttribute("member");
        if (null == member){
            //该用户没有登录 就转发到登录页面
            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
            return;
        }

        //查询数据库中的订单表
        List<Order> orders = orderService.showOrder();
        request.getSession().setAttribute("orders",orders);
        //转发到显示订单页

        response.sendRedirect(request.getContextPath() + "/views/order/order.jsp");

    }

}
