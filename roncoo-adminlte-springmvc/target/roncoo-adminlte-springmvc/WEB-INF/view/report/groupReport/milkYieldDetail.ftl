<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>生鲜奶产量明细</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                ${companyName}
                <small>生鲜奶产量明细</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${companyName}</li>
            </ol>
        </section>

        <section class="content">
            <small>天宁牧场</small>
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-aqua">
                        <span class="info-box-icon"><i class="fa fa-cny"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">总产奶量</span>
                            <span class="info-box-number">${(resultData[0]/1000)?floor}</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar"> ${beginTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 吨</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-green">
                        <span class="info-box-icon"><i class="fa fa-yen"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">成乳牛日均产奶量</span>
                            <span class="info-box-number">${resultData[1]?string("0.0")}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar"> ${beginTime}</span>
                            <span style="position: absolute;right: 23px"> 单位 : 千克</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-yellow">
                        <span class="info-box-icon"><i class="fa fa-line-chart"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">泌乳牛日均产奶量</span>
                            <span class="info-box-number">${resultData[2]?string("0.0")}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar"> ${beginTime}</span>
                            <span style="position: absolute;right: 23px"> 单位 : 千克</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-purple">
                        <span class="info-box-icon"><i class="fa fa-line-chart"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">泌乳牛头数(前一天)</span>
                            <span class="info-box-number">${resultData[3]?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar"> ${beginTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 头</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
            </div>
            <small>华山牧场</small>
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-aqua">
                        <span class="info-box-icon"><i class="fa fa-cny"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">总产奶量</span>
                            <span class="info-box-number">${(result[0]/1000)?floor}</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar"> ${endTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 吨</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-green">
                        <span class="info-box-icon"><i class="fa fa-yen"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">成乳牛日均产奶量</span>
                            <span class="info-box-number">${result[1]?string("0.0")}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar"> ${endTime}</span>
                            <span style="position: absolute;right: 23px"> 单位 : 千克</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-yellow">
                        <span class="info-box-icon"><i class="fa fa-line-chart"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">泌乳牛日均产奶量</span>
                            <span class="info-box-number">${result[2]?string("0.0")}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar"> ${endTime}</span>
                            <span style="position: absolute;right: 23px"> 单位 : 千克</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-purple">
                        <span class="info-box-icon"><i class="fa fa-line-chart"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">泌乳牛头数(前一天)</span>
                            <span class="info-box-number">${result[3]?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar"> ${endTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 头</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">产量走势对比图</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="selectTime" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
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
    var yearMonths ='';
    $('#selectTime').datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: true,
        startView: 1,
        maxViewMode: 1,
        minViewMode:1
    }).on('changeDate',function (ev) {
        yearMonths = $(this).val();
        yieldTrend(yearMonths);
    });
    $(function () {
        $('#selectTime').datepicker( 'setDate' , '-0m' );
    });

    /**
     * 产量走势对比图
     */
    function yieldTrend(yearMonths) {
        $.ajax({
            url: "${ctx}/report/groupReport/yieldTrendAjax?companyNumber=${companyNumber}&yearMonths=" + yearMonths,
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
        function init(result) {
            var sxAxis = [];//x轴数据
            var seriesTNMC = [];//天宁牧场数据
            var seriesHSMC = [];//华山牧场数据
            for (var i = 0; i < result['axisx'].length; i++) {
                sxAxis.push(result['axisx'][i]);
                seriesTNMC.push(Math.floor(result['TNMC'][i]/1000));
                seriesHSMC.push(Math.floor(result['HSMC'][i]/1000));
            }
            var saleReport = echarts.init($(".businessIncomeChart")[0], echartsTheme);
            console.log(saleReport);
            var option2 = {
                title:{
                    subtext:'单位:吨',
                    left:'3%'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        label: {
                            formatter: '{value}'
                        }
                    }
                },
                legend: {
                    x: 'center',
                    data: ['天宁牧场', '华山牧场']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '10%',
                    containLabel: true
                },
                toolbox: {
                    show: true,
                    right:'3%',
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
                        name: '天宁牧场',
                        type: 'line',
                        data: seriesTNMC,
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
                        name: '华山牧场',
                        type: 'line',
                        data: seriesHSMC,
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
