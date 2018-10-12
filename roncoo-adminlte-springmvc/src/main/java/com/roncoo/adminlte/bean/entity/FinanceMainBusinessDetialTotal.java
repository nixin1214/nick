package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 主营业务收支明细(累计)
 * Created by lx on 2017/11/14.
 */
public class FinanceMainBusinessDetialTotal implements Serializable{
    private Long fid;
    private String frow_num;
    private String fproject;
    private BigDecimal sales_volume;
    private BigDecimal selling_unit_price;
    private BigDecimal selling_amont;
    private BigDecimal cost_unit;
    private BigDecimal cost_last_month;
    private BigDecimal cost_amont;
    private BigDecimal sale_profit_unit;
    private BigDecimal sale_profit_count;
    private BigDecimal sale_profit_ratio;
    private Long fhead_id;
    private int frow_index;
    private  int fstrong;

    public FinanceMainBusinessDetialTotal() {
    }

    public FinanceMainBusinessDetialTotal(Long fid, String frow_num, String fproject, BigDecimal sales_volume, BigDecimal selling_unit_price, BigDecimal selling_amont, BigDecimal cost_unit, BigDecimal cost_last_month, BigDecimal cost_amont, BigDecimal sale_profit_unit, BigDecimal sale_profit_count, BigDecimal sale_profit_ratio, Long fhead_id, int frow_index, int fstrong) {
        this.fid = fid;
        this.frow_num = frow_num;
        this.fproject = fproject;
        this.sales_volume = sales_volume;
        this.selling_unit_price = selling_unit_price;
        this.selling_amont = selling_amont;
        this.cost_unit = cost_unit;
        this.cost_last_month = cost_last_month;
        this.cost_amont = cost_amont;
        this.sale_profit_unit = sale_profit_unit;
        this.sale_profit_count = sale_profit_count;
        this.sale_profit_ratio = sale_profit_ratio;
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

    public BigDecimal getSales_volume() {
        return sales_volume;
    }

    public void setSales_volume(BigDecimal sales_volume) {
        this.sales_volume = sales_volume;
    }

    public BigDecimal getSelling_unit_price() {
        return selling_unit_price;
    }

    public void setSelling_unit_price(BigDecimal selling_unit_price) {
        this.selling_unit_price = selling_unit_price;
    }

    public BigDecimal getSelling_amont() {
        return selling_amont;
    }

    public void setSelling_amont(BigDecimal selling_amont) {
        this.selling_amont = selling_amont;
    }

    public BigDecimal getCost_unit() {
        return cost_unit;
    }

    public void setCost_unit(BigDecimal cost_unit) {
        this.cost_unit = cost_unit;
    }

    public BigDecimal getCost_amont() {
        return cost_amont;
    }

    public void setCost_amont(BigDecimal cost_amont) {
        this.cost_amont = cost_amont;
    }

    public BigDecimal getSale_profit_unit() {
        return sale_profit_unit;
    }

    public void setSale_profit_unit(BigDecimal sale_profit_unit) {
        this.sale_profit_unit = sale_profit_unit;
    }

    public BigDecimal getSale_profit_count() {
        return sale_profit_count;
    }

    public void setSale_profit_count(BigDecimal sale_profit_count) {
        this.sale_profit_count = sale_profit_count;
    }

    public BigDecimal getSale_profit_ratio() {
        return sale_profit_ratio;
    }

    public void setSale_profit_ratio(BigDecimal sale_profit_ratio) {
        this.sale_profit_ratio = sale_profit_ratio;
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

    public BigDecimal getCost_last_month() {
        return cost_last_month;
    }

    public void setCost_last_month(BigDecimal cost_last_month) {
        this.cost_last_month = cost_last_month;
    }
}
