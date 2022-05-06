package com.hspedu.furns.service.impl;

import com.hspedu.furns.dao.AdminDAO;
import com.hspedu.furns.dao.impl.AdminDAOImpl;
import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.service.AdminService;

/**
 * @author 金宗文
 * @version 1.0
 */
public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO = new AdminDAOImpl();
    @Override
    public Admin login(Admin admin){
        return adminDAO.queryMemberByUsernameAndPassword(admin.getAdminName(),admin.getPassword());
    }
}
