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
							<h3 class="box-title">操作日志</h3>
						</div>
						<div class="box-body">
							<div class="clearfix">
								<div class="col-md-3">
									<div class="input-group date ">
										<div class="input-group-addon">
											<i class="fa fa-calendar"></i>
										</div>
										<input type="text" class="form-control pull-right" id="startDate" placeholder="开始日期...">
									</div>
								</div>
								<div class="col-md-3">
                                    <div class="input-group date ">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right" id="endDate" placeholder="结束日期...">
                                    </div>
								</div>
								<div class="col-md-2">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-search"></i></span>
										<input type="text" class="form-control" id="userName" placeholder="根据账号搜索...">
									</div>
                                </div>
                                <div class="col-md-2">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-search"></i></span>
										<select id="orgName" class="form-control">
											<option value="">全部</option>
										<#list companys as company>
                                            <option value="${company.fnumber}">${company.fname}</option>
										</#list>
										</select>
                                    </div>
								</div>
								<div class="col-md-2">
									<button type="button" onclick="roleReload();" class="btn btn-primary">搜索</button>
                                    <button type="button" onclick="allReload();" class="btn btn-primary">刷新</button>
								</div>
							</div><br/>
							<table id="operation_tab" class="table table-bordered table-striped">
								<thead>
									<tr>
										<tr>
											<th>序号</th>
											<th>姓名</th>
											<th>账号</th>
											<th>所属组织</th>
											<th>操作类型</th>
											<th>IP地址</th>
											<th>操作时间</th>
											<th>结果</th>
											<th>操作</th>
										</tr>
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
</div>
<@jsFile/>
<script type="text/javascript">
var role_tab;
$(function() {
	//初始化时间选择器
	$('#startDate').datepicker({
		language: 'zh-CN',
		format: 'yyyy-mm-dd',
		autoclose: true,
		todayHighlight: true
	});
	$('#endDate').datepicker({
		language: 'zh-CN',
		format: 'yyyy-mm-dd',
		autoclose: true,
		todayHighlight: true
	});
	//初始化表格
	
	var No=0;
	role_tab = $('#operation_tab').DataTable({
		"dom":'itflp',
		"processing":true,
		"searching":false,
		"serverSide":true, //启用服务器端分页
		"bInfo":false,
		"language":{"url":"plugins/datatables/language.json"},
		"ajax":{"url":"${ctx}/admin/operationLog/page","type":"post"},
		"columns":[ 
		    {"data":null}, 
			{"data":"fuserName"},
			{"data":"fuserAccount"},
			{"data": "company.fname"},
			{"data":"foperationType"},
			{"data":"fipAddress"},
			{"data":"fcreatime"},
			{"data":null},
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
                targets: 7,
                data: null,
                render: function (data) {
                    if(data.ferrorCode == "0"){
                        return "成功";
                    }
                    if(data.ferrorCode == "success"){
                        return "成功";
                    }
                    return "失败";
                }
            },
            {
				"targets" : -1,
				"data" : null,
				"render" : function(data) {
					var btn = '<a class="btn btn-xs btn-primary" target="modal" modal="lg" href="${ctx}/admin/operationLog/view?id='+ data.fid+ '">查看</a> &nbsp;';
					return btn;
				}
		}]
	}).on('preXhr.dt', function ( e, settings, data ) {
	console.log(data,settings)
		No=0;
    } );
});

function roleReload(){
	//reloadTable(role_tab,"#roleTime","#rolePremise");
    var param = {
        "startDate" : $("#startDate").val(),
        "endDate" : $("#endDate").val(),
        "orgName" : $("#orgName").val(),
        "userName" : $("#userName").val()
    };
    role_tab.settings()[0].ajax.data = param;
    role_tab.ajax.reload();
}
function allReload(){
    var a =  document.getElementById("startDate");
    var b = document.getElementById("endDate");
    var c =  document.getElementById("orgName");
    var d = document.getElementById("userName");
    a.value = "";
    b.value = "";
    c.value = "";
    d.value = "";
    role_tab.settings()[0].ajax.data = "";
    role_tab.ajax.reload();
}

function roleToListAjax(){
	list_ajax = role_tab;
}
</script>
</body>
<@footer/>
</html>