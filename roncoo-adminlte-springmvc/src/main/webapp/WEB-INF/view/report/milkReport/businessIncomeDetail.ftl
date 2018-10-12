<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>营业收入明细</title>
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
                <small>营业收入明细</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${company}</li>
            </ol>
        </section>
        <input type="hidden" id="companyNumber" value="${company}">

        <section class="content">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-aqua">
                        <span class="info-box-icon"><i class="fa fa-cny"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">本期累计营收</span>
                            <span class="info-box-number">
                                <#if resultList?exists>
                                    ${resultList[0]?floor}
                                </#if>
                                </span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <#assign yesrmx = result[1]>
                            <span class="fa fa-calendar">  ${yesrmx}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 万元</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-green">
                        <span class="info-box-icon"><i class="fa fa-yen"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">本年累计营收</span>
                            <span class="info-box-number">
                            <#if resultList?exists>
                                    ${resultList[1]?floor}
                            </#if>
                            </span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${yesrmx}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 万元</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-yellow">
                        <span class="info-box-icon"><i class="fa fa-line-chart"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">上月环比</span>
                            <span class="info-box-number">
                            <#if (resultList[3]>0)>
                                ${(resultList[0]-resultList[3])/resultList[3]*100}
                            <#elseif (resultList[3]<0) >
                                ${(1-resultList[0]/resultList[3])*100}
                            <#else>
                                0
                            </#if>
                                %
                                </span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="progress-description">相比${result[0]?substring(0,4)}年${result[0]?substring(4,6)}月</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-purple">
                        <span class="info-box-icon"><i class="fa fa-line-chart"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">去年同比</span>
                            <span class="info-box-number">
                            <#if (resultList[2]>0)>
                                ${(resultList[0]-resultList[2])/resultList[2]*100}
                            <#elseif (resultList[2]<0) >
                                ${(1-resultList[0]/resultList[2])*100}
                            <#else>
                                0
                            </#if>
                                %
                                </span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="progress-description">相比${lastMonth?substring(0,4)}年${lastMonth?substring(4,6)}月</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">年度营收趋势图</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="selectTime" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <div class="row">
                                <div class="col-md-7 col-sm-8">
                                    <div class="businessIncomeChart" style="width: 100%; height: 350px;"></div>
                                </div>
                                <div class="col-md-5 col-sm-8">
                                    <div class="businessChart" style="width: 100%; height: 350px;"></div>
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
                            <h3 class="box-title">主营业务收支汇总表</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="securityTime" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover" style="font-size: 11px;">
                                <thead>
                                <tr>
                                    <th rowspan="2">产品项目</th>
                                    <th colspan="2">产品销量(吨)</th>
                                    <th colspan="3">主营业务净收入(元、元/吨)</th>
                                    <th colspan="3">主营业务成本(元、元/吨)</th>
                                    <th colspan="5">销售毛利</th>
                                </tr>
                                <tr>
                                    <th>预算</th>
                                    <th>实际</th>
                                    <th>单位预算</th>
                                    <th>单位实际</th>
                                    <th>总额</th>
                                    <th>单位预算</th>
                                    <th>单位实际</th>
                                    <th>总额</th>
                                    <th>单位预算</th>
                                    <th>单位实际</th>
                                    <th>预算毛利率</th>
                                    <th>实际毛利率</th>
                                    <th>总额</th>
                                </tr>
                                </thead>
                                <tbody id="tbody">
                                <tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<@jsFile/>

