package com.hspedu.furns.web;

import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;

/**
 * @author 金宗文
 * @version 1.0
 */
public class MemberServlet1 extends BasicServlet{
    private MemberService memberService = new MemberServiceImpl();


}
