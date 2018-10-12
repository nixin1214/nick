package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TBusinessQuotaLog implements Serializable {
    private Long fid;

    private Long fquotaId;

    private String fquotaName;

    private String fquotaNameEn;

    private BigDecimal fquotaOldValue;

    private BigDecimal fquotaNewValue;

    private Long fuserId;

    private String fuserNo;

    private String fuserName;

    private Long forgId;

    private Date fcreatime;

    private static final long serialVersionUID = 1L;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getFquotaId() {
        return fquotaId;
    }

    public void setFquotaId(Long fquotaId) {
        this.fquotaId = fquotaId;
    }

    public String getFquotaName() {
        return fquotaName;
    }

    public void setFquotaName(String fquotaName) {
        this.fquotaName = fquotaName == null ? null : fquotaName.trim();
    }

    public String getFquotaNameEn() {
        return fquotaNameEn;
    }

    public void setFquotaNameEn(String fquotaNameEn) {
        this.fquotaNameEn = fquotaNameEn == null ? null : fquotaNameEn.trim();
    }

    public BigDecimal getFquotaOldValue() {
        return fquotaOldValue;
    }

    public void setFquotaOldValue(BigDecimal fquotaOldValue) {
        this.fquotaOldValue = fquotaOldValue;
    }

    public BigDecimal getFquotaNewValue() {
        return fquotaNewValue;
    }

    public void setFquotaNewValue(BigDecimal fquotaNewValue) {
        this.fquotaNewValue = fquotaNewValue;
    }

    public Long getFuserId() {
        return fuserId;
    }

    public void setFuserId(Long fuserId) {
        this.fuserId = fuserId;
    }

    public String getFuserNo() {
        return fuserNo;
    }

    public void setFuserNo(String fuserNo) {
        this.fuserNo = fuserNo == null ? null : fuserNo.trim();
    }

    public String getFuserName() {
        return fuserName;
    }

    public void setFuserName(String fuserName) {
        this.fuserName = fuserName == null ? null : fuserName.trim();
    }

    public Long getForgId() {
        return forgId;
    }

    public void setForgId(Long forgId) {
        this.forgId = forgId;
    }

    public Date getFcreatime() {
        return fcreatime;
    }

    public void setFcreatime(Date fcreatime) {
        this.fcreatime = fcreatime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", fquotaId=").append(fquotaId);
        sb.append(", fquotaName=").append(fquotaName);
        sb.append(", fquotaNameEn=").append(fquotaNameEn);
        sb.append(", fquotaOldValue=").append(fquotaOldValue);
        sb.append(", fquotaNewValue=").append(fquotaNewValue);
        sb.append(", fuserId=").append(fuserId);
        sb.append(", fuserNo=").append(fuserNo);
        sb.append(", fuserName=").append(fuserName);
        sb.append(", forgId=").append(forgId);
        sb.append(", fcreatime=").append(fcreatime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}