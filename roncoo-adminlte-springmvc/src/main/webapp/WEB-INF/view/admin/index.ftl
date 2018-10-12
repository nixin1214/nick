<!DOCTYPE html>
<html>
<head>
<#include "/macro/base.ftl" />
<#include "/macro/static.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>中垦乳业智慧经营分析系统</title>
<@style/>
</head>
<#--<body class="hold-transition skin-blue sidebar-collapse sidebar-mini ajax-template" id="tabs">-->
<body class="hold-transition skin-green sidebar-mini ajax-template" id="tabs">
<div class="wrapper">
<@header/>
<@menu/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper" id="content">
    </div>

</div>
<@jsFile/>
<script type="text/javascript">
    $(function() {
        init();
    });

    /**
     * 首页初始化
     */
    function init () {
        $("#content").append('<div id="zk_index_page" class="tabs-panel"><iframe src="${ctx}/admin/${indexUrl}?companyNumber=${companyNumber}" width="100%" height="'+($(window).height() - 55)+'" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling-x="no" scrolling-y="auto" allowtransparency="yes" id="iframe"></iframe></div>');
    }

</script>

<script>
    var submit = true;
    $(function () {
        $("#oldPwd").blur(function () {
            var oldPwd = $(this).val();
            if(oldPwd==""){
                $("#lastTip").html("旧密码不能为空，请重新输入！").css("display","block");
                submit = false;
            }else {
                $("#lastTip").css("display","none");
                submit = true;
            }
        });
        $("#newPwd").blur(function () {
            var newPwd = $(this).val();
            if(newPwd==""){
                $("#newTip2").html("新密码不能为空，请重新输入！").css("display","block");
                submit = false;
            }else if (newPwd.length<6 || newPwd.length>16){
                $("#newTip2").html("密码长度不能小于6位或大于16位！").css("display","block");
                submit = false;
            }else {
                $("#newTip2").css("display","none");
                var newPass = $("#newPwd").val();
                var repPass = $("#newPwd2").val();
                if (newPass!=repPass){
                    $("#newTip").html("两次输入密码不一致,请重输！").css("display","block");
                    submit = false;
                }else {
                    $("#newTip").css("display","none");
                    submit = true;
                }
            }
        });

        $("#newPwd2").blur(function () {
            var newPass = $("#newPwd").val();
            var repPass = $("#newPwd2").val();
            if (newPass!=repPass){
                $("#newTip").html("两次输入密码不一致,请重输！").css("display","block");
                submit = false;
            }else if (repPass.length<6 || repPass.length>16){
                $("#newTip").html("密码长度不能小于6位或大于16位！").css("display","block");
                submit = false;
            }else {
                $("#newTip").css("display","none");
                submit = true;
            }
        });


        $("#pwd_btn").click(function(){
            var oldPwd=$("#oldPwd").val(); /*原始密码*/
            var newPwd=$("#newPwd").val(); /*新密码1*/
            var newPwd2=$("#newPwd2").val(); /*新密码2*/
            var userName=$("#userName").val(); /*新密码2*/
            if(submit){
                $.ajax({
                    type:"post",
                    url:"${ctx}/admin/rePwd",
                    data:{"userName":userName,"oldPwd":oldPwd,"newPwd":newPwd},
                    success:function (data){
                        var jsonObj = eval("("+data+")");
                        console.log(jsonObj);
                        if (jsonObj==0){
                            $("#lastTip").html("原始密码输入错误，请重新输入！").css("display","block");
                        }else {
                            alert("修改成功！");
                            $("#myModal").modal("hide");
                        }
                    }
                });
            }
        });

        $("#rePwdBtn").click(function () {
            $("#lastTip").css("display","none");
            $("#newTip2").css("display","none");
            $("#newTip").css("display","none");
        });

        /**
         * 鼠标悬停和离开事件
         */
        $("#setuser").hover(function(){
            $("#userinterface").show();
        },function(){
            $("#userinterface").hide();
        });


    });




</script>
</body>
</html>
