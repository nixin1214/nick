<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>对标分析</title>
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
                <small>对标分析</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"<i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${company}</li>
            </ol>
        </section>

        <section class="content">
        <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">对比分析</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="selectTime" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <div class="row">
                                <div class="col-md-6">
                                <#--财务评价指标对比-->
                                    <div id="finance_div" style="width: 100%; height: 350px;"></div>
                                </div>
                                <div class="col-md-6"
                                     style="border-left-style: dashed; border-left-width: thin;border-left-color: #cccccc;">
                                <#--产品全成本对比-->
                                    <div id="cost_comparison_div" style="width: 100%; height: 350px;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">对比分析</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </section>
    </div>
</div>
<@jsFile/>

<script type="text/javascript">
    financeReport();
    var yearMonths ='';
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
        costComparisonReport(yearMonths);
    });

    $(function () {
        $('#securityTime').datepicker( 'setDate' , '-1m' );//设置日期控件默认值,触发change事件
        $('#selectTime').datepicker( 'setDate' , '-1m' );
    });
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

    <#--/**-->
    <#--* 成本比较-->
    <#--*/-->
    function costComparisonReport(yearMonths) {
        $.ajax({
            url: "${ctx}/report/milkReport/productCostAjax?companyNumber=${companyNumber}&yearMonths=" + yearMonths,
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
    var seriesHS = [];//华山牧乳业数据
    var seriesTY = [];//天友乳业数据
    var seriesGM = [];//光明乳业数据
    for (var i = 0; i < result['axisx'].length; i++) {
    sxAxis.push(result['axisx'][i]);
    seriesHS.push(Math.floor(result['HSMRY'][i]));
    seriesTY.push(Math.floor(result['TYRY'][i]));
    seriesGM.push(Math.floor(result['GMRY'][i]));
    }
    if (sxAxis[0] == null) {
    sxAxis = ["直接材料", "直接人工", "能源动力", "制造费用", "销售费用", "管理费用", "财务费用"];
    }
        var option = {
            title: {
            text: '产品单位成本对比',
            subtext: '(单位：元)',
            left: 'left',
            textStyle: {
            fontSize: 16
            }
        },
            calculable: true,
            tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
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
            legend: {
            x: 'center',
            data: ['华山牧乳业', '天友乳业', '光明乳业'],
            top:'3%'
    },
            grid: {
            left: '3%',
            right: '4%',
            bottom: '10%',
            containLabel: true
            },
            xAxis: [
            {
            type: 'category',
            data: sxAxis,
            axisLabel: {
            interval: 0,
            rotate: -20,
            margin: 30,
            textStyle: {
            color: '#0c180d',
            align: 'center'

            }
        }
       }
    ],
            yAxis: [
            {
            splitArea: {show: false},
            type: 'value'
            }
    ],
            series: [
            {
            name: '华山牧乳业',
            type: 'bar',
            data: seriesHS
            },
            {
            name: '天友乳业',
            type: 'bar',
            data: seriesTY
            },
            {
            name: '光明乳业',
            type: 'bar',
            data: seriesGM
            }
        ]
    };
    var report = echarts.init($("#cost_comparison_div")[0], echartsTheme);
        report.setOption(option);
        $(window).resize(function () {
        report.resize();
        });
    }


    /**
     * 财务评价指标
     */
    function financeReport() {
        $.ajax({
        url: "${ctx}/report/milkReport/financialEvaluationAjax?companyNumber=${companyNumber}",
            type: "get",
            dataType: "text",
            success: function (result) {
            var jsonObj = eval('(' + result + ')');
            inits(jsonObj);
            financial(jsonObj);
         },
            error: function () {
            console.log('错误');
            }
        });
    }

    function financial(result) {
        $("#example2").empty();
        var zkry1 = 0;
        var zkry2 = 0;
        var zkry3 = 0;
        var zkry4 = 0;
        var zkry5 = 0;
        var zkry6 = 0;
        var zkry7 = 0;
        var zkry8 = 0;
        var zkry9 = 0;
        var zkry10 = 0;
        var zkry11 = 0;
        var gmry1 = 0;
        var gmry2 = 0;
        var gmry3 = 0;
        var gmry4 = 0;
        var gmry5 = 0;
        var gmry6 = 0;
        var gmry7 = 0;
        var gmry8 = 0;
        var gmry9 = 0;
        var gmry10 = 0;
        var gmry11 = 0;

        var cwdb1 = 0;
        var cwdb2 = 0;
        var cwdb3 = 0;
        var cwdb4 = 0;
        var cwdb5 = 0;
        var cwdb6 = 0;
        var cwdb7 = 0;
        var cwdb8 = 0;
        var cwdb9 = 0;
        var cwdb10 = 0;
        var cwdb11 = 0;
        var row = "<tr>";
        row = row +"<td>"+"#"+"</td>";
        var rowindex = "<tr>";
        rowindex = rowindex +"<td>"+"中垦乳业"+"</td>";
        var rowgmry = "<tr>";
        rowgmry = rowgmry +"<td>"+"光明乳业"+"</td>";
        var cwcompare = "<tr>";
        cwcompare = cwcompare +"<td>"+"财务比较"+"</td>";

        for(var key in result){
            if(key=="GMRY"){
                for(var keys in result[key]){
                    if(keys==0){
                        gmry1 = (result[key][keys]*100).toFixed(2);
                        rowgmry = rowgmry+"<td>"+gmry1+"%"+"</td>";
                    }
                    if(keys==1){
                        gmry2 = (result[key][keys]*100).toFixed(2);
                        rowgmry = rowgmry+"<td>"+gmry2+"%"+"</td>";
                    }
                    if(keys==2){
                        gmry3 = (result[key][keys]*100).toFixed(2);
                        rowgmry = rowgmry+"<td>"+gmry3+"%"+"</td>";
                    }
                    if(keys==3){
                        gmry4 = (result[key][keys]*100).toFixed(2);
                        rowgmry = rowgmry+"<td>"+gmry4+"%"+"</td>";
                    }
                    if(keys==4){
                        gmry5 = (result[key][keys]*100).toFixed(2);
                        rowgmry = rowgmry+"<td>"+gmry5+"%"+"</td>";
                    }
                    if(keys==5){
                        gmry6 = Math.floor(result[key][keys]);
                        rowgmry = rowgmry+"<td>"+gmry6+"次"+"</td>";
                    }
                    if(keys==6){
                        gmry7 = (result[key][keys]*100).toFixed(2);
                        rowgmry = rowgmry+"<td>"+gmry7+"%"+"</td>";
                    }
                    if(keys==7){
                        gmry8 = (result[key][keys]*100).toFixed(2);
                        rowgmry = rowgmry+"<td>"+gmry8+"%"+"</td>";
                    }
                    if(keys==8){
                        gmry9 = (result[key][keys]*100).toFixed(2);
                        rowgmry = rowgmry+"<td>"+gmry9+"%"+"</td>";
                    }
                    if(keys==9){
                        gmry10 = (result[key][keys]*100).toFixed(2);
                        rowgmry = rowgmry+"<td>"+gmry10+"%"+"</td>";
                    }
                    if(keys==10){
                        gmry11 = (result[key][keys]*100).toFixed(2);
                        rowgmry = rowgmry+"<td>"+gmry11+"%"+"</td>";
                    }

                }
                $("#example2").append(rowgmry+"</tr>");
            }
            if(key=="ZKRY"){
                for(var keys in result[key]){
                    row = row+"<td>"+keys+"</td>";
                    if(keys=="资产增长率"){
                        zkry1 = result[key][keys].toFixed(2);
                        rowindex = rowindex+"<td>"+zkry1+"%"+"</td>";
                    }
                    if(keys=="速动比率"){
                        zkry2 = result[key][keys].toFixed(2);
                        rowindex = rowindex+"<td>"+zkry2+"%"+"</td>";
                    }
                    if(keys=="流动比率"){
                        zkry3 = result[key][keys].toFixed(2);
                        rowindex = rowindex+"<td>"+zkry3+"%"+"</td>";
                    }
                    if(keys=="应收账款周转率"){
                        zkry4 = Math.floor(result[key][keys]);
                        rowindex = rowindex+"<td>"+zkry4+"次"+"</td>";
                    }
                    if(keys=="销售毛利率"){
                        zkry5 = result[key][keys].toFixed(2);
                        rowindex = rowindex+"<td>"+zkry5+"%"+"</td>";
                    }
                    if(keys=="营业利润率"){
                        zkry6 = result[key][keys].toFixed(2);
                        rowindex = rowindex+"<td>"+zkry6+"%"+"</td>";
                    }
                    if(keys=="成本费用利润率"){
                        zkry7 = result[key][keys].toFixed(2);
                        rowindex = rowindex+"<td>"+zkry7+"%"+"</td>";
                    }
                    if(keys=="期间费用率"){
                        zkry8 = result[key][keys].toFixed(2);
                        rowindex = rowindex+"<td>"+zkry8+"%"+"</td>";
                    }
                    if(keys=="资产负债率"){
                        zkry9 = result[key][keys].toFixed(2);
                        rowindex = rowindex+"<td>"+zkry9+"%"+"</td>";
                    }
                    if(keys=="销售增长率"){
                        zkry10 = result[key][keys].toFixed(2);
                        rowindex = rowindex+"<td>"+zkry10+"%"+"</td>";
                    }
                    if(keys=="利润增长率"){
                        zkry11 = result[key][keys].toFixed(2);
                        rowindex = rowindex+"<td>"+zkry11+"%"+"</td>";
                    }
                }
                $("#example2").append(row+"</tr>"+rowindex+"</tr>");
            }
            if(key=="axisx") {
                if (result["axisx"][0] == "资产增长率") {
                    cwdb1 = zkry1 - gmry1;
                    if (cwdb1 > 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + cwdb1.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (cwdb1 < 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + cwdb1.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + cwdb1.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (result["axisx"][1] == "资产负债率") {
                    cwdb2 = zkry9 - gmry2;
                    if (cwdb2 > 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + cwdb2.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (cwdb2 < 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + cwdb2.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {

                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + cwdb2.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (result["axisx"][2] == "流动比率") {
                    cwdb3 = zkry3 - gmry3;
                    if (cwdb3 > 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + cwdb3.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (cwdb3 < 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + cwdb3.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {

                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + cwdb3.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (result["axisx"][3] == "成本费用利润率") {
                    cwdb4 = zkry7 - gmry4;
                    if (cwdb4 > 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + cwdb4.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (cwdb4 < 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + cwdb4.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {

                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + cwdb4.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (result["axisx"][4] == "期间费用率") {
                    cwdb5 = zkry8 - gmry5;
                    if (cwdb5 > 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + cwdb5.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (cwdb5 < 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + cwdb5.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {

                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + cwdb5.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (result["axisx"][5] == "应收账款周转率") {
                    cwdb6 = zkry4 - gmry6;
                    if (cwdb6 > 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + cwdb6.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (cwdb6 < 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + cwdb6.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {

                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + cwdb6.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (result["axisx"][6] == "利润增长率") {
                    cwdb7 = zkry11 - gmry7;
                    if (cwdb7 > 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + cwdb7.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (cwdb7 < 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + cwdb7.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {

                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + cwdb7.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (result["axisx"][7] == "速动比率") {
                    cwdb8 = zkry2 - gmry2;
                    if (cwdb8 > 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + cwdb8.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (cwdb8 < 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + cwdb8.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {

                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + cwdb8.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (result["axisx"][8] == "销售增长率") {
                    cwdb9 = zkry10 - gmry9;
                    if (cwdb9 > 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + cwdb9.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (cwdb9 < 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + cwdb9.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {

                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + cwdb9.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (result["axisx"][9] == "销售毛利率") {
                    cwdb10 = zkry5 - gmry10;
                    if (cwdb10 > 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + cwdb10.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (cwdb10 < 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + cwdb10.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + cwdb10.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                if (result["axisx"][10] == "营业利润率") {
                    cwdb11 = zkry6 - gmry11;
                    if (cwdb11 > 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-red\"><i class=\"fa fa-caret-up\"></i>" + cwdb11.toFixed(2) + "%" + "</span>" + "</td>";
                    } else if (cwdb11 < 0) {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-green\"><i class=\"fa fa-caret-down\"></i>" + cwdb11.toFixed(2) + "%" + "</span>" + "</td>";
                    } else {
                        cwcompare = cwcompare + "<td>" + "<span class=\"description-percentage text-yellow\"><i class=\"fa fa-caret-left\"></i>" + cwdb11.toFixed(2) + "%" + "</span>" + "</td>";
                    }
                }
                $("#example2").append(cwcompare+"</tr>");
            }

            }



    }
    function inits(result) {
        var sxAxis = [];//x轴数据
        var seriesZK = [];//中垦乳业数据
        var seriesGM = [];//光明乳业数据
//        var month = result['month'];//总的有多少个月
        for (var i = 0; i < result['axisx'].length; i++) {
        seriesGM.push((result['GMRY'][i] * 100).toFixed(2));
        }
        for (var key in result["ZKRY"]) {
        sxAxis.push(key);
        seriesZK.push((result["ZKRY"][key]).toFixed(2));
        }
        if(sxAxis[0] == null){
        sxAxis = ["资产负债率","速动比率","流动比率","应收账款周转率","销售毛利率","营业利润率","成本费用利润率","期间费用率","资产增长率","销售增长率","利润增长率"];
        }
        var option = {
        title: {
        text: '财务评价指标',
        subtext: '(单位：% / 次)',
        left: 'left',
        textStyle: {
        fontSize: 16
        }
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
        legend: {
        data: ['中垦乳业', '光明乳业'],
        x: 'center',
        top:'3%'
        },
        tooltip: {
        trigger: 'axis',
        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
        type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        },
            formatter: function (params) {
            var format;
            if(typeof (params[1])!= "undefined"){
            if(params[0].name!='应收账款周转率'){
            format = params[0].name+'<br/>'+params[0].seriesName+':'+params[0].value+' %'+'<br/>'+params[1].seriesName+':'+params[1].value+' %';
            }else {
            format = params[0].name+'<br/>'+params[0].seriesName+':'+Math.floor(params[0].value)+' 次'+'<br/>'+params[1].seriesName+':'+Math.floor(params[1].value)+' 次';
            }
        }else{
        if(params[0].name!='应收账款周转率'){
        format = params[0].name+'<br/>'+params[0].seriesName+':'+params[0].value+' %';
        }else {
        format = params[0].name+'<br/>'+params[0].seriesName+':'+Math.floor(params[0].value)+' 次';
        }
    }
            return format;
        }
    },
            xAxis: {
            type: 'category',
            data: sxAxis,
            axisLabel: {
            interval: 0,
            rotate: -20,
            margin: 30,
            textStyle: {
            color: '#0c180d',
            align: 'center'

         }
        }
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
            name: '中垦乳业',
            type: 'bar',
            data: seriesZK
            },
            {
            name: '光明乳业',
            type: 'bar',
            data: seriesGM
            }
        ]
    };

            var finance = echarts.init($("#finance_div")[0], echartsTheme);
            finance.setOption(option);
            $(window).resize(function () {
            finance.resize();
            });
        }

</script>
</body>
<@footer/>
</html>
