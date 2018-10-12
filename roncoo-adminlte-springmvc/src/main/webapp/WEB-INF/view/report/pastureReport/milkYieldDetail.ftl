<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>营业收入明细</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                天宁牧场
                <small>牛奶产量及理化指标分析</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">天宁牧场</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-lg-10">
                    <div class="row">
                        <div class="col-md-12">

                            <div class="box box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">平均产奶量数据(kg)</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <table id="example2" class="table table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>1月</th>
                                            <th>2月</th>
                                            <th>3月</th>
                                            <th>4月</th>
                                            <th>5月</th>
                                            <th>6月</th>
                                            <th>7月</th>
                                            <th>8月</th>
                                            <th>9月</th>
                                            <th>10月</th>
                                            <th>11月</th>
                                            <th>12月</th>
                                            <th>平均值</th>
                                            <th>本月预算</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>泌乳牛</td>
                                            <td>31.21</td>
                                            <td>31.31</td>
                                            <td>30.82</td>
                                            <td>31.42</td>
                                            <td>30.79</td>
                                            <td>30.81</td>
                                            <td>29.81</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>30.91</td>
                                            <td>-</td>
                                        </tr>
                                        <tr>
                                            <td>成乳牛</td>
                                            <td>26.68</td>
                                            <td>28.49</td>
                                            <td>28.07</td>
                                            <td>28.27</td>
                                            <td>27.38</td>
                                            <td>27.71</td>
                                            <td>26.92</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>27.68</td>
                                            <td>-</td>
                                        </tr>
                                        <tr>
                                            <td>泌乳牛饲养头日</td>
                                            <td>112880</td>
                                            <td>135032</td>
                                            <td>121813</td>
                                            <td>132141</td>
                                            <td>126089</td>
                                            <td>131228</td>
                                            <td>129218</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>126914</td>
                                            <td>-</td>
                                        </tr>
                                        <tr>
                                            <td>成乳牛饲养头日</td>
                                            <td>132014</td>
                                            <td>148419</td>
                                            <td>133759</td>
                                            <td>146862</td>
                                            <td>141782</td>
                                            <td>145920</td>
                                            <td>143088</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>141692</td>
                                            <td>-</td>
                                        </tr>
                                        <tr>
                                            <td>月总产奶量</td>
                                            <td>3544730</td>
                                            <td>4228480</td>
                                            <td>3754190</td>
                                            <td>4151760</td>
                                            <td>3882560</td>
                                            <td>4043060</td>
                                            <td>3851940</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>3922389</td>
                                            <td>-</td>
                                        </tr>
                                        <tr>
                                            <td>干奶牛比例</td>
                                            <td><span class="badge bg-yellow">14.5%</span></td>
                                            <td><span class="badge bg-yellow">9.9%</span></td>
                                            <td><span class="badge bg-yellow">8.9%</span></td>
                                            <td><span class="badge bg-yellow">10.0%</span></td>
                                            <td><span class="badge bg-yellow">11.1%</span></td>
                                            <td><span class="badge bg-yellow">10.1%</span></td>
                                            <td><span class="badge bg-yellow">9.7%</span></td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td><span class="badge bg-yellow">10.4%</span></td>
                                            <td>-</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.box-body -->
                            </div>


                            <div class="box box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">牛奶质量指标数据</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <table id="example2" class="table table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>1月</th>
                                            <th>2月</th>
                                            <th>3月</th>
                                            <th>4月</th>
                                            <th>5月</th>
                                            <th>6月</th>
                                            <th>7月</th>
                                            <th>8月</th>
                                            <th>9月</th>
                                            <th>10月</th>
                                            <th>11月</th>
                                            <th>12月</th>
                                            <th>国际一流牧场水平</th>
                                            <th>预算值</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>体细胞含量/ml</td>
                                            <td>166395</td>
                                            <td>163776</td>
                                            <td>164800</td>
                                            <td>159678</td>
                                            <td>165582</td>
                                            <td>176245</td>
                                            <td>191001</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>100000</td>
                                            <td>-</td>
                                        </tr>
                                        <tr>
                                            <td>微生物含量/ml</td>
                                            <td>5512</td>
                                            <td>3881</td>
                                            <td>4500</td>
                                            <td>5800</td>
                                            <td>15288</td>
                                            <td>13061</td>
                                            <td>12217</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>100000</td>
                                            <td>-</td>
                                        </tr>
                                        <tr>
                                            <td>蛋白质含量(%)</td>
                                            <td>3.30</td>
                                            <td>3.28</td>
                                            <td>3.29</td>
                                            <td>3.30</td>
                                            <td>3.28</td>
                                            <td>3.25</td>
                                            <td>3.20</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>3.30</td>
                                            <td>-</td>
                                        </tr>
                                        <tr>
                                            <td>脂肪含量(%)</td>
                                            <td>3.92</td>
                                            <td>3.88</td>
                                            <td>3.90</td>
                                            <td>3.95</td>
                                            <td>3.83</td>
                                            <td>3.76</td>
                                            <td>3.78</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>4.00</td>
                                            <td>-</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.box-body -->
                            </div>


                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">产奶量及理化指标分析</h3>
                                    <div class="box-tools pull-right">
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
                                    <div class="row">
                                        <div class="col-md-12 col-sm-8">
                                            <div class="cattle_map" style="width: 100%; height: 350px;"></div>
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
    /**
     * 获取当前panel对象
     *
     * @returns {*|jQuery}
     */
    function getTabPanel() {
        var _tab_index = $("#navTabs li[class=active]").index();
        return $("#content").eq(_tab_index - 1);
    }

    $(function () {
        init();
    });

    /**
     * 初始化
     */
    function init() {
        var saleReport = echarts.init($(".group_map")[0], echartsTheme);
        console.log(saleReport);
        var option2 = {
            title: {
                text: '产量分析',
                subtext: '单位:千克',
                left: 'center'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data: ['月产奶量']
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
                    data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '月产奶量',
                    type: 'line',
                    data: [3544730, 4228480, 3754190, 4151760, 3882560, 4043060, 3851940, 0, 0, 0, 0, 0],
                    itemStyle: {
                        normal: {
                            color: '#2b6ba6'
                        }
                    }, markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                }
                }
            ]
        };
        saleReport.setOption(option2);


            var saleReport = echarts.init($(".cattle_map")[0], echartsTheme);
            console.log(saleReport);
            var option2 = {
                title: {
                    text: '指标分析',
                    subtext: '单位:ml',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    orient: 'vertical',
                    x: 'left',
                    data: ['体细胞含量', '微生物含量']
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
                        data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '体细胞含量',
                        type: 'line',
                        data: [166395, 163776, 164800, 159678, 165582, 176245, 191001, 0, 0, 0, 0, 0],
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
                        name: '微生物含量',
                        type: 'line',
                        data: [5512, 3881, 4500, 5800, 15288, 13061, 12217, 0, 0, 0, 0, 0],
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
