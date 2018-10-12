<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>销量与销售分析</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
            ${company}
                <input type="hidden" id="company" value="${companyName}">
                <small>销量与销售分析</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${company}</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">销量分析</h3>
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
                                        <div class="col-md-12 col-sm-12">
                                            <input class="pull-right" type="text" id="yearMonth" style="position: absolute;right:28px;top:5px;z-index: 3">
                                            <div id="amount_div" style="height: 300px;"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="chart tab-pane" id="sales-chart" style="position: relative; height: 300px;">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <input class="pull-right" type="text" id="yearTime" style="position: absolute;right:28px;top:5px;z-index: 3">
                                            <div id="amount_divs" style="height: 300px;"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </div>
                </div>
                <div class="col-xs-12 no-padding">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">销售额分析</h3>
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
                                            <input class="pull-right" type="text" id="yearMonths" style="position: absolute;right:28px;top:5px;z-index: 3">
                                            <div id="amount" style="height: 300px;"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="chart tab-pane" id="sales-charts" style="position: relative; height: 300px;">
                                    <div class="box-body">
                                        <div class="row">
                                            <input class="pull-right" type="text" id="yearTimes" style="position: absolute;right:28px;top:5px;z-index: 3">
                                            <div id="amounts" style="height: 300px;"></div>
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
    //初始化时间选择器
    var yearTime = "";
    var yearTimes = "";
    var yearMonths = "";
    var yearMonth = "";
    $('#yearMonth').datepicker({
        language: 'zh-CN',
        format: 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight: true
    }).on('changeDate',function (ev) {
        yearMonth = $(this).val();
        indexSale(yearMonth);
    });
    $('#yearMonths').datepicker({
        language: 'zh-CN',
        format: 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight: true
    }).on('changeDate',function (ev) {
        yearMonths = $(this).val();
        indexSales(yearMonths);
    });

    $(function () {
        $('#yearMonth').datepicker( 'setDate' , '-1d' );
        $('#yearMonths').datepicker( 'setDate' , '-1d' );
        $('#eyeryChart').click(function () {
            $('#yearTime').datepicker({
                language: 'zh-CN',
                format: 'yyyymm',
                autoclose: true,
                todayHighlight: false,
                startView: 1,
                maxViewMode: 1,
                minViewMode: 1
            }).on('changeDate',function () {
                yearTime = $("#yearTime").val();
                indexSaleMonth(yearTime);
            });
            $('#yearTime').datepicker( 'setDate' , '-0m' );
        });
        $('#eyeryCharts').click(function () {
            $('#yearTimes').datepicker({
                language: 'zh-CN',
                format: 'yyyymm',
                autoclose: true,
                todayHighlight: false,
                startView: 1,
                maxViewMode: 1,
                minViewMode: 1
            }).on('changeDate',function () {
                yearTimes = $("#yearTimes").val();
                indexMonth(yearTimes);
            });
            $('#yearTimes').datepicker( 'setDate' , '-0m' );
        });
    });

    function indexSaleMonth(yearTime) {
        $.ajax({
            url: "${ctx}/report/milkReport/saleChartMonthAjax?companyNumber=${companyNumber}&company=${company}&yearTime="+yearTime,
            type: "get",
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                indexSaleMonths(jsonObj);//销售量分析chart数据
            },
            error: function () {
                console.log('错误');
            }
        });
    }
    function indexSale(yearMonth) {
        $.ajax({
            url: "${ctx}/report/milkReport/saleChartAjax?companyNumber=${companyNumber}&company=${company}&yearMonth="+yearMonth,
            type: "get",
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                init(jsonObj);//销售量分析chart数据
            },
            error: function () {
                console.log('错误');
            }
        });
    }
    function indexSales(yearMonths) {
        $.ajax({
            url: "${ctx}/report/milkReport/saleChartsAjax?companyNumber=${companyNumber}&company=${company}&yearMonths="+yearMonths,
            type: "get",
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                inits(jsonObj);//销售额分析chart数据
            },
            error: function () {
                console.log('错误');
            }
        });
    }
    function indexMonth(yearTimes) {
        $.ajax({
            url: "${ctx}/report/milkReport/saleMonthAjax?companyNumber=${companyNumber}&company=${company}&yearTimes="+yearTimes,
            type: "get",
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                MonthCharts(jsonObj);//销售额分析chart数据
            },
            error: function () {
                console.log('错误');
            }
        });
    }
    function indexSaleMonths(result){
        var axix = result['yearMonth'];
        var axiy = [];
        var axiN = [];
        var axiM = [];
        for (var i = 0; i < result['yearMonth'].length; i++) {
            axiy.push(Math.floor(result['PJRCNL-CWMYXL'][i]));
            axiN.push(Math.floor(result['PJRCNL-DWMYXL'][i]));
            axiM.push(Math.floor(result['PJRCNL-XSMYXL'][i]));
        }

        var saleReport = echarts.init($('#amount_divs')[0], echartsTheme);

        var option2 = {

            tooltip: {
                trigger: 'axis'
            },
            legend: {
                x: 'center',
                data: ['低温奶销量','常温奶销量','学生奶销量'],
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
                    data:axix
                }
            ],
            yAxis: [
                {
                    name: '销量(吨)',
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
                    name: '低温奶销量',
                    type: 'line',
                    data: axiN,
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
                    name: '常温奶销量',
                    type: 'line',
                    data: axiy,
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
                },
                {
                    name: '学生奶销量',
                    type: 'line',
                    data: axiM,
                    yAxisIndex: 0,
                    itemStyle: {
                        normal: {
                            color: '#74BB44'
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
    function init(result){
        var axix = result['yearMonth'];
        var axiy = [];
        var axiN = [];
        var axiM = [];
        for (var i = 0; i < result['yearMonth'].length; i++) {
            axiy.push(Math.floor(result['HSMRY-XL-CWDTXL'][i]));
            axiN.push(Math.floor(result['HSMRY-XL-DWDTXL'][i]));
            axiM.push(Math.floor(result['HSMRY-XLE-XSDTXL'][i]));
        }

        var saleReporta = echarts.init($('#amount_div')[0], echartsTheme);

        var option2 = {

            tooltip: {
                trigger: 'axis'
            },
            legend: {
                x: 'center',
                data: ['低温奶销量','常温奶销量','学生奶销量'],
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
                    data:axix
                }
            ],
            yAxis: [
                {
                    name: '销量(吨)',
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
                    name: '低温奶销量',
                    type: 'line',
                    data: axiN,
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
                    name: '常温奶销量',
                    type: 'line',
                    data: axiy,
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
                },
                {
                    name: '学生奶销量',
                    type: 'line',
                    data: axiM,
                    yAxisIndex: 0,
                    itemStyle: {
                        normal: {
                            color: '#74BB44'
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
        saleReporta.setOption(option2);

        $(window).resize(function () {
            saleReporta.resize();
        });
    }
    function inits(result){
        var axixs = result['yearMonth'];
        var axiys = [];
        var axiNs = [];
        var axiMs = [];
        for (var i = 0; i < result['yearMonth'].length; i++) {
            axiys.push(Math.floor(result['HSMRY-XLE-CWDTXS'][i]));
            axiNs.push(Math.floor(result['HSMRY-XLE-DWDTXS'][i]));
            axiMs.push(Math.floor(result['HSMRY-XLE-XSDTXS'][i]));
        }

        var saleReports = echarts.init($('#amount')[0], echartsTheme);

        var option2 = {

            tooltip: {
                trigger: 'axis'
            },
            legend: {
                x: 'center',
                data: ['低温奶销售额','常温奶销售额','学生奶销售额'],
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
                    data:axixs
                }
            ],
            yAxis: [
                {
                    name: '销售额(万元)',
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
                    name: '低温奶销售额',
                    type: 'line',
                    data: axiNs,
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
                    name: '常温奶销售额',
                    type: 'line',
                    data: axiys,
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
                },
                {
                    name: '学生奶销售额',
                    type: 'line',
                    data: axiMs,
                    yAxisIndex: 0,
                    itemStyle: {
                        normal: {
                            color: '#74BB44'
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
        saleReports.setOption(option2);

        $(window).resize(function () {
            saleReports.resize();
        });
    }
    function MonthCharts(result){
        var axixs = result['yearMonth'];
        var axiys = [];
        var axiNs = [];
        var axiMs = [];
        for (var i = 0; i < result['yearMonth'].length; i++) {
            axiys.push(Math.floor(result['PJRCNL-CWMYXSE'][i]));
            axiNs.push(Math.floor(result['PJRCNL-DWMYXSE'][i]));
            axiMs.push(Math.floor(result['PJRCNL-XSMYXSE'][i]));
        }

        var saleReportw = echarts.init($('#amounts')[0], echartsTheme);

        var option2 = {

            tooltip: {
                trigger: 'axis'
            },
            legend: {
                x: 'center',
                data: ['低温奶销售额','常温奶销售额','学生奶销售额'],
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
                    data:axixs
                }
            ],
            yAxis: [
                {
                    name: '销售额(万元)',
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
                    name: '低温奶销售额',
                    type: 'line',
                    data: axiNs,
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
                    name: '常温奶销售额',
                    type: 'line',
                    data: axiys,
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
                },
                {
                    name: '学生奶销售额',
                    type: 'line',
                    data: axiMs,
                    yAxisIndex: 0,
                    itemStyle: {
                        normal: {
                            color: '#74BB44'
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
        saleReportw.setOption(option2);

        $(window).resize(function () {
            saleReportw.resize();
        });
    }

    $(window).load(function () {
        var el = $('.content-header');
        el.html(el.html().replace(/TYRY/ig, '天友乳业'));
        el.html(el.html().replace(/HSMRY/ig, '华山牧乳业'));
        el.html(el.html().replace(/TNMC/ig, '天宁牧场'));
        el.html(el.html().replace(/HSMC/ig, '华山牧场'));
    });

</script>
</div>
</body>
<@footer/>
</html>