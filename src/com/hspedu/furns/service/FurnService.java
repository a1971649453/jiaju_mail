package com.hspedu.furns.service;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;

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

    /**
     * 修改家居
     * @param id
     * @return
     */
    public int updateFurn(Furn furn);


    /**
     * 根据id返回单个家居信息
     * @param id
     * @return
     */
    public Furn queryFurnById(int id);


    public Page<Furn> page(int pageNo, int pageSize);



}
