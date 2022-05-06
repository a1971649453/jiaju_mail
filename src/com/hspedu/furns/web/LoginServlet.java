//package com.hspedu.furns.web; /**
// * @author 金宗文
// * @version 1.0
// * 用户登录的Servlet 判断用户名和密码都相等
// */
//
//import com.hspedu.furns.dao.MemberDAO;
//import com.hspedu.furns.entity.Member;
//import com.hspedu.furns.service.MemberService;
//import com.hspedu.furns.service.impl.MemberServiceImpl;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//
//@WebServlet(name = "LoginServlet", value = "/loginServlet")
//public class LoginServlet extends HttpServlet {
//    private MemberService memberService = new MemberServiceImpl();
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request,response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("loginServlet被调用");
//        //1.得到username 和 password
//        String username = request.getParameter("user-name");
//        String password = request.getParameter("user-password");
////        System.out.println(username +" :" +  password);
////        //2.调用login方法
////        if (memberService.login(username,password)){//如果验证成功
////            System.out.println("登录成功");
////        }else{
////            System.out.println("登录失败");
////            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
////        }
//        Member member = memberService.login(new Member(null, username, password, null));
//        if (member!=null){
//            System.out.println(member + " 登录成功");
//            request.getRequestDispatcher("/views/member/login_ok.html").forward(request,response);
//        }else{
//            System.out.println(member + " 登录失败");
//            request.setAttribute("msg","用户账号或密码错误");
//            request.setAttribute("username", username);
//            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
//        }
//    }
//}
