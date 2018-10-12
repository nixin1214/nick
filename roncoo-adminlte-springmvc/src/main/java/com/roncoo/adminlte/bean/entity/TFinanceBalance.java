package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;

public class TFinanceBalance implements Serializable {
    private Long fid;

    private Long fheadId;

    private Integer frowIndex1;

    private String fproject1;

    private Double ffinalAmount1;

    private Double fbeginningAmount1;

    private String fproject2;

    private Integer frowIndex2;

    private Double ffinalAmount2;

    private Double fbeginningAmount2;

    private String fstatus;

    private Integer fsheetRowNumber;

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

    public Integer getFrowIndex1() {
        return frowIndex1;
    }

    public void setFrowIndex1(Integer frowIndex1) {
        this.frowIndex1 = frowIndex1;
    }

    public String getFproject1() {
        return fproject1;
    }

    public void setFproject1(String fproject1) {
        this.fproject1 = fproject1 == null ? null : fproject1.trim();
    }

    public Double getFfinalAmount1() {
        return ffinalAmount1;
    }

    public void setFfinalAmount1(Double ffinalAmount1) {
        this.ffinalAmount1 = ffinalAmount1;
    }

    public Double getFbeginningAmount1() {
        return fbeginningAmount1;
    }

    public void setFbeginningAmount1(Double fbeginningAmount1) {
        this.fbeginningAmount1 = fbeginningAmount1;
    }

    public String getFproject2() {
        return fproject2;
    }

    public void setFproject2(String fproject2) {
        this.fproject2 = fproject2 == null ? null : fproject2.trim();
    }

    public Integer getFrowIndex2() {
        return frowIndex2;
    }

    public void setFrowIndex2(Integer frowIndex2) {
        this.frowIndex2 = frowIndex2;
    }

    public Double getFfinalAmount2() {
        return ffinalAmount2;
    }

    public void setFfinalAmount2(Double ffinalAmount2) {
        this.ffinalAmount2 = ffinalAmount2;
    }

    public Double getFbeginningAmount2() {
        return fbeginningAmount2;
    }

    public void setFbeginningAmount2(Double fbeginningAmount2) {
        this.fbeginningAmount2 = fbeginningAmount2;
    }

    public String getFstatus() {
        return fstatus;
    }

    public void setFstatus(String fstatus) {
        this.fstatus = fstatus == null ? null : fstatus.trim();
    }

    public Integer getFsheetRowNumber() {
        return fsheetRowNumber;
    }

    public void setFsheetRowNumber(Integer fsheetRowNumber) {
        this.fsheetRowNumber = fsheetRowNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", fheadId=").append(fheadId);
        sb.append(", frowIndex1=").append(frowIndex1);
        sb.append(", fproject1=").append(fproject1);
        sb.append(", ffinalAmount1=").append(ffinalAmount1);
        sb.append(", fbeginningAmount1=").append(fbeginningAmount1);
        sb.append(", fproject2=").append(fproject2);
        sb.append(", frowIndex2=").append(frowIndex2);
        sb.append(", ffinalAmount2=").append(ffinalAmount2);
        sb.append(", fbeginningAmount2=").append(fbeginningAmount2);
        sb.append(", fstatus=").append(fstatus);
        sb.append(", fsheetRowNumber=").append(fsheetRowNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}