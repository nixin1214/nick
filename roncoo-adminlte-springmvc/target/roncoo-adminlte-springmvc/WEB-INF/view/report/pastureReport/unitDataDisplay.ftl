<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>单位指标分析</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
            ${company}
                <input type="hidden" id="company" value="${companyName}">
                <small>单位指标分析</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${company}</li>
            </ol>
        </section>
        <input type="hidden" id="orgCode" value="${company}">
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">单牛产量趋势图</h3>
                                    <div class="box-tools pull-right">
                                        <input type="text" id="securityTime" placeholder="选择期间...">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-8">
                                            <div class="singleCowYield" style="width: 100%; height: 350px;"></div>
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
                                    <h3 class="box-title">单位利润分析</h3>
                                    <div class="box-tools pull-right">
                                        <input type="text" id="selectTime" placeholder="选择期间...">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-8">
                                            <div class="unitProfit" style="width: 100%; height: 350px;"></div>
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
</div>
<@jsFile/>
<script type="text/javascript" src="dist/layer/layer.js" ></script>
<script type="text/javascript">
    $(window).load(function () {
        var el = $('.content-header');
        el.html(el.html().replace(/TYRY/ig, '天友乳业'));
        el.html(el.html().replace(/HSMRY/ig, '华山牧乳业'));
        el.html(el.html().replace(/TNMC/ig, '天宁牧场'));
        el.html(el.html().replace(/HSMC/ig, '华山牧场'));
    });

    var yearMonth = '';
    $('#securityTime').datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: true,
        startView: 1,
        maxViewMode: 1,
        minViewMode: 1
    }).on('changeDate', function () {
        yearMonth = $(this).val();
        unitYield(yearMonth);
    });
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
        unitDataDisplay(yearMonthone);
    });

    $(function () {
        $('#securityTime').datepicker('setDate', '-1m');//设置日期控件默认值,触发change事件
        $('#selectTime').datepicker('setDate', '-1m');//设置日期控件默认值,触发change事件
    });

    /**
     * 单牛产量走势图
     */
    function unitYield(yearMonth) {
        $.ajax({
            url:"${ctx}/report/pastureReport/singleCowYieldAjax?companyNumber=${company}&yearMonth="+yearMonth,
            type:"get",
            dataType:"text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                init(jsonObj);
            },
            error:function(){
                console.log('错误');
            }
        });

        function init(result) {
        var sxAxis=[];
        var SNFvalue=[];//泌乳牛日均产奶量
        var BQFvalue=[];//成乳牛日均产奶量
        for(var i=0;i<result['yearMonths'].length;i++){
            sxAxis.push(result['yearMonths'][i]);
            SNFvalue.push(Math.floor(result['MRN'][i]));
            BQFvalue.push(Math.floor(result['CRN'][i]));
        }
        var saleReport = echarts.init($(".singleCowYield")[0]);
        var option2 = {
            title:{
                subtext:'单位:千克',
                left:'5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['泌乳牛日均产量', '成乳牛日均产量']
            },
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                },
                right:'5%'
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    data: sxAxis,
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
                    },
                    axisLabel: {
                        formatter: '{value}'
                    }
                }
            ],
            series: [
                {
                    name: '泌乳牛日均产量',
                    type: 'line',
                    data: SNFvalue,
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
                    name: '成乳牛日均产量',
                    type: 'line',
                    data: BQFvalue,
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
    }

    /**
     * 单位利润分析图
     */
    function unitDataDisplay(yearMonthone) {
        $.ajax({
            url:"${ctx}/report/pastureReport/unitDataDisplayAjax?companyNumber=${company}&yearMonthone="+yearMonthone,
            type:"get",
            dataType:"text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                init(jsonObj);
            },
            error:function(){
                console.log('错误');
            }
        });
        function init(result) {
        var sxAxis=[];
        var SNFvalue=[];//单牛利润
        var unitEmp = [];//单人利润
        var perCapita = [];//人均头数
        var BQFvalue=[];//单奶成本
            console.log(result);
        for(var i=0;i<result['yearMonths'].length;i++){
            sxAxis.push(result['yearMonths'][i]);
            SNFvalue.push(Math.floor(result['resultData'][i][0]));
            unitEmp.push(Math.floor(result['resultData'][i][1]));
            perCapita.push(Math.floor(result['resultData'][i][2]));
            BQFvalue.push(Math.floor(result['resultData'][i][3]));
        }
        var saleReport = echarts.init($(".unitProfit")[0]);
        var option2 = {
            title:{
                subtext:'单位：元',
                left:'5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['单牛利润','单人利润', '单奶成本','人均头数']
            },
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                },
                right:'5%'
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    data: sxAxis,
                }
            ],
            yAxis: [
                {
                    name:'单位:元',
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
                    },
                    axisLabel: {
                        formatter: '{value}'
                    }
                },
                {
                    name:'单位:头',
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
                    },
                    axisLabel: {
                        formatter: '{value}'
                    }
                }
            ],
            series: [
                {
                    name: '单牛利润',
                    type: 'bar',
                    data: SNFvalue,
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
                    name: '单人利润',
                    type: 'bar',
                    data: unitEmp,
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
                    name: '单奶成本',
                    type: 'bar',
                    data: BQFvalue,
                    yAxisIndex: 0,
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
                    name: '人均头数',
                    type: 'bar',
                    data: perCapita,
                    yAxisIndex: 1,
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
                }
            ]
        };
        saleReport.setOption(option2);
        $(window).resize(function () {
            saleReport.resize();
        });
    }
    }


</script>
</body>
<@footer/>
</html>