package com.hspedu.furns.service;

import com.hspedu.furns.entity.Member;

/**
 * @author 金宗文
 * @version 1.0
 */
public interface MemberService {

    //注册用户
    public boolean registerMember(Member member);


    //判断用户名是否存在
    public boolean isExistsMember(String username);

    //判断用户是否存在密码和用户名
    public boolean login(String username,String password);

    public Member login(Member member);
}
