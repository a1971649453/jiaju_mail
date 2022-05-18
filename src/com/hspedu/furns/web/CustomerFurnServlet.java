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
        request.getRequestDispatcher("views/customer/index.jsp").forward(request,response);
    }

    public void pageByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        //把null与"" 业务逻辑合并在一起
        if (name == null){
            name = "";
        }
        //1.获取pageNo 2.获取pageSize 3.获取name 4.调用方法返回对象 5.放入request域中
        int pageNo = DataUtils.parseInt(request.getParameter("pageNo"),1);
        int pageSize = DataUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Furn> page = furnService.pageByName(pageNo,pageSize,name);
        //根据名字构建url  自己做的时候没有想到 如何把name加上 解决方法为 将整个URL独立出来 然后是否添加
        StringBuilder url = new StringBuilder("CustomerFurnServlet?action=pageByName");
        if (!"".equals(name)){
            url.append("&name=").append(name);
        }
        page.setUrl(url.toString());
        request.setAttribute("page",page);
        //如何收到对象后 如何展示分页导航
        request.getRequestDispatcher("views/customer/index.jsp").forward(request,response);
    }

}
