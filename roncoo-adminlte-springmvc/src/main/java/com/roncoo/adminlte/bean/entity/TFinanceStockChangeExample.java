package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceStockChangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceStockChangeExample() {
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

        public Criteria andFbeginNumberIsNull() {
            addCriterion("fbegin_number is null");
            return (Criteria) this;
        }

        public Criteria andFbeginNumberIsNotNull() {
            addCriterion("fbegin_number is not null");
            return (Criteria) this;
        }

        public Criteria andFbeginNumberEqualTo(BigDecimal value) {
            addCriterion("fbegin_number =", value, "fbeginNumber");
            return (Criteria) this;
        }

        public Criteria andFbeginNumberNotEqualTo(BigDecimal value) {
            addCriterion("fbegin_number <>", value, "fbeginNumber");
            return (Criteria) this;
        }

        public Criteria andFbeginNumberGreaterThan(BigDecimal value) {
            addCriterion("fbegin_number >", value, "fbeginNumber");
            return (Criteria) this;
        }

        public Criteria andFbeginNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fbegin_number >=", value, "fbeginNumber");
            return (Criteria) this;
        }

        public Criteria andFbeginNumberLessThan(BigDecimal value) {
            addCriterion("fbegin_number <", value, "fbeginNumber");
            return (Criteria) this;
        }

        public Criteria andFbeginNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fbegin_number <=", value, "fbeginNumber");
            return (Criteria) this;
        }

        public Criteria andFbeginNumberIn(List<BigDecimal> values) {
            addCriterion("fbegin_number in", values, "fbeginNumber");
            return (Criteria) this;
        }

        public Criteria andFbeginNumberNotIn(List<BigDecimal> values) {
            addCriterion("fbegin_number not in", values, "fbeginNumber");
            return (Criteria) this;
        }

        public Criteria andFbeginNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fbegin_number between", value1, value2, "fbeginNumber");
            return (Criteria) this;
        }

        public Criteria andFbeginNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fbegin_number not between", value1, value2, "fbeginNumber");
            return (Criteria) this;
        }

        public Criteria andFbeginAmountIsNull() {
            addCriterion("fbegin_amount is null");
            return (Criteria) this;
        }

        public Criteria andFbeginAmountIsNotNull() {
            addCriterion("fbegin_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFbeginAmountEqualTo(BigDecimal value) {
            addCriterion("fbegin_amount =", value, "fbeginAmount");
            return (Criteria) this;
        }

        public Criteria andFbeginAmountNotEqualTo(BigDecimal value) {
            addCriterion("fbegin_amount <>", value, "fbeginAmount");
            return (Criteria) this;
        }

        public Criteria andFbeginAmountGreaterThan(BigDecimal value) {
            addCriterion("fbegin_amount >", value, "fbeginAmount");
            return (Criteria) this;
        }

        public Criteria andFbeginAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fbegin_amount >=", value, "fbeginAmount");
            return (Criteria) this;
        }

        public Criteria andFbeginAmountLessThan(BigDecimal value) {
            addCriterion("fbegin_amount <", value, "fbeginAmount");
            return (Criteria) this;
        }

        public Criteria andFbeginAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fbegin_amount <=", value, "fbeginAmount");
            return (Criteria) this;
        }

        public Criteria andFbeginAmountIn(List<BigDecimal> values) {
            addCriterion("fbegin_amount in", values, "fbeginAmount");
            return (Criteria) this;
        }

        public Criteria andFbeginAmountNotIn(List<BigDecimal> values) {
            addCriterion("fbegin_amount not in", values, "fbeginAmount");
            return (Criteria) this;
        }

        public Criteria andFbeginAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fbegin_amount between", value1, value2, "fbeginAmount");
            return (Criteria) this;
        }

        public Criteria andFbeginAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fbegin_amount not between", value1, value2, "fbeginAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAddNumberIsNull() {
            addCriterion("fthis_add_number is null");
            return (Criteria) this;
        }

        public Criteria andFthisAddNumberIsNotNull() {
            addCriterion("fthis_add_number is not null");
            return (Criteria) this;
        }

        public Criteria andFthisAddNumberEqualTo(BigDecimal value) {
            addCriterion("fthis_add_number =", value, "fthisAddNumber");
            return (Criteria) this;
        }

        public Criteria andFthisAddNumberNotEqualTo(BigDecimal value) {
            addCriterion("fthis_add_number <>", value, "fthisAddNumber");
            return (Criteria) this;
        }

        public Criteria andFthisAddNumberGreaterThan(BigDecimal value) {
            addCriterion("fthis_add_number >", value, "fthisAddNumber");
            return (Criteria) this;
        }

        public Criteria andFthisAddNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_add_number >=", value, "fthisAddNumber");
            return (Criteria) this;
        }

        public Criteria andFthisAddNumberLessThan(BigDecimal value) {
            addCriterion("fthis_add_number <", value, "fthisAddNumber");
            return (Criteria) this;
        }

        public Criteria andFthisAddNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_add_number <=", value, "fthisAddNumber");
            return (Criteria) this;
        }

        public Criteria andFthisAddNumberIn(List<BigDecimal> values) {
            addCriterion("fthis_add_number in", values, "fthisAddNumber");
            return (Criteria) this;
        }

        public Criteria andFthisAddNumberNotIn(List<BigDecimal> values) {
            addCriterion("fthis_add_number not in", values, "fthisAddNumber");
            return (Criteria) this;
        }

        public Criteria andFthisAddNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_add_number between", value1, value2, "fthisAddNumber");
            return (Criteria) this;
        }

        public Criteria andFthisAddNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_add_number not between", value1, value2, "fthisAddNumber");
            return (Criteria) this;
        }

        public Criteria andFthisAddAmountIsNull() {
            addCriterion("fthis_add_amount is null");
            return (Criteria) this;
        }

        public Criteria andFthisAddAmountIsNotNull() {
            addCriterion("fthis_add_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFthisAddAmountEqualTo(BigDecimal value) {
            addCriterion("fthis_add_amount =", value, "fthisAddAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAddAmountNotEqualTo(BigDecimal value) {
            addCriterion("fthis_add_amount <>", value, "fthisAddAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAddAmountGreaterThan(BigDecimal value) {
            addCriterion("fthis_add_amount >", value, "fthisAddAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAddAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_add_amount >=", value, "fthisAddAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAddAmountLessThan(BigDecimal value) {
            addCriterion("fthis_add_amount <", value, "fthisAddAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAddAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_add_amount <=", value, "fthisAddAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAddAmountIn(List<BigDecimal> values) {
            addCriterion("fthis_add_amount in", values, "fthisAddAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAddAmountNotIn(List<BigDecimal> values) {
            addCriterion("fthis_add_amount not in", values, "fthisAddAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAddAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_add_amount between", value1, value2, "fthisAddAmount");
            return (Criteria) this;
        }

        public Criteria andFthisAddAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_add_amount not between", value1, value2, "fthisAddAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAddNumberIsNull() {
            addCriterion("ftotal_add_number is null");
            return (Criteria) this;
        }

        public Criteria andFtotalAddNumberIsNotNull() {
            addCriterion("ftotal_add_number is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalAddNumberEqualTo(BigDecimal value) {
            addCriterion("ftotal_add_number =", value, "ftotalAddNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalAddNumberNotEqualTo(BigDecimal value) {
            addCriterion("ftotal_add_number <>", value, "ftotalAddNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalAddNumberGreaterThan(BigDecimal value) {
            addCriterion("ftotal_add_number >", value, "ftotalAddNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalAddNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_add_number >=", value, "ftotalAddNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalAddNumberLessThan(BigDecimal value) {
            addCriterion("ftotal_add_number <", value, "ftotalAddNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalAddNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_add_number <=", value, "ftotalAddNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalAddNumberIn(List<BigDecimal> values) {
            addCriterion("ftotal_add_number in", values, "ftotalAddNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalAddNumberNotIn(List<BigDecimal> values) {
            addCriterion("ftotal_add_number not in", values, "ftotalAddNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalAddNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_add_number between", value1, value2, "ftotalAddNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalAddNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_add_number not between", value1, value2, "ftotalAddNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalAddAmountIsNull() {
            addCriterion("ftotal_add_amount is null");
            return (Criteria) this;
        }

        public Criteria andFtotalAddAmountIsNotNull() {
            addCriterion("ftotal_add_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalAddAmountEqualTo(BigDecimal value) {
            addCriterion("ftotal_add_amount =", value, "ftotalAddAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAddAmountNotEqualTo(BigDecimal value) {
            addCriterion("ftotal_add_amount <>", value, "ftotalAddAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAddAmountGreaterThan(BigDecimal value) {
            addCriterion("ftotal_add_amount >", value, "ftotalAddAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAddAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_add_amount >=", value, "ftotalAddAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAddAmountLessThan(BigDecimal value) {
            addCriterion("ftotal_add_amount <", value, "ftotalAddAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAddAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_add_amount <=", value, "ftotalAddAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAddAmountIn(List<BigDecimal> values) {
            addCriterion("ftotal_add_amount in", values, "ftotalAddAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAddAmountNotIn(List<BigDecimal> values) {
            addCriterion("ftotal_add_amount not in", values, "ftotalAddAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAddAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_add_amount between", value1, value2, "ftotalAddAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalAddAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_add_amount not between", value1, value2, "ftotalAddAmount");
            return (Criteria) this;
        }

        public Criteria andFthisFallingNumberIsNull() {
            addCriterion("fthis_falling_number is null");
            return (Criteria) this;
        }

        public Criteria andFthisFallingNumberIsNotNull() {
            addCriterion("fthis_falling_number is not null");
            return (Criteria) this;
        }

        public Criteria andFthisFallingNumberEqualTo(BigDecimal value) {
            addCriterion("fthis_falling_number =", value, "fthisFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFthisFallingNumberNotEqualTo(BigDecimal value) {
            addCriterion("fthis_falling_number <>", value, "fthisFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFthisFallingNumberGreaterThan(BigDecimal value) {
            addCriterion("fthis_falling_number >", value, "fthisFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFthisFallingNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_falling_number >=", value, "fthisFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFthisFallingNumberLessThan(BigDecimal value) {
            addCriterion("fthis_falling_number <", value, "fthisFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFthisFallingNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_falling_number <=", value, "fthisFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFthisFallingNumberIn(List<BigDecimal> values) {
            addCriterion("fthis_falling_number in", values, "fthisFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFthisFallingNumberNotIn(List<BigDecimal> values) {
            addCriterion("fthis_falling_number not in", values, "fthisFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFthisFallingNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_falling_number between", value1, value2, "fthisFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFthisFallingNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_falling_number not between", value1, value2, "fthisFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFthisFallingAmountIsNull() {
            addCriterion("fthis_falling_amount is null");
            return (Criteria) this;
        }

        public Criteria andFthisFallingAmountIsNotNull() {
            addCriterion("fthis_falling_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFthisFallingAmountEqualTo(BigDecimal value) {
            addCriterion("fthis_falling_amount =", value, "fthisFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFthisFallingAmountNotEqualTo(BigDecimal value) {
            addCriterion("fthis_falling_amount <>", value, "fthisFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFthisFallingAmountGreaterThan(BigDecimal value) {
            addCriterion("fthis_falling_amount >", value, "fthisFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFthisFallingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_falling_amount >=", value, "fthisFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFthisFallingAmountLessThan(BigDecimal value) {
            addCriterion("fthis_falling_amount <", value, "fthisFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFthisFallingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fthis_falling_amount <=", value, "fthisFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFthisFallingAmountIn(List<BigDecimal> values) {
            addCriterion("fthis_falling_amount in", values, "fthisFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFthisFallingAmountNotIn(List<BigDecimal> values) {
            addCriterion("fthis_falling_amount not in", values, "fthisFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFthisFallingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_falling_amount between", value1, value2, "fthisFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFthisFallingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fthis_falling_amount not between", value1, value2, "fthisFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingNumberIsNull() {
            addCriterion("ftotal_falling_number is null");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingNumberIsNotNull() {
            addCriterion("ftotal_falling_number is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingNumberEqualTo(BigDecimal value) {
            addCriterion("ftotal_falling_number =", value, "ftotalFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingNumberNotEqualTo(BigDecimal value) {
            addCriterion("ftotal_falling_number <>", value, "ftotalFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingNumberGreaterThan(BigDecimal value) {
            addCriterion("ftotal_falling_number >", value, "ftotalFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_falling_number >=", value, "ftotalFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingNumberLessThan(BigDecimal value) {
            addCriterion("ftotal_falling_number <", value, "ftotalFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_falling_number <=", value, "ftotalFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingNumberIn(List<BigDecimal> values) {
            addCriterion("ftotal_falling_number in", values, "ftotalFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingNumberNotIn(List<BigDecimal> values) {
            addCriterion("ftotal_falling_number not in", values, "ftotalFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_falling_number between", value1, value2, "ftotalFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_falling_number not between", value1, value2, "ftotalFallingNumber");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingAmountIsNull() {
            addCriterion("ftotal_falling_amount is null");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingAmountIsNotNull() {
            addCriterion("ftotal_falling_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingAmountEqualTo(BigDecimal value) {
            addCriterion("ftotal_falling_amount =", value, "ftotalFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingAmountNotEqualTo(BigDecimal value) {
            addCriterion("ftotal_falling_amount <>", value, "ftotalFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingAmountGreaterThan(BigDecimal value) {
            addCriterion("ftotal_falling_amount >", value, "ftotalFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_falling_amount >=", value, "ftotalFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingAmountLessThan(BigDecimal value) {
            addCriterion("ftotal_falling_amount <", value, "ftotalFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotal_falling_amount <=", value, "ftotalFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingAmountIn(List<BigDecimal> values) {
            addCriterion("ftotal_falling_amount in", values, "ftotalFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingAmountNotIn(List<BigDecimal> values) {
            addCriterion("ftotal_falling_amount not in", values, "ftotalFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_falling_amount between", value1, value2, "ftotalFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalFallingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotal_falling_amount not between", value1, value2, "ftotalFallingAmount");
            return (Criteria) this;
        }

        public Criteria andFlastNumberIsNull() {
            addCriterion("flast_number is null");
            return (Criteria) this;
        }

        public Criteria andFlastNumberIsNotNull() {
            addCriterion("flast_number is not null");
            return (Criteria) this;
        }

        public Criteria andFlastNumberEqualTo(BigDecimal value) {
            addCriterion("flast_number =", value, "flastNumber");
            return (Criteria) this;
        }

        public Criteria andFlastNumberNotEqualTo(BigDecimal value) {
            addCriterion("flast_number <>", value, "flastNumber");
            return (Criteria) this;
        }

        public Criteria andFlastNumberGreaterThan(BigDecimal value) {
            addCriterion("flast_number >", value, "flastNumber");
            return (Criteria) this;
        }

        public Criteria andFlastNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("flast_number >=", value, "flastNumber");
            return (Criteria) this;
        }

        public Criteria andFlastNumberLessThan(BigDecimal value) {
            addCriterion("flast_number <", value, "flastNumber");
            return (Criteria) this;
        }

        public Criteria andFlastNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("flast_number <=", value, "flastNumber");
            return (Criteria) this;
        }

        public Criteria andFlastNumberIn(List<BigDecimal> values) {
            addCriterion("flast_number in", values, "flastNumber");
            return (Criteria) this;
        }

        public Criteria andFlastNumberNotIn(List<BigDecimal> values) {
            addCriterion("flast_number not in", values, "flastNumber");
            return (Criteria) this;
        }

        public Criteria andFlastNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flast_number between", value1, value2, "flastNumber");
            return (Criteria) this;
        }

        public Criteria andFlastNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flast_number not between", value1, value2, "flastNumber");
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