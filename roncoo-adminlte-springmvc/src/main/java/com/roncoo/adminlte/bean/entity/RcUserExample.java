package com.roncoo.adminlte.bean.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RcUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public RcUserExample() {
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

        public Criteria andStatusIdIsNull() {
            addCriterion("STATUS_ID is null");
            return (Criteria) this;
        }

        public Criteria andStatusIdIsNotNull() {
            addCriterion("STATUS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStatusIdEqualTo(String value) {
            addCriterion("STATUS_ID =", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotEqualTo(String value) {
            addCriterion("STATUS_ID <>", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThan(String value) {
            addCriterion("STATUS_ID >", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS_ID >=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThan(String value) {
            addCriterion("STATUS_ID <", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThanOrEqualTo(String value) {
            addCriterion("STATUS_ID <=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLike(String value) {
            addCriterion("STATUS_ID like", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotLike(String value) {
            addCriterion("STATUS_ID not like", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdIn(List<String> values) {
            addCriterion("STATUS_ID in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotIn(List<String> values) {
            addCriterion("STATUS_ID not in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdBetween(String value1, String value2) {
            addCriterion("STATUS_ID between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotBetween(String value1, String value2) {
            addCriterion("STATUS_ID not between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNull() {
            addCriterion("USER_NO is null");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNotNull() {
            addCriterion("USER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andUserNoEqualTo(String value) {
            addCriterion("USER_NO =", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotEqualTo(String value) {
            addCriterion("USER_NO <>", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThan(String value) {
            addCriterion("USER_NO >", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NO >=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThan(String value) {
            addCriterion("USER_NO <", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThanOrEqualTo(String value) {
            addCriterion("USER_NO <=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLike(String value) {
            addCriterion("USER_NO like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotLike(String value) {
            addCriterion("USER_NO not like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoIn(List<String> values) {
            addCriterion("USER_NO in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotIn(List<String> values) {
            addCriterion("USER_NO not in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoBetween(String value1, String value2) {
            addCriterion("USER_NO between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotBetween(String value1, String value2) {
            addCriterion("USER_NO not between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("NICK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("NICK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("NICK_NAME =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("NICK_NAME <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("NICK_NAME >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("NICK_NAME >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("NICK_NAME <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("NICK_NAME <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("NICK_NAME like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("NICK_NAME not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("NICK_NAME in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("NICK_NAME not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("NICK_NAME between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("NICK_NAME not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andViewTypeIsNull() {
            addCriterion("VIEW_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andViewTypeIsNotNull() {
            addCriterion("VIEW_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andViewTypeEqualTo(String value) {
            addCriterion("VIEW_TYPE =", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeNotEqualTo(String value) {
            addCriterion("VIEW_TYPE <>", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeGreaterThan(String value) {
            addCriterion("VIEW_TYPE >", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeGreaterThanOrEqualTo(String value) {
            addCriterion("VIEW_TYPE >=", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeLessThan(String value) {
            addCriterion("VIEW_TYPE <", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeLessThanOrEqualTo(String value) {
            addCriterion("VIEW_TYPE <=", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeLike(String value) {
            addCriterion("VIEW_TYPE like", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeNotLike(String value) {
            addCriterion("VIEW_TYPE not like", value, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeIn(List<String> values) {
            addCriterion("VIEW_TYPE in", values, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeNotIn(List<String> values) {
            addCriterion("VIEW_TYPE not in", values, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeBetween(String value1, String value2) {
            addCriterion("VIEW_TYPE between", value1, value2, "viewType");
            return (Criteria) this;
        }

        public Criteria andViewTypeNotBetween(String value1, String value2) {
            addCriterion("VIEW_TYPE not between", value1, value2, "viewType");
            return (Criteria) this;
        }

        public Criteria andDataScopeIsNull() {
            addCriterion("DATA_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andDataScopeIsNotNull() {
            addCriterion("DATA_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andDataScopeEqualTo(String value) {
            addCriterion("DATA_SCOPE =", value, "dataScope");
            return (Criteria) this;
        }

        public Criteria andDataScopeNotEqualTo(String value) {
            addCriterion("DATA_SCOPE <>", value, "dataScope");
            return (Criteria) this;
        }

        public Criteria andDataScopeGreaterThan(String value) {
            addCriterion("DATA_SCOPE >", value, "dataScope");
            return (Criteria) this;
        }

        public Criteria andDataScopeGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_SCOPE >=", value, "dataScope");
            return (Criteria) this;
        }

        public Criteria andDataScopeLessThan(String value) {
            addCriterion("DATA_SCOPE <", value, "dataScope");
            return (Criteria) this;
        }

        public Criteria andDataScopeLessThanOrEqualTo(String value) {
            addCriterion("DATA_SCOPE <=", value, "dataScope");
            return (Criteria) this;
        }

        public Criteria andDataScopeLike(String value) {
            addCriterion("DATA_SCOPE like", value, "dataScope");
            return (Criteria) this;
        }

        public Criteria andDataScopeNotLike(String value) {
            addCriterion("DATA_SCOPE not like", value, "dataScope");
            return (Criteria) this;
        }

        public Criteria andDataScopeIn(List<String> values) {
            addCriterion("DATA_SCOPE in", values, "dataScope");
            return (Criteria) this;
        }

        public Criteria andDataScopeNotIn(List<String> values) {
            addCriterion("DATA_SCOPE not in", values, "dataScope");
            return (Criteria) this;
        }

        public Criteria andDataScopeBetween(String value1, String value2) {
            addCriterion("DATA_SCOPE between", value1, value2, "dataScope");
            return (Criteria) this;
        }

        public Criteria andDataScopeNotBetween(String value1, String value2) {
            addCriterion("DATA_SCOPE not between", value1, value2, "dataScope");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdIsNull() {
            addCriterion("yzj_openid is null");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdIsNotNull() {
            addCriterion("yzj_openid is not null");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdEqualTo(String value) {
            addCriterion("yzj_openid =", value, "YZJOpenId");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdNotEqualTo(String value) {
            addCriterion("yzj_openid <>", value, "YZJOpenId");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdGreaterThan(String value) {
            addCriterion("yzj_openid >", value, "YZJOpenId");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("yzj_openid >=", value, "YZJOpenId");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdLessThan(String value) {
            addCriterion("yzj_openid <", value, "YZJOpenId");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdLessThanOrEqualTo(String value) {
            addCriterion("yzj_openid <=", value, "YZJOpenId");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdLike(String value) {
            addCriterion("yzj_openid like", value, "YZJOpenId");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdNotLike(String value) {
            addCriterion("yzj_openid not like", value, "YZJOpenId");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdIn(List<String> values) {
            addCriterion("yzj_openid in", values, "YZJOpenId");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdNotIn(List<String> values) {
            addCriterion("yzj_openid not in", values, "YZJOpenId");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdBetween(String value1, String value2) {
            addCriterion("yzj_openid between", value1, value2, "YZJOpenId");
            return (Criteria) this;
        }

        public Criteria andYZJOpenIdNotBetween(String value1, String value2) {
            addCriterion("yzj_openid not between", value1, value2, "YZJOpenId");
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