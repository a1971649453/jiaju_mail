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
}
