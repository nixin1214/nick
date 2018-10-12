package com.roncoo.adminlte.bean.entity;

import java.util.ArrayList;
import java.util.List;

public class TExcelSheetConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TExcelSheetConfigExample() {
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

        public Criteria andFheadIdIsNull() {
            addCriterion("fhead_id is null");
            return (Criteria) this;
        }

        public Criteria andFheadIdIsNotNull() {
            addCriterion("fhead_id is not null");
            return (Criteria) this;
        }

        public Criteria andFheadIdEqualTo(Long value) {
            addCriterion("fhead_id =", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotEqualTo(Long value) {
            addCriterion("fhead_id <>", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdGreaterThan(Long value) {
            addCriterion("fhead_id >", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fhead_id >=", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdLessThan(Long value) {
            addCriterion("fhead_id <", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdLessThanOrEqualTo(Long value) {
            addCriterion("fhead_id <=", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdIn(List<Long> values) {
            addCriterion("fhead_id in", values, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotIn(List<Long> values) {
            addCriterion("fhead_id not in", values, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdBetween(Long value1, Long value2) {
            addCriterion("fhead_id between", value1, value2, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotBetween(Long value1, Long value2) {
            addCriterion("fhead_id not between", value1, value2, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFsheetIndexIsNull() {
            addCriterion("fsheet_index is null");
            return (Criteria) this;
        }

        public Criteria andFsheetIndexIsNotNull() {
            addCriterion("fsheet_index is not null");
            return (Criteria) this;
        }

        public Criteria andFsheetIndexEqualTo(Integer value) {
            addCriterion("fsheet_index =", value, "fsheetIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetIndexNotEqualTo(Integer value) {
            addCriterion("fsheet_index <>", value, "fsheetIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetIndexGreaterThan(Integer value) {
            addCriterion("fsheet_index >", value, "fsheetIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("fsheet_index >=", value, "fsheetIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetIndexLessThan(Integer value) {
            addCriterion("fsheet_index <", value, "fsheetIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetIndexLessThanOrEqualTo(Integer value) {
            addCriterion("fsheet_index <=", value, "fsheetIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetIndexIn(List<Integer> values) {
            addCriterion("fsheet_index in", values, "fsheetIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetIndexNotIn(List<Integer> values) {
            addCriterion("fsheet_index not in", values, "fsheetIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetIndexBetween(Integer value1, Integer value2) {
            addCriterion("fsheet_index between", value1, value2, "fsheetIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("fsheet_index not between", value1, value2, "fsheetIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetNameIsNull() {
            addCriterion("fsheet_name is null");
            return (Criteria) this;
        }

        public Criteria andFsheetNameIsNotNull() {
            addCriterion("fsheet_name is not null");
            return (Criteria) this;
        }

        public Criteria andFsheetNameEqualTo(String value) {
            addCriterion("fsheet_name =", value, "fsheetName");
            return (Criteria) this;
        }

        public Criteria andFsheetNameNotEqualTo(String value) {
            addCriterion("fsheet_name <>", value, "fsheetName");
            return (Criteria) this;
        }

        public Criteria andFsheetNameGreaterThan(String value) {
            addCriterion("fsheet_name >", value, "fsheetName");
            return (Criteria) this;
        }

        public Criteria andFsheetNameGreaterThanOrEqualTo(String value) {
            addCriterion("fsheet_name >=", value, "fsheetName");
            return (Criteria) this;
        }

        public Criteria andFsheetNameLessThan(String value) {
            addCriterion("fsheet_name <", value, "fsheetName");
            return (Criteria) this;
        }

        public Criteria andFsheetNameLessThanOrEqualTo(String value) {
            addCriterion("fsheet_name <=", value, "fsheetName");
            return (Criteria) this;
        }

        public Criteria andFsheetNameLike(String value) {
            addCriterion("fsheet_name like", value, "fsheetName");
            return (Criteria) this;
        }

        public Criteria andFsheetNameNotLike(String value) {
            addCriterion("fsheet_name not like", value, "fsheetName");
            return (Criteria) this;
        }

        public Criteria andFsheetNameIn(List<String> values) {
            addCriterion("fsheet_name in", values, "fsheetName");
            return (Criteria) this;
        }

        public Criteria andFsheetNameNotIn(List<String> values) {
            addCriterion("fsheet_name not in", values, "fsheetName");
            return (Criteria) this;
        }

        public Criteria andFsheetNameBetween(String value1, String value2) {
            addCriterion("fsheet_name between", value1, value2, "fsheetName");
            return (Criteria) this;
        }

        public Criteria andFsheetNameNotBetween(String value1, String value2) {
            addCriterion("fsheet_name not between", value1, value2, "fsheetName");
            return (Criteria) this;
        }

        public Criteria andFstartRowIndexIsNull() {
            addCriterion("fstart_row_index is null");
            return (Criteria) this;
        }

        public Criteria andFstartRowIndexIsNotNull() {
            addCriterion("fstart_row_index is not null");
            return (Criteria) this;
        }

        public Criteria andFstartRowIndexEqualTo(Integer value) {
            addCriterion("fstart_row_index =", value, "fstartRowIndex");
            return (Criteria) this;
        }

        public Criteria andFstartRowIndexNotEqualTo(Integer value) {
            addCriterion("fstart_row_index <>", value, "fstartRowIndex");
            return (Criteria) this;
        }

        public Criteria andFstartRowIndexGreaterThan(Integer value) {
            addCriterion("fstart_row_index >", value, "fstartRowIndex");
            return (Criteria) this;
        }

        public Criteria andFstartRowIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("fstart_row_index >=", value, "fstartRowIndex");
            return (Criteria) this;
        }

        public Criteria andFstartRowIndexLessThan(Integer value) {
            addCriterion("fstart_row_index <", value, "fstartRowIndex");
            return (Criteria) this;
        }

        public Criteria andFstartRowIndexLessThanOrEqualTo(Integer value) {
            addCriterion("fstart_row_index <=", value, "fstartRowIndex");
            return (Criteria) this;
        }

        public Criteria andFstartRowIndexIn(List<Integer> values) {
            addCriterion("fstart_row_index in", values, "fstartRowIndex");
            return (Criteria) this;
        }

        public Criteria andFstartRowIndexNotIn(List<Integer> values) {
            addCriterion("fstart_row_index not in", values, "fstartRowIndex");
            return (Criteria) this;
        }

        public Criteria andFstartRowIndexBetween(Integer value1, Integer value2) {
            addCriterion("fstart_row_index between", value1, value2, "fstartRowIndex");
            return (Criteria) this;
        }

        public Criteria andFstartRowIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("fstart_row_index not between", value1, value2, "fstartRowIndex");
            return (Criteria) this;
        }

        public Criteria andFendRowIndexIsNull() {
            addCriterion("fend_row_index is null");
            return (Criteria) this;
        }

        public Criteria andFendRowIndexIsNotNull() {
            addCriterion("fend_row_index is not null");
            return (Criteria) this;
        }

        public Criteria andFendRowIndexEqualTo(Integer value) {
            addCriterion("fend_row_index =", value, "fendRowIndex");
            return (Criteria) this;
        }

        public Criteria andFendRowIndexNotEqualTo(Integer value) {
            addCriterion("fend_row_index <>", value, "fendRowIndex");
            return (Criteria) this;
        }

        public Criteria andFendRowIndexGreaterThan(Integer value) {
            addCriterion("fend_row_index >", value, "fendRowIndex");
            return (Criteria) this;
        }

        public Criteria andFendRowIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("fend_row_index >=", value, "fendRowIndex");
            return (Criteria) this;
        }

        public Criteria andFendRowIndexLessThan(Integer value) {
            addCriterion("fend_row_index <", value, "fendRowIndex");
            return (Criteria) this;
        }

        public Criteria andFendRowIndexLessThanOrEqualTo(Integer value) {
            addCriterion("fend_row_index <=", value, "fendRowIndex");
            return (Criteria) this;
        }

        public Criteria andFendRowIndexIn(List<Integer> values) {
            addCriterion("fend_row_index in", values, "fendRowIndex");
            return (Criteria) this;
        }

        public Criteria andFendRowIndexNotIn(List<Integer> values) {
            addCriterion("fend_row_index not in", values, "fendRowIndex");
            return (Criteria) this;
        }

        public Criteria andFendRowIndexBetween(Integer value1, Integer value2) {
            addCriterion("fend_row_index between", value1, value2, "fendRowIndex");
            return (Criteria) this;
        }

        public Criteria andFendRowIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("fend_row_index not between", value1, value2, "fendRowIndex");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsIsNull() {
            addCriterion("fcol_indexs is null");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsIsNotNull() {
            addCriterion("fcol_indexs is not null");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsEqualTo(String value) {
            addCriterion("fcol_indexs =", value, "fcolIndexs");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsNotEqualTo(String value) {
            addCriterion("fcol_indexs <>", value, "fcolIndexs");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsGreaterThan(String value) {
            addCriterion("fcol_indexs >", value, "fcolIndexs");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsGreaterThanOrEqualTo(String value) {
            addCriterion("fcol_indexs >=", value, "fcolIndexs");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsLessThan(String value) {
            addCriterion("fcol_indexs <", value, "fcolIndexs");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsLessThanOrEqualTo(String value) {
            addCriterion("fcol_indexs <=", value, "fcolIndexs");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsLike(String value) {
            addCriterion("fcol_indexs like", value, "fcolIndexs");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsNotLike(String value) {
            addCriterion("fcol_indexs not like", value, "fcolIndexs");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsIn(List<String> values) {
            addCriterion("fcol_indexs in", values, "fcolIndexs");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsNotIn(List<String> values) {
            addCriterion("fcol_indexs not in", values, "fcolIndexs");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsBetween(String value1, String value2) {
            addCriterion("fcol_indexs between", value1, value2, "fcolIndexs");
            return (Criteria) this;
        }

        public Criteria andFcolIndexsNotBetween(String value1, String value2) {
            addCriterion("fcol_indexs not between", value1, value2, "fcolIndexs");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexIsNull() {
            addCriterion("fignore_rows_index is null");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexIsNotNull() {
            addCriterion("fignore_rows_index is not null");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexEqualTo(String value) {
            addCriterion("fignore_rows_index =", value, "fignoreRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexNotEqualTo(String value) {
            addCriterion("fignore_rows_index <>", value, "fignoreRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexGreaterThan(String value) {
            addCriterion("fignore_rows_index >", value, "fignoreRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexGreaterThanOrEqualTo(String value) {
            addCriterion("fignore_rows_index >=", value, "fignoreRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexLessThan(String value) {
            addCriterion("fignore_rows_index <", value, "fignoreRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexLessThanOrEqualTo(String value) {
            addCriterion("fignore_rows_index <=", value, "fignoreRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexLike(String value) {
            addCriterion("fignore_rows_index like", value, "fignoreRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexNotLike(String value) {
            addCriterion("fignore_rows_index not like", value, "fignoreRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexIn(List<String> values) {
            addCriterion("fignore_rows_index in", values, "fignoreRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexNotIn(List<String> values) {
            addCriterion("fignore_rows_index not in", values, "fignoreRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexBetween(String value1, String value2) {
            addCriterion("fignore_rows_index between", value1, value2, "fignoreRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFignoreRowsIndexNotBetween(String value1, String value2) {
            addCriterion("fignore_rows_index not between", value1, value2, "fignoreRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFdbTableIsNull() {
            addCriterion("fdb_table is null");
            return (Criteria) this;
        }

        public Criteria andFdbTableIsNotNull() {
            addCriterion("fdb_table is not null");
            return (Criteria) this;
        }

        public Criteria andFdbTableEqualTo(String value) {
            addCriterion("fdb_table =", value, "fdbTable");
            return (Criteria) this;
        }

        public Criteria andFdbTableNotEqualTo(String value) {
            addCriterion("fdb_table <>", value, "fdbTable");
            return (Criteria) this;
        }

        public Criteria andFdbTableGreaterThan(String value) {
            addCriterion("fdb_table >", value, "fdbTable");
            return (Criteria) this;
        }

        public Criteria andFdbTableGreaterThanOrEqualTo(String value) {
            addCriterion("fdb_table >=", value, "fdbTable");
            return (Criteria) this;
        }

        public Criteria andFdbTableLessThan(String value) {
            addCriterion("fdb_table <", value, "fdbTable");
            return (Criteria) this;
        }

        public Criteria andFdbTableLessThanOrEqualTo(String value) {
            addCriterion("fdb_table <=", value, "fdbTable");
            return (Criteria) this;
        }

        public Criteria andFdbTableLike(String value) {
            addCriterion("fdb_table like", value, "fdbTable");
            return (Criteria) this;
        }

        public Criteria andFdbTableNotLike(String value) {
            addCriterion("fdb_table not like", value, "fdbTable");
            return (Criteria) this;
        }

        public Criteria andFdbTableIn(List<String> values) {
            addCriterion("fdb_table in", values, "fdbTable");
            return (Criteria) this;
        }

        public Criteria andFdbTableNotIn(List<String> values) {
            addCriterion("fdb_table not in", values, "fdbTable");
            return (Criteria) this;
        }

        public Criteria andFdbTableBetween(String value1, String value2) {
            addCriterion("fdb_table between", value1, value2, "fdbTable");
            return (Criteria) this;
        }

        public Criteria andFdbTableNotBetween(String value1, String value2) {
            addCriterion("fdb_table not between", value1, value2, "fdbTable");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexIsNull() {
            addCriterion("fstrong_rows_index is null");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexIsNotNull() {
            addCriterion("fstrong_rows_index is not null");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexEqualTo(String value) {
            addCriterion("fstrong_rows_index =", value, "fstrongRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexNotEqualTo(String value) {
            addCriterion("fstrong_rows_index <>", value, "fstrongRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexGreaterThan(String value) {
            addCriterion("fstrong_rows_index >", value, "fstrongRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexGreaterThanOrEqualTo(String value) {
            addCriterion("fstrong_rows_index >=", value, "fstrongRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexLessThan(String value) {
            addCriterion("fstrong_rows_index <", value, "fstrongRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexLessThanOrEqualTo(String value) {
            addCriterion("fstrong_rows_index <=", value, "fstrongRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexLike(String value) {
            addCriterion("fstrong_rows_index like", value, "fstrongRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexNotLike(String value) {
            addCriterion("fstrong_rows_index not like", value, "fstrongRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexIn(List<String> values) {
            addCriterion("fstrong_rows_index in", values, "fstrongRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexNotIn(List<String> values) {
            addCriterion("fstrong_rows_index not in", values, "fstrongRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexBetween(String value1, String value2) {
            addCriterion("fstrong_rows_index between", value1, value2, "fstrongRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFstrongRowsIndexNotBetween(String value1, String value2) {
            addCriterion("fstrong_rows_index not between", value1, value2, "fstrongRowsIndex");
            return (Criteria) this;
        }

        public Criteria andFmergesIsNull() {
            addCriterion("fmerges is null");
            return (Criteria) this;
        }

        public Criteria andFmergesIsNotNull() {
            addCriterion("fmerges is not null");
            return (Criteria) this;
        }

        public Criteria andFmergesEqualTo(String value) {
            addCriterion("fmerges =", value, "fmerges");
            return (Criteria) this;
        }

        public Criteria andFmergesNotEqualTo(String value) {
            addCriterion("fmerges <>", value, "fmerges");
            return (Criteria) this;
        }

        public Criteria andFmergesGreaterThan(String value) {
            addCriterion("fmerges >", value, "fmerges");
            return (Criteria) this;
        }

        public Criteria andFmergesGreaterThanOrEqualTo(String value) {
            addCriterion("fmerges >=", value, "fmerges");
            return (Criteria) this;
        }

        public Criteria andFmergesLessThan(String value) {
            addCriterion("fmerges <", value, "fmerges");
            return (Criteria) this;
        }

        public Criteria andFmergesLessThanOrEqualTo(String value) {
            addCriterion("fmerges <=", value, "fmerges");
            return (Criteria) this;
        }

        public Criteria andFmergesLike(String value) {
            addCriterion("fmerges like", value, "fmerges");
            return (Criteria) this;
        }

        public Criteria andFmergesNotLike(String value) {
            addCriterion("fmerges not like", value, "fmerges");
            return (Criteria) this;
        }

        public Criteria andFmergesIn(List<String> values) {
            addCriterion("fmerges in", values, "fmerges");
            return (Criteria) this;
        }

        public Criteria andFmergesNotIn(List<String> values) {
            addCriterion("fmerges not in", values, "fmerges");
            return (Criteria) this;
        }

        public Criteria andFmergesBetween(String value1, String value2) {
            addCriterion("fmerges between", value1, value2, "fmerges");
            return (Criteria) this;
        }

        public Criteria andFmergesNotBetween(String value1, String value2) {
            addCriterion("fmerges not between", value1, value2, "fmerges");
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