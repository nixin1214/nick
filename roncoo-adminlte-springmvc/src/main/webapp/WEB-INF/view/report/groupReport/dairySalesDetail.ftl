<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>乳制品销售明细</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
            ${companyName}
                <small>乳制品销量明细</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${companyName}</li>
            </ol>
        </section>

        <section class="content">
            <small>天友乳业</small>
            <div class="row">
                <div class="col-md-4 col-sm-6 col-xs-12">
                    <div class="info-box bg-aqua">
                        <span class="info-box-icon"><i class="fa fa-database"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">低温奶销量</span>
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
                <div class="col-md-4 col-sm-6 col-xs-12">
                    <div class="info-box bg-green">
                        <span class="info-box-icon"><i class="fa fa-database"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">常温奶销量</span>
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
                <div class="col-md-4 col-sm-6 col-xs-12">
                    <div class="info-box bg-yellow">
                        <span class="info-box-icon"><i class="fa fa-cubes"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">奶粉销量</span>
                            <span class="info-box-number">${(resultData[2])?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${beginTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 吨</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>

            </div>
            <small>华山牧乳业</small>
            <div class="row">
                <div class="col-md-4 col-sm-6 col-xs-12">
                    <div class="info-box bg-aqua">
                        <span class="info-box-icon"><i class="fa fa-database"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">低温奶销量</span>
                            <span class="info-box-number">${(result[0])?floor}</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${endTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 吨</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 col-xs-12">
                    <div class="info-box bg-green">
                        <span class="info-box-icon"><i class="fa fa-database"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">常温奶销量</span>
                            <span class="info-box-number">${(result[1])?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${endTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 吨</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 col-xs-12">
                    <div class="info-box bg-yellow">
                        <span class="info-box-icon"><i class="fa fa-cubes"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">奶粉销量</span>
                            <span class="info-box-number">${(result[2])?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${endTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 吨</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>

            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">销售额趋势图</h3>
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
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">成员单位销量对比</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="securityTime" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <div class="row">
                                <div class="col-md-6 col-sm-6">
                                    <div class="branchProportionChart" style="width: 100%; height: 350px;"></div>
                                </div>
                                <div class="col-md-6 col-sm-6">
                                    <div class="branchProportionByYearMonthChart" style="width: 100%; height: 350px;"></div>
                                </div>
                            </div>
                        </div>
                        <div class="box-body no-padding" style="border-top: dashed 1px #a09e9e;">
                            <div class="row">
                                <div class="col-md-6 col-sm-6">
                                    <div class="branchProportion" style="width: 100%; height: 350px;"></div>
                                </div>
                                <div class="col-md-6 col-sm-6">
                                    <div class="branchProportionByYear" style="width: 100%; height: 350px;"></div>
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
    var yearMonth ='';
    var yearMonths ='';
    $('#securityTime').datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: true,
        startView: 1,
        maxViewMode: 1,
        minViewMode:1
    }).on('changeDate',function (ev) {
        yearMonth = $(this).val();
        salesComparison(yearMonth);
    });
    $('#selectTime').datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: true,
        startView: 1,
        maxViewMode: 1,
        minViewMode:1
    }).on('changeDate',function (ev) {
        yearMonths = $(this).val();
        revenueTrends(yearMonths);
    });

    $(function () {

        $('#securityTime').datepicker( 'setDate' , '-1m' );//设置日期控件默认值,触发change事件
        $('#selectTime').datepicker( 'setDate' , '-1m' );
    });

    /**
     * 年度营收趋势图
     */
    function revenueTrends(yearMonths) {
        $.ajax({
            url: "${ctx}/report/groupReport/revenueTrendsAjax?companyNumber=${companyNumber}&yearMonths=" + yearMonths,
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
            var seriesGTNF = [];//奶粉数据
            var seriesDWN = [];//低温奶数据
            var seriesCWN = [];//常温奶数据
            for (var i = 0; i < result['axisx'].length; i++) {
                sxAxis.push(result['axisx'][i]);
                seriesGTNF.push(Math.floor(result['GTNF'][i]));
                seriesDWN.push(Math.floor(result['DWN'][i]));
                seriesCWN.push(Math.floor(result['CWN'][i]));
            }
            var saleReport = echarts.init($(".businessIncomeChart")[0], echartsTheme);
            console.log(saleReport);
            var option2 = {
                title: {
                    text: '',
                    subtext: '单位:万元',
                    left: '5%'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    //orient: 'vertical',
                    y: 'top',
                    data: ['奶粉', '低温奶', '常温奶']
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
                        name: '液体奶销售额',
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
                        name: '奶粉销售额',
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
                        itemStyle : {
                            normal : {
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
                        itemStyle : {
                            normal : {
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
                        data: seriesGTNF,
                        itemStyle : {
                            normal : {
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
            saleReport.setOption(option2);

            $(window).resize(function () {
                saleReport.resize();
            });
        }

    /**
     * 获取上一个月
     *
     * @date 格式为yyyy-mm-dd的日期，如：2014-01-25
     */
    function getPreMonth(date) {
        var year = date.getFullYear(); //获取当前日期的年份
        var month = date.getMonth(); //获取当前日期的前一个月月份 0-11
        var year2 = year;
        if (month == 0) {//翻年
            year2 = parseInt(year2) - 1;
            month = 12;
        } else if (month < 10) {
            month = '0' + month;
        }
        var t2 = year2 + '' + month;
        return t2;
    }

    /**
     * 分公司销量对比
     */
    function salesComparison(yearMonth) {
        $.ajax({
            url: "${ctx}/report/groupReport/salesComparisonAjax?companyNumber=${companyNumber}",
            type: "get",
            data: {'yearMonth' :yearMonth},
            dataType: "text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                branchProportionChart(jsonObj);
                branchProportionByYearMonth(jsonObj);
                branchProportionByYear(jsonObj);
                branchProportion(jsonObj);
            },
            error:function(){
                console.log('错误');
            }
        });
    }
    
    /**
     * 分公司销量对比-营收趋势图
     */
    function branchProportionChart(result) {
        var sxAxis = [];//x轴数据
        var seriesTYRY = [];//天友乳业数据
        var seriesHSMRY = [];//华山牧乳业数据
        var seriesZKRY = [];//中垦乳业数据
        for (var i = 0; i < result['axisx'].length-1; i++) {
            sxAxis.push(result['axisx'][i]);
            seriesTYRY.push(Math.floor(result['TYRY'][i]));
            seriesHSMRY.push(Math.floor(result['HSMRY'][i]));
            //seriesZKRY.push(Math.floor(result['ZKRY'][i]));
        }
        if(sxAxis[0] == null){
            sxAxis = ["低温奶销量","常温奶销量","奶粉销量"];
        }
        var saleReport = echarts.init($(".branchProportionChart")[0], echartsTheme);
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
                //orient: 'vertical',
                y: 'top',
                data: ['天友乳业', '华山牧乳业']
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
                    name: '天友乳业',
                    type: 'bar',
                    data: seriesTYRY,
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
                    name: '华山牧乳业',
                    type: 'bar',
                    data: seriesHSMRY,
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
//                {
//                    name: '中垦乳业',
//                    type: 'bar',
//                    data: seriesZKRY,
//                    itemStyle: {
//                        normal: {
//                            //color: '#00c0ef'
//                        }
//                    },
//                    markPoint: {
//                        data: [
//                            {type: 'max', name: '最大值'},
//                            {type: 'min', name: '最小值'}
//                        ]
//                    }
//                }
            ]
        };
        saleReport.setOption(option2);

        $(window).resize(function () {
            saleReport.resize();
        });
    }


    /**
     * 分公司销量对比-销量占比图
     */
    function branchProportionByYearMonth(result) {
        var axisx = [];
        var seriesData = [];//数据
        var tyData = 0;
        var hsData = 0;
        var zkData = 0;
        for(var i = 0;i < 3;i++){
             tyData += result['TYRY'][i];
             hsData +=result['HSMRY'][i];
             zkData += result['ZKRY'][i];
        }
        if (tyData!=0){
            seriesData.push({name:"天友乳业",value:Math.floor(tyData)});
            axisx.push('天友乳业');
        }
        if (hsData!=0){
            seriesData.push({name:"华山牧乳业",value:Math.floor(hsData)});
            axisx.push('华山牧乳业');
        }
//        if (zkData!=0){
//            seriesData.push({name:"中垦乳业",value:Math.floor(zkData)});
//        }
        var branchProportion = echarts.init($('.branchProportionByYearMonthChart')[0], echartsTheme);
        var option = {
            title : {
                text: '销量占比',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}吨 ({d}%)"
            },
            legend: {
                bottom: 20,
                left: 'center',
                data:axisx
            },
            series: [
                {
                    name:'销量',
                    type:'pie',
                    radius: ['35%', '50%'],
                    label: {
                        normal: {
                            formatter: '{b}：{c}吨'
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
        branchProportion.setOption(option);
        $(window).resize(function () {
            branchProportion.resize();
        });
    }
    /**
     * 分公司销量对比-销量占比图
     */
    function branchProportionByYear(result) {
        var axAxis = [];
        var seriesData = [];//数据
        if (result['axisx'][0]!=null){
            seriesData.push({name:result['axisx'][0],value:Math.floor(result['HSMRY'][0])});
            axAxis.push(result['axisx'][0]);
        }
        if (result['axisx'][1]!=null){
            seriesData.push({name:result['axisx'][1],value:Math.floor(result['HSMRY'][1])});
            axAxis.push(result['axisx'][1]);
        }
        if (result['axisx'][2]!=null){
            seriesData.push({name:result['axisx'][2],value:Math.floor(result['HSMRY'][2])});
            axAxis.push(result['axisx'][2]);
        }
        var branchProportion = echarts.init($('.branchProportionByYear')[0], echartsTheme);
        var option = {
            title : {
                text: '华山牧销量',
                left: 'center',
                top:'5%'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}吨 ({d}%)"
            },
            legend: {
                bottom:20,
                left: 'center',
                data:axAxis
            },
            series: [
                {
                    name:'销量',
                    type:'pie',
                    radius: ['35%', '50%'],
                    label: {
                        normal: {
                            formatter: '{b}：{c}吨'
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
        branchProportion.setOption(option);
        $(window).resize(function () {
            branchProportion.resize();
        });
    }

    /**
     * 分公司销量对比-销量占比图
     */
    function branchProportion(result) {
        var axAxis = [];
        var seriesData = [];//数据
        if (result['axisx'][0]!=null){
            seriesData.push({name:result['axisx'][0],value:Math.floor(result['TYRY'][0])});
            axAxis.push(result['axisx'][0]);
        }
        if (result['axisx'][1]!=null){
            seriesData.push({name:result['axisx'][1],value:Math.floor(result['TYRY'][1])});
            axAxis.push(result['axisx'][1]);
        }
        if (result['axisx'][2]!=null){
            seriesData.push({name:result['axisx'][2],value:Math.floor(result['TYRY'][2])});
            axAxis.push(result['axisx'][2]);
        }
        var branchProportion = echarts.init($('.branchProportion')[0], echartsTheme);
        var option = {
            title : {
                text: '天友销量',
                left: 'center',
                top:'5%'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}吨 ({d}%)"
            },
            legend: {
                bottom: 20,
                left: 'center',
                data:axAxis
            },
            series: [
                {
                    name:'销量',
                    type:'pie',
                    radius: ['35%', '50%'],
                    label: {
                        normal: {
                            formatter: '{b}：{c}吨'
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
        branchProportion.setOption(option);
        $(window).resize(function () {
            branchProportion.resize();
        });
    }

</script>
</body>
<@footer/>
</html>
