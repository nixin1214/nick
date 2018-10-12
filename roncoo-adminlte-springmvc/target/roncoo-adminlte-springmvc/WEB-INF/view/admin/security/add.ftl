<div class="row">
    <div class="col-md-12">
        <form id="securityAddForm">
            <div class="modal-body">
                <div class="form-group">
                    <label id="userNoLabel">账号</label>
                    <input type="text" class="form-control" name="userNo" id="userNo" placeholder="输入账号...">
                </div>
                <div class="form-group">
                    <label id="passwordLabel">密码</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="输入密码...">
                </div>
                <div class="form-group">
                    <label id="nickNameLabel">姓名</label>
                    <input type="text" class="form-control" name="nickName" id="nickName" placeholder="输入姓名...">
                </div>
			<#--<div class="form-group">
                <label>性别</label>
                <select name="sex" class="form-control select2" style="width: 100%;">
                    <option value="1">男</option>
                    <option value="0">女</option>
                </select>
            </div>
            <div class="form-group">
                <label>首页视图</label>
                <select name="viewType" class="form-control select2" style="width: 100%;">
                    <option value="groupIndex">集团视图</option>
                    <option value="milkIndex">乳厂视图</option>
                    <option value="pastureIndex">牧场视图</option>
                </select>
            </div>-->
                <div class="form-group">
                    <label>所属组织</label>
                    <select name="dataScope" class="form-control select2" style="width: 100%;">
					<#list companys as company>
                        <option value="${company.fnumber}">${company.fname}</option>
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
				</#list>
                </div>
            </div>
            <div class="modal-footer">
                <div class="pull-right">
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
                    <button type="button" class="btn btn-primary btn-sm" onclick="securitySave();"><i class="fa fa-save"></i>保存</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    function securitySave(){
        $("span").remove(".errorClass");
        $("br").remove(".errorClass");
        var status = 1;
        if($("#userNo").val()==""){
            $("#userNoLabel").prepend('<span class="errorClass" style="color:red">*角色名不能为空</span><br class="errorClass"/>');
            status = 0;
        }
        if($("#password").val()==""){
            $("#passwordLabel").prepend('<span class="errorClass" style="color:red">*角色值不能为空</span><br class="errorClass"/>');
            status = 0;
        }else if($("#password").val().length<6 || $("#password").val().length>16){
            $("#passwordLabel").prepend('<span class="errorClass" style="color:red">*密码长度不能小于6位或大于16位！</span><br class="errorClass"/>');
            status = 0;
        }

        if(status == 0){
            return false;
        }else{
            $.ajax({
                url: '${ctx}/admin/security/save',
                type: 'post',
                dataType: 'text',
                data: $("#securityAddForm").serialize(),
                success: function (data) {
                    if(data=="添加用户成功"){
                        $("#lgModal").modal('hide');
                    }
                    alertMsg(data,"success");
                    reloadTable(list_ajax,"#securityTime","#securityPremise");
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