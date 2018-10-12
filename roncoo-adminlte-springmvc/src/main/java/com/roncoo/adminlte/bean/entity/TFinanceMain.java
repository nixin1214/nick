package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.util.Date;

public class TFinanceMain implements Serializable {
    private Long fid;

    private Long fcreator;

    private Date fcreatime;

    private Long fupdator;

    private Date fupdatime;

    private String fcompanyNumber;

    private String fcompanyName;

    private String fstatus;

    private String fyearMonth;

    private String freport; //此字段无用

    private String fdescription;

    private String freportNumber;

    private String ffinanceChage;

    private String funitChage;

    private Date fbizdate;

    private static final long serialVersionUID = 1L;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getFcreator() {
        return fcreator;
    }

    public void setFcreator(Long fcreator) {
        this.fcreator = fcreator;
    }

    public Date getFcreatime() {
        return fcreatime;
    }

    public void setFcreatime(Date fcreatime) {
        this.fcreatime = fcreatime;
    }

    public Long getFupdator() {
        return fupdator;
    }

    public void setFupdator(Long fupdator) {
        this.fupdator = fupdator;
    }

    public Date getFupdatime() {
        return fupdatime;
    }

    public void setFupdatime(Date fupdatime) {
        this.fupdatime = fupdatime;
    }

    public String getFcompanyNumber() {
        return fcompanyNumber;
    }

    public void setFcompanyNumber(String fcompanyNumber) {
        this.fcompanyNumber = fcompanyNumber == null ? null : fcompanyNumber.trim();
    }

    public String getFcompanyName() {
        return fcompanyName;
    }

    public void setFcompanyName(String fcompanyName) {
        this.fcompanyName = fcompanyName == null ? null : fcompanyName.trim();
    }

    public String getFstatus() {
        return fstatus;
    }

    public void setFstatus(String fstatus) {
        this.fstatus = fstatus == null ? null : fstatus.trim();
    }

    public String getFyearMonth() {
        return fyearMonth;
    }

    public void setFyearMonth(String fyearMonth) {
        this.fyearMonth = fyearMonth == null ? null : fyearMonth.trim();
    }

    public String getFreport() {
        return freport;
    }

    public void setFreport(String freport) {
        this.freport = freport == null ? null : freport.trim();
    }

    public String getFdescription() {
        return fdescription;
    }

    public void setFdescription(String fdescription) {
        this.fdescription = fdescription == null ? null : fdescription.trim();
    }

    public String getFreportNumber() {
        return freportNumber;
    }

    public void setFreportNumber(String freportNumber) {
        this.freportNumber = freportNumber == null ? null : freportNumber.trim();
    }

    public String getFfinanceChage() {
        return ffinanceChage;
    }

    public void setFfinanceChage(String ffinanceChage) {
        this.ffinanceChage = ffinanceChage == null ? null : ffinanceChage.trim();
    }

    public String getFunitChage() {
        return funitChage;
    }

    public void setFunitChage(String funitChage) {
        this.funitChage = funitChage == null ? null : funitChage.trim();
    }

    public Date getFbizdate() {
        return fbizdate;
    }

    public void setFbizdate(Date fbizdate) {
        this.fbizdate = fbizdate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", fcreator=").append(fcreator);
        sb.append(", fcreatime=").append(fcreatime);
        sb.append(", fupdator=").append(fupdator);
        sb.append(", fupdatime=").append(fupdatime);
        sb.append(", fcompanyNumber=").append(fcompanyNumber);
        sb.append(", fcompanyName=").append(fcompanyName);
        sb.append(", fstatus=").append(fstatus);
        sb.append(", fyearMonth=").append(fyearMonth);
        sb.append(", freport=").append(freport);
        sb.append(", fdescription=").append(fdescription);
        sb.append(", freportNumber=").append(freportNumber);
        sb.append(", ffinanceChage=").append(ffinanceChage);
        sb.append(", funitChage=").append(funitChage);
        sb.append(", fbizdate=").append(fbizdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}