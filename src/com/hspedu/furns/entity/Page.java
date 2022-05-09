package com.hspedu.furns.entity;

import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public class Page<T> {
    //因为每页显示多少条记录 是其他地方也可能使用
    public static final Integer PAGE_SIZE = 3;
    //分页的各个信息
    //1.分页的大小 2.分页的数字(第几页)3.要显示的集合
    private Integer pageNo;
    private Integer pageSize = PAGE_SIZE ;
    //表示共有多少页  从DB来  在DAO层
    private Integer pageTotalCount;
    //表示有多少条记录 从DB来 在DAO层
    private Integer totalRow;
    private List<Furn> items;

    //分页导航
    private String url;


    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageTotalCount, Integer totalRow, List<Furn> items, String url) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        this.totalRow = totalRow;
        this.items = items;
        this.url = url;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public List<Furn> getItems() {
        return items;
    }

    public void setItems(List<Furn> items) {
        this.items = items;
    }


}
