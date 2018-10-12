<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>销售日报表</title>
<@style/>
    <style type="text/css">
        #quota_tab{
            border-width: 2px;
            border-color: #0c0c0c
        }
        .table-bordered > thead > tr > th,
        .table-bordered > tbody > tr > th,
        .table-bordered > tfoot > tr > th,
        .table-bordered > thead > tr > td,
        .table-bordered > tbody > tr > td,
        .table-bordered > tfoot > tr > td{
            border:1px solid #353333;
        }
    </style>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
            ${company}
                <input type="hidden" value="${companyName}" id="company"/>
                <small>销售日报表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"<i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${company}</li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">销售日报表</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="box-body">
                            <table id="quota_tab" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th class="text-center" colspan="17" style="font-size: 18px;">华山牧乳业${yearMonth?substring(0,4)}年${yearMonth?substring(4,6)}月${yearMonth?substring(6)}日销售日报表</th>
                                </tr>
                                <tr>
                                    <th class="text-center"  rowspan="2">项目</th>
                                    <th class="text-center" rowspan="2">产品名称</th>
                                    <th class="text-center" colspan="7">本月产品销量（吨）</th>
                                    <th class="text-center" colspan="7">本月产品销售收入（万元）</th>
                                </tr>
                                <tr>
                                    <th class="text-center">当日实际</th>
                                    <th class="text-center">累计日均</th>
                                    <th class="text-center">预算日均</th>
                                    <th class="text-center">预算同步达成率%</th>
                                    <th class="text-center">本月累计</th>
                                    <th class="text-center">本月预算</th>
                                    <th class="text-center">本月累计完成率%</th>
                                    <th class="text-center">当日实际</th>
                                    <th class="text-center">累计日均</th>
                                    <th class="text-center">预算日均</th>
                                    <th class="text-center">预算同步达成率%</th>
                                    <th class="text-center">本月累计</th>
                                    <th class="text-center">本月预算</th>
                                    <th class="text-center">本月累计完成率%</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list resultMap?keys as key>
                                    <#if key != "低温size" && key != "常温size" && key != "学生奶size" && key != "合计">
                                        <#list resultMap[key] as item>
                                            <#if item_index ==0>
                                            <tr>
                                                <#if key = "低温">
                                                    <th class="text-center" rowspan="${resultMap["低温size"]}"
                                                        style="vertical-align: middle">低温产品
                                                    </th>
                                                <#elseif key = "常温">
                                                    <th class="text-center" rowspan="${resultMap["常温size"]}"
                                                        style="vertical-align: middle">常温产品
                                                    </th>
                                                <#elseif key = "学生奶">
                                                    <th class="text-center" rowspan="${resultMap["学生奶size"]}"
                                                        style="vertical-align: middle">学生奶
                                                    </th>
                                                </#if>
                                                <th class="text-center">${item.productName}</th>
                                                <th class="text-center">${item.salesVolumeActual?string("0.0")}</th>
                                                <th class="text-center">${(item.salesVolumeTotal/nowday)?string("0.0")}</th>
                                                <th class="text-center">${(item.salesVolumeBudget/item.days)?string("0.0")}</th>
                                                <th class="text-center">
                                                    <#if item.salesVolumeBudget != 0>
                                                    ${((item.salesVolumeTotal/nowday)/(item.salesVolumeBudget/item.days)*100)?string("0.0")}
                                                    <#else >
                                                        100
                                                    </#if>%
                                                </th>
                                                <th class="text-center">${item.salesVolumeTotal?string("0.0")}</th>
                                                <th class="text-center">${item.salesVolumeBudget?string("0.0")}</th>
                                                <th class="text-center">
                                                    <#if item.salesVolumeBudget != 0>
                                                    ${(item.salesVolumeTotal/item.salesVolumeBudget*100)?string("0.0")}
                                                    <#else >
                                                        100
                                                    </#if>%
                                                </th>
                                                <th class="text-center">${item.salesAmountActual?string("0.0")}</th>
                                                <th class="text-center">${(item.salesAmountTatal/nowday)?string("0.0")}</th>
                                                <th class="text-center">${(item.salesAmountBudget/item.days)?string("0.0")}</th>
                                                <th class="text-center">
                                                    <#if item.salesAmountBudget != 0>
                                                    ${((item.salesAmountTatal/nowday)/(item.salesAmountBudget/item.days)*100)?string("0.0")}
                                                    <#else >
                                                        100
                                                    </#if>%
                                                </th>
                                                <th class="text-center">${item.salesAmountTatal?string("0.0")}</th>
                                                <th class="text-center">${item.salesAmountBudget?string("0.0")}</th>
                                                <th class="text-center">
                                                    <#if item.salesAmountBudget != 0>
                                                    ${(item.salesAmountTatal/item.salesAmountBudget*100)?string("0.0")}
                                                    <#else >
                                                        100
                                                    </#if>%
                                                </th>
                                            </tr>
                                            <#else >
                                            <tr>
                                                <th class="text-center">${item.productName}</th>
                                                <th class="text-center">${item.salesVolumeActual?string("0.0")}</th>
                                                <th class="text-center">${(item.salesVolumeTotal/nowday)?string("0.0")}</th>
                                                <th class="text-center">${(item.salesVolumeBudget/item.days)?string("0.0")}</th>
                                                <th class="text-center">
                                                    <#if item.salesVolumeBudget != 0>
                                                    ${((item.salesVolumeTotal/nowday)/(item.salesVolumeBudget/item.days)*100)?string("0.0")}
                                                    <#else >
                                                        100
                                                    </#if>%
                                                </th>
                                                <th class="text-center">${item.salesVolumeTotal?string("0.0")}</th>
                                                <th class="text-center">${item.salesVolumeBudget?string("0.0")}</th>
                                                <th class="text-center">
                                                    <#if item.salesVolumeBudget != 0>
                                                    ${(item.salesVolumeTotal/item.salesVolumeBudget*100)?string("0.0")}
                                                    <#else >
                                                        100
                                                    </#if>%
                                                </th>
                                                <th class="text-center">${item.salesAmountActual?string("0.0")}</th>
                                                <th class="text-center">${(item.salesAmountTatal/nowday)?string("0.0")}</th>
                                                <th class="text-center">${(item.salesAmountBudget/item.days)?string("0.0")}</th>
                                                <th class="text-center">
                                                    <#if item.salesAmountBudget != 0>
                                                    ${((item.salesAmountTatal/nowday)/(item.salesAmountBudget/item.days)*100)?string("0.0")}
                                                    <#else >
                                                        100
                                                    </#if>%
                                                </th>
                                                <th class="text-center">${item.salesAmountTatal?string("0.0")}</th>
                                                <th class="text-center">${item.salesAmountBudget?string("0.0")}</th>
                                                <th class="text-center">
                                                    <#if item.salesAmountBudget != 0>
                                                    ${(item.salesAmountTatal/item.salesAmountBudget*100)?string("0.0")}
                                                    <#else >
                                                        100
                                                    </#if>%
                                                </th>
                                            </tr>
                                            </#if>
                                        </#list>
                                    </#if>
                                </#list>
                                <#assign totalData = resultMap["合计"]>
                                <tr>
                                    <th class="text-center" colspan="2">${totalData.classification}</th>
                                    <th class="text-center">${totalData.salesVolumeActual?string("0.0")}</th>
                                    <th class="text-center">${(totalData.salesVolumeTotal/nowday)?string("0.0")}</th>
                                    <th class="text-center">${(totalData.salesVolumeBudget/totalData.days)?string("0.0")}</th>
                                    <th class="text-center">
                                    <#if totalData.salesVolumeBudget != 0>
                                    ${(totalData.salesVolumeTotal/nowday)/(totalData.salesVolumeBudget/totalData.days)*100}
                                    <#else >
                                        100
                                    </#if>%
                                    </th>
                                    <th class="text-center">${totalData.salesVolumeTotal?string("0.0")}</th>
                                    <th class="text-center">${totalData.salesVolumeBudget?string("0.0")}</th>
                                    <th class="text-center">
                                    <#if totalData.salesVolumeBudget != 0>
                                    ${(totalData.salesVolumeTotal/totalData.salesVolumeBudget*100)?string("0.0")}
                                    <#else >
                                        100
                                    </#if>%
                                    </th>
                                    <th class="text-center">${totalData.salesAmountActual?string("0.0")}</th>
                                    <th class="text-center">${(totalData.salesAmountTatal/nowday)?string("0.0")}</th>
                                    <th class="text-center">${(totalData.salesAmountBudget/totalData.days)?string("0.0")}</th>
                                    <th class="text-center">
                                    <#if totalData.salesAmountBudget != 0>
                                    ${((totalData.salesAmountTatal/nowday)/(totalData.salesAmountBudget/totalData.days)*100)?string("0.0")}
                                    <#else >
                                        100
                                    </#if>%
                                    </th>
                                    <th class="text-center">${totalData.salesAmountTatal?string("0.0")}</th>
                                    <th class="text-center">${totalData.salesAmountBudget?string("0.0")}</th>
                                    <th class="text-center">
                                    <#if totalData.salesAmountBudget != 0>
                                    ${(totalData.salesAmountTatal/totalData.salesAmountBudget*100)?string("0.0")}
                                    <#else >
                                        100
                                    </#if>%
                                    </th>
                                </tr>
                                <tr>
                                    <th class="text-center" rowspan="2">销售区域分析</th>
                                    <th class="text-center">华山牧乳业</th>
                                    <th class="text-center">${totalData.salesVolumeActual?string("0.0")}</th>
                                    <th class="text-center">${(totalData.salesVolumeTotal/nowday)?string("0.0")}</th>
                                    <th class="text-center">${(totalData.salesVolumeBudget/totalData.days)?string("0.0")}</th>
                                    <th class="text-center">
                                    <#if totalData.salesVolumeBudget != 0>
                                    ${((totalData.salesVolumeTotal/nowday)/(totalData.salesVolumeBudget/totalData.days)*100)?string("0.0")}
                                    <#else >
                                        100
                                    </#if>%
                                    </th>
                                    <th class="text-center">${totalData.salesVolumeTotal?string("0.0")}</th>
                                    <th class="text-center">${totalData.salesVolumeBudget?string("0.0")}</th>
                                    <th class="text-center">
                                    <#if totalData.salesVolumeBudget != 0>
                                    ${(totalData.salesVolumeTotal/totalData.salesVolumeBudget*100)?string("0.0")}
                                    <#else >
                                        100
                                    </#if>%
                                    </th>
                                    <th class="text-center">${totalData.salesAmountActual?string("0.0")}</th>
                                    <th class="text-center">${(totalData.salesAmountTatal/nowday)?string("0.0")}</th>
                                    <th class="text-center">${(totalData.salesAmountBudget/totalData.days)?string("0.0")}</th>
                                    <th class="text-center">
                                    <#if totalData.salesAmountBudget != 0>
                                    ${((totalData.salesAmountTatal/nowday)/(totalData.salesAmountBudget/totalData.days)*100)?string("0.0")}
                                    <#else >
                                        100
                                    </#if>%
                                    </th>
                                    <th class="text-center">${totalData.salesAmountTatal?string("0.0")}</th>
                                    <th class="text-center">${totalData.salesAmountBudget?string("0.0")}</th>
                                    <th class="text-center">
                                    <#if totalData.salesAmountBudget != 0>
                                    ${(totalData.salesAmountTatal/totalData.salesAmountBudget*100)?string("0.0")}
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
                                        <th class="text-center">${report.dailyPractice?string("0.0")}</th>
                                        <th class="text-center">${report.dailyTotalAvg?string("0.0")}</th>
                                        <th class="text-center">${report.dailyAvgBudget?string("0.0")}</th>
                                    <#--<th class="text-center">${ZKGYLDYYS/days}</th>-->
                                        <th class="text-center">${(report.completionRate*100)?string("0.0")}%</th>
                                        <th class="text-center">${report.thisMonthTotal?string("0.0")}</th>
                                        <th class="text-center">${report.thisMonthBudget?string("0.0")}</th>
                                    <#--<th class="text-center">${ZKGYLDYYS}</th>-->
                                        <th class="text-center">${(report.thisMonthCompletionRate*100)?string("0.0")}%</th>
                                    </#if>
                                    <#if report.fsheetRowIndex == 42>
                                        <th class="text-center">${report.dailyPractice?string("0.0")}</th>
                                        <th class="text-center">${report.dailyTotalAvg?string("0.0")}</th>
                                        <th class="text-center">${report.dailyAvgBudget?string("0.0")}</th>
                                    <#--<th class="text-center">${ZKGYLDYYS/days}</th>-->
                                        <th class="text-center">${(report.completionRate*100)?string("0.0")}%</th>
                                        <th class="text-center">${report.thisMonthTotal?string("0.0")}</th>
                                        <th class="text-center">${report.thisMonthBudget?string("0.0")}</th>
                                    <#--<th class="text-center">${ZKGYLDYYS}</th>-->
                                        <th class="text-center">${(report.thisMonthCompletionRate*100)?string("0.0")}%</th>
                                    </#if>
                                </#list>
                                    <#else >
                                        <th class="text-center">0</th>
                                        <th class="text-center">0</th>
                                        <th class="text-center">0</th>
                                        <th class="text-center">100%</th>
                                        <th class="text-center">0</th>
                                        <th class="text-center">0</th>
                                        <th class="text-center">100%</th>
                                        <th class="text-center">0</th>
                                        <th class="text-center">0</th>
                                        <th class="text-center">0</th>
                                        <th class="text-center">100%</th>
                                        <th class="text-center">0</th>
                                        <th class="text-center">0</th>
                                        <th class="text-center">100%</th>
                                    </#if>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </section>
    </div>
</div>
<@jsFile/>
<script>
    $(window).load(function () {
        var el = $('.content-header');
        el.html(el.html().replace(/TYRY/ig, '天友乳业'));
        el.html(el.html().replace(/HSMRY/ig, '华山牧乳业'));
        el.html(el.html().replace(/TNMC/ig, '天宁牧场'));
        el.html(el.html().replace(/HSMC/ig, '华山牧场'));
    });
</script>
</body>
<@footer/>
</html>
