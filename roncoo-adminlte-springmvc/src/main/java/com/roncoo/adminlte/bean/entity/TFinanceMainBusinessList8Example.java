package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceMainBusinessList8Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceMainBusinessList8Example() {
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

        public Criteria andBudgetProportionIsNull() {
            addCriterion("BUDGET_PROPORTION is null");
            return (Criteria) this;
        }

        public Criteria andBudgetProportionIsNotNull() {
            addCriterion("BUDGET_PROPORTION is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetProportionEqualTo(BigDecimal value) {
            addCriterion("BUDGET_PROPORTION =", value, "budgetProportion");
            return (Criteria) this;
        }

        public Criteria andBudgetProportionNotEqualTo(BigDecimal value) {
            addCriterion("BUDGET_PROPORTION <>", value, "budgetProportion");
            return (Criteria) this;
        }

        public Criteria andBudgetProportionGreaterThan(BigDecimal value) {
            addCriterion("BUDGET_PROPORTION >", value, "budgetProportion");
            return (Criteria) this;
        }

        public Criteria andBudgetProportionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_PROPORTION >=", value, "budgetProportion");
            return (Criteria) this;
        }

        public Criteria andBudgetProportionLessThan(BigDecimal value) {
            addCriterion("BUDGET_PROPORTION <", value, "budgetProportion");
            return (Criteria) this;
        }

        public Criteria andBudgetProportionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_PROPORTION <=", value, "budgetProportion");
            return (Criteria) this;
        }

        public Criteria andBudgetProportionIn(List<BigDecimal> values) {
            addCriterion("BUDGET_PROPORTION in", values, "budgetProportion");
            return (Criteria) this;
        }

        public Criteria andBudgetProportionNotIn(List<BigDecimal> values) {
            addCriterion("BUDGET_PROPORTION not in", values, "budgetProportion");
            return (Criteria) this;
        }

        public Criteria andBudgetProportionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_PROPORTION between", value1, value2, "budgetProportion");
            return (Criteria) this;
        }

        public Criteria andBudgetProportionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_PROPORTION not between", value1, value2, "budgetProportion");
            return (Criteria) this;
        }

        public Criteria andActualProportionIsNull() {
            addCriterion("ACTUAL_PROPORTION is null");
            return (Criteria) this;
        }

        public Criteria andActualProportionIsNotNull() {
            addCriterion("ACTUAL_PROPORTION is not null");
            return (Criteria) this;
        }

        public Criteria andActualProportionEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_PROPORTION =", value, "actualProportion");
            return (Criteria) this;
        }

        public Criteria andActualProportionNotEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_PROPORTION <>", value, "actualProportion");
            return (Criteria) this;
        }

        public Criteria andActualProportionGreaterThan(BigDecimal value) {
            addCriterion("ACTUAL_PROPORTION >", value, "actualProportion");
            return (Criteria) this;
        }

        public Criteria andActualProportionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_PROPORTION >=", value, "actualProportion");
            return (Criteria) this;
        }

        public Criteria andActualProportionLessThan(BigDecimal value) {
            addCriterion("ACTUAL_PROPORTION <", value, "actualProportion");
            return (Criteria) this;
        }

        public Criteria andActualProportionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_PROPORTION <=", value, "actualProportion");
            return (Criteria) this;
        }

        public Criteria andActualProportionIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_PROPORTION in", values, "actualProportion");
            return (Criteria) this;
        }

        public Criteria andActualProportionNotIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_PROPORTION not in", values, "actualProportion");
            return (Criteria) this;
        }

        public Criteria andActualProportionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_PROPORTION between", value1, value2, "actualProportion");
            return (Criteria) this;
        }

        public Criteria andActualProportionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_PROPORTION not between", value1, value2, "actualProportion");
            return (Criteria) this;
        }

        public Criteria andBudgetPriceIsNull() {
            addCriterion("BUDGET_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andBudgetPriceIsNotNull() {
            addCriterion("BUDGET_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetPriceEqualTo(BigDecimal value) {
            addCriterion("BUDGET_PRICE =", value, "budgetPrice");
            return (Criteria) this;
        }

        public Criteria andBudgetPriceNotEqualTo(BigDecimal value) {
            addCriterion("BUDGET_PRICE <>", value, "budgetPrice");
            return (Criteria) this;
        }

        public Criteria andBudgetPriceGreaterThan(BigDecimal value) {
            addCriterion("BUDGET_PRICE >", value, "budgetPrice");
            return (Criteria) this;
        }

        public Criteria andBudgetPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_PRICE >=", value, "budgetPrice");
            return (Criteria) this;
        }

        public Criteria andBudgetPriceLessThan(BigDecimal value) {
            addCriterion("BUDGET_PRICE <", value, "budgetPrice");
            return (Criteria) this;
        }

        public Criteria andBudgetPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_PRICE <=", value, "budgetPrice");
            return (Criteria) this;
        }

        public Criteria andBudgetPriceIn(List<BigDecimal> values) {
            addCriterion("BUDGET_PRICE in", values, "budgetPrice");
            return (Criteria) this;
        }

        public Criteria andBudgetPriceNotIn(List<BigDecimal> values) {
            addCriterion("BUDGET_PRICE not in", values, "budgetPrice");
            return (Criteria) this;
        }

        public Criteria andBudgetPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_PRICE between", value1, value2, "budgetPrice");
            return (Criteria) this;
        }

        public Criteria andBudgetPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_PRICE not between", value1, value2, "budgetPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceIsNull() {
            addCriterion("ACTUAL_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andActualPriceIsNotNull() {
            addCriterion("ACTUAL_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andActualPriceEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_PRICE =", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceNotEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_PRICE <>", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceGreaterThan(BigDecimal value) {
            addCriterion("ACTUAL_PRICE >", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_PRICE >=", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceLessThan(BigDecimal value) {
            addCriterion("ACTUAL_PRICE <", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_PRICE <=", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_PRICE in", values, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceNotIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_PRICE not in", values, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_PRICE between", value1, value2, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_PRICE not between", value1, value2, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andBudgetSalePriceIsNull() {
            addCriterion("BUDGET_SALE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andBudgetSalePriceIsNotNull() {
            addCriterion("BUDGET_SALE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetSalePriceEqualTo(BigDecimal value) {
            addCriterion("BUDGET_SALE_PRICE =", value, "budgetSalePrice");
            return (Criteria) this;
        }

        public Criteria andBudgetSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("BUDGET_SALE_PRICE <>", value, "budgetSalePrice");
            return (Criteria) this;
        }

        public Criteria andBudgetSalePriceGreaterThan(BigDecimal value) {
            addCriterion("BUDGET_SALE_PRICE >", value, "budgetSalePrice");
            return (Criteria) this;
        }

        public Criteria andBudgetSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_SALE_PRICE >=", value, "budgetSalePrice");
            return (Criteria) this;
        }

        public Criteria andBudgetSalePriceLessThan(BigDecimal value) {
            addCriterion("BUDGET_SALE_PRICE <", value, "budgetSalePrice");
            return (Criteria) this;
        }

        public Criteria andBudgetSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_SALE_PRICE <=", value, "budgetSalePrice");
            return (Criteria) this;
        }

        public Criteria andBudgetSalePriceIn(List<BigDecimal> values) {
            addCriterion("BUDGET_SALE_PRICE in", values, "budgetSalePrice");
            return (Criteria) this;
        }

        public Criteria andBudgetSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("BUDGET_SALE_PRICE not in", values, "budgetSalePrice");
            return (Criteria) this;
        }

        public Criteria andBudgetSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_SALE_PRICE between", value1, value2, "budgetSalePrice");
            return (Criteria) this;
        }

        public Criteria andBudgetSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_SALE_PRICE not between", value1, value2, "budgetSalePrice");
            return (Criteria) this;
        }

        public Criteria andActualSalePriceIsNull() {
            addCriterion("ACTUAL_SALE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andActualSalePriceIsNotNull() {
            addCriterion("ACTUAL_SALE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andActualSalePriceEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_SALE_PRICE =", value, "actualSalePrice");
            return (Criteria) this;
        }

        public Criteria andActualSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_SALE_PRICE <>", value, "actualSalePrice");
            return (Criteria) this;
        }

        public Criteria andActualSalePriceGreaterThan(BigDecimal value) {
            addCriterion("ACTUAL_SALE_PRICE >", value, "actualSalePrice");
            return (Criteria) this;
        }

        public Criteria andActualSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_SALE_PRICE >=", value, "actualSalePrice");
            return (Criteria) this;
        }

        public Criteria andActualSalePriceLessThan(BigDecimal value) {
            addCriterion("ACTUAL_SALE_PRICE <", value, "actualSalePrice");
            return (Criteria) this;
        }

        public Criteria andActualSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_SALE_PRICE <=", value, "actualSalePrice");
            return (Criteria) this;
        }

        public Criteria andActualSalePriceIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_SALE_PRICE in", values, "actualSalePrice");
            return (Criteria) this;
        }

        public Criteria andActualSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_SALE_PRICE not in", values, "actualSalePrice");
            return (Criteria) this;
        }

        public Criteria andActualSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_SALE_PRICE between", value1, value2, "actualSalePrice");
            return (Criteria) this;
        }

        public Criteria andActualSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_SALE_PRICE not between", value1, value2, "actualSalePrice");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitCostIsNull() {
            addCriterion("BUDGET_UNIT_COST is null");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitCostIsNotNull() {
            addCriterion("BUDGET_UNIT_COST is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitCostEqualTo(BigDecimal value) {
            addCriterion("BUDGET_UNIT_COST =", value, "budgetUnitCost");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitCostNotEqualTo(BigDecimal value) {
            addCriterion("BUDGET_UNIT_COST <>", value, "budgetUnitCost");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitCostGreaterThan(BigDecimal value) {
            addCriterion("BUDGET_UNIT_COST >", value, "budgetUnitCost");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_UNIT_COST >=", value, "budgetUnitCost");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitCostLessThan(BigDecimal value) {
            addCriterion("BUDGET_UNIT_COST <", value, "budgetUnitCost");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_UNIT_COST <=", value, "budgetUnitCost");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitCostIn(List<BigDecimal> values) {
            addCriterion("BUDGET_UNIT_COST in", values, "budgetUnitCost");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitCostNotIn(List<BigDecimal> values) {
            addCriterion("BUDGET_UNIT_COST not in", values, "budgetUnitCost");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_UNIT_COST between", value1, value2, "budgetUnitCost");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_UNIT_COST not between", value1, value2, "budgetUnitCost");
            return (Criteria) this;
        }

        public Criteria andActualUnitCostIsNull() {
            addCriterion("ACTUAL_UNIT_COST is null");
            return (Criteria) this;
        }

        public Criteria andActualUnitCostIsNotNull() {
            addCriterion("ACTUAL_UNIT_COST is not null");
            return (Criteria) this;
        }

        public Criteria andActualUnitCostEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_UNIT_COST =", value, "actualUnitCost");
            return (Criteria) this;
        }

        public Criteria andActualUnitCostNotEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_UNIT_COST <>", value, "actualUnitCost");
            return (Criteria) this;
        }

        public Criteria andActualUnitCostGreaterThan(BigDecimal value) {
            addCriterion("ACTUAL_UNIT_COST >", value, "actualUnitCost");
            return (Criteria) this;
        }

        public Criteria andActualUnitCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_UNIT_COST >=", value, "actualUnitCost");
            return (Criteria) this;
        }

        public Criteria andActualUnitCostLessThan(BigDecimal value) {
            addCriterion("ACTUAL_UNIT_COST <", value, "actualUnitCost");
            return (Criteria) this;
        }

        public Criteria andActualUnitCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_UNIT_COST <=", value, "actualUnitCost");
            return (Criteria) this;
        }

        public Criteria andActualUnitCostIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_UNIT_COST in", values, "actualUnitCost");
            return (Criteria) this;
        }

        public Criteria andActualUnitCostNotIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_UNIT_COST not in", values, "actualUnitCost");
            return (Criteria) this;
        }

        public Criteria andActualUnitCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_UNIT_COST between", value1, value2, "actualUnitCost");
            return (Criteria) this;
        }

        public Criteria andActualUnitCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_UNIT_COST not between", value1, value2, "actualUnitCost");
            return (Criteria) this;
        }

        public Criteria andBudgetSaleCostIsNull() {
            addCriterion("BUDGET_SALE_COST is null");
            return (Criteria) this;
        }

        public Criteria andBudgetSaleCostIsNotNull() {
            addCriterion("BUDGET_SALE_COST is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetSaleCostEqualTo(BigDecimal value) {
            addCriterion("BUDGET_SALE_COST =", value, "budgetSaleCost");
            return (Criteria) this;
        }

        public Criteria andBudgetSaleCostNotEqualTo(BigDecimal value) {
            addCriterion("BUDGET_SALE_COST <>", value, "budgetSaleCost");
            return (Criteria) this;
        }

        public Criteria andBudgetSaleCostGreaterThan(BigDecimal value) {
            addCriterion("BUDGET_SALE_COST >", value, "budgetSaleCost");
            return (Criteria) this;
        }

        public Criteria andBudgetSaleCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_SALE_COST >=", value, "budgetSaleCost");
            return (Criteria) this;
        }

        public Criteria andBudgetSaleCostLessThan(BigDecimal value) {
            addCriterion("BUDGET_SALE_COST <", value, "budgetSaleCost");
            return (Criteria) this;
        }

        public Criteria andBudgetSaleCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_SALE_COST <=", value, "budgetSaleCost");
            return (Criteria) this;
        }

        public Criteria andBudgetSaleCostIn(List<BigDecimal> values) {
            addCriterion("BUDGET_SALE_COST in", values, "budgetSaleCost");
            return (Criteria) this;
        }

        public Criteria andBudgetSaleCostNotIn(List<BigDecimal> values) {
            addCriterion("BUDGET_SALE_COST not in", values, "budgetSaleCost");
            return (Criteria) this;
        }

        public Criteria andBudgetSaleCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_SALE_COST between", value1, value2, "budgetSaleCost");
            return (Criteria) this;
        }

        public Criteria andBudgetSaleCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_SALE_COST not between", value1, value2, "budgetSaleCost");
            return (Criteria) this;
        }

        public Criteria andActualSaleCostIsNull() {
            addCriterion("ACTUAL_SALE_COST is null");
            return (Criteria) this;
        }

        public Criteria andActualSaleCostIsNotNull() {
            addCriterion("ACTUAL_SALE_COST is not null");
            return (Criteria) this;
        }

        public Criteria andActualSaleCostEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_SALE_COST =", value, "actualSaleCost");
            return (Criteria) this;
        }

        public Criteria andActualSaleCostNotEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_SALE_COST <>", value, "actualSaleCost");
            return (Criteria) this;
        }

        public Criteria andActualSaleCostGreaterThan(BigDecimal value) {
            addCriterion("ACTUAL_SALE_COST >", value, "actualSaleCost");
            return (Criteria) this;
        }

        public Criteria andActualSaleCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_SALE_COST >=", value, "actualSaleCost");
            return (Criteria) this;
        }

        public Criteria andActualSaleCostLessThan(BigDecimal value) {
            addCriterion("ACTUAL_SALE_COST <", value, "actualSaleCost");
            return (Criteria) this;
        }

        public Criteria andActualSaleCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_SALE_COST <=", value, "actualSaleCost");
            return (Criteria) this;
        }

        public Criteria andActualSaleCostIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_SALE_COST in", values, "actualSaleCost");
            return (Criteria) this;
        }

        public Criteria andActualSaleCostNotIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_SALE_COST not in", values, "actualSaleCost");
            return (Criteria) this;
        }

        public Criteria andActualSaleCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_SALE_COST between", value1, value2, "actualSaleCost");
            return (Criteria) this;
        }

        public Criteria andActualSaleCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_SALE_COST not between", value1, value2, "actualSaleCost");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitLevelIsNull() {
            addCriterion("BUDGET_UNIT_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitLevelIsNotNull() {
            addCriterion("BUDGET_UNIT_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitLevelEqualTo(BigDecimal value) {
            addCriterion("BUDGET_UNIT_LEVEL =", value, "budgetUnitLevel");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitLevelNotEqualTo(BigDecimal value) {
            addCriterion("BUDGET_UNIT_LEVEL <>", value, "budgetUnitLevel");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitLevelGreaterThan(BigDecimal value) {
            addCriterion("BUDGET_UNIT_LEVEL >", value, "budgetUnitLevel");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitLevelGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_UNIT_LEVEL >=", value, "budgetUnitLevel");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitLevelLessThan(BigDecimal value) {
            addCriterion("BUDGET_UNIT_LEVEL <", value, "budgetUnitLevel");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitLevelLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_UNIT_LEVEL <=", value, "budgetUnitLevel");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitLevelIn(List<BigDecimal> values) {
            addCriterion("BUDGET_UNIT_LEVEL in", values, "budgetUnitLevel");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitLevelNotIn(List<BigDecimal> values) {
            addCriterion("BUDGET_UNIT_LEVEL not in", values, "budgetUnitLevel");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitLevelBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_UNIT_LEVEL between", value1, value2, "budgetUnitLevel");
            return (Criteria) this;
        }

        public Criteria andBudgetUnitLevelNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_UNIT_LEVEL not between", value1, value2, "budgetUnitLevel");
            return (Criteria) this;
        }

        public Criteria andActualUnitLevelIsNull() {
            addCriterion("ACTUAL_UNIT_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andActualUnitLevelIsNotNull() {
            addCriterion("ACTUAL_UNIT_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andActualUnitLevelEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_UNIT_LEVEL =", value, "actualUnitLevel");
            return (Criteria) this;
        }

        public Criteria andActualUnitLevelNotEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_UNIT_LEVEL <>", value, "actualUnitLevel");
            return (Criteria) this;
        }

        public Criteria andActualUnitLevelGreaterThan(BigDecimal value) {
            addCriterion("ACTUAL_UNIT_LEVEL >", value, "actualUnitLevel");
            return (Criteria) this;
        }

        public Criteria andActualUnitLevelGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_UNIT_LEVEL >=", value, "actualUnitLevel");
            return (Criteria) this;
        }

        public Criteria andActualUnitLevelLessThan(BigDecimal value) {
            addCriterion("ACTUAL_UNIT_LEVEL <", value, "actualUnitLevel");
            return (Criteria) this;
        }

        public Criteria andActualUnitLevelLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_UNIT_LEVEL <=", value, "actualUnitLevel");
            return (Criteria) this;
        }

        public Criteria andActualUnitLevelIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_UNIT_LEVEL in", values, "actualUnitLevel");
            return (Criteria) this;
        }

        public Criteria andActualUnitLevelNotIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_UNIT_LEVEL not in", values, "actualUnitLevel");
            return (Criteria) this;
        }

        public Criteria andActualUnitLevelBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_UNIT_LEVEL between", value1, value2, "actualUnitLevel");
            return (Criteria) this;
        }

        public Criteria andActualUnitLevelNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_UNIT_LEVEL not between", value1, value2, "actualUnitLevel");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossProfitIsNull() {
            addCriterion("BUDGET_GROSS_PROFIT is null");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossProfitIsNotNull() {
            addCriterion("BUDGET_GROSS_PROFIT is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossProfitEqualTo(BigDecimal value) {
            addCriterion("BUDGET_GROSS_PROFIT =", value, "budgetGrossProfit");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossProfitNotEqualTo(BigDecimal value) {
            addCriterion("BUDGET_GROSS_PROFIT <>", value, "budgetGrossProfit");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossProfitGreaterThan(BigDecimal value) {
            addCriterion("BUDGET_GROSS_PROFIT >", value, "budgetGrossProfit");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_GROSS_PROFIT >=", value, "budgetGrossProfit");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossProfitLessThan(BigDecimal value) {
            addCriterion("BUDGET_GROSS_PROFIT <", value, "budgetGrossProfit");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_GROSS_PROFIT <=", value, "budgetGrossProfit");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossProfitIn(List<BigDecimal> values) {
            addCriterion("BUDGET_GROSS_PROFIT in", values, "budgetGrossProfit");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossProfitNotIn(List<BigDecimal> values) {
            addCriterion("BUDGET_GROSS_PROFIT not in", values, "budgetGrossProfit");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_GROSS_PROFIT between", value1, value2, "budgetGrossProfit");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_GROSS_PROFIT not between", value1, value2, "budgetGrossProfit");
            return (Criteria) this;
        }

        public Criteria andActualGrossProfitIsNull() {
            addCriterion("ACTUAL_GROSS_PROFIT is null");
            return (Criteria) this;
        }

        public Criteria andActualGrossProfitIsNotNull() {
            addCriterion("ACTUAL_GROSS_PROFIT is not null");
            return (Criteria) this;
        }

        public Criteria andActualGrossProfitEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_GROSS_PROFIT =", value, "actualGrossProfit");
            return (Criteria) this;
        }

        public Criteria andActualGrossProfitNotEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_GROSS_PROFIT <>", value, "actualGrossProfit");
            return (Criteria) this;
        }

        public Criteria andActualGrossProfitGreaterThan(BigDecimal value) {
            addCriterion("ACTUAL_GROSS_PROFIT >", value, "actualGrossProfit");
            return (Criteria) this;
        }

        public Criteria andActualGrossProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_GROSS_PROFIT >=", value, "actualGrossProfit");
            return (Criteria) this;
        }

        public Criteria andActualGrossProfitLessThan(BigDecimal value) {
            addCriterion("ACTUAL_GROSS_PROFIT <", value, "actualGrossProfit");
            return (Criteria) this;
        }

        public Criteria andActualGrossProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_GROSS_PROFIT <=", value, "actualGrossProfit");
            return (Criteria) this;
        }

        public Criteria andActualGrossProfitIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_GROSS_PROFIT in", values, "actualGrossProfit");
            return (Criteria) this;
        }

        public Criteria andActualGrossProfitNotIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_GROSS_PROFIT not in", values, "actualGrossProfit");
            return (Criteria) this;
        }

        public Criteria andActualGrossProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_GROSS_PROFIT between", value1, value2, "actualGrossProfit");
            return (Criteria) this;
        }

        public Criteria andActualGrossProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_GROSS_PROFIT not between", value1, value2, "actualGrossProfit");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossInterestIsNull() {
            addCriterion("BUDGET_GROSS_INTEREST is null");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossInterestIsNotNull() {
            addCriterion("BUDGET_GROSS_INTEREST is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossInterestEqualTo(BigDecimal value) {
            addCriterion("BUDGET_GROSS_INTEREST =", value, "budgetGrossInterest");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossInterestNotEqualTo(BigDecimal value) {
            addCriterion("BUDGET_GROSS_INTEREST <>", value, "budgetGrossInterest");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossInterestGreaterThan(BigDecimal value) {
            addCriterion("BUDGET_GROSS_INTEREST >", value, "budgetGrossInterest");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_GROSS_INTEREST >=", value, "budgetGrossInterest");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossInterestLessThan(BigDecimal value) {
            addCriterion("BUDGET_GROSS_INTEREST <", value, "budgetGrossInterest");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUDGET_GROSS_INTEREST <=", value, "budgetGrossInterest");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossInterestIn(List<BigDecimal> values) {
            addCriterion("BUDGET_GROSS_INTEREST in", values, "budgetGrossInterest");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossInterestNotIn(List<BigDecimal> values) {
            addCriterion("BUDGET_GROSS_INTEREST not in", values, "budgetGrossInterest");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_GROSS_INTEREST between", value1, value2, "budgetGrossInterest");
            return (Criteria) this;
        }

        public Criteria andBudgetGrossInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUDGET_GROSS_INTEREST not between", value1, value2, "budgetGrossInterest");
            return (Criteria) this;
        }

        public Criteria andActualGrossInterestIsNull() {
            addCriterion("ACTUAL_GROSS_INTEREST is null");
            return (Criteria) this;
        }

        public Criteria andActualGrossInterestIsNotNull() {
            addCriterion("ACTUAL_GROSS_INTEREST is not null");
            return (Criteria) this;
        }

        public Criteria andActualGrossInterestEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_GROSS_INTEREST =", value, "actualGrossInterest");
            return (Criteria) this;
        }

        public Criteria andActualGrossInterestNotEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_GROSS_INTEREST <>", value, "actualGrossInterest");
            return (Criteria) this;
        }

        public Criteria andActualGrossInterestGreaterThan(BigDecimal value) {
            addCriterion("ACTUAL_GROSS_INTEREST >", value, "actualGrossInterest");
            return (Criteria) this;
        }

        public Criteria andActualGrossInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_GROSS_INTEREST >=", value, "actualGrossInterest");
            return (Criteria) this;
        }

        public Criteria andActualGrossInterestLessThan(BigDecimal value) {
            addCriterion("ACTUAL_GROSS_INTEREST <", value, "actualGrossInterest");
            return (Criteria) this;
        }

        public Criteria andActualGrossInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_GROSS_INTEREST <=", value, "actualGrossInterest");
            return (Criteria) this;
        }

        public Criteria andActualGrossInterestIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_GROSS_INTEREST in", values, "actualGrossInterest");
            return (Criteria) this;
        }

        public Criteria andActualGrossInterestNotIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_GROSS_INTEREST not in", values, "actualGrossInterest");
            return (Criteria) this;
        }

        public Criteria andActualGrossInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_GROSS_INTEREST between", value1, value2, "actualGrossInterest");
            return (Criteria) this;
        }

        public Criteria andActualGrossInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_GROSS_INTEREST not between", value1, value2, "actualGrossInterest");
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