package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceTaxStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceTaxStatisticsExample() {
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
            addCriterion("fid is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fid is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Long value) {
            addCriterion("fid =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Long value) {
            addCriterion("fid <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Long value) {
            addCriterion("fid >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Long value) {
            addCriterion("fid >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Long value) {
            addCriterion("fid <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Long value) {
            addCriterion("fid <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Long> values) {
            addCriterion("fid in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Long> values) {
            addCriterion("fid not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Long value1, Long value2) {
            addCriterion("fid between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Long value1, Long value2) {
            addCriterion("fid not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFheadIdIsNull() {
            addCriterion("fhead_id is null");
            return (Criteria) this;
        }

        public Criteria andFheadIdIsNotNull() {
            addCriterion("fhead_id is not null");
            return (Criteria) this;
        }

        public Criteria andFheadIdEqualTo(Long value) {
            addCriterion("fhead_id =", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotEqualTo(Long value) {
            addCriterion("fhead_id <>", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdGreaterThan(Long value) {
            addCriterion("fhead_id >", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fhead_id >=", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdLessThan(Long value) {
            addCriterion("fhead_id <", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdLessThanOrEqualTo(Long value) {
            addCriterion("fhead_id <=", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdIn(List<Long> values) {
            addCriterion("fhead_id in", values, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotIn(List<Long> values) {
            addCriterion("fhead_id not in", values, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdBetween(Long value1, Long value2) {
            addCriterion("fhead_id between", value1, value2, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotBetween(Long value1, Long value2) {
            addCriterion("fhead_id not between", value1, value2, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFrowIndexIsNull() {
            addCriterion("frow_index is null");
            return (Criteria) this;
        }

        public Criteria andFrowIndexIsNotNull() {
            addCriterion("frow_index is not null");
            return (Criteria) this;
        }

        public Criteria andFrowIndexEqualTo(Integer value) {
            addCriterion("frow_index =", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexNotEqualTo(Integer value) {
            addCriterion("frow_index <>", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexGreaterThan(Integer value) {
            addCriterion("frow_index >", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("frow_index >=", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexLessThan(Integer value) {
            addCriterion("frow_index <", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexLessThanOrEqualTo(Integer value) {
            addCriterion("frow_index <=", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexIn(List<Integer> values) {
            addCriterion("frow_index in", values, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexNotIn(List<Integer> values) {
            addCriterion("frow_index not in", values, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexBetween(Integer value1, Integer value2) {
            addCriterion("frow_index between", value1, value2, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("frow_index not between", value1, value2, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFprojectNameIsNull() {
            addCriterion("fproject_name is null");
            return (Criteria) this;
        }

        public Criteria andFprojectNameIsNotNull() {
            addCriterion("fproject_name is not null");
            return (Criteria) this;
        }

        public Criteria andFprojectNameEqualTo(String value) {
            addCriterion("fproject_name =", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameNotEqualTo(String value) {
            addCriterion("fproject_name <>", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameGreaterThan(String value) {
            addCriterion("fproject_name >", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameGreaterThanOrEqualTo(String value) {
            addCriterion("fproject_name >=", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameLessThan(String value) {
            addCriterion("fproject_name <", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameLessThanOrEqualTo(String value) {
            addCriterion("fproject_name <=", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameLike(String value) {
            addCriterion("fproject_name like", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameNotLike(String value) {
            addCriterion("fproject_name not like", value, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameIn(List<String> values) {
            addCriterion("fproject_name in", values, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameNotIn(List<String> values) {
            addCriterion("fproject_name not in", values, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameBetween(String value1, String value2) {
            addCriterion("fproject_name between", value1, value2, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFprojectNameNotBetween(String value1, String value2) {
            addCriterion("fproject_name not between", value1, value2, "fprojectName");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidIsNull() {
            addCriterion("fbegin_period_unpaid is null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidIsNotNull() {
            addCriterion("fbegin_period_unpaid is not null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_unpaid =", value, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidNotEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_unpaid <>", value, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidGreaterThan(BigDecimal value) {
            addCriterion("fbegin_period_unpaid >", value, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_unpaid >=", value, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidLessThan(BigDecimal value) {
            addCriterion("fbegin_period_unpaid <", value, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_unpaid <=", value, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidIn(List<BigDecimal> values) {
            addCriterion("fbegin_period_unpaid in", values, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidNotIn(List<BigDecimal> values) {
            addCriterion("fbegin_period_unpaid not in", values, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fbegin_period_unpaid between", value1, value2, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodUnpaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fbegin_period_unpaid not between", value1, value2, "fbeginPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldIsNull() {
            addCriterion("fbegin_period_should is null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldIsNotNull() {
            addCriterion("fbegin_period_should is not null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_should =", value, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldNotEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_should <>", value, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldGreaterThan(BigDecimal value) {
            addCriterion("fbegin_period_should >", value, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_should >=", value, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldLessThan(BigDecimal value) {
            addCriterion("fbegin_period_should <", value, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_should <=", value, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldIn(List<BigDecimal> values) {
            addCriterion("fbegin_period_should in", values, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldNotIn(List<BigDecimal> values) {
            addCriterion("fbegin_period_should not in", values, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fbegin_period_should between", value1, value2, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodShouldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fbegin_period_should not between", value1, value2, "fbeginPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyIsNull() {
            addCriterion("fbegin_period_already is null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyIsNotNull() {
            addCriterion("fbegin_period_already is not null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_already =", value, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyNotEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_already <>", value, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyGreaterThan(BigDecimal value) {
            addCriterion("fbegin_period_already >", value, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_already >=", value, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyLessThan(BigDecimal value) {
            addCriterion("fbegin_period_already <", value, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_already <=", value, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyIn(List<BigDecimal> values) {
            addCriterion("fbegin_period_already in", values, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyNotIn(List<BigDecimal> values) {
            addCriterion("fbegin_period_already not in", values, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fbegin_period_already between", value1, value2, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodAlreadyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fbegin_period_already not between", value1, value2, "fbeginPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidIsNull() {
            addCriterion("fbegin_period_final_unpaid is null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidIsNotNull() {
            addCriterion("fbegin_period_final_unpaid is not null");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_final_unpaid =", value, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidNotEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_final_unpaid <>", value, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidGreaterThan(BigDecimal value) {
            addCriterion("fbegin_period_final_unpaid >", value, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_final_unpaid >=", value, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidLessThan(BigDecimal value) {
            addCriterion("fbegin_period_final_unpaid <", value, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fbegin_period_final_unpaid <=", value, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidIn(List<BigDecimal> values) {
            addCriterion("fbegin_period_final_unpaid in", values, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidNotIn(List<BigDecimal> values) {
            addCriterion("fbegin_period_final_unpaid not in", values, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fbegin_period_final_unpaid between", value1, value2, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFbeginPeriodFinalUnpaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fbegin_period_final_unpaid not between", value1, value2, "fbeginPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidIsNull() {
            addCriterion("ftotal_period_unpaid is null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidIsNotNull() {
            addCriterion("ftotal_period_unpaid is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_unpaid =", value, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidNotEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_unpaid <>", value, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidGreaterThan(BigDecimal value) {
            addCriterion("ftotal_period_unpaid >", value, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_unpaid >=", value, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidLessThan(BigDecimal value) {
            addCriterion("ftotal_period_unpaid <", value, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_unpaid <=", value, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidIn(List<BigDecimal> values) {
            addCriterion("ftotal_period_unpaid in", values, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidNotIn(List<BigDecimal> values) {
            addCriterion("ftotal_period_unpaid not in", values, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_period_unpaid between", value1, value2, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodUnpaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_period_unpaid not between", value1, value2, "ftotalPeriodUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldIsNull() {
            addCriterion("ftotal_period_should is null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldIsNotNull() {
            addCriterion("ftotal_period_should is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_should =", value, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldNotEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_should <>", value, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldGreaterThan(BigDecimal value) {
            addCriterion("ftotal_period_should >", value, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_should >=", value, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldLessThan(BigDecimal value) {
            addCriterion("ftotal_period_should <", value, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_should <=", value, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldIn(List<BigDecimal> values) {
            addCriterion("ftotal_period_should in", values, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldNotIn(List<BigDecimal> values) {
            addCriterion("ftotal_period_should not in", values, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_period_should between", value1, value2, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodShouldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_period_should not between", value1, value2, "ftotalPeriodShould");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyIsNull() {
            addCriterion("ftotal_period_already is null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyIsNotNull() {
            addCriterion("ftotal_period_already is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_already =", value, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyNotEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_already <>", value, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyGreaterThan(BigDecimal value) {
            addCriterion("ftotal_period_already >", value, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_already >=", value, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyLessThan(BigDecimal value) {
            addCriterion("ftotal_period_already <", value, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_already <=", value, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyIn(List<BigDecimal> values) {
            addCriterion("ftotal_period_already in", values, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyNotIn(List<BigDecimal> values) {
            addCriterion("ftotal_period_already not in", values, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_period_already between", value1, value2, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAlreadyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_period_already not between", value1, value2, "ftotalPeriodAlready");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidIsNull() {
            addCriterion("ftotal_period_final_unpaid is null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidIsNotNull() {
            addCriterion("ftotal_period_final_unpaid is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_final_unpaid =", value, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidNotEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_final_unpaid <>", value, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidGreaterThan(BigDecimal value) {
            addCriterion("ftotal_period_final_unpaid >", value, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_final_unpaid >=", value, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidLessThan(BigDecimal value) {
            addCriterion("ftotal_period_final_unpaid <", value, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_period_final_unpaid <=", value, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidIn(List<BigDecimal> values) {
            addCriterion("ftotal_period_final_unpaid in", values, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidNotIn(List<BigDecimal> values) {
            addCriterion("ftotal_period_final_unpaid not in", values, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_period_final_unpaid between", value1, value2, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodFinalUnpaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_period_final_unpaid not between", value1, value2, "ftotalPeriodFinalUnpaid");
            return (Criteria) this;
        }

        public Criteria andFextend1IsNull() {
            addCriterion("fextend1 is null");
            return (Criteria) this;
        }

        public Criteria andFextend1IsNotNull() {
            addCriterion("fextend1 is not null");
            return (Criteria) this;
        }

        public Criteria andFextend1EqualTo(BigDecimal value) {
            addCriterion("fextend1 =", value, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1NotEqualTo(BigDecimal value) {
            addCriterion("fextend1 <>", value, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1GreaterThan(BigDecimal value) {
            addCriterion("fextend1 >", value, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fextend1 >=", value, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1LessThan(BigDecimal value) {
            addCriterion("fextend1 <", value, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("fextend1 <=", value, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1In(List<BigDecimal> values) {
            addCriterion("fextend1 in", values, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1NotIn(List<BigDecimal> values) {
            addCriterion("fextend1 not in", values, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("fextend1 between", value1, value2, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fextend1 not between", value1, value2, "fextend1");
            return (Criteria) this;
        }

        public Criteria andFextend2IsNull() {
            addCriterion("fextend2 is null");
            return (Criteria) this;
        }

        public Criteria andFextend2IsNotNull() {
            addCriterion("fextend2 is not null");
            return (Criteria) this;
        }

        public Criteria andFextend2EqualTo(BigDecimal value) {
            addCriterion("fextend2 =", value, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2NotEqualTo(BigDecimal value) {
            addCriterion("fextend2 <>", value, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2GreaterThan(BigDecimal value) {
            addCriterion("fextend2 >", value, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fextend2 >=", value, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2LessThan(BigDecimal value) {
            addCriterion("fextend2 <", value, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("fextend2 <=", value, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2In(List<BigDecimal> values) {
            addCriterion("fextend2 in", values, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2NotIn(List<BigDecimal> values) {
            addCriterion("fextend2 not in", values, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("fextend2 between", value1, value2, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fextend2 not between", value1, value2, "fextend2");
            return (Criteria) this;
        }

        public Criteria andFextend3IsNull() {
            addCriterion("fextend3 is null");
            return (Criteria) this;
        }

        public Criteria andFextend3IsNotNull() {
            addCriterion("fextend3 is not null");
            return (Criteria) this;
        }

        public Criteria andFextend3EqualTo(BigDecimal value) {
            addCriterion("fextend3 =", value, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3NotEqualTo(BigDecimal value) {
            addCriterion("fextend3 <>", value, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3GreaterThan(BigDecimal value) {
            addCriterion("fextend3 >", value, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fextend3 >=", value, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3LessThan(BigDecimal value) {
            addCriterion("fextend3 <", value, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("fextend3 <=", value, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3In(List<BigDecimal> values) {
            addCriterion("fextend3 in", values, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3NotIn(List<BigDecimal> values) {
            addCriterion("fextend3 not in", values, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("fextend3 between", value1, value2, "fextend3");
            return (Criteria) this;
        }

        public Criteria andFextend3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fextend3 not between", value1, value2, "fextend3");
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