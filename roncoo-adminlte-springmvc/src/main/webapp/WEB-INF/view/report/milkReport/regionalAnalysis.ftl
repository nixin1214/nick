<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>区域分析</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                ${company}
                <input type="hidden" id="company" value="${companyName}">
                <small>区域分析</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${company}</li>
            </ol>
        </section>

        <section class="content">

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">销售量分析</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="nav-tabs-custom">
                            <!-- Tabs within a box -->
                            <ul class="nav nav-tabs pull-right">
                                <li class="active"><a href="#revenue-chart" data-toggle="tab" style="color: #00a65a">按日查看</a></li>
                                <li><a href="#sales-chart" data-toggle="tab" style="color: #00a7d0" id="eyeryChart">按月查看</a></li>
                            </ul>
                            <div class="tab-content no-padding">
                                <div class="chart tab-pane active" id="revenue-chart" style="position: relative; height: 300px;">
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-8">
                                                <input class="pull-right" type="text" id="securityTimes" style="position: absolute;right:28px;top:5px;z-index: 3">
                                                <div class="businessIncome" style="height: 300px;"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="chart tab-pane" id="sales-chart" style="position: relative; height: 300px;">
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-8">
                                                <input class="pull-right" type="text" id="securityTime" style="position: absolute;right:28px;top:5px;z-index: 3">
                                                <div class="businessIncomeChart" style="height: 300px;"></div>
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
                <div class="col-xs-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">销量额分析</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="nav-tabs-custom">
                            <!-- Tabs within a box -->
                            <ul class="nav nav-tabs pull-right">
                                <li class="active"><a href="#revenue-charts" data-toggle="tab" style="color: #00a65a">按日查看</a></li>
                                <li><a href="#sales-charts" data-toggle="tab" style="color: #00a7d0" id="eyeryCharts">按月查看</a></li>
                            </ul>
                            <div class="tab-content no-padding">
                                <div class="chart tab-pane active" id="revenue-charts" style="position: relative; height: 300px;">
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-8">
                                                <input class="pull-right" type="text" id="selectTimes" style="position: absolute;right:28px;top:5px;z-index: 3">
                                                <div class="businessIncomes" style="height: 300px;"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="chart tab-pane" id="sales-charts" style="position: relative; height: 300px;">
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-8">
                                                <input class="pull-right" type="text" id="selectTime" style="position: absolute;right:28px;top:5px;z-index: 3">
                                                <div class="businessIncomeCharts" style="height: 300px;"></div>
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
<@common/>
<@jsFile/>
    <script type="text/javascript">
        var yearMonth = '';
        var yearMonths = '';
        var securityTimes = '';
        var selectTimes = '';
        $('#securityTimes').datepicker({
            language: 'zh-CN',
            format: 'yyyy-mm-dd',
            autoclose: true,
            todayHighlight: true
        }).on('changeDate',function (ev) {
            securityTimes = $(this).val();
            hsmrysale(securityTimes);
        });
        $('#selectTimes').datepicker({
            language: 'zh-CN',
            format: 'yyyy-mm-dd',
            autoclose: true,
            todayHighlight: true
        }).on('changeDate',function (ev) {
            selectTimes = $(this).val();
            hsmrysales(selectTimes);
        });

        $(function () {
            $('#securityTimes').datepicker( 'setDate' , '-1d' );//设置日期控件默认值,触发change事件
            $('#selectTimes').datepicker( 'setDate' , '-1d' );//设置日期控件默认值,触发change事件
            $('#eyeryChart').click(function () {
                $('#securityTime').datepicker({
                    language: 'zh-CN',
                    format: 'yyyymm',
                    autoclose: true,
                    todayHighlight: false,
                    startView: 1,
                    maxViewMode: 1,
                    minViewMode: 1
                }).on('changeDate', function (ev) {
                    yearMonth = $(this).val();
                    businessIncomeChart(yearMonth);
                });
                $('#securityTime').datepicker( 'setDate' , '-1m' );
            });
            $('#eyeryCharts').click(function () {
                $('#selectTime').datepicker({
                    language: 'zh-CN',
                    format: 'yyyymm',
                    autoclose: true,
                    todayHighlight: true,
                    startView: 1,
                    maxViewMode: 1,
                    minViewMode:1
                }).on('changeDate',function () {
                    yearMonths = $(this).val();
                    businessIncomeDetail(yearMonths);
                });
                $('#selectTime').datepicker( 'setDate' , '-1m' );
            });
        });
        function hsmrysale(securityTimes) {
            $.ajax({
                url: "${ctx}/report/milkReport/hsmrySaleDayajax?companyNumber=${companyNumber}&company=${company}&securityTimes="+securityTimes,
                type: "get",
                dataType: "text",
                success: function(result){
                    var jsonObj = eval('(' + result + ')');
                    hsmrysaleDay(jsonObj);
                },
                error:function(){
                    console.log('错误');
                }
            });

        }
        function businessIncomeChart(yearMonth) {
            $.ajax({
                url: "${ctx}/report/milkReport/regionalAnalysisajax?companyNumber=${companyNumber}&company=${company}&yearMonth="+yearMonth,
                type: "get",
                dataType: "text",
                success: function(result){
                    var jsonObj = eval('(' + result + ')');
                    Areachart(jsonObj);
                },
                error:function(){
                    console.log('错误');
                }
            });

        }
        function businessIncomeDetail(yearMonths) {
            $.ajax({
                url: "${ctx}/report/milkReport/zkgylAnalysisajax?companyNumber=${companyNumber}&company=${company}&yearMonths="+yearMonths,
                type: "get",
                dataType: "text",
                success: function(result){
                    var jsonObjs = eval('(' + result + ')');
                    init(jsonObjs);
                },
                error:function(){
                    console.log('错误');
                }
            });

        }
        function hsmrysales(selectTimes) {
            $.ajax({
                url: "${ctx}/report/milkReport/zkgyldayajax?companyNumber=${companyNumber}&company=${company}&selectTimes="+selectTimes,
                type: "get",
                dataType: "text",
                success: function(result){
                    var jsonObjs = eval('(' + result + ')');
                    zkgylsale(jsonObjs);
                },
                error:function(){
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

            console.log(result);
            var sxAxis = [];//
            var seriesGTNF = [];//
            var seriesDWN = [];//
            for (var i = 0; i < result['yearMonth'].length; i++) {
                sxAxis.push(result['yearMonth'][i]);
                seriesGTNF.push(Math.floor(result['HSMRY']['PJRCNL-HSMRMYXSE'][i]));
                seriesDWN.push(Math.floor(result['ZKGYL']['ZKGYL-LSMYXLE'][i]));
            }
            var saleReports = echarts.init($('.businessIncomeCharts')[0], echartsTheme);

            var option2 = {

                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    x: 'center',
                    data: ['陕西','全国'],
                    top:'5%'
                },
                toolbox: {
                    show: true,
                    feature: {
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    },
                    right:'20%',
                    top:'5%'
                },
                calculable: true,
                grid: {
                    left:'3%',
                    right:'3%',
                    bottom:'15%',
                    top:'20%',
                    containLabel:true
                },
                xAxis: [
                    {
                        type: 'category',
                        axisLabel: {
                            interval: 0,
                            rotate: -30,
                            margin: 30,
                            textStyle: {
                                color: '#0c180d',
                                align: 'center'
                            }
                        },
                        data: sxAxis
                    }
                ],
                yAxis: [
                    {
                        name: '销量额(万元)',
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
                        name: '陕西',
                        type: 'line',
                        data: seriesGTNF,
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
                        name: '全国',
                        type: 'line',
                        data: seriesDWN,
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
            saleReports.clear();
            saleReports.setOption(option2);
            $(window).resize(function () {
                saleReports.resize();
            });
        }

        function zkgylsale(result) {
            var sxAxis = [];//
            var seriesGTNF = [];//
            var seriesDWN = [];//
            for (var i = 0; i < result['yearMonth'].length; i++) {
                sxAxis.push(result['yearMonth'][i]);
                seriesGTNF.push(Math.floor(result['HSMRY']['PJRCNL-MTXSHSM'][i]));
                seriesDWN.push((result['ZKGYL']['ZKGYL-LSMTXLE'][i]).toFixed(2));
            }
            var saleReports = echarts.init($('.businessIncomes')[0], echartsTheme);

            var option2 = {

                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    x: 'center',
                    data: ['陕西','全国'],
                    top:'5%'
                },
                toolbox: {
                    show: true,
                    feature: {
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    },
                    right:'20%',
                    top:'5%'
                },
                calculable: true,
                grid: {
                    left:'3%',
                    right:'3%',
                    bottom:'15%',
                    top:'20%',
                    containLabel:true
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
                        data: sxAxis
                    }
                ],
                yAxis: [
                    {
                        name: '销量额(万元)',
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
                        name: '陕西',
                        type: 'line',
                        data: seriesGTNF,
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
                        name: '全国',
                        type: 'line',
                        data: seriesDWN,
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
            saleReports.clear();
            saleReports.setOption(option2);
            $(window).resize(function () {
                saleReports.resize();
            });
        }

        /**
         * 区域分析走势图
         * @param result
         * @constructor
         */
        function Areachart(result) {
            var sxAxis = [];//
            var seriesGTNF = [];//
            var seriesDWN = [];//
            for (var i = 0; i < result['yearMonth'].length; i++) {
                sxAxis.push(result['yearMonth'][i]);
                seriesGTNF.push(Math.floor(result["HSMRY"]['PJRCNL-MYXHSMR'][i]));
                seriesDWN.push(Math.floor(result["ZKGYL"]['ZKGYL-LSMYXL'][i]));
            }
            var saleReport = echarts.init($(".businessIncomeChart")[0], echartsTheme);
            var option2 = {
                title: {
                    subtext: '单位:吨',
                        left: '3%'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    x: 'center',
                    data: ['陕西','全国'],
                    top:'5%'
                },
                toolbox: {
                    show: true,
                    feature: {
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    },
                    right:'20%',
                    top:'5%'
                },
                calculable: true,
                grid: {
                    left:'3%',
                    right:'3%',
                    bottom:'15%',
                    top:'20%',
                    containLabel:true
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
                            }
                        },
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
                        name: '陕西',
                        type: 'line',
                        data: seriesGTNF,
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
                        name: '全国',
                        type: 'line',
                        data: seriesDWN,
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
            saleReport.clear();
            saleReport.setOption(option2);

            $(window).resize(function () {
                saleReport.resize();
            });
        }

        function hsmrysaleDay(result) {
            var sxAxis = [];//
            var seriesGTNF = [];//
            var seriesDWN = [];//
            for (var i = 0; i < result['yearMonth'].length; i++) {
                sxAxis.push(result['yearMonth'][i]);
                seriesGTNF.push(Math.floor(result['HSMRY']['PJRCNL-MTSHSMR'][i]));
                seriesDWN.push((result['ZKGYL']['ZKGYL-LSMTXL'][i]).toFixed(2));
            }
            var saleReport = echarts.init($(".businessIncome")[0], echartsTheme);
            var option2 = {
                title: {
                    subtext: '单位:吨',
                    left: '3%'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    x: 'center',
                    data: ['陕西','全国'],
                    top:'5%'
                },
                toolbox: {
                    show: true,
                    feature: {
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    },
                    right:'20%',
                    top:'5%'
                },
                calculable: true,
                grid: {
                    left:'3%',
                    right:'3%',
                    bottom:'15%',
                    top:'20%',
                    containLabel:true
                },
                xAxis: [
                    {
                        type: 'category',
                        axisLabel: {
                            interval: 1,
                            rotate: -20,
                            margin: 30,
                            textStyle: {
                                color: '#0c180d',
                                align: 'center'
                            }
                        },
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
                        name: '陕西',
                        type: 'line',
                        data: seriesGTNF,
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
                        name: '全国',
                        type: 'line',
                        data: seriesDWN,
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
            saleReport.clear();
            saleReport.setOption(option2);

            $(window).resize(function () {
                saleReport.resize();
            });
        }


    </script>

</div>
</body>
<@footer/>
</html>