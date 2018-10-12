package com.roncoo.adminlte.bean.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSysResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TSysResourceExample() {
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

        public Criteria andFresNameIsNull() {
            addCriterion("fres_name is null");
            return (Criteria) this;
        }

        public Criteria andFresNameIsNotNull() {
            addCriterion("fres_name is not null");
            return (Criteria) this;
        }

        public Criteria andFresNameEqualTo(String value) {
            addCriterion("fres_name =", value, "fresName");
            return (Criteria) this;
        }

        public Criteria andFresNameNotEqualTo(String value) {
            addCriterion("fres_name <>", value, "fresName");
            return (Criteria) this;
        }

        public Criteria andFresNameGreaterThan(String value) {
            addCriterion("fres_name >", value, "fresName");
            return (Criteria) this;
        }

        public Criteria andFresNameGreaterThanOrEqualTo(String value) {
            addCriterion("fres_name >=", value, "fresName");
            return (Criteria) this;
        }

        public Criteria andFresNameLessThan(String value) {
            addCriterion("fres_name <", value, "fresName");
            return (Criteria) this;
        }

        public Criteria andFresNameLessThanOrEqualTo(String value) {
            addCriterion("fres_name <=", value, "fresName");
            return (Criteria) this;
        }

        public Criteria andFresNameLike(String value) {
            addCriterion("fres_name like", value, "fresName");
            return (Criteria) this;
        }

        public Criteria andFresNameNotLike(String value) {
            addCriterion("fres_name not like", value, "fresName");
            return (Criteria) this;
        }

        public Criteria andFresNameIn(List<String> values) {
            addCriterion("fres_name in", values, "fresName");
            return (Criteria) this;
        }

        public Criteria andFresNameNotIn(List<String> values) {
            addCriterion("fres_name not in", values, "fresName");
            return (Criteria) this;
        }

        public Criteria andFresNameBetween(String value1, String value2) {
            addCriterion("fres_name between", value1, value2, "fresName");
            return (Criteria) this;
        }

        public Criteria andFresNameNotBetween(String value1, String value2) {
            addCriterion("fres_name not between", value1, value2, "fresName");
            return (Criteria) this;
        }

        public Criteria andFresDescIsNull() {
            addCriterion("fres_desc is null");
            return (Criteria) this;
        }

        public Criteria andFresDescIsNotNull() {
            addCriterion("fres_desc is not null");
            return (Criteria) this;
        }

        public Criteria andFresDescEqualTo(String value) {
            addCriterion("fres_desc =", value, "fresDesc");
            return (Criteria) this;
        }

        public Criteria andFresDescNotEqualTo(String value) {
            addCriterion("fres_desc <>", value, "fresDesc");
            return (Criteria) this;
        }

        public Criteria andFresDescGreaterThan(String value) {
            addCriterion("fres_desc >", value, "fresDesc");
            return (Criteria) this;
        }

        public Criteria andFresDescGreaterThanOrEqualTo(String value) {
            addCriterion("fres_desc >=", value, "fresDesc");
            return (Criteria) this;
        }

        public Criteria andFresDescLessThan(String value) {
            addCriterion("fres_desc <", value, "fresDesc");
            return (Criteria) this;
        }

        public Criteria andFresDescLessThanOrEqualTo(String value) {
            addCriterion("fres_desc <=", value, "fresDesc");
            return (Criteria) this;
        }

        public Criteria andFresDescLike(String value) {
            addCriterion("fres_desc like", value, "fresDesc");
            return (Criteria) this;
        }

        public Criteria andFresDescNotLike(String value) {
            addCriterion("fres_desc not like", value, "fresDesc");
            return (Criteria) this;
        }

        public Criteria andFresDescIn(List<String> values) {
            addCriterion("fres_desc in", values, "fresDesc");
            return (Criteria) this;
        }

        public Criteria andFresDescNotIn(List<String> values) {
            addCriterion("fres_desc not in", values, "fresDesc");
            return (Criteria) this;
        }

        public Criteria andFresDescBetween(String value1, String value2) {
            addCriterion("fres_desc between", value1, value2, "fresDesc");
            return (Criteria) this;
        }

        public Criteria andFresDescNotBetween(String value1, String value2) {
            addCriterion("fres_desc not between", value1, value2, "fresDesc");
            return (Criteria) this;
        }

        public Criteria andFisLeafIsNull() {
            addCriterion("fis_leaf is null");
            return (Criteria) this;
        }

        public Criteria andFisLeafIsNotNull() {
            addCriterion("fis_leaf is not null");
            return (Criteria) this;
        }

        public Criteria andFisLeafEqualTo(Integer value) {
            addCriterion("fis_leaf =", value, "fisLeaf");
            return (Criteria) this;
        }

        public Criteria andFisLeafNotEqualTo(Integer value) {
            addCriterion("fis_leaf <>", value, "fisLeaf");
            return (Criteria) this;
        }

        public Criteria andFisLeafGreaterThan(Integer value) {
            addCriterion("fis_leaf >", value, "fisLeaf");
            return (Criteria) this;
        }

        public Criteria andFisLeafGreaterThanOrEqualTo(Integer value) {
            addCriterion("fis_leaf >=", value, "fisLeaf");
            return (Criteria) this;
        }

        public Criteria andFisLeafLessThan(Integer value) {
            addCriterion("fis_leaf <", value, "fisLeaf");
            return (Criteria) this;
        }

        public Criteria andFisLeafLessThanOrEqualTo(Integer value) {
            addCriterion("fis_leaf <=", value, "fisLeaf");
            return (Criteria) this;
        }

        public Criteria andFisLeafIn(List<Integer> values) {
            addCriterion("fis_leaf in", values, "fisLeaf");
            return (Criteria) this;
        }

        public Criteria andFisLeafNotIn(List<Integer> values) {
            addCriterion("fis_leaf not in", values, "fisLeaf");
            return (Criteria) this;
        }

        public Criteria andFisLeafBetween(Integer value1, Integer value2) {
            addCriterion("fis_leaf between", value1, value2, "fisLeaf");
            return (Criteria) this;
        }

        public Criteria andFisLeafNotBetween(Integer value1, Integer value2) {
            addCriterion("fis_leaf not between", value1, value2, "fisLeaf");
            return (Criteria) this;
        }

        public Criteria andFresUrlIsNull() {
            addCriterion("fres_url is null");
            return (Criteria) this;
        }

        public Criteria andFresUrlIsNotNull() {
            addCriterion("fres_url is not null");
            return (Criteria) this;
        }

        public Criteria andFresUrlEqualTo(String value) {
            addCriterion("fres_url =", value, "fresUrl");
            return (Criteria) this;
        }

        public Criteria andFresUrlNotEqualTo(String value) {
            addCriterion("fres_url <>", value, "fresUrl");
            return (Criteria) this;
        }

        public Criteria andFresUrlGreaterThan(String value) {
            addCriterion("fres_url >", value, "fresUrl");
            return (Criteria) this;
        }

        public Criteria andFresUrlGreaterThanOrEqualTo(String value) {
            addCriterion("fres_url >=", value, "fresUrl");
            return (Criteria) this;
        }

        public Criteria andFresUrlLessThan(String value) {
            addCriterion("fres_url <", value, "fresUrl");
            return (Criteria) this;
        }

        public Criteria andFresUrlLessThanOrEqualTo(String value) {
            addCriterion("fres_url <=", value, "fresUrl");
            return (Criteria) this;
        }

        public Criteria andFresUrlLike(String value) {
            addCriterion("fres_url like", value, "fresUrl");
            return (Criteria) this;
        }

        public Criteria andFresUrlNotLike(String value) {
            addCriterion("fres_url not like", value, "fresUrl");
            return (Criteria) this;
        }

        public Criteria andFresUrlIn(List<String> values) {
            addCriterion("fres_url in", values, "fresUrl");
            return (Criteria) this;
        }

        public Criteria andFresUrlNotIn(List<String> values) {
            addCriterion("fres_url not in", values, "fresUrl");
            return (Criteria) this;
        }

        public Criteria andFresUrlBetween(String value1, String value2) {
            addCriterion("fres_url between", value1, value2, "fresUrl");
            return (Criteria) this;
        }

        public Criteria andFresUrlNotBetween(String value1, String value2) {
            addCriterion("fres_url not between", value1, value2, "fresUrl");
            return (Criteria) this;
        }

        public Criteria andFicoIsNull() {
            addCriterion("fico is null");
            return (Criteria) this;
        }

        public Criteria andFicoIsNotNull() {
            addCriterion("fico is not null");
            return (Criteria) this;
        }

        public Criteria andFicoEqualTo(String value) {
            addCriterion("fico =", value, "fico");
            return (Criteria) this;
        }

        public Criteria andFicoNotEqualTo(String value) {
            addCriterion("fico <>", value, "fico");
            return (Criteria) this;
        }

        public Criteria andFicoGreaterThan(String value) {
            addCriterion("fico >", value, "fico");
            return (Criteria) this;
        }

        public Criteria andFicoGreaterThanOrEqualTo(String value) {
            addCriterion("fico >=", value, "fico");
            return (Criteria) this;
        }

        public Criteria andFicoLessThan(String value) {
            addCriterion("fico <", value, "fico");
            return (Criteria) this;
        }

        public Criteria andFicoLessThanOrEqualTo(String value) {
            addCriterion("fico <=", value, "fico");
            return (Criteria) this;
        }

        public Criteria andFicoLike(String value) {
            addCriterion("fico like", value, "fico");
            return (Criteria) this;
        }

        public Criteria andFicoNotLike(String value) {
            addCriterion("fico not like", value, "fico");
            return (Criteria) this;
        }

        public Criteria andFicoIn(List<String> values) {
            addCriterion("fico in", values, "fico");
            return (Criteria) this;
        }

        public Criteria andFicoNotIn(List<String> values) {
            addCriterion("fico not in", values, "fico");
            return (Criteria) this;
        }

        public Criteria andFicoBetween(String value1, String value2) {
            addCriterion("fico between", value1, value2, "fico");
            return (Criteria) this;
        }

        public Criteria andFicoNotBetween(String value1, String value2) {
            addCriterion("fico not between", value1, value2, "fico");
            return (Criteria) this;
        }

        public Criteria andFresTypeIsNull() {
            addCriterion("fres_type is null");
            return (Criteria) this;
        }

        public Criteria andFresTypeIsNotNull() {
            addCriterion("fres_type is not null");
            return (Criteria) this;
        }

        public Criteria andFresTypeEqualTo(String value) {
            addCriterion("fres_type =", value, "fresType");
            return (Criteria) this;
        }

        public Criteria andFresTypeNotEqualTo(String value) {
            addCriterion("fres_type <>", value, "fresType");
            return (Criteria) this;
        }

        public Criteria andFresTypeGreaterThan(String value) {
            addCriterion("fres_type >", value, "fresType");
            return (Criteria) this;
        }

        public Criteria andFresTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fres_type >=", value, "fresType");
            return (Criteria) this;
        }

        public Criteria andFresTypeLessThan(String value) {
            addCriterion("fres_type <", value, "fresType");
            return (Criteria) this;
        }

        public Criteria andFresTypeLessThanOrEqualTo(String value) {
            addCriterion("fres_type <=", value, "fresType");
            return (Criteria) this;
        }

        public Criteria andFresTypeLike(String value) {
            addCriterion("fres_type like", value, "fresType");
            return (Criteria) this;
        }

        public Criteria andFresTypeNotLike(String value) {
            addCriterion("fres_type not like", value, "fresType");
            return (Criteria) this;
        }

        public Criteria andFresTypeIn(List<String> values) {
            addCriterion("fres_type in", values, "fresType");
            return (Criteria) this;
        }

        public Criteria andFresTypeNotIn(List<String> values) {
            addCriterion("fres_type not in", values, "fresType");
            return (Criteria) this;
        }

        public Criteria andFresTypeBetween(String value1, String value2) {
            addCriterion("fres_type between", value1, value2, "fresType");
            return (Criteria) this;
        }

        public Criteria andFresTypeNotBetween(String value1, String value2) {
            addCriterion("fres_type not between", value1, value2, "fresType");
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

        public Criteria andFcreateDateIsNull() {
            addCriterion("fcreate_date is null");
            return (Criteria) this;
        }

        public Criteria andFcreateDateIsNotNull() {
            addCriterion("fcreate_date is not null");
            return (Criteria) this;
        }

        public Criteria andFcreateDateEqualTo(Date value) {
            addCriterion("fcreate_date =", value, "fcreateDate");
            return (Criteria) this;
        }

        public Criteria andFcreateDateNotEqualTo(Date value) {
            addCriterion("fcreate_date <>", value, "fcreateDate");
            return (Criteria) this;
        }

        public Criteria andFcreateDateGreaterThan(Date value) {
            addCriterion("fcreate_date >", value, "fcreateDate");
            return (Criteria) this;
        }

        public Criteria andFcreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("fcreate_date >=", value, "fcreateDate");
            return (Criteria) this;
        }

        public Criteria andFcreateDateLessThan(Date value) {
            addCriterion("fcreate_date <", value, "fcreateDate");
            return (Criteria) this;
        }

        public Criteria andFcreateDateLessThanOrEqualTo(Date value) {
            addCriterion("fcreate_date <=", value, "fcreateDate");
            return (Criteria) this;
        }

        public Criteria andFcreateDateIn(List<Date> values) {
            addCriterion("fcreate_date in", values, "fcreateDate");
            return (Criteria) this;
        }

        public Criteria andFcreateDateNotIn(List<Date> values) {
            addCriterion("fcreate_date not in", values, "fcreateDate");
            return (Criteria) this;
        }

        public Criteria andFcreateDateBetween(Date value1, Date value2) {
            addCriterion("fcreate_date between", value1, value2, "fcreateDate");
            return (Criteria) this;
        }

        public Criteria andFcreateDateNotBetween(Date value1, Date value2) {
            addCriterion("fcreate_date not between", value1, value2, "fcreateDate");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueIsNull() {
            addCriterion("fpermission_value is null");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueIsNotNull() {
            addCriterion("fpermission_value is not null");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueEqualTo(String value) {
            addCriterion("fpermission_value =", value, "fpermissionValue");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueNotEqualTo(String value) {
            addCriterion("fpermission_value <>", value, "fpermissionValue");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueGreaterThan(String value) {
            addCriterion("fpermission_value >", value, "fpermissionValue");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueGreaterThanOrEqualTo(String value) {
            addCriterion("fpermission_value >=", value, "fpermissionValue");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueLessThan(String value) {
            addCriterion("fpermission_value <", value, "fpermissionValue");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueLessThanOrEqualTo(String value) {
            addCriterion("fpermission_value <=", value, "fpermissionValue");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueLike(String value) {
            addCriterion("fpermission_value like", value, "fpermissionValue");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueNotLike(String value) {
            addCriterion("fpermission_value not like", value, "fpermissionValue");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueIn(List<String> values) {
            addCriterion("fpermission_value in", values, "fpermissionValue");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueNotIn(List<String> values) {
            addCriterion("fpermission_value not in", values, "fpermissionValue");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueBetween(String value1, String value2) {
            addCriterion("fpermission_value between", value1, value2, "fpermissionValue");
            return (Criteria) this;
        }

        public Criteria andFpermissionValueNotBetween(String value1, String value2) {
            addCriterion("fpermission_value not between", value1, value2, "fpermissionValue");
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

        public Criteria andFstatusEqualTo(Integer value) {
            addCriterion("fstatus =", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotEqualTo(Integer value) {
            addCriterion("fstatus <>", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThan(Integer value) {
            addCriterion("fstatus >", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("fstatus >=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThan(Integer value) {
            addCriterion("fstatus <", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThanOrEqualTo(Integer value) {
            addCriterion("fstatus <=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusIn(List<Integer> values) {
            addCriterion("fstatus in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotIn(List<Integer> values) {
            addCriterion("fstatus not in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusBetween(Integer value1, Integer value2) {
            addCriterion("fstatus between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("fstatus not between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstyleIsNull() {
            addCriterion("fstyle is null");
            return (Criteria) this;
        }

        public Criteria andFstyleIsNotNull() {
            addCriterion("fstyle is not null");
            return (Criteria) this;
        }

        public Criteria andFstyleEqualTo(String value) {
            addCriterion("fstyle =", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleNotEqualTo(String value) {
            addCriterion("fstyle <>", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleGreaterThan(String value) {
            addCriterion("fstyle >", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleGreaterThanOrEqualTo(String value) {
            addCriterion("fstyle >=", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleLessThan(String value) {
            addCriterion("fstyle <", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleLessThanOrEqualTo(String value) {
            addCriterion("fstyle <=", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleLike(String value) {
            addCriterion("fstyle like", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleNotLike(String value) {
            addCriterion("fstyle not like", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleIn(List<String> values) {
            addCriterion("fstyle in", values, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleNotIn(List<String> values) {
            addCriterion("fstyle not in", values, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleBetween(String value1, String value2) {
            addCriterion("fstyle between", value1, value2, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleNotBetween(String value1, String value2) {
            addCriterion("fstyle not between", value1, value2, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameIsNull() {
            addCriterion("fpermission_name is null");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameIsNotNull() {
            addCriterion("fpermission_name is not null");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameEqualTo(String value) {
            addCriterion("fpermission_name =", value, "fpermissionName");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameNotEqualTo(String value) {
            addCriterion("fpermission_name <>", value, "fpermissionName");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameGreaterThan(String value) {
            addCriterion("fpermission_name >", value, "fpermissionName");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameGreaterThanOrEqualTo(String value) {
            addCriterion("fpermission_name >=", value, "fpermissionName");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameLessThan(String value) {
            addCriterion("fpermission_name <", value, "fpermissionName");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameLessThanOrEqualTo(String value) {
            addCriterion("fpermission_name <=", value, "fpermissionName");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameLike(String value) {
            addCriterion("fpermission_name like", value, "fpermissionName");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameNotLike(String value) {
            addCriterion("fpermission_name not like", value, "fpermissionName");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameIn(List<String> values) {
            addCriterion("fpermission_name in", values, "fpermissionName");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameNotIn(List<String> values) {
            addCriterion("fpermission_name not in", values, "fpermissionName");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameBetween(String value1, String value2) {
            addCriterion("fpermission_name between", value1, value2, "fpermissionName");
            return (Criteria) this;
        }

        public Criteria andFpermissionNameNotBetween(String value1, String value2) {
            addCriterion("fpermission_name not between", value1, value2, "fpermissionName");
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