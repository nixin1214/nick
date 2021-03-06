package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceSaleExpensesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceSaleExpensesExample() {
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

        public Criteria andFafterYearThisIsNull() {
            addCriterion("fafter_year_this is null");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisIsNotNull() {
            addCriterion("fafter_year_this is not null");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisEqualTo(BigDecimal value) {
            addCriterion("fafter_year_this =", value, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisNotEqualTo(BigDecimal value) {
            addCriterion("fafter_year_this <>", value, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisGreaterThan(BigDecimal value) {
            addCriterion("fafter_year_this >", value, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fafter_year_this >=", value, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisLessThan(BigDecimal value) {
            addCriterion("fafter_year_this <", value, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fafter_year_this <=", value, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisIn(List<BigDecimal> values) {
            addCriterion("fafter_year_this in", values, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisNotIn(List<BigDecimal> values) {
            addCriterion("fafter_year_this not in", values, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fafter_year_this between", value1, value2, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fafter_year_this not between", value1, value2, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalIsNull() {
            addCriterion("fafter_year_total is null");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalIsNotNull() {
            addCriterion("fafter_year_total is not null");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalEqualTo(BigDecimal value) {
            addCriterion("fafter_year_total =", value, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalNotEqualTo(BigDecimal value) {
            addCriterion("fafter_year_total <>", value, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalGreaterThan(BigDecimal value) {
            addCriterion("fafter_year_total >", value, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fafter_year_total >=", value, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalLessThan(BigDecimal value) {
            addCriterion("fafter_year_total <", value, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fafter_year_total <=", value, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalIn(List<BigDecimal> values) {
            addCriterion("fafter_year_total in", values, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalNotIn(List<BigDecimal> values) {
            addCriterion("fafter_year_total not in", values, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fafter_year_total between", value1, value2, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fafter_year_total not between", value1, value2, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisIsNull() {
            addCriterion("fthis_year_budget_this is null");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisIsNotNull() {
            addCriterion("fthis_year_budget_this is not null");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisEqualTo(BigDecimal value) {
            addCriterion("fthis_year_budget_this =", value, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisNotEqualTo(BigDecimal value) {
            addCriterion("fthis_year_budget_this <>", value, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisGreaterThan(BigDecimal value) {
            addCriterion("fthis_year_budget_this >", value, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_year_budget_this >=", value, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisLessThan(BigDecimal value) {
            addCriterion("fthis_year_budget_this <", value, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_year_budget_this <=", value, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisIn(List<BigDecimal> values) {
            addCriterion("fthis_year_budget_this in", values, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisNotIn(List<BigDecimal> values) {
            addCriterion("fthis_year_budget_this not in", values, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_year_budget_this between", value1, value2, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_year_budget_this not between", value1, value2, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalIsNull() {
            addCriterion("fthis_year_budget_total is null");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalIsNotNull() {
            addCriterion("fthis_year_budget_total is not null");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalEqualTo(BigDecimal value) {
            addCriterion("fthis_year_budget_total =", value, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalNotEqualTo(BigDecimal value) {
            addCriterion("fthis_year_budget_total <>", value, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalGreaterThan(BigDecimal value) {
            addCriterion("fthis_year_budget_total >", value, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_year_budget_total >=", value, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalLessThan(BigDecimal value) {
            addCriterion("fthis_year_budget_total <", value, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_year_budget_total <=", value, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalIn(List<BigDecimal> values) {
            addCriterion("fthis_year_budget_total in", values, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalNotIn(List<BigDecimal> values) {
            addCriterion("fthis_year_budget_total not in", values, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_year_budget_total between", value1, value2, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_year_budget_total not between", value1, value2, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisIsNull() {
            addCriterion("fthis_year_actual_this is null");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisIsNotNull() {
            addCriterion("fthis_year_actual_this is not null");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisEqualTo(BigDecimal value) {
            addCriterion("fthis_year_actual_this =", value, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisNotEqualTo(BigDecimal value) {
            addCriterion("fthis_year_actual_this <>", value, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisGreaterThan(BigDecimal value) {
            addCriterion("fthis_year_actual_this >", value, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_year_actual_this >=", value, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisLessThan(BigDecimal value) {
            addCriterion("fthis_year_actual_this <", value, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_year_actual_this <=", value, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisIn(List<BigDecimal> values) {
            addCriterion("fthis_year_actual_this in", values, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisNotIn(List<BigDecimal> values) {
            addCriterion("fthis_year_actual_this not in", values, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_year_actual_this between", value1, value2, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_year_actual_this not between", value1, value2, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalIsNull() {
            addCriterion("fthis_year_actual_total is null");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalIsNotNull() {
            addCriterion("fthis_year_actual_total is not null");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalEqualTo(BigDecimal value) {
            addCriterion("fthis_year_actual_total =", value, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalNotEqualTo(BigDecimal value) {
            addCriterion("fthis_year_actual_total <>", value, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalGreaterThan(BigDecimal value) {
            addCriterion("fthis_year_actual_total >", value, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_year_actual_total >=", value, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalLessThan(BigDecimal value) {
            addCriterion("fthis_year_actual_total <", value, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_year_actual_total <=", value, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalIn(List<BigDecimal> values) {
            addCriterion("fthis_year_actual_total in", values, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalNotIn(List<BigDecimal> values) {
            addCriterion("fthis_year_actual_total not in", values, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_year_actual_total between", value1, value2, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_year_actual_total not between", value1, value2, "fthisYearActualTotal");
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