package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 利润表
 * Created by lx on 2017/11/11.
 */
public class BalanceProfit implements Serializable {

    private Long fid;
    private String fproject;
    private int frow_num;
    private BigDecimal last_year_actual;
    private BigDecimal last_year_total;
    private BigDecimal this_year_budget;
    private BigDecimal this_year_budget_total;
    private BigDecimal this_year_actual;
    private BigDecimal this_year_actual_total;
    private Long fhead_id;
    private int frow_index;
    private int fstrong;


    public BalanceProfit() {
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFproject() {
        return fproject;
    }

    public void setFproject(String fproject) {
        this.fproject = fproject;
    }

    public int getFrow_num() {
        return frow_num;
    }

    public void setFrow_num(int frow_num) {
        this.frow_num = frow_num;
    }

    public BigDecimal getLast_year_actual() {
        return last_year_actual;
    }

    public void setLast_year_actual(BigDecimal last_year_actual) {
        this.last_year_actual = last_year_actual;
    }

    public BigDecimal getLast_year_total() {
        return last_year_total;
    }

    public void setLast_year_total(BigDecimal last_year_total) {
        this.last_year_total = last_year_total;
    }

    public BigDecimal getThis_year_budget() {
        return this_year_budget;
    }

    public void setThis_year_budget(BigDecimal this_year_budget) {
        this.this_year_budget = this_year_budget;
    }

    public BigDecimal getThis_year_budget_total() {
        return this_year_budget_total;
    }

    public void setThis_year_budget_total(BigDecimal this_year_budget_total) {
        this.this_year_budget_total = this_year_budget_total;
    }

    public BigDecimal getThis_year_actual() {
        return this_year_actual;
    }

    public void setThis_year_actual(BigDecimal this_year_actual) {
        this.this_year_actual = this_year_actual;
    }

    public BigDecimal getThis_year_actual_total() {
        return this_year_actual_total;
    }

    public void setThis_year_actual_total(BigDecimal this_year_actual_total) {
        this.this_year_actual_total = this_year_actual_total;
    }

    public Long getFhead_id() {
        return fhead_id;
    }

    public void setFhead_id(Long fhead_id) {
        this.fhead_id = fhead_id;
    }

    public int getFrow_index() {
        return frow_index;
    }

    public void setFrow_index(int frow_index) {
        this.frow_index = frow_index;
    }

    public int getFstrong() {
        return fstrong;
    }

    public void setFstrong(int fstrong) {
        this.fstrong = fstrong;
    }
}
