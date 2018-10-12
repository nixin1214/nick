package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TFinanceMilkCostThis implements Serializable {
    private Long fid;

    private Long fheadId;

    private Integer frowIndex;

    private String fseq;

    private String fprojectName;

    private BigDecimal fyield;

    private BigDecimal fmaterialYield;

    private BigDecimal fmaterialAmount;

    private BigDecimal fpackageYield;

    private BigDecimal fpackageAmount;

    private BigDecimal flaborCostYield;

    private BigDecimal flaborCostAmount;

    private BigDecimal fpowerCostYield;

    private BigDecimal fpowerCostAmount;

    private BigDecimal fmanufCostYield;

    private BigDecimal fmanufCostAmount;

    private BigDecimal fproductionCostYield;

    private BigDecimal fproductionCostAmount;

    private BigDecimal fextend1;

    private BigDecimal fextend2;

    private BigDecimal fextend3;

    private BigDecimal fextend4;

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

    public String getFseq() {
        return fseq;
    }

    public void setFseq(String fseq) {
        this.fseq = fseq == null ? null : fseq.trim();
    }

    public String getFprojectName() {
        return fprojectName;
    }

    public void setFprojectName(String fprojectName) {
        this.fprojectName = fprojectName == null ? null : fprojectName.trim();
    }

    public BigDecimal getFyield() {
        return fyield;
    }

    public void setFyield(BigDecimal fyield) {
        this.fyield = fyield;
    }

    public BigDecimal getFmaterialYield() {
        return fmaterialYield;
    }

    public void setFmaterialYield(BigDecimal fmaterialYield) {
        this.fmaterialYield = fmaterialYield;
    }

    public BigDecimal getFmaterialAmount() {
        return fmaterialAmount;
    }

    public void setFmaterialAmount(BigDecimal fmaterialAmount) {
        this.fmaterialAmount = fmaterialAmount;
    }

    public BigDecimal getFpackageYield() {
        return fpackageYield;
    }

    public void setFpackageYield(BigDecimal fpackageYield) {
        this.fpackageYield = fpackageYield;
    }

    public BigDecimal getFpackageAmount() {
        return fpackageAmount;
    }

    public void setFpackageAmount(BigDecimal fpackageAmount) {
        this.fpackageAmount = fpackageAmount;
    }

    public BigDecimal getFlaborCostYield() {
        return flaborCostYield;
    }

    public void setFlaborCostYield(BigDecimal flaborCostYield) {
        this.flaborCostYield = flaborCostYield;
    }

    public BigDecimal getFlaborCostAmount() {
        return flaborCostAmount;
    }

    public void setFlaborCostAmount(BigDecimal flaborCostAmount) {
        this.flaborCostAmount = flaborCostAmount;
    }

    public BigDecimal getFpowerCostYield() {
        return fpowerCostYield;
    }

    public void setFpowerCostYield(BigDecimal fpowerCostYield) {
        this.fpowerCostYield = fpowerCostYield;
    }

    public BigDecimal getFpowerCostAmount() {
        return fpowerCostAmount;
    }

    public void setFpowerCostAmount(BigDecimal fpowerCostAmount) {
        this.fpowerCostAmount = fpowerCostAmount;
    }

    public BigDecimal getFmanufCostYield() {
        return fmanufCostYield;
    }

    public void setFmanufCostYield(BigDecimal fmanufCostYield) {
        this.fmanufCostYield = fmanufCostYield;
    }

    public BigDecimal getFmanufCostAmount() {
        return fmanufCostAmount;
    }

    public void setFmanufCostAmount(BigDecimal fmanufCostAmount) {
        this.fmanufCostAmount = fmanufCostAmount;
    }

    public BigDecimal getFproductionCostYield() {
        return fproductionCostYield;
    }

    public void setFproductionCostYield(BigDecimal fproductionCostYield) {
        this.fproductionCostYield = fproductionCostYield;
    }

    public BigDecimal getFproductionCostAmount() {
        return fproductionCostAmount;
    }

    public void setFproductionCostAmount(BigDecimal fproductionCostAmount) {
        this.fproductionCostAmount = fproductionCostAmount;
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

    public BigDecimal getFextend4() {
        return fextend4;
    }

    public void setFextend4(BigDecimal fextend4) {
        this.fextend4 = fextend4;
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
        sb.append(", fseq=").append(fseq);
        sb.append(", fprojectName=").append(fprojectName);
        sb.append(", fyield=").append(fyield);
        sb.append(", fmaterialYield=").append(fmaterialYield);
        sb.append(", fmaterialAmount=").append(fmaterialAmount);
        sb.append(", fpackageYield=").append(fpackageYield);
        sb.append(", fpackageAmount=").append(fpackageAmount);
        sb.append(", flaborCostYield=").append(flaborCostYield);
        sb.append(", flaborCostAmount=").append(flaborCostAmount);
        sb.append(", fpowerCostYield=").append(fpowerCostYield);
        sb.append(", fpowerCostAmount=").append(fpowerCostAmount);
        sb.append(", fmanufCostYield=").append(fmanufCostYield);
        sb.append(", fmanufCostAmount=").append(fmanufCostAmount);
        sb.append(", fproductionCostYield=").append(fproductionCostYield);
        sb.append(", fproductionCostAmount=").append(fproductionCostAmount);
        sb.append(", fextend1=").append(fextend1);
        sb.append(", fextend2=").append(fextend2);
        sb.append(", fextend3=").append(fextend3);
        sb.append(", fextend4=").append(fextend4);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}