<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>品类分析</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
			${company}
                <input type="hidden" id="company" value="${companyName}">
                <small>品类分析</small>
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
                            <h3 class="box-title">品类分析</h3>
                            <div class="box-tools pull-right">
                            </div>
                        </div>
                        <div class="nav-tabs-custom">
                            <!-- Tabs within a box -->
                            <ul class="nav nav-tabs pull-right">
                                <li class="active"><a href="#revenue-chart" data-toggle="tab" style="color: #00a65a">按日查看</a></li>
                                <li><a href="#sales-chart" data-toggle="tab" style="color: #00a7d0" id="eyeryChart">按月查看</a></li>
                            </ul>
                            <div class="tab-content no-padding">
                                <div class="chart tab-pane active" id="revenue-chart" style="position: relative;">
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div style="height: 3px;"></div>
                                            <div class="col-md-12 col-sm-8">
                                                <input class="pull-right" type="text" id="everydayTime" placeholder="选择期间..." style="position: absolute;right:28px;top:5px;z-index: 3">
                                                <div class="groupcattle" style=" height: 350px;border-bottom: dashed 1px gray;"></div>
                                                <div class="groupcattle1" style=" height: 350px;"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="chart tab-pane" id="sales-chart" style="position: relative;">
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div style="height: 3px;"></div>
                                            <div class="col-md-12 col-sm-8">
                                                <input class="pull-right" type="text" id="securityTime" placeholder="选择期间..." style="position: absolute;right:28px;top:5px;z-index: 3">
                                                <div class="group_map" style=" height: 350px;border-bottom: dashed 1px gray;"></div>
                                                <div class="group_map1" style=" height: 350px;"></div>
                                            </div>
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
    var yearMonth = '';
    var yearMonthDay = '';
    $('#everydayTime').datepicker({
        language: 'zh-CN',
        format: 'yyyymmdd',
        autoclose: true,
        todayHighlight: true
    }).on('changeDate',function (ev) {
        yearMonthDay = $(this).val();
        everydayChart(yearMonthDay);
    });

    $('#eyeryChart').click(function () {
        $('#securityTime').datepicker({
            language: 'zh-CN',
            format: 'yyyymm',
            autoclose: true,
            todayHighlight: false,
            startView: 1,
            maxViewMode: 1,
            minViewMode: 1
        }).on('changeDate', function (ev) {
            yearMonth = $(this).val();
            herdStructure(yearMonth);
        });
        $('#securityTime').datepicker( 'setDate' , '-0m' );
    });

    $(function () {
        $('#everydayTime').datepicker( 'setDate' , '-1d' );//设置日期控件默认值,触发change事件
    });


    function herdStructure(yearMonth) {
        $("#example2").empty();
        $.ajax({
            url: "${ctx}/report/milkReport/queryMonthData?yearMonth="+yearMonth,
            type: "get",
            dataType: "text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                monthChart(jsonObj);
                monthAmount(jsonObj);
            },
            error:function(){
                console.log('错误');
            }
        });
    }

    function everydayChart(yearMonthDay) {
        $("#example2").empty();
        $.ajax({
            url: "${ctx}/report/milkReport/queryDayData?yearMonth="+yearMonthDay,
            type: "get",
            dataType: "text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                dayChart(jsonObj);
                dayAmountChart(jsonObj);
            },
            error:function(){
                console.log('错误');
            }
        });
    }


    /**
     * 初始化
     */
    function monthChart(result) {

        var sxAxis=[];//月份数据
        var legend=[];//图例数据
        var sxAyis = [];//指标数据
        for(key in result["resultMap"]){
            if (key == "yearMonthArr"){
                for(var i = 0;i<result["resultMap"][key].length;i++){
                    sxAxis.push(result["resultMap"][key][i]);
                }
            }else {
                legend.push(key);
                sxAyis.push(
                    {
                        name: key,
                        type: 'line',
                        data: result["resultMap"][key],
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
                    }
                );
            }
        }

        var saleReport = echarts.init($(".group_map")[0]);
        var option2 = {
            title : {
                text: '月销量前5走势',
                subtext: '单位:吨',
                left: 'center',
                top:'5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: [{
                x:'center',
                bottom:'5%',
                data: legend
            },
//                {
//                    x:'left',
//                    top:'5%',
//                    data: [ '母犊','公犊']
//                }
            ],
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                },
                right:'3%',
                top:'10%'
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
            series: sxAyis
        };
        saleReport.setOption(option2);


        $(window).resize(function () {
            saleReport.resize();
        });
    };


    /**
     * 初始化
     */
    function monthAmount(result) {

        var sxAxis=[];//月份数据
        var legend=[];//图例数据
        var sxAyis = [];//指标数据
        for(key in result["amountMap"]){
            if (key == "yearMonthArr"){
                for(var i = 0;i<result["amountMap"][key].length;i++){
                    sxAxis.push(result["amountMap"][key][i]);
                }
            }else {
                legend.push(key);
                var seriesAx = [];
                for(var i=0;i<result["amountMap"][key].length;i++){
                    seriesAx.push((result["amountMap"][key][i]/10000).toFixed(2));
                }
                sxAyis.push(
                        {
                            name: key,
                            type: 'line',
                            data: seriesAx,
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
                        }
                );
            }
        }

        var saleReport = echarts.init($(".group_map1")[0]);
        var option2 = {
            title : {
                text: '月销售额前5走势',
                subtext: '单位:万元',
                left: 'center',
                top:'5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: [{
                x:'center',
                bottom:'5%',
                data: legend
            },
//                {
//                    x:'left',
//                    top:'5%',
//                    data: [ '母犊','公犊']
//                }
            ],
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                },
                right:'3%',
                top:'10%'
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
            series: sxAyis
        };
        saleReport.setOption(option2);


        $(window).resize(function () {
            saleReport.resize();
        });
    };


    function dayChart(result) {

        var sxAxis=[];//月份数据
        var legend=[];//图例数据
        var series=[];//指标数据
        for(key in result["resultMap"]){
            if (key == "yearMonthArr"){
                for(var i=0;i<result["resultMap"][key].length;i++){
                    sxAxis.push(result["resultMap"][key][i]);
                }
            }else {
                legend.push(key);
                series.push(
                    {
                        name: key,
                        type: 'line',
                        data: result["resultMap"][key],
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
                    }
                );
            }
        }
        var saleReports = echarts.init($(".groupcattle")[0]);
        var option2 = {
            title : {
                text: '日销量前5走势',
                subtext: '单位:吨',
                left: 'center',
                top:'5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: [{
                x:'center',
                bottom:'6%',
                data: legend
            },
//                {
//                    x:'left',
//                    top:'5%',
//                    data: [ '母犊','公犊']
//                }
            ],
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                },
                top:'10%',
                right:'3%'
            },
            calculable: true,
            grid: {
                left:'3%',
                right:'3%',
                bottom:'15%',
                top:'25%',
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
            series: series
        };
        saleReports.clear();
        saleReports.setOption(option2);
        $(window).resize(function () {
            saleReports.resize();
        });
    }

    function dayAmountChart(result) {

        var sxAxis=[];//月份数据
        var legend=[];//图例数据
        var series=[];//指标数据
        for(key in result["amountMap"]){
            if (key == "yearMonthArr"){
                for(var i=0;i<result["amountMap"][key].length;i++){
                    sxAxis.push(result["amountMap"][key][i]);
                }
            }else {
                legend.push(key);
                var seriesAx = [];
                for(var i=0;i<result["amountMap"][key].length;i++){
                    seriesAx.push((result["amountMap"][key][i]/10000).toFixed(2));
                }
                series.push(
                        {
                            name: key,
                            type: 'line',
                            data: seriesAx,
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
                        }
                );
            }
        }
        var saleReports = echarts.init($(".groupcattle1")[0]);
        var option2 = {
            title : {
                text: '日销售额前5走势',
                subtext: '单位:万元',
                left: 'center',
                top:'5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: [{
                x:'center',
                bottom:'6%',
                data: legend
            },
//                {
//                    x:'left',
//                    top:'5%',
//                    data: [ '母犊','公犊']
//                }
            ],
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                },
                top:'10%',
                right:'3%'
            },
            calculable: true,
            grid: {
                left:'3%',
                right:'3%',
                bottom:'15%',
                top:'25%',
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
            series: series
        };
        saleReports.setOption(option2);
        $(window).resize(function () {
            saleReports.resize();
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