<script type="text/javascript">

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
        summaryDataAjax(yearMonth);
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
        businessIncomeDetail(yearMonthone);
    });

    $(function () {
        $('#securityTime').datepicker('setDate', '-1m');//设置日期控件默认值,触发change事件
        $('#selectTime').datepicker('setDate', '-1m');//设置日期控件默认值,触发change事件
    });
    function businessIncomeDetail(yearMonthone) {
        $.ajax({
            url: "${ctx}/report/milkReport/businessIncomeDetailAjax?companyNumber=${companyNumber}&company=${company}&yearMonthone="+yearMonthone,
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
        $.ajax({
            url: "${ctx}/report/milkReport/businessAjax?companyNumber=${companyNumber}&company=${company}&yearMonthone="+yearMonthone,
            type: "get",
            dataType: "text",
            success: function (result) {
                var jsonObj = eval('(' + result + ')');
                initSumMonth(jsonObj);
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

    //加载主营业务收支汇总表数据
    function summaryDataAjax(yearMonth) {
        $("#tbody").empty();
        var companyNumber = $("#companyNumber").val();
        $.ajax({
            url: "${ctx}/report/milkReport/businessDataAjax",
            type: "post",
            dataType: "text",
            traditional: true,
            data: {"yearMonth": yearMonth, "companyNumber": companyNumber},
            success: function (result) {
                var jsonObj = eval("(" + result + ")");
                console.log(jsonObj);
                for (var key in jsonObj) {
                    $("#tbody").append("<tr id=" + key + "></tr>");
                    var trId = "#" + key;
                    for (var i = 0; i < jsonObj[key].length; i++) {
                        if(i!=0&&jsonObj[key][i]!=0){
                            if(i!=11&&i!=12){
                                $(trId).append("<td>" + Math.floor(jsonObj[key][i]) + "</td>");
                            }else {
                                $(trId).append("<td>" + jsonObj[key][i].toFixed(2) + "</td>");
                            }
                        }else if(i==0&&jsonObj[key][i]!=0){
                            $(trId).append("<td>" +  jsonObj[key][i] + "</td>");
                        }else{
                            $(trId).append("<td>" +  "-" + "</td>");
                        }


                    }
                }
            },
            error: function () {
                alert("错误");
            }
        });
    }

    /**
     * 初始化
     */
    function init(result) {
        var saleReport = echarts.init($(".businessIncomeChart")[0], echartsTheme);
        var sxAxis = [];//x轴数据
        var seriesZYYWCB = [];//营业收入数据
        var seriesZYYWJSR = [];//营业收入预算数据
        var ZHZBSN = [];//去年同期数据
        for (var i = 0; i < result['axisx'].length; i++) {
            sxAxis.push(result['axisx'][i]);
            seriesZYYWCB.push(Math.floor(result['ZYYWCB'][i]));
            seriesZYYWJSR.push(Math.floor(result['ZYYWJSR'][i]));
            ZHZBSN.push(Math.floor(result['ZHZBSN'][i]));
        }
        var option2 = {
            title: {
                text: '',
                subtext: '单位:万元',
                left: 'left'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                //orient: 'vertical',
                x: 'center',
                data: ['本期', '预算','上年同期'],
                top:10
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
            grid: {
                left: '3%',
                right: '4%',
                bottom: '2%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    data: sxAxis,
                    axisLabel:{
                        interval:0,
                        rotate:-20,
                        margin: 30,
                        textStyle:{
                            color:'#0c180d',
                            align: 'center'

                        },
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
            series: [
                {
                    name: '本期',
                    type: 'line',
                    data: seriesZYYWCB,
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
                    name: '预算',
                    type: 'line',
                    data: seriesZYYWJSR,
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
                },
                {
                    name: '上年同期',
                    type: 'line',
                    data: ZHZBSN,
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
    function initSumMonth(result) {
        var axAxis = [];
        var seriesData = [];//数据
        if (result['axisx'][0]!=null){
            seriesData.push({name:'本年累计营收',value:Math.floor(result['resultList'][0])});
            axAxis.push('本年累计营收');
        }
        if (result['axisx'][1]!=null){
            seriesData.push({name:'上年同期累计营收',value:Math.floor(result['resultList'][1])});
            axAxis.push('上年同期累计营收');
        }
        var businessChart = echarts.init($('.businessChart')[0], echartsTheme);
        var option = {
            title : {
                text: '年度同期累计对比',
                left: 'center',
                top:20
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}万 ({d}%)"
            },
            legend: {
                bottom: 20,
                left: 'center',
                data:axAxis
            },
            series: [
                {
                    name:'',
                    type:'pie',
                    radius: ['35%', '50%'],
                    label: {
                        normal: {
                            formatter: '{b}：\r\n{c}万'
                        }
                    },
                    data:seriesData,
                    animationType: 'scale',
                    animationEasing: 'elasticOut',
                    animationDelay: function (idx) {
                        return Math.random() * 200;
                    }
                }
            ]
        };
        businessChart.setOption(option);
        $(window).resize(function () {
            businessChart.resize();
        });
    }
</script>
</body>
<@footer/>
</html>

