package com.roncoo.adminlte.bean.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSysRoleResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TSysRoleResourceExample() {
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

        public Criteria andFroleIdIsNull() {
            addCriterion("frole_id is null");
            return (Criteria) this;
        }

        public Criteria andFroleIdIsNotNull() {
            addCriterion("frole_id is not null");
            return (Criteria) this;
        }

        public Criteria andFroleIdEqualTo(Long value) {
            addCriterion("frole_id =", value, "froleId");
            return (Criteria) this;
        }

        public Criteria andFroleIdNotEqualTo(Long value) {
            addCriterion("frole_id <>", value, "froleId");
            return (Criteria) this;
        }

        public Criteria andFroleIdGreaterThan(Long value) {
            addCriterion("frole_id >", value, "froleId");
            return (Criteria) this;
        }

        public Criteria andFroleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("frole_id >=", value, "froleId");
            return (Criteria) this;
        }

        public Criteria andFroleIdLessThan(Long value) {
            addCriterion("frole_id <", value, "froleId");
            return (Criteria) this;
        }

        public Criteria andFroleIdLessThanOrEqualTo(Long value) {
            addCriterion("frole_id <=", value, "froleId");
            return (Criteria) this;
        }

        public Criteria andFroleIdIn(List<Long> values) {
            addCriterion("frole_id in", values, "froleId");
            return (Criteria) this;
        }

        public Criteria andFroleIdNotIn(List<Long> values) {
            addCriterion("frole_id not in", values, "froleId");
            return (Criteria) this;
        }

        public Criteria andFroleIdBetween(Long value1, Long value2) {
            addCriterion("frole_id between", value1, value2, "froleId");
            return (Criteria) this;
        }

        public Criteria andFroleIdNotBetween(Long value1, Long value2) {
            addCriterion("frole_id not between", value1, value2, "froleId");
            return (Criteria) this;
        }

        public Criteria andFresourceIdIsNull() {
            addCriterion("fresource_id is null");
            return (Criteria) this;
        }

        public Criteria andFresourceIdIsNotNull() {
            addCriterion("fresource_id is not null");
            return (Criteria) this;
        }

        public Criteria andFresourceIdEqualTo(Long value) {
            addCriterion("fresource_id =", value, "fresourceId");
            return (Criteria) this;
        }

        public Criteria andFresourceIdNotEqualTo(Long value) {
            addCriterion("fresource_id <>", value, "fresourceId");
            return (Criteria) this;
        }

        public Criteria andFresourceIdGreaterThan(Long value) {
            addCriterion("fresource_id >", value, "fresourceId");
            return (Criteria) this;
        }

        public Criteria andFresourceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fresource_id >=", value, "fresourceId");
            return (Criteria) this;
        }

        public Criteria andFresourceIdLessThan(Long value) {
            addCriterion("fresource_id <", value, "fresourceId");
            return (Criteria) this;
        }

        public Criteria andFresourceIdLessThanOrEqualTo(Long value) {
            addCriterion("fresource_id <=", value, "fresourceId");
            return (Criteria) this;
        }

        public Criteria andFresourceIdIn(List<Long> values) {
            addCriterion("fresource_id in", values, "fresourceId");
            return (Criteria) this;
        }

        public Criteria andFresourceIdNotIn(List<Long> values) {
            addCriterion("fresource_id not in", values, "fresourceId");
            return (Criteria) this;
        }

        public Criteria andFresourceIdBetween(Long value1, Long value2) {
            addCriterion("fresource_id between", value1, value2, "fresourceId");
            return (Criteria) this;
        }

        public Criteria andFresourceIdNotBetween(Long value1, Long value2) {
            addCriterion("fresource_id not between", value1, value2, "fresourceId");
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