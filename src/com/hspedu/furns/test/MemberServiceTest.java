package com.hspedu.furns.test;

import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @author 金宗文
 * @version 1.0
 */
public class MemberServiceTest {
    private MemberService memberService = new MemberServiceImpl();
    @Test
    public void isExistsUsername(){
        if (memberService.isExistsMember("admin")){
            System.out.println("用户名存在");
        }else{
            System.out.println("用户名不存在");
        }
    }
    @Test
    public  void registerMember(){
        Member member = new Member(null, "mary", "mary", "mary@soouhu.com");
        if (memberService.registerMember(member)){
            System.out.println("注册用户成功");
        }else {
            System.out.println("注册用户失败");
        }
    }
}
