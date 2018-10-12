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
                天友乳业
                <small>综合指标</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">天友乳业</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-lg-10">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">综合指标</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="col-lg-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-aqua">
                                            <div class="inner">
                                                <h3>150</h3>

                                                <p>销售收入</p>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-social-bitcoin-outline"></i>
                                            </div>
                                            <a href="javascript:void(0)" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>
                                    <!-- ./col -->
                                    <div class="col-lg-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-green">
                                            <div class="inner">
                                                <h3>53<sup style="font-size: 20px">%</sup></h3>

                                                <p>销售毛利</p>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-arrow-graph-up-right"></i>
                                            </div>
                                            <a href="#" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>
                                    <!-- ./col -->
                                    <div class="col-lg-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-yellow">
                                            <div class="inner">
                                                <h3>44</h3>

                                                <p>牛奶产量</p>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-speedometer"></i>
                                            </div>
                                            <a href="#" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>
                                    <!-- ./col -->
                                    <div class="col-lg-3 col-sm-6">
                                        <!-- small box -->
                                        <div class="small-box bg-red">
                                            <div class="inner">
                                                <h3>65535</h3>

                                                <p>本年累计销量</p>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-checkmark"></i>
                                            </div>
                                            <a href="#" class="small-box-footer">查看明细<i class="fa fa-arrow-circle-right"></i></a>
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
                                    <h3 class="box-title">年度销量分析</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-9 col-sm-8">
                                            <div class="group_map" style="width: 100%; height: 350px;"></div>
                                        </div>
                                        <div class="col-md-3 col-sm-4">
                                            <div class="col-md-12">
                                                <p class="text-center">
                                                    <strong>本月销量TOP5</strong>
                                                </p>
                                                <table class="table table-condensed">
                                                    <tbody><tr>
                                                        <th style="width: 10px">#</th>
                                                        <th>产品</th>
                                                        <th>销量</th>
                                                        <th style="width: 40px">增长率</th>
                                                    </tr>
                                                    <tr>
                                                        <td>1.</td>
                                                        <td>纯源</td>
                                                        <td>
                                                            <div class="progress progress">
                                                                <div class="progress-bar progress-bar-danger" style="width: 55%">5000</div>
                                                            </div>
                                                        </td>
                                                        <td><span class="badge bg-red">55%</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td>2.</td>
                                                        <td>优酸乳</td>
                                                        <td>
                                                            <div class="progress progress">
                                                                <div class="progress-bar progress-bar-yellow" style="width: 70%">6000</div>
                                                            </div>
                                                        </td>
                                                        <td><span class="badge bg-yellow">70%</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td>3.</td>
                                                        <td>巴士奶</td>
                                                        <td>
                                                            <div class="progress progress progress-striped active">
                                                                <div class="progress-bar progress-bar-primary" style="width: 70%">3000</div>
                                                            </div>
                                                        </td>
                                                        <td><span class="badge bg-light-blue">30%</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td>4.</td>
                                                        <td>核桃奶</td>
                                                        <td>
                                                            <div class="progress progress progress-striped active">
                                                                <div class="progress-bar progress-bar-success" style="width: 90%">8000</div>
                                                            </div>
                                                        </td>
                                                        <td><span class="badge bg-green">90%</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td>5.</td>
                                                        <td>畅优310</td>
                                                        <td>
                                                            <div class="progress progress progress-striped active">
                                                                <div class="progress-bar progress-bar-info" style="width: 90%">8000</div>
                                                            </div>
                                                        </td>
                                                        <td><span class="badge bg-green">90%</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td>6.</td>
                                                        <td>奶粉</td>
                                                        <td>
                                                            <div class="progress progress progress-striped active">
                                                                <div class="progress-bar progress-bar-Teal" style="width: 68%">6800</div>
                                                            </div>
                                                        </td>
                                                        <td><span class="badge bg-green">68%</span></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">快速查看</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="box-body">
                            <table class="table table-condensed">
                                <tbody>
                                <tr>
                                    <th>销售</th>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">销售看板</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">区域分析</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">渠道分析</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">品牌分析</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">品类分析</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">销售部门分析</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">应收账款分析</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">销售发货及时率</a></td>
                                </tr>
                                <tr>
                                    <th>采购</th>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">采购看板</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">采购价格分析</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">采购执行分析</a></td>
                                </tr>
                                <tr>
                                    <th>财务</th>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">资产负债率</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">流动比率</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">速动比率</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">应收账款周转率</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">销售毛利率</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">营业利润率</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">成本费用利润率</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">期间费用率</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">劳动生产率</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">资产产出率</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">资产增长率</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">销售增长率</a></td>
                                </tr>
                                <tr>
                                    <td><a href="javascript:void(0)">利润增长率</a></td>
                                </tr>
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
    /**
     * 获取当前panel对象
     *
     * @returns {*|jQuery}
     */
    function getTabPanel() {
        var _tab_index = $("#navTabs li[class=active]").index();
        return $("#content").eq(_tab_index - 1);
    }

    $(function() {
        init();
    });

    /**
     * 初始化
     */
    function init () {
        var saleReport = echarts.init($(".group_map")[0]);
        console.log(saleReport);
        var option2 = {
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['低温奶','常温奶']
            },
            toolbox: {
                show : true,
                feature : {
                    dataView : {show: true, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'低温奶',
                    type:'bar',
                    data:[200.0, 240.9, 270.0, 323.2, 325.6, 376.7, 335.6, 262.2, 432.6, 220.0, 460.4, 3.3],
                    itemStyle: {
                        normal: {
                            color: '#00c0ef'
                        }
                    },
                    markPoint : {
                        data : [
                            {type : 'max', name: '最大值'},
                            {type : 'min', name: '最小值'}
                        ]
                    }
                },
                {
                    name:'常温奶',
                    type:'bar',
                    data:[112.6, 150.9, 129.0, 126.4, 158.7, 170.7, 175.6, 182.2, 148.7, 18.8, 130.0, 200.3],
                    itemStyle: {
                        normal: {
                            color: '#00a65a'
                        }
                    },
                    markPoint : {
                        data : [
                            {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183},
                            {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
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
