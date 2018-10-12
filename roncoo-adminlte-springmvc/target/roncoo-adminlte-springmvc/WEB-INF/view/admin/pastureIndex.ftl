<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>中垦经分系统</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
            ${companyName}
                <input type="hidden" value="${company}" id="company"/>
                <small>综合指标</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">牧场视图</li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-10">
                    <div class="row">

                        <div class="nav-tabs-custom" style="background: none;">
                            <!-- Tabs within a box -->
                            <ul class="nav nav-tabs pull-right col-md-12">
                                <li class="btn btn-info"><a href="#revenue-chart" data-toggle="tab" >累计</a></li>
                                <li class="active btn btn-info"><a href="#sales-chart" data-toggle="tab" >本期</a></li>
                                <li class="pull-left header">&nbsp;</li>
                            </ul>
                            <div class="tab-content no-padding" style="background: none;">
                                <!-- Morris chart - Sales -->
                                <div class="chart tab-pane" id="revenue-chart" style="height: 157px;">
                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-aqua">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">营业收入<br>
                                                        <span class="calendarIcon" style="position: absolute;top: 99px;right: 109px;"><li class="fa fa-calendar"></li> ${yysrlj[0].fyearMonth?substring(0,4)}01~${yysrlj[0].fyearMonth?substring(4,6)}</span>
                                                    </div>
                                                    <h3 style="text-align: right">
                                                    <#assign SJvaleuLj = yysrlj[0].fvalue>
                                                    ${SJvaleuLj}
                                                        <sup style="font-size: 20px">万</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">预算目标</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#assign YJvaleuLJ = yysrlj[1].fvalue>
                                                    ${YJvaleuLJ}万
                                                    </div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">完成率</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#if YJvaleuLJ == 0>
                                                        0%
                                                    <#else>
                                                        <#if (YJvaleuLJ>0)>
                                                            ${SJvaleuLj/YJvaleuLJ*100}%
                                                        <#else >
                                                            ${(2-SJvaleuLj/YJvaleuLJ)*100}%
                                                        </#if>
                                                    </#if>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-social-bitcoin-outline"></i>
                                            </div>
                                            <a target="navTab"
                                               href="${ctx}/report/pastureReport/businessIncomeDetail?companyNumber=${companyNumber}&company=${company}"
                                               class="small-box-footer" data-title="营业收入明细">查看明细<i
                                                    class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>

                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-green">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">利润总额<br>
                                                        <span class="calendarIcon" style="position: absolute;top: 99px;right: 109px;"><li class="fa fa-calendar"></li> ${lrzelj[0].fyearMonth?substring(0,4)}01~${lrzelj[0].fyearMonth?substring(4,6)}</span>
                                                    </div>
                                                    <h3 style="text-align: right">
                                                    <#assign actualLj = lrzelj[0].fvalue>
                                                    <#assign budgetLj = lrzelj[1].fvalue>
                                                    ${actualLj}
                                                        <sup style="font-size: 20px">万</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">预算目标</div>
                                                    <div class="pull-right zk-target-right">
                                                    ${budgetLj}万
                                                    </div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">完成率</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#if budgetLj== 0>
                                                        0%
                                                    <#else >
                                                        <#if (budgetLj>0)>
                                                            ${actualLj/budgetLj*100}%
                                                        <#else >
                                                            ${(2-actualLj/budgetLj)*100}%
                                                        </#if>

                                                    </#if>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-arrow-graph-up-right"></i>
                                            </div>
                                            <a target="navTab"
                                               href="${ctx}/report/pastureReport/operatingProfit?companyNumber=${companyNumber}&company=${company}"
                                               class="small-box-footer" data-title="营业利润明细">查看明细<i
                                                    class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>

                                    <!-- ./col -->
                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-yellow">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">单位生产成本<br>
                                                        <span class="calendarIcon" style="position: absolute;top: 99px;right: 109px;"><li class="fa fa-calendar"></li> ${dwwqcblj[0].fyearMonth?substring(0,4)}01~${dwwqcblj[0].fyearMonth?substring(4,6)}</span>
                                                    </div>
                                                    <h3 style="text-align: right">
                                                    <#assign dwsccbLj = dwwqcblj[0].fvalue>
                                                    <#assign dwsccbYSLj = dwwqcblj[1].fvalue>
                                                    ${dwsccbLj?string("#")}
                                                        <sup style="font-size: 20px">元</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">预算指标</div>
                                                    <div class="pull-right zk-target-right">
                                                    ${dwsccbYSLj?string("#")}元
                                                    </div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">占比</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#if dwsccbYSLj == 0>
                                                        0%
                                                    <#else>
                                                        <#if (dwsccbYSLj>0)>
                                                            ${dwsccbLj/dwsccbYSLj*100}%
                                                        <#else >
                                                            ${(2-dwsccbLj/dwsccbYSLj)*100}%
                                                        </#if>
                                                    </#if>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-arrow-graph-up-right"></i>
                                            </div>
                                            <a target="navTab"
                                               href="${ctx}/report/pastureReport/unitTotalCostDetail?companyNumber=${companyNumber}&company=${company}"
                                               class="small-box-footer" data-title="单位完全成本明细">查看明细<i
                                                    class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>
                                    <!-- ./col -->
                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-red">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">生鲜奶产量<br>
                                                    <#assign SXNCLLj = 0>
                                                    <#assign fyearMonth = "">
                                                    <#list sxncllj?keys as key>
                                                        <#if key == "QK">
                                                            <#assign SXNCLLj = sxncllj[key]/1000>
                                                        </#if>
                                                    </#list>
                                                    <#list sxncl?keys as key>
                                                        <#if key == "yearMonth">
                                                            <#assign fyearMonth = sxncl[key]>
                                                        </#if>
                                                    </#list>
                                                        <#if fyearMonth?substring(5,6)?number==1>
                                                            <#if (fyearMonth?substring(6)?number>25)>
                                                                <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar">  ${fyearMonth?substring(0,6)}01~${fyearMonth?substring(4)}</li></span>
                                                            <#else>
                                                                <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar"> ${fyearMonth?substring(0,6)}01~${fyearMonth?substring(4)}</li></span>
                                                            </#if>
                                                        <#elseif fyearMonth?substring(4,6)?number==12>
                                                            <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar"> ${fyearMonth?substring(0,5)}${fyearMonth?substring(5,6)?number-1}26~${fyearMonth?substring(4)}</li></span>
                                                        <#elseif fyearMonth?substring(4,6)?number==10>
                                                            <#if (fyearMonth?substring(6)?number>25)>
                                                                <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar"> ${fyearMonth?substring(0,4)}0926~${fyearMonth?substring(4)}</li></span>
                                                            <#else>
                                                                <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar"> ${fyearMonth?substring(0,4)}0926~${fyearMonth?substring(4)}</li></span>
                                                            </#if>
                                                        <#else >
                                                            <#if (fyearMonth?substring(6)?number>25)>
                                                                <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar"> ${fyearMonth?substring(0,5)}${fyearMonth?substring(5,6)}26~${fyearMonth?substring(4)}</li></span>
                                                            <#else>
                                                                <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar"> ${fyearMonth?substring(0,5)}${fyearMonth?substring(5,6)?number-1}26~${fyearMonth?substring(4)}</li></span>
                                                            </#if>
                                                        </#if>
                                                    </div>
                                                    <h3 style="text-align: right">
                                                    ${SXNCLLj?string("#")}
                                                        <sup style="font-size: 20px">吨</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">&nbsp;</div>
                                                    <div class="pull-right zk-target-right">&nbsp;
                                                    </div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">&nbsp;</div>
                                                    <div class="pull-right zk-target-right">
                                                        &nbsp;
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-speedometer"></i>
                                            </div>
                                            <a target="navTab"
                                               href="${ctx}/report/pastureReport/yieldAndIndex?companyNumber=${companyNumber}&company=${company}"
                                               class="small-box-footer" data-title="牛奶产量及理化指标">查看明细<i
                                                    class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="chart tab-pane active" id="sales-chart" style="height: 157px;">
                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-aqua">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">营业收入<br>
                                                        <span class="calendarIcon"><li class="fa fa-calendar"></li> ${yysr[0].fyearMonth}</span>
                                                    </div>
                                                    <h3 style="text-align: right">
                                                    <#assign SJvaleu = yysr[0].fvalue>
                                                    ${SJvaleu}
                                                        <sup style="font-size: 20px">万</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">预算目标</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#assign YJvaleu = yysr[1].fvalue>
                                                    ${YJvaleu}万
                                                    </div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">完成率</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#if YJvaleu == 0>
                                                        0%
                                                    <#else>
                                                        <#if (YJvaleu>0)>
                                                            ${SJvaleu/YJvaleu*100}%
                                                        <#else >
                                                            ${(2-SJvaleu/YJvaleu)*100}%
                                                        </#if>
                                                    </#if>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-social-bitcoin-outline"></i>
                                            </div>
                                            <a target="navTab"
                                               href="${ctx}/report/pastureReport/businessIncomeDetail?companyNumber=${companyNumber}&company=${company}"
                                               class="small-box-footer" data-title="营业收入明细">查看明细<i
                                                    class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>

                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-green">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">利润总额<br>
                                                        <span class="calendarIcon"><li class="fa fa-calendar"></li> ${yylr[0].fyearMonth}</span>
                                                    </div>
                                                    <h3 style="text-align: right">
                                                    <#assign actual = yylr[0].fvalue>
                                                    <#assign budget = yylr[1].fvalue>
                                                    ${actual}
                                                        <sup style="font-size: 20px">万</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">预算目标</div>
                                                    <div class="pull-right zk-target-right">
                                                    ${budget}万
                                                    </div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">完成率</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#if budget== 0>
                                                        0%
                                                    <#else >
                                                        <#if (budget>0)>
                                                            ${actual/budget*100}%
                                                        <#else >
                                                            ${(2-actual/budget)*100}%
                                                        </#if>
                                                    </#if>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-arrow-graph-up-right"></i>
                                            </div>
                                            <a target="navTab"
                                               href="${ctx}/report/pastureReport/operatingProfit?companyNumber=${companyNumber}&company=${company}"
                                               class="small-box-footer" data-title="营业利润明细">查看明细<i
                                                    class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>

                                    <!-- ./col -->
                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-yellow">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">单位生产成本<br>
                                                        <span class="calendarIcon"><li class="fa fa-calendar"></li> ${dwwqcb[0].fyearMonth}</span>
                                                    </div>
                                                    <h3 style="text-align: right">
                                                    <#assign dwsccb = dwwqcb[0].fvalue>
                                                    <#assign dwsccbYS = dwwqcb[1].fvalue>
                                                    ${dwsccb?string("#")}
                                                        <sup style="font-size: 20px">元</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">预算指标</div>
                                                    <div class="pull-right zk-target-right">
                                                    ${dwsccbYS?string("#")}元
                                                    </div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">占比</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#if dwsccbYS == 0>
                                                        0%
                                                    <#else>
                                                        <#if (dwsccbYS>0)>
                                                            ${dwsccb/dwsccbYS*100}%
                                                        <#else >
                                                            ${(2-dwsccb/dwsccbYS)*100}%
                                                        </#if>
                                                    </#if>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-arrow-graph-up-right"></i>
                                            </div>
                                            <a target="navTab"
                                               href="${ctx}/report/pastureReport/unitTotalCostDetail?companyNumber=${companyNumber}&company=${company}"
                                               class="small-box-footer" data-title="单位完全成本明细">查看明细<i
                                                    class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>
                                    <!-- ./col -->
                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-red">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">生鲜奶产量<br>
                                                    <#assign SXNCL = 0>
                                                    <#assign fyearMonth = "">
                                                    <#list sxncl?keys as key>
                                                        <#if key != "yearMonth">
                                                            <#assign SXNCL = sxncl[key]/1000>
                                                        <#else >
                                                            <#assign fyearMonth = sxncl[key]>
                                                        </#if>
                                                    </#list>
                                                        <span class="calendarIcon"><li class="fa fa-calendar"></li> ${fyearMonth}</span>
                                                    </div>
                                                    <h3 style="text-align: right">
                                                    ${SXNCL?floor}
                                                        <sup style="font-size: 20px">吨</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">&nbsp;</div>
                                                    <div class="pull-right zk-target-right">&nbsp;
                                                    </div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">&nbsp;</div>
                                                    <div class="pull-right zk-target-right">
                                                        &nbsp;
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-speedometer"></i>
                                            </div>
                                            <a target="navTab"
                                               href="${ctx}/report/pastureReport/yieldAndIndex?companyNumber=${companyNumber}&company=${company}"
                                               class="small-box-footer" data-title="牛奶产量及理化指标">查看明细<i
                                                    class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>



                        <!-- ./col -->
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">牧场指标分析</h3>
                                    <div class="box-tools pull-right">
                                        <input type="text" id="cattleTime" placeholder="选择期间...">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-7">
                                            <div class="group_map" style="width: 100%; height: 350px;"></div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="cattle_div" style="width: 100%; height: 350px;"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <#-- add begin  杨北平   2018-01-30 -->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">每日产量走势图</h3>
                                    <div class="box-tools pull-right">
                                        <input type="text" id="securityTime" placeholder="选择期间...">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="dailyYield" style="width: 100%; height: 350px;"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <#--  add end   -->

                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-warning">
                                <div class="box-header with-border">
                                    <h3 class="box-title">病情分析</h3>
                                    <div class="box-tools pull-right">
                                        <input id="illnessYearMonth" type="text">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-sm-12 col-xs-12">
                                            <div class="table-responsive" style="height: 163px;">
                                                <table class="table no-margin">
                                                    <thead>
                                                    <tr>
                                                        <th>牛群</th>
                                                        <th>发病率</th>
                                                        <th>环比</th>
                                                        <th>死淘率</th>
                                                        <th>环比</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody id="tbody">

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.row -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">快速查看</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="box-body">
                            <table class="table table-condensed" style="height: 1243px;">
                                <tbody>
                                <tr>
                                    <th>业务指标</th>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/herdStructure?companyNumber=${companyNumber}&company=${company}">牛群结构分析</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/yieldAndIndex?companyNumber=${companyNumber}&company=${company}">牛奶产量</a>
                                    </td>
                                </tr>
                                <#--<tr>-->
                                    <#--<td style="padding-left: 15px;"><a target="navTab"-->
                                                                       <#--href="${ctx}/report/pastureReport/avgFeedCost?companyNumber=${companyNumber}&company=${company}">平均每日饲料成本</a>-->
                                    <#--</td>-->
                                <#--</tr>-->
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/aclfLossRate?companyNumber=${companyNumber}&company=${company}">犊牛损失率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/dairyCowsMorbidity?companyNumber=${companyNumber}&company=${company}">成乳牛发病率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/dairyCowsClean?companyNumber=${companyNumber}&company=${company}">成乳牛死淘率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/cattleClean?companyNumber=${companyNumber}&company=${company}">育成牛死淘率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/calfClean?companyNumber=${companyNumber}&company=${company}">犊牛死淘率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/oilConsumption?companyNumber=${companyNumber}&company=${company}">油料消耗表</a>
                                    </td>
                                </tr>
                                <tr>
                                    <th>财务指标</th>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/unitDataDisplay?companyNumber=${companyNumber}&company=${company}">单位指标分析</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-ZCFZL-BFB&fNameZh=资产负债率&lastYearFNameEn=CW-ZCFZL-SN-BFB&fNameYs=CW-ZCFZL-BFBYS">资产负债率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-LDBL-BFB&fNameZh=流动比率&lastYearFNameEn=CW-LDBL-SN-BFB&fNameYs=CW-LDBL-BFBYS">流动比率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-SDBL-BFB&fNameZh=速动比率&lastYearFNameEn=CW-SDBL-SN-BFB&fNameYs=CW-SDBL-BFBYS">速动比率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-YSZKZZL-BFB&fNameZh=应收账款周转率&lastYearFNameEn=CW-YSZKZZL-SN-BFB&fNameYs=CW-YSZKZZL-BFBYS">应收账款周转率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-XSMLL-BFB&fNameZh=销售毛利率&lastYearFNameEn=ZKZB-XSMLL-SN-BFB&fNameYs=CW-XSMLL-BFBYS">销售毛利率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-YYLRL-BFB&fNameZh=营业利润率&lastYearFNameEn=CW-YYLRL-SN-BFB&fNameYs=CW-YYLRL-BFBYS">营业利润率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                           href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-CBFYLRL-BFB&fNameZh=成本费用利润率&lastYearFNameEn=CW-CBFYLRL-SN-BFB&fNameYs=CW-CBFYLRL-BFBYS">成本费用利润率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-QJFYL-BFB&fNameZh=期间费用率&lastYearFNameEn=CW-QJFYL-SN-BFB&fNameYs=CW-QJFYL-BFBYS">期间费用率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=YYYLNL-LDSCL-BQ&fNameZh=劳动生产率&lastYearFNameEn=YYYLNL-LDSCL-SN&fNameYs=YYYLNL-LDSCL-BQYS">劳动生产率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=YYYLNL-ZCCCL-BQ&fNameZh=资产产出率&lastYearFNameEn=YYYLNL-ZCCCL-SN&fNameYs=YYYLNL-ZCCCL-BQYS">资产产出率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-ZCZZL-BFB&fNameZh=资产增长率&lastYearFNameEn=CW-ZCZZL-SN-BFB&fNameYs=CW-ZCZZL-BFBYS">资产增长率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-XSZZL-BFB&fNameZh=销售增长率&lastYearFNameEn=CW-XSZZL-SN-BFB&fNameYs=CW-XSZZL-BFBYS">销售增长率</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;"><a target="navTab"
                                                                       href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-LRZZL-BFB&fNameZh=利润增长率&lastYearFNameEn=CW-LRZZL-SN-BFB&fNameYs=CW-LRZZL-BFBYS">利润增长率</a>
                                    </td>
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
<script type="text/javascript">
    var yearMonth ='';
    var yearMonths ='';
    $('#securityTime').datepicker({
        language: 'zh-CN',
        format: 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight: true,
    }).on('changeDate',function (ev) {
        yearMonth = $(this).val();
        dailyYield(yearMonth);
    });
    $('#cattleTime').datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: true,
        startView: 1,
        maxViewMode: 1,
        minViewMode:1
    }).on('changeDate',function (ev) {
        yearMonths = $(this).val();
        herdStructure(yearMonths);
        yieldAnalysis(yearMonths);
    });

    //病情分析时间插件
    $('#illnessYearMonth').datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: true,
        startView: 1,
        maxViewMode: 1,
        minViewMode:1
    }).on('changeDate',function (ev) {
        illnessAnalysis($("#illnessYearMonth").val());
    });

    $(function () {
        $('#securityTime').datepicker( 'setDate' , '-1d' );//设置日期控件默认值,触发change事件
        $('#cattleTime').datepicker( 'setDate' , '-0m' );
        $('#illnessYearMonth').datepicker( 'setDate' , '-0m' );
    });

    //病情分析
    function illnessAnalysis(yearMonth) {
        $.ajax({
            url:"${ctx}/admin/illnessAnalysisAjax",
            type:"post",
            data:{"yearMonth":yearMonth,"companyNumber":$("#company").val()},
            dataType:"text",
            success:function (result) {
                var jsonObj = eval('(' + result + ')');
                addIllData(jsonObj);
            },
            error:function () {
                console.log("错误");
            }
        });

    function addIllData(result) {
        $("#tbody").empty();
        var tableData = "";
        for(var key in result["structureData"]){
            if (key!="yearMonth"){
                var cowClass = "";
                var rowDatas = "";
                switch (key) {
                    case ("CR"):
                        cowClass = "成乳牛";
                        break;
                    case ("YC"):
                        cowClass = "育成牛";
                        break;
                    case ("DN"):
                        cowClass = "犊牛";
                        break;
                }
                for(var i=0;i<result["structureData"][key].length;i++){
                    if(i%2==1){
                        if (result["structureData"][key][i]>0){
                            rowDatas = rowDatas+"<td><span class=\"description-percentage text-red\">" +
                                    "<i class=\"fa fa-caret-up\"></i>"+(result["structureData"][key][i])+"%</span></td>";
                        }
                        if (result["structureData"][key][i]==0){
                            rowDatas = rowDatas+"<td><span class=\"description-percentage text-yellow\">" +
                                    "<i class=\"fa fa-caret-left\"></i>"+(result["structureData"][key][i])+"%</span></td>";
                        }
                        if (result["structureData"][key][i]<0){
                            rowDatas = rowDatas+"<td><span class=\"description-percentage text-green\">" +
                                    "<i class=\"fa fa-caret-down\"></i>"+(result["structureData"][key][i])+"%</span></td>";
                        }
                    }else{
                        rowDatas = rowDatas+"<td><span class=\"label label-success\">"+(result["structureData"][key][i])+"%</span></td>"
                    }
                }
                tableData = tableData+"<tr><td>"+cowClass+"</td>"+rowDatas+"</tr>";
            }
        }
        $("#tbody").append(tableData);
    }


    }

    /**
     * 初始化产量分析
     */
    function yieldAnalysis(yearMonths) {
        /*
                 * 获取产量数据
                 */
        $.ajax({
            url: "${ctx}/admin/pastueIndexYieldChartAjax?companyNumber=${company}",
            type: "get",
            data: {'yearMonths': yearMonths},
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                init(jsonObj);
            },
            error: function () {
                console.log('错误');
            }
        });
        function init(result) {
            var sxAxis = [];
            var avgFvalue = [];
            var singleFvalue = [];
            for (var i = 0; i < result['yearMonths'].length; i++) {
                sxAxis.push(result['yearMonths'][i]);
                avgFvalue.push(Math.floor(result['ttFvalues'][i] / 1000));
                singleFvalue.push(Math.floor(result['swFvalues'][i]));
            }
            var saleReport = echarts.init($('.group_map')[0], echartsTheme);

            var option2 = {

                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    x: 'center',
                    data: ['月总产奶量', '成乳牛单产']
                },
                toolbox: {
                    show: true,
                    feature: {
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    },
                    padding: [0, 10, 20, 5]
                },
                calculable: true,
                grid: {
                    y: 68
                },
                xAxis: [
                    {
                        type: 'category',
                        axisLabel: {
                            interval: 0,
                            rotate: -20,
                            margin: 30,
                            textStyle: {
                                color: '#0c180d',
                                align: 'center'

                            },
                        },
                        data: sxAxis
                    }
                ],
                yAxis: [
                    {
                        name: '月总产奶量(吨)',
                        type: 'value',
                        axisLabel: {
                            formatter: '{value}'
                        },
                        max: function (value) {
                            var num = parseInt(value.max / 5 * 6);
                            var numStr = num.toString();
                            var newNum = 0;
                            for (var i = 0; i < numStr.length; i++) {
                                if (i === 0) {
                                    newNum = parseInt(num / Math.pow(10, numStr.length - 1)) + 1;
                                } else {
                                    newNum = newNum * 10;
                                }
                            }
                            return newNum;
                        }
                    },
                    {
                        name: '成乳牛单产(千克)',
                        type: 'value',
                        axisLabel: {
                            formatter: '{value}'
                        },
                        max: function (value) {
                            var num = parseInt(value.max / 5 * 6);
                            var numStr = num.toString();
                            var newNum = 0;
                            for (var i = 0; i < numStr.length; i++) {
                                if (i === 0) {
                                    newNum = parseInt(num / Math.pow(10, numStr.length - 1)) + 1;
                                } else {
                                    newNum = newNum * 10;
                                }
                            }
                            return newNum;
                        }
                    }
                ],
                series: [
                    {
                        name: '月总产奶量',
                        type: 'line',
                        data: avgFvalue,
                        yAxisIndex: 0,
                        itemStyle: {
                            normal: {
                                color: '#00c0ef'
                            }
                        },
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name: '成乳牛单产',
                        type: 'line',
                        yAxisIndex: 1,
                        data: singleFvalue,
                        itemStyle: {
                            normal: {
                                color: '#00a65a'
                            }
                        },
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        }
                    }
                ]
            };
            saleReport.setOption(option2);

            $(window).resize(function () {
                saleReport.resize();
            });
        }
    }


    function herdStructure(yearMonths) {
        /*
               * 获取牛群结构数据
               */
        $.ajax({
            url: "${ctx}/admin/structureChartAjax?companyNumber=${company}",
            type: "get",
            data: {'yearMonths': yearMonths},
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                initStructure(jsonObj);
            },
            error: function () {
                console.log('错误');
            }
        });
        function initStructure(result) {
            var cattle = []; //图例数据
            var fvalues = []; //值数据
            var fyearMonths = "";
            $.each(result, function (key, value) {
                if(key!="yearMonths") {
                    cattle.push(key);
                    var keyAndValue = {'value': Math.round(value), 'name': key};
                    fvalues.push(keyAndValue);
                }else {
                    fyearMonths = value;
                }
            });
            var cattles = echarts.init($('.cattle_div')[0], echartsTheme);
            var option = {
                title: {
                    text: '牛群结构分析',
                    left: 'center',
                    subtext:fyearMonths
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c}头 ({d}%)"
                },
                legend: {
                    bottom: 1,
                    left: 'center',
                    data: cattle
                },
                series: [
                    {
                        name: '牛群种类',
                        type: 'pie',
                        radius: ['30%', '45%'],
                        center: ['50%', '50%'],
                        label: {
                            normal: {
                                formatter: '{b}：\r\n({c}头)'
                            }
                        },
                        data: fvalues,
                        animationType: 'scale',
                        animationEasing: 'elasticOut',
                        animationDelay: function (idx) {
                            return Math.random() * 200;
                        }
                    }
                ]
            };
            cattles.setOption(option);
            $(window).resize(function () {
                cattles.resize();
            });
        }
    }


    /**
     * 初始化产量分析
     */
    function dailyYield(yearMonth) {
        /*
                 * 获取产量数据
                 */
        $.ajax({
            url: "${ctx}/admin/dailyYieldAjax?companyNumber=${company}",
            type: "get",
            data: {'yearMonth': yearMonth},
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                dailyYieldInit(jsonObj);
            },
            error: function () {
                console.log('错误');
            }
        });
    }
        function dailyYieldInit(result) {
            var axix = result['yearMonth'];
            var axiy = [];
            var axiN = [];
            console.log(result);
            for (var i = 0; i < result['yearMonth'].length; i++) {
                axiy.push(Math.floor(result['PJRCNL-QN'][i] / 1000));
                axiN.push(Math.floor(result['PJRCNL-XL'][i] / 1000));
            }
            var saleReport = echarts.init($('.dailyYield')[0], echartsTheme);

            var option2 = {

                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    x: 'center',
                    data: ['每日产奶量', '每日销量']
                },
                toolbox: {
                    show: true,
                    feature: {
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    },
                    padding: [0, 10, 20, 5]
                },
                calculable: true,
                grid: {
                    y: 68
                },
                xAxis: [
                    {
                        type: 'category',
                        axisLabel: {
                            interval: 1,
                            rotate: -30,
                            margin: 30,
                            textStyle: {
                                color: '#0c180d',
                                align: 'center'
                            }
                        },
                        data: axix
                    }
                ],
                yAxis: [
                    {
                        name: '每日产奶量(吨)',
                        type: 'value',
                        axisLabel: {
                            formatter: '{value}'
                        },
                        max: function (value) {
                            var num = parseInt(value.max / 5 * 6);
                            var numStr = num.toString();
                            var newNum = 0;
                            for (var i = 0; i < numStr.length; i++) {
                                if (i === 0) {
                                    newNum = parseInt(num / Math.pow(10, numStr.length - 1)) + 1;
                                } else {
                                    newNum = newNum * 10;
                                }
                            }
                            return newNum;
                        }
                    }
                ],
                series: [
                    {
                        name: '每日产奶量',
                        type: 'line',
                        data: axiy,
                        yAxisIndex: 0,
                        itemStyle: {
                            normal: {
                                color: '#00c0ef'
                            }
                        },
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name: '每日销量',
                        type: 'line',
                        data: axiN,
                        yAxisIndex: 0,
                        itemStyle: {
                            normal: {
                                color: '#00a65a'
                            }
                        },
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        }
                    }
                ]
            };
            saleReport.setOption(option2);

            $(window).resize(function () {
                saleReport.resize();
            });
        }


</script>
</body>
<@footer/>
</html>