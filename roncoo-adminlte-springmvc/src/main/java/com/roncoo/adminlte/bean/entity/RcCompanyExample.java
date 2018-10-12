package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RcCompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public RcCompanyExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFnameIsNull() {
            addCriterion("FNAME is null");
            return (Criteria) this;
        }

        public Criteria andFnameIsNotNull() {
            addCriterion("FNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFnameEqualTo(String value) {
            addCriterion("FNAME =", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotEqualTo(String value) {
            addCriterion("FNAME <>", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThan(String value) {
            addCriterion("FNAME >", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThanOrEqualTo(String value) {
            addCriterion("FNAME >=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThan(String value) {
            addCriterion("FNAME <", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThanOrEqualTo(String value) {
            addCriterion("FNAME <=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLike(String value) {
            addCriterion("FNAME like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotLike(String value) {
            addCriterion("FNAME not like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameIn(List<String> values) {
            addCriterion("FNAME in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotIn(List<String> values) {
            addCriterion("FNAME not in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameBetween(String value1, String value2) {
            addCriterion("FNAME between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotBetween(String value1, String value2) {
            addCriterion("FNAME not between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFnumberIsNull() {
            addCriterion("FNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andFnumberIsNotNull() {
            addCriterion("FNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andFnumberEqualTo(String value) {
            addCriterion("FNUMBER =", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberNotEqualTo(String value) {
            addCriterion("FNUMBER <>", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberGreaterThan(String value) {
            addCriterion("FNUMBER >", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberGreaterThanOrEqualTo(String value) {
            addCriterion("FNUMBER >=", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberLessThan(String value) {
            addCriterion("FNUMBER <", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberLessThanOrEqualTo(String value) {
            addCriterion("FNUMBER <=", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberLike(String value) {
            addCriterion("FNUMBER like", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberNotLike(String value) {
            addCriterion("FNUMBER not like", value, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberIn(List<String> values) {
            addCriterion("FNUMBER in", values, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberNotIn(List<String> values) {
            addCriterion("FNUMBER not in", values, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberBetween(String value1, String value2) {
            addCriterion("FNUMBER between", value1, value2, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFnumberNotBetween(String value1, String value2) {
            addCriterion("FNUMBER not between", value1, value2, "fnumber");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNull() {
            addCriterion("FTYPE is null");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNotNull() {
            addCriterion("FTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFtypeEqualTo(String value) {
            addCriterion("FTYPE =", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotEqualTo(String value) {
            addCriterion("FTYPE <>", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThan(String value) {
            addCriterion("FTYPE >", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThanOrEqualTo(String value) {
            addCriterion("FTYPE >=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThan(String value) {
            addCriterion("FTYPE <", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThanOrEqualTo(String value) {
            addCriterion("FTYPE <=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLike(String value) {
            addCriterion("FTYPE like", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotLike(String value) {
            addCriterion("FTYPE not like", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeIn(List<String> values) {
            addCriterion("FTYPE in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotIn(List<String> values) {
            addCriterion("FTYPE not in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeBetween(String value1, String value2) {
            addCriterion("FTYPE between", value1, value2, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotBetween(String value1, String value2) {
            addCriterion("FTYPE not between", value1, value2, "ftype");
            return (Criteria) this;
        }

        public Criteria andFdescIsNull() {
            addCriterion("FDESC is null");
            return (Criteria) this;
        }

        public Criteria andFdescIsNotNull() {
            addCriterion("FDESC is not null");
            return (Criteria) this;
        }

        public Criteria andFdescEqualTo(String value) {
            addCriterion("FDESC =", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescNotEqualTo(String value) {
            addCriterion("FDESC <>", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescGreaterThan(String value) {
            addCriterion("FDESC >", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescGreaterThanOrEqualTo(String value) {
            addCriterion("FDESC >=", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescLessThan(String value) {
            addCriterion("FDESC <", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescLessThanOrEqualTo(String value) {
            addCriterion("FDESC <=", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescLike(String value) {
            addCriterion("FDESC like", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescNotLike(String value) {
            addCriterion("FDESC not like", value, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescIn(List<String> values) {
            addCriterion("FDESC in", values, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescNotIn(List<String> values) {
            addCriterion("FDESC not in", values, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescBetween(String value1, String value2) {
            addCriterion("FDESC between", value1, value2, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFdescNotBetween(String value1, String value2) {
            addCriterion("FDESC not between", value1, value2, "fdesc");
            return (Criteria) this;
        }

        public Criteria andFlongCodeIsNull() {
            addCriterion("FLONG_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFlongCodeIsNotNull() {
            addCriterion("FLONG_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFlongCodeEqualTo(String value) {
            addCriterion("FLONG_CODE =", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeNotEqualTo(String value) {
            addCriterion("FLONG_CODE <>", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeGreaterThan(String value) {
            addCriterion("FLONG_CODE >", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FLONG_CODE >=", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeLessThan(String value) {
            addCriterion("FLONG_CODE <", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeLessThanOrEqualTo(String value) {
            addCriterion("FLONG_CODE <=", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeLike(String value) {
            addCriterion("FLONG_CODE like", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeNotLike(String value) {
            addCriterion("FLONG_CODE not like", value, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeIn(List<String> values) {
            addCriterion("FLONG_CODE in", values, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeNotIn(List<String> values) {
            addCriterion("FLONG_CODE not in", values, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeBetween(String value1, String value2) {
            addCriterion("FLONG_CODE between", value1, value2, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFlongCodeNotBetween(String value1, String value2) {
            addCriterion("FLONG_CODE not between", value1, value2, "flongCode");
            return (Criteria) this;
        }

        public Criteria andFparentCodeIsNull() {
            addCriterion("FPARENT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFparentCodeIsNotNull() {
            addCriterion("FPARENT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFparentCodeEqualTo(String value) {
            addCriterion("FPARENT_CODE =", value, "fparentCode");
            return (Criteria) this;
        }

        public Criteria andFparentCodeNotEqualTo(String value) {
            addCriterion("FPARENT_CODE <>", value, "fparentCode");
            return (Criteria) this;
        }

        public Criteria andFparentCodeGreaterThan(String value) {
            addCriterion("FPARENT_CODE >", value, "fparentCode");
            return (Criteria) this;
        }

        public Criteria andFparentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FPARENT_CODE >=", value, "fparentCode");
            return (Criteria) this;
        }

        public Criteria andFparentCodeLessThan(String value) {
            addCriterion("FPARENT_CODE <", value, "fparentCode");
            return (Criteria) this;
        }

        public Criteria andFparentCodeLessThanOrEqualTo(String value) {
            addCriterion("FPARENT_CODE <=", value, "fparentCode");
            return (Criteria) this;
        }

        public Criteria andFparentCodeLike(String value) {
            addCriterion("FPARENT_CODE like", value, "fparentCode");
            return (Criteria) this;
        }

        public Criteria andFparentCodeNotLike(String value) {
            addCriterion("FPARENT_CODE not like", value, "fparentCode");
            return (Criteria) this;
        }

        public Criteria andFparentCodeIn(List<String> values) {
            addCriterion("FPARENT_CODE in", values, "fparentCode");
            return (Criteria) this;
        }

        public Criteria andFparentCodeNotIn(List<String> values) {
            addCriterion("FPARENT_CODE not in", values, "fparentCode");
            return (Criteria) this;
        }

        public Criteria andFparentCodeBetween(String value1, String value2) {
            addCriterion("FPARENT_CODE between", value1, value2, "fparentCode");
            return (Criteria) this;
        }

        public Criteria andFparentCodeNotBetween(String value1, String value2) {
            addCriterion("FPARENT_CODE not between", value1, value2, "fparentCode");
            return (Criteria) this;
        }

        public Criteria andFposIsNull() {
            addCriterion("FPOS is null");
            return (Criteria) this;
        }

        public Criteria andFposIsNotNull() {
            addCriterion("FPOS is not null");
            return (Criteria) this;
        }

        public Criteria andFposEqualTo(Short value) {
            addCriterion("FPOS =", value, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposNotEqualTo(Short value) {
            addCriterion("FPOS <>", value, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposGreaterThan(Short value) {
            addCriterion("FPOS >", value, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposGreaterThanOrEqualTo(Short value) {
            addCriterion("FPOS >=", value, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposLessThan(Short value) {
            addCriterion("FPOS <", value, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposLessThanOrEqualTo(Short value) {
            addCriterion("FPOS <=", value, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposIn(List<Short> values) {
            addCriterion("FPOS in", values, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposNotIn(List<Short> values) {
            addCriterion("FPOS not in", values, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposBetween(Short value1, Short value2) {
            addCriterion("FPOS between", value1, value2, "fpos");
            return (Criteria) this;
        }

        public Criteria andFposNotBetween(Short value1, Short value2) {
            addCriterion("FPOS not between", value1, value2, "fpos");
            return (Criteria) this;
        }

        public Criteria andFendflagIsNull() {
            addCriterion("FENDFLAG is null");
            return (Criteria) this;
        }

        public Criteria andFendflagIsNotNull() {
            addCriterion("FENDFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFendflagEqualTo(Short value) {
            addCriterion("FENDFLAG =", value, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagNotEqualTo(Short value) {
            addCriterion("FENDFLAG <>", value, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagGreaterThan(Short value) {
            addCriterion("FENDFLAG >", value, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagGreaterThanOrEqualTo(Short value) {
            addCriterion("FENDFLAG >=", value, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagLessThan(Short value) {
            addCriterion("FENDFLAG <", value, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagLessThanOrEqualTo(Short value) {
            addCriterion("FENDFLAG <=", value, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagIn(List<Short> values) {
            addCriterion("FENDFLAG in", values, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagNotIn(List<Short> values) {
            addCriterion("FENDFLAG not in", values, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagBetween(Short value1, Short value2) {
            addCriterion("FENDFLAG between", value1, value2, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFendflagNotBetween(Short value1, Short value2) {
            addCriterion("FENDFLAG not between", value1, value2, "fendflag");
            return (Criteria) this;
        }

        public Criteria andFstatusIsNull() {
            addCriterion("FSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andFstatusIsNotNull() {
            addCriterion("FSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andFstatusEqualTo(Short value) {
            addCriterion("FSTATUS =", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotEqualTo(Short value) {
            addCriterion("FSTATUS <>", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThan(Short value) {
            addCriterion("FSTATUS >", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThanOrEqualTo(Short value) {
            addCriterion("FSTATUS >=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThan(Short value) {
            addCriterion("FSTATUS <", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThanOrEqualTo(Short value) {
            addCriterion("FSTATUS <=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusIn(List<Short> values) {
            addCriterion("FSTATUS in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotIn(List<Short> values) {
            addCriterion("FSTATUS not in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusBetween(Short value1, Short value2) {
            addCriterion("FSTATUS between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotBetween(Short value1, Short value2) {
            addCriterion("FSTATUS not between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFdescnIsNull() {
            addCriterion("FDESCN is null");
            return (Criteria) this;
        }

        public Criteria andFdescnIsNotNull() {
            addCriterion("FDESCN is not null");
            return (Criteria) this;
        }

        public Criteria andFdescnEqualTo(String value) {
            addCriterion("FDESCN =", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnNotEqualTo(String value) {
            addCriterion("FDESCN <>", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnGreaterThan(String value) {
            addCriterion("FDESCN >", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnGreaterThanOrEqualTo(String value) {
            addCriterion("FDESCN >=", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnLessThan(String value) {
            addCriterion("FDESCN <", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnLessThanOrEqualTo(String value) {
            addCriterion("FDESCN <=", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnLike(String value) {
            addCriterion("FDESCN like", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnNotLike(String value) {
            addCriterion("FDESCN not like", value, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnIn(List<String> values) {
            addCriterion("FDESCN in", values, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnNotIn(List<String> values) {
            addCriterion("FDESCN not in", values, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnBetween(String value1, String value2) {
            addCriterion("FDESCN between", value1, value2, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFdescnNotBetween(String value1, String value2) {
            addCriterion("FDESCN not between", value1, value2, "fdescn");
            return (Criteria) this;
        }

        public Criteria andFviewIsNull() {
            addCriterion("FVIEW is null");
            return (Criteria) this;
        }

        public Criteria andFviewIsNotNull() {
            addCriterion("FVIEW is not null");
            return (Criteria) this;
        }

        public Criteria andFviewEqualTo(String value) {
            addCriterion("FVIEW =", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewNotEqualTo(String value) {
            addCriterion("FVIEW <>", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewGreaterThan(String value) {
            addCriterion("FVIEW >", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewGreaterThanOrEqualTo(String value) {
            addCriterion("FVIEW >=", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewLessThan(String value) {
            addCriterion("FVIEW <", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewLessThanOrEqualTo(String value) {
            addCriterion("FVIEW <=", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewLike(String value) {
            addCriterion("FVIEW like", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewNotLike(String value) {
            addCriterion("FVIEW not like", value, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewIn(List<String> values) {
            addCriterion("FVIEW in", values, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewNotIn(List<String> values) {
            addCriterion("FVIEW not in", values, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewBetween(String value1, String value2) {
            addCriterion("FVIEW between", value1, value2, "fview");
            return (Criteria) this;
        }

        public Criteria andFviewNotBetween(String value1, String value2) {
            addCriterion("FVIEW not between", value1, value2, "fview");
            return (Criteria) this;
        }

        public Criteria andFlevelIsNull() {
            addCriterion("FLEVEL is null");
            return (Criteria) this;
        }

        public Criteria andFlevelIsNotNull() {
            addCriterion("FLEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andFlevelEqualTo(Short value) {
            addCriterion("FLEVEL =", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelNotEqualTo(Short value) {
            addCriterion("FLEVEL <>", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelGreaterThan(Short value) {
            addCriterion("FLEVEL >", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("FLEVEL >=", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelLessThan(Short value) {
            addCriterion("FLEVEL <", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelLessThanOrEqualTo(Short value) {
            addCriterion("FLEVEL <=", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelIn(List<Short> values) {
            addCriterion("FLEVEL in", values, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelNotIn(List<Short> values) {
            addCriterion("FLEVEL not in", values, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelBetween(Short value1, Short value2) {
            addCriterion("FLEVEL between", value1, value2, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelNotBetween(Short value1, Short value2) {
            addCriterion("FLEVEL not between", value1, value2, "flevel");
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