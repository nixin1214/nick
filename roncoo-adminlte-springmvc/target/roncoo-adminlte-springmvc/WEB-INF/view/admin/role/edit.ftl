<div class="row">
	<div class="col-md-12">
		<form id="roleEditForm">
			<input type="hidden" id="id" name="id" value=${bean.id}>
			<div class="box-body">
				<div class="form-group">
					<label id="roleNameLabel">角色名</label>
					<input type="text" class="form-control" name="roleName" id="roleName" value=${bean.roleName} placeholder="角色名...">
				</div>
				<div class="form-group">
					<label id="roleValueLabel">角色值</label>
					<input type="text" class="form-control" name="roleValue" id="roleValue" value=${bean.roleValue} placeholder="角色值...">
				</div>
                <div class="form-group">
                    <label id="roleValueLabel">资源权限</label>
                    <input type="text" name="resources" id="resources" placeholder="资源...">
                </div>
				<#--<div class="form-group">-->
					<#--<label>权限：</label>-->
					<#--<label>-->
						<#--<input type="checkbox" id="allCheckbox" class="flat-red" onClick="onClickCheckbox('allCheckbox','permission')">全选-->
					<#--</label>-->
					<#--<br/>-->
					<#--<#list permissions as permission>-->
						<#--<#if bean.permissionList??>-->
							<#--<label>-->
			                  <#--<input type="checkbox" name="permission" class="flat-red" value="${permission.id}"<#list bean.permissionList as beanPermission> <#if beanPermission.permissionsValue == permission.permissionsValue>checked</#if></#list>> ${permission.permissionsName}-->
			                <#--</label>-->
						<#--<#else>-->
							<#--<label>-->
			                  <#--<input type="checkbox" name="permission" class="flat-red" value="${permission.id}"> ${permission.permissionName}-->
			                <#--</label>-->
						<#--</#if>-->
					<#--</#list>-->
				<#--</div>-->
             </div>
			<div class="box-footer">
				<div class="pull-right">
					<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
               		<button onclick="roleUpdate();" type="button" class="btn btn-primary btn-sm"><i class="fa fa-paste"></i>更新</button>
				</div>
          	</div>
		</form>
	</div>
</div>

<!-- easy ui -->
<link type="text/css" rel="stylesheet" href="plugins/easyui/themes/material/easyui.css">
<link type="text/css" rel="stylesheet" href="plugins/easyui/themes/icon.css">
<script type="text/javascript" src="plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="plugins/easyui/easyloader.js"></script>
<script type="text/javascript">
	function roleUpdate(){
		$("span").remove(".errorClass");
		$("br").remove(".errorClass");
		var status = 1;
		if($("#roleName").val()==""){
			$("#roleNameLabel").prepend('<span class="errorClass" style="color:red">*角色名不能为空</span><br class="errorClass"/>');
			status = 0;
		}
		if($("#roleValue").val()==""){
			$("#roleValueLabel").prepend('<span class="errorClass" style="color:red">*角色值不能为空</span><br class="errorClass"/>');
			status = 0;
		}
        var resourceNodes = $("#resources").combotreegrid('grid').treegrid('getCheckedNodes');
        if(resourceNodes.length === 0){
            $("#resourceLabel").prepend('<span class="errorClass" style="color:red">*权限资源不能为空</span><br class="errorClass"/>');
            status = 0;
        }
		if(status == 0){
			return false;
		}else{
			ajaxPost();
		}
	}
		
	function ajaxPost() {
		var options = {
	        url: '${ctx}/admin/role/update',
	        type: 'post',
	        dataType: 'text',
	        data: $("#roleEditForm").serialize(),
	        success: function (data) {
                $("#resources").combotreegrid('destroy');
	        	$("#lgModal").modal('hide');
	        	alertMsg("更新成功","success");
	        	reloadTable(list_ajax,"#roleTime","#rolePremise");
	        }
		};
		$.ajax(options);
	}

	getResources();
    /**
	 * 获取资源列表
     */
	function getResources() {
		$("#resources").combotreegrid({
			url: '${ctx}/admin/role/getResources',
			idField: 'id',
			treeField: 'name',
			multiple: true,
            collapsible: true,
            rownumbers: true,
            animate: true,
			panelWidth: 500,
			value: '${resources}',
			columns:[[
				{field:'name',title:'资源名称',width:200},
				{field:'resType',title:'类型',width:100},
				{field:'permistionValue',title:'权限值',width:100}
			]],
            onLoadSuccess: function() {
                $("#resources").combotreegrid("resize", '100%');
			}
		});
	}
</script>