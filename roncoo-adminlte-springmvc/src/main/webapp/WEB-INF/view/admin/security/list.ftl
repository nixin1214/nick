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
							<h3 class="box-title">用户管理</h3>
							<div class="box-tools pull-right">
								<@shiro.hasPermission name="user:add">
									<a onclick="securityToListAjax();" class="btn btn-sm btn-primary" target="modal" modal="lg" href="${ctx}/admin/security/add">添加</a>
								</@shiro.hasPermission>
							</div>
						</div>
						<div class="box-body">
							<div class="clearfix">
								<div class="col-md-4">
									<div class="input-group date ">
										<div class="input-group-addon">
											<i class="fa fa-calendar"></i>
										</div>
										<input type="text" class="form-control pull-right" id="securityTime" placeholder="根据创建时间搜索...">
									</div>
								</div>
								<div class="col-md-4">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-search"></i></span>
										<input type="text" class="form-control" id="securityPremise" placeholder="根据账号搜索...">
									</div>
								</div>
								<div class="col-md-4">
									<button type="submit" onclick="securityReload();" class="btn btn-primary">搜索</button>
                                    <button type="submit" onclick="security();" class="btn btn-primary">刷新</button>
								</div>
							</div><br/>
							<table id="security_tab" class="table table-bordered table-striped">
								<thead>
									<tr>
										<tr>
											<th>序号</th>
											<th>账号</th>
											<th>昵称</th>
											<th>角色</th>
											<th>状态</th>
											<th>创建时间</th>
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
var security_tab;
$(function() {
	//初始化时间选择器
	$('#securityTime').datepicker({
		language: 'zh-CN',
		format: 'yyyy-mm-dd',
		autoclose: true,
		todayHighlight: true,
        startView: 1,
        maxViewMode: 1,
        minViewMode:1
	});
	//初始化表格
	
	var No=0;
	security_tab=$('#security_tab').DataTable({
		"dom":'itflp',
		"processing":true,
		"searching":false,
		"serverSide":true, //启用服务器端分页
		"bInfo":false,
		"language":{"url":"plugins/datatables/language.json"},
		"ajax" : {"url":"${ctx}/admin/security/page","type":"post"},
		"columns":[ 
		    {"data":null}, 
			{"data":"userNo"},
			{"data":"nickName"},
			{"data":null},
			{"data":null},
			{"data":"createTime"},
			{"data":null} 
			],
		"columnDefs":[
			{
			    targets: 0,
			    data: null,
			    render: function (data) {
			    	No=No+1;
			        return No;
			    }
			},
			{
			    targets: 3,
			    data: null,
			    render: function (data) {
			    	var  listStr = "";
			    	var list = data.roleList;
			    	for(var i=0;i<list.length;i++){
			    		listStr = listStr+(i+1)+"."+list[i].roleName;
			    	}
			    	return listStr;
			    }
			},
			{
			    targets: 4,
			    data: null,
			    render: function (data) {
			    	if(data.statusId == "0"){
			    		return "不可用";
			    	}
			    	if(data.statusId == "1"){
			    		return "可用";
			    	}
			    	return "未知状态";
			    }
			},
            {
				"targets" : -1,
				"data" : null,
				"render" : function(data) {
					var btn = "";
							if(data.userNo != 'super'){
								btn = '<a class="btn btn-xs btn-primary" target="modal" modal="lg" href="${ctx}/admin/security/view?id='+ data.id+ '">查看</a> &nbsp;'
								+'<@shiro.hasPermission name="user:update">'
								+'<a class="btn btn-xs btn-info" onclick="securityToListAjax();" target="modal" modal="lg" href="${ctx}/admin/security/edit?id='+ data.id+ '">修改</a> &nbsp;'
								+'</@shiro.hasPermission>'
								+'<@shiro.hasPermission name="user:delete">'
								+'<a class="btn btn-xs btn-default" callback="securityReload();" data-body="确认要删除吗？" target="ajaxTodo" href="${ctx}/admin/security/delete?id='+ data.id + '">删除</a>'
								+'</@shiro.hasPermission>';
							}
					return btn;
			}
		} ]
	}).on('preXhr.dt', function ( e, settings, data ) {
		No=0;
    } );
	
	$("#securitySeek").on("click",function(){
 		reloadTable(security_tab,"#securityTime","#securityPremise");
	});
});
function security(){
    var a =  document.getElementById("securityTime");
	var b = document.getElementById("securityPremise");
		a.value = "";
		b.value = "";
    reloadTable(security_tab,a,b);
}
function securityReload(){
	reloadTable(security_tab,"#securityTime","#securityPremise");
}

function securityDelete(id) {
	window.location.href='${ctx}/admin/security/delete?id=' + id;
}

function securityToListAjax(){
	list_ajax = security_tab;
	console.log(list_ajax);
}
</script>
</body>
<@footer/>
</html>