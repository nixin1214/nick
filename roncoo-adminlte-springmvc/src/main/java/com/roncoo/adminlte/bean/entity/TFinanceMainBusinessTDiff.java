package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TFinanceMainBusinessTDiff implements Serializable {
    private Long fid;

    private String frowNum;

    private String fproject;

    private BigDecimal saleBudget;

    private BigDecimal saleActual;

    private BigDecimal incomeBudget;

    private BigDecimal incomeActual;

    private BigDecimal incomeTotal;

    private BigDecimal costBudget;

    private BigDecimal costActual;

    private BigDecimal costTotal;

    private BigDecimal saleProfitBudget;

    private BigDecimal saleProfitActual;

    private BigDecimal saleProfitBudgetRatio;

    private BigDecimal saleProfitActualRatio;

    private BigDecimal saleTotal;

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

    public String getFrowNum() {
        return frowNum;
    }

    public void setFrowNum(String frowNum) {
        this.frowNum = frowNum == null ? null : frowNum.trim();
    }

    public String getFproject() {
        return fproject;
    }

    public void setFproject(String fproject) {
        this.fproject = fproject == null ? null : fproject.trim();
    }

    public BigDecimal getSaleBudget() {
        return saleBudget;
    }

    public void setSaleBudget(BigDecimal saleBudget) {
        this.saleBudget = saleBudget;
    }

    public BigDecimal getSaleActual() {
        return saleActual;
    }

    public void setSaleActual(BigDecimal saleActual) {
        this.saleActual = saleActual;
    }

    public BigDecimal getIncomeBudget() {
        return incomeBudget;
    }

    public void setIncomeBudget(BigDecimal incomeBudget) {
        this.incomeBudget = incomeBudget;
    }

    public BigDecimal getIncomeActual() {
        return incomeActual;
    }

    public void setIncomeActual(BigDecimal incomeActual) {
        this.incomeActual = incomeActual;
    }

    public BigDecimal getIncomeTotal() {
        return incomeTotal;
    }

    public void setIncomeTotal(BigDecimal incomeTotal) {
        this.incomeTotal = incomeTotal;
    }

    public BigDecimal getCostBudget() {
        return costBudget;
    }

    public void setCostBudget(BigDecimal costBudget) {
        this.costBudget = costBudget;
    }

    public BigDecimal getCostActual() {
        return costActual;
    }

    public void setCostActual(BigDecimal costActual) {
        this.costActual = costActual;
    }

    public BigDecimal getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(BigDecimal costTotal) {
        this.costTotal = costTotal;
    }

    public BigDecimal getSaleProfitBudget() {
        return saleProfitBudget;
    }

    public void setSaleProfitBudget(BigDecimal saleProfitBudget) {
        this.saleProfitBudget = saleProfitBudget;
    }

    public BigDecimal getSaleProfitActual() {
        return saleProfitActual;
    }

    public void setSaleProfitActual(BigDecimal saleProfitActual) {
        this.saleProfitActual = saleProfitActual;
    }

    public BigDecimal getSaleProfitBudgetRatio() {
        return saleProfitBudgetRatio;
    }

    public void setSaleProfitBudgetRatio(BigDecimal saleProfitBudgetRatio) {
        this.saleProfitBudgetRatio = saleProfitBudgetRatio;
    }

    public BigDecimal getSaleProfitActualRatio() {
        return saleProfitActualRatio;
    }

    public void setSaleProfitActualRatio(BigDecimal saleProfitActualRatio) {
        this.saleProfitActualRatio = saleProfitActualRatio;
    }

    public BigDecimal getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(BigDecimal saleTotal) {
        this.saleTotal = saleTotal;
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
        sb.append(", frowNum=").append(frowNum);
        sb.append(", fproject=").append(fproject);
        sb.append(", saleBudget=").append(saleBudget);
        sb.append(", saleActual=").append(saleActual);
        sb.append(", incomeBudget=").append(incomeBudget);
        sb.append(", incomeActual=").append(incomeActual);
        sb.append(", incomeTotal=").append(incomeTotal);
        sb.append(", costBudget=").append(costBudget);
        sb.append(", costActual=").append(costActual);
        sb.append(", costTotal=").append(costTotal);
        sb.append(", saleProfitBudget=").append(saleProfitBudget);
        sb.append(", saleProfitActual=").append(saleProfitActual);
        sb.append(", saleProfitBudgetRatio=").append(saleProfitBudgetRatio);
        sb.append(", saleProfitActualRatio=").append(saleProfitActualRatio);
        sb.append(", saleTotal=").append(saleTotal);
        sb.append(", fheadId=").append(fheadId);
        sb.append(", frowIndex=").append(frowIndex);
        sb.append(", fstrong=").append(fstrong);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}