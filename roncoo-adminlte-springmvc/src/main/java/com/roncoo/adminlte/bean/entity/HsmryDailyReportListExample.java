package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HsmryDailyReportListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HsmryDailyReportListExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andClassificationIsNull() {
            addCriterion("CLASSIFICATION is null");
            return (Criteria) this;
        }

        public Criteria andClassificationIsNotNull() {
            addCriterion("CLASSIFICATION is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationEqualTo(String value) {
            addCriterion("CLASSIFICATION =", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotEqualTo(String value) {
            addCriterion("CLASSIFICATION <>", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThan(String value) {
            addCriterion("CLASSIFICATION >", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThanOrEqualTo(String value) {
            addCriterion("CLASSIFICATION >=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThan(String value) {
            addCriterion("CLASSIFICATION <", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThanOrEqualTo(String value) {
            addCriterion("CLASSIFICATION <=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLike(String value) {
            addCriterion("CLASSIFICATION like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotLike(String value) {
            addCriterion("CLASSIFICATION not like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationIn(List<String> values) {
            addCriterion("CLASSIFICATION in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotIn(List<String> values) {
            addCriterion("CLASSIFICATION not in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationBetween(String value1, String value2) {
            addCriterion("CLASSIFICATION between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotBetween(String value1, String value2) {
            addCriterion("CLASSIFICATION not between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("PRODUCT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("PRODUCT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("PRODUCT_NAME =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("PRODUCT_NAME <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("PRODUCT_NAME >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("PRODUCT_NAME <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("PRODUCT_NAME like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("PRODUCT_NAME not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("PRODUCT_NAME in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("PRODUCT_NAME not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeTotalIsNull() {
            addCriterion("SALES_VOLUME_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeTotalIsNotNull() {
            addCriterion("SALES_VOLUME_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeTotalEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME_TOTAL =", value, "salesVolumeTotal");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeTotalNotEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME_TOTAL <>", value, "salesVolumeTotal");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeTotalGreaterThan(BigDecimal value) {
            addCriterion("SALES_VOLUME_TOTAL >", value, "salesVolumeTotal");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME_TOTAL >=", value, "salesVolumeTotal");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeTotalLessThan(BigDecimal value) {
            addCriterion("SALES_VOLUME_TOTAL <", value, "salesVolumeTotal");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME_TOTAL <=", value, "salesVolumeTotal");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeTotalIn(List<BigDecimal> values) {
            addCriterion("SALES_VOLUME_TOTAL in", values, "salesVolumeTotal");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeTotalNotIn(List<BigDecimal> values) {
            addCriterion("SALES_VOLUME_TOTAL not in", values, "salesVolumeTotal");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_VOLUME_TOTAL between", value1, value2, "salesVolumeTotal");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_VOLUME_TOTAL not between", value1, value2, "salesVolumeTotal");
            return (Criteria) this;
        }

        public Criteria andSalesAmountTatalIsNull() {
            addCriterion("SALES_AMOUNT_TATAL is null");
            return (Criteria) this;
        }

        public Criteria andSalesAmountTatalIsNotNull() {
            addCriterion("SALES_AMOUNT_TATAL is not null");
            return (Criteria) this;
        }

        public Criteria andSalesAmountTatalEqualTo(BigDecimal value) {
            addCriterion("SALES_AMOUNT_TATAL =", value, "salesAmountTatal");
            return (Criteria) this;
        }

        public Criteria andSalesAmountTatalNotEqualTo(BigDecimal value) {
            addCriterion("SALES_AMOUNT_TATAL <>", value, "salesAmountTatal");
            return (Criteria) this;
        }

        public Criteria andSalesAmountTatalGreaterThan(BigDecimal value) {
            addCriterion("SALES_AMOUNT_TATAL >", value, "salesAmountTatal");
            return (Criteria) this;
        }

        public Criteria andSalesAmountTatalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_AMOUNT_TATAL >=", value, "salesAmountTatal");
            return (Criteria) this;
        }

        public Criteria andSalesAmountTatalLessThan(BigDecimal value) {
            addCriterion("SALES_AMOUNT_TATAL <", value, "salesAmountTatal");
            return (Criteria) this;
        }

        public Criteria andSalesAmountTatalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_AMOUNT_TATAL <=", value, "salesAmountTatal");
            return (Criteria) this;
        }

        public Criteria andSalesAmountTatalIn(List<BigDecimal> values) {
            addCriterion("SALES_AMOUNT_TATAL in", values, "salesAmountTatal");
            return (Criteria) this;
        }

        public Criteria andSalesAmountTatalNotIn(List<BigDecimal> values) {
            addCriterion("SALES_AMOUNT_TATAL not in", values, "salesAmountTatal");
            return (Criteria) this;
        }

        public Criteria andSalesAmountTatalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_AMOUNT_TATAL between", value1, value2, "salesAmountTatal");
            return (Criteria) this;
        }

        public Criteria andSalesAmountTatalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_AMOUNT_TATAL not between", value1, value2, "salesAmountTatal");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBudgetIsNull() {
            addCriterion("SALES_VOLUME_BUDGET is null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBudgetIsNotNull() {
            addCriterion("SALES_VOLUME_BUDGET is not null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBudgetEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME_BUDGET =", value, "salesVolumeBudget");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBudgetNotEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME_BUDGET <>", value, "salesVolumeBudget");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBudgetGreaterThan(BigDecimal value) {
            addCriterion("SALES_VOLUME_BUDGET >", value, "salesVolumeBudget");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME_BUDGET >=", value, "salesVolumeBudget");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBudgetLessThan(BigDecimal value) {
            addCriterion("SALES_VOLUME_BUDGET <", value, "salesVolumeBudget");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME_BUDGET <=", value, "salesVolumeBudget");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBudgetIn(List<BigDecimal> values) {
            addCriterion("SALES_VOLUME_BUDGET in", values, "salesVolumeBudget");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBudgetNotIn(List<BigDecimal> values) {
            addCriterion("SALES_VOLUME_BUDGET not in", values, "salesVolumeBudget");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_VOLUME_BUDGET between", value1, value2, "salesVolumeBudget");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_VOLUME_BUDGET not between", value1, value2, "salesVolumeBudget");
            return (Criteria) this;
        }

        public Criteria andSalesAmountBudgetIsNull() {
            addCriterion("SALES_AMOUNT_BUDGET is null");
            return (Criteria) this;
        }

        public Criteria andSalesAmountBudgetIsNotNull() {
            addCriterion("SALES_AMOUNT_BUDGET is not null");
            return (Criteria) this;
        }

        public Criteria andSalesAmountBudgetEqualTo(BigDecimal value) {
            addCriterion("SALES_AMOUNT_BUDGET =", value, "salesAmountBudget");
            return (Criteria) this;
        }

        public Criteria andSalesAmountBudgetNotEqualTo(BigDecimal value) {
            addCriterion("SALES_AMOUNT_BUDGET <>", value, "salesAmountBudget");
            return (Criteria) this;
        }

        public Criteria andSalesAmountBudgetGreaterThan(BigDecimal value) {
            addCriterion("SALES_AMOUNT_BUDGET >", value, "salesAmountBudget");
            return (Criteria) this;
        }

        public Criteria andSalesAmountBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_AMOUNT_BUDGET >=", value, "salesAmountBudget");
            return (Criteria) this;
        }

        public Criteria andSalesAmountBudgetLessThan(BigDecimal value) {
            addCriterion("SALES_AMOUNT_BUDGET <", value, "salesAmountBudget");
            return (Criteria) this;
        }

        public Criteria andSalesAmountBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_AMOUNT_BUDGET <=", value, "salesAmountBudget");
            return (Criteria) this;
        }

        public Criteria andSalesAmountBudgetIn(List<BigDecimal> values) {
            addCriterion("SALES_AMOUNT_BUDGET in", values, "salesAmountBudget");
            return (Criteria) this;
        }

        public Criteria andSalesAmountBudgetNotIn(List<BigDecimal> values) {
            addCriterion("SALES_AMOUNT_BUDGET not in", values, "salesAmountBudget");
            return (Criteria) this;
        }

        public Criteria andSalesAmountBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_AMOUNT_BUDGET between", value1, value2, "salesAmountBudget");
            return (Criteria) this;
        }

        public Criteria andSalesAmountBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_AMOUNT_BUDGET not between", value1, value2, "salesAmountBudget");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeActualIsNull() {
            addCriterion("SALES_VOLUME_ACTUAL is null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeActualIsNotNull() {
            addCriterion("SALES_VOLUME_ACTUAL is not null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeActualEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME_ACTUAL =", value, "salesVolumeActual");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeActualNotEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME_ACTUAL <>", value, "salesVolumeActual");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeActualGreaterThan(BigDecimal value) {
            addCriterion("SALES_VOLUME_ACTUAL >", value, "salesVolumeActual");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME_ACTUAL >=", value, "salesVolumeActual");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeActualLessThan(BigDecimal value) {
            addCriterion("SALES_VOLUME_ACTUAL <", value, "salesVolumeActual");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME_ACTUAL <=", value, "salesVolumeActual");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeActualIn(List<BigDecimal> values) {
            addCriterion("SALES_VOLUME_ACTUAL in", values, "salesVolumeActual");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeActualNotIn(List<BigDecimal> values) {
            addCriterion("SALES_VOLUME_ACTUAL not in", values, "salesVolumeActual");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_VOLUME_ACTUAL between", value1, value2, "salesVolumeActual");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_VOLUME_ACTUAL not between", value1, value2, "salesVolumeActual");
            return (Criteria) this;
        }

        public Criteria andSalesAmountActualIsNull() {
            addCriterion("SALES_AMOUNT_ACTUAL is null");
            return (Criteria) this;
        }

        public Criteria andSalesAmountActualIsNotNull() {
            addCriterion("SALES_AMOUNT_ACTUAL is not null");
            return (Criteria) this;
        }

        public Criteria andSalesAmountActualEqualTo(BigDecimal value) {
            addCriterion("SALES_AMOUNT_ACTUAL =", value, "salesAmountActual");
            return (Criteria) this;
        }

        public Criteria andSalesAmountActualNotEqualTo(BigDecimal value) {
            addCriterion("SALES_AMOUNT_ACTUAL <>", value, "salesAmountActual");
            return (Criteria) this;
        }

        public Criteria andSalesAmountActualGreaterThan(BigDecimal value) {
            addCriterion("SALES_AMOUNT_ACTUAL >", value, "salesAmountActual");
            return (Criteria) this;
        }

        public Criteria andSalesAmountActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_AMOUNT_ACTUAL >=", value, "salesAmountActual");
            return (Criteria) this;
        }

        public Criteria andSalesAmountActualLessThan(BigDecimal value) {
            addCriterion("SALES_AMOUNT_ACTUAL <", value, "salesAmountActual");
            return (Criteria) this;
        }

        public Criteria andSalesAmountActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_AMOUNT_ACTUAL <=", value, "salesAmountActual");
            return (Criteria) this;
        }

        public Criteria andSalesAmountActualIn(List<BigDecimal> values) {
            addCriterion("SALES_AMOUNT_ACTUAL in", values, "salesAmountActual");
            return (Criteria) this;
        }

        public Criteria andSalesAmountActualNotIn(List<BigDecimal> values) {
            addCriterion("SALES_AMOUNT_ACTUAL not in", values, "salesAmountActual");
            return (Criteria) this;
        }

        public Criteria andSalesAmountActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_AMOUNT_ACTUAL between", value1, value2, "salesAmountActual");
            return (Criteria) this;
        }

        public Criteria andSalesAmountActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_AMOUNT_ACTUAL not between", value1, value2, "salesAmountActual");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("DAYS is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Long value) {
            addCriterion("DAYS =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Long value) {
            addCriterion("DAYS <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Long value) {
            addCriterion("DAYS >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Long value) {
            addCriterion("DAYS >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Long value) {
            addCriterion("DAYS <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Long value) {
            addCriterion("DAYS <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Long> values) {
            addCriterion("DAYS in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Long> values) {
            addCriterion("DAYS not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Long value1, Long value2) {
            addCriterion("DAYS between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Long value1, Long value2) {
            addCriterion("DAYS not between", value1, value2, "days");
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