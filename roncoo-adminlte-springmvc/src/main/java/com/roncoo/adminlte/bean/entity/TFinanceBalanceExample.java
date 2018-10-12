package com.roncoo.adminlte.bean.entity;

import java.util.ArrayList;
import java.util.List;

public class TFinanceBalanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceBalanceExample() {
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

        public Criteria andFrowIndex1IsNull() {
            addCriterion("frow_index1 is null");
            return (Criteria) this;
        }

        public Criteria andFrowIndex1IsNotNull() {
            addCriterion("frow_index1 is not null");
            return (Criteria) this;
        }

        public Criteria andFrowIndex1EqualTo(Integer value) {
            addCriterion("frow_index1 =", value, "frowIndex1");
            return (Criteria) this;
        }

        public Criteria andFrowIndex1NotEqualTo(Integer value) {
            addCriterion("frow_index1 <>", value, "frowIndex1");
            return (Criteria) this;
        }

        public Criteria andFrowIndex1GreaterThan(Integer value) {
            addCriterion("frow_index1 >", value, "frowIndex1");
            return (Criteria) this;
        }

        public Criteria andFrowIndex1GreaterThanOrEqualTo(Integer value) {
            addCriterion("frow_index1 >=", value, "frowIndex1");
            return (Criteria) this;
        }

        public Criteria andFrowIndex1LessThan(Integer value) {
            addCriterion("frow_index1 <", value, "frowIndex1");
            return (Criteria) this;
        }

        public Criteria andFrowIndex1LessThanOrEqualTo(Integer value) {
            addCriterion("frow_index1 <=", value, "frowIndex1");
            return (Criteria) this;
        }

        public Criteria andFrowIndex1In(List<Integer> values) {
            addCriterion("frow_index1 in", values, "frowIndex1");
            return (Criteria) this;
        }

        public Criteria andFrowIndex1NotIn(List<Integer> values) {
            addCriterion("frow_index1 not in", values, "frowIndex1");
            return (Criteria) this;
        }

        public Criteria andFrowIndex1Between(Integer value1, Integer value2) {
            addCriterion("frow_index1 between", value1, value2, "frowIndex1");
            return (Criteria) this;
        }

        public Criteria andFrowIndex1NotBetween(Integer value1, Integer value2) {
            addCriterion("frow_index1 not between", value1, value2, "frowIndex1");
            return (Criteria) this;
        }

        public Criteria andFproject1IsNull() {
            addCriterion("fproject1 is null");
            return (Criteria) this;
        }

        public Criteria andFproject1IsNotNull() {
            addCriterion("fproject1 is not null");
            return (Criteria) this;
        }

        public Criteria andFproject1EqualTo(String value) {
            addCriterion("fproject1 =", value, "fproject1");
            return (Criteria) this;
        }

        public Criteria andFproject1NotEqualTo(String value) {
            addCriterion("fproject1 <>", value, "fproject1");
            return (Criteria) this;
        }

        public Criteria andFproject1GreaterThan(String value) {
            addCriterion("fproject1 >", value, "fproject1");
            return (Criteria) this;
        }

        public Criteria andFproject1GreaterThanOrEqualTo(String value) {
            addCriterion("fproject1 >=", value, "fproject1");
            return (Criteria) this;
        }

        public Criteria andFproject1LessThan(String value) {
            addCriterion("fproject1 <", value, "fproject1");
            return (Criteria) this;
        }

        public Criteria andFproject1LessThanOrEqualTo(String value) {
            addCriterion("fproject1 <=", value, "fproject1");
            return (Criteria) this;
        }

        public Criteria andFproject1Like(String value) {
            addCriterion("fproject1 like", value, "fproject1");
            return (Criteria) this;
        }

        public Criteria andFproject1NotLike(String value) {
            addCriterion("fproject1 not like", value, "fproject1");
            return (Criteria) this;
        }

        public Criteria andFproject1In(List<String> values) {
            addCriterion("fproject1 in", values, "fproject1");
            return (Criteria) this;
        }

        public Criteria andFproject1NotIn(List<String> values) {
            addCriterion("fproject1 not in", values, "fproject1");
            return (Criteria) this;
        }

        public Criteria andFproject1Between(String value1, String value2) {
            addCriterion("fproject1 between", value1, value2, "fproject1");
            return (Criteria) this;
        }

        public Criteria andFproject1NotBetween(String value1, String value2) {
            addCriterion("fproject1 not between", value1, value2, "fproject1");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount1IsNull() {
            addCriterion("ffinal_amount1 is null");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount1IsNotNull() {
            addCriterion("ffinal_amount1 is not null");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount1EqualTo(Double value) {
            addCriterion("ffinal_amount1 =", value, "ffinalAmount1");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount1NotEqualTo(Double value) {
            addCriterion("ffinal_amount1 <>", value, "ffinalAmount1");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount1GreaterThan(Double value) {
            addCriterion("ffinal_amount1 >", value, "ffinalAmount1");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount1GreaterThanOrEqualTo(Double value) {
            addCriterion("ffinal_amount1 >=", value, "ffinalAmount1");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount1LessThan(Double value) {
            addCriterion("ffinal_amount1 <", value, "ffinalAmount1");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount1LessThanOrEqualTo(Double value) {
            addCriterion("ffinal_amount1 <=", value, "ffinalAmount1");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount1In(List<Double> values) {
            addCriterion("ffinal_amount1 in", values, "ffinalAmount1");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount1NotIn(List<Double> values) {
            addCriterion("ffinal_amount1 not in", values, "ffinalAmount1");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount1Between(Double value1, Double value2) {
            addCriterion("ffinal_amount1 between", value1, value2, "ffinalAmount1");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount1NotBetween(Double value1, Double value2) {
            addCriterion("ffinal_amount1 not between", value1, value2, "ffinalAmount1");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount1IsNull() {
            addCriterion("fbeginning_amount1 is null");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount1IsNotNull() {
            addCriterion("fbeginning_amount1 is not null");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount1EqualTo(Double value) {
            addCriterion("fbeginning_amount1 =", value, "fbeginningAmount1");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount1NotEqualTo(Double value) {
            addCriterion("fbeginning_amount1 <>", value, "fbeginningAmount1");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount1GreaterThan(Double value) {
            addCriterion("fbeginning_amount1 >", value, "fbeginningAmount1");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount1GreaterThanOrEqualTo(Double value) {
            addCriterion("fbeginning_amount1 >=", value, "fbeginningAmount1");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount1LessThan(Double value) {
            addCriterion("fbeginning_amount1 <", value, "fbeginningAmount1");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount1LessThanOrEqualTo(Double value) {
            addCriterion("fbeginning_amount1 <=", value, "fbeginningAmount1");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount1In(List<Double> values) {
            addCriterion("fbeginning_amount1 in", values, "fbeginningAmount1");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount1NotIn(List<Double> values) {
            addCriterion("fbeginning_amount1 not in", values, "fbeginningAmount1");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount1Between(Double value1, Double value2) {
            addCriterion("fbeginning_amount1 between", value1, value2, "fbeginningAmount1");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount1NotBetween(Double value1, Double value2) {
            addCriterion("fbeginning_amount1 not between", value1, value2, "fbeginningAmount1");
            return (Criteria) this;
        }

        public Criteria andFproject2IsNull() {
            addCriterion("fproject2 is null");
            return (Criteria) this;
        }

        public Criteria andFproject2IsNotNull() {
            addCriterion("fproject2 is not null");
            return (Criteria) this;
        }

        public Criteria andFproject2EqualTo(String value) {
            addCriterion("fproject2 =", value, "fproject2");
            return (Criteria) this;
        }

        public Criteria andFproject2NotEqualTo(String value) {
            addCriterion("fproject2 <>", value, "fproject2");
            return (Criteria) this;
        }

        public Criteria andFproject2GreaterThan(String value) {
            addCriterion("fproject2 >", value, "fproject2");
            return (Criteria) this;
        }

        public Criteria andFproject2GreaterThanOrEqualTo(String value) {
            addCriterion("fproject2 >=", value, "fproject2");
            return (Criteria) this;
        }

        public Criteria andFproject2LessThan(String value) {
            addCriterion("fproject2 <", value, "fproject2");
            return (Criteria) this;
        }

        public Criteria andFproject2LessThanOrEqualTo(String value) {
            addCriterion("fproject2 <=", value, "fproject2");
            return (Criteria) this;
        }

        public Criteria andFproject2Like(String value) {
            addCriterion("fproject2 like", value, "fproject2");
            return (Criteria) this;
        }

        public Criteria andFproject2NotLike(String value) {
            addCriterion("fproject2 not like", value, "fproject2");
            return (Criteria) this;
        }

        public Criteria andFproject2In(List<String> values) {
            addCriterion("fproject2 in", values, "fproject2");
            return (Criteria) this;
        }

        public Criteria andFproject2NotIn(List<String> values) {
            addCriterion("fproject2 not in", values, "fproject2");
            return (Criteria) this;
        }

        public Criteria andFproject2Between(String value1, String value2) {
            addCriterion("fproject2 between", value1, value2, "fproject2");
            return (Criteria) this;
        }

        public Criteria andFproject2NotBetween(String value1, String value2) {
            addCriterion("fproject2 not between", value1, value2, "fproject2");
            return (Criteria) this;
        }

        public Criteria andFrowIndex2IsNull() {
            addCriterion("frow_index2 is null");
            return (Criteria) this;
        }

        public Criteria andFrowIndex2IsNotNull() {
            addCriterion("frow_index2 is not null");
            return (Criteria) this;
        }

        public Criteria andFrowIndex2EqualTo(Integer value) {
            addCriterion("frow_index2 =", value, "frowIndex2");
            return (Criteria) this;
        }

        public Criteria andFrowIndex2NotEqualTo(Integer value) {
            addCriterion("frow_index2 <>", value, "frowIndex2");
            return (Criteria) this;
        }

        public Criteria andFrowIndex2GreaterThan(Integer value) {
            addCriterion("frow_index2 >", value, "frowIndex2");
            return (Criteria) this;
        }

        public Criteria andFrowIndex2GreaterThanOrEqualTo(Integer value) {
            addCriterion("frow_index2 >=", value, "frowIndex2");
            return (Criteria) this;
        }

        public Criteria andFrowIndex2LessThan(Integer value) {
            addCriterion("frow_index2 <", value, "frowIndex2");
            return (Criteria) this;
        }

        public Criteria andFrowIndex2LessThanOrEqualTo(Integer value) {
            addCriterion("frow_index2 <=", value, "frowIndex2");
            return (Criteria) this;
        }

        public Criteria andFrowIndex2In(List<Integer> values) {
            addCriterion("frow_index2 in", values, "frowIndex2");
            return (Criteria) this;
        }

        public Criteria andFrowIndex2NotIn(List<Integer> values) {
            addCriterion("frow_index2 not in", values, "frowIndex2");
            return (Criteria) this;
        }

        public Criteria andFrowIndex2Between(Integer value1, Integer value2) {
            addCriterion("frow_index2 between", value1, value2, "frowIndex2");
            return (Criteria) this;
        }

        public Criteria andFrowIndex2NotBetween(Integer value1, Integer value2) {
            addCriterion("frow_index2 not between", value1, value2, "frowIndex2");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount2IsNull() {
            addCriterion("ffinal_amount2 is null");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount2IsNotNull() {
            addCriterion("ffinal_amount2 is not null");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount2EqualTo(Double value) {
            addCriterion("ffinal_amount2 =", value, "ffinalAmount2");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount2NotEqualTo(Double value) {
            addCriterion("ffinal_amount2 <>", value, "ffinalAmount2");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount2GreaterThan(Double value) {
            addCriterion("ffinal_amount2 >", value, "ffinalAmount2");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount2GreaterThanOrEqualTo(Double value) {
            addCriterion("ffinal_amount2 >=", value, "ffinalAmount2");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount2LessThan(Double value) {
            addCriterion("ffinal_amount2 <", value, "ffinalAmount2");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount2LessThanOrEqualTo(Double value) {
            addCriterion("ffinal_amount2 <=", value, "ffinalAmount2");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount2In(List<Double> values) {
            addCriterion("ffinal_amount2 in", values, "ffinalAmount2");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount2NotIn(List<Double> values) {
            addCriterion("ffinal_amount2 not in", values, "ffinalAmount2");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount2Between(Double value1, Double value2) {
            addCriterion("ffinal_amount2 between", value1, value2, "ffinalAmount2");
            return (Criteria) this;
        }

        public Criteria andFfinalAmount2NotBetween(Double value1, Double value2) {
            addCriterion("ffinal_amount2 not between", value1, value2, "ffinalAmount2");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount2IsNull() {
            addCriterion("fbeginning_amount2 is null");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount2IsNotNull() {
            addCriterion("fbeginning_amount2 is not null");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount2EqualTo(Double value) {
            addCriterion("fbeginning_amount2 =", value, "fbeginningAmount2");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount2NotEqualTo(Double value) {
            addCriterion("fbeginning_amount2 <>", value, "fbeginningAmount2");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount2GreaterThan(Double value) {
            addCriterion("fbeginning_amount2 >", value, "fbeginningAmount2");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount2GreaterThanOrEqualTo(Double value) {
            addCriterion("fbeginning_amount2 >=", value, "fbeginningAmount2");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount2LessThan(Double value) {
            addCriterion("fbeginning_amount2 <", value, "fbeginningAmount2");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount2LessThanOrEqualTo(Double value) {
            addCriterion("fbeginning_amount2 <=", value, "fbeginningAmount2");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount2In(List<Double> values) {
            addCriterion("fbeginning_amount2 in", values, "fbeginningAmount2");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount2NotIn(List<Double> values) {
            addCriterion("fbeginning_amount2 not in", values, "fbeginningAmount2");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount2Between(Double value1, Double value2) {
            addCriterion("fbeginning_amount2 between", value1, value2, "fbeginningAmount2");
            return (Criteria) this;
        }

        public Criteria andFbeginningAmount2NotBetween(Double value1, Double value2) {
            addCriterion("fbeginning_amount2 not between", value1, value2, "fbeginningAmount2");
            return (Criteria) this;
        }

        public Criteria andFstatusIsNull() {
            addCriterion("fstatus is null");
            return (Criteria) this;
        }

        public Criteria andFstatusIsNotNull() {
            addCriterion("fstatus is not null");
            return (Criteria) this;
        }

        public Criteria andFstatusEqualTo(String value) {
            addCriterion("fstatus =", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotEqualTo(String value) {
            addCriterion("fstatus <>", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThan(String value) {
            addCriterion("fstatus >", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThanOrEqualTo(String value) {
            addCriterion("fstatus >=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThan(String value) {
            addCriterion("fstatus <", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThanOrEqualTo(String value) {
            addCriterion("fstatus <=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLike(String value) {
            addCriterion("fstatus like", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotLike(String value) {
            addCriterion("fstatus not like", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusIn(List<String> values) {
            addCriterion("fstatus in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotIn(List<String> values) {
            addCriterion("fstatus not in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusBetween(String value1, String value2) {
            addCriterion("fstatus between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotBetween(String value1, String value2) {
            addCriterion("fstatus not between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFsheetRowNumberIsNull() {
            addCriterion("fsheet_row_number is null");
            return (Criteria) this;
        }

        public Criteria andFsheetRowNumberIsNotNull() {
            addCriterion("fsheet_row_number is not null");
            return (Criteria) this;
        }

        public Criteria andFsheetRowNumberEqualTo(Integer value) {
            addCriterion("fsheet_row_number =", value, "fsheetRowNumber");
            return (Criteria) this;
        }

        public Criteria andFsheetRowNumberNotEqualTo(Integer value) {
            addCriterion("fsheet_row_number <>", value, "fsheetRowNumber");
            return (Criteria) this;
        }

        public Criteria andFsheetRowNumberGreaterThan(Integer value) {
            addCriterion("fsheet_row_number >", value, "fsheetRowNumber");
            return (Criteria) this;
        }

        public Criteria andFsheetRowNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("fsheet_row_number >=", value, "fsheetRowNumber");
            return (Criteria) this;
        }

        public Criteria andFsheetRowNumberLessThan(Integer value) {
            addCriterion("fsheet_row_number <", value, "fsheetRowNumber");
            return (Criteria) this;
        }

        public Criteria andFsheetRowNumberLessThanOrEqualTo(Integer value) {
            addCriterion("fsheet_row_number <=", value, "fsheetRowNumber");
            return (Criteria) this;
        }

        public Criteria andFsheetRowNumberIn(List<Integer> values) {
            addCriterion("fsheet_row_number in", values, "fsheetRowNumber");
            return (Criteria) this;
        }

        public Criteria andFsheetRowNumberNotIn(List<Integer> values) {
            addCriterion("fsheet_row_number not in", values, "fsheetRowNumber");
            return (Criteria) this;
        }

        public Criteria andFsheetRowNumberBetween(Integer value1, Integer value2) {
            addCriterion("fsheet_row_number between", value1, value2, "fsheetRowNumber");
            return (Criteria) this;
        }

        public Criteria andFsheetRowNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("fsheet_row_number not between", value1, value2, "fsheetRowNumber");
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