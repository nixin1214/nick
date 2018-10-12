package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 
 */

public class TFinanceMainBusinessListM implements Serializable {
    private BigDecimal fid;

    private String frowNum;

    private String fproject;

    private BigDecimal salesVolume;

    private BigDecimal sellingUnitPrice;

    private BigDecimal sellingAmont;

    private BigDecimal costUnit;

    private BigDecimal costAmont;

    private BigDecimal saleProfitUnit;

    private BigDecimal saleProfitCount;

    private BigDecimal saleProfitRatio;

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

    public String getFrowNum() {
        return frowNum;
    }

    public void setFrowNum(String frowNum) {
        this.frowNum = frowNum;
    }

    public String getFproject() {
        return fproject;
    }

    public void setFproject(String fproject) {
        this.fproject = fproject;
    }

    public BigDecimal getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(BigDecimal salesVolume) {
        this.salesVolume = salesVolume;
    }

    public BigDecimal getSellingUnitPrice() {
        return sellingUnitPrice;
    }

    public void setSellingUnitPrice(BigDecimal sellingUnitPrice) {
        this.sellingUnitPrice = sellingUnitPrice;
    }

    public BigDecimal getSellingAmont() {
        return sellingAmont;
    }

    public void setSellingAmont(BigDecimal sellingAmont) {
        this.sellingAmont = sellingAmont;
    }

    public BigDecimal getCostUnit() {
        return costUnit;
    }

    public void setCostUnit(BigDecimal costUnit) {
        this.costUnit = costUnit;
    }

    public BigDecimal getCostAmont() {
        return costAmont;
    }

    public void setCostAmont(BigDecimal costAmont) {
        this.costAmont = costAmont;
    }

    public BigDecimal getSaleProfitUnit() {
        return saleProfitUnit;
    }

    public void setSaleProfitUnit(BigDecimal saleProfitUnit) {
        this.saleProfitUnit = saleProfitUnit;
    }

    public BigDecimal getSaleProfitCount() {
        return saleProfitCount;
    }

    public void setSaleProfitCount(BigDecimal saleProfitCount) {
        this.saleProfitCount = saleProfitCount;
    }

    public BigDecimal getSaleProfitRatio() {
        return saleProfitRatio;
    }

    public void setSaleProfitRatio(BigDecimal saleProfitRatio) {
        this.saleProfitRatio = saleProfitRatio;
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
        TFinanceMainBusinessListM other = (TFinanceMainBusinessListM) that;
        return (this.getFid() == null ? other.getFid() == null : this.getFid().equals(other.getFid()))
            && (this.getFrowNum() == null ? other.getFrowNum() == null : this.getFrowNum().equals(other.getFrowNum()))
            && (this.getFproject() == null ? other.getFproject() == null : this.getFproject().equals(other.getFproject()))
            && (this.getSalesVolume() == null ? other.getSalesVolume() == null : this.getSalesVolume().equals(other.getSalesVolume()))
            && (this.getSellingUnitPrice() == null ? other.getSellingUnitPrice() == null : this.getSellingUnitPrice().equals(other.getSellingUnitPrice()))
            && (this.getSellingAmont() == null ? other.getSellingAmont() == null : this.getSellingAmont().equals(other.getSellingAmont()))
            && (this.getCostUnit() == null ? other.getCostUnit() == null : this.getCostUnit().equals(other.getCostUnit()))
            && (this.getCostAmont() == null ? other.getCostAmont() == null : this.getCostAmont().equals(other.getCostAmont()))
            && (this.getSaleProfitUnit() == null ? other.getSaleProfitUnit() == null : this.getSaleProfitUnit().equals(other.getSaleProfitUnit()))
            && (this.getSaleProfitCount() == null ? other.getSaleProfitCount() == null : this.getSaleProfitCount().equals(other.getSaleProfitCount()))
            && (this.getSaleProfitRatio() == null ? other.getSaleProfitRatio() == null : this.getSaleProfitRatio().equals(other.getSaleProfitRatio()))
            && (this.getFheadId() == null ? other.getFheadId() == null : this.getFheadId().equals(other.getFheadId()))
            && (this.getFrowIndex() == null ? other.getFrowIndex() == null : this.getFrowIndex().equals(other.getFrowIndex()))
            && (this.getFstrong() == null ? other.getFstrong() == null : this.getFstrong().equals(other.getFstrong()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFid() == null) ? 0 : getFid().hashCode());
        result = prime * result + ((getFrowNum() == null) ? 0 : getFrowNum().hashCode());
        result = prime * result + ((getFproject() == null) ? 0 : getFproject().hashCode());
        result = prime * result + ((getSalesVolume() == null) ? 0 : getSalesVolume().hashCode());
        result = prime * result + ((getSellingUnitPrice() == null) ? 0 : getSellingUnitPrice().hashCode());
        result = prime * result + ((getSellingAmont() == null) ? 0 : getSellingAmont().hashCode());
        result = prime * result + ((getCostUnit() == null) ? 0 : getCostUnit().hashCode());
        result = prime * result + ((getCostAmont() == null) ? 0 : getCostAmont().hashCode());
        result = prime * result + ((getSaleProfitUnit() == null) ? 0 : getSaleProfitUnit().hashCode());
        result = prime * result + ((getSaleProfitCount() == null) ? 0 : getSaleProfitCount().hashCode());
        result = prime * result + ((getSaleProfitRatio() == null) ? 0 : getSaleProfitRatio().hashCode());
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
        sb.append(", frowNum=").append(frowNum);
        sb.append(", fproject=").append(fproject);
        sb.append(", salesVolume=").append(salesVolume);
        sb.append(", sellingUnitPrice=").append(sellingUnitPrice);
        sb.append(", sellingAmont=").append(sellingAmont);
        sb.append(", costUnit=").append(costUnit);
        sb.append(", costAmont=").append(costAmont);
        sb.append(", saleProfitUnit=").append(saleProfitUnit);
        sb.append(", saleProfitCount=").append(saleProfitCount);
        sb.append(", saleProfitRatio=").append(saleProfitRatio);
        sb.append(", fheadId=").append(fheadId);
        sb.append(", frowIndex=").append(frowIndex);
        sb.append(", fstrong=").append(fstrong);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}