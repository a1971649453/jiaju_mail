package com.hspedu.furns.web; /**
 * @author 金宗文
 * @version 1.0
 */

import com.hspedu.furns.entity.OrderItem;
import com.hspedu.furns.service.OrderItemService;
import com.hspedu.furns.service.impl.OrderItemServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "OrderItemServlet", value = "/OrderItemServlet")
public class OrderItemServlet extends BasicServlet {
    private OrderItemService orderItemService = new OrderItemServiceImpl();

    public void listOrderItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.得到前端传入的订单号
        int OrderItemTotalCount = 0;
        BigDecimal OrderItemTotalPrice = new BigDecimal(0);
        String order_id = request.getParameter("order_id");
        //2.根据订单号返回相应的item集合
        List<OrderItem> orderItems = orderItemService.listOrderItem(order_id);
        //3.得到总价 和总个数
        for (OrderItem orderItem : orderItems) {
            OrderItemTotalCount += orderItem.getCount();
            OrderItemTotalPrice = OrderItemTotalPrice.add(orderItem.getTotalPrice());

        }
        //将总价和总个数放到request域
        request.getSession().setAttribute("orderItems", orderItems);
        request.setAttribute("OrderItemTotalCount",OrderItemTotalCount);
        request.setAttribute("OrderItemTotalPrice",OrderItemTotalPrice);
        //转发到details
        request.getRequestDispatcher("views/order/order_detail.jsp").forward(request, response);
//        response.sendRedirect(request.getContextPath() + "/views/order/order_detail.jsp");
    }
}
