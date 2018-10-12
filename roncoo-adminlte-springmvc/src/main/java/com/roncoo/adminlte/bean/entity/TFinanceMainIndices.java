package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体：主要指标1
 */
public class TFinanceMainIndices implements Serializable {

    private Long fid;           //id
    private String fcategory;   //分类
    private String fproject;    //项目名称
    private Integer frow_index;//行次
    private BigDecimal fthis_period_budget;     //本期预算
    private BigDecimal fthis_period_last_year;  //本期上年
    private BigDecimal fthis_period_actual;     //本期实际
    private BigDecimal fcum_budget;     //累计预算
    private BigDecimal fcum_last_year;  //累计上年
    private BigDecimal fcum_actual;     //累计实际
    private Long fhead_id;          //父ID
    private int fsheet_row_index;   //sheet页行索引
    private int fis_strong;         //加粗行-是否加粗

    public TFinanceMainIndices(){

    }

    public TFinanceMainIndices(Long fid, String fcategory, String fproject, Integer frow_index, BigDecimal fthis_period_budget, BigDecimal fthis_period_last_year, BigDecimal fthis_period_actual, BigDecimal fcum_budget, BigDecimal fcum_last_year, BigDecimal fcum_actual, Long fhead_id, int fsheet_row_index, int fis_strong) {
        this.fid = fid;
        this.fcategory = fcategory;
        this.fproject = fproject;
        this.frow_index = frow_index;
        this.fthis_period_budget = fthis_period_budget;
        this.fthis_period_last_year = fthis_period_last_year;
        this.fthis_period_actual = fthis_period_actual;
        this.fcum_budget = fcum_budget;
        this.fcum_last_year = fcum_last_year;
        this.fcum_actual = fcum_actual;
        this.fhead_id = fhead_id;
        this.fsheet_row_index = fsheet_row_index;
        this.fis_strong = fis_strong;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFcategory() {
        return fcategory;
    }

    public void setFcategory(String fcategory) {
        this.fcategory = fcategory;
    }

    public String getFproject() {
        return fproject;
    }

    public void setFproject(String fproject) {
        this.fproject = fproject;
    }

    public Integer getFrow_index() {
        return frow_index;
    }

    public void setFrow_index(Integer frow_index) {
        this.frow_index = frow_index;
    }

    public BigDecimal getFthis_period_budget() {
        return fthis_period_budget;
    }

    public void setFthis_period_budget(BigDecimal fthis_period_budget) {
        this.fthis_period_budget = fthis_period_budget;
    }

    public BigDecimal getFthis_period_last_year() {
        return fthis_period_last_year;
    }

    public void setFthis_period_last_year(BigDecimal fthis_period_last_year) {
        this.fthis_period_last_year = fthis_period_last_year;
    }

    public BigDecimal getFthis_period_actual() {
        return fthis_period_actual;
    }

    public void setFthis_period_actual(BigDecimal fthis_period_actual) {
        this.fthis_period_actual = fthis_period_actual;
    }

    public BigDecimal getFcum_budget() {
        return fcum_budget;
    }

    public void setFcum_budget(BigDecimal fcum_budget) {
        this.fcum_budget = fcum_budget;
    }

    public BigDecimal getFcum_last_year() {
        return fcum_last_year;
    }

    public void setFcum_last_year(BigDecimal fcum_last_year) {
        this.fcum_last_year = fcum_last_year;
    }

    public BigDecimal getFcum_actual() {
        return fcum_actual;
    }

    public void setFcum_actual(BigDecimal fcum_actual) {
        this.fcum_actual = fcum_actual;
    }

    public Long getFhead_id() {
        return fhead_id;
    }

    public void setFhead_id(Long fhead_id) {
        this.fhead_id = fhead_id;
    }

    public int getFsheet_row_index() {
        return fsheet_row_index;
    }

    public void setFsheet_row_index(int fsheet_row_index) {
        this.fsheet_row_index = fsheet_row_index;
    }

    public int getFis_strong() {
        return fis_strong;
    }

    public void setFis_strong(int fis_strong) {
        this.fis_strong = fis_strong;
    }

    @Override
    public String toString() {
        return "TFinanceMainIndices{" +
                "fid=" + fid +
                ", fcategory='" + fcategory + '\'' +
                ", fproject='" + fproject + '\'' +
                ", frow_index=" + frow_index +
                ", fthis_period_budget=" + fthis_period_budget +
                ", fthis_period_last_year=" + fthis_period_last_year +
                ", fthis_period_actual=" + fthis_period_actual +
                ", fcum_budget=" + fcum_budget +
                ", fcum_last_year=" + fcum_last_year +
                ", fcum_actual=" + fcum_actual +
                ", fhead_id=" + fhead_id +
                ", fsheet_row_index=" + fsheet_row_index +
                ", fis_strong=" + fis_strong +
                '}';
    }


}