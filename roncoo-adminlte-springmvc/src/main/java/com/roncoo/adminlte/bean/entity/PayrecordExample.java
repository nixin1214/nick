package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PayrecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayrecordExample() {
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

        public Criteria andOilnameIsNull() {
            addCriterion("OILNAME is null");
            return (Criteria) this;
        }

        public Criteria andOilnameIsNotNull() {
            addCriterion("OILNAME is not null");
            return (Criteria) this;
        }

        public Criteria andOilnameEqualTo(String value) {
            addCriterion("OILNAME =", value, "oilname");
            return (Criteria) this;
        }

        public Criteria andOilnameNotEqualTo(String value) {
            addCriterion("OILNAME <>", value, "oilname");
            return (Criteria) this;
        }

        public Criteria andOilnameGreaterThan(String value) {
            addCriterion("OILNAME >", value, "oilname");
            return (Criteria) this;
        }

        public Criteria andOilnameGreaterThanOrEqualTo(String value) {
            addCriterion("OILNAME >=", value, "oilname");
            return (Criteria) this;
        }

        public Criteria andOilnameLessThan(String value) {
            addCriterion("OILNAME <", value, "oilname");
            return (Criteria) this;
        }

        public Criteria andOilnameLessThanOrEqualTo(String value) {
            addCriterion("OILNAME <=", value, "oilname");
            return (Criteria) this;
        }

        public Criteria andOilnameLike(String value) {
            addCriterion("OILNAME like", value, "oilname");
            return (Criteria) this;
        }

        public Criteria andOilnameNotLike(String value) {
            addCriterion("OILNAME not like", value, "oilname");
            return (Criteria) this;
        }

        public Criteria andOilnameIn(List<String> values) {
            addCriterion("OILNAME in", values, "oilname");
            return (Criteria) this;
        }

        public Criteria andOilnameNotIn(List<String> values) {
            addCriterion("OILNAME not in", values, "oilname");
            return (Criteria) this;
        }

        public Criteria andOilnameBetween(String value1, String value2) {
            addCriterion("OILNAME between", value1, value2, "oilname");
            return (Criteria) this;
        }

        public Criteria andOilnameNotBetween(String value1, String value2) {
            addCriterion("OILNAME not between", value1, value2, "oilname");
            return (Criteria) this;
        }

        public Criteria andOilpriceIsNull() {
            addCriterion("OILPRICE is null");
            return (Criteria) this;
        }

        public Criteria andOilpriceIsNotNull() {
            addCriterion("OILPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOilpriceEqualTo(BigDecimal value) {
            addCriterion("OILPRICE =", value, "oilprice");
            return (Criteria) this;
        }

        public Criteria andOilpriceNotEqualTo(BigDecimal value) {
            addCriterion("OILPRICE <>", value, "oilprice");
            return (Criteria) this;
        }

        public Criteria andOilpriceGreaterThan(BigDecimal value) {
            addCriterion("OILPRICE >", value, "oilprice");
            return (Criteria) this;
        }

        public Criteria andOilpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OILPRICE >=", value, "oilprice");
            return (Criteria) this;
        }

        public Criteria andOilpriceLessThan(BigDecimal value) {
            addCriterion("OILPRICE <", value, "oilprice");
            return (Criteria) this;
        }

        public Criteria andOilpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OILPRICE <=", value, "oilprice");
            return (Criteria) this;
        }

        public Criteria andOilpriceIn(List<BigDecimal> values) {
            addCriterion("OILPRICE in", values, "oilprice");
            return (Criteria) this;
        }

        public Criteria andOilpriceNotIn(List<BigDecimal> values) {
            addCriterion("OILPRICE not in", values, "oilprice");
            return (Criteria) this;
        }

        public Criteria andOilpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OILPRICE between", value1, value2, "oilprice");
            return (Criteria) this;
        }

        public Criteria andOilpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OILPRICE not between", value1, value2, "oilprice");
            return (Criteria) this;
        }

        public Criteria andLitersIsNull() {
            addCriterion("LITERS is null");
            return (Criteria) this;
        }

        public Criteria andLitersIsNotNull() {
            addCriterion("LITERS is not null");
            return (Criteria) this;
        }

        public Criteria andLitersEqualTo(BigDecimal value) {
            addCriterion("LITERS =", value, "liters");
            return (Criteria) this;
        }

        public Criteria andLitersNotEqualTo(BigDecimal value) {
            addCriterion("LITERS <>", value, "liters");
            return (Criteria) this;
        }

        public Criteria andLitersGreaterThan(BigDecimal value) {
            addCriterion("LITERS >", value, "liters");
            return (Criteria) this;
        }

        public Criteria andLitersGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LITERS >=", value, "liters");
            return (Criteria) this;
        }

        public Criteria andLitersLessThan(BigDecimal value) {
            addCriterion("LITERS <", value, "liters");
            return (Criteria) this;
        }

        public Criteria andLitersLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LITERS <=", value, "liters");
            return (Criteria) this;
        }

        public Criteria andLitersIn(List<BigDecimal> values) {
            addCriterion("LITERS in", values, "liters");
            return (Criteria) this;
        }

        public Criteria andLitersNotIn(List<BigDecimal> values) {
            addCriterion("LITERS not in", values, "liters");
            return (Criteria) this;
        }

        public Criteria andLitersBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LITERS between", value1, value2, "liters");
            return (Criteria) this;
        }

        public Criteria andLitersNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LITERS not between", value1, value2, "liters");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIsNull() {
            addCriterion("FINISHTIME is null");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIsNotNull() {
            addCriterion("FINISHTIME is not null");
            return (Criteria) this;
        }

        public Criteria andFinishtimeEqualTo(String value) {
            addCriterion("FINISHTIME =", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotEqualTo(String value) {
            addCriterion("FINISHTIME <>", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeGreaterThan(String value) {
            addCriterion("FINISHTIME >", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeGreaterThanOrEqualTo(String value) {
            addCriterion("FINISHTIME >=", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeLessThan(String value) {
            addCriterion("FINISHTIME <", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeLessThanOrEqualTo(String value) {
            addCriterion("FINISHTIME <=", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeLike(String value) {
            addCriterion("FINISHTIME like", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotLike(String value) {
            addCriterion("FINISHTIME not like", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIn(List<String> values) {
            addCriterion("FINISHTIME in", values, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotIn(List<String> values) {
            addCriterion("FINISHTIME not in", values, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeBetween(String value1, String value2) {
            addCriterion("FINISHTIME between", value1, value2, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotBetween(String value1, String value2) {
            addCriterion("FINISHTIME not between", value1, value2, "finishtime");
            return (Criteria) this;
        }

        public Criteria andCardnoIsNull() {
            addCriterion("CARDNO is null");
            return (Criteria) this;
        }

        public Criteria andCardnoIsNotNull() {
            addCriterion("CARDNO is not null");
            return (Criteria) this;
        }

        public Criteria andCardnoEqualTo(String value) {
            addCriterion("CARDNO =", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotEqualTo(String value) {
            addCriterion("CARDNO <>", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoGreaterThan(String value) {
            addCriterion("CARDNO >", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoGreaterThanOrEqualTo(String value) {
            addCriterion("CARDNO >=", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLessThan(String value) {
            addCriterion("CARDNO <", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLessThanOrEqualTo(String value) {
            addCriterion("CARDNO <=", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLike(String value) {
            addCriterion("CARDNO like", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotLike(String value) {
            addCriterion("CARDNO not like", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoIn(List<String> values) {
            addCriterion("CARDNO in", values, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotIn(List<String> values) {
            addCriterion("CARDNO not in", values, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoBetween(String value1, String value2) {
            addCriterion("CARDNO between", value1, value2, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotBetween(String value1, String value2) {
            addCriterion("CARDNO not between", value1, value2, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardremainIsNull() {
            addCriterion("CARDREMAIN is null");
            return (Criteria) this;
        }

        public Criteria andCardremainIsNotNull() {
            addCriterion("CARDREMAIN is not null");
            return (Criteria) this;
        }

        public Criteria andCardremainEqualTo(BigDecimal value) {
            addCriterion("CARDREMAIN =", value, "cardremain");
            return (Criteria) this;
        }

        public Criteria andCardremainNotEqualTo(BigDecimal value) {
            addCriterion("CARDREMAIN <>", value, "cardremain");
            return (Criteria) this;
        }

        public Criteria andCardremainGreaterThan(BigDecimal value) {
            addCriterion("CARDREMAIN >", value, "cardremain");
            return (Criteria) this;
        }

        public Criteria andCardremainGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CARDREMAIN >=", value, "cardremain");
            return (Criteria) this;
        }

        public Criteria andCardremainLessThan(BigDecimal value) {
            addCriterion("CARDREMAIN <", value, "cardremain");
            return (Criteria) this;
        }

        public Criteria andCardremainLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CARDREMAIN <=", value, "cardremain");
            return (Criteria) this;
        }

        public Criteria andCardremainIn(List<BigDecimal> values) {
            addCriterion("CARDREMAIN in", values, "cardremain");
            return (Criteria) this;
        }

        public Criteria andCardremainNotIn(List<BigDecimal> values) {
            addCriterion("CARDREMAIN not in", values, "cardremain");
            return (Criteria) this;
        }

        public Criteria andCardremainBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CARDREMAIN between", value1, value2, "cardremain");
            return (Criteria) this;
        }

        public Criteria andCardremainNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CARDREMAIN not between", value1, value2, "cardremain");
            return (Criteria) this;
        }

        public Criteria andCarnoIsNull() {
            addCriterion("CARNO is null");
            return (Criteria) this;
        }

        public Criteria andCarnoIsNotNull() {
            addCriterion("CARNO is not null");
            return (Criteria) this;
        }

        public Criteria andCarnoEqualTo(String value) {
            addCriterion("CARNO =", value, "carno");
            return (Criteria) this;
        }

        public Criteria andCarnoNotEqualTo(String value) {
            addCriterion("CARNO <>", value, "carno");
            return (Criteria) this;
        }

        public Criteria andCarnoGreaterThan(String value) {
            addCriterion("CARNO >", value, "carno");
            return (Criteria) this;
        }

        public Criteria andCarnoGreaterThanOrEqualTo(String value) {
            addCriterion("CARNO >=", value, "carno");
            return (Criteria) this;
        }

        public Criteria andCarnoLessThan(String value) {
            addCriterion("CARNO <", value, "carno");
            return (Criteria) this;
        }

        public Criteria andCarnoLessThanOrEqualTo(String value) {
            addCriterion("CARNO <=", value, "carno");
            return (Criteria) this;
        }

        public Criteria andCarnoLike(String value) {
            addCriterion("CARNO like", value, "carno");
            return (Criteria) this;
        }

        public Criteria andCarnoNotLike(String value) {
            addCriterion("CARNO not like", value, "carno");
            return (Criteria) this;
        }

        public Criteria andCarnoIn(List<String> values) {
            addCriterion("CARNO in", values, "carno");
            return (Criteria) this;
        }

        public Criteria andCarnoNotIn(List<String> values) {
            addCriterion("CARNO not in", values, "carno");
            return (Criteria) this;
        }

        public Criteria andCarnoBetween(String value1, String value2) {
            addCriterion("CARNO between", value1, value2, "carno");
            return (Criteria) this;
        }

        public Criteria andCarnoNotBetween(String value1, String value2) {
            addCriterion("CARNO not between", value1, value2, "carno");
            return (Criteria) this;
        }

        public Criteria andCardnameIsNull() {
            addCriterion("CARDNAME is null");
            return (Criteria) this;
        }

        public Criteria andCardnameIsNotNull() {
            addCriterion("CARDNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCardnameEqualTo(String value) {
            addCriterion("CARDNAME =", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameNotEqualTo(String value) {
            addCriterion("CARDNAME <>", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameGreaterThan(String value) {
            addCriterion("CARDNAME >", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameGreaterThanOrEqualTo(String value) {
            addCriterion("CARDNAME >=", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameLessThan(String value) {
            addCriterion("CARDNAME <", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameLessThanOrEqualTo(String value) {
            addCriterion("CARDNAME <=", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameLike(String value) {
            addCriterion("CARDNAME like", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameNotLike(String value) {
            addCriterion("CARDNAME not like", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameIn(List<String> values) {
            addCriterion("CARDNAME in", values, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameNotIn(List<String> values) {
            addCriterion("CARDNAME not in", values, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameBetween(String value1, String value2) {
            addCriterion("CARDNAME between", value1, value2, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameNotBetween(String value1, String value2) {
            addCriterion("CARDNAME not between", value1, value2, "cardname");
            return (Criteria) this;
        }

        public Criteria andStationnameIsNull() {
            addCriterion("STATIONNAME is null");
            return (Criteria) this;
        }

        public Criteria andStationnameIsNotNull() {
            addCriterion("STATIONNAME is not null");
            return (Criteria) this;
        }

        public Criteria andStationnameEqualTo(String value) {
            addCriterion("STATIONNAME =", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotEqualTo(String value) {
            addCriterion("STATIONNAME <>", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameGreaterThan(String value) {
            addCriterion("STATIONNAME >", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameGreaterThanOrEqualTo(String value) {
            addCriterion("STATIONNAME >=", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLessThan(String value) {
            addCriterion("STATIONNAME <", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLessThanOrEqualTo(String value) {
            addCriterion("STATIONNAME <=", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLike(String value) {
            addCriterion("STATIONNAME like", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotLike(String value) {
            addCriterion("STATIONNAME not like", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameIn(List<String> values) {
            addCriterion("STATIONNAME in", values, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotIn(List<String> values) {
            addCriterion("STATIONNAME not in", values, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameBetween(String value1, String value2) {
            addCriterion("STATIONNAME between", value1, value2, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotBetween(String value1, String value2) {
            addCriterion("STATIONNAME not between", value1, value2, "stationname");
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