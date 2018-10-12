package com.roncoo.adminlte.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TFinanceOther implements Serializable {
    private Long fid;

    private Long frowIndex;

    private String fenterprise;

    private String fquotaName;

    private String ftype;

    private String fquotaNameZh;

    private BigDecimal fquotaValue;

    private String fresource;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fcreatime;

    private String fyearmonth;

    private String fremark;

    private BigDecimal fextend1;

    private BigDecimal fextend2;

    private BigDecimal fextend3;

    private Long fcreatorId;

    private String fcreatorName;

    private String fcompanyCode;

    private RcCompany company;

    private static final long serialVersionUID = 1L;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getFrowIndex() {
        return frowIndex;
    }

    public void setFrowIndex(Long frowIndex) {
        this.frowIndex = frowIndex;
    }

    public String getFenterprise() {
        return fenterprise;
    }

    public void setFenterprise(String fenterprise) {
        this.fenterprise = fenterprise == null ? null : fenterprise.trim();
    }

    public String getFquotaName() {
        return fquotaName;
    }

    public void setFquotaName(String fquotaName) {
        this.fquotaName = fquotaName == null ? null : fquotaName.trim();
    }

    public BigDecimal getFquotaValue() {
        return fquotaValue;
    }

    public void setFquotaValue(BigDecimal fquotaValue) {
        this.fquotaValue = fquotaValue;
    }

    public String getFresource() {
        return fresource;
    }

    public void setFresource(String fresource) {
        this.fresource = fresource == null ? null : fresource.trim();
    }

    public Date getFcreatime() {
        return fcreatime;
    }

    public void setFcreatime(Date fcreatime) {
        this.fcreatime = fcreatime;
    }

    public String getFyearmonth() {
        return fyearmonth;
    }

    public void setFyearmonth(String fyearmonth) {
        this.fyearmonth = fyearmonth == null ? null : fyearmonth.trim();
    }

    public String getFremark() {
        return fremark;
    }

    public void setFremark(String fremark) {
        this.fremark = fremark == null ? null : fremark.trim();
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

    public Long getFcreatorId() {
        return fcreatorId;
    }

    public void setFcreatorId(Long fcreatorId) {
        this.fcreatorId = fcreatorId;
    }

    public String getFcreatorName() {
        return fcreatorName;
    }

    public void setFcreatorName(String fcreatorName) {
        this.fcreatorName = fcreatorName == null ? null : fcreatorName.trim();
    }

    public String getFcompanyCode() {
        return fcompanyCode;
    }

    public void setFcompanyCode(String fcompanyCode) {
        this.fcompanyCode = fcompanyCode == null ? null : fcompanyCode.trim();
    }

    public RcCompany getCompany() {
        return company;
    }

    public void setCompany(RcCompany company) {
        this.company = company;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getFquotaNameZh() {
        return fquotaNameZh;
    }

    public void setFquotaNameZh(String fquotaNameZh) {
        this.fquotaNameZh = fquotaNameZh;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", frowIndex=").append(frowIndex);
        sb.append(", fenterprise=").append(fenterprise);
        sb.append(", fquotaName=").append(fquotaName);
        sb.append(", fquotaNameZh=").append(fquotaNameZh);
        sb.append(", ftype=").append(ftype);
        sb.append(", fquotaValue=").append(fquotaValue);
        sb.append(", fresource=").append(fresource);
        sb.append(", fcreatime=").append(fcreatime);
        sb.append(", fyearmonth=").append(fyearmonth);
        sb.append(", fremark=").append(fremark);
        sb.append(", fextend1=").append(fextend1);
        sb.append(", fextend2=").append(fextend2);
        sb.append(", fextend3=").append(fextend3);
        sb.append(", fcreatorId=").append(fcreatorId);
        sb.append(", fcreatorName=").append(fcreatorName);
        sb.append(", fcompanyCode=").append(fcompanyCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}