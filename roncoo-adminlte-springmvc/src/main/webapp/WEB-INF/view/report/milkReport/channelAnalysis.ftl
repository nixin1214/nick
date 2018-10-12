<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>销售渠道</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
            ${company}
                <input type="hidden" value="${companyName}" id="company"/>
                <small>销售渠道</small>
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
                            <h3 class="box-title">渠道销量走势</h3>
                            <div class="box-tools pull-right">

                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="nav-tabs-custom">
                            <!-- Tabs within a box -->
                            <ul class="nav nav-tabs pull-right">
                                <li class="active"><a href="#revenue-chart" data-toggle="tab" style="color: #00a65a" id="eyeryCharts">按日查看</a></li>
                                <li><a href="#sales-chart" data-toggle="tab" style="color: #00a7d0" id="eyeryChart">按月查看</a></li>
                            </ul>

                            <div class="tab-content no-padding">
                                <div class="chart tab-pane active" id="revenue-chart" style="position: relative; height: 300px;">
                            <div class="box-body no-padding">
                                <input class="pull-right" type="text" id="everydayTime" style="position: absolute;right:12px;top:5px;z-index: 3;width: 130px">
                                <div class="row">
                                    <div class="col-md-7 col-sm-12">
                                        <div class="detailByYearMonthCharts" style="height: 300px;"></div>
                                    </div>
                                    <div class="col-md-5 col-sm-12">
                                        <div class="detailByYearMonthChartRatios" style="height: 300px;"></div>
                                    </div>
                                </div>

                            </div>
                                </div>
                                <div class="chart tab-pane" id="sales-chart" style="position: relative; height: 300px;">
                        <div class="box-body no-padding">
                            <input type="text" id="securityTime" style="position: absolute;right:12px;top:5px;z-index: 3;width: 130px">
                            <div class="row">
                                <div class="col-md-7 col-sm-12">
                                    <div class="detailByYearMonthChart" style="height: 300px;"></div>
                                </div>
                                <div class="col-md-5 col-sm-12">
                                    <div class="detailByYearMonthChartRatio" style="height: 300px;"></div>
                                </div>
                            </div>
                        </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-10">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">渠道销量数据(单位:吨)</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-8">
                                            <div class="group_map">
                                                <table id="group_map"
                                                       class="table table-bordered table-hover dataTable no-footer">

                                                </table>
                                            </div>
                                        </div>
                                    </div>
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
                            <h3 class="box-title">渠道销售金额走势</h3>
                            <div class="box-tools pull-right">

                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="nav-tabs-custom">
                            <!-- Tabs within a box -->
                            <ul class="nav nav-tabs pull-right">
                                <li class="active"><a href="#revenue-charts" data-toggle="tab" style="color: #00a65a" id="eyerysCharts">按日查看</a></li>
                                <li><a href="#sales-charts" data-toggle="tab" style="color: #00a7d0" id="eyerysChart">按月查看</a></li>
                            </ul>

                            <div class="tab-content no-padding">
                                <div class="chart tab-pane active" id="revenue-charts" style="position: relative; height: 300px;">
                                    <div class="box-body no-padding">
                                        <input class="pull-right" type="text" id="everydaysTime" style="position: absolute;right:12px;top:5px;z-index: 3;width: 130px">
                                        <div class="row">
                                            <div class="col-md-7 col-sm-12">
                                                <div class="detailsByYearMonthCharts" style="height: 300px;"></div>
                                            </div>
                                            <div class="col-md-5 col-sm-12">
                                                <div class="detailsByYearMonthChartRatios" style="height: 300px;"></div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="chart tab-pane" id="sales-charts" style="position: relative; height: 300px;">
                                    <div class="box-body no-padding">
                                        <input type="text" id="securitysTime" style="position: absolute;right:12px;top:5px;z-index: 3;width: 130px">
                                        <div class="row">
                                            <div class="col-md-7 col-sm-12">
                                                <div class="detailsByYearMonthChart" style="height: 300px;"></div>
                                            </div>
                                            <div class="col-md-5 col-sm-12">
                                                <div class="detailsByYearMonthChartRatio" style="height: 300px;"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-10">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">渠道销售金额数据(单位:万元)</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-8">
                                            <div class="group_map">
                                                <table id="groups_map"
                                                       class="table table-bordered table-hover dataTable no-footer">

                                                </table>
                                            </div>
                                        </div>
                                    </div>
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
    var yearMonth = '';
    var yearMonths= '';
    $('#everydayTime').datepicker({
        language: 'zh-CN',
        format: 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight: true,
    }).on('changeDate', function (ev) {
        yearMonths = $(this).val();
        detailByYearMonthChartday(yearMonths);
    });

    $(function () {
        $('#everydayTime').datepicker( 'setDate' , '-1d' );//设置日期控件默认值,触发change事件
        $('#eyeryChart').click(function () {
            $("#securityTime").datepicker({
                language: 'zh-CN',
                format: 'yyyymm',
                autoclose: true,
                todayHighlight: false,
                startView: 1,
                maxViewMode: 1,
                minViewMode:1
            }).on('changeDate',function (ev) {
                yearMonth = $(this).val();
                detailByYearMonthChart(yearMonth);
            });
            $('#securityTime').datepicker( 'setDate' , '-1m' );
        });
        $('#eyeryCharts').click(function () {
            detailByYearMonthChartday(yearMonths);
        });
    });

    var yearsMonth = '';
    var yearsMonths= '';

    $('#everydaysTime').datepicker({
        language: 'zh-CN',
        format: 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight: true,
    }).on('changeDate', function (ev) {
        yearsMonths = $(this).val();
        detailsByYearMonthChartday(yearsMonths);
    });

    $(function () {
        $('#everydaysTime').datepicker( 'setDate' , '-1d' );//设置日期控件默认值,触发change事件
        $('#eyerysChart').click(function () {
            $("#securitysTime").datepicker({
                language: 'zh-CN',
                format: 'yyyymm',
                autoclose: true,
                todayHighlight: false,
                startView: 1,
                maxViewMode: 1,
                minViewMode:1
            }).on('changeDate',function (ev) {
                yearsMonth = $(this).val();
                detailsByYearMonthChart(yearsMonth);
            });
            $('#securitysTime').datepicker( 'setDate' , '-1m' );
        });
        $('#eyerysCharts').click(function () {
            detailsByYearMonthChartday(yearsMonths);
        });
    });

    function detailByYearMonthChart(yearMonth) {
        $.ajax({
            url: "${ctx}/report/milkReport/saleComparisonAjax?companyNumber=${company}",
            type: "get",
            data: {'yearMonth': yearMonth},
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                init(jsonObj);
                channelChart(jsonObj);
            },
            error: function () {
                console.log('错误');
            }
        });
    }
    function detailsByYearMonthChart(yearsMonth) {
        $.ajax({
            url: "${ctx}/report/milkReport/salesComparisonAjax?companyNumber=${company}",
            type: "get",
            data: {'yearsMonth': yearsMonth},
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                initis(jsonObj);
                channelChartis(jsonObj);
            },
            error: function () {
                console.log('错误');
            }
        });
    }

    function detailByYearMonthChartday(yearMonths) {
        $.ajax({
            url: "${ctx}/report/milkReport/saleComparisonAjaxday?companyNumber=${company}",
            type: "get",
            data: {'yearMonths': yearMonths},
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                inits(jsonObj);
                channelCharts(jsonObj);
            },
            error: function () {
                console.log('错误');
            }
        });
    }
    function detailsByYearMonthChartday(yearsMonths) {
        $.ajax({
            url: "${ctx}/report/milkReport/salesComparisonAjaxday?companyNumber=${company}",
            type: "get",
            data: {'yearsMonths': yearsMonths},
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                insits(jsonObj);
                channelsCharts(jsonObj);
            },
            error: function () {
                console.log('错误');
            }
        });
    }

    function inits(result) {
        var sxAxis = result['yearMonth'];//x轴数据
        var sxAyis = [];//Y轴数据
        var legendData = []; //拆线图legend数据
        var ratioAyis = [];//饼图数据
        var ratioLegend = []; //饼图legend数据
        var legendSelected = {};
        for (var key in result) {
            if (key != 'yearMonth') {
                legendData.push(key);
                if(result[key][30]!=0){
                    ratioAyis.push({name:key,value:result[key][30]});
                    ratioLegend.push(key);
                }

                if (result[key][30]==0){
                    legendSelected[key] = false;
                }
                sxAyis.push({
                    name: key,
                    type: 'line',
                    data: result[key],
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
                });
            }
        }
        var saleReport = echarts.init($(".detailByYearMonthCharts")[0], echartsTheme);
        var option2 = {
            title: {
                //text: '销售渠道分析图',
                subtext: '单位:吨',
                left: 20
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                orient: 'horizontal',
                x: 'center',
                data:legendData,
                bottom:'2%',
                selected:legendSelected
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '12%',
                containLabel: true
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
                    data: sxAxis,
                    axisLabel: {
                        interval: 1,
                        rotate: -30,
                        margin: 30,
                        textStyle: {
                            color: '#0c180d',
                            align: 'center'

                        }
                    }
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
            series: sxAyis
        };


        var cattles = echarts.init($('.detailByYearMonthChartRatios')[0], echartsTheme);
        var option = {
            title: {
                text: '渠道销量占比',
                left: 'center',
                subtext:'单位:吨'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}吨 ({d}%)"
            },
            legend: {
                bottom: 5,
                left: 'center',
                data: legendData
            },
            series: [
                {
                    name: '渠道',
                    type: 'pie',
                    radius: ['30%', '45%'],
                    center: ['50%', '50%'],
                    label: {
                        normal: {
                            formatter: '{b}：\r\n({c}吨)'
                            //formatter: '{b}'
                        }
                    },
                    data: ratioAyis,
                    animationType: 'scale',
                    animationEasing: 'elasticOut',
                    animationDelay: function (idx) {
                        return Math.random() * 200;
                    }
                }
            ]
        };
        saleReport.clear();
        saleReport.setOption(option2);
        cattles.setOption(option);


        $(window).resize(function () {
            saleReport.resize();
            cattles.resize();
        });
    }


    function insits(result) {
        var sxAxis = result['yearMonth'];//x轴数据
        var sxAyis = [];//Y轴数据
        var legendData = []; //拆线图legend数据
        var ratioAyis = [];//饼图数据
        var ratioLegend = []; //饼图legend数据
        var legendSelected = {};
        for (var key in result) {
            if (key != 'yearMonth') {
                legendData.push(key);
                if(result[key][30]!=0){
                    ratioAyis.push({name:key,value:result[key][30]});
                    ratioLegend.push(key);
                }

                if (result[key][30]==0){
                    legendSelected[key] = false;
                }
                sxAyis.push({
                    name: key,
                    type: 'line',
                    data: result[key],
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
                });
            }
        }
        var saleReport = echarts.init($(".detailsByYearMonthCharts")[0], echartsTheme);
        var option2 = {
            title: {
                //text: '销售渠道分析图',
                subtext: '单位:万元',
                left: 20
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                orient: 'horizontal',
                x: 'center',
                data:legendData,
                bottom:'2%',
                selected:legendSelected
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '12%',
                containLabel: true
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
                    data: sxAxis,
                    axisLabel: {
                        interval: 1,
                        rotate: -30,
                        margin: 30,
                        textStyle: {
                            color: '#0c180d',
                            align: 'center'

                        }
                    }
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
            series: sxAyis
        };


        var cattles = echarts.init($('.detailsByYearMonthChartRatios')[0], echartsTheme);
        var option = {
            title: {
                text: '渠道销售金额占比',
                left: 'center',
                subtext:'单位:万元'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}万元 ({d}%)"
            },
            legend: {
                bottom: 5,
                left: 'center',
                data: legendData
            },
            series: [
                {
                    name: '渠道',
                    type: 'pie',
                    radius: ['30%', '45%'],
                    center: ['50%', '50%'],
                    label: {
                        normal: {
                            formatter: '{b}：\r\n({c}万元)'
                            //formatter: '{b}'
                        }
                    },
                    data: ratioAyis,
                    animationType: 'scale',
                    animationEasing: 'elasticOut',
                    animationDelay: function (idx) {
                        return Math.random() * 200;
                    }
                }
            ]
        };
        saleReport.clear();
        saleReport.setOption(option2);
        cattles.setOption(option);


        $(window).resize(function () {
            saleReport.resize();
            cattles.resize();
        });
    }
        function init(result) {
            var sxAxis = result['yearMonth'];//x轴数据
            var sxAyis = [];//Y轴数据
            var legendData = []; //拆线图legend数据
            var ratioAyis = [];//饼图数据
            var ratioLegend = []; //饼图legend数据
            var legendSelected = {};
            for (var key in result) {
                if (key != 'yearMonth') {
                    legendData.push(key);
                    if(result[key][11]!=0){
                        ratioAyis.push({name:key,value:result[key][11]});
                        ratioLegend.push(key);
                    }

                    if (result[key][11]==0){
                        legendSelected[key] = false;
                    }
                    sxAyis.push({
                        name: key,
                        type: 'line',
                        data: result[key],
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
                    });
                }
            }
            var saleReport = echarts.init($(".detailByYearMonthChart")[0], echartsTheme);
            var option2 = {
                title: {
                    //text: '销售渠道分析图',
                    subtext: '单位:吨',
                    left: 20
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    orient: 'horizontal',
                    x: 'center',
                    data:legendData,
                    bottom:'2%',
                    selected:legendSelected
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '12%',
                    containLabel: true
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
                        data: sxAxis,
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
                series: sxAyis
            };


            var cattles = echarts.init($('.detailByYearMonthChartRatio')[0], echartsTheme);
            var option = {
                title: {
                    text: '渠道销量占比',
                    left: 'center',
                    subtext:'单位:吨'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c}吨 ({d}%)"
                },
                legend: {
                    bottom: 5,
                    left: 'center',
                    data: legendData
                },
                series: [
                    {
                        name: '渠道',
                        type: 'pie',
                        radius: ['30%', '45%'],
                        center: ['50%', '50%'],
                        label: {
                            normal: {
                                formatter: '{b}：\r\n({c}吨)'
                                //formatter: '{b}'
                            }
                        },
                        data: ratioAyis,
                        animationType: 'scale',
                        animationEasing: 'elasticOut',
                        animationDelay: function (idx) {
                            return Math.random() * 200;
                        }
                    }
                ]
            };
            saleReport.clear();
            saleReport.setOption(option2);
            cattles.setOption(option);


            $(window).resize(function () {
                saleReport.resize();
                cattles.resize();
            });
        }

    function initis(result) {
        var sxAxis = result['yearMonth'];//x轴数据
        var sxAyis = [];//Y轴数据
        var legendData = []; //拆线图legend数据
        var ratioAyis = [];//饼图数据
        var ratioLegend = []; //饼图legend数据
        var legendSelected = {};
        for (var key in result) {
            if (key != 'yearMonth') {
                legendData.push(key);
                if(result[key][11]!=0){
                    ratioAyis.push({name:key,value:result[key][11]});
                    ratioLegend.push(key);
                }

                if (result[key][11]==0){
                    legendSelected[key] = false;
                }
                sxAyis.push({
                    name: key,
                    type: 'line',
                    data: result[key],
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
                });
            }
        }
        var saleReport = echarts.init($(".detailsByYearMonthChart")[0], echartsTheme);
        var option2 = {
            title: {
                //text: '销售渠道分析图',
                subtext: '单位:万元',
                left: 20
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                orient: 'horizontal',
                x: 'center',
                data:legendData,
                bottom:'2%',
                selected:legendSelected
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '12%',
                containLabel: true
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
                    data: sxAxis,
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
            series: sxAyis
        };


        var cattles = echarts.init($('.detailsByYearMonthChartRatio')[0], echartsTheme);
        var option = {
            title: {
                text: '渠道销售金额占比',
                left: 'center',
                subtext:'单位:万元'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}万元 ({d}%)"
            },
            legend: {
                bottom: 5,
                left: 'center',
                data: legendData
            },
            series: [
                {
                    name: '渠道',
                    type: 'pie',
                    radius: ['30%', '45%'],
                    center: ['50%', '50%'],
                    label: {
                        normal: {
                            formatter: '{b}：\r\n({c}万元)'
                            //formatter: '{b}'
                        }
                    },
                    data: ratioAyis,
                    animationType: 'scale',
                    animationEasing: 'elasticOut',
                    animationDelay: function (idx) {
                        return Math.random() * 200;
                    }
                }
            ]
        };
        saleReport.clear();
        saleReport.setOption(option2);
        cattles.setOption(option);


        $(window).resize(function () {
            saleReport.resize();
            cattles.resize();
        });
    }

    function channelCharts(result) {
        $("#group_map").empty();
        var jsonObj = result;
        console.log(jsonObj["yearMonth"]);
        var rowHead = "<tr><th>#</th>";
        for (var i = 19; i <= 30; i++) {
            rowHead = rowHead + "<th>" + jsonObj["yearMonth"][i] + "</th>";
        }
        $("#group_map").append(rowHead + "</tr>");
        for (var key in jsonObj) {
            var row = "";
            var number = "-";
            if (key != "yearMonth") {
                row = row + "<tr><td>" + key + "</td>";
                for (var i = 19; i <=30; i++) {
                    if(jsonObj[key][i]==0){
                        row = row + "<td>" + number + "</td>";
                    }else{
                        row = row + "<td>" + jsonObj[key][i] + "</td>";
                    }

                }
                $("#group_map").append(row + "</tr>");
            }
        }
    }

    function channelsCharts(result) {
        $("#groups_map").empty();
        var jsonObj = result;
        console.log(jsonObj["yearMonth"]);
        var rowHead = "<tr><th>#</th>";
        for (var i = 19; i <= 30; i++) {
            rowHead = rowHead + "<th>" + jsonObj["yearMonth"][i] + "</th>";
        }
        $("#groups_map").append(rowHead + "</tr>");
        for (var key in jsonObj) {
            var row = "";
            var number = "-";
            if (key != "yearMonth") {
                row = row + "<tr><td>" + key + "</td>";
                for (var i = 19; i <=30; i++) {
                    if(jsonObj[key][i]==0){
                        row = row + "<td>" + number + "</td>";
                    }else{
                        row = row + "<td>" + jsonObj[key][i] + "</td>";
                    }

                }
                $("#groups_map").append(row + "</tr>");
            }
        }
    }
    function channelChart(result) {
        $("#group_map").empty();
        var jsonObj = result;
        var rowHead = "<tr><th>#</th>";
        for (var i = 0; i < jsonObj["yearMonth"].length; i++) {
            rowHead = rowHead + "<th>" + jsonObj["yearMonth"][i] + "</th>";
        }
        $("#group_map").append(rowHead + "</tr>");
        for (var key in jsonObj) {
            var row = "";
            var number = "-";
            if (key != "yearMonth") {
                row = row + "<tr><td>" + key + "</td>";
                for (var i = 0; i < jsonObj[key].length; i++) {
                    if(jsonObj[key][i]==0){
                        row = row + "<td>" + number + "</td>";
                    }else{
                        row = row + "<td>" + jsonObj[key][i] + "</td>";
                    }

                }
                $("#group_map").append(row + "</tr>");
            }
        }
    }

    function channelChartis(result) {
        $("#groups_map").empty();
        var jsonObj = result;
        var rowHead = "<tr><th>#</th>";
        for (var i = 0; i < jsonObj["yearMonth"].length; i++) {
            rowHead = rowHead + "<th>" + jsonObj["yearMonth"][i] + "</th>";
        }
        $("#groups_map").append(rowHead + "</tr>");
        for (var key in jsonObj) {
            var row = "";
            var number = "-";
            if (key != "yearMonth") {
                row = row + "<tr><td>" + key + "</td>";
                for (var i = 0; i < jsonObj[key].length; i++) {
                    if(jsonObj[key][i]==0){
                        row = row + "<td>" + number + "</td>";
                    }else{
                        row = row + "<td>" + jsonObj[key][i] + "</td>";
                    }

                }
                $("#groups_map").append(row + "</tr>");
            }
        }
    }

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
