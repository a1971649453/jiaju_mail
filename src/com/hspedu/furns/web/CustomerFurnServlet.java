package com.hspedu.furns.web; /**
 * @author 金宗文
 * @version 1.0
 */

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import com.hspedu.furns.utils.DataUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerFurnServlet", value = "/CustomerFurnServlet")
public class CustomerFurnServlet extends BasicServlet {
    private FurnServlet furnServlet = new FurnServlet();
    private FurnService furnService = new FurnServiceImpl();

    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        int pageNo = DataUtils.parseInt(request.getParameter("pageNo"),1);
        int pageSize = DataUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        //调用Service方法 获取Page对象
        Page<Furn> page = furnService.page(pageNo, pageSize);
        //转发给 list方法
        request.setAttribute("page",page);
        request.getRequestDispatcher("/customer/index.jsp").forward(request,response);
    }

}
