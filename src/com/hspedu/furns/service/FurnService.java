package com.hspedu.furns.service;

import com.hspedu.furns.entity.Furn;

import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public interface FurnService {
    //查询家居
    public List<Furn> queryFurns();
}