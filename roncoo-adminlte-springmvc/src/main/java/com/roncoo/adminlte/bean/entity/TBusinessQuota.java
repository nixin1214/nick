package com.roncoo.adminlte.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TBusinessQuota implements Serializable {
    private Long fid;

    private String fresSys;

    private Long forgId;

    private String forgCode;

    private String forgLongCode;

    private String fyearMonth;

    private String ftype;

    private String fnameZh;

    private String fnameEn;

    private BigDecimal fvalue;

    private String fvalueType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fcreatime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fupdatime;

    private String funit;

    private String fdimension;

    private String fremark;

    private String flastUpdator;

    private String fsmallClass;

    private RcCompany company;

    private static final long serialVersionUID = 1L;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFresSys() {
        return fresSys;
    }

    public void setFresSys(String fresSys) {
        this.fresSys = fresSys == null ? null : fresSys.trim();
    }

    public Long getForgId() {
        return forgId;
    }

    public void setForgId(Long forgId) {
        this.forgId = forgId;
    }

    public String getForgCode() {
        return forgCode;
    }

    public void setForgCode(String forgCode) {
        this.forgCode = forgCode == null ? null : forgCode.trim();
    }

    public String getForgLongCode() {
        return forgLongCode;
    }

    public void setForgLongCode(String forgLongCode) {
        this.forgLongCode = forgLongCode == null ? null : forgLongCode.trim();
    }

    public String getFyearMonth() {
        return fyearMonth;
    }

    public void setFyearMonth(String fyearMonth) {
        this.fyearMonth = fyearMonth == null ? null : fyearMonth.trim();
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype == null ? null : ftype.trim();
    }

    public String getFnameZh() {
        return fnameZh;
    }

    public void setFnameZh(String fnameZh) {
        this.fnameZh = fnameZh == null ? null : fnameZh.trim();
    }

    public String getFnameEn() {
        return fnameEn;
    }

    public void setFnameEn(String fnameEn) {
        this.fnameEn = fnameEn == null ? null : fnameEn.trim();
    }

    public BigDecimal getFvalue() {
        return fvalue;
    }

    public void setFvalue(BigDecimal fvalue) {
        this.fvalue = fvalue;
    }

    public String getFvalueType() {
        return fvalueType;
    }

    public void setFvalueType(String fvalueType) {
        this.fvalueType = fvalueType == null ? null : fvalueType.trim();
    }

    public Date getFcreatime() {
        return fcreatime;
    }

    public void setFcreatime(Date fcreatime) {
        this.fcreatime = fcreatime;
    }

    public Date getFupdatime() {
        return fupdatime;
    }

    public void setFupdatime(Date fupdatime) {
        this.fupdatime = fupdatime;
    }

    public String getFunit() {
        return funit;
    }

    public void setFunit(String funit) {
        this.funit = funit == null ? null : funit.trim();
    }

    public String getFdimension() {
        return fdimension;
    }

    public void setFdimension(String fdimension) {
        this.fdimension = fdimension == null ? null : fdimension.trim();
    }

    public String getFremark() {
        return fremark;
    }

    public void setFremark(String fremark) {
        this.fremark = fremark == null ? null : fremark.trim();
    }

    public String getFlastUpdator() {
        return flastUpdator;
    }

    public void setFlastUpdator(String flastUpdator) {
        this.flastUpdator = flastUpdator == null ? null : flastUpdator.trim();
    }

    public String getFsmallClass() {
        return fsmallClass;
    }

    public void setFsmallClass(String fsmallClass) {
        this.fsmallClass = fsmallClass == null ? null : fsmallClass.trim();
    }

    public RcCompany getCompany() {
        return company;
    }

    public void setCompany(RcCompany company) {
        this.company = company;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", fresSys=").append(fresSys);
        sb.append(", forgId=").append(forgId);
        sb.append(", forgCode=").append(forgCode);
        sb.append(", forgLongCode=").append(forgLongCode);
        sb.append(", fyearMonth=").append(fyearMonth);
        sb.append(", ftype=").append(ftype);
        sb.append(", fnameZh=").append(fnameZh);
        sb.append(", fnameEn=").append(fnameEn);
        sb.append(", fvalue=").append(fvalue);
        sb.append(", fvalueType=").append(fvalueType);
        sb.append(", fcreatime=").append(fcreatime);
        sb.append(", fupdatime=").append(fupdatime);
        sb.append(", funit=").append(funit);
        sb.append(", fdimension=").append(fdimension);
        sb.append(", fremark=").append(fremark);
        sb.append(", flastUpdator=").append(flastUpdator);
        sb.append(", fsmallClass=").append(fsmallClass);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}