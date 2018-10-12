package com.roncoo.adminlte.bean.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSysUserLogsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TSysUserLogsExample() {
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

        public Criteria andFuserAccountIsNull() {
            addCriterion("fuser_account is null");
            return (Criteria) this;
        }

        public Criteria andFuserAccountIsNotNull() {
            addCriterion("fuser_account is not null");
            return (Criteria) this;
        }

        public Criteria andFuserAccountEqualTo(String value) {
            addCriterion("fuser_account =", value, "fuserAccount");
            return (Criteria) this;
        }

        public Criteria andFuserAccountNotEqualTo(String value) {
            addCriterion("fuser_account <>", value, "fuserAccount");
            return (Criteria) this;
        }

        public Criteria andFuserAccountGreaterThan(String value) {
            addCriterion("fuser_account >", value, "fuserAccount");
            return (Criteria) this;
        }

        public Criteria andFuserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("fuser_account >=", value, "fuserAccount");
            return (Criteria) this;
        }

        public Criteria andFuserAccountLessThan(String value) {
            addCriterion("fuser_account <", value, "fuserAccount");
            return (Criteria) this;
        }

        public Criteria andFuserAccountLessThanOrEqualTo(String value) {
            addCriterion("fuser_account <=", value, "fuserAccount");
            return (Criteria) this;
        }

        public Criteria andFuserAccountLike(String value) {
            addCriterion("fuser_account like", value, "fuserAccount");
            return (Criteria) this;
        }

        public Criteria andFuserAccountNotLike(String value) {
            addCriterion("fuser_account not like", value, "fuserAccount");
            return (Criteria) this;
        }

        public Criteria andFuserAccountIn(List<String> values) {
            addCriterion("fuser_account in", values, "fuserAccount");
            return (Criteria) this;
        }

        public Criteria andFuserAccountNotIn(List<String> values) {
            addCriterion("fuser_account not in", values, "fuserAccount");
            return (Criteria) this;
        }

        public Criteria andFuserAccountBetween(String value1, String value2) {
            addCriterion("fuser_account between", value1, value2, "fuserAccount");
            return (Criteria) this;
        }

        public Criteria andFuserAccountNotBetween(String value1, String value2) {
            addCriterion("fuser_account not between", value1, value2, "fuserAccount");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeIsNull() {
            addCriterion("foperation_type is null");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeIsNotNull() {
            addCriterion("foperation_type is not null");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeEqualTo(String value) {
            addCriterion("foperation_type =", value, "foperationType");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeNotEqualTo(String value) {
            addCriterion("foperation_type <>", value, "foperationType");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeGreaterThan(String value) {
            addCriterion("foperation_type >", value, "foperationType");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("foperation_type >=", value, "foperationType");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeLessThan(String value) {
            addCriterion("foperation_type <", value, "foperationType");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeLessThanOrEqualTo(String value) {
            addCriterion("foperation_type <=", value, "foperationType");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeLike(String value) {
            addCriterion("foperation_type like", value, "foperationType");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeNotLike(String value) {
            addCriterion("foperation_type not like", value, "foperationType");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeIn(List<String> values) {
            addCriterion("foperation_type in", values, "foperationType");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeNotIn(List<String> values) {
            addCriterion("foperation_type not in", values, "foperationType");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeBetween(String value1, String value2) {
            addCriterion("foperation_type between", value1, value2, "foperationType");
            return (Criteria) this;
        }

        public Criteria andFoperationTypeNotBetween(String value1, String value2) {
            addCriterion("foperation_type not between", value1, value2, "foperationType");
            return (Criteria) this;
        }

        public Criteria andFuserOrgIdIsNull() {
            addCriterion("fuser_org_id is null");
            return (Criteria) this;
        }

        public Criteria andFuserOrgIdIsNotNull() {
            addCriterion("fuser_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andFuserOrgIdEqualTo(Long value) {
            addCriterion("fuser_org_id =", value, "fuserOrgId");
            return (Criteria) this;
        }

        public Criteria andFuserOrgIdNotEqualTo(Long value) {
            addCriterion("fuser_org_id <>", value, "fuserOrgId");
            return (Criteria) this;
        }

        public Criteria andFuserOrgIdGreaterThan(Long value) {
            addCriterion("fuser_org_id >", value, "fuserOrgId");
            return (Criteria) this;
        }

        public Criteria andFuserOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fuser_org_id >=", value, "fuserOrgId");
            return (Criteria) this;
        }

        public Criteria andFuserOrgIdLessThan(Long value) {
            addCriterion("fuser_org_id <", value, "fuserOrgId");
            return (Criteria) this;
        }

        public Criteria andFuserOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("fuser_org_id <=", value, "fuserOrgId");
            return (Criteria) this;
        }

        public Criteria andFuserOrgIdIn(List<Long> values) {
            addCriterion("fuser_org_id in", values, "fuserOrgId");
            return (Criteria) this;
        }

        public Criteria andFuserOrgIdNotIn(List<Long> values) {
            addCriterion("fuser_org_id not in", values, "fuserOrgId");
            return (Criteria) this;
        }

        public Criteria andFuserOrgIdBetween(Long value1, Long value2) {
            addCriterion("fuser_org_id between", value1, value2, "fuserOrgId");
            return (Criteria) this;
        }

        public Criteria andFuserOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("fuser_org_id not between", value1, value2, "fuserOrgId");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameIsNull() {
            addCriterion("fuser_org_name is null");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameIsNotNull() {
            addCriterion("fuser_org_name is not null");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameEqualTo(String value) {
            addCriterion("fuser_org_name =", value, "fuserOrgName");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameNotEqualTo(String value) {
            addCriterion("fuser_org_name <>", value, "fuserOrgName");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameGreaterThan(String value) {
            addCriterion("fuser_org_name >", value, "fuserOrgName");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("fuser_org_name >=", value, "fuserOrgName");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameLessThan(String value) {
            addCriterion("fuser_org_name <", value, "fuserOrgName");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameLessThanOrEqualTo(String value) {
            addCriterion("fuser_org_name <=", value, "fuserOrgName");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameLike(String value) {
            addCriterion("fuser_org_name like", value, "fuserOrgName");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameNotLike(String value) {
            addCriterion("fuser_org_name not like", value, "fuserOrgName");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameIn(List<String> values) {
            addCriterion("fuser_org_name in", values, "fuserOrgName");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameNotIn(List<String> values) {
            addCriterion("fuser_org_name not in", values, "fuserOrgName");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameBetween(String value1, String value2) {
            addCriterion("fuser_org_name between", value1, value2, "fuserOrgName");
            return (Criteria) this;
        }

        public Criteria andFuserOrgNameNotBetween(String value1, String value2) {
            addCriterion("fuser_org_name not between", value1, value2, "fuserOrgName");
            return (Criteria) this;
        }

        public Criteria andFresourceIsNull() {
            addCriterion("fresource is null");
            return (Criteria) this;
        }

        public Criteria andFresourceIsNotNull() {
            addCriterion("fresource is not null");
            return (Criteria) this;
        }

        public Criteria andFresourceEqualTo(String value) {
            addCriterion("fresource =", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceNotEqualTo(String value) {
            addCriterion("fresource <>", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceGreaterThan(String value) {
            addCriterion("fresource >", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceGreaterThanOrEqualTo(String value) {
            addCriterion("fresource >=", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceLessThan(String value) {
            addCriterion("fresource <", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceLessThanOrEqualTo(String value) {
            addCriterion("fresource <=", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceLike(String value) {
            addCriterion("fresource like", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceNotLike(String value) {
            addCriterion("fresource not like", value, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceIn(List<String> values) {
            addCriterion("fresource in", values, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceNotIn(List<String> values) {
            addCriterion("fresource not in", values, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceBetween(String value1, String value2) {
            addCriterion("fresource between", value1, value2, "fresource");
            return (Criteria) this;
        }

        public Criteria andFresourceNotBetween(String value1, String value2) {
            addCriterion("fresource not between", value1, value2, "fresource");
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

        public Criteria andFsourceIsNull() {
            addCriterion("fsource is null");
            return (Criteria) this;
        }

        public Criteria andFsourceIsNotNull() {
            addCriterion("fsource is not null");
            return (Criteria) this;
        }

        public Criteria andFsourceEqualTo(String value) {
            addCriterion("fsource =", value, "fsource");
            return (Criteria) this;
        }

        public Criteria andFsourceNotEqualTo(String value) {
            addCriterion("fsource <>", value, "fsource");
            return (Criteria) this;
        }

        public Criteria andFsourceGreaterThan(String value) {
            addCriterion("fsource >", value, "fsource");
            return (Criteria) this;
        }

        public Criteria andFsourceGreaterThanOrEqualTo(String value) {
            addCriterion("fsource >=", value, "fsource");
            return (Criteria) this;
        }

        public Criteria andFsourceLessThan(String value) {
            addCriterion("fsource <", value, "fsource");
            return (Criteria) this;
        }

        public Criteria andFsourceLessThanOrEqualTo(String value) {
            addCriterion("fsource <=", value, "fsource");
            return (Criteria) this;
        }

        public Criteria andFsourceLike(String value) {
            addCriterion("fsource like", value, "fsource");
            return (Criteria) this;
        }

        public Criteria andFsourceNotLike(String value) {
            addCriterion("fsource not like", value, "fsource");
            return (Criteria) this;
        }

        public Criteria andFsourceIn(List<String> values) {
            addCriterion("fsource in", values, "fsource");
            return (Criteria) this;
        }

        public Criteria andFsourceNotIn(List<String> values) {
            addCriterion("fsource not in", values, "fsource");
            return (Criteria) this;
        }

        public Criteria andFsourceBetween(String value1, String value2) {
            addCriterion("fsource between", value1, value2, "fsource");
            return (Criteria) this;
        }

        public Criteria andFsourceNotBetween(String value1, String value2) {
            addCriterion("fsource not between", value1, value2, "fsource");
            return (Criteria) this;
        }

        public Criteria andFmacAddressIsNull() {
            addCriterion("fmac_address is null");
            return (Criteria) this;
        }

        public Criteria andFmacAddressIsNotNull() {
            addCriterion("fmac_address is not null");
            return (Criteria) this;
        }

        public Criteria andFmacAddressEqualTo(String value) {
            addCriterion("fmac_address =", value, "fmacAddress");
            return (Criteria) this;
        }

        public Criteria andFmacAddressNotEqualTo(String value) {
            addCriterion("fmac_address <>", value, "fmacAddress");
            return (Criteria) this;
        }

        public Criteria andFmacAddressGreaterThan(String value) {
            addCriterion("fmac_address >", value, "fmacAddress");
            return (Criteria) this;
        }

        public Criteria andFmacAddressGreaterThanOrEqualTo(String value) {
            addCriterion("fmac_address >=", value, "fmacAddress");
            return (Criteria) this;
        }

        public Criteria andFmacAddressLessThan(String value) {
            addCriterion("fmac_address <", value, "fmacAddress");
            return (Criteria) this;
        }

        public Criteria andFmacAddressLessThanOrEqualTo(String value) {
            addCriterion("fmac_address <=", value, "fmacAddress");
            return (Criteria) this;
        }

        public Criteria andFmacAddressLike(String value) {
            addCriterion("fmac_address like", value, "fmacAddress");
            return (Criteria) this;
        }

        public Criteria andFmacAddressNotLike(String value) {
            addCriterion("fmac_address not like", value, "fmacAddress");
            return (Criteria) this;
        }

        public Criteria andFmacAddressIn(List<String> values) {
            addCriterion("fmac_address in", values, "fmacAddress");
            return (Criteria) this;
        }

        public Criteria andFmacAddressNotIn(List<String> values) {
            addCriterion("fmac_address not in", values, "fmacAddress");
            return (Criteria) this;
        }

        public Criteria andFmacAddressBetween(String value1, String value2) {
            addCriterion("fmac_address between", value1, value2, "fmacAddress");
            return (Criteria) this;
        }

        public Criteria andFmacAddressNotBetween(String value1, String value2) {
            addCriterion("fmac_address not between", value1, value2, "fmacAddress");
            return (Criteria) this;
        }

        public Criteria andFipAddressIsNull() {
            addCriterion("fip_address is null");
            return (Criteria) this;
        }

        public Criteria andFipAddressIsNotNull() {
            addCriterion("fip_address is not null");
            return (Criteria) this;
        }

        public Criteria andFipAddressEqualTo(String value) {
            addCriterion("fip_address =", value, "fipAddress");
            return (Criteria) this;
        }

        public Criteria andFipAddressNotEqualTo(String value) {
            addCriterion("fip_address <>", value, "fipAddress");
            return (Criteria) this;
        }

        public Criteria andFipAddressGreaterThan(String value) {
            addCriterion("fip_address >", value, "fipAddress");
            return (Criteria) this;
        }

        public Criteria andFipAddressGreaterThanOrEqualTo(String value) {
            addCriterion("fip_address >=", value, "fipAddress");
            return (Criteria) this;
        }

        public Criteria andFipAddressLessThan(String value) {
            addCriterion("fip_address <", value, "fipAddress");
            return (Criteria) this;
        }

        public Criteria andFipAddressLessThanOrEqualTo(String value) {
            addCriterion("fip_address <=", value, "fipAddress");
            return (Criteria) this;
        }

        public Criteria andFipAddressLike(String value) {
            addCriterion("fip_address like", value, "fipAddress");
            return (Criteria) this;
        }

        public Criteria andFipAddressNotLike(String value) {
            addCriterion("fip_address not like", value, "fipAddress");
            return (Criteria) this;
        }

        public Criteria andFipAddressIn(List<String> values) {
            addCriterion("fip_address in", values, "fipAddress");
            return (Criteria) this;
        }

        public Criteria andFipAddressNotIn(List<String> values) {
            addCriterion("fip_address not in", values, "fipAddress");
            return (Criteria) this;
        }

        public Criteria andFipAddressBetween(String value1, String value2) {
            addCriterion("fip_address between", value1, value2, "fipAddress");
            return (Criteria) this;
        }

        public Criteria andFipAddressNotBetween(String value1, String value2) {
            addCriterion("fip_address not between", value1, value2, "fipAddress");
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

        public Criteria andFerrorCodeIsNull() {
            addCriterion("ferror_code is null");
            return (Criteria) this;
        }

        public Criteria andFerrorCodeIsNotNull() {
            addCriterion("ferror_code is not null");
            return (Criteria) this;
        }

        public Criteria andFerrorCodeEqualTo(String value) {
            addCriterion("ferror_code =", value, "ferrorCode");
            return (Criteria) this;
        }

        public Criteria andFerrorCodeNotEqualTo(String value) {
            addCriterion("ferror_code <>", value, "ferrorCode");
            return (Criteria) this;
        }

        public Criteria andFerrorCodeGreaterThan(String value) {
            addCriterion("ferror_code >", value, "ferrorCode");
            return (Criteria) this;
        }

        public Criteria andFerrorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ferror_code >=", value, "ferrorCode");
            return (Criteria) this;
        }

        public Criteria andFerrorCodeLessThan(String value) {
            addCriterion("ferror_code <", value, "ferrorCode");
            return (Criteria) this;
        }

        public Criteria andFerrorCodeLessThanOrEqualTo(String value) {
            addCriterion("ferror_code <=", value, "ferrorCode");
            return (Criteria) this;
        }

        public Criteria andFerrorCodeLike(String value) {
            addCriterion("ferror_code like", value, "ferrorCode");
            return (Criteria) this;
        }

        public Criteria andFerrorCodeNotLike(String value) {
            addCriterion("ferror_code not like", value, "ferrorCode");
            return (Criteria) this;
        }

        public Criteria andFerrorCodeIn(List<String> values) {
            addCriterion("ferror_code in", values, "ferrorCode");
            return (Criteria) this;
        }

        public Criteria andFerrorCodeNotIn(List<String> values) {
            addCriterion("ferror_code not in", values, "ferrorCode");
            return (Criteria) this;
        }

        public Criteria andFerrorCodeBetween(String value1, String value2) {
            addCriterion("ferror_code between", value1, value2, "ferrorCode");
            return (Criteria) this;
        }

        public Criteria andFerrorCodeNotBetween(String value1, String value2) {
            addCriterion("ferror_code not between", value1, value2, "ferrorCode");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgIsNull() {
            addCriterion("ferror_msg is null");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgIsNotNull() {
            addCriterion("ferror_msg is not null");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgEqualTo(String value) {
            addCriterion("ferror_msg =", value, "ferrorMsg");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgNotEqualTo(String value) {
            addCriterion("ferror_msg <>", value, "ferrorMsg");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgGreaterThan(String value) {
            addCriterion("ferror_msg >", value, "ferrorMsg");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgGreaterThanOrEqualTo(String value) {
            addCriterion("ferror_msg >=", value, "ferrorMsg");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgLessThan(String value) {
            addCriterion("ferror_msg <", value, "ferrorMsg");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgLessThanOrEqualTo(String value) {
            addCriterion("ferror_msg <=", value, "ferrorMsg");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgLike(String value) {
            addCriterion("ferror_msg like", value, "ferrorMsg");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgNotLike(String value) {
            addCriterion("ferror_msg not like", value, "ferrorMsg");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgIn(List<String> values) {
            addCriterion("ferror_msg in", values, "ferrorMsg");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgNotIn(List<String> values) {
            addCriterion("ferror_msg not in", values, "ferrorMsg");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgBetween(String value1, String value2) {
            addCriterion("ferror_msg between", value1, value2, "ferrorMsg");
            return (Criteria) this;
        }

        public Criteria andFerrorMsgNotBetween(String value1, String value2) {
            addCriterion("ferror_msg not between", value1, value2, "ferrorMsg");
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