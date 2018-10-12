package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TBusinessQuotaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TBusinessQuotaExample() {
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

        public Criteria andFresSysIsNull() {
            addCriterion("fres_sys is null");
            return (Criteria) this;
        }

        public Criteria andFresSysIsNotNull() {
            addCriterion("fres_sys is not null");
            return (Criteria) this;
        }

        public Criteria andFresSysEqualTo(String value) {
            addCriterion("fres_sys =", value, "fresSys");
            return (Criteria) this;
        }

        public Criteria andFresSysNotEqualTo(String value) {
            addCriterion("fres_sys <>", value, "fresSys");
            return (Criteria) this;
        }

        public Criteria andFresSysGreaterThan(String value) {
            addCriterion("fres_sys >", value, "fresSys");
            return (Criteria) this;
        }

        public Criteria andFresSysGreaterThanOrEqualTo(String value) {
            addCriterion("fres_sys >=", value, "fresSys");
            return (Criteria) this;
        }

        public Criteria andFresSysLessThan(String value) {
            addCriterion("fres_sys <", value, "fresSys");
            return (Criteria) this;
        }

        public Criteria andFresSysLessThanOrEqualTo(String value) {
            addCriterion("fres_sys <=", value, "fresSys");
            return (Criteria) this;
        }

        public Criteria andFresSysLike(String value) {
            addCriterion("fres_sys like", value, "fresSys");
            return (Criteria) this;
        }

        public Criteria andFresSysNotLike(String value) {
            addCriterion("fres_sys not like", value, "fresSys");
            return (Criteria) this;
        }

        public Criteria andFresSysIn(List<String> values) {
            addCriterion("fres_sys in", values, "fresSys");
            return (Criteria) this;
        }

        public Criteria andFresSysNotIn(List<String> values) {
            addCriterion("fres_sys not in", values, "fresSys");
            return (Criteria) this;
        }

        public Criteria andFresSysBetween(String value1, String value2) {
            addCriterion("fres_sys between", value1, value2, "fresSys");
            return (Criteria) this;
        }

        public Criteria andFresSysNotBetween(String value1, String value2) {
            addCriterion("fres_sys not between", value1, value2, "fresSys");
            return (Criteria) this;
        }

        public Criteria andForgIdIsNull() {
            addCriterion("forg_id is null");
            return (Criteria) this;
        }

        public Criteria andForgIdIsNotNull() {
            addCriterion("forg_id is not null");
            return (Criteria) this;
        }

        public Criteria andForgIdEqualTo(Long value) {
            addCriterion("forg_id =", value, "forgId");
            return (Criteria) this;
        }

        public Criteria andForgIdNotEqualTo(Long value) {
            addCriterion("forg_id <>", value, "forgId");
            return (Criteria) this;
        }

        public Criteria andForgIdGreaterThan(Long value) {
            addCriterion("forg_id >", value, "forgId");
            return (Criteria) this;
        }

        public Criteria andForgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("forg_id >=", value, "forgId");
            return (Criteria) this;
        }

        public Criteria andForgIdLessThan(Long value) {
            addCriterion("forg_id <", value, "forgId");
            return (Criteria) this;
        }

        public Criteria andForgIdLessThanOrEqualTo(Long value) {
            addCriterion("forg_id <=", value, "forgId");
            return (Criteria) this;
        }

        public Criteria andForgIdIn(List<Long> values) {
            addCriterion("forg_id in", values, "forgId");
            return (Criteria) this;
        }

        public Criteria andForgIdNotIn(List<Long> values) {
            addCriterion("forg_id not in", values, "forgId");
            return (Criteria) this;
        }

        public Criteria andForgIdBetween(Long value1, Long value2) {
            addCriterion("forg_id between", value1, value2, "forgId");
            return (Criteria) this;
        }

        public Criteria andForgIdNotBetween(Long value1, Long value2) {
            addCriterion("forg_id not between", value1, value2, "forgId");
            return (Criteria) this;
        }

        public Criteria andForgCodeIsNull() {
            addCriterion("forg_code is null");
            return (Criteria) this;
        }

        public Criteria andForgCodeIsNotNull() {
            addCriterion("forg_code is not null");
            return (Criteria) this;
        }

        public Criteria andForgCodeEqualTo(String value) {
            addCriterion("forg_code =", value, "forgCode");
            return (Criteria) this;
        }

        public Criteria andForgCodeNotEqualTo(String value) {
            addCriterion("forg_code <>", value, "forgCode");
            return (Criteria) this;
        }

        public Criteria andForgCodeGreaterThan(String value) {
            addCriterion("forg_code >", value, "forgCode");
            return (Criteria) this;
        }

        public Criteria andForgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("forg_code >=", value, "forgCode");
            return (Criteria) this;
        }

        public Criteria andForgCodeLessThan(String value) {
            addCriterion("forg_code <", value, "forgCode");
            return (Criteria) this;
        }

        public Criteria andForgCodeLessThanOrEqualTo(String value) {
            addCriterion("forg_code <=", value, "forgCode");
            return (Criteria) this;
        }

        public Criteria andForgCodeLike(String value) {
            addCriterion("forg_code like", value, "forgCode");
            return (Criteria) this;
        }

        public Criteria andForgCodeNotLike(String value) {
            addCriterion("forg_code not like", value, "forgCode");
            return (Criteria) this;
        }

        public Criteria andForgCodeIn(List<String> values) {
            addCriterion("forg_code in", values, "forgCode");
            return (Criteria) this;
        }

        public Criteria andForgCodeNotIn(List<String> values) {
            addCriterion("forg_code not in", values, "forgCode");
            return (Criteria) this;
        }

        public Criteria andForgCodeBetween(String value1, String value2) {
            addCriterion("forg_code between", value1, value2, "forgCode");
            return (Criteria) this;
        }

        public Criteria andForgCodeNotBetween(String value1, String value2) {
            addCriterion("forg_code not between", value1, value2, "forgCode");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeIsNull() {
            addCriterion("forg_long_code is null");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeIsNotNull() {
            addCriterion("forg_long_code is not null");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeEqualTo(String value) {
            addCriterion("forg_long_code =", value, "forgLongCode");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeNotEqualTo(String value) {
            addCriterion("forg_long_code <>", value, "forgLongCode");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeGreaterThan(String value) {
            addCriterion("forg_long_code >", value, "forgLongCode");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeGreaterThanOrEqualTo(String value) {
            addCriterion("forg_long_code >=", value, "forgLongCode");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeLessThan(String value) {
            addCriterion("forg_long_code <", value, "forgLongCode");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeLessThanOrEqualTo(String value) {
            addCriterion("forg_long_code <=", value, "forgLongCode");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeLike(String value) {
            addCriterion("forg_long_code like", value, "forgLongCode");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeNotLike(String value) {
            addCriterion("forg_long_code not like", value, "forgLongCode");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeIn(List<String> values) {
            addCriterion("forg_long_code in", values, "forgLongCode");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeNotIn(List<String> values) {
            addCriterion("forg_long_code not in", values, "forgLongCode");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeBetween(String value1, String value2) {
            addCriterion("forg_long_code between", value1, value2, "forgLongCode");
            return (Criteria) this;
        }

        public Criteria andForgLongCodeNotBetween(String value1, String value2) {
            addCriterion("forg_long_code not between", value1, value2, "forgLongCode");
            return (Criteria) this;
        }

        public Criteria andFyearMonthIsNull() {
            addCriterion("fyear_month is null");
            return (Criteria) this;
        }

        public Criteria andFyearMonthIsNotNull() {
            addCriterion("fyear_month is not null");
            return (Criteria) this;
        }

        public Criteria andFyearMonthEqualTo(String value) {
            addCriterion("fyear_month =", value, "fyearMonth");
            return (Criteria) this;
        }

        public Criteria andFyearMonthNotEqualTo(String value) {
            addCriterion("fyear_month <>", value, "fyearMonth");
            return (Criteria) this;
        }

        public Criteria andFyearMonthGreaterThan(String value) {
            addCriterion("fyear_month >", value, "fyearMonth");
            return (Criteria) this;
        }

        public Criteria andFyearMonthGreaterThanOrEqualTo(String value) {
            addCriterion("fyear_month >=", value, "fyearMonth");
            return (Criteria) this;
        }

        public Criteria andFyearMonthLessThan(String value) {
            addCriterion("fyear_month <", value, "fyearMonth");
            return (Criteria) this;
        }

        public Criteria andFyearMonthLessThanOrEqualTo(String value) {
            addCriterion("fyear_month <=", value, "fyearMonth");
            return (Criteria) this;
        }

        public Criteria andFyearMonthLike(String value) {
            addCriterion("fyear_month like", value, "fyearMonth");
            return (Criteria) this;
        }

        public Criteria andFyearMonthNotLike(String value) {
            addCriterion("fyear_month not like", value, "fyearMonth");
            return (Criteria) this;
        }

        public Criteria andFyearMonthIn(List<String> values) {
            addCriterion("fyear_month in", values, "fyearMonth");
            return (Criteria) this;
        }

        public Criteria andFyearMonthNotIn(List<String> values) {
            addCriterion("fyear_month not in", values, "fyearMonth");
            return (Criteria) this;
        }

        public Criteria andFyearMonthBetween(String value1, String value2) {
            addCriterion("fyear_month between", value1, value2, "fyearMonth");
            return (Criteria) this;
        }

        public Criteria andFyearMonthNotBetween(String value1, String value2) {
            addCriterion("fyear_month not between", value1, value2, "fyearMonth");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNull() {
            addCriterion("ftype is null");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNotNull() {
            addCriterion("ftype is not null");
            return (Criteria) this;
        }

        public Criteria andFtypeEqualTo(String value) {
            addCriterion("ftype =", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotEqualTo(String value) {
            addCriterion("ftype <>", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThan(String value) {
            addCriterion("ftype >", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThanOrEqualTo(String value) {
            addCriterion("ftype >=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThan(String value) {
            addCriterion("ftype <", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThanOrEqualTo(String value) {
            addCriterion("ftype <=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLike(String value) {
            addCriterion("ftype like", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotLike(String value) {
            addCriterion("ftype not like", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeIn(List<String> values) {
            addCriterion("ftype in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotIn(List<String> values) {
            addCriterion("ftype not in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeBetween(String value1, String value2) {
            addCriterion("ftype between", value1, value2, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotBetween(String value1, String value2) {
            addCriterion("ftype not between", value1, value2, "ftype");
            return (Criteria) this;
        }

        public Criteria andFnameZhIsNull() {
            addCriterion("fname_zh is null");
            return (Criteria) this;
        }

        public Criteria andFnameZhIsNotNull() {
            addCriterion("fname_zh is not null");
            return (Criteria) this;
        }

        public Criteria andFnameZhEqualTo(String value) {
            addCriterion("fname_zh =", value, "fnameZh");
            return (Criteria) this;
        }

        public Criteria andFnameZhNotEqualTo(String value) {
            addCriterion("fname_zh <>", value, "fnameZh");
            return (Criteria) this;
        }

        public Criteria andFnameZhGreaterThan(String value) {
            addCriterion("fname_zh >", value, "fnameZh");
            return (Criteria) this;
        }

        public Criteria andFnameZhGreaterThanOrEqualTo(String value) {
            addCriterion("fname_zh >=", value, "fnameZh");
            return (Criteria) this;
        }

        public Criteria andFnameZhLessThan(String value) {
            addCriterion("fname_zh <", value, "fnameZh");
            return (Criteria) this;
        }

        public Criteria andFnameZhLessThanOrEqualTo(String value) {
            addCriterion("fname_zh <=", value, "fnameZh");
            return (Criteria) this;
        }

        public Criteria andFnameZhLike(String value) {
            addCriterion("fname_zh like", value, "fnameZh");
            return (Criteria) this;
        }

        public Criteria andFnameZhNotLike(String value) {
            addCriterion("fname_zh not like", value, "fnameZh");
            return (Criteria) this;
        }

        public Criteria andFnameZhIn(List<String> values) {
            addCriterion("fname_zh in", values, "fnameZh");
            return (Criteria) this;
        }

        public Criteria andFnameZhNotIn(List<String> values) {
            addCriterion("fname_zh not in", values, "fnameZh");
            return (Criteria) this;
        }

        public Criteria andFnameZhBetween(String value1, String value2) {
            addCriterion("fname_zh between", value1, value2, "fnameZh");
            return (Criteria) this;
        }

        public Criteria andFnameZhNotBetween(String value1, String value2) {
            addCriterion("fname_zh not between", value1, value2, "fnameZh");
            return (Criteria) this;
        }

        public Criteria andFnameEnIsNull() {
            addCriterion("fname_en is null");
            return (Criteria) this;
        }

        public Criteria andFnameEnIsNotNull() {
            addCriterion("fname_en is not null");
            return (Criteria) this;
        }

        public Criteria andFnameEnEqualTo(String value) {
            addCriterion("fname_en =", value, "fnameEn");
            return (Criteria) this;
        }

        public Criteria andFnameEnNotEqualTo(String value) {
            addCriterion("fname_en <>", value, "fnameEn");
            return (Criteria) this;
        }

        public Criteria andFnameEnGreaterThan(String value) {
            addCriterion("fname_en >", value, "fnameEn");
            return (Criteria) this;
        }

        public Criteria andFnameEnGreaterThanOrEqualTo(String value) {
            addCriterion("fname_en >=", value, "fnameEn");
            return (Criteria) this;
        }

        public Criteria andFnameEnLessThan(String value) {
            addCriterion("fname_en <", value, "fnameEn");
            return (Criteria) this;
        }

        public Criteria andFnameEnLessThanOrEqualTo(String value) {
            addCriterion("fname_en <=", value, "fnameEn");
            return (Criteria) this;
        }

        public Criteria andFnameEnLike(String value) {
            addCriterion("fname_en like", value, "fnameEn");
            return (Criteria) this;
        }

        public Criteria andFnameEnNotLike(String value) {
            addCriterion("fname_en not like", value, "fnameEn");
            return (Criteria) this;
        }

        public Criteria andFnameEnIn(List<String> values) {
            addCriterion("fname_en in", values, "fnameEn");
            return (Criteria) this;
        }

        public Criteria andFnameEnNotIn(List<String> values) {
            addCriterion("fname_en not in", values, "fnameEn");
            return (Criteria) this;
        }

        public Criteria andFnameEnBetween(String value1, String value2) {
            addCriterion("fname_en between", value1, value2, "fnameEn");
            return (Criteria) this;
        }

        public Criteria andFnameEnNotBetween(String value1, String value2) {
            addCriterion("fname_en not between", value1, value2, "fnameEn");
            return (Criteria) this;
        }

        public Criteria andFvalueIsNull() {
            addCriterion("fvalue is null");
            return (Criteria) this;
        }

        public Criteria andFvalueIsNotNull() {
            addCriterion("fvalue is not null");
            return (Criteria) this;
        }

        public Criteria andFvalueEqualTo(BigDecimal value) {
            addCriterion("fvalue =", value, "fvalue");
            return (Criteria) this;
        }

        public Criteria andFvalueNotEqualTo(BigDecimal value) {
            addCriterion("fvalue <>", value, "fvalue");
            return (Criteria) this;
        }

        public Criteria andFvalueGreaterThan(BigDecimal value) {
            addCriterion("fvalue >", value, "fvalue");
            return (Criteria) this;
        }

        public Criteria andFvalueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fvalue >=", value, "fvalue");
            return (Criteria) this;
        }

        public Criteria andFvalueLessThan(BigDecimal value) {
            addCriterion("fvalue <", value, "fvalue");
            return (Criteria) this;
        }

        public Criteria andFvalueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fvalue <=", value, "fvalue");
            return (Criteria) this;
        }

        public Criteria andFvalueIn(List<BigDecimal> values) {
            addCriterion("fvalue in", values, "fvalue");
            return (Criteria) this;
        }

        public Criteria andFvalueNotIn(List<BigDecimal> values) {
            addCriterion("fvalue not in", values, "fvalue");
            return (Criteria) this;
        }

        public Criteria andFvalueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fvalue between", value1, value2, "fvalue");
            return (Criteria) this;
        }

        public Criteria andFvalueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fvalue not between", value1, value2, "fvalue");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeIsNull() {
            addCriterion("fvalue_type is null");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeIsNotNull() {
            addCriterion("fvalue_type is not null");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeEqualTo(String value) {
            addCriterion("fvalue_type =", value, "fvalueType");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeNotEqualTo(String value) {
            addCriterion("fvalue_type <>", value, "fvalueType");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeGreaterThan(String value) {
            addCriterion("fvalue_type >", value, "fvalueType");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fvalue_type >=", value, "fvalueType");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeLessThan(String value) {
            addCriterion("fvalue_type <", value, "fvalueType");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeLessThanOrEqualTo(String value) {
            addCriterion("fvalue_type <=", value, "fvalueType");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeLike(String value) {
            addCriterion("fvalue_type like", value, "fvalueType");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeNotLike(String value) {
            addCriterion("fvalue_type not like", value, "fvalueType");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeIn(List<String> values) {
            addCriterion("fvalue_type in", values, "fvalueType");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeNotIn(List<String> values) {
            addCriterion("fvalue_type not in", values, "fvalueType");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeBetween(String value1, String value2) {
            addCriterion("fvalue_type between", value1, value2, "fvalueType");
            return (Criteria) this;
        }

        public Criteria andFvalueTypeNotBetween(String value1, String value2) {
            addCriterion("fvalue_type not between", value1, value2, "fvalueType");
            return (Criteria) this;
        }

        public Criteria andFcreatimeIsNull() {
            addCriterion("fcreatime is null");
            return (Criteria) this;
        }

        public Criteria andFcreatimeIsNotNull() {
            addCriterion("fcreatime is not null");
            return (Criteria) this;
        }

        public Criteria andFcreatimeEqualTo(Date value) {
            addCriterion("fcreatime =", value, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeNotEqualTo(Date value) {
            addCriterion("fcreatime <>", value, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeGreaterThan(Date value) {
            addCriterion("fcreatime >", value, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fcreatime >=", value, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeLessThan(Date value) {
            addCriterion("fcreatime <", value, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeLessThanOrEqualTo(Date value) {
            addCriterion("fcreatime <=", value, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeIn(List<Date> values) {
            addCriterion("fcreatime in", values, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeNotIn(List<Date> values) {
            addCriterion("fcreatime not in", values, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeBetween(Date value1, Date value2) {
            addCriterion("fcreatime between", value1, value2, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFcreatimeNotBetween(Date value1, Date value2) {
            addCriterion("fcreatime not between", value1, value2, "fcreatime");
            return (Criteria) this;
        }

        public Criteria andFupdatimeIsNull() {
            addCriterion("fupdatime is null");
            return (Criteria) this;
        }

        public Criteria andFupdatimeIsNotNull() {
            addCriterion("fupdatime is not null");
            return (Criteria) this;
        }

        public Criteria andFupdatimeEqualTo(Date value) {
            addCriterion("fupdatime =", value, "fupdatime");
            return (Criteria) this;
        }

        public Criteria andFupdatimeNotEqualTo(Date value) {
            addCriterion("fupdatime <>", value, "fupdatime");
            return (Criteria) this;
        }

        public Criteria andFupdatimeGreaterThan(Date value) {
            addCriterion("fupdatime >", value, "fupdatime");
            return (Criteria) this;
        }

        public Criteria andFupdatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fupdatime >=", value, "fupdatime");
            return (Criteria) this;
        }

        public Criteria andFupdatimeLessThan(Date value) {
            addCriterion("fupdatime <", value, "fupdatime");
            return (Criteria) this;
        }

        public Criteria andFupdatimeLessThanOrEqualTo(Date value) {
            addCriterion("fupdatime <=", value, "fupdatime");
            return (Criteria) this;
        }

        public Criteria andFupdatimeIn(List<Date> values) {
            addCriterion("fupdatime in", values, "fupdatime");
            return (Criteria) this;
        }

        public Criteria andFupdatimeNotIn(List<Date> values) {
            addCriterion("fupdatime not in", values, "fupdatime");
            return (Criteria) this;
        }

        public Criteria andFupdatimeBetween(Date value1, Date value2) {
            addCriterion("fupdatime between", value1, value2, "fupdatime");
            return (Criteria) this;
        }

        public Criteria andFupdatimeNotBetween(Date value1, Date value2) {
            addCriterion("fupdatime not between", value1, value2, "fupdatime");
            return (Criteria) this;
        }

        public Criteria andFunitIsNull() {
            addCriterion("funit is null");
            return (Criteria) this;
        }

        public Criteria andFunitIsNotNull() {
            addCriterion("funit is not null");
            return (Criteria) this;
        }

        public Criteria andFunitEqualTo(String value) {
            addCriterion("funit =", value, "funit");
            return (Criteria) this;
        }

        public Criteria andFunitNotEqualTo(String value) {
            addCriterion("funit <>", value, "funit");
            return (Criteria) this;
        }

        public Criteria andFunitGreaterThan(String value) {
            addCriterion("funit >", value, "funit");
            return (Criteria) this;
        }

        public Criteria andFunitGreaterThanOrEqualTo(String value) {
            addCriterion("funit >=", value, "funit");
            return (Criteria) this;
        }

        public Criteria andFunitLessThan(String value) {
            addCriterion("funit <", value, "funit");
            return (Criteria) this;
        }

        public Criteria andFunitLessThanOrEqualTo(String value) {
            addCriterion("funit <=", value, "funit");
            return (Criteria) this;
        }

        public Criteria andFunitLike(String value) {
            addCriterion("funit like", value, "funit");
            return (Criteria) this;
        }

        public Criteria andFunitNotLike(String value) {
            addCriterion("funit not like", value, "funit");
            return (Criteria) this;
        }

        public Criteria andFunitIn(List<String> values) {
            addCriterion("funit in", values, "funit");
            return (Criteria) this;
        }

        public Criteria andFunitNotIn(List<String> values) {
            addCriterion("funit not in", values, "funit");
            return (Criteria) this;
        }

        public Criteria andFunitBetween(String value1, String value2) {
            addCriterion("funit between", value1, value2, "funit");
            return (Criteria) this;
        }

        public Criteria andFunitNotBetween(String value1, String value2) {
            addCriterion("funit not between", value1, value2, "funit");
            return (Criteria) this;
        }

        public Criteria andFdimensionIsNull() {
            addCriterion("fdimension is null");
            return (Criteria) this;
        }

        public Criteria andFdimensionIsNotNull() {
            addCriterion("fdimension is not null");
            return (Criteria) this;
        }

        public Criteria andFdimensionEqualTo(String value) {
            addCriterion("fdimension =", value, "fdimension");
            return (Criteria) this;
        }

        public Criteria andFdimensionNotEqualTo(String value) {
            addCriterion("fdimension <>", value, "fdimension");
            return (Criteria) this;
        }

        public Criteria andFdimensionGreaterThan(String value) {
            addCriterion("fdimension >", value, "fdimension");
            return (Criteria) this;
        }

        public Criteria andFdimensionGreaterThanOrEqualTo(String value) {
            addCriterion("fdimension >=", value, "fdimension");
            return (Criteria) this;
        }

        public Criteria andFdimensionLessThan(String value) {
            addCriterion("fdimension <", value, "fdimension");
            return (Criteria) this;
        }

        public Criteria andFdimensionLessThanOrEqualTo(String value) {
            addCriterion("fdimension <=", value, "fdimension");
            return (Criteria) this;
        }

        public Criteria andFdimensionLike(String value) {
            addCriterion("fdimension like", value, "fdimension");
            return (Criteria) this;
        }

        public Criteria andFdimensionNotLike(String value) {
            addCriterion("fdimension not like", value, "fdimension");
            return (Criteria) this;
        }

        public Criteria andFdimensionIn(List<String> values) {
            addCriterion("fdimension in", values, "fdimension");
            return (Criteria) this;
        }

        public Criteria andFdimensionNotIn(List<String> values) {
            addCriterion("fdimension not in", values, "fdimension");
            return (Criteria) this;
        }

        public Criteria andFdimensionBetween(String value1, String value2) {
            addCriterion("fdimension between", value1, value2, "fdimension");
            return (Criteria) this;
        }

        public Criteria andFdimensionNotBetween(String value1, String value2) {
            addCriterion("fdimension not between", value1, value2, "fdimension");
            return (Criteria) this;
        }

        public Criteria andFremarkIsNull() {
            addCriterion("fremark is null");
            return (Criteria) this;
        }

        public Criteria andFremarkIsNotNull() {
            addCriterion("fremark is not null");
            return (Criteria) this;
        }

        public Criteria andFremarkEqualTo(String value) {
            addCriterion("fremark =", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotEqualTo(String value) {
            addCriterion("fremark <>", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkGreaterThan(String value) {
            addCriterion("fremark >", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkGreaterThanOrEqualTo(String value) {
            addCriterion("fremark >=", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkLessThan(String value) {
            addCriterion("fremark <", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkLessThanOrEqualTo(String value) {
            addCriterion("fremark <=", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkLike(String value) {
            addCriterion("fremark like", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotLike(String value) {
            addCriterion("fremark not like", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkIn(List<String> values) {
            addCriterion("fremark in", values, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotIn(List<String> values) {
            addCriterion("fremark not in", values, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkBetween(String value1, String value2) {
            addCriterion("fremark between", value1, value2, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotBetween(String value1, String value2) {
            addCriterion("fremark not between", value1, value2, "fremark");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorIsNull() {
            addCriterion("flast_updator is null");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorIsNotNull() {
            addCriterion("flast_updator is not null");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorEqualTo(String value) {
            addCriterion("flast_updator =", value, "flastUpdator");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorNotEqualTo(String value) {
            addCriterion("flast_updator <>", value, "flastUpdator");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorGreaterThan(String value) {
            addCriterion("flast_updator >", value, "flastUpdator");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorGreaterThanOrEqualTo(String value) {
            addCriterion("flast_updator >=", value, "flastUpdator");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorLessThan(String value) {
            addCriterion("flast_updator <", value, "flastUpdator");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorLessThanOrEqualTo(String value) {
            addCriterion("flast_updator <=", value, "flastUpdator");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorLike(String value) {
            addCriterion("flast_updator like", value, "flastUpdator");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorNotLike(String value) {
            addCriterion("flast_updator not like", value, "flastUpdator");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorIn(List<String> values) {
            addCriterion("flast_updator in", values, "flastUpdator");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorNotIn(List<String> values) {
            addCriterion("flast_updator not in", values, "flastUpdator");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorBetween(String value1, String value2) {
            addCriterion("flast_updator between", value1, value2, "flastUpdator");
            return (Criteria) this;
        }

        public Criteria andFlastUpdatorNotBetween(String value1, String value2) {
            addCriterion("flast_updator not between", value1, value2, "flastUpdator");
            return (Criteria) this;
        }

        public Criteria andFsmallClassIsNull() {
            addCriterion("fsmall_class is null");
            return (Criteria) this;
        }

        public Criteria andFsmallClassIsNotNull() {
            addCriterion("fsmall_class is not null");
            return (Criteria) this;
        }

        public Criteria andFsmallClassEqualTo(String value) {
            addCriterion("fsmall_class =", value, "fsmallClass");
            return (Criteria) this;
        }

        public Criteria andFsmallClassNotEqualTo(String value) {
            addCriterion("fsmall_class <>", value, "fsmallClass");
            return (Criteria) this;
        }

        public Criteria andFsmallClassGreaterThan(String value) {
            addCriterion("fsmall_class >", value, "fsmallClass");
            return (Criteria) this;
        }

        public Criteria andFsmallClassGreaterThanOrEqualTo(String value) {
            addCriterion("fsmall_class >=", value, "fsmallClass");
            return (Criteria) this;
        }

        public Criteria andFsmallClassLessThan(String value) {
            addCriterion("fsmall_class <", value, "fsmallClass");
            return (Criteria) this;
        }

        public Criteria andFsmallClassLessThanOrEqualTo(String value) {
            addCriterion("fsmall_class <=", value, "fsmallClass");
            return (Criteria) this;
        }

        public Criteria andFsmallClassLike(String value) {
            addCriterion("fsmall_class like", value, "fsmallClass");
            return (Criteria) this;
        }

        public Criteria andFsmallClassNotLike(String value) {
            addCriterion("fsmall_class not like", value, "fsmallClass");
            return (Criteria) this;
        }

        public Criteria andFsmallClassIn(List<String> values) {
            addCriterion("fsmall_class in", values, "fsmallClass");
            return (Criteria) this;
        }

        public Criteria andFsmallClassNotIn(List<String> values) {
            addCriterion("fsmall_class not in", values, "fsmallClass");
            return (Criteria) this;
        }

        public Criteria andFsmallClassBetween(String value1, String value2) {
            addCriterion("fsmall_class between", value1, value2, "fsmallClass");
            return (Criteria) this;
        }

        public Criteria andFsmallClassNotBetween(String value1, String value2) {
            addCriterion("fsmall_class not between", value1, value2, "fsmallClass");
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