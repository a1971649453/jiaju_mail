package com.hspedu.furns.test;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import org.junit.jupiter.api.Test;

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
}
