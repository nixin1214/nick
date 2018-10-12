package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 主营业务收支总(累计)
 * Created by lx on 2017/11/14.
 */
public class FinanceMainBusinessTotal implements Serializable{
    private Long fid;
    private String frow_num;
    private String fproject;
    private BigDecimal sale_budget;
    private BigDecimal sale_actual;
    private BigDecimal income_budget;
    private BigDecimal income_actual;
    private BigDecimal income_total;
    private BigDecimal cost_budget;
    private BigDecimal cost_actual;
    private BigDecimal cost_total;
    private BigDecimal sale_profit_budget;
    private BigDecimal sale_profit_actual;
    private BigDecimal sale_profit_budget_ratio;
    private BigDecimal sale_profit_actual_ratio;
    private BigDecimal sale_total;
    private Long fhead_id;
    private int frow_index;
    private  int fstrong;

    public FinanceMainBusinessTotal() {
    }

    public FinanceMainBusinessTotal(Long fid, String frow_num, String fproject, BigDecimal sale_budget, BigDecimal sale_actual, BigDecimal income_budget, BigDecimal income_actual, BigDecimal income_total, BigDecimal cost_budget, BigDecimal cost_actual, BigDecimal cost_total, BigDecimal sale_profit_budget, BigDecimal sale_profit_actual, BigDecimal sale_profit_budget_ratio, BigDecimal sale_profit_actual_ratio, BigDecimal sale_total, Long fhead_id, int frow_index, int fstrong) {
        this.fid = fid;
        this.frow_num = frow_num;
        this.fproject = fproject;
        this.sale_budget = sale_budget;
        this.sale_actual = sale_actual;
        this.income_budget = income_budget;
        this.income_actual = income_actual;
        this.income_total = income_total;
        this.cost_budget = cost_budget;
        this.cost_actual = cost_actual;
        this.cost_total = cost_total;
        this.sale_profit_budget = sale_profit_budget;
        this.sale_profit_actual = sale_profit_actual;
        this.sale_profit_budget_ratio = sale_profit_budget_ratio;
        this.sale_profit_actual_ratio = sale_profit_actual_ratio;
        this.sale_total = sale_total;
        this.fhead_id = fhead_id;
        this.frow_index = frow_index;
        this.fstrong = fstrong;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFrow_num() {
        return frow_num;
    }

    public void setFrow_num(String frow_num) {
        this.frow_num = frow_num;
    }

    public String getFproject() {
        return fproject;
    }

    public void setFproject(String fproject) {
        this.fproject = fproject;
    }

    public BigDecimal getSale_budget() {
        return sale_budget;
    }

    public void setSale_budget(BigDecimal sale_budget) {
        this.sale_budget = sale_budget;
    }

    public BigDecimal getSale_actual() {
        return sale_actual;
    }

    public void setSale_actual(BigDecimal sale_actual) {
        this.sale_actual = sale_actual;
    }

    public BigDecimal getIncome_budget() {
        return income_budget;
    }

    public void setIncome_budget(BigDecimal income_budget) {
        this.income_budget = income_budget;
    }

    public BigDecimal getIncome_actual() {
        return income_actual;
    }

    public void setIncome_actual(BigDecimal income_actual) {
        this.income_actual = income_actual;
    }

    public BigDecimal getIncome_total() {
        return income_total;
    }

    public void setIncome_total(BigDecimal income_total) {
        this.income_total = income_total;
    }

    public BigDecimal getCost_budget() {
        return cost_budget;
    }

    public void setCost_budget(BigDecimal cost_budget) {
        this.cost_budget = cost_budget;
    }

    public BigDecimal getCost_actual() {
        return cost_actual;
    }

    public void setCost_actual(BigDecimal cost_actual) {
        this.cost_actual = cost_actual;
    }

    public BigDecimal getCost_total() {
        return cost_total;
    }

    public void setCost_total(BigDecimal cost_total) {
        this.cost_total = cost_total;
    }

    public BigDecimal getSale_profit_budget() {
        return sale_profit_budget;
    }

    public void setSale_profit_budget(BigDecimal sale_profit_budget) {
        this.sale_profit_budget = sale_profit_budget;
    }

    public BigDecimal getSale_profit_actual() {
        return sale_profit_actual;
    }

    public void setSale_profit_actual(BigDecimal sale_profit_actual) {
        this.sale_profit_actual = sale_profit_actual;
    }

    public BigDecimal getSale_profit_budget_ratio() {
        return sale_profit_budget_ratio;
    }

    public void setSale_profit_budget_ratio(BigDecimal sale_profit_budget_ratio) {
        this.sale_profit_budget_ratio = sale_profit_budget_ratio;
    }

    public BigDecimal getSale_profit_actual_ratio() {
        return sale_profit_actual_ratio;
    }

    public void setSale_profit_actual_ratio(BigDecimal sale_profit_actual_ratio) {
        this.sale_profit_actual_ratio = sale_profit_actual_ratio;
    }

    public BigDecimal getSale_total() {
        return sale_total;
    }

    public void setSale_total(BigDecimal sale_total) {
        this.sale_total = sale_total;
    }

    public Long getFhead_id() {
        return fhead_id;
    }

    public void setFhead_id(Long fhead_id) {
        this.fhead_id = fhead_id;
    }

    public int getFrow_index() {
        return frow_index;
    }

    public void setFrow_index(int frow_index) {
        this.frow_index = frow_index;
    }

    public int getFstrong() {
        return fstrong;
    }

    public void setFstrong(int fstrong) {
        this.fstrong = fstrong;
    }
}
