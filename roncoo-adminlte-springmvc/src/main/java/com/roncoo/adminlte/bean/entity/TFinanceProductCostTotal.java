package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TFinanceProductCostTotal implements Serializable {
    private Long fid;

    private Long fheadId;

    private Integer frowIndex;

    private String fseq;

    private String fprojectName;

    private BigDecimal fyield;

    private BigDecimal fmaterialBudget;

    private BigDecimal fmaterialActual;

    private BigDecimal fpackageBudget;

    private BigDecimal fpackageActual;

    private BigDecimal flaborCostBudget;

    private BigDecimal flaborCostActual;

    private BigDecimal fpowerCostBudget;

    private BigDecimal fpowerCostActual;

    private BigDecimal fmanufCostBudget;

    private BigDecimal fmanufCostActual;

    private BigDecimal fproductionCostBudget;

    private BigDecimal fproductionCostActual;

    private BigDecimal fproductionCostTotal;

    private BigDecimal fextend1;

    private BigDecimal fextend3;

    private BigDecimal fextend2;

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

    public BigDecimal getFmaterialBudget() {
        return fmaterialBudget;
    }

    public void setFmaterialBudget(BigDecimal fmaterialBudget) {
        this.fmaterialBudget = fmaterialBudget;
    }

    public BigDecimal getFmaterialActual() {
        return fmaterialActual;
    }

    public void setFmaterialActual(BigDecimal fmaterialActual) {
        this.fmaterialActual = fmaterialActual;
    }

    public BigDecimal getFpackageBudget() {
        return fpackageBudget;
    }

    public void setFpackageBudget(BigDecimal fpackageBudget) {
        this.fpackageBudget = fpackageBudget;
    }

    public BigDecimal getFpackageActual() {
        return fpackageActual;
    }

    public void setFpackageActual(BigDecimal fpackageActual) {
        this.fpackageActual = fpackageActual;
    }

    public BigDecimal getFlaborCostBudget() {
        return flaborCostBudget;
    }

    public void setFlaborCostBudget(BigDecimal flaborCostBudget) {
        this.flaborCostBudget = flaborCostBudget;
    }

    public BigDecimal getFlaborCostActual() {
        return flaborCostActual;
    }

    public void setFlaborCostActual(BigDecimal flaborCostActual) {
        this.flaborCostActual = flaborCostActual;
    }

    public BigDecimal getFpowerCostBudget() {
        return fpowerCostBudget;
    }

    public void setFpowerCostBudget(BigDecimal fpowerCostBudget) {
        this.fpowerCostBudget = fpowerCostBudget;
    }

    public BigDecimal getFpowerCostActual() {
        return fpowerCostActual;
    }

    public void setFpowerCostActual(BigDecimal fpowerCostActual) {
        this.fpowerCostActual = fpowerCostActual;
    }

    public BigDecimal getFmanufCostBudget() {
        return fmanufCostBudget;
    }

    public void setFmanufCostBudget(BigDecimal fmanufCostBudget) {
        this.fmanufCostBudget = fmanufCostBudget;
    }

    public BigDecimal getFmanufCostActual() {
        return fmanufCostActual;
    }

    public void setFmanufCostActual(BigDecimal fmanufCostActual) {
        this.fmanufCostActual = fmanufCostActual;
    }

    public BigDecimal getFproductionCostBudget() {
        return fproductionCostBudget;
    }

    public void setFproductionCostBudget(BigDecimal fproductionCostBudget) {
        this.fproductionCostBudget = fproductionCostBudget;
    }

    public BigDecimal getFproductionCostActual() {
        return fproductionCostActual;
    }

    public void setFproductionCostActual(BigDecimal fproductionCostActual) {
        this.fproductionCostActual = fproductionCostActual;
    }

    public BigDecimal getFproductionCostTotal() {
        return fproductionCostTotal;
    }

    public void setFproductionCostTotal(BigDecimal fproductionCostTotal) {
        this.fproductionCostTotal = fproductionCostTotal;
    }

    public BigDecimal getFextend1() {
        return fextend1;
    }

    public void setFextend1(BigDecimal fextend1) {
        this.fextend1 = fextend1;
    }

    public BigDecimal getFextend3() {
        return fextend3;
    }

    public void setFextend3(BigDecimal fextend3) {
        this.fextend3 = fextend3;
    }

    public BigDecimal getFextend2() {
        return fextend2;
    }

    public void setFextend2(BigDecimal fextend2) {
        this.fextend2 = fextend2;
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
        sb.append(", fmaterialBudget=").append(fmaterialBudget);
        sb.append(", fmaterialActual=").append(fmaterialActual);
        sb.append(", fpackageBudget=").append(fpackageBudget);
        sb.append(", fpackageActual=").append(fpackageActual);
        sb.append(", flaborCostBudget=").append(flaborCostBudget);
        sb.append(", flaborCostActual=").append(flaborCostActual);
        sb.append(", fpowerCostBudget=").append(fpowerCostBudget);
        sb.append(", fpowerCostActual=").append(fpowerCostActual);
        sb.append(", fmanufCostBudget=").append(fmanufCostBudget);
        sb.append(", fmanufCostActual=").append(fmanufCostActual);
        sb.append(", fproductionCostBudget=").append(fproductionCostBudget);
        sb.append(", fproductionCostActual=").append(fproductionCostActual);
        sb.append(", fproductionCostTotal=").append(fproductionCostTotal);
        sb.append(", fextend1=").append(fextend1);
        sb.append(", fextend3=").append(fextend3);
        sb.append(", fextend2=").append(fextend2);
        sb.append(", fextend4=").append(fextend4);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}