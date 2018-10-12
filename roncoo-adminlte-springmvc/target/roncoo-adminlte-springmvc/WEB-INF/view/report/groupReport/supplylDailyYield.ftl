<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>每日产销量</title>
<@style/>

    <style type="text/css">
        .table-bordered > thead > tr > th{
            border: 1px solid #353333;
        }
        .bootstrap-table .table>thead>tr>th{
            border: 1px solid #353333;
        }
        .table-bordered > tbody > tr > td{
            border: 1px solid #353333;
        }

    </style>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
            ${companyName}
                <small>每日产销量</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i>中垦</a></li>
                <li class="active">${companyName}</li>
            </ol>
        </section>
        <input type="hidden" id="orgCode" value="${companyNumber}">
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">每日产销明细</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="nav-tabs-custom">
                                <ul class="nav nav-tabs" id="myTab">
                                    <li class="active"><a href="#zk_zyzb1" data-toggle="tab" aria-expanded="true" data="1">销量(吨)</a></li>
                                    <li class=""><a href="#zk_zyzb1" data-toggle="tab" aria-expanded="true" data="2">销售收入(万元)</a></li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="col-md-3">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                        <input type="text" class="form-control" id="yearMonth" placeholder="根据时间搜索...">
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <button type="button" onclick="reload();" class="btn btn-primary">搜索</button>
                                </div>
                                <div  class="tab-pane active" id="zk_zyzb1">
                                    <table id="quota_tab" class="table table-bordered table-striped" style="border-width: 3px;border-color: #0c0c0c;"></table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
<@common/>
</div>
<@jsFile/>
<script type="text/javascript">
    var yearMonth;
    var start = 1;
    var pageSize = 20;
    $("#yearMonth").datepicker({
        language: 'zh-CN',
        format: 'yyyymmdd',
        autoclose: true,
        todayHighlight: true,
    }).on('changeDate',function (ev) {
        yearMonth = $(this).val();
    });
$(function () {
    $("li").width("13rem");
    $("li a").height("25px");
    $('#yearMonth').datepicker( 'setDate' , '-1d' );

    //选项卡切换
    $('#myTab a').click(function (e) {
        var idName = $(this).text();
        layer.msg(idName);
        if ($(this).attr("data")==1){
            start = 1;
        }else {
            start = 21;
        }
        queryData(pageSize,start,yearMonth);
    });
    //初始化数据
    queryData(pageSize,start,yearMonth);
});

//查询数据
function queryData(pageSize,start,yearMonth) {
    var url = baseUrl + "/report/dataEdit/dailyReportTotal";
   $.ajax({
        url:url,
       type: 'POST',
       cache: false,
       data: {
           yearMonth: yearMonth,
           type:0,
           pageSize:pageSize,
           start:start
       },
       dataType: 'json',
       success: function (data) {
           var jsonDatas = data.datas||'';
           loadData(jsonDatas);
           if (data.stateCode !== 200) {
               var error = data.error;
               layer.msg(error == null ? "未查询到数据" : error);
           }
       }
   });
}

//数据填充
function loadData(jsonDatas) {
    $('#quota_tab').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: false,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '供应链总表',
            worksheetName: '供应链总表'
        },
        columns: [
            [
                {
                    field: 'distributionChannel',
                    title: "项目",
                    halign: 'center',
                    align: 'left',
                    valign: "middle",
                    colspan: 3
                },
                {
                    title: '供应链',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 8

                }
            ],
            [{
                field: 'distributionChannel',
                title: "渠道",
                halign: 'center',
                align: 'center',
                valign: "middle",
                formatter: function (value, row, index) {
                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'salesArea',
                title: "区域",
                halign: 'center',
                align: 'center',
                valign: "middle",
                formatter: function (value, row, index) {
                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'areaList',
                title: "细项",
                halign: 'center',
                align: 'center',
                valign: "middle",
                formatter: function (value, row, index) {
                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            },
//                {
//                field: 'index',
//                valign: "middle",
//                title: '序号'
//            },
                {
                field: 'dailyPractice',
                valign: "middle",
                title: '当日实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'dailyTotalAvg',
                valign: "middle",
                title: '累计日均',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'dailyAvgBudget',
                valign: "middle",
                title: '预算日均',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'completionRate',
                valign: "middle",
                title: '本月同步完成率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }else {
                        var a = '';
                        a = Math.floor(value*100)+'%';
                        return a;
                    }

                }
            }, {
                field: 'thisMonthBudget',
                valign: "middle",
                title: '本月预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'thisMonthTotal',
                valign: "middle",
                title: '本月累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'thisMonthCompletionRate',
                valign: "middle",
                title: '本月累计完成率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }else {
                        var b = '';
                        b = Math.floor(value*100)+'%';
                        return b;
                    }

                }
            }
            ]
        ],
        data: jsonDatas,
        onAll: function (name, args) {
            $('#quota_tab').bootstrapTable('mergeCells', {
                index: 0,
                field: 'distributionChannel',
                rowspan: 4
            });
            $('#quota_tab').bootstrapTable('mergeCells', {
                index: 4,
                field: 'distributionChannel',
                rowspan: 7
            });
            $('#quota_tab').bootstrapTable('mergeCells', {
                index: 11,
                field: 'distributionChannel',
                rowspan: 8
            });
            $('#quota_tab').bootstrapTable('mergeCells', {
                index: 19,
                field: 'distributionChannel',
                colspan: 3
            });
            $('#quota_tab').bootstrapTable('mergeCells', {
                index: 20,
                field: 'distributionChannel',
                rowspan: 4
            });
            $('#quota_tab').bootstrapTable('mergeCells', {
                index: 24,
                field: 'distributionChannel',
                rowspan: 7
            });
            $('#quota_tab').bootstrapTable('mergeCells', {
                index: 31,
                field: 'distributionChannel',
                rowspan: 8
            });
            $('#quota_tab').bootstrapTable('mergeCells', {
                index: 39,
                field: 'distributionChannel',
                colspan: 3
            });

            $('#quota_tab').bootstrapTable('mergeCells', {
                index: 9,
                field: 'salesArea',
                rowspan: 2
            });
            $('#quota_tab').bootstrapTable('mergeCells', {
                index: 29,
                field: 'salesArea',
                rowspan: 2
            });
        }
    });

}
//条件查询
function reload() {
    queryData(pageSize,start,yearMonth);
}

</script>
</body>
<@footer/>
</html>