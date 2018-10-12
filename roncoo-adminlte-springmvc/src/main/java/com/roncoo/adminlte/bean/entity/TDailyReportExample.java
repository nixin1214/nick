package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TDailyReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDailyReportExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFidIsNull() {
            addCriterion("FID is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FID is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(BigDecimal value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(BigDecimal value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(BigDecimal value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(BigDecimal value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<BigDecimal> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<BigDecimal> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andYearMonthIsNull() {
            addCriterion("YEAR_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andYearMonthIsNotNull() {
            addCriterion("YEAR_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andYearMonthEqualTo(String value) {
            addCriterion("YEAR_MONTH =", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthNotEqualTo(String value) {
            addCriterion("YEAR_MONTH <>", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthGreaterThan(String value) {
            addCriterion("YEAR_MONTH >", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthGreaterThanOrEqualTo(String value) {
            addCriterion("YEAR_MONTH >=", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthLessThan(String value) {
            addCriterion("YEAR_MONTH <", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthLessThanOrEqualTo(String value) {
            addCriterion("YEAR_MONTH <=", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthLike(String value) {
            addCriterion("YEAR_MONTH like", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthNotLike(String value) {
            addCriterion("YEAR_MONTH not like", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthIn(List<String> values) {
            addCriterion("YEAR_MONTH in", values, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthNotIn(List<String> values) {
            addCriterion("YEAR_MONTH not in", values, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthBetween(String value1, String value2) {
            addCriterion("YEAR_MONTH between", value1, value2, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthNotBetween(String value1, String value2) {
            addCriterion("YEAR_MONTH not between", value1, value2, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andFdifferenceIsNull() {
            addCriterion("FDIFFERENCE is null");
            return (Criteria) this;
        }

        public Criteria andFdifferenceIsNotNull() {
            addCriterion("FDIFFERENCE is not null");
            return (Criteria) this;
        }

        public Criteria andFdifferenceEqualTo(BigDecimal value) {
            addCriterion("FDIFFERENCE =", value, "fdifference");
            return (Criteria) this;
        }

        public Criteria andFdifferenceNotEqualTo(BigDecimal value) {
            addCriterion("FDIFFERENCE <>", value, "fdifference");
            return (Criteria) this;
        }

        public Criteria andFdifferenceGreaterThan(BigDecimal value) {
            addCriterion("FDIFFERENCE >", value, "fdifference");
            return (Criteria) this;
        }

        public Criteria andFdifferenceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FDIFFERENCE >=", value, "fdifference");
            return (Criteria) this;
        }

        public Criteria andFdifferenceLessThan(BigDecimal value) {
            addCriterion("FDIFFERENCE <", value, "fdifference");
            return (Criteria) this;
        }

        public Criteria andFdifferenceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FDIFFERENCE <=", value, "fdifference");
            return (Criteria) this;
        }

        public Criteria andFdifferenceIn(List<BigDecimal> values) {
            addCriterion("FDIFFERENCE in", values, "fdifference");
            return (Criteria) this;
        }

        public Criteria andFdifferenceNotIn(List<BigDecimal> values) {
            addCriterion("FDIFFERENCE not in", values, "fdifference");
            return (Criteria) this;
        }

        public Criteria andFdifferenceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FDIFFERENCE between", value1, value2, "fdifference");
            return (Criteria) this;
        }

        public Criteria andFdifferenceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FDIFFERENCE not between", value1, value2, "fdifference");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexIsNull() {
            addCriterion("FSHEET_ROW_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexIsNotNull() {
            addCriterion("FSHEET_ROW_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexEqualTo(BigDecimal value) {
            addCriterion("FSHEET_ROW_INDEX =", value, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexNotEqualTo(BigDecimal value) {
            addCriterion("FSHEET_ROW_INDEX <>", value, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexGreaterThan(BigDecimal value) {
            addCriterion("FSHEET_ROW_INDEX >", value, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FSHEET_ROW_INDEX >=", value, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexLessThan(BigDecimal value) {
            addCriterion("FSHEET_ROW_INDEX <", value, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FSHEET_ROW_INDEX <=", value, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexIn(List<BigDecimal> values) {
            addCriterion("FSHEET_ROW_INDEX in", values, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexNotIn(List<BigDecimal> values) {
            addCriterion("FSHEET_ROW_INDEX not in", values, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FSHEET_ROW_INDEX between", value1, value2, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FSHEET_ROW_INDEX not between", value1, value2, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelIsNull() {
            addCriterion("DISTRIBUTION_CHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelIsNotNull() {
            addCriterion("DISTRIBUTION_CHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelEqualTo(String value) {
            addCriterion("DISTRIBUTION_CHANNEL =", value, "distributionChannel");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelNotEqualTo(String value) {
            addCriterion("DISTRIBUTION_CHANNEL <>", value, "distributionChannel");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelGreaterThan(String value) {
            addCriterion("DISTRIBUTION_CHANNEL >", value, "distributionChannel");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelGreaterThanOrEqualTo(String value) {
            addCriterion("DISTRIBUTION_CHANNEL >=", value, "distributionChannel");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelLessThan(String value) {
            addCriterion("DISTRIBUTION_CHANNEL <", value, "distributionChannel");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelLessThanOrEqualTo(String value) {
            addCriterion("DISTRIBUTION_CHANNEL <=", value, "distributionChannel");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelLike(String value) {
            addCriterion("DISTRIBUTION_CHANNEL like", value, "distributionChannel");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelNotLike(String value) {
            addCriterion("DISTRIBUTION_CHANNEL not like", value, "distributionChannel");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelIn(List<String> values) {
            addCriterion("DISTRIBUTION_CHANNEL in", values, "distributionChannel");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelNotIn(List<String> values) {
            addCriterion("DISTRIBUTION_CHANNEL not in", values, "distributionChannel");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelBetween(String value1, String value2) {
            addCriterion("DISTRIBUTION_CHANNEL between", value1, value2, "distributionChannel");
            return (Criteria) this;
        }

        public Criteria andDistributionChannelNotBetween(String value1, String value2) {
            addCriterion("DISTRIBUTION_CHANNEL not between", value1, value2, "distributionChannel");
            return (Criteria) this;
        }

        public Criteria andSalesAreaIsNull() {
            addCriterion("SALES_AREA is null");
            return (Criteria) this;
        }

        public Criteria andSalesAreaIsNotNull() {
            addCriterion("SALES_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andSalesAreaEqualTo(String value) {
            addCriterion("SALES_AREA =", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaNotEqualTo(String value) {
            addCriterion("SALES_AREA <>", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaGreaterThan(String value) {
            addCriterion("SALES_AREA >", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaGreaterThanOrEqualTo(String value) {
            addCriterion("SALES_AREA >=", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaLessThan(String value) {
            addCriterion("SALES_AREA <", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaLessThanOrEqualTo(String value) {
            addCriterion("SALES_AREA <=", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaLike(String value) {
            addCriterion("SALES_AREA like", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaNotLike(String value) {
            addCriterion("SALES_AREA not like", value, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaIn(List<String> values) {
            addCriterion("SALES_AREA in", values, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaNotIn(List<String> values) {
            addCriterion("SALES_AREA not in", values, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaBetween(String value1, String value2) {
            addCriterion("SALES_AREA between", value1, value2, "salesArea");
            return (Criteria) this;
        }

        public Criteria andSalesAreaNotBetween(String value1, String value2) {
            addCriterion("SALES_AREA not between", value1, value2, "salesArea");
            return (Criteria) this;
        }

        public Criteria andAreaListIsNull() {
            addCriterion("AREA_LIST is null");
            return (Criteria) this;
        }

        public Criteria andAreaListIsNotNull() {
            addCriterion("AREA_LIST is not null");
            return (Criteria) this;
        }

        public Criteria andAreaListEqualTo(String value) {
            addCriterion("AREA_LIST =", value, "areaList");
            return (Criteria) this;
        }

        public Criteria andAreaListNotEqualTo(String value) {
            addCriterion("AREA_LIST <>", value, "areaList");
            return (Criteria) this;
        }

        public Criteria andAreaListGreaterThan(String value) {
            addCriterion("AREA_LIST >", value, "areaList");
            return (Criteria) this;
        }

        public Criteria andAreaListGreaterThanOrEqualTo(String value) {
            addCriterion("AREA_LIST >=", value, "areaList");
            return (Criteria) this;
        }

        public Criteria andAreaListLessThan(String value) {
            addCriterion("AREA_LIST <", value, "areaList");
            return (Criteria) this;
        }

        public Criteria andAreaListLessThanOrEqualTo(String value) {
            addCriterion("AREA_LIST <=", value, "areaList");
            return (Criteria) this;
        }

        public Criteria andAreaListLike(String value) {
            addCriterion("AREA_LIST like", value, "areaList");
            return (Criteria) this;
        }

        public Criteria andAreaListNotLike(String value) {
            addCriterion("AREA_LIST not like", value, "areaList");
            return (Criteria) this;
        }

        public Criteria andAreaListIn(List<String> values) {
            addCriterion("AREA_LIST in", values, "areaList");
            return (Criteria) this;
        }

        public Criteria andAreaListNotIn(List<String> values) {
            addCriterion("AREA_LIST not in", values, "areaList");
            return (Criteria) this;
        }

        public Criteria andAreaListBetween(String value1, String value2) {
            addCriterion("AREA_LIST between", value1, value2, "areaList");
            return (Criteria) this;
        }

        public Criteria andAreaListNotBetween(String value1, String value2) {
            addCriterion("AREA_LIST not between", value1, value2, "areaList");
            return (Criteria) this;
        }

        public Criteria andDailyPracticeIsNull() {
            addCriterion("DAILY_PRACTICE is null");
            return (Criteria) this;
        }

        public Criteria andDailyPracticeIsNotNull() {
            addCriterion("DAILY_PRACTICE is not null");
            return (Criteria) this;
        }

        public Criteria andDailyPracticeEqualTo(BigDecimal value) {
            addCriterion("DAILY_PRACTICE =", value, "dailyPractice");
            return (Criteria) this;
        }

        public Criteria andDailyPracticeNotEqualTo(BigDecimal value) {
            addCriterion("DAILY_PRACTICE <>", value, "dailyPractice");
            return (Criteria) this;
        }

        public Criteria andDailyPracticeGreaterThan(BigDecimal value) {
            addCriterion("DAILY_PRACTICE >", value, "dailyPractice");
            return (Criteria) this;
        }

        public Criteria andDailyPracticeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DAILY_PRACTICE >=", value, "dailyPractice");
            return (Criteria) this;
        }

        public Criteria andDailyPracticeLessThan(BigDecimal value) {
            addCriterion("DAILY_PRACTICE <", value, "dailyPractice");
            return (Criteria) this;
        }

        public Criteria andDailyPracticeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DAILY_PRACTICE <=", value, "dailyPractice");
            return (Criteria) this;
        }

        public Criteria andDailyPracticeIn(List<BigDecimal> values) {
            addCriterion("DAILY_PRACTICE in", values, "dailyPractice");
            return (Criteria) this;
        }

        public Criteria andDailyPracticeNotIn(List<BigDecimal> values) {
            addCriterion("DAILY_PRACTICE not in", values, "dailyPractice");
            return (Criteria) this;
        }

        public Criteria andDailyPracticeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAILY_PRACTICE between", value1, value2, "dailyPractice");
            return (Criteria) this;
        }

        public Criteria andDailyPracticeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAILY_PRACTICE not between", value1, value2, "dailyPractice");
            return (Criteria) this;
        }

        public Criteria andDailyTotalAvgIsNull() {
            addCriterion("DAILY_TOTAL_AVG is null");
            return (Criteria) this;
        }

        public Criteria andDailyTotalAvgIsNotNull() {
            addCriterion("DAILY_TOTAL_AVG is not null");
            return (Criteria) this;
        }

        public Criteria andDailyTotalAvgEqualTo(BigDecimal value) {
            addCriterion("DAILY_TOTAL_AVG =", value, "dailyTotalAvg");
            return (Criteria) this;
        }

        public Criteria andDailyTotalAvgNotEqualTo(BigDecimal value) {
            addCriterion("DAILY_TOTAL_AVG <>", value, "dailyTotalAvg");
            return (Criteria) this;
        }

        public Criteria andDailyTotalAvgGreaterThan(BigDecimal value) {
            addCriterion("DAILY_TOTAL_AVG >", value, "dailyTotalAvg");
            return (Criteria) this;
        }

        public Criteria andDailyTotalAvgGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DAILY_TOTAL_AVG >=", value, "dailyTotalAvg");
            return (Criteria) this;
        }

        public Criteria andDailyTotalAvgLessThan(BigDecimal value) {
            addCriterion("DAILY_TOTAL_AVG <", value, "dailyTotalAvg");
            return (Criteria) this;
        }

        public Criteria andDailyTotalAvgLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DAILY_TOTAL_AVG <=", value, "dailyTotalAvg");
            return (Criteria) this;
        }

        public Criteria andDailyTotalAvgIn(List<BigDecimal> values) {
            addCriterion("DAILY_TOTAL_AVG in", values, "dailyTotalAvg");
            return (Criteria) this;
        }

        public Criteria andDailyTotalAvgNotIn(List<BigDecimal> values) {
            addCriterion("DAILY_TOTAL_AVG not in", values, "dailyTotalAvg");
            return (Criteria) this;
        }

        public Criteria andDailyTotalAvgBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAILY_TOTAL_AVG between", value1, value2, "dailyTotalAvg");
            return (Criteria) this;
        }

        public Criteria andDailyTotalAvgNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAILY_TOTAL_AVG not between", value1, value2, "dailyTotalAvg");
            return (Criteria) this;
        }

        public Criteria andDailyAvgBudgetIsNull() {
            addCriterion("DAILY_AVG_BUDGET is null");
            return (Criteria) this;
        }

        public Criteria andDailyAvgBudgetIsNotNull() {
            addCriterion("DAILY_AVG_BUDGET is not null");
            return (Criteria) this;
        }

        public Criteria andDailyAvgBudgetEqualTo(BigDecimal value) {
            addCriterion("DAILY_AVG_BUDGET =", value, "dailyAvgBudget");
            return (Criteria) this;
        }

        public Criteria andDailyAvgBudgetNotEqualTo(BigDecimal value) {
            addCriterion("DAILY_AVG_BUDGET <>", value, "dailyAvgBudget");
            return (Criteria) this;
        }

        public Criteria andDailyAvgBudgetGreaterThan(BigDecimal value) {
            addCriterion("DAILY_AVG_BUDGET >", value, "dailyAvgBudget");
            return (Criteria) this;
        }

        public Criteria andDailyAvgBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DAILY_AVG_BUDGET >=", value, "dailyAvgBudget");
            return (Criteria) this;
        }

        public Criteria andDailyAvgBudgetLessThan(BigDecimal value) {
            addCriterion("DAILY_AVG_BUDGET <", value, "dailyAvgBudget");
            return (Criteria) this;
        }

        public Criteria andDailyAvgBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DAILY_AVG_BUDGET <=", value, "dailyAvgBudget");
            return (Criteria) this;
        }

        public Criteria andDailyAvgBudgetIn(List<BigDecimal> values) {
            addCriterion("DAILY_AVG_BUDGET in", values, "dailyAvgBudget");
            return (Criteria) this;
        }

        public Criteria andDailyAvgBudgetNotIn(List<BigDecimal> values) {
            addCriterion("DAILY_AVG_BUDGET not in", values, "dailyAvgBudget");
            return (Criteria) this;
        }

        public Criteria andDailyAvgBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAILY_AVG_BUDGET between", value1, value2, "dailyAvgBudget");
            return (Criteria) this;
        }

        public Criteria andDailyAvgBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAILY_AVG_BUDGET not between", value1, value2, "dailyAvgBudget");
            return (Criteria) this;
        }

        public Criteria andCompletionRateIsNull() {
            addCriterion("COMPLETION_RATE is null");
            return (Criteria) this;
        }

        public Criteria andCompletionRateIsNotNull() {
            addCriterion("COMPLETION_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andCompletionRateEqualTo(BigDecimal value) {
            addCriterion("COMPLETION_RATE =", value, "completionRate");
            return (Criteria) this;
        }

        public Criteria andCompletionRateNotEqualTo(BigDecimal value) {
            addCriterion("COMPLETION_RATE <>", value, "completionRate");
            return (Criteria) this;
        }

        public Criteria andCompletionRateGreaterThan(BigDecimal value) {
            addCriterion("COMPLETION_RATE >", value, "completionRate");
            return (Criteria) this;
        }

        public Criteria andCompletionRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COMPLETION_RATE >=", value, "completionRate");
            return (Criteria) this;
        }

        public Criteria andCompletionRateLessThan(BigDecimal value) {
            addCriterion("COMPLETION_RATE <", value, "completionRate");
            return (Criteria) this;
        }

        public Criteria andCompletionRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COMPLETION_RATE <=", value, "completionRate");
            return (Criteria) this;
        }

        public Criteria andCompletionRateIn(List<BigDecimal> values) {
            addCriterion("COMPLETION_RATE in", values, "completionRate");
            return (Criteria) this;
        }

        public Criteria andCompletionRateNotIn(List<BigDecimal> values) {
            addCriterion("COMPLETION_RATE not in", values, "completionRate");
            return (Criteria) this;
        }

        public Criteria andCompletionRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMPLETION_RATE between", value1, value2, "completionRate");
            return (Criteria) this;
        }

        public Criteria andCompletionRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMPLETION_RATE not between", value1, value2, "completionRate");
            return (Criteria) this;
        }

        public Criteria andThisMonthBudgetIsNull() {
            addCriterion("THIS_MONTH_BUDGET is null");
            return (Criteria) this;
        }

        public Criteria andThisMonthBudgetIsNotNull() {
            addCriterion("THIS_MONTH_BUDGET is not null");
            return (Criteria) this;
        }

        public Criteria andThisMonthBudgetEqualTo(BigDecimal value) {
            addCriterion("THIS_MONTH_BUDGET =", value, "thisMonthBudget");
            return (Criteria) this;
        }

        public Criteria andThisMonthBudgetNotEqualTo(BigDecimal value) {
            addCriterion("THIS_MONTH_BUDGET <>", value, "thisMonthBudget");
            return (Criteria) this;
        }

        public Criteria andThisMonthBudgetGreaterThan(BigDecimal value) {
            addCriterion("THIS_MONTH_BUDGET >", value, "thisMonthBudget");
            return (Criteria) this;
        }

        public Criteria andThisMonthBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_MONTH_BUDGET >=", value, "thisMonthBudget");
            return (Criteria) this;
        }

        public Criteria andThisMonthBudgetLessThan(BigDecimal value) {
            addCriterion("THIS_MONTH_BUDGET <", value, "thisMonthBudget");
            return (Criteria) this;
        }

        public Criteria andThisMonthBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_MONTH_BUDGET <=", value, "thisMonthBudget");
            return (Criteria) this;
        }

        public Criteria andThisMonthBudgetIn(List<BigDecimal> values) {
            addCriterion("THIS_MONTH_BUDGET in", values, "thisMonthBudget");
            return (Criteria) this;
        }

        public Criteria andThisMonthBudgetNotIn(List<BigDecimal> values) {
            addCriterion("THIS_MONTH_BUDGET not in", values, "thisMonthBudget");
            return (Criteria) this;
        }

        public Criteria andThisMonthBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_MONTH_BUDGET between", value1, value2, "thisMonthBudget");
            return (Criteria) this;
        }

        public Criteria andThisMonthBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_MONTH_BUDGET not between", value1, value2, "thisMonthBudget");
            return (Criteria) this;
        }

        public Criteria andThisMonthTotalIsNull() {
            addCriterion("THIS_MONTH_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andThisMonthTotalIsNotNull() {
            addCriterion("THIS_MONTH_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andThisMonthTotalEqualTo(BigDecimal value) {
            addCriterion("THIS_MONTH_TOTAL =", value, "thisMonthTotal");
            return (Criteria) this;
        }

        public Criteria andThisMonthTotalNotEqualTo(BigDecimal value) {
            addCriterion("THIS_MONTH_TOTAL <>", value, "thisMonthTotal");
            return (Criteria) this;
        }

        public Criteria andThisMonthTotalGreaterThan(BigDecimal value) {
            addCriterion("THIS_MONTH_TOTAL >", value, "thisMonthTotal");
            return (Criteria) this;
        }

        public Criteria andThisMonthTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_MONTH_TOTAL >=", value, "thisMonthTotal");
            return (Criteria) this;
        }

        public Criteria andThisMonthTotalLessThan(BigDecimal value) {
            addCriterion("THIS_MONTH_TOTAL <", value, "thisMonthTotal");
            return (Criteria) this;
        }

        public Criteria andThisMonthTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_MONTH_TOTAL <=", value, "thisMonthTotal");
            return (Criteria) this;
        }

        public Criteria andThisMonthTotalIn(List<BigDecimal> values) {
            addCriterion("THIS_MONTH_TOTAL in", values, "thisMonthTotal");
            return (Criteria) this;
        }

        public Criteria andThisMonthTotalNotIn(List<BigDecimal> values) {
            addCriterion("THIS_MONTH_TOTAL not in", values, "thisMonthTotal");
            return (Criteria) this;
        }

        public Criteria andThisMonthTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_MONTH_TOTAL between", value1, value2, "thisMonthTotal");
            return (Criteria) this;
        }

        public Criteria andThisMonthTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_MONTH_TOTAL not between", value1, value2, "thisMonthTotal");
            return (Criteria) this;
        }

        public Criteria andThisMonthCompletionRateIsNull() {
            addCriterion("THIS_MONTH_COMPLETION_RATE is null");
            return (Criteria) this;
        }

        public Criteria andThisMonthCompletionRateIsNotNull() {
            addCriterion("THIS_MONTH_COMPLETION_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andThisMonthCompletionRateEqualTo(BigDecimal value) {
            addCriterion("THIS_MONTH_COMPLETION_RATE =", value, "thisMonthCompletionRate");
            return (Criteria) this;
        }

        public Criteria andThisMonthCompletionRateNotEqualTo(BigDecimal value) {
            addCriterion("THIS_MONTH_COMPLETION_RATE <>", value, "thisMonthCompletionRate");
            return (Criteria) this;
        }

        public Criteria andThisMonthCompletionRateGreaterThan(BigDecimal value) {
            addCriterion("THIS_MONTH_COMPLETION_RATE >", value, "thisMonthCompletionRate");
            return (Criteria) this;
        }

        public Criteria andThisMonthCompletionRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_MONTH_COMPLETION_RATE >=", value, "thisMonthCompletionRate");
            return (Criteria) this;
        }

        public Criteria andThisMonthCompletionRateLessThan(BigDecimal value) {
            addCriterion("THIS_MONTH_COMPLETION_RATE <", value, "thisMonthCompletionRate");
            return (Criteria) this;
        }

        public Criteria andThisMonthCompletionRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_MONTH_COMPLETION_RATE <=", value, "thisMonthCompletionRate");
            return (Criteria) this;
        }

        public Criteria andThisMonthCompletionRateIn(List<BigDecimal> values) {
            addCriterion("THIS_MONTH_COMPLETION_RATE in", values, "thisMonthCompletionRate");
            return (Criteria) this;
        }

        public Criteria andThisMonthCompletionRateNotIn(List<BigDecimal> values) {
            addCriterion("THIS_MONTH_COMPLETION_RATE not in", values, "thisMonthCompletionRate");
            return (Criteria) this;
        }

        public Criteria andThisMonthCompletionRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_MONTH_COMPLETION_RATE between", value1, value2, "thisMonthCompletionRate");
            return (Criteria) this;
        }

        public Criteria andThisMonthCompletionRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_MONTH_COMPLETION_RATE not between", value1, value2, "thisMonthCompletionRate");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}