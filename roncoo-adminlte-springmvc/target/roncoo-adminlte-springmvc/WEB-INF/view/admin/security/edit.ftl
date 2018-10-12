<div class="row">
    <div class="col-md-12">
        <form id="securityEditForm">
            <input type="hidden" id="id" name="id" value=${bean.id}>
            <div class="box-body">
                <div class="form-group">
                    <label id="userNoLabel">账号</label>
                    <input type="text" class="form-control" name="userNo" id="userNo" value=${bean.userNo!} disabled placeholder="输入账号...">
                </div>
                <div class="form-group">
                    <label id="passwordLabel">密码</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="输入密码...">
                </div>
                <div class="form-group">
                    <label id="nickNameLabel">姓名</label>
                    <input type="text" class="form-control" name="nickName" id="nickName" value=${bean.nickName!} placeholder="输入姓名...">
                </div>
			<#--<div class="form-group">
                <label>性别</label>
                <select name="sex" class="form-control select2" style="width: 100%;">
                    <option <#if bean.sex == 0>selected="selected"</#if> value="0">女</option>
                    <option <#if bean.sex == 1>selected="selected"</#if> value="1">男</option>
                </select>
            </div>-->
                <div class="form-group">
                    <label>所属组织</label>
                    <select name="dataScope" class="form-control select2" style="width: 100%;">
					<#list companys as company>
						<#if company.fnumber == '${bean.dataScope!}'>
                            <option value="${company.fnumber}" selected="selected">${company.fname}</option>
						<#else>
                            <option value="${company.fnumber}">${company.fname}</option>
						</#if>
					</#list>
                    </select>
                </div>
                <div class="form-group">
                    <label>角色：</label>
                    <label>
                        <input type="checkbox" id="allCheckbox" class="flat-red">全选
                    </label>
                    <br/>
				<#list roles as role>
					<#if bean.roleList??>
						<#if role.roleValue == 'superAdmin'>
							<@shiro.hasPermission name="super:update">
                                <label>
                                    <input type="checkbox" name="role" class="flat-red" value="${role.id}"<#list bean.roleList as beanRole> <#if beanRole.roleValue == role.roleValue>checked</#if></#list>> ${role.roleName}
                                </label>
							</@shiro.hasPermission>
						<#else>
                            <label>
                                <input type="checkbox" name="role" class="flat-red" value="${role.id}"<#list bean.roleList as beanRole> <#if beanRole.roleValue == role.roleValue>checked</#if></#list>> ${role.roleName}
                            </label>
						</#if>
					<#else>
						<#if role.roleValue == 'superAdmin'>
							<@shiro.hasPermission name="super:update">
                                <label>
                                    <input type="checkbox" name="role" class="flat-red" value="${role.id}"> ${role.roleName}
                                </label>
							</@shiro.hasPermission>
						<#else>
                            <label>
                                <input type="checkbox" name="role" class="flat-red" value="${role.id}"> ${role.roleName}
                            </label>
						</#if>
					</#if>
				</#list>
                </div>
            </div>
            <div class="box-footer">
                <div class="pull-right">
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
                    <button onclick="securityUpdate();" type="button" class="btn btn-primary btn-sm"><i class="fa fa-paste"></i>更新</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    function securityUpdate(){
        $("span").remove(".errorClass");
        $("br").remove(".errorClass");
        var status=1;
        if($("#password").val()==""){
            $("#passwordLabel").prepend('<span class="errorClass" style="color:red">*新密码不能为空，请重新输入！</span><br class="errorClass"/>');
            status = 0;
        }else if($("#password").val().length<6 || $("#password").val().length>16){
            $("#passwordLabel").prepend('<span class="errorClass" style="color:red">*密码长度不能小于6位或大于16位！</span><br class="errorClass"/>');
            status = 0;
        }

        if(status == 0){
            return false;
        }else {
            $.ajax({
                url: '${ctx}/admin/security/update',
                type: 'post',
                dataType: 'text',
                data: $("#securityEditForm").serialize(),
                success: function (data) {
                    $("#lgModal").modal('hide');
                    alertMsg("更新成功", "success");
                    reloadTable(list_ajax, "#securityTime", "#securityPremise");
                }
            });
        }
    }

    $(function () {
        var sum = $("input[name='role']:checkbox").length;//能勾选的总个数
        var num = $("input[name='role']:checked").length;//已勾选的个数

        /**
         * 全选/全不选
         * @param data
         */
        $("#allCheckbox").click(function onClickCheckbox() {
            if (this.checked){
                num = sum;
                $("input[name='role']:checkbox").prop('checked',true);
            } else {
                num = 0;
                $("input[name='role']:checkbox").prop('checked',false);
            }
        });

        /**
         * 单独勾选事件
         * @param data
         */
        $("input[name='role']:checkbox").click(function checkboxChange() {
            if (this.checked) {
                num ++;
                if (num === sum) {
                    $("#allCheckbox").prop('checked',true);
                }
            } else {
                num --;
                $("#allCheckbox").prop('checked',false);
            }
        });
    })
</script>