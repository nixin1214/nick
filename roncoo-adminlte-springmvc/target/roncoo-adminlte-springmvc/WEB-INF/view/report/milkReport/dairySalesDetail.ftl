<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>乳制品销量明细</title>
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
                <small>销售分析</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${company}</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-aqua">
                        <span class="info-box-icon"><i class="fa fa-database"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">低温奶</span>
                            <span class="info-box-number">${(resultData[0])?floor}</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${beginTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 吨</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-green">
                        <span class="info-box-icon"><i class="fa fa-database"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">常温奶</span>
                            <span class="info-box-number">${(resultData[1])?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${beginTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 吨</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-yellow">
                        <span class="info-box-icon"><i class="fa fa-cubes"></i></span>

                        <div class="info-box-content">
                            <#if company=="HSMRY">
                            <span class="info-box-text">学生奶</span>
                            <span class="info-box-number">${(resultData[2])?floor}</span>
                            <#else >
                                <span class="info-box-text">奶粉</span>
                                <span class="info-box-number">${(resultData[4])?floor}</span>
                            </#if>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${beginTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 吨</span>

                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-purple">
                        <span class="info-box-icon"><i class="fa fa-rmb"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">净收入</span>
                            <span class="info-box-number">${(resultData[3])?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${beginTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 万元</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">年度销量趋势图</h3>
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
        dairySalesDetail(yearMonthone);
    });

    $(function () {
        $('#selectTime').datepicker( 'setDate' , '-1m' );//设置日期控件默认值,触发change事件
    });

    function dairySalesDetail(yearMonthone) {
        $.ajax({
            url: "${ctx}/report/milkReport/dairySalesDetailAjax?companyNumber=${companyNumber}&company=${company}&yearMonthone="+yearMonthone,
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
        var saleReport = echarts.init($(".businessIncomeChart")[0], echartsTheme);
        console.log(result);
        var sxAxis = [];//x轴数据
        var seriesGTNF = [];//学生奶数据
        var seriesDWN = [];//低温奶数据
        var seriesCWN = [];//常温奶数据
        var seriesNF = [];//常温奶数据
        for (var i = 0; i < result['axisx'].length; i++) {
            sxAxis.push(result['axisx'][i]);
            seriesGTNF.push(Math.floor(result['GTNF'][i]));
            seriesDWN.push(Math.floor(result['DWN'][i]));
            seriesCWN.push(Math.floor(result['CWN'][i]));
            seriesNF.push(Math.floor(result['NF'][i]));
        }
        if(result['company']=='HSMRY'){
            var option2 = {
                title: {
                    text: '',
                    subtext: '单位：吨',
                    left: '5%'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    //orient: 'vertical',
                    y: 'top',
                    data: ['学生奶','低温奶', '常温奶']
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
                grid: {
                    y: 75
                },
                xAxis: [
                    {
                        type: 'category',
                        data: sxAxis
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '液体奶销售量',
                        position: 'left',
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
                        name: '学生奶销售量',
                        position: 'right',
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
                        name: '低温奶',
                        type: 'line',
                        data: seriesDWN,
                        itemStyle: {
                            normal: {
                                color:'#00c0ef',
                                lineStyle:{
                                    color:'#00c0ef'
                                }
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
                        name: '常温奶',
                        type: 'line',
                        data: seriesCWN,
                        itemStyle: {
                            normal: {
                                color:'#00a65a',
                                lineStyle:{
                                    color:'#00a65a'
                                }
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
                        name: '学生奶',
                        type: 'line',
                        data: seriesGTNF,
                        itemStyle: {
                            normal: {
                                color:'#db8b0b',
                                lineStyle:{
                                    color:'#db8b0b'
                                }
                            }
                        },
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        yAxisIndex: 1
                    }
                ]
            };
        }else{
            var option2 = {
                title: {
                    text: '',
                    subtext: '单位：吨',
                    left: '5%'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    //orient: 'vertical',
                    y: 'top',
                    data: ['奶粉','低温奶', '常温奶']
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
                grid: {
                    y: 75
                },
                xAxis: [
                    {
                        type: 'category',
                        data: sxAxis
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '液体奶销售量',
                        position: 'left',
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
                        name: '奶粉销售量',
                        position: 'right',
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
                        name: '低温奶',
                        type: 'line',
                        data: seriesDWN,
                        itemStyle: {
                            normal: {
                                color:'#00c0ef',
                                lineStyle:{
                                    color:'#00c0ef'
                                }
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
                        name: '常温奶',
                        type: 'line',
                        data: seriesCWN,
                        itemStyle: {
                            normal: {
                                color:'#00a65a',
                                lineStyle:{
                                    color:'#00a65a'
                                }
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
                        name: '奶粉',
                        type: 'line',
                        data: seriesNF,
                        itemStyle: {
                            normal: {
                                color:'#db8b0b',
                                lineStyle:{
                                    color:'#db8b0b'
                                }
                            }
                        },
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        yAxisIndex: 1
                    }
                ]
            };
        }

        saleReport.setOption(option2);

        $(window).resize(function () {
            saleReport.resize();
        });
    }
</script>
</body>
<@footer/>
</html>
