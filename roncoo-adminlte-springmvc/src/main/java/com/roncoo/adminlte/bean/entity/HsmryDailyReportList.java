package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class HsmryDailyReportList implements Serializable {
    private BigDecimal fid;

    private String classification;

    private String productName;

    private BigDecimal salesVolumeTotal = BigDecimal.ZERO;

    private BigDecimal salesAmountTatal = BigDecimal.ZERO;

    private BigDecimal salesVolumeBudget = BigDecimal.ZERO;

    private BigDecimal salesAmountBudget = BigDecimal.ZERO;

    private BigDecimal salesVolumeActual = BigDecimal.ZERO;

    private BigDecimal salesAmountActual = BigDecimal.ZERO;

    private Date createtime;

    private Long days = 0l;

    private static final long serialVersionUID = 1L;

    public BigDecimal getFid() {
        return fid;
    }

    public void setFid(BigDecimal fid) {
        this.fid = fid;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getSalesVolumeTotal() {
        return salesVolumeTotal;
    }

    public void setSalesVolumeTotal(BigDecimal salesVolumeTotal) {
        this.salesVolumeTotal = salesVolumeTotal;
    }

    public BigDecimal getSalesAmountTatal() {
        return salesAmountTatal;
    }

    public void setSalesAmountTatal(BigDecimal salesAmountTatal) {
        this.salesAmountTatal = salesAmountTatal;
    }

    public BigDecimal getSalesVolumeBudget() {
        return salesVolumeBudget;
    }

    public void setSalesVolumeBudget(BigDecimal salesVolumeBudget) {
        this.salesVolumeBudget = salesVolumeBudget;
    }

    public BigDecimal getSalesAmountBudget() {
        return salesAmountBudget;
    }

    public void setSalesAmountBudget(BigDecimal salesAmountBudget) {
        this.salesAmountBudget = salesAmountBudget;
    }

    public BigDecimal getSalesVolumeActual() {
        return salesVolumeActual;
    }

    public void setSalesVolumeActual(BigDecimal salesVolumeActual) {
        this.salesVolumeActual = salesVolumeActual;
    }

    public BigDecimal getSalesAmountActual() {
        return salesAmountActual;
    }

    public void setSalesAmountActual(BigDecimal salesAmountActual) {
        this.salesAmountActual = salesAmountActual;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
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
        HsmryDailyReportList other = (HsmryDailyReportList) that;
        return (this.getFid() == null ? other.getFid() == null : this.getFid().equals(other.getFid()))
            && (this.getClassification() == null ? other.getClassification() == null : this.getClassification().equals(other.getClassification()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getSalesVolumeTotal() == null ? other.getSalesVolumeTotal() == null : this.getSalesVolumeTotal().equals(other.getSalesVolumeTotal()))
            && (this.getSalesAmountTatal() == null ? other.getSalesAmountTatal() == null : this.getSalesAmountTatal().equals(other.getSalesAmountTatal()))
            && (this.getSalesVolumeBudget() == null ? other.getSalesVolumeBudget() == null : this.getSalesVolumeBudget().equals(other.getSalesVolumeBudget()))
            && (this.getSalesAmountBudget() == null ? other.getSalesAmountBudget() == null : this.getSalesAmountBudget().equals(other.getSalesAmountBudget()))
            && (this.getSalesVolumeActual() == null ? other.getSalesVolumeActual() == null : this.getSalesVolumeActual().equals(other.getSalesVolumeActual()))
            && (this.getSalesAmountActual() == null ? other.getSalesAmountActual() == null : this.getSalesAmountActual().equals(other.getSalesAmountActual()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFid() == null) ? 0 : getFid().hashCode());
        result = prime * result + ((getClassification() == null) ? 0 : getClassification().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getSalesVolumeTotal() == null) ? 0 : getSalesVolumeTotal().hashCode());
        result = prime * result + ((getSalesAmountTatal() == null) ? 0 : getSalesAmountTatal().hashCode());
        result = prime * result + ((getSalesVolumeBudget() == null) ? 0 : getSalesVolumeBudget().hashCode());
        result = prime * result + ((getSalesAmountBudget() == null) ? 0 : getSalesAmountBudget().hashCode());
        result = prime * result + ((getSalesVolumeActual() == null) ? 0 : getSalesVolumeActual().hashCode());
        result = prime * result + ((getSalesAmountActual() == null) ? 0 : getSalesAmountActual().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", classification=").append(classification);
        sb.append(", productName=").append(productName);
        sb.append(", salesVolumeTotal=").append(salesVolumeTotal);
        sb.append(", salesAmountTatal=").append(salesAmountTatal);
        sb.append(", salesVolumeBudget=").append(salesVolumeBudget);
        sb.append(", salesAmountBudget=").append(salesAmountBudget);
        sb.append(", salesVolumeActual=").append(salesVolumeActual);
        sb.append(", salesAmountActual=").append(salesAmountActual);
        sb.append(", createtime=").append(createtime);
        sb.append(", days=").append(days);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}