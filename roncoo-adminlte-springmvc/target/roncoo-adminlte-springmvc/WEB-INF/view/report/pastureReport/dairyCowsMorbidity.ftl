<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>成乳牛发病率分析</title>
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
                <small>成乳牛发病率分析</small>
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
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">成乳牛发病率分析</h3>
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
                                                <input class="pull-right" type="text" id="everydayTime" style="position: absolute;right:12px;top:5px;z-index: 3;width: 130px">
                                                <div class="row">
                                                    <div class="col-md-7 col-sm-8">
                                                        <div class="group" style=" height: 300px;"></div>
                                                    </div>
                                                    <div class="col-md-5 col-sm-8">
                                                        <div class="five" style=" height: 300px;"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="chart tab-pane" id="sales-chart" style="position: relative; height: 300px;">
                                            <div class="box-body no-padding">
                                                <input class="pull-right" type="text" id="yearMonth" style="position: absolute;right:12px;top:5px;z-index: 3;width: 130px">
                                                <div class="row">
                                                    <div class="col-md-7 col-sm-8">
                                                        <div class="group_map" style=" height: 300px;"></div>
                                                    </div>
                                                    <div class="col-md-5 col-sm-8">
                                                        <div class="five_max" style=" height: 300px;"></div>
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
                            <div class="box box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">成乳牛发病数据分析(单位:头)</h3>
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
                                            <th rowspan="2">病种</th>
                                        <#list resultData.yearMonths as yearMonth>
                                            <th>${yearMonth}</th>
                                        </#list>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#assign map = resultData.data>
                                        <#assign number = 0>
                                        <#list map?keys as bz>
                                            <#if bz != '饲养头日数'>
                                            <tr>
                                                <td>${bz}</td>
                                                <#assign ymap = map[bz]>
                                                <#list ymap?keys as qj>
                                                    <#assign vmap = ymap[qj]>
                                                    <#if vmap["CRLFBL-TS"]==0>
                                                        <td>-</td>
                                                   <#else >
                                                    <td>${vmap["CRLFBL-TS"]}</td>
                                                    </#if>
                                                </#list>
                                            </tr>
                                            </#if>
                                        </#list>
                                        </tbody>
                                        <tfoot>
                                        <tr>
                                            <th>发病头数</th>
                                        <#assign fbl = fblData.swFvalues>
                                        <#list fbl as fvalue>
                                            <th>${fvalue}</th>
                                        </#list>
                                        </tr>

                                        <tr id="fbl">
                                            <th>发病率</th>
                                            <#assign fbl = fblData.ttFvalues>
                                            <#list fbl as fvalue>
                                                <th><span class="badge bg-yellow">${fvalue}%</span></th>
                                            </#list>
                                        </tr>
                                        </tfoot>
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
        dairyEveryAjax(yearMonths);
        dairyCowsMorbidityFiveMaxEveryAjax(yearMonths);
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
                dairyCowsMorbidity(yearMonth);
                dairyCowsMorbidityFive(yearMonth);
            });
            $('#yearMonth').datepicker( 'setDate' , '-0m' );
        });
    });


    function dairyCowsMorbidity(yearMonth) {
        $.ajax({
            url: "${ctx}/report/pastureReport/dairyCowsMorbidityAjax?company=${company}&yearMonth=" + yearMonth,
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
    function dairyCowsMorbidityFive(yearMonth) {
        $.ajax({
            url: "${ctx}/report/pastureReport/dairyCowsMorbidityFiveMaxAjax?company=${company}&yearMonth="+yearMonth,
            type: "get",
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                initFiveMax(jsonObj);
            },
            error: function () {
                console.log('错误');
            }
        });

    }
    function dairyEveryAjax(yearMonths) {
        $.ajax({
            url: "${ctx}/report/pastureReport/dairyEveryAjax?company=${company}&yearMonths="+yearMonths,
            type: "get",
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                initresult(jsonObj);
            },
            error: function () {
                console.log('错误');
            }
        });

    }
    function dairyCowsMorbidityFiveMaxEveryAjax(yearMonths) {
        $.ajax({
            url: "${ctx}/report/pastureReport/dairyCowsMorbidityFiveMaxEveryAjax?company=${company}&yearMonths="+yearMonths,
            type: "get",
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                FiveMax(jsonObj);
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
    function initresult(result) {
        var sxAxis = [];
        var swFvalue = [];
        var ttFvalue = [];
        for (var i = 0; i < result['yearMonths'].length; i++) {
            sxAxis.push(result['yearMonths'][i]);
            swFvalue.push(Math.floor(result['swFvalues'][i]));
            ttFvalue.push(Math.floor(result['ttFvalues'][i]));
        }
        var saleReport = echarts.init($(".group")[0]);
        var option2 = {
            title:{
                subtext:'单位:头',
                left:'5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['饲养头日数', '发病头数']
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
                        interval:1,
                        rotate:40
                    }
                }
            ],
            yAxis: [
                {
                    name:'饲养头日数',
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
                },
                {
                    name:'发病头数',
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
                    name: '饲养头日数',
                    type: 'bar',
                    data: ttFvalue,
                    yAxisIndex:0,
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
                    name: '发病头数',
                    type: 'bar',
                    data: swFvalue,
                    yAxisIndex:1,
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



    function FiveMax(result) {
        var cattle = [];
        var fvalues = [];
        if(result["resultList"].length>=5){
            for(var i = 0;i < 5;i++){
                cattle.push(result["resultList"][i].fsmallClass);
                fvalues.push({name:result["resultList"][i].fsmallClass,value:result["resultList"][i].fvalue});
            }
        }else {
            for(var i = 0;i < result["resultList"].length;i++){
                cattle.push(result["resultList"][i].fsmallClass);
                fvalues.push({name:result["resultList"][i].fsmallClass,value:result["resultList"][i].fvalue});
            }
        }
        var cattles = echarts.init($('.five')[0], echartsTheme);
        var option = {
            title: {
                text: '当日前5大病种',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}头 ({d}%)"
            },
            legend: {
                bottom: 20,
                left: 'center',
                data: cattle
            },
            series: [
                {
                    name: '病种',
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
    function init(result) {
        var sxAxis = [];
        var swFvalue = [];
        var ttFvalue = [];
        for (var i = 0; i < result['yearMonths'].length; i++) {
            sxAxis.push(result['yearMonths'][i]);
            swFvalue.push(Math.floor(result['swFvalues'][i]));
            ttFvalue.push(Math.floor(result['ttFvalues'][i]));
        }
        var saleReport = echarts.init($(".group_map")[0]);
        var option2 = {
            title:{
                subtext:'单位:头',
                left:'5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['饲养头日数', '发病头数']
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
                    axisLabel:{
                        interval:0,
                        rotate:-30,
                        margin: 30,
                        textStyle:{
                            color:'#0c180d',
                            align: 'center'

                        }
                    }
                }
            ],
            yAxis: [
                {
                    name:'饲养头日数',
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
                },
                {
                    name:'发病头数',
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
                    name: '饲养头日数',
                    type: 'bar',
                    data: ttFvalue,
                    yAxisIndex:0,
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
                    name: '发病头数',
                    type: 'bar',
                    data: swFvalue,
                    yAxisIndex:1,
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



    function initFiveMax(result) {
        var cattle = [];
        var fvalues = [];
        if(result["resultList"].length>0){
        for(var i = 0;i < 5;i++){
            cattle.push(result["resultList"][i].fsmallClass);
            fvalues.push({name:result["resultList"][i].fsmallClass,value:result["resultList"][i].fvalue});
            }
        }
        var cattles = echarts.init($('.five_max')[0], echartsTheme);
        var option = {
            title: {
                text: '当月前5大病种',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}头 ({d}%)"
            },
            legend: {
                bottom: 20,
                left: 'center',
                data: cattle
            },
            series: [
                {
                    name: '病种',
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

</script>
</body>
<@footer/>
</html>
