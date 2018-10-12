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
								<div class="col-md-3">
									<div class="input-group date ">
										<div class="input-group-addon">
											<i class="fa fa-calendar"></i>
										</div>
										<input type="text" class="form-control pull-right" id="yearMonthSelect" placeholder="选择期间...">
									</div>
								</div>
								<div class="col-md-3">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-search"></i></span>
                                        <select id="orgCode" style="width: 100%; padding: 6px 12px; height: 34px; vertical-align: bottom; margin-right: 10px;" class="form-control">
											<option value="">选择组织</option>
										<#list companys as company>
                                            <option value="${company.fnumber}">${company.fname}</option>
										</#list>
                                        </select>
									</div>
								</div>
								<div class="col-md-3">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-search"></i></span>
										<input type="text" class="form-control" id="quotaName" placeholder="根据指标名称搜索...">
									</div>
								</div>
								<div class="col-md-3">
									<button type="button" style="margin-bottom: 5px;" onclick="roleReload();" class="btn btn-primary">搜索</button>
                                    <button type="submit" style="margin-bottom: 5px;" onclick="security();" class="btn btn-primary">刷新</button>
                                    <button id="insert" type="button" onclick="queryCompany()" data-toggle="modal" data-target="#myModal" style="margin-bottom: 5px;"  class="btn btn-primary">新增</button>
                                    <br>
									<#-- 取消导入和模板下载
									<button type="button" style="margin-bottom: 5px;" class="btn btn-primary" data-toggle="modal" data-target="#modal-info"><i class="glyphicon glyphicon-import icon-share"></i>导入</button>
                                    <button type="button" style="margin-bottom: 5px;" class="btn btn-info" onclick="window.location.href='${ctx}/report/dataEdit/downloadTempFile?tempType=MILK_INDEX_TEMP'"><i class="glyphicon glyphicon-export icon-share"></i>模板下载</button>-->
								</div>


                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header ">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                    &times;
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel">
                                                    指标维护
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                <form class="form-horizontal" role="form" action="">
                                                    <div class="form-group">
                                                        <label for="firstname" class="col-sm-2 control-label">选择组织:</label>
                                                        <div class="col-sm-8">
                                                            <select id="companyVal" class="form-control"></select>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label for="firstname" class="col-sm-2 control-label">选择指标:</label>
                                                        <div class="col-sm-8">
                                                            <select id="indexData" class="form-control">

                                                            </select>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label for="firstname" class="col-sm-2 control-label">选择分类:</label>
                                                        <div class="col-sm-8">
                                                            <select id="listOption" class="form-control">
                                                            </select>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label for="firstname" class="col-sm-2 control-label">选择时间:</label>
                                                        <div id="data-picker" class="col-sm-8">
                                                            <input type="text" class="form-control" id="fyearMonth">
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label for="firstname" class="col-sm-2 control-label">输入值:</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" id="fvalue">
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-12 modal-footer">
                                                            <div class="col-sm-5"></div>
                                                            <button type="button" id="pwd_btn" class="btn btn-primary col-sm-2" onclick="submitSave()">保存</button>
                                                        </div>
                                                    </div>

                                                </form>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
                                </div>



							</div>
							<table id="quota_tab" class="table table-bordered table-striped">
								<thead>
									<tr>
										<tr>
											<th>序号</th>
											<th>期间</th>
											<th>组织</th>
											<th>名称</th>
											<th>值</th>
											<th>细分类</th>
											<th>更新日期</th>
											<th>操作</th>
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
                                            <h4 class="modal-title">理化指标上传</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="alert alert-danger alert-dismissable" id="errorMsg" style="display: none">
                                                <button type="button" class="close" data-dismiss="alert"
                                                        aria-hidden="true">
                                                    &times;
                                                </button>
                                            </div>
                                            <div class="clearfix">
                                                <label for="jobData" class="control-label" style="float:left;padding-left:15px; padding-right: 5px; line-height: 34px;">理化指标</label>
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
$(function () {
    $('#yearMonthSelect').datepicker({
        language: 'zh-CN',
        format: 'yyyymm',
        autoclose: true,
        todayHighlight: true,
        startView: 1,
        maxViewMode: 1,
        minViewMode:1
    });
});

