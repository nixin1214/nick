<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>乳业视图</title>
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
                <li class="active">乳业视图</li>
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
                                                    <div class="pull-left zk-target-left">
                                                        营业收入<br>
                                                        <span class="calendarIcon" style="position: absolute;top: 99px;right: 109px;"><li class="fa fa-calendar"></li> ${yysrlj[0].fyearMonth?substring(0,4)}01~${yysrlj[0].fyearMonth?substring(4,6)}</span>
                                                    </div>
                                                    <h3 style="text-align: right">
                                                    <#assign sjsrlj = yysrlj[0].fvalue>
                                                    ${sjsrlj?string("#")}
                                                        <sup style="font-size: 20px">万</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">预算目标</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#assign yssrlj = yysrlj[1].fvalue>
                                                    ${yssrlj?string("#")}万
                                                    </div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">完成率</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#if yssrlj == 0>
                                                        0%
                                                    <#else>
                                                        <#assign srRatio = 0>
                                                        <#if (yssrlj>0)>
                                                            <#assign srRatio = sjsrlj/yssrlj*100>
                                                        <#else>
                                                            <#assign srRatio = (2-sjsrlj/yssrlj)*100>
                                                        </#if>
                                                    ${srRatio}%
                                                    </#if>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-social-bitcoin-outline"></i>
                                            </div>
                                            <a target="navTab" href="${ctx}/report/milkReport/businessIncomeDetail?companyNumber=${companyNumber}&company=${company}" data-title="营业收入明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>
                                    <!-- ./col -->

                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-green">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">
                                                        利润总额<br>
                                                        <span class="calendarIcon" style="position: absolute;top: 99px;right: 109px;"><li class="fa fa-calendar"></li> ${lrzelj[0].fyearMonth?substring(0,4)}01~${lrzelj[0].fyearMonth?substring(4,6)}</span>
                                                    </div>
                                                    <h3 style="text-align: right">
                                                    <#assign actualLj = lrzelj[0].fvalue>
                                                    <#assign budgetLj = lrzelj[1].fvalue>
                                                    ${actualLj?string("#")}
                                                        <sup style="font-size: 20px">万</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">预算目标</div>
                                                    <div class="pull-right zk-target-right">${budgetLj?string("#")}万</div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">完成率</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#if budgetLj==0>
                                                        0%
                                                    <#else>
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
                                            <a target="navTab" href="${ctx}/report/pastureReport/operatingProfit?companyNumber=${companyNumber}&company=${company}" data-title="利润总额明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>

                                    <!-- ./col -->
                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-red">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">
                                                        应收账款<br>
                                                        <span class="calendarIcon" style="position: absolute;top: 99px;right: 109px;"><li class="fa fa-calendar"></li> ${yszk[0].fyearMonth?substring(0,4)}01~${yszk[0].fyearMonth?substring(4,6)}</span>
                                                    </div>
                                                    <h3 style="text-align: right">

                                                    ${yszk[0].fvalue?string("#")}
                                                        <sup style="font-size: 20px">万</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">&nbsp;</div>
                                                    <div class="pull-right zk-target-right">&nbsp;</div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">&nbsp;</div>
                                                    <div class="pull-right zk-target-right">&nbsp;</div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-checkmark"></i>
                                            </div>
                                            <a target="navTab" href="${ctx}/report/milkReport/accountsReceivableDetail?companyNumber=${companyNumber}&company=${company}" data-title="应收账款明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>

                                    <!-- ./col -->
                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-yellow">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">
                                                        乳制品销量<br>
                                                        <#if company="HSMRY">
                                                            <#assign fyearMonths = "">
                                                        <#list rzpxl1?keys as key>
                                                            <#if key == "yearMonth">
                                                            <#assign fyearMonths = rzpxl1[key]>
                                                            </#if>
                                                        </#list>
                                                        <#if fyearMonths?substring(5,6)?number==1>
                                                            <#if (fyearMonths?substring(6)?number>25)>
                                                            <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar">  ${fyearMonths?substring(0,6)}01~${fyearMonths?substring(4)}</li></span>
                                                            <#else>
                                                            <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar"> ${fyearMonths?substring(0,6)}01~${fyearMonths?substring(4)}</li></span>
                                                            </#if>
                                                        <#elseif fyearMonths?substring(4,6)?number==12>
                                                            <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar"> ${fyearMonths?substring(0,5)}${fyearMonths?substring(5,6)?number-1}26~${fyearMonths?substring(4)}</li></span>
                                                        <#elseif fyearMonths?substring(4,6)?number==10>
                                                            <#if (fyearMonths?substring(6)?number>25)>
                                                            <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar"> ${fyearMonths?substring(0,4)}0926~${fyearMonths?substring(4)}25</li></span>
                                                            <#else>
                                                            <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar"> ${fyearMonths?substring(0,4)}0926~${fyearMonths?substring(4)}</li></span>
                                                            </#if>
                                                        <#else >
                                                            <#if (fyearMonths?substring(6)?number>25)>
                                                            <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar"> ${fyearMonths?substring(0,5)}${fyearMonths?substring(5,6)?number}26~${fyearMonths?substring(4)}</li></span>
                                                            <#else>
                                                            <span class="calendarIcon" style="position: absolute;top: 99px;right: 89px;"><li class="fa fa-calendar"> ${fyearMonths?substring(0,5)}${fyearMonths?substring(5,6)?number-1}26~${fyearMonths?substring(4)}</li></span>
                                                            </#if>
                                                        </#if>
                                                            <#else >
                                                                <span class="calendarIcon" style="position: absolute;top: 99px;right: 109px;"><li class="fa fa-calendar"></li> ${rzpxllj[0].fyearMonth?substring(0,4)}01~${rzpxllj[0].fyearMonth?substring(4)}</span>
                                                        </#if>

                                                    </div>
                                                    <h3 style="text-align: right">
                                                        <#if company="HSMRY">
                                                            <#assign SXNCLLj1 = 0>
                                                            <#list rzpxl2?keys as key>
                                                                <#if key == "MYXHSMR">
                                                                    <#assign SXNCLLj1 = rzpxl2[key]>
                                                                </#if>
                                                            </#list>
                                                        ${SXNCLLj1?string("#")}
                                                        <#else >
                                                            <#assign sjxl = rzpxllj[0].fvalue>
                                                        ${sjxl?string("#")}
                                                        </#if>

                                                        <sup style="font-size: 20px">吨</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">预算目标</div>
                                                    <div class="pull-right zk-target-right">
                                                        <#if company="HSMRY">
                                                            <#assign byys1 = 0>
                                                            <#list rzpxl2?keys as key>
                                                            <#if key == "BYSHSMR">
                                                            <#assign byys1 = rzpxl2[key]>
                                                            </#if>
                                                            </#list>
                                                            ${byys1?string("#")}
                                                            <#else >
                                                                <#assign ysxl = rzpxllj[1].fvalue>
                                                            ${ysxl?string("#")}
                                                        </#if>

                                                        吨</div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">完成率</div>
                                                    <div class="pull-right zk-target-right">
                                                        <#if company="HSMRY">
                                                            <#if byys1 == 0>
                                                            0%
                                                            <#else>
                                                            <#if (byys1>0)>
                                                            ${SXNCLLj1/byys1*100}%
                                                            <#elseif (byys1<0)>
                                                            ${(2-SXNCLLj1/byys1)*100}
                                                            </#if>
                                                            </#if>
                                                            <#else >
                                                                <#if ysxl == 0>
                                                                    0%
                                                                <#else>
                                                                    <#if (ysxl>0)>
                                                                    ${sjxl/ysxl*100}%
                                                                    <#elseif (ysxl<0)>
                                                                    ${(2-sjxl/ysxl)*100}
                                                                    </#if>
                                                                </#if>
                                                        </#if>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-speedometer"></i>
                                            </div>
                                        <#if company =="HSMRY">
                                            <a target="navTab" href="${ctx}/report/milkReport/salesKanban?companyNumber=${companyNumber}&company=${company}" data-title="乳制品销量明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                         <#else >
                                             <a target="navTab" href="${ctx}/report/milkReport/dairySalesDetail?companyNumber=${companyNumber}&company=${company}" data-title="乳制品销量明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                        </#if>
                                        </div>
                                    </div>
                                </div>
                                <div class="chart tab-pane active" id="sales-chart" style="height: 157px;">

                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-aqua">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">
                                                        营业收入<br>
                                                        <span class="calendarIcon"><li class="fa fa-calendar"></li> ${yysr[0].fyearMonth}</span>
                                                    </div>
                                                    <h3 style="text-align: right">
                                                    <#assign sjsr = yysr[0].fvalue>
                                                    ${sjsr?string("#")}
                                                        <sup style="font-size: 20px">万</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">预算目标</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#assign yssr = yysr[1].fvalue>
                                                    ${yssr?string("#")}万
                                                    </div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">完成率</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#if yssr == 0>
                                                        0%
                                                    <#else>
                                                        <#assign srRatio = 0>
                                                        <#if (yssr>0)>
                                                            <#assign srRatio = sjsr/yssr*100>
                                                        <#else>
                                                            <#assign srRatio = (2-sjsr/yssr)*100>
                                                        </#if>
                                                    ${srRatio}%
                                                    </#if>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-social-bitcoin-outline"></i>
                                            </div>
                                            <a target="navTab" href="${ctx}/report/milkReport/businessIncomeDetail?companyNumber=${companyNumber}&company=${company}" data-title="营业收入明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>
                                    <!-- ./col -->

                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-green">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">
                                                        利润总额<br>
                                                        <span class="calendarIcon"><li class="fa fa-calendar"></li> ${lrze[0].fyearMonth}</span>
                                                    </div>
                                                    <h3 style="text-align: right">
                                                    <#assign actual = lrze[0].fvalue>
                                                    <#assign budget = lrze[1].fvalue>
                                                    ${actual?string("#")}
                                                        <sup style="font-size: 20px">万</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">预算目标</div>
                                                    <div class="pull-right zk-target-right">${budget?string("#")}万</div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">完成率</div>
                                                    <div class="pull-right zk-target-right">
                                                    <#if budget==0>
                                                        0%
                                                    <#else>
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
                                            <a target="navTab" href="${ctx}/report/pastureReport/operatingProfit?companyNumber=${companyNumber}&company=${company}" data-title="利润总额明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>
                                    <!-- ./col -->
                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-red">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">
                                                        应收账款<br>
                                                        <span class="calendarIcon"><li class="fa fa-calendar"></li> ${yszk[0].fyearMonth}</span>
                                                    </div>
                                                    <h3 style="text-align: right">

                                                    ${yszk[0].fvalue?string("#")}
                                                        <sup style="font-size: 20px">万</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">&nbsp;</div>
                                                    <div class="pull-right zk-target-right">&nbsp;</div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">&nbsp;</div>
                                                    <div class="pull-right zk-target-right">&nbsp;</div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-checkmark"></i>
                                            </div>
                                            <a target="navTab" href="${ctx}/report/milkReport/accountsReceivableDetail?companyNumber=${companyNumber}&company=${company}" data-title="应收账款明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>
                                    <!-- ./col -->
                                    <div class="col-md-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-yellow">
                                            <div class="inner">
                                                <div>
                                                    <div class="pull-left zk-target-left">
                                                        乳制品销量<br>
                                                    <#if company="HSMRY">
                                                    <#list rzpxl1?keys as key>
                                                        <#if key == "yearMonth">
                                                        <#assign MonthDay = rzpxl1[key]>
                                                        </#if>
                                                    </#list>
                                                        <span class="calendarIcon"><li class="fa fa-calendar"></li> ${MonthDay}</span>
                                                    <#else >
                                                        <span class="calendarIcon"><li class="fa fa-calendar"></li> ${rzpxl[0].fyearMonth}</span>
                                                    </#if>
                                                    </div>
                                                    <h3 style="text-align: right">
                                                    <#if  company="HSMRY">
                                                        <#assign SXNCLLj = 0>
                                                        <#list rzpxl1?keys as key>
                                                            <#if key != "yearMonth">
                                                                <#assign SXNCLLj = rzpxl1[key]>
                                                            </#if>
                                                        </#list>
                                                    ${SXNCLLj?string("#")}
                                                    <#else >
                                                    <#assign sjxl = rzpxl[0].fvalue>
                                                    ${sjxl?string("#")}
                                                        </#if>
                                                        <sup style="font-size: 20px">吨</sup></h3>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">预算目标</div>
                                                    <div class="pull-right zk-target-right">
                                                        <#if company="HSMRY">
                                                        <#assign byys = 0>
                                                        <#list rzpxl2?keys as key>
                                                        <#if key == "BYSHSMR">
                                                        <#assign byys = rzpxl2[key]/days>
                                                        </#if>
                                                        </#list>
                                                        ${byys?string("#")}
                                                        <#else >
                                                            <#assign ysxl = rzpxl[1].fvalue>
                                                        ${ysxl?string("#")}
                                                        </#if>
                                                        吨</div>
                                                </div>
                                                <div class="clearfix zk-target">
                                                    <div class="pull-left zk-target-left">完成率</div>
                                                    <div class="pull-right zk-target-right">
                                                        <#if company="HSMRY">
                                                            <#if byys == 0>
                                                            0%
                                                            <#else>
                                                            <#if (byys>0)>
                                                            ${SXNCLLj/byys*100}%
                                                            <#elseif (byys<0)>
                                                            ${(2-SXNCLLj/byys)*100}
                                                            </#if>
                                                        </#if>
                                                            <#else >
                                                                <#if ysxl == 0>
                                                                    0%
                                                                <#else>
                                                                    <#if (ysxl>0)>
                                                                    ${sjxl/ysxl*100}%
                                                                    <#elseif (ysxl<0)>
                                                                    ${(2-sjxl/ysxl)*100}
                                                                    </#if>
                                                                </#if>
                                                        </#if>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-speedometer"></i>
                                            </div>
                                        <#if company =="HSMRY">
                                            <a target="navTab" href="${ctx}/report/milkReport/salesKanban?companyNumber=${companyNumber}&company=${company}" data-title="乳制品销量明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                        <#else >
                                            <a target="navTab" href="${ctx}/report/milkReport/dairySalesDetail?companyNumber=${companyNumber}&company=${company}" data-title="乳制品销量明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                        </#if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">每日经营走势图</h3>
                                    <div class="box-tools pull-right">
                                        <input type="text" id="securityTimes" placeholder="选择期间...">
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

                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">销售金额分析</h3>
                                    <div class="box-tools pull-right">
                                        <input type="text" id="yearMonth">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-8 col-sm-8">
                                            <div id="amount_div" style="width: 100%; height: 300px;"></div>
                                        </div>
                                        <div class="col-md-4 col-sm-4">
                                            <div id="amount_pie_div" style="width: 100%; height: 300px;"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">销量分析</h3>
                                    <div class="box-tools pull-right">

                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-8 col-sm-8">
                                            <div class="group_map" style="width: 100%; height: 29rem;"></div>
                                        </div>
                                        <div class="col-md-4 col-sm-4">
                                            <#--<div class="col-md-12">-->
                                                <p class="text-left">
                                                    <strong>本月销量前5(单位:吨）</strong>
                                                </p>
                                                <input type="text" id="securityTime" placeholder="选择期间..." style="position: absolute;top: 2px;right: 18px;width: 102px">
                                                <table id="example2" class="table table-condensed" style="font-size: 1.1rem;height: 25rem;">
                                                    <tbody>

                                                    </tbody>
                                                </table>
                                            <#--</div>-->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                <#--
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">销售分析</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div id="project_div" style="width: 100%; height: 300px;"></div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div id="channel_div" style="width: 100%; height: 300px;"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                   -->
                </div>
                <div class="col-md-2">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">快速查看</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="box-body">
                            <table class="table table-condensed" style="height: 1340    px;">
                                <tbody class="zk-repot-list">
                                    <tr>
                                        <th>销售指标</th>
                                    </tr>


                                    <#--<tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/regionalAnalysis?companyNumber=${companyNumber}&company=${company}">区域分析</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/salesChannel?companyNumber=${companyNumber}">渠道分析</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/regionalAnalysis?companyNumber=${companyNumber}&company=${company}">品牌分析</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/categoryAnalysis?companyNumber=${companyNumber}&company=${company}">品类分析</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/salesDepartmentAnalysis?companyNumber=${companyNumber}&company=${company}">销售部门分析</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/regionalAnalysis?companyNumber=${companyNumber}&company=${company}">应收账款分析</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/regionalAnalysis?companyNumber=${companyNumber}&company=${company}">销售发货及时率</a></td>
                                    </tr>-->
                                    <#if company =="HSMRY">
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/salesAnalysis?companyNumber=${companyNumber}&company=${company}">销售看板</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/regionalAnalysis?companyNumber=${companyNumber}&company=${company}">区域分析</a></td>
                                    </tr>
                                    <#else>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/admin/comingSoon?companyNumber=${companyNumber}&company=${company}&modularName=销售看板">销售看板</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/admin/comingSoon?companyNumber=${companyNumber}&modularName=区域分析">区域分析</a></td>
                                    </tr>
                                    </#if>
                                    <#-- edit begin  杨北平  2017-12-25 -->
                                    <#if company =="HSMRY">
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/channelAnalysis?companyNumber=${companyNumber}&company=${company}">渠道分析</a></td>
                                    </tr>
                                    <#else>
                                    <tr>
                                        <#--<td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/salesChannel?companyNumber=${companyNumber}&company=${company}">渠道分析</a></td>-->
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/admin/comingSoon?companyNumber=${companyNumber}&modularName=渠道分析">渠道分析</a></td>
                                    </tr>
                                    </#if>
                                    <#-- edit end -->
                                    <#--<tr>-->
                                        <#--<td style="padding-left: 15px;"><a target="navTab" href="${ctx}/admin/comingSoon?companyNumber=${companyNumber}&modularName=品牌分析">品牌分析</a></td>-->
                                    <#--</tr>-->
                                    <#if company =="HSMRY">
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/categoryAnalysis?companyNumber=${companyNumber}&company=${company}">品类分析</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/dairySalesDetail?companyNumber=${companyNumber}&company=${company}">销售分析</a></td>
                                    </tr>
                                    <#else>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/admin/comingSoon?companyNumber=${companyNumber}&modularName=品类分析">品类分析</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/admin/comingSoon?companyNumber=${companyNumber}&modularName=销售分析">销售分析</a></td>
                                    </tr>
                                    </#if>
                                    <#--<tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/admin/comingSoon?companyNumber=${companyNumber}&modularName=销售部门分析">销售部门分析</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/admin/comingSoon?companyNumber=${companyNumber}&modularName=应收账款分析">应收账款分析</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/admin/comingSoon?companyNumber=${companyNumber}&modularName=销售发货及时率">销售发货及时率</a></td>
                                    </tr>
                                    <tr>
                                        <th>采购指标</th>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/purchasingReport?companyNumber=${companyNumber}&company=${company}">采购看板</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/purchasingPriceReport?companyNumber=${companyNumber}&company=${company}">采购价格分析</a></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/purchasingExecutionReport?companyNumber=${companyNumber}&company=${company}">采购执行分析</a></td>
                                    </tr>-->
                                    <tr>
                                        <th>财务指标</th>
                                    </tr>
                                    <#if companyNumber == 'ZKRY'>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/milkReport/Analysis?companyNumber=${companyNumber}&company=${company}">对标企业</a></td>
                                    </tr>
                                    </#if>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-ZCFZL-BFB&fNameZh=资产负债率&lastYearFNameEn=CW-ZCFZL-SN-BFB&fNameYs=CW-ZCFZL-BFBYS">资产负债率</a>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-LDBL-BFB&fNameZh=流动比率&lastYearFNameEn=CW-LDBL-SN-BFB&fNameYs=CW-LDBL-BFBYS">流动比率</a>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-SDBL-BFB&fNameZh=速动比率&lastYearFNameEn=CW-SDBL-SN-BFB&fNameYs=CW-SDBL-BFBYS">速动比率</a>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-YSZKZZL-BFB&fNameZh=应收账款周转率&lastYearFNameEn=CW-YSZKZZL-SN-BFB&fNameYs=CW-YSZKZZL-BFBYS">应收账款周转率</a>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-XSMLL-BFB&fNameZh=销售毛利率&lastYearFNameEn=ZKZB-XSMLL-SN-BFB&fNameYs=CW-XSMLL-BFBYS">销售毛利率</a>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-YYLRL-BFB&fNameZh=营业利润率&lastYearFNameEn=CW-YYLRL-SN-BFB&fNameYs=CW-YYLRL-BFBYS">营业利润率</a>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-CBFYLRL-BFB&fNameZh=成本费用利润率&lastYearFNameEn=CW-CBFYLRL-SN-BFB&fNameYs=CW-CBFYLRL-BFBYS">成本费用利润率</a>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-QJFYL-BFB&fNameZh=期间费用率&lastYearFNameEn=CW-QJFYL-SN-BFB&fNameYs=CW-QJFYL-BFBYS">期间费用率</a>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=YYYLNL-LDSCL-BQ&fNameZh=劳动生产率&lastYearFNameEn=YYYLNL-LDSCL-SN&fNameYs=YYYLNL-LDSCL-BQYS">劳动生产率</a>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=YYYLNL-ZCCCL-BQ&fNameZh=资产产出率&lastYearFNameEn=YYYLNL-ZCCCL-SN&fNameYs=YYYLNL-ZCCCL-BQYS">资产产出率</a>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-ZCZZL-BFB&fNameZh=资产增长率&lastYearFNameEn=CW-ZCZZL-SN-BFB&fNameYs=CW-ZCZZL-BFBYS">资产增长率</a>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-XSZZL-BFB&fNameZh=销售增长率&lastYearFNameEn=CW-XSZZL-SN-BFB&fNameYs=CW-XSZZL-BFBYS">销售增长率</a>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 15px;"><a target="navTab" href="${ctx}/report/pastureReport/financialIndex?companyNumber=${companyNumber}&company=${company}&fNameEn=CW-LRZZL-BFB&fNameZh=利润增长率&lastYearFNameEn=CW-LRZZL-SN-BFB&fNameYs=CW-LRZZL-BFBYS">利润增长率</a>
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
    var yearMonth = '';
    $("#yearMonth").datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: false,
        startView: 1,
        maxViewMode: 1,
        minViewMode:1
    }).on('changeDate',function (ev) {
        yearMonth = $(this).val();
        indexSale(yearMonth);
    });
    var yearMonths = '';
    $('#securityTime').datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: true,
        startView: 1,
        maxViewMode: 1,
        minViewMode: 1
    }).on('changeDate', function () {
        yearMonths = $(this).val();
        productSales(yearMonths);
    });
    var securityTime = '';
    $('#securityTimes').datepicker({
        language: 'zh-CN',
        format: 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight: true,
    }).on('changeDate',function (ev) {
        securityTime = $(this).val();
        dailyYield(securityTime);
    });
    $(function () {
        $('#yearMonth').datepicker( 'setDate' , '-1m' );//设置日期控件默认值,触发change事件
        $('#securityTime').datepicker( 'setDate' , '-0m' );
        $('#securityTimes').datepicker( 'setDate' , '-1d' );
    });
    function productSales(yearMonths) {
        $.ajax({
            url: "${ctx}/admin/productSales?companyNumber=${companyNumber}&company=${company}&yearMonths=" + yearMonths,
            type: "get",
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                Areachart(jsonObj);
            },
            error: function () {
                console.log('错误');
            }
        });
    }
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
    function indexSale(yearMonth){
        $.ajax({
            url:"${ctx}/admin/indexSaleChartAjax?companyNumber=${company}",
            type:"get",
            data:{'yearMonth':yearMonth},
            dataType:"text",
            success:function (result) {
                var jsonObj = eval('('+result+')');
                financePidReport(jsonObj);//销售金额饼图数据
                init(jsonObj);//销售量分析chart数据
            },
            error:function () {
                console.log('错误');
            }
        });
        /**
         *
        $.ajax({

            url:"${ctx}/admin/indexSaleAreaChartAjax?companyNumber=${company}",
            type:"get",
            dataType:"text",
            success:function (result) {
                var jsonObj = eval('('+result+')');
                financeReport(jsonObj);//销量金额折线数据
            },
            error:function () {
                console.log('错误');
            }
        });*/

        $(".progress").css("margin-top","0px");//修改销量前5 ==>销量样式


    }

        function Areachart(result) {
            $("#example2").empty();
            var first = 0;
            var two = 0;
            var three = 0;
            var four = 0;
            var five = 0;

            $("#example2").append("<tr>" +"<th style=\"width: 10px\">"+"#"+"</th>"+"<th>"+"产品"+"</th>"+"<th>"+"销量"+"</th>"+"<th style=\"text-align: center\">"+"环比"+"</th>"+"</tr>");
             console.log();
             for(var key in result){
                var row = "<tr>";
                 row = row +"<td>"+key+"</td>";
                if(key==1){
                    row = row + "<td>"+result[key][0]+"</td>";
                    row = row + "<td>"+"<div class=\"progress\"style=\"margin-top:0px\">"+"<div class=\"progress-bar progress-bar-danger\" style=\"width: 100%\">"+Math.floor(result[key][1])+"</div>"+"</div>"+"</td>";
                    if(result[key][2]>0){
                        first = (result[key][1]-result[key][2])/result[key][2]*100;
                        row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-red\">"+first.toFixed(2)+"%"+"</span>"+"</td>";
                    }else if(result[key][2]<0){
                        first = (1-result[key][1]/result[key][2])*100;
                        row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-red\">"+first.toFixed(2)+"%"+"</span>"+"</td>";
                    }else {
                        row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-red\">"+first.toFixed(2)+"%"+"</span>"+"</td>";
                    }
                }
                 if(key==2){
                     row = row + "<td>"+result[key][0]+"</td>";
                     row = row + "<td>"+"<div class=\"progress\"style=\"margin-top:0px\">"+"<div class=\"progress-bar progress-bar-yellow\" style=\"width: 100%\">"+Math.floor(result[key][1])+"</div>"+"</div>"+"</td>";
                     if(result[key][2]>0){
                         two = (result[key][1]-result[key][2])/result[key][2]*100;
                         row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-yellow\">"+two.toFixed(2)+"%"+"</span>"+"</td>";
                     }else if(result[key][2]<0){
                         two = (1-result[key][1]/result[key][2])*100;
                         row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-yellow\">"+two.toFixed(2)+"%"+"</span>"+"</td>";
                     }else {
                         row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-yellow\">"+two.toFixed(2)+"%"+"</span>"+"</td>";
                     }
                 }
                 if(key==3){
                     row = row + "<td>"+result[key][0]+"</td>";
                     row = row + "<td>"+"<div class=\"progress\"style=\"margin-top:0px\">"+"<div class=\"progress-bar progress-bar-primary\" style=\"width: 100%\">"+Math.floor(result[key][1])+"</div>"+"</div>"+"</td>";
                     if(result[key][2]>0){
                         three = (result[key][1]-result[key][2])/result[key][2]*100;
                         row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-blue\">"+three.toFixed(2)+"%"+"</span>"+"</td>";
                     }else if(result[key][2]<0){
                         three = (1-result[key][1]/result[key][2])*100;
                         row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-blue\">"+three.toFixed(2)+"%"+"</span>"+"</td>";
                     }else {
                         row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-blue\">"+three.toFixed(2)+"%"+"</span>"+"</td>";
                     }
                 }
                 if(key==4){
                     row = row + "<td>"+result[key][0]+"</td>";
                     row = row + "<td>"+"<div class=\"progress\"style=\"margin-top:0px\">"+"<div class=\"progress-bar progress-bar-success\" style=\"width: 100%\">"+Math.floor(result[key][1])+"</div>"+"</div>"+"</td>";
                     if(result[key][2]>0){
                         four = (result[key][1]-result[key][2])/result[key][2]*100;
                         row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-green\">"+four.toFixed(2)+"%"+"</span>"+"</td>";
                     }else if(result[key][2]<0){
                         four = (1-result[key][1]/result[key][2])*100;
                         row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-green\">"+four.toFixed(2)+"%"+"</span>"+"</td>";
                     }else {
                         row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-green\">"+four.toFixed(2)+"%"+"</span>"+"</td>";
                     }
                 }
                 if(key==5){
                     row = row + "<td>"+result[key][0]+"</td>";
                     row = row + "<td>"+"<div class=\"progress\"style=\"margin-top:0px\">"+"<div class=\"progress-bar progress-bar-info\" style=\"width: 100%\">"+Math.floor(result[key][1])+"</div>"+"</div>"+"</td>";
                     if(result[key][2]>0){
                         five = (result[key][1]-result[key][2])/result[key][2]*100;
                         row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-aqua\">"+five.toFixed(2)+"%"+"</span>"+"</td>";
                     }else if(result[key][2]<0){
                         five = (1-result[key][1]/result[key][2])*100;
                         row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-aqua\">"+five.toFixed(2)+"%"+"</span>"+"</td>";
                     }else {
                         row = row + "<td style=\"text-align: center\">"+"<span class=\"badge bg-aqua\">"+five.toFixed(2)+"%"+"</span>"+"</td>";
                     }
                 }





                 $("#example2").append(row+"</tr>");
             }
        }
    /**
     * 初始化
     */
    function init (result) {
        var yearMonths = [];//月份
        var DWNXL = [];//低温奶销量
        var CWNXL = [];//常温奶销量
        var NFXL = [];//奶粉销量
        var XSNXL = [];//学生奶销量
        var DWNXSE = [];//低温奶销售额
        var CWNXSE = [];//常温奶销售额
        var NFXSE = [];//奶粉销售额
        var XSNXSE = [];//学生奶销售额
        for(var i=0;i<result["yearMonths"].length;i++){
            yearMonths.push(result["yearMonths"][i]);
            DWNXL.push(Math.floor(result["quota"]["XLFX-DWNXL-QK"][i]));
            CWNXL.push(Math.floor(result["quota"]["XLFX-CWNXL-QK"][i]));
            NFXL.push(Math.floor(result["quota"]["XLFX-NFXL-QK"][i]));
            XSNXL.push(Math.floor(result["quota"]["PJRCNL-XSMYXL"][i]));
            DWNXSE.push(Math.floor(result["quota"]["XSJEFX-DWNXSE-WY"][i]));
            CWNXSE.push(Math.floor(result["quota"]["XSJEFX-CWNXSE-WY"][i]));
            NFXSE.push(Math.floor(result["quota"]["XSJEFX-NFXSE-WY"][i]));
            XSNXSE.push(Math.floor(result["quota"]["PJRCNL-XSMYXSE"][i]));
        }
        if(result["companyNumber"]!="HSMRY"){
            var saleReport = echarts.init($('.group_map')[0], echartsTheme);
            var option2 = {
                title:{
                    subtext:'单位:吨'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['低温奶','常温奶','奶粉']
                },
                toolbox: {
                    show : true,
                    feature : {
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                grid: {
                    left:'3%',
                    right:'3%',
                    bottom:'10%',
                    containLabel:true
                },
                xAxis : [
                    {
                        type : 'category',
                        data : yearMonths,
                        axisLabel: {
                            interval: 0,
                            rotate: -20,
                            margin: 30,
                            textStyle: {
                                color: '#0c180d',
                                align: 'center'

                            },
                        },
                    }
                ],
                yAxis : [
                    {
                        type: 'value',
                        name: '液体奶销量',
                        position: 'left',
                        axisLabel: {
                            formatter: '{value}'
                        },
                        max: function(value) {
                            var num = parseInt(value.max /5 * 6);
                            var numStr = num.toString();
                            var newNum = 0;
                            for (var i = 0; i < numStr.length; i++) {
                                if (i === 0) {
                                    newNum = parseInt(num / Math.pow(10,numStr.length - 1)) + 1;
                                }else {
                                    newNum = newNum * 10;
                                }
                            }
                            return newNum;
                        }
                    },
                    {
                        type: 'value',
                        name: '奶粉销量',
                        position: 'right',
                        axisLabel: {
                            formatter: '{value}'
                        },
                        max: function(value) {
                            var num = parseInt(value.max /5 * 6);
                            var numStr = num.toString();
                            var newNum = 0;
                            for (var i = 0; i < numStr.length; i++) {
                                if (i === 0) {
                                    newNum = parseInt(num / Math.pow(10,numStr.length - 1)) + 1;
                                }else {
                                    newNum = newNum * 10;
                                }
                            }
                            return newNum;
                        }
                    }
                ],
                series : [
                    {
                        name:'低温奶',
                        type:'line',
                        data:DWNXL,
                        itemStyle: {
                            normal: {
                                color: '#DD2222'
                            }
                        },
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name:'常温奶',
                        type:'line',
                        data:CWNXL,
                        itemStyle: {
                            normal: {
                                color: '#EEC211'
                            }
                        },
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name:'奶粉',
                        type:'line',
                        data:NFXL,
                        itemStyle: {
                            normal: {
                                color: '#3c8dbc'
                            }
                        },
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        yAxisIndex: 1
                    }
                ]
            };
            saleReport.setOption(option2);



            var amountReport = echarts.init($("#amount_div")[0], echartsTheme);
            var option = {
                title:{
                    subtext:'单位:万元'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['低温奶','常温奶','奶粉']
                },
                toolbox: {
                    show : true,
                    feature : {
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                grid: {
                    left:'3%',
                    right:'3%',
                    bottom:'10%',
                    containLabel:true
                },
                xAxis : [
                    {
                        type : 'category',
                        data : yearMonths,
                        axisLabel: {
                            interval: 0,
                            rotate: -20,
                            margin: 30,
                            textStyle: {
                                color: '#0c180d',
                                align: 'center'

                            },
                        },
                    }
                ],
                yAxis : [
                    {
                        type: 'value',
                        name: '液体奶销售额',
                        position: 'left',
                        axisLabel: {
                            formatter: '{value}'
                        },
                        max: function(value) {
                            var num = parseInt(value.max /5 * 6);
                            var numStr = num.toString();
                            var newNum = 0;
                            for (var i = 0; i < numStr.length; i++) {
                                if (i === 0) {
                                    newNum = parseInt(num / Math.pow(10,numStr.length - 1)) + 1;
                                }else {
                                    newNum = newNum * 10;
                                }
                            }
                            return newNum;
                        }
                    },
                    {
                        type: 'value',
                        name: '奶粉销售额',
                        position: 'right',
                        axisLabel: {
                            formatter: '{value}'
                        },
                        max: function(value) {
                            var num = parseInt(value.max /5 * 6);
                            var numStr = num.toString();
                            var newNum = 0;
                            for (var i = 0; i < numStr.length; i++) {
                                if (i === 0) {
                                    newNum = parseInt(num / Math.pow(10,numStr.length - 1)) + 1;
                                }else {
                                    newNum = newNum * 10;
                                }
                            }
                            return newNum;
                        }
                    }
                ],
                series : [
                    {
                        name:'低温奶',
                        type:'line',
                        data:DWNXSE,
                        itemStyle: {
                            normal: {
                                color: '#DD2222'
                            }
                        },
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name:'常温奶',
                        type:'line',
                        data:CWNXSE,
                        itemStyle: {
                            normal: {
                                color: '#EEC211'
                            }
                        },
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name:'奶粉',
                        type:'line',
                        data:NFXSE,
                        itemStyle: {
                            normal: {
                                color: '#3c8dbc'
                            }
                        },
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        yAxisIndex: 1
                    }
                ]
            };

            amountReport.setOption(option);
        }else{
            var saleReport = echarts.init($('.group_map')[0], echartsTheme);
            var option2 = {
                title:{
                    subtext:'单位:吨'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['低温奶','常温奶','学生奶']
                },
                toolbox: {
                    show : true,
                    feature : {
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                grid: {
                    left:'3%',
                    right:'3%',
                    bottom:'10%',
                    containLabel:true
                },
                xAxis : [
                    {
                        type : 'category',
                        data : yearMonths,
                        axisLabel: {
                            interval: 0,
                            rotate: -20,
                            margin: 30,
                            textStyle: {
                                color: '#0c180d',
                                align: 'center'

                            }
                        }
                    }
                ],
                yAxis : [
                    {
                        type: 'value',
                        name: '液体奶销量',
                        position: 'left',
                        axisLabel: {
                            formatter: '{value}'
                        },
                        max: function(value) {
                            var num = parseInt(value.max /5 * 6);
                            var numStr = num.toString();
                            var newNum = 0;
                            for (var i = 0; i < numStr.length; i++) {
                                if (i === 0) {
                                    newNum = parseInt(num / Math.pow(10,numStr.length - 1)) + 1;
                                }else {
                                    newNum = newNum * 10;
                                }
                            }
                            return newNum;
                        }
                    },
                    {
                        type: 'value',
                        name: '学生奶销量',
                        position: 'right',
                        axisLabel: {
                            formatter: '{value}'
                        },
                        max: function(value) {
                            var num = parseInt(value.max /5 * 6);
                            var numStr = num.toString();
                            var newNum = 0;
                            for (var i = 0; i < numStr.length; i++) {
                                if (i === 0) {
                                    newNum = parseInt(num / Math.pow(10,numStr.length - 1)) + 1;
                                }else {
                                    newNum = newNum * 10;
                                }
                            }
                            return newNum;
                        }
                    }
                ],
                series : [
                    {
                        name:'低温奶',
                        type:'line',
                        data:DWNXL,
                        itemStyle: {
                            normal: {
                                color: '#DD2222'
                            }
                        },
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name:'常温奶',
                        type:'line',
                        data:CWNXL,
                        itemStyle: {
                            normal: {
                                color: '#EEC211'
                            }
                        },
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name:'学生奶',
                        type:'line',
                        data:XSNXL,
                        itemStyle: {
                            normal: {
                                color: '#3c8dbc'
                            }
                        },
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        yAxisIndex: 1
                    }
                ]
            };
            saleReport.setOption(option2);



            var amountReport = echarts.init($("#amount_div")[0], echartsTheme);
            var option = {
                title:{
                    subtext:'单位:万元'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['低温奶','常温奶','学生奶']
                },
                toolbox: {
                    show : true,
                    feature : {
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                grid: {
                    left:'3%',
                    right:'3%',
                    bottom:'10%',
                    containLabel:true
                },
                xAxis : [
                    {
                        type : 'category',
                        data : yearMonths,
                        axisLabel: {
                            interval: 0,
                            rotate: -20,
                            margin: 30,
                            textStyle: {
                                color: '#0c180d',
                                align: 'center'

                            }
                        }
                    }
                ],
                yAxis : [
                    {
                        type: 'value',
                        name: '液体奶销售额',
                        position: 'left',
                        axisLabel: {
                            formatter: '{value}'
                        },
                        max: function(value) {
                            var num = parseInt(value.max /5 * 6);
                            var numStr = num.toString();
                            var newNum = 0;
                            for (var i = 0; i < numStr.length; i++) {
                                if (i === 0) {
                                    newNum = parseInt(num / Math.pow(10,numStr.length - 1)) + 1;
                                }else {
                                    newNum = newNum * 10;
                                }
                            }
                            return newNum;
                        }
                    },
                    {
                        type: 'value',
                        name: '学生奶销售额',
                        position: 'right',
                        axisLabel: {
                            formatter: '{value}'
                        },
                        max: function(value) {
                            var num = parseInt(value.max /5 * 6);
                            var numStr = num.toString();
                            var newNum = 0;
                            for (var i = 0; i < numStr.length; i++) {
                                if (i === 0) {
                                    newNum = parseInt(num / Math.pow(10,numStr.length - 1)) + 1;
                                }else {
                                    newNum = newNum * 10;
                                }
                            }
                            return newNum;
                        }
                    }
                ],
                series : [
                    {
                        name:'低温奶',
                        type:'line',
                        data:DWNXSE,
                        itemStyle: {
                            normal: {
                                color: '#DD2222'
                            }
                        },
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name:'常温奶',
                        type:'line',
                        data:CWNXSE,
                        itemStyle: {
                            normal: {
                                color: '#EEC211'
                            }
                        },
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name:'学生奶',
                        type:'line',
                        data:XSNXSE,
                        itemStyle: {
                            normal: {
                                color: '#3c8dbc'
                            }
                        },
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        yAxisIndex: 1
                    }
                ]
            };

            amountReport.setOption(option);
        }


        $(window).resize(function () {
            saleReport.resize();
            amountReport.resize();
        });

    }

    /**
     * 销量分析chart

    function financeReport(result) {
        var regionLegend = [];//区域分析图例
        var channelLegend = [];//渠道分析图例
        var regionData = [];//区域分析数据
        var channelData = [];//渠道分析数据
        for(var i=0;i<result["resultList"].length;i++){
            if(result["resultList"][i].fnameEn=="XSFX-QYFX-WY"){
                var region = {};
                region.value = Math.floor(result["resultList"][i].fvalue);
                region.name = result["resultList"][i].fsmallClass;
                regionLegend.push(result["resultList"][i].fsmallClass);
                regionData.push(region);
            }else{
                var channel = {};
                channel.value = Math.floor(result["resultList"][i].fvalue);
                channel.name = result["resultList"][i].fsmallClass;
                channelLegend.push(result["resultList"][i].fsmallClass);
                channelData.push(channel);
            }
        }
        var projectReport = echarts.init(document.getElementById("project_div"), echartsTheme);

        var option = {
            title : {
                text: '区域分析',
                subtext: '本期销售情况',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}吨 ({d}%)"
            },
            legend: {
                //orient: 'vertical',
                y: 'bottom',
                data:regionLegend
            },
            series: [
                {
                    name:'销售区域',
                    type:'pie',
                    radius: ['35%', '50%'],
                    label: {
                        normal: {
                            formatter: '{b}：{c}吨',
                            /*backgroundColor: '#eee',
                            borderColor: '#aaa',
                            borderWidth: 1,
                            borderRadius: 4,
                            rich: {
                                a: {
                                    color: '#999',
                                    lineHeight: 22,
                                    align: 'center'
                                },
                                hr: {
                                    borderColor: '#aaa',
                                    width: '100%',
                                    borderWidth: 0.5,
                                    height: 0
                                },
                                b: {
                                    fontSize: 16,
                                    lineHeight: 33
                                },
                                per: {
                                    color: '#eee',
                                    backgroundColor: '#334455',
                                    padding: [2, 4],
                                    borderRadius: 2
                                }
                            }
                        }
                    },
                    data:regionData
                }
            ]
        };
        projectReport.setOption(option);

        var channelReport = echarts.init(document.getElementById("channel_div"), echartsTheme);

        var option3 = {
            title : {
                text: '渠道分析',
                subtext: '本期销售情况',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}吨 ({d}%)"
            },
            legend: {
                //orient: 'vertical',
                y: 'bottom',
                data:channelLegend
            },
            series: [
                {
                    name:'销售区域',
                    type:'pie',
                    radius: ['35%', '50%'],
                    label: {
                        normal: {
                            formatter: '{b}：{c}吨',
                            /*backgroundColor: '#eee',
                            borderColor: '#aaa',
                            borderWidth: 1,
                            borderRadius: 4,
                            rich: {
                                a: {
                                    color: '#999',
                                    lineHeight: 22,
                                    align: 'center'
                                },
                                hr: {
                                    borderColor: '#aaa',
                                    width: '100%',
                                    borderWidth: 0.5,
                                    height: 0
                                },
                                b: {
                                    fontSize: 16,
                                    lineHeight: 33
                                },
                                per: {
                                    color: '#eee',
                                    backgroundColor: '#334455',
                                    padding: [2, 4],
                                    borderRadius: 2
                                }
                            }
                        }
                    },
                    data:channelData
                }
            ]
        };
        channelReport.setOption(option3);
        $(window).resize(function () {
            projectReport.resize();
            channelReport.resize();
        });

    }*/

    /**
     * 销售金额分析
     */
    function financePidReport(result) {
        var dwn = Math.floor(result["quota"]["XLFX-DWNXL-QK"][11]);//低温奶
        var cwn = Math.floor(result["quota"]["XLFX-CWNXL-QK"][11]);//常温奶
        var nf = Math.floor(result["quota"]["XLFX-NFXL-QK"][11]);//奶粉
        var xs = Math.floor(result["quota"]["PJRCNL-XSMYXL"][11]);//学生奶
        if(result["companyNumber"]!="HSMRY"){
            var option = {
                title:{
                    text:"产品销量",
                    left:"center"
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c}吨 ({d}%)"
                },
                legend: {
                    //orient: 'vertical',
                    y: 'bottom',
                    data:['低温奶','常温奶','奶粉']
                },
                series: [
                    {
                        name:'销量',
                        type:'pie',
                        radius: ['35%', '50%'],
                        label: {
                            normal: {
                                formatter: '{b}\r\n{c}吨',
                                /*backgroundColor: '#eee',
                                borderColor: '#aaa',
                                borderWidth: 1,
                                borderRadius: 4,*/
                                rich: {
                                    a: {
                                        color: '#999',
                                        lineHeight: 22,
                                        align: 'center'
                                    },
                                    hr: {
                                        borderColor: '#aaa',
                                        width: '100%',
                                        borderWidth: 0.5,
                                        height: 0
                                    },
                                    b: {
                                        fontSize: 16,
                                        lineHeight: 33
                                    },
                                    per: {
                                        color: '#eee',
                                        backgroundColor: '#334455',
                                        padding: [2, 4],
                                        borderRadius: 2
                                    }
                                }
                            }
                        },
                        data:[
                            {value:dwn, name:'低温奶'},
                            {value:cwn, name:'常温奶'},
                            {value:nf, name:'奶粉'}
                        ]
                    }
                ]
            };
            var amountPieReport = echarts.init($("#amount_pie_div")[0],echartsTheme);
            amountPieReport.setOption(option);
        }else{
            var option = {
                title:{
                    text:"产品销量",
                    left:"center"
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c}吨 ({d}%)"
                },
                legend: {
                    //orient: 'vertical',
                    y: 'bottom',
                    data:['低温奶','常温奶','学生奶']
                },
                series: [
                    {
                        name:'销量',
                        type:'pie',
                        radius: ['35%', '50%'],
                        label: {
                            normal: {
                                formatter: '{b}\r\n{c}吨',
                                /*backgroundColor: '#eee',
                                borderColor: '#aaa',
                                borderWidth: 1,
                                borderRadius: 4,*/
                                rich: {
                                    a: {
                                        color: '#999',
                                        lineHeight: 22,
                                        align: 'center'
                                    },
                                    hr: {
                                        borderColor: '#aaa',
                                        width: '100%',
                                        borderWidth: 0.5,
                                        height: 0
                                    },
                                    b: {
                                        fontSize: 16,
                                        lineHeight: 33
                                    },
                                    per: {
                                        color: '#eee',
                                        backgroundColor: '#334455',
                                        padding: [2, 4],
                                        borderRadius: 2
                                    }
                                }
                            }
                        },
                        data:[
                            {value:dwn, name:'低温奶'},
                            {value:cwn, name:'常温奶'},
                            {value:xs, name:'学生奶'}
                        ]
                    }
                ]
            };
            var amountPieReport = echarts.init($("#amount_pie_div")[0],echartsTheme);
            amountPieReport.setOption(option);
        }

        $(window).resize(function () {
            amountPieReport.resize();
        });
    }
    function dailyYieldInit(result) {
        var axix = result['yearMonth'];
        var axiy = [];
        var axiN = [];
        console.log(result);
        for (var i = 0; i < result['yearMonth'].length; i++) {
            axiy.push(Math.floor(result['XLFX-XL'][i]));
            axiN.push(Math.floor(result['XLFX-XLE'][i]));
        }
        var saleReport = echarts.init($('.dailyYield')[0], echartsTheme);

        var option2 = {

            tooltip: {
                trigger: 'axis'
            },
            legend: {
                x: 'center',
                data: ['每日销售量', '每日销售额']
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
                    name: '每日销售量(吨)',
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
                    type: 'value',
                    name: '每日销售额(万元)',
                    position: 'right',
                    axisLabel: {
                        formatter: '{value}'
                    },
                    max: function(value) {
                        var num = parseInt(value.max /5 * 6);
                        var numStr = num.toString();
                        var newNum = 0;
                        for (var i = 0; i < numStr.length; i++) {
                            if (i === 0) {
                                newNum = parseInt(num / Math.pow(10,numStr.length - 1)) + 1;
                            }else {
                                newNum = newNum * 10;
                            }
                        }
                        return newNum;
                    }
                }
            ],
            series: [
                {
                    name: '每日销售量',
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
                    name: '每日销售额',
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
                    },
                    yAxisIndex: 1
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
