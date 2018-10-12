<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>销售渠道分析</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                渠道分析
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">天友乳业</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-lg-12">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">低温奶</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table class="table table-bordered">
                                <tbody>
                                <tr>
                                    <th style="width: 10px" rowspan="3">#</th>
                                    <th rowspan="3" width="9%">物料分组</th>
                                    <th rowspan="3">物料名称</th>
                                    <th rowspan="3" width="5%">单位</th>
                                    <th colspan="4">经销商渠道</th>
                                    <th colspan="4">健康生活馆</th>
                                    <th colspan="2" rowspan="2">合计</th>
                                </tr>
                                <tr>
                                    <th colspan="2">销量</th>
                                    <th colspan="2">销额</th>
                                    <th colspan="2">销量</th>
                                    <th colspan="2">销额</th>
                                </tr>
                                <tr>
                                    <th>数量</th>
                                    <th>占比</th>
                                    <th>金额</th>
                                    <th>占比</th>
                                    <th>数量</th>
                                    <th>占比</th>
                                    <th>金额</th>
                                    <th>占比</th>
                                    <th>数量</th>
                                    <th>金额</th>
                                </tr>
                                <tr>
                                    <td>1.</td>
                                    <td>巴氏奶</td>
                                    <td><span class="label label-primary">爱克林AD鲜牛奶</span></td>
                                    <td>袋</td>
                                    <td>15975</td>
                                    <td>
                                        <span class="badge bg-yellow">10.5%</span>
                                    </td>
                                    <td>30411.39</td>
                                    <td>
                                        <span class="badge bg-green">0.5%</span>
                                    </td>
                                    <td>0</td>
                                    <td>
                                        <span class="badge bg-blue">0%</span>
                                    </td>
                                    <td>0</td>
                                    <td>
                                        <span class="badge bg-blue">0%</span>
                                    </td>
                                    <td><span class="badge bg-red">151265</span></td>
                                    <td><span class="badge bg-red">350802.63</span></td>
                                </tr>
                                <tr>
                                    <td>2.</td>
                                    <td>巴氏奶</td>
                                    <td><span class="label label-primary">D190ml瓶装纯鲜牛奶（送奶专供）</span></td>
                                    <td>袋</td>
                                    <td>15975</td>
                                    <td>
                                        <span class="badge bg-yellow">10.5%</span>
                                    </td>
                                    <td>30411.39</td>
                                    <td>
                                        <span class="badge bg-green">0.5%</span>
                                    </td>
                                    <td>0</td>
                                    <td>
                                        <span class="badge bg-blue">0%</span>
                                    </td>
                                    <td>0</td>
                                    <td>
                                        <span class="badge bg-blue">0%</span>
                                    </td>
                                    <td><span class="badge bg-red">151265</span></td>
                                    <td><span class="badge bg-red">350802.63</span></td>
                                </tr>
                                <tr>
                                    <td>3.</td>
                                    <td>酸奶</td>
                                    <td><span class="label label-primary">D160g纸杯低脂无蔗糖酸牛奶（电商专供）</span></td>
                                    <td>袋</td>
                                    <td>15975</td>
                                    <td>
                                        <span class="badge bg-yellow">10.5%</span>
                                    </td>
                                    <td>30411.39</td>
                                    <td>
                                        <span class="badge bg-green">0.5%</span>
                                    </td>
                                    <td>0</td>
                                    <td>
                                        <span class="badge bg-blue">0%</span>
                                    </td>
                                    <td>0</td>
                                    <td>
                                        <span class="badge bg-blue">0%</span>
                                    </td>
                                    <td><span class="badge bg-red">151265</span></td>
                                    <td><span class="badge bg-red">350802.63</span></td>
                                </tr>
                                <tr>
                                    <td>4.</td>
                                    <td>饮料</td>
                                    <td><span class="label label-primary">PE瓶装原味活性乳酸菌饮品</span></td>
                                    <td>袋</td>
                                    <td>15975</td>
                                    <td>
                                        <span class="badge bg-yellow">10.5%</span>
                                    </td>
                                    <td>30411.39</td>
                                    <td>
                                        <span class="badge bg-green">0.5%</span>
                                    </td>
                                    <td>18687</td>
                                    <td>
                                        <span class="badge bg-blue">23%</span>
                                    </td>
                                    <td>58772.99</td>
                                    <td>
                                        <span class="badge bg-blue">16%</span>
                                    </td>
                                    <td><span class="badge bg-red">151265</span></td>
                                    <td><span class="badge bg-red">350802.63</span></td>
                                </tr>
                                <tr>
                                    <td>5.</td>
                                    <td>饮料</td>
                                    <td><span class="label label-primary">酵你好看胡萝卜汁饮品</span></td>
                                    <td>袋</td>
                                    <td>15975</td>
                                    <td>
                                        <span class="badge bg-yellow">10.5%</span>
                                    </td>
                                    <td>30411.39</td>
                                    <td>
                                        <span class="badge bg-green">0.5%</span>
                                    </td>
                                    <td>58772.99</td>
                                    <td>
                                        <span class="badge bg-blue">11%</span>
                                    </td>
                                    <td>68156.98</td>
                                    <td>
                                        <span class="badge bg-blue">23%</span>
                                    </td>
                                    <td><span class="badge bg-red">151265</span></td>
                                    <td><span class="badge bg-red">350802.63</span></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">常温奶</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table class="table table-bordered">
                                <tbody>
                                <tr>
                                    <th style="width: 10px" rowspan="3">#</th>
                                    <th rowspan="3" width="9%">物料分组</th>
                                    <th rowspan="3">物料名称</th>
                                    <th rowspan="3" width="5%">单位</th>
                                    <th colspan="4">经销商渠道</th>
                                    <th colspan="4">健康生活馆</th>
                                    <th colspan="2" rowspan="2">合计</th>
                                </tr>
                                <tr>
                                    <th colspan="2">销量</th>
                                    <th colspan="2">销额</th>
                                    <th colspan="2">销量</th>
                                    <th colspan="2">销额</th>
                                </tr>
                                <tr>
                                    <th>数量</th>
                                    <th>占比</th>
                                    <th>金额</th>
                                    <th>占比</th>
                                    <th>数量</th>
                                    <th>占比</th>
                                    <th>金额</th>
                                    <th>占比</th>
                                    <th>数量</th>
                                    <th>金额</th>
                                </tr>
                                <tr>
                                    <td>1.</td>
                                    <td>利乐商业奶</td>
                                    <td><span class="label label-primary">利乐钻青芒牛乳</span></td>
                                    <td>袋</td>
                                    <td>15975</td>
                                    <td>
                                        <span class="badge bg-yellow">10.5%</span>
                                    </td>
                                    <td>30411.39</td>
                                    <td>
                                        <span class="badge bg-green">0.5%</span>
                                    </td>
                                    <td>0</td>
                                    <td>
                                        <span class="badge bg-blue">0%</span>
                                    </td>
                                    <td>0</td>
                                    <td>
                                        <span class="badge bg-blue">0%</span>
                                    </td>
                                    <td><span class="badge bg-red">151265</span></td>
                                    <td><span class="badge bg-red">350802.63</span></td>
                                </tr>
                                <tr>
                                    <td>2.</td>
                                    <td>利乐商业奶</td>
                                    <td><span class="label label-primary">利乐钻香椰牛乳</span></td>
                                    <td>袋</td>
                                    <td>15975</td>
                                    <td>
                                        <span class="badge bg-yellow">10.5%</span>
                                    </td>
                                    <td>30411.39</td>
                                    <td>
                                        <span class="badge bg-green">0.5%</span>
                                    </td>
                                    <td>0</td>
                                    <td>
                                        <span class="badge bg-blue">0%</span>
                                    </td>
                                    <td>0</td>
                                    <td>
                                        <span class="badge bg-blue">0%</span>
                                    </td>
                                    <td><span class="badge bg-red">151265</span></td>
                                    <td><span class="badge bg-red">350802.63</span></td>
                                </tr>
                                <tr>
                                    <td>3.</td>
                                    <td>康美包商业奶</td>
                                    <td><span class="label label-primary">康美包i果粒蓝莓味酸奶饮品（提）</span></td>
                                    <td>袋</td>
                                    <td>15975</td>
                                    <td>
                                        <span class="badge bg-yellow">10.5%</span>
                                    </td>
                                    <td>30411.39</td>
                                    <td>
                                        <span class="badge bg-green">0.5%</span>
                                    </td>
                                    <td>0</td>
                                    <td>
                                        <span class="badge bg-blue">0%</span>
                                    </td>
                                    <td>0</td>
                                    <td>
                                        <span class="badge bg-blue">0%</span>
                                    </td>
                                    <td><span class="badge bg-red">151265</span></td>
                                    <td><span class="badge bg-red">350802.63</span></td>
                                </tr>
                                <tr>
                                    <td>4.</td>
                                    <td>康美包学生奶</td>
                                    <td><span class="label label-primary">康美包学生菠萝奶（标准型）</span></td>
                                    <td>袋</td>
                                    <td>15975</td>
                                    <td>
                                        <span class="badge bg-yellow">10.5%</span>
                                    </td>
                                    <td>30411.39</td>
                                    <td>
                                        <span class="badge bg-green">0.5%</span>
                                    </td>
                                    <td>18687</td>
                                    <td>
                                        <span class="badge bg-blue">23%</span>
                                    </td>
                                    <td>58772.99</td>
                                    <td>
                                        <span class="badge bg-blue">16%</span>
                                    </td>
                                    <td><span class="badge bg-red">151265</span></td>
                                    <td><span class="badge bg-red">350802.63</span></td>
                                </tr>
                                <tr>
                                    <td>5.</td>
                                    <td>饮料</td>
                                    <td><span class="label label-primary">酵你好看胡萝卜汁饮品</span></td>
                                    <td>袋</td>
                                    <td>15975</td>
                                    <td>
                                        <span class="badge bg-yellow">10.5%</span>
                                    </td>
                                    <td>30411.39</td>
                                    <td>
                                        <span class="badge bg-green">0.5%</span>
                                    </td>
                                    <td>58772.99</td>
                                    <td>
                                        <span class="badge bg-blue">11%</span>
                                    </td>
                                    <td>68156.98</td>
                                    <td>
                                        <span class="badge bg-blue">23%</span>
                                    </td>
                                    <td><span class="badge bg-red">151265</span></td>
                                    <td><span class="badge bg-red">350802.63</span></td>
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
        $("th").css({"text-align":"center","vertical-align":"middle"});
        /**
         * 单位样式设置
         */
        $("table tr td:nth-child(4)").css({"text-align":"center","vertical-align":"middle"});
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
