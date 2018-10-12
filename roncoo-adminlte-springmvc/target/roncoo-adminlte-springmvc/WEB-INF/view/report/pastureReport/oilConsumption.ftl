<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>油料消耗表</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
            ${company}
                <input type="hidden" id="company" value="${companyName}">
                <small>油料消耗表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${company}</li>
            </ol>
        </section>
        <input type="hidden" id="orgCode" value="${company}">
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">油料消耗明细</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="clearfix">
                                <div class="col-md-3">
                                    <div class="input-group date ">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right" id="FinishTime" placeholder="选择期间...">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="input-group date ">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right" id="EndTime" placeholder="选择期间...">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-search"></i></span>
                                        <input type="text" class="form-control" id="cardName" placeholder="根据持卡人搜索...">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <button type="button" onclick="roleReload();" class="btn btn-primary">搜索</button>
                                </div>
                            </div><br>
                            <table id="quota_tab" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th class="text-center">序号</th>
                                    <th class="text-center">油料型号</th>
                                    <th class="text-center">单价</th>
                                    <th class="text-center">加油量(升)</th>
                                    <th class="text-center">金额</th>
                                    <th class="text-center">加油时间</th>
                                    <th class="text-center">油卡号</th>
                                    <th class="text-center">油卡余额</th>
                                    <th class="text-center">车牌号</th>
                                    <th class="text-center">持卡人</th>
                                    <th class="text-center">加油站</th>
                                </tr>
                                </thead>
                                <tbody id="tbody"></tbody>
                                <tfoot></tfoot>
                            </table>
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
    $(window).load(function () {
        var el = $('.content-header');
        el.html(el.html().replace(/TYRY/ig, '天友乳业'));
        el.html(el.html().replace(/HSMRY/ig, '华山牧乳业'));
        el.html(el.html().replace(/TNMC/ig, '天宁牧场'));
        el.html(el.html().replace(/HSMC/ig, '华山牧场'));
    });

    $(function() {
        //初始化时间选择器
        $('#FinishTime').datepicker({
            language: 'zh-CN',
            format: 'yyyy-mm-dd',
            autoclose: true,
            todayHighlight: true
        });
    });
    $(function() {
        //初始化时间选择器
        $('#EndTime').datepicker({
            language: 'zh-CN',
            format: 'yyyy-mm-dd',
            autoclose: true,
            todayHighlight: true
        });
    });

    var role_tab;
    var totalLiters = 0;
    var totalAmount = 0;
    $(function() {

        var No=0;
        role_tab = $('#quota_tab').DataTable({
            "dom":'itflp',
            "processing":true,
            "searching":false,
            "orderable":false,
            "serverSide":true, //启用服务器端分页
            "bInfo":false,
            "language":{"url":"plugins/datatables/language.json"},
            "ajax":{"url":"${ctx}/report/pastureReport/page","type":"post","data":function (d) {
                d.orgCode=$("#orgCode").val();
            }},
            "columns":[
                {"data":null},
                {"data":"oilname"},
                {"data":"oilprice"},
                {"data":"liters"},
                {"data":"amount"},
                {"data":"finishtime"},
                {"data":"cardno"},
                {"data":"cardremain"},
                {"data":"carno"},
                {"data":"cardname"},
                {"data":"stationname"}
            ],
            "columnDefs" : [
                {
                    targets: 0,
                    data: null,
                    render: function (data) {

                        if (No<$("select option:selected").val()){
                            totalLiters = totalLiters+data.liters;
                            totalAmount = totalAmount+data.amount;
                        }
                        No=No+1;
                        return No;
                    }
                }]
        }).on('preXhr.dt', function ( e, settings, data ) {
            No=0;
            loadTotal();
        });
    });

    function loadTotal(){
        setTimeout(function () {
            $("tfoot").empty();
            $("tfoot").append("<tr>" +
                    "<th>合计</th>" +
                    "<th>-</th>" +
                    "<th>-</th>" +
                    "<th>"+(totalLiters).toFixed(2)+"</th>" +
                    "<th>"+(totalAmount).toFixed(2)+"</th>" +
                    "<th>-</th>" +
                    "<th>-</th>" +
                    "<th>-</th>" +
                    "<th>-</th>" +
                    "<th>-</th>" +
                    "<th>-</th></tr>");
        },500);
        totalLiters=0;
        totalAmount = 0;
    }

    //查询 点击事件方法
    function roleReload(){
        var endTime = $("#EndTime").val();
        var date = $("#FinishTime").val();
        var search = $("#cardName").val();
        var orgCode = $("#orgCode").val();
        var param = {
            "endTime" : endTime,//结束时间
            "finishTime" : date,//开始时间
            "orgCode" :orgCode ,
            "cardName" : search,//指标名
        };
        role_tab.settings()[0].ajax.data = param;
        role_tab.ajax.reload();
        $("tfoot").empty();
        totalLiters = 0;
        totalAmount = 0;
    }


</script>
</body>
<@footer/>
</html>