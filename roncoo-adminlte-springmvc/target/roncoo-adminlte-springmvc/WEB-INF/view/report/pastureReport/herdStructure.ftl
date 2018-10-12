<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>牛群结构分析</title>
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
                <small>牛群结构分析</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${company}</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">牛群结构分析</h3>
                                    <div class="box-tools pull-right">

                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="nav-tabs-custom">
                                    <!-- Tabs within a box -->
                                    <ul class="nav nav-tabs pull-right">
                                        <li class="active"><a href="#revenue-chart" data-toggle="tab" style="color: #00a65a">按日查看</a></li>
                                        <li><a href="#sales-chart" data-toggle="tab" style="color: #00a7d0" id="eyeryChart">按月查看</a></li>
                                    </ul>
                                    <div class="tab-content no-padding">
                                        <div class="chart tab-pane active" id="revenue-chart" style="position: relative; height: 300px;">
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div style="height: 3px;"></div>
                                                <div class="col-md-12 col-sm-8">
                                                    <input class="pull-right" type="text" id="everydayTime" placeholder="选择期间..." style="position: absolute;right:28px;top:5px;z-index: 3">
                                                    <div class="groupcattle" style=" height: 300px;"></div>
                                                </div>
                                            </div>
                                        </div>
                                        </div>
                                        <div class="chart tab-pane" id="sales-chart" style="position: relative; height: 300px">
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div style="height: 3px;"></div>
                                                    <div class="col-md-12 col-sm-8">
                                                        <input class="pull-right" type="text" id="securityTime" placeholder="选择期间..." style="position: absolute;right:28px;top:5px;z-index: 3">
                                                        <div class="group_map" style=" height: 300px;"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <#--<div class="box-body no-padding">-->
                                    <#--<div class="row">-->
                                        <#--<div class="col-md-12 col-sm-8">-->
                                            <#--<div class="group_map" style="width: 100%; height: 350px;"></div>-->
                                        <#--</div>-->
                                    <#--</div>-->
                                <#--</div>-->
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">牛群结构分析（头）</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <table id="example2" class="table table-bordered table-hover">
                                        <thead>

                                        </thead>
                                    </table>
                                </div>
                                <!-- /.box-body -->
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
    var yearMonth = '';
    var yearMonths ='';
    $('#everydayTime').datepicker({
        language: 'zh-CN',
        format: 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight: true
    }).on('changeDate',function (ev) {
        yearMonths = $(this).val();
        everydayChart(yearMonths);
    });

    $(function () {
        $('#everydayTime').datepicker( 'setDate' , '-1d' );//设置日期控件默认值,触发change事件
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
    });

    function herdStructure(yearMonth) {
        $.ajax({
            url: "${ctx}/report/pastureReport/herdStructureAjax?companyNumber=${companyNumber}&company=${company}",
            type: "get",
            data: {'yearMonth': yearMonth},
            dataType: "text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                init(jsonObj);
                Areachart(jsonObj);
            },
            error:function(){
                console.log('错误');
            }
        });
    }
    function everydayChart(yearMonths) {
        $.ajax({
            url: "${ctx}/report/pastureReport/herdStructureEveryAjax?companyNumber=${companyNumber}&company=${company}",
            type: "get",
            data: {'yearMonths': yearMonths},
            dataType: "text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                everyChart(jsonObj);
            },
            error:function(){
                console.log('错误');
            }
        });
    }
    function Areachart(result) {
        $("#example2").empty();
        var yearMohth = result["yearMonths"];
        //循环的月份
        var rowone = rowone+"<tr><td>#</td>";
        for(var i=0;i<yearMohth.length;i++){
            rowone = rowone+"<td>"+yearMohth[i]+"</td>";
        }
        $("#example2").append(rowone+"</tr>");
        //循环的数据
        for (var key in result) {
            var row = "<tr>";
            var number = "-";
            if(key != "yearMonths") {
                row = row + "<td>" + key + "</td>";
                for (var i = 0; i < result[key].length; i++) {
                    if(result[key][i]==0){
                        row = row + "<td>" + number + "</td>";
                    }else{
                        row = row + "<td>" + Math.floor(result[key][i]) + "</td>";
                    }

                }
                $("#example2").append(row + "</tr>");
            }
        }
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
    function init(result) {
        var saleReport = echarts.init($(".group_map")[0]);
        console.log(result);

        var sxAxis=[];//月份数据
        var seriesGD=[];//公犊数据
        var seriesMD=[];//母犊数据
        var seriesQNN=[];//青年牛数据
        var seriesGNN=[];//干奶牛数据
        var seriesMRN=[];//泌乳牛数据
        var seriesYCN=[];//育成牛数据
        for(var i = 0; i < result['yearMonths'].length; i++){
            sxAxis.push(result['yearMonths'][i]);
            if (result['公犊'] != null) {
                seriesGD.push(Math.floor(result['公犊'][i]));
            }
            if (result['母犊'] != null) {
                seriesMD.push(Math.floor(result['母犊'][i]));
            }
            if (result['青年牛'] != null) {
                seriesQNN.push(Math.floor(result['青年牛'][i]));
            }
            if (result['干奶牛'] != null) {
                seriesGNN.push(Math.floor(result['干奶牛'][i]));
            }
            if (result['泌乳牛'] != null) {
                seriesMRN.push(Math.floor(result['泌乳牛'][i]));
            }
            if (result['育成牛'] != null) {
                seriesYCN.push(Math.floor(result['育成牛'][i]));
            }
        }
        var option2 = {
            title : {
                text: '',
                subtext: '单位:头',
                left: '5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: [{
                x:'center',
                top:'3%',
                data: ['泌乳牛', '干奶牛','青年牛','母犊','公犊','育成牛']
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
                right:'17%'
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
                    name: '泌乳牛',
                    type: 'line',
                    data: seriesMRN,
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
                    name: '干奶牛',
                    type: 'line',
                    data: seriesGNN,
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
                    name: '青年牛',
                    type: 'line',
                    data: seriesQNN,
                    itemStyle: {
                        normal: {
                            color: '#a53da6'
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
                    name: '母犊',
                    type: 'line',
                    data: seriesMD,
                    itemStyle: {
                        normal: {
                            color: '#2325a6'
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
                    name: '公犊',
                    type: 'line',
                    data: seriesGD,
                    itemStyle: {
                        normal: {
                            color: '#a6a426'
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
                    name: '育成牛',
                    type: 'line',
                    data: seriesYCN,
                    itemStyle: {
                        normal: {
                            color: '#a6a426'
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
    function everyChart(result) {
        var saleReports = echarts.init($(".groupcattle")[0]);
        console.log(result);

        var sxAxis=[];//月份数据
        var seriesGD=[];//公犊数据
        var seriesMD=[];//母犊数据
        var seriesQNN=[];//青年牛数据
        var seriesGNN=[];//干奶牛数据
        var seriesMRN=[];//泌乳牛数据
        var seriesYCN=[];//育成牛数据
        for(var i = 0; i < result['yearMonth'].length; i++){
            sxAxis.push(result['yearMonth'][i]);
            if (result['NQJG-MT-GD'] != null) {
                seriesGD.push(Math.floor(result['NQJG-MT-GD'][i]));
            }
            if (result['NQJG-MT-MD'] != null) {
                seriesMD.push(Math.floor(result['NQJG-MT-MD'][i]));
            }
            if (result['NQJG-MT-QNN'] != null) {
                seriesQNN.push(Math.floor(result['NQJG-MT-QNN'][i]));
            }
            if (result['NQJG-MT-GNN'] != null) {
                seriesGNN.push(Math.floor(result['NQJG-MT-GNN'][i]));
            }
            if (result['NQJG-MT-MRN'] != null) {
                seriesMRN.push(Math.floor(result['NQJG-MT-MRN'][i]));
            }
            if (result['NQJG-MT-YCN'] != null) {
                seriesYCN.push(Math.floor(result['NQJG-MT-YCN'][i]));
            }
        }
        var option2 = {
            title : {
                text: '',
                subtext: '单位:头',
                left: '5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: [{
                x:'center',
                top:'3%',
                data: ['泌乳牛', '干奶牛','青年牛','母犊','公犊','育成牛']
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
                right:'17%'
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    axisLabel: {
                        interval: 1,
                        rotate: -30,
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
            series: [
                {
                    name: '泌乳牛',
                    type: 'line',
                    data: seriesMRN,
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
                    name: '干奶牛',
                    type: 'line',
                    data: seriesGNN,
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
                    name: '青年牛',
                    type: 'line',
                    data: seriesQNN,
                    itemStyle: {
                        normal: {
                            color: '#a53da6'
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
                    name: '母犊',
                    type: 'line',
                    data: seriesMD,
                    itemStyle: {
                        normal: {
                            color: '#2325a6'
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
                    name: '公犊',
                    type: 'line',
                    data: seriesGD,
                    itemStyle: {
                        normal: {
                            color: '#a6a426'
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
                    name: '育成牛',
                    type: 'line',
                    data: seriesYCN,
                    itemStyle: {
                        normal: {
                            color: '#a6a426'
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
        saleReports.setOption(option2);
        $(window).resize(function () {
            saleReports.resize();
        });
    }



</script>
</body>
<@footer/>
</html>
