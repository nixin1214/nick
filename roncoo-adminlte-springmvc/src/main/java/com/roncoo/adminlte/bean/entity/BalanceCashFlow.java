package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 现金流量
 * Created by lx on 2017/11/11.
 */
public class BalanceCashFlow implements Serializable {

    private Long fid;
    private Long fhead_id;
    private String fproject;
    private BigDecimal fthis_period_cum;
    private BigDecimal flast_year_cum;
    private String fother_data;
    private BigDecimal fthis_period_cum2;
    private BigDecimal flast_year_cum2;
    private int fsheet_row_index;
    private int fis_strong;

    public BalanceCashFlow(){}

    public BalanceCashFlow(Long fid, Long fhead_id, String fproject, BigDecimal fthis_period_cum, BigDecimal flast_year_cum, String fother_data, BigDecimal fthis_period_cum2, BigDecimal flast_year_cum2, int fsheet_row_index, int fis_strong) {
        this.fid = fid;
        this.fhead_id = fhead_id;
        this.fproject = fproject;
        this.fthis_period_cum = fthis_period_cum;
        this.flast_year_cum = flast_year_cum;
        this.fother_data = fother_data;
        this.fthis_period_cum2 = fthis_period_cum2;
        this.flast_year_cum2 = flast_year_cum2;
        this.fsheet_row_index = fsheet_row_index;
        this.fis_strong = fis_strong;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getFhead_id() {
        return fhead_id;
    }

    public void setFhead_id(Long fhead_id) {
        this.fhead_id = fhead_id;
    }

    public String getFproject() {
        return fproject;
    }

    public void setFproject(String fproject) {
        this.fproject = fproject;
    }

    public BigDecimal getFthis_period_cum() {
        return fthis_period_cum;
    }

    public void setFthis_period_cum(BigDecimal fthis_period_cum) {
        this.fthis_period_cum = fthis_period_cum;
    }

    public BigDecimal getFlast_year_cum() {
        return flast_year_cum;
    }

    public void setFlast_year_cum(BigDecimal flast_year_cum) {
        this.flast_year_cum = flast_year_cum;
    }

    public String getFother_data() {
        return fother_data;
    }

    public void setFother_data(String fother_data) {
        this.fother_data = fother_data;
    }

    public BigDecimal getFthis_period_cum2() {
        return fthis_period_cum2;
    }

    public void setFthis_period_cum2(BigDecimal fthis_period_cum2) {
        this.fthis_period_cum2 = fthis_period_cum2;
    }

    public BigDecimal getFlast_year_cum2() {
        return flast_year_cum2;
    }

    public void setFlast_year_cum2(BigDecimal flast_year_cum2) {
        this.flast_year_cum2 = flast_year_cum2;
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
}
