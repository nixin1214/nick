package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 
 */
public class TDailyReport implements Serializable {
    private BigDecimal fid;

    private String yearMonth;

    private BigDecimal fdifference;

    private BigDecimal fsheetRowIndex;

    private String distributionChannel;

    private String salesArea;

    private String areaList;

    private BigDecimal dailyPractice;

    private BigDecimal dailyTotalAvg;

    private BigDecimal dailyAvgBudget;

    private BigDecimal completionRate;

    private BigDecimal thisMonthBudget;

    private BigDecimal thisMonthTotal;

    private BigDecimal thisMonthCompletionRate;

    private static final long serialVersionUID = 1L;

    public BigDecimal getFid() {
        return fid;
    }

    public void setFid(BigDecimal fid) {
        this.fid = fid;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public BigDecimal getFdifference() {
        return fdifference;
    }

    public void setFdifference(BigDecimal fdifference) {
        this.fdifference = fdifference;
    }

    public BigDecimal getFsheetRowIndex() {
        return fsheetRowIndex;
    }

    public void setFsheetRowIndex(BigDecimal fsheetRowIndex) {
        this.fsheetRowIndex = fsheetRowIndex;
    }

    public String getDistributionChannel() {
        return distributionChannel;
    }

    public void setDistributionChannel(String distributionChannel) {
        this.distributionChannel = distributionChannel;
    }

    public String getSalesArea() {
        return salesArea;
    }

    public void setSalesArea(String salesArea) {
        this.salesArea = salesArea;
    }

    public String getAreaList() {
        return areaList;
    }

    public void setAreaList(String areaList) {
        this.areaList = areaList;
    }

    public BigDecimal getDailyPractice() {
        return dailyPractice;
    }

    public void setDailyPractice(BigDecimal dailyPractice) {
        this.dailyPractice = dailyPractice;
    }

    public BigDecimal getDailyTotalAvg() {
        return dailyTotalAvg;
    }

    public void setDailyTotalAvg(BigDecimal dailyTotalAvg) {
        this.dailyTotalAvg = dailyTotalAvg;
    }

    public BigDecimal getDailyAvgBudget() {
        return dailyAvgBudget;
    }

    public void setDailyAvgBudget(BigDecimal dailyAvgBudget) {
        this.dailyAvgBudget = dailyAvgBudget;
    }

    public BigDecimal getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(BigDecimal completionRate) {
        this.completionRate = completionRate;
    }

    public BigDecimal getThisMonthBudget() {
        return thisMonthBudget;
    }

    public void setThisMonthBudget(BigDecimal thisMonthBudget) {
        this.thisMonthBudget = thisMonthBudget;
    }

    public BigDecimal getThisMonthTotal() {
        return thisMonthTotal;
    }

    public void setThisMonthTotal(BigDecimal thisMonthTotal) {
        this.thisMonthTotal = thisMonthTotal;
    }

    public BigDecimal getThisMonthCompletionRate() {
        return thisMonthCompletionRate;
    }

    public void setThisMonthCompletionRate(BigDecimal thisMonthCompletionRate) {
        this.thisMonthCompletionRate = thisMonthCompletionRate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TDailyReport other = (TDailyReport) that;
        return (this.getFid() == null ? other.getFid() == null : this.getFid().equals(other.getFid()))
            && (this.getYearMonth() == null ? other.getYearMonth() == null : this.getYearMonth().equals(other.getYearMonth()))
            && (this.getFdifference() == null ? other.getFdifference() == null : this.getFdifference().equals(other.getFdifference()))
            && (this.getFsheetRowIndex() == null ? other.getFsheetRowIndex() == null : this.getFsheetRowIndex().equals(other.getFsheetRowIndex()))
            && (this.getDistributionChannel() == null ? other.getDistributionChannel() == null : this.getDistributionChannel().equals(other.getDistributionChannel()))
            && (this.getSalesArea() == null ? other.getSalesArea() == null : this.getSalesArea().equals(other.getSalesArea()))
            && (this.getAreaList() == null ? other.getAreaList() == null : this.getAreaList().equals(other.getAreaList()))
            && (this.getDailyPractice() == null ? other.getDailyPractice() == null : this.getDailyPractice().equals(other.getDailyPractice()))
            && (this.getDailyTotalAvg() == null ? other.getDailyTotalAvg() == null : this.getDailyTotalAvg().equals(other.getDailyTotalAvg()))
            && (this.getDailyAvgBudget() == null ? other.getDailyAvgBudget() == null : this.getDailyAvgBudget().equals(other.getDailyAvgBudget()))
            && (this.getCompletionRate() == null ? other.getCompletionRate() == null : this.getCompletionRate().equals(other.getCompletionRate()))
            && (this.getThisMonthBudget() == null ? other.getThisMonthBudget() == null : this.getThisMonthBudget().equals(other.getThisMonthBudget()))
            && (this.getThisMonthTotal() == null ? other.getThisMonthTotal() == null : this.getThisMonthTotal().equals(other.getThisMonthTotal()))
            && (this.getThisMonthCompletionRate() == null ? other.getThisMonthCompletionRate() == null : this.getThisMonthCompletionRate().equals(other.getThisMonthCompletionRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFid() == null) ? 0 : getFid().hashCode());
        result = prime * result + ((getYearMonth() == null) ? 0 : getYearMonth().hashCode());
        result = prime * result + ((getFdifference() == null) ? 0 : getFdifference().hashCode());
        result = prime * result + ((getFsheetRowIndex() == null) ? 0 : getFsheetRowIndex().hashCode());
        result = prime * result + ((getDistributionChannel() == null) ? 0 : getDistributionChannel().hashCode());
        result = prime * result + ((getSalesArea() == null) ? 0 : getSalesArea().hashCode());
        result = prime * result + ((getAreaList() == null) ? 0 : getAreaList().hashCode());
        result = prime * result + ((getDailyPractice() == null) ? 0 : getDailyPractice().hashCode());
        result = prime * result + ((getDailyTotalAvg() == null) ? 0 : getDailyTotalAvg().hashCode());
        result = prime * result + ((getDailyAvgBudget() == null) ? 0 : getDailyAvgBudget().hashCode());
        result = prime * result + ((getCompletionRate() == null) ? 0 : getCompletionRate().hashCode());
        result = prime * result + ((getThisMonthBudget() == null) ? 0 : getThisMonthBudget().hashCode());
        result = prime * result + ((getThisMonthTotal() == null) ? 0 : getThisMonthTotal().hashCode());
        result = prime * result + ((getThisMonthCompletionRate() == null) ? 0 : getThisMonthCompletionRate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", yearMonth=").append(yearMonth);
        sb.append(", fdifference=").append(fdifference);
        sb.append(", fsheetRowIndex=").append(fsheetRowIndex);
        sb.append(", distributionChannel=").append(distributionChannel);
        sb.append(", salesArea=").append(salesArea);
        sb.append(", areaList=").append(areaList);
        sb.append(", dailyPractice=").append(dailyPractice);
        sb.append(", dailyTotalAvg=").append(dailyTotalAvg);
        sb.append(", dailyAvgBudget=").append(dailyAvgBudget);
        sb.append(", completionRate=").append(completionRate);
        sb.append(", thisMonthBudget=").append(thisMonthBudget);
        sb.append(", thisMonthTotal=").append(thisMonthTotal);
        sb.append(", thisMonthCompletionRate=").append(thisMonthCompletionRate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}