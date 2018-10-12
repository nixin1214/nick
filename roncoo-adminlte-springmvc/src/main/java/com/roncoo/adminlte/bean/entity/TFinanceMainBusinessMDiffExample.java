package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceMainBusinessMDiffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceMainBusinessMDiffExample() {
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

        public Criteria andFrowNumIsNull() {
            addCriterion("FROW_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFrowNumIsNotNull() {
            addCriterion("FROW_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFrowNumEqualTo(String value) {
            addCriterion("FROW_NUM =", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotEqualTo(String value) {
            addCriterion("FROW_NUM <>", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumGreaterThan(String value) {
            addCriterion("FROW_NUM >", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumGreaterThanOrEqualTo(String value) {
            addCriterion("FROW_NUM >=", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumLessThan(String value) {
            addCriterion("FROW_NUM <", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumLessThanOrEqualTo(String value) {
            addCriterion("FROW_NUM <=", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumLike(String value) {
            addCriterion("FROW_NUM like", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotLike(String value) {
            addCriterion("FROW_NUM not like", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumIn(List<String> values) {
            addCriterion("FROW_NUM in", values, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotIn(List<String> values) {
            addCriterion("FROW_NUM not in", values, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumBetween(String value1, String value2) {
            addCriterion("FROW_NUM between", value1, value2, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotBetween(String value1, String value2) {
            addCriterion("FROW_NUM not between", value1, value2, "frowNum");
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

        public Criteria andSaleBudgetIsNull() {
            addCriterion("SALE_BUDGET is null");
            return (Criteria) this;
        }

        public Criteria andSaleBudgetIsNotNull() {
            addCriterion("SALE_BUDGET is not null");
            return (Criteria) this;
        }

        public Criteria andSaleBudgetEqualTo(BigDecimal value) {
            addCriterion("SALE_BUDGET =", value, "saleBudget");
            return (Criteria) this;
        }

        public Criteria andSaleBudgetNotEqualTo(BigDecimal value) {
            addCriterion("SALE_BUDGET <>", value, "saleBudget");
            return (Criteria) this;
        }

        public Criteria andSaleBudgetGreaterThan(BigDecimal value) {
            addCriterion("SALE_BUDGET >", value, "saleBudget");
            return (Criteria) this;
        }

        public Criteria andSaleBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_BUDGET >=", value, "saleBudget");
            return (Criteria) this;
        }

        public Criteria andSaleBudgetLessThan(BigDecimal value) {
            addCriterion("SALE_BUDGET <", value, "saleBudget");
            return (Criteria) this;
        }

        public Criteria andSaleBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_BUDGET <=", value, "saleBudget");
            return (Criteria) this;
        }

        public Criteria andSaleBudgetIn(List<BigDecimal> values) {
            addCriterion("SALE_BUDGET in", values, "saleBudget");
            return (Criteria) this;
        }

        public Criteria andSaleBudgetNotIn(List<BigDecimal> values) {
            addCriterion("SALE_BUDGET not in", values, "saleBudget");
            return (Criteria) this;
        }

        public Criteria andSaleBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_BUDGET between", value1, value2, "saleBudget");
            return (Criteria) this;
        }

        public Criteria andSaleBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_BUDGET not between", value1, value2, "saleBudget");
            return (Criteria) this;
        }

        public Criteria andSaleActualIsNull() {
            addCriterion("SALE_ACTUAL is null");
            return (Criteria) this;
        }

        public Criteria andSaleActualIsNotNull() {
            addCriterion("SALE_ACTUAL is not null");
            return (Criteria) this;
        }

        public Criteria andSaleActualEqualTo(BigDecimal value) {
            addCriterion("SALE_ACTUAL =", value, "saleActual");
            return (Criteria) this;
        }

        public Criteria andSaleActualNotEqualTo(BigDecimal value) {
            addCriterion("SALE_ACTUAL <>", value, "saleActual");
            return (Criteria) this;
        }

        public Criteria andSaleActualGreaterThan(BigDecimal value) {
            addCriterion("SALE_ACTUAL >", value, "saleActual");
            return (Criteria) this;
        }

        public Criteria andSaleActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_ACTUAL >=", value, "saleActual");
            return (Criteria) this;
        }

        public Criteria andSaleActualLessThan(BigDecimal value) {
            addCriterion("SALE_ACTUAL <", value, "saleActual");
            return (Criteria) this;
        }

        public Criteria andSaleActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_ACTUAL <=", value, "saleActual");
            return (Criteria) this;
        }

        public Criteria andSaleActualIn(List<BigDecimal> values) {
            addCriterion("SALE_ACTUAL in", values, "saleActual");
            return (Criteria) this;
        }

        public Criteria andSaleActualNotIn(List<BigDecimal> values) {
            addCriterion("SALE_ACTUAL not in", values, "saleActual");
            return (Criteria) this;
        }

        public Criteria andSaleActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_ACTUAL between", value1, value2, "saleActual");
            return (Criteria) this;
        }

        public Criteria andSaleActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_ACTUAL not between", value1, value2, "saleActual");
            return (Criteria) this;
        }

        public Criteria andIncomeBudgetIsNull() {
            addCriterion("INCOME_BUDGET is null");
            return (Criteria) this;
        }

        public Criteria andIncomeBudgetIsNotNull() {
            addCriterion("INCOME_BUDGET is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeBudgetEqualTo(BigDecimal value) {
            addCriterion("INCOME_BUDGET =", value, "incomeBudget");
            return (Criteria) this;
        }

        public Criteria andIncomeBudgetNotEqualTo(BigDecimal value) {
            addCriterion("INCOME_BUDGET <>", value, "incomeBudget");
            return (Criteria) this;
        }

        public Criteria andIncomeBudgetGreaterThan(BigDecimal value) {
            addCriterion("INCOME_BUDGET >", value, "incomeBudget");
            return (Criteria) this;
        }

        public Criteria andIncomeBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INCOME_BUDGET >=", value, "incomeBudget");
            return (Criteria) this;
        }

        public Criteria andIncomeBudgetLessThan(BigDecimal value) {
            addCriterion("INCOME_BUDGET <", value, "incomeBudget");
            return (Criteria) this;
        }

        public Criteria andIncomeBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INCOME_BUDGET <=", value, "incomeBudget");
            return (Criteria) this;
        }

        public Criteria andIncomeBudgetIn(List<BigDecimal> values) {
            addCriterion("INCOME_BUDGET in", values, "incomeBudget");
            return (Criteria) this;
        }

        public Criteria andIncomeBudgetNotIn(List<BigDecimal> values) {
            addCriterion("INCOME_BUDGET not in", values, "incomeBudget");
            return (Criteria) this;
        }

        public Criteria andIncomeBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INCOME_BUDGET between", value1, value2, "incomeBudget");
            return (Criteria) this;
        }

        public Criteria andIncomeBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INCOME_BUDGET not between", value1, value2, "incomeBudget");
            return (Criteria) this;
        }

        public Criteria andIncomeActualIsNull() {
            addCriterion("INCOME_ACTUAL is null");
            return (Criteria) this;
        }

        public Criteria andIncomeActualIsNotNull() {
            addCriterion("INCOME_ACTUAL is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeActualEqualTo(BigDecimal value) {
            addCriterion("INCOME_ACTUAL =", value, "incomeActual");
            return (Criteria) this;
        }

        public Criteria andIncomeActualNotEqualTo(BigDecimal value) {
            addCriterion("INCOME_ACTUAL <>", value, "incomeActual");
            return (Criteria) this;
        }

        public Criteria andIncomeActualGreaterThan(BigDecimal value) {
            addCriterion("INCOME_ACTUAL >", value, "incomeActual");
            return (Criteria) this;
        }

        public Criteria andIncomeActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INCOME_ACTUAL >=", value, "incomeActual");
            return (Criteria) this;
        }

        public Criteria andIncomeActualLessThan(BigDecimal value) {
            addCriterion("INCOME_ACTUAL <", value, "incomeActual");
            return (Criteria) this;
        }

        public Criteria andIncomeActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INCOME_ACTUAL <=", value, "incomeActual");
            return (Criteria) this;
        }

        public Criteria andIncomeActualIn(List<BigDecimal> values) {
            addCriterion("INCOME_ACTUAL in", values, "incomeActual");
            return (Criteria) this;
        }

        public Criteria andIncomeActualNotIn(List<BigDecimal> values) {
            addCriterion("INCOME_ACTUAL not in", values, "incomeActual");
            return (Criteria) this;
        }

        public Criteria andIncomeActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INCOME_ACTUAL between", value1, value2, "incomeActual");
            return (Criteria) this;
        }

        public Criteria andIncomeActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INCOME_ACTUAL not between", value1, value2, "incomeActual");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalIsNull() {
            addCriterion("INCOME_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalIsNotNull() {
            addCriterion("INCOME_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalEqualTo(BigDecimal value) {
            addCriterion("INCOME_TOTAL =", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalNotEqualTo(BigDecimal value) {
            addCriterion("INCOME_TOTAL <>", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalGreaterThan(BigDecimal value) {
            addCriterion("INCOME_TOTAL >", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INCOME_TOTAL >=", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalLessThan(BigDecimal value) {
            addCriterion("INCOME_TOTAL <", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INCOME_TOTAL <=", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalIn(List<BigDecimal> values) {
            addCriterion("INCOME_TOTAL in", values, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalNotIn(List<BigDecimal> values) {
            addCriterion("INCOME_TOTAL not in", values, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INCOME_TOTAL between", value1, value2, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INCOME_TOTAL not between", value1, value2, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andCostBudgetIsNull() {
            addCriterion("COST_BUDGET is null");
            return (Criteria) this;
        }

        public Criteria andCostBudgetIsNotNull() {
            addCriterion("COST_BUDGET is not null");
            return (Criteria) this;
        }

        public Criteria andCostBudgetEqualTo(BigDecimal value) {
            addCriterion("COST_BUDGET =", value, "costBudget");
            return (Criteria) this;
        }

        public Criteria andCostBudgetNotEqualTo(BigDecimal value) {
            addCriterion("COST_BUDGET <>", value, "costBudget");
            return (Criteria) this;
        }

        public Criteria andCostBudgetGreaterThan(BigDecimal value) {
            addCriterion("COST_BUDGET >", value, "costBudget");
            return (Criteria) this;
        }

        public Criteria andCostBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_BUDGET >=", value, "costBudget");
            return (Criteria) this;
        }

        public Criteria andCostBudgetLessThan(BigDecimal value) {
            addCriterion("COST_BUDGET <", value, "costBudget");
            return (Criteria) this;
        }

        public Criteria andCostBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_BUDGET <=", value, "costBudget");
            return (Criteria) this;
        }

        public Criteria andCostBudgetIn(List<BigDecimal> values) {
            addCriterion("COST_BUDGET in", values, "costBudget");
            return (Criteria) this;
        }

        public Criteria andCostBudgetNotIn(List<BigDecimal> values) {
            addCriterion("COST_BUDGET not in", values, "costBudget");
            return (Criteria) this;
        }

        public Criteria andCostBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_BUDGET between", value1, value2, "costBudget");
            return (Criteria) this;
        }

        public Criteria andCostBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_BUDGET not between", value1, value2, "costBudget");
            return (Criteria) this;
        }

        public Criteria andCostActualIsNull() {
            addCriterion("COST_ACTUAL is null");
            return (Criteria) this;
        }

        public Criteria andCostActualIsNotNull() {
            addCriterion("COST_ACTUAL is not null");
            return (Criteria) this;
        }

        public Criteria andCostActualEqualTo(BigDecimal value) {
            addCriterion("COST_ACTUAL =", value, "costActual");
            return (Criteria) this;
        }

        public Criteria andCostActualNotEqualTo(BigDecimal value) {
            addCriterion("COST_ACTUAL <>", value, "costActual");
            return (Criteria) this;
        }

        public Criteria andCostActualGreaterThan(BigDecimal value) {
            addCriterion("COST_ACTUAL >", value, "costActual");
            return (Criteria) this;
        }

        public Criteria andCostActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_ACTUAL >=", value, "costActual");
            return (Criteria) this;
        }

        public Criteria andCostActualLessThan(BigDecimal value) {
            addCriterion("COST_ACTUAL <", value, "costActual");
            return (Criteria) this;
        }

        public Criteria andCostActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_ACTUAL <=", value, "costActual");
            return (Criteria) this;
        }

        public Criteria andCostActualIn(List<BigDecimal> values) {
            addCriterion("COST_ACTUAL in", values, "costActual");
            return (Criteria) this;
        }

        public Criteria andCostActualNotIn(List<BigDecimal> values) {
            addCriterion("COST_ACTUAL not in", values, "costActual");
            return (Criteria) this;
        }

        public Criteria andCostActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_ACTUAL between", value1, value2, "costActual");
            return (Criteria) this;
        }

        public Criteria andCostActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_ACTUAL not between", value1, value2, "costActual");
            return (Criteria) this;
        }

        public Criteria andCostTotalIsNull() {
            addCriterion("COST_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andCostTotalIsNotNull() {
            addCriterion("COST_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andCostTotalEqualTo(BigDecimal value) {
            addCriterion("COST_TOTAL =", value, "costTotal");
            return (Criteria) this;
        }

        public Criteria andCostTotalNotEqualTo(BigDecimal value) {
            addCriterion("COST_TOTAL <>", value, "costTotal");
            return (Criteria) this;
        }

        public Criteria andCostTotalGreaterThan(BigDecimal value) {
            addCriterion("COST_TOTAL >", value, "costTotal");
            return (Criteria) this;
        }

        public Criteria andCostTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_TOTAL >=", value, "costTotal");
            return (Criteria) this;
        }

        public Criteria andCostTotalLessThan(BigDecimal value) {
            addCriterion("COST_TOTAL <", value, "costTotal");
            return (Criteria) this;
        }

        public Criteria andCostTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_TOTAL <=", value, "costTotal");
            return (Criteria) this;
        }

        public Criteria andCostTotalIn(List<BigDecimal> values) {
            addCriterion("COST_TOTAL in", values, "costTotal");
            return (Criteria) this;
        }

        public Criteria andCostTotalNotIn(List<BigDecimal> values) {
            addCriterion("COST_TOTAL not in", values, "costTotal");
            return (Criteria) this;
        }

        public Criteria andCostTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_TOTAL between", value1, value2, "costTotal");
            return (Criteria) this;
        }

        public Criteria andCostTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_TOTAL not between", value1, value2, "costTotal");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetIsNull() {
            addCriterion("SALE_PROFIT_BUDGET is null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetIsNotNull() {
            addCriterion("SALE_PROFIT_BUDGET is not null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_BUDGET =", value, "saleProfitBudget");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetNotEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_BUDGET <>", value, "saleProfitBudget");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetGreaterThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_BUDGET >", value, "saleProfitBudget");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_BUDGET >=", value, "saleProfitBudget");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetLessThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_BUDGET <", value, "saleProfitBudget");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_BUDGET <=", value, "saleProfitBudget");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_BUDGET in", values, "saleProfitBudget");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetNotIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_BUDGET not in", values, "saleProfitBudget");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_BUDGET between", value1, value2, "saleProfitBudget");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_BUDGET not between", value1, value2, "saleProfitBudget");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualIsNull() {
            addCriterion("SALE_PROFIT_ACTUAL is null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualIsNotNull() {
            addCriterion("SALE_PROFIT_ACTUAL is not null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_ACTUAL =", value, "saleProfitActual");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualNotEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_ACTUAL <>", value, "saleProfitActual");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualGreaterThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_ACTUAL >", value, "saleProfitActual");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_ACTUAL >=", value, "saleProfitActual");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualLessThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_ACTUAL <", value, "saleProfitActual");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_ACTUAL <=", value, "saleProfitActual");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_ACTUAL in", values, "saleProfitActual");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualNotIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_ACTUAL not in", values, "saleProfitActual");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_ACTUAL between", value1, value2, "saleProfitActual");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_ACTUAL not between", value1, value2, "saleProfitActual");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetRatioIsNull() {
            addCriterion("SALE_PROFIT_BUDGET_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetRatioIsNotNull() {
            addCriterion("SALE_PROFIT_BUDGET_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetRatioEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_BUDGET_RATIO =", value, "saleProfitBudgetRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetRatioNotEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_BUDGET_RATIO <>", value, "saleProfitBudgetRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetRatioGreaterThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_BUDGET_RATIO >", value, "saleProfitBudgetRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_BUDGET_RATIO >=", value, "saleProfitBudgetRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetRatioLessThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_BUDGET_RATIO <", value, "saleProfitBudgetRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_BUDGET_RATIO <=", value, "saleProfitBudgetRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetRatioIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_BUDGET_RATIO in", values, "saleProfitBudgetRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetRatioNotIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_BUDGET_RATIO not in", values, "saleProfitBudgetRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_BUDGET_RATIO between", value1, value2, "saleProfitBudgetRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitBudgetRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_BUDGET_RATIO not between", value1, value2, "saleProfitBudgetRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualRatioIsNull() {
            addCriterion("SALE_PROFIT_ACTUAL_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualRatioIsNotNull() {
            addCriterion("SALE_PROFIT_ACTUAL_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualRatioEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_ACTUAL_RATIO =", value, "saleProfitActualRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualRatioNotEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_ACTUAL_RATIO <>", value, "saleProfitActualRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualRatioGreaterThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_ACTUAL_RATIO >", value, "saleProfitActualRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_ACTUAL_RATIO >=", value, "saleProfitActualRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualRatioLessThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_ACTUAL_RATIO <", value, "saleProfitActualRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_ACTUAL_RATIO <=", value, "saleProfitActualRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualRatioIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_ACTUAL_RATIO in", values, "saleProfitActualRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualRatioNotIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_ACTUAL_RATIO not in", values, "saleProfitActualRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_ACTUAL_RATIO between", value1, value2, "saleProfitActualRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitActualRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_ACTUAL_RATIO not between", value1, value2, "saleProfitActualRatio");
            return (Criteria) this;
        }

        public Criteria andSaleTotalIsNull() {
            addCriterion("SALE_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andSaleTotalIsNotNull() {
            addCriterion("SALE_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andSaleTotalEqualTo(BigDecimal value) {
            addCriterion("SALE_TOTAL =", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalNotEqualTo(BigDecimal value) {
            addCriterion("SALE_TOTAL <>", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalGreaterThan(BigDecimal value) {
            addCriterion("SALE_TOTAL >", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_TOTAL >=", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalLessThan(BigDecimal value) {
            addCriterion("SALE_TOTAL <", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_TOTAL <=", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalIn(List<BigDecimal> values) {
            addCriterion("SALE_TOTAL in", values, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalNotIn(List<BigDecimal> values) {
            addCriterion("SALE_TOTAL not in", values, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_TOTAL between", value1, value2, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_TOTAL not between", value1, value2, "saleTotal");
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