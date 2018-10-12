package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 资产负债表(差额表)
 */
public class TFinanceBalanceDifference implements Serializable {
    private Long fid;

    private String fproject;

    private Integer frowNum;

    private BigDecimal periodEndAccount;

    private BigDecimal periodBeginAccount;

    private String fproject2;

    private Integer frowNum2;

    private BigDecimal periodEndAccount2;

    private BigDecimal periodBeginAccount2;

    private Long fheadId;

    private Integer frowIndex;

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

    public Integer getFrowNum() {
        return frowNum;
    }

    public void setFrowNum(Integer frowNum) {
        this.frowNum = frowNum;
    }

    public BigDecimal getPeriodEndAccount() {
        return periodEndAccount;
    }

    public void setPeriodEndAccount(BigDecimal periodEndAccount) {
        this.periodEndAccount = periodEndAccount;
    }

    public BigDecimal getPeriodBeginAccount() {
        return periodBeginAccount;
    }

    public void setPeriodBeginAccount(BigDecimal periodBeginAccount) {
        this.periodBeginAccount = periodBeginAccount;
    }

    public String getFproject2() {
        return fproject2;
    }

    public void setFproject2(String fproject2) {
        this.fproject2 = fproject2 == null ? null : fproject2.trim();
    }

    public Integer getFrowNum2() {
        return frowNum2;
    }

    public void setFrowNum2(Integer frowNum2) {
        this.frowNum2 = frowNum2;
    }

    public BigDecimal getPeriodEndAccount2() {
        return periodEndAccount2;
    }

    public void setPeriodEndAccount2(BigDecimal periodEndAccount2) {
        this.periodEndAccount2 = periodEndAccount2;
    }

    public BigDecimal getPeriodBeginAccount2() {
        return periodBeginAccount2;
    }

    public void setPeriodBeginAccount2(BigDecimal periodBeginAccount2) {
        this.periodBeginAccount2 = periodBeginAccount2;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", fproject=").append(fproject);
        sb.append(", frowNum=").append(frowNum);
        sb.append(", periodEndAccount=").append(periodEndAccount);
        sb.append(", periodBeginAccount=").append(periodBeginAccount);
        sb.append(", fproject2=").append(fproject2);
        sb.append(", frowNum2=").append(frowNum2);
        sb.append(", periodEndAccount2=").append(periodEndAccount2);
        sb.append(", periodBeginAccount2=").append(periodBeginAccount2);
        sb.append(", fheadId=").append(fheadId);
        sb.append(", frowIndex=").append(frowIndex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}