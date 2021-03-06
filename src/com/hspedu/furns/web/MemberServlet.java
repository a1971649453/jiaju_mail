package com.hspedu.furns.web; /**
 * @author 金宗文
 * @version 1.0
 */

import com.google.gson.Gson;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@WebServlet(name = "MemberServlet", value = "/MemberServlet")
public class MemberServlet extends BasicServlet {
    private MemberService memberService = new MemberServiceImpl();
    Map<String, Object> resultMap = new HashMap<>();
    Gson gson = new Gson();


    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        if (member != null) {//该用户没有在DB
            HttpSession session = request.getSession();
            session.setAttribute("member",member);
//            System.out.println(member + " 登录成功");
            if ("jzwAdmin".equals(member.getUsername())){
                request.getRequestDispatcher("/views/manage/manage_menu.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("/views/member/login_ok.jsp").forward(request, response);
            }

        } else {
            System.out.println(member + " 登录失败");
            request.setAttribute("msg", "用户账号或密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
        }
    }


    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("user-email");
        //获取验证码
        String code = request.getParameter("code");
        //从session获取验证码
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //立即删除session中的验证码 防止重复提交
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //判断 如果一致
        if (token!=null && token.equalsIgnoreCase(code)) {
            //判断用户名是否可用
            if (!memberService.isExistsMember(username)) {
                //注册
//            System.out.println("用户名" + username + "可用");
                Member member = new Member(null, username, password, email);
                if (memberService.registerMember(member)) {
                    request.getRequestDispatcher("/views/member/register_ok.jsp").forward(request, response);
//                System.out.println("注册成功");
                } else {
                    request.getRequestDispatcher("/views/member/register_fail.jsp").forward(request, response);
//                System.out.println("注册失败");
                }
            } else {
//            返回注册页面
                System.out.println("用户名" + username + "不可用");
            }
        }else{//验证码不正确
            request.setAttribute("msg","验证码不正确");
            //带回显示到注册选项页
            request.setAttribute("active","register");
            request.setAttribute("username",username);
            request.setAttribute("email",email);
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
        }
    }

    public  void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    /**
     * 用于前端判断用户名是否存在
     */
    public void isExistsMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.得到 前端username
        String username = request.getParameter("username");
        boolean isExistsUsername = memberService.isExistsMember(username);
        // 拼接json 格式 可扩展
//        String resultJson = "{\"isExist\": "+ isExistsUsername + "}";
        //将要返回的数据放到map 再转到json
        resultMap.put("isExist",isExistsUsername);
        String resultJson = gson.toJson(resultMap);
        //返回
        response.getWriter().write(resultJson);
    }

    public void isCodeTure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.得到前端传入的code
        String code = request.getParameter("code");
        //2.得到后台验证码
        //从session获取验证码
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //3.判断
        if (code.equals(token)){
            resultMap.put("codeIsTure",true);
        }else {
            resultMap.put("codeIsTure",false);
        }
        String resultJson = gson.toJson(resultMap);
        //返回
        response.getWriter().write(resultJson);
    }
}
