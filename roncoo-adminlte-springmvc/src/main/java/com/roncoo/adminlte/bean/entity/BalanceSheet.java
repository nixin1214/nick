package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 资产负债
 * Created by lx on 2017/11/11.
 */
public class BalanceSheet implements Serializable {

    private Long fid;
    private String fproject;
    private int frow_num;
    private BigDecimal period_end_account;
    private BigDecimal period_begin_account;
    private String fproject2;
    private int frow_num2;
    private BigDecimal period_end_account2;
    private BigDecimal period_begin_account2;
    private Long fhead_id;
    private int frow_index;

    public BalanceSheet() {
    }

    public BalanceSheet(Long fid, String fproject, int frow_num, BigDecimal period_end_account, BigDecimal period_begin_account, String fproject2, int frow_num2, BigDecimal period_end_account2, BigDecimal period_begin_account2, Long fhead_id, int frow_index) {
        this.fid = fid;
        this.fproject = fproject;
        this.frow_num = frow_num;
        this.period_end_account = period_end_account;
        this.period_begin_account = period_begin_account;
        this.fproject2 = fproject2;
        this.frow_num2 = frow_num2;
        this.period_end_account2 = period_end_account2;
        this.period_begin_account2 = period_begin_account2;
        this.fhead_id = fhead_id;
        this.frow_index = frow_index;
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

    public BigDecimal getPeriod_end_account() {
        return period_end_account;
    }

    public void setPeriod_end_account(BigDecimal period_end_account) {
        this.period_end_account = period_end_account;
    }

    public BigDecimal getPeriod_begin_account() {
        return period_begin_account;
    }

    public void setPeriod_begin_account(BigDecimal period_begin_account) {
        this.period_begin_account = period_begin_account;
    }

    public String getFproject2() {
        return fproject2;
    }

    public void setFproject2(String fproject2) {
        this.fproject2 = fproject2;
    }

    public int getFrow_num2() {
        return frow_num2;
    }

    public void setFrow_num2(int frow_num2) {
        this.frow_num2 = frow_num2;
    }

    public BigDecimal getPeriod_end_account2() {
        return period_end_account2;
    }

    public void setPeriod_end_account2(BigDecimal period_end_account2) {
        this.period_end_account2 = period_end_account2;
    }

    public BigDecimal getPeriod_begin_account2() {
        return period_begin_account2;
    }

    public void setPeriod_begin_account2(BigDecimal period_begin_account2) {
        this.period_begin_account2 = period_begin_account2;
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
}
