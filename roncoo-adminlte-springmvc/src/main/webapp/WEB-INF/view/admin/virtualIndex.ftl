<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>虚拟组织首页</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
            ${companyName}
                <small>综合指标</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${companyName}</li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="callout callout-info">
                        <h4><i class="icon fa fa-warning"></i> ${companyName}用户！</h4>
                        <i class="fa fa-cog fa-spin"></i>欢迎登陆！
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<@jsFile/>
</body>
</html>