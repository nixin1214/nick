<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>中垦经分系统</title>
<@style/>
    <style type="text/css">
        #quota_tab{
            border-width: 3px;
            border-color: #0c0c0c
        }
        #zk_zyzb_tb2{
            border-width: 3px;
            border-color: #0c0c0c
        }
        .bootstrap-table .table>thead>tr>th{
            border: 1px solid #353333;
        }
        .bootstrap-table .table:not(.table-condensed)>tbody>tr>td{
            border:1px solid #353333;
        }
    </style>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">指标管理</h3>
                            <div class="box-tools pull-right">
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="nav-tabs-custom">
                                <ul class="nav nav-tabs" id="myTab">
                                    <li class="active"><a href="#zk_zyzb1" data-toggle="tab" aria-expanded="true" data="0">供应链总表</a></li>
                                    <li class=""><a href="#zk_zyzb2" data-toggle="tab" aria-expanded="true" data="1">供应链分表</a></li>
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
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-info"><i class="glyphicon glyphicon-import icon-share"></i>导入</button>
                                    <button type="button" class="btn btn-info" onclick="window.location.href='${ctx}/report/dataEdit/downloadTempFile?tempType=DAILY_REPORT'"><i class="glyphicon glyphicon-export icon-share"></i>模板下载</button>
                                </div>
                                <div  class="tab-pane active" id="zk_zyzb1">
                                    <table id="quota_tab" class="table table-bordered table-striped"></table>
                                </div>
                                <div  class="tab-pane" id="zk_zyzb2">
                                    <table id="zk_zyzb_tb2" class="table table-bordered table-striped"></table>
                                </div>
                            </div>
                            <div class="modal modal-info fade" id="modal-info">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title">对标数据上传</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="alert alert-danger alert-dismissable" id="errorMsg" style="display: none">
                                                <button type="button" class="close" data-dismiss="alert"
                                                        aria-hidden="true">
                                                    &times;
                                                </button>
                                            </div>
                                            <div class="clearfix">
                                                <label for="jobData" class="control-label" style="float:left;padding-left:15px; padding-right: 5px; line-height: 34px;">对标数据</label>
                                                <div class="file-container" style="display:inline-block;position:relative;overflow: hidden;vertical-align:middle">
                                                    <form id="infoLogoForm" enctype='multipart/form-data'>
                                                        <input type="hidden" name="idcNum" id="idcNum" value=""/>
                                                        <button class="btn btn-success fileinput-button" type="button">上传</button>
                                                        <input type="file" id="financeFile" name="financeFile" onchange="loadFile(this.files[0])" style="position:absolute;top:0;left:0;font-size:34px; opacity:0">
                                                    </form>
                                                </div>
                                                <span id="filename" style="vertical-align: middle">未选择文件</span>
                                            </div>
                                            <script>
                                                function loadFile(file){
                                                    if (file.name.endsWith('.xls') || file.name.endsWith('.xlsx') ) {
                                                        $("#errorMsg").hide();
                                                        $("#filename").html(file.name);
                                                    }else{
                                                        $("#errorMsg").text("只能选择excel文件").show();
                                                        setTimeout(function() {
                                                            $("#errorMsg").hide(1000);
                                                        }, 2000);
                                                        return false;
                                                    }
                                                }
                                            </script>
                                        </div>

                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-outline pull-left" data-dismiss="modal" id="close-modal">关闭</button>
                                            <button type="button" class="btn btn-outline" id="uploadBtn">确定上传</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
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
<script type="text/javascript" src="dist/layer/layer.js" ></script>
<script type="text/javascript">
    var currentNum = 0;
    var yearMonth = $("#yearMonth").val();
        //初始化时间选择器
        $('#yearMonth').datepicker({
            language: 'zh-CN',
            format: 'yyyymmdd',
            autoclose: true,
            todayHighlight: true,
        }).on('changeDate',function (ev) {
            yearMonth = $(this).val();
        });
    $(function() {
        $("li").width("8rem");
        $("li a").height("25px");
        $('#yearMonth').datepicker( 'setDate' , '-1d' );
        $("#uploadBtn").on("click", function () {
            var financeForm = new FormData();
            financeForm.append("financeFile", document.getElementById("financeFile").files[0]);
            financeForm.append("idcNum", document.getElementById("idcNum").value);
            console.log(yearMonth);
            financeForm.append("period",yearMonth);
            var url = baseUrl + "/report/dataEdit/importDailyReport";

            $.ajax({
                url: url,
                type: 'POST',
                cache: false,
                async: false,
                data: financeForm,
                processData: false,
                contentType: false,
                dataType:'json',
                success:function(data){            //服务器响应成功时的处理函数
                    if (data.stateCode === 200) {
                        layer.msg('导入成功！');
                    } else {
                        layer.msg(data.error);
                    }
                    $("#financeFile").val(null);
                    $("#filename").text("请选择文件");
                    reload();
                    $("#close-modal").click();
                }
            }).done(function(res) {
                console.log(res);
            }).fail(function(res) {
                console.log(res);
            });

        });


        //选项卡切换
        $('#myTab a').click(function (e) {
            var idName = $(this).text();
            currentNum = $(this).attr("data");
            $("#idcNum").val(currentNum);
            layer.msg(idName);
            queryData(yearMonth,currentNum);
        });

        queryData(yearMonth,currentNum);
    });

    function queryData(yearMonth,currentNum) {
        var pageSize;
        if (currentNum==0){
            pageSize = 40;
        }else {
            pageSize = 102;
        }
        var url = baseUrl + "/report/dataEdit/dailyReportTotal";
        $.ajax({
            url: url,
            type: 'POST',
            cache: false,
            data: {
                yearMonth: yearMonth,
                type:currentNum,
                pageSize:pageSize
            },
            dataType: 'json',
            success: function (data) {
                showCurrentTabData(data,pageSize);
            }
        });
    }

    function showCurrentTabData(data,pageSize) {
        var jsonDatas = data.datas||'';
        var idcNum = data.idcNum;
        switch (idcNum) {
            case 0:
                //总表
                loadData(jsonDatas,pageSize);
                break;
            case 1:
                //分表
                load_zyzb2(jsonDatas,pageSize);
                break;
        }
        if (data.stateCode !== 200) {
            var error = data.error;
            layer.msg(error == null ? "未查询到数据" : error);
        }
    }


    function loadData(jsonDatas,pageSize) {
        $('#quota_tab').bootstrapTable('destroy').bootstrapTable({
            striped: true,
            pagination: false,
            pageNumber: 1,
            pageSize: pageSize,
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
//                    {
//                    field: 'index',
//                    valign: "middle",
//                    title: '序号'
//                },
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
                        }
                        return value;
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
                        }
                        return value;
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

    function load_zyzb2(jsonDatas,pageSize) {
        console.log(jsonDatas);
        $('#zk_zyzb_tb2').bootstrapTable('destroy').bootstrapTable({
            striped: true,
            pagination: false,
            pageNumber: 1,
            pageSize: pageSize,
            pageList: [20, 50, 100],
            search: false,
            showColumns: true,
            showRefresh: true,
            showToggle: true,
            showExport: false,
            exportDataType: 'all',
            exportTypes: ['xls'],
            exportOptions: {
                fileName: '供应链分表',
                worksheetName: '供应链分表'
            },
            columns: [
                [
                    {
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
//                    {
//                    field: 'index',
//                    valign: "middle",
//                    title: '序号'
//                },
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
                        }
                        return value;
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
                        }
                        return value;
                    }
                }
                ]
            ],
            data: jsonDatas,
            onAll: function (name, args) {
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 0,
                    field: 'distributionChannel',
                    rowspan: 10
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 10,
                    field: 'distributionChannel',
                    rowspan: 11
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 21,
                    field: 'distributionChannel',
                    rowspan: 29
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 50,
                    field: 'distributionChannel',
                    colspan: 3
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 51,
                    field: 'distributionChannel',
                    rowspan: 10
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 61,
                    field: 'distributionChannel',
                    rowspan: 11
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 72,
                    field: 'distributionChannel',
                    rowspan: 29
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 101,
                    field: 'distributionChannel',
                    colspan: 3
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 0,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 4,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 9,
                    field: 'salesArea',
                    colspan: 2
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 10,
                    field: 'salesArea',
                    rowspan: 5
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 15,
                    field: 'salesArea',
                    rowspan: 5
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 20,
                    field: 'salesArea',
                    colspan: 2
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 21,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 25,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 29,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 33,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 37,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 41,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 45,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 49,
                    field: 'salesArea',
                    colspan: 2
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 51,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 55,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 60,
                    field: 'salesArea',
                    colspan: 2
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 61,
                    field: 'salesArea',
                    rowspan: 5
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 66,
                    field: 'salesArea',
                    rowspan: 5
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 71,
                    field: 'salesArea',
                    colspan: 2
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 72,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 76,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 80,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 84,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 88,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 92,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 96,
                    field: 'salesArea',
                    rowspan: 4
                });
                $('#zk_zyzb_tb2').bootstrapTable('mergeCells', {
                    index: 100,
                    field: 'salesArea',
                    colspan: 2
                });
            }
        });
    }


    function reload() {
        queryData(yearMonth,currentNum);
    }

</script>
</body>
<@footer/>
</html>