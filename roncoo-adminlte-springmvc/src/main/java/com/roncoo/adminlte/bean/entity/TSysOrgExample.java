package com.roncoo.adminlte.bean.entity;

import java.util.ArrayList;
import java.util.List;

public class TSysOrgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TSysOrgExample() {
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

        public Criteria andFcodeIsNull() {
            addCriterion("fcode is null");
            return (Criteria) this;
        }

        public Criteria andFcodeIsNotNull() {
            addCriterion("fcode is not null");
            return (Criteria) this;
        }

        public Criteria andFcodeEqualTo(String value) {
            addCriterion("fcode =", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotEqualTo(String value) {
            addCriterion("fcode <>", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeGreaterThan(String value) {
            addCriterion("fcode >", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeGreaterThanOrEqualTo(String value) {
            addCriterion("fcode >=", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeLessThan(String value) {
            addCriterion("fcode <", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeLessThanOrEqualTo(String value) {
            addCriterion("fcode <=", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeLike(String value) {
            addCriterion("fcode like", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotLike(String value) {
            addCriterion("fcode not like", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeIn(List<String> values) {
            addCriterion("fcode in", values, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotIn(List<String> values) {
            addCriterion("fcode not in", values, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeBetween(String value1, String value2) {
            addCriterion("fcode between", value1, value2, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotBetween(String value1, String value2) {
            addCriterion("fcode not between", value1, value2, "fcode");
            return (Criteria) this;
        }

        public Criteria andFnameIsNull() {
            addCriterion("fname is null");
            return (Criteria) this;
        }

        public Criteria andFnameIsNotNull() {
            addCriterion("fname is not null");
            return (Criteria) this;
        }

        public Criteria andFnameEqualTo(String value) {
            addCriterion("fname =", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotEqualTo(String value) {
            addCriterion("fname <>", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThan(String value) {
            addCriterion("fname >", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThanOrEqualTo(String value) {
            addCriterion("fname >=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThan(String value) {
            addCriterion("fname <", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThanOrEqualTo(String value) {
            addCriterion("fname <=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLike(String value) {
            addCriterion("fname like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotLike(String value) {
            addCriterion("fname not like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameIn(List<String> values) {
            addCriterion("fname in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotIn(List<String> values) {
            addCriterion("fname not in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameBetween(String value1, String value2) {
            addCriterion("fname between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotBetween(String value1, String value2) {
            addCriterion("fname not between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFlongCodeIsNull() {
            addCriterion("flong_code is null");
            return (Criteria) this;
        }

        public Criteria andFlongCodeIsNotNull() {
            addCriterion("flong_code is not null");
            return (Criteria) this;
        }

        public Criteria andFlongCodeEqualTo(String value) {
            addCriterion("flong_code =", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeNotEqualTo(String value) {
            addCriterion("flong_code <>", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeGreaterThan(String value) {
            addCriterion("flong_code >", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeGreaterThanOrEqualTo(String value) {
            addCriterion("flong_code >=", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeLessThan(String value) {
            addCriterion("flong_code <", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeLessThanOrEqualTo(String value) {
            addCriterion("flong_code <=", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeLike(String value) {
            addCriterion("flong_code like", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeNotLike(String value) {
            addCriterion("flong_code not like", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeIn(List<String> values) {
            addCriterion("flong_code in", values, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeNotIn(List<String> values) {
            addCriterion("flong_code not in", values, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeBetween(String value1, String value2) {
            addCriterion("flong_code between", value1, value2, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeNotBetween(String value1, String value2) {
            addCriterion("flong_code not between", value1, value2, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFparentIdIsNull() {
            addCriterion("fparent_id is null");
            return (Criteria) this;
        }

        public Criteria andFparentIdIsNotNull() {
            addCriterion("fparent_id is not null");
            return (Criteria) this;
        }

        public Criteria andFparentIdEqualTo(Long value) {
            addCriterion("fparent_id =", value, "fparentId");
            return (Criteria) this;
        }

        public Criteria andFparentIdNotEqualTo(Long value) {
            addCriterion("fparent_id <>", value, "fparentId");
            return (Criteria) this;
        }

        public Criteria andFparentIdGreaterThan(Long value) {
            addCriterion("fparent_id >", value, "fparentId");
            return (Criteria) this;
        }

        public Criteria andFparentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fparent_id >=", value, "fparentId");
            return (Criteria) this;
        }

        public Criteria andFparentIdLessThan(Long value) {
            addCriterion("fparent_id <", value, "fparentId");
            return (Criteria) this;
        }

        public Criteria andFparentIdLessThanOrEqualTo(Long value) {
            addCriterion("fparent_id <=", value, "fparentId");
            return (Criteria) this;
        }

        public Criteria andFparentIdIn(List<Long> values) {
            addCriterion("fparent_id in", values, "fparentId");
            return (Criteria) this;
        }

        public Criteria andFparentIdNotIn(List<Long> values) {
            addCriterion("fparent_id not in", values, "fparentId");
            return (Criteria) this;
        }

        public Criteria andFparentIdBetween(Long value1, Long value2) {
            addCriterion("fparent_id between", value1, value2, "fparentId");
            return (Criteria) this;
        }

        public Criteria andFparentIdNotBetween(Long value1, Long value2) {
            addCriterion("fparent_id not between", value1, value2, "fparentId");
            return (Criteria) this;
        }

        public Criteria andFparentNameIsNull() {
            addCriterion("fparent_name is null");
            return (Criteria) this;
        }

        public Criteria andFparentNameIsNotNull() {
            addCriterion("fparent_name is not null");
            return (Criteria) this;
        }

        public Criteria andFparentNameEqualTo(String value) {
            addCriterion("fparent_name =", value, "fparentName");
            return (Criteria) this;
        }

        public Criteria andFparentNameNotEqualTo(String value) {
            addCriterion("fparent_name <>", value, "fparentName");
            return (Criteria) this;
        }

        public Criteria andFparentNameGreaterThan(String value) {
            addCriterion("fparent_name >", value, "fparentName");
            return (Criteria) this;
        }

        public Criteria andFparentNameGreaterThanOrEqualTo(String value) {
            addCriterion("fparent_name >=", value, "fparentName");
            return (Criteria) this;
        }

        public Criteria andFparentNameLessThan(String value) {
            addCriterion("fparent_name <", value, "fparentName");
            return (Criteria) this;
        }

        public Criteria andFparentNameLessThanOrEqualTo(String value) {
            addCriterion("fparent_name <=", value, "fparentName");
            return (Criteria) this;
        }

        public Criteria andFparentNameLike(String value) {
            addCriterion("fparent_name like", value, "fparentName");
            return (Criteria) this;
        }

        public Criteria andFparentNameNotLike(String value) {
            addCriterion("fparent_name not like", value, "fparentName");
            return (Criteria) this;
        }

        public Criteria andFparentNameIn(List<String> values) {
            addCriterion("fparent_name in", values, "fparentName");
            return (Criteria) this;
        }

        public Criteria andFparentNameNotIn(List<String> values) {
            addCriterion("fparent_name not in", values, "fparentName");
            return (Criteria) this;
        }

        public Criteria andFparentNameBetween(String value1, String value2) {
            addCriterion("fparent_name between", value1, value2, "fparentName");
            return (Criteria) this;
        }

        public Criteria andFparentNameNotBetween(String value1, String value2) {
            addCriterion("fparent_name not between", value1, value2, "fparentName");
            return (Criteria) this;
        }

        public Criteria andFposIsNull() {
            addCriterion("fpos is null");
            return (Criteria) this;
        }

        public Criteria andFposIsNotNull() {
            addCriterion("fpos is not null");
            return (Criteria) this;
        }

        public Criteria andFposEqualTo(Integer value) {
            addCriterion("fpos =", value, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposNotEqualTo(Integer value) {
            addCriterion("fpos <>", value, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposGreaterThan(Integer value) {
            addCriterion("fpos >", value, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposGreaterThanOrEqualTo(Integer value) {
            addCriterion("fpos >=", value, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposLessThan(Integer value) {
            addCriterion("fpos <", value, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposLessThanOrEqualTo(Integer value) {
            addCriterion("fpos <=", value, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposIn(List<Integer> values) {
            addCriterion("fpos in", values, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposNotIn(List<Integer> values) {
            addCriterion("fpos not in", values, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposBetween(Integer value1, Integer value2) {
            addCriterion("fpos between", value1, value2, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposNotBetween(Integer value1, Integer value2) {
            addCriterion("fpos not between", value1, value2, "fpos");
            return (Criteria) this;
        }

        public Criteria andFcatalogyIsNull() {
            addCriterion("fcatalogy is null");
            return (Criteria) this;
        }

        public Criteria andFcatalogyIsNotNull() {
            addCriterion("fcatalogy is not null");
            return (Criteria) this;
        }

        public Criteria andFcatalogyEqualTo(String value) {
            addCriterion("fcatalogy =", value, "fcatalogy");
            return (Criteria) this;
        }

        public Criteria andFcatalogyNotEqualTo(String value) {
            addCriterion("fcatalogy <>", value, "fcatalogy");
            return (Criteria) this;
        }

        public Criteria andFcatalogyGreaterThan(String value) {
            addCriterion("fcatalogy >", value, "fcatalogy");
            return (Criteria) this;
        }

        public Criteria andFcatalogyGreaterThanOrEqualTo(String value) {
            addCriterion("fcatalogy >=", value, "fcatalogy");
            return (Criteria) this;
        }

        public Criteria andFcatalogyLessThan(String value) {
            addCriterion("fcatalogy <", value, "fcatalogy");
            return (Criteria) this;
        }

        public Criteria andFcatalogyLessThanOrEqualTo(String value) {
            addCriterion("fcatalogy <=", value, "fcatalogy");
            return (Criteria) this;
        }

        public Criteria andFcatalogyLike(String value) {
            addCriterion("fcatalogy like", value, "fcatalogy");
            return (Criteria) this;
        }

        public Criteria andFcatalogyNotLike(String value) {
            addCriterion("fcatalogy not like", value, "fcatalogy");
            return (Criteria) this;
        }

        public Criteria andFcatalogyIn(List<String> values) {
            addCriterion("fcatalogy in", values, "fcatalogy");
            return (Criteria) this;
        }

        public Criteria andFcatalogyNotIn(List<String> values) {
            addCriterion("fcatalogy not in", values, "fcatalogy");
            return (Criteria) this;
        }

        public Criteria andFcatalogyBetween(String value1, String value2) {
            addCriterion("fcatalogy between", value1, value2, "fcatalogy");
            return (Criteria) this;
        }

        public Criteria andFcatalogyNotBetween(String value1, String value2) {
            addCriterion("fcatalogy not between", value1, value2, "fcatalogy");
            return (Criteria) this;
        }

        public Criteria andFendflagIsNull() {
            addCriterion("fendflag is null");
            return (Criteria) this;
        }

        public Criteria andFendflagIsNotNull() {
            addCriterion("fendflag is not null");
            return (Criteria) this;
        }

        public Criteria andFendflagEqualTo(Integer value) {
            addCriterion("fendflag =", value, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagNotEqualTo(Integer value) {
            addCriterion("fendflag <>", value, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagGreaterThan(Integer value) {
            addCriterion("fendflag >", value, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("fendflag >=", value, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagLessThan(Integer value) {
            addCriterion("fendflag <", value, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagLessThanOrEqualTo(Integer value) {
            addCriterion("fendflag <=", value, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagIn(List<Integer> values) {
            addCriterion("fendflag in", values, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagNotIn(List<Integer> values) {
            addCriterion("fendflag not in", values, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagBetween(Integer value1, Integer value2) {
            addCriterion("fendflag between", value1, value2, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagNotBetween(Integer value1, Integer value2) {
            addCriterion("fendflag not between", value1, value2, "fendflag");
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

        public Criteria andFdescnIsNull() {
            addCriterion("fdescn is null");
            return (Criteria) this;
        }

        public Criteria andFdescnIsNotNull() {
            addCriterion("fdescn is not null");
            return (Criteria) this;
        }

        public Criteria andFdescnEqualTo(String value) {
            addCriterion("fdescn =", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnNotEqualTo(String value) {
            addCriterion("fdescn <>", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnGreaterThan(String value) {
            addCriterion("fdescn >", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnGreaterThanOrEqualTo(String value) {
            addCriterion("fdescn >=", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnLessThan(String value) {
            addCriterion("fdescn <", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnLessThanOrEqualTo(String value) {
            addCriterion("fdescn <=", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnLike(String value) {
            addCriterion("fdescn like", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnNotLike(String value) {
            addCriterion("fdescn not like", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnIn(List<String> values) {
            addCriterion("fdescn in", values, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnNotIn(List<String> values) {
            addCriterion("fdescn not in", values, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnBetween(String value1, String value2) {
            addCriterion("fdescn between", value1, value2, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnNotBetween(String value1, String value2) {
            addCriterion("fdescn not between", value1, value2, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFviewIsNull() {
            addCriterion("fview is null");
            return (Criteria) this;
        }

        public Criteria andFviewIsNotNull() {
            addCriterion("fview is not null");
            return (Criteria) this;
        }

        public Criteria andFviewEqualTo(String value) {
            addCriterion("fview =", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewNotEqualTo(String value) {
            addCriterion("fview <>", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewGreaterThan(String value) {
            addCriterion("fview >", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewGreaterThanOrEqualTo(String value) {
            addCriterion("fview >=", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewLessThan(String value) {
            addCriterion("fview <", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewLessThanOrEqualTo(String value) {
            addCriterion("fview <=", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewLike(String value) {
            addCriterion("fview like", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewNotLike(String value) {
            addCriterion("fview not like", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewIn(List<String> values) {
            addCriterion("fview in", values, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewNotIn(List<String> values) {
            addCriterion("fview not in", values, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewBetween(String value1, String value2) {
            addCriterion("fview between", value1, value2, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewNotBetween(String value1, String value2) {
            addCriterion("fview not between", value1, value2, "fview");
            return (Criteria) this;
        }

        public Criteria andFlevelIsNull() {
            addCriterion("flevel is null");
            return (Criteria) this;
        }

        public Criteria andFlevelIsNotNull() {
            addCriterion("flevel is not null");
            return (Criteria) this;
        }

        public Criteria andFlevelEqualTo(Integer value) {
            addCriterion("flevel =", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelNotEqualTo(Integer value) {
            addCriterion("flevel <>", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelGreaterThan(Integer value) {
            addCriterion("flevel >", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("flevel >=", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelLessThan(Integer value) {
            addCriterion("flevel <", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelLessThanOrEqualTo(Integer value) {
            addCriterion("flevel <=", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelIn(List<Integer> values) {
            addCriterion("flevel in", values, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelNotIn(List<Integer> values) {
            addCriterion("flevel not in", values, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelBetween(Integer value1, Integer value2) {
            addCriterion("flevel between", value1, value2, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("flevel not between", value1, value2, "flevel");
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