package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceProductCostTotalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceProductCostTotalExample() {
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

        public Criteria andFseqIsNull() {
            addCriterion("fseq is null");
            return (Criteria) this;
        }

        public Criteria andFseqIsNotNull() {
            addCriterion("fseq is not null");
            return (Criteria) this;
        }

        public Criteria andFseqEqualTo(String value) {
            addCriterion("fseq =", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqNotEqualTo(String value) {
            addCriterion("fseq <>", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqGreaterThan(String value) {
            addCriterion("fseq >", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqGreaterThanOrEqualTo(String value) {
            addCriterion("fseq >=", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqLessThan(String value) {
            addCriterion("fseq <", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqLessThanOrEqualTo(String value) {
            addCriterion("fseq <=", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqLike(String value) {
            addCriterion("fseq like", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqNotLike(String value) {
            addCriterion("fseq not like", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqIn(List<String> values) {
            addCriterion("fseq in", values, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqNotIn(List<String> values) {
            addCriterion("fseq not in", values, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqBetween(String value1, String value2) {
            addCriterion("fseq between", value1, value2, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqNotBetween(String value1, String value2) {
            addCriterion("fseq not between", value1, value2, "fseq");
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

        public Criteria andFyieldIsNull() {
            addCriterion("fyield is null");
            return (Criteria) this;
        }

        public Criteria andFyieldIsNotNull() {
            addCriterion("fyield is not null");
            return (Criteria) this;
        }

        public Criteria andFyieldEqualTo(BigDecimal value) {
            addCriterion("fyield =", value, "fyield");
            return (Criteria) this;
        }

        public Criteria andFyieldNotEqualTo(BigDecimal value) {
            addCriterion("fyield <>", value, "fyield");
            return (Criteria) this;
        }

        public Criteria andFyieldGreaterThan(BigDecimal value) {
            addCriterion("fyield >", value, "fyield");
            return (Criteria) this;
        }

        public Criteria andFyieldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fyield >=", value, "fyield");
            return (Criteria) this;
        }

        public Criteria andFyieldLessThan(BigDecimal value) {
            addCriterion("fyield <", value, "fyield");
            return (Criteria) this;
        }

        public Criteria andFyieldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fyield <=", value, "fyield");
            return (Criteria) this;
        }

        public Criteria andFyieldIn(List<BigDecimal> values) {
            addCriterion("fyield in", values, "fyield");
            return (Criteria) this;
        }

        public Criteria andFyieldNotIn(List<BigDecimal> values) {
            addCriterion("fyield not in", values, "fyield");
            return (Criteria) this;
        }

        public Criteria andFyieldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fyield between", value1, value2, "fyield");
            return (Criteria) this;
        }

        public Criteria andFyieldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fyield not between", value1, value2, "fyield");
            return (Criteria) this;
        }

        public Criteria andFmaterialBudgetIsNull() {
            addCriterion("fmaterial_budget is null");
            return (Criteria) this;
        }

        public Criteria andFmaterialBudgetIsNotNull() {
            addCriterion("fmaterial_budget is not null");
            return (Criteria) this;
        }

        public Criteria andFmaterialBudgetEqualTo(BigDecimal value) {
            addCriterion("fmaterial_budget =", value, "fmaterialBudget");
            return (Criteria) this;
        }

        public Criteria andFmaterialBudgetNotEqualTo(BigDecimal value) {
            addCriterion("fmaterial_budget <>", value, "fmaterialBudget");
            return (Criteria) this;
        }

        public Criteria andFmaterialBudgetGreaterThan(BigDecimal value) {
            addCriterion("fmaterial_budget >", value, "fmaterialBudget");
            return (Criteria) this;
        }

        public Criteria andFmaterialBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fmaterial_budget >=", value, "fmaterialBudget");
            return (Criteria) this;
        }

        public Criteria andFmaterialBudgetLessThan(BigDecimal value) {
            addCriterion("fmaterial_budget <", value, "fmaterialBudget");
            return (Criteria) this;
        }

        public Criteria andFmaterialBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fmaterial_budget <=", value, "fmaterialBudget");
            return (Criteria) this;
        }

        public Criteria andFmaterialBudgetIn(List<BigDecimal> values) {
            addCriterion("fmaterial_budget in", values, "fmaterialBudget");
            return (Criteria) this;
        }

        public Criteria andFmaterialBudgetNotIn(List<BigDecimal> values) {
            addCriterion("fmaterial_budget not in", values, "fmaterialBudget");
            return (Criteria) this;
        }

        public Criteria andFmaterialBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmaterial_budget between", value1, value2, "fmaterialBudget");
            return (Criteria) this;
        }

        public Criteria andFmaterialBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmaterial_budget not between", value1, value2, "fmaterialBudget");
            return (Criteria) this;
        }

        public Criteria andFmaterialActualIsNull() {
            addCriterion("fmaterial_actual is null");
            return (Criteria) this;
        }

        public Criteria andFmaterialActualIsNotNull() {
            addCriterion("fmaterial_actual is not null");
            return (Criteria) this;
        }

        public Criteria andFmaterialActualEqualTo(BigDecimal value) {
            addCriterion("fmaterial_actual =", value, "fmaterialActual");
            return (Criteria) this;
        }

        public Criteria andFmaterialActualNotEqualTo(BigDecimal value) {
            addCriterion("fmaterial_actual <>", value, "fmaterialActual");
            return (Criteria) this;
        }

        public Criteria andFmaterialActualGreaterThan(BigDecimal value) {
            addCriterion("fmaterial_actual >", value, "fmaterialActual");
            return (Criteria) this;
        }

        public Criteria andFmaterialActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fmaterial_actual >=", value, "fmaterialActual");
            return (Criteria) this;
        }

        public Criteria andFmaterialActualLessThan(BigDecimal value) {
            addCriterion("fmaterial_actual <", value, "fmaterialActual");
            return (Criteria) this;
        }

        public Criteria andFmaterialActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fmaterial_actual <=", value, "fmaterialActual");
            return (Criteria) this;
        }

        public Criteria andFmaterialActualIn(List<BigDecimal> values) {
            addCriterion("fmaterial_actual in", values, "fmaterialActual");
            return (Criteria) this;
        }

        public Criteria andFmaterialActualNotIn(List<BigDecimal> values) {
            addCriterion("fmaterial_actual not in", values, "fmaterialActual");
            return (Criteria) this;
        }

        public Criteria andFmaterialActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmaterial_actual between", value1, value2, "fmaterialActual");
            return (Criteria) this;
        }

        public Criteria andFmaterialActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmaterial_actual not between", value1, value2, "fmaterialActual");
            return (Criteria) this;
        }

        public Criteria andFpackageBudgetIsNull() {
            addCriterion("fpackage_budget is null");
            return (Criteria) this;
        }

        public Criteria andFpackageBudgetIsNotNull() {
            addCriterion("fpackage_budget is not null");
            return (Criteria) this;
        }

        public Criteria andFpackageBudgetEqualTo(BigDecimal value) {
            addCriterion("fpackage_budget =", value, "fpackageBudget");
            return (Criteria) this;
        }

        public Criteria andFpackageBudgetNotEqualTo(BigDecimal value) {
            addCriterion("fpackage_budget <>", value, "fpackageBudget");
            return (Criteria) this;
        }

        public Criteria andFpackageBudgetGreaterThan(BigDecimal value) {
            addCriterion("fpackage_budget >", value, "fpackageBudget");
            return (Criteria) this;
        }

        public Criteria andFpackageBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fpackage_budget >=", value, "fpackageBudget");
            return (Criteria) this;
        }

        public Criteria andFpackageBudgetLessThan(BigDecimal value) {
            addCriterion("fpackage_budget <", value, "fpackageBudget");
            return (Criteria) this;
        }

        public Criteria andFpackageBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fpackage_budget <=", value, "fpackageBudget");
            return (Criteria) this;
        }

        public Criteria andFpackageBudgetIn(List<BigDecimal> values) {
            addCriterion("fpackage_budget in", values, "fpackageBudget");
            return (Criteria) this;
        }

        public Criteria andFpackageBudgetNotIn(List<BigDecimal> values) {
            addCriterion("fpackage_budget not in", values, "fpackageBudget");
            return (Criteria) this;
        }

        public Criteria andFpackageBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpackage_budget between", value1, value2, "fpackageBudget");
            return (Criteria) this;
        }

        public Criteria andFpackageBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpackage_budget not between", value1, value2, "fpackageBudget");
            return (Criteria) this;
        }

        public Criteria andFpackageActualIsNull() {
            addCriterion("fpackage_actual is null");
            return (Criteria) this;
        }

        public Criteria andFpackageActualIsNotNull() {
            addCriterion("fpackage_actual is not null");
            return (Criteria) this;
        }

        public Criteria andFpackageActualEqualTo(BigDecimal value) {
            addCriterion("fpackage_actual =", value, "fpackageActual");
            return (Criteria) this;
        }

        public Criteria andFpackageActualNotEqualTo(BigDecimal value) {
            addCriterion("fpackage_actual <>", value, "fpackageActual");
            return (Criteria) this;
        }

        public Criteria andFpackageActualGreaterThan(BigDecimal value) {
            addCriterion("fpackage_actual >", value, "fpackageActual");
            return (Criteria) this;
        }

        public Criteria andFpackageActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fpackage_actual >=", value, "fpackageActual");
            return (Criteria) this;
        }

        public Criteria andFpackageActualLessThan(BigDecimal value) {
            addCriterion("fpackage_actual <", value, "fpackageActual");
            return (Criteria) this;
        }

        public Criteria andFpackageActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fpackage_actual <=", value, "fpackageActual");
            return (Criteria) this;
        }

        public Criteria andFpackageActualIn(List<BigDecimal> values) {
            addCriterion("fpackage_actual in", values, "fpackageActual");
            return (Criteria) this;
        }

        public Criteria andFpackageActualNotIn(List<BigDecimal> values) {
            addCriterion("fpackage_actual not in", values, "fpackageActual");
            return (Criteria) this;
        }

        public Criteria andFpackageActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpackage_actual between", value1, value2, "fpackageActual");
            return (Criteria) this;
        }

        public Criteria andFpackageActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpackage_actual not between", value1, value2, "fpackageActual");
            return (Criteria) this;
        }

        public Criteria andFlaborCostBudgetIsNull() {
            addCriterion("flabor_cost_budget is null");
            return (Criteria) this;
        }

        public Criteria andFlaborCostBudgetIsNotNull() {
            addCriterion("flabor_cost_budget is not null");
            return (Criteria) this;
        }

        public Criteria andFlaborCostBudgetEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_budget =", value, "flaborCostBudget");
            return (Criteria) this;
        }

        public Criteria andFlaborCostBudgetNotEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_budget <>", value, "flaborCostBudget");
            return (Criteria) this;
        }

        public Criteria andFlaborCostBudgetGreaterThan(BigDecimal value) {
            addCriterion("flabor_cost_budget >", value, "flaborCostBudget");
            return (Criteria) this;
        }

        public Criteria andFlaborCostBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_budget >=", value, "flaborCostBudget");
            return (Criteria) this;
        }

        public Criteria andFlaborCostBudgetLessThan(BigDecimal value) {
            addCriterion("flabor_cost_budget <", value, "flaborCostBudget");
            return (Criteria) this;
        }

        public Criteria andFlaborCostBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_budget <=", value, "flaborCostBudget");
            return (Criteria) this;
        }

        public Criteria andFlaborCostBudgetIn(List<BigDecimal> values) {
            addCriterion("flabor_cost_budget in", values, "flaborCostBudget");
            return (Criteria) this;
        }

        public Criteria andFlaborCostBudgetNotIn(List<BigDecimal> values) {
            addCriterion("flabor_cost_budget not in", values, "flaborCostBudget");
            return (Criteria) this;
        }

        public Criteria andFlaborCostBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flabor_cost_budget between", value1, value2, "flaborCostBudget");
            return (Criteria) this;
        }

        public Criteria andFlaborCostBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flabor_cost_budget not between", value1, value2, "flaborCostBudget");
            return (Criteria) this;
        }

        public Criteria andFlaborCostActualIsNull() {
            addCriterion("flabor_cost_actual is null");
            return (Criteria) this;
        }

        public Criteria andFlaborCostActualIsNotNull() {
            addCriterion("flabor_cost_actual is not null");
            return (Criteria) this;
        }

        public Criteria andFlaborCostActualEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_actual =", value, "flaborCostActual");
            return (Criteria) this;
        }

        public Criteria andFlaborCostActualNotEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_actual <>", value, "flaborCostActual");
            return (Criteria) this;
        }

        public Criteria andFlaborCostActualGreaterThan(BigDecimal value) {
            addCriterion("flabor_cost_actual >", value, "flaborCostActual");
            return (Criteria) this;
        }

        public Criteria andFlaborCostActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_actual >=", value, "flaborCostActual");
            return (Criteria) this;
        }

        public Criteria andFlaborCostActualLessThan(BigDecimal value) {
            addCriterion("flabor_cost_actual <", value, "flaborCostActual");
            return (Criteria) this;
        }

        public Criteria andFlaborCostActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_actual <=", value, "flaborCostActual");
            return (Criteria) this;
        }

        public Criteria andFlaborCostActualIn(List<BigDecimal> values) {
            addCriterion("flabor_cost_actual in", values, "flaborCostActual");
            return (Criteria) this;
        }

        public Criteria andFlaborCostActualNotIn(List<BigDecimal> values) {
            addCriterion("flabor_cost_actual not in", values, "flaborCostActual");
            return (Criteria) this;
        }

        public Criteria andFlaborCostActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flabor_cost_actual between", value1, value2, "flaborCostActual");
            return (Criteria) this;
        }

        public Criteria andFlaborCostActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flabor_cost_actual not between", value1, value2, "flaborCostActual");
            return (Criteria) this;
        }

        public Criteria andFpowerCostBudgetIsNull() {
            addCriterion("fpower_cost_budget is null");
            return (Criteria) this;
        }

        public Criteria andFpowerCostBudgetIsNotNull() {
            addCriterion("fpower_cost_budget is not null");
            return (Criteria) this;
        }

        public Criteria andFpowerCostBudgetEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_budget =", value, "fpowerCostBudget");
            return (Criteria) this;
        }

        public Criteria andFpowerCostBudgetNotEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_budget <>", value, "fpowerCostBudget");
            return (Criteria) this;
        }

        public Criteria andFpowerCostBudgetGreaterThan(BigDecimal value) {
            addCriterion("fpower_cost_budget >", value, "fpowerCostBudget");
            return (Criteria) this;
        }

        public Criteria andFpowerCostBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_budget >=", value, "fpowerCostBudget");
            return (Criteria) this;
        }

        public Criteria andFpowerCostBudgetLessThan(BigDecimal value) {
            addCriterion("fpower_cost_budget <", value, "fpowerCostBudget");
            return (Criteria) this;
        }

        public Criteria andFpowerCostBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_budget <=", value, "fpowerCostBudget");
            return (Criteria) this;
        }

        public Criteria andFpowerCostBudgetIn(List<BigDecimal> values) {
            addCriterion("fpower_cost_budget in", values, "fpowerCostBudget");
            return (Criteria) this;
        }

        public Criteria andFpowerCostBudgetNotIn(List<BigDecimal> values) {
            addCriterion("fpower_cost_budget not in", values, "fpowerCostBudget");
            return (Criteria) this;
        }

        public Criteria andFpowerCostBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpower_cost_budget between", value1, value2, "fpowerCostBudget");
            return (Criteria) this;
        }

        public Criteria andFpowerCostBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpower_cost_budget not between", value1, value2, "fpowerCostBudget");
            return (Criteria) this;
        }

        public Criteria andFpowerCostActualIsNull() {
            addCriterion("fpower_cost_actual is null");
            return (Criteria) this;
        }

        public Criteria andFpowerCostActualIsNotNull() {
            addCriterion("fpower_cost_actual is not null");
            return (Criteria) this;
        }

        public Criteria andFpowerCostActualEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_actual =", value, "fpowerCostActual");
            return (Criteria) this;
        }

        public Criteria andFpowerCostActualNotEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_actual <>", value, "fpowerCostActual");
            return (Criteria) this;
        }

        public Criteria andFpowerCostActualGreaterThan(BigDecimal value) {
            addCriterion("fpower_cost_actual >", value, "fpowerCostActual");
            return (Criteria) this;
        }

        public Criteria andFpowerCostActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_actual >=", value, "fpowerCostActual");
            return (Criteria) this;
        }

        public Criteria andFpowerCostActualLessThan(BigDecimal value) {
            addCriterion("fpower_cost_actual <", value, "fpowerCostActual");
            return (Criteria) this;
        }

        public Criteria andFpowerCostActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_actual <=", value, "fpowerCostActual");
            return (Criteria) this;
        }

        public Criteria andFpowerCostActualIn(List<BigDecimal> values) {
            addCriterion("fpower_cost_actual in", values, "fpowerCostActual");
            return (Criteria) this;
        }

        public Criteria andFpowerCostActualNotIn(List<BigDecimal> values) {
            addCriterion("fpower_cost_actual not in", values, "fpowerCostActual");
            return (Criteria) this;
        }

        public Criteria andFpowerCostActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpower_cost_actual between", value1, value2, "fpowerCostActual");
            return (Criteria) this;
        }

        public Criteria andFpowerCostActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpower_cost_actual not between", value1, value2, "fpowerCostActual");
            return (Criteria) this;
        }

        public Criteria andFmanufCostBudgetIsNull() {
            addCriterion("fmanuf_cost_budget is null");
            return (Criteria) this;
        }

        public Criteria andFmanufCostBudgetIsNotNull() {
            addCriterion("fmanuf_cost_budget is not null");
            return (Criteria) this;
        }

        public Criteria andFmanufCostBudgetEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_budget =", value, "fmanufCostBudget");
            return (Criteria) this;
        }

        public Criteria andFmanufCostBudgetNotEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_budget <>", value, "fmanufCostBudget");
            return (Criteria) this;
        }

        public Criteria andFmanufCostBudgetGreaterThan(BigDecimal value) {
            addCriterion("fmanuf_cost_budget >", value, "fmanufCostBudget");
            return (Criteria) this;
        }

        public Criteria andFmanufCostBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_budget >=", value, "fmanufCostBudget");
            return (Criteria) this;
        }

        public Criteria andFmanufCostBudgetLessThan(BigDecimal value) {
            addCriterion("fmanuf_cost_budget <", value, "fmanufCostBudget");
            return (Criteria) this;
        }

        public Criteria andFmanufCostBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_budget <=", value, "fmanufCostBudget");
            return (Criteria) this;
        }

        public Criteria andFmanufCostBudgetIn(List<BigDecimal> values) {
            addCriterion("fmanuf_cost_budget in", values, "fmanufCostBudget");
            return (Criteria) this;
        }

        public Criteria andFmanufCostBudgetNotIn(List<BigDecimal> values) {
            addCriterion("fmanuf_cost_budget not in", values, "fmanufCostBudget");
            return (Criteria) this;
        }

        public Criteria andFmanufCostBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmanuf_cost_budget between", value1, value2, "fmanufCostBudget");
            return (Criteria) this;
        }

        public Criteria andFmanufCostBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmanuf_cost_budget not between", value1, value2, "fmanufCostBudget");
            return (Criteria) this;
        }

        public Criteria andFmanufCostActualIsNull() {
            addCriterion("fmanuf_cost_actual is null");
            return (Criteria) this;
        }

        public Criteria andFmanufCostActualIsNotNull() {
            addCriterion("fmanuf_cost_actual is not null");
            return (Criteria) this;
        }

        public Criteria andFmanufCostActualEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_actual =", value, "fmanufCostActual");
            return (Criteria) this;
        }

        public Criteria andFmanufCostActualNotEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_actual <>", value, "fmanufCostActual");
            return (Criteria) this;
        }

        public Criteria andFmanufCostActualGreaterThan(BigDecimal value) {
            addCriterion("fmanuf_cost_actual >", value, "fmanufCostActual");
            return (Criteria) this;
        }

        public Criteria andFmanufCostActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_actual >=", value, "fmanufCostActual");
            return (Criteria) this;
        }

        public Criteria andFmanufCostActualLessThan(BigDecimal value) {
            addCriterion("fmanuf_cost_actual <", value, "fmanufCostActual");
            return (Criteria) this;
        }

        public Criteria andFmanufCostActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_actual <=", value, "fmanufCostActual");
            return (Criteria) this;
        }

        public Criteria andFmanufCostActualIn(List<BigDecimal> values) {
            addCriterion("fmanuf_cost_actual in", values, "fmanufCostActual");
            return (Criteria) this;
        }

        public Criteria andFmanufCostActualNotIn(List<BigDecimal> values) {
            addCriterion("fmanuf_cost_actual not in", values, "fmanufCostActual");
            return (Criteria) this;
        }

        public Criteria andFmanufCostActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmanuf_cost_actual between", value1, value2, "fmanufCostActual");
            return (Criteria) this;
        }

        public Criteria andFmanufCostActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmanuf_cost_actual not between", value1, value2, "fmanufCostActual");
            return (Criteria) this;
        }

        public Criteria andFproductionCostBudgetIsNull() {
            addCriterion("fproduction_cost_budget is null");
            return (Criteria) this;
        }

        public Criteria andFproductionCostBudgetIsNotNull() {
            addCriterion("fproduction_cost_budget is not null");
            return (Criteria) this;
        }

        public Criteria andFproductionCostBudgetEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_budget =", value, "fproductionCostBudget");
            return (Criteria) this;
        }

        public Criteria andFproductionCostBudgetNotEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_budget <>", value, "fproductionCostBudget");
            return (Criteria) this;
        }

        public Criteria andFproductionCostBudgetGreaterThan(BigDecimal value) {
            addCriterion("fproduction_cost_budget >", value, "fproductionCostBudget");
            return (Criteria) this;
        }

        public Criteria andFproductionCostBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_budget >=", value, "fproductionCostBudget");
            return (Criteria) this;
        }

        public Criteria andFproductionCostBudgetLessThan(BigDecimal value) {
            addCriterion("fproduction_cost_budget <", value, "fproductionCostBudget");
            return (Criteria) this;
        }

        public Criteria andFproductionCostBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_budget <=", value, "fproductionCostBudget");
            return (Criteria) this;
        }

        public Criteria andFproductionCostBudgetIn(List<BigDecimal> values) {
            addCriterion("fproduction_cost_budget in", values, "fproductionCostBudget");
            return (Criteria) this;
        }

        public Criteria andFproductionCostBudgetNotIn(List<BigDecimal> values) {
            addCriterion("fproduction_cost_budget not in", values, "fproductionCostBudget");
            return (Criteria) this;
        }

        public Criteria andFproductionCostBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fproduction_cost_budget between", value1, value2, "fproductionCostBudget");
            return (Criteria) this;
        }

        public Criteria andFproductionCostBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fproduction_cost_budget not between", value1, value2, "fproductionCostBudget");
            return (Criteria) this;
        }

        public Criteria andFproductionCostActualIsNull() {
            addCriterion("fproduction_cost_actual is null");
            return (Criteria) this;
        }

        public Criteria andFproductionCostActualIsNotNull() {
            addCriterion("fproduction_cost_actual is not null");
            return (Criteria) this;
        }

        public Criteria andFproductionCostActualEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_actual =", value, "fproductionCostActual");
            return (Criteria) this;
        }

        public Criteria andFproductionCostActualNotEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_actual <>", value, "fproductionCostActual");
            return (Criteria) this;
        }

        public Criteria andFproductionCostActualGreaterThan(BigDecimal value) {
            addCriterion("fproduction_cost_actual >", value, "fproductionCostActual");
            return (Criteria) this;
        }

        public Criteria andFproductionCostActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_actual >=", value, "fproductionCostActual");
            return (Criteria) this;
        }

        public Criteria andFproductionCostActualLessThan(BigDecimal value) {
            addCriterion("fproduction_cost_actual <", value, "fproductionCostActual");
            return (Criteria) this;
        }

        public Criteria andFproductionCostActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_actual <=", value, "fproductionCostActual");
            return (Criteria) this;
        }

        public Criteria andFproductionCostActualIn(List<BigDecimal> values) {
            addCriterion("fproduction_cost_actual in", values, "fproductionCostActual");
            return (Criteria) this;
        }

        public Criteria andFproductionCostActualNotIn(List<BigDecimal> values) {
            addCriterion("fproduction_cost_actual not in", values, "fproductionCostActual");
            return (Criteria) this;
        }

        public Criteria andFproductionCostActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fproduction_cost_actual between", value1, value2, "fproductionCostActual");
            return (Criteria) this;
        }

        public Criteria andFproductionCostActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fproduction_cost_actual not between", value1, value2, "fproductionCostActual");
            return (Criteria) this;
        }

        public Criteria andFproductionCostTotalIsNull() {
            addCriterion("fproduction_cost_total is null");
            return (Criteria) this;
        }

        public Criteria andFproductionCostTotalIsNotNull() {
            addCriterion("fproduction_cost_total is not null");
            return (Criteria) this;
        }

        public Criteria andFproductionCostTotalEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_total =", value, "fproductionCostTotal");
            return (Criteria) this;
        }

        public Criteria andFproductionCostTotalNotEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_total <>", value, "fproductionCostTotal");
            return (Criteria) this;
        }

        public Criteria andFproductionCostTotalGreaterThan(BigDecimal value) {
            addCriterion("fproduction_cost_total >", value, "fproductionCostTotal");
            return (Criteria) this;
        }

        public Criteria andFproductionCostTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_total >=", value, "fproductionCostTotal");
            return (Criteria) this;
        }

        public Criteria andFproductionCostTotalLessThan(BigDecimal value) {
            addCriterion("fproduction_cost_total <", value, "fproductionCostTotal");
            return (Criteria) this;
        }

        public Criteria andFproductionCostTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_total <=", value, "fproductionCostTotal");
            return (Criteria) this;
        }

        public Criteria andFproductionCostTotalIn(List<BigDecimal> values) {
            addCriterion("fproduction_cost_total in", values, "fproductionCostTotal");
            return (Criteria) this;
        }

        public Criteria andFproductionCostTotalNotIn(List<BigDecimal> values) {
            addCriterion("fproduction_cost_total not in", values, "fproductionCostTotal");
            return (Criteria) this;
        }

        public Criteria andFproductionCostTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fproduction_cost_total between", value1, value2, "fproductionCostTotal");
            return (Criteria) this;
        }

        public Criteria andFproductionCostTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fproduction_cost_total not between", value1, value2, "fproductionCostTotal");
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

        public Criteria andFextend4IsNull() {
            addCriterion("fextend4 is null");
            return (Criteria) this;
        }

        public Criteria andFextend4IsNotNull() {
            addCriterion("fextend4 is not null");
            return (Criteria) this;
        }

        public Criteria andFextend4EqualTo(BigDecimal value) {
            addCriterion("fextend4 =", value, "fextend4");
            return (Criteria) this;
        }

        public Criteria andFextend4NotEqualTo(BigDecimal value) {
            addCriterion("fextend4 <>", value, "fextend4");
            return (Criteria) this;
        }

        public Criteria andFextend4GreaterThan(BigDecimal value) {
            addCriterion("fextend4 >", value, "fextend4");
            return (Criteria) this;
        }

        public Criteria andFextend4GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fextend4 >=", value, "fextend4");
            return (Criteria) this;
        }

        public Criteria andFextend4LessThan(BigDecimal value) {
            addCriterion("fextend4 <", value, "fextend4");
            return (Criteria) this;
        }

        public Criteria andFextend4LessThanOrEqualTo(BigDecimal value) {
            addCriterion("fextend4 <=", value, "fextend4");
            return (Criteria) this;
        }

        public Criteria andFextend4In(List<BigDecimal> values) {
            addCriterion("fextend4 in", values, "fextend4");
            return (Criteria) this;
        }

        public Criteria andFextend4NotIn(List<BigDecimal> values) {
            addCriterion("fextend4 not in", values, "fextend4");
            return (Criteria) this;
        }

        public Criteria andFextend4Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("fextend4 between", value1, value2, "fextend4");
            return (Criteria) this;
        }

        public Criteria andFextend4NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fextend4 not between", value1, value2, "fextend4");
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