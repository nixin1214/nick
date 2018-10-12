<#macro style>
	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<link rel="shortcut icon" type="image/x-icon" href="dist/img/favicon.ico">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="plugins/Ionicons/css/ionicons.min.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="dist/css/style.css">

    <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap.css">
    <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="plugins/bootstrap-table/bootstrap-table.min.css">

    <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</#macro>

<#macro jsFile>
<!-- jQuery 3 -->
<script src="plugins/jQuery/jquery.min.js"></script>
<script src="plugins/jQueryUI/jquery-ui.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="plugins/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.js"></script>
<script src="dist/js/demo.js"></script>
<!-- layer -->
<script type="text/javascript" src="dist/layer/layer.js" ></script>

<!-- echarts -->
<script src="plugins/echarts/echarts.min.js"></script>
<script src="plugins/echarts/theme/shine.js"></script>
<script src="plugins/echarts/theme/macarons.js"></script>
<script src="plugins/echarts/map/china.js"></script>

<!-- datepicker -->
<script src="plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.min.js"></script>

<script src="plugins/jvectormap/jquery-jvectormap.min.js"></script>
<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

<script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script type="text/javascript" src="plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap-table/export/bootstrap-table-export.js"></script>
<script type="text/javascript" src="plugins/tableExport/tableExport.js"></script>
<script type="text/javascript" src="plugins/tableExport/libs/FileSaver/FileSaver.min.js"></script>
<script type="text/javascript" src="plugins/tableExport/libs/js-xlsx/xlsx.core.min.js"></script>
<script type="text/javascript" src="plugins/tableExport/libs/jsPDF/jspdf.min.js"></script>
<script type="text/javascript" src="plugins/tableExport/libs/pdfmake/pdfmake.min.js"></script>
<script type="text/javascript" src="plugins/tableExport/libs/pdfmake/vfs_fonts.js"></script>
<script type="text/javascript" src="plugins/tableExport/libs/jsPDF-AutoTable/jspdf.plugin.autotable.js"></script>


<script type="text/javascript">
    var echartsTheme = 'shine';//echarts主题
    var list_ajax;
    var date_ajax;
    var search_ajax;
    //当你需要多条件查询，你可以调用此方法，动态修改参数传给服务器
    window.reloadTable = function(oTable,datePremise,premise) {
        var date = $(datePremise).val();
        var search = $(premise).val();
        var param = {
            "date" : date,
            "search" : search
        };
        oTable.settings()[0].ajax.data = param;
        oTable.ajax.reload();
    }

    var baseUrl = '${ctx}';
</script>
</#macro>
<#macro common>
<div id="loading" class="loading-panel" style="display: none;">
    <div class="box">
        <i class="fa fa-refresh fa-spin"></i> <span class="tip"> 正在加载 · · · </span>
    </div>
</div>
<div class="modal fade" id="smModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <p>确认删除？</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary">确认</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="lgModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <p>确认删除？</p>
            </div>
        </div>
    </div>
</div>
</#macro>