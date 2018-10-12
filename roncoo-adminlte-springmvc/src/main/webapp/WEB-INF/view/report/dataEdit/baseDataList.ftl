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
                            <div class="clearfix">
                                <#--<div class="col-md-3">
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
										<#list companys as company>
                                            <option value="${company.fnumber}">${company.fname}</option>
										</#list>
                                        </select>
                                    </div>
                                </div>-->
                                <div class="col-md-7">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-search"></i></span>
                                        <input type="text" class="form-control" id="quotaName" placeholder="根据指标名称搜索...">
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <button type="button" onclick="roleReload();" class="btn btn-primary">搜索</button>
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-info"><i class="glyphicon glyphicon-import icon-share"></i>导入</button>
                                    <button type="button" class="btn btn-info" onclick="window.location.href='${ctx}/report/dataEdit/downloadTempFile?tempType=OTHER_TEMP'"><i class="glyphicon glyphicon-export icon-share"></i>模板下载</button>
                                </div>
                            </div><br/>
                            <table id="quota_tab" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                <tr>
                                    <th>序号</th>
                                    <th>期间</th>
                                    <th>组织</th>
                                    <th>对标企业</th>
                                    <th>指标编码</th>
                                    <th>指标名称</th>
                                    <th>值</th>
                                    <th>创建人</th>
                                    <th>导入日期</th>
                                </tr>
                                </tr>
                                </thead>
                            </table>
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
            "ajax":{"url":"${ctx}/report/dataEdit/page2","type":"post"},
            "columns":[
                {"data":null},
                {"data":"fyearmonth"},
                {"data":"company.fname"},
                {"data":"fenterprise"},
                {"data":"fquotaName"},
                {"data":"fremark"},
                {"data":"fquotaValue"},
                {"data":"fcreatorName"},
                {"data":"fcreatime"}
            ],
            "columnDefs" : [
                {
                    targets: 0,
                    data: null,
                    render: function (data) {
                        No=No+1;
                        return No;
                    }
                }]
        }).on('preXhr.dt', function ( e, settings, data ) {
            No=0;
        } );


        $("#uploadBtn").on("click", function () {
            var financeForm = new FormData();
            financeForm.append("financeFile", document.getElementById("financeFile").files[0]);
            financeForm.append("idcNum", document.getElementById("idcNum").value);
            var url = baseUrl + "/report/dataEdit/importBaseData";

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
                    if (data.stateCode === 0) {
                        layer.msg('导入成功！');
                    } else {
                        layer.msg(data.error);
                    }
                    $("#financeFile").val(null);
                    $("#filename").text("请选择文件");
                    roleReload();
                    $("#close-modal").click();
                }
            }).done(function(res) {
                console.log(res);
            }).fail(function(res) {
                console.log(res);
            });

        });
    });

    function roleReload(){
        //reloadTable(role_tab,"#yearMonth","#quotaName");

        var search = $("#quotaName").val();
        var param = {
            "quotaName" : search
        };
        role_tab.settings()[0].ajax.data = param;
        role_tab.ajax.reload();
    }

    function roleToListAjax(){
        list_ajax = role_tab;
    }
</script>
</body>
<@footer/>
</html>