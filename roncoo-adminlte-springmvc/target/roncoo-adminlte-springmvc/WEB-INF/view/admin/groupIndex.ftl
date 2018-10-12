<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>中垦经分系统</title>
<@style/>
    <style type="text/css">
        .table > tbody > tr > td{
            padding: 6px;
        }

        </style>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="row">
                <div class="col-lg-8 col-md-8">
                    <span style="font-size: 30px;">中垦乳业</span>
                    <small>综合指标</small>
                </div>
                <div class="col-lg-4 col-md-4">
                    <div class="btn-group pull-right">
                        <button type="button" class="btn btn-success"><i class="fa fa-bullhorn"></i>&nbsp;&nbsp;每日快报&nbsp;&nbsp;</button>
                        <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                            <span class="caret"></span>
                            <span class="sr-only">Toggle Dropdown</span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a target="navTab"  href="${ctx}/report/groupReport/pastureDailyYield?companyNumber=${companyNumber}">牧场每日产销量</a></li>
                            <li><a target="navTab"  href="${ctx}/report/groupReport/milkDailyYield?companyNumber=${companyNumber}">华山牧每日产销量</a></li>
                            <li><a target="navTab"  href="${ctx}/report/groupReport/supplylDailyYield?companyNumber=${companyNumber}">供应链每日产销量</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <#--<ol class="breadcrumb" style="top: -10px;right: 10px">
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                        <!-- User Account: style can be found in dropdown.less &ndash;&gt;
                        <li id="setday"  class="box box-info dropdown user user-menu" >
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding: 2px 10px;">
                                <span class="hidden-xs" style="font-size: 18px">每日快报 <i class="fa fa-chevron-down"></i></span>
                            </a>
                            <table id = "setdaydata" class="dropdown-menu table table-condensed" style="min-width: auto;height: 70px;">
                                <tr>
                                    <td style="padding-left: 15px;">
                                        <a target="navTab"  href="${ctx}/report/groupReport/pastureDailyYield?companyNumber=${companyNumber}">牧场每日产销量</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;">
                                        <a target="navTab"  href="${ctx}/report/groupReport/milkDailyYield?companyNumber=${companyNumber}">华山牧每日产销量</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-left: 15px;">
                                        <a target="navTab"  href="${ctx}/report/groupReport/supplylDailyYield?companyNumber=${companyNumber}">供应链每日产销量</a>
                                    </td>
                                </tr>
                            </table>
                            &lt;#&ndash;<ul  class="dropdown-menu">&ndash;&gt;
                                &lt;#&ndash;<!-- User image &ndash;&gt;&ndash;&gt;
                                &lt;#&ndash;<li class="user-header">&ndash;&gt;

                                    &lt;#&ndash;<p>&ndash;&gt;
                                    &lt;#&ndash;<small>欢迎登陆</small>&ndash;&gt;
                                    &lt;#&ndash;</p>&ndash;&gt;
                                &lt;#&ndash;</li>&ndash;&gt;
                            &lt;#&ndash;</ul>&ndash;&gt;
                        </li>
                    </ul>
                </div>
            </ol>-->
        </section>
        <section class="content">
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
                        <div class="chart tab-pane" id="revenue-chart" >
                            <div class="col-md-2 col-sm-6">
                                <!-- small box -->
                                <div class="small-box bg-aqua">
                                    <div class="inner">
                                        <h3>
                                        <#assign ZCZE = 0>
                                        <#assign yearMonth = "">
                                        <#list zcze?keys as key>
                                            <#if key=="ZHZB-ZCZE-WY">
                                                <#assign ZCZE = zcze[key]>
                                            <#else>
                                                <#assign yearMonth = zcze[key]>
                                            </#if>
                                        </#list>
                                        ${ZCZE?floor}
                                            <sup style="font-size: 20px">万</sup>
                                        </h3>
                                        <div>资产总额<span class="calendarIcon position" style="position: absolute;top: 70px;right: 70px;"><li class="fa fa-calendar"></li> ${yearMonth?substring(0,4)}01~${yearMonth?substring(4,6)}</span></div>

                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-social-bitcoin-outline"></i>
                                    </div>
                                    <a target="navTab"
                                       href="${ctx}/report/groupReport/totalAssetsDetail?companyNumber=${companyNumber}"
                                       data-title="资产总额明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-md-2 col-sm-6">
                                <!-- small box -->
                                <div class="small-box bg-green">
                                    <div class="inner">
                                        <h3>
                                        <#assign YYSRLJ = 0>
                                        <#assign yearMonth = "">
                                        <#list yysrlj?keys as key>
                                            <#if key=="ZHZB-YYSR-BNLJ-WY">
                                                <#assign YYSRLJ = yysrlj[key]>
                                            <#else>
                                                <#assign yearMonth = yysrlj[key]>
                                            </#if>
                                        </#list>
                                        ${YYSRLJ?floor}
                                            <sup style="font-size: 20px">万</sup></h3>
                                        <div>营业收入<span class="calendarIcon position" style="position: absolute;top: 70px;right: 70px;"><li class="fa fa-calendar"></li> ${yearMonth?substring(0,4)}01~${yearMonth?substring(4,6)}</span></div>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-arrow-graph-up-right"></i>
                                    </div>
                                    <a target="navTab"
                                       href="${ctx}/report/groupReport/businessIncomeDetail?companyNumber=${companyNumber}"
                                       data-title="营业收入明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-md-2 col-sm-6">
                                <!-- small box -->
                                <div class="small-box bg-red">
                                    <div class="inner">
                                        <h3>
                                        <#assign RZPXLLJ = 0>
                                        <#assign yearMonth = "">
                                        <#list rzpxllj?keys as key>
                                            <#if key=="ZHZB-RZPXL-LJ">
                                                <#assign RZPXLLJ = rzpxllj[key]>
                                            <#else>
                                                <#assign yearMonth = rzpxllj[key]>
                                            </#if>
                                        </#list>
                                        ${RZPXLLJ?floor}
                                            <sup style="font-size: 20px">吨</sup></h3>
                                        <div>乳制品销量<span class="calendarIcon position" style="position: absolute;top: 70px;right: 70px;"><li class="fa fa-calendar"></li> ${yearMonth?substring(0,4)}01~${yearMonth?substring(4,6)}</span></div>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-checkmark"></i>
                                    </div>
                                    <a target="navTab"
                                       href="${ctx}/report/groupReport/dairySalesDetail?companyNumber=${companyNumber}"
                                       data-title="乳制品销售明细" class="small-box-footer">查看明细<i
                                            class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-md-2 col-sm-6">
                                <!-- small box -->
                                <div class="small-box bg-primary">
                                    <div class="inner">
                                        <h3>
                                        <#assign YSZK = 0>
                                        <#assign yearMonth = "">
                                        <#list yszk?keys as key>
                                            <#if key=="ZHZB-YSZK-WY-QM">
                                                <#assign YSZK = yszk[key]>
                                            <#else>
                                                <#assign yearMonth = yszk[key]>
                                            </#if>
                                        </#list>
                                        ${YSZK?floor}
                                            <sup style="font-size: 20px">万</sup></h3>
                                        <div>应收账款<span class="calendarIcon position" style="position: absolute;top: 70px;right: 70px;"><li class="fa fa-calendar"></li> ${yearMonth?substring(0,4)}01~${yearMonth?substring(4,6)}</span></div>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-speedometer"></i>
                                    </div>
                                    <a target="navTab"
                                       href="${ctx}/report/groupReport/accountsReceivableDetail?companyNumber=${companyNumber}"
                                       data-title="应收账款明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-md-2 col-sm-6">
                                <!-- small box -->
                                <div class="small-box bg-teal">
                                    <div class="inner">
                                        <h3>
                                        <#assign SXNCLLJ = 0>
                                        <#assign yearMonth = "">
                                        <#list sxncllj?keys as key>
                                            <#if key=="QK">
                                                <#assign SXNCLLJ = sxncllj[key]/1000>
                                            </#if>
                                        </#list>
                                        ${SXNCLLJ?floor}
                                            <sup style="font-size: 20px">吨</sup></h3>
                                        <#list sxncl?keys as key>
                                            <#if key == "yearMonth">
                                                <#assign fyearMonth = sxncl[key]>
                                            </#if>
                                        </#list>
                                        <div>生鲜奶产量
                                        <#if fyearMonth?substring(5,6)?number==1>
                                            <#if (fyearMonth?substring(6)?number>25)>
                                                <span class="calendarIcon" style="position: absolute;top: 70px;right: 42px;"><li class="fa fa-calendar">  ${fyearMonth?substring(0,6)}01~${fyearMonth?substring(4)}</li></span>
                                            <#else>
                                                <span class="calendarIcon" style="position: absolute;top: 70px;right: 42px;"><li class="fa fa-calendar"> ${fyearMonth?substring(0,6)}01~${fyearMonth?substring(4)}</li></span>
                                            </#if>
                                        <#elseif fyearMonth?substring(4,6)?number==12>
                                            <span class="calendarIcon" style="position: absolute;top: 70px;right: 42px;"><li class="fa fa-calendar"> ${fyearMonth?substring(0,5)}${fyearMonth?substring(5,6)?number-1}26~${fyearMonth?substring(4)}</li></span>
                                        <#elseif fyearMonth?substring(4,6)?number==10>
                                            <#if (fyearMonth?substring(6)?number>25)>
                                                <span class="calendarIcon" style="position: absolute;top: 70px;right: 42px;"><li class="fa fa-calendar"> ${fyearMonth?substring(0,4)}0926~${fyearMonth?substring(4)}</li></span>
                                            <#else>
                                                <span class="calendarIcon" style="position: absolute;top: 70px;right: 42px;"><li class="fa fa-calendar"> ${fyearMonth?substring(0,4)}0926~${fyearMonth?substring(4)}</li></span>
                                            </#if>
                                        <#else >
                                            <#if (fyearMonth?substring(6)?number>25)>
                                                <span class="calendarIcon" style="position: absolute;top: 70px;right: 42px;"><li class="fa fa-calendar"> ${fyearMonth?substring(0,5)}${fyearMonth?substring(5,6)}26~${fyearMonth?substring(4)}</li></span>
                                            <#else>
                                                <span class="calendarIcon" style="position: absolute;top: 70px;right: 42px;"><li class="fa fa-calendar"> ${fyearMonth?substring(0,5)}${fyearMonth?substring(5,6)?number-1}26~${fyearMonth?substring(4)}</li></span>
                                            </#if>
                                        </#if>
                                        </div>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-speedometer"></i>
                                    </div>
                                    <a target="navTab"
                                       href="${ctx}/report/groupReport/milkYieldDetail?companyNumber=${companyNumber}"
                                       data-title="生鲜奶产量明细" class="small-box-footer">查看明细<i
                                            class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <#--<div class="col-md-2 col-sm-6">-->
                                <#--<!-- small box &ndash;&gt;-->
                                <#--<div class="small-box bg-orange">-->
                                    <#--<div class="inner">-->
                                        <#--<h3>-->
                                        <#--<#assign CRNTS = 0>-->
                                        <#--<#assign yearMonth = "">-->
                                        <#--<#list crnts?keys as key>-->
                                            <#--<#if key=="NQJG-MT-MRN">-->
                                                <#--<#assign CRNTS = crnts[key]>-->
                                            <#--<#else>-->
                                                <#--<#assign yearMonth = crnts[key]>-->
                                            <#--</#if>-->
                                        <#--</#list>-->
                                        <#--${CRNTS?floor}-->
                                            <#--<sup style="font-size: 20px">头</sup></h3>-->
                                        <#--<div>成乳牛<span class="calendarIcon position"style="position: absolute;top: 70px;right: 76px;"><li class="fa fa-calendar"></li> ${yearMonth}</span></div>-->
                                    <#--</div>-->
                                    <#--<div class="icon">-->
                                        <#--<i class="ion ion-speedometer"></i>-->
                                    <#--</div>-->
                                    <#--<a target="navTab" href="${ctx}/report/groupReport/cattleDetail?companyNumber=${companyNumber}"-->
                                       <#--data-title="牛群结构明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>-->
                                <#--</div>-->
                            <#--</div>-->
                        </div>
                        <div class="chart tab-pane active" id="sales-chart" >
                            <div class="col-md-2 col-sm-6">
                                <!-- small box -->
                                <div class="small-box bg-aqua">
                                    <div class="inner">
                                        <h3>
                                        <#assign ZCZE = 0>
                                        <#assign yearMonth = "">
                                        <#list zcze?keys as key>
                                            <#if key=="ZHZB-ZCZE-WY">
                                                <#assign ZCZE = zcze[key]>
                                            <#else>
                                                <#assign yearMonth = zcze[key]>
                                            </#if>
                                        </#list>
                                        ${ZCZE?floor}
                                            <sup style="font-size: 20px">万</sup>
                                        </h3>
                                        <div>资产总额<span class="calendarIcon position"><li class="fa fa-calendar"></li> ${yearMonth}</span></div>

                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-social-bitcoin-outline"></i>
                                    </div>
                                    <a target="navTab"
                                       href="${ctx}/report/groupReport/totalAssetsDetail?companyNumber=${companyNumber}"
                                       data-title="资产总额明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-md-2 col-sm-6">
                                <!-- small box -->
                                <div class="small-box bg-green">
                                    <div class="inner">
                                        <h3>
                                        <#assign YYSR = 0>
                                        <#assign yearMonth = "">
                                        <#list yysr?keys as key>
                                            <#if key=="ZHZB-YYSR-WY">
                                                <#assign YYSR = yysr[key]>
                                            <#else>
                                                <#assign yearMonth = yysr[key]>
                                            </#if>
                                        </#list>
                                        ${YYSR?floor}
                                            <sup style="font-size: 20px">万</sup></h3>
                                        <div>营业收入<span class="calendarIcon position"><li class="fa fa-calendar"></li> ${yearMonth}</span></div>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-arrow-graph-up-right"></i>
                                    </div>
                                    <a target="navTab"
                                       href="${ctx}/report/groupReport/businessIncomeDetail?companyNumber=${companyNumber}"
                                       data-title="营业收入明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-md-2 col-sm-6">
                                <!-- small box -->
                                <div class="small-box bg-red">
                                    <div class="inner">
                                        <h3>
                                        <#assign RZPXL = 0>
                                        <#assign yearMonth = "">
                                        <#list rzpxl?keys as key>
                                            <#if key=="ZHZB-RZPXL-QK">
                                                <#assign RZPXL = rzpxl[key]>
                                            <#else>
                                                <#assign yearMonth = rzpxl[key]>
                                            </#if>
                                        </#list>
                                        ${RZPXL?floor}
                                            <sup style="font-size: 20px">吨</sup></h3>
                                        <div>乳制品销量<span class="calendarIcon position"><li class="fa fa-calendar"></li> ${yearMonth}</span></div>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-checkmark"></i>
                                    </div>
                                    <a target="navTab"
                                       href="${ctx}/report/groupReport/dairySalesDetail?companyNumber=${companyNumber}"
                                       data-title="乳制品销售明细" class="small-box-footer">查看明细<i
                                            class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-md-2 col-sm-6">
                                <!-- small box -->
                                <div class="small-box bg-primary">
                                    <div class="inner">
                                        <h3>
                                        <#assign YSZK = 0>
                                        <#assign yearMonth = "">
                                        <#list yszk?keys as key>
                                            <#if key=="ZHZB-YSZK-WY-QM">
                                                <#assign YSZK = yszk[key]>
                                            <#else>
                                                <#assign yearMonth = yszk[key]>
                                            </#if>
                                        </#list>
                                        ${YSZK?floor}
                                            <sup style="font-size: 20px">万</sup></h3>
                                        <div>应收账款<span class="calendarIcon position"><li class="fa fa-calendar"></li> ${yearMonth}</span></div>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-speedometer"></i>
                                    </div>
                                    <a target="navTab"
                                       href="${ctx}/report/groupReport/accountsReceivableDetail?companyNumber=${companyNumber}"
                                       data-title="应收账款明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-md-2 col-sm-6">
                                <!-- small box -->
                                <div class="small-box bg-teal">
                                    <div class="inner">
                                        <h3>
                                        <#assign SXNCL = 0>
                                        <#assign yearMonth = "">
                                        <#list sxncl?keys as key>
                                            <#if key=="PJRCNL-QN">
                                                <#assign SXNCL = sxncl[key]/1000>
                                            <#else>
                                                <#assign yearMonth = sxncl[key]>
                                            </#if>
                                        </#list>
                                        ${SXNCL?floor}
                                            <sup style="font-size: 20px">吨</sup></h3>
                                        <div>生鲜奶产量<span class="calendarIcon position"><li class="fa fa-calendar"></li> ${yearMonth}</span></div>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-speedometer"></i>
                                    </div>
                                    <a target="navTab"
                                       href="${ctx}/report/groupReport/milkYieldDetail?companyNumber=${companyNumber}"
                                       data-title="生鲜奶产量明细" class="small-box-footer">查看明细<i
                                            class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-md-2 col-sm-6">
                                <!-- small box -->
                                <div class="small-box bg-orange">
                                    <div class="inner">
                                        <h3>
                                        <#assign CRNTS = 0>
                                        <#assign yearMonth = "">
                                        <#list crnts?keys as key>
                                            <#if key=="NQJG-MT-MRN">
                                                <#assign CRNTS = crnts[key]>
                                            <#else>
                                                <#assign yearMonth = crnts[key]>
                                            </#if>
                                        </#list>
                                        ${CRNTS?floor}
                                            <sup style="font-size: 20px">头</sup></h3>
                                        <div>成乳牛<span class="calendarIcon position"><li class="fa fa-calendar"></li> ${yearMonth}</span></div>
                                    </div>
                                    <div class="icon">
                                        <i class="ion ion-speedometer"></i>
                                    </div>
                                    <a target="navTab" href="${ctx}/report/groupReport/cattleDetail?companyNumber=${companyNumber}"
                                       data-title="牛群结构明细" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>





            </div>
            <div class="row">
                <div class="col-md-8">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">市场分布</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i></button>
                            </div>
                            <div class="box-tools" style="right:40px;" id="choice">
                                <button id="dayDate" class="btn btn-info btn-sm">日</button>
                                <button id="monthDate" class="btn btn-info btn-sm">月</button>
                                <button id="seasonDate" class="btn btn-info btn-sm">季</button>
                                <button id="totalDate" class="btn btn-info btn-sm">累计</button>
                                <input id="mapDate" type="text" style="width: 100px;height: ">
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <div class="row">
                                <div class="col-md-10 col-sm-8">
                                    <div class="group_map" style="width: 100%; height: 400px;"></div>
                                </div>
                                <div class="col-md-2 col-md-4">
                                    <div class="pad box-pane-right" style="min-height: 280px;padding: 0px">
                                        <div class="description-block border-right">
                                            <span id="ratioTY" class="description-percentage "></span>
                                            <h6 id="currentTY" class="description-header" style="font-size: 12px;"></h6>
                                            <span class="description-text">天友乳业</span><br>
                                        </div>
                                        <div class="description-block border-right" style="margin-top: 50px;">
                                            <span id="ratioHSM" class="description-percentage "></span>
                                            <h6 id="currentHSM" class="description-header"
                                                style="font-size: 12px;"></h6>
                                            <span class="description-text">华山牧乳业</span><br>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">营收分析</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i></button>
                            </div>
                            <div class="box-tools" style="right:40px;" id="choices">
                                <button id="securityTime" class="btn btn-info btn-sm">月</button>
                                <button id="security" class="btn btn-info btn-sm">季</button>
                                <button id="sum" class="btn btn-info btn-sm">累计</button>
                                <input id="mapDates" type="text" style="width: 65px;">
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <div style="height: 400px; width: 100%">
                                <table id="example2" class="table table-striped" style="font-size: 12px;">
                                    <tbody>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <#--<div class="row">-->
                <#--<div class="col-md-12">-->
                    <#--<div class="box box-info">-->
                        <#--<div class="box-header with-border">-->
                            <#--<h3 class="box-title">对比分析</h3>-->
                            <#--<div class="box-tools pull-right">-->
                                <#--<button type="button" class="btn btn-box-tool" data-widget="collapse"><i-->
                                        <#--class="fa fa-minus"></i></button>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="box-body no-padding">-->
                            <#--<div class="row">-->
                                <#--<div class="col-md-6">-->
                                <#--&lt;#&ndash;财务评价指标对比&ndash;&gt;-->
                                    <#--<div id="finance_div" style="width: 100%; height: 350px;"></div>-->
                                <#--</div>-->
                                <#--<div class="col-md-6"-->
                                     <#--style="border-left-style: dashed; border-left-width: thin;border-left-color: #cccccc;">-->
                                <#--&lt;#&ndash;产品全成本对比&ndash;&gt;-->
                                    <#--<div id="cost_comparison_div" style="width: 100%; height: 350px;"></div>-->
                                <#--</div>-->
                            <#--</div>-->
                            <#--<div class="row">-->
                                <#--<div class="col-md-6">-->
                                <#--&lt;#&ndash;期间费用率&ndash;&gt;-->
                                    <#--<div id="period_comp_div" style="width: 100%; height: 1px;"></div>-->
                                <#--</div>-->
                                <#--<div class="col-md-6">-->
                                <#--&lt;#&ndash;牛奶全成本对比&ndash;&gt;-->
                                    <#--<div id="milk_cost_comp_div" style="width: 100%; height: 1px;"></div>-->
                                <#--</div>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        </section>
    </div>
