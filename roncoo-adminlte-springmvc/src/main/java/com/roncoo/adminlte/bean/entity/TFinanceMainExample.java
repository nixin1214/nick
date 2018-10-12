package com.roncoo.adminlte.bean.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TFinanceMainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceMainExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andFcreatorIsNull() {
            addCriterion("fcreator is null");
            return (Criteria) this;
        }

        public Criteria andFcreatorIsNotNull() {
            addCriterion("fcreator is not null");
            return (Criteria) this;
        }

        public Criteria andFcreatorEqualTo(Long value) {
            addCriterion("fcreator =", value, "fcreator");
            return (Criteria) this;
        }

        public Criteria andFcreatorNotEqualTo(Long value) {
            addCriterion("fcreator <>", value, "fcreator");
            return (Criteria) this;
        }

        public Criteria andFcreatorGreaterThan(Long value) {
            addCriterion("fcreator >", value, "fcreator");
            return (Criteria) this;
        }

        public Criteria andFcreatorGreaterThanOrEqualTo(Long value) {
            addCriterion("fcreator >=", value, "fcreator");
            return (Criteria) this;
        }

        public Criteria andFcreatorLessThan(Long value) {
            addCriterion("fcreator <", value, "fcreator");
            return (Criteria) this;
        }

        public Criteria andFcreatorLessThanOrEqualTo(Long value) {
            addCriterion("fcreator <=", value, "fcreator");
            return (Criteria) this;
        }

        public Criteria andFcreatorIn(List<Long> values) {
            addCriterion("fcreator in", values, "fcreator");
            return (Criteria) this;
        }

        public Criteria andFcreatorNotIn(List<Long> values) {
            addCriterion("fcreator not in", values, "fcreator");
            return (Criteria) this;
        }

        public Criteria andFcreatorBetween(Long value1, Long value2) {
            addCriterion("fcreator between", value1, value2, "fcreator");
            return (Criteria) this;
        }

        public Criteria andFcreatorNotBetween(Long value1, Long value2) {
            addCriterion("fcreator not between", value1, value2, "fcreator");
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

        public Criteria andFupdatorIsNull() {
            addCriterion("fupdator is null");
            return (Criteria) this;
        }

        public Criteria andFupdatorIsNotNull() {
            addCriterion("fupdator is not null");
            return (Criteria) this;
        }

        public Criteria andFupdatorEqualTo(Long value) {
            addCriterion("fupdator =", value, "fupdator");
            return (Criteria) this;
        }

        public Criteria andFupdatorNotEqualTo(Long value) {
            addCriterion("fupdator <>", value, "fupdator");
            return (Criteria) this;
        }

        public Criteria andFupdatorGreaterThan(Long value) {
            addCriterion("fupdator >", value, "fupdator");
            return (Criteria) this;
        }

        public Criteria andFupdatorGreaterThanOrEqualTo(Long value) {
            addCriterion("fupdator >=", value, "fupdator");
            return (Criteria) this;
        }

        public Criteria andFupdatorLessThan(Long value) {
            addCriterion("fupdator <", value, "fupdator");
            return (Criteria) this;
        }

        public Criteria andFupdatorLessThanOrEqualTo(Long value) {
            addCriterion("fupdator <=", value, "fupdator");
            return (Criteria) this;
        }

        public Criteria andFupdatorIn(List<Long> values) {
            addCriterion("fupdator in", values, "fupdator");
            return (Criteria) this;
        }

        public Criteria andFupdatorNotIn(List<Long> values) {
            addCriterion("fupdator not in", values, "fupdator");
            return (Criteria) this;
        }

        public Criteria andFupdatorBetween(Long value1, Long value2) {
            addCriterion("fupdator between", value1, value2, "fupdator");
            return (Criteria) this;
        }

        public Criteria andFupdatorNotBetween(Long value1, Long value2) {
            addCriterion("fupdator not between", value1, value2, "fupdator");
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

        public Criteria andFcompanyNumberIsNull() {
            addCriterion("fcompany_number is null");
            return (Criteria) this;
        }

        public Criteria andFcompanyNumberIsNotNull() {
            addCriterion("fcompany_number is not null");
            return (Criteria) this;
        }

        public Criteria andFcompanyNumberEqualTo(String value) {
            addCriterion("fcompany_number =", value, "fcompanyNumber");
            return (Criteria) this;
        }

        public Criteria andFcompanyNumberNotEqualTo(String value) {
            addCriterion("fcompany_number <>", value, "fcompanyNumber");
            return (Criteria) this;
        }

        public Criteria andFcompanyNumberGreaterThan(String value) {
            addCriterion("fcompany_number >", value, "fcompanyNumber");
            return (Criteria) this;
        }

        public Criteria andFcompanyNumberGreaterThanOrEqualTo(String value) {
            addCriterion("fcompany_number >=", value, "fcompanyNumber");
            return (Criteria) this;
        }

        public Criteria andFcompanyNumberLessThan(String value) {
            addCriterion("fcompany_number <", value, "fcompanyNumber");
            return (Criteria) this;
        }

        public Criteria andFcompanyNumberLessThanOrEqualTo(String value) {
            addCriterion("fcompany_number <=", value, "fcompanyNumber");
            return (Criteria) this;
        }

        public Criteria andFcompanyNumberLike(String value) {
            addCriterion("fcompany_number like", value, "fcompanyNumber");
            return (Criteria) this;
        }

        public Criteria andFcompanyNumberNotLike(String value) {
            addCriterion("fcompany_number not like", value, "fcompanyNumber");
            return (Criteria) this;
        }

        public Criteria andFcompanyNumberIn(List<String> values) {
            addCriterion("fcompany_number in", values, "fcompanyNumber");
            return (Criteria) this;
        }

        public Criteria andFcompanyNumberNotIn(List<String> values) {
            addCriterion("fcompany_number not in", values, "fcompanyNumber");
            return (Criteria) this;
        }

        public Criteria andFcompanyNumberBetween(String value1, String value2) {
            addCriterion("fcompany_number between", value1, value2, "fcompanyNumber");
            return (Criteria) this;
        }

        public Criteria andFcompanyNumberNotBetween(String value1, String value2) {
            addCriterion("fcompany_number not between", value1, value2, "fcompanyNumber");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameIsNull() {
            addCriterion("fcompany_name is null");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameIsNotNull() {
            addCriterion("fcompany_name is not null");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameEqualTo(String value) {
            addCriterion("fcompany_name =", value, "fcompanyName");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameNotEqualTo(String value) {
            addCriterion("fcompany_name <>", value, "fcompanyName");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameGreaterThan(String value) {
            addCriterion("fcompany_name >", value, "fcompanyName");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("fcompany_name >=", value, "fcompanyName");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameLessThan(String value) {
            addCriterion("fcompany_name <", value, "fcompanyName");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameLessThanOrEqualTo(String value) {
            addCriterion("fcompany_name <=", value, "fcompanyName");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameLike(String value) {
            addCriterion("fcompany_name like", value, "fcompanyName");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameNotLike(String value) {
            addCriterion("fcompany_name not like", value, "fcompanyName");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameIn(List<String> values) {
            addCriterion("fcompany_name in", values, "fcompanyName");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameNotIn(List<String> values) {
            addCriterion("fcompany_name not in", values, "fcompanyName");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameBetween(String value1, String value2) {
            addCriterion("fcompany_name between", value1, value2, "fcompanyName");
            return (Criteria) this;
        }

        public Criteria andFcompanyNameNotBetween(String value1, String value2) {
            addCriterion("fcompany_name not between", value1, value2, "fcompanyName");
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

        public Criteria andFreportIsNull() {
            addCriterion("freport is null");
            return (Criteria) this;
        }

        public Criteria andFreportIsNotNull() {
            addCriterion("freport is not null");
            return (Criteria) this;
        }

        public Criteria andFreportEqualTo(String value) {
            addCriterion("freport =", value, "freport");
            return (Criteria) this;
        }

        public Criteria andFreportNotEqualTo(String value) {
            addCriterion("freport <>", value, "freport");
            return (Criteria) this;
        }

        public Criteria andFreportGreaterThan(String value) {
            addCriterion("freport >", value, "freport");
            return (Criteria) this;
        }

        public Criteria andFreportGreaterThanOrEqualTo(String value) {
            addCriterion("freport >=", value, "freport");
            return (Criteria) this;
        }

        public Criteria andFreportLessThan(String value) {
            addCriterion("freport <", value, "freport");
            return (Criteria) this;
        }

        public Criteria andFreportLessThanOrEqualTo(String value) {
            addCriterion("freport <=", value, "freport");
            return (Criteria) this;
        }

        public Criteria andFreportLike(String value) {
            addCriterion("freport like", value, "freport");
            return (Criteria) this;
        }

        public Criteria andFreportNotLike(String value) {
            addCriterion("freport not like", value, "freport");
            return (Criteria) this;
        }

        public Criteria andFreportIn(List<String> values) {
            addCriterion("freport in", values, "freport");
            return (Criteria) this;
        }

        public Criteria andFreportNotIn(List<String> values) {
            addCriterion("freport not in", values, "freport");
            return (Criteria) this;
        }

        public Criteria andFreportBetween(String value1, String value2) {
            addCriterion("freport between", value1, value2, "freport");
            return (Criteria) this;
        }

        public Criteria andFreportNotBetween(String value1, String value2) {
            addCriterion("freport not between", value1, value2, "freport");
            return (Criteria) this;
        }

        public Criteria andFdescriptionIsNull() {
            addCriterion("fdescription is null");
            return (Criteria) this;
        }

        public Criteria andFdescriptionIsNotNull() {
            addCriterion("fdescription is not null");
            return (Criteria) this;
        }

        public Criteria andFdescriptionEqualTo(String value) {
            addCriterion("fdescription =", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionNotEqualTo(String value) {
            addCriterion("fdescription <>", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionGreaterThan(String value) {
            addCriterion("fdescription >", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("fdescription >=", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionLessThan(String value) {
            addCriterion("fdescription <", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionLessThanOrEqualTo(String value) {
            addCriterion("fdescription <=", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionLike(String value) {
            addCriterion("fdescription like", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionNotLike(String value) {
            addCriterion("fdescription not like", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionIn(List<String> values) {
            addCriterion("fdescription in", values, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionNotIn(List<String> values) {
            addCriterion("fdescription not in", values, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionBetween(String value1, String value2) {
            addCriterion("fdescription between", value1, value2, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionNotBetween(String value1, String value2) {
            addCriterion("fdescription not between", value1, value2, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFreportNumberIsNull() {
            addCriterion("freport_number is null");
            return (Criteria) this;
        }

        public Criteria andFreportNumberIsNotNull() {
            addCriterion("freport_number is not null");
            return (Criteria) this;
        }

        public Criteria andFreportNumberEqualTo(String value) {
            addCriterion("freport_number =", value, "freportNumber");
            return (Criteria) this;
        }

        public Criteria andFreportNumberNotEqualTo(String value) {
            addCriterion("freport_number <>", value, "freportNumber");
            return (Criteria) this;
        }

        public Criteria andFreportNumberGreaterThan(String value) {
            addCriterion("freport_number >", value, "freportNumber");
            return (Criteria) this;
        }

        public Criteria andFreportNumberGreaterThanOrEqualTo(String value) {
            addCriterion("freport_number >=", value, "freportNumber");
            return (Criteria) this;
        }

        public Criteria andFreportNumberLessThan(String value) {
            addCriterion("freport_number <", value, "freportNumber");
            return (Criteria) this;
        }

        public Criteria andFreportNumberLessThanOrEqualTo(String value) {
            addCriterion("freport_number <=", value, "freportNumber");
            return (Criteria) this;
        }

        public Criteria andFreportNumberLike(String value) {
            addCriterion("freport_number like", value, "freportNumber");
            return (Criteria) this;
        }

        public Criteria andFreportNumberNotLike(String value) {
            addCriterion("freport_number not like", value, "freportNumber");
            return (Criteria) this;
        }

        public Criteria andFreportNumberIn(List<String> values) {
            addCriterion("freport_number in", values, "freportNumber");
            return (Criteria) this;
        }

        public Criteria andFreportNumberNotIn(List<String> values) {
            addCriterion("freport_number not in", values, "freportNumber");
            return (Criteria) this;
        }

        public Criteria andFreportNumberBetween(String value1, String value2) {
            addCriterion("freport_number between", value1, value2, "freportNumber");
            return (Criteria) this;
        }

        public Criteria andFreportNumberNotBetween(String value1, String value2) {
            addCriterion("freport_number not between", value1, value2, "freportNumber");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageIsNull() {
            addCriterion("ffinance_chage is null");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageIsNotNull() {
            addCriterion("ffinance_chage is not null");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageEqualTo(String value) {
            addCriterion("ffinance_chage =", value, "ffinanceChage");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageNotEqualTo(String value) {
            addCriterion("ffinance_chage <>", value, "ffinanceChage");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageGreaterThan(String value) {
            addCriterion("ffinance_chage >", value, "ffinanceChage");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageGreaterThanOrEqualTo(String value) {
            addCriterion("ffinance_chage >=", value, "ffinanceChage");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageLessThan(String value) {
            addCriterion("ffinance_chage <", value, "ffinanceChage");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageLessThanOrEqualTo(String value) {
            addCriterion("ffinance_chage <=", value, "ffinanceChage");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageLike(String value) {
            addCriterion("ffinance_chage like", value, "ffinanceChage");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageNotLike(String value) {
            addCriterion("ffinance_chage not like", value, "ffinanceChage");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageIn(List<String> values) {
            addCriterion("ffinance_chage in", values, "ffinanceChage");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageNotIn(List<String> values) {
            addCriterion("ffinance_chage not in", values, "ffinanceChage");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageBetween(String value1, String value2) {
            addCriterion("ffinance_chage between", value1, value2, "ffinanceChage");
            return (Criteria) this;
        }

        public Criteria andFfinanceChageNotBetween(String value1, String value2) {
            addCriterion("ffinance_chage not between", value1, value2, "ffinanceChage");
            return (Criteria) this;
        }

        public Criteria andFunitChageIsNull() {
            addCriterion("funit_chage is null");
            return (Criteria) this;
        }

        public Criteria andFunitChageIsNotNull() {
            addCriterion("funit_chage is not null");
            return (Criteria) this;
        }

        public Criteria andFunitChageEqualTo(String value) {
            addCriterion("funit_chage =", value, "funitChage");
            return (Criteria) this;
        }

        public Criteria andFunitChageNotEqualTo(String value) {
            addCriterion("funit_chage <>", value, "funitChage");
            return (Criteria) this;
        }

        public Criteria andFunitChageGreaterThan(String value) {
            addCriterion("funit_chage >", value, "funitChage");
            return (Criteria) this;
        }

        public Criteria andFunitChageGreaterThanOrEqualTo(String value) {
            addCriterion("funit_chage >=", value, "funitChage");
            return (Criteria) this;
        }

        public Criteria andFunitChageLessThan(String value) {
            addCriterion("funit_chage <", value, "funitChage");
            return (Criteria) this;
        }

        public Criteria andFunitChageLessThanOrEqualTo(String value) {
            addCriterion("funit_chage <=", value, "funitChage");
            return (Criteria) this;
        }

        public Criteria andFunitChageLike(String value) {
            addCriterion("funit_chage like", value, "funitChage");
            return (Criteria) this;
        }

        public Criteria andFunitChageNotLike(String value) {
            addCriterion("funit_chage not like", value, "funitChage");
            return (Criteria) this;
        }

        public Criteria andFunitChageIn(List<String> values) {
            addCriterion("funit_chage in", values, "funitChage");
            return (Criteria) this;
        }

        public Criteria andFunitChageNotIn(List<String> values) {
            addCriterion("funit_chage not in", values, "funitChage");
            return (Criteria) this;
        }

        public Criteria andFunitChageBetween(String value1, String value2) {
            addCriterion("funit_chage between", value1, value2, "funitChage");
            return (Criteria) this;
        }

        public Criteria andFunitChageNotBetween(String value1, String value2) {
            addCriterion("funit_chage not between", value1, value2, "funitChage");
            return (Criteria) this;
        }

        public Criteria andFbizdateIsNull() {
            addCriterion("fbizdate is null");
            return (Criteria) this;
        }

        public Criteria andFbizdateIsNotNull() {
            addCriterion("fbizdate is not null");
            return (Criteria) this;
        }

        public Criteria andFbizdateEqualTo(Date value) {
            addCriterionForJDBCDate("fbizdate =", value, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("fbizdate <>", value, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateGreaterThan(Date value) {
            addCriterionForJDBCDate("fbizdate >", value, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fbizdate >=", value, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateLessThan(Date value) {
            addCriterionForJDBCDate("fbizdate <", value, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fbizdate <=", value, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateIn(List<Date> values) {
            addCriterionForJDBCDate("fbizdate in", values, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("fbizdate not in", values, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fbizdate between", value1, value2, "fbizdate");
            return (Criteria) this;
        }

        public Criteria andFbizdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fbizdate not between", value1, value2, "fbizdate");
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