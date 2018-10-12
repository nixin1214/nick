package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class HSMRYSALEREPORT implements Serializable {
    private String FYEAR_MONTH;

    private BigDecimal FWEIGHT;

    private BigDecimal FAMOUNT;

    private String FCHANNEL;

    private String FAREA;

    private String FPRODUCT_TYPE;

    private Date FCREATIME;

    private String FID;

    private static final long serialVersionUID = 1L;

    public String getFYEAR_MONTH() {
        return FYEAR_MONTH;
    }

    public void setFYEAR_MONTH(String FYEAR_MONTH) {
        this.FYEAR_MONTH = FYEAR_MONTH;
    }

    public BigDecimal getFWEIGHT() {
        return FWEIGHT;
    }

    public void setFWEIGHT(BigDecimal FWEIGHT) {
        this.FWEIGHT = FWEIGHT;
    }

    public BigDecimal getFAMOUNT() {
        return FAMOUNT;
    }

    public void setFAMOUNT(BigDecimal FAMOUNT) {
        this.FAMOUNT = FAMOUNT;
    }

    public String getFCHANNEL() {
        return FCHANNEL;
    }

    public void setFCHANNEL(String FCHANNEL) {
        this.FCHANNEL = FCHANNEL;
    }

    public String getFAREA() {
        return FAREA;
    }

    public void setFAREA(String FAREA) {
        this.FAREA = FAREA;
    }

    public String getFPRODUCT_TYPE() {
        return FPRODUCT_TYPE;
    }

    public void setFPRODUCT_TYPE(String FPRODUCT_TYPE) {
        this.FPRODUCT_TYPE = FPRODUCT_TYPE;
    }

    public Date getFCREATIME() {
        return FCREATIME;
    }

    public void setFCREATIME(Date FCREATIME) {
        this.FCREATIME = FCREATIME;
    }

    public String getFID() {
        return FID;
    }

    public void setFID(String FID) {
        this.FID = FID;
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
        HSMRYSALEREPORT other = (HSMRYSALEREPORT) that;
        return (this.getFYEAR_MONTH() == null ? other.getFYEAR_MONTH() == null : this.getFYEAR_MONTH().equals(other.getFYEAR_MONTH()))
            && (this.getFWEIGHT() == null ? other.getFWEIGHT() == null : this.getFWEIGHT().equals(other.getFWEIGHT()))
            && (this.getFAMOUNT() == null ? other.getFAMOUNT() == null : this.getFAMOUNT().equals(other.getFAMOUNT()))
            && (this.getFCHANNEL() == null ? other.getFCHANNEL() == null : this.getFCHANNEL().equals(other.getFCHANNEL()))
            && (this.getFAREA() == null ? other.getFAREA() == null : this.getFAREA().equals(other.getFAREA()))
            && (this.getFPRODUCT_TYPE() == null ? other.getFPRODUCT_TYPE() == null : this.getFPRODUCT_TYPE().equals(other.getFPRODUCT_TYPE()))
            && (this.getFCREATIME() == null ? other.getFCREATIME() == null : this.getFCREATIME().equals(other.getFCREATIME()))
            && (this.getFID() == null ? other.getFID() == null : this.getFID().equals(other.getFID()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFYEAR_MONTH() == null) ? 0 : getFYEAR_MONTH().hashCode());
        result = prime * result + ((getFWEIGHT() == null) ? 0 : getFWEIGHT().hashCode());
        result = prime * result + ((getFAMOUNT() == null) ? 0 : getFAMOUNT().hashCode());
        result = prime * result + ((getFCHANNEL() == null) ? 0 : getFCHANNEL().hashCode());
        result = prime * result + ((getFAREA() == null) ? 0 : getFAREA().hashCode());
        result = prime * result + ((getFPRODUCT_TYPE() == null) ? 0 : getFPRODUCT_TYPE().hashCode());
        result = prime * result + ((getFCREATIME() == null) ? 0 : getFCREATIME().hashCode());
        result = prime * result + ((getFID() == null) ? 0 : getFID().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", FYEAR_MONTH=").append(FYEAR_MONTH);
        sb.append(", FWEIGHT=").append(FWEIGHT);
        sb.append(", FAMOUNT=").append(FAMOUNT);
        sb.append(", FCHANNEL=").append(FCHANNEL);
        sb.append(", FAREA=").append(FAREA);
        sb.append(", FPRODUCT_TYPE=").append(FPRODUCT_TYPE);
        sb.append(", FCREATIME=").append(FCREATIME);
        sb.append(", FID=").append(FID);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}