package com.hspedu.furns.web; /**
 * @author 金宗文
 * @version 1.0
 */

import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemberServlet", value = "/MemberServlet")
public class MemberServlet extends HttpServlet {
    private MemberService memberService = new MemberServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MemberServlet被调用");
        String action = request.getParameter("action");
        if (action.equals("login")){
            String username = request.getParameter("user-name");
            String password = request.getParameter("user-password");
//        System.out.println(username +" :" +  password);
//        //2.调用login方法
//        if (memberService.login(username,password)){//如果验证成功
//            System.out.println("登录成功");
//        }else{
//            System.out.println("登录失败");
//            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
//        }
            Member member = memberService.login(new Member(null, username, password, null));
            if (member!=null){
                System.out.println(member + " 登录成功");
                request.getRequestDispatcher("/views/member/login_ok.html").forward(request,response);
            }else{
                System.out.println(member + " 登录失败");
                request.setAttribute("msg","用户账号或密码错误");
                request.setAttribute("username", username);
                request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
            }
        }else if (action.equals("register")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("user-email");

            if(!memberService.isExistsMember(username)){
                //注册
//            System.out.println("用户名" + username + "可用");
                Member member = new Member(null, username, password, email);
                if (memberService.registerMember(member)){
                    request.getRequestDispatcher("/views/member/register_ok.html").forward(request,response);
//                System.out.println("注册成功");
                }else {
                    request.getRequestDispatcher("/views/member/register_fail.html").forward(request,response);
//                System.out.println("注册失败");
                }
            }else {
//            返回注册页面
                System.out.println("用户名" + username + "不可用");
            }
        }
    }
}
