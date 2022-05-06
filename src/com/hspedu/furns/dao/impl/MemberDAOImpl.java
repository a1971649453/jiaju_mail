package com.hspedu.furns.dao.impl;

import com.hspedu.furns.dao.BasicDao;
import com.hspedu.furns.dao.MemberDAO;
import com.hspedu.furns.entity.Member;

/**
 * @author 金宗文
 * @version 1.0
 */
public class MemberDAOImpl extends BasicDao<Member> implements MemberDAO{

    /**
     * 通过用户名返回对应的Member
     * @param username
     * @return 对应的Member 如果没有返回null
     */
    @Override
    public Member queryMemberByUsername(String username) {
        //sql先测试 再放入
        String sql = "SELECT `id`,`username`,`password`,`email` FROM `member` \n" +
                "  WHERE `username` = ?";
        return  querySingle(sql, Member.class, username);
    }

    /**
     * 保存一个会员
     * @param member 传入member对象
     * @return -1失败 其他数字为受影响的行数
     */
    @Override
    public int saveMember(Member member) {
        String sql = " INSERT INTO `member`(`username`,`password`,`email`) VALUES(?,MD5(?),?)";
        return update(sql,member.getUsername(),member.getPassword(),member.getEmail());
    }

    @Override
    public Member queryMemberByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `id`,`username`,`password`,`email` FROM `member` " +
                " WHERE `username` = ? and `password` = MD5(?)";
        return querySingle(sql,Member.class,username,password);
    }
}
