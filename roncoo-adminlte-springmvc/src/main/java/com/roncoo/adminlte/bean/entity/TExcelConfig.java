package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.util.List;

public class TExcelConfig implements Serializable {
    private Long fid;

    private String fnumber;

    private String fname;

    private String fremark;

    private String ftype;

    private Integer fstatus;

    private String fileType;

    private String fversion;

    private static final long serialVersionUID = 1L;

    private List<TExcelSheetConfig> sheetConfigs;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber == null ? null : fnumber.trim();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFremark() {
        return fremark;
    }

    public void setFremark(String fremark) {
        this.fremark = fremark == null ? null : fremark.trim();
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype == null ? null : ftype.trim();
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getFversion() {
        return fversion;
    }

    public void setFversion(String fversion) {
        this.fversion = fversion == null ? null : fversion.trim();
    }

    public List<TExcelSheetConfig> getSheetConfigs() {
        return sheetConfigs;
    }

    public void setSheetConfigs(List<TExcelSheetConfig> sheetConfigs) {
        this.sheetConfigs = sheetConfigs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", fnumber=").append(fnumber);
        sb.append(", fname=").append(fname);
        sb.append(", fremark=").append(fremark);
        sb.append(", ftype=").append(ftype);
        sb.append(", fstatus=").append(fstatus);
        sb.append(", fileType=").append(fileType);
        sb.append(", fversion=").append(fversion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}