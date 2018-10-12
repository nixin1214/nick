package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 主要指标5
 * Created by lx on 2017/11/3.
 */
public class TFmainIndices5 implements Serializable {

    private int fid;
    private String fproject;

    private BigDecimal year_plan;
    private BigDecimal q1_done;
    private BigDecimal q2_done;
    private BigDecimal q3_done;
    private BigDecimal q4_done;
    private BigDecimal year_done;
    private BigDecimal year_done_count;
    private BigDecimal year_done_ratio;
    private BigDecimal year_done_variance;

    private Long fhead_id;
    private int frow_index;

    public TFmainIndices5() {
    }

    public TFmainIndices5(int fid, String fproject, BigDecimal year_plan, BigDecimal q1_done, BigDecimal q2_done, BigDecimal q3_done, BigDecimal q4_done, BigDecimal year_done, BigDecimal year_done_count, BigDecimal year_done_ratio, BigDecimal year_done_variance, Long fhead_id, int frow_index) {
        this.fid = fid;
        this.fproject = fproject;
        this.year_plan = year_plan;
        this.q1_done = q1_done;
        this.q2_done = q2_done;
        this.q3_done = q3_done;
        this.q4_done = q4_done;
        this.year_done = year_done;
        this.year_done_count = year_done_count;
        this.year_done_ratio = year_done_ratio;
        this.year_done_variance = year_done_variance;
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

    public BigDecimal getYear_plan() {
        return year_plan;
    }

    public void setYear_plan(BigDecimal year_plan) {
        this.year_plan = year_plan;
    }

    public BigDecimal getQ1_done() {
        return q1_done;
    }

    public void setQ1_done(BigDecimal q1_done) {
        this.q1_done = q1_done;
    }

    public BigDecimal getQ2_done() {
        return q2_done;
    }

    public void setQ2_done(BigDecimal q2_done) {
        this.q2_done = q2_done;
    }

    public BigDecimal getQ3_done() {
        return q3_done;
    }

    public void setQ3_done(BigDecimal q3_done) {
        this.q3_done = q3_done;
    }

    public BigDecimal getQ4_done() {
        return q4_done;
    }

    public void setQ4_done(BigDecimal q4_done) {
        this.q4_done = q4_done;
    }

    public BigDecimal getYear_done() {
        return year_done;
    }

    public void setYear_done(BigDecimal year_done) {
        this.year_done = year_done;
    }

    public BigDecimal getYear_done_count() {
        return year_done_count;
    }

    public void setYear_done_count(BigDecimal year_done_count) {
        this.year_done_count = year_done_count;
    }

    public BigDecimal getYear_done_ratio() {
        return year_done_ratio;
    }

    public void setYear_done_ratio(BigDecimal year_done_ratio) {
        this.year_done_ratio = year_done_ratio;
    }

    public BigDecimal getYear_done_variance() {
        return year_done_variance;
    }

    public void setYear_done_variance(BigDecimal year_done_variance) {
        this.year_done_variance = year_done_variance;
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
