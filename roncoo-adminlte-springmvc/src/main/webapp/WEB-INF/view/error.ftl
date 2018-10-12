<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>权限不足</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="callout callout-danger">
                        <h4><i class="icon fa fa-ban"></i> 权限不足！</h4>
                        您无权访问此功能，请联系管理员！
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<@jsFile/>
</body>
</html>