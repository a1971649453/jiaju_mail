package com.hspedu.furns.test;

import com.hspedu.furns.dao.FurnDAO;
import com.hspedu.furns.dao.impl.FurnDAOImpl;
import com.hspedu.furns.entity.Furn;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public class FurnDAOTest {
    private FurnDAO furnDAO = new FurnDAOImpl();
    private Furn furn;

    @Test
    public void queryFurns() {
        List<Furn> furns = furnDAO.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }

    @Test
    public void addFurnsTest() {
        BigDecimal bigDecimal = new BigDecimal(180.00);
        String defaultImgPath = "assets/images/product-image/6.jpg";
        Furn furn1 = new Furn(null, "test", "test", bigDecimal, 2, 23, defaultImgPath);
        System.out.println(furnDAO.addFurn(furn1));
    }

    @Test
    public void deleteFurnTest() {
        furnDAO.deleteFurn(8);
    }

    @Test
    public void getTotalRow() {
        System.out.println(furnDAO.getTotalRow());
    }

    @Test
    public void getPageItems() {
        List<Furn> pageItems = furnDAO.getPageItems(0, 3);
        for (Furn pageItem : pageItems) {
            System.out.println(pageItem);
        }
    }

    @Test
    public void testQueryByName() {
        System.out.println(furnDAO.getPageTotalRowByName("小"));
    }


    @Test
    public void testGetPageItemsByName(){
        System.out.println(furnDAO.getPageItemsByName(1,2,"小"));
    }

}
