package com.hspedu.furns.filter; /**

 * @author 金宗文
 * @version 1.0
 */

import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.entity.Member;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 用于权限验证的过滤器 对指定的url进行验证
 * 如果登陆过就放行 如果没有登录 就回到登录页面
 */
public class AuthFilter implements Filter {
    //将我们要排除的url放入excludeUrls
    private List<String> excludedUrls;
    public void init(FilterConfig config) throws ServletException {
        String strExcludedUrls = config.getInitParameter("excludeUrls");
        String[] splitUrl = strExcludedUrls.split(",");

        //常用类
        excludedUrls = Arrays.asList(splitUrl);
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //得到请求的url
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //请求的url
        String url = req.getServletPath();


        //判断是否要验证
        if (!excludedUrls.contains(url)) {


            //得到session中的session 对象
            Member member = (Member) req.getSession().getAttribute("member");
            Admin admin = (Admin) req.getSession().getAttribute("Admin");
            if (member == null && admin == null) {//该用户没有登录 转发到登录页面
            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
                //注意 转发并不会走过滤器
//                resp.sendRedirect(req.getContextPath() + "/views/member/login.jsp");
                return;
            }
        }
        chain.doFilter(request, response);

    }
}
