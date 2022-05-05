package com.hspedu.furns.test;

import com.hspedu.furns.dao.MemberDAO;
import com.hspedu.furns.dao.impl.MemberDAOImpl;
import com.hspedu.furns.entity.Member;
import org.junit.jupiter.api.Test;

/**
 * @author 金宗文
 * @version 1.0
 */
public class MemberDAOTest {
    private MemberDAO memberDAO = new MemberDAOImpl();
    @Test
    public void queryMemberByUsername(){

        if (memberDAO.queryMemberByUsername("admin")==null){
            System.out.println("用户名不存在");
        }else{
            System.out.println("用户名存在");
        }
    }
    @Test
    public  void saveMember(){
        Member member = new Member(null, "king", "king", "king@soouhu.com");
        if (memberDAO.saveMember(member)==1){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }
}