$(function() {


	//初始化时间选择器
//	$('#yearMonth').datepicker({
//		language: 'zh-CN',
//		format: 'yyyymm',
//		autoclose: true,
//		todayHighlight: true,
//        startView: 1,
//        maxViewMode: 1,
//        minViewMode:1
//	});
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
			{"data":"fyearMonth"},
			{"data":"company.fname"},
			{"data":"fnameZh"},
			{"data":"fvalue"},
			{"data":"fsmallClass"},
			{"data":"fupdatime"},
			{"data":null}
			],
		"columnDefs" : [
			{
			    targets: 0,
			    data: null,
			    render: function (data) {
			    	No=No+1;
			        return No;
			    }
			},
            {
				"targets" : -1,
				"data" : null,
				"render" : function(data) {
					var btn = '<a class="btn btn-xs btn-primary" target="modal" modal="lg" href="${ctx}/report/dataEdit/view?id='+ data.fid+ '">查看</a> &nbsp;';
						btn = btn+'<@shiro.hasPermission name="quota:edit">'
						+'<a class="btn btn-xs btn-info" onclick="roleToListAjax();" target="modal" modal="lg" href="${ctx}/report/dataEdit/edit?id='+ data.fid+'">修改</a> &nbsp;'
						+'</@shiro.hasPermission>';
				return btn;
			}
		} ]
	}).on('preXhr.dt', function ( e, settings, data ) {
	console.log(data,settings)
		No=0;
    } );

    $("#uploadBtn").on("click", function () {
        var financeForm = new FormData();
        if (document.getElementById("financeFile").files[0] == null) {
            layer.msg("请选择文件");
            return;
		}
        financeForm.append("financeFile", document.getElementById("financeFile").files[0]);
        var url = baseUrl + "/report/dataEdit/importMilkIndexData";

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
                    //showCurrentTabData(data);
                } else {
                    layer.msg(data.error);
                }
                $("#financeFile").val(null);
				$("#filename").html("请选择文件");
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

    var date = $("#yearMonthSelect").val();
    var search = $("#quotaName").val();
    var param = {
        "yearMonth" : date,//月份
        "quotaName" : search,//指标名
		"orgCode" : $("#orgCode").val()//组织
    };
    role_tab.settings()[0].ajax.data = param;
    role_tab.ajax.reload();
}

function roleToListAjax(){
	list_ajax = role_tab;
}

function security(){
    $('#yearMonthSelect').val("");
    $('#orgCode').val("");
    $('#quotaName').val("");
    var param = {
        "yearMonth" : null,//月份
        "quotaName" : null,//指标名
        "orgCode" : null//组织
    };
    role_tab.settings()[0].ajax.data = param;
    role_tab.ajax.reload();
}

/*
* 加载组织选项
*/
function queryCompany() {
    var companyName = "";
    $.ajax({
        url: "${ctx}/report/dataEdit/queryCompany",
        type: "post",
        dataType: "text",
        success:function (result) {
            var jsonObj = eval('(' + result + ')');
            $("#companyVal").empty();
            companyName = jsonObj["list"][1].fnumber;
            for(var i=0;i<jsonObj["list"].length;i++){
                if(jsonObj["list"][i].fnumber!="XNZZ"){
                    $("#companyVal").append("<option value="+jsonObj["list"][i].fnumber+">"+jsonObj["list"][i].fname+"</option>");
                }
            }
            loadIndex(companyName);
        },
        error:function(){
            console.log("错误");
        }
    });

}

/*
* 改变选项重新加载
*/
$(function () {
    var companyName ="";
   $("#companyVal").change(function () {
       companyName = $("#companyVal option:selected").val();
       loadIndex(companyName);
   });

    $("#indexData").change(function () {
        var indexData = $("#indexData option:selected").val();
        loadList(companyName,indexData);
        formatDate();
    });
});

