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
                ${companyName}
                <small>营业收入明细</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${companyName}</li>
            </ol>
        </section>
        <input type="hidden" id="companyNumber" value="${companyNumber}">

        <section class="content">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-aqua">
                        <span class="info-box-icon"><i class="fa fa-cny"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">天友乳业</span>
                            <span class="info-box-number">${TYRY[0]?floor}</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${beginTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 万元</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-green">
                        <span class="info-box-icon"><i class="fa fa-yen"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">华山牧乳业</span>
                            <span class="info-box-number">${HSMRY[0]?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${startTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 万元</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-yellow">
                        <span class="info-box-icon"><i class="fa fa-line-chart"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">天宁牧场</span>
                            <span class="info-box-number">${TNMC[0]?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${endTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 万元</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-purple">
                        <span class="info-box-icon"><i class="fa fa-line-chart"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">华山牧场</span>
                            <span class="info-box-number">${HSMC[0]?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${overTime}</span>
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
                            <h3 class="box-title">年度营收趋势图</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="selectTime" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
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
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">各公司本期营收分析</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="securityTime" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <div class="row">
                                <div class="col-md-7 col-sm-7">
                                    <div class="detailByYearMonthChart" style="width: 100%; height: 350px;"></div>
                                </div>
                                <div class="col-md-5 col-sm-5">
                                    <div class="branchProportionByYearMonthChart" style="width: 100%; height: 350px;"></div>
                                </div>
                            </div>
                            <div class="row">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <#--<div class="row">-->
                <#--<div class="col-md-12">-->
                    <#--<div class="box box-primary">-->
                        <#--<div class="box-header">-->
                            <#--<h3 class="box-title">主营业务收支汇总表</h3>-->
                            <#--<div class="box-tools pull-right">-->
                                <#--<input type="text" id="selectTime" placeholder="选择期间...">-->
                                <#--<button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>-->
                                <#--</button>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<!-- /.box-header &ndash;&gt;-->
                        <#--<div class="box-body">-->
                            <#--<table id="example2" class="table table-bordered table-hover" style="font-size: 11px;">-->
                                <#--<thead>-->
                                    <#--<tr>-->
                                        <#--<th rowspan="2">产品项目</th>-->
                                        <#--<th colspan="2">产品销量(吨)</th>-->
                                        <#--<th colspan="3">主营业务净收入(元、元/吨)</th>-->
                                        <#--<th colspan="3">主营业务成本(元、元/吨)</th>-->
                                        <#--<th colspan="5">销售毛利</th>-->
                                    <#--</tr>-->
                                    <#--<tr>-->
                                        <#--<th>预算</th>-->
                                        <#--<th>实际</th>-->
                                        <#--<th>单位预算</th>-->
                                        <#--<th>单位实际</th>-->
                                        <#--<th>总额</th>-->
                                        <#--<th>单位预算</th>-->
                                        <#--<th>单位实际</th>-->
                                        <#--<th>总额</th>-->
                                        <#--<th>单位预算</th>-->
                                        <#--<th>单位实际</th>-->
                                        <#--<th>预算毛利率</th>-->
                                        <#--<th>实际毛利率</th>-->
                                        <#--<th>总额</th>-->
                                    <#--</tr>-->
                                <#--</thead>-->
                                <#--<tbody id="tbody">-->
                                <#--</tbody>-->
                            <#--</table>-->
                        <#--</div>-->
                        <#--<!-- /.box-body &ndash;&gt;-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
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
        minViewMode:1
    }).on('changeDate',function () {
        yearMonth = $(this).val();
        //summaryDataAjax(yearMonth);
        businessIncomeDetailAjax(yearMonth);
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
        annualRevenueTrends(yearMonthone);
        businessAjax(yearMonthone);
    });

    $(function () {
        $('#securityTime').datepicker( 'setDate' , '-1m' );//设置日期控件默认值,触发change事件
        $('#selectTime').datepicker( 'setDate' , '-1m' );//设置日期控件默认值,触发change事件
    });
    function businessAjax(yearMonthone) {
        $.ajax({
            url: "${ctx}/report/groupReport/businessAjax?companyNumber=${companyNumber}&yearMonthone="+yearMonthone,
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

    /**
     * 获取年度营收趋势图数据
     */
    function annualRevenueTrends(yearMonthone) {
        $.ajax({
            url: "${ctx}/report/groupReport/annualRevenueTrendsAjax?companyNumber=${companyNumber}&yearMonthone=" + yearMonthone,
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
        function init(result) {
            var sxAxis = [];//x轴数据
            var seriesYYSR = [];//营业收入
            var seriesYYSRYS = [];//营业收入预算
            var seriesYYSRBQSN = [];//营业收入本期上年

            for (var i = 0; i < result['axisx'].length; i++) {
                sxAxis.push(result['axisx'][i]);
                seriesYYSR.push(Math.floor(result['YYSR'][i]));
                seriesYYSRYS.push(Math.floor(result['YYSRYS'][i].toFixed(0)));
                seriesYYSRBQSN.push(Math.floor(result['YYSRBQSN'][i].toFixed(0)));
            }
            var saleReport = echarts.init($(".businessIncomeChart")[0], echartsTheme);
            var option2 = {
                title: {
                    text: '',
                    subtext: '单位:万元',
                    left: 40
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    orient: 'horizontal',
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
                        name: '本期',
                        type: 'line',
                        data: seriesYYSR,
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
                        data: seriesYYSRYS,
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
                        data: seriesYYSRBQSN,
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
    /**
     * 各个公司年度应收趋势图
    */
    /**
     * 按期间展示各分公司资产指标
     */
    function businessIncomeDetailAjax(yearMonth) {
        var companyNumber = $("#companyNumber").val();
        $.ajax({
            url: "${ctx}/report/groupReport/businessIncomeDetailAjax?companyNumber=${companyNumber}",
            type: "get",
            data: {'yearMonth' :yearMonth},
            dataType: "text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                init(jsonObj);
                initAll(jsonObj);
            },
            error:function(){
                console.log('错误');
            }
        });
        /**
         * 柱状图
         * */
        function init(result) {
            var propertis = {TYRY:'天友',HSMRY:'华山牧',TNMC:'天宁',HSMC:'华山',ZKGYL:'供应链',THMY:'天鸿'};//
            var legend = [];//图例数据
            var sxAxis = [];//X轴数据
            var seriesCN = [];//成本
            var seriesJSR = [];//净收入
            for(key in result){
                if(key == 'axisx'){
                    legend = result['axisx'];
                }else {
                    sxAxis.push(propertis[key]);
                    seriesCN.push(Math.floor(result[key][0]));
                    seriesJSR.push(Math.floor(result[key][1]));
                }
            }
            if(legend[0] == null){
                legend = ["主营业务成本","主营业务净收入"];
            }
            var saleReport = echarts.init($(".detailByYearMonthChart")[0], echartsTheme);
            var option = {
                title: {
                    //text: '本期营收趋势图',
                    subtext: '单位:万元',
                    left: 10
                },
                toolbox: {
                    show: true,
                    feature: {
                        dataView: {show: true, readOnly: false},
                        magicType: {
                            show: true,
                            type: ['line', 'bar']
                        },
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                legend: {
                    data: legend,
                    x: 'center',
                    top:10
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: true,
                    data: sxAxis
                },
                yAxis: {
                    type: 'value',
                    splitArea: {show: false},
                    axisLabel: {
                        formatter: '{value}'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '10%',
                    containLabel: true
                },
                series: [
                    {
                        name: '主营业务成本',
                        type: 'bar',
                        data: seriesCN
                    },
                    {
                        name: '主营业务净收入',
                        type: 'bar',
                        data: seriesJSR
                    }
                ]
            };
            saleReport.setOption(option);

            $(window).resize(function () {
                saleReport.resize();
            });
        }

        /**饼图
         * 按期间展示各分公司占比
         */
        function initAll(result) {
            var axisx = [];
            var seriesTYRY = [];//天友乳业数据
            var propertis = {TYRY:'天友',HSMRY:'华山牧',TNMC:'天宁',HSMC:'华山',ZKGYL:'供应链',THMY:'天鸿'};//
            for(key in result){
                if (key != 'axisx'){
                    if(result[key][1]!=0){
                        seriesTYRY.push({name:propertis[key],value:Math.floor(result[key][1])});
                        axisx.push(propertis[key]);
                    }
                }
            }
            console.log(result);
            console.log(seriesTYRY);
            var branchProportion = echarts.init($('.branchProportionByYearMonthChart')[0], echartsTheme);
            var option = {
                title: {
                    text: '主营业务净收入分布',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c}万 ({d}%)"
                },
                legend: {
                    bottom: 20,
                    left: 'center',
                    data: axisx
                },
                series: [
                    {
                        name: '资产总额',
                        type: 'pie',
                        radius: '45%',
                        center: ['50%', '50%'],
                        label: {
                            normal: {
                                formatter: '{b}：{c}万'
                            }
                        },
                        data: seriesTYRY,
                        animationType: 'scale',
                        animationEasing: 'elasticOut',
                        animationDelay: function (idx) {
                            return Math.random() * 200;
                        }
                    }
                ]
            };
            branchProportion.setOption(option);
            $(window).resize(function () {
                branchProportion.resize();
            });
        }
    }




    /**
     * 加载主营业务收支汇总表数据
     */
    function summaryDataAjax(yearMonth) {
        $("#tbody").empty();
        var companyNumber = $("#companyNumber").val();
        var rowIndex = [30,31,32,33,34,35,36,38,39,40,41,42];
        $.ajax({
            url:"${ctx}/report/pastureReport/summaryDataAjax",
            type:"post",
            dataType:"text",
            traditional: true,
            data:{"yearMonth":yearMonth,"companyNumber":companyNumber,"rowIndex":rowIndex},
            success:function (result) {
                var jsonObj = eval("("+result+")");
                for (var key in jsonObj){
                    if(jsonObj[key][0]!='-') {
                        $("#tbody").append("<tr id=" + key + "></tr>");
                        var trId = "#" + key;
                        for (var i = 0; i < jsonObj[key].length; i++) {
                            $(trId).append("<td>" + (jsonObj[key][i] == 0 ? '-' : jsonObj[key][i]) + "</td>");
                        }
                    }
                }
            },
            error:function () {
                console.log('错误');
            }
        });
    }
    function initSumMonth(result) {
        var axAxis = [];
        var seriesData = [];//数据
        console.log(result['resultList']);
        if (result['axisx'][0]!=null){
            seriesData.push({name:'本年',value:Math.floor(result['resultList'][0])});
            axAxis.push('本年');
        }
        if (result['axisx'][1]!=null){
            seriesData.push({name:'上年',value:Math.floor(result['resultList'][1])});
            axAxis.push('上年');
        }
        var businessChart = echarts.init($('.businessChart')[0], echartsTheme);
        var option = {
            title : {
                text: '年度同期营收累计对比',
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
                    center: ['50%', '50%'],
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
