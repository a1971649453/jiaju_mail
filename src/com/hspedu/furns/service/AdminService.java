package com.hspedu.furns.service;

import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.entity.Member;

/**
 * @author 金宗文
 * @version 1.0
 */
public interface AdminService {
    //判断用户是否存在密码和用户名
    public Admin login(Admin admin);
}
