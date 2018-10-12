package com.roncoo.adminlte.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class TSysUserLogs implements Serializable {
    private Long fid;

    private Long fuserId;

    private String fuserName;

    private String fuserAccount;

    private String foperationType;

    private Long fuserOrgId;

    private String fuserOrgName;

    private String fresource;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date fcreatime;

    private String fremark;

    private String fsource;

    private String fmacAddress;

    private String fipAddress;

    private String fstatus;

    private String ferrorCode;

    private String ferrorMsg;

    private RcCompany company;

    private static final long serialVersionUID = 1L;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getFuserId() {
        return fuserId;
    }

    public void setFuserId(Long fuserId) {
        this.fuserId = fuserId;
    }

    public String getFuserName() {
        return fuserName;
    }

    public void setFuserName(String fuserName) {
        this.fuserName = fuserName == null ? null : fuserName.trim();
    }

    public String getFuserAccount() {
        return fuserAccount;
    }

    public void setFuserAccount(String fuserAccount) {
        this.fuserAccount = fuserAccount == null ? null : fuserAccount.trim();
    }

    public String getFoperationType() {
        return foperationType;
    }

    public void setFoperationType(String foperationType) {
        this.foperationType = foperationType == null ? null : foperationType.trim();
    }

    public Long getFuserOrgId() {
        return fuserOrgId;
    }

    public void setFuserOrgId(Long fuserOrgId) {
        this.fuserOrgId = fuserOrgId;
    }

    public String getFuserOrgName() {
        return fuserOrgName;
    }

    public void setFuserOrgName(String fuserOrgName) {
        this.fuserOrgName = fuserOrgName == null ? null : fuserOrgName.trim();
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

    public String getFremark() {
        return fremark;
    }

    public void setFremark(String fremark) {
        this.fremark = fremark == null ? null : fremark.trim();
    }

    public String getFsource() {
        return fsource;
    }

    public void setFsource(String fsource) {
        this.fsource = fsource == null ? null : fsource.trim();
    }

    public String getFmacAddress() {
        return fmacAddress;
    }

    public void setFmacAddress(String fmacAddress) {
        this.fmacAddress = fmacAddress == null ? null : fmacAddress.trim();
    }

    public String getFipAddress() {
        return fipAddress;
    }

    public void setFipAddress(String fipAddress) {
        this.fipAddress = fipAddress == null ? null : fipAddress.trim();
    }

    public String getFstatus() {
        return fstatus;
    }

    public void setFstatus(String fstatus) {
        this.fstatus = fstatus == null ? null : fstatus.trim();
    }

    public String getFerrorCode() {
        return ferrorCode;
    }

    public void setFerrorCode(String ferrorCode) {
        this.ferrorCode = ferrorCode == null ? null : ferrorCode.trim();
    }

    public String getFerrorMsg() {
        return ferrorMsg;
    }

    public void setFerrorMsg(String ferrorMsg) {
        this.ferrorMsg = ferrorMsg == null ? null : ferrorMsg.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", fuserId=").append(fuserId);
        sb.append(", fuserName=").append(fuserName);
        sb.append(", fuserAccount=").append(fuserAccount);
        sb.append(", foperationType=").append(foperationType);
        sb.append(", fuserOrgId=").append(fuserOrgId);
        sb.append(", fuserOrgName=").append(fuserOrgName);
        sb.append(", fresource=").append(fresource);
        sb.append(", fcreatime=").append(fcreatime);
        sb.append(", fremark=").append(fremark);
        sb.append(", fsource=").append(fsource);
        sb.append(", fmacAddress=").append(fmacAddress);
        sb.append(", fipAddress=").append(fipAddress);
        sb.append(", fstatus=").append(fstatus);
        sb.append(", ferrorCode=").append(ferrorCode);
        sb.append(", ferrorMsg=").append(ferrorMsg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public RcCompany getCompany() {
        return company;
    }

    public void setCompany(RcCompany company) {
        this.company = company;
    }
}