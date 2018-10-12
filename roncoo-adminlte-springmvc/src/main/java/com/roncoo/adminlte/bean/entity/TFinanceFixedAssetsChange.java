package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TFinanceFixedAssetsChange implements Serializable {
    private Long fid;

    private Long fheadId;

    private Integer frowIndex;

    private String fprojectName;

    private BigDecimal fbeginBalance;

    private BigDecimal fthisYearAdd;

    private BigDecimal fthisYearFalling;

    private BigDecimal fendBalance;

    private BigDecimal fextend1;

    private BigDecimal fextend2;

    private BigDecimal fextend3;

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

    public Integer getFrowIndex() {
        return frowIndex;
    }

    public void setFrowIndex(Integer frowIndex) {
        this.frowIndex = frowIndex;
    }

    public String getFprojectName() {
        return fprojectName;
    }

    public void setFprojectName(String fprojectName) {
        this.fprojectName = fprojectName == null ? null : fprojectName.trim();
    }

    public BigDecimal getFbeginBalance() {
        return fbeginBalance;
    }

    public void setFbeginBalance(BigDecimal fbeginBalance) {
        this.fbeginBalance = fbeginBalance;
    }

    public BigDecimal getFthisYearAdd() {
        return fthisYearAdd;
    }

    public void setFthisYearAdd(BigDecimal fthisYearAdd) {
        this.fthisYearAdd = fthisYearAdd;
    }

    public BigDecimal getFthisYearFalling() {
        return fthisYearFalling;
    }

    public void setFthisYearFalling(BigDecimal fthisYearFalling) {
        this.fthisYearFalling = fthisYearFalling;
    }

    public BigDecimal getFendBalance() {
        return fendBalance;
    }

    public void setFendBalance(BigDecimal fendBalance) {
        this.fendBalance = fendBalance;
    }

    public BigDecimal getFextend1() {
        return fextend1;
    }

    public void setFextend1(BigDecimal fextend1) {
        this.fextend1 = fextend1;
    }

    public BigDecimal getFextend2() {
        return fextend2;
    }

    public void setFextend2(BigDecimal fextend2) {
        this.fextend2 = fextend2;
    }

    public BigDecimal getFextend3() {
        return fextend3;
    }

    public void setFextend3(BigDecimal fextend3) {
        this.fextend3 = fextend3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", fheadId=").append(fheadId);
        sb.append(", frowIndex=").append(frowIndex);
        sb.append(", fprojectName=").append(fprojectName);
        sb.append(", fbeginBalance=").append(fbeginBalance);
        sb.append(", fthisYearAdd=").append(fthisYearAdd);
        sb.append(", fthisYearFalling=").append(fthisYearFalling);
        sb.append(", fendBalance=").append(fendBalance);
        sb.append(", fextend1=").append(fextend1);
        sb.append(", fextend2=").append(fextend2);
        sb.append(", fextend3=").append(fextend3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}