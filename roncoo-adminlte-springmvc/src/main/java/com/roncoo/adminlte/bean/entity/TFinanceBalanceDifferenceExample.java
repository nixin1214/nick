package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceBalanceDifferenceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceBalanceDifferenceExample() {
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

        public Criteria andFprojectIsNull() {
            addCriterion("fproject is null");
            return (Criteria) this;
        }

        public Criteria andFprojectIsNotNull() {
            addCriterion("fproject is not null");
            return (Criteria) this;
        }

        public Criteria andFprojectEqualTo(String value) {
            addCriterion("fproject =", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectNotEqualTo(String value) {
            addCriterion("fproject <>", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectGreaterThan(String value) {
            addCriterion("fproject >", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectGreaterThanOrEqualTo(String value) {
            addCriterion("fproject >=", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectLessThan(String value) {
            addCriterion("fproject <", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectLessThanOrEqualTo(String value) {
            addCriterion("fproject <=", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectLike(String value) {
            addCriterion("fproject like", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectNotLike(String value) {
            addCriterion("fproject not like", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectIn(List<String> values) {
            addCriterion("fproject in", values, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectNotIn(List<String> values) {
            addCriterion("fproject not in", values, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectBetween(String value1, String value2) {
            addCriterion("fproject between", value1, value2, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectNotBetween(String value1, String value2) {
            addCriterion("fproject not between", value1, value2, "fproject");
            return (Criteria) this;
        }

        public Criteria andFrowNumIsNull() {
            addCriterion("frow_num is null");
            return (Criteria) this;
        }

        public Criteria andFrowNumIsNotNull() {
            addCriterion("frow_num is not null");
            return (Criteria) this;
        }

        public Criteria andFrowNumEqualTo(Integer value) {
            addCriterion("frow_num =", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotEqualTo(Integer value) {
            addCriterion("frow_num <>", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumGreaterThan(Integer value) {
            addCriterion("frow_num >", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("frow_num >=", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumLessThan(Integer value) {
            addCriterion("frow_num <", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumLessThanOrEqualTo(Integer value) {
            addCriterion("frow_num <=", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumIn(List<Integer> values) {
            addCriterion("frow_num in", values, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotIn(List<Integer> values) {
            addCriterion("frow_num not in", values, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumBetween(Integer value1, Integer value2) {
            addCriterion("frow_num between", value1, value2, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotBetween(Integer value1, Integer value2) {
            addCriterion("frow_num not between", value1, value2, "frowNum");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccountIsNull() {
            addCriterion("period_end_account is null");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccountIsNotNull() {
            addCriterion("period_end_account is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccountEqualTo(BigDecimal value) {
            addCriterion("period_end_account =", value, "periodEndAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccountNotEqualTo(BigDecimal value) {
            addCriterion("period_end_account <>", value, "periodEndAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccountGreaterThan(BigDecimal value) {
            addCriterion("period_end_account >", value, "periodEndAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("period_end_account >=", value, "periodEndAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccountLessThan(BigDecimal value) {
            addCriterion("period_end_account <", value, "periodEndAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("period_end_account <=", value, "periodEndAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccountIn(List<BigDecimal> values) {
            addCriterion("period_end_account in", values, "periodEndAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccountNotIn(List<BigDecimal> values) {
            addCriterion("period_end_account not in", values, "periodEndAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("period_end_account between", value1, value2, "periodEndAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("period_end_account not between", value1, value2, "periodEndAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccountIsNull() {
            addCriterion("period_begin_account is null");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccountIsNotNull() {
            addCriterion("period_begin_account is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccountEqualTo(BigDecimal value) {
            addCriterion("period_begin_account =", value, "periodBeginAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccountNotEqualTo(BigDecimal value) {
            addCriterion("period_begin_account <>", value, "periodBeginAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccountGreaterThan(BigDecimal value) {
            addCriterion("period_begin_account >", value, "periodBeginAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("period_begin_account >=", value, "periodBeginAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccountLessThan(BigDecimal value) {
            addCriterion("period_begin_account <", value, "periodBeginAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("period_begin_account <=", value, "periodBeginAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccountIn(List<BigDecimal> values) {
            addCriterion("period_begin_account in", values, "periodBeginAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccountNotIn(List<BigDecimal> values) {
            addCriterion("period_begin_account not in", values, "periodBeginAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("period_begin_account between", value1, value2, "periodBeginAccount");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("period_begin_account not between", value1, value2, "periodBeginAccount");
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

        public Criteria andFrowNum2IsNull() {
            addCriterion("frow_num2 is null");
            return (Criteria) this;
        }

        public Criteria andFrowNum2IsNotNull() {
            addCriterion("frow_num2 is not null");
            return (Criteria) this;
        }

        public Criteria andFrowNum2EqualTo(Integer value) {
            addCriterion("frow_num2 =", value, "frowNum2");
            return (Criteria) this;
        }

        public Criteria andFrowNum2NotEqualTo(Integer value) {
            addCriterion("frow_num2 <>", value, "frowNum2");
            return (Criteria) this;
        }

        public Criteria andFrowNum2GreaterThan(Integer value) {
            addCriterion("frow_num2 >", value, "frowNum2");
            return (Criteria) this;
        }

        public Criteria andFrowNum2GreaterThanOrEqualTo(Integer value) {
            addCriterion("frow_num2 >=", value, "frowNum2");
            return (Criteria) this;
        }

        public Criteria andFrowNum2LessThan(Integer value) {
            addCriterion("frow_num2 <", value, "frowNum2");
            return (Criteria) this;
        }

        public Criteria andFrowNum2LessThanOrEqualTo(Integer value) {
            addCriterion("frow_num2 <=", value, "frowNum2");
            return (Criteria) this;
        }

        public Criteria andFrowNum2In(List<Integer> values) {
            addCriterion("frow_num2 in", values, "frowNum2");
            return (Criteria) this;
        }

        public Criteria andFrowNum2NotIn(List<Integer> values) {
            addCriterion("frow_num2 not in", values, "frowNum2");
            return (Criteria) this;
        }

        public Criteria andFrowNum2Between(Integer value1, Integer value2) {
            addCriterion("frow_num2 between", value1, value2, "frowNum2");
            return (Criteria) this;
        }

        public Criteria andFrowNum2NotBetween(Integer value1, Integer value2) {
            addCriterion("frow_num2 not between", value1, value2, "frowNum2");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccount2IsNull() {
            addCriterion("period_end_account2 is null");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccount2IsNotNull() {
            addCriterion("period_end_account2 is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccount2EqualTo(BigDecimal value) {
            addCriterion("period_end_account2 =", value, "periodEndAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccount2NotEqualTo(BigDecimal value) {
            addCriterion("period_end_account2 <>", value, "periodEndAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccount2GreaterThan(BigDecimal value) {
            addCriterion("period_end_account2 >", value, "periodEndAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccount2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("period_end_account2 >=", value, "periodEndAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccount2LessThan(BigDecimal value) {
            addCriterion("period_end_account2 <", value, "periodEndAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccount2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("period_end_account2 <=", value, "periodEndAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccount2In(List<BigDecimal> values) {
            addCriterion("period_end_account2 in", values, "periodEndAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccount2NotIn(List<BigDecimal> values) {
            addCriterion("period_end_account2 not in", values, "periodEndAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccount2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("period_end_account2 between", value1, value2, "periodEndAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodEndAccount2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("period_end_account2 not between", value1, value2, "periodEndAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccount2IsNull() {
            addCriterion("period_begin_account2 is null");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccount2IsNotNull() {
            addCriterion("period_begin_account2 is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccount2EqualTo(BigDecimal value) {
            addCriterion("period_begin_account2 =", value, "periodBeginAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccount2NotEqualTo(BigDecimal value) {
            addCriterion("period_begin_account2 <>", value, "periodBeginAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccount2GreaterThan(BigDecimal value) {
            addCriterion("period_begin_account2 >", value, "periodBeginAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccount2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("period_begin_account2 >=", value, "periodBeginAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccount2LessThan(BigDecimal value) {
            addCriterion("period_begin_account2 <", value, "periodBeginAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccount2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("period_begin_account2 <=", value, "periodBeginAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccount2In(List<BigDecimal> values) {
            addCriterion("period_begin_account2 in", values, "periodBeginAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccount2NotIn(List<BigDecimal> values) {
            addCriterion("period_begin_account2 not in", values, "periodBeginAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccount2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("period_begin_account2 between", value1, value2, "periodBeginAccount2");
            return (Criteria) this;
        }

        public Criteria andPeriodBeginAccount2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("period_begin_account2 not between", value1, value2, "periodBeginAccount2");
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