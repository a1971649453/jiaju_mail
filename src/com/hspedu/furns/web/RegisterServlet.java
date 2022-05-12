//package com.hspedu.furns.web; /**
// * @author 金宗文
// * @version 1.0
// */
//
//import com.hspedu.furns.entity.Member;
//import com.hspedu.furns.service.MemberService;
//import com.hspedu.furns.service.impl.MemberServiceImpl;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//
//@WebServlet(name = "RegisterServlet", value = "/registerServlet")
//public class RegisterServlet extends HttpServlet {
//    //定义一个属性
//    private MemberService memberService = new MemberServiceImpl();
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request,response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //得到用户名 密码 和email
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String email = request.getParameter("user-email");
//
//        if(!memberService.isExistsMember(username)){
//            //注册
////            System.out.println("用户名" + username + "可用");
//            Member member = new Member(null, username, password, email);
//            if (memberService.registerMember(member)){
//                request.getRequestDispatcher("/views/member/register_ok.jsp").forward(request,response);
////                System.out.println("注册成功");
//            }else {
//                request.getRequestDispatcher("/views/member/register_fail.jsp").forward(request,response);
////                System.out.println("注册失败");
//            }
//        }else {
////            返回注册页面
//            System.out.println("用户名" + username + "不可用");
//        }
//    }
//}