/*
* 加载指标类选项
*/
function loadIndex(companyName) {
    var indexData = "";
    $.ajax({
        url:"${ctx}/report/dataEdit/locadIndex?companyName="+companyName,
        type:"get",
        dataType:"text",
        success:function (result) {
            var jsonObj = eval('('+result+')');
            $("#indexData").empty();
            indexData = jsonObj["resultList"][0].fnameEn;
                for (var i = 0; i < jsonObj["resultList"].length; i++) {
                    $("#indexData").append("<option value=" + jsonObj["resultList"][i].fnameEn + " unit=" + jsonObj["resultList"][i].funit + " dimension=" + jsonObj["resultList"][i].fdimension + " yearMonth=" + jsonObj["resultList"][i].fyearMonth + ">" + jsonObj["resultList"][i].fnameZh + "</option>");
                }
            loadList(companyName,indexData);
        },
        error:function () {
            console.log("错误!");
        }
    });
}

/*
* 加载细分类选项
*/
function loadList(companyName,indexData) {
    $.ajax({
        url:"${ctx}/report/dataEdit/locadList?companyName="+companyName+"&indexData="+indexData,
        type:"get",
        dataType:"text",
        success:function (result) {
            var jsonObj = eval('('+result+')');
            $("#listOption").empty();
            if(jsonObj["resultList"].length>0) {
                for (var i = 0; i < jsonObj["resultList"].length; i++) {
                    if (jsonObj["resultList"][i].forgCode != "XNZZ")
                        $("#listOption").append("<option>" + jsonObj["resultList"][i].fsmallClass + "</option>");
                }
            }else {
                $("#listOption").append("<option>无</option>");
            }
            formatDate();
        },
        error:function () {
            console.log("错误!");
        }
    });
}

/**
 * 提交保存数据
 */
function submitSave(){
     var orgCode = $("#companyVal option:selected").val();
     var fnameZh = $("#indexData option:selected").html();
     var fnameEn = $("#indexData option:selected").val();
     var fsmallClass = $("#listOption option:selected").html()=="无"?null:$("#listOption option:selected").html();
     var fyearMonth = $("#fyearMonth").val();
     var fvalue = $("#fvalue").val();
     var funit = $("#indexData option:selected").attr("unit");
    var fdimension = $("#indexData option:selected").attr("dimension");
    console.log(funit);

     var data = {"forgCode":orgCode,"fnameZh":fnameZh,"fnameEn":fnameEn,"fsmallClass":fsmallClass,"fyearMonth":fyearMonth,"fvalue":fvalue,"ftype":"手动维护","fvalueType":"number","funit":funit,"fdimension":fdimension};
    $.ajax({
       url:"${ctx}/report/dataEdit/submitSave",
       type:"post",
        dataType:"text",
        data:data,
        success:function (result) {
            $("#myModal").modal("hide");
            if (result==1){
                layer.msg("添加成功!");
            }else{
                layer.msg("修改成功");
            }
            role_tab.ajax.reload();
        },
        error:function () {
            $("#myModal").modal("hide");
            layer.msg("操作失败");;
        }
    });
}

function formatDate() {
    var fyearMonth = $("#indexData option:selected").attr("yearMonth");
    if(fyearMonth.length<7) {
        $("#fyearMonth").remove();
        $("#data-picker").append('<input type="text" class="form-control" id="fyearMonth">');
        $('#fyearMonth').datepicker({
            language: 'zh-CN',
            format: 'yyyymm',
            autoclose: true,
            todayHighlight: true,
            startView: 1,
            maxViewMode: 1,
            minViewMode: 1
        });
    }else {
        $("#fyearMonth").remove();
        $("#data-picker").append('<input type="text" class="form-control" id="fyearMonth">');
        $('#fyearMonth').datepicker({
            language: 'zh-CN',
            format: 'yyyymmdd',
            autoclose: true,
            todayHighlight: true,
        });
    }
};
</script>
</body>
<@footer/>
</html>