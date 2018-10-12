package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TFinanceTaxSDiff implements Serializable {
    private Long fid;

    private Long fheadId;

    private Long frowIndex;

    private String fprojectName;

    private BigDecimal fbeginPeriodUnpaid;

    private BigDecimal fbeginPeriodShould;

    private BigDecimal fbeginPeriodAlready;

    private BigDecimal fbeginPeriodFinalUnpaid;

    private BigDecimal ftotalPeriodUnpaid;

    private BigDecimal ftotalPeriodShould;

    private BigDecimal ftotalPeriodAlready;

    private BigDecimal ftotalPeriodFinalUnpaid;

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

    public Long getFrowIndex() {
        return frowIndex;
    }

    public void setFrowIndex(Long frowIndex) {
        this.frowIndex = frowIndex;
    }

    public String getFprojectName() {
        return fprojectName;
    }

    public void setFprojectName(String fprojectName) {
        this.fprojectName = fprojectName == null ? null : fprojectName.trim();
    }

    public BigDecimal getFbeginPeriodUnpaid() {
        return fbeginPeriodUnpaid;
    }

    public void setFbeginPeriodUnpaid(BigDecimal fbeginPeriodUnpaid) {
        this.fbeginPeriodUnpaid = fbeginPeriodUnpaid;
    }

    public BigDecimal getFbeginPeriodShould() {
        return fbeginPeriodShould;
    }

    public void setFbeginPeriodShould(BigDecimal fbeginPeriodShould) {
        this.fbeginPeriodShould = fbeginPeriodShould;
    }

    public BigDecimal getFbeginPeriodAlready() {
        return fbeginPeriodAlready;
    }

    public void setFbeginPeriodAlready(BigDecimal fbeginPeriodAlready) {
        this.fbeginPeriodAlready = fbeginPeriodAlready;
    }

    public BigDecimal getFbeginPeriodFinalUnpaid() {
        return fbeginPeriodFinalUnpaid;
    }

    public void setFbeginPeriodFinalUnpaid(BigDecimal fbeginPeriodFinalUnpaid) {
        this.fbeginPeriodFinalUnpaid = fbeginPeriodFinalUnpaid;
    }

    public BigDecimal getFtotalPeriodUnpaid() {
        return ftotalPeriodUnpaid;
    }

    public void setFtotalPeriodUnpaid(BigDecimal ftotalPeriodUnpaid) {
        this.ftotalPeriodUnpaid = ftotalPeriodUnpaid;
    }

    public BigDecimal getFtotalPeriodShould() {
        return ftotalPeriodShould;
    }

    public void setFtotalPeriodShould(BigDecimal ftotalPeriodShould) {
        this.ftotalPeriodShould = ftotalPeriodShould;
    }

    public BigDecimal getFtotalPeriodAlready() {
        return ftotalPeriodAlready;
    }

    public void setFtotalPeriodAlready(BigDecimal ftotalPeriodAlready) {
        this.ftotalPeriodAlready = ftotalPeriodAlready;
    }

    public BigDecimal getFtotalPeriodFinalUnpaid() {
        return ftotalPeriodFinalUnpaid;
    }

    public void setFtotalPeriodFinalUnpaid(BigDecimal ftotalPeriodFinalUnpaid) {
        this.ftotalPeriodFinalUnpaid = ftotalPeriodFinalUnpaid;
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
        sb.append(", fbeginPeriodUnpaid=").append(fbeginPeriodUnpaid);
        sb.append(", fbeginPeriodShould=").append(fbeginPeriodShould);
        sb.append(", fbeginPeriodAlready=").append(fbeginPeriodAlready);
        sb.append(", fbeginPeriodFinalUnpaid=").append(fbeginPeriodFinalUnpaid);
        sb.append(", ftotalPeriodUnpaid=").append(ftotalPeriodUnpaid);
        sb.append(", ftotalPeriodShould=").append(ftotalPeriodShould);
        sb.append(", ftotalPeriodAlready=").append(ftotalPeriodAlready);
        sb.append(", ftotalPeriodFinalUnpaid=").append(ftotalPeriodFinalUnpaid);
        sb.append(", fextend1=").append(fextend1);
        sb.append(", fextend2=").append(fextend2);
        sb.append(", fextend3=").append(fextend3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}