package com.roncoo.adminlte.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.*;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * 财务指标导入工具类
 * Created by lx on 2017/11/10.
 */
public class IndicesTool {



    /**
     * 遍历主要指标1对象列表为JSON数组
     * @param list
     * @return
     */
    public static JSONArray listToJsonArray(List<TFinanceMainIndices> list) {
        JSONArray array = new JSONArray();
        for (TFinanceMainIndices tm : list) {
            JSONObject obj = new JSONObject();
            obj.put("type", "<strong>" + StringUtils.trimToEmpty(tm.getFcategory()) + "</strong>");
            if (tm.getFis_strong() == 1) {
                obj.put("name", "<strong>" + StringUtils.trimToEmpty(tm.getFproject()) + "</strong>");
            } else {
                obj.put("name", tm.getFproject());
            }
            obj.put("rowNum", tm.getFrow_index());
            obj.put("this_budget", tm.getFthis_period_budget());
            obj.put("this_last_year", tm.getFthis_period_last_year());
            obj.put("this_actual", tm.getFthis_period_actual());
            obj.put("cum_budget", tm.getFcum_budget());
            obj.put("cum_last_year", tm.getFcum_last_year());
            obj.put("cum_actual", tm.getFcum_actual());
            array.add(obj);
        }
        return array;
    }

    /**
     * List 转换成JSON 数组并封装成JSON对象
     * @param object
     * @param list
     */
    public static void listToJson(JSONObject object, List list) {
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            String text = JSON.toJSONString(list);
            object.put("datas", JSONArray.parseArray(text));
            object.put("stateCode", 200);
        }
    }


    /**
     * 利润对象列表转JsonArray
     * @param list
     * @return
     */
    public static JSONArray balanceProfitListToJsonArray(List<BalanceProfit> list) {
        JSONArray array = new JSONArray();
        if (list!=null && list.size()>0){

            for (BalanceProfit bl : list) {
                JSONObject obj = new JSONObject();
                if (bl.getFstrong() == 1) {
                    obj.put("fproject", "<strong>" +bl.getFproject() + "</strong>");
                    obj.put("frow_num", "<strong>" +bl.getFrow_num() + "</strong>");
                    obj.put("last_year_actual", "<strong>" +bl.getLast_year_actual() + "</strong>");
                    obj.put("last_year_total", "<strong>" +bl.getLast_year_total() + "</strong>");
                    obj.put("this_year_budget", "<strong>" +bl.getThis_year_budget() + "</strong>");
                    obj.put("this_year_budget_total","<strong>" + bl.getThis_year_budget_total() + "</strong>");
                    obj.put("this_year_actual", "<strong>" +bl.getThis_year_actual() + "</strong>");
                    obj.put("this_year_actual_total","<strong>" + bl.getThis_year_actual_total() + "</strong>");
                } else {
                    obj.put("fproject", bl.getFproject());
                    obj.put("frow_num", bl.getFrow_num());
                    obj.put("last_year_actual", bl.getLast_year_actual());
                    obj.put("last_year_total", bl.getLast_year_total());
                    obj.put("this_year_budget", bl.getThis_year_budget());
                    obj.put("this_year_budget_total", bl.getThis_year_budget_total());
                    obj.put("this_year_actual", bl.getThis_year_actual());
                    obj.put("this_year_actual_total", bl.getThis_year_actual_total());
                }
                array.add(obj);
            }
        }
        return  array;
    }

    /**
     * 利润对象列表转JsonArray
     * @param list
     * @return
     */
    public static JSONArray balanceProfitListToJsonArray2(List<TFinanceProfitDiff> list) {
        JSONArray array = new JSONArray();
        if (list!=null && list.size()>0){

            for (TFinanceProfitDiff bl : list) {
                JSONObject obj = new JSONObject();
                if (bl.getFstrong() != null && bl.getFstrong().intValue() == 1) {
                    obj.put("fproject", "<strong>" +bl.getFproject() + "</strong>");
                    obj.put("frow_num", "<strong>" +bl.getFrowNum() + "</strong>");
                    obj.put("last_year_actual", "<strong>" +bl.getLastYearActual() + "</strong>");
                    obj.put("last_year_total", "<strong>" +bl.getLastYearTotal() + "</strong>");
                    obj.put("this_year_budget", "<strong>" +bl.getThisYearBudget() + "</strong>");
                    obj.put("this_year_budget_total","<strong>" + bl.getThisYearBudgetTotal() + "</strong>");
                    obj.put("this_year_actual", "<strong>" +bl.getThisYearActual() + "</strong>");
                    obj.put("this_year_actual_total","<strong>" + bl.getThisYearActualTotal() + "</strong>");
                } else {
                    obj.put("fproject", bl.getFproject());
                    obj.put("frow_num", bl.getFrowNum());
                    obj.put("last_year_actual", bl.getLastYearActual());
                    obj.put("last_year_total", bl.getLastYearTotal());
                    obj.put("this_year_budget", bl.getThisYearBudget());
                    obj.put("this_year_budget_total", bl.getThisYearBudgetTotal());
                    obj.put("this_year_actual", bl.getThisYearActual());
                    obj.put("this_year_actual_total", bl.getThisYearActualTotal());
                }
                array.add(obj);
            }
        }
        return  array;
    }

    /**
     * 现金流量列表转JsonArray
     * @param list
     * @return
     */
    public static JSONArray balanceCashFlowToArray(List<BalanceCashFlow> list) {
        JSONArray array = new JSONArray();
        if (list!=null && list.size()>0){
            for (BalanceCashFlow flow : list) {
                JSONObject obj = new JSONObject();
                if (flow.getFis_strong()==1){
                    obj.put("fproject", "<strong>" +flow.getFproject() + "</strong>");
                }else{
                    obj.put("fproject",flow.getFproject());
                }
                obj.put("fthis_period_cum",flow.getFthis_period_cum());
                obj.put("flast_year_cum",flow.getFlast_year_cum());
                obj.put("igDecimal",flow.getFother_data());
                obj.put("fthis_period_cum2",flow.getFthis_period_cum2());
                obj.put("flast_year_cum2",flow.getFlast_year_cum2());
                array.add(obj);
            }
        }
        return  array;
    }
    /**
     * 现金流量列表转JsonArray
     * @param list
     * @return
     */
    public static JSONArray balanceCashFlowToArray2(List<TFinanceCashFlowDiff> list) {
        JSONArray array = new JSONArray();
        if (list!=null && list.size()>0){
            for (TFinanceCashFlowDiff flow : list) {
                JSONObject obj = new JSONObject();
                if (flow.getFisStrong() != null && flow.getFisStrong().intValue()==1){
                    obj.put("fproject", "<strong>" +flow.getFproject() + "</strong>");
                }else{
                    obj.put("fproject",flow.getFproject());
                }
                obj.put("fthis_period_cum",flow.getFthisPeriodCum());
                obj.put("flast_year_cum",flow.getFlastYearCum());
                obj.put("igDecimal",flow.getFotherData());
                obj.put("fthis_period_cum2",flow.getFthisPeriodCum2());
                obj.put("flast_year_cum2",flow.getFlastYearCum2());
                array.add(obj);
            }
        }
        return  array;
    }


    /**
     * 主营业务收支总（本月）表转JsonArray
     * @param list
     * @return
     */
    public static JSONArray balanceMainBusinessMonthToArray(List<FinanceMainBusinessMonth> list) {
        JSONArray array = new JSONArray();
        if (list!=null && list.size()>0){
            for (FinanceMainBusinessMonth bm : list) {
                JSONObject obj = new JSONObject();
                if (bm.getFstrong()==1){
                    obj.put("fproject", "<strong>" +bm.getFproject() + "</strong>");
                    obj.put("frow_num","<strong>" +bm.getFrow_num() + "</strong>");
                }else{
                    obj.put("fproject",bm.getFproject());
                    obj.put("frow_num",bm.getFrow_num());
                }
                obj.put("sale_budget",bm.getSale_budget());
                obj.put("sale_actual",bm.getSale_actual());
                obj.put("income_budget",bm.getIncome_budget());
                obj.put("income_actual",bm.getIncome_actual());
                obj.put("income_total",bm.getIncome_total());
                obj.put("cost_budget",bm.getCost_budget());
                obj.put("cost_actual",bm.getCost_actual());
                obj.put("cost_total",bm.getCost_total());
                obj.put("sale_profit_budget",bm.getSale_profit_budget());
                obj.put("sale_profit_actual",bm.getSale_profit_actual());
                obj.put("sale_profit_budget_ratio",bm.getSale_profit_budget_ratio());
                obj.put("sale_profit_actual_ratio",bm.getSale_profit_actual_ratio());
                obj.put("sale_total",bm.getSale_total());
                array.add(obj);
            }
        }
        return  array;
    }
    /**
     * 主营业务收支总（本月）表转JsonArray
     * @param list
     * @return
     */
    public static JSONArray balanceMainBusinessMonthToArray2(List<TFinanceMainBusinessMDiff> list) {
        JSONArray array = new JSONArray();
        if (list!=null && list.size()>0){
            for (TFinanceMainBusinessMDiff bm : list) {
                JSONObject obj = new JSONObject();
                if (bm.getFstrong() != null && bm.getFstrong().intValue() == 1){
                    obj.put("fproject", "<strong>" +bm.getFproject() + "</strong>");
                    obj.put("frow_num","<strong>" +bm.getFrowNum() + "</strong>");
                }else{
                    obj.put("fproject",bm.getFproject());
                    obj.put("frow_num",bm.getFrowNum());
                }
                obj.put("sale_budget",bm.getSaleBudget());
                obj.put("sale_actual",bm.getSaleActual());
                obj.put("income_budget",bm.getIncomeBudget());
                obj.put("income_actual",bm.getIncomeActual());
                obj.put("income_total",bm.getIncomeTotal());
                obj.put("cost_budget",bm.getCostBudget());
                obj.put("cost_actual",bm.getCostActual());
                obj.put("cost_total",bm.getCostTotal());
                obj.put("sale_profit_budget",bm.getSaleProfitBudget());
                obj.put("sale_profit_actual",bm.getSaleProfitActual());
                obj.put("sale_profit_budget_ratio",bm.getSaleProfitBudgetRatio());
                obj.put("sale_profit_actual_ratio",bm.getSaleProfitActualRatio());
                obj.put("sale_total",bm.getSaleTotal());
                array.add(obj);
            }
        }
        return  array;
    }

    /**
     * 主营业务收支总（累计）表转JsonArray
     * @param list
     * @return
     */
    public static JSONArray balanceMainBusinessMonthTotalToArray(List<FinanceMainBusinessTotal> list) {
        JSONArray array = new JSONArray();
        if (list!=null && list.size()>0){
            for (FinanceMainBusinessTotal bm : list) {
                JSONObject obj = new JSONObject();
                if (bm.getFstrong()==1){
                    obj.put("fproject", "<strong>" +bm.getFproject() + "</strong>");
                    obj.put("frow_num","<strong>" +bm.getFrow_num() + "</strong>");
                }else{
                    obj.put("fproject",bm.getFproject());
                    obj.put("frow_num",bm.getFrow_num());
                }
                obj.put("sale_budget",bm.getSale_budget());
                obj.put("sale_actual",bm.getSale_actual());
                obj.put("income_budget",bm.getIncome_budget());
                obj.put("income_actual",bm.getIncome_actual());
                obj.put("income_total",bm.getIncome_total());
                obj.put("cost_budget",bm.getCost_budget());
                obj.put("cost_actual",bm.getCost_actual());
                obj.put("cost_total",bm.getCost_total());
                obj.put("sale_profit_budget",bm.getSale_profit_budget());
                obj.put("sale_profit_actual",bm.getSale_profit_actual());
                obj.put("sale_profit_budget_ratio",bm.getSale_profit_budget_ratio());
                obj.put("sale_profit_actual_ratio",bm.getSale_profit_actual_ratio());
                obj.put("sale_total",bm.getSale_total());
                array.add(obj);
            }
        }
        return  array;
    }

    /**
     * 主营业务收支总（累计）表转JsonArray
     * @param list
     * @return
     */
    public static JSONArray balanceMainBusinessMonthTotalToArray2(List<TFinanceMainBusinessTDiff> list) {
        JSONArray array = new JSONArray();
        if (list!=null && list.size()>0){
            for (TFinanceMainBusinessTDiff bm : list) {
                JSONObject obj = new JSONObject();
                if (bm.getFstrong() != null && bm.getFstrong().intValue()==1){
                    obj.put("fproject", "<strong>" +bm.getFproject() + "</strong>");
                    obj.put("frow_num","<strong>" +bm.getFrowNum() + "</strong>");
                }else{
                    obj.put("fproject",bm.getFproject());
                    obj.put("frow_num",bm.getFrowNum());
                }
                obj.put("sale_budget",bm.getSaleBudget());
                obj.put("sale_actual",bm.getSaleActual());
                obj.put("income_budget",bm.getIncomeBudget());
                obj.put("income_actual",bm.getIncomeActual());
                obj.put("income_total",bm.getIncomeTotal());
                obj.put("cost_budget",bm.getCostBudget());
                obj.put("cost_actual",bm.getCostActual());
                obj.put("cost_total",bm.getCostTotal());
                obj.put("sale_profit_budget",bm.getSaleProfitBudget());
                obj.put("sale_profit_actual",bm.getSaleProfitActual());
                obj.put("sale_profit_budget_ratio",bm.getSaleProfitBudgetRatio());
                obj.put("sale_profit_actual_ratio",bm.getSaleProfitActualRatio());
                obj.put("sale_total",bm.getSaleTotal());
                array.add(obj);
            }
        }
        return  array;
    }
    /**
     * 主营业务收支明细（本月）表转JsonArray
     * @param list
     * @return
     */
    public static JSONArray balanceMainBusinessDetailMonthToArray(List<FinanceMainBusinessDetialMonth> list) {
        JSONArray array = new JSONArray();
        if (list!=null && list.size()>0){
            for (FinanceMainBusinessDetialMonth bm : list) {
                JSONObject obj = new JSONObject();
                if (bm.getFstrong()==1){
                    obj.put("fproject", "<strong>" +bm.getFproject() + "</strong>");
                    obj.put("frow_num","<strong>" +bm.getFrow_num() + "</strong>");
                }else{
                    obj.put("fproject",bm.getFproject());
                    obj.put("frow_num",bm.getFrow_num());
                }
                obj.put("sales_volume",bm.getSales_volume());
                obj.put("selling_unit_price",bm.getSelling_unit_price());
                obj.put("selling_amont",bm.getSelling_amont());
                obj.put("cost_unit",bm.getCost_unit());
                obj.put("cost_amont",bm.getCost_amont());
                obj.put("sale_profit_unit",bm.getSale_profit_unit());
                obj.put("sale_profit_count",bm.getSale_profit_count());
                obj.put("sale_profit_ratio",bm.getSale_profit_ratio());
                array.add(obj);
            }
        }
        return  array;
    }

    /**
     * 主营业务收支明细（累计）表转JsonArray
     * @param list
     * @return
     */
    public static JSONArray balanceMainBusinessDetialTotalToArray(List<FinanceMainBusinessDetialTotal> list) {
        JSONArray array = new JSONArray();
        if (list!=null && list.size()>0){
            for (FinanceMainBusinessDetialTotal bm : list) {
                JSONObject obj = new JSONObject();
                if (bm.getFstrong()==1){
                    obj.put("fproject", "<strong>" +bm.getFproject() + "</strong>");
                    obj.put("frow_num","<strong>" +bm.getFrow_num() + "</strong>");
                }else{
                    obj.put("fproject",bm.getFproject());
                    obj.put("frow_num",bm.getFrow_num());
                }
                obj.put("sales_volume",bm.getSales_volume());
                obj.put("selling_unit_price",bm.getSelling_unit_price());
                obj.put("selling_amont",bm.getSelling_amont());
                obj.put("cost_unit",bm.getCost_unit());
                obj.put("cost_last_month",bm.getCost_last_month());
                obj.put("cost_amont",bm.getCost_amont());
                obj.put("sale_profit_unit",bm.getSale_profit_unit());
                obj.put("sale_profit_count",bm.getSale_profit_count());
                obj.put("sale_profit_ratio",bm.getSale_profit_ratio());
                array.add(obj);
            }
        }
        return  array;
    }


    /**
     * 遍历主要指标1对象列表为JSON数组
     * @param list
     * @return
     */
    public static JSONArray dailyReportListToJsonArray(List<TDailyReport> list) {
        JSONArray array = new JSONArray();
        int num = 1;
        for (TDailyReport tm : list) {
            JSONObject obj = new JSONObject();
            obj.put("distributionChannel", "<strong>" + StringUtils.trimToEmpty(tm.getDistributionChannel()) + "</strong>");
            obj.put("salesArea", "<strong>" + StringUtils.trimToEmpty(tm.getSalesArea()) + "</strong>");
            obj.put("areaList", tm.getAreaList());
            obj.put("index", num);
            obj.put("dailyPractice", tm.getDailyPractice());
            obj.put("dailyTotalAvg", tm.getDailyTotalAvg());
            obj.put("dailyAvgBudget", tm.getDailyAvgBudget());
            obj.put("completionRate", tm.getCompletionRate());
            obj.put("thisMonthBudget", tm.getThisMonthBudget());
            obj.put("thisMonthTotal", tm.getThisMonthTotal());
            obj.put("thisMonthCompletionRate", tm.getThisMonthCompletionRate());
            array.add(obj);
            num++;
        }
        return array;
    }

    /**
     * 主营收支明细表(本月华山牧乳业)列表为JSON数组
     * @param list
     * @return
     */
//    public static JSONArray financemainbusinesshsmMonthToArray(List<Financemainbusinesshsm> list) {
//        JSONArray array = new JSONArray();
//        int num = 1;
//        for (Financemainbusinesshsm tm : list) {
//            JSONObject obj = new JSONObject();
//            obj.put("distributionChannel", "<strong>" + StringUtils.trimToEmpty(tm.getFrowNum()) + "</strong>");
//            obj.put("salesArea", "<strong>" + StringUtils.trimToEmpty(tm.getFproject()) + "</strong>");
//            obj.put("SaleBudget", tm.getSaleBudget());
//            obj.put("index", num);
//            obj.put("SaleActual", tm.getSaleActual());
//            obj.put("BudgetProportion", tm.getBudgetProportion());
//            obj.put("ActualProportion", tm.getActualProportion());
//            obj.put("BudgetPrice", tm.getBudgetPrice());
//            obj.put("ActualPrice", tm.getActualPrice());
//            obj.put("BudgetPrice", tm.getBudgetPrice());
//            obj.put("ActualPrice", tm.getActualPrice());
//            obj.put("BudgetUnitCost", tm.getBudgetUnitCost());
//            obj.put("ActualUnitCost", tm.getActualUnitCost());
//            obj.put("BudgetSaleCost", tm.getBudgetSaleCost());
//            obj.put("ActualSaleCost", tm.getActualSaleCost());
//
//            obj.put("BudgetUnitLevel", tm.getBudgetUnitLevel());
//            obj.put("ActualUnitLevel", tm.getActualUnitLevel());
//            obj.put("BudgetGrossProfit", tm.getBudgetGrossProfit());
//            obj.put("ActualGrossProfit", tm.getActualGrossProfit());
//            obj.put("BudgetGrossProfit", tm.getBudgetGrossProfit());
//            obj.put("ActualGrossInterest", tm.getActualGrossInterest());
//
//
//            array.add(obj);
//            num++;
//        }
//        return array;
//    }



}
