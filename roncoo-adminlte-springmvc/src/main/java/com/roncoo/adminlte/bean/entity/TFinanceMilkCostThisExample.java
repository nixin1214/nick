package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceMilkCostThisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceMilkCostThisExample() {
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

        public Criteria andFmaterialYieldIsNull() {
            addCriterion("fmaterial_yield is null");
            return (Criteria) this;
        }

        public Criteria andFmaterialYieldIsNotNull() {
            addCriterion("fmaterial_yield is not null");
            return (Criteria) this;
        }

        public Criteria andFmaterialYieldEqualTo(BigDecimal value) {
            addCriterion("fmaterial_yield =", value, "fmaterialYield");
            return (Criteria) this;
        }

        public Criteria andFmaterialYieldNotEqualTo(BigDecimal value) {
            addCriterion("fmaterial_yield <>", value, "fmaterialYield");
            return (Criteria) this;
        }

        public Criteria andFmaterialYieldGreaterThan(BigDecimal value) {
            addCriterion("fmaterial_yield >", value, "fmaterialYield");
            return (Criteria) this;
        }

        public Criteria andFmaterialYieldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fmaterial_yield >=", value, "fmaterialYield");
            return (Criteria) this;
        }

        public Criteria andFmaterialYieldLessThan(BigDecimal value) {
            addCriterion("fmaterial_yield <", value, "fmaterialYield");
            return (Criteria) this;
        }

        public Criteria andFmaterialYieldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fmaterial_yield <=", value, "fmaterialYield");
            return (Criteria) this;
        }

        public Criteria andFmaterialYieldIn(List<BigDecimal> values) {
            addCriterion("fmaterial_yield in", values, "fmaterialYield");
            return (Criteria) this;
        }

        public Criteria andFmaterialYieldNotIn(List<BigDecimal> values) {
            addCriterion("fmaterial_yield not in", values, "fmaterialYield");
            return (Criteria) this;
        }

        public Criteria andFmaterialYieldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmaterial_yield between", value1, value2, "fmaterialYield");
            return (Criteria) this;
        }

        public Criteria andFmaterialYieldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmaterial_yield not between", value1, value2, "fmaterialYield");
            return (Criteria) this;
        }

        public Criteria andFmaterialAmountIsNull() {
            addCriterion("fmaterial_amount is null");
            return (Criteria) this;
        }

        public Criteria andFmaterialAmountIsNotNull() {
            addCriterion("fmaterial_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFmaterialAmountEqualTo(BigDecimal value) {
            addCriterion("fmaterial_amount =", value, "fmaterialAmount");
            return (Criteria) this;
        }

        public Criteria andFmaterialAmountNotEqualTo(BigDecimal value) {
            addCriterion("fmaterial_amount <>", value, "fmaterialAmount");
            return (Criteria) this;
        }

        public Criteria andFmaterialAmountGreaterThan(BigDecimal value) {
            addCriterion("fmaterial_amount >", value, "fmaterialAmount");
            return (Criteria) this;
        }

        public Criteria andFmaterialAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fmaterial_amount >=", value, "fmaterialAmount");
            return (Criteria) this;
        }

        public Criteria andFmaterialAmountLessThan(BigDecimal value) {
            addCriterion("fmaterial_amount <", value, "fmaterialAmount");
            return (Criteria) this;
        }

        public Criteria andFmaterialAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fmaterial_amount <=", value, "fmaterialAmount");
            return (Criteria) this;
        }

        public Criteria andFmaterialAmountIn(List<BigDecimal> values) {
            addCriterion("fmaterial_amount in", values, "fmaterialAmount");
            return (Criteria) this;
        }

        public Criteria andFmaterialAmountNotIn(List<BigDecimal> values) {
            addCriterion("fmaterial_amount not in", values, "fmaterialAmount");
            return (Criteria) this;
        }

        public Criteria andFmaterialAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmaterial_amount between", value1, value2, "fmaterialAmount");
            return (Criteria) this;
        }

        public Criteria andFmaterialAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmaterial_amount not between", value1, value2, "fmaterialAmount");
            return (Criteria) this;
        }

        public Criteria andFpackageYieldIsNull() {
            addCriterion("fpackage_yield is null");
            return (Criteria) this;
        }

        public Criteria andFpackageYieldIsNotNull() {
            addCriterion("fpackage_yield is not null");
            return (Criteria) this;
        }

        public Criteria andFpackageYieldEqualTo(BigDecimal value) {
            addCriterion("fpackage_yield =", value, "fpackageYield");
            return (Criteria) this;
        }

        public Criteria andFpackageYieldNotEqualTo(BigDecimal value) {
            addCriterion("fpackage_yield <>", value, "fpackageYield");
            return (Criteria) this;
        }

        public Criteria andFpackageYieldGreaterThan(BigDecimal value) {
            addCriterion("fpackage_yield >", value, "fpackageYield");
            return (Criteria) this;
        }

        public Criteria andFpackageYieldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fpackage_yield >=", value, "fpackageYield");
            return (Criteria) this;
        }

        public Criteria andFpackageYieldLessThan(BigDecimal value) {
            addCriterion("fpackage_yield <", value, "fpackageYield");
            return (Criteria) this;
        }

        public Criteria andFpackageYieldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fpackage_yield <=", value, "fpackageYield");
            return (Criteria) this;
        }

        public Criteria andFpackageYieldIn(List<BigDecimal> values) {
            addCriterion("fpackage_yield in", values, "fpackageYield");
            return (Criteria) this;
        }

        public Criteria andFpackageYieldNotIn(List<BigDecimal> values) {
            addCriterion("fpackage_yield not in", values, "fpackageYield");
            return (Criteria) this;
        }

        public Criteria andFpackageYieldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpackage_yield between", value1, value2, "fpackageYield");
            return (Criteria) this;
        }

        public Criteria andFpackageYieldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpackage_yield not between", value1, value2, "fpackageYield");
            return (Criteria) this;
        }

        public Criteria andFpackageAmountIsNull() {
            addCriterion("fpackage_amount is null");
            return (Criteria) this;
        }

        public Criteria andFpackageAmountIsNotNull() {
            addCriterion("fpackage_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFpackageAmountEqualTo(BigDecimal value) {
            addCriterion("fpackage_amount =", value, "fpackageAmount");
            return (Criteria) this;
        }

        public Criteria andFpackageAmountNotEqualTo(BigDecimal value) {
            addCriterion("fpackage_amount <>", value, "fpackageAmount");
            return (Criteria) this;
        }

        public Criteria andFpackageAmountGreaterThan(BigDecimal value) {
            addCriterion("fpackage_amount >", value, "fpackageAmount");
            return (Criteria) this;
        }

        public Criteria andFpackageAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fpackage_amount >=", value, "fpackageAmount");
            return (Criteria) this;
        }

        public Criteria andFpackageAmountLessThan(BigDecimal value) {
            addCriterion("fpackage_amount <", value, "fpackageAmount");
            return (Criteria) this;
        }

        public Criteria andFpackageAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fpackage_amount <=", value, "fpackageAmount");
            return (Criteria) this;
        }

        public Criteria andFpackageAmountIn(List<BigDecimal> values) {
            addCriterion("fpackage_amount in", values, "fpackageAmount");
            return (Criteria) this;
        }

        public Criteria andFpackageAmountNotIn(List<BigDecimal> values) {
            addCriterion("fpackage_amount not in", values, "fpackageAmount");
            return (Criteria) this;
        }

        public Criteria andFpackageAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpackage_amount between", value1, value2, "fpackageAmount");
            return (Criteria) this;
        }

        public Criteria andFpackageAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpackage_amount not between", value1, value2, "fpackageAmount");
            return (Criteria) this;
        }

        public Criteria andFlaborCostYieldIsNull() {
            addCriterion("flabor_cost_yield is null");
            return (Criteria) this;
        }

        public Criteria andFlaborCostYieldIsNotNull() {
            addCriterion("flabor_cost_yield is not null");
            return (Criteria) this;
        }

        public Criteria andFlaborCostYieldEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_yield =", value, "flaborCostYield");
            return (Criteria) this;
        }

        public Criteria andFlaborCostYieldNotEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_yield <>", value, "flaborCostYield");
            return (Criteria) this;
        }

        public Criteria andFlaborCostYieldGreaterThan(BigDecimal value) {
            addCriterion("flabor_cost_yield >", value, "flaborCostYield");
            return (Criteria) this;
        }

        public Criteria andFlaborCostYieldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_yield >=", value, "flaborCostYield");
            return (Criteria) this;
        }

        public Criteria andFlaborCostYieldLessThan(BigDecimal value) {
            addCriterion("flabor_cost_yield <", value, "flaborCostYield");
            return (Criteria) this;
        }

        public Criteria andFlaborCostYieldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_yield <=", value, "flaborCostYield");
            return (Criteria) this;
        }

        public Criteria andFlaborCostYieldIn(List<BigDecimal> values) {
            addCriterion("flabor_cost_yield in", values, "flaborCostYield");
            return (Criteria) this;
        }

        public Criteria andFlaborCostYieldNotIn(List<BigDecimal> values) {
            addCriterion("flabor_cost_yield not in", values, "flaborCostYield");
            return (Criteria) this;
        }

        public Criteria andFlaborCostYieldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flabor_cost_yield between", value1, value2, "flaborCostYield");
            return (Criteria) this;
        }

        public Criteria andFlaborCostYieldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flabor_cost_yield not between", value1, value2, "flaborCostYield");
            return (Criteria) this;
        }

        public Criteria andFlaborCostAmountIsNull() {
            addCriterion("flabor_cost_amount is null");
            return (Criteria) this;
        }

        public Criteria andFlaborCostAmountIsNotNull() {
            addCriterion("flabor_cost_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFlaborCostAmountEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_amount =", value, "flaborCostAmount");
            return (Criteria) this;
        }

        public Criteria andFlaborCostAmountNotEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_amount <>", value, "flaborCostAmount");
            return (Criteria) this;
        }

        public Criteria andFlaborCostAmountGreaterThan(BigDecimal value) {
            addCriterion("flabor_cost_amount >", value, "flaborCostAmount");
            return (Criteria) this;
        }

        public Criteria andFlaborCostAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_amount >=", value, "flaborCostAmount");
            return (Criteria) this;
        }

        public Criteria andFlaborCostAmountLessThan(BigDecimal value) {
            addCriterion("flabor_cost_amount <", value, "flaborCostAmount");
            return (Criteria) this;
        }

        public Criteria andFlaborCostAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("flabor_cost_amount <=", value, "flaborCostAmount");
            return (Criteria) this;
        }

        public Criteria andFlaborCostAmountIn(List<BigDecimal> values) {
            addCriterion("flabor_cost_amount in", values, "flaborCostAmount");
            return (Criteria) this;
        }

        public Criteria andFlaborCostAmountNotIn(List<BigDecimal> values) {
            addCriterion("flabor_cost_amount not in", values, "flaborCostAmount");
            return (Criteria) this;
        }

        public Criteria andFlaborCostAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flabor_cost_amount between", value1, value2, "flaborCostAmount");
            return (Criteria) this;
        }

        public Criteria andFlaborCostAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flabor_cost_amount not between", value1, value2, "flaborCostAmount");
            return (Criteria) this;
        }

        public Criteria andFpowerCostYieldIsNull() {
            addCriterion("fpower_cost_yield is null");
            return (Criteria) this;
        }

        public Criteria andFpowerCostYieldIsNotNull() {
            addCriterion("fpower_cost_yield is not null");
            return (Criteria) this;
        }

        public Criteria andFpowerCostYieldEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_yield =", value, "fpowerCostYield");
            return (Criteria) this;
        }

        public Criteria andFpowerCostYieldNotEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_yield <>", value, "fpowerCostYield");
            return (Criteria) this;
        }

        public Criteria andFpowerCostYieldGreaterThan(BigDecimal value) {
            addCriterion("fpower_cost_yield >", value, "fpowerCostYield");
            return (Criteria) this;
        }

        public Criteria andFpowerCostYieldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_yield >=", value, "fpowerCostYield");
            return (Criteria) this;
        }

        public Criteria andFpowerCostYieldLessThan(BigDecimal value) {
            addCriterion("fpower_cost_yield <", value, "fpowerCostYield");
            return (Criteria) this;
        }

        public Criteria andFpowerCostYieldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_yield <=", value, "fpowerCostYield");
            return (Criteria) this;
        }

        public Criteria andFpowerCostYieldIn(List<BigDecimal> values) {
            addCriterion("fpower_cost_yield in", values, "fpowerCostYield");
            return (Criteria) this;
        }

        public Criteria andFpowerCostYieldNotIn(List<BigDecimal> values) {
            addCriterion("fpower_cost_yield not in", values, "fpowerCostYield");
            return (Criteria) this;
        }

        public Criteria andFpowerCostYieldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpower_cost_yield between", value1, value2, "fpowerCostYield");
            return (Criteria) this;
        }

        public Criteria andFpowerCostYieldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpower_cost_yield not between", value1, value2, "fpowerCostYield");
            return (Criteria) this;
        }

        public Criteria andFpowerCostAmountIsNull() {
            addCriterion("fpower_cost_amount is null");
            return (Criteria) this;
        }

        public Criteria andFpowerCostAmountIsNotNull() {
            addCriterion("fpower_cost_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFpowerCostAmountEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_amount =", value, "fpowerCostAmount");
            return (Criteria) this;
        }

        public Criteria andFpowerCostAmountNotEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_amount <>", value, "fpowerCostAmount");
            return (Criteria) this;
        }

        public Criteria andFpowerCostAmountGreaterThan(BigDecimal value) {
            addCriterion("fpower_cost_amount >", value, "fpowerCostAmount");
            return (Criteria) this;
        }

        public Criteria andFpowerCostAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_amount >=", value, "fpowerCostAmount");
            return (Criteria) this;
        }

        public Criteria andFpowerCostAmountLessThan(BigDecimal value) {
            addCriterion("fpower_cost_amount <", value, "fpowerCostAmount");
            return (Criteria) this;
        }

        public Criteria andFpowerCostAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fpower_cost_amount <=", value, "fpowerCostAmount");
            return (Criteria) this;
        }

        public Criteria andFpowerCostAmountIn(List<BigDecimal> values) {
            addCriterion("fpower_cost_amount in", values, "fpowerCostAmount");
            return (Criteria) this;
        }

        public Criteria andFpowerCostAmountNotIn(List<BigDecimal> values) {
            addCriterion("fpower_cost_amount not in", values, "fpowerCostAmount");
            return (Criteria) this;
        }

        public Criteria andFpowerCostAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpower_cost_amount between", value1, value2, "fpowerCostAmount");
            return (Criteria) this;
        }

        public Criteria andFpowerCostAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fpower_cost_amount not between", value1, value2, "fpowerCostAmount");
            return (Criteria) this;
        }

        public Criteria andFmanufCostYieldIsNull() {
            addCriterion("fmanuf_cost_yield is null");
            return (Criteria) this;
        }

        public Criteria andFmanufCostYieldIsNotNull() {
            addCriterion("fmanuf_cost_yield is not null");
            return (Criteria) this;
        }

        public Criteria andFmanufCostYieldEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_yield =", value, "fmanufCostYield");
            return (Criteria) this;
        }

        public Criteria andFmanufCostYieldNotEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_yield <>", value, "fmanufCostYield");
            return (Criteria) this;
        }

        public Criteria andFmanufCostYieldGreaterThan(BigDecimal value) {
            addCriterion("fmanuf_cost_yield >", value, "fmanufCostYield");
            return (Criteria) this;
        }

        public Criteria andFmanufCostYieldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_yield >=", value, "fmanufCostYield");
            return (Criteria) this;
        }

        public Criteria andFmanufCostYieldLessThan(BigDecimal value) {
            addCriterion("fmanuf_cost_yield <", value, "fmanufCostYield");
            return (Criteria) this;
        }

        public Criteria andFmanufCostYieldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_yield <=", value, "fmanufCostYield");
            return (Criteria) this;
        }

        public Criteria andFmanufCostYieldIn(List<BigDecimal> values) {
            addCriterion("fmanuf_cost_yield in", values, "fmanufCostYield");
            return (Criteria) this;
        }

        public Criteria andFmanufCostYieldNotIn(List<BigDecimal> values) {
            addCriterion("fmanuf_cost_yield not in", values, "fmanufCostYield");
            return (Criteria) this;
        }

        public Criteria andFmanufCostYieldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmanuf_cost_yield between", value1, value2, "fmanufCostYield");
            return (Criteria) this;
        }

        public Criteria andFmanufCostYieldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmanuf_cost_yield not between", value1, value2, "fmanufCostYield");
            return (Criteria) this;
        }

        public Criteria andFmanufCostAmountIsNull() {
            addCriterion("fmanuf_cost_amount is null");
            return (Criteria) this;
        }

        public Criteria andFmanufCostAmountIsNotNull() {
            addCriterion("fmanuf_cost_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFmanufCostAmountEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_amount =", value, "fmanufCostAmount");
            return (Criteria) this;
        }

        public Criteria andFmanufCostAmountNotEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_amount <>", value, "fmanufCostAmount");
            return (Criteria) this;
        }

        public Criteria andFmanufCostAmountGreaterThan(BigDecimal value) {
            addCriterion("fmanuf_cost_amount >", value, "fmanufCostAmount");
            return (Criteria) this;
        }

        public Criteria andFmanufCostAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_amount >=", value, "fmanufCostAmount");
            return (Criteria) this;
        }

        public Criteria andFmanufCostAmountLessThan(BigDecimal value) {
            addCriterion("fmanuf_cost_amount <", value, "fmanufCostAmount");
            return (Criteria) this;
        }

        public Criteria andFmanufCostAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fmanuf_cost_amount <=", value, "fmanufCostAmount");
            return (Criteria) this;
        }

        public Criteria andFmanufCostAmountIn(List<BigDecimal> values) {
            addCriterion("fmanuf_cost_amount in", values, "fmanufCostAmount");
            return (Criteria) this;
        }

        public Criteria andFmanufCostAmountNotIn(List<BigDecimal> values) {
            addCriterion("fmanuf_cost_amount not in", values, "fmanufCostAmount");
            return (Criteria) this;
        }

        public Criteria andFmanufCostAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmanuf_cost_amount between", value1, value2, "fmanufCostAmount");
            return (Criteria) this;
        }

        public Criteria andFmanufCostAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fmanuf_cost_amount not between", value1, value2, "fmanufCostAmount");
            return (Criteria) this;
        }

        public Criteria andFproductionCostYieldIsNull() {
            addCriterion("fproduction_cost_yield is null");
            return (Criteria) this;
        }

        public Criteria andFproductionCostYieldIsNotNull() {
            addCriterion("fproduction_cost_yield is not null");
            return (Criteria) this;
        }

        public Criteria andFproductionCostYieldEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_yield =", value, "fproductionCostYield");
            return (Criteria) this;
        }

        public Criteria andFproductionCostYieldNotEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_yield <>", value, "fproductionCostYield");
            return (Criteria) this;
        }

        public Criteria andFproductionCostYieldGreaterThan(BigDecimal value) {
            addCriterion("fproduction_cost_yield >", value, "fproductionCostYield");
            return (Criteria) this;
        }

        public Criteria andFproductionCostYieldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_yield >=", value, "fproductionCostYield");
            return (Criteria) this;
        }

        public Criteria andFproductionCostYieldLessThan(BigDecimal value) {
            addCriterion("fproduction_cost_yield <", value, "fproductionCostYield");
            return (Criteria) this;
        }

        public Criteria andFproductionCostYieldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_yield <=", value, "fproductionCostYield");
            return (Criteria) this;
        }

        public Criteria andFproductionCostYieldIn(List<BigDecimal> values) {
            addCriterion("fproduction_cost_yield in", values, "fproductionCostYield");
            return (Criteria) this;
        }

        public Criteria andFproductionCostYieldNotIn(List<BigDecimal> values) {
            addCriterion("fproduction_cost_yield not in", values, "fproductionCostYield");
            return (Criteria) this;
        }

        public Criteria andFproductionCostYieldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fproduction_cost_yield between", value1, value2, "fproductionCostYield");
            return (Criteria) this;
        }

        public Criteria andFproductionCostYieldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fproduction_cost_yield not between", value1, value2, "fproductionCostYield");
            return (Criteria) this;
        }

        public Criteria andFproductionCostAmountIsNull() {
            addCriterion("fproduction_cost_amount is null");
            return (Criteria) this;
        }

        public Criteria andFproductionCostAmountIsNotNull() {
            addCriterion("fproduction_cost_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFproductionCostAmountEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_amount =", value, "fproductionCostAmount");
            return (Criteria) this;
        }

        public Criteria andFproductionCostAmountNotEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_amount <>", value, "fproductionCostAmount");
            return (Criteria) this;
        }

        public Criteria andFproductionCostAmountGreaterThan(BigDecimal value) {
            addCriterion("fproduction_cost_amount >", value, "fproductionCostAmount");
            return (Criteria) this;
        }

        public Criteria andFproductionCostAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_amount >=", value, "fproductionCostAmount");
            return (Criteria) this;
        }

        public Criteria andFproductionCostAmountLessThan(BigDecimal value) {
            addCriterion("fproduction_cost_amount <", value, "fproductionCostAmount");
            return (Criteria) this;
        }

        public Criteria andFproductionCostAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fproduction_cost_amount <=", value, "fproductionCostAmount");
            return (Criteria) this;
        }

        public Criteria andFproductionCostAmountIn(List<BigDecimal> values) {
            addCriterion("fproduction_cost_amount in", values, "fproductionCostAmount");
            return (Criteria) this;
        }

        public Criteria andFproductionCostAmountNotIn(List<BigDecimal> values) {
            addCriterion("fproduction_cost_amount not in", values, "fproductionCostAmount");
            return (Criteria) this;
        }

        public Criteria andFproductionCostAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fproduction_cost_amount between", value1, value2, "fproductionCostAmount");
            return (Criteria) this;
        }

        public Criteria andFproductionCostAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fproduction_cost_amount not between", value1, value2, "fproductionCostAmount");
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