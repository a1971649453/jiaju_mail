package com.hspedu.furns.test;

import com.hspedu.furns.dao.FurnDAO;
import com.hspedu.furns.dao.impl.FurnDAOImpl;
import com.hspedu.furns.entity.Furn;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public class FurnDAOTest {
    private FurnDAO furnDAO =new FurnDAOImpl();
    @Test
    public  void queryFurns(){
        List<Furn> furns = furnDAO.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }
}
