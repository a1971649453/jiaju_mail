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
    //Todo 考虑分页
    public List<Furn> queryFurns();

    //5.添加家居

    /**
     * 传入的furn对象保存到DB
     * @param furn
     * @return
     */
    public int addFurn(Furn furn);

    //6.删除家居

    /**
     * 根据传入的id 删除家居
     * @param id
     * @return
     */
    public int deleteFurn(int id);
    
}
