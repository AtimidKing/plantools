package com.king.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by king on 2017/7/25.
 */
public class Plan {
    private BigInteger id;//计划编号
    private String title;//标题
    private String detail;//描述
    private LocalDate date;//日期
    private int status;//状态(0:未开始,1:进行中,2:已完成)

    public Plan(){}

    public Plan(BigInteger id, String title, LocalDate date, int status) {
        setId(id);
        setTitle(title);
        setDate(date);
        setStatus(status);
    }
    public Plan(BigInteger id, String title,String detail, LocalDate date, int status) {
        setId(id);
        setTitle(title);
        setDetail(detail);
        setDate(date);
        setStatus(status);
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 指定Plan对象的部分参数
     */
    public void stuffDateAndStatus() {
        this.setDate(LocalDate.now());
        this.setStatus(0);
    }

}
