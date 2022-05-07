package com.hspedu.furns.web; /**
 * @author 金宗文
 * @version 1.0
 */

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.AdminService;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.AdminServiceImpl;
import com.hspedu.furns.service.impl.FurnServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FurnServlet", value = "/manage/FurnServlet")
public class FurnServlet extends BasicServlet {
    private FurnService furnService =new FurnServiceImpl();

    /**
     * 模板设计模式 + 反射 + 动态绑定
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Furn> furns = furnService.queryFurns();
        request.setAttribute("furns",furns);
       request.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(request,response);
    }
}
