package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TFinanceOtherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceOtherExample() {
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

        public Criteria andFenterpriseIsNull() {
            addCriterion("FENTERPRISE is null");
            return (Criteria) this;
        }

        public Criteria andFenterpriseIsNotNull() {
            addCriterion("FENTERPRISE is not null");
            return (Criteria) this;
        }

        public Criteria andFenterpriseEqualTo(String value) {
            addCriterion("FENTERPRISE =", value, "fenterprise");
            return (Criteria) this;
        }

        public Criteria andFenterpriseNotEqualTo(String value) {
            addCriterion("FENTERPRISE <>", value, "fenterprise");
            return (Criteria) this;
        }

        public Criteria andFenterpriseGreaterThan(String value) {
            addCriterion("FENTERPRISE >", value, "fenterprise");
            return (Criteria) this;
        }

        public Criteria andFenterpriseGreaterThanOrEqualTo(String value) {
            addCriterion("FENTERPRISE >=", value, "fenterprise");
            return (Criteria) this;
        }

        public Criteria andFenterpriseLessThan(String value) {
            addCriterion("FENTERPRISE <", value, "fenterprise");
            return (Criteria) this;
        }

        public Criteria andFenterpriseLessThanOrEqualTo(String value) {
            addCriterion("FENTERPRISE <=", value, "fenterprise");
            return (Criteria) this;
        }

        public Criteria andFenterpriseLike(String value) {
            addCriterion("FENTERPRISE like", value, "fenterprise");
            return (Criteria) this;
        }

        public Criteria andFenterpriseNotLike(String value) {
            addCriterion("FENTERPRISE not like", value, "fenterprise");
            return (Criteria) this;
        }

        public Criteria andFenterpriseIn(List<String> values) {
            addCriterion("FENTERPRISE in", values, "fenterprise");
            return (Criteria) this;
        }

        public Criteria andFenterpriseNotIn(List<String> values) {
            addCriterion("FENTERPRISE not in", values, "fenterprise");
            return (Criteria) this;
        }

        public Criteria andFenterpriseBetween(String value1, String value2) {
            addCriterion("FENTERPRISE between", value1, value2, "fenterprise");
            return (Criteria) this;
        }

        public Criteria andFenterpriseNotBetween(String value1, String value2) {
            addCriterion("FENTERPRISE not between", value1, value2, "fenterprise");
            return (Criteria) this;
        }

        public Criteria andFquotaNameIsNull() {
            addCriterion("FQUOTA_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFquotaNameIsNotNull() {
            addCriterion("FQUOTA_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEqualTo(String value) {
            addCriterion("FQUOTA_NAME =", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameNotEqualTo(String value) {
            addCriterion("FQUOTA_NAME <>", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameGreaterThan(String value) {
            addCriterion("FQUOTA_NAME >", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameGreaterThanOrEqualTo(String value) {
            addCriterion("FQUOTA_NAME >=", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameLessThan(String value) {
            addCriterion("FQUOTA_NAME <", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameLessThanOrEqualTo(String value) {
            addCriterion("FQUOTA_NAME <=", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameLike(String value) {
            addCriterion("FQUOTA_NAME like", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameNotLike(String value) {
            addCriterion("FQUOTA_NAME not like", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameIn(List<String> values) {
            addCriterion("FQUOTA_NAME in", values, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameNotIn(List<String> values) {
            addCriterion("FQUOTA_NAME not in", values, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameBetween(String value1, String value2) {
            addCriterion("FQUOTA_NAME between", value1, value2, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameNotBetween(String value1, String value2) {
            addCriterion("FQUOTA_NAME not between", value1, value2, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaValueIsNull() {
            addCriterion("FQUOTA_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andFquotaValueIsNotNull() {
            addCriterion("FQUOTA_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andFquotaValueEqualTo(BigDecimal value) {
            addCriterion("FQUOTA_VALUE =", value, "fquotaValue");
            return (Criteria) this;
        }

        public Criteria andFquotaValueNotEqualTo(BigDecimal value) {
            addCriterion("FQUOTA_VALUE <>", value, "fquotaValue");
            return (Criteria) this;
        }

        public Criteria andFquotaValueGreaterThan(BigDecimal value) {
            addCriterion("FQUOTA_VALUE >", value, "fquotaValue");
            return (Criteria) this;
        }

        public Criteria andFquotaValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FQUOTA_VALUE >=", value, "fquotaValue");
            return (Criteria) this;
        }

        public Criteria andFquotaValueLessThan(BigDecimal value) {
            addCriterion("FQUOTA_VALUE <", value, "fquotaValue");
            return (Criteria) this;
        }

        public Criteria andFquotaValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FQUOTA_VALUE <=", value, "fquotaValue");
            return (Criteria) this;
        }

        public Criteria andFquotaValueIn(List<BigDecimal> values) {
            addCriterion("FQUOTA_VALUE in", values, "fquotaValue");
            return (Criteria) this;
        }

        public Criteria andFquotaValueNotIn(List<BigDecimal> values) {
            addCriterion("FQUOTA_VALUE not in", values, "fquotaValue");
            return (Criteria) this;
        }

        public Criteria andFquotaValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FQUOTA_VALUE between", value1, value2, "fquotaValue");
            return (Criteria) this;
        }

        public Criteria andFquotaValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FQUOTA_VALUE not between", value1, value2, "fquotaValue");
            return (Criteria) this;
        }

        public Criteria andFresourceIsNull() {
            addCriterion("FRESOURCE is null");
            return (Criteria) this;
        }

        public Criteria andFresourceIsNotNull() {
            addCriterion("FRESOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andFresourceEqualTo(String value) {
            addCriterion("FRESOURCE =", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceNotEqualTo(String value) {
            addCriterion("FRESOURCE <>", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceGreaterThan(String value) {
            addCriterion("FRESOURCE >", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceGreaterThanOrEqualTo(String value) {
            addCriterion("FRESOURCE >=", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceLessThan(String value) {
            addCriterion("FRESOURCE <", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceLessThanOrEqualTo(String value) {
            addCriterion("FRESOURCE <=", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceLike(String value) {
            addCriterion("FRESOURCE like", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceNotLike(String value) {
            addCriterion("FRESOURCE not like", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceIn(List<String> values) {
            addCriterion("FRESOURCE in", values, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceNotIn(List<String> values) {
            addCriterion("FRESOURCE not in", values, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceBetween(String value1, String value2) {
            addCriterion("FRESOURCE between", value1, value2, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceNotBetween(String value1, String value2) {
            addCriterion("FRESOURCE not between", value1, value2, "fresource");
            return (Criteria) this;
        }

        public Criteria andFcreatimeIsNull() {
            addCriterion("FCREATIME is null");
            return (Criteria) this;
        }

        public Criteria andFcreatimeIsNotNull() {
            addCriterion("FCREATIME is not null");
            return (Criteria) this;
        }

        public Criteria andFcreatimeEqualTo(Date value) {
            addCriterion("FCREATIME =", value, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeNotEqualTo(Date value) {
            addCriterion("FCREATIME <>", value, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeGreaterThan(Date value) {
            addCriterion("FCREATIME >", value, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FCREATIME >=", value, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeLessThan(Date value) {
            addCriterion("FCREATIME <", value, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeLessThanOrEqualTo(Date value) {
            addCriterion("FCREATIME <=", value, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeIn(List<Date> values) {
            addCriterion("FCREATIME in", values, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeNotIn(List<Date> values) {
            addCriterion("FCREATIME not in", values, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeBetween(Date value1, Date value2) {
            addCriterion("FCREATIME between", value1, value2, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeNotBetween(Date value1, Date value2) {
            addCriterion("FCREATIME not between", value1, value2, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFyearmonthIsNull() {
            addCriterion("FYEARMONTH is null");
            return (Criteria) this;
        }

        public Criteria andFyearmonthIsNotNull() {
            addCriterion("FYEARMONTH is not null");
            return (Criteria) this;
        }

        public Criteria andFyearmonthEqualTo(String value) {
            addCriterion("FYEARMONTH =", value, "fyearmonth");
            return (Criteria) this;
        }

        public Criteria andFyearmonthNotEqualTo(String value) {
            addCriterion("FYEARMONTH <>", value, "fyearmonth");
            return (Criteria) this;
        }

        public Criteria andFyearmonthGreaterThan(String value) {
            addCriterion("FYEARMONTH >", value, "fyearmonth");
            return (Criteria) this;
        }

        public Criteria andFyearmonthGreaterThanOrEqualTo(String value) {
            addCriterion("FYEARMONTH >=", value, "fyearmonth");
            return (Criteria) this;
        }

        public Criteria andFyearmonthLessThan(String value) {
            addCriterion("FYEARMONTH <", value, "fyearmonth");
            return (Criteria) this;
        }

        public Criteria andFyearmonthLessThanOrEqualTo(String value) {
            addCriterion("FYEARMONTH <=", value, "fyearmonth");
            return (Criteria) this;
        }

        public Criteria andFyearmonthLike(String value) {
            addCriterion("FYEARMONTH like", value, "fyearmonth");
            return (Criteria) this;
        }

        public Criteria andFyearmonthNotLike(String value) {
            addCriterion("FYEARMONTH not like", value, "fyearmonth");
            return (Criteria) this;
        }

        public Criteria andFyearmonthIn(List<String> values) {
            addCriterion("FYEARMONTH in", values, "fyearmonth");
            return (Criteria) this;
        }

        public Criteria andFyearmonthNotIn(List<String> values) {
            addCriterion("FYEARMONTH not in", values, "fyearmonth");
            return (Criteria) this;
        }

        public Criteria andFyearmonthBetween(String value1, String value2) {
            addCriterion("FYEARMONTH between", value1, value2, "fyearmonth");
            return (Criteria) this;
        }

        public Criteria andFyearmonthNotBetween(String value1, String value2) {
            addCriterion("FYEARMONTH not between", value1, value2, "fyearmonth");
            return (Criteria) this;
        }

        public Criteria andFremarkIsNull() {
            addCriterion("FREMARK is null");
            return (Criteria) this;
        }

        public Criteria andFremarkIsNotNull() {
            addCriterion("FREMARK is not null");
            return (Criteria) this;
        }

        public Criteria andFremarkEqualTo(String value) {
            addCriterion("FREMARK =", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotEqualTo(String value) {
            addCriterion("FREMARK <>", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkGreaterThan(String value) {
            addCriterion("FREMARK >", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkGreaterThanOrEqualTo(String value) {
            addCriterion("FREMARK >=", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkLessThan(String value) {
            addCriterion("FREMARK <", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkLessThanOrEqualTo(String value) {
            addCriterion("FREMARK <=", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkLike(String value) {
            addCriterion("FREMARK like", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotLike(String value) {
            addCriterion("FREMARK not like", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkIn(List<String> values) {
            addCriterion("FREMARK in", values, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotIn(List<String> values) {
            addCriterion("FREMARK not in", values, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkBetween(String value1, String value2) {
            addCriterion("FREMARK between", value1, value2, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotBetween(String value1, String value2) {
            addCriterion("FREMARK not between", value1, value2, "fremark");
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

        public Criteria andFcreatorIdIsNull() {
            addCriterion("FCREATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andFcreatorIdIsNotNull() {
            addCriterion("FCREATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFcreatorIdEqualTo(Long value) {
            addCriterion("FCREATOR_ID =", value, "fcreatorId");
            return (Criteria) this;
        }

        public Criteria andFcreatorIdNotEqualTo(Long value) {
            addCriterion("FCREATOR_ID <>", value, "fcreatorId");
            return (Criteria) this;
        }

        public Criteria andFcreatorIdGreaterThan(Long value) {
            addCriterion("FCREATOR_ID >", value, "fcreatorId");
            return (Criteria) this;
        }

        public Criteria andFcreatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FCREATOR_ID >=", value, "fcreatorId");
            return (Criteria) this;
        }

        public Criteria andFcreatorIdLessThan(Long value) {
            addCriterion("FCREATOR_ID <", value, "fcreatorId");
            return (Criteria) this;
        }

        public Criteria andFcreatorIdLessThanOrEqualTo(Long value) {
            addCriterion("FCREATOR_ID <=", value, "fcreatorId");
            return (Criteria) this;
        }

        public Criteria andFcreatorIdIn(List<Long> values) {
            addCriterion("FCREATOR_ID in", values, "fcreatorId");
            return (Criteria) this;
        }

        public Criteria andFcreatorIdNotIn(List<Long> values) {
            addCriterion("FCREATOR_ID not in", values, "fcreatorId");
            return (Criteria) this;
        }

        public Criteria andFcreatorIdBetween(Long value1, Long value2) {
            addCriterion("FCREATOR_ID between", value1, value2, "fcreatorId");
            return (Criteria) this;
        }

        public Criteria andFcreatorIdNotBetween(Long value1, Long value2) {
            addCriterion("FCREATOR_ID not between", value1, value2, "fcreatorId");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameIsNull() {
            addCriterion("FCREATOR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameIsNotNull() {
            addCriterion("FCREATOR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameEqualTo(String value) {
            addCriterion("FCREATOR_NAME =", value, "fcreatorName");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameNotEqualTo(String value) {
            addCriterion("FCREATOR_NAME <>", value, "fcreatorName");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameGreaterThan(String value) {
            addCriterion("FCREATOR_NAME >", value, "fcreatorName");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("FCREATOR_NAME >=", value, "fcreatorName");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameLessThan(String value) {
            addCriterion("FCREATOR_NAME <", value, "fcreatorName");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameLessThanOrEqualTo(String value) {
            addCriterion("FCREATOR_NAME <=", value, "fcreatorName");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameLike(String value) {
            addCriterion("FCREATOR_NAME like", value, "fcreatorName");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameNotLike(String value) {
            addCriterion("FCREATOR_NAME not like", value, "fcreatorName");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameIn(List<String> values) {
            addCriterion("FCREATOR_NAME in", values, "fcreatorName");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameNotIn(List<String> values) {
            addCriterion("FCREATOR_NAME not in", values, "fcreatorName");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameBetween(String value1, String value2) {
            addCriterion("FCREATOR_NAME between", value1, value2, "fcreatorName");
            return (Criteria) this;
        }

        public Criteria andFcreatorNameNotBetween(String value1, String value2) {
            addCriterion("FCREATOR_NAME not between", value1, value2, "fcreatorName");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeIsNull() {
            addCriterion("FCOMPANY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeIsNotNull() {
            addCriterion("FCOMPANY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeEqualTo(String value) {
            addCriterion("FCOMPANY_CODE =", value, "fcompanyCode");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeNotEqualTo(String value) {
            addCriterion("FCOMPANY_CODE <>", value, "fcompanyCode");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeGreaterThan(String value) {
            addCriterion("FCOMPANY_CODE >", value, "fcompanyCode");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FCOMPANY_CODE >=", value, "fcompanyCode");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeLessThan(String value) {
            addCriterion("FCOMPANY_CODE <", value, "fcompanyCode");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("FCOMPANY_CODE <=", value, "fcompanyCode");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeLike(String value) {
            addCriterion("FCOMPANY_CODE like", value, "fcompanyCode");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeNotLike(String value) {
            addCriterion("FCOMPANY_CODE not like", value, "fcompanyCode");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeIn(List<String> values) {
            addCriterion("FCOMPANY_CODE in", values, "fcompanyCode");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeNotIn(List<String> values) {
            addCriterion("FCOMPANY_CODE not in", values, "fcompanyCode");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeBetween(String value1, String value2) {
            addCriterion("FCOMPANY_CODE between", value1, value2, "fcompanyCode");
            return (Criteria) this;
        }

        public Criteria andFcompanyCodeNotBetween(String value1, String value2) {
            addCriterion("FCOMPANY_CODE not between", value1, value2, "fcompanyCode");
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