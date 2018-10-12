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
					   <h3 class="box-title">数据字典明细功能</h3>
					   <div class="box-tools pull-right">
							<a onclick="dictionaryToListAjax();" class="btn btn-sm btn-primary"  target="modal" modal="lg" href="${ctx}/admin/dataDictionary/add">添加</a>
						</div>
					 </div>
					 <div class="box-body">
						<div class="clearfix">
							<div class="col-md-4">
							<div class="input-group date ">
									<div class="input-group-addon">
									  <i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control pull-right" id="dictionary-time" placeholder="根据创建时间搜索...">
								  </div>
							</div>
							<div class="col-md-4">
								<div class="input-group">
								   <span class="input-group-addon"><i class="fa fa-search"></i></span>
								   <input type="text" class="form-control" id="dictionary-premise" placeholder="根据字段名搜索...">
							   </div>
							</div>
							<div class="col-md-4">
								<button type="button" onclick="dictionaryReload();" class="btn btn-primary">搜索</button>
                                <button type="submit" onclick="security();" class="btn btn-primary">刷新</button>
							</div>
						</div><br/>
						<table id="dictionary_tab" class="table table-bordered table-striped" >
						   <thead>
							   <tr>
								<th>序号</th>
								<th>字段名</th>
								<th>排序</th>
								<th>备注</th>
								<th>创建时间</th>
								<th>操作</th>
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
  var dictionary_tab;
  $(function () {
    //Date picker
    $('#dictionary-time').datepicker({
      	language: 'zh-CN',
		format: 'yyyy-mm-dd',
		autoclose: true,
		todayHighlight: true
    });
	//初始化表格

	 var No=0;
     dictionary_tab =$('#dictionary_tab').DataTable( {
        "dom":'itflp',
        "processing":true,
		"searching":false,
        "serverSide":true,   //启用服务器端分页
		"bInfo":false,  
        "language":{"url": "plugins/datatables/language.json"},
        "ajax": {"url":"${ctx}/admin/dataDictionary/page","type":"post"},
        "columns": [
            { "data": null},
            { "data": "fieldName" },
            { "data": "sort" },
            { "data": "remark" },
            { "data": "createTime"},
            { "data": null }
        ],
        "columnDefs": [
			{
			    targets: 0,
			    data: null,
			    render: function (data) {
			    	No=No+1;
			        return No;
			    }
			},
               {
	            "targets": 5,
	            "data": null,
	            "render": function(data){
					var btn = '<a class="btn btn-xs btn-primary" target="modal" modal="lg" href="${ctx}/admin/dataDictionary/view?id='+data.id+'">查看</a> &nbsp;'
					+'<a class="btn btn-xs btn-info" onclick="dictionaryToListAjax();" target="modal" modal="lg"  href="${ctx}/admin/dataDictionary/edit?id='+data.id+'">修改</a>&nbsp;'
					+'<a class="btn btn-xs btn-primary" target="navTab" href="${ctx}/admin/dataDictionaryList/list?id='+data.id+'&fieldCode='+data.fieldCode+'">明细</a>&nbsp;'
					+'<a class="btn btn-xs btn-default" callback="dictionaryReload();" data-body="确认要删除吗？" target="ajaxTodo" href="${ctx}/admin/dataDictionary/delete?id='+ data.id + '&fieldCode='+data.fieldCode+'">删除</a>';
					return btn;
			}
        } ]
    } ).on('preXhr.dt', function ( e, settings, data ) {
		No=0;
    } );
  });
  function security(){
      var a =  document.getElementById("dictionary-time");
      var b = document.getElementById("dictionary-premise");
      a.value = "";
      b.value = "";
      reloadTable(dictionary_tab,a,b);
  }
  function dictionaryReload(){
  	reloadTable(dictionary_tab,"#dictionary-time","#dictionary-premise");
  }
  
  function dictionaryToListAjax(){
  	list_ajax = dictionary_tab;
  }
</script>
</body>
<@footer/>
</html>