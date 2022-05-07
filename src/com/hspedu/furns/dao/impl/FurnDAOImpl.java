package com.hspedu.furns.dao.impl;

import com.hspedu.furns.dao.BasicDao;
import com.hspedu.furns.dao.FurnDAO;
import com.hspedu.furns.entity.Furn;

import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public class FurnDAOImpl extends BasicDao<Furn> implements FurnDAO {

    @Override
    public Furn queryFurnById(int id) {
        String sql = "SELECT `id`,`name`,`maker`,`price`,`sales`,`stock`,`img_path` FROM furn WHERE id =?";
        return querySingle(sql,Furn.class,id);
    }

    @Override
    public Furn queryFurnByName(String name) {
        String sql = "SELECT `id`,`name`,`maker`,`price`,`sales`,`stock`,`img_path` FROM furn WHERE `name` =?";
        return querySingle(sql,Furn.class,name);
    }

    @Override
    public List<Furn> queryFurnByMaker(String maker) {
        String sql = "SELECT `id`,`name`,`maker`,`price`,`sales`,`stock`,`img_path` FROM furn WHERE `maker` =?";
        return queryMuti(sql,Furn.class,maker);
    }

    @Override
    public List<Furn> queryFurns() {
        String sql = "SELECT `id`,`name`,`maker`,`price`,`sales`,`stock`,`img_path` FROM furn";
        return queryMuti(sql,Furn.class);
    }
}