</div>

<@jsFile/>
<script type="text/javascript">


    //地图时间
    $('#mapDate').datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: true,
        startView: 1,
        maxViewMode: 1,
        minViewMode: 1
    }).on('changeDate', function () {
        mapReport($("#mapDate").val());
    });

    $('#mapDates').datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: true,
        startView: 1,
        maxViewMode: 1,
        minViewMode: 1
    }).on('changeDate', function () {
        businessIncomeDetail($("#mapDates").val());
    });


    $(function () {

        //点击地图按日查询按钮
        $("#dayDate").click(function () {
            $("#mapDate").remove();
            $("#choice").append("<input id=\"mapDate\" type=\"text\" style=\"width: 100px;\">");
            $.fn.datepicker.dates['zh-CN'] = {
                days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
                daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
                daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
                months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                today: "今日",
                format: "yyyy年mm月dd日",
                weekStart: 1
            };
            $('#mapDate').datepicker({
                language: 'zh-CN',
                format: 'yyyymmdd',
                autoclose: true,
                todayHighlight: true
            }).on('changeDate', function () {
                mapReport($("#mapDate").val());
            });
            $('#mapDate').datepicker( 'setDate' , '-1d' );
        });


        //点击地图按月查询按钮
        $("#monthDate").click(function () {
            $("#mapDate").remove();
            $("#choice").append("<input id=\"mapDate\" type=\"text\" style=\"width: 100px;\">");
            $.fn.datepicker.dates['zh-CN'] = {
                days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
                daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
                daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
                months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                today: "今日",
                format: "yyyy年mm月dd日",
                weekStart: 1
            };
            $('#mapDate').datepicker({
                language: 'zh-CN',
                format: 'yyyymm',
                autoclose: true,
                todayHighlight: true,
                startView: 1,
                maxViewMode: 1,
                minViewMode: 1
            }).on('changeDate', function () {
                mapReport($("#mapDate").val());
            });
            $('#mapDate').datepicker( 'setDate' , '-1m' );
        });


        $("#seasonDate").click(function () {
            $("#mapDate").remove();
            $("#choice").append("<input id=\"mapDate\" type=\"text\" style=\"width: 100px;\">");

            $.fn.datepicker.dates['zh-CN'] = {
                days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
                daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
                daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
                months: ["Q1", "Q2", "Q3", "Q4", "", "", "", "", "", "", "", ""],
                monthsShort: ["一季度", "二季度", "三季度", "四季度", "", "", "", "", "", "", "", ""],
                clear: "清除",
                meridiem: ["上午", "下午"],
                today: "今日",
                format: "yyyy年mm月dd日",
                weekStart: 1
            };

            $('#mapDate').datepicker({
                language: 'zh-CN',
                format: 'yyyyMM',
                autoclose: true,
                todayHighlight: true,
                startView: 1,
                maxViewMode: 1,
                minViewMode: 1
            }).on('changeDate', function () {
                mapReport($("#mapDate").val());
            });
            var date = new Date();
            var num;
            switch (date.getMonth()){
                case 1:
                    num = 0;
                    break;
                case 2:
                    num = 1;
                    break;
                case 3:
                    num = 2;
                    break;
                case 4:
                    num = 2;
                    break;
                case 5:
                    num = 3;
                    break;
                case 6:
                    num = 4;
                    break;
                case 7:
                    num = 4;
                    break;
                case 8:
                    num = 5;
                    break;
                case 9:
                    num = 6;
                    break;
                case 10:
                    num = 6;
                    break;
                case 11:
                    num = 7;
                    break;
                case 12:
                    num = 8;
                    break;
            };
            $('#mapDate').datepicker( 'setDate' , '-'+num+'m' );
        });
        //点击地图按累计查询按钮
        $("#totalDate").click(function () {
            $("#mapDate").remove();
            mapReport('');
        });
    });
    $(function () {


        //点击地图按月查询按钮
        $("#securityTime").click(function () {
            $("#mapDates").remove();
            $("#choices").append("<input id=\"mapDates\" type=\"text\" style=\"width: 100px;\">");
            $.fn.datepicker.dates['zh-CN'] = {
                days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
                daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
                daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
                months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                today: "今日",
                format: "yyyy年mm月dd日",
                weekStart: 1
            };
            $('#mapDates').datepicker({
                language: 'zh-CN',
                format: 'yyyymm',
                autoclose: true,
                todayHighlight: true,
                startView: 1,
                maxViewMode: 1,
                minViewMode: 1
            }).on('changeDate', function () {
                businessIncomeDetail($("#mapDates").val());
            });
            $('#mapDates').datepicker( 'setDate' , '-1m' );
        });


        $("#security").click(function () {
            $("#mapDates").remove();
            $("#choices").append("<input id=\"mapDates\" type=\"text\" style=\"width: 100px;\">");

            $.fn.datepicker.dates['zh-CN'] = {
                days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
                daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
                daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
                months: ["Q1", "Q2", "Q3", "Q4", "", "", "", "", "", "", "", ""],
                monthsShort: ["一季度", "二季度", "三季度", "四季度", "", "", "", "", "", "", "", ""],
                clear: "清除",
                meridiem: ["上午", "下午"],
                today: "今日",
                format: "yyyy年mm月dd日",
                weekStart: 1
            };

            $('#mapDates').datepicker({
                language: 'zh-CN',
                format: 'yyyyMM',
                autoclose: true,
                todayHighlight: true,
                startView: 1,
                maxViewMode: 1,
                minViewMode: 1
            }).on('changeDate', function () {
                businessIncome($("#mapDates").val());
            });
            var date = new Date();
            var num;
            switch (date.getMonth()){
                case 1:
                    num = 0;
                    break;
                case 2:
                    num = 1;
                    break;
                case 3:
                    num = 2;
                    break;
                case 4:
                    num = 2;
                    break;
                case 5:
                    num = 3;
                    break;
                case 6:
                    num = 4;
                    break;
                case 7:
                    num = 4;
                    break;
                case 8:
                    num = 5;
                    break;
                case 9:
                    num = 6;
                    break;
                case 10:
                    num = 6;
                    break;
                case 11:
                    num = 7;
                    break;
                case 12:
                    num = 8;
                    break;
            }
            $('#mapDates').datepicker( 'setDate' , '-'+num+'m' );
        });
        //点击累计查询按钮
        $("#sum").click(function () {
            $("#mapDates").remove();
            businessIncomesum();
        });
    });

    $(function () {
        $('#mapDate').datepicker('setDate', '-1m');//地图时间初始化
        $('#mapDates').datepicker('setDate', '-1m');//地图时间初始化
    });
    function businessIncomeDetail(yearMonth) {
        $.ajax({
            url: "${ctx}/admin/businessIncomeDetailAjax?companyNumber=${companyNumber}&yearMonth=" + yearMonth,
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

    function businessIncomesum() {
        $.ajax({
            url: "${ctx}/admin/businessIncomesum?companyNumber=${companyNumber}",
            type: "get",
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                businesssum(jsonObj);
            },
            error: function () {
                console.log('错误');
            }
        });
    }

    function businessIncome(security) {
        $.ajax({
            url: "${ctx}/admin/businessIncomeAjax?companyNumber=${companyNumber}&security=" + security,
            type: "get",
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                business(jsonObj);
            },
            error: function () {
                console.log('错误');
            }
        });
    }

    function business(result) {
        console.log(result);
        $("#example2").empty();
        var hsmcys = 0;
        var hsmchb = 0;
        var hsmctb = 0;
        var hsmcwc = 0;

        var tyryys = 0;
        var tyryhb = 0;
        var tyrytb = 0;
        var tyrywc = 0;

        var zkgylys = 0;
        var zkgylhb = 0;
        var zkgyltb = 0;
        var zkgylwc = 0;

        var tnmcys = 0;
        var tnmchb = 0;
        var tnmctb = 0;
        var tnmcwc = 0;

        var hsmryys = 0;
        var hsmryhb = 0;
        var hsmrytb = 0;
        var hsmrywc = 0;

        var thmyys = 0;
        var thmyhb = 0;
        var thmytb = 0;
        var thmywc = 0;
        $("#example2").append("<tr>" +"<th>"+"公司"+"</th>"+"<th>"+"营收"+"</th>"+"<th>"+"完成率"+"</th>"+"<th>"+"环比"+"</th>"+"<th>"+"同比"+"</th>"+"</tr>");
        for(var key in result) {

            if(key!='中垦虚拟组织') {
                var row = "<tr>";
                row = row + "<td>" + key + "</td>";
                if (key == '华山牧场') {
                    hsmcys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + hsmcys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        hsmcwc = hsmcys/ result[key]['byys'] * 100;
                    }
                    if (result[key]['sysj'] > 0) {
                        hsmchb = (hsmcys - result[key]['sysj']) / result[key]['sysj'] * 100;
                    } else if (result[key]['sysj'] < 0) {
                        hsmchb = (1 - hsmcys / result[key]['sysj']) * 100;
                    }
                    if (result[key]['bqsn'] > 0) {
                        hsmctb = (hsmcys - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        hsmctb = (1 - hsmcys / result[key]['bqsn']) * 100;
                    }
//                    console.log(hsmcwc);
                    if (hsmcwc>100) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    }else if (0 < hsmcwc) {
                        console.log(result[key]['byys']);
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-down\"></i>" + hsmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                    else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if ((hsmcys - result[key]['sysj']) > 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((hsmcys - result[key]['sysj']) == 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((hsmcys - result[key]['sysj']) < 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if (hsmctb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmctb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmctb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                }
                if (key == '中垦供应链') {
                    zkgylys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + zkgylys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        zkgylwc = zkgylys/ result[key]['byys'] * 100;
                    }
                    if (result[key]['sysj'] > 0) {
                        zkgylhb = (zkgylys - result[key]['sysj']) / result[key]['sysj'] * 100;
                    } else if (result[key]['sysj'] < 0) {
                        zkgylhb = (1 - zkgylys / result[key]['sysj']) * 100;
                    }
                    if (result[key]['bqsn'] > 0) {
                        zkgyltb = (zkgylys - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        zkgyltb = (1 - zkgylys / result[key]['bqsn']) * 100;
                    }

                    if (zkgylwc>100) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + zkgylwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (0<zkgylwc) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + zkgylwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + zkgylwc.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if ((zkgylys - result[key]['sysj']) > 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + zkgylhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((zkgylys - result[key]['sysj']) == 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + zkgylhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((zkgylys - result[key]['sysj']) < 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + zkgylhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + zkgylhb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if (zkgyltb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + zkgyltb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (zkgyltb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + zkgyltb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (zkgyltb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + zkgyltb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + zkgyltb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                }
                if (key == '天友乳业') {
                    tyryys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + tyryys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        tyrywc = tyryys/ result[key]['byys'] * 100;
                    }
                    if (result[key]['sysj'] > 0) {
                        tyryhb = (tyryys - result[key]['sysj']) / result[key]['sysj'] * 100;
                    } else if (result[key]['sysj'] < 0) {
                        tyryhb = (1 - tyryys / result[key]['sysj']) * 100;
                    }
                    if (result[key]['bqsn'] > 0) {
                        tyrytb = (tyryys - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        tyrytb = (1 - tyryys / result[key]['bqsn']) * 100;
                    }

                    if (tyrywc>100) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tyrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (0<tyrywc) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tyrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tyrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if ((tyryys - result[key]['sysj']) > 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tyryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((tyryys - result[key]['sysj']) == 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tyryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((tyryys - result[key]['sysj']) < 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tyryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tyryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if (tyrytb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tyrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tyrytb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tyrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tyrytb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tyrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tyrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                }
                if (key == '天宁牧场') {
                    tnmcys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + tnmcys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        tnmcwc = tnmcys/ result[key]['byys'] * 100;
                    }
                    if (result[key]['sysj'] > 0) {
                        tnmchb = (tnmcys - result[key]['sysj']) / result[key]['sysj'] * 100;
                    } else if (result[key]['sysj'] < 0) {
                        tnmchb = (1 - tnmcys / result[key]['sysj']) * 100;
                    }
                    if (result[key]['bqsn'] > 0) {
                        tnmctb = (tnmcys - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        tnmctb = (1 - tnmcys / result[key]['bqsn']) * 100;
                    }

                    if (tnmcwc>100) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tnmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (0<tnmcwc) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tnmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tnmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if ((tnmcys - result[key]['sysj']) > 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tnmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((tnmcys - result[key]['sysj']) == 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tnmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((tnmcys - result[key]['sysj']) < 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tnmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tnmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if (tnmctb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tnmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tnmctb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tnmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tnmctb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tnmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tnmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (key == '华山牧乳业') {
                    hsmryys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + hsmryys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        hsmrywc = hsmryys/ result[key]['byys'] * 100;
                    }
                    if (result[key]['sysj'] > 0) {
                        hsmryhb = (hsmryys - result[key]['sysj']) / result[key]['sysj'] * 100;
                    } else if (result[key]['sysj'] < 0) {
                        hsmryhb = (1 - hsmryys / result[key]['sysj']) * 100;
                    }
                    if (result[key]['bqsn'] > 0) {
                        hsmrytb = (hsmryys - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        hsmrytb = (1 - hsmryys / result[key]['bqsn']) * 100;
                    }

                    if (hsmrywc>100) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (0<hsmrywc) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if ((hsmryys - result[key]['sysj']) > 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((hsmryys - result[key]['sysj']) == 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((hsmryys- result[key]['sysj']) < 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if (hsmrytb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmrytb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmrytb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (key == '天鸿牧业') {
                    thmyys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + thmyys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        thmywc = thmyys/ result[key]['byys'] * 100;
                    }
                    if (result[key]['sysj'] > 0) {
                        thmyhb = (thmyys - result[key]['sysj']) / result[key]['sysj'] * 100;
                    } else if (result[key]['sysj'] < 0) {
                        thmyhb = (1 - thmyys / result[key]['sysj']) * 100;
                    }
                    if (result[key]['bqsn'] > 0) {
                        thmytb = (thmyys - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        thmytb = (1 - thmyys / result[key]['bqsn']) * 100;
                    }

                    if (thmywc>100) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + thmywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (0<thmywc) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + thmywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + thmywc.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if ((thmyys - result[key]['sysj']) > 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + thmyhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((thmyys - result[key]['sysj']) == 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + thmyhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((thmyys - result[key]['sysj']) < 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + thmyhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + thmyhb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if (thmytb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + thmytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (thmytb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + thmytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (thmytb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + thmytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + thmytb.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                $("#example2").append(row + "</tr>");
            }
        }

    }


    function businesssum(result) {
        $("#example2").empty();
        var hsmcys = 0;
        var hsmctb = 0;
        var hsmcwc = 0;

        var tyryys = 0;
        var tyrytb = 0;
        var tyrywc = 0;

        var zkgylys = 0;
        var zkgyltb = 0;
        var zkgylwc = 0;

        var tnmcys = 0;
        var tnmctb = 0;
        var tnmcwc = 0;

        var hsmryys = 0;
        var hsmrytb = 0;
        var hsmrywc = 0;

        var thmyys = 0;
        var thmytb = 0;
        var thmywc = 0;
        $("#example2").append("<tr>" +"<th>"+"公司"+"</th>"+"<th>"+"营收"+"</th>"+"<th>"+"完成率"+"</th>"+"<th>"+"同比"+"</th>"+"</tr>");
        for(var key in result) {

            if(key!='中垦虚拟组织') {
                var row = "<tr>";
                row = row + "<td>" + key + "</td>";
                if (key == '华山牧场') {
                    hsmcys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + hsmcys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        hsmcwc = hsmcys/ result[key]['byys'] * 100;
                    }

                    if (result[key]['bqsn'] > 0) {
                        hsmctb = (hsmcys - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        hsmctb = (1 - hsmcys / result[key]['bqsn']) * 100;
                    }

                    if (hsmcwc>100) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (0<hsmcwc) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    }


                    if (hsmctb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmctb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmctb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                }
                if (key == '中垦供应链') {
                    zkgylys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + zkgylys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        zkgylwc = zkgylys/ result[key]['byys'] * 100;
                    }

                    if (result[key]['bqsn'] > 0) {
                        zkgyltb = (zkgylys - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        zkgyltb = (1 - zkgylys / result[key]['bqsn']) * 100;
                    }

                    if (zkgylwc>100) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + zkgylwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (0<zkgylwc) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + zkgylwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + zkgylwc.toFixed(2) + "%" + "</span>" + "</td>";
                    }



                    if (zkgyltb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + zkgyltb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (zkgyltb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + zkgyltb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (zkgyltb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + zkgyltb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + zkgyltb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                }
                if (key == '天友乳业') {
                    tyryys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + tyryys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        tyrywc = tyryys/ result[key]['byys'] * 100;
                    }

                    if (result[key]['bqsn'] > 0) {
                        tyrytb = (tyryys - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        tyrytb = (1 - tyryys / result[key]['bqsn']) * 100;
                    }

                    if (tyrywc>100) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tyrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (0<tyrywc) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tyrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tyrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    }



                    if (tyrytb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tyrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tyrytb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tyrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tyrytb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tyrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tyrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                }
                if (key == '天宁牧场') {
                    tnmcys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + tnmcys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        tnmcwc = tnmcys/ result[key]['byys'] * 100;
                    }

                    if (result[key]['bqsn'] > 0) {
                        tnmctb = (tnmcys - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        tnmctb = (1 - tnmcys / result[key]['bqsn']) * 100;
                    }

                    if (tnmcwc>100) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tnmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (0<tnmcwc) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tnmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tnmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    }



                    if (tnmctb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tnmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tnmctb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tnmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tnmctb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tnmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tnmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (key == '华山牧乳业') {
                    hsmryys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + hsmryys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        hsmrywc = hsmryys/ result[key]['byys'] * 100;
                    }

                    if (result[key]['bqsn'] > 0) {
                        hsmrytb = (hsmryys - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        hsmrytb = (1 - hsmryys / result[key]['bqsn']) * 100;
                    }

                    if (hsmrywc>100) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (0<hsmrywc) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    }



                    if (hsmrytb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmrytb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmrytb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (key == '天鸿牧业') {
                    thmyys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + thmyys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['sysj'] != undefined) {
                        thmywc = thmyys/ result[key]['byys'] * 100;
                    }

                    if (result[key]['bqsn'] > 0) {
                        thmytb = (thmyys - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        thmytb = (1 - thmyys / result[key]['bqsn']) * 100;
                    }

                    if (thmywc>100) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + thmywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (0<thmywc) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + thmywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + thmywc.toFixed(2) + "%" + "</span>" + "</td>";
                    }



                    if (thmytb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + thmytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (thmytb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + thmytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (thmytb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + thmytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + thmytb.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                $("#example2").append(row + "</tr>");
            }
        }

    }

    function Areachart(result) {
        console.log(result);
        $("#example2").empty();
        $("#mapDates").remove();
        $("#choices").append("<input id=\"mapDates\" type=\"text\" style=\"width: 100px;\">");

        $('#mapDates').datepicker({
            language: 'zh-CN',
            format: 'yyyymm',
            autoclose: true,
            todayHighlight: true,
            startView: 1,
            maxViewMode: 1,
            minViewMode: 1
        }).on('changeDate', function () {
            businessIncomeDetail($("#mapDates").val());
        });
        $("#mapDates").val(result['yearMonth']);
//        $(function () {
//            $('#mapDates').datepicker('setDate', '-1m');//时间初始化
//        });


        var hsmcys = 0;
        var hsmchb = 0;
        var hsmctb = 0;
        var hsmcwc = 0;

        var tyryys = 0;
        var tyryhb = 0;
        var tyrytb = 0;
        var tyrywc = 0;

        var zkgylys = 0;
        var zkgylhb = 0;
        var zkgyltb = 0;
        var zkgylwc = 0;

        var tnmcys = 0;
        var tnmchb = 0;
        var tnmctb = 0;
        var tnmcwc = 0;

        var hsmryys = 0;
        var hsmryhb = 0;
        var hsmrytb = 0;
        var hsmrywc = 0;

        var thmyys = 0;
        var thmyhb = 0;
        var thmytb = 0;
        var thmywc = 0;



        $("#example2").append("<tr>" +"<th>"+"公司"+"</th>"+"<th>"+"营收"+"</th>"+"<th>"+"完成率"+"</th>"+"<th>"+"环比"+"</th>"+"<th>"+"同比"+"</th>"+"</tr>");
        for(var key in result) {

            if(key!='中垦虚拟组织'&&key!='yearMonth') {
                var row = "<tr>";
                row = row + "<td>" + key + "</td>";
                if (key == '华山牧场') {
                    hsmcys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + hsmcys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        hsmcwc = result[key]['dysj']/ result[key]['byys'] * 100;
                    }
                    if (result[key]['sysj'] > 0) {
                        hsmchb = (result[key]['dysj'] - result[key]['sysj']) / result[key]['sysj'] * 100;
                    } else if (result[key]['sysj'] < 0) {
                        hsmchb = (1 - result[key]['dysj'] / result[key]['sysj']) * 100;
                    }
                    if (result[key]['bqsn'] > 0) {
                        hsmctb = (result[key]['dysj'] - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        hsmctb = (1 - result[key]['dysj'] / result[key]['bqsn']) * 100;
                    }

                    if (hsmcwc>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmcwc<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if ((result[key]['dysj'] - result[key]['sysj']) > 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((result[key]['dysj'] - result[key]['sysj']) == 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((result[key]['dysj'] - result[key]['sysj']) < 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if (hsmctb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmctb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmctb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                }
                if (key == '中垦供应链') {
                    zkgylys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + zkgylys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        zkgylwc = result[key]['dysj']/ result[key]['byys'] * 100;
                    }
                    if (result[key]['sysj'] > 0) {
                        zkgylhb = (result[key]['dysj'] - result[key]['sysj']) / result[key]['sysj'] * 100;
                    } else if (result[key]['sysj'] < 0) {
                        zkgylhb = (1 - result[key]['dysj'] / result[key]['sysj']) * 100;
                    }
                    if (result[key]['bqsn'] > 0) {
                        zkgyltb = (result[key]['dysj'] - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        zkgyltb = (1 - result[key]['dysj'] / result[key]['bqsn']) * 100;
                    }

                    if (zkgylwc>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + zkgylwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (zkgylwc<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + zkgylwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + zkgylwc.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if ((result[key]['dysj'] - result[key]['sysj']) > 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + zkgylhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((result[key]['dysj'] - result[key]['sysj']) == 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + zkgylhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((result[key]['dysj'] - result[key]['sysj']) < 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + zkgylhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + zkgylhb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if (zkgyltb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + zkgyltb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (zkgyltb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + zkgyltb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (zkgyltb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + zkgyltb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + zkgyltb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                }
                if (key == '天友乳业') {
                    tyryys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + tyryys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        tyrywc = result[key]['dysj']/ result[key]['byys'] * 100;
                    }
                    if (result[key]['sysj'] > 0) {
                        tyryhb = (result[key]['dysj'] - result[key]['sysj']) / result[key]['sysj'] * 100;
                    } else if (result[key]['sysj'] < 0) {
                        tyryhb = (1 - result[key]['dysj'] / result[key]['sysj']) * 100;
                    }
                    if (result[key]['bqsn'] > 0) {
                        tyrytb = (result[key]['dysj'] - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        tyrytb = (1 - result[key]['dysj'] / result[key]['bqsn']) * 100;
                    }

                    if (tyrywc>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tyrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tyrywc<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tyrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tyrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if ((result[key]['dysj'] - result[key]['sysj']) > 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tyryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((result[key]['dysj'] - result[key]['sysj']) == 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tyryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((result[key]['dysj'] - result[key]['sysj']) < 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tyryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tyryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if (tyrytb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tyrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tyrytb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tyrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tyrytb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tyrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tyrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                }
                if (key == '天宁牧场') {
                    tnmcys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + tnmcys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        tnmcwc = tnmcys/ result[key]['byys'] * 100;
                    }
                    if (result[key]['sysj'] > 0) {
                        tnmchb = (result[key]['dysj'] - result[key]['sysj']) / result[key]['sysj'] * 100;
                    } else if (result[key]['sysj'] < 0) {
                        tnmchb = (1 - result[key]['dysj'] / result[key]['sysj']) * 100;
                    }
                    if (result[key]['bqsn'] > 0) {
                        tnmctb = (result[key]['dysj'] - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        tnmctb = (1 - result[key]['dysj'] / result[key]['bqsn']) * 100;
                    }

                    if (tnmcwc>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tnmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tnmcwc<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tnmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tnmcwc.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if ((result[key]['dysj'] - result[key]['sysj']) > 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tnmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((result[key]['dysj'] - result[key]['sysj']) == 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tnmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((result[key]['dysj'] - result[key]['sysj']) < 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tnmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tnmchb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if (tnmctb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + tnmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tnmctb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tnmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (tnmctb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + tnmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + tnmctb.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (key == '华山牧乳业') {
                    hsmryys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + hsmryys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        hsmrywc = hsmryys/ result[key]['byys'] * 100;
                    }
                    if (result[key]['sysj'] > 0) {
                        hsmryhb = (result[key]['dysj'] - result[key]['sysj']) / result[key]['sysj'] * 100;
                    } else if (result[key]['sysj'] < 0) {
                        hsmryhb = (1 - result[key]['dysj'] / result[key]['sysj']) * 100;
                    }
                    if (result[key]['bqsn'] > 0) {
                        hsmrytb = (result[key]['dysj'] - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        hsmrytb = (1 - result[key]['dysj'] / result[key]['bqsn']) * 100;
                    }

                    if (hsmrywc>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmrywc<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmrywc.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if ((result[key]['dysj'] - result[key]['sysj']) > 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((result[key]['dysj'] - result[key]['sysj']) == 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((result[key]['dysj'] - result[key]['sysj']) < 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmryhb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if (hsmrytb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + hsmrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmrytb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (hsmrytb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + hsmrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + hsmrytb.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (key == '天鸿牧业') {
                    thmyys = result[key]['dysj']==undefined?0:Math.floor(result[key]['dysj']);
                    row = row + "<td>" + "<span class=\"label label-success\">" + thmyys + "</span>" + "</td>";
                    if (result[key]['byys'] != 0&&result[key]['byys'] != undefined) {
                        thmywc = thmyys/ result[key]['byys'] * 100;
                    }
                    if (result[key]['sysj'] > 0) {
                        thmyhb = (result[key]['dysj'] - result[key]['sysj']) / result[key]['sysj'] * 100;
                    } else if (result[key]['sysj'] < 0) {
                        thmyhb = (1 - result[key]['dysj'] / result[key]['sysj']) * 100;
                    }
                    if (result[key]['bqsn'] > 0) {
                        thmytb = (result[key]['dysj'] - result[key]['bqsn']) / result[key]['bqsn'] * 100;
                    } else if (result[key]['bqsn'] < 0) {
                        thmytb = (1 - result[key]['dysj'] / result[key]['bqsn']) * 100;
                    }

                    if (thmywc>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + thmywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (thmywc<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + thmywc.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + thmywc.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if ((result[key]['dysj'] - result[key]['sysj']) > 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + thmyhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((result[key]['dysj'] - result[key]['sysj']) == 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + thmyhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if ((result[key]['dysj'] - result[key]['sysj']) < 0 && result[key]['sysj'] != 0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + thmyhb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + thmyhb.toFixed(2) + "%" + "</span>" + "</td>";
                    }

                    if (thmytb>0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + thmytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (thmytb==0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + thmytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (thmytb<0) {
                        row = row + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + thmytb.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        row = row + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + thmytb.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                $("#example2").append(row + "</tr>");
            }
        }

    }

    /**
     * 中国地图
     */
    function mapReport(mapYearMonth) {
        $.ajax({
            url: "${ctx}/admin/groupIndexMapAjax?companyNumber=${companyNumber}&yearMonth="+mapYearMonth,
            type: "get",
            dataType: "text",
            success: function (result) {
                var jsonObj = eval("(" + result + ")");
                init(jsonObj);//加载地图
            }
        });

        function init(result) {
            var saleReport = echarts.init($('.group_map')[0], echartsTheme);
            var itemStyle = {
                normal: {
                    color: '#32cd32',
                    label: {
                        show: true,
                        textStyle: {
                            color: '#333',
                            fontSize: 15
                        }
                    }
                },
                emphasis: {                 // 也是选中样式
                    borderWidth: 1,
                    borderColor: 'yellow',
                    color: '#cd5c5c',
                    label: {
                        show: false,
                        textStyle: {
                            color: 'red'
                        }
                    }
                }
            };

            var itemStyle2 = {
                normal: {
                    color: '#605ca8',
                    label: {
                        show: true,
                        textStyle: {
                            color: '#333',
                            fontSize: 15
                        }
                    }
                },
                emphasis: {                 // 也是选中样式
                    borderWidth: 1,
                    borderColor: 'yellow',
                    color: '#cd5c5c',
                    label: {
                        show: false,
                        textStyle: {
                            color: 'red'
                        }
                    }
                }
            };
            var TYData = [];
            var HSMData = [];
            var frontTY = 0;//天友上月市场总额
            var currentTY = 0;//天友当月市场月总额
            var frontHSM = 0;//华山牧上月市场总额
            var currentHSM = 0;//华山牧当月市场总额
            for (var i = 0; i < result["TYRY"].length; i++) {
                if (result["yearMonthTY"] != result["TYRY"][i]["yearMonth"]) {
                    frontTY = result["TYRY"][i]["value"] + frontTY;
                } else {
                    var itemT = result["TYRY"][i];
                    currentTY = itemT["value"] + currentTY;
                    itemT.itemStyle = itemStyle;
                    TYData.push(itemT);
                }
            }
            for (var i = 0; i < result["HSMRY"].length; i++) {
                if (result["yearMonthHSM"] != result["HSMRY"][i]["yearMonth"]) {
                    frontHSM = result["HSMRY"][i]["value"] + frontHSM;
                } else {
                    var itemT = result["HSMRY"][i];
                    currentHSM = itemT["value"] + currentHSM;
                    itemT.itemStyle = itemStyle2;
                    HSMData.push(itemT);
                }
            }
            var maxResult = (currentTY > currentHSM)?currentTY:currentHSM;
            $("#currentTY").empty();
            $("#currentHSM").empty();
            $("#ratioTY").empty();
            $("#ratioHSM").empty();
            $("#currentTY").append("￥" + Math.round(currentTY) + " 万");
            $("#currentHSM").append("￥" + currentHSM + " 万");
            var ratioTY = 100;
            if (frontTY != 0) {
                ratioTY = (Math.abs(currentTY - frontTY) / frontTY * 100).toFixed(2);
            }
            if (currentTY - frontTY > 0) {
                $("#ratioTY").removeClass("text-yellow text-green text-red");
                $("#ratioTY").addClass("text-red");
                $("#ratioTY").append('<i class="fa fa-caret-up"></i>' + ratioTY + '%');
            } else if (currentTY - frontTY == 0) {
                $("#ratioTY").removeClass("text-yellow text-green text-red");
                $("#ratioTY").addClass("text-yellow");
                $("#ratioTY").append('<i class="fa fa-caret-left"></i>' + ratioTY + '%');
            } else {
                $("#ratioTY").removeClass("text-yellow text-green text-red");
                $("#ratioTY").addClass("text-green");
                $("#ratioTY").append('<i class="fa fa-caret-down"></i>' + ratioTY + '%');
            }
            var ratioHSM = 100;
            if (frontHSM != 0) {
                ratioHSM = (Math.abs(currentHSM - frontHSM) / frontHSM * 100).toFixed(2);
            }
            if (currentHSM - frontHSM > 0) {
                $("#ratioHSM").removeClass("text-yellow text-green text-red");
                $("#ratioHSM").addClass("text-red");
                $("#ratioHSM").append('<i class="fa fa-caret-up"></i>' + ratioHSM + '%');
            } else if (currentHSM - frontHSM == 0) {
                $("#ratioHSM").removeClass("text-yellow text-green text-red");
                $("#ratioHSM").addClass("text-yellow");
                $("#ratioHSM").append('<i class="fa fa-caret-left"></i>' + ratioHSM + '%');
            } else {
                $("#ratioHSM").removeClass("text-yellow text-green text-red");
                $("#ratioHSM").addClass("text-green");
                $("#ratioHSM").append('<i class="fa fa-caret-down"></i>' + ratioHSM + '%');
            }
            var option3 = {
                legend: {
                    x: 'left',
                    data: ['华山牧','天友']
                },
                dataRange: {
                    min: 0,
                    max: maxResult*1.2,
                    text: ['高', '低'],           // 文本，默认为数值文本
                    calculable: true,
                    x: 'left',
                    color: ['orangered', '#83C77E', 'lightskyblue']
                },
                toolbox: {
                    show: true,
                    orient: 'vertical',
                    x: 'right',
                    y: 'center',
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                tooltip: {
                    trigger: 'item',
                    formatter: function (params) {
                        var res2 = params.name + '<br/>';
                        var res = '';
                        var myseries = option3.series;
                        var total = 0;
                        for (var i = 0; i < myseries.length; i++) {
                            res += '--' + myseries[i].name;
                            for (var j = 0; j < myseries[i].data.length; j++) {
                                if (myseries[i].data[j].name == params.name) {
                                    res += ' : ' + myseries[i].data[j].value + '万<br/>';
                                    total += myseries[i].data[j].value;
                                }else {
                                    res += '<br/>';
                                }
                            }
                        }
                        return params.name + ':' + total + '万<br/>' + res;
                    }
                },
                roamController: {
                    show: true,
                    x: 'right',
                    mapTypeControl: {
                        'china': true
                    }
                },
                series: [
                    {
                        name: '华山牧',
                        type: 'map',
                        mapType: 'china',
                        roam: true,
                        layoutCenter: ['110%', '110%'],
                        selectedMode: 'multiple',
                        itemStyle: {
                            normal: {
                                borderWidth: 1,
                                borderColor: 'lightgreen',
                                areaColor: '#83C77E',
                                color: '#605ca8',
                                label: {
                                    show: false
                                }
                            },
                            emphasis: {                 // 也是选中样式
                                borderWidth: 1,
                                borderColor: '#fff',
                                color: '#001F3F',
                                label: {
                                    show: true,
                                    textStyle: {
                                        color: '#111'
                                    }
                                }
                            }
                        },
                        data: HSMData
                    },
                    {
                        name: '天友',
                        type: 'map',
                        mapType: 'china',
                        roam: true,
                        layoutCenter: ['110%', '110%'],
                        selectedMode: 'multiple',
                        itemStyle: {
                            normal: {
                                borderWidth: 1,
                                borderColor: 'lightgreen',
                                areaColor: '#83c77e',
                                color: 'orange',
                                label: {
                                    show: false
                                }
                            },
                            emphasis: {                 // 也是选中样式
                                borderWidth: 1,
                                borderColor: '#fff',
                                color: '#32cd32',
                                label: {
                                    show: true,
                                    textStyle: {
                                        color: '#111'
                                    }
                                }
                            }
                        },
                        data: TYData,
                    }
                ]
            };
            saleReport.setOption(option3);

            $(window).resize(function () {
                saleReport.resize();
            });
        }
    }


    <#--/**-->
     <#--* 成本比较-->
     <#--*/-->
    <#--function costComparisonReport() {-->
        <#--$.ajax({-->
            <#--url: "${ctx}/admin/productCostAjax?companyNumber=${companyNumber}",-->
            <#--type: "get",-->
            <#--dataType: "text",-->
            <#--success: function (result) {-->
                <#--var jsonObj = eval('(' + result + ')');-->
                <#--init(jsonObj);-->
            <#--},-->
            <#--error: function () {-->
                <#--console.log('错误');-->
            <#--}-->
        <#--});-->

        <#--function init(result) {-->
            <#--var sxAxis = [];//x轴数据-->
            <#--var seriesHS = [];//华山牧乳业数据-->
            <#--var seriesTY = [];//天友乳业数据-->
            <#--var seriesGM = [];//光明乳业数据-->
            <#--for (var i = 0; i < result['axisx'].length; i++) {-->
                <#--sxAxis.push(result['axisx'][i]);-->
                <#--seriesHS.push(Math.floor(result['HSMRY'][i]));-->
                <#--seriesTY.push(Math.floor(result['TYRY'][i]));-->
                <#--seriesGM.push(Math.floor(result['GMRY'][i]));-->
            <#--}-->
            <#--if (sxAxis[0] == null) {-->
                <#--sxAxis = ["直接材料", "直接人工", "能源动力", "制造费用", "销售费用", "管理费用", "财务费用"];-->
            <#--}-->
            <#--var option = {-->
                <#--title: {-->
                    <#--text: '产品单位成本对比',-->
                    <#--subtext: '(单位：元)',-->
                    <#--left: 'left',-->
                    <#--textStyle: {-->
                        <#--fontSize: 16-->
                    <#--}-->
                <#--},-->
                <#--calculable: true,-->
                <#--tooltip: {-->
                    <#--trigger: 'axis',-->
                    <#--axisPointer: {            // 坐标轴指示器，坐标轴触发有效-->
                        <#--type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'-->
                    <#--}-->
                <#--},-->
                <#--toolbox: {-->
                    <#--show: true,-->
                    <#--feature: {-->
                        <#--dataView: {show: true, readOnly: false},-->
                        <#--magicType: {show: true, type: ['line', 'bar']},-->
                        <#--restore: {show: true},-->
                        <#--saveAsImage: {show: true}-->
                    <#--}-->
                <#--},-->
                <#--legend: {-->
                    <#--x: 'center',-->
                    <#--data: ['华山牧乳业', '天友乳业', '光明乳业'],-->
                    <#--top:'3%'-->
                <#--},-->
                <#--grid: {-->
                    <#--left: '3%',-->
                    <#--right: '4%',-->
                    <#--bottom: '10%',-->
                    <#--containLabel: true-->
                <#--},-->
                <#--xAxis: [-->
                    <#--{-->
                        <#--type: 'category',-->
                        <#--data: sxAxis,-->
                        <#--axisLabel: {-->
                            <#--interval: 0,-->
                            <#--rotate: -20,-->
                            <#--margin: 30,-->
                            <#--textStyle: {-->
                                <#--color: '#0c180d',-->
                                <#--align: 'center'-->

                            <#--},-->
                        <#--}-->
                    <#--}-->
                <#--],-->
                <#--yAxis: [-->
                    <#--{-->
                        <#--splitArea: {show: false},-->
                        <#--type: 'value'-->
                    <#--}-->
                <#--],-->
                <#--series: [-->
                    <#--{-->
                        <#--name: '华山牧乳业',-->
                        <#--type: 'bar',-->
                        <#--data: seriesHS-->
                    <#--},-->
                    <#--{-->
                        <#--name: '天友乳业',-->
                        <#--type: 'bar',-->
                        <#--data: seriesTY-->
                    <#--},-->
                    <#--{-->
                        <#--name: '光明乳业',-->
                        <#--type: 'bar',-->
                        <#--data: seriesGM-->
                    <#--}-->
                <#--]-->
            <#--};-->
            <#--var report = echarts.init($("#cost_comparison_div")[0], echartsTheme);-->
            <#--report.setOption(option);-->
            <#--$(window).resize(function () {-->
                <#--report.resize();-->
            <#--});-->
        <#--}-->
    <#--}-->
    

    /**
     * 财务评价指标
     */
    <#--function financeReport() {-->
        <#--$.ajax({-->
            <#--url: "${ctx}/admin/financialEvaluationAjax?companyNumber=${companyNumber}",-->
            <#--type: "get",-->
            <#--dataType: "text",-->
            <#--success: function (result) {-->
                <#--var jsonObj = eval('(' + result + ')');-->
                <#--init(jsonObj);-->
            <#--},-->
            <#--error: function () {-->
                <#--console.log('错误');-->
            <#--}-->
        <#--});-->

        <#--function init(result) {-->
            <#--var sxAxis = [];//x轴数据-->
            <#--var seriesZK = [];//中垦乳业数据-->
            <#--var seriesGM = [];//光明乳业数据-->
            <#--var month = result['month'];//总的有多少个月-->
            <#--for (var i = 0; i < result['axisx'].length; i++) {-->
                <#--seriesGM.push((result['GMRY'][i] * 100).toFixed(2));-->
            <#--}-->
            <#--for (var key in result["ZKRY"]) {-->
                <#--sxAxis.push(key);-->
                <#--seriesZK.push((result["ZKRY"][key]).toFixed(2));-->
            <#--}-->
            <#--if(sxAxis[0] == null){-->
                <#--sxAxis = ["资产负债率","速动比率","流动比率","应收账款周转率","销售毛利率","营业利润率","成本费用利润率","期间费用率","资产增长率","销售增长率","利润增长率"];-->
            <#--}-->
            <#--var option = {-->
                <#--title: {-->
                    <#--text: '财务评价指标',-->
                    <#--subtext: '(单位：% / 次)',-->
                    <#--left: 'left',-->
                    <#--textStyle: {-->
                        <#--fontSize: 16-->
                    <#--}-->
                <#--},-->
                <#--toolbox: {-->
                    <#--show: true,-->
                    <#--feature: {-->
                        <#--dataView: {show: true, readOnly: false},-->
                        <#--magicType: {show: true, type: ['line', 'bar']},-->
                        <#--restore: {show: true},-->
                        <#--saveAsImage: {show: true}-->
                    <#--}-->
                <#--},-->
                <#--legend: {-->
                    <#--data: ['中垦乳业', '光明乳业'],-->
                    <#--x: 'center',-->
                    <#--top:'3%'-->
                <#--},-->
                <#--tooltip: {-->
                    <#--trigger: 'axis',-->
                    <#--axisPointer: {            // 坐标轴指示器，坐标轴触发有效-->
                        <#--type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'-->
                    <#--},-->
                    <#--formatter: function (params) {-->
                            <#--var format;-->
                            <#--if(typeof (params[1])!= "undefined"){-->
                                <#--if(params[0].name!='应收账款周转率'){-->
                                    <#--format = params[0].name+'<br/>'+params[0].seriesName+':'+params[0].value+' %'+'<br/>'+params[1].seriesName+':'+params[1].value+' %';-->
                                <#--}else {-->
                                    <#--format = params[0].name+'<br/>'+params[0].seriesName+':'+Math.floor(params[0].value)+' 次'+'<br/>'+params[1].seriesName+':'+Math.floor(params[1].value)+' 次';-->
                                <#--}-->
                            <#--}else{-->
                                <#--if(params[0].name!='应收账款周转率'){-->
                                    <#--format = params[0].name+'<br/>'+params[0].seriesName+':'+params[0].value+' %';-->
                                <#--}else {-->
                                    <#--format = params[0].name+'<br/>'+params[0].seriesName+':'+Math.floor(params[0].value)+' 次';-->
                                <#--}-->
                            <#--}-->


                        <#--return format;-->
                    <#--}-->
                <#--},-->
                <#--xAxis: {-->
                    <#--type: 'category',-->
                    <#--data: sxAxis,-->
                    <#--axisLabel: {-->
                        <#--interval: 0,-->
                        <#--rotate: -20,-->
                        <#--margin: 30,-->
                        <#--textStyle: {-->
                            <#--color: '#0c180d',-->
                            <#--align: 'center'-->

                        <#--}-->
                    <#--}-->
                <#--},-->
                <#--yAxis: {-->
                    <#--type: 'value',-->
                    <#--splitArea: {show: false},-->
                    <#--axisLabel: {-->
                        <#--formatter: '{value}'-->
                    <#--}-->
                <#--},-->
                <#--grid: {-->
                    <#--left: '3%',-->
                    <#--right: '4%',-->
                    <#--bottom: '10%',-->
                    <#--containLabel: true-->
                <#--},-->
                <#--series: [-->
                    <#--{-->
                        <#--name: '中垦乳业',-->
                        <#--type: 'bar',-->
                        <#--data: seriesZK-->
                    <#--},-->
                    <#--{-->
                        <#--name: '光明乳业',-->
                        <#--type: 'bar',-->
                        <#--data: seriesGM-->
                    <#--}-->
                <#--]-->
            <#--};-->

            <#--var finance = echarts.init($("#finance_div")[0], echartsTheme);-->
            <#--finance.setOption(option);-->
            <#--$(window).resize(function () {-->
                <#--finance.resize();-->
            <#--});-->
        <#--}-->
    <#--}-->

    /**
     * 期间费用率指标
     */
    function periodCompReport() {

        var periodComp = echarts.init($("#period_comp_div")[0]);
    }
    $(function () {
        $("#setday").hover(function(){
            $("#setdaydata").show();
        },function(){
            $("#setdaydata").hide();
        });
    });
</script>
</body>

</html>
<@footer/>