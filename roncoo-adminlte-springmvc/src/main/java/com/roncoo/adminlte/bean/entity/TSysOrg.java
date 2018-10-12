package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;

public class TSysOrg implements Serializable {
    private Long fid;

    private String fcode;

    private String fname;

    private String flongCode;

    private Long fparentId;

    private String fparentName;

    private Integer fpos;

    private String fcatalogy;

    private Integer fendflag;

    private String fstatus;

    private String fdescn;

    private String fview;

    private Integer flevel;

    private static final long serialVersionUID = 1L;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode == null ? null : fcode.trim();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFlongCode() {
        return flongCode;
    }

    public void setFlongCode(String flongCode) {
        this.flongCode = flongCode == null ? null : flongCode.trim();
    }

    public Long getFparentId() {
        return fparentId;
    }

    public void setFparentId(Long fparentId) {
        this.fparentId = fparentId;
    }

    public String getFparentName() {
        return fparentName;
    }

    public void setFparentName(String fparentName) {
        this.fparentName = fparentName == null ? null : fparentName.trim();
    }

    public Integer getFpos() {
        return fpos;
    }

    public void setFpos(Integer fpos) {
        this.fpos = fpos;
    }

    public String getFcatalogy() {
        return fcatalogy;
    }

    public void setFcatalogy(String fcatalogy) {
        this.fcatalogy = fcatalogy == null ? null : fcatalogy.trim();
    }

    public Integer getFendflag() {
        return fendflag;
    }

    public void setFendflag(Integer fendflag) {
        this.fendflag = fendflag;
    }

    public String getFstatus() {
        return fstatus;
    }

    public void setFstatus(String fstatus) {
        this.fstatus = fstatus == null ? null : fstatus.trim();
    }

    public String getFdescn() {
        return fdescn;
    }

    public void setFdescn(String fdescn) {
        this.fdescn = fdescn == null ? null : fdescn.trim();
    }

    public String getFview() {
        return fview;
    }

    public void setFview(String fview) {
        this.fview = fview == null ? null : fview.trim();
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
        sb.append(", fcode=").append(fcode);
        sb.append(", fname=").append(fname);
        sb.append(", flongCode=").append(flongCode);
        sb.append(", fparentId=").append(fparentId);
        sb.append(", fparentName=").append(fparentName);
        sb.append(", fpos=").append(fpos);
        sb.append(", fcatalogy=").append(fcatalogy);
        sb.append(", fendflag=").append(fendflag);
        sb.append(", fstatus=").append(fstatus);
        sb.append(", fdescn=").append(fdescn);
        sb.append(", fview=").append(fview);
        sb.append(", flevel=").append(flevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}