package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author
 */
public class Payrecord implements Serializable {
    private String oilname;

    private BigDecimal oilprice;

    private BigDecimal liters;

    private BigDecimal amount;

    private String finishtime;

    private String cardno;

    private BigDecimal cardremain;

    private String carno;

    private String cardname;

    private String stationname;

    private static final long serialVersionUID = 1L;

    public String getOilname() {
        return oilname;
    }

    public void setOilname(String oilname) {
        this.oilname = oilname;
    }

    public BigDecimal getOilprice() {
        return oilprice;
    }

    public void setOilprice(BigDecimal oilprice) {
        this.oilprice = oilprice;
    }

    public BigDecimal getLiters() {
        return liters;
    }

    public void setLiters(BigDecimal liters) {
        this.liters = liters;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public BigDecimal getCardremain() {
        return cardremain;
    }

    public void setCardremain(BigDecimal cardremain) {
        this.cardremain = cardremain;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
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
        Payrecord other = (Payrecord) that;
        return (this.getOilname() == null ? other.getOilname() == null : this.getOilname().equals(other.getOilname()))
                && (this.getOilprice() == null ? other.getOilprice() == null : this.getOilprice().equals(other.getOilprice()))
                && (this.getLiters() == null ? other.getLiters() == null : this.getLiters().equals(other.getLiters()))
                && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
                && (this.getFinishtime() == null ? other.getFinishtime() == null : this.getFinishtime().equals(other.getFinishtime()))
                && (this.getCardno() == null ? other.getCardno() == null : this.getCardno().equals(other.getCardno()))
                && (this.getCardremain() == null ? other.getCardremain() == null : this.getCardremain().equals(other.getCardremain()))
                && (this.getCarno() == null ? other.getCarno() == null : this.getCarno().equals(other.getCarno()))
                && (this.getCardname() == null ? other.getCardname() == null : this.getCardname().equals(other.getCardname()))
                && (this.getStationname() == null ? other.getStationname() == null : this.getStationname().equals(other.getStationname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOilname() == null) ? 0 : getOilname().hashCode());
        result = prime * result + ((getOilprice() == null) ? 0 : getOilprice().hashCode());
        result = prime * result + ((getLiters() == null) ? 0 : getLiters().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getFinishtime() == null) ? 0 : getFinishtime().hashCode());
        result = prime * result + ((getCardno() == null) ? 0 : getCardno().hashCode());
        result = prime * result + ((getCardremain() == null) ? 0 : getCardremain().hashCode());
        result = prime * result + ((getCarno() == null) ? 0 : getCarno().hashCode());
        result = prime * result + ((getCardname() == null) ? 0 : getCardname().hashCode());
        result = prime * result + ((getStationname() == null) ? 0 : getStationname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oilname=").append(oilname);
        sb.append(", oilprice=").append(oilprice);
        sb.append(", liters=").append(liters);
        sb.append(", amount=").append(amount);
        sb.append(", finishtime=").append(finishtime);
        sb.append(", cardno=").append(cardno);
        sb.append(", cardremain=").append(cardremain);
        sb.append(", carno=").append(carno);
        sb.append(", cardname=").append(cardname);
        sb.append(", stationname=").append(stationname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}