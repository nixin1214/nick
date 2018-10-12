<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>牛奶产量及理化指标</title>
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
                <small>牛奶产量及理化指标分析</small>
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
                            <h3 class="box-title">产奶量分析</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i></button>
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
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div style="height: 3px;"></div>
                                            <div class="col-md-12 col-sm-8">
                                                <input class="pull-right" type="text" id="everydayTime" placeholder="选择期间..." style="position: absolute;right:28px;top:5px;z-index: 3">
                                                <div class="groupcattle" style="height: 300px;"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="chart tab-pane" id="sales-chart" style="position: relative; height: 300px;">
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div style="height: 3px;"></div>
                                            <div class="col-md-12 col-sm-8">
                                                <input class="pull-right" type="text" id="yearMonth" style="position: absolute;right:28px;top:5px;z-index: 3">
                                                <div class="group_map" style=" height: 300px;"></div>
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
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">平均产奶量数据(单位:千克)</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <table id="example2" class="table table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                        <#list resultData.yearMonths as yearMonth>
                                            <th>${yearMonth}</th>
                                        </#list>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list resultData?keys as key>
                                        <#if key!="yearMonths" && key!="ratio" && !key?contains("NNZLZB")>
                                        <tr>
                                            <td>${key}</td>
                                            <#assign resultList = resultData[key]>
                                            <#list resultList?keys as resultKey>
                                            <#assign result = resultList[resultKey]>
                                                <#if result==0>
                                                    <td>-</td>
                                                <#else >
                                                    <td>${result?floor}</td>
                                                </#if>
                                            </#list>
                                        </tr>
                                        </#if>
                                        </#list>
                                        <tr>
                                            <td>干奶牛比例</td>
                                        <#list resultData.ratio as ratio>
                                        <td><span class="badge bg-yellow">
                                            ${ratio*100}%</span></td>
                                        </#list>
                                        </tr>
                                        </tbody>
                                    </table>
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
                yieldAndIndex(yearMonth);
            });
            $('#yearMonth').datepicker( 'setDate' , '-0m' );
        });
    });

    function yieldAndIndex(yearMonth) {
        $.ajax({
           url:"${ctx}/report/pastureReport/yieldAndIndexAjax?companyNumber=${companyNumber}&company=${company}&yearMonth="+yearMonth,
           type:"get",
           dataType:"text",
           success:function (result) {
               var jsonObj = eval("("+result+")");
               init(jsonObj);
           },
            error:function () {
                console.log('错误');
            }
        });
    }
    function everydayChart(yearMonths) {
        $.ajax({
            url: "${ctx}/report/pastureReport/yieldAndIndexEveryAjax?companyNumber=${companyNumber}&company=${company}&yearMonths="+yearMonths,
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

    /**
     * 初始化
     */
    function everyChart(result) {
        var yearMonths = [];
        var monthYields = [];
        for (var i=0;i<result["yearMonth"].length;i++){
            yearMonths.push(result["yearMonth"][i]);
            monthYields.push(Math.floor(result["PJRCNL-QN"][i]/1000));
        }
        var saleReport = echarts.init($(".groupcattle")[0], echartsTheme);
        console.log(saleReport);
        var option2 = {
            title: {
                text: '',
                subtext: '单位:吨',
                left: '5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                orient: 'vertical',
                x: 'center',
                data: ['每日产奶量']
            },
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                },
                right:'20%'
            },
            calculable: true,
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
                    data: yearMonths
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
                    name: '每日产奶量',
                    type: 'line',
                    data: monthYields,
                    itemStyle: {
                        normal: {
                            color: '#2b6ba6'
                        }
                    }, markPoint: {
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
    function init(result) {
        var yearMonths = [];
        var monthYields = [];
        var somaticCells = [];
        var Microorganism = [];
        for (var i=0;i<result["yearMonths"].length;i++){
            yearMonths.push(result["yearMonths"][i]);
            monthYields.push(Math.floor(result["PJRCNL-QK"][i]/1000));
        }
        var saleReport = echarts.init($(".group_map")[0], echartsTheme);
        console.log(saleReport);
        var option2 = {
            title: {
                text: '',
                subtext: '单位:吨',
                left: '5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                orient: 'vertical',
                x: 'center',
                data: ['每月产奶量']
            },
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                },
                right:'20%'
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    data: yearMonths
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
                    name: '每月产奶量',
                    type: 'line',
                    data: monthYields,
                    itemStyle: {
                        normal: {
                            color: '#2b6ba6'
                        }
                    }, markPoint: {
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
