package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceEmpSalaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceEmpSalaryExample() {
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

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart = limitStart;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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

        public Criteria andFrowIndexEqualTo(Integer value) {
            addCriterion("FROW_INDEX =", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexNotEqualTo(Integer value) {
            addCriterion("FROW_INDEX <>", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexGreaterThan(Integer value) {
            addCriterion("FROW_INDEX >", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("FROW_INDEX >=", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexLessThan(Integer value) {
            addCriterion("FROW_INDEX <", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexLessThanOrEqualTo(Integer value) {
            addCriterion("FROW_INDEX <=", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexIn(List<Integer> values) {
            addCriterion("FROW_INDEX in", values, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexNotIn(List<Integer> values) {
            addCriterion("FROW_INDEX not in", values, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexBetween(Integer value1, Integer value2) {
            addCriterion("FROW_INDEX between", value1, value2, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("FROW_INDEX not between", value1, value2, "frowIndex");
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

        public Criteria andFthisBeginPeriodAmountIsNull() {
            addCriterion("FTHIS_BEGIN_PERIOD_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFthisBeginPeriodAmountIsNotNull() {
            addCriterion("FTHIS_BEGIN_PERIOD_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFthisBeginPeriodAmountEqualTo(BigDecimal value) {
            addCriterion("FTHIS_BEGIN_PERIOD_AMOUNT =", value, "fthisBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisBeginPeriodAmountNotEqualTo(BigDecimal value) {
            addCriterion("FTHIS_BEGIN_PERIOD_AMOUNT <>", value, "fthisBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisBeginPeriodAmountGreaterThan(BigDecimal value) {
            addCriterion("FTHIS_BEGIN_PERIOD_AMOUNT >", value, "fthisBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisBeginPeriodAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_BEGIN_PERIOD_AMOUNT >=", value, "fthisBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisBeginPeriodAmountLessThan(BigDecimal value) {
            addCriterion("FTHIS_BEGIN_PERIOD_AMOUNT <", value, "fthisBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisBeginPeriodAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_BEGIN_PERIOD_AMOUNT <=", value, "fthisBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisBeginPeriodAmountIn(List<BigDecimal> values) {
            addCriterion("FTHIS_BEGIN_PERIOD_AMOUNT in", values, "fthisBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisBeginPeriodAmountNotIn(List<BigDecimal> values) {
            addCriterion("FTHIS_BEGIN_PERIOD_AMOUNT not in", values, "fthisBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisBeginPeriodAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_BEGIN_PERIOD_AMOUNT between", value1, value2, "fthisBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisBeginPeriodAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_BEGIN_PERIOD_AMOUNT not between", value1, value2, "fthisBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodAmountIsNull() {
            addCriterion("FTHIS_PERIOD_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodAmountIsNotNull() {
            addCriterion("FTHIS_PERIOD_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodAmountEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_AMOUNT =", value, "fthisPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodAmountNotEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_AMOUNT <>", value, "fthisPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodAmountGreaterThan(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_AMOUNT >", value, "fthisPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_AMOUNT >=", value, "fthisPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodAmountLessThan(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_AMOUNT <", value, "fthisPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_AMOUNT <=", value, "fthisPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodAmountIn(List<BigDecimal> values) {
            addCriterion("FTHIS_PERIOD_AMOUNT in", values, "fthisPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodAmountNotIn(List<BigDecimal> values) {
            addCriterion("FTHIS_PERIOD_AMOUNT not in", values, "fthisPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_PERIOD_AMOUNT between", value1, value2, "fthisPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_PERIOD_AMOUNT not between", value1, value2, "fthisPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodPaidAmountIsNull() {
            addCriterion("FTHIS_PERIOD_PAID_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodPaidAmountIsNotNull() {
            addCriterion("FTHIS_PERIOD_PAID_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodPaidAmountEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_PAID_AMOUNT =", value, "fthisPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodPaidAmountNotEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_PAID_AMOUNT <>", value, "fthisPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodPaidAmountGreaterThan(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_PAID_AMOUNT >", value, "fthisPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodPaidAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_PAID_AMOUNT >=", value, "fthisPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodPaidAmountLessThan(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_PAID_AMOUNT <", value, "fthisPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodPaidAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_PAID_AMOUNT <=", value, "fthisPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodPaidAmountIn(List<BigDecimal> values) {
            addCriterion("FTHIS_PERIOD_PAID_AMOUNT in", values, "fthisPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodPaidAmountNotIn(List<BigDecimal> values) {
            addCriterion("FTHIS_PERIOD_PAID_AMOUNT not in", values, "fthisPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodPaidAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_PERIOD_PAID_AMOUNT between", value1, value2, "fthisPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodPaidAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_PERIOD_PAID_AMOUNT not between", value1, value2, "fthisPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodEndAmountIsNull() {
            addCriterion("FTHIS_PERIOD_END_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodEndAmountIsNotNull() {
            addCriterion("FTHIS_PERIOD_END_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodEndAmountEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_END_AMOUNT =", value, "fthisPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodEndAmountNotEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_END_AMOUNT <>", value, "fthisPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodEndAmountGreaterThan(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_END_AMOUNT >", value, "fthisPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodEndAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_END_AMOUNT >=", value, "fthisPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodEndAmountLessThan(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_END_AMOUNT <", value, "fthisPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodEndAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_END_AMOUNT <=", value, "fthisPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodEndAmountIn(List<BigDecimal> values) {
            addCriterion("FTHIS_PERIOD_END_AMOUNT in", values, "fthisPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodEndAmountNotIn(List<BigDecimal> values) {
            addCriterion("FTHIS_PERIOD_END_AMOUNT not in", values, "fthisPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodEndAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_PERIOD_END_AMOUNT between", value1, value2, "fthisPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodEndAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_PERIOD_END_AMOUNT not between", value1, value2, "fthisPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalBeginPeriodAmountIsNull() {
            addCriterion("FTOTAL_BEGIN_PERIOD_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFtotalBeginPeriodAmountIsNotNull() {
            addCriterion("FTOTAL_BEGIN_PERIOD_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalBeginPeriodAmountEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_BEGIN_PERIOD_AMOUNT =", value, "ftotalBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalBeginPeriodAmountNotEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_BEGIN_PERIOD_AMOUNT <>", value, "ftotalBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalBeginPeriodAmountGreaterThan(BigDecimal value) {
            addCriterion("FTOTAL_BEGIN_PERIOD_AMOUNT >", value, "ftotalBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalBeginPeriodAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_BEGIN_PERIOD_AMOUNT >=", value, "ftotalBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalBeginPeriodAmountLessThan(BigDecimal value) {
            addCriterion("FTOTAL_BEGIN_PERIOD_AMOUNT <", value, "ftotalBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalBeginPeriodAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_BEGIN_PERIOD_AMOUNT <=", value, "ftotalBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalBeginPeriodAmountIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_BEGIN_PERIOD_AMOUNT in", values, "ftotalBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalBeginPeriodAmountNotIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_BEGIN_PERIOD_AMOUNT not in", values, "ftotalBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalBeginPeriodAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_BEGIN_PERIOD_AMOUNT between", value1, value2, "ftotalBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalBeginPeriodAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_BEGIN_PERIOD_AMOUNT not between", value1, value2, "ftotalBeginPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAmountIsNull() {
            addCriterion("FTOTAL_PERIOD_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAmountIsNotNull() {
            addCriterion("FTOTAL_PERIOD_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAmountEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_AMOUNT =", value, "ftotalPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAmountNotEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_AMOUNT <>", value, "ftotalPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAmountGreaterThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_AMOUNT >", value, "ftotalPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_AMOUNT >=", value, "ftotalPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAmountLessThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_AMOUNT <", value, "ftotalPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_AMOUNT <=", value, "ftotalPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAmountIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_AMOUNT in", values, "ftotalPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAmountNotIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_AMOUNT not in", values, "ftotalPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_AMOUNT between", value1, value2, "ftotalPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_AMOUNT not between", value1, value2, "ftotalPeriodAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodPaidAmountIsNull() {
            addCriterion("FTOTAL_PERIOD_PAID_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodPaidAmountIsNotNull() {
            addCriterion("FTOTAL_PERIOD_PAID_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodPaidAmountEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_PAID_AMOUNT =", value, "ftotalPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodPaidAmountNotEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_PAID_AMOUNT <>", value, "ftotalPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodPaidAmountGreaterThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_PAID_AMOUNT >", value, "ftotalPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodPaidAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_PAID_AMOUNT >=", value, "ftotalPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodPaidAmountLessThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_PAID_AMOUNT <", value, "ftotalPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodPaidAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_PAID_AMOUNT <=", value, "ftotalPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodPaidAmountIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_PAID_AMOUNT in", values, "ftotalPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodPaidAmountNotIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_PAID_AMOUNT not in", values, "ftotalPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodPaidAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_PAID_AMOUNT between", value1, value2, "ftotalPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodPaidAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_PAID_AMOUNT not between", value1, value2, "ftotalPeriodPaidAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodEndAmountIsNull() {
            addCriterion("FTOTAL_PERIOD_END_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodEndAmountIsNotNull() {
            addCriterion("FTOTAL_PERIOD_END_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodEndAmountEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_END_AMOUNT =", value, "ftotalPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodEndAmountNotEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_END_AMOUNT <>", value, "ftotalPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodEndAmountGreaterThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_END_AMOUNT >", value, "ftotalPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodEndAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_END_AMOUNT >=", value, "ftotalPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodEndAmountLessThan(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_END_AMOUNT <", value, "ftotalPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodEndAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTAL_PERIOD_END_AMOUNT <=", value, "ftotalPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodEndAmountIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_END_AMOUNT in", values, "ftotalPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodEndAmountNotIn(List<BigDecimal> values) {
            addCriterion("FTOTAL_PERIOD_END_AMOUNT not in", values, "ftotalPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodEndAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_END_AMOUNT between", value1, value2, "ftotalPeriodEndAmount");
            return (Criteria) this;
        }

        public Criteria andFtotalPeriodEndAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTAL_PERIOD_END_AMOUNT not between", value1, value2, "ftotalPeriodEndAmount");
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

        public Criteria andFthisBudgetIsNull() {
            addCriterion("FTHISBUDGET is null");
            return (Criteria) this;
        }

        public Criteria andFthisBudgetIsNotNull() {
            addCriterion("FTHISBUDGET is not null");
            return (Criteria) this;
        }

        public Criteria andFthisBudgetEqualTo(BigDecimal value) {
            addCriterion("FTHISBUDGET =", value, "fthisBudget");
            return (Criteria) this;
        }

        public Criteria andFthisBudgetNotEqualTo(BigDecimal value) {
            addCriterion("FTHISBUDGET <>", value, "fthisBudget");
            return (Criteria) this;
        }

        public Criteria andFthisBudgetGreaterThan(BigDecimal value) {
            addCriterion("FTHISBUDGET >", value, "fthisBudget");
            return (Criteria) this;
        }

        public Criteria andFthisBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHISBUDGET >=", value, "fthisBudget");
            return (Criteria) this;
        }

        public Criteria andFthisBudgetLessThan(BigDecimal value) {
            addCriterion("FTHISBUDGET <", value, "fthisBudget");
            return (Criteria) this;
        }

        public Criteria andFthisBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHISBUDGET <=", value, "fthisBudget");
            return (Criteria) this;
        }

        public Criteria andFthisBudgetIn(List<BigDecimal> values) {
            addCriterion("FTHISBUDGET in", values, "fthisBudget");
            return (Criteria) this;
        }

        public Criteria andFthisBudgetNotIn(List<BigDecimal> values) {
            addCriterion("FTHISBUDGET not in", values, "fthisBudget");
            return (Criteria) this;
        }

        public Criteria andFthisBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHISBUDGET between", value1, value2, "fthisBudget");
            return (Criteria) this;
        }

        public Criteria andFthisBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHISBUDGET not between", value1, value2, "fthisBudget");
            return (Criteria) this;
        }

        public Criteria andFtotalBudgetIsNull() {
            addCriterion("FTOTALBUDGET is null");
            return (Criteria) this;
        }

        public Criteria andFtotalBudgetIsNotNull() {
            addCriterion("FTOTALBUDGET is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalBudgetEqualTo(BigDecimal value) {
            addCriterion("FTOTALBUDGET =", value, "ftotalBudget");
            return (Criteria) this;
        }

        public Criteria andFtotalBudgetNotEqualTo(BigDecimal value) {
            addCriterion("FTOTALBUDGET <>", value, "ftotalBudget");
            return (Criteria) this;
        }

        public Criteria andFtotalBudgetGreaterThan(BigDecimal value) {
            addCriterion("FTOTALBUDGET >", value, "ftotalBudget");
            return (Criteria) this;
        }

        public Criteria andFtotalBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTALBUDGET >=", value, "ftotalBudget");
            return (Criteria) this;
        }

        public Criteria andFtotalBudgetLessThan(BigDecimal value) {
            addCriterion("FTOTALBUDGET <", value, "ftotalBudget");
            return (Criteria) this;
        }

        public Criteria andFtotalBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTOTALBUDGET <=", value, "ftotalBudget");
            return (Criteria) this;
        }

        public Criteria andFtotalBudgetIn(List<BigDecimal> values) {
            addCriterion("FTOTALBUDGET in", values, "ftotalBudget");
            return (Criteria) this;
        }

        public Criteria andFtotalBudgetNotIn(List<BigDecimal> values) {
            addCriterion("FTOTALBUDGET not in", values, "ftotalBudget");
            return (Criteria) this;
        }

        public Criteria andFtotalBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTALBUDGET between", value1, value2, "ftotalBudget");
            return (Criteria) this;
        }

        public Criteria andFtotalBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTOTALBUDGET not between", value1, value2, "ftotalBudget");
            return (Criteria) this;
        }
    }

    /**
     */
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