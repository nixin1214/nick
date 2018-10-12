<div class="row">
	<div class="col-md-12">
		<div class="box-body  no-padding">
			<table class="table table-striped">
                <tr>
                	<td>用户姓名：</td>
                	<td style="width: 90%">${bean.fuserName}</td>
                </tr>
                <tr>
                	<td>用户账号：</td>
                	<td>${bean.fuserAccount?if_exists}</td>
                </tr>
                <tr>
                    <td>操作类型：</td>
                    <td>${bean.foperationType?if_exists}</td>
                </tr>
                <tr>
                	<td>组织名称：</td>
                	<td>${bean.company.fname?if_exists}</td>
                </tr>
                <tr>
                	<td>操作时间：</td>
                	<td>${bean.fcreatime?string('yyyy-MM-dd HH:mm:ss')}</td>
                </tr>
                <tr>
                    <td>操作对象：</td>
                    <td>${bean.fresource?if_exists}</td>
                </tr>
                <tr>
                    <td>IP地址：</td>
                    <td>${bean.fipAddress?if_exists}</td>
                </tr>
                <tr>
                    <td>错误码：</td>
                    <td>${bean.ferrorCode?if_exists}</td>
                </tr>
                <tr>
                    <td>错误描述：</td>
                    <td>${bean.ferrorMsg?if_exists}</td>
                </tr>
                <tr>
                    <td>备注：</td>
                    <td>${bean.fremark?if_exists}</td>
                </tr>
         	</table>
         	<div class="box-footer">
				<div class="pull-right">
					<button type="button" class="btn btn-default btn-sm" id="close" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
				</div>
			</div>
    	</div>
	</div>
</div>