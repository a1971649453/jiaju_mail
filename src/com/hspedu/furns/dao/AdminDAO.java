package com.hspedu.furns.dao;

import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.entity.Member;

/**
 * @author 金宗文
 * @version 1.0
 */
public interface AdminDAO {
    //通过用户名和密码来查询
    public Admin queryMemberByUsernameAndPassword(String username, String password);
}
