<div class="row">
	<div class="col-md-12">
		<div class="box-body  no-padding">
			<table class="table table-striped">
                <tr>
                	<td width="20%">数据来源：</td>
                	<td style="width: 90%">${bean.fresSys?if_exists}</td>
                </tr>
                <tr>
                	<td>所属组织：</td>
                	<td>${bean.company.fname?if_exists}</td>
                </tr>
                <tr>
                	<td>期间：</td>
                	<td>${bean.fyearMonth?if_exists}</td>
                </tr>
                <tr>
                	<td>指标类型：</td>
                	<td>${bean.ftype?if_exists}</td>
                </tr>
                <tr>
                	<td>指标中文名称：</td>
                	<td>${bean.fnameZh?if_exists}</td>
                </tr>
                <tr>
                	<td>指标英文名称：</td>
                	<td>${bean.fnameEn?if_exists}</td>
                </tr>
                <tr>
                	<td>细分类：</td>
                	<td>${bean.fsmallClass?if_exists}</td>
                </tr>
                <tr>
                	<td>指标值：</td>
                	<td>${bean.fvalue?if_exists}</td>
                </tr>
                <tr>
                	<td>指标值类型：</td>
                	<td>${bean.fvalueType?if_exists}</td>
                </tr>
                <tr>
                	<td>指标生成周期：</td>
                	<td>${bean.fdimension?if_exists}</td>
                </tr>
                <tr>
                	<td>创建时间：</td>
                	<td>${bean.fcreatime?string('yyyy-MM-dd HH:mm:ss')}</td>
                </tr>
                <tr>
                	<td>更新时间：</td>
                	<td>${bean.fupdatime?string('yyyy-MM-dd HH:mm:ss')}</td>
                </tr>
                <tr>
                	<td>最后更新人：</td>
                	<td>${bean.flastUpdator?if_exists}</td>
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