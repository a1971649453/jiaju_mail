package com.hspedu.furns.dao.impl;

import com.hspedu.furns.dao.AdminDAO;
import com.hspedu.furns.dao.BasicDao;
import com.hspedu.furns.entity.Admin;

/**
 * @author 金宗文
 * @version 1.0
 */
public class AdminDAOImpl extends BasicDao<Admin> implements AdminDAO {

    @Override
    public Admin queryMemberByUsernameAndPassword(String adminName, String password) {
        String sql = "SELECT `adminName`,`password` FROM `admin` " +
                " WHERE adminName = ? and `password` = MD5(?)";
        return querySingle(sql,Admin.class,adminName,password);
    }

}
