package com.dongying.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class RecordEntity {

    private Integer id;
    @Excel(name = "档案名", orderNum = "0")
    private String name;
    @Excel(name = "密级",replace = {"公开_0","绝密_1"},orderNum = "1")
    private Integer security;

    @Override
    public String toString() {
        return "RecordEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", security=" + security +
                ", date=" + date +
                '}';
    }

    @Excel(name = "时间",importFormat = "yyyy-MM-dd", orderNum = "2")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSecurity() {
        return security;
    }

    public void setSecurity(Integer security) {
        this.security = security;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}