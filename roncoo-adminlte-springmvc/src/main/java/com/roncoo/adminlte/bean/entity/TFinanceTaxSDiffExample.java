package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceTaxSDiffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceTaxSDiffExample() {
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

        public Criteria andFidEqualTo(Long value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Long value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Long value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Long value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Long value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Long value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Long> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Long> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Long value1, Long value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Long value1, Long value2) {
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

        public Criteria andFheadIdEqualTo(Long value) {
            addCriterion("FHEAD_ID =", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotEqualTo(Long value) {
            addCriterion("FHEAD_ID <>", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdGreaterThan(Long value) {
            addCriterion("FHEAD_ID >", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FHEAD_ID >=", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdLessThan(Long value) {
            addCriterion("FHEAD_ID <", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdLessThanOrEqualTo(Long value) {
            addCriterion("FHEAD_ID <=", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdIn(List<Long> values) {
            addCriterion("FHEAD_ID in", values, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotIn(List<Long> values) {
            addCriterion("FHEAD_ID not in", values, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdBetween(Long value1, Long value2) {
            addCriterion("FHEAD_ID between", value1, value2, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotBetween(Long value1, Long value2) {
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

        public Criteria andFprojectNameIsNull() {
            addCriterion("FPROJECT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFprojectNameIsNotNull() {
            addCriterion("FPROJECT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFprojectNameEqualTo(String value) {
            addCriterion("FPROJECT_NAME =", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameNotEqualTo(String value) {
            addCriterion("FPROJECT_NAME <>", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameGreaterThan(String value) {
            addCriterion("FPROJECT_NAME >", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameGreaterThanOrEqualTo(String value) {
            addCriterion("FPROJECT_NAME >=", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameLessThan(String value) {
            addCriterion("FPROJECT_NAME <", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameLessThanOrEqualTo(String value) {
            addCriterion("FPROJECT_NAME <=", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameLike(String value) {
            addCriterion("FPROJECT_NAME like", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameNotLike(String value) {
            addCriterion("FPROJECT_NAME not like", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameIn(List<String> values) {
            addCriterion("FPROJECT_NAME in", values, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameNotIn(List<String> values) {
            addCriterion("FPROJECT_NAME not in", values, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameBetween(String value1, String value2) {
            addCriterion("FPROJECT_NAME between", value1, value2, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameNotBetween(String value1, String value2) {
            addCriterion("FPROJECT_NAME not between", value1, value2, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidIsNull() {
            addCriterion("FBEGIN_PERIOD_UNPAID is null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidIsNotNull() {
            addCriterion("FBEGIN_PERIOD_UNPAID is not null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_UNPAID =", value, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidNotEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_UNPAID <>", value, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidGreaterThan(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_UNPAID >", value, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_UNPAID >=", value, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidLessThan(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_UNPAID <", value, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_UNPAID <=", value, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidIn(List<BigDecimal> values) {
            addCriterion("FBEGIN_PERIOD_UNPAID in", values, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidNotIn(List<BigDecimal> values) {
            addCriterion("FBEGIN_PERIOD_UNPAID not in", values, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FBEGIN_PERIOD_UNPAID between", value1, value2, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FBEGIN_PERIOD_UNPAID not between", value1, value2, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldIsNull() {
            addCriterion("FBEGIN_PERIOD_SHOULD is null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldIsNotNull() {
            addCriterion("FBEGIN_PERIOD_SHOULD is not null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_SHOULD =", value, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldNotEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_SHOULD <>", value, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldGreaterThan(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_SHOULD >", value, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_SHOULD >=", value, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldLessThan(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_SHOULD <", value, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_SHOULD <=", value, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldIn(List<BigDecimal> values) {
            addCriterion("FBEGIN_PERIOD_SHOULD in", values, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldNotIn(List<BigDecimal> values) {
            addCriterion("FBEGIN_PERIOD_SHOULD not in", values, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FBEGIN_PERIOD_SHOULD between", value1, value2, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FBEGIN_PERIOD_SHOULD not between", value1, value2, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyIsNull() {
            addCriterion("FBEGIN_PERIOD_ALREADY is null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyIsNotNull() {
            addCriterion("FBEGIN_PERIOD_ALREADY is not null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_ALREADY =", value, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyNotEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_ALREADY <>", value, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyGreaterThan(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_ALREADY >", value, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_ALREADY >=", value, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyLessThan(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_ALREADY <", value, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_ALREADY <=", value, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyIn(List<BigDecimal> values) {
            addCriterion("FBEGIN_PERIOD_ALREADY in", values, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyNotIn(List<BigDecimal> values) {
            addCriterion("FBEGIN_PERIOD_ALREADY not in", values, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FBEGIN_PERIOD_ALREADY between", value1, value2, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FBEGIN_PERIOD_ALREADY not between", value1, value2, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidIsNull() {
            addCriterion("FBEGIN_PERIOD_FINAL_UNPAID is null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidIsNotNull() {
            addCriterion("FBEGIN_PERIOD_FINAL_UNPAID is not null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_FINAL_UNPAID =", value, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidNotEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_FINAL_UNPAID <>", value, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidGreaterThan(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_FINAL_UNPAID >", value, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_FINAL_UNPAID >=", value, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidLessThan(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_FINAL_UNPAID <", value, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FBEGIN_PERIOD_FINAL_UNPAID <=", value, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidIn(List<BigDecimal> values) {
            addCriterion("FBEGIN_PERIOD_FINAL_UNPAID in", values, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidNotIn(List<BigDecimal> values) {
            addCriterion("FBEGIN_PERIOD_FINAL_UNPAID not in", values, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FBEGIN_PERIOD_FINAL_UNPAID between", value1, value2, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FBEGIN_PERIOD_FINAL_UNPAID not between", value1, value2, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidIsNull() {
            addCriterion("FTOTAL_PERIOD_UNPAID is null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidIsNotNull() {
            addCriterion("FTOTAL_PERIOD_UNPAID is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_UNPAID =", value, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidNotEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_UNPAID <>", value, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidGreaterThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_UNPAID >", value, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_UNPAID >=", value, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidLessThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_UNPAID <", value, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_UNPAID <=", value, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_UNPAID in", values, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidNotIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_UNPAID not in", values, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_UNPAID between", value1, value2, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_UNPAID not between", value1, value2, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldIsNull() {
            addCriterion("FTOTAL_PERIOD_SHOULD is null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldIsNotNull() {
            addCriterion("FTOTAL_PERIOD_SHOULD is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_SHOULD =", value, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldNotEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_SHOULD <>", value, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldGreaterThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_SHOULD >", value, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_SHOULD >=", value, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldLessThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_SHOULD <", value, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_SHOULD <=", value, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_SHOULD in", values, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldNotIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_SHOULD not in", values, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_SHOULD between", value1, value2, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_SHOULD not between", value1, value2, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyIsNull() {
            addCriterion("FTOTAL_PERIOD_ALREADY is null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyIsNotNull() {
            addCriterion("FTOTAL_PERIOD_ALREADY is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_ALREADY =", value, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyNotEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_ALREADY <>", value, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyGreaterThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_ALREADY >", value, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_ALREADY >=", value, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyLessThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_ALREADY <", value, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_ALREADY <=", value, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_ALREADY in", values, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyNotIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_ALREADY not in", values, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_ALREADY between", value1, value2, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_ALREADY not between", value1, value2, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidIsNull() {
            addCriterion("FTOTAL_PERIOD_FINAL_UNPAID is null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidIsNotNull() {
            addCriterion("FTOTAL_PERIOD_FINAL_UNPAID is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_FINAL_UNPAID =", value, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidNotEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_FINAL_UNPAID <>", value, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidGreaterThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_FINAL_UNPAID >", value, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_FINAL_UNPAID >=", value, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidLessThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_FINAL_UNPAID <", value, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_FINAL_UNPAID <=", value, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_FINAL_UNPAID in", values, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidNotIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_FINAL_UNPAID not in", values, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_FINAL_UNPAID between", value1, value2, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_FINAL_UNPAID not between", value1, value2, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFextend1IsNull() {
            addCriterion("FEXTEND1 is null");
            return (Criteria) this;
        }

        public Criteria andFextend1IsNotNull() {
            addCriterion("FEXTEND1 is not null");
            return (Criteria) this;
        }

        public Criteria andFextend1EqualTo(BigDecimal value) {
            addCriterion("FEXTEND1 =", value, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1NotEqualTo(BigDecimal value) {
            addCriterion("FEXTEND1 <>", value, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1GreaterThan(BigDecimal value) {
            addCriterion("FEXTEND1 >", value, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEXTEND1 >=", value, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1LessThan(BigDecimal value) {
            addCriterion("FEXTEND1 <", value, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEXTEND1 <=", value, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1In(List<BigDecimal> values) {
            addCriterion("FEXTEND1 in", values, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1NotIn(List<BigDecimal> values) {
            addCriterion("FEXTEND1 not in", values, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEXTEND1 between", value1, value2, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEXTEND1 not between", value1, value2, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend2IsNull() {
            addCriterion("FEXTEND2 is null");
            return (Criteria) this;
        }

        public Criteria andFextend2IsNotNull() {
            addCriterion("FEXTEND2 is not null");
            return (Criteria) this;
        }

        public Criteria andFextend2EqualTo(BigDecimal value) {
            addCriterion("FEXTEND2 =", value, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2NotEqualTo(BigDecimal value) {
            addCriterion("FEXTEND2 <>", value, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2GreaterThan(BigDecimal value) {
            addCriterion("FEXTEND2 >", value, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEXTEND2 >=", value, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2LessThan(BigDecimal value) {
            addCriterion("FEXTEND2 <", value, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEXTEND2 <=", value, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2In(List<BigDecimal> values) {
            addCriterion("FEXTEND2 in", values, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2NotIn(List<BigDecimal> values) {
            addCriterion("FEXTEND2 not in", values, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEXTEND2 between", value1, value2, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEXTEND2 not between", value1, value2, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend3IsNull() {
            addCriterion("FEXTEND3 is null");
            return (Criteria) this;
        }

        public Criteria andFextend3IsNotNull() {
            addCriterion("FEXTEND3 is not null");
            return (Criteria) this;
        }

        public Criteria andFextend3EqualTo(BigDecimal value) {
            addCriterion("FEXTEND3 =", value, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3NotEqualTo(BigDecimal value) {
            addCriterion("FEXTEND3 <>", value, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3GreaterThan(BigDecimal value) {
            addCriterion("FEXTEND3 >", value, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEXTEND3 >=", value, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3LessThan(BigDecimal value) {
            addCriterion("FEXTEND3 <", value, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEXTEND3 <=", value, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3In(List<BigDecimal> values) {
            addCriterion("FEXTEND3 in", values, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3NotIn(List<BigDecimal> values) {
            addCriterion("FEXTEND3 not in", values, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEXTEND3 between", value1, value2, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEXTEND3 not between", value1, value2, "fextend3");
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