package com.hspedu.furns.dao.impl;

import com.hspedu.furns.dao.BasicDao;
import com.hspedu.furns.dao.FurnDAO;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;
import org.junit.jupiter.api.Test;

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

    @Override
    public int addFurn(Furn furn) {
        String sql = "INSERT INTO `furn`(`id`,`name`,`maker`,`price`,`sales`,`stock`,`img_path`) VALUES(NULL,?,?,?,?,?,?)";
        return update(sql,furn.getName(),furn.getMaker(),furn.getPrice(),furn.getSales(),furn.getStock(),furn.getImg_path());
    }

    @Override
    public int deleteFurn(int id) {
        String sql = "DELETE FROM `furn` WHERE `id` = ?";
        if (queryFurnById(id)!=null){
            return update(sql,id);
        }else{
            return -1;
        }
    }

    @Override
    public int updateFurn(Furn furn) {
        String sql = "UPDATE furn SET `name` = ? , `maker` = ? , `price`= ? , `sales` = ? , `stock` = ?, `img_path` = ?  " +
                " WHERE id = ?; ";
        return update(sql, furn.getName(), furn.getMaker(), furn.getPrice(), furn.getSales(), furn.getStock(),furn.getImg_path(),furn.getId());
    }

    @Override
    public int getTotalRow() {
        String sql = "SELECT Count(*) FROM `furn`";
//        return (Integer) queryScalar(sql); castError
        return ((Number)queryScalar(sql)).intValue();
    }

    @Override
    public List<Furn> getPageItems(int begin,int pageSize) {
        String sql = "SELECT `id`,`name`,`maker`,`price`,`sales`,`stock`,`img_path` FROM furn LIMIT ? , ?";
        return queryMuti(sql,Furn.class,begin,pageSize);
    }

    @Override
    public int getPageTotalRowByName(String name) {
        String sql = "SELECT Count(*) FROM `furn`" +
                " where `name` LIKE ?";
        return ((Number)queryScalar(sql,"%" + name + "%")).intValue();
    }

    @Override
    public List<Furn> getPageItemsByName(int begin,int pageSize,String name) {
        String sql = "SELECT `id`,`name`,`maker`,`price`,`sales`,`stock`,`img_path` FROM furn where `name` LIKE ? LIMIT ?,?";
        return queryMuti(sql,Furn.class,"%" + name + "%",begin,pageSize);
    }



}
