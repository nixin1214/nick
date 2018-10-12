package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceSaleExpensesDiffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceSaleExpensesDiffExample() {
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

        public Criteria andFseqIsNull() {
            addCriterion("FSEQ is null");
            return (Criteria) this;
        }

        public Criteria andFseqIsNotNull() {
            addCriterion("FSEQ is not null");
            return (Criteria) this;
        }

        public Criteria andFseqEqualTo(String value) {
            addCriterion("FSEQ =", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqNotEqualTo(String value) {
            addCriterion("FSEQ <>", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqGreaterThan(String value) {
            addCriterion("FSEQ >", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqGreaterThanOrEqualTo(String value) {
            addCriterion("FSEQ >=", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqLessThan(String value) {
            addCriterion("FSEQ <", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqLessThanOrEqualTo(String value) {
            addCriterion("FSEQ <=", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqLike(String value) {
            addCriterion("FSEQ like", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqNotLike(String value) {
            addCriterion("FSEQ not like", value, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqIn(List<String> values) {
            addCriterion("FSEQ in", values, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqNotIn(List<String> values) {
            addCriterion("FSEQ not in", values, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqBetween(String value1, String value2) {
            addCriterion("FSEQ between", value1, value2, "fseq");
            return (Criteria) this;
        }

        public Criteria andFseqNotBetween(String value1, String value2) {
            addCriterion("FSEQ not between", value1, value2, "fseq");
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

        public Criteria andFafterYearThisIsNull() {
            addCriterion("FAFTER_YEAR_THIS is null");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisIsNotNull() {
            addCriterion("FAFTER_YEAR_THIS is not null");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisEqualTo(BigDecimal value) {
            addCriterion("FAFTER_YEAR_THIS =", value, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisNotEqualTo(BigDecimal value) {
            addCriterion("FAFTER_YEAR_THIS <>", value, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisGreaterThan(BigDecimal value) {
            addCriterion("FAFTER_YEAR_THIS >", value, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAFTER_YEAR_THIS >=", value, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisLessThan(BigDecimal value) {
            addCriterion("FAFTER_YEAR_THIS <", value, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAFTER_YEAR_THIS <=", value, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisIn(List<BigDecimal> values) {
            addCriterion("FAFTER_YEAR_THIS in", values, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisNotIn(List<BigDecimal> values) {
            addCriterion("FAFTER_YEAR_THIS not in", values, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAFTER_YEAR_THIS between", value1, value2, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearThisNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAFTER_YEAR_THIS not between", value1, value2, "fafterYearThis");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalIsNull() {
            addCriterion("FAFTER_YEAR_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalIsNotNull() {
            addCriterion("FAFTER_YEAR_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalEqualTo(BigDecimal value) {
            addCriterion("FAFTER_YEAR_TOTAL =", value, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalNotEqualTo(BigDecimal value) {
            addCriterion("FAFTER_YEAR_TOTAL <>", value, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalGreaterThan(BigDecimal value) {
            addCriterion("FAFTER_YEAR_TOTAL >", value, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAFTER_YEAR_TOTAL >=", value, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalLessThan(BigDecimal value) {
            addCriterion("FAFTER_YEAR_TOTAL <", value, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAFTER_YEAR_TOTAL <=", value, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalIn(List<BigDecimal> values) {
            addCriterion("FAFTER_YEAR_TOTAL in", values, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalNotIn(List<BigDecimal> values) {
            addCriterion("FAFTER_YEAR_TOTAL not in", values, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAFTER_YEAR_TOTAL between", value1, value2, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFafterYearTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAFTER_YEAR_TOTAL not between", value1, value2, "fafterYearTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisIsNull() {
            addCriterion("FTHIS_YEAR_BUDGET_THIS is null");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisIsNotNull() {
            addCriterion("FTHIS_YEAR_BUDGET_THIS is not null");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_BUDGET_THIS =", value, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisNotEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_BUDGET_THIS <>", value, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisGreaterThan(BigDecimal value) {
            addCriterion("FTHIS_YEAR_BUDGET_THIS >", value, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_BUDGET_THIS >=", value, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisLessThan(BigDecimal value) {
            addCriterion("FTHIS_YEAR_BUDGET_THIS <", value, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_BUDGET_THIS <=", value, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisIn(List<BigDecimal> values) {
            addCriterion("FTHIS_YEAR_BUDGET_THIS in", values, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisNotIn(List<BigDecimal> values) {
            addCriterion("FTHIS_YEAR_BUDGET_THIS not in", values, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_YEAR_BUDGET_THIS between", value1, value2, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetThisNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_YEAR_BUDGET_THIS not between", value1, value2, "fthisYearBudgetThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalIsNull() {
            addCriterion("FTHIS_YEAR_BUDGET_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalIsNotNull() {
            addCriterion("FTHIS_YEAR_BUDGET_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_BUDGET_TOTAL =", value, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalNotEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_BUDGET_TOTAL <>", value, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalGreaterThan(BigDecimal value) {
            addCriterion("FTHIS_YEAR_BUDGET_TOTAL >", value, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_BUDGET_TOTAL >=", value, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalLessThan(BigDecimal value) {
            addCriterion("FTHIS_YEAR_BUDGET_TOTAL <", value, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_BUDGET_TOTAL <=", value, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalIn(List<BigDecimal> values) {
            addCriterion("FTHIS_YEAR_BUDGET_TOTAL in", values, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalNotIn(List<BigDecimal> values) {
            addCriterion("FTHIS_YEAR_BUDGET_TOTAL not in", values, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_YEAR_BUDGET_TOTAL between", value1, value2, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearBudgetTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_YEAR_BUDGET_TOTAL not between", value1, value2, "fthisYearBudgetTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisIsNull() {
            addCriterion("FTHIS_YEAR_ACTUAL_THIS is null");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisIsNotNull() {
            addCriterion("FTHIS_YEAR_ACTUAL_THIS is not null");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_ACTUAL_THIS =", value, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisNotEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_ACTUAL_THIS <>", value, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisGreaterThan(BigDecimal value) {
            addCriterion("FTHIS_YEAR_ACTUAL_THIS >", value, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_ACTUAL_THIS >=", value, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisLessThan(BigDecimal value) {
            addCriterion("FTHIS_YEAR_ACTUAL_THIS <", value, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_ACTUAL_THIS <=", value, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisIn(List<BigDecimal> values) {
            addCriterion("FTHIS_YEAR_ACTUAL_THIS in", values, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisNotIn(List<BigDecimal> values) {
            addCriterion("FTHIS_YEAR_ACTUAL_THIS not in", values, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_YEAR_ACTUAL_THIS between", value1, value2, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualThisNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_YEAR_ACTUAL_THIS not between", value1, value2, "fthisYearActualThis");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalIsNull() {
            addCriterion("FTHIS_YEAR_ACTUAL_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalIsNotNull() {
            addCriterion("FTHIS_YEAR_ACTUAL_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_ACTUAL_TOTAL =", value, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalNotEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_ACTUAL_TOTAL <>", value, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalGreaterThan(BigDecimal value) {
            addCriterion("FTHIS_YEAR_ACTUAL_TOTAL >", value, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_ACTUAL_TOTAL >=", value, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalLessThan(BigDecimal value) {
            addCriterion("FTHIS_YEAR_ACTUAL_TOTAL <", value, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_YEAR_ACTUAL_TOTAL <=", value, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalIn(List<BigDecimal> values) {
            addCriterion("FTHIS_YEAR_ACTUAL_TOTAL in", values, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalNotIn(List<BigDecimal> values) {
            addCriterion("FTHIS_YEAR_ACTUAL_TOTAL not in", values, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_YEAR_ACTUAL_TOTAL between", value1, value2, "fthisYearActualTotal");
            return (Criteria) this;
        }

        public Criteria andFthisYearActualTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_YEAR_ACTUAL_TOTAL not between", value1, value2, "fthisYearActualTotal");
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