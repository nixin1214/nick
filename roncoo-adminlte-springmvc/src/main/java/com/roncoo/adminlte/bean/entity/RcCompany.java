package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;

public class RcCompany implements Serializable {
    private Long id;

    private String fname;

    private String fnumber;

    private String ftype;

    private String fdesc;

    private String flongCode;

    private String fparentCode;

    private Short fpos;

    private Short fendflag;

    private Short fstatus;

    private String fdescn;

    private String fview;

    private Short flevel;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber == null ? null : fnumber.trim();
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype == null ? null : ftype.trim();
    }

    public String getFdesc() {
        return fdesc;
    }

    public void setFdesc(String fdesc) {
        this.fdesc = fdesc == null ? null : fdesc.trim();
    }

    public String getFlongCode() {
        return flongCode;
    }

    public void setFlongCode(String flongCode) {
        this.flongCode = flongCode == null ? null : flongCode.trim();
    }

    public String getFparentCode() {
        return fparentCode;
    }

    public void setFparentCode(String fparentCode) {
        this.fparentCode = fparentCode == null ? null : fparentCode.trim();
    }

    public Short getFpos() {
        return fpos;
    }

    public void setFpos(Short fpos) {
        this.fpos = fpos;
    }

    public Short getFendflag() {
        return fendflag;
    }

    public void setFendflag(Short fendflag) {
        this.fendflag = fendflag;
    }

    public Short getFstatus() {
        return fstatus;
    }

    public void setFstatus(Short fstatus) {
        this.fstatus = fstatus;
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

    public Short getFlevel() {
        return flevel;
    }

    public void setFlevel(Short flevel) {
        this.flevel = flevel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fname=").append(fname);
        sb.append(", fnumber=").append(fnumber);
        sb.append(", ftype=").append(ftype);
        sb.append(", fdesc=").append(fdesc);
        sb.append(", flongCode=").append(flongCode);
        sb.append(", fparentCode=").append(fparentCode);
        sb.append(", fpos=").append(fpos);
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