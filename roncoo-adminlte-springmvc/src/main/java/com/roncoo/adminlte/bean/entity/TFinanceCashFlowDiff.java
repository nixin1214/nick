package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TFinanceCashFlowDiff implements Serializable {
    private Long fid;

    private Long fheadId;

    private String fproject;

    private BigDecimal fthisPeriodCum;

    private BigDecimal flastYearCum;

    private String fotherData;

    private BigDecimal fthisPeriodCum2;

    private BigDecimal flastYearCum2;

    private Long fsheetRowIndex;

    private Long fisStrong;

    private static final long serialVersionUID = 1L;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getFheadId() {
        return fheadId;
    }

    public void setFheadId(Long fheadId) {
        this.fheadId = fheadId;
    }

    public String getFproject() {
        return fproject;
    }

    public void setFproject(String fproject) {
        this.fproject = fproject == null ? null : fproject.trim();
    }

    public BigDecimal getFthisPeriodCum() {
        return fthisPeriodCum;
    }

    public void setFthisPeriodCum(BigDecimal fthisPeriodCum) {
        this.fthisPeriodCum = fthisPeriodCum;
    }

    public BigDecimal getFlastYearCum() {
        return flastYearCum;
    }

    public void setFlastYearCum(BigDecimal flastYearCum) {
        this.flastYearCum = flastYearCum;
    }

    public String getFotherData() {
        return fotherData;
    }

    public void setFotherData(String fotherData) {
        this.fotherData = fotherData == null ? null : fotherData.trim();
    }

    public BigDecimal getFthisPeriodCum2() {
        return fthisPeriodCum2;
    }

    public void setFthisPeriodCum2(BigDecimal fthisPeriodCum2) {
        this.fthisPeriodCum2 = fthisPeriodCum2;
    }

    public BigDecimal getFlastYearCum2() {
        return flastYearCum2;
    }

    public void setFlastYearCum2(BigDecimal flastYearCum2) {
        this.flastYearCum2 = flastYearCum2;
    }

    public Long getFsheetRowIndex() {
        return fsheetRowIndex;
    }

    public void setFsheetRowIndex(Long fsheetRowIndex) {
        this.fsheetRowIndex = fsheetRowIndex;
    }

    public Long getFisStrong() {
        return fisStrong;
    }

    public void setFisStrong(Long fisStrong) {
        this.fisStrong = fisStrong;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", fheadId=").append(fheadId);
        sb.append(", fproject=").append(fproject);
        sb.append(", fthisPeriodCum=").append(fthisPeriodCum);
        sb.append(", flastYearCum=").append(flastYearCum);
        sb.append(", fotherData=").append(fotherData);
        sb.append(", fthisPeriodCum2=").append(fthisPeriodCum2);
        sb.append(", flastYearCum2=").append(flastYearCum2);
        sb.append(", fsheetRowIndex=").append(fsheetRowIndex);
        sb.append(", fisStrong=").append(fisStrong);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}