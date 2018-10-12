<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>单位完全成本明细</title>
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
                <small>单位完全成本明细</small>
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
                        <span class="info-box-icon"><i class="fa fa-database"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">原材料完全成本</span>
                            <span class="info-box-number">${result['totalList']['CPCB-ZJCL-WY']?floor}</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${beginTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 元</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-green">
                        <span class="info-box-icon"><i class="fa fa-users"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">单位直接人工成本</span>
                            <span class="info-box-number">${result['totalList']['CPCB-ZJRG-WY']?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${beginTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 元</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-yellow">
                        <span class="info-box-icon"><i class="fa fa-yen"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">单位制造费用成本</span>
                            <span class="info-box-number">${result['totalList']['CPCB-ZZFY-WY']?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${beginTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 元</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-purple">
                        <span class="info-box-icon"><i class="fa fa-line-chart"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">生产成本合计</span>
                            <span class="info-box-number">${result['totalList']['CPCB-SCCBHJ-WY']?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar">  ${beginTime}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 元</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">年度成本走势图</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="security" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <div class="row">
                                <div class="col-md-12 col-sm-8">
                                    <div class="unitTotalCostChart" style="width: 100%; height: 350px;"></div>
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
                            <h3 class="box-title">单位完全成本明细表</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="securityTime" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover" style="font-size: 11px;">
                                <thead>
                                <tr>
                                    <th rowspan="2">产品项目</th>
                                    <th rowspan="2">产量:(吨)</th>
                                    <th colspan="2">原材料单位成本(元/吨)</th>
                                    <th colspan="2">单位直接人工成本(元/吨)</th>
                                    <th colspan="2">单位制造费用成本(元/吨)</th>
                                    <th colspan="3">生产成本合计(元/吨)</th>
                                </tr>
                                <tr>
                                    <th>预算</th>
                                    <th>实际</th>
                                    <th>预算</th>
                                    <th>实际</th>
                                    <th>预算</th>
                                    <th>实际</th>
                                    <th>预算单位</th>
                                    <th>实际单位</th>
                                    <th>总额</th>
                                </tr>
                                </thead>
                                <tbody id="tbody">

                                </tbody>
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

    var yearMonth ='';
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
        ajaxLoad(yearMonth);
    });
    var yearMonths ='';
    $('#security').datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: true,
        startView: 1,
        maxViewMode: 1,
        minViewMode:1
    }).on('changeDate',function (ev) {
        yearMonths = $(this).val();
        costTrend(yearMonths);
    });
    $(function () {
        $('#securityTime').datepicker( 'setDate' , '-1m' );//设置日期控件默认值,触发change事件
        $('#security').datepicker( 'setDate' , '-1m' );
    });

    function ajaxLoad(yearMonth) {
        $("#tbody").empty();
        var companyNumber = $("#companyNumber").val();
        var rowIndex = [];
        if (companyNumber=='HSMC'){
            rowIndex.push(30);
        }else {
            rowIndex.push(31);
        }
        $.ajax({
            url:"${ctx}/report/pastureReport/unitTotalCostDetailAjax",
            type:"post",
            dataType:"text",
            traditional: true,
            data:{"yearMonth":yearMonth,"companyNumber":companyNumber,"rowIndex":rowIndex},
            success:function (result) {
                var jsonObj = eval("("+result+")");
                for (var key in jsonObj){
                    $("#tbody").append("<tr id="+key+"></tr>");
                    var trId = "#"+key;
                    for (var i=0;i<jsonObj[key].length;i++){
                        $(trId).append("<td>"+(jsonObj[key][i]==0?'-':jsonObj[key][i])+"</td>");
                    }
                }
            },
            error:function () {
                console.log('错误');
            }
        });
    }

    function costTrend(yearMonths) {
        $.ajax({
            url:"${ctx}/report/pastureReport/costTrendAjax?company=${company}&yearMonths="+yearMonths,
            type:"get",
            dataType:"text",
            success:function (result) {
                var jsonObj = eval("("+result+")");
                init(jsonObj);
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
    function init(jsonObj) {
        var yearMonth = jsonObj["yearMonth"];
        var cl = [];
        var rg = [];
        var zz = [];
        for(var i=0;i<yearMonth.length;i++){
            if(jsonObj["CPCB-ZJCL-WY"].length>0){
                cl.push(Math.floor(jsonObj["CPCB-ZJCL-WY"][i]));
            }else{
                cl.push(0);
            }
            if(jsonObj["CPCB-ZJRG-WY"].length>0){
                rg.push(Math.floor(jsonObj["CPCB-ZJRG-WY"][i]));
            }else{
                rg.push(0);
            }
            if(jsonObj["CPCB-ZZFY-WY"].length>0){
                zz.push(Math.floor(jsonObj["CPCB-ZZFY-WY"][i]));
            }else{
                zz.push(0);
            }

        }
        var saleReport = echarts.init($(".unitTotalCostChart")[0], echartsTheme);

        var option = {
            title: {
                text: '',
                subtext: '单位:元、元/吨'
            },
            tooltip : {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    label: {
                        backgroundColor: '#6a7985'
                    }
                }
            },
            legend: {
                data:['原材料单位成本','单位直接人工成本','单位制造费用成本']
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : false,
                    data : yearMonth
                }
            ],
            yAxis : [
                {
                    type : 'value',
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
            series : [
                {
                    name:'原材料单位成本',
                    type:'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data:cl
                },
                {
                    name:'单位直接人工成本',
                    type:'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data:rg
                },
                {
                    name:'单位制造费用成本',
                    type:'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data:zz
                }
            ]
        };
        saleReport.setOption(option);

        $(window).resize(function () {
            saleReport.resize();
        });
    }
</script>
</body>
<@footer/>
</html>