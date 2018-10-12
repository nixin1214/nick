package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HsmryProductListBudgetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HsmryProductListBudgetExample() {
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

        public Criteria andYearmonthIsNull() {
            addCriterion("YEARMONTH is null");
            return (Criteria) this;
        }

        public Criteria andYearmonthIsNotNull() {
            addCriterion("YEARMONTH is not null");
            return (Criteria) this;
        }

        public Criteria andYearmonthEqualTo(String value) {
            addCriterion("YEARMONTH =", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthNotEqualTo(String value) {
            addCriterion("YEARMONTH <>", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthGreaterThan(String value) {
            addCriterion("YEARMONTH >", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthGreaterThanOrEqualTo(String value) {
            addCriterion("YEARMONTH >=", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthLessThan(String value) {
            addCriterion("YEARMONTH <", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthLessThanOrEqualTo(String value) {
            addCriterion("YEARMONTH <=", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthLike(String value) {
            addCriterion("YEARMONTH like", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthNotLike(String value) {
            addCriterion("YEARMONTH not like", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthIn(List<String> values) {
            addCriterion("YEARMONTH in", values, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthNotIn(List<String> values) {
            addCriterion("YEARMONTH not in", values, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthBetween(String value1, String value2) {
            addCriterion("YEARMONTH between", value1, value2, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthNotBetween(String value1, String value2) {
            addCriterion("YEARMONTH not between", value1, value2, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNull() {
            addCriterion("PRODUCTNAME is null");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNotNull() {
            addCriterion("PRODUCTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andProductnameEqualTo(String value) {
            addCriterion("PRODUCTNAME =", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotEqualTo(String value) {
            addCriterion("PRODUCTNAME <>", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThan(String value) {
            addCriterion("PRODUCTNAME >", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCTNAME >=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThan(String value) {
            addCriterion("PRODUCTNAME <", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThanOrEqualTo(String value) {
            addCriterion("PRODUCTNAME <=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLike(String value) {
            addCriterion("PRODUCTNAME like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotLike(String value) {
            addCriterion("PRODUCTNAME not like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameIn(List<String> values) {
            addCriterion("PRODUCTNAME in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotIn(List<String> values) {
            addCriterion("PRODUCTNAME not in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameBetween(String value1, String value2) {
            addCriterion("PRODUCTNAME between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotBetween(String value1, String value2) {
            addCriterion("PRODUCTNAME not between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeIsNull() {
            addCriterion("SALESVOLUME is null");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeIsNotNull() {
            addCriterion("SALESVOLUME is not null");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeEqualTo(BigDecimal value) {
            addCriterion("SALESVOLUME =", value, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeNotEqualTo(BigDecimal value) {
            addCriterion("SALESVOLUME <>", value, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeGreaterThan(BigDecimal value) {
            addCriterion("SALESVOLUME >", value, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALESVOLUME >=", value, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeLessThan(BigDecimal value) {
            addCriterion("SALESVOLUME <", value, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALESVOLUME <=", value, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeIn(List<BigDecimal> values) {
            addCriterion("SALESVOLUME in", values, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeNotIn(List<BigDecimal> values) {
            addCriterion("SALESVOLUME not in", values, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALESVOLUME between", value1, value2, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALESVOLUME not between", value1, value2, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesamountIsNull() {
            addCriterion("SALESAMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSalesamountIsNotNull() {
            addCriterion("SALESAMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSalesamountEqualTo(BigDecimal value) {
            addCriterion("SALESAMOUNT =", value, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountNotEqualTo(BigDecimal value) {
            addCriterion("SALESAMOUNT <>", value, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountGreaterThan(BigDecimal value) {
            addCriterion("SALESAMOUNT >", value, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALESAMOUNT >=", value, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountLessThan(BigDecimal value) {
            addCriterion("SALESAMOUNT <", value, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALESAMOUNT <=", value, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountIn(List<BigDecimal> values) {
            addCriterion("SALESAMOUNT in", values, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountNotIn(List<BigDecimal> values) {
            addCriterion("SALESAMOUNT not in", values, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALESAMOUNT between", value1, value2, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALESAMOUNT not between", value1, value2, "salesamount");
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

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterionForJDBCDate("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATETIME not between", value1, value2, "updatetime");
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