<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>犊牛损失率分析</title>
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
                <small>犊牛损失率分析</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${company}</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">犊牛损失率分析</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                </div>
                                <!-- /.box-header -->
                                <div class="nav-tabs-custom">
                                    <!-- Tabs within a box -->
                                    <ul class="nav nav-tabs pull-right">
                                        <li class="active"><a href="#revenue-chart" data-toggle="tab" style="color: #00a65a">按日查看</a></li>
                                        <li><a href="#sales-chart" data-toggle="tab" style="color: #00a7d0" id="eyeryChart">按月查看</a></li>
                                    </ul>
                                    <div class="tab-content no-padding">
                                        <div class="chart tab-pane active" id="revenue-chart" style="position: relative; height: 400px;">
                                            <div class="box-body no-padding">
                                                <input class="pull-right" type="text" id="everydayTime" style="position: absolute;right:28px;top:5px;z-index: 3">
                                                <div class="row">
                                                    <div class="col-md-7">
                                                        <div class="group" style=" height: 400px;"></div>
                                                    </div>
                                                    <div class="col-md-5">
                                                        <div class="cattle" style=" height: 400px;"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="chart tab-pane" id="sales-chart" style="position: relative; height: 400px;">
                                            <div class="box-body no-padding">
                                                <input class="pull-right" type="text" id="yearMonth" style="position: absolute;right:28px;top:5px;z-index: 3">
                                                <div class="row">
                                                    <div class="col-md-7">
                                                        <div class="group_map" style=" height: 400px;"></div>
                                                    </div>
                                                    <div class="col-md-5">
                                                        <div class="cattle_div" style=" height: 400px;"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.box-body -->
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
    var yearMonths = '';
    $('#everydayTime').datepicker({
        language: 'zh-CN',
        format: 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight: true
    }).on('changeDate',function (ev) {
        yearMonths = $(this).val();
        everydayChart(yearMonths);
    });

    $(function () {
        $('#everydayTime').datepicker( 'setDate' , '-1d' );//设置日期控件默认值,触发change事件
        $('#eyeryChart').click(function () {
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
                aclfLossRate(yearMonth);
            });
            $('#yearMonth').datepicker( 'setDate' , '-1m' );
        });
    });

    function aclfLossRate(yearMonth) {
        $.ajax({
            url:"${ctx}/report/pastureReport/aclfLossRateAjax?company=${company}&yearMonth="+yearMonth,
            type:"get",
            dataType:"text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                console.log(jsonObj);
                init(jsonObj);
            },
            error:function(){
                console.log('错误');
            }
        });
    }
    function everydayChart(yearMonths) {
        $.ajax({
            url: "${ctx}/report/pastureReport/aclfLossRateAjaxEveryAjax?companyNumber=${companyNumber}&company=${company}&yearMonths="+yearMonths,
            type: "get",
            dataType: "text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                everyChart(jsonObj);
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

    function everyChart(result) {
        console.log(result);
        var yearMonths = [];
        var PZSB = [];//配种失败数据
        var DTTT = [];//带胎淘汰数据
        var LC = [];//流产数据
        for(var i=0;i<result["yearMonth"].length;i++){
            yearMonths.push(result["yearMonth"][i]);
            PZSB.push(Math.floor(result["DNSSL-PZCG5CWMT-TS"][i]));
            DTTT.push(Math.floor(result["DNSSL-DTTTCMT-TS"][i]));
            LC.push(Math.floor(result["DNSSL-BYMT-TS"][i]));
        }
        //配种失败与带胎淘汰数据
        var saleReport = echarts.init($(".group")[0]);
        var option2 = {
            title:{
                subtext:'单位:头',
                x:'left'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['配种失败', '带胎淘汰','流产头数'],
                top:'5%'
            },
            grid:{
                left:'3%',
                right:'3%',
                bottom:'20%',
                containLabel:true
            },
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                },
                right:'5%',
                top:'5%'
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    data: yearMonths,
                    axisLabel: {
                        interval:1,
                        rotate:40
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
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
                    name: '配种失败',
                    type: 'line',
                    data: PZSB,
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
                    name: '带胎淘汰',
                    type: 'line',
                    data: DTTT,
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
                    name: '流产头数',
                    type: 'line',
                    data: LC,
                    yAxisIndex: 1,
                    itemStyle: {
                        normal: {
                            color: '#3c8dbc'
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

        var cattles = echarts.init($('.cattle')[0], echartsTheme);
        var option = {
            title: {
                text: '',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}头 ({d}%)"
            },
            legend: {
                bottom: '5%',
                x: 'center',
                data: ['超5次配种未受孕数', '带胎淘汰成乳牛数','流产头数']
            },
            series: [
                {
                    name: '',
                    type: 'pie',
                    radius: '40%',
                    center: ['50%', '50%'],
                    label: {
                        normal: {
                            formatter: "{c}头 \n ({d}%)"
                        }
                    },
                    data: [
                        {value: PZSB[30], name: '超5次配种未受孕数'},
                        {value: DTTT[30], name: '带胎淘汰成乳牛数'},
                        {value: LC[30], name: '流产头数'}
                        //{value: PZCGAll, name: '配种成功数'}
                    ],
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
            saleReport.resize();
        });
    }
    /**
     * 初始化
     */
    function init(result) {
        var yearMonths = [];
        var PZSB = [];//配种失败数据
        var DTTT = [];//带胎淘汰数据
        var LC = [];//流产数据
        //var ZCSW = [];//早产死亡数据
        //var SCSW = [];//顺产死亡数据
        //var PZSBAll = Math.floor(result["quota"]["DNSSL-PZCG5CWHY-TS"][11]);//本月配种失败数
        //var DTTTAll = Math.floor(result["quota"]["DNSSL-DTTTCRN-TS"][11]);//本月带胎淘汰数
        //var SLNAll = Math.floor(result["quota"]["DNSSL-SLN-TS"][11]);//本月配种成功数
        //var PJHY = Math.floor(result["quota"]["DNSSL-BYPJHY-TS"][11]);//本月平均怀孕数
        //var BYLC = Math.floor(result["quota"]["DNSSL-BYLC-TS"][11]);//本月流产数
        //var CSNTS = Math.floor(result["quota"]["DNSSL-BYMDCSN-TS"][11]);//本月母犊出生牛总数
        //var BYZCSW = Math.floor(result["quota"]["DNSSL-BYZC24XSFLY-TS"][11]);//本月早产24小时非留养头数
        //var BYSCSW = Math.floor(result["quota"]["DNSSL-BYZC24XSFLY2-TS"][11]);//本月正产24小时非留养头数
        //var PZCGAll = SLNAll-DTTTAll-PZSBAll; //配种成功数
        //var WLCS = PJHY-BYLC;//未流产数
        //var CHTS = CSNTS-BYZCSW-BYSCSW;//成活头数
        for(var i=0;i<result["yearMonths"].length;i++){
            yearMonths.push(result["yearMonths"][i]);
            PZSB.push(Math.floor(result["quota"]["DNSSL-PZCG5CWHY-TS"][i]));
            DTTT.push(Math.floor(result["quota"]["DNSSL-DTTTCRN-TS"][i]));
            //ZCSW.push(Math.floor(result["quota"]["DNSSL-BYZC24XSFLY-TS"][i]));
            //SCSW.push(Math.floor(result["quota"]["DNSSL-BYZC24XSFLY2-TS"][i]));
            LC.push(Math.floor(result["quota"]["DNSSL-BYLC-TS"][i]));
        }
        //配种失败与带胎淘汰数据
        var saleReport = echarts.init($(".group_map")[0]);
        var option2 = {
            title:{
                subtext:'单位:头',
                x:'left'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['配种失败', '带胎淘汰','流产头数'],
                top:'5%'
            },
            grid:{
                left:'3%',
                right:'3%',
                bottom:'10%',
                containLabel:true
            },
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                },
                right:'5%',
                top:'5%'
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    data: yearMonths,
                    axisLabel: {
                        interval:0,
                        rotate:-30
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
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
                    name: '配种失败',
                    type: 'line',
                    data: PZSB,
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
                    name: '带胎淘汰',
                    type: 'line',
                    data: DTTT,
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
                    name: '流产头数',
                    type: 'line',
                    data: LC,
                    itemStyle: {
                        normal: {
                            color: '#3c8dbc'
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

        var cattles = echarts.init($('.cattle_div')[0], echartsTheme);
        var option = {
            title: {
                text: '',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}头 ({d}%)"
            },
            legend: {
                bottom: '5%',
                x: 'center',
                data: ['超5次配种未受孕数', '带胎淘汰成乳牛数','流产头数']
            },
            series: [
                {
                    name: '',
                    type: 'pie',
                    radius: '40%',
                    center: ['50%', '50%'],
                    label: {
                        normal: {
                            formatter: "{c}头 \n ({d}%)"
                        }
                    },
                    data: [
                        {value: PZSB[11], name: '超5次配种未受孕数'},
                        {value: DTTT[11], name: '带胎淘汰成乳牛数'},
                        {value: LC[11], name: '流产头数'}
                        //{value: PZCGAll, name: '配种成功数'}
                    ],
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
            saleReport.resize();
        });
    }


</script>
</body>
<@footer/>
</html>
