package com.hspedu.furns.dao;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;

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

    /**
     * 修改家居信息
     * @param furn
     * @return
     */
    public int updateFurn(Furn furn);

    //获取总的行数
    public int getTotalRow();

    // 获取当前页要显示的数据
    public List<Furn> getPageItems(int begin, int pageSize);

    /**
     * 根据名字搜索出总的记录数
     * @param name
     */
    public int getPageTotalRowByName(String name);

    /**
     * 根据搜索名字得到
     * @param name
     */
    public List<Furn> getPageItemsByName(int begin, int pageSize,String name);

}
