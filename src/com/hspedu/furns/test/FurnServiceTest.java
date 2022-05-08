package com.hspedu.furns.test;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public class FurnServiceTest {

    private FurnService furnService = new FurnServiceImpl();
    @Test
    public void queryFurns(){
        List<Furn> furns = furnService.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }
    @Test
    public void add(){
        BigDecimal bigDecimal = new BigDecimal(180.00);
        String defaultImgPath = "assets/images/product-image/6.jpg";
       Furn furn1 = new Furn(null, "test!", "test", bigDecimal, 2, 23, defaultImgPath);
       furnService.addFurn(furn1);
    }
}