package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TFinanceFixedAssetsInv implements Serializable {
    private Long fid;

    private Long fheadId;

    private Integer frowIndex;

    private String fseq;

    private String fprojectName;

    private BigDecimal ftotalAmount;

    private BigDecimal fafterUnfinishedAmount;

    private BigDecimal fthisMonthAmount;

    private BigDecimal fthisYearAmount;

    private BigDecimal fpaidAmount;

    private BigDecimal fthisUnfinishedAmount;

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

    public BigDecimal getFtotalAmount() {
        return ftotalAmount;
    }

    public void setFtotalAmount(BigDecimal ftotalAmount) {
        this.ftotalAmount = ftotalAmount;
    }

    public BigDecimal getFafterUnfinishedAmount() {
        return fafterUnfinishedAmount;
    }

    public void setFafterUnfinishedAmount(BigDecimal fafterUnfinishedAmount) {
        this.fafterUnfinishedAmount = fafterUnfinishedAmount;
    }

    public BigDecimal getFthisMonthAmount() {
        return fthisMonthAmount;
    }

    public void setFthisMonthAmount(BigDecimal fthisMonthAmount) {
        this.fthisMonthAmount = fthisMonthAmount;
    }

    public BigDecimal getFthisYearAmount() {
        return fthisYearAmount;
    }

    public void setFthisYearAmount(BigDecimal fthisYearAmount) {
        this.fthisYearAmount = fthisYearAmount;
    }

    public BigDecimal getFpaidAmount() {
        return fpaidAmount;
    }

    public void setFpaidAmount(BigDecimal fpaidAmount) {
        this.fpaidAmount = fpaidAmount;
    }

    public BigDecimal getFthisUnfinishedAmount() {
        return fthisUnfinishedAmount;
    }

    public void setFthisUnfinishedAmount(BigDecimal fthisUnfinishedAmount) {
        this.fthisUnfinishedAmount = fthisUnfinishedAmount;
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
        sb.append(", fseq=").append(fseq);
        sb.append(", fprojectName=").append(fprojectName);
        sb.append(", ftotalAmount=").append(ftotalAmount);
        sb.append(", fafterUnfinishedAmount=").append(fafterUnfinishedAmount);
        sb.append(", fthisMonthAmount=").append(fthisMonthAmount);
        sb.append(", fthisYearAmount=").append(fthisYearAmount);
        sb.append(", fpaidAmount=").append(fpaidAmount);
        sb.append(", fthisUnfinishedAmount=").append(fthisUnfinishedAmount);
        sb.append(", fextend1=").append(fextend1);
        sb.append(", fextend2=").append(fextend2);
        sb.append(", fextend3=").append(fextend3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}