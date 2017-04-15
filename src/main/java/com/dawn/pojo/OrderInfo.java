package com.dawn.pojo;

import java.util.Date;

public class OrderInfo {
    private String orderno;

    private String ordertime;

    private Date itime;

    private String expressno;

    private Integer currentstep;

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime == null ? null : ordertime.trim();
    }

    public Date getItime() {
        return itime;
    }

    public void setItime(Date itime) {
        this.itime = itime;
    }

    public String getExpressno() {
        return expressno;
    }

    public void setExpressno(String expressno) {
        this.expressno = expressno == null ? null : expressno.trim();
    }

    public Integer getCurrentstep() {
        return currentstep;
    }

    public void setCurrentstep(Integer currentstep) {
        this.currentstep = currentstep;
    }
}