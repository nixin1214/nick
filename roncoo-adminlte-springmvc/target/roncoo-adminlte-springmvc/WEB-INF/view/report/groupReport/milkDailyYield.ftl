<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>每日产销量</title>
<@style/>
    <style type="text/css">
        .table-bordered > thead > tr > th,
        .table-bordered > tbody > tr > th,
        .table-bordered > tfoot > tr > th,
        .table-bordered > thead > tr > td,
        .table-bordered > tbody > tr > td,
        .table-bordered > tfoot > tr > td {
            border: 1px solid #353333;
        }
        #quota_tab{
            border-width: 3px;
            border-color: #0c0c0c
        }
        #zk_zyzb_tb2{
            border-width: 3px;
            border-color: #0c0c0c
        }
    </style>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
            ${companyName}
                <small>每日产销量</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${companyName}</li>
            </ol>
        </section>
        <input type="hidden" id="orgCode" value="${companyNumber}">
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">每日产销明细</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="nav-tabs-custom">
                                <ul class="nav nav-tabs" id="myTab">
                                    <li class="active"><a href="#zk_zyzb1" data-toggle="tab" aria-expanded="true" data="0">销量</a></li>
                                    <li class=""><a href="#zk_zyzb2" data-toggle="tab" aria-expanded="true" data="1">销售额</a></li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div  class="tab-pane active" id="zk_zyzb1">
                                    <#assign DWNDRSJ = 0> <#-- 低温奶当日实际 -->
                                    <#assign DWNLJRJ = 0> <#-- 低温奶累计日均 -->
                                    <#assign DWNBYLJ = 0> <#-- 低温奶本月累计 -->
                                    <#assign DWNDYYS = 0> <#-- 低温奶当月预算 -->

                                    <#assign CWNDRSJ = 0> <#-- 常温奶当日实际 -->
                                    <#assign CWNLJRJ = 0> <#-- 常温奶累计日均 -->
                                    <#assign CWNBYLJ = 0> <#-- 常温奶本月累计 -->
                                    <#assign CWNDYYS = 0> <#-- 常温奶当月预算 -->
                                    <#assign SYNDYXJYS = 0> <#-- 商业奶当月小计预算 -->

                                    <#assign XSNDRSJ = 0> <#-- 学生奶当日实际 -->
                                    <#assign XSNLJRJ = 0> <#-- 学生奶累计日均 -->
                                    <#assign XSNBYLJ = 0> <#-- 学生奶本月累计 -->
                                    <#assign XSNDYYS = 0> <#-- 学生奶当月预算 -->
                                    <#assign DYQSHJYS = 0> <#-- 当月全司合计预算 -->

                                    <#assign HSMRYDYYS = 0> <#-- 华山牧乳业当月预算 -->
                                    <#assign ZKGYLDYYS = 0> <#-- 中垦供应链当月预算 -->
                                        <#list resultMap?keys as key>
                                            <#switch key>
                                                <#case "HSMRY-XL-DWDTXL"><#-- 低温奶当日实际 -->
                                                    <#assign DWNDRSJ = resultMap[key]>
                                                    <#break >
                                                <#case "HSMRY-XL-DWXLRJ"><#-- 低温奶累计日均 -->
                                                    <#assign DWNLJRJ = resultMap[key]>
                                                    <#break >
                                                <#case "HSMRY-XL-DWXLLJ"><#-- 低温奶本月累计 -->
                                                    <#assign DWNBYLJ = resultMap[key]>
                                                    <#break >
                                                <#case "PJRCNL-BYSYDW"><#-- 低温奶当月预算 -->
                                                    <#assign DWNDYYS = resultMap[key]>
                                                    <#break >
                                                <#case "HSMRY-XL-CWDTXL"><#-- 常温奶当日实际 -->
                                                    <#assign CWNDRSJ = resultMap[key]>
                                                    <#break >
                                                <#case "HSMRY-XL-CWXLRJ"><#-- 常温奶累计日均 -->
                                                    <#assign CWNLJRJ = resultMap[key]>
                                                    <#break >
                                                <#case "HSMRY-XL-CWXLLJ"><#-- 常温奶本月累计 -->
                                                    <#assign CWNBYLJ = resultMap[key]>
                                                    <#break >
                                                <#case "PJRCNL-BYSYCW"><#-- 常温奶当月预算 -->
                                                    <#assign CWNDYYS = resultMap[key]>
                                                    <#break >
                                                <#case "PJRCNL-BYSYXJ"> <#-- 商业奶当月小计预算 -->
                                                    <#assign SYNDYXJYS = resultMap[key]>
                                                    <#break >
                                                <#case "HSMRY-XLE-XSDTXL"><#-- 学生奶当日实际 -->
                                                    <#assign XSNDRSJ = resultMap[key]>
                                                    <#break >
                                                <#case "HSMRY-XL-XSXLRJ"><#-- 学生奶累计日均 -->
                                                    <#assign XSNLJRJ = resultMap[key]>
                                                    <#break >
                                                <#case "HSMRY-XL-XSXLLJ"><#-- 学生奶本月累计 -->
                                                    <#assign XSNBYLJ = resultMap[key]>
                                                    <#break >
                                                <#case "PJRCNL-BYSYXSN"><#-- 学生奶当月预算 -->
                                                    <#assign XSNDYYS = resultMap[key]>
                                                    <#break >
                                                <#case "PJRCNL-BYSQSHJ"><#-- 当月全司合计预算 -->
                                                    <#assign DYQSHJYS = resultMap[key]>
                                                    <#break >
                                                <#case "PJRCNL-BYSHSMR"><#-- 华山牧乳业当月预算 -->
                                                    <#assign HSMRYDYYS = resultMap[key]>
                                                    <#break >
                                                <#case "PJRCNL-BYSZKGY"><#-- 中垦供应链当月预算 -->
                                                    <#assign ZKGYLDYYS = resultMap[key]>
                                                    <#break >
                                            </#switch>
                                        </#list>
                                    <table id="quota_tab" class="table table-bordered table-hover">
                                        <tr>
                                            <th class="text-center" colspan="10" style="font-size: 18px;border: 1px solid">华山牧乳业${yearMonth?substring(0,4)}年${yearMonth?substring(4,6)}月${yearMonth?substring(6)}日产销量日报表</th>
                                        </tr>
                                        <tr>
                                            <th class="text-center" rowspan="9" style="vertical-align: middle">华山牧乳业</th>
                                            <th class="text-center" colspan="2" rowspan="2" style="line-height: 53px;">项目</th>
                                            <th class="text-center" rowspan="2" style="line-height: 53px;">当日实际</th>
                                            <th class="text-center" colspan="6">本月产品销量（吨）</th>
                                        </tr>
                                        <tr>
                                            <th class="text-center">累计日均</th>
                                            <th class="text-center">当月预算日均</th>
                                            <th class="text-center">预算同步达成率</th>
                                            <th class="text-center">本月累计</th>
                                            <th class="text-center">本月预算</th>
                                            <th class="text-center">本月累计完成率</th>
                                        </tr>
                                        <tr>
                                            <th class="text-center" rowspan="2" style="vertical-align: middle">商业奶</th>
                                            <th class="text-center">低温</th>
                                            <th class="text-center">${DWNDRSJ}</th>
                                            <th class="text-center">${DWNLJRJ}</th>
                                            <th class="text-center">${DWNDYYS/days}</th>
                                            <th class="text-center">
                                                <#if DWNDYYS!=0>
                                                    ${(DWNLJRJ/(DWNDYYS/days)*100)?string("#.##")}
                                                <#else >
                                                    100
                                                </#if> %
                                            </th>
                                            <th class="text-center">${DWNBYLJ}</th>
                                            <th class="text-center">${DWNDYYS}</th>
                                            <th class="text-center">
                                                <#if DWNDYYS!=0>
                                                    ${(DWNBYLJ/DWNDYYS*100)?string("#.##")}
                                                <#else >
                                                    100
                                                </#if>
                                                %</th>
                                        </tr>
                                        <tr>
                                            <th class="text-center">常温</th>
                                            <th class="text-center">${CWNDRSJ}</th>
                                            <th class="text-center">${CWNLJRJ}</th>
                                            <th class="text-center">${CWNDYYS/days}</th>
                                            <th class="text-center">
                                                <#if CWNDYYS!=0>
                                                    ${(CWNLJRJ/(CWNDYYS/days)*100)?string("#.##")}
                                                <#else >
                                                    100
                                                </#if>%
                                            </th>
                                            <th class="text-center">${CWNBYLJ}</th>
                                            <th class="text-center">${CWNDYYS}</th>
                                            <th class="text-center">
                                                <#if CWNDYYS!=0>
                                                    ${(CWNBYLJ/CWNDYYS*100)?string("#.##")}
                                                <#else >
                                                    100
                                                </#if>%
                                            </th>
                                        </tr>
                                        <tr>
                                            <th class="text-center" colspan="2" style="vertical-align: middle">商业奶小计</th>
                                            <th class="text-center">${DWNDRSJ+CWNDRSJ}</th>
                                            <th class="text-center">${DWNLJRJ+CWNLJRJ}</th>
                                            <th class="text-center">${SYNDYXJYS/days}</th>
                                            <th class="text-center">
                                            <#if SYNDYXJYS!=0>
                                                ${((DWNLJRJ+CWNLJRJ)/(SYNDYXJYS/days)*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                            <th class="text-center">${DWNBYLJ+CWNBYLJ}</th>
                                            <th class="text-center">${SYNDYXJYS}</th>
                                            <th class="text-center">
                                                <#if SYNDYXJYS!=0>
                                                    ${((DWNBYLJ+CWNBYLJ)/SYNDYXJYS*100)?string("#.##")}
                                                <#else >
                                                    100
                                                </#if>%
                                            </th>
                                        </tr>
                                        <tr>
                                            <th class="text-center" colspan="2" style="vertical-align: middle">学生奶</th>
                                            <th class="text-center">${XSNDRSJ}</th>
                                            <th class="text-center">${XSNLJRJ}</th>
                                            <th class="text-center">${XSNDYYS/days}</th>
                                            <th class="text-center">
                                            <#if XSNDYYS!=0>
                                                ${(XSNLJRJ/(XSNDYYS/days)*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                            <th class="text-center">${XSNBYLJ}</th>
                                            <th class="text-center">${XSNDYYS}</th>
                                            <th class="text-center">
                                                <#if XSNDYYS!=0>
                                                    ${(XSNBYLJ/XSNDYYS*100)?string("#.##")}
                                                <#else >
                                                    100
                                                </#if>%
                                            </th>
                                        </tr>
                                        <tr>
                                            <th class="text-center" colspan="2" style="vertical-align: middle">全司合计</th>
                                            <th class="text-center">${DWNDRSJ+CWNDRSJ+XSNDRSJ}</th>
                                            <th class="text-center">${DWNLJRJ+CWNLJRJ+XSNLJRJ}</th>
                                            <th class="text-center">${DYQSHJYS/days}</th>
                                            <th class="text-center">
                                            <#if DYQSHJYS!=0>
                                                ${((DWNLJRJ+CWNLJRJ+XSNLJRJ)/(DYQSHJYS/days)*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                            <th class="text-center">${DWNBYLJ+CWNBYLJ+XSNBYLJ}</th>
                                            <th class="text-center">${DYQSHJYS}</th>
                                            <th class="text-center">
                                                <#if DYQSHJYS!=0>
                                                    ${((DWNBYLJ+CWNBYLJ+XSNBYLJ)/DYQSHJYS*100)?string("#.##")}
                                                <#else >
                                                    100
                                                </#if>%
                                            </th>
                                        </tr>
                                        <tr>
                                            <th class="text-center" rowspan="2" style="vertical-align: middle">销售区域分析</th>
                                            <th class="text-center">华山牧乳业</th>
                                            <th class="text-center">${DWNDRSJ+CWNDRSJ+XSNDRSJ}</th>
                                            <th class="text-center">${DWNLJRJ+CWNLJRJ+XSNLJRJ}</th>
                                            <th class="text-center">${DYQSHJYS/days}</th>
                                            <th class="text-center">
                                            <#if DYQSHJYS!=0>
                                            ${((DWNLJRJ+CWNLJRJ+XSNLJRJ)/(DYQSHJYS/days)*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                            <th class="text-center">${DWNBYLJ+CWNBYLJ+XSNBYLJ}</th>
                                            <th class="text-center">${DYQSHJYS}</th>
                                            <th class="text-center">
                                            <#if DYQSHJYS!=0>
                                            ${((DWNBYLJ+CWNBYLJ+XSNBYLJ)/DYQSHJYS*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                        </tr>
                                        <tr>
                                            <th class="text-center">中垦供应链</th>
                                            <#if reportList?size gt 0>
                                            <#list reportList as report>
                                                <#if report.fsheetRowIndex == 22>
                                                    <th class="text-center">${report.dailyPractice}</th>
                                                    <th class="text-center">${report.dailyTotalAvg}</th>
                                                    <th class="text-center">${report.dailyAvgBudget}</th>
                                                <#--<th class="text-center">${ZKGYLDYYS/days}</th>-->
                                                    <th class="text-center">${report.completionRate*100}%</th>
                                                    <th class="text-center">${report.thisMonthTotal}</th>
                                                    <th class="text-center">${report.thisMonthBudget}</th>
                                                <#--<th class="text-center">${ZKGYLDYYS}</th>-->
                                                    <th class="text-center">${report.thisMonthCompletionRate*100}%</th>
                                                </#if>
                                            </#list>
                                            <#else >
                                                <th class="text-center">0</th>
                                                <th class="text-center">0</th>
                                                <th class="text-center">0</th>
                                                <th class="text-center">0</th>
                                                <th class="text-center">0</th>
                                                <th class="text-center">0</th>
                                                <th class="text-center">0</th>
                                            </#if>
                                        </tr>
                                    </table>
                                </div>
                                <div  class="tab-pane" id="zk_zyzb2">
                                <#assign DWNDRSJ = 0> <#-- 低温奶当日实际 -->
                                <#assign DWNLJRJ = 0> <#-- 低温奶累计日均 -->
                                <#assign DWNBYLJ = 0> <#-- 低温奶本月累计 -->
                                <#assign DWNDYYS = 0> <#-- 低温奶当月预算 -->

                                <#assign CWNDRSJ = 0> <#-- 常温奶当日实际 -->
                                <#assign CWNLJRJ = 0> <#-- 常温奶累计日均 -->
                                <#assign CWNBYLJ = 0> <#-- 常温奶本月累计 -->
                                <#assign CWNDYYS = 0> <#-- 常温奶当月预算 -->
                                <#assign SYNDYXJYS = 0> <#-- 商业奶当月小计预算 -->

                                <#assign XSNDRSJ = 0> <#-- 学生奶当日实际 -->
                                <#assign XSNLJRJ = 0> <#-- 学生奶累计日均 -->
                                <#assign XSNBYLJ = 0> <#-- 学生奶本月累计 -->
                                <#assign XSNDYYS = 0> <#-- 学生奶当月预算 -->
                                <#assign DYQSHJYS = 0> <#-- 当月全司合计预算 -->

                                <#assign HSMRYDYYS = 0> <#-- 华山牧乳业当月预算 -->
                                <#assign ZKGYLDYYS = 0> <#-- 中垦供应链当月预算 -->
                                <#list dataMap?keys as key>
                                    <#switch key>
                                        <#case "HSMRY-XLE-DWDTXS"><#-- 低温奶当日实际 -->
                                            <#assign DWNDRSJ = dataMap[key]>
                                            <#break >
                                        <#case "HSMRY-XSE-DWXSRJ"><#-- 低温奶累计日均 -->
                                            <#assign DWNLJRJ = dataMap[key]>
                                            <#break >
                                        <#case "HSMRY-XSE-DWXSLJ"><#-- 低温奶本月累计 -->
                                            <#assign DWNBYLJ = dataMap[key]>
                                            <#break >
                                        <#case "BYDWNXSE-YS"><#-- 低温奶当月预算 -->
                                            <#assign DWNDYYS = dataMap[key]>
                                            <#break >
                                        <#case "HSMRY-XLE-CWDTXS"><#-- 常温奶当日实际 -->
                                            <#assign CWNDRSJ = dataMap[key]>
                                            <#break >
                                        <#case "HSMRY-XSE-CWXSRJ"><#-- 常温奶累计日均 -->
                                            <#assign CWNLJRJ = dataMap[key]>
                                            <#break >
                                        <#case "HSMRY-XSE-CWXSLJ"><#-- 常温奶本月累计 -->
                                            <#assign CWNBYLJ = dataMap[key]>
                                            <#break >
                                        <#case "BYCWNXSE-YS"><#-- 常温奶当月预算 -->
                                            <#assign CWNDYYS = dataMap[key]>
                                            <#break >
                                        <#case "BYSYNXSE-YS"> <#-- 商业奶当月小计预算 -->
                                            <#assign SYNDYXJYS = dataMap[key]>
                                            <#break >
                                        <#case "HSMRY-XLE-XSDTXS"><#-- 学生奶当日实际 -->
                                            <#assign XSNDRSJ = dataMap[key]>
                                            <#break >
                                        <#case "HSMRY-XSE-XSXSRJ"><#-- 学生奶累计日均 -->
                                            <#assign XSNLJRJ = dataMap[key]>
                                            <#break >
                                        <#case "HSMRY-XSE-XSXSLJ"><#-- 学生奶本月累计 -->
                                            <#assign XSNBYLJ = dataMap[key]>
                                            <#break >
                                        <#case "BYXSNXSE-YS"><#-- 学生奶当月预算 -->
                                            <#assign XSNDYYS = dataMap[key]>
                                            <#break >
                                        <#case "BYQSXSEHJ-YS"><#-- 当月全司合计预算 -->
                                            <#assign DYQSHJYS = dataMap[key]>
                                            <#break >
                                        <#case "BYHSMRYXSE-YS"><#-- 华山牧乳业当月预算 -->
                                            <#assign HSMRYDYYS = dataMap[key]>
                                            <#break >
                                        <#case "BYZKGYLXSE-YS"><#-- 中垦供应链当月预算 -->
                                            <#assign ZKGYLDYYS = dataMap[key]>
                                            <#break >
                                    </#switch>
                                </#list>
                                    <table id="zk_zyzb_tb2" class="table table-bordered table-striped">
                                        <tr>
                                            <th class="text-center" colspan="10" style="font-size: 18px;border: 1px solid">华山牧乳业${yearMonth?substring(0,4)}年${yearMonth?substring(4,6)}月${yearMonth?substring(6)}日销售额日报表</th>
                                        </tr>
                                            <tr>
                                                <th class="text-center" rowspan="9" style="vertical-align: middle">华山牧乳业</th>
                                                <th class="text-center" colspan="2" rowspan="2" style="line-height: 53px;">项目</th>
                                                <th class="text-center" rowspan="2" style="line-height: 53px;">当日实际</th>
                                                <th class="text-center" colspan="6">本月产品销售收入（万元）</th>
                                            </tr>
                                            <tr>
                                                <th class="text-center">累计日均</th>
                                                <th class="text-center">当月预算日均</th>
                                                <th class="text-center">预算同步达成率</th>
                                                <th class="text-center">本月累计</th>
                                                <th class="text-center">本月预算</th>
                                                <th class="text-center">本月累计完成率</th>
                                            </tr>
                                        <tr>
                                            <th class="text-center" rowspan="2" style="vertical-align: middle">商业奶</th>
                                            <th class="text-center">低温</th>
                                            <th class="text-center">${DWNDRSJ}</th>
                                            <th class="text-center">${DWNLJRJ/10000}</th>
                                            <th class="text-center">${DWNDYYS/days}</th>
                                            <th class="text-center">
                                            <#if DWNDYYS!=0>
                                            ${(DWNLJRJ/10000/(DWNDYYS/days)*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if> %
                                            </th>
                                            <th class="text-center">${DWNBYLJ/10000}</th>
                                            <th class="text-center">${DWNDYYS}</th>
                                            <th class="text-center">
                                            <#if DWNDYYS!=0>
                                            ${(DWNBYLJ/10000/DWNDYYS*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>
                                                %</th>
                                        </tr>
                                        <tr>
                                            <th class="text-center">常温</th>
                                            <th class="text-center">${CWNDRSJ}</th>
                                            <th class="text-center">${CWNLJRJ/10000}</th>
                                            <th class="text-center">${CWNDYYS/days}</th>
                                            <th class="text-center">
                                            <#if CWNDYYS!=0>
                                            ${(CWNLJRJ/10000/(CWNDYYS/days)*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                            <th class="text-center">${CWNBYLJ/10000}</th>
                                            <th class="text-center">${CWNDYYS}</th>
                                            <th class="text-center">
                                            <#if CWNDYYS!=0>
                                            ${(CWNBYLJ/10000/CWNDYYS*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                        </tr>
                                        <tr>
                                            <th class="text-center" colspan="2" style="vertical-align: middle">商业奶小计</th>
                                            <th class="text-center">${DWNDRSJ+CWNDRSJ}</th>
                                            <th class="text-center">${(DWNLJRJ+CWNLJRJ)/10000}</th>
                                            <th class="text-center">${SYNDYXJYS/days}</th>
                                            <th class="text-center">
                                            <#if SYNDYXJYS!=0>
                                            ${((DWNLJRJ+CWNLJRJ)/10000/(SYNDYXJYS/days)*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                            <th class="text-center">${(DWNBYLJ+CWNBYLJ)/10000}</th>
                                            <th class="text-center">${SYNDYXJYS}</th>
                                            <th class="text-center">
                                            <#if SYNDYXJYS!=0>
                                            ${((DWNBYLJ+CWNBYLJ)/10000/SYNDYXJYS*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                        </tr>
                                        <tr>
                                            <th class="text-center" colspan="2" style="vertical-align: middle">学生奶</th>
                                            <th class="text-center">${XSNDRSJ}</th>
                                            <th class="text-center">${XSNLJRJ/10000}</th>
                                            <th class="text-center">${XSNDYYS/days}</th>
                                            <th class="text-center">
                                            <#if XSNDYYS!=0>
                                            ${(XSNLJRJ/10000/(XSNDYYS/days)*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                            <th class="text-center">${XSNBYLJ/10000}</th>
                                            <th class="text-center">${XSNDYYS}</th>
                                            <th class="text-center">
                                            <#if XSNDYYS!=0>
                                            ${(XSNBYLJ/10000/XSNDYYS*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                        </tr>
                                        <tr>
                                            <th class="text-center" colspan="2" style="vertical-align: middle">全司合计</th>
                                            <th class="text-center">${DWNDRSJ+CWNDRSJ+XSNDRSJ}</th>
                                            <th class="text-center">${(DWNLJRJ+CWNLJRJ+XSNLJRJ)/10000}</th>
                                            <th class="text-center">${DYQSHJYS/days}</th>
                                            <th class="text-center">
                                            <#if DYQSHJYS!=0>
                                            ${((DWNLJRJ+CWNLJRJ+XSNLJRJ)/10000/(DYQSHJYS/days)*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                            <th class="text-center">${(DWNBYLJ+CWNBYLJ+XSNBYLJ)/10000}</th>
                                            <th class="text-center">${DYQSHJYS}</th>
                                            <th class="text-center">
                                            <#if DYQSHJYS!=0>
                                            ${((DWNBYLJ+CWNBYLJ+XSNBYLJ)/10000/DYQSHJYS*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                        </tr>
                                        <tr>
                                            <th class="text-center" rowspan="2" style="vertical-align: middle">销售区域分析</th>
                                            <th class="text-center">华山牧乳业</th>
                                            <th class="text-center">${DWNDRSJ+CWNDRSJ+XSNDRSJ}</th>
                                            <th class="text-center">${(DWNLJRJ+CWNLJRJ+XSNLJRJ)/10000}</th>
                                            <th class="text-center">${DYQSHJYS/days}</th>
                                            <th class="text-center">
                                            <#if DYQSHJYS!=0>
                                            ${((DWNLJRJ+CWNLJRJ+XSNLJRJ)/10000/(DYQSHJYS/days)*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                            <th class="text-center">${(DWNBYLJ+CWNBYLJ+XSNBYLJ)/10000}</th>
                                            <th class="text-center">${DYQSHJYS}</th>
                                            <th class="text-center">
                                            <#if DYQSHJYS!=0>
                                            ${((DWNBYLJ+CWNBYLJ+XSNBYLJ)/10000/DYQSHJYS*100)?string("#.##")}
                                            <#else >
                                                100
                                            </#if>%
                                            </th>
                                        </tr>
                                        <tr>
                                            <th class="text-center">中垦供应链</th>
                                            <#if reportList?size gt 0>
                                            <#list reportList as report>
                                            <#if report.fsheetRowIndex == 42>
                                            <th class="text-center">${report.dailyPractice}</th>
                                            <th class="text-center">${report.dailyTotalAvg}</th>
                                            <th class="text-center">${report.dailyAvgBudget}</th>
                                            <#--<th class="text-center">${ZKGYLDYYS/days}</th>-->
                                            <th class="text-center">${report.completionRate*100}%</th>
                                            <th class="text-center">${report.thisMonthTotal}</th>
                                            <th class="text-center">${report.thisMonthBudget}</th>
                                            <#--<th class="text-center">${ZKGYLDYYS}</th>-->
                                            <th class="text-center">${report.thisMonthCompletionRate*100}%</th>
                                            </#if>
                                            </#list>
                                            <#else >
                                                <th class="text-center">0</th>
                                                <th class="text-center">0</th>
                                                <th class="text-center">0</th>
                                                <th class="text-center">0</th>
                                                <th class="text-center">0</th>
                                                <th class="text-center">0</th>
                                                <th class="text-center">0</th>
                                            </#if>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
<@common/>
</div>
<@jsFile/>
<script type="text/javascript" src="dist/layer/layer.js" ></script>
<script type="text/javascript">

    $('#myTab a').click(function (e) {
        var idName = $(this).text();
        layer.msg(idName);
    });

</script>
</body>
<@footer/>
</html>