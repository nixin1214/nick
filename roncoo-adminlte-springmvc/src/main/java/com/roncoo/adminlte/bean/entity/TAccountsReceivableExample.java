package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TAccountsReceivableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TAccountsReceivableExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setPageSize(int pageSize) {
        this.pageSize=pageSize;
    }

    public int getPageSize() {
        return pageSize;
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

        public Criteria andFheadIdIsNull() {
            addCriterion("FHEAD_ID is null");
            return (Criteria) this;
        }

        public Criteria andFheadIdIsNotNull() {
            addCriterion("FHEAD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFheadIdEqualTo(BigDecimal value) {
            addCriterion("FHEAD_ID =", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotEqualTo(BigDecimal value) {
            addCriterion("FHEAD_ID <>", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdGreaterThan(BigDecimal value) {
            addCriterion("FHEAD_ID >", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FHEAD_ID >=", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdLessThan(BigDecimal value) {
            addCriterion("FHEAD_ID <", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FHEAD_ID <=", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdIn(List<BigDecimal> values) {
            addCriterion("FHEAD_ID in", values, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotIn(List<BigDecimal> values) {
            addCriterion("FHEAD_ID not in", values, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FHEAD_ID between", value1, value2, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FHEAD_ID not between", value1, value2, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFrowIndexIsNull() {
            addCriterion("FROW_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andFrowIndexIsNotNull() {
            addCriterion("FROW_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andFrowIndexEqualTo(Long value) {
            addCriterion("FROW_INDEX =", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexNotEqualTo(Long value) {
            addCriterion("FROW_INDEX <>", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexGreaterThan(Long value) {
            addCriterion("FROW_INDEX >", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("FROW_INDEX >=", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexLessThan(Long value) {
            addCriterion("FROW_INDEX <", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexLessThanOrEqualTo(Long value) {
            addCriterion("FROW_INDEX <=", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexIn(List<Long> values) {
            addCriterion("FROW_INDEX in", values, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexNotIn(List<Long> values) {
            addCriterion("FROW_INDEX not in", values, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexBetween(Long value1, Long value2) {
            addCriterion("FROW_INDEX between", value1, value2, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexNotBetween(Long value1, Long value2) {
            addCriterion("FROW_INDEX not between", value1, value2, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andDistributorIsNull() {
            addCriterion("DISTRIBUTOR is null");
            return (Criteria) this;
        }

        public Criteria andDistributorIsNotNull() {
            addCriterion("DISTRIBUTOR is not null");
            return (Criteria) this;
        }

        public Criteria andDistributorEqualTo(String value) {
            addCriterion("DISTRIBUTOR =", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorNotEqualTo(String value) {
            addCriterion("DISTRIBUTOR <>", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorGreaterThan(String value) {
            addCriterion("DISTRIBUTOR >", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorGreaterThanOrEqualTo(String value) {
            addCriterion("DISTRIBUTOR >=", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorLessThan(String value) {
            addCriterion("DISTRIBUTOR <", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorLessThanOrEqualTo(String value) {
            addCriterion("DISTRIBUTOR <=", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorLike(String value) {
            addCriterion("DISTRIBUTOR like", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorNotLike(String value) {
            addCriterion("DISTRIBUTOR not like", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorIn(List<String> values) {
            addCriterion("DISTRIBUTOR in", values, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorNotIn(List<String> values) {
            addCriterion("DISTRIBUTOR not in", values, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorBetween(String value1, String value2) {
            addCriterion("DISTRIBUTOR between", value1, value2, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorNotBetween(String value1, String value2) {
            addCriterion("DISTRIBUTOR not between", value1, value2, "distributor");
            return (Criteria) this;
        }

        public Criteria andAccountsReceivableIsNull() {
            addCriterion("ACCOUNTS_RECEIVABLE is null");
            return (Criteria) this;
        }

        public Criteria andAccountsReceivableIsNotNull() {
            addCriterion("ACCOUNTS_RECEIVABLE is not null");
            return (Criteria) this;
        }

        public Criteria andAccountsReceivableEqualTo(BigDecimal value) {
            addCriterion("ACCOUNTS_RECEIVABLE =", value, "accountsReceivable");
            return (Criteria) this;
        }

        public Criteria andAccountsReceivableNotEqualTo(BigDecimal value) {
            addCriterion("ACCOUNTS_RECEIVABLE <>", value, "accountsReceivable");
            return (Criteria) this;
        }

        public Criteria andAccountsReceivableGreaterThan(BigDecimal value) {
            addCriterion("ACCOUNTS_RECEIVABLE >", value, "accountsReceivable");
            return (Criteria) this;
        }

        public Criteria andAccountsReceivableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCOUNTS_RECEIVABLE >=", value, "accountsReceivable");
            return (Criteria) this;
        }

        public Criteria andAccountsReceivableLessThan(BigDecimal value) {
            addCriterion("ACCOUNTS_RECEIVABLE <", value, "accountsReceivable");
            return (Criteria) this;
        }

        public Criteria andAccountsReceivableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCOUNTS_RECEIVABLE <=", value, "accountsReceivable");
            return (Criteria) this;
        }

        public Criteria andAccountsReceivableIn(List<BigDecimal> values) {
            addCriterion("ACCOUNTS_RECEIVABLE in", values, "accountsReceivable");
            return (Criteria) this;
        }

        public Criteria andAccountsReceivableNotIn(List<BigDecimal> values) {
            addCriterion("ACCOUNTS_RECEIVABLE not in", values, "accountsReceivable");
            return (Criteria) this;
        }

        public Criteria andAccountsReceivableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCOUNTS_RECEIVABLE between", value1, value2, "accountsReceivable");
            return (Criteria) this;
        }

        public Criteria andAccountsReceivableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCOUNTS_RECEIVABLE not between", value1, value2, "accountsReceivable");
            return (Criteria) this;
        }

        public Criteria andGrowthRateIsNull() {
            addCriterion("GROWTH_RATE is null");
            return (Criteria) this;
        }

        public Criteria andGrowthRateIsNotNull() {
            addCriterion("GROWTH_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andGrowthRateEqualTo(BigDecimal value) {
            addCriterion("GROWTH_RATE =", value, "growthRate");
            return (Criteria) this;
        }

        public Criteria andGrowthRateNotEqualTo(BigDecimal value) {
            addCriterion("GROWTH_RATE <>", value, "growthRate");
            return (Criteria) this;
        }

        public Criteria andGrowthRateGreaterThan(BigDecimal value) {
            addCriterion("GROWTH_RATE >", value, "growthRate");
            return (Criteria) this;
        }

        public Criteria andGrowthRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GROWTH_RATE >=", value, "growthRate");
            return (Criteria) this;
        }

        public Criteria andGrowthRateLessThan(BigDecimal value) {
            addCriterion("GROWTH_RATE <", value, "growthRate");
            return (Criteria) this;
        }

        public Criteria andGrowthRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GROWTH_RATE <=", value, "growthRate");
            return (Criteria) this;
        }

        public Criteria andGrowthRateIn(List<BigDecimal> values) {
            addCriterion("GROWTH_RATE in", values, "growthRate");
            return (Criteria) this;
        }

        public Criteria andGrowthRateNotIn(List<BigDecimal> values) {
            addCriterion("GROWTH_RATE not in", values, "growthRate");
            return (Criteria) this;
        }

        public Criteria andGrowthRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GROWTH_RATE between", value1, value2, "growthRate");
            return (Criteria) this;
        }

        public Criteria andGrowthRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GROWTH_RATE not between", value1, value2, "growthRate");
            return (Criteria) this;
        }

        public Criteria andRingRatioIsNull() {
            addCriterion("RING_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andRingRatioIsNotNull() {
            addCriterion("RING_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andRingRatioEqualTo(BigDecimal value) {
            addCriterion("RING_RATIO =", value, "ringRatio");
            return (Criteria) this;
        }

        public Criteria andRingRatioNotEqualTo(BigDecimal value) {
            addCriterion("RING_RATIO <>", value, "ringRatio");
            return (Criteria) this;
        }

        public Criteria andRingRatioGreaterThan(BigDecimal value) {
            addCriterion("RING_RATIO >", value, "ringRatio");
            return (Criteria) this;
        }

        public Criteria andRingRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RING_RATIO >=", value, "ringRatio");
            return (Criteria) this;
        }

        public Criteria andRingRatioLessThan(BigDecimal value) {
            addCriterion("RING_RATIO <", value, "ringRatio");
            return (Criteria) this;
        }

        public Criteria andRingRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RING_RATIO <=", value, "ringRatio");
            return (Criteria) this;
        }

        public Criteria andRingRatioIn(List<BigDecimal> values) {
            addCriterion("RING_RATIO in", values, "ringRatio");
            return (Criteria) this;
        }

        public Criteria andRingRatioNotIn(List<BigDecimal> values) {
            addCriterion("RING_RATIO not in", values, "ringRatio");
            return (Criteria) this;
        }

        public Criteria andRingRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RING_RATIO between", value1, value2, "ringRatio");
            return (Criteria) this;
        }

        public Criteria andRingRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RING_RATIO not between", value1, value2, "ringRatio");
            return (Criteria) this;
        }

        public Criteria andYearOnIsNull() {
            addCriterion("YEAR_ON is null");
            return (Criteria) this;
        }

        public Criteria andYearOnIsNotNull() {
            addCriterion("YEAR_ON is not null");
            return (Criteria) this;
        }

        public Criteria andYearOnEqualTo(BigDecimal value) {
            addCriterion("YEAR_ON =", value, "yearOn");
            return (Criteria) this;
        }

        public Criteria andYearOnNotEqualTo(BigDecimal value) {
            addCriterion("YEAR_ON <>", value, "yearOn");
            return (Criteria) this;
        }

        public Criteria andYearOnGreaterThan(BigDecimal value) {
            addCriterion("YEAR_ON >", value, "yearOn");
            return (Criteria) this;
        }

        public Criteria andYearOnGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("YEAR_ON >=", value, "yearOn");
            return (Criteria) this;
        }

        public Criteria andYearOnLessThan(BigDecimal value) {
            addCriterion("YEAR_ON <", value, "yearOn");
            return (Criteria) this;
        }

        public Criteria andYearOnLessThanOrEqualTo(BigDecimal value) {
            addCriterion("YEAR_ON <=", value, "yearOn");
            return (Criteria) this;
        }

        public Criteria andYearOnIn(List<BigDecimal> values) {
            addCriterion("YEAR_ON in", values, "yearOn");
            return (Criteria) this;
        }

        public Criteria andYearOnNotIn(List<BigDecimal> values) {
            addCriterion("YEAR_ON not in", values, "yearOn");
            return (Criteria) this;
        }

        public Criteria andYearOnBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YEAR_ON between", value1, value2, "yearOn");
            return (Criteria) this;
        }

        public Criteria andYearOnNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YEAR_ON not between", value1, value2, "yearOn");
            return (Criteria) this;
        }
    }

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