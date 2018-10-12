package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HSMRYSALEREPORTExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HSMRYSALEREPORTExample() {
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

        public Criteria andFYEAR_MONTHIsNull() {
            addCriterion("FYEAR_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andFYEAR_MONTHIsNotNull() {
            addCriterion("FYEAR_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andFYEAR_MONTHEqualTo(String value) {
            addCriterion("FYEAR_MONTH =", value, "FYEAR_MONTH");
            return (Criteria) this;
        }

        public Criteria andFYEAR_MONTHNotEqualTo(String value) {
            addCriterion("FYEAR_MONTH <>", value, "FYEAR_MONTH");
            return (Criteria) this;
        }

        public Criteria andFYEAR_MONTHGreaterThan(String value) {
            addCriterion("FYEAR_MONTH >", value, "FYEAR_MONTH");
            return (Criteria) this;
        }

        public Criteria andFYEAR_MONTHGreaterThanOrEqualTo(String value) {
            addCriterion("FYEAR_MONTH >=", value, "FYEAR_MONTH");
            return (Criteria) this;
        }

        public Criteria andFYEAR_MONTHLessThan(String value) {
            addCriterion("FYEAR_MONTH <", value, "FYEAR_MONTH");
            return (Criteria) this;
        }

        public Criteria andFYEAR_MONTHLessThanOrEqualTo(String value) {
            addCriterion("FYEAR_MONTH <=", value, "FYEAR_MONTH");
            return (Criteria) this;
        }

        public Criteria andFYEAR_MONTHLike(String value) {
            addCriterion("FYEAR_MONTH like", value, "FYEAR_MONTH");
            return (Criteria) this;
        }

        public Criteria andFYEAR_MONTHNotLike(String value) {
            addCriterion("FYEAR_MONTH not like", value, "FYEAR_MONTH");
            return (Criteria) this;
        }

        public Criteria andFYEAR_MONTHIn(List<String> values) {
            addCriterion("FYEAR_MONTH in", values, "FYEAR_MONTH");
            return (Criteria) this;
        }

        public Criteria andFYEAR_MONTHNotIn(List<String> values) {
            addCriterion("FYEAR_MONTH not in", values, "FYEAR_MONTH");
            return (Criteria) this;
        }

        public Criteria andFYEAR_MONTHBetween(String value1, String value2) {
            addCriterion("FYEAR_MONTH between", value1, value2, "FYEAR_MONTH");
            return (Criteria) this;
        }

        public Criteria andFYEAR_MONTHNotBetween(String value1, String value2) {
            addCriterion("FYEAR_MONTH not between", value1, value2, "FYEAR_MONTH");
            return (Criteria) this;
        }

        public Criteria andFWEIGHTIsNull() {
            addCriterion("FWEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andFWEIGHTIsNotNull() {
            addCriterion("FWEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andFWEIGHTEqualTo(BigDecimal value) {
            addCriterion("FWEIGHT =", value, "FWEIGHT");
            return (Criteria) this;
        }

        public Criteria andFWEIGHTNotEqualTo(BigDecimal value) {
            addCriterion("FWEIGHT <>", value, "FWEIGHT");
            return (Criteria) this;
        }

        public Criteria andFWEIGHTGreaterThan(BigDecimal value) {
            addCriterion("FWEIGHT >", value, "FWEIGHT");
            return (Criteria) this;
        }

        public Criteria andFWEIGHTGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FWEIGHT >=", value, "FWEIGHT");
            return (Criteria) this;
        }

        public Criteria andFWEIGHTLessThan(BigDecimal value) {
            addCriterion("FWEIGHT <", value, "FWEIGHT");
            return (Criteria) this;
        }

        public Criteria andFWEIGHTLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FWEIGHT <=", value, "FWEIGHT");
            return (Criteria) this;
        }

        public Criteria andFWEIGHTIn(List<BigDecimal> values) {
            addCriterion("FWEIGHT in", values, "FWEIGHT");
            return (Criteria) this;
        }

        public Criteria andFWEIGHTNotIn(List<BigDecimal> values) {
            addCriterion("FWEIGHT not in", values, "FWEIGHT");
            return (Criteria) this;
        }

        public Criteria andFWEIGHTBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FWEIGHT between", value1, value2, "FWEIGHT");
            return (Criteria) this;
        }

        public Criteria andFWEIGHTNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FWEIGHT not between", value1, value2, "FWEIGHT");
            return (Criteria) this;
        }

        public Criteria andFAMOUNTIsNull() {
            addCriterion("FAMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFAMOUNTIsNotNull() {
            addCriterion("FAMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFAMOUNTEqualTo(BigDecimal value) {
            addCriterion("FAMOUNT =", value, "FAMOUNT");
            return (Criteria) this;
        }

        public Criteria andFAMOUNTNotEqualTo(BigDecimal value) {
            addCriterion("FAMOUNT <>", value, "FAMOUNT");
            return (Criteria) this;
        }

        public Criteria andFAMOUNTGreaterThan(BigDecimal value) {
            addCriterion("FAMOUNT >", value, "FAMOUNT");
            return (Criteria) this;
        }

        public Criteria andFAMOUNTGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAMOUNT >=", value, "FAMOUNT");
            return (Criteria) this;
        }

        public Criteria andFAMOUNTLessThan(BigDecimal value) {
            addCriterion("FAMOUNT <", value, "FAMOUNT");
            return (Criteria) this;
        }

        public Criteria andFAMOUNTLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAMOUNT <=", value, "FAMOUNT");
            return (Criteria) this;
        }

        public Criteria andFAMOUNTIn(List<BigDecimal> values) {
            addCriterion("FAMOUNT in", values, "FAMOUNT");
            return (Criteria) this;
        }

        public Criteria andFAMOUNTNotIn(List<BigDecimal> values) {
            addCriterion("FAMOUNT not in", values, "FAMOUNT");
            return (Criteria) this;
        }

        public Criteria andFAMOUNTBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAMOUNT between", value1, value2, "FAMOUNT");
            return (Criteria) this;
        }

        public Criteria andFAMOUNTNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAMOUNT not between", value1, value2, "FAMOUNT");
            return (Criteria) this;
        }

        public Criteria andFCHANNELIsNull() {
            addCriterion("FCHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andFCHANNELIsNotNull() {
            addCriterion("FCHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andFCHANNELEqualTo(String value) {
            addCriterion("FCHANNEL =", value, "FCHANNEL");
            return (Criteria) this;
        }

        public Criteria andFCHANNELNotEqualTo(String value) {
            addCriterion("FCHANNEL <>", value, "FCHANNEL");
            return (Criteria) this;
        }

        public Criteria andFCHANNELGreaterThan(String value) {
            addCriterion("FCHANNEL >", value, "FCHANNEL");
            return (Criteria) this;
        }

        public Criteria andFCHANNELGreaterThanOrEqualTo(String value) {
            addCriterion("FCHANNEL >=", value, "FCHANNEL");
            return (Criteria) this;
        }

        public Criteria andFCHANNELLessThan(String value) {
            addCriterion("FCHANNEL <", value, "FCHANNEL");
            return (Criteria) this;
        }

        public Criteria andFCHANNELLessThanOrEqualTo(String value) {
            addCriterion("FCHANNEL <=", value, "FCHANNEL");
            return (Criteria) this;
        }

        public Criteria andFCHANNELLike(String value) {
            addCriterion("FCHANNEL like", value, "FCHANNEL");
            return (Criteria) this;
        }

        public Criteria andFCHANNELNotLike(String value) {
            addCriterion("FCHANNEL not like", value, "FCHANNEL");
            return (Criteria) this;
        }

        public Criteria andFCHANNELIn(List<String> values) {
            addCriterion("FCHANNEL in", values, "FCHANNEL");
            return (Criteria) this;
        }

        public Criteria andFCHANNELNotIn(List<String> values) {
            addCriterion("FCHANNEL not in", values, "FCHANNEL");
            return (Criteria) this;
        }

        public Criteria andFCHANNELBetween(String value1, String value2) {
            addCriterion("FCHANNEL between", value1, value2, "FCHANNEL");
            return (Criteria) this;
        }

        public Criteria andFCHANNELNotBetween(String value1, String value2) {
            addCriterion("FCHANNEL not between", value1, value2, "FCHANNEL");
            return (Criteria) this;
        }

        public Criteria andFAREAIsNull() {
            addCriterion("FAREA is null");
            return (Criteria) this;
        }

        public Criteria andFAREAIsNotNull() {
            addCriterion("FAREA is not null");
            return (Criteria) this;
        }

        public Criteria andFAREAEqualTo(String value) {
            addCriterion("FAREA =", value, "FAREA");
            return (Criteria) this;
        }

        public Criteria andFAREANotEqualTo(String value) {
            addCriterion("FAREA <>", value, "FAREA");
            return (Criteria) this;
        }

        public Criteria andFAREAGreaterThan(String value) {
            addCriterion("FAREA >", value, "FAREA");
            return (Criteria) this;
        }

        public Criteria andFAREAGreaterThanOrEqualTo(String value) {
            addCriterion("FAREA >=", value, "FAREA");
            return (Criteria) this;
        }

        public Criteria andFAREALessThan(String value) {
            addCriterion("FAREA <", value, "FAREA");
            return (Criteria) this;
        }

        public Criteria andFAREALessThanOrEqualTo(String value) {
            addCriterion("FAREA <=", value, "FAREA");
            return (Criteria) this;
        }

        public Criteria andFAREALike(String value) {
            addCriterion("FAREA like", value, "FAREA");
            return (Criteria) this;
        }

        public Criteria andFAREANotLike(String value) {
            addCriterion("FAREA not like", value, "FAREA");
            return (Criteria) this;
        }

        public Criteria andFAREAIn(List<String> values) {
            addCriterion("FAREA in", values, "FAREA");
            return (Criteria) this;
        }

        public Criteria andFAREANotIn(List<String> values) {
            addCriterion("FAREA not in", values, "FAREA");
            return (Criteria) this;
        }

        public Criteria andFAREABetween(String value1, String value2) {
            addCriterion("FAREA between", value1, value2, "FAREA");
            return (Criteria) this;
        }

        public Criteria andFAREANotBetween(String value1, String value2) {
            addCriterion("FAREA not between", value1, value2, "FAREA");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPEIsNull() {
            addCriterion("FPRODUCT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPEIsNotNull() {
            addCriterion("FPRODUCT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPEEqualTo(String value) {
            addCriterion("FPRODUCT_TYPE =", value, "FPRODUCT_TYPE");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPENotEqualTo(String value) {
            addCriterion("FPRODUCT_TYPE <>", value, "FPRODUCT_TYPE");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPEGreaterThan(String value) {
            addCriterion("FPRODUCT_TYPE >", value, "FPRODUCT_TYPE");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPEGreaterThanOrEqualTo(String value) {
            addCriterion("FPRODUCT_TYPE >=", value, "FPRODUCT_TYPE");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPELessThan(String value) {
            addCriterion("FPRODUCT_TYPE <", value, "FPRODUCT_TYPE");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPELessThanOrEqualTo(String value) {
            addCriterion("FPRODUCT_TYPE <=", value, "FPRODUCT_TYPE");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPELike(String value) {
            addCriterion("FPRODUCT_TYPE like", value, "FPRODUCT_TYPE");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPENotLike(String value) {
            addCriterion("FPRODUCT_TYPE not like", value, "FPRODUCT_TYPE");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPEIn(List<String> values) {
            addCriterion("FPRODUCT_TYPE in", values, "FPRODUCT_TYPE");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPENotIn(List<String> values) {
            addCriterion("FPRODUCT_TYPE not in", values, "FPRODUCT_TYPE");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPEBetween(String value1, String value2) {
            addCriterion("FPRODUCT_TYPE between", value1, value2, "FPRODUCT_TYPE");
            return (Criteria) this;
        }

        public Criteria andFPRODUCT_TYPENotBetween(String value1, String value2) {
            addCriterion("FPRODUCT_TYPE not between", value1, value2, "FPRODUCT_TYPE");
            return (Criteria) this;
        }

        public Criteria andFCREATIMEIsNull() {
            addCriterion("FCREATIME is null");
            return (Criteria) this;
        }

        public Criteria andFCREATIMEIsNotNull() {
            addCriterion("FCREATIME is not null");
            return (Criteria) this;
        }

        public Criteria andFCREATIMEEqualTo(Date value) {
            addCriterion("FCREATIME =", value, "FCREATIME");
            return (Criteria) this;
        }

        public Criteria andFCREATIMENotEqualTo(Date value) {
            addCriterion("FCREATIME <>", value, "FCREATIME");
            return (Criteria) this;
        }

        public Criteria andFCREATIMEGreaterThan(Date value) {
            addCriterion("FCREATIME >", value, "FCREATIME");
            return (Criteria) this;
        }

        public Criteria andFCREATIMEGreaterThanOrEqualTo(Date value) {
            addCriterion("FCREATIME >=", value, "FCREATIME");
            return (Criteria) this;
        }

        public Criteria andFCREATIMELessThan(Date value) {
            addCriterion("FCREATIME <", value, "FCREATIME");
            return (Criteria) this;
        }

        public Criteria andFCREATIMELessThanOrEqualTo(Date value) {
            addCriterion("FCREATIME <=", value, "FCREATIME");
            return (Criteria) this;
        }

        public Criteria andFCREATIMEIn(List<Date> values) {
            addCriterion("FCREATIME in", values, "FCREATIME");
            return (Criteria) this;
        }

        public Criteria andFCREATIMENotIn(List<Date> values) {
            addCriterion("FCREATIME not in", values, "FCREATIME");
            return (Criteria) this;
        }

        public Criteria andFCREATIMEBetween(Date value1, Date value2) {
            addCriterion("FCREATIME between", value1, value2, "FCREATIME");
            return (Criteria) this;
        }

        public Criteria andFCREATIMENotBetween(Date value1, Date value2) {
            addCriterion("FCREATIME not between", value1, value2, "FCREATIME");
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