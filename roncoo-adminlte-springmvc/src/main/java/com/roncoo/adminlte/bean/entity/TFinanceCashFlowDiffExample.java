package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TFinanceCashFlowDiffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public TFinanceCashFlowDiffExample() {
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
            addCriterion("FID is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FID is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Long value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Long value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Long value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Long value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Long value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Long value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Long> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Long> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Long value1, Long value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Long value1, Long value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFheadIdIsNull() {
            addCriterion("FHEAD_ID is null");
            return (Criteria) this;
        }

        public Criteria andFheadIdIsNotNull() {
            addCriterion("FHEAD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFheadIdEqualTo(Long value) {
            addCriterion("FHEAD_ID =", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotEqualTo(Long value) {
            addCriterion("FHEAD_ID <>", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdGreaterThan(Long value) {
            addCriterion("FHEAD_ID >", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FHEAD_ID >=", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdLessThan(Long value) {
            addCriterion("FHEAD_ID <", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdLessThanOrEqualTo(Long value) {
            addCriterion("FHEAD_ID <=", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdIn(List<Long> values) {
            addCriterion("FHEAD_ID in", values, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotIn(List<Long> values) {
            addCriterion("FHEAD_ID not in", values, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdBetween(Long value1, Long value2) {
            addCriterion("FHEAD_ID between", value1, value2, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotBetween(Long value1, Long value2) {
            addCriterion("FHEAD_ID not between", value1, value2, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFprojectIsNull() {
            addCriterion("FPROJECT is null");
            return (Criteria) this;
        }

        public Criteria andFprojectIsNotNull() {
            addCriterion("FPROJECT is not null");
            return (Criteria) this;
        }

        public Criteria andFprojectEqualTo(String value) {
            addCriterion("FPROJECT =", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectNotEqualTo(String value) {
            addCriterion("FPROJECT <>", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectGreaterThan(String value) {
            addCriterion("FPROJECT >", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectGreaterThanOrEqualTo(String value) {
            addCriterion("FPROJECT >=", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectLessThan(String value) {
            addCriterion("FPROJECT <", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectLessThanOrEqualTo(String value) {
            addCriterion("FPROJECT <=", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectLike(String value) {
            addCriterion("FPROJECT like", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectNotLike(String value) {
            addCriterion("FPROJECT not like", value, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectIn(List<String> values) {
            addCriterion("FPROJECT in", values, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectNotIn(List<String> values) {
            addCriterion("FPROJECT not in", values, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectBetween(String value1, String value2) {
            addCriterion("FPROJECT between", value1, value2, "fproject");
            return (Criteria) this;
        }

        public Criteria andFprojectNotBetween(String value1, String value2) {
            addCriterion("FPROJECT not between", value1, value2, "fproject");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCumIsNull() {
            addCriterion("FTHIS_PERIOD_CUM is null");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCumIsNotNull() {
            addCriterion("FTHIS_PERIOD_CUM is not null");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCumEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_CUM =", value, "fthisPeriodCum");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCumNotEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_CUM <>", value, "fthisPeriodCum");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCumGreaterThan(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_CUM >", value, "fthisPeriodCum");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_CUM >=", value, "fthisPeriodCum");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCumLessThan(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_CUM <", value, "fthisPeriodCum");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_CUM <=", value, "fthisPeriodCum");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCumIn(List<BigDecimal> values) {
            addCriterion("FTHIS_PERIOD_CUM in", values, "fthisPeriodCum");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCumNotIn(List<BigDecimal> values) {
            addCriterion("FTHIS_PERIOD_CUM not in", values, "fthisPeriodCum");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_PERIOD_CUM between", value1, value2, "fthisPeriodCum");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_PERIOD_CUM not between", value1, value2, "fthisPeriodCum");
            return (Criteria) this;
        }

        public Criteria andFlastYearCumIsNull() {
            addCriterion("FLAST_YEAR_CUM is null");
            return (Criteria) this;
        }

        public Criteria andFlastYearCumIsNotNull() {
            addCriterion("FLAST_YEAR_CUM is not null");
            return (Criteria) this;
        }

        public Criteria andFlastYearCumEqualTo(BigDecimal value) {
            addCriterion("FLAST_YEAR_CUM =", value, "flastYearCum");
            return (Criteria) this;
        }

        public Criteria andFlastYearCumNotEqualTo(BigDecimal value) {
            addCriterion("FLAST_YEAR_CUM <>", value, "flastYearCum");
            return (Criteria) this;
        }

        public Criteria andFlastYearCumGreaterThan(BigDecimal value) {
            addCriterion("FLAST_YEAR_CUM >", value, "flastYearCum");
            return (Criteria) this;
        }

        public Criteria andFlastYearCumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FLAST_YEAR_CUM >=", value, "flastYearCum");
            return (Criteria) this;
        }

        public Criteria andFlastYearCumLessThan(BigDecimal value) {
            addCriterion("FLAST_YEAR_CUM <", value, "flastYearCum");
            return (Criteria) this;
        }

        public Criteria andFlastYearCumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FLAST_YEAR_CUM <=", value, "flastYearCum");
            return (Criteria) this;
        }

        public Criteria andFlastYearCumIn(List<BigDecimal> values) {
            addCriterion("FLAST_YEAR_CUM in", values, "flastYearCum");
            return (Criteria) this;
        }

        public Criteria andFlastYearCumNotIn(List<BigDecimal> values) {
            addCriterion("FLAST_YEAR_CUM not in", values, "flastYearCum");
            return (Criteria) this;
        }

        public Criteria andFlastYearCumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLAST_YEAR_CUM between", value1, value2, "flastYearCum");
            return (Criteria) this;
        }

        public Criteria andFlastYearCumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLAST_YEAR_CUM not between", value1, value2, "flastYearCum");
            return (Criteria) this;
        }

        public Criteria andFotherDataIsNull() {
            addCriterion("FOTHER_DATA is null");
            return (Criteria) this;
        }

        public Criteria andFotherDataIsNotNull() {
            addCriterion("FOTHER_DATA is not null");
            return (Criteria) this;
        }

        public Criteria andFotherDataEqualTo(String value) {
            addCriterion("FOTHER_DATA =", value, "fotherData");
            return (Criteria) this;
        }

        public Criteria andFotherDataNotEqualTo(String value) {
            addCriterion("FOTHER_DATA <>", value, "fotherData");
            return (Criteria) this;
        }

        public Criteria andFotherDataGreaterThan(String value) {
            addCriterion("FOTHER_DATA >", value, "fotherData");
            return (Criteria) this;
        }

        public Criteria andFotherDataGreaterThanOrEqualTo(String value) {
            addCriterion("FOTHER_DATA >=", value, "fotherData");
            return (Criteria) this;
        }

        public Criteria andFotherDataLessThan(String value) {
            addCriterion("FOTHER_DATA <", value, "fotherData");
            return (Criteria) this;
        }

        public Criteria andFotherDataLessThanOrEqualTo(String value) {
            addCriterion("FOTHER_DATA <=", value, "fotherData");
            return (Criteria) this;
        }

        public Criteria andFotherDataLike(String value) {
            addCriterion("FOTHER_DATA like", value, "fotherData");
            return (Criteria) this;
        }

        public Criteria andFotherDataNotLike(String value) {
            addCriterion("FOTHER_DATA not like", value, "fotherData");
            return (Criteria) this;
        }

        public Criteria andFotherDataIn(List<String> values) {
            addCriterion("FOTHER_DATA in", values, "fotherData");
            return (Criteria) this;
        }

        public Criteria andFotherDataNotIn(List<String> values) {
            addCriterion("FOTHER_DATA not in", values, "fotherData");
            return (Criteria) this;
        }

        public Criteria andFotherDataBetween(String value1, String value2) {
            addCriterion("FOTHER_DATA between", value1, value2, "fotherData");
            return (Criteria) this;
        }

        public Criteria andFotherDataNotBetween(String value1, String value2) {
            addCriterion("FOTHER_DATA not between", value1, value2, "fotherData");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCum2IsNull() {
            addCriterion("FTHIS_PERIOD_CUM2 is null");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCum2IsNotNull() {
            addCriterion("FTHIS_PERIOD_CUM2 is not null");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCum2EqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_CUM2 =", value, "fthisPeriodCum2");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCum2NotEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_CUM2 <>", value, "fthisPeriodCum2");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCum2GreaterThan(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_CUM2 >", value, "fthisPeriodCum2");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCum2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_CUM2 >=", value, "fthisPeriodCum2");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCum2LessThan(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_CUM2 <", value, "fthisPeriodCum2");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCum2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FTHIS_PERIOD_CUM2 <=", value, "fthisPeriodCum2");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCum2In(List<BigDecimal> values) {
            addCriterion("FTHIS_PERIOD_CUM2 in", values, "fthisPeriodCum2");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCum2NotIn(List<BigDecimal> values) {
            addCriterion("FTHIS_PERIOD_CUM2 not in", values, "fthisPeriodCum2");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCum2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_PERIOD_CUM2 between", value1, value2, "fthisPeriodCum2");
            return (Criteria) this;
        }

        public Criteria andFthisPeriodCum2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FTHIS_PERIOD_CUM2 not between", value1, value2, "fthisPeriodCum2");
            return (Criteria) this;
        }

        public Criteria andFlastYearCum2IsNull() {
            addCriterion("FLAST_YEAR_CUM2 is null");
            return (Criteria) this;
        }

        public Criteria andFlastYearCum2IsNotNull() {
            addCriterion("FLAST_YEAR_CUM2 is not null");
            return (Criteria) this;
        }

        public Criteria andFlastYearCum2EqualTo(BigDecimal value) {
            addCriterion("FLAST_YEAR_CUM2 =", value, "flastYearCum2");
            return (Criteria) this;
        }

        public Criteria andFlastYearCum2NotEqualTo(BigDecimal value) {
            addCriterion("FLAST_YEAR_CUM2 <>", value, "flastYearCum2");
            return (Criteria) this;
        }

        public Criteria andFlastYearCum2GreaterThan(BigDecimal value) {
            addCriterion("FLAST_YEAR_CUM2 >", value, "flastYearCum2");
            return (Criteria) this;
        }

        public Criteria andFlastYearCum2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FLAST_YEAR_CUM2 >=", value, "flastYearCum2");
            return (Criteria) this;
        }

        public Criteria andFlastYearCum2LessThan(BigDecimal value) {
            addCriterion("FLAST_YEAR_CUM2 <", value, "flastYearCum2");
            return (Criteria) this;
        }

        public Criteria andFlastYearCum2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FLAST_YEAR_CUM2 <=", value, "flastYearCum2");
            return (Criteria) this;
        }

        public Criteria andFlastYearCum2In(List<BigDecimal> values) {
            addCriterion("FLAST_YEAR_CUM2 in", values, "flastYearCum2");
            return (Criteria) this;
        }

        public Criteria andFlastYearCum2NotIn(List<BigDecimal> values) {
            addCriterion("FLAST_YEAR_CUM2 not in", values, "flastYearCum2");
            return (Criteria) this;
        }

        public Criteria andFlastYearCum2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLAST_YEAR_CUM2 between", value1, value2, "flastYearCum2");
            return (Criteria) this;
        }

        public Criteria andFlastYearCum2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLAST_YEAR_CUM2 not between", value1, value2, "flastYearCum2");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexIsNull() {
            addCriterion("FSHEET_ROW_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexIsNotNull() {
            addCriterion("FSHEET_ROW_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexEqualTo(Long value) {
            addCriterion("FSHEET_ROW_INDEX =", value, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexNotEqualTo(Long value) {
            addCriterion("FSHEET_ROW_INDEX <>", value, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexGreaterThan(Long value) {
            addCriterion("FSHEET_ROW_INDEX >", value, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("FSHEET_ROW_INDEX >=", value, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexLessThan(Long value) {
            addCriterion("FSHEET_ROW_INDEX <", value, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexLessThanOrEqualTo(Long value) {
            addCriterion("FSHEET_ROW_INDEX <=", value, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexIn(List<Long> values) {
            addCriterion("FSHEET_ROW_INDEX in", values, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexNotIn(List<Long> values) {
            addCriterion("FSHEET_ROW_INDEX not in", values, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexBetween(Long value1, Long value2) {
            addCriterion("FSHEET_ROW_INDEX between", value1, value2, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFsheetRowIndexNotBetween(Long value1, Long value2) {
            addCriterion("FSHEET_ROW_INDEX not between", value1, value2, "fsheetRowIndex");
            return (Criteria) this;
        }

        public Criteria andFisStrongIsNull() {
            addCriterion("FIS_STRONG is null");
            return (Criteria) this;
        }

        public Criteria andFisStrongIsNotNull() {
            addCriterion("FIS_STRONG is not null");
            return (Criteria) this;
        }

        public Criteria andFisStrongEqualTo(Long value) {
            addCriterion("FIS_STRONG =", value, "fisStrong");
            return (Criteria) this;
        }

        public Criteria andFisStrongNotEqualTo(Long value) {
            addCriterion("FIS_STRONG <>", value, "fisStrong");
            return (Criteria) this;
        }

        public Criteria andFisStrongGreaterThan(Long value) {
            addCriterion("FIS_STRONG >", value, "fisStrong");
            return (Criteria) this;
        }

        public Criteria andFisStrongGreaterThanOrEqualTo(Long value) {
            addCriterion("FIS_STRONG >=", value, "fisStrong");
            return (Criteria) this;
        }

        public Criteria andFisStrongLessThan(Long value) {
            addCriterion("FIS_STRONG <", value, "fisStrong");
            return (Criteria) this;
        }

        public Criteria andFisStrongLessThanOrEqualTo(Long value) {
            addCriterion("FIS_STRONG <=", value, "fisStrong");
            return (Criteria) this;
        }

        public Criteria andFisStrongIn(List<Long> values) {
            addCriterion("FIS_STRONG in", values, "fisStrong");
            return (Criteria) this;
        }

        public Criteria andFisStrongNotIn(List<Long> values) {
            addCriterion("FIS_STRONG not in", values, "fisStrong");
            return (Criteria) this;
        }

        public Criteria andFisStrongBetween(Long value1, Long value2) {
            addCriterion("FIS_STRONG between", value1, value2, "fisStrong");
            return (Criteria) this;
        }

        public Criteria andFisStrongNotBetween(Long value1, Long value2) {
            addCriterion("FIS_STRONG not between", value1, value2, "fisStrong");
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