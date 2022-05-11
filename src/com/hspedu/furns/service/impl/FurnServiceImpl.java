package com.hspedu.furns.service.impl;

import com.hspedu.furns.dao.FurnDAO;
import com.hspedu.furns.dao.impl.FurnDAOImpl;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;
import com.hspedu.furns.service.FurnService;

import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public class FurnServiceImpl implements FurnService {
    private FurnDAO furnDAO = new FurnDAOImpl();
    @Override
    public List<Furn> queryFurns() {
        return furnDAO.queryFurns();
    }

    @Override
    public int addFurn(Furn furn) {
        return furnDAO.addFurn(furn);
    }

    @Override
    public int deleteFurnById(int id) {
        return furnDAO.deleteFurn(id);
    }

    @Override
    public int updateFurn(Furn furn) {
        return furnDAO.updateFurn(furn);
    }

    @Override
    public Furn queryFurnById(int id){
        return  furnDAO.queryFurnById(id);
    }

    @Override
    public Page<Furn> page(int pageNo, int pageSize) {
        //先创建一个page对象 然后填充数据
        Page<Furn> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int totalRow = furnDAO.getTotalRow();
        page.setTotalRow(totalRow);
        //pageTotalCount 需要计算
        int pageTotalCount = totalRow / pageSize;
        if (totalRow % pageSize > 0){
            pageTotalCount += 1;
        }
        page.setPageTotalCount(pageTotalCount);
        //begin 如何计算
        // 隐藏一个坑
        int begin = (pageNo - 1) * pageSize;
        page.setItems(furnDAO.getPageItems(begin,pageSize));

        //TODO 还差一个URL
        return page;
    }

    @Override
    public Page<Furn> pageByName(int pageNo, int pageSize, String name) {
        Page<Furn> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int totalRow = furnDAO.getPageTotalRowByName(name);
        page.setTotalRow(totalRow);
        int pageTotalCount = totalRow / pageSize;
        if (totalRow % pageSize > 0){
            pageTotalCount += 1;
        }
        page.setPageTotalCount(pageTotalCount);
        int begin = (pageNo - 1) * pageSize;
        page.setItems(furnDAO.getPageItemsByName(begin,pageSize,name));
        return page;
    }


}
