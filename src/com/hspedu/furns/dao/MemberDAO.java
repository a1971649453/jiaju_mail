package com.hspedu.furns.dao;

import com.hspedu.furns.entity.Member;

/**
 * @author 金宗文
 * @version 1.0
 */
public interface MemberDAO {
    //自己分析需要哪些方法
    //提供通过用户名 返回对应的Member
    public Member queryMemberByUsername(String username);

    //提供一个保存Member到Member表的方法
    public int saveMember(Member member);

    //通过用户名和密码来查询
    public Member queryMemberByUsernameAndPassword(String username, String password);

}
