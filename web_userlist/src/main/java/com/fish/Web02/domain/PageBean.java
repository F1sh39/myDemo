package com.fish.Web02.domain;

import java.util.List;

public class PageBean<T> {
    private int totalrows;
    private int totalpage;
    private List<T> datalist;
    private int rows;
    private int nowpage;

    @Override
    public String toString() {
        return "PageBean{" +
                "totalrows=" + totalrows +
                ", totalpage=" + totalpage +
                ", datalist=" + datalist +
                ", rows=" + rows +
                ", nowpage=" + nowpage +
                '}';
    }

    public int getTotalrows() {
        return totalrows;
    }

    public void setTotalrows(int totalrows) {
        this.totalrows = totalrows;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public List<T> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<T> datalist) {
        this.datalist = datalist;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getNowpage() {
        return nowpage;
    }

    public void setNowpage(int nowpage) {
        this.nowpage = nowpage;
    }
}
