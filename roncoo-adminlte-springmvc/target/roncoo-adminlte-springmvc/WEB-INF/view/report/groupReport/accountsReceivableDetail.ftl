<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>应收账款明细</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
            ${companyName}
                <small>应收账款明细</small>
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
                            <span class="info-box-text">年初金额</span>
                            <span class="info-box-number">${(resultData[1])?floor}</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <#assign yesrmx = result[1]>
                            <span class="fa fa-calendar"> ${yesrmx}</span>
                            <span style="position: absolute;right: 20px"> 单位 : 万元</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-green">
                        <span class="info-box-icon"><i class="fa fa-yen"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">期末金额</span>
                            <span class="info-box-number">${(resultData[0])?floor}</span>

                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="fa fa-calendar"> ${yesrmx}</span>
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
                                <#if (resultData[4]>0)>
                                    ${(resultData[0]-resultData[4])/resultData[4]*100}
								<#elseif (resultData[4]<0)>
                                    ${(1-resultData[0]/resultData[4])*100}
                                <#else>
                                    0
                                </#if>
                                    %</span>

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
                                <#if (resultData[2]>0)>
									${(resultData[0]-resultData[2])/resultData[2]*100}
								<#elseif (resultData[2]<0)>
									${(1-resultData[0]/resultData[2])*100}
                                <#else>
                                    0
                                </#if>
                                    %</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="progress-description">相比${lastMonth?substring(0,4)}年${lastMonth?substring(4,6)}月</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box bg-teal">
                        <span class="info-box-icon"><i class="fa fa-refresh"></i></span>

                        <div class="info-box-content">
                            <span class="info-box-text">回款率</span>
                            <span class="info-box-number">
                                <#if resultData[3]!=0>
                                    <#assign result = (resultData[0]-resultData[4])/resultData[3]>
                                ${(1-result)*100}
                                <#else>
                                    0
                                </#if>
                                    %</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 100%"></div>
                            </div>
                            <span class="progress-description">${yesrmx?substring(0,4)}年${(yesrmx?substring(4,6))}月</span>
                        </div>
                        <!-- /.info-box-content -->
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">应收账款分析</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="securityTime" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <div class="row">
                                <div class="col-md-8 col-sm-8">
                                    <div class="businessIncomeChart" style="width: 100%; height: 350px;"></div>
                                </div>
                                <div class="col-md-4 col-sm-4">
                                    <p class="text-center" style="margin-top: 15px;">
                                        <strong>应收账款前5(单位:万元）</strong>
                                    </p>
                                    <table class="table table-condensed" style="height: 260px;">
                                        <thead>
                                        <th class="text-center">序号</th>
                                        <th class="text-center">经销商</th>
                                        <th class="text-center">应收账款</th>
                                        <th class="text-center">回款率</th>
                                        <th class="text-center">环比</th>
                                        <th class="text-center">同比</th>
                                        </thead>
                                        <tbody>

                                        </tbody>
                                    </table>
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
                            <h3 class="box-title">近12个月回款率走势</h3>
                            <div class="box-tools pull-right">
                                <input type="text" id="selectTime" placeholder="选择期间...">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <div class="row">
                                <div class="col-md-12 col-sm-8">
                                    <div id="reimbursementRate" style="width: 100%; height: 350px;"></div>
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
        accountsReceivable(yearMonth);
        queryAccountsReceivable(yearMonth);
    });
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
        reimbursementRateAjax(yearMonths);
    });

    $(function () {
        $('#securityTime').datepicker( 'setDate' , '-1m' );//设置日期控件默认值,触发change事件
        $('#selectTime').datepicker( 'setDate' , '-1m' );
    });


    /**
     * 应收账款明细-近12个月应收账款图-charts数据
     */
    function accountsReceivable(yearMonth) {
        $.ajax({
            url: "${ctx}/report/groupReport/accountsReceivableAjax?companyNumber=${companyNumber}&yearMonth=" + yearMonth,
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
            var propertis = {TYRY:'天友乳业',HSMRY:'华山牧乳业',TNMC:'天宁牧场',HSMC:'华山牧场',ZKGYL:'中垦供应链',THMY:'天鸿牧业'};
            var sxAxis = [];//x轴数据
            var series = [];//数据
            var legend = [];//图例
            for(key in result){
                if (key == 'axisx'){
                    sxAxis = result['axisx'];
                }else {
                    legend.push(propertis[key]);
                    series.push(
                        {
                            name: propertis[key],
                            type: 'line',
                            stack: propertis[key],
                            //areaStyle: {normal: {}},
                            data: result[key]
                        }
                    );
                }
            }
            var saleReport = echarts.init($(".businessIncomeChart")[0], echartsTheme);
            var option = {
                title: {
                    text: '近12个月走势',
                    subtext: '单位:万元',
                    left:'center'
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
                    data: legend,
                    bottom:'5%'
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '15%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: sxAxis
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '其他成员单位',
                        position: 'left',
                        axisLabel: {
                            formatter: '{value}'
                        },
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
                        name: '华山牧乳业',
                        position: 'right',
                        axisLabel: {
                            formatter: '{value}'
                        },
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
            saleReport.setOption(option);

            $(window).resize(function () {
                saleReport.resize();
            });
        }


    function reimbursementRateAjax(yearMonths) {
        $.ajax({
            url: "${ctx}/report/groupReport/reimbursementRateAjax?companyNumber=${companyNumber}&yearMonths="+yearMonths,
            type: "get",
            dataType: "text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                reimbursementRate(jsonObj);
            },
            error:function(){
                console.log('错误');
            }
        });

    }


    /**
     * 初始化
     */
    function reimbursementRate(result) {

        var sxAxis = [];//x轴数据
        var seriesZYYWCB = [];//应收账款数据
        var length = result['resultList'].length;
        for (var i = length-2; i >= 0; i--){
            var index = length-i-1;
            sxAxis.push(result['resultList'][length-1][index]);//取得12个月
            var data1 = result['resultList'][i][0];
            var data2 = result['resultList'][i][2];
            var data3 = result['resultList'][i][1];
            if(data3 ==0){
                seriesZYYWCB.push(0);
                continue;
            }
            var ratio = 1-(data1-data2)/data3;
            seriesZYYWCB.push((ratio*100).toFixed(2));
        }


        var saleReport = echarts.init($("#reimbursementRate")[0], echartsTheme);
        var option2 = {
            title: {
                subtext: '单位:百分比',
                left: '3%'
            },
            tooltip: {
                trigger: 'axis'
            },
            toolbox: {
                show: true,
                right:'3%',
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
                bottom: '10%',
                containLabel: true
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
                    axisLabel: {
                        formatter: '{value} %'
                    },
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
                    name: '回款率',
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
                }
            ]
        };
        saleReport.setOption(option2);

        $(window).resize(function () {
            saleReport.resize();
        });
    };


    function queryAccountsReceivable(yearMonth) {
        $.ajax({
            url: "${ctx}/report/milkReport/queryAccountsReceivable?companyNumber=${companyNumber}&yearMonth="+yearMonth,
            type: "get",
            dataType: "text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                inti(jsonObj);
            },
            error:function(){
                console.log('错误');
            }
        });


        function inti(jsonObj) {
            var data = jsonObj["resultList"];
            $("tbody").empty();
            var tbody = "" ;
            var barColor = ["progress-bar-danger","progress-bar-yellow","progress-bar-primary","progress-bar-success","progress-bar-info"];
            var badgeColor = ["bg-red","bg-yellow","bg-blue","bg-green","bg-aqua"];
            for(var i=0;i<5;i++){
                tbody += "<tr><td>"+(i+1)+".</td>"
                        +"<td>"+data[i].distributor+"</td>"
                        +"<td>" +
                        "<div class=\"progress\">" +
                        "<div class=\"progress-bar "+barColor[i]+"\" style=\"width: 100%\">"+(data[i].accountsReceivable==0?"-":data[i].accountsReceivable)
                        +"</div>" +
                        "</div>" +
                        "</td>" +
                        "<td>" +
                        "<div class=\"progress\">" +
                        "<div class=\"progress-bar "+barColor[i]+"\" style=\"width: 100%\">"+(data[i].growthRate==0?"-":data[i].growthRate)
                        +"</div>" +
                        "</div>" +
                        "</td>" +
                        "<td>" +
                        "<div class=\"progress\">" +
                        "<div class=\"progress-bar "+barColor[i]+"\" style=\"width: 100%\">"+(data[i].ringRatio==0?"-":data[i].ringRatio)
                        +"</div>" +
                        "</div>" +
                        "</td>" +
                        "<td style=\"text-align: center\"><span class=\"badge "+badgeColor[i]+"\">"+(data[i].yearOn==0?"-":(data[i].yearOn+"%"))+"</span></td></tr>";
            }
            $("tbody").append(tbody);
        }
    }

</script>
</body>
<@footer/>
</html>
