<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>资产总额明细</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                ${companyName}
                <small>资产总额明细</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${companyName}</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-aqua">
                        <span class="info-box-icon"><i class="fa fa-cny"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">货币资金</span>
                            <span class="info-box-number">${resultData[0]?floor}</span>
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
                            <span class="info-box-text">应收账款</span>
                            <span class="info-box-number">${resultData[1]?floor}</span>

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
                    <div class="info-box bg-yellow">
                        <span class="info-box-icon"><i class="fa fa-line-chart"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">存货</span>
                            <span class="info-box-number">${resultData[2]?floor}</span>

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
                    <div class="info-box bg-purple">
                        <span class="info-box-icon"><i class="fa fa-line-chart"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">固定资产</span>
                            <span class="info-box-number">${resultData[3]?floor}</span>

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
                            <h3 class="box-title">资产总额走势图</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="security" placeholder="选择期间...">
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
                            <h3 class="box-title">各公司资产同期对比</h3>
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
        todayHighlight: false,
        startView: 1,
        maxViewMode: 1,
        minViewMode:1
    }).on('changeDate',function (ev) {
        yearMonth = $(this).val();
        detailByYearMonthChart(yearMonth);
    });
    $('#security').datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: false,
        startView: 1,
        maxViewMode: 1,
        minViewMode:1
    }).on('changeDate',function (ev) {
        yearMonths = $(this).val();
        assetsTrendByYearMonth(yearMonths);
    });

    $(function () {
        $('#securityTime').datepicker( 'setDate' , '-1m' );//设置日期控件默认值,触发change事件
        $('#security').datepicker( 'setDate' , '-1m' );
    });

    /**
     * 按期间展示资产总额走势
     */
    function assetsTrendByYearMonth(yearMonths) {
        $.ajax({
            url: "${ctx}/report/groupReport/assetsTrendAjax?companyNumber=${companyNumber}&yearMonths="+yearMonths,
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
            var seriesHBJJ = [];//货币资金数据
            var seriesYSZK = [];//应收账款数据
            var seriesCH= [];//存货数据
            var seriesGDZC = [];//固定资产数据
            for (var i = 0; i < result['axisx'].length; i++) {
                sxAxis.push(result['axisx'][i]);
                seriesHBJJ.push(Math.floor(result['HBJJ'][i]));
                seriesYSZK.push(Math.floor(result['YSZK'][i]));
                seriesCH.push(Math.floor(result['CH'][i]));
                seriesGDZC.push(Math.floor(result['GDZC'][i]));
            }
            var saleReport = echarts.init($(".businessIncomeChart")[0], echartsTheme);
            var option = {
                title: {
                    text: '',
                    subtext: '单位:万元'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        label: {
                            backgroundColor: '#6a7985'
                        }
                    }
                },
                legend: {
                    data: ['货币资金', '应收账款', '存货', '固定资产']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: true,
                        data: sxAxis
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '货币资金',
                        type: 'line',
                        stack: '总量',
                        areaStyle: {normal: {}},
                        data: seriesHBJJ,
                        itemStyle : {
                            normal : {
                                color:'#00c0ef',
                                lineStyle:{
                                    color:'#00c0ef'
                                }
                            }
                        }
                    },
                    {
                        name: '应收账款',
                        type: 'line',
                        stack: '总量',
                        areaStyle: {normal: {}},
                        data: seriesYSZK,
                        itemStyle : {
                            normal : {
                                color:'#00a65a',
                                lineStyle:{
                                    color:'#00a65a'
                                }
                            }
                        }
                    },
                    {
                        name: '存货',
                        type: 'line',
                        stack: '总量',
                        areaStyle: {normal: {}},
                        data: seriesCH,
                        itemStyle : {
                            normal : {
                                color:'#db8b0b',
                                lineStyle:{
                                    color:'#db8b0b'
                                }
                            }
                        }
                    },
                    {
                        name: '固定资产',
                        type: 'line',
                        stack: '总量',
                        areaStyle: {normal: {}},
                        data: seriesGDZC,
                        itemStyle : {
                            normal : {
                                color:'#555299',
                                lineStyle:{
                                    color:'#555299'
                                }
                            }
                        }
                    }
                ]
            };
            saleReport.setOption(option);

            $(window).resize(function () {
                saleReport.resize();
            });
        }

    /**
     * 按期间展示各分公司资产指标
     */
    function detailByYearMonthChart(yearMonth) {
        $.ajax({
            url: "${ctx}/report/groupReport/assetsComparisonAjax?companyNumber=${companyNumber}",
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
        function init(result) {
            var sxAxis = [];//x轴数据
            var series = [];//指标数据
            var legend = [];//图例数据
            var propertis = {TYRY:'天友乳业',HSMRY:'华山牧乳业',TNMC:'天宁牧场',HSMC:'华山牧场',ZKGYL:'中垦供应链',THMY:'天鸿牧业'};
            for(key in result){
                if (key=='axisx'){
                    sxAxis=result['axisx'];
                }else {
                    legend.push(propertis[key]);
                    series.push(
                            {
                                name: propertis[key],
                                type: 'bar',
                                data: result[key]
                            }
                    );
                }
            }
            if(sxAxis[0] == null){
                sxAxis = ["货币基金","应收账款","存货","固定资产"];
            }
            var saleReport = echarts.init($(".detailByYearMonthChart")[0], echartsTheme);
            var option = {
                title: {
                    text: '',
                    subtext: '单位:万元',
                    left: 'left'
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
                    bottom:'3%'
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
                series: series
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
            console.log(result);
            var axisx = []; //图例数据
            var seriesTYRY = [];//天友乳业数据
            var propertis = {TYRY:'天友',HSMRY:'华山牧',TNMC:'天宁',HSMC:'华山',ZKGYL:'供应链',THMY:'天鸿'};
            for(key in result){
                if (key != 'axisx'){
                    if(result[key][result['axisx'].length-1]!=0){
                        seriesTYRY.push({name:propertis[key],value:Math.floor(result[key][result['axisx'].length-1])});
                        axisx.push(propertis[key]);
                    }
                }
            }
            var branchProportion = echarts.init($('.branchProportionByYearMonthChart')[0], echartsTheme);
            var option = {
                title: {
                    text: '资产分布',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c}万 ({d}%)"
                },
                legend: {
                    bottom: 1,
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

    <#--/**-->
     <#--* 按期间展示各分公司占比-->
     <#--*/-->
    <#--function branchProportionByYearMonth(yearMonth) {-->
        <#--$.ajax({-->
            <#--url: "${ctx}/report/groupReport/assetsComparisonAjax?companyNumber=${companyNumber}",-->
            <#--type: "get",-->
            <#--data: {yearMonth :yearMonth},-->
            <#--dataType: "text",-->
            <#--success: function(result){-->
                <#--var jsonObj = eval('(' + result + ')');-->
                <#--init(jsonObj);-->
            <#--},-->
            <#--error:function(){-->
                <#--alert("错误");-->
            <#--}-->
        <#--});-->
        <#--function init(result) {-->
            <#--var axisx = [];-->
            <#--var seriesTYRY = [];//天友乳业数据-->
            <#--var seriesHSMRY = 0;//华山牧乳业数据-->
            <#--var seriesTNMC = 0;//天宁牧场数据-->
            <#--var seriesHSMC = 0;//华山牧场数据-->
            <#--var seriesZKGYL = 0;//中垦供应链数据-->
            <#--for (var i = result['axisx'].length-1; i < result['axisx'].length; i++) {-->
                <#--if (result['TYRY'][i]!=0){-->
                    <#--seriesTYRY.push({name:'天友',value:result['TYRY'][i]});-->
                    <#--axisx.push("天友");-->
                <#--}-->
                <#--if (result['HSMRY'][i]!=0){-->
                    <#--seriesTYRY.push({name:'华山乳',value:result['HSMRY'][i]});-->
                    <#--axisx.push("华山乳");-->
                <#--}-->
                <#--if (result['TNMC'][i]!=0){-->
                    <#--seriesTYRY.push({name:'天宁',value:result['TNMC'][i]});-->
                    <#--axisx.push("天宁");-->
                <#--}-->
                <#--if (result['HSMC'][i]!=0){-->
                    <#--seriesTYRY.push({name:'华山牧',value:result['HSMC'][i]});-->
                    <#--axisx.push("华山牧");-->
                <#--}-->
                <#--if (result['ZKGYL'][i]!=0){-->
                    <#--seriesTYRY.push({name:'供应链',value:result['ZKGYL'][i]});-->
                    <#--axisx.push("供应链");-->
                <#--}-->
               <#--// seriesTYRY.push(Math.floor(result['TYRY'][i]));-->
                <#--//seriesTYRY+=Math.floor(result['TYRY'][i]);-->
                <#--//seriesHSMRY.push(Math.floor(result['HSMRY'][i]));-->
                <#--//seriesHSMRY+=Math.floor(result['HSMRY'][i]);-->
<#--//                seriesTNMC.push(Math.floor(result['TNMC'][i]));-->
                <#--//seriesTNMC+=Math.floor(result['TNMC'][i]);-->
<#--//                seriesHSMC.push(Math.floor(result['HSMC'][i]));-->
                <#--//seriesHSMC+=Math.floor(result['HSMC'][i]);-->
<#--//                seriesZKGYL.push(Math.floor(result['ZKGYL'][i]));-->
                <#--//seriesZKGYL+=Math.floor(result['ZKGYL'][i]);-->
            <#--}-->
            <#--var branchProportion = echarts.init($('.branchProportionByYearMonthChart')[0], echartsTheme);-->
            <#--var option = {-->
                <#--title: {-->
                    <#--text: '资产分布',-->
                    <#--left: 'center'-->
                <#--},-->
                <#--tooltip: {-->
                    <#--trigger: 'item',-->
                    <#--formatter: "{a} <br/>{b}: {c}万 ({d}%)"-->
                <#--},-->
                <#--legend: {-->
                    <#--bottom: 1,-->
                    <#--left: 'center',-->
                    <#--data: axisx-->
                <#--},-->
                <#--series: [-->
                    <#--{-->
                        <#--name: '资产总额',-->
                        <#--type: 'pie',-->
                        <#--radius: '45%',-->
                        <#--center: ['50%', '50%'],-->
                        <#--label: {-->
                            <#--normal: {-->
                                <#--formatter: '{b}：{c}万'-->
                            <#--}-->
                        <#--},-->
                        <#--data: seriesTYRY,-->
                        <#--animationType: 'scale',-->
                        <#--animationEasing: 'elasticOut',-->
                        <#--animationDelay: function (idx) {-->
                            <#--return Math.random() * 200;-->
                        <#--}-->
                    <#--}-->
                <#--]-->
            <#--};-->
            <#--branchProportion.setOption(option);-->
            <#--$(window).resize(function () {-->
                <#--branchProportion.resize();-->
            <#--});-->
        <#--}-->
    <#--}-->
</script>
</body>
<@footer/>
</html>
