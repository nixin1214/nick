<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>${fNameZh}</title>
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
                <small>${fNameZh}</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"<i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${company}</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-lg-10">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">${fNameZh}趋势图</h3>
                                    <div class="box-tools pull-right">
                                        <input type="text" id="selectTime" placeholder="选择期间...">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-8">
                                            <div class="group_map" style="width: 100%; height: 350px;"></div>
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
</div>
<@jsFile/>

<script type="text/javascript">
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
        financialIndex(yearMonthone);
    });

    $(function () {
        $('#selectTime').datepicker('setDate', '-1m');//设置日期控件默认值,触发change事件
    });
    function financialIndex(yearMonthone) {
         $.ajax({
               url:"${ctx}/report/pastureReport/financialIndexAjax?companyNumber=${company}&fNameEn=${fNameEn}&fNameYs=${fNameYs}&lastYearFNameEn=${lastYearFNameEn}&yearMonthone="+yearMonthone,
               type:"get",
               dataType:"text",
               success: function(result){
                   var jsonObj = eval('(' + result + ')');
                    init(jsonObj);
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
    function init(result) {
        var sxAxis=[];
        var SNFvalue=[];//上年的数据
        var BQFvalue=[];//本期的数据
        var YSFvalue=[];//预算的数据
        var yUnit;
        if(result['fNameEn'][0]=="CW-YSZKZZL-BFBYS"){

            yUnit = '{value} 次';
        }else if(result['fNameEn'][0]=="YYYLNL-LDSCL-BQYS") {

            yUnit = '{value} 万元/人';
        }else{
            yUnit = '{value} %';
        }
        for(var i=0;i<result['yearMonths'].length;i++){
            sxAxis.push(result['yearMonths'][i]);
            if(result['fNameEn'][0]=="CW-YSZKZZL-BFBYS"){
                SNFvalue.push(Math.floor(result['SNFvalue'][i]));
                BQFvalue.push(Math.floor(result['BQFvalue'][i]));
                YSFvalue.push(Math.floor(result['YSFvalue'][i]));
            }else {
                SNFvalue.push(result['SNFvalue'][i].toFixed(2));
                BQFvalue.push(result['BQFvalue'][i].toFixed(2));
                YSFvalue.push(result['YSFvalue'][i].toFixed(2));
            }

        }
        var saleReport = echarts.init($(".group_map")[0]);
        var option2 = {
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['上年', '本期','预算']
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
                    data: sxAxis,
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
                    },
                    axisLabel: {
                        formatter: yUnit
                    }
                }
            ],
            series: [
                {
                    name: '上年',
                    type: 'bar',
                    data: SNFvalue,
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
                    name: '本期',
                    type: 'bar',
                    data: BQFvalue,
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
                    name: '预算',
                    type: 'bar',
                    data: YSFvalue,
                    itemStyle: {
                        normal: {
                            color: '#DDDD22'
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

</script>
</body>
<@footer/>
</html>
