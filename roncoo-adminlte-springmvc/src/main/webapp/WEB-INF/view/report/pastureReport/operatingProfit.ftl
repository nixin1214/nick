<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>利润总额</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
            ${company}
                <input type="hidden" id="company" value="${companyName}">
                <small>利润总额明细</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${company}</li>
            </ol>
        </section>
        <input type="hidden" id="companyNumber" value="${company}">

        <section class="content">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-aqua">
                        <span class="info-box-icon"><i class="fa fa-cny"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">本期利润总额</span>
                            <span class="info-box-number">
                                <#if resultList?exists >
                                    ${resultList[0]}
                                </#if>
                                </span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <#assign yesrmx = result[1]>
                            <span class="fa fa-calendar"> ${yesrmx}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 万元</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-green">
                        <span class="info-box-icon"><i class="fa fa-yen"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">本年累计营利</span>
                            <span class="info-box-number">
                            <#if resultList?exists >
                                    ${resultList[1]}
                                </#if>
                                </span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar"> ${yesrmx}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 万元</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-yellow">
                        <span class="info-box-icon"><i class="fa fa-line-chart"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">上月环比</span>
                            <span class="info-box-number">
                                <#if (resultList[3]>0) >
                                    ${(resultList[0]-resultList[3])/resultList[3]*100}
                                <#elseif (resultList[3]<0) >
                                    ${(1-resultList[0]/resultList[3])*100}
                                <#else>
                                    0
                                </#if>%
                                </span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="progress-description">相比${result[0]?substring(0,4)}年${result[0]?substring(4,6)}月</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-purple">
                        <span class="info-box-icon"><i class="fa fa-line-chart"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">去年同比</span>
                            <span class="info-box-number">
                                <#if (resultList[2]>0) >
                                    ${(resultList[0]-resultList[2])/resultList[2]*100}
                                <#elseif (resultList[2]<0) >
                                    ${(1-resultList[0]/resultList[2])*100}
                                <#else>
                                    0
                                </#if>%
                                </span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="progress-description">相比${lastMonth?substring(0,4)}年${lastMonth?substring(4,6)}月</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">年度利润趋势图</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="selectTime" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <div class="row">
                                <div class="col-md-12 col-sm-8">
                                    <div class="businessIncomeChart" style="width: 100%; height: 350px;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<@jsFile/>

<script type="text/javascript">
    var yearMonthone = '';
    $('#selectTime').datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: true,
        startView: 1,
        maxViewMode: 1,
        minViewMode:1
    }).on('changeDate',function () {
        yearMonthone = $(this).val();
        operatingprofit(yearMonthone);
    });

    $(function () {
        $('#selectTime').datepicker( 'setDate' , '-1m' );//设置日期控件默认值,触发change事件
    });

    function operatingprofit(yearMonthone) {
        $.ajax({
            url: "${ctx}/report/pastureReport/operatingprofitAjax?companyNumber=${companyNumber}&company=${company}&yearMonthone="+yearMonthone,
            type: "get",
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                init(jsonObj);
            },
            error: function () {
                console.log('错误');
            }
        });
    }

    $(window).load(function () {
        var el = $('.content-header');
        el.html(el.html().replace(/TYRY/ig, '天友乳业'));
        el.html(el.html().replace(/HSMRY/ig, '华山牧乳业'));
        el.html(el.html().replace(/TNMC/ig, '天宁牧场'));
        el.html(el.html().replace(/HSMC/ig, '华山牧场'));
    });

    /**
     * 初始化
     */
    function init(result) {
        var sxAxis = result['yearMonth'];//x轴数据
        var seriesYYLR = [];//营业利润
        var seriesYYLRYS = [];//营业利润预算
        var seriesYYLRSN = [];//营业利润本期上年
        for (var i = 0; i < result['yearMonth'].length; i++) {
            if (result['CW-YYLR'].length > 0) {
                seriesYYLR.push(Math.round(result['CW-YYLR'][i]));
            }
            if (result['CW-YYLR-YS'].length > 0) {
                seriesYYLRYS.push(Math.round(result['CW-YYLR-YS'][i]));
            }
            if (result['CW-YYLR-SN'].length > 0) {
                seriesYYLRSN.push(Math.round(result['CW-YYLR-SN'][i]));
            }
        }
        var saleReport = echarts.init($(".businessIncomeChart")[0], echartsTheme);
        var option2 = {
            title: {
                text: '',
                subtext: '单位:万元',
                left: 'left'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                orient: 'horizontal',
                x: 'center',
                data: ['本期', '预算','上年同期']
            },
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    data: sxAxis
                }
            ],
            yAxis: [
                {
                    type: 'value',
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
                    name: '本期',
                    type: 'line',
                    data: seriesYYLR,
                    itemStyle: {
                        normal: {
                            //color: '#00a65a'
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
                    name: '预算',
                    type: 'line',
                    data: seriesYYLRYS,
                    itemStyle: {
                        normal: {
                            //color: '#00c0ef'
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
                    name: '上年同期',
                    type: 'line',
                    data: seriesYYLRSN,
                    itemStyle: {
                        normal: {
                            //color: '#00c0ef'
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
