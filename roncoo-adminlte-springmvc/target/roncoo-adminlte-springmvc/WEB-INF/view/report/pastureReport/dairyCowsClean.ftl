<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>成乳牛死淘分析</title>
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
                <small>成乳牛死淘分析</small>
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
                                    <h3 class="box-title">成乳牛死淘分析</h3>
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
                                                    <div class="col-md-12 col-sm-8">
                                                        <input class="pull-right" type="text" id="everydayTime" placeholder="选择期间..." style="position: absolute;right:32px;top:5px;z-index: 3;width: 130px">
                                                        <div class="groupcattle" style="height: 300px;"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="chart tab-pane" id="sales-chart" style="position: relative; height: 300px;">
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div style="height: 3px;"></div>
                                                    <div class="col-md-12 col-sm-8">
                                                        <input class="pull-right" type="text" id="yearMonth" style="position: absolute;right:35px;top:5px;z-index: 3;width: 130px">
                                                        <div class="group_map" style=" height: 300px;"></div>
                                                    </div>
                                                </div>
                                            </div>
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
                                    <h3 class="box-title">成乳牛死淘数据分析(单位:头)</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <table id="example2" class="table table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th rowspan="2">病种</th>
                                        <#list resultData.yearMonths as yearMonth>
                                            <th colspan="2">${yearMonth}</th>
                                        </#list>
                                        </tr>
                                        <tr>
                                        <#list resultData.yearMonths as yearMonth>
                                            <th>死亡</th>
                                            <th>淘汰</th>
                                        </#list>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#assign map = resultData.data>
                                        <#list map?keys as bz>
                                        <tr>
                                            <td>${bz}</td>
                                            <#assign ymap = map[bz]>
                                            <#list ymap?keys as qj>
                                                <#assign vmap = ymap[qj]>
                                                <#if vmap["CRLSTL-SW-TS"]==0&&vmap["CRLSTL-TT-TS"]!=0>
                                                    <td>-</td>
                                                    <td>${vmap["CRLSTL-TT-TS"]}</td>
                                                <#elseif vmap["CRLSTL-TT-TS"]==0&&vmap["CRLSTL-SW-TS"]!=0>
                                                    <td>${vmap["CRLSTL-SW-TS"]}</td>
                                                    <td>-</td>
                                                <#elseif vmap["CRLSTL-TT-TS"]==0&&vmap["CRLSTL-SW-TS"]==0>
                                                    <td>-</td>
                                                    <td>-</td>
                                                <#else >
                                                    <td>${vmap["CRLSTL-SW-TS"]}</td>
                                                    <td>${vmap["CRLSTL-TT-TS"]}</td>
                                                </#if>
                                            </#list>
                                        </tr>
                                        </#list>
                                        </tbody>
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
    var yearMonths = '';
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
            $("#yearMonth").datepicker({
                language: 'zh-CN',
                format: 'yyyymm',
                autoclose: true,
                todayHighlight: false,
                startView: 1,
                maxViewMode: 1,
                minViewMode:1
            }).on('changeDate',function (ev) {
                yearMonth = $(this).val();
                dairyCowsClean(yearMonth);
            });
            $('#yearMonth').datepicker( 'setDate' , '-0m' );
        });
    });


    function dairyCowsClean(yearMonth) {
        $.ajax({
            url: "${ctx}/report/pastureReport/dairyCowsCleanAjax?companyNumber=${companyNumber}&company=${company}&yearMonth="+yearMonth,
            type: "get",
            dataType: "text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                init(jsonObj);
            },
            error:function(){
                console.log('错误');
            }
        });
    }
    function everydayChart(yearMonths) {
        $.ajax({
            url: "${ctx}/report/pastureReport/dairyCowsEveryAjax?companyNumber=${companyNumber}&company=${company}&yearMonths="+yearMonths,
            type: "get",
            dataType: "text",
            success: function(result){
                var jsonObj = eval('(' + result + ')');
                everyday(jsonObj);
            },
            error:function(){
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

    /**
     * 初始化
     */
    function everyday(result) {
        var sxAxis=[];//月份数据
        var swFvalue=[];//死亡数据
        var ttFvalue=[];//淘汰数据
        for(var i=0;i<result['yearMonths'].length;i++){
            sxAxis.push(result['yearMonths'][i]);
            swFvalue.push(Math.floor(result['swFvalues'][i]));
            ttFvalue.push(Math.floor(result['ttFvalues'][i]));
        }
        var saleReport = echarts.init($(".groupcattle")[0]);
        console.log(saleReport);
        var option2 = {
            title:{
                subtext:'单位:头',
                left:'5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['死亡', '淘汰']
            },
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                },
                right:'20%'
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
                    name: '死亡',
                    type: 'bar',
                    data: swFvalue,
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
                    name: '淘汰',
                    type: 'bar',
                    data: ttFvalue,
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
    function init(result) {
        var sxAxis=[];//月份数据
        var swFvalue=[];//死亡数据
        var ttFvalue=[];//淘汰数据
        for(var i=0;i<result['yearMonths'].length;i++){
            sxAxis.push(result['yearMonths'][i]);
            swFvalue.push(Math.floor(result['swFvalues'][i]));
            ttFvalue.push(Math.floor(result['ttFvalues'][i]));
        }
        var saleReport = echarts.init($(".group_map")[0]);
        console.log(saleReport);
        var option2 = {
            title:{
                subtext:'单位:头',
                left:'5%'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['死亡', '淘汰']
            },
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                },
                right:'20%'
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    data: sxAxis,
                    axisLabel:{
                        interval:0,
                        rotate:-30,
                        margin: 30,
                        textStyle:{
                            color:'#0c180d',
                            align: 'center'

                        }
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
                    name: '死亡',
                    type: 'bar',
                    data: swFvalue,
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
                    name: '淘汰',
                    type: 'bar',
                    data: ttFvalue,
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

    $(function () {
        $('#example2').DataTable({
            'paging': true,
            'lengthChange': true,
            'searching': false,
            'ordering': true,
            'info': true,
            'autoWidth': false,
            'language':{
                'paginate':{
                    'next':'下一页',
                    'previous': '上一页'
                },
                'info':'第 _PAGE_ 页 共 _PAGES_ 页',
                'emptyTable': '查询无数据',
                'infoEmpty': '第 0 页 共 0 页',
                'lengthMenu':'显示 _MENU_ 条'
            }
        })
    })


</script>
</body>
<@footer/>
</html>
