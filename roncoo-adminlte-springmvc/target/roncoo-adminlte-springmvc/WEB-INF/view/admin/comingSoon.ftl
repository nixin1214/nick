<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>${modularName}</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
        <div class="content-wrapper" style="background-image: url('dist/img/jqqd.jpg'); background-size: cover;">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                ${companyName}
                    <small>${modularName}</small>
                </h1>
            </section>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                    </div>
                </div>
            </section>
        </div>
</div>
</body>
<@footer/>
</html>