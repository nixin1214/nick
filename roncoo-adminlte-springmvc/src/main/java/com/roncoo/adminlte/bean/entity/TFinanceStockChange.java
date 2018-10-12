package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TFinanceStockChange implements Serializable {
    private Long fid;

    private Long fheadId;

    private Integer frowIndex;

    private String fprojectName;

    private BigDecimal fbeginNumber;

    private BigDecimal fbeginAmount;

    private BigDecimal fthisAddNumber;

    private BigDecimal fthisAddAmount;

    private BigDecimal ftotalAddNumber;

    private BigDecimal ftotalAddAmount;

    private BigDecimal fthisFallingNumber;

    private BigDecimal fthisFallingAmount;

    private BigDecimal ftotalFallingNumber;

    private BigDecimal ftotalFallingAmount;

    private BigDecimal flastNumber;

    private BigDecimal flastAmount;

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

    public BigDecimal getFbeginNumber() {
        return fbeginNumber;
    }

    public void setFbeginNumber(BigDecimal fbeginNumber) {
        this.fbeginNumber = fbeginNumber;
    }

    public BigDecimal getFbeginAmount() {
        return fbeginAmount;
    }

    public void setFbeginAmount(BigDecimal fbeginAmount) {
        this.fbeginAmount = fbeginAmount;
    }

    public BigDecimal getFthisAddNumber() {
        return fthisAddNumber;
    }

    public void setFthisAddNumber(BigDecimal fthisAddNumber) {
        this.fthisAddNumber = fthisAddNumber;
    }

    public BigDecimal getFthisAddAmount() {
        return fthisAddAmount;
    }

    public void setFthisAddAmount(BigDecimal fthisAddAmount) {
        this.fthisAddAmount = fthisAddAmount;
    }

    public BigDecimal getFtotalAddNumber() {
        return ftotalAddNumber;
    }

    public void setFtotalAddNumber(BigDecimal ftotalAddNumber) {
        this.ftotalAddNumber = ftotalAddNumber;
    }

    public BigDecimal getFtotalAddAmount() {
        return ftotalAddAmount;
    }

    public void setFtotalAddAmount(BigDecimal ftotalAddAmount) {
        this.ftotalAddAmount = ftotalAddAmount;
    }

    public BigDecimal getFthisFallingNumber() {
        return fthisFallingNumber;
    }

    public void setFthisFallingNumber(BigDecimal fthisFallingNumber) {
        this.fthisFallingNumber = fthisFallingNumber;
    }

    public BigDecimal getFthisFallingAmount() {
        return fthisFallingAmount;
    }

    public void setFthisFallingAmount(BigDecimal fthisFallingAmount) {
        this.fthisFallingAmount = fthisFallingAmount;
    }

    public BigDecimal getFtotalFallingNumber() {
        return ftotalFallingNumber;
    }

    public void setFtotalFallingNumber(BigDecimal ftotalFallingNumber) {
        this.ftotalFallingNumber = ftotalFallingNumber;
    }

    public BigDecimal getFtotalFallingAmount() {
        return ftotalFallingAmount;
    }

    public void setFtotalFallingAmount(BigDecimal ftotalFallingAmount) {
        this.ftotalFallingAmount = ftotalFallingAmount;
    }

    public BigDecimal getFlastNumber() {
        return flastNumber;
    }

    public void setFlastNumber(BigDecimal flastNumber) {
        this.flastNumber = flastNumber;
    }

    public BigDecimal getFlastAmount() {
        return flastAmount;
    }

    public void setFlastAmount(BigDecimal flastAmount) {
        this.flastAmount = flastAmount;
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
        sb.append(", fbeginNumber=").append(fbeginNumber);
        sb.append(", fbeginAmount=").append(fbeginAmount);
        sb.append(", fthisAddNumber=").append(fthisAddNumber);
        sb.append(", fthisAddAmount=").append(fthisAddAmount);
        sb.append(", ftotalAddNumber=").append(ftotalAddNumber);
        sb.append(", ftotalAddAmount=").append(ftotalAddAmount);
        sb.append(", fthisFallingNumber=").append(fthisFallingNumber);
        sb.append(", fthisFallingAmount=").append(fthisFallingAmount);
        sb.append(", ftotalFallingNumber=").append(ftotalFallingNumber);
        sb.append(", ftotalFallingAmount=").append(ftotalFallingAmount);
        sb.append(", flastNumber=").append(flastNumber);
        sb.append(", flastAmount=").append(flastAmount);
        sb.append(", fextend1=").append(fextend1);
        sb.append(", fextend2=").append(fextend2);
        sb.append(", fextend3=").append(fextend3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}