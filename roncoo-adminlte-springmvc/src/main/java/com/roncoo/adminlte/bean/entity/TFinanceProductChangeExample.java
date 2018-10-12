package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceProductChangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceProductChangeExample() {
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

        public Criteria andFproductNameIsNull() {
            addCriterion("fproduct_name is null");
            return (Criteria) this;
        }

        public Criteria andFproductNameIsNotNull() {
            addCriterion("fproduct_name is not null");
            return (Criteria) this;
        }

        public Criteria andFproductNameEqualTo(String value) {
            addCriterion("fproduct_name =", value, "fproductName");
            return (Criteria) this;
        }

        public Criteria andFproductNameNotEqualTo(String value) {
            addCriterion("fproduct_name <>", value, "fproductName");
            return (Criteria) this;
        }

        public Criteria andFproductNameGreaterThan(String value) {
            addCriterion("fproduct_name >", value, "fproductName");
            return (Criteria) this;
        }

        public Criteria andFproductNameGreaterThanOrEqualTo(String value) {
            addCriterion("fproduct_name >=", value, "fproductName");
            return (Criteria) this;
        }

        public Criteria andFproductNameLessThan(String value) {
            addCriterion("fproduct_name <", value, "fproductName");
            return (Criteria) this;
        }

        public Criteria andFproductNameLessThanOrEqualTo(String value) {
            addCriterion("fproduct_name <=", value, "fproductName");
            return (Criteria) this;
        }

        public Criteria andFproductNameLike(String value) {
            addCriterion("fproduct_name like", value, "fproductName");
            return (Criteria) this;
        }

        public Criteria andFproductNameNotLike(String value) {
            addCriterion("fproduct_name not like", value, "fproductName");
            return (Criteria) this;
        }

        public Criteria andFproductNameIn(List<String> values) {
            addCriterion("fproduct_name in", values, "fproductName");
            return (Criteria) this;
        }

        public Criteria andFproductNameNotIn(List<String> values) {
            addCriterion("fproduct_name not in", values, "fproductName");
            return (Criteria) this;
        }

        public Criteria andFproductNameBetween(String value1, String value2) {
            addCriterion("fproduct_name between", value1, value2, "fproductName");
            return (Criteria) this;
        }

        public Criteria andFproductNameNotBetween(String value1, String value2) {
            addCriterion("fproduct_name not between", value1, value2, "fproductName");
            return (Criteria) this;
        }

        public Criteria andFquantityIsNull() {
            addCriterion("fquantity is null");
            return (Criteria) this;
        }

        public Criteria andFquantityIsNotNull() {
            addCriterion("fquantity is not null");
            return (Criteria) this;
        }

        public Criteria andFquantityEqualTo(BigDecimal value) {
            addCriterion("fquantity =", value, "fquantity");
            return (Criteria) this;
        }

        public Criteria andFquantityNotEqualTo(BigDecimal value) {
            addCriterion("fquantity <>", value, "fquantity");
            return (Criteria) this;
        }

        public Criteria andFquantityGreaterThan(BigDecimal value) {
            addCriterion("fquantity >", value, "fquantity");
            return (Criteria) this;
        }

        public Criteria andFquantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fquantity >=", value, "fquantity");
            return (Criteria) this;
        }

        public Criteria andFquantityLessThan(BigDecimal value) {
            addCriterion("fquantity <", value, "fquantity");
            return (Criteria) this;
        }

        public Criteria andFquantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fquantity <=", value, "fquantity");
            return (Criteria) this;
        }

        public Criteria andFquantityIn(List<BigDecimal> values) {
            addCriterion("fquantity in", values, "fquantity");
            return (Criteria) this;
        }

        public Criteria andFquantityNotIn(List<BigDecimal> values) {
            addCriterion("fquantity not in", values, "fquantity");
            return (Criteria) this;
        }

        public Criteria andFquantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fquantity between", value1, value2, "fquantity");
            return (Criteria) this;
        }

        public Criteria andFquantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fquantity not between", value1, value2, "fquantity");
            return (Criteria) this;
        }

        public Criteria andFamountIsNull() {
            addCriterion("famount is null");
            return (Criteria) this;
        }

        public Criteria andFamountIsNotNull() {
            addCriterion("famount is not null");
            return (Criteria) this;
        }

        public Criteria andFamountEqualTo(BigDecimal value) {
            addCriterion("famount =", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountNotEqualTo(BigDecimal value) {
            addCriterion("famount <>", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountGreaterThan(BigDecimal value) {
            addCriterion("famount >", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("famount >=", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountLessThan(BigDecimal value) {
            addCriterion("famount <", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("famount <=", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountIn(List<BigDecimal> values) {
            addCriterion("famount in", values, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountNotIn(List<BigDecimal> values) {
            addCriterion("famount not in", values, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("famount between", value1, value2, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("famount not between", value1, value2, "famount");
            return (Criteria) this;
        }

        public Criteria andFthisYieldIsNull() {
            addCriterion("fthis_yield is null");
            return (Criteria) this;
        }

        public Criteria andFthisYieldIsNotNull() {
            addCriterion("fthis_yield is not null");
            return (Criteria) this;
        }

        public Criteria andFthisYieldEqualTo(BigDecimal value) {
            addCriterion("fthis_yield =", value, "fthisYield");
            return (Criteria) this;
        }

        public Criteria andFthisYieldNotEqualTo(BigDecimal value) {
            addCriterion("fthis_yield <>", value, "fthisYield");
            return (Criteria) this;
        }

        public Criteria andFthisYieldGreaterThan(BigDecimal value) {
            addCriterion("fthis_yield >", value, "fthisYield");
            return (Criteria) this;
        }

        public Criteria andFthisYieldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_yield >=", value, "fthisYield");
            return (Criteria) this;
        }

        public Criteria andFthisYieldLessThan(BigDecimal value) {
            addCriterion("fthis_yield <", value, "fthisYield");
            return (Criteria) this;
        }

        public Criteria andFthisYieldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_yield <=", value, "fthisYield");
            return (Criteria) this;
        }

        public Criteria andFthisYieldIn(List<BigDecimal> values) {
            addCriterion("fthis_yield in", values, "fthisYield");
            return (Criteria) this;
        }

        public Criteria andFthisYieldNotIn(List<BigDecimal> values) {
            addCriterion("fthis_yield not in", values, "fthisYield");
            return (Criteria) this;
        }

        public Criteria andFthisYieldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_yield between", value1, value2, "fthisYield");
            return (Criteria) this;
        }

        public Criteria andFthisYieldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_yield not between", value1, value2, "fthisYield");
            return (Criteria) this;
        }

        public Criteria andFtotalYieldIsNull() {
            addCriterion("ftotal_yield is null");
            return (Criteria) this;
        }

        public Criteria andFtotalYieldIsNotNull() {
            addCriterion("ftotal_yield is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalYieldEqualTo(BigDecimal value) {
            addCriterion("ftotal_yield =", value, "ftotalYield");
            return (Criteria) this;
        }

        public Criteria andFtotalYieldNotEqualTo(BigDecimal value) {
            addCriterion("ftotal_yield <>", value, "ftotalYield");
            return (Criteria) this;
        }

        public Criteria andFtotalYieldGreaterThan(BigDecimal value) {
            addCriterion("ftotal_yield >", value, "ftotalYield");
            return (Criteria) this;
        }

        public Criteria andFtotalYieldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_yield >=", value, "ftotalYield");
            return (Criteria) this;
        }

        public Criteria andFtotalYieldLessThan(BigDecimal value) {
            addCriterion("ftotal_yield <", value, "ftotalYield");
            return (Criteria) this;
        }

        public Criteria andFtotalYieldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_yield <=", value, "ftotalYield");
            return (Criteria) this;
        }

        public Criteria andFtotalYieldIn(List<BigDecimal> values) {
            addCriterion("ftotal_yield in", values, "ftotalYield");
            return (Criteria) this;
        }

        public Criteria andFtotalYieldNotIn(List<BigDecimal> values) {
            addCriterion("ftotal_yield not in", values, "ftotalYield");
            return (Criteria) this;
        }

        public Criteria andFtotalYieldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_yield between", value1, value2, "ftotalYield");
            return (Criteria) this;
        }

        public Criteria andFtotalYieldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_yield not between", value1, value2, "ftotalYield");
            return (Criteria) this;
        }

        public Criteria andFthisCostIsNull() {
            addCriterion("fthis_cost is null");
            return (Criteria) this;
        }

        public Criteria andFthisCostIsNotNull() {
            addCriterion("fthis_cost is not null");
            return (Criteria) this;
        }

        public Criteria andFthisCostEqualTo(BigDecimal value) {
            addCriterion("fthis_cost =", value, "fthisCost");
            return (Criteria) this;
        }

        public Criteria andFthisCostNotEqualTo(BigDecimal value) {
            addCriterion("fthis_cost <>", value, "fthisCost");
            return (Criteria) this;
        }

        public Criteria andFthisCostGreaterThan(BigDecimal value) {
            addCriterion("fthis_cost >", value, "fthisCost");
            return (Criteria) this;
        }

        public Criteria andFthisCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_cost >=", value, "fthisCost");
            return (Criteria) this;
        }

        public Criteria andFthisCostLessThan(BigDecimal value) {
            addCriterion("fthis_cost <", value, "fthisCost");
            return (Criteria) this;
        }

        public Criteria andFthisCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_cost <=", value, "fthisCost");
            return (Criteria) this;
        }

        public Criteria andFthisCostIn(List<BigDecimal> values) {
            addCriterion("fthis_cost in", values, "fthisCost");
            return (Criteria) this;
        }

        public Criteria andFthisCostNotIn(List<BigDecimal> values) {
            addCriterion("fthis_cost not in", values, "fthisCost");
            return (Criteria) this;
        }

        public Criteria andFthisCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_cost between", value1, value2, "fthisCost");
            return (Criteria) this;
        }

        public Criteria andFthisCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_cost not between", value1, value2, "fthisCost");
            return (Criteria) this;
        }

        public Criteria andFtotalCostIsNull() {
            addCriterion("ftotal_cost is null");
            return (Criteria) this;
        }

        public Criteria andFtotalCostIsNotNull() {
            addCriterion("ftotal_cost is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalCostEqualTo(BigDecimal value) {
            addCriterion("ftotal_cost =", value, "ftotalCost");
            return (Criteria) this;
        }

        public Criteria andFtotalCostNotEqualTo(BigDecimal value) {
            addCriterion("ftotal_cost <>", value, "ftotalCost");
            return (Criteria) this;
        }

        public Criteria andFtotalCostGreaterThan(BigDecimal value) {
            addCriterion("ftotal_cost >", value, "ftotalCost");
            return (Criteria) this;
        }

        public Criteria andFtotalCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_cost >=", value, "ftotalCost");
            return (Criteria) this;
        }

        public Criteria andFtotalCostLessThan(BigDecimal value) {
            addCriterion("ftotal_cost <", value, "ftotalCost");
            return (Criteria) this;
        }

        public Criteria andFtotalCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_cost <=", value, "ftotalCost");
            return (Criteria) this;
        }

        public Criteria andFtotalCostIn(List<BigDecimal> values) {
            addCriterion("ftotal_cost in", values, "ftotalCost");
            return (Criteria) this;
        }

        public Criteria andFtotalCostNotIn(List<BigDecimal> values) {
            addCriterion("ftotal_cost not in", values, "ftotalCost");
            return (Criteria) this;
        }

        public Criteria andFtotalCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_cost between", value1, value2, "ftotalCost");
            return (Criteria) this;
        }

        public Criteria andFtotalCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_cost not between", value1, value2, "ftotalCost");
            return (Criteria) this;
        }

        public Criteria andFthisSalesIsNull() {
            addCriterion("fthis_sales is null");
            return (Criteria) this;
        }

        public Criteria andFthisSalesIsNotNull() {
            addCriterion("fthis_sales is not null");
            return (Criteria) this;
        }

        public Criteria andFthisSalesEqualTo(BigDecimal value) {
            addCriterion("fthis_sales =", value, "fthisSales");
            return (Criteria) this;
        }

        public Criteria andFthisSalesNotEqualTo(BigDecimal value) {
            addCriterion("fthis_sales <>", value, "fthisSales");
            return (Criteria) this;
        }

        public Criteria andFthisSalesGreaterThan(BigDecimal value) {
            addCriterion("fthis_sales >", value, "fthisSales");
            return (Criteria) this;
        }

        public Criteria andFthisSalesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_sales >=", value, "fthisSales");
            return (Criteria) this;
        }

        public Criteria andFthisSalesLessThan(BigDecimal value) {
            addCriterion("fthis_sales <", value, "fthisSales");
            return (Criteria) this;
        }

        public Criteria andFthisSalesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_sales <=", value, "fthisSales");
            return (Criteria) this;
        }

        public Criteria andFthisSalesIn(List<BigDecimal> values) {
            addCriterion("fthis_sales in", values, "fthisSales");
            return (Criteria) this;
        }

        public Criteria andFthisSalesNotIn(List<BigDecimal> values) {
            addCriterion("fthis_sales not in", values, "fthisSales");
            return (Criteria) this;
        }

        public Criteria andFthisSalesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_sales between", value1, value2, "fthisSales");
            return (Criteria) this;
        }

        public Criteria andFthisSalesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_sales not between", value1, value2, "fthisSales");
            return (Criteria) this;
        }

        public Criteria andFtotalSalesIsNull() {
            addCriterion("ftotal_sales is null");
            return (Criteria) this;
        }

        public Criteria andFtotalSalesIsNotNull() {
            addCriterion("ftotal_sales is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalSalesEqualTo(BigDecimal value) {
            addCriterion("ftotal_sales =", value, "ftotalSales");
            return (Criteria) this;
        }

        public Criteria andFtotalSalesNotEqualTo(BigDecimal value) {
            addCriterion("ftotal_sales <>", value, "ftotalSales");
            return (Criteria) this;
        }

        public Criteria andFtotalSalesGreaterThan(BigDecimal value) {
            addCriterion("ftotal_sales >", value, "ftotalSales");
            return (Criteria) this;
        }

        public Criteria andFtotalSalesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_sales >=", value, "ftotalSales");
            return (Criteria) this;
        }

        public Criteria andFtotalSalesLessThan(BigDecimal value) {
            addCriterion("ftotal_sales <", value, "ftotalSales");
            return (Criteria) this;
        }

        public Criteria andFtotalSalesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_sales <=", value, "ftotalSales");
            return (Criteria) this;
        }

        public Criteria andFtotalSalesIn(List<BigDecimal> values) {
            addCriterion("ftotal_sales in", values, "ftotalSales");
            return (Criteria) this;
        }

        public Criteria andFtotalSalesNotIn(List<BigDecimal> values) {
            addCriterion("ftotal_sales not in", values, "ftotalSales");
            return (Criteria) this;
        }

        public Criteria andFtotalSalesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_sales between", value1, value2, "ftotalSales");
            return (Criteria) this;
        }

        public Criteria andFtotalSalesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_sales not between", value1, value2, "ftotalSales");
            return (Criteria) this;
        }

        public Criteria andFthisAmountIsNull() {
            addCriterion("fthis_amount is null");
            return (Criteria) this;
        }

        public Criteria andFthisAmountIsNotNull() {
            addCriterion("fthis_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFthisAmountEqualTo(BigDecimal value) {
            addCriterion("fthis_amount =", value, "fthisAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAmountNotEqualTo(BigDecimal value) {
            addCriterion("fthis_amount <>", value, "fthisAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAmountGreaterThan(BigDecimal value) {
            addCriterion("fthis_amount >", value, "fthisAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_amount >=", value, "fthisAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAmountLessThan(BigDecimal value) {
            addCriterion("fthis_amount <", value, "fthisAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_amount <=", value, "fthisAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAmountIn(List<BigDecimal> values) {
            addCriterion("fthis_amount in", values, "fthisAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAmountNotIn(List<BigDecimal> values) {
            addCriterion("fthis_amount not in", values, "fthisAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_amount between", value1, value2, "fthisAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_amount not between", value1, value2, "fthisAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAmountIsNull() {
            addCriterion("ftotal_amount is null");
            return (Criteria) this;
        }

        public Criteria andFtotalAmountIsNotNull() {
            addCriterion("ftotal_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalAmountEqualTo(BigDecimal value) {
            addCriterion("ftotal_amount =", value, "ftotalAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("ftotal_amount <>", value, "ftotalAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAmountGreaterThan(BigDecimal value) {
            addCriterion("ftotal_amount >", value, "ftotalAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_amount >=", value, "ftotalAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAmountLessThan(BigDecimal value) {
            addCriterion("ftotal_amount <", value, "ftotalAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_amount <=", value, "ftotalAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAmountIn(List<BigDecimal> values) {
            addCriterion("ftotal_amount in", values, "ftotalAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("ftotal_amount not in", values, "ftotalAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_amount between", value1, value2, "ftotalAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_amount not between", value1, value2, "ftotalAmount");
            return (Criteria) this;
        }

        public Criteria andFotherQuantityIsNull() {
            addCriterion("fother_quantity is null");
            return (Criteria) this;
        }

        public Criteria andFotherQuantityIsNotNull() {
            addCriterion("fother_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andFotherQuantityEqualTo(BigDecimal value) {
            addCriterion("fother_quantity =", value, "fotherQuantity");
            return (Criteria) this;
        }

        public Criteria andFotherQuantityNotEqualTo(BigDecimal value) {
            addCriterion("fother_quantity <>", value, "fotherQuantity");
            return (Criteria) this;
        }

        public Criteria andFotherQuantityGreaterThan(BigDecimal value) {
            addCriterion("fother_quantity >", value, "fotherQuantity");
            return (Criteria) this;
        }

        public Criteria andFotherQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fother_quantity >=", value, "fotherQuantity");
            return (Criteria) this;
        }

        public Criteria andFotherQuantityLessThan(BigDecimal value) {
            addCriterion("fother_quantity <", value, "fotherQuantity");
            return (Criteria) this;
        }

        public Criteria andFotherQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fother_quantity <=", value, "fotherQuantity");
            return (Criteria) this;
        }

        public Criteria andFotherQuantityIn(List<BigDecimal> values) {
            addCriterion("fother_quantity in", values, "fotherQuantity");
            return (Criteria) this;
        }

        public Criteria andFotherQuantityNotIn(List<BigDecimal> values) {
            addCriterion("fother_quantity not in", values, "fotherQuantity");
            return (Criteria) this;
        }

        public Criteria andFotherQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fother_quantity between", value1, value2, "fotherQuantity");
            return (Criteria) this;
        }

        public Criteria andFotherQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fother_quantity not between", value1, value2, "fotherQuantity");
            return (Criteria) this;
        }

        public Criteria andFotherAmountIsNull() {
            addCriterion("fother_amount is null");
            return (Criteria) this;
        }

        public Criteria andFotherAmountIsNotNull() {
            addCriterion("fother_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFotherAmountEqualTo(BigDecimal value) {
            addCriterion("fother_amount =", value, "fotherAmount");
            return (Criteria) this;
        }

        public Criteria andFotherAmountNotEqualTo(BigDecimal value) {
            addCriterion("fother_amount <>", value, "fotherAmount");
            return (Criteria) this;
        }

        public Criteria andFotherAmountGreaterThan(BigDecimal value) {
            addCriterion("fother_amount >", value, "fotherAmount");
            return (Criteria) this;
        }

        public Criteria andFotherAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fother_amount >=", value, "fotherAmount");
            return (Criteria) this;
        }

        public Criteria andFotherAmountLessThan(BigDecimal value) {
            addCriterion("fother_amount <", value, "fotherAmount");
            return (Criteria) this;
        }

        public Criteria andFotherAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fother_amount <=", value, "fotherAmount");
            return (Criteria) this;
        }

        public Criteria andFotherAmountIn(List<BigDecimal> values) {
            addCriterion("fother_amount in", values, "fotherAmount");
            return (Criteria) this;
        }

        public Criteria andFotherAmountNotIn(List<BigDecimal> values) {
            addCriterion("fother_amount not in", values, "fotherAmount");
            return (Criteria) this;
        }

        public Criteria andFotherAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fother_amount between", value1, value2, "fotherAmount");
            return (Criteria) this;
        }

        public Criteria andFotherAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fother_amount not between", value1, value2, "fotherAmount");
            return (Criteria) this;
        }

        public Criteria andFlastQuantityIsNull() {
            addCriterion("flast_quantity is null");
            return (Criteria) this;
        }

        public Criteria andFlastQuantityIsNotNull() {
            addCriterion("flast_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andFlastQuantityEqualTo(BigDecimal value) {
            addCriterion("flast_quantity =", value, "flastQuantity");
            return (Criteria) this;
        }

        public Criteria andFlastQuantityNotEqualTo(BigDecimal value) {
            addCriterion("flast_quantity <>", value, "flastQuantity");
            return (Criteria) this;
        }

        public Criteria andFlastQuantityGreaterThan(BigDecimal value) {
            addCriterion("flast_quantity >", value, "flastQuantity");
            return (Criteria) this;
        }

        public Criteria andFlastQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("flast_quantity >=", value, "flastQuantity");
            return (Criteria) this;
        }

        public Criteria andFlastQuantityLessThan(BigDecimal value) {
            addCriterion("flast_quantity <", value, "flastQuantity");
            return (Criteria) this;
        }

        public Criteria andFlastQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("flast_quantity <=", value, "flastQuantity");
            return (Criteria) this;
        }

        public Criteria andFlastQuantityIn(List<BigDecimal> values) {
            addCriterion("flast_quantity in", values, "flastQuantity");
            return (Criteria) this;
        }

        public Criteria andFlastQuantityNotIn(List<BigDecimal> values) {
            addCriterion("flast_quantity not in", values, "flastQuantity");
            return (Criteria) this;
        }

        public Criteria andFlastQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flast_quantity between", value1, value2, "flastQuantity");
            return (Criteria) this;
        }

        public Criteria andFlastQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flast_quantity not between", value1, value2, "flastQuantity");
            return (Criteria) this;
        }

        public Criteria andFlastAmountIsNull() {
            addCriterion("flast_amount is null");
            return (Criteria) this;
        }

        public Criteria andFlastAmountIsNotNull() {
            addCriterion("flast_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFlastAmountEqualTo(BigDecimal value) {
            addCriterion("flast_amount =", value, "flastAmount");
            return (Criteria) this;
        }

        public Criteria andFlastAmountNotEqualTo(BigDecimal value) {
            addCriterion("flast_amount <>", value, "flastAmount");
            return (Criteria) this;
        }

        public Criteria andFlastAmountGreaterThan(BigDecimal value) {
            addCriterion("flast_amount >", value, "flastAmount");
            return (Criteria) this;
        }

        public Criteria andFlastAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("flast_amount >=", value, "flastAmount");
            return (Criteria) this;
        }

        public Criteria andFlastAmountLessThan(BigDecimal value) {
            addCriterion("flast_amount <", value, "flastAmount");
            return (Criteria) this;
        }

        public Criteria andFlastAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("flast_amount <=", value, "flastAmount");
            return (Criteria) this;
        }

        public Criteria andFlastAmountIn(List<BigDecimal> values) {
            addCriterion("flast_amount in", values, "flastAmount");
            return (Criteria) this;
        }

        public Criteria andFlastAmountNotIn(List<BigDecimal> values) {
            addCriterion("flast_amount not in", values, "flastAmount");
            return (Criteria) this;
        }

        public Criteria andFlastAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flast_amount between", value1, value2, "flastAmount");
            return (Criteria) this;
        }

        public Criteria andFlastAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flast_amount not between", value1, value2, "flastAmount");
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