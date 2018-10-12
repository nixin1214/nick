package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TAccountsReceivable implements Serializable {
    private BigDecimal fid;

    private BigDecimal fheadId;

    private Long frowIndex;

    private String distributor;

    private BigDecimal accountsReceivable;

    private BigDecimal growthRate;

    private BigDecimal ringRatio;

    private BigDecimal yearOn;

    private static final long serialVersionUID = 1L;

    public BigDecimal getFid() {
        return fid;
    }

    public void setFid(BigDecimal fid) {
        this.fid = fid;
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

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor == null ? null : distributor.trim();
    }

    public BigDecimal getAccountsReceivable() {
        return accountsReceivable;
    }

    public void setAccountsReceivable(BigDecimal accountsReceivable) {
        this.accountsReceivable = accountsReceivable;
    }

    public BigDecimal getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(BigDecimal growthRate) {
        this.growthRate = growthRate;
    }

    public BigDecimal getRingRatio() {
        return ringRatio;
    }

    public void setRingRatio(BigDecimal ringRatio) {
        this.ringRatio = ringRatio;
    }

    public BigDecimal getYearOn() {
        return yearOn;
    }

    public void setYearOn(BigDecimal yearOn) {
        this.yearOn = yearOn;
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
        sb.append(", distributor=").append(distributor);
        sb.append(", accountsReceivable=").append(accountsReceivable);
        sb.append(", growthRate=").append(growthRate);
        sb.append(", ringRatio=").append(ringRatio);
        sb.append(", yearOn=").append(yearOn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}