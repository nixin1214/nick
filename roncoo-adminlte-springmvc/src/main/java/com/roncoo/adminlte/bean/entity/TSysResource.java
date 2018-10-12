package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.util.Date;

public class TSysResource implements Serializable {
    private Long fid;

    private String fresName;

    private String fresDesc;

    private Integer fisLeaf;

    private String fresUrl;

    private String fico;

    private String fresType;

    private Integer fpos;

    private Long fparentId;

    private Date fcreateDate;

    private String fpermissionValue;

    private Integer fstatus;

    private String fstyle;

    private String fpermissionName;

    private Integer flevel;

    private static final long serialVersionUID = 1L;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFresName() {
        return fresName;
    }

    public void setFresName(String fresName) {
        this.fresName = fresName == null ? null : fresName.trim();
    }

    public String getFresDesc() {
        return fresDesc;
    }

    public void setFresDesc(String fresDesc) {
        this.fresDesc = fresDesc == null ? null : fresDesc.trim();
    }

    public Integer getFisLeaf() {
        return fisLeaf;
    }

    public void setFisLeaf(Integer fisLeaf) {
        this.fisLeaf = fisLeaf;
    }

    public String getFresUrl() {
        return fresUrl;
    }

    public void setFresUrl(String fresUrl) {
        this.fresUrl = fresUrl == null ? null : fresUrl.trim();
    }

    public String getFico() {
        return fico;
    }

    public void setFico(String fico) {
        this.fico = fico == null ? null : fico.trim();
    }

    public String getFresType() {
        return fresType;
    }

    public void setFresType(String fresType) {
        this.fresType = fresType == null ? null : fresType.trim();
    }

    public Integer getFpos() {
        return fpos;
    }

    public void setFpos(Integer fpos) {
        this.fpos = fpos;
    }

    public Long getFparentId() {
        return fparentId;
    }

    public void setFparentId(Long fparentId) {
        this.fparentId = fparentId;
    }

    public Date getFcreateDate() {
        return fcreateDate;
    }

    public void setFcreateDate(Date fcreateDate) {
        this.fcreateDate = fcreateDate;
    }

    public String getFpermissionValue() {
        return fpermissionValue;
    }

    public void setFpermissionValue(String fpermissionValue) {
        this.fpermissionValue = fpermissionValue == null ? null : fpermissionValue.trim();
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }

    public String getFstyle() {
        return fstyle;
    }

    public void setFstyle(String fstyle) {
        this.fstyle = fstyle == null ? null : fstyle.trim();
    }

    public String getFpermissionName() {
        return fpermissionName;
    }

    public void setFpermissionName(String fpermissionName) {
        this.fpermissionName = fpermissionName == null ? null : fpermissionName.trim();
    }

    public Integer getFlevel() {
        return flevel;
    }

    public void setFlevel(Integer flevel) {
        this.flevel = flevel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", fresName=").append(fresName);
        sb.append(", fresDesc=").append(fresDesc);
        sb.append(", fisLeaf=").append(fisLeaf);
        sb.append(", fresUrl=").append(fresUrl);
        sb.append(", fico=").append(fico);
        sb.append(", fresType=").append(fresType);
        sb.append(", fpos=").append(fpos);
        sb.append(", fparentId=").append(fparentId);
        sb.append(", fcreateDate=").append(fcreateDate);
        sb.append(", fpermissionValue=").append(fpermissionValue);
        sb.append(", fstatus=").append(fstatus);
        sb.append(", fstyle=").append(fstyle);
        sb.append(", fpermissionName=").append(fpermissionName);
        sb.append(", flevel=").append(flevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}