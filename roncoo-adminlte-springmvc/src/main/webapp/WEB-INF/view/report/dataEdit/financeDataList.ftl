<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>财务报表上传界面</title>
<@style/>
    <style type="text/css">
        .nav > li > a {
            padding: 5px 10px;
        }
    </style>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                中垦乳业
                <small>指标编辑</small>
            </h1>
            <#--<ol class="breadcrumb">-->
                <#--<li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i>中垦</a></li>-->
                <#--<li class="active">数据维护</li>-->
            <#--</ol>-->
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <ul id="myTab" class="nav nav-tabs">
                            <li class="active"><a href="#zk_zyzb1" data-toggle="tab" aria-expanded="true" data="1">主要指标1</a></li>
                            <li class=""><a href="#zk_zyzb2" data-toggle="tab" aria-expanded="true" data="2">主要指标2</a></li>
                            <li class=""><a href="#zk_zyzb3" data-toggle="tab" aria-expanded="true" data="3">主要指标3</a></li>
                            <li class=""><a href="#zk_zyzb4" data-toggle="tab" aria-expanded="true" data="4">主要指标4</a></li>
                            <li class=""><a href="#zk_zyzb5" data-toggle="tab" aria-expanded="true" data="5">主要指标5</a></li>
                            <li class=""><a href="#zk_zcfzb" data-toggle="tab" aria-expanded="true" data="6">资产负债表</a></li>
                            <li class=""><a href="#zk_lrb" data-toggle="tab" aria-expanded="true" data="7">利润表</a></li>
                            <li class=""><a href="#zk_xjllb" data-toggle="tab" aria-expanded="true" data="8">现金流量表</a></li>
                            <li class=""><a href="#zk_xsfy" data-toggle="tab" aria-expanded="true" data="17">销售费用</a></li>
                            <li class=""><a href="#zk_glfy" data-toggle="tab" aria-expanded="true" data="18">管理费用</a></li>
                            <li class=""><a href="#zk_zzfy" data-toggle="tab" aria-expanded="true" data="19">制造费用</a></li>
                            <li class=""><a href="#zk_cwfy" data-toggle="tab" aria-expanded="true" data="20">财务费用</a></li>
                            <li class=""><a href="#zk_sftjb" data-toggle="tab" aria-expanded="true" data="21">税费统计表</a></li>
                            <li class=""><a href="#zk_ygxc" data-toggle="tab" aria-expanded="true" data="22">员工薪酬</a></li>
                            <li class=""><a href="#zk_gdzczjb" data-toggle="tab" aria-expanded="true" data="24">固定资产增减表</a></li>
                            <li class=""><a href="#zk_chzjb" data-toggle="tab" aria-expanded="true" data="25">存货增减表</a></li>
                            <li class=""><a href="#zk_cpzjb" data-toggle="tab" aria-expanded="true" data="26">产品增减表</a></li>
                            <li class=""><a href="#zk_zyszz_by" data-toggle="tab" aria-expanded="true" data="9">主营收支总(本月)</a></li>
                            <li class=""><a href="#zk_zyszz_lj" data-toggle="tab" aria-expanded="true" data="10">主营收支总(累计)</a></li>
                            <li class=""><a href="#zk_zyszmxty_by" data-toggle="tab" aria-expanded="true" data="11">主营收支明细(本月天友乳业)</a></li>
                            <li class=""><a href="#zk_zyszmx_by" data-toggle="tab" aria-expanded="true" data="37">主营收支明细(本月华山牧乳业)</a></li>
                            <li class=""><a href="#zk_zyszmxmc_by" data-toggle="tab" aria-expanded="true" data="38">主营收支明细牧场(本月含运费)</a></li>
                            <li class=""><a href="#zk_zyszmxmcb_by" data-toggle="tab" aria-expanded="true" data="39">主营收支明细牧场(本月不含运费)</a></li>
                            <li class=""><a href="#zk_zyszmxgyl_by" data-toggle="tab" aria-expanded="true" data="40">主营收支明细(本月供应链)</a></li>
                            <li class=""><a href="#zk_zyszmxtyl_by" data-toggle="tab" aria-expanded="true" data="12">主营收支明细(累计天友乳业)</a></li>
                            <li class=""><a href="#zk_zyszmxhsl_by" data-toggle="tab" aria-expanded="true" data="41">主营收支明细(累计华山牧乳业)</a></li>
                            <li class=""><a href="#zk_zyszmxmcl_by" data-toggle="tab" aria-expanded="true" data="42">主营收支明细(累计牧场含运费)</a></li>
                            <li class=""><a href="#zk_zyszmxmclb_by" data-toggle="tab" aria-expanded="true" data="43">主营收支明细(累计牧场不含运费)</a></li>
                            <li class=""><a href="#zk_zyszmxgyll_by" data-toggle="tab" aria-expanded="true" data="44">主营收支明细(累计供应链)</a></li>
                            <li class=""><a href="#zk_rzpcpmxty_by" data-toggle="tab" aria-expanded="true" data="15">乳制品产品明细(本月天友乳业)</a></li>
                            <li class=""><a href="#zk_rzpcpmxhsm_by" data-toggle="tab" aria-expanded="true" data="45">乳制品成本明细(本月华山牧乳业)</a></li>
                            <li class=""><a href="#zk_rzpcpmxmc_by" data-toggle="tab" aria-expanded="true" data="46">乳制品成本明细(本月牧场)</a></li>
                            <li class=""><a href="#zk_rzpcpmxtyl_by" data-toggle="tab" aria-expanded="true" data="16">乳制品成本明细(累计天友乳业)</a></li>
                            <li class=""><a href="#zk_rzpcpmxhsml_by" data-toggle="tab" aria-expanded="true" data="47">乳制品成本明细(累计华山牧乳业)</a></li>
                            <li class=""><a href="#zk_rzpcpmxmcl_by" data-toggle="tab" aria-expanded="true" data="48">乳制品成本明细(累计牧场)</a></li>


                            <li class=""><a href="#zk_cpcbhzb_by" data-toggle="tab" aria-expanded="true" data="13">产品成本汇总表(本月)</a></li>
                            <li class=""><a href="#zk_cpcbhzb_lj" data-toggle="tab" aria-expanded="true" data="14">产品成本汇总表(累计)</a></li>


                            <li class=""><a href="#zk_gdzctzqkb" data-toggle="tab" aria-expanded="true" data="23">固定资产投资情况表</a></li>

                        </ul>

                        <div class="tab-content">
                            <div id="toolbar" class="toolbar">
                                <lable style="font-weight: bold">公司：</lable>
                                <select id="company" style="padding: 6px 12px; height: 34px; vertical-align: bottom; margin-right: 10px;">
                                <#list companys as company>
                                    <#if company.fnumber == companyNumber>
                                        <option value="${company.fnumber}" selected>${company.fname}</option>
                                    <#else >
                                        <option value="${company.fnumber}">${company.fname}</option>
                                    </#if>
                                </#list>
                                </select>
                                <lable style="font-weight: bold">期间：</lable>
                                <input id="dataSelection" style="padding: 6px 12px; height: 34px; width: 80px; vertical-align: bottom; margin-right: 10px;">
                                <a class="btn btn-info" id="btnSerch1"><i class="fa fa-search"></i> 查询</a>
                                <button type="button" class="btn btn-info" onclick="window.location.href='${ctx}/report/dataEdit/downloadTempFile?tempType=FINANCE_REPORT_TEMP'"><i class="glyphicon glyphicon-export icon-share"></i>模板下载</button>
                                <@shiro.hasPermission name="finance_report:import">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-info"><i class="glyphicon glyphicon-import icon-share"></i>导入</button>
                                </@shiro.hasPermission>
                                <@shiro.hasPermission name="finance_report:export">
                                    <button type="button" class="btn btn-info" onclick="downloadConsolidationSheet();"><i class="glyphicon glyphicon-export icon-share"></i>合并导出</button>
                                </@shiro.hasPermission>
                            </div>

                            <div class="tab-pane active" id="zk_zyzb1">
                                <table id="zk_zyzb_tb1" class="table table-striped table-bordered table-hover" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyzb2">
                                <table id="zk_zyzb_tb2" class="table table-striped table-bordered table-hover  text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyzb3">
                                <table id="zk_zyzb_tb3" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyzb4">
                                <table id="zk_zyzb_tb4" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyzb5">
                                <table id="zk_zyzb_tb5" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zcfzb">
                                <table id="zk_zcfzb_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_lrb">
                                <table id="zk_lrb_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_xjllb">
                                <table id="zk_xjllb_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyszz_by">
                                <table id="zk_zyszz_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyszz_lj">
                                <table id="zk_zyszz_lj_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyszmxty_by">
                                <table id="zk_zyszmxty_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyszmx_by">
                                <table id="zk_zyszmx_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyszmxmc_by">
                                <table id="zk_zyszmxmc_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyszmxmcb_by">
                                <table id="zk_zyszmxmcb_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyszmxgyl_by">
                                <table id="zk_zyszmxgyl_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyszmxtyl_by">
                                <table id="zk_zyszmxtyl_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyszmxhsl_by">
                                <table id="zk_zyszmxhsl_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyszmxmcl_by">
                                <table id="zk_zyszmxmcl_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyszmxmclb_by">
                                <table id="zk_zyszmxmclb_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zyszmxgyll_by">
                                <table id="zk_zyszmxgyll_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_rzpcpmxty_by">
                                <table id="zk_rzpcpmxty_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_rzpcpmxhsm_by">
                                <table id="zk_rzpcpmxhsm_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_rzpcpmxmc_by">
                                <table id="zk_rzpcpmxmc_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_rzpcpmxtyl_by">
                                <table id="zk_rzpcpmxtyl_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_rzpcpmxhsml_by">
                                <table id="zk_rzpcpmxhsml_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_rzpcpmxmcl_by">
                                <table id="zk_rzpcpmxmcl_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <#--<div class="tab-pane table-responsive" id="zk_zyszmx_lj">-->
                                <#--<table id="zk_zyszmx_lj_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>-->
                            <#--</div>-->
                            <div class="tab-pane table-responsive" id="zk_cpcbhzb_by">
                                <table id="zk_cpcbhzb_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_cpcbhzb_lj">
                                <table id="zk_cpcbhzb_lj_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <#--<div class="tab-pane table-responsive" id="zk_rzpcpmx_by">-->
                                <#--<table id="zk_rzpcpmx_by_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>-->
                            <#--</div>-->
                            <#--<div class="tab-pane table-responsive" id="zk_rzpcpmx_lj">-->
                                <#--<table id="zk_rzpcpmx_lj_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>-->
                            <#--</div>-->
                            <div class="tab-pane table-responsive" id="zk_xsfy">
                                <table id="zk_xsfy_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_glfy">
                                <table id="zk_glfy_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_zzfy">
                                <table id="zk_zzfy_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_cwfy">
                                <table id="zk_cwfy_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_sftjb">
                                <table id="zk_sftjb_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_ygxc">
                                <table id="zk_ygxc_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_gdzctzqkb">
                                <table id="zk_gdzctzqkb_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_gdzczjb">
                                <table id="zk_gdzczjb_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_chzjb">
                                <table id="zk_chzjb_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>
                            <div class="tab-pane table-responsive" id="zk_cpzjb">
                                <table id="zk_cpzjb_tb" class="table table-striped table-bordered table-hover text-nowrap" width="100%"></table>
                            </div>

                        <#--导入对话框-->
                            <div class="modal modal-info fade" id="modal-info">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title">财务报表上报</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="alert alert-danger alert-dismissable" id="errorMsg" style="display: none">
                                                <button type="button" class="close" data-dismiss="alert"
                                                        aria-hidden="true">
                                                    &times;
                                                </button>
                                            </div>
                                            <div class="clearfix">
                                                <label for="jobData" class="control-label" style="float:left;padding-left:15px; padding-right: 5px; line-height: 34px;">财务数据</label>
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
</div>
<@jsFile/>
<script type="text/javascript" src="plugins/jQuery/ajaxfileupload.js"></script>
<script type="text/javascript" src="dist/layer/layer.js" ></script>
<script type="text/javascript">
    var yearMonth = '';
    $(function () {
        $('#dataSelection').datepicker({
            language: 'zh-CN',
            format: 'yyyymm',
            autoclose: true,
            todayHighlight: true,
            startView: 1,
            maxViewMode: 1,
            minViewMode:1
        });
        $('#dataSelection').datepicker( 'setDate' , '-1m' );

    });

    $(function () {
        $("li").width("15.3rem");
        /*$("li").css({"text-align":"center","vertical-align":"middle"});*/
    });

    /**
     * 合并导出
     */
    function downloadConsolidationSheet() {
        yearMonth = $('#dataSelection').val();
        if (yearMonth == '') {//未选择日期
            layer.msg("请选择期间");
        }else {//已选择日期
        <#--var downUrl = '${ctx}/report/dataEdit/querySheet?yearMonth=' + yearMonth;-->
        <#--window.location.href = downUrl;-->
            $.ajax({
                url:'${ctx}/report/dataEdit/querySheet?yearMonth=' + yearMonth,
                type:"get",
                dataType:"text",
                success:function (result) {
                    if (result == "noMonth") {
                        layer.msg("当月暂无数据");
                    }else if (result == "haveMonth") {
                        window.location.href = '${ctx}/report/dataEdit/consolidationSheet?yearMonth=' + yearMonth;
                    }
                },
                error:function () {
                    console.log('错误');
                }
            });
        }
    }
</script>
<script type="text/javascript" src="dist/js/report/financeDataList.js?v=1.3"></script>
</body>
<@footer/>
</html>
