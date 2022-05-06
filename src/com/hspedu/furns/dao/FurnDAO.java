package com.hspedu.furns.dao;

import com.hspedu.furns.entity.Furn;

import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public interface FurnDAO {
    //1.根据id查找家具
    public Furn queryFurnById(int id);
    //2.根据名字查找家具
    public Furn queryFurnByName(String name);
    //3.根据制造商返回家具集合
    public List<Furn> queryFurnByMaker(String maker);
    //4.管理家居 得到所有家居
    public List<Furn> queryAll();
}
