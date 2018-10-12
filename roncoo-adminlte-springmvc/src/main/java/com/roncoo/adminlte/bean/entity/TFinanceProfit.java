package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 
 */
public class TFinanceProfit implements Serializable {
    private BigDecimal fid;

    private String fproject;

    private Long frowNum;

    private BigDecimal lastYearActual;

    private BigDecimal lastYearTotal;

    private BigDecimal thisYearBudget;

    private BigDecimal thisYearBudgetTotal;

    private BigDecimal thisYearActual;

    private BigDecimal thisYearActualTotal;

    private BigDecimal fheadId;

    private Long frowIndex;

    private Long fstrong;

    private static final long serialVersionUID = 1L;

    public BigDecimal getFid() {
        return fid;
    }

    public void setFid(BigDecimal fid) {
        this.fid = fid;
    }

    public String getFproject() {
        return fproject;
    }

    public void setFproject(String fproject) {
        this.fproject = fproject;
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

    public BigDecimal getFheadId() {
        return fheadId;
    }

    public void setFheadId(BigDecimal fheadId) {
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
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TFinanceProfit other = (TFinanceProfit) that;
        return (this.getFid() == null ? other.getFid() == null : this.getFid().equals(other.getFid()))
            && (this.getFproject() == null ? other.getFproject() == null : this.getFproject().equals(other.getFproject()))
            && (this.getFrowNum() == null ? other.getFrowNum() == null : this.getFrowNum().equals(other.getFrowNum()))
            && (this.getLastYearActual() == null ? other.getLastYearActual() == null : this.getLastYearActual().equals(other.getLastYearActual()))
            && (this.getLastYearTotal() == null ? other.getLastYearTotal() == null : this.getLastYearTotal().equals(other.getLastYearTotal()))
            && (this.getThisYearBudget() == null ? other.getThisYearBudget() == null : this.getThisYearBudget().equals(other.getThisYearBudget()))
            && (this.getThisYearBudgetTotal() == null ? other.getThisYearBudgetTotal() == null : this.getThisYearBudgetTotal().equals(other.getThisYearBudgetTotal()))
            && (this.getThisYearActual() == null ? other.getThisYearActual() == null : this.getThisYearActual().equals(other.getThisYearActual()))
            && (this.getThisYearActualTotal() == null ? other.getThisYearActualTotal() == null : this.getThisYearActualTotal().equals(other.getThisYearActualTotal()))
            && (this.getFheadId() == null ? other.getFheadId() == null : this.getFheadId().equals(other.getFheadId()))
            && (this.getFrowIndex() == null ? other.getFrowIndex() == null : this.getFrowIndex().equals(other.getFrowIndex()))
            && (this.getFstrong() == null ? other.getFstrong() == null : this.getFstrong().equals(other.getFstrong()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFid() == null) ? 0 : getFid().hashCode());
        result = prime * result + ((getFproject() == null) ? 0 : getFproject().hashCode());
        result = prime * result + ((getFrowNum() == null) ? 0 : getFrowNum().hashCode());
        result = prime * result + ((getLastYearActual() == null) ? 0 : getLastYearActual().hashCode());
        result = prime * result + ((getLastYearTotal() == null) ? 0 : getLastYearTotal().hashCode());
        result = prime * result + ((getThisYearBudget() == null) ? 0 : getThisYearBudget().hashCode());
        result = prime * result + ((getThisYearBudgetTotal() == null) ? 0 : getThisYearBudgetTotal().hashCode());
        result = prime * result + ((getThisYearActual() == null) ? 0 : getThisYearActual().hashCode());
        result = prime * result + ((getThisYearActualTotal() == null) ? 0 : getThisYearActualTotal().hashCode());
        result = prime * result + ((getFheadId() == null) ? 0 : getFheadId().hashCode());
        result = prime * result + ((getFrowIndex() == null) ? 0 : getFrowIndex().hashCode());
        result = prime * result + ((getFstrong() == null) ? 0 : getFstrong().hashCode());
        return result;
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