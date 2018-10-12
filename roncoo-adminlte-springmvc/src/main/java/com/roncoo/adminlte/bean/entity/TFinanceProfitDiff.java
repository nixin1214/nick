package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TFinanceProfitDiff implements Serializable {
    private Long fid;

    private String fproject;

    private Long frowNum;

    private BigDecimal lastYearActual;

    private BigDecimal lastYearTotal;

    private BigDecimal thisYearBudget;

    private BigDecimal thisYearBudgetTotal;

    private BigDecimal thisYearActual;

    private BigDecimal thisYearActualTotal;

    private Long fheadId;

    private Long frowIndex;

    private Long fstrong;

    private static final long serialVersionUID = 1L;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFproject() {
        return fproject;
    }

    public void setFproject(String fproject) {
        this.fproject = fproject == null ? null : fproject.trim();
    }

    public Long getFrowNum() {
        return frowNum;
    }

    public void setFrowNum(Long frowNum) {
        this.frowNum = frowNum;
    }

    public BigDecimal getLastYearActual() {
        return lastYearActual;
    }

    public void setLastYearActual(BigDecimal lastYearActual) {
        this.lastYearActual = lastYearActual;
    }

    public BigDecimal getLastYearTotal() {
        return lastYearTotal;
    }

    public void setLastYearTotal(BigDecimal lastYearTotal) {
        this.lastYearTotal = lastYearTotal;
    }

    public BigDecimal getThisYearBudget() {
        return thisYearBudget;
    }

    public void setThisYearBudget(BigDecimal thisYearBudget) {
        this.thisYearBudget = thisYearBudget;
    }

    public BigDecimal getThisYearBudgetTotal() {
        return thisYearBudgetTotal;
    }

    public void setThisYearBudgetTotal(BigDecimal thisYearBudgetTotal) {
        this.thisYearBudgetTotal = thisYearBudgetTotal;
    }

    public BigDecimal getThisYearActual() {
        return thisYearActual;
    }

    public void setThisYearActual(BigDecimal thisYearActual) {
        this.thisYearActual = thisYearActual;
    }

    public BigDecimal getThisYearActualTotal() {
        return thisYearActualTotal;
    }

    public void setThisYearActualTotal(BigDecimal thisYearActualTotal) {
        this.thisYearActualTotal = thisYearActualTotal;
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

    public Long getFstrong() {
        return fstrong;
    }

    public void setFstrong(Long fstrong) {
        this.fstrong = fstrong;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", fproject=").append(fproject);
        sb.append(", frowNum=").append(frowNum);
        sb.append(", lastYearActual=").append(lastYearActual);
        sb.append(", lastYearTotal=").append(lastYearTotal);
        sb.append(", thisYearBudget=").append(thisYearBudget);
        sb.append(", thisYearBudgetTotal=").append(thisYearBudgetTotal);
        sb.append(", thisYearActual=").append(thisYearActual);
        sb.append(", thisYearActualTotal=").append(thisYearActualTotal);
        sb.append(", fheadId=").append(fheadId);
        sb.append(", frowIndex=").append(frowIndex);
        sb.append(", fstrong=").append(fstrong);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}