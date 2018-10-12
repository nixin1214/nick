package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class HsmryProductListBudget implements Serializable {
    private BigDecimal fid;

    private String yearmonth;

    private String productname;

    private BigDecimal salesvolume;

    private BigDecimal salesamount;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public BigDecimal getFid() {
        return fid;
    }

    public void setFid(BigDecimal fid) {
        this.fid = fid;
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public BigDecimal getSalesvolume() {
        return salesvolume;
    }

    public void setSalesvolume(BigDecimal salesvolume) {
        this.salesvolume = salesvolume;
    }

    public BigDecimal getSalesamount() {
        return salesamount;
    }

    public void setSalesamount(BigDecimal salesamount) {
        this.salesamount = salesamount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
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
        HsmryProductListBudget other = (HsmryProductListBudget) that;
        return (this.getFid() == null ? other.getFid() == null : this.getFid().equals(other.getFid()))
            && (this.getYearmonth() == null ? other.getYearmonth() == null : this.getYearmonth().equals(other.getYearmonth()))
            && (this.getProductname() == null ? other.getProductname() == null : this.getProductname().equals(other.getProductname()))
            && (this.getSalesvolume() == null ? other.getSalesvolume() == null : this.getSalesvolume().equals(other.getSalesvolume()))
            && (this.getSalesamount() == null ? other.getSalesamount() == null : this.getSalesamount().equals(other.getSalesamount()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFid() == null) ? 0 : getFid().hashCode());
        result = prime * result + ((getYearmonth() == null) ? 0 : getYearmonth().hashCode());
        result = prime * result + ((getProductname() == null) ? 0 : getProductname().hashCode());
        result = prime * result + ((getSalesvolume() == null) ? 0 : getSalesvolume().hashCode());
        result = prime * result + ((getSalesamount() == null) ? 0 : getSalesamount().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", yearmonth=").append(yearmonth);
        sb.append(", productname=").append(productname);
        sb.append(", salesvolume=").append(salesvolume);
        sb.append(", salesamount=").append(salesamount);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}