<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>牛群结构明细</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                ${companyName}
                <small>牛群结构明细</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${companyName}</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">牛群结构分析</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="selectTime" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <div class="col-md-6">
                                <div class="cattleDetailChart" style="width: 100%; height: 300px;"></div>
                            </div>
                            <div class="col-md-6">
                                <div class="cattleChart" style="width: 100%; height: 300px;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">牛群结构变动情况</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="securityTime" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <div class="col-md-12">
                                <div class="cattleChangeChart" style="width: 100%; height: 500px;"></div>
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
        cattleChangeChart(yearMonth);
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
        herdStructure(yearMonths);
    });
    $(function () {
        $('#securityTime').datepicker( 'setDate' , '-0m' );//设置日期控件默认值,触发change事件
        $('#selectTime').datepicker( 'setDate' , '-0m' );
    });

    /**
     *  获取牛群结构数据
     */
    function herdStructure (yearMonths) {
        $.ajax({
            url: "${ctx}/report/groupReport/herdStructureAjax?companyNumber=${companyNumber}&yearMonths="+yearMonths,
            type: "get",
            dataType: "text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                console.log(jsonObj);
                //cattleChart(jsonObj);
                cattleDetailChart(jsonObj);
            },
            error:function(){
                console.log('错误');
            }
        });
    }

    /**
     * 牛群结构变动情况
     */
    function cattleChangeChart(yearMonth) {
        $.ajax({
            url: "${ctx}/report/groupReport/herdStructureChangeAjax?companyNumber=${companyNumber}&yearMonth="+yearMonth,
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
            var NQJG_14M_QNN_TS = [];
            var NQJG_14M_WPZ_TS = [];
            var NQJG_14M_YPZWHY_TS = [];
            var NQJG_14M_WHY14YYSQNN_TS = [];
            var ZHZB_CRNTS_TS = [];
            var NQJG_CRN_SLWPZ_TS = [];
            var NQJG_CRN_YPZWHY_TS = [];
            var NQJG_CRN_SNWPZ_TS = [];
            var WPZZ14MWHY = [];
            var WPZZ14MQNN = [];
            var WPZZCRN = [];
            var number = 100;
            for (var i = 0; i < result['axisx'].length; i++) {
                sxAxis.push(result['axisx'][i]);
                NQJG_14M_QNN_TS.push(result['NQJG-14M-QNN-TS'][i]);
                NQJG_14M_WPZ_TS.push(result['NQJG-14M-WPZ-TS'][i]);
                NQJG_14M_YPZWHY_TS.push(result['NQJG-14M-YPZWHY-TS'][i]);
                NQJG_14M_WHY14YYSQNN_TS.push(result['NQJG-14M-WHY14YYSQNN-TS'][i]);
                ZHZB_CRNTS_TS.push(result['ZHZB-CRNTS-TS'][i]);
                NQJG_CRN_SLWPZ_TS.push(result['NQJG-CRN-SLWPZ-TS'][i]);
                NQJG_CRN_YPZWHY_TS.push(result['NQJG-CRN-YPZWHY-TS'][i]);
                NQJG_CRN_SNWPZ_TS.push(result['NQJG-CRN-SNWPZ-TS'][i]);

                if (result['NQJG-14M-WHY14YYSQNN-TS'][i] !== 0) {
                    WPZZ14MWHY.push((result['NQJG-14M-WPZ-TS'][i]/result['NQJG-14M-WHY14YYSQNN-TS'][i]*number).toFixed(2));
                }else{
                    WPZZ14MWHY.push('0.00');
                }
                if (result['NQJG-14M-QNN-TS'][i] !== 0) {
                    WPZZ14MQNN.push((result['NQJG-14M-WPZ-TS'][i]/result['NQJG-14M-QNN-TS'][i]*number).toFixed(2));
                }else{
                    WPZZ14MQNN.push('0.00');
                }
                if (result['ZHZB-CRNTS-TS'][i] !== 0) {
                    WPZZCRN.push((result['NQJG-CRN-SLWPZ-TS'][i]/result['ZHZB-CRNTS-TS'][i]*number).toFixed(2));
                }else{
                    WPZZCRN.push('0.00');
                }
            }
            var saleReport = echarts.init($(".cattleChangeChart")[0], echartsTheme);
            var colors = ['#5793f3', '#d14a61', '#675bba'];
            var option = {
                color: colors,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross'
                    }
                },
                grid: {
                    right: '20%',
                    top: 100
                },
                toolbox: {
                    top: 100,
                    orient: 'vertical',
                    feature: {
                        dataView: {show: true, readOnly: false},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                legend: {
                    height: 100,
                    data: [
                        '14个月以上青年牛头数',
                        '未配种头数',
                        '青年牛已配种但未确认怀孕头数',
                        '未怀孕14个月以上青年牛总头数',
                        '成乳牛(泌乳牛+干奶牛)头数',
                        '适龄未配种头数',
                        '成乳牛已配种但未确认怀孕头数',
                        '适龄未怀孕成乳牛总头数',
                        '未配种占14月以上未怀孕青年牛比例',
                        '未配种占14个月以上青年牛比例',
                        '未配种占成乳牛比例'
                    ],
                    selected:{
                        '未配种头数':false,
                        '青年牛已配种但未确认怀孕头数':false,
                        '未怀孕14个月以上青年牛总头数':false,
                        '适龄未配种头数':false,
                        '成乳牛已配种但未确认怀孕头数':false,
                        '适龄未怀孕成乳牛总头数':false,
                        '未配种占14月以上未怀孕青年牛比例':false,
                        '未配种占14个月以上青年牛比例':false,
                        '未配种占成乳牛比例':false
                    }
                },
                xAxis: [
                    {
                        type: 'category',
                        axisTick: {
                            alignWithLabel: true
                        },
                        data: sxAxis
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '大类牛只数',
                        position: 'left',
                        axisLine: {
                            lineStyle: {
                                color: colors[0]
                            }
                        },
                        axisLabel: {
                            formatter: '{value} 头'
                        }
                    },
                    {
                        type: 'value',
                        name: '小类牛只数',
                        position: 'right',
                        axisLine: {
                            lineStyle: {
                                color: colors[1]
                            }
                        },
                        axisLabel: {
                            formatter: '{value} 头'
                        }
                    },
                    {
                        type: 'value',
                        name: '占比',
                        position: 'right',
                        offset: 80,
                        axisLine: {
                            lineStyle: {
                                color: colors[2]
                            }
                        },
                        axisLabel: {
                            formatter: '{value} %'
                        }
                    }
                ],
                series: [
                    {
                        name: '14个月以上青年牛头数',
                        type: 'bar',
                        data: NQJG_14M_QNN_TS
                    },
                    {
                        name: '青年牛已配种但未确认怀孕头数',
                        type: 'bar',
                        yAxisIndex: 0,
                        data: NQJG_14M_YPZWHY_TS
                    },
                    {
                        name: '适龄未怀孕成乳牛总头数',
                        type: 'bar',
                        yAxisIndex: 0,
                        data: NQJG_CRN_SNWPZ_TS
                    },
                    {
                        name: '成乳牛(泌乳牛+干奶牛)头数',
                        type: 'bar',
                        yAxisIndex: 0,
                        data: ZHZB_CRNTS_TS
                    },
                    {
                        name: '适龄未配种头数',
                        type: 'bar',
                        yAxisIndex: 1,
                        data: NQJG_CRN_SLWPZ_TS
                    },
                    {
                        name: '未配种头数',
                        type: 'bar',
                        yAxisIndex: 1,
                        data: NQJG_14M_WPZ_TS
                    },
                    {
                        name: '成乳牛已配种但未确认怀孕头数',
                        type: 'bar',
                        yAxisIndex: 1,
                        data: NQJG_CRN_YPZWHY_TS
                    },
                    {
                        name: '未怀孕14个月以上青年牛总头数',
                        type: 'bar',
                        yAxisIndex: 1,
                        data: NQJG_14M_WHY14YYSQNN_TS
                    },
                    {
                        name: '未配种占14月以上未怀孕青年牛比例',
                        type: 'line',
                        yAxisIndex: 2,
                        data: WPZZ14MWHY
                    },
                    {
                        name: '未配种占14个月以上青年牛比例',
                        type: 'line',
                        yAxisIndex: 2,
                        data: WPZZ14MQNN
                    },
                    {
                        name: '未配种占成乳牛比例',
                        type: 'line',
                        yAxisIndex: 2,
                        data: WPZZCRN
                    }
                ]
            };
            saleReport.setOption(option);

            $(window).resize(function () {
                saleReport.resize();
            });
        }

    /**
     * 牛群结构分布
     */
    function cattleDetailChart(result) {
        var sxAxis = [];//x轴数据
        var tnTotal = 0;
        var hsmTotal = 0;
        for (var i = 0; i < result['axisx'].length; i++) {
            sxAxis.push(result['axisx'][i]);
            tnTotal = tnTotal+result['TNMC'][i];
            hsmTotal = hsmTotal+result['HSMC'][i];
        }
        console.log(sxAxis);
        var branchProportion = echarts.init($('.cattleDetailChart')[0], echartsTheme);
        var option = {
            title : {
                text: '天宁牧场',
                subtext:'总头数:'+tnTotal,
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}头 ({d}%)"
            },
            legend: {
                bottom: 1,
                left: 'center',
                data:sxAxis
            },
            series: [
                {
                    type:'pie',
                    radius : '45%',
                    center: ['50%', '50%'],
                    label: {
                        normal: {
                            formatter: '{b}：{c}头'
                        }
                    },
                    data:[
                        {value:parseInt(result['TNMC'][0]), name:'公犊'},
                        {value:parseInt(result['TNMC'][1]), name:'母犊'},
                        {value:parseInt(result['TNMC'][2]), name:'青年牛'},
                        {value:parseInt(result['TNMC'][3]), name:'干奶牛'},
                        {value:parseInt(result['TNMC'][4]), name:'泌乳牛'},
                        {value:parseInt(result['TNMC'][5]), name:'育成牛'}
                    ],
                    animationType: 'scale',
                    animationEasing: 'elasticOut',
                    animationDelay: function (idx) {
                        return Math.random() * 200;
                    }
                }
            ]
        };
        branchProportion.setOption(option);

        var branchProportion1 = echarts.init($('.cattleChart')[0], echartsTheme);
        var option1 = {
            title : {
                text: '华山牧场',
                subtext:'总头数:'+hsmTotal,
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}头 ({d}%)"
            },
            legend: {
                bottom: 1,
                left: 'center',
                data:sxAxis
            },
            series: [
                {
                    type:'pie',
                    radius : '45%',
                    center: ['50%', '50%'],
                    label: {
                        normal: {
                            formatter: '{b}：{c}头'
                        }
                    },
                    data:[
                        {value:parseInt(result['HSMC'][0]), name:'公犊'},
                        {value:parseInt(result['HSMC'][1]), name:'母犊'},
                        {value:parseInt(result['HSMC'][2]), name:'青年牛'},
                        {value:parseInt(result['HSMC'][3]), name:'干奶牛'},
                        {value:parseInt(result['HSMC'][4]), name:'泌乳牛'},
                        {value:parseInt(result['HSMC'][5]), name:'育成牛'}
                    ],
                    animationType: 'scale',
                    animationEasing: 'elasticOut',
                    animationDelay: function (idx) {
                        return Math.random() * 200;
                    }
                }
            ]
        };
        branchProportion1.setOption(option1);
        $(window).resize(function () {
            branchProportion.resize();
            branchProportion1.resize();
        });
    }

    /**
     * 分公司牛群占比

    function cattleChart(result) {
        var seriesTNMC = 0;//天宁牧场数据
        var seriesHSMC = 0;//华山牧场数据
        for (var i = 0; i < result['axisx'].length; i++) {
            seriesTNMC += result['TNMC'][i];
            seriesHSMC += result['HSMC'][i];
        }
        var branchProportion = echarts.init($('.cattleChart')[0], echartsTheme);
        var option = {
            title : {
                text: '分公司牛头数',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c}头 ({d}%)"
            },
            legend: {
                bottom: 1,
                left: 'center',
                data:['天宁牧场','华山牧场']
            },
            series: [
                {
                    name:'牛群',
                    type:'pie',
                    radius : '45%',
                    center: ['50%', '50%'],
                    label: {
                        normal: {
                            formatter: '{b}：{c}头'
                        }
                    },
                    data:[
                        {value:parseInt(seriesTNMC), name:'天宁牧场'},
                        {value:parseInt(seriesHSMC), name:'华山牧场'}
                    ],
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
    }*/
</script>
</body>
<@footer/>
</html>
