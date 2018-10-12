package com.roncoo.adminlte.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class TFinanceMainBusinessListMExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFinanceMainBusinessListMExample() {
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

        public Criteria andFidEqualTo(BigDecimal value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(BigDecimal value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(BigDecimal value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(BigDecimal value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<BigDecimal> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<BigDecimal> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFrowNumIsNull() {
            addCriterion("FROW_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFrowNumIsNotNull() {
            addCriterion("FROW_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFrowNumEqualTo(String value) {
            addCriterion("FROW_NUM =", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotEqualTo(String value) {
            addCriterion("FROW_NUM <>", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumGreaterThan(String value) {
            addCriterion("FROW_NUM >", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumGreaterThanOrEqualTo(String value) {
            addCriterion("FROW_NUM >=", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumLessThan(String value) {
            addCriterion("FROW_NUM <", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumLessThanOrEqualTo(String value) {
            addCriterion("FROW_NUM <=", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumLike(String value) {
            addCriterion("FROW_NUM like", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotLike(String value) {
            addCriterion("FROW_NUM not like", value, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumIn(List<String> values) {
            addCriterion("FROW_NUM in", values, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotIn(List<String> values) {
            addCriterion("FROW_NUM not in", values, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumBetween(String value1, String value2) {
            addCriterion("FROW_NUM between", value1, value2, "frowNum");
            return (Criteria) this;
        }

        public Criteria andFrowNumNotBetween(String value1, String value2) {
            addCriterion("FROW_NUM not between", value1, value2, "frowNum");
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

        public Criteria andSalesVolumeIsNull() {
            addCriterion("SALES_VOLUME is null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeIsNotNull() {
            addCriterion("SALES_VOLUME is not null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME =", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeNotEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME <>", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeGreaterThan(BigDecimal value) {
            addCriterion("SALES_VOLUME >", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME >=", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeLessThan(BigDecimal value) {
            addCriterion("SALES_VOLUME <", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALES_VOLUME <=", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeIn(List<BigDecimal> values) {
            addCriterion("SALES_VOLUME in", values, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeNotIn(List<BigDecimal> values) {
            addCriterion("SALES_VOLUME not in", values, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_VOLUME between", value1, value2, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALES_VOLUME not between", value1, value2, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSellingUnitPriceIsNull() {
            addCriterion("SELLING_UNIT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andSellingUnitPriceIsNotNull() {
            addCriterion("SELLING_UNIT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andSellingUnitPriceEqualTo(BigDecimal value) {
            addCriterion("SELLING_UNIT_PRICE =", value, "sellingUnitPrice");
            return (Criteria) this;
        }

        public Criteria andSellingUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("SELLING_UNIT_PRICE <>", value, "sellingUnitPrice");
            return (Criteria) this;
        }

        public Criteria andSellingUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("SELLING_UNIT_PRICE >", value, "sellingUnitPrice");
            return (Criteria) this;
        }

        public Criteria andSellingUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SELLING_UNIT_PRICE >=", value, "sellingUnitPrice");
            return (Criteria) this;
        }

        public Criteria andSellingUnitPriceLessThan(BigDecimal value) {
            addCriterion("SELLING_UNIT_PRICE <", value, "sellingUnitPrice");
            return (Criteria) this;
        }

        public Criteria andSellingUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SELLING_UNIT_PRICE <=", value, "sellingUnitPrice");
            return (Criteria) this;
        }

        public Criteria andSellingUnitPriceIn(List<BigDecimal> values) {
            addCriterion("SELLING_UNIT_PRICE in", values, "sellingUnitPrice");
            return (Criteria) this;
        }

        public Criteria andSellingUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("SELLING_UNIT_PRICE not in", values, "sellingUnitPrice");
            return (Criteria) this;
        }

        public Criteria andSellingUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SELLING_UNIT_PRICE between", value1, value2, "sellingUnitPrice");
            return (Criteria) this;
        }

        public Criteria andSellingUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SELLING_UNIT_PRICE not between", value1, value2, "sellingUnitPrice");
            return (Criteria) this;
        }

        public Criteria andSellingAmontIsNull() {
            addCriterion("SELLING_AMONT is null");
            return (Criteria) this;
        }

        public Criteria andSellingAmontIsNotNull() {
            addCriterion("SELLING_AMONT is not null");
            return (Criteria) this;
        }

        public Criteria andSellingAmontEqualTo(BigDecimal value) {
            addCriterion("SELLING_AMONT =", value, "sellingAmont");
            return (Criteria) this;
        }

        public Criteria andSellingAmontNotEqualTo(BigDecimal value) {
            addCriterion("SELLING_AMONT <>", value, "sellingAmont");
            return (Criteria) this;
        }

        public Criteria andSellingAmontGreaterThan(BigDecimal value) {
            addCriterion("SELLING_AMONT >", value, "sellingAmont");
            return (Criteria) this;
        }

        public Criteria andSellingAmontGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SELLING_AMONT >=", value, "sellingAmont");
            return (Criteria) this;
        }

        public Criteria andSellingAmontLessThan(BigDecimal value) {
            addCriterion("SELLING_AMONT <", value, "sellingAmont");
            return (Criteria) this;
        }

        public Criteria andSellingAmontLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SELLING_AMONT <=", value, "sellingAmont");
            return (Criteria) this;
        }

        public Criteria andSellingAmontIn(List<BigDecimal> values) {
            addCriterion("SELLING_AMONT in", values, "sellingAmont");
            return (Criteria) this;
        }

        public Criteria andSellingAmontNotIn(List<BigDecimal> values) {
            addCriterion("SELLING_AMONT not in", values, "sellingAmont");
            return (Criteria) this;
        }

        public Criteria andSellingAmontBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SELLING_AMONT between", value1, value2, "sellingAmont");
            return (Criteria) this;
        }

        public Criteria andSellingAmontNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SELLING_AMONT not between", value1, value2, "sellingAmont");
            return (Criteria) this;
        }

        public Criteria andCostUnitIsNull() {
            addCriterion("COST_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andCostUnitIsNotNull() {
            addCriterion("COST_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andCostUnitEqualTo(BigDecimal value) {
            addCriterion("COST_UNIT =", value, "costUnit");
            return (Criteria) this;
        }

        public Criteria andCostUnitNotEqualTo(BigDecimal value) {
            addCriterion("COST_UNIT <>", value, "costUnit");
            return (Criteria) this;
        }

        public Criteria andCostUnitGreaterThan(BigDecimal value) {
            addCriterion("COST_UNIT >", value, "costUnit");
            return (Criteria) this;
        }

        public Criteria andCostUnitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_UNIT >=", value, "costUnit");
            return (Criteria) this;
        }

        public Criteria andCostUnitLessThan(BigDecimal value) {
            addCriterion("COST_UNIT <", value, "costUnit");
            return (Criteria) this;
        }

        public Criteria andCostUnitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_UNIT <=", value, "costUnit");
            return (Criteria) this;
        }

        public Criteria andCostUnitIn(List<BigDecimal> values) {
            addCriterion("COST_UNIT in", values, "costUnit");
            return (Criteria) this;
        }

        public Criteria andCostUnitNotIn(List<BigDecimal> values) {
            addCriterion("COST_UNIT not in", values, "costUnit");
            return (Criteria) this;
        }

        public Criteria andCostUnitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_UNIT between", value1, value2, "costUnit");
            return (Criteria) this;
        }

        public Criteria andCostUnitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_UNIT not between", value1, value2, "costUnit");
            return (Criteria) this;
        }

        public Criteria andCostAmontIsNull() {
            addCriterion("COST_AMONT is null");
            return (Criteria) this;
        }

        public Criteria andCostAmontIsNotNull() {
            addCriterion("COST_AMONT is not null");
            return (Criteria) this;
        }

        public Criteria andCostAmontEqualTo(BigDecimal value) {
            addCriterion("COST_AMONT =", value, "costAmont");
            return (Criteria) this;
        }

        public Criteria andCostAmontNotEqualTo(BigDecimal value) {
            addCriterion("COST_AMONT <>", value, "costAmont");
            return (Criteria) this;
        }

        public Criteria andCostAmontGreaterThan(BigDecimal value) {
            addCriterion("COST_AMONT >", value, "costAmont");
            return (Criteria) this;
        }

        public Criteria andCostAmontGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_AMONT >=", value, "costAmont");
            return (Criteria) this;
        }

        public Criteria andCostAmontLessThan(BigDecimal value) {
            addCriterion("COST_AMONT <", value, "costAmont");
            return (Criteria) this;
        }

        public Criteria andCostAmontLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_AMONT <=", value, "costAmont");
            return (Criteria) this;
        }

        public Criteria andCostAmontIn(List<BigDecimal> values) {
            addCriterion("COST_AMONT in", values, "costAmont");
            return (Criteria) this;
        }

        public Criteria andCostAmontNotIn(List<BigDecimal> values) {
            addCriterion("COST_AMONT not in", values, "costAmont");
            return (Criteria) this;
        }

        public Criteria andCostAmontBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_AMONT between", value1, value2, "costAmont");
            return (Criteria) this;
        }

        public Criteria andCostAmontNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_AMONT not between", value1, value2, "costAmont");
            return (Criteria) this;
        }

        public Criteria andSaleProfitUnitIsNull() {
            addCriterion("SALE_PROFIT_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitUnitIsNotNull() {
            addCriterion("SALE_PROFIT_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitUnitEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_UNIT =", value, "saleProfitUnit");
            return (Criteria) this;
        }

        public Criteria andSaleProfitUnitNotEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_UNIT <>", value, "saleProfitUnit");
            return (Criteria) this;
        }

        public Criteria andSaleProfitUnitGreaterThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_UNIT >", value, "saleProfitUnit");
            return (Criteria) this;
        }

        public Criteria andSaleProfitUnitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_UNIT >=", value, "saleProfitUnit");
            return (Criteria) this;
        }

        public Criteria andSaleProfitUnitLessThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_UNIT <", value, "saleProfitUnit");
            return (Criteria) this;
        }

        public Criteria andSaleProfitUnitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_UNIT <=", value, "saleProfitUnit");
            return (Criteria) this;
        }

        public Criteria andSaleProfitUnitIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_UNIT in", values, "saleProfitUnit");
            return (Criteria) this;
        }

        public Criteria andSaleProfitUnitNotIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_UNIT not in", values, "saleProfitUnit");
            return (Criteria) this;
        }

        public Criteria andSaleProfitUnitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_UNIT between", value1, value2, "saleProfitUnit");
            return (Criteria) this;
        }

        public Criteria andSaleProfitUnitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_UNIT not between", value1, value2, "saleProfitUnit");
            return (Criteria) this;
        }

        public Criteria andSaleProfitCountIsNull() {
            addCriterion("SALE_PROFIT_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitCountIsNotNull() {
            addCriterion("SALE_PROFIT_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitCountEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_COUNT =", value, "saleProfitCount");
            return (Criteria) this;
        }

        public Criteria andSaleProfitCountNotEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_COUNT <>", value, "saleProfitCount");
            return (Criteria) this;
        }

        public Criteria andSaleProfitCountGreaterThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_COUNT >", value, "saleProfitCount");
            return (Criteria) this;
        }

        public Criteria andSaleProfitCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_COUNT >=", value, "saleProfitCount");
            return (Criteria) this;
        }

        public Criteria andSaleProfitCountLessThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_COUNT <", value, "saleProfitCount");
            return (Criteria) this;
        }

        public Criteria andSaleProfitCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_COUNT <=", value, "saleProfitCount");
            return (Criteria) this;
        }

        public Criteria andSaleProfitCountIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_COUNT in", values, "saleProfitCount");
            return (Criteria) this;
        }

        public Criteria andSaleProfitCountNotIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_COUNT not in", values, "saleProfitCount");
            return (Criteria) this;
        }

        public Criteria andSaleProfitCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_COUNT between", value1, value2, "saleProfitCount");
            return (Criteria) this;
        }

        public Criteria andSaleProfitCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_COUNT not between", value1, value2, "saleProfitCount");
            return (Criteria) this;
        }

        public Criteria andSaleProfitRatioIsNull() {
            addCriterion("SALE_PROFIT_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitRatioIsNotNull() {
            addCriterion("SALE_PROFIT_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andSaleProfitRatioEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_RATIO =", value, "saleProfitRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitRatioNotEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_RATIO <>", value, "saleProfitRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitRatioGreaterThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_RATIO >", value, "saleProfitRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_RATIO >=", value, "saleProfitRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitRatioLessThan(BigDecimal value) {
            addCriterion("SALE_PROFIT_RATIO <", value, "saleProfitRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SALE_PROFIT_RATIO <=", value, "saleProfitRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitRatioIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_RATIO in", values, "saleProfitRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitRatioNotIn(List<BigDecimal> values) {
            addCriterion("SALE_PROFIT_RATIO not in", values, "saleProfitRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_RATIO between", value1, value2, "saleProfitRatio");
            return (Criteria) this;
        }

        public Criteria andSaleProfitRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SALE_PROFIT_RATIO not between", value1, value2, "saleProfitRatio");
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

        public Criteria andFheadIdEqualTo(long value) {
            addCriterion("FHEAD_ID =", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotEqualTo(BigDecimal value) {
            addCriterion("FHEAD_ID <>", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdGreaterThan(BigDecimal value) {
            addCriterion("FHEAD_ID >", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FHEAD_ID >=", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdLessThan(BigDecimal value) {
            addCriterion("FHEAD_ID <", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FHEAD_ID <=", value, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdIn(List<BigDecimal> values) {
            addCriterion("FHEAD_ID in", values, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotIn(List<BigDecimal> values) {
            addCriterion("FHEAD_ID not in", values, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FHEAD_ID between", value1, value2, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFheadIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FHEAD_ID not between", value1, value2, "fheadId");
            return (Criteria) this;
        }

        public Criteria andFrowIndexIsNull() {
            addCriterion("FROW_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andFrowIndexIsNotNull() {
            addCriterion("FROW_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andFrowIndexEqualTo(Long value) {
            addCriterion("FROW_INDEX =", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexNotEqualTo(Long value) {
            addCriterion("FROW_INDEX <>", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexGreaterThan(Long value) {
            addCriterion("FROW_INDEX >", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("FROW_INDEX >=", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexLessThan(Long value) {
            addCriterion("FROW_INDEX <", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexLessThanOrEqualTo(Long value) {
            addCriterion("FROW_INDEX <=", value, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexIn(List<Long> values) {
            addCriterion("FROW_INDEX in", values, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexNotIn(List<Long> values) {
            addCriterion("FROW_INDEX not in", values, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexBetween(Long value1, Long value2) {
            addCriterion("FROW_INDEX between", value1, value2, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFrowIndexNotBetween(Long value1, Long value2) {
            addCriterion("FROW_INDEX not between", value1, value2, "frowIndex");
            return (Criteria) this;
        }

        public Criteria andFstrongIsNull() {
            addCriterion("FSTRONG is null");
            return (Criteria) this;
        }

        public Criteria andFstrongIsNotNull() {
            addCriterion("FSTRONG is not null");
            return (Criteria) this;
        }

        public Criteria andFstrongEqualTo(Long value) {
            addCriterion("FSTRONG =", value, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongNotEqualTo(Long value) {
            addCriterion("FSTRONG <>", value, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongGreaterThan(Long value) {
            addCriterion("FSTRONG >", value, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongGreaterThanOrEqualTo(Long value) {
            addCriterion("FSTRONG >=", value, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongLessThan(Long value) {
            addCriterion("FSTRONG <", value, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongLessThanOrEqualTo(Long value) {
            addCriterion("FSTRONG <=", value, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongIn(List<Long> values) {
            addCriterion("FSTRONG in", values, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongNotIn(List<Long> values) {
            addCriterion("FSTRONG not in", values, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongBetween(Long value1, Long value2) {
            addCriterion("FSTRONG between", value1, value2, "fstrong");
            return (Criteria) this;
        }

        public Criteria andFstrongNotBetween(Long value1, Long value2) {
            addCriterion("FSTRONG not between", value1, value2, "fstrong");
            return (Criteria) this;
        }
    }

    /**
     */
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