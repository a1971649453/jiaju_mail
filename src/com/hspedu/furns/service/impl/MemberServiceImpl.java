package com.hspedu.furns.service.impl;

import com.hspedu.furns.dao.MemberDAO;
import com.hspedu.furns.dao.impl.MemberDAOImpl;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;

/**
 * @author 金宗文
 * @version 1.0
 */
public class MemberServiceImpl implements MemberService {
    //定义一个 MemberDAO属性
    private MemberDAO memberDAO = new MemberDAOImpl();

    /**
     * 注册用户
     * @param member
     * @return
     */
    @Override
    public boolean registerMember(Member member) {
        return memberDAO.saveMember(member) == 1;
    }

    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    @Override
    public boolean isExistsMember(String username) {
        return memberDAO.queryMemberByUsername(username) != null;

    }
}
