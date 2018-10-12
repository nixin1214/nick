package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 主要指标4
 * Created by lx on 2017/11/3.
 */
public class TFmainIndices4 implements Serializable {

    private int fid;
    private String fproject;

    private BigDecimal year_flag_mine;
    private String year_flag_company;
    private BigDecimal year_flag_cost_ratio;
    private BigDecimal year_flag_variance;

    private BigDecimal q1_flag_mine;
    private String q1_flag_company;
    private BigDecimal q1_flag_cost_ratio;
    private BigDecimal q1_flag_variance;

    private BigDecimal q2_flag_mine;
    private String q2_flag_company;
    private BigDecimal q2_flag_cost_ratio;
    private BigDecimal q2_flag_variance;

    private BigDecimal q3_flag_mine;
    private String q3_flag_company;
    private BigDecimal q3_flag_cost_ratio;
    private BigDecimal q3_flag_variance;

     private BigDecimal q4_flag_mine;
    private String q4_flag_company;
    private BigDecimal q4_flag_cost_ratio;
    private BigDecimal q4_flag_variance;

    private Long fhead_id;
    private int frow_index;

    public TFmainIndices4() {
    }

    public TFmainIndices4(int fid, String fproject, BigDecimal year_flag_mine, String year_flag_company, BigDecimal year_flag_cost_ratio, BigDecimal year_flag_variance, BigDecimal q1_flag_mine, String q1_flag_company, BigDecimal q1_flag_cost_ratio, BigDecimal q1_flag_variance, BigDecimal q2_flag_mine, String q2_flag_company, BigDecimal q2_flag_cost_ratio, BigDecimal q2_flag_variance, BigDecimal q3_flag_mine, String q3_flag_company, BigDecimal q3_flag_cost_ratio, BigDecimal q3_flag_variance, BigDecimal q4_flag_mine, String q4_flag_company, BigDecimal q4_flag_cost_ratio, BigDecimal q4_flag_variance, Long fhead_id, int frow_index) {
        this.fid = fid;
        this.fproject = fproject;
        this.year_flag_mine = year_flag_mine;
        this.year_flag_company = year_flag_company;
        this.year_flag_cost_ratio = year_flag_cost_ratio;
        this.year_flag_variance = year_flag_variance;
        this.q1_flag_mine = q1_flag_mine;
        this.q1_flag_company = q1_flag_company;
        this.q1_flag_cost_ratio = q1_flag_cost_ratio;
        this.q1_flag_variance = q1_flag_variance;
        this.q2_flag_mine = q2_flag_mine;
        this.q2_flag_company = q2_flag_company;
        this.q2_flag_cost_ratio = q2_flag_cost_ratio;
        this.q2_flag_variance = q2_flag_variance;
        this.q3_flag_mine = q3_flag_mine;
        this.q3_flag_company = q3_flag_company;
        this.q3_flag_cost_ratio = q3_flag_cost_ratio;
        this.q3_flag_variance = q3_flag_variance;
        this.q4_flag_mine = q4_flag_mine;
        this.q4_flag_company = q4_flag_company;
        this.q4_flag_cost_ratio = q4_flag_cost_ratio;
        this.q4_flag_variance = q4_flag_variance;
        this.fhead_id = fhead_id;
        this.frow_index = frow_index;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFproject() {
        return fproject;
    }

    public void setFproject(String fproject) {
        this.fproject = fproject;
    }

    public BigDecimal getYear_flag_mine() {
        return year_flag_mine;
    }

    public void setYear_flag_mine(BigDecimal year_flag_mine) {
        this.year_flag_mine = year_flag_mine;
    }

    public String getYear_flag_company() {
        return year_flag_company;
    }

    public void setYear_flag_company(String year_flag_company) {
        this.year_flag_company = year_flag_company;
    }

    public BigDecimal getYear_flag_cost_ratio() {
        return year_flag_cost_ratio;
    }

    public void setYear_flag_cost_ratio(BigDecimal year_flag_cost_ratio) {
        this.year_flag_cost_ratio = year_flag_cost_ratio;
    }

    public BigDecimal getYear_flag_variance() {
        return year_flag_variance;
    }

    public void setYear_flag_variance(BigDecimal year_flag_variance) {
        this.year_flag_variance = year_flag_variance;
    }

    public BigDecimal getQ1_flag_mine() {
        return q1_flag_mine;
    }

    public void setQ1_flag_mine(BigDecimal q1_flag_mine) {
        this.q1_flag_mine = q1_flag_mine;
    }

    public String getQ1_flag_company() {
        return q1_flag_company;
    }

    public void setQ1_flag_company(String q1_flag_company) {
        this.q1_flag_company = q1_flag_company;
    }

    public BigDecimal getQ1_flag_cost_ratio() {
        return q1_flag_cost_ratio;
    }

    public void setQ1_flag_cost_ratio(BigDecimal q1_flag_cost_ratio) {
        this.q1_flag_cost_ratio = q1_flag_cost_ratio;
    }

    public BigDecimal getQ1_flag_variance() {
        return q1_flag_variance;
    }

    public void setQ1_flag_variance(BigDecimal q1_flag_variance) {
        this.q1_flag_variance = q1_flag_variance;
    }

    public BigDecimal getQ2_flag_mine() {
        return q2_flag_mine;
    }

    public void setQ2_flag_mine(BigDecimal q2_flag_mine) {
        this.q2_flag_mine = q2_flag_mine;
    }

    public String getQ2_flag_company() {
        return q2_flag_company;
    }

    public void setQ2_flag_company(String q2_flag_company) {
        this.q2_flag_company = q2_flag_company;
    }

    public BigDecimal getQ2_flag_cost_ratio() {
        return q2_flag_cost_ratio;
    }

    public void setQ2_flag_cost_ratio(BigDecimal q2_flag_cost_ratio) {
        this.q2_flag_cost_ratio = q2_flag_cost_ratio;
    }

    public BigDecimal getQ2_flag_variance() {
        return q2_flag_variance;
    }

    public void setQ2_flag_variance(BigDecimal q2_flag_variance) {
        this.q2_flag_variance = q2_flag_variance;
    }

    public BigDecimal getQ3_flag_mine() {
        return q3_flag_mine;
    }

    public void setQ3_flag_mine(BigDecimal q3_flag_mine) {
        this.q3_flag_mine = q3_flag_mine;
    }

    public String getQ3_flag_company() {
        return q3_flag_company;
    }

    public void setQ3_flag_company(String q3_flag_company) {
        this.q3_flag_company = q3_flag_company;
    }

    public BigDecimal getQ3_flag_cost_ratio() {
        return q3_flag_cost_ratio;
    }

    public void setQ3_flag_cost_ratio(BigDecimal q3_flag_cost_ratio) {
        this.q3_flag_cost_ratio = q3_flag_cost_ratio;
    }

    public BigDecimal getQ3_flag_variance() {
        return q3_flag_variance;
    }

    public void setQ3_flag_variance(BigDecimal q3_flag_variance) {
        this.q3_flag_variance = q3_flag_variance;
    }

    public BigDecimal getQ4_flag_mine() {
        return q4_flag_mine;
    }

    public void setQ4_flag_mine(BigDecimal q4_flag_mine) {
        this.q4_flag_mine = q4_flag_mine;
    }

    public String getQ4_flag_company() {
        return q4_flag_company;
    }

    public void setQ4_flag_company(String q4_flag_company) {
        this.q4_flag_company = q4_flag_company;
    }

    public BigDecimal getQ4_flag_cost_ratio() {
        return q4_flag_cost_ratio;
    }

    public void setQ4_flag_cost_ratio(BigDecimal q4_flag_cost_ratio) {
        this.q4_flag_cost_ratio = q4_flag_cost_ratio;
    }

    public BigDecimal getQ4_flag_variance() {
        return q4_flag_variance;
    }

    public void setQ4_flag_variance(BigDecimal q4_flag_variance) {
        this.q4_flag_variance = q4_flag_variance;
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
