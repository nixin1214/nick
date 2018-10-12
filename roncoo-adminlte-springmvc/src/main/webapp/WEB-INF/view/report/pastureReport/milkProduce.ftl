<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>牛奶产量及理化指标</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                ${companyName}
                <small>年奶产量及理化指标</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">乳业视图</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-lg-12">
                    <div class="box box-info">
                        <div class="box-body">
                            <div id="toolbar" class="toolbar">
                                <a href="javascript:;" class="btn btn-primary btn-refresh" ><i class="fa fa-refresh"></i> </a>
                                <a href="javascript:;" class="btn btn-danger btn-del btn-disabled disabled" ><i class="fa fa-trash"></i> 删除</a>
                                <a class="btn btn-info btn-disabled disabled btn-selected" href="javascript:;"><i class="fa fa-leaf"></i> 获取选中项</a>
                                <div class="dropdown btn-group">
                                    <a class="btn btn-primary btn-more dropdown-toggle btn-disabled disabled" data-toggle="dropdown"><i class="fa fa-cog"></i> 更多</a>
                                    <ul class="dropdown-menu text-left" role="menu">
                                        <li><a class="btn btn-link btn-multi btn-disabled disabled" href="javascript:;" data-params="status=normal"><i class="fa fa-eye"></i> 设为正常</a></li>
                                        <li><a class="btn btn-link btn-multi btn-disabled disabled" href="javascript:;" data-params="status=hidden"><i class="fa fa-eye-slash"></i> 设为隐藏</a></li>
                                    </ul>
                                </div>
                                <a class="btn btn-success btn-singlesearch" href="javascript:;"><i class="fa fa-user"></i> 自定义搜索</a>
                                <a class="btn btn-success btn-change btn-start" data-params="action=start" data-url="data/edit.json" href="javascript:;"><i class="fa fa-play"></i> 启动</a>
                                <a class="btn btn-danger btn-change btn-pause" data-params="action=pause" data-url="data/edit.json" href="javascript:;"><i class="fa fa-pause"></i> 暂停</a>
                            </div>
                            <table id="table" class="table table-striped table-bordered table-hover" width="100%">

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
    $(function() {
        $('#table').bootstrapTable({
            striped: true,
            pagination: true,
            pageNumber: 1,
            pageSize: 5,
            pageList: [10,20,30,50,100],
            search: false,
            showColumns: true,
            showRefresh: true,
            showToggle: true,
            showExport: true,
            exportDataType: 'all',
            exportTypes: ['xlsx'],
            exportOptions: {
                fileName: '牛奶产量及理化指标',
                worksheetName: '测试中文',
                pdfmake: {
                    enabled: true
                }
            },
            toolbar: '#toolbar',
            columns: [{
                field: 'id',
                title: 'Item ID'
            }, {
                field: 'name',
                title: 'Item Name'
            }, {
                field: 'price',
                title: 'Item Price'
            }],
            data: [{
                id: 1,
                name: '喜人',
                price: '$1'
            }, {
                id: 2,
                name: '中华人民共和国',
                price: '$2'
            }, {
                id: 2,
                name: 'Item 2',
                price: '$2'
            }, {
                id: 2,
                name: 'Item 2',
                price: '$2'
            }, {
                id: 2,
                name: 'Item 2',
                price: '$2'
            }, {
                id: 2,
                name: 'Item 2',
                price: '$2'
            }, {
                id: 2,
                name: 'Item 2',
                price: '$2'
            }, {
                id: 2,
                name: 'Item 2',
                price: '$2'
            }, {
                id: 2,
                name: 'Item 2',
                price: '$2'
            }, {
                id: 2,
                name: 'Item 2',
                price: '$2'
            }, {
                id: 2,
                name: 'Item 2',
                price: '$2'
            }]
        });
    });
</script>
</body>
<@footer/>
</html>
