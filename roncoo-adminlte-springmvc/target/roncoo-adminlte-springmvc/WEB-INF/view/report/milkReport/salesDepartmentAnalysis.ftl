<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>销售部门分析</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <#--<div class="content-wrapper">
        <section class="content-header">
            <h1>
			${company}
                <input type="hidden" id="company" value="${companyName}">
                <small>销售部门分析</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${company}</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">销售部门分析</h3>
                            <div class="box-tools pull-right">
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="clearfix">
                                <div class="col-md-3">
                                    <div class="input-group date ">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right" id="yearMonth" placeholder="选择期间...">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-search"></i></span>
                                        <select id="orgCode" style="width: 100%; padding: 6px 12px; height: 34px; vertical-align: bottom; margin-right: 10px;" class="form-control">

                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-search"></i></span>
                                        <input type="text" class="form-control" id="quotaName" placeholder="根据产品名称搜索...">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <button type="button" onclick="roleReload();" class="btn btn-primary">搜索</button>
                                </div>
                            </div><br>
                            <table id="quota_tab" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>销售部门</th>
                                    <th>销量</th>
                                    <th>销额</th>
                                    <th>占比</th>
                                    <th>销售组织</th>
                                    <th>上期销量</th>
                                    <th>去年同期销量</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
<@common/>
<@jsFile/>
<script type="text/javascript">
    var role_tab;
    $(function() {
        //初始化时间选择器
        $('#yearMonth').datepicker({
            language: 'zh-CN',
            format: 'yyyymm',
            autoclose: true,
            todayHighlight: true
        });
        //初始化表格

        var No=0;
        role_tab = $('#quota_tab').DataTable({
            "dom":'itflp',
            "processing":true,
            "searching":false,
            "serverSide":true, //启用服务器端分页
            "bInfo":false,
            "language":{"url":"plugins/datatables/language.json"},
            "ajax":{"url":"${ctx}/report/dataEdit/page","type":"post"},
            "columns":[
                {"data":null},
                {"data":"0#"},
                {"data":"6.65"},
                {"data":"67.04"},
                {"data":"445.82"},
                {"data":"445.82"},
                {"data":"2016/4/2"},
                {"data":"0C9840B5"}
            ],
            "columnDefs" : [
                {
                    targets: 0,
                    data: null,
                    render: function (data) {
                        No=No+1;
                        return No;
                    }
                } ]
        }).on('preXhr.dt', function ( e, settings, data ) {
            console.log(data,settings)
            No=0;
        } );
    });

    function roleReload(){
        //reloadTable(role_tab,"#yearMonth","#quotaName");

        var date = $("#yearMonth").val();
        var search = $("#quotaName").val();
        var param = {
            "yearMonth" : date,
            "quotaName" : search,
            "orgCode" : $("#orgCode").val()
        };
        role_tab.settings()[0].ajax.data = param;
        role_tab.ajax.reload();
    }

    $(window).load(function () {
        var el = $('.content-header');
        el.html(el.html().replace(/TYRY/ig, '天友乳业'));
        el.html(el.html().replace(/HSMRY/ig, '华山牧乳业'));
        el.html(el.html().replace(/TNMC/ig, '天宁牧场'));
        el.html(el.html().replace(/HSMC/ig, '华山牧场'));
    });

    //function roleToListAjax(){
    //	list_ajax = role_tab;
    //}
</script>-->
        <div class="content-wrapper" style="background-image: url('dist/img/jqqd.jpg'); background-size: cover;">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                ${companyName}
                    <small>销售部门分析</small>
                </h1>
            </section>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                    <#--<div class="callout callout-info">
                        <h4><i class="icon fa fa-warning"></i> 敬请期待！</h4>
                        <i class="fa fa-cog fa-spin"></i>系统建设中，敬请期待二期！
                    </div>-->
                    <#--<img src="dist/img/jqqd.jpg">-->
                    </div>
                </div>
            </section>
        </div>
</div>
</body>
<@footer/>
</html>