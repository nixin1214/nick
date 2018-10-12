<#macro menu>
<!-- Left side column. contains the sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
    ${menuHtml}
        <@shiro.hasAnyRoles name="zkld,admin">
            <a class="btn btn-block btn-social btn-dropbox" href="${ctx}/eas/ssoLogin?username=user" target="_blank" style="margin: 5px 0px">
                <i class="fa fa-dropbox"></i>华山牧EAS
            </a>
        </@shiro.hasAnyRoles>
    </section>
    <!-- /.sidebar -->
</aside>
</#macro>

<#macro header>
<style type="text/css">

    @media (min-width: 768px) {
        .navbar-nav > li > a {
            padding-top: 10px;
            padding-bottom: 10px;
        }
    }

</style>
<header class="main-header" id="header">
    <#include "/macro/static.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <!-- Logo -->
    <a href="${ctx}/admin/index" class="logo">
        <span class="logo-mini"><b>中</b><b>垦</b></span>
        <span class="logo-lg"><b><img src="dist/img/logo2.png" style="width: 30px;">中垦乳业 </b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">切换导航</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>

        <!-- Collect the nav links, forms, and other content for toggling -->
    <#--<div class="collapse navbar-collapse pull-left" id="navbar-collapse">-->
    <#--<ul class="nav navbar-nav nav-addtabs nav-tabs" id="navTabs">-->
    <#--<li class="active"><a href="javascript:void(0);"><span>控制台</span></a></li>-->
    <#--<li><a href="javascript:void(0);">测试按钮</a><i class="close-tab fa fa-remove"></i></li>-->
    <#--</ul>-->
    <#--</div>-->
        <div class="pull-left tabs-page" id="navDiv">
            <!--如果不想在顶部显示角标,则给ul加上disable-top-badge类即可-->
            <ul class="nav nav-tabs nav-addtabs disable-top-badge tabs-list clearfix" id="navTabs">
                <li data-panel="zk_index_page" class="active" url="${ctx}/admin/${indexUrl}"><a href="#tab_11180" data-toggle="tab"><span>首页</span></a></li>
            </ul>
            <!-- 右键按钮 -->
            <div class="context-menu" id="contextMenu">
                <ul class="ct-nav">
                    <li rel="reload">刷新标签页</li>
                    <li rel="closeCurrent">关闭标签页</li>
                    <li rel="closeOther">关闭其他标签页</li>
                    <li rel="closeAll">关闭全部标签页</li>
                </ul>
            </div>
        </div>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- User Account: style can be found in dropdown.less -->
                <li id="setuser"  class="dropdown user user-menu" >
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding-top: 10px; padding-bottom: 10px;">
                        <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs">${USER_INFO.nickName}</span>
                    </a>
                    <ul id="userinterface" class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                            <p>
                            ${USER_INFO.nickName}<small>欢迎登陆</small>
                            </p>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a id="rePwdBtn" class="btn btn-default btn-flat" data-toggle="modal" data-target="#myModal">密码修改</a>
                            </div>
                            <div class="pull-right">
                                <a href="${ctx}/exit" class="btn btn-default btn-flat">安全退出</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <!-- Control Sidebar Toggle Button
                <li>
                    <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                </li>-->
            </ul>
        </div>
    </nav>
</header>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header ">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改密码
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="">
                    <div class="form-group">
                        <label for="firstname" class="col-sm-2 control-label">旧密码:</label>
                        <div class="col-sm-8">
                            <input type="hidden" value="${USER_INFO.userNo}" id="userName">
                            <input type="password" class="form-control" id="oldPwd" required="required">
                            <div class="col-md-offset-2 col-md-8" style="color:red;display:none;" id="lastTip"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">新密码:</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" id="newPwd" required="required">
                            <div class="col-md-offset-2 col-md-8" style="color:red;display:none;" id="newTip2"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">确认新密码:</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" id="newPwd2" required="required">
                            <div class="col-md-offset-2 col-md-8" style="color:red;display:none;" id="newTip"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 modal-footer">
                            <div class="col-sm-5"></div>
                            <button type="button" id="pwd_btn" class="btn btn-primary col-sm-2">保存</button>
                        </div>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</#macro>

<#macro footer>
<footer class="main-footer">
    <div class="pull-rights hidden-xs" STYLE="margin-left: 500px">
       Group &copy; 2017-2018 <a href="javascript:void(0);">中垦乳业</a>
    </div>
</footer>
</#macro>
<#--
<#macro style>
	<!-- Tell the browser to be responsive to screen width &ndash;&gt;
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<link rel="shortcut icon" type="image/x-icon" href="dist/img/favicon.ico">
    <!-- Bootstrap 3.3.7 &ndash;&gt;
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome &ndash;&gt;
    <link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons &ndash;&gt;
    <link rel="stylesheet" href="plugins/Ionicons/css/ionicons.min.css">
    <!-- jvectormap &ndash;&gt;
    <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap.css">
    <!-- Theme style &ndash;&gt;
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. &ndash;&gt;
    <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="dist/css/style.css">

    <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="plugins/datatables/jquery.dataTables.css">
    <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries &ndash;&gt;
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// &ndash;&gt;
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]&ndash;&gt;
</#macro>

<#macro jsFile>
<!-- jQuery 3 &ndash;&gt;
<script src="plugins/jQuery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 &ndash;&gt;
<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- SlimScroll &ndash;&gt;
<script src="plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick &ndash;&gt;
<script src="plugins/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App &ndash;&gt;
<script src="dist/js/adminlte.js"></script>
<script src="dist/js/demo.js"></script>

<!-- echarts &ndash;&gt;
<script src="plugins/echarts/echarts.min.js"></script>
<script src="plugins/echarts/theme/shine.js"></script>
<script src="plugins/echarts/map/china.js"></script>

<!-- datepicker &ndash;&gt;
<script src="plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
</#macro>-->

<#macro setting>
<aside class="control-sidebar control-sidebar-dark">
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
        <!--<li>
            <a href="#control-sidebar-home-tab" data-toggle="tab">
                <i class="fa fa-home"></i>
            </a>
        </li>
        <li>
            <a href="#control-sidebar-settings-tab" data-toggle="tab">
                <i class="fa fa-gears"></i>
            </a>
        </li>-->
    </ul>
    <div class="tab-content">
        <div class="tab-pane" id="control-sidebar-home-tab">
            <h3 class="control-sidebar-heading">最近的活动</h3>
            <ul class="control-sidebar-menu">
                <li>
                    <a href="javascript:void(0)">
                        <i class="menu-icon fa fa-birthday-cake bg-red"></i>
                        <div class="menu-info">
                            <h4 class="control-sidebar-subheading">我的生日</h4>
                            <p>四月二十四</p>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0)">
                        <i class="menu-icon fa fa-user bg-yellow"></i>

                        <div class="menu-info">
                            <h4 class="control-sidebar-subheading">更新我的资料</h4>
                            <p>新手机号码 (+86)1234567890</p>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0)">
                        <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

                        <div class="menu-info">
                            <h4 class="control-sidebar-subheading">添加邮箱地址</h4>

                            <p>abc@roncoo.com</p>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0)">
                        <i class="menu-icon fa fa-file-code-o bg-green"></i>
                        <div class="menu-info">
                            <h4 class="control-sidebar-subheading">写个256字的描述</h4>
                            <p>执行时间5秒</p>
                        </div>
                    </a>
                </li>
            </ul>
            <h3 class="control-sidebar-heading">任务进度</h3>
            <ul class="control-sidebar-menu">
                <li>
                    <a href="javascript:void(0)">
                        <h4 class="control-sidebar-subheading">
                            自定义模板的设计 <span class="label label-danger pull-right">70%</span>
                        </h4>
                        <div class="progress progress-xxs">
                            <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0)">
                        <h4 class="control-sidebar-subheading">
                            更新简历 <span class="label label-success pull-right">95%</span>
                        </h4>

                        <div class="progress progress-xxs">
                            <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0)">
                        <h4 class="control-sidebar-subheading">
                            获取积分 <span class="label label-warning pull-right">50%</span>
                        </h4>

                        <div class="progress progress-xxs">
                            <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0)">
                        <h4 class="control-sidebar-subheading">
                            后端框架 <span class="label label-primary pull-right">68%</span>
                        </h4>

                        <div class="progress progress-xxs">
                            <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
        <!-- Settings tab content -->
        <div class="tab-pane" id="control-sidebar-settings-tab">
            <form method="post">
                <h3 class="control-sidebar-heading">一般设置</h3>
                <div class="form-group">
                    <label class="control-sidebar-subheading"> 面板的使用报告 <input type="checkbox" class="pull-right" checked>
                    </label>
                    <p>有关此常规设置选项的一些信息</p>
                </div>
                <div class="form-group">
                    <label class="control-sidebar-subheading"> 允许邮件重定向 <input type="checkbox" class="pull-right" checked>
                    </label>
                    <p>其他可用的选项集</p>
                </div>
                <div class="form-group">
                    <label class="control-sidebar-subheading"> 在帖子中公开作者姓名 <input type="checkbox" class="pull-right" checked>
                    </label>
                    <p>允许用户在博客帖子中显示自己的名字</p>
                </div>
                <h3 class="control-sidebar-heading">聊天设置</h3>
                <div class="form-group">
                    <label class="control-sidebar-subheading"> 显示我是否在线 <input type="checkbox" class="pull-right" checked>
                    </label>
                </div>
                <div class="form-group">
                    <label class="control-sidebar-subheading"> 关闭通知 <input type="checkbox" class="pull-right">
                    </label>
                </div>
                <div class="form-group">
                    <label class="control-sidebar-subheading"> 删除的聊天记录 <a href="javascript:void(0)" class="text-red pull-right">
                        <i class="fa fa-trash-o"></i>
                    </a>
                    </label>
                </div>
            </form>
        </div>
    </div>
</aside>
<div class="control-sidebar-bg"></div>
</#macro>
