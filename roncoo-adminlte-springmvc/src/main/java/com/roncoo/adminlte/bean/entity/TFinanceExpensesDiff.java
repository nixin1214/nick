package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TFinanceExpensesDiff implements Serializable {
    private Long fid;

    private Long fheadId;

    private Long frowIndex;

    private String fprojectName;

    private BigDecimal fafterYearThis;

    private BigDecimal fafterYearTotal;

    private BigDecimal fthisYearBudgetThis;

    private BigDecimal fthisYearBudgetTotal;

    private BigDecimal fthisYearActualMonth;

    private BigDecimal fthisYearActualThis;

    private BigDecimal fextend1;

    private BigDecimal fextend2;

    private BigDecimal fextend3;

    private String fseq;

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

    public BigDecimal getFafterYearThis() {
        return fafterYearThis;
    }

    public void setFafterYearThis(BigDecimal fafterYearThis) {
        this.fafterYearThis = fafterYearThis;
    }

    public BigDecimal getFafterYearTotal() {
        return fafterYearTotal;
    }

    public void setFafterYearTotal(BigDecimal fafterYearTotal) {
        this.fafterYearTotal = fafterYearTotal;
    }

    public BigDecimal getFthisYearBudgetThis() {
        return fthisYearBudgetThis;
    }

    public void setFthisYearBudgetThis(BigDecimal fthisYearBudgetThis) {
        this.fthisYearBudgetThis = fthisYearBudgetThis;
    }

    public BigDecimal getFthisYearBudgetTotal() {
        return fthisYearBudgetTotal;
    }

    public void setFthisYearBudgetTotal(BigDecimal fthisYearBudgetTotal) {
        this.fthisYearBudgetTotal = fthisYearBudgetTotal;
    }

    public BigDecimal getFthisYearActualMonth() {
        return fthisYearActualMonth;
    }

    public void setFthisYearActualMonth(BigDecimal fthisYearActualMonth) {
        this.fthisYearActualMonth = fthisYearActualMonth;
    }

    public BigDecimal getFthisYearActualThis() {
        return fthisYearActualThis;
    }

    public void setFthisYearActualThis(BigDecimal fthisYearActualThis) {
        this.fthisYearActualThis = fthisYearActualThis;
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

    public String getFseq() {
        return fseq;
    }

    public void setFseq(String fseq) {
        this.fseq = fseq == null ? null : fseq.trim();
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
        sb.append(", fafterYearThis=").append(fafterYearThis);
        sb.append(", fafterYearTotal=").append(fafterYearTotal);
        sb.append(", fthisYearBudgetThis=").append(fthisYearBudgetThis);
        sb.append(", fthisYearBudgetTotal=").append(fthisYearBudgetTotal);
        sb.append(", fthisYearActualMonth=").append(fthisYearActualMonth);
        sb.append(", fthisYearActualThis=").append(fthisYearActualThis);
        sb.append(", fextend1=").append(fextend1);
        sb.append(", fextend2=").append(fextend2);
        sb.append(", fextend3=").append(fextend3);
        sb.append(", fseq=").append(fseq);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}