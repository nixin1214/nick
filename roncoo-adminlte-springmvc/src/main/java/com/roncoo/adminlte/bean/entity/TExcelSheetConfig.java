package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;

public class TExcelSheetConfig implements Serializable {
    private Long fid;

    private Long fheadId;

    private Integer fsheetIndex;

    private String fsheetName;

    private Integer fstartRowIndex;

    private Integer fendRowIndex;

    private String fcolIndexs;

    private String fignoreRowsIndex;

    private String fdbTable;

    private String fstrongRowsIndex;

    private String fmerges;

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

    public Integer getFsheetIndex() {
        return fsheetIndex;
    }

    public void setFsheetIndex(Integer fsheetIndex) {
        this.fsheetIndex = fsheetIndex;
    }

    public String getFsheetName() {
        return fsheetName;
    }

    public void setFsheetName(String fsheetName) {
        this.fsheetName = fsheetName == null ? null : fsheetName.trim();
    }

    public Integer getFstartRowIndex() {
        return fstartRowIndex;
    }

    public void setFstartRowIndex(Integer fstartRowIndex) {
        this.fstartRowIndex = fstartRowIndex;
    }

    public Integer getFendRowIndex() {
        return fendRowIndex;
    }

    public void setFendRowIndex(Integer fendRowIndex) {
        this.fendRowIndex = fendRowIndex;
    }

    public String getFcolIndexs() {
        return fcolIndexs;
    }

    public void setFcolIndexs(String fcolIndexs) {
        this.fcolIndexs = fcolIndexs == null ? null : fcolIndexs.trim();
    }

    public String getFignoreRowsIndex() {
        return fignoreRowsIndex;
    }

    public void setFignoreRowsIndex(String fignoreRowsIndex) {
        this.fignoreRowsIndex = fignoreRowsIndex == null ? null : fignoreRowsIndex.trim();
    }

    public String getFdbTable() {
        return fdbTable;
    }

    public void setFdbTable(String fdbTable) {
        this.fdbTable = fdbTable == null ? null : fdbTable.trim();
    }

    public String getFstrongRowsIndex() {
        return fstrongRowsIndex;
    }

    public void setFstrongRowsIndex(String fstrongRowsIndex) {
        this.fstrongRowsIndex = fstrongRowsIndex == null ? null : fstrongRowsIndex.trim();
    }

    public String getFmerges() {
        return fmerges;
    }

    public void setFmerges(String fmerges) {
        this.fmerges = fmerges == null ? null : fmerges.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", fheadId=").append(fheadId);
        sb.append(", fsheetIndex=").append(fsheetIndex);
        sb.append(", fsheetName=").append(fsheetName);
        sb.append(", fstartRowIndex=").append(fstartRowIndex);
        sb.append(", fendRowIndex=").append(fendRowIndex);
        sb.append(", fcolIndexs=").append(fcolIndexs);
        sb.append(", fignoreRowsIndex=").append(fignoreRowsIndex);
        sb.append(", fdbTable=").append(fdbTable);
        sb.append(", fstrongRowsIndex=").append(fstrongRowsIndex);
        sb.append(", fmerges=").append(fmerges);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}