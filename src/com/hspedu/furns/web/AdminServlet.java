package com.hspedu.furns.web; /**
 * @author 金宗文
 * @version 1.0
 */

import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.AdminService;
import com.hspedu.furns.service.impl.AdminServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends BasicServlet {
    private AdminService adminService = new AdminServiceImpl();
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String adminName = request.getParameter("admin-name");
        String password = request.getParameter("admin-password");
        Admin admin = adminService.login(new Admin(null, adminName, password));
        if (admin!=null){
            //如果通过 是管理员
            request.getSession().setAttribute("Admin",admin);
            request.getRequestDispatcher("/views/manage/manage_menu.jsp").forward(request,response);
        }else{
            request.setAttribute("msg", "用户账号或密码错误");
            request.setAttribute("adminName", adminName);
            request.getRequestDispatcher("/views/manage/manage_login.jsp").forward(request,response);
        }
    }
}
