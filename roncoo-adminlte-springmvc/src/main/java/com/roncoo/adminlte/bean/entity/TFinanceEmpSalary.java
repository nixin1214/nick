package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 
 */
public class TFinanceEmpSalary implements Serializable {
    private Long fid;

    private Long fheadId;

    private Integer frowIndex;

    private String fprojectName;

    private BigDecimal fthisBeginPeriodAmount;

    private BigDecimal fthisPeriodAmount;

    private BigDecimal fthisPeriodPaidAmount;

    private BigDecimal fthisPeriodEndAmount;

    private BigDecimal ftotalBeginPeriodAmount;

    private BigDecimal ftotalPeriodAmount;

    private BigDecimal ftotalPeriodPaidAmount;

    private BigDecimal ftotalPeriodEndAmount;

    private BigDecimal fextend1;

    private BigDecimal fextend2;

    private BigDecimal fextend3;

    private BigDecimal fthisBudget;

    private BigDecimal ftotalBudget;

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
        this.fprojectName = fprojectName;
    }

    public BigDecimal getFthisBeginPeriodAmount() {
        return fthisBeginPeriodAmount;
    }

    public void setFthisBeginPeriodAmount(BigDecimal fthisBeginPeriodAmount) {
        this.fthisBeginPeriodAmount = fthisBeginPeriodAmount;
    }

    public BigDecimal getFthisPeriodAmount() {
        return fthisPeriodAmount;
    }

    public void setFthisPeriodAmount(BigDecimal fthisPeriodAmount) {
        this.fthisPeriodAmount = fthisPeriodAmount;
    }

    public BigDecimal getFthisPeriodPaidAmount() {
        return fthisPeriodPaidAmount;
    }

    public void setFthisPeriodPaidAmount(BigDecimal fthisPeriodPaidAmount) {
        this.fthisPeriodPaidAmount = fthisPeriodPaidAmount;
    }

    public BigDecimal getFthisPeriodEndAmount() {
        return fthisPeriodEndAmount;
    }

    public void setFthisPeriodEndAmount(BigDecimal fthisPeriodEndAmount) {
        this.fthisPeriodEndAmount = fthisPeriodEndAmount;
    }

    public BigDecimal getFtotalBeginPeriodAmount() {
        return ftotalBeginPeriodAmount;
    }

    public void setFtotalBeginPeriodAmount(BigDecimal ftotalBeginPeriodAmount) {
        this.ftotalBeginPeriodAmount = ftotalBeginPeriodAmount;
    }

    public BigDecimal getFtotalPeriodAmount() {
        return ftotalPeriodAmount;
    }

    public void setFtotalPeriodAmount(BigDecimal ftotalPeriodAmount) {
        this.ftotalPeriodAmount = ftotalPeriodAmount;
    }

    public BigDecimal getFtotalPeriodPaidAmount() {
        return ftotalPeriodPaidAmount;
    }

    public void setFtotalPeriodPaidAmount(BigDecimal ftotalPeriodPaidAmount) {
        this.ftotalPeriodPaidAmount = ftotalPeriodPaidAmount;
    }

    public BigDecimal getFtotalPeriodEndAmount() {
        return ftotalPeriodEndAmount;
    }

    public void setFtotalPeriodEndAmount(BigDecimal ftotalPeriodEndAmount) {
        this.ftotalPeriodEndAmount = ftotalPeriodEndAmount;
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

    public BigDecimal getFthisBudget() {
        return fthisBudget;
    }

    public void setFthisBudget(BigDecimal fthisBudget) {
        this.fthisBudget = fthisBudget;
    }

    public BigDecimal getFtotalBudget() {
        return ftotalBudget;
    }

    public void setFtotalBudget(BigDecimal ftotalBudget) {
        this.ftotalBudget = ftotalBudget;
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
        TFinanceEmpSalary other = (TFinanceEmpSalary) that;
        return (this.getFid() == null ? other.getFid() == null : this.getFid().equals(other.getFid()))
            && (this.getFheadId() == null ? other.getFheadId() == null : this.getFheadId().equals(other.getFheadId()))
            && (this.getFrowIndex() == null ? other.getFrowIndex() == null : this.getFrowIndex().equals(other.getFrowIndex()))
            && (this.getFprojectName() == null ? other.getFprojectName() == null : this.getFprojectName().equals(other.getFprojectName()))
            && (this.getFthisBeginPeriodAmount() == null ? other.getFthisBeginPeriodAmount() == null : this.getFthisBeginPeriodAmount().equals(other.getFthisBeginPeriodAmount()))
            && (this.getFthisPeriodAmount() == null ? other.getFthisPeriodAmount() == null : this.getFthisPeriodAmount().equals(other.getFthisPeriodAmount()))
            && (this.getFthisPeriodPaidAmount() == null ? other.getFthisPeriodPaidAmount() == null : this.getFthisPeriodPaidAmount().equals(other.getFthisPeriodPaidAmount()))
            && (this.getFthisPeriodEndAmount() == null ? other.getFthisPeriodEndAmount() == null : this.getFthisPeriodEndAmount().equals(other.getFthisPeriodEndAmount()))
            && (this.getFtotalBeginPeriodAmount() == null ? other.getFtotalBeginPeriodAmount() == null : this.getFtotalBeginPeriodAmount().equals(other.getFtotalBeginPeriodAmount()))
            && (this.getFtotalPeriodAmount() == null ? other.getFtotalPeriodAmount() == null : this.getFtotalPeriodAmount().equals(other.getFtotalPeriodAmount()))
            && (this.getFtotalPeriodPaidAmount() == null ? other.getFtotalPeriodPaidAmount() == null : this.getFtotalPeriodPaidAmount().equals(other.getFtotalPeriodPaidAmount()))
            && (this.getFtotalPeriodEndAmount() == null ? other.getFtotalPeriodEndAmount() == null : this.getFtotalPeriodEndAmount().equals(other.getFtotalPeriodEndAmount()))
            && (this.getFextend1() == null ? other.getFextend1() == null : this.getFextend1().equals(other.getFextend1()))
            && (this.getFextend2() == null ? other.getFextend2() == null : this.getFextend2().equals(other.getFextend2()))
            && (this.getFextend3() == null ? other.getFextend3() == null : this.getFextend3().equals(other.getFextend3()))
            && (this.getFthisBudget() == null ? other.getFthisBudget() == null : this.getFthisBudget().equals(other.getFthisBudget()))
            && (this.getFtotalBudget() == null ? other.getFtotalBudget() == null : this.getFtotalBudget().equals(other.getFtotalBudget()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFid() == null) ? 0 : getFid().hashCode());
        result = prime * result + ((getFheadId() == null) ? 0 : getFheadId().hashCode());
        result = prime * result + ((getFrowIndex() == null) ? 0 : getFrowIndex().hashCode());
        result = prime * result + ((getFprojectName() == null) ? 0 : getFprojectName().hashCode());
        result = prime * result + ((getFthisBeginPeriodAmount() == null) ? 0 : getFthisBeginPeriodAmount().hashCode());
        result = prime * result + ((getFthisPeriodAmount() == null) ? 0 : getFthisPeriodAmount().hashCode());
        result = prime * result + ((getFthisPeriodPaidAmount() == null) ? 0 : getFthisPeriodPaidAmount().hashCode());
        result = prime * result + ((getFthisPeriodEndAmount() == null) ? 0 : getFthisPeriodEndAmount().hashCode());
        result = prime * result + ((getFtotalBeginPeriodAmount() == null) ? 0 : getFtotalBeginPeriodAmount().hashCode());
        result = prime * result + ((getFtotalPeriodAmount() == null) ? 0 : getFtotalPeriodAmount().hashCode());
        result = prime * result + ((getFtotalPeriodPaidAmount() == null) ? 0 : getFtotalPeriodPaidAmount().hashCode());
        result = prime * result + ((getFtotalPeriodEndAmount() == null) ? 0 : getFtotalPeriodEndAmount().hashCode());
        result = prime * result + ((getFextend1() == null) ? 0 : getFextend1().hashCode());
        result = prime * result + ((getFextend2() == null) ? 0 : getFextend2().hashCode());
        result = prime * result + ((getFextend3() == null) ? 0 : getFextend3().hashCode());
        result = prime * result + ((getFthisBudget() == null) ? 0 : getFthisBudget().hashCode());
        result = prime * result + ((getFtotalBudget() == null) ? 0 : getFtotalBudget().hashCode());
        return result;
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
        sb.append(", fthisBeginPeriodAmount=").append(fthisBeginPeriodAmount);
        sb.append(", fthisPeriodAmount=").append(fthisPeriodAmount);
        sb.append(", fthisPeriodPaidAmount=").append(fthisPeriodPaidAmount);
        sb.append(", fthisPeriodEndAmount=").append(fthisPeriodEndAmount);
        sb.append(", ftotalBeginPeriodAmount=").append(ftotalBeginPeriodAmount);
        sb.append(", ftotalPeriodAmount=").append(ftotalPeriodAmount);
        sb.append(", ftotalPeriodPaidAmount=").append(ftotalPeriodPaidAmount);
        sb.append(", ftotalPeriodEndAmount=").append(ftotalPeriodEndAmount);
        sb.append(", fextend1=").append(fextend1);
        sb.append(", fextend2=").append(fextend2);
        sb.append(", fextend3=").append(fextend3);
        sb.append(", fthisBudget=").append(fthisBudget);
        sb.append(", ftotalBudget=").append(ftotalBudget);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}