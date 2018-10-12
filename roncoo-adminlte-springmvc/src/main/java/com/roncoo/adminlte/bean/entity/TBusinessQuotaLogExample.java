package com.roncoo.adminlte.bean.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TBusinessQuotaLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TBusinessQuotaLogExample() {
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

        public Criteria andFquotaIdIsNull() {
            addCriterion("fquota_id is null");
            return (Criteria) this;
        }

        public Criteria andFquotaIdIsNotNull() {
            addCriterion("fquota_id is not null");
            return (Criteria) this;
        }

        public Criteria andFquotaIdEqualTo(Long value) {
            addCriterion("fquota_id =", value, "fquotaId");
            return (Criteria) this;
        }

        public Criteria andFquotaIdNotEqualTo(Long value) {
            addCriterion("fquota_id <>", value, "fquotaId");
            return (Criteria) this;
        }

        public Criteria andFquotaIdGreaterThan(Long value) {
            addCriterion("fquota_id >", value, "fquotaId");
            return (Criteria) this;
        }

        public Criteria andFquotaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fquota_id >=", value, "fquotaId");
            return (Criteria) this;
        }

        public Criteria andFquotaIdLessThan(Long value) {
            addCriterion("fquota_id <", value, "fquotaId");
            return (Criteria) this;
        }

        public Criteria andFquotaIdLessThanOrEqualTo(Long value) {
            addCriterion("fquota_id <=", value, "fquotaId");
            return (Criteria) this;
        }

        public Criteria andFquotaIdIn(List<Long> values) {
            addCriterion("fquota_id in", values, "fquotaId");
            return (Criteria) this;
        }

        public Criteria andFquotaIdNotIn(List<Long> values) {
            addCriterion("fquota_id not in", values, "fquotaId");
            return (Criteria) this;
        }

        public Criteria andFquotaIdBetween(Long value1, Long value2) {
            addCriterion("fquota_id between", value1, value2, "fquotaId");
            return (Criteria) this;
        }

        public Criteria andFquotaIdNotBetween(Long value1, Long value2) {
            addCriterion("fquota_id not between", value1, value2, "fquotaId");
            return (Criteria) this;
        }

        public Criteria andFquotaNameIsNull() {
            addCriterion("fquota_name is null");
            return (Criteria) this;
        }

        public Criteria andFquotaNameIsNotNull() {
            addCriterion("fquota_name is not null");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEqualTo(String value) {
            addCriterion("fquota_name =", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameNotEqualTo(String value) {
            addCriterion("fquota_name <>", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameGreaterThan(String value) {
            addCriterion("fquota_name >", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameGreaterThanOrEqualTo(String value) {
            addCriterion("fquota_name >=", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameLessThan(String value) {
            addCriterion("fquota_name <", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameLessThanOrEqualTo(String value) {
            addCriterion("fquota_name <=", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameLike(String value) {
            addCriterion("fquota_name like", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameNotLike(String value) {
            addCriterion("fquota_name not like", value, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameIn(List<String> values) {
            addCriterion("fquota_name in", values, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameNotIn(List<String> values) {
            addCriterion("fquota_name not in", values, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameBetween(String value1, String value2) {
            addCriterion("fquota_name between", value1, value2, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameNotBetween(String value1, String value2) {
            addCriterion("fquota_name not between", value1, value2, "fquotaName");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnIsNull() {
            addCriterion("fquota_name_en is null");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnIsNotNull() {
            addCriterion("fquota_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnEqualTo(String value) {
            addCriterion("fquota_name_en =", value, "fquotaNameEn");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnNotEqualTo(String value) {
            addCriterion("fquota_name_en <>", value, "fquotaNameEn");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnGreaterThan(String value) {
            addCriterion("fquota_name_en >", value, "fquotaNameEn");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("fquota_name_en >=", value, "fquotaNameEn");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnLessThan(String value) {
            addCriterion("fquota_name_en <", value, "fquotaNameEn");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnLessThanOrEqualTo(String value) {
            addCriterion("fquota_name_en <=", value, "fquotaNameEn");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnLike(String value) {
            addCriterion("fquota_name_en like", value, "fquotaNameEn");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnNotLike(String value) {
            addCriterion("fquota_name_en not like", value, "fquotaNameEn");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnIn(List<String> values) {
            addCriterion("fquota_name_en in", values, "fquotaNameEn");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnNotIn(List<String> values) {
            addCriterion("fquota_name_en not in", values, "fquotaNameEn");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnBetween(String value1, String value2) {
            addCriterion("fquota_name_en between", value1, value2, "fquotaNameEn");
            return (Criteria) this;
        }

        public Criteria andFquotaNameEnNotBetween(String value1, String value2) {
            addCriterion("fquota_name_en not between", value1, value2, "fquotaNameEn");
            return (Criteria) this;
        }

        public Criteria andFquotaOldValueIsNull() {
            addCriterion("fquota_old_value is null");
            return (Criteria) this;
        }

        public Criteria andFquotaOldValueIsNotNull() {
            addCriterion("fquota_old_value is not null");
            return (Criteria) this;
        }

        public Criteria andFquotaOldValueEqualTo(Long value) {
            addCriterion("fquota_old_value =", value, "fquotaOldValue");
            return (Criteria) this;
        }

        public Criteria andFquotaOldValueNotEqualTo(Long value) {
            addCriterion("fquota_old_value <>", value, "fquotaOldValue");
            return (Criteria) this;
        }

        public Criteria andFquotaOldValueGreaterThan(Long value) {
            addCriterion("fquota_old_value >", value, "fquotaOldValue");
            return (Criteria) this;
        }

        public Criteria andFquotaOldValueGreaterThanOrEqualTo(Long value) {
            addCriterion("fquota_old_value >=", value, "fquotaOldValue");
            return (Criteria) this;
        }

        public Criteria andFquotaOldValueLessThan(Long value) {
            addCriterion("fquota_old_value <", value, "fquotaOldValue");
            return (Criteria) this;
        }

        public Criteria andFquotaOldValueLessThanOrEqualTo(Long value) {
            addCriterion("fquota_old_value <=", value, "fquotaOldValue");
            return (Criteria) this;
        }

        public Criteria andFquotaOldValueIn(List<Long> values) {
            addCriterion("fquota_old_value in", values, "fquotaOldValue");
            return (Criteria) this;
        }

        public Criteria andFquotaOldValueNotIn(List<Long> values) {
            addCriterion("fquota_old_value not in", values, "fquotaOldValue");
            return (Criteria) this;
        }

        public Criteria andFquotaOldValueBetween(Long value1, Long value2) {
            addCriterion("fquota_old_value between", value1, value2, "fquotaOldValue");
            return (Criteria) this;
        }

        public Criteria andFquotaOldValueNotBetween(Long value1, Long value2) {
            addCriterion("fquota_old_value not between", value1, value2, "fquotaOldValue");
            return (Criteria) this;
        }

        public Criteria andFquotaNewValueIsNull() {
            addCriterion("fquota_new_value is null");
            return (Criteria) this;
        }

        public Criteria andFquotaNewValueIsNotNull() {
            addCriterion("fquota_new_value is not null");
            return (Criteria) this;
        }

        public Criteria andFquotaNewValueEqualTo(Long value) {
            addCriterion("fquota_new_value =", value, "fquotaNewValue");
            return (Criteria) this;
        }

        public Criteria andFquotaNewValueNotEqualTo(Long value) {
            addCriterion("fquota_new_value <>", value, "fquotaNewValue");
            return (Criteria) this;
        }

        public Criteria andFquotaNewValueGreaterThan(Long value) {
            addCriterion("fquota_new_value >", value, "fquotaNewValue");
            return (Criteria) this;
        }

        public Criteria andFquotaNewValueGreaterThanOrEqualTo(Long value) {
            addCriterion("fquota_new_value >=", value, "fquotaNewValue");
            return (Criteria) this;
        }

        public Criteria andFquotaNewValueLessThan(Long value) {
            addCriterion("fquota_new_value <", value, "fquotaNewValue");
            return (Criteria) this;
        }

        public Criteria andFquotaNewValueLessThanOrEqualTo(Long value) {
            addCriterion("fquota_new_value <=", value, "fquotaNewValue");
            return (Criteria) this;
        }

        public Criteria andFquotaNewValueIn(List<Long> values) {
            addCriterion("fquota_new_value in", values, "fquotaNewValue");
            return (Criteria) this;
        }

        public Criteria andFquotaNewValueNotIn(List<Long> values) {
            addCriterion("fquota_new_value not in", values, "fquotaNewValue");
            return (Criteria) this;
        }

        public Criteria andFquotaNewValueBetween(Long value1, Long value2) {
            addCriterion("fquota_new_value between", value1, value2, "fquotaNewValue");
            return (Criteria) this;
        }

        public Criteria andFquotaNewValueNotBetween(Long value1, Long value2) {
            addCriterion("fquota_new_value not between", value1, value2, "fquotaNewValue");
            return (Criteria) this;
        }

        public Criteria andFuserIdIsNull() {
            addCriterion("fuser_id is null");
            return (Criteria) this;
        }

        public Criteria andFuserIdIsNotNull() {
            addCriterion("fuser_id is not null");
            return (Criteria) this;
        }

        public Criteria andFuserIdEqualTo(Long value) {
            addCriterion("fuser_id =", value, "fuserId");
            return (Criteria) this;
        }

        public Criteria andFuserIdNotEqualTo(Long value) {
            addCriterion("fuser_id <>", value, "fuserId");
            return (Criteria) this;
        }

        public Criteria andFuserIdGreaterThan(Long value) {
            addCriterion("fuser_id >", value, "fuserId");
            return (Criteria) this;
        }

        public Criteria andFuserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fuser_id >=", value, "fuserId");
            return (Criteria) this;
        }

        public Criteria andFuserIdLessThan(Long value) {
            addCriterion("fuser_id <", value, "fuserId");
            return (Criteria) this;
        }

        public Criteria andFuserIdLessThanOrEqualTo(Long value) {
            addCriterion("fuser_id <=", value, "fuserId");
            return (Criteria) this;
        }

        public Criteria andFuserIdIn(List<Long> values) {
            addCriterion("fuser_id in", values, "fuserId");
            return (Criteria) this;
        }

        public Criteria andFuserIdNotIn(List<Long> values) {
            addCriterion("fuser_id not in", values, "fuserId");
            return (Criteria) this;
        }

        public Criteria andFuserIdBetween(Long value1, Long value2) {
            addCriterion("fuser_id between", value1, value2, "fuserId");
            return (Criteria) this;
        }

        public Criteria andFuserIdNotBetween(Long value1, Long value2) {
            addCriterion("fuser_id not between", value1, value2, "fuserId");
            return (Criteria) this;
        }

        public Criteria andFuserNoIsNull() {
            addCriterion("fuser_no is null");
            return (Criteria) this;
        }

        public Criteria andFuserNoIsNotNull() {
            addCriterion("fuser_no is not null");
            return (Criteria) this;
        }

        public Criteria andFuserNoEqualTo(String value) {
            addCriterion("fuser_no =", value, "fuserNo");
            return (Criteria) this;
        }

        public Criteria andFuserNoNotEqualTo(String value) {
            addCriterion("fuser_no <>", value, "fuserNo");
            return (Criteria) this;
        }

        public Criteria andFuserNoGreaterThan(String value) {
            addCriterion("fuser_no >", value, "fuserNo");
            return (Criteria) this;
        }

        public Criteria andFuserNoGreaterThanOrEqualTo(String value) {
            addCriterion("fuser_no >=", value, "fuserNo");
            return (Criteria) this;
        }

        public Criteria andFuserNoLessThan(String value) {
            addCriterion("fuser_no <", value, "fuserNo");
            return (Criteria) this;
        }

        public Criteria andFuserNoLessThanOrEqualTo(String value) {
            addCriterion("fuser_no <=", value, "fuserNo");
            return (Criteria) this;
        }

        public Criteria andFuserNoLike(String value) {
            addCriterion("fuser_no like", value, "fuserNo");
            return (Criteria) this;
        }

        public Criteria andFuserNoNotLike(String value) {
            addCriterion("fuser_no not like", value, "fuserNo");
            return (Criteria) this;
        }

        public Criteria andFuserNoIn(List<String> values) {
            addCriterion("fuser_no in", values, "fuserNo");
            return (Criteria) this;
        }

        public Criteria andFuserNoNotIn(List<String> values) {
            addCriterion("fuser_no not in", values, "fuserNo");
            return (Criteria) this;
        }

        public Criteria andFuserNoBetween(String value1, String value2) {
            addCriterion("fuser_no between", value1, value2, "fuserNo");
            return (Criteria) this;
        }

        public Criteria andFuserNoNotBetween(String value1, String value2) {
            addCriterion("fuser_no not between", value1, value2, "fuserNo");
            return (Criteria) this;
        }

        public Criteria andFuserNameIsNull() {
            addCriterion("fuser_name is null");
            return (Criteria) this;
        }

        public Criteria andFuserNameIsNotNull() {
            addCriterion("fuser_name is not null");
            return (Criteria) this;
        }

        public Criteria andFuserNameEqualTo(String value) {
            addCriterion("fuser_name =", value, "fuserName");
            return (Criteria) this;
        }

        public Criteria andFuserNameNotEqualTo(String value) {
            addCriterion("fuser_name <>", value, "fuserName");
            return (Criteria) this;
        }

        public Criteria andFuserNameGreaterThan(String value) {
            addCriterion("fuser_name >", value, "fuserName");
            return (Criteria) this;
        }

        public Criteria andFuserNameGreaterThanOrEqualTo(String value) {
            addCriterion("fuser_name >=", value, "fuserName");
            return (Criteria) this;
        }

        public Criteria andFuserNameLessThan(String value) {
            addCriterion("fuser_name <", value, "fuserName");
            return (Criteria) this;
        }

        public Criteria andFuserNameLessThanOrEqualTo(String value) {
            addCriterion("fuser_name <=", value, "fuserName");
            return (Criteria) this;
        }

        public Criteria andFuserNameLike(String value) {
            addCriterion("fuser_name like", value, "fuserName");
            return (Criteria) this;
        }

        public Criteria andFuserNameNotLike(String value) {
            addCriterion("fuser_name not like", value, "fuserName");
            return (Criteria) this;
        }

        public Criteria andFuserNameIn(List<String> values) {
            addCriterion("fuser_name in", values, "fuserName");
            return (Criteria) this;
        }

        public Criteria andFuserNameNotIn(List<String> values) {
            addCriterion("fuser_name not in", values, "fuserName");
            return (Criteria) this;
        }

        public Criteria andFuserNameBetween(String value1, String value2) {
            addCriterion("fuser_name between", value1, value2, "fuserName");
            return (Criteria) this;
        }

        public Criteria andFuserNameNotBetween(String value1, String value2) {
            addCriterion("fuser_name not between", value1, value2, "fuserName");
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