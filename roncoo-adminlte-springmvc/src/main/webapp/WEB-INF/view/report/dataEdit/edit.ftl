<div class="row">
	<div class="col-md-12">
		<form id="roleEditForm">
			<input type="hidden" id="fid" name="fid" value=${bean.fid}>
			<div class="box-body">
				<div class="form-group">
					<label id="fresSysLabel">指标来源</label>
					<input type="text" class="form-control" name="fresSys" id="fresSys" value='${bean.fresSys?if_exists}' placeholder="..." disabled>
				</div>
                <div class="form-group">
                    <label id="fdimessionLabel">生成周期</label>
                    <input type="text" class="form-control" name="fdimession" id="fdimession" value='${bean.fdimession?if_exists}' placeholder="..." disabled>
                </div>
				<div class="form-group">
					<label id="orgNameLabel">所属组织</label>
					<input type="text" class="form-control" name="orgName" id="orgName" value='${bean.company.name?if_exists}' placeholder="..." disabled>
				</div>
				<div class="form-group">
					<label id="fyearMonthLabel">期间</label>
					<input type="text" class="form-control" name="fyearMonth" id="fyearMonth" value='${bean.fyearMonth?if_exists}' placeholder="..." disabled>
				</div>
				<div class="form-group">
					<label id="ftypeLabel">指标类型</label>
					<input type="text" class="form-control" name="ftype" id="ftype" value='${bean.ftype?if_exists}' placeholder="..." disabled>
				</div>
				<div class="form-group">
					<label id="fnameZhLabel">中文名称</label>
					<input type="text" class="form-control" name="fnameZh" id="fnameZh" value='${bean.fnameZh?if_exists}' placeholder="..." disabled>
				</div>
				<div class="form-group">
					<label id="placeholderLabel">英文编码</label>
					<input type="text" class="form-control" name="fnameEn" id="fnameEn" value='${bean.fnameEn?if_exists}' placeholder="..." disabled>
				</div>
				<div class="form-group">
					<label id="fsmallClassLabel">细分类</label>
					<input type="text" class="form-control" name="fsmallClass" id="fsmallClass" value='${bean.fsmallClass?if_exists}' placeholder="..." disabled>
				</div>
				<div class="form-group">
					<label id="fvalueLabel">指标值</label>
					<input type="text" class="form-control" name="fvalue" id="fvalue" value='${bean.fvalue?if_exists}' placeholder="指标值...">
				</div>
				<div class="form-group">
					<label id="fvalueTypeLabel">值类型</label>
					<input type="text" class="form-control" name="fvalueType" id="fvalueType" value='${bean.fvalueType?if_exists}' placeholder="..." disabled>
				</div>
				<div class="form-group">
					<label id="fcreatimeLabel">创建时间</label>
					<input type="text" class="form-control" name="fcreatime" id="fcreatime" value='${bean.fcreatime?string('yyyy-MM-dd HH:mm:ss')}' placeholder="..." disabled>
				</div>
				<div class="form-group">
					<label id="fupdatimeLabel">最后更新时间</label>
					<input type="text" class="form-control" name="fupdatime" id="fupdatime" value='${bean.fupdatime?string('yyyy-MM-dd HH:mm:ss')}' placeholder="..." disabled>
				</div>
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
		if($("#fvalue").val()==""){
			$("#fvalueLabel").prepend('<span class="errorClass" style="color:red">*指标值不能为空</span><br class="errorClass"/>');
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
	        url: '${ctx}/report/dataEdit/update',
	        type: 'post',
	        dataType: 'text',
	        data: $("#roleEditForm").serialize(),
	        success: function (data) {
	        	$("#lgModal").modal('hide');
	        	alertMsg("更新成功","success");
	        	reloadTable(list_ajax,"#roleTime","#rolePremise");
	        }
		};
		$.ajax(options);
	}
</script>