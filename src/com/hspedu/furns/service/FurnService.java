package com.hspedu.furns.service;

import com.hspedu.furns.entity.Furn;

import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public interface FurnService {
    //查询家居

    /**
     * 返回家居信息
     * @return
     */
    public List<Furn> queryFurns();

    /**
     * 添加furn对象
     * @param furn
     */
    public int addFurn(Furn furn);

    /**
     * 删除家居
     * @return
     */
    public int deleteFurnById(int id);
}
