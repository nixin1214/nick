package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceProfitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFinanceProfitExample() {
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

        public Criteria andFprojectIsNull() {
            addCriterion("FPROJECT is null");
            return (Criteria) this;
        }

        public Criteria andFprojectIsNotNull() {
            addCriterion("FPROJECT is not null");
            return (Criteria) this;
        }

        public Criteria andFprojectEqualTo(String value) {
            addCriterion("FPROJECT =", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectNotEqualTo(String value) {
            addCriterion("FPROJECT <>", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectGreaterThan(String value) {
            addCriterion("FPROJECT >", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectGreaterThanOrEqualTo(String value) {
            addCriterion("FPROJECT >=", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectLessThan(String value) {
            addCriterion("FPROJECT <", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectLessThanOrEqualTo(String value) {
            addCriterion("FPROJECT <=", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectLike(String value) {
            addCriterion("FPROJECT like", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectNotLike(String value) {
            addCriterion("FPROJECT not like", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectIn(List<String> values) {
            addCriterion("FPROJECT in", values, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectNotIn(List<String> values) {
            addCriterion("FPROJECT not in", values, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectBetween(String value1, String value2) {
            addCriterion("FPROJECT between", value1, value2, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectNotBetween(String value1, String value2) {
            addCriterion("FPROJECT not between", value1, value2, "fproject");
            return (Criteria) this;
        }

        public Criteria andFrowNumIsNull() {
            addCriterion("FROW_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFrowNumIsNotNull() {
            addCriterion("FROW_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFrowNumEqualTo(Long value) {
            addCriterion("FROW_NUM =", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotEqualTo(Long value) {
            addCriterion("FROW_NUM <>", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumGreaterThan(Long value) {
            addCriterion("FROW_NUM >", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumGreaterThanOrEqualTo(Long value) {
            addCriterion("FROW_NUM >=", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumLessThan(Long value) {
            addCriterion("FROW_NUM <", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumLessThanOrEqualTo(Long value) {
            addCriterion("FROW_NUM <=", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumIn(List<Long> values) {
            addCriterion("FROW_NUM in", values, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotIn(List<Long> values) {
            addCriterion("FROW_NUM not in", values, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumBetween(Long value1, Long value2) {
            addCriterion("FROW_NUM between", value1, value2, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotBetween(Long value1, Long value2) {
            addCriterion("FROW_NUM not between", value1, value2, "frowNum");
            return (Criteria) this;
        }

        public Criteria andLastYearActualIsNull() {
            addCriterion("LAST_YEAR_ACTUAL is null");
            return (Criteria) this;
        }

        public Criteria andLastYearActualIsNotNull() {
            addCriterion("LAST_YEAR_ACTUAL is not null");
            return (Criteria) this;
        }

        public Criteria andLastYearActualEqualTo(BigDecimal value) {
            addCriterion("LAST_YEAR_ACTUAL =", value, "lastYearActual");
            return (Criteria) this;
        }

        public Criteria andLastYearActualNotEqualTo(BigDecimal value) {
            addCriterion("LAST_YEAR_ACTUAL <>", value, "lastYearActual");
            return (Criteria) this;
        }

        public Criteria andLastYearActualGreaterThan(BigDecimal value) {
            addCriterion("LAST_YEAR_ACTUAL >", value, "lastYearActual");
            return (Criteria) this;
        }

        public Criteria andLastYearActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LAST_YEAR_ACTUAL >=", value, "lastYearActual");
            return (Criteria) this;
        }

        public Criteria andLastYearActualLessThan(BigDecimal value) {
            addCriterion("LAST_YEAR_ACTUAL <", value, "lastYearActual");
            return (Criteria) this;
        }

        public Criteria andLastYearActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LAST_YEAR_ACTUAL <=", value, "lastYearActual");
            return (Criteria) this;
        }

        public Criteria andLastYearActualIn(List<BigDecimal> values) {
            addCriterion("LAST_YEAR_ACTUAL in", values, "lastYearActual");
            return (Criteria) this;
        }

        public Criteria andLastYearActualNotIn(List<BigDecimal> values) {
            addCriterion("LAST_YEAR_ACTUAL not in", values, "lastYearActual");
            return (Criteria) this;
        }

        public Criteria andLastYearActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LAST_YEAR_ACTUAL between", value1, value2, "lastYearActual");
            return (Criteria) this;
        }

        public Criteria andLastYearActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LAST_YEAR_ACTUAL not between", value1, value2, "lastYearActual");
            return (Criteria) this;
        }

        public Criteria andLastYearTotalIsNull() {
            addCriterion("LAST_YEAR_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andLastYearTotalIsNotNull() {
            addCriterion("LAST_YEAR_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andLastYearTotalEqualTo(BigDecimal value) {
            addCriterion("LAST_YEAR_TOTAL =", value, "lastYearTotal");
            return (Criteria) this;
        }

        public Criteria andLastYearTotalNotEqualTo(BigDecimal value) {
            addCriterion("LAST_YEAR_TOTAL <>", value, "lastYearTotal");
            return (Criteria) this;
        }

        public Criteria andLastYearTotalGreaterThan(BigDecimal value) {
            addCriterion("LAST_YEAR_TOTAL >", value, "lastYearTotal");
            return (Criteria) this;
        }

        public Criteria andLastYearTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LAST_YEAR_TOTAL >=", value, "lastYearTotal");
            return (Criteria) this;
        }

        public Criteria andLastYearTotalLessThan(BigDecimal value) {
            addCriterion("LAST_YEAR_TOTAL <", value, "lastYearTotal");
            return (Criteria) this;
        }

        public Criteria andLastYearTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LAST_YEAR_TOTAL <=", value, "lastYearTotal");
            return (Criteria) this;
        }

        public Criteria andLastYearTotalIn(List<BigDecimal> values) {
            addCriterion("LAST_YEAR_TOTAL in", values, "lastYearTotal");
            return (Criteria) this;
        }

        public Criteria andLastYearTotalNotIn(List<BigDecimal> values) {
            addCriterion("LAST_YEAR_TOTAL not in", values, "lastYearTotal");
            return (Criteria) this;
        }

        public Criteria andLastYearTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LAST_YEAR_TOTAL between", value1, value2, "lastYearTotal");
            return (Criteria) this;
        }

        public Criteria andLastYearTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LAST_YEAR_TOTAL not between", value1, value2, "lastYearTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetIsNull() {
            addCriterion("THIS_YEAR_BUDGET is null");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetIsNotNull() {
            addCriterion("THIS_YEAR_BUDGET is not null");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_BUDGET =", value, "thisYearBudget");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetNotEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_BUDGET <>", value, "thisYearBudget");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetGreaterThan(BigDecimal value) {
            addCriterion("THIS_YEAR_BUDGET >", value, "thisYearBudget");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_BUDGET >=", value, "thisYearBudget");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetLessThan(BigDecimal value) {
            addCriterion("THIS_YEAR_BUDGET <", value, "thisYearBudget");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_BUDGET <=", value, "thisYearBudget");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetIn(List<BigDecimal> values) {
            addCriterion("THIS_YEAR_BUDGET in", values, "thisYearBudget");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetNotIn(List<BigDecimal> values) {
            addCriterion("THIS_YEAR_BUDGET not in", values, "thisYearBudget");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_YEAR_BUDGET between", value1, value2, "thisYearBudget");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_YEAR_BUDGET not between", value1, value2, "thisYearBudget");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetTotalIsNull() {
            addCriterion("THIS_YEAR_BUDGET_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetTotalIsNotNull() {
            addCriterion("THIS_YEAR_BUDGET_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetTotalEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_BUDGET_TOTAL =", value, "thisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetTotalNotEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_BUDGET_TOTAL <>", value, "thisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetTotalGreaterThan(BigDecimal value) {
            addCriterion("THIS_YEAR_BUDGET_TOTAL >", value, "thisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_BUDGET_TOTAL >=", value, "thisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetTotalLessThan(BigDecimal value) {
            addCriterion("THIS_YEAR_BUDGET_TOTAL <", value, "thisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_BUDGET_TOTAL <=", value, "thisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetTotalIn(List<BigDecimal> values) {
            addCriterion("THIS_YEAR_BUDGET_TOTAL in", values, "thisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetTotalNotIn(List<BigDecimal> values) {
            addCriterion("THIS_YEAR_BUDGET_TOTAL not in", values, "thisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_YEAR_BUDGET_TOTAL between", value1, value2, "thisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearBudgetTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_YEAR_BUDGET_TOTAL not between", value1, value2, "thisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearActualIsNull() {
            addCriterion("THIS_YEAR_ACTUAL is null");
            return (Criteria) this;
        }

        public Criteria andThisYearActualIsNotNull() {
            addCriterion("THIS_YEAR_ACTUAL is not null");
            return (Criteria) this;
        }

        public Criteria andThisYearActualEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_ACTUAL =", value, "thisYearActual");
            return (Criteria) this;
        }

        public Criteria andThisYearActualNotEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_ACTUAL <>", value, "thisYearActual");
            return (Criteria) this;
        }

        public Criteria andThisYearActualGreaterThan(BigDecimal value) {
            addCriterion("THIS_YEAR_ACTUAL >", value, "thisYearActual");
            return (Criteria) this;
        }

        public Criteria andThisYearActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_ACTUAL >=", value, "thisYearActual");
            return (Criteria) this;
        }

        public Criteria andThisYearActualLessThan(BigDecimal value) {
            addCriterion("THIS_YEAR_ACTUAL <", value, "thisYearActual");
            return (Criteria) this;
        }

        public Criteria andThisYearActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_ACTUAL <=", value, "thisYearActual");
            return (Criteria) this;
        }

        public Criteria andThisYearActualIn(List<BigDecimal> values) {
            addCriterion("THIS_YEAR_ACTUAL in", values, "thisYearActual");
            return (Criteria) this;
        }

        public Criteria andThisYearActualNotIn(List<BigDecimal> values) {
            addCriterion("THIS_YEAR_ACTUAL not in", values, "thisYearActual");
            return (Criteria) this;
        }

        public Criteria andThisYearActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_YEAR_ACTUAL between", value1, value2, "thisYearActual");
            return (Criteria) this;
        }

        public Criteria andThisYearActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_YEAR_ACTUAL not between", value1, value2, "thisYearActual");
            return (Criteria) this;
        }

        public Criteria andThisYearActualTotalIsNull() {
            addCriterion("THIS_YEAR_ACTUAL_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andThisYearActualTotalIsNotNull() {
            addCriterion("THIS_YEAR_ACTUAL_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andThisYearActualTotalEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_ACTUAL_TOTAL =", value, "thisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearActualTotalNotEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_ACTUAL_TOTAL <>", value, "thisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearActualTotalGreaterThan(BigDecimal value) {
            addCriterion("THIS_YEAR_ACTUAL_TOTAL >", value, "thisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearActualTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_ACTUAL_TOTAL >=", value, "thisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearActualTotalLessThan(BigDecimal value) {
            addCriterion("THIS_YEAR_ACTUAL_TOTAL <", value, "thisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearActualTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("THIS_YEAR_ACTUAL_TOTAL <=", value, "thisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearActualTotalIn(List<BigDecimal> values) {
            addCriterion("THIS_YEAR_ACTUAL_TOTAL in", values, "thisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearActualTotalNotIn(List<BigDecimal> values) {
            addCriterion("THIS_YEAR_ACTUAL_TOTAL not in", values, "thisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearActualTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_YEAR_ACTUAL_TOTAL between", value1, value2, "thisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andThisYearActualTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("THIS_YEAR_ACTUAL_TOTAL not between", value1, value2, "thisYearActualTotal");
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

        public Criteria andFheadIdIn(List<Long> values) {
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

        public Criteria andFstrongIsNull() {
            addCriterion("FSTRONG is null");
            return (Criteria) this;
        }

        public Criteria andFstrongIsNotNull() {
            addCriterion("FSTRONG is not null");
            return (Criteria) this;
        }

        public Criteria andFstrongEqualTo(Long value) {
            addCriterion("FSTRONG =", value, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongNotEqualTo(Long value) {
            addCriterion("FSTRONG <>", value, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongGreaterThan(Long value) {
            addCriterion("FSTRONG >", value, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongGreaterThanOrEqualTo(Long value) {
            addCriterion("FSTRONG >=", value, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongLessThan(Long value) {
            addCriterion("FSTRONG <", value, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongLessThanOrEqualTo(Long value) {
            addCriterion("FSTRONG <=", value, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongIn(List<Long> values) {
            addCriterion("FSTRONG in", values, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongNotIn(List<Long> values) {
            addCriterion("FSTRONG not in", values, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongBetween(Long value1, Long value2) {
            addCriterion("FSTRONG between", value1, value2, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongNotBetween(Long value1, Long value2) {
            addCriterion("FSTRONG not between", value1, value2, "fstrong");
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