package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TFinanceProductChange implements Serializable {
    private Long fid;

    private Long fheadId;

    private Integer frowIndex;

    private String fseq;

    private String fproductName;

    private BigDecimal fquantity;

    private BigDecimal famount;

    private BigDecimal fthisYield;

    private BigDecimal ftotalYield;

    private BigDecimal fthisCost;

    private BigDecimal ftotalCost;

    private BigDecimal fthisSales;

    private BigDecimal ftotalSales;

    private BigDecimal fthisAmount;

    private BigDecimal ftotalAmount;

    private BigDecimal fotherQuantity;

    private BigDecimal fotherAmount;

    private BigDecimal flastQuantity;

    private BigDecimal flastAmount;

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

    public String getFproductName() {
        return fproductName;
    }

    public void setFproductName(String fproductName) {
        this.fproductName = fproductName == null ? null : fproductName.trim();
    }

    public BigDecimal getFquantity() {
        return fquantity;
    }

    public void setFquantity(BigDecimal fquantity) {
        this.fquantity = fquantity;
    }

    public BigDecimal getFamount() {
        return famount;
    }

    public void setFamount(BigDecimal famount) {
        this.famount = famount;
    }

    public BigDecimal getFthisYield() {
        return fthisYield;
    }

    public void setFthisYield(BigDecimal fthisYield) {
        this.fthisYield = fthisYield;
    }

    public BigDecimal getFtotalYield() {
        return ftotalYield;
    }

    public void setFtotalYield(BigDecimal ftotalYield) {
        this.ftotalYield = ftotalYield;
    }

    public BigDecimal getFthisCost() {
        return fthisCost;
    }

    public void setFthisCost(BigDecimal fthisCost) {
        this.fthisCost = fthisCost;
    }

    public BigDecimal getFtotalCost() {
        return ftotalCost;
    }

    public void setFtotalCost(BigDecimal ftotalCost) {
        this.ftotalCost = ftotalCost;
    }

    public BigDecimal getFthisSales() {
        return fthisSales;
    }

    public void setFthisSales(BigDecimal fthisSales) {
        this.fthisSales = fthisSales;
    }

    public BigDecimal getFtotalSales() {
        return ftotalSales;
    }

    public void setFtotalSales(BigDecimal ftotalSales) {
        this.ftotalSales = ftotalSales;
    }

    public BigDecimal getFthisAmount() {
        return fthisAmount;
    }

    public void setFthisAmount(BigDecimal fthisAmount) {
        this.fthisAmount = fthisAmount;
    }

    public BigDecimal getFtotalAmount() {
        return ftotalAmount;
    }

    public void setFtotalAmount(BigDecimal ftotalAmount) {
        this.ftotalAmount = ftotalAmount;
    }

    public BigDecimal getFotherQuantity() {
        return fotherQuantity;
    }

    public void setFotherQuantity(BigDecimal fotherQuantity) {
        this.fotherQuantity = fotherQuantity;
    }

    public BigDecimal getFotherAmount() {
        return fotherAmount;
    }

    public void setFotherAmount(BigDecimal fotherAmount) {
        this.fotherAmount = fotherAmount;
    }

    public BigDecimal getFlastQuantity() {
        return flastQuantity;
    }

    public void setFlastQuantity(BigDecimal flastQuantity) {
        this.flastQuantity = flastQuantity;
    }

    public BigDecimal getFlastAmount() {
        return flastAmount;
    }

    public void setFlastAmount(BigDecimal flastAmount) {
        this.flastAmount = flastAmount;
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
        sb.append(", fproductName=").append(fproductName);
        sb.append(", fquantity=").append(fquantity);
        sb.append(", famount=").append(famount);
        sb.append(", fthisYield=").append(fthisYield);
        sb.append(", ftotalYield=").append(ftotalYield);
        sb.append(", fthisCost=").append(fthisCost);
        sb.append(", ftotalCost=").append(ftotalCost);
        sb.append(", fthisSales=").append(fthisSales);
        sb.append(", ftotalSales=").append(ftotalSales);
        sb.append(", fthisAmount=").append(fthisAmount);
        sb.append(", ftotalAmount=").append(ftotalAmount);
        sb.append(", fotherQuantity=").append(fotherQuantity);
        sb.append(", fotherAmount=").append(fotherAmount);
        sb.append(", flastQuantity=").append(flastQuantity);
        sb.append(", flastAmount=").append(flastAmount);
        sb.append(", fextend1=").append(fextend1);
        sb.append(", fextend2=").append(fextend2);
        sb.append(", fextend3=").append(fextend3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}