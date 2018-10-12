<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>平均每日饲料成本</title>
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
                <small>平均每日饲料成本</small>
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
                                    <h3 class="box-title">平均每日饲料成本分析</h3>
                                    <div class="box-tools pull-right">
                                        <input type="text" id="yearMonth">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-8">
                                            <div class="group_map" style="width: 100%; height: 350px;"></div>
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
                                    <h3 class="box-title">平均每日饲料成本(元)</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <table id="example2" class="table table-bordered table-hover" style="overflow-x: scroll; font-size: 11px;">
                                        <thead>
                                        <tr>
                                            <th style="text-align: center" colspan="2">#</th>
                                            <#list resultData.yearMonths as yearMonth>
                                                <th>${yearMonth}</th>
                                            </#list>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#assign map = resultData.data>
                                        <#list map?keys as name>
                                        <tr>
                                            <td rowspan="3" class="text-center">${name}</td>
                                            <#assign quotaMaps = map[name]>
                                            <td>每日成本</td>
                                            <#list quotaMaps.PJMRSLCB as quotaPJMRSLCB>
                                                <#if quotaPJMRSLCB.fvalue==0>
                                                    <td>-</td>
                                                <#else >
                                                <td>${quotaPJMRSLCB.fvalue}</td>
                                                </#if>
                                            </#list>
                                        </tr>
                                        <tr>
                                            <td>饲养头日</td>
                                            <#list quotaMaps.SYTR as quotaSYTR>
                                                <#if quotaSYTR.fvalue==0>
                                                    <td>-</td>
                                                <#else >
                                                <td>${quotaSYTR.fvalue}</td>
                                                </#if>
                                            </#list>
                                        </tr>
                                        <tr>
                                            <td>每月成本</td>
                                            <#list quotaMaps.YSLCB as quotaYSLCB>
                                                <#if quotaYSLCB.fvalue==0>
                                                    <td>-</td>
                                                <#else >
                                                <td>${quotaYSLCB.fvalue}</td>
                                                </#if>
                                            </#list>
                                        </tr>
                                        </#list>
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
        avgFeedCost(yearMonth);
    });
    $(function () {
        $('#yearMonth').datepicker( 'setDate' , '-1m' );//设置日期控件默认值,触发change事件
    });

    function avgFeedCost(yearMonth) {
        $.ajax({
            url: "${ctx}/report/pastureReport/avgFeedCostAjax?company=${company}&yearMonth="+yearMonth,
            type: "get",
            dataType: "text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                init(jsonObj);
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
        var saleReport = echarts.init($(".group_map")[0]);
        console.log(saleReport);

        var sxAxis=[];//月份数据
        var seriesDN=[];//犊牛数据
        var seriesCRN=[];//成乳牛数据
        var seriesQNN=[];//青年牛数据
        var seriesGNN=[];//干奶牛数据
        var seriesMRN=[];//泌乳牛数据
        for(var i = 0; i < result['yearMonths'].length; i++){
            sxAxis.push(result['yearMonths'][i]);
            if (result['犊牛'] != null) {
                seriesDN.push(result['犊牛'][i]);
            }
            if (result['成乳牛'] != null) {
                seriesCRN.push(result['成乳牛'][i]);
            }
            if (result['青年牛'] != null) {
                seriesQNN.push(result['青年牛'][i]);
            }
            if (result['干奶牛'] != null) {
                seriesGNN.push(result['干奶牛'][i]);
            }
            if (result['泌乳牛'] != null) {
                seriesMRN.push(result['泌乳牛'][i]);
            }
        }
        var option2 = {
            title : {
                subtext: '单位:元',
                left: 'left'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: [{
                x:'center',
                data: ['泌乳牛', '干奶牛','成乳牛', '青年牛','犊牛']
            }
//                ,{
//                    x:'left',
//                    top:'5%',
//                    data: [ '青年牛','犊牛']
//                }
                    ],
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
                    name: '泌乳牛',
                    type: 'line',
                    data: seriesMRN,
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
                    name: '干奶牛',
                    type: 'line',
                    data: seriesGNN,
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
                    name: '成乳牛',
                    type: 'line',
                    data: seriesCRN,
                    itemStyle: {
                        normal: {
                            color: '#a53da6'
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
                    name: '青年牛',
                    type: 'line',
                    data: seriesQNN,
                    itemStyle: {
                        normal: {
                            color: '#2325a6'
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
                    name: '犊牛',
                    type: 'line',
                    data: seriesDN,
                    itemStyle: {
                        normal: {
                            color: '#a6a426'
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
