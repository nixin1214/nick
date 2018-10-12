$(function () {
    'use strict';

    var currentNum = 1;

    $("#financeData").on("change", function () {
        $("#filename").html($(this)[0].name);
    });
    init();

    /**
     * 查询主要指标数据
     */
    $("#btnSerch1").click(function () {
        //var period = $("#dataSelection option:selected").val();
        queryData();
    });

    //选项卡切换
    $('#myTab a').click(function (e) {
        var idName = $(this).text();
        currentNum = $(this).attr("data");
        $("#idcNum").val(currentNum);
        layer.msg(idName);
        queryData();
    })


    function queryData() {
        var period = $("#dataSelection").val();
        var company = $("#company").val();
        if (period == '') {
            layer.msg("请选择期间");
            return;
        } else if (company === '') {
            layer.msg("请选择组织");
            return;
        }
        var url = baseUrl + "/report/dataEdit/queryFinaceIndcies";
        $.ajax({
            url: url,
            type: 'POST',
            cache: false,
            data: {
                period: period,
                idcNum: currentNum,
                company: company
            },
            dataType: 'json',
            success: function (data) {
                //console.log(data);

                showCurrentTabData(data);
            }
        });
    }



    queryData();

});




/**
 * 初始化页面事件
 */
function init() {

    /**
     * 导入文件
     */
    $("#uploadBtn").on("click", function () {
        var financeForm = new FormData();
        if (document.getElementById("financeFile").files[0] == null) {
            layer.msg("请选择文件");
            return;
        }
        financeForm.append("financeFile", document.getElementById("financeFile").files[0]);
        financeForm.append("idcNum", document.getElementById("idcNum").value);
        financeForm.append("yearMonth",document.getElementById("dataSelection").value);
        var url = baseUrl + "/report/dataEdit/importFinance";
        layer.msg("正在上传...请稍后");
        //等待1000一定时间后，开始执行上传文件操作
        setTimeout(function(){
            $.ajax({
                url: url,
                type: 'POST',
                cache: false,
                async: false,
                data: financeForm,
                processData: false,
                contentType: false,
                dataType: 'json',
                success: function (data) {            //服务器响应成功时的处理函数
                    if (data.stateCode === 200) {
                        layer.msg('导入成功！');
                        //showCurrentTabData(data);
                    } else {
                        layer.msg(data.error);
                    }
                    $("#financeFile").val(null);
                    $("#filename").html("请选择文件");
                    $("#close-modal").click();
                }
            }).done(function (res) {
                console.log(res);
            }).fail(function (res) {
                console.log(res);
            });
        }, 1000);
    });

    //获取焦点，解决点击刷新问题
    $('#zk_zyzb_tb1').focus(function () {
    });

}

/**
 * 展示当前选项卡列表数据
 * Create by Andrew 2017-11-21
 * @param data 结果集
 */
function showCurrentTabData(data) {
    //if (data != null && data.stateCode == 200) {
        var jsonDatas = data.datas||'';
        var idcNum = data.idcNum;
        //console.log(jsonDatas);
        switch (idcNum) {
            case 1:
                //主要指标1
                load_zyzb1(jsonDatas);
                break;
            case 2:
                load_zyzb2(jsonDatas);
                break;
            case 3:
                load_zyzb3(jsonDatas);
                break;
            case 4:
                load_zyzb4(jsonDatas);
                break;
            case 5:
                load_zyzb5(jsonDatas);
                break;
            case 6:
                //资产负债表
                load_zcfz(jsonDatas);
                break;
            case 7:
                //利润
                load_lr(jsonDatas);
                break;
            case 8:
                //现金流量表
                load_xjllb(jsonDatas);
                break;
            case 9:
                //主营业务收支总(本月)
                load_zyszz_by(jsonDatas);
                break;
            case 10:
                //主营业务收支总(累计)
                load_zyszz_lj_tb(jsonDatas);
                break;
            case 37:
                //华山牧乳业明细(本月)
                load_zyszmx_by(jsonDatas);
                break;
            case 38:
                //主营收支明细牧场(本月含运费)
                load_zyszmxmc_by(jsonDatas);
                break;
            case 39:
                //主营收支明细牧场(本月不含运费)
                zk_zyszmxmcb_by(jsonDatas);
                break;
            case 40:
                //主营收支明细(本月供应链)
                zk_zyszmxgyl_by(jsonDatas);
                break;
            case 41:
                //主营收支明细(累计华山牧乳业)
                zk_zyszmxhsl_by(jsonDatas);
                break;
            case 42:
                //主营收支明细(累计牧场含运费)
                zk_zyszmxmcl_by(jsonDatas);
                break;
            case 43:
                //主营收支明细(累计牧场不含运费)
                zk_zyszmxmclb_by(jsonDatas);
                break;
            case 44:
                //主营收支明细(累计供应链)
                zk_zyszmxgyll_by(jsonDatas);
                break;
            case 45:
                //乳制品成本明细(本月华山牧乳业)
                zk_rzpcpmxhsm_by(jsonDatas);
                break;
            case 46:
                //乳制品成本明细(本月牧场)
                zk_rzpcpmxmc_by(jsonDatas);
                break;
            case 47:
                //乳制品成本明细(累计华山牧乳业)
                zk_rzpcpmxhsml_by(jsonDatas);
                break;
            case 48:
                //乳制品成本明细(累计牧场)
                zk_rzpcpmxmcl_by(jsonDatas);
                break;
            case 11:
                //主营业务收支明细(本月天友乳业)
                load_zyszmxty_by(jsonDatas);
                break;
            case 12:
                //主营业务收支明细(累计天友乳业)
                load_zyszmx_lj(jsonDatas);
                break;
            case 13:
                //产品成本汇总表(本月)
                load_cpcbhzb_by(jsonDatas);
                break;
            case 14:
                //产品成本汇总表(累计)
                load_cpcbhzb_lj(jsonDatas);
                break;
            case 15:
                //乳制品成本明细表(本月)
                load_rzpcpmx_by(jsonDatas);
                break;
            case 16:
                //乳制品成本明细表(累计)
                load_rzpcpmx_lj(jsonDatas);
                break;
            case 17:
                //销售费用
                load_xsfy(jsonDatas);
                break;
            case 18:
                //管理费用
                load_glfy(jsonDatas);
                break;
            case 19:
                //制造费用
                load_zzfy(jsonDatas);
                break;
            case 20:
                //财务费用
                load_cwfy(jsonDatas);
                break;
            case 21:
                //税费统计表
                load_sftjb(jsonDatas);
                break;
            case 22:
                //员工薪酬
                load_ygxc(jsonDatas);
                break;
            case 23:
                //固定资产投资情况表
                load_gdzctzqkb(jsonDatas);
                break;
            case 24:
                //固定资产增减表
                load_gdzczjb(jsonDatas);
                break;
            case 25:
                //存货增减表
                load_chzjb(jsonDatas);
                break;
            case 26:
                //产品增减表
                load_cpzjb(jsonDatas);
                break;
            case 27:
                //资产负债表(差额表)
                load_zcfzb_ceb(jsonDatas);
                break;
            default:
                break;
        }
    //} else {
    if (data.stateCode !== 200) {
        var error = data.error;
        layer.msg(error == null ? "未查询到数据" : error);
    }
    //}
}

/**
 * 加载<h3>主要指标1</h3>
 */
function load_zyzb1(datas) {
    var yearMonth = $("#dataSelection").val();
    var sn;
    var ys;
    console.log(yearMonth);
    if(yearMonth.indexOf('2017')!=-1){
        sn = '上年';
        ys = '预算';
    }else{
        sn = '预算';
        ys = '上年';
    }
    $('#zk_zyzb_tb1').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '主要指标1',
            worksheetName: '主要指标1'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    title: "项目",
                    halign: 'center',
                    align: 'center',
                    valign: "middle",
                    colspan: 2,
                    rowspan: 1
                },
                {
                    field: 'rowNum',
                    title: '行次',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    rowspan: 2
                },
                {
                    title: '本期',
                    halign: 'center',
                    align: 'center',
                    colspan: 3
                },
                {
                    title: '累计',
                    halign: 'center',
                    align: 'center',
                    colspan: 3
                }
            ],
            [{
                field: 'type',
                valign: "middle",
                title: '分类',
                formatter: function (value, row, index) {

                    if (value === null || value === 'null' || typeof value === 'undefined') {
                        return '';
                    }
                    return value;
                }
            }, {
                field: 'name',
                valign: "middle",
                title: '指标'
            }, {
                field: 'this_budget',
                title: ys,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'this_last_year',
                title: sn,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'this_actual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cum_budget',
                title: ys,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cum_last_year',
                title: sn,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cum_actual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            //跨行跨列表格设置

            $('#zk_zyzb_tb1').bootstrapTable('mergeCells', {
                index: 0,
                field: 'type',
                rowspan: 11
            });
            $('#zk_zyzb_tb1').bootstrapTable('mergeCells', {
                index: 11,
                field: 'type',
                rowspan: 9
            });
            $('#zk_zyzb_tb1').bootstrapTable('mergeCells', {
                index: 20,
                field: 'type',
                rowspan: 4
            });
            $('#zk_zyzb_tb1').bootstrapTable('mergeCells', {
                index: 24,
                field: 'type',
                rowspan: 6
            });
            $('#zk_zyzb_tb1').bootstrapTable('mergeCells', {
                index: 30,
                field: 'type',
                rowspan: 3
            });

            $('#zk_zyzb_tb1').focus(function () {
            });
            $('#zk_zyzb_tb1').click(function () {
            });
        }
    });
}

/**
 * 加载主要指标2
 * @param jsonDatas
 */
function load_zyzb2(jsonDatas) {

    $('#zk_zyzb_tb2').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: false,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '主要指标2',
            worksheetName: '主要指标2'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    field: 'fproject',
                    title: "项目",
                    halign: 'center',
                    align: 'left',
                    valign: "middle",
                    rowspan: 2
                },
                {
                    title: '1月',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '2月',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '3月',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '4月',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '5月',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '6月',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '7月',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '8月',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '9月',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '10月',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '11月',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '12月',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '一季度',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 4
                },
                {
                    title: '二季度',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 4
                },
                {
                    title: '三季度',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 4
                },
                {
                    title: '四季度',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 4
                },
                {
                    title: '年度累计',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 4
                },
                {
                    field: 'finace_warrning',
                    title: '财务预警',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    rowspan: 2
                }
            ],
            [{
                field: 'budget1',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actual1',
                valign: "middle",
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budget2',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actual2',
                valign: "middle",
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budget3',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actual3',
                valign: "middle",
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budget4',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actual4',
                valign: "middle",
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budget5',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actual5',
                valign: "middle",
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budget6',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actual6',
                valign: "middle",
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budget7',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actual7',
                valign: "middle",
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budget8',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actual8',
                valign: "middle",
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budget9',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actual9',
                valign: "middle",
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budget10',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actual10',
                valign: "middle",
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budget11',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actual11',
                valign: "middle",
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budget12',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actual12',
                valign: "middle",
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q1_aim',
                valign: "middle",
                title: '目标',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q1_done',
                valign: "middle",
                title: '完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q1_done_ratio',
                valign: "middle",
                title: '完成率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q1_cost_ratio',
                valign: "middle",
                title: '成本占比',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q2_aim',
                valign: "middle",
                title: '目标',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q2_done',
                valign: "middle",
                title: '完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q2_done_ratio',
                valign: "middle",
                title: '完成率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q2_cost_ratio',
                valign: "middle",
                title: '成本占比',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q3_aim',
                valign: "middle",
                title: '目标',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q3_done',
                valign: "middle",
                title: '完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q3_done_ratio',
                valign: "middle",
                title: '完成率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q3_cost_ratio',
                valign: "middle",
                title: '成本占比',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q4_aim',
                valign: "middle",
                title: '目标',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q4_done',
                valign: "middle",
                title: '完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q4_done_ratio',
                valign: "middle",
                title: '完成率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q4_cost_ratio',
                valign: "middle",
                title: '成本占比',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'y_aim',
                valign: "middle",
                title: '目标',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'y_done',
                valign: "middle",
                title: '完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'y_done_ratio',
                valign: "middle",
                title: '完成率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'y_cost_ratio',
                valign: "middle",
                title: '成本占比',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: jsonDatas,
        onAll: function (name, args) {
        }
    });

}

/**
 * 加载主要指标3
 * @param jsonDatas
 */
function load_zyzb3(jsonDatas) {

    $('#zk_zyzb_tb3').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: false,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '主要指标3',
            worksheetName: '主要指标3'
        },
        columns: [
            [
                {
                    field: 'fproject',
                    title: "项目",
                    halign: 'center',
                    align: 'left',
                    valign: "middle",
                    rowspan: 2
                },
                {
                    title: '上年同期',
                    halign: 'center',
                    valign: "middle",
                    align: 'center'
                }, {
                title: '上年同期',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                title: '上年同期',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                title: '上年同期',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                title: '上年同期',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                title: '上年同期',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                title: '上年同期',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                title: '上年同期',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                title: '上年同期',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                title: '上年同期',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                title: '上年同期',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                title: '上年同期',
                halign: 'center',
                valign: "middle",
                align: 'center'
            },
                {
                    title: '年度同比',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 4
                }, {
                title: '一季度环比',
                halign: 'center',
                valign: "middle",
                align: 'center',
                colspan: 4
            }, {
                title: '二季度环比',
                halign: 'center',
                valign: "middle",
                align: 'center',
                colspan: 4
            }, {
                title: '三季度环比',
                halign: 'center',
                valign: "middle",
                align: 'center',
                colspan: 4
            }, {
                title: '四季度环比',
                halign: 'center',
                valign: "middle",
                align: 'center',
                colspan: 4
            }
            ],
            [{
                field: 'fperoid1',
                valign: "middle",
                title: '1月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fperoid2',
                valign: "middle",
                title: '2月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fperoid3',
                valign: "middle",
                title: '3月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fperoid4',
                valign: "middle",
                title: '4月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fperoid5',
                valign: "middle",
                title: '5月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fperoid6',
                valign: "middle",
                title: '6月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fperoid7',
                valign: "middle",
                title: '7月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fperoid8',
                valign: "middle",
                title: '8月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fperoid9',
                valign: "middle",
                title: '9月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fperoid10',
                valign: "middle",
                title: '10月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fperoid11',
                valign: "middle",
                title: '11月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fperoid12',
                valign: "middle",
                title: '12月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'this_year_count',
                valign: "middle",
                title: '本年累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'last_year_count',
                valign: "middle",
                title: '上年累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'year_count',
                valign: "middle",
                title: '增减额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'year_ratio',
                valign: "middle",
                title: '增减比率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q1_this_done',
                valign: "middle",
                title: '本季完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q1_last_done',
                valign: "middle",
                title: '上季完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q1_count',
                valign: "middle",
                title: '增减额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q1_ratio',
                valign: "middle",
                title: '增减比率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q2_this_done',
                valign: "middle",
                title: '本季完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q2_last_done',
                valign: "middle",
                title: '上季完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q2_count',
                valign: "middle",
                title: '增减额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q2_ratio',
                valign: "middle",
                title: '增减比率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q3_this_done',
                valign: "middle",
                title: '本季完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q3_last_done',
                valign: "middle",
                title: '上季完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q3_count',
                valign: "middle",
                title: '增减额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q3_ratio',
                valign: "middle",
                title: '增减比率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q4_this_done',
                valign: "middle",
                title: '本季完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q4_last_done',
                valign: "middle",
                title: '上季完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q4_count',
                valign: "middle",
                title: '增减额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q4_ratio',
                valign: "middle",
                title: '增减比率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: jsonDatas,
        onAll: function (name, args) {
        }
    });
    $('#zk_zyzb_tb3').bootstrapTable('refresh');
}

/**
 * 主要指标4
 * @param jsonDatas
 */
function load_zyzb4(jsonDatas) {

    $('#zk_zyzb_tb4').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: false,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '主要指标4',
            worksheetName: '主要指标4'
        },
        columns: [
            [
                {
                    field: 'fproject',
                    title: "项目",
                    halign: 'center',
                    align: 'left',
                    valign: "middle",
                    rowspan: 2
                },
                {
                    title: '年度累计行业对标',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 4

                }, {
                title: '一季度累计行业对标',
                halign: 'center',
                valign: "middle",
                align: 'center',
                colspan: 4
            }, {
                title: '二季度累计行业对标',
                halign: 'center',
                valign: "middle",
                align: 'center',
                colspan: 4
            }, {
                title: '三季度累计行业对标',
                halign: 'center',
                valign: "middle",
                align: 'center',
                colspan: 4
            }, {
                title: '四季度累计行业对标',
                halign: 'center',
                valign: "middle",
                align: 'center',
                colspan: 4
            }
            ],
            [{
                field: 'year_flag_mine',
                valign: "middle",
                title: '本企业',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'year_flag_company',
                valign: "middle",
                title: '对标企业'
            }, {
                field: 'year_flag_cost_ratio',
                valign: "middle",
                title: '成本占比',
                formatter: function (value, row, index) {
                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'year_flag_variance',
                valign: "middle",
                title: '差异率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q1_flag_mine',
                valign: "middle",
                title: '本企业',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q1_flag_company',
                valign: "middle",
                title: '对标企业'
            }, {
                field: 'q1_flag_cost_ratio',
                valign: "middle",
                title: '成本占比',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q1_flag_variance',
                valign: "middle",
                title: '差异率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q2_flag_mine',
                valign: "middle",
                title: '本企业',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q2_flag_company',
                valign: "middle",
                title: '对标企业'
            }, {
                field: 'q2_flag_cost_ratio',
                valign: "middle",
                title: '成本占比',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q2_flag_variance',
                valign: "middle",
                title: '差异率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q3_flag_mine',
                valign: "middle",
                title: '本企业',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q3_flag_company',
                valign: "middle",
                title: '对标企业'
            }, {
                field: 'q3_flag_cost_ratio',
                valign: "middle",
                title: '成本占比',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q3_flag_variance',
                valign: "middle",
                title: '差异率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q4_flag_mine',
                valign: "middle",
                title: '本企业',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q4_flag_company',
                valign: "middle",
                title: '对标企业'
            }, {
                field: 'q4_flag_cost_ratio',
                valign: "middle",
                title: '成本占比',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q4_flag_variance',
                valign: "middle",
                title: '差异率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: jsonDatas,
        onAll: function (name, args) {
        }
    });
}

/**
 * 主要指标5
 * @param jsonDatas
 */
function load_zyzb5(jsonDatas) {

    $('#zk_zyzb_tb5').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: false,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        columns: [
            [
                {
                    field: 'fproject',
                    title: "项目",
                    halign: 'center',
                    align: 'left',
                    valign: "middle",
                    rowspan: 2
                },
                {
                    title: '主要经济指标年度完成情况',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    colspan: 6

                }, {
                title: '年度完成预测',
                halign: 'center',
                valign: "middle",
                align: 'center',
                colspan: 3
            }
            ],
            [{
                field: 'year_plan',
                valign: "middle",
                title: '年度目标',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q1_done',
                valign: "middle",
                title: '一季度完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q2_done',
                valign: "middle",
                title: '二季度完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q3_done',
                valign: "middle",
                title: '三季度完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'q4_done',
                valign: "middle",
                title: '四季度完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'year_done',
                valign: "middle",
                title: '年度完成',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'year_done_count',
                valign: "middle",
                title: '完成值',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'year_done_ratio',
                valign: "middle",
                title: '完成率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'year_done_variance',
                valign: "middle",
                title: '偏差率',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: jsonDatas,
        onAll: function (name, args) {
        }
    });
}

/**
 * 资产负债
 * @param jsonDatas
 */
function load_zcfz(jsonDatas) {

    $('#zk_zcfzb_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: false,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        columns: [
            {
                field: 'fproject',
                title: "项目",
                halign: 'center',
                align: 'left',
                valign: "middle"
            }, {
                field: 'frow_num',
                title: '行次',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                field: 'period_end_account',
                title: '期末金额',
                halign: 'center',
                valign: "middle",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'period_begin_account',
                title: '年初金额',
                halign: 'center',
                valign: "middle",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fproject2',
                title: "项目",
                halign: 'center',
                align: 'left',
                valign: "middle"
            }, {
                field: 'frow_num2',
                title: '行次',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                field: 'period_end_account2',
                title: '期末金额',
                halign: 'center',
                valign: "middle",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'period_begin_account2',
                title: '年初金额',
                halign: 'center',
                valign: "middle",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
        ],
        data: jsonDatas
    });
}

/**
 * 利润表
 * @param jsonDatas
 */
function load_lr(jsonDatas) {

    $('#zk_lrb_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: false,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        columns: [
            [
                {
                    field: 'fproject',
                    title: "项目",
                    halign: 'center',
                    align: 'left',
                    valign: "middle",
                    rowspan: 2
                }, {
                field: 'frow_num',
                title: '行次',
                halign: 'center',
                valign: "middle",
                align: 'center',
                rowspan: 2
            }, {
                title: '上年实际',
                halign: 'center',
                valign: "middle",
                align: 'center',
                colspan: 2
            }, {
                title: '本年预算',
                halign: 'center',
                valign: "middle",
                align: 'center',
                colspan: 2

            }, {
                title: "本年实际",
                halign: 'center',
                align: 'center',
                colspan: 2
            }],
            [
                {
                    field: 'last_year_actual',
                    title: '本月',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    formatter: function (value, row, index) {
                        console.log(value);
                        if (value === 0 || value === '0' || typeof value === 'undefined'||value === '<strong>0</strong>') {
                            return '-';
                        }
                        return value;
                    }
                }, {
                field: 'last_year_total',
                title: '累计',
                halign: 'center',
                valign: "middle",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined'||value === '<strong>0</strong>') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'this_year_budget',
                title: '本月',
                halign: 'center',
                valign: "middle",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined'||value === '<strong>0</strong>') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'this_year_budget_total',
                title: '累计',
                halign: 'center',
                valign: "middle",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined'||value === '<strong>0</strong>') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'this_year_actual',
                title: '本月',
                halign: 'center',
                valign: "middle",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined'||value === '<strong>0</strong>') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'this_year_actual_total',
                title: '累计',
                halign: 'center',
                valign: "middle",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined'||value === '<strong>0</strong>') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: jsonDatas
    });
}

/**
 * 现金流量
 * @param jsonDatas
 */
function load_xjllb(jsonDatas) {
    $('#zk_xjllb_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: false,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        columns: [
            {
                field: 'fproject',
                title: "项目",
                halign: 'center',
                align: 'left',
                valign: "middle"
            }, {
                field: 'fthis_period_cum',
                title: '本期累计数',
                halign: 'center',
                valign: "middle",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'flast_year_cum',
                title: '上年累计数',
                halign: 'center',
                valign: "middle",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'igDecimal',
                title: '补充资料',
                halign: 'center',
                valign: "middle",
                align: 'left'

            }, {
                field: 'fthis_period_cum2',
                title: "本期累计数",
                halign: 'center',
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'flast_year_cum2',
                title: "上年累计数",
                halign: 'center',
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
        ],
        data: jsonDatas
    });
}

/**
 * 主营业务收支总(本月)
 * @param jsonDatas
 */
function load_zyszz_by(jsonDatas) {
    $('#zk_zyszz_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: false,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        columns: [
            [{
                field: 'frow_num',
                title: "序号",
                halign: 'center',
                align: 'left',
                valign: "middle",
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'left',
                valign: "middle",
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                align: 'center',
                colspan: 2
            }, {
                title: '主营业务净收入（万元、元/吨）',
                align: 'center',
                colspan: 3
            }, {
                title: '主营业务成本（万元、元/吨）',
                align: 'center',
                colspan: 3
            }, {
                title: '销售毛利',
                align: 'center',
                colspan: 5
            }
            ],
            [{
                field: 'sale_budget',
                title: "预算",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_actual',
                title: "实际",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'income_budget',
                title: "单位预算",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'income_actual',
                title: "单位实际",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'income_total',
                title: "总额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cost_budget',
                title: "单位预算",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cost_actual',
                title: "单位实际",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cost_total',
                title: "总额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_budget',
                title: "单位预算",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_actual',
                title: "单位实际",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_budget_ratio',
                title: "预算毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_actual_ratio',
                title: "实际毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_total',
                title: "总额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: jsonDatas,
        onAll: function (name, args) {
            $('#zk_zyszz_by_tb').bootstrapTable('mergeCells', {
                index: 0,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszz_by_tb').bootstrapTable('mergeCells', {
                index: 1,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszz_by_tb').bootstrapTable('mergeCells', {
                index: 9,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszz_by_tb').bootstrapTable('mergeCells', {
                index: 17,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszz_by_tb').bootstrapTable('mergeCells', {
                index: 48,
                field: 'frow_num',
                colspan: 2
            });

            $(this).focus(function () {
            });
        }
    });

    $('#zk_zyszz_by_tb').click(function () {
    });
}

/**
 * 主营业务收支总(累计)
 * @param jsonDatas
 */
function load_zyszz_lj_tb(jsonDatas) {
    $('#zk_zyszz_lj_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: false,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        columns: [
            [{
                field: 'frow_num',
                title: "序号",
                halign: 'center',
                align: 'left',
                valign: "middle",
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'left',
                valign: "middle",
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                align: 'center',
                colspan: 2
            }, {
                title: '主营业务净收入（万元、元/吨）',
                align: 'center',
                colspan: 3
            }, {
                title: '主营业务成本（万元、元/吨）',
                align: 'center',
                colspan: 3
            }, {
                title: '销售毛利',
                align: 'center',
                colspan: 5
            }
            ],
            [{
                field: 'sale_budget',
                title: "预算",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_actual',
                title: "实际",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'income_budget',
                title: "单位预算",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'income_actual',
                title: "单位实际",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'income_total',
                title: "总额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cost_budget',
                title: "单位预算",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cost_actual',
                title: "单位实际",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cost_total',
                title: "总额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_budget',
                title: "单位预算",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_actual',
                title: "单位实际",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_budget_ratio',
                title: "预算毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_actual_ratio',
                title: "实际毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_total',
                title: "总额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: jsonDatas,
        onAll: function (name, args) {
            $('#zk_zyszz_lj_tb').bootstrapTable('mergeCells', {
                index: 0,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszz_lj_tb').bootstrapTable('mergeCells', {
                index: 1,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszz_lj_tb').bootstrapTable('mergeCells', {
                index: 9,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszz_lj_tb').bootstrapTable('mergeCells', {
                index: 17,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszz_lj_tb').bootstrapTable('mergeCells', {
                index: 48,
                field: 'frow_num',
                colspan: 2
            });

            $(this).focus(function () {
            });
        }
    });

    $('#zk_zyszz_lj_tb').click(function () {
    });
}


/**
 * 华山牧乳业明细(本月)
 * @param jsonDatas
 */
function load_zyszmx_by(datas) {

    $('#zk_zyszmx_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '华山牧乳业明细(本月)',
            worksheetName: '华山牧乳业明细(本月)'
        },
        columns: [
            [{
                field: 'frowNum',
                title: "行次",
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '占比',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '主营业务净收入（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '主营业务成本（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '销售毛利',
                halign: 'center',
                align: 'center',
                colspan: 6
            }
            ],
            [{
                field: 'saleBudget',
                title: "预算销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'saleActual',
                title: "实际销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetProportion',
                title: "预算占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualProportion',
                title: "实际占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetPrice',
                title: "预算单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualPrice',
                title: "实际单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSalePrice',
                title: "预算销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSalePrice',
                title: "实际销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitCost',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitCost',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSaleCost',
                title: "预算销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSaleCost',
                title: "实际销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitLevel',
                title: "预算单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitLevel',
                title: "实际单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossProfit',
                title: "预算毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossProfit',
                title: "实际毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossInterest',
                title: "预算毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossInterest',
                title: "实际毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
             ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_zyszmx_by_tb').focus(function () {
            });
            $('#zk_zyszmx_by_tb').click(function () {
            });
        }
    });

}

/**
 * 主营收支明细牧场(本月含运费)
 * @param jsonDatas
 */
function load_zyszmxmc_by(datas) {

    $('#zk_zyszmxmc_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '主营收支明细牧场(本月含运费)',
            worksheetName: '主营收支明细牧场(本月含运费)'
        },
        columns: [
            [{
                field: 'frowNum',
                title: "行次",
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '占比',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '主营业务净收入（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '主营业务成本（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '销售毛利',
                halign: 'center',
                align: 'center',
                colspan: 6
            }
            ],
            [{
                field: 'saleBudget',
                title: "预算销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'saleActual',
                title: "实际销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetProportion',
                title: "预算占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualProportion',
                title: "实际占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetPrice',
                title: "预算单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualPrice',
                title: "实际单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSalePrice',
                title: "预算销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSalePrice',
                title: "实际销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitCost',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitCost',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSaleCost',
                title: "预算销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSaleCost',
                title: "实际销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitLevel',
                title: "预算单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitLevel',
                title: "实际单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossProfit',
                title: "预算毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossProfit',
                title: "实际毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossInterest',
                title: "预算毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossInterest',
                title: "实际毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_zyszmxmc_by_tb').focus(function () {
            });
            $('#zk_zyszmxmc_by_tb').click(function () {
            });
        }
    });

}
/**
 * 主营收支明细牧场(本月不含运费)
 * @param jsonDatas
 */
function zk_zyszmxmcb_by(datas) {

    $('#zk_zyszmxmcb_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '主营收支明细牧场(本月不含运费)',
            worksheetName: '主营收支明细牧场(本月不含运费)'
        },
        columns: [
            [{
                field: 'frowNum',
                title: "行次",
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '占比',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '主营业务净收入（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '主营业务成本（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '销售毛利',
                halign: 'center',
                align: 'center',
                colspan: 6
            }
            ],
            [{
                field: 'saleBudget',
                title: "预算销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'saleActual',
                title: "实际销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetProportion',
                title: "预算占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualProportion',
                title: "实际占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetPrice',
                title: "预算单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualPrice',
                title: "实际单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSalePrice',
                title: "预算销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSalePrice',
                title: "实际销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitCost',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitCost',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSaleCost',
                title: "预算销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSaleCost',
                title: "实际销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitLevel',
                title: "预算单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitLevel',
                title: "实际单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossProfit',
                title: "预算毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossProfit',
                title: "实际毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossInterest',
                title: "预算毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossInterest',
                title: "实际毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_zyszmxmcb_by_tb').focus(function () {
            });
            $('#zk_zyszmxmcb_by_tb').click(function () {
            });
        }
    });

}
/**
 * 主营收支明细(累计华山牧乳业)
 * @param jsonDatas
 */
function zk_zyszmxgyl_by(datas) {

    $('#zk_zyszmxgyl_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '主营收支明细(累计华山牧乳业)',
            worksheetName: '主营收支明细(累计华山牧乳业)'
        },
        columns: [
            [{
                field: 'frowNum',
                title: "行次",
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '占比',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '主营业务净收入（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '主营业务成本（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '销售毛利',
                halign: 'center',
                align: 'center',
                colspan: 6
            }
            ],
            [{
                field: 'saleBudget',
                title: "预算销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'saleActual',
                title: "实际销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetProportion',
                title: "预算占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualProportion',
                title: "实际占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetPrice',
                title: "预算单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualPrice',
                title: "实际单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSalePrice',
                title: "预算销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSalePrice',
                title: "实际销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitCost',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitCost',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSaleCost',
                title: "预算销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSaleCost',
                title: "实际销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitLevel',
                title: "预算单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitLevel',
                title: "实际单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossProfit',
                title: "预算毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossProfit',
                title: "实际毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossInterest',
                title: "预算毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossInterest',
                title: "实际毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_zyszmxgyl_by_tb').focus(function () {
            });
            $('#zk_zyszmxgyl_by_tb').click(function () {
            });
        }
    });

}

/**
 * 主营收支明细(本月供应链)
 * @param jsonDatas
 */
function zk_zyszmxgyl_by(datas) {

    $('#zk_zyszmxgyl_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '主营收支明细(本月供应链)',
            worksheetName: '主营收支明细(本月供应链)'
        },
        columns: [
            [{
                field: 'frowNum',
                title: "行次",
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '占比',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '主营业务净收入（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '主营业务成本（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '销售毛利',
                halign: 'center',
                align: 'center',
                colspan: 6
            }
            ],
            [{
                field: 'saleBudget',
                title: "预算销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'saleActual',
                title: "实际销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetProportion',
                title: "预算占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualProportion',
                title: "实际占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetPrice',
                title: "预算单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualPrice',
                title: "实际单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSalePrice',
                title: "预算销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSalePrice',
                title: "实际销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitCost',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitCost',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSaleCost',
                title: "预算销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSaleCost',
                title: "实际销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitLevel',
                title: "预算单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitLevel',
                title: "实际单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossProfit',
                title: "预算毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossProfit',
                title: "实际毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossInterest',
                title: "预算毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossInterest',
                title: "实际毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_zyszmxgyl_by_tb').focus(function () {
            });
            $('#zk_zyszmxgyl_by_tb').click(function () {
            });
        }
    });

}
/**
 * 主营收支明细(累计华山牧乳业)
 * @param jsonDatas
 */
function zk_zyszmxhsl_by(datas) {

    $('#zk_zyszmxhsl_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '主营收支明细(累计华山牧乳业)',
            worksheetName: '主营收支明细(累计华山牧乳业)'
        },
        columns: [
            [{
                field: 'frowNum',
                title: "行次",
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '占比',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '主营业务净收入（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '主营业务成本（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '销售毛利',
                halign: 'center',
                align: 'center',
                colspan: 6
            }
            ],
            [{
                field: 'saleBudget',
                title: "预算销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'saleActual',
                title: "实际销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetProportion',
                title: "预算占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualProportion',
                title: "实际占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetPrice',
                title: "预算单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualPrice',
                title: "实际单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSalePrice',
                title: "预算销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSalePrice',
                title: "实际销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitCost',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitCost',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSaleCost',
                title: "预算销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSaleCost',
                title: "实际销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitLevel',
                title: "预算单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitLevel',
                title: "实际单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossProfit',
                title: "预算毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossProfit',
                title: "实际毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossInterest',
                title: "预算毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossInterest',
                title: "实际毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_zyszmxhsl_by_tb').focus(function () {
            });
            $('#zk_zyszmxhsl_by_tb').click(function () {
            });
        }
    });

}
/**
 * 主营收支明细(累计牧场含运费)
 * @param jsonDatas
 */
function zk_zyszmxmcl_by(datas) {

    $('#zk_zyszmxmcl_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '主营收支明细(累计牧场含运费)',
            worksheetName: '主营收支明细(累计牧场含运费)'
        },
        columns: [
            [{
                field: 'frowNum',
                title: "行次",
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '占比',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '主营业务净收入（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '主营业务成本（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '销售毛利',
                halign: 'center',
                align: 'center',
                colspan: 6
            }
            ],
            [{
                field: 'saleBudget',
                title: "预算销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'saleActual',
                title: "实际销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetProportion',
                title: "预算占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualProportion',
                title: "实际占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetPrice',
                title: "预算单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualPrice',
                title: "实际单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSalePrice',
                title: "预算销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSalePrice',
                title: "实际销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitCost',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitCost',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSaleCost',
                title: "预算销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSaleCost',
                title: "实际销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitLevel',
                title: "预算单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitLevel',
                title: "实际单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossProfit',
                title: "预算毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossProfit',
                title: "实际毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossInterest',
                title: "预算毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossInterest',
                title: "实际毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_zyszmxmcl_by_tb').focus(function () {
            });
            $('#zk_zyszmxmcl_by_tb').click(function () {
            });
        }
    });

}
/**
 * 主营收支明细(累计牧场含运费)
 * @param jsonDatas
 */
function zk_zyszmxmclb_by(datas) {

    $('#zk_zyszmxmclb_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '主营收支明细(累计牧场不含运费)',
            worksheetName: '主营收支明细(累计牧场不含运费)'
        },
        columns: [
            [{
                field: 'frowNum',
                title: "行次",
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '占比',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '主营业务净收入（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '主营业务成本（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '销售毛利',
                halign: 'center',
                align: 'center',
                colspan: 6
            }
            ],
            [{
                field: 'saleBudget',
                title: "预算销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'saleActual',
                title: "实际销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetProportion',
                title: "预算占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualProportion',
                title: "实际占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetPrice',
                title: "预算单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualPrice',
                title: "实际单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSalePrice',
                title: "预算销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSalePrice',
                title: "实际销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitCost',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitCost',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSaleCost',
                title: "预算销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSaleCost',
                title: "实际销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitLevel',
                title: "预算单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitLevel',
                title: "实际单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossProfit',
                title: "预算毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossProfit',
                title: "实际毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossInterest',
                title: "预算毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossInterest',
                title: "实际毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_zyszmxmclb_by_tb').focus(function () {
            });
            $('#zk_zyszmxmclb_by_tb').click(function () {
            });
        }
    });

}
/**
 * 主营收支明细(累计供应链)
 * @param jsonDatas
 */
function zk_zyszmxgyll_by(datas) {

    $('#zk_zyszmxgyll_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '主营收支明细(累计供应链)',
            worksheetName: '主营收支明细(累计供应链)'
        },
        columns: [
            [{
                field: 'frowNum',
                title: "行次",
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '占比',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '主营业务净收入（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '主营业务成本（万元、元/吨）',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '销售毛利',
                halign: 'center',
                align: 'center',
                colspan: 6
            }
            ],
            [{
                field: 'saleBudget',
                title: "预算销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'saleActual',
                title: "实际销量",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetProportion',
                title: "预算占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualProportion',
                title: "实际占比",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetPrice',
                title: "预算单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualPrice',
                title: "实际单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSalePrice',
                title: "预算销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSalePrice',
                title: "实际销售金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitCost',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitCost',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSaleCost',
                title: "预算销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSaleCost',
                title: "实际销售成本金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitLevel',
                title: "预算单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitLevel',
                title: "实际单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossProfit',
                title: "预算毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossProfit',
                title: "实际毛利额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossInterest',
                title: "预算毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossInterest',
                title: "实际毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_zyszmxgyll_by_tb').focus(function () {
            });
            $('#zk_zyszmxgyll_by_tb').click(function () {
            });
        }
    });

}

/**
 * 乳制品成本明细(本月华山牧乳业)
 * @param jsonDatas
 */
function zk_rzpcpmxhsm_by(datas) {

    $('#zk_rzpcpmxhsm_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '乳制品成本明细(本月华山牧乳业)',
            worksheetName: '乳制品成本明细(本月华山牧乳业)'
        },
        columns: [
            [{
                field: 'frowNum',
                title: "行次",
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '占比',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '原材料',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '包装物',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '直接人工薪酬',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '燃料及动力',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '制造费用',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '生产成本',
                halign: 'center',
                align: 'center',
                colspan: 4
            }
            ],
            [{
                field: 'saleBudget',
                title: "预算",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'saleActual',
                title: "实际",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetProportion',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualProportion',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetPrice',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualPrice',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSalePrice',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSalePrice',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitCost',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitCost',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSaleCost',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSaleCost',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitLevel',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitLevel',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossProfit',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossProfit',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossInterest',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossInterest',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetXscb',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualXscb',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetDwsp',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualDwsp',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetYsml',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualYsml',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetYsll',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualYsll',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_rzpcpmxhsm_by_tb').focus(function () {
            });
            $('#zk_rzpcpmxhsm_by_tb').click(function () {
            });
        }
    });

}


/**
 * 乳制品成本明细(本月牧场)
 * @param jsonDatas
 */
function zk_rzpcpmxmc_by(datas) {

    $('#zk_rzpcpmxmc_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '乳制品成本明细(本月牧场)',
            worksheetName: '乳制品成本明细(本月牧场)'
        },
        columns: [
            [{
                field: 'frowNum',
                title: "行次",
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '占比',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '原材料',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '包装物',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '直接人工薪酬',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '燃料及动力',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '制造费用',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '生产成本',
                halign: 'center',
                align: 'center',
                colspan: 4
            }
            ],
            [{
                field: 'saleBudget',
                title: "预算",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'saleActual',
                title: "实际",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetProportion',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualProportion',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetPrice',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualPrice',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSalePrice',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSalePrice',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitCost',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitCost',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSaleCost',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSaleCost',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitLevel',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitLevel',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossProfit',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossProfit',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossInterest',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossInterest',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetXscb',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualXscb',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetDwsp',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualDwsp',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetYsml',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualYsml',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetYsll',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualYsll',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_rzpcpmxmc_by_tb').focus(function () {
            });
            $('#zk_rzpcpmxmc_by_tb').click(function () {
            });
        }
    });

}
/**
 * 乳制品成本明细(累计华山牧乳业)
 * @param jsonDatas
 */
function zk_rzpcpmxhsml_by(datas) {

    $('#zk_rzpcpmxhsml_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '乳制品成本明细(累计华山牧乳业)',
            worksheetName: '乳制品成本明细(累计华山牧乳业)'
        },
        columns: [
            [{
                field: 'frowNum',
                title: "行次",
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '占比',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '原材料',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '包装物',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '直接人工薪酬',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '燃料及动力',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '制造费用',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '生产成本',
                halign: 'center',
                align: 'center',
                colspan: 4
            }
            ],
            [{
                field: 'saleBudget',
                title: "预算",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'saleActual',
                title: "实际",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetProportion',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualProportion',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetPrice',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualPrice',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSalePrice',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSalePrice',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitCost',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitCost',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSaleCost',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSaleCost',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitLevel',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitLevel',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossProfit',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossProfit',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossInterest',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossInterest',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetXscb',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualXscb',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetDwsp',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualDwsp',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetYsml',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualYsml',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetYsll',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualYsll',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_rzpcpmxhsml_by_tb').focus(function () {
            });
            $('#zk_rzpcpmxhsml_by_tb').click(function () {
            });
        }
    });

}
/**
 * 乳制品成本明细(累计华山牧乳业)
 * @param jsonDatas
 */
function zk_rzpcpmxmcl_by(datas) {

    $('#zk_rzpcpmxmcl_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '乳制品成本明细(累计牧场)',
            worksheetName: '乳制品成本明细(累计牧场)'
        },
        columns: [
            [{
                field: 'frowNum',
                title: "行次",
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产品销量（吨）',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '占比',
                halign: 'center',
                align: 'center',
                colspan: 2
            }, {
                title: '原材料',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '包装物',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '直接人工薪酬',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '燃料及动力',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '制造费用',
                halign: 'center',
                align: 'center',
                colspan: 4
            }, {
                title: '生产成本',
                halign: 'center',
                align: 'center',
                colspan: 4
            }
            ],
            [{
                field: 'saleBudget',
                title: "预算",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'saleActual',
                title: "实际",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetProportion',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualProportion',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetPrice',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualPrice',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSalePrice',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSalePrice',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitCost',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitCost',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetSaleCost',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualSaleCost',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetUnitLevel',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualUnitLevel',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossProfit',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossProfit',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetGrossInterest',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualGrossInterest',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetXscb',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualXscb',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetDwsp',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualDwsp',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetYsml',
                title: "预算单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualYsml',
                title: "实际单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'budgetYsll',
                title: "预算金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'actualYsll',
                title: "实际金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }
            ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_rzpcpmxmcl_by_tb').focus(function () {
            });
            $('#zk_rzpcpmxmcl_by_tb').click(function () {
            });
        }
    });

}

/**
 * 主营业务收明细(本月)
 * @param jsonDatas
 */
function load_zyszmxty_by(jsonDatas) {

    $('#zk_zyszmxty_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        columns: [
            [{
                field: 'frow_num',
                title: "序号",
                halign: 'center',
                align: 'left',
                valign: "middle",
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'left',
                valign: "middle",
                rowspan: 2
            }, {
                field: 'sales_volume',
                title: '产品销量（吨）',
                align: 'center',
                halign: 'center',
                valign: "middle",
                rowspan: 2,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                title: '主营业务净收入(万元、元/吨)',
                align: 'center',
                colspan: 3
            }, {
                title: '主营业务成本(万元、元/吨)',
                align: 'center',
                colspan: 2
            }, {
                title: '销售毛利',
                align: 'center',
                colspan: 3
            }
            ],
            [{
                field: 'selling_unit_price',
                title: "销售单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'selling_amont',
                title: "金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cost_unit',
                title: "单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cost_last_month',
                title: "上月累计",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cost_amont',
                title: "金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_unit',
                title: "单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_count',
                title: "金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_ratio',
                title: "毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: jsonDatas,
        onAll: function (name, args) {
            $('#zk_zyszmxty_by_tb').bootstrapTable('mergeCells', {
                index: 0,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszmxty_by_tb').bootstrapTable('mergeCells', {
                index: 82,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszmxty_by_tb').bootstrapTable('mergeCells', {
                index: 83,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszmxty_by_tb').bootstrapTable('mergeCells', {
                index: 128,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszmxty_by_tb').bootstrapTable('mergeCells', {
                index: 129,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszmxty_by_tb').bootstrapTable('mergeCells', {
                index: 166,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszmxty_by_tb').bootstrapTable('mergeCells', {
                index: 167,
                field: 'frow_num',
                colspan: 2
            });
            $(this).focus(function () {
            });
        }
    });

    $('#zk_zyszmxty_by_tb').click(function () {
    });
}

/**
 * 主营业务收明细(累计)
 * @param jsonDatas
 */
function load_zyszmx_lj(jsonDatas) {

    $('#zk_zyszmxtyl_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        columns: [
            [{
                field: 'frow_num',
                title: "序号",
                halign: 'center',
                align: 'left',
                valign: "middle",
                rowspan: 2
            }, {
                field: 'fproject',
                title: '项目',
                halign: 'center',
                align: 'left',
                valign: "middle",
                rowspan: 2
            }, {
                field: 'sales_volume',
                title: '产品销量（吨）',
                align: 'center',
                halign: 'center',
                valign: "middle",
                rowspan: 2,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                title: '主营业务净收入(万元、元/吨)',
                align: 'center',
                colspan: 3
            }, {
                title: '主营业务成本(万元、元/吨)',
                align: 'center',
                colspan: 2
            }, {
                title: '销售毛利',
                align: 'center',
                colspan: 3
            }
            ],
            [{
                field: 'selling_unit_price',
                title: "销售单价",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'selling_amont',
                title: "金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cost_unit',
                title: "单位成本",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cost_last_month',
                title: "上月累计",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'cost_amont',
                title: "金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_unit',
                title: "单位水平",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_count',
                title: "金额",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'sale_profit_ratio',
                title: "毛利率",
                align: 'center',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: jsonDatas,
        onAll: function (name, args) {
            $('#zk_zyszmxtyl_tb').bootstrapTable('mergeCells', {
                index: 0,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszmxtyl_tb').bootstrapTable('mergeCells', {
                index: 82,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszmxtyl_tb').bootstrapTable('mergeCells', {
                index: 83,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszmxtyl_tb').bootstrapTable('mergeCells', {
                index: 128,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszmxtyl_tb').bootstrapTable('mergeCells', {
                index: 129,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszmxtyl_tb').bootstrapTable('mergeCells', {
                index: 166,
                field: 'frow_num',
                colspan: 2
            });
            $('#zk_zyszmxtyl_tb').bootstrapTable('mergeCells', {
                index: 167,
                field: 'frow_num',
                colspan: 2
            });
            $(this).focus(function () {
            });
        }
    });

    $('#zk_zyszmxtyl_tb').click(function () {
    });
}


/**
 * sheet 13
 * 加载<h3>产品成本汇总表(本月)</h3>
 */
function load_cpcbhzb_by(datas) {

    $('#zk_cpcbhzb_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '产品成本汇总表(本月)',
            worksheetName: '产品成本汇总表(本月)'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    title: '行次',
                    field: 'fseq',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2
                }, {
                title: '产品项目',
                field: 'fprojectName',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产量(吨)',
                field: 'fyield',
                halign: 'center',
                align: 'center',
                rowspan: 2,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            },
                {
                    title: '原材料(元)',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '包装物(元)',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '直接人工薪酬(元)',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '燃料及动力(元)',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '制造费用(元)',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '生产成本(元)',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                }
            ],
            [{
                field: 'fmaterialBudget',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmaterialActual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpackageBudget',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpackageActual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'flaborCostBudget',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'flaborCostActual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpowerCostBudget',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpowerCostActual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmanufCostBudget',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmanufCostActual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fproductionCostBudget',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fproductionCostActual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_cpcbhzb_by_tb').focus(function () {
            });
            $('#zk_cpcbhzb_by_tb').click(function () {
            });
        }
    });
}

/**
 * sheet 14
 * 加载<h3>产品成本汇总表(累计)</h3>
 */
function load_cpcbhzb_lj(datas) {

    $('#zk_cpcbhzb_lj_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '产品成本汇总表(累计)',
            worksheetName: '产品成本汇总表(累计)'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    title: '行次',
                    field: 'fseq',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2
                }, {
                title: '产品项目',
                field: 'fprojectName',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产量(吨)',
                field: 'fyield',
                halign: 'center',
                align: 'center',
                rowspan: 2,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            },
                {
                    title: '原材料(元)',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '包装物(元)',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '直接人工薪酬(元)',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '燃料及动力(元)',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '制造费用(元)',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '生产成本',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                }
            ],
            [{
                field: 'fmaterialBudget',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmaterialActual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpackageBudget',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpackageActual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'flaborCostBudget',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'flaborCostActual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpowerCostBudget',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpowerCostActual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmanufCostBudget',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmanufCostActual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fproductionCostBudget',
                valign: "middle",
                title: '预算',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fproductionCostActual',
                title: '实际',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_cpcbhzb_lj_tb').focus(function () {
            });
            $('#zk_cpcbhzb_lj_tb').click(function () {
            });
        }
    });
}

/**
 * sheet 15
 * 加载<h3>乳制品成本明细表(本月)</h3>
 */
function load_rzpcpmx_by(datas) {

    $('#zk_rzpcpmxty_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '乳制品成本明细表(本月)',
            worksheetName: '乳制品成本明细表(本月)'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    title: '行次',
                    field: 'fseq',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2
                }, {
                title: '产品项目',
                field: 'fprojectName',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产量(吨)',
                field: 'fyield',
                halign: 'center',
                align: 'center',
                rowspan: 2,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            },
                {
                    title: '原材料',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '包装物',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '直接人工薪酬',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '燃料及动力',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '制造费用',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '生产成本',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                }
            ],
            [{
                field: 'fmaterialYield',
                valign: "middle",
                title: '单位成本(元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmaterialAmount',
                title: '金额(万元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpackageYield',
                valign: "middle",
                title: '单位成本(元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpackageAmount',
                title: '金额(万元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'flaborCostYield',
                valign: "middle",
                title: '单位成本(元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'flaborCostAmount',
                title: '金额(万元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpowerCostYield',
                valign: "middle",
                title: '单位成本(元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpowerCostAmount',
                title: '金额(万元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmanufCostYield',
                valign: "middle",
                title: '单位成本(元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmanufCostAmount',
                title: '金额(万元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fproductionCostYield',
                valign: "middle",
                title: '单位成本(元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fproductionCostAmount',
                title: '金额(万元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_rzpcpmxty_by_tb').focus(function () {
            });
            $('#zk_rzpcpmxty_by_tb').click(function () {
            });
        }
    });
}

/**
 * sheet 16
 * 加载<h3>乳制品成本明细表(累计)</h3>
 */
function load_rzpcpmx_lj(datas) {

    $('#zk_rzpcpmxtyl_by_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '乳制品成本明细表(累计)',
            worksheetName: '乳制品成本明细表(累计)'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    title: '行次',
                    field: 'fseq',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2
                }, {
                title: '产品项目',
                field: 'fprojectName',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '上月累计',
                field: 'fyieldLast',
                halign: 'center',
                align: 'center',
                rowspan: 2
            }, {
                title: '产量(吨)',
                field: 'fyield',
                halign: 'center',
                align: 'center',
                rowspan: 2,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            },
                {
                    title: '原材料',
                    halign: 'center',
                    align: 'center',
                    colspan: 3
                },
                {
                    title: '包装物',
                    halign: 'center',
                    align: 'center',
                    colspan: 3
                },
                {
                    title: '直接人工薪酬',
                    halign: 'center',
                    align: 'center',
                    colspan: 3
                },
                {
                    title: '燃料及动力',
                    halign: 'center',
                    align: 'center',
                    colspan: 3
                },
                {
                    title: '制造费用',
                    halign: 'center',
                    align: 'center',
                    colspan: 3
                },
                {
                    title: '生产成本',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                }
            ],
            [{
                field: 'fmaterialYield',
                valign: "middle",
                title: '单位成本(元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmaterialLast',
                valign: "middle",
                title: '上月累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmaterialAmount',
                title: '金额(万元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpackageYield',
                valign: "middle",
                title: '单位成本(元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpackageLast',
                valign: "middle",
                title: '上月累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpackageAmount',
                title: '金额(万元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'flaborCostYield',
                valign: "middle",
                title: '单位成本(元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'flaborCostLast',
                valign: "middle",
                title: '上月累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'flaborCostAmount',
                title: '金额(万元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpowerCostYield',
                valign: "middle",
                title: '单位成本(元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpowerCostLast',
                valign: "middle",
                title: '上月累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fpowerCostAmount',
                title: '金额(万元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmanufCostYield',
                valign: "middle",
                title: '单位成本(元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmanufCostLast',
                valign: "middle",
                title: '上月累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fmanufCostAmount',
                title: '金额(万元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fproductionCostYield',
                valign: "middle",
                title: '单位成本(元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fproductionCostAmount',
                title: '金额(万元)',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_rzpcpmxtyl_by_tb').focus(function () {
            });
            $('#zk_rzpcpmxtyl_by_tb').click(function () {
            });
        }
    });
}

/**
 * sheet 17
 * 加载<h3>销售费用</h3>
 */
function load_xsfy(datas) {

    $('#zk_xsfy_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '销售费用',
            worksheetName: '销售费用'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    title: '行次',
                    field: 'fseq',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2
                }, {
                title: '销售费用项目',
                field: 'fprojectName',
                halign: 'center',
                align: 'center',
                rowspan: 2
            },
                {
                    title: '上年同期',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '本年预算',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '本年实际',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                }
            ],
            [{
                field: 'fafterYearThis',
                valign: "middle",
                title: '本月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fafterYearTotal',
                valign: "middle",
                title: '累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearBudgetThis',
                title: '本月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearBudgetTotal',
                title: '累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearActualThis',
                title: '本月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearActualTotal',
                title: '累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_xsfy_tb').focus(function () {
            });
            $('#zk_xsfy_tb').click(function () {
            });
        }
    });
}

/**
 * sheet 18
 * 加载<h3>管理费用</h3>
 */
function load_glfy(datas) {

    $('#zk_glfy_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '管理费用',
            worksheetName: '管理费用'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    title: '行次',
                    field: 'fseq',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2
                }, {
                title: '管理费用项目',
                field: 'fprojectName',
                halign: 'center',
                align: 'center',
                rowspan: 2
            },
                {
                    title: '上年实际',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '本年预算',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '本年实际',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                }
            ],
            [{
                field: 'fafterYearThis',
                valign: "middle",
                title: '本月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fafterYearTotal',
                valign: "middle",
                title: '累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearBudgetThis',
                title: '本月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearBudgetTotal',
                title: '累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearActualThis',
                title: '本月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearActualTotal',
                title: '累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_glfy_tb').focus(function () {
            });
            $('#zk_glfy_tb').click(function () {
            });
        }
    });
}

/**
 * sheet 19
 * 加载<h3>制造费用</h3>
 */
function load_zzfy(datas) {

    $('#zk_zzfy_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '制造费用',
            worksheetName: '制造费用'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    title: '行次',
                    field: 'fseq',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2
                }, {
                title: '制造费用项目',
                field: 'fprojectName',
                halign: 'center',
                align: 'center',
                rowspan: 2
            },
                {
                    title: '上年同期',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '本年预算',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '本年实际',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                }
            ],
            [{
                field: 'fafterYearThis',
                valign: "middle",
                title: '本月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fafterYearTotal',
                valign: "middle",
                title: '累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearBudgetThis',
                title: '本月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearBudgetTotal',
                title: '累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearActualThis',
                title: '本月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearActualTotal',
                title: '累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_zzfy_tb').focus(function () {
            });
            $('#zk_zzfy_tb').click(function () {
            });
        }
    });
}

/**
 * sheet 20
 * 加载<h3>财务费用</h3>
 */
function load_cwfy(datas) {

    $('#zk_cwfy_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '财务费用',
            worksheetName: '财务费用'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    title: '行次',
                    field: 'fseq',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2
                }, {
                title: '财务费用项目',
                field: 'fprojectName',
                halign: 'center',
                align: 'center',
                rowspan: 2
            },
                {
                    title: '上年实际',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '本年预算',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '本年实际',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                }
            ],
            [{
                field: 'fafterYearThis',
                valign: "middle",
                title: '本月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fafterYearTotal',
                valign: "middle",
                title: '累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearBudgetThis',
                title: '本月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearBudgetTotal',
                title: '累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearActualMonth',
                title: '本月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearActualThis',
                title: '累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_cwfy_tb').focus(function () {
            });
            $('#zk_cwfy_tb').click(function () {
            });
        }
    });
}

/**
 * sheet 21
 * 加载<h3>税费统计表</h3>
 */
function load_sftjb(datas) {

    $('#zk_sftjb_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '税费统计表',
            worksheetName: '税费统计表'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    title: '项目',
                    field: 'fprojectName',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2
                },
                {
                    title: '本期数',
                    halign: 'center',
                    align: 'center',
                    colspan: 4
                },
                {
                    title: '累计数',
                    halign: 'center',
                    align: 'center',
                    colspan: 4
                }
            ],
            [{
                field: 'fbeginPeriodUnpaid',
                valign: "middle",
                title: '期初未交',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fbeginPeriodShould',
                valign: "middle",
                title: '本期应交',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fbeginPeriodAlready',
                title: '本期已交',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fbeginPeriodFinalUnpaid',
                title: '期末未交',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'ftotalPeriodUnpaid',
                title: '期初未交',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'ftotalPeriodShould',
                title: '本期应交',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'ftotalPeriodAlready',
                title: '本期已交',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'ftotalPeriodFinalUnpaid',
                title: '期末未交',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_sftjb_tb').focus(function () {
            });
            $('#zk_sftjb_tb').click(function () {
            });
        }
    });
}

/**
 * sheet 22
 * 加载<h3>员工薪酬</h3>
 */
function load_ygxc(datas) {

    $('#zk_ygxc_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '员工薪酬',
            worksheetName: '员工薪酬'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    title: '项目',
                    field: 'fprojectName',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2
                },
                {
                    title: '预算',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '本期数',
                    halign: 'center',
                    align: 'center',
                    colspan: 4
                },
                {
                    title: '累计数',
                    halign: 'center',
                    align: 'center',
                    colspan: 4
                }
            ],
            [{
                field: 'fthisBudget',
                valign: "middle",
                title: '本期',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'ftotalBudget',
                valign: "middle",
                title: '累计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisBeginPeriodAmount',
                valign: "middle",
                title: '期初余额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisPeriodAmount',
                valign: "middle",
                title: '本期提计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisPeriodPaidAmount',
                title: '本期支出',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisPeriodEndAmount',
                title: '期末余额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'ftotalBeginPeriodAmount',
                title: '期初余额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'ftotalPeriodAmount',
                title: '本期提计',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'ftotalPeriodPaidAmount',
                title: '本期支出',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'ftotalPeriodEndAmount',
                title: '期末余额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_ygxc_tb').focus(function () {
            });
            $('#zk_ygxc_tb').click(function () {
            });
        }
    });
}

/**
 * sheet 23
 * 加载<h3>固定资产投资情况表</h3>
 */
function load_gdzctzqkb(datas) {

    $('#zk_gdzctzqkb_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '固定资产投资情况表',
            worksheetName: '固定资产投资情况表'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    field: 'fseq',
                    title: '序号',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    rowspan: 2
                },
                {
                    title: '项目名称',
                    field: 'fprojectName',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2
                },
                {
                    title: '项目计划',
                    halign: 'center',
                    align: 'center'
                },
                {
                    title: '上年未完工',
                    field: 'fafterUnfinishedAmount',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2,
                    formatter: function (value, row, index) {

                        if (value === 0 || value === '0' || typeof value === 'undefined') {
                            return '-';
                        }
                        return value;
                    }
                },
                {
                    title: '本年实际投资',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '已交付资产',
                    field: 'fpaidAmount',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2,
                    formatter: function (value, row, index) {

                        if (value === 0 || value === '0' || typeof value === 'undefined') {
                            return '-';
                        }
                        return value;
                    }
                },
                {
                    title: '本年未完工',
                    field: 'fthisUnfinishedAmount',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2,
                    formatter: function (value, row, index) {

                        if (value === 0 || value === '0' || typeof value === 'undefined') {
                            return '-';
                        }
                        return value;
                    }
                }
            ],
            [{
                field: 'ftotalAmount',
                valign: "middle",
                title: '总投资',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisMonthAmount',
                valign: "middle",
                title: '本月',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYearAmount',
                title: '本年',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_gdzctzqkb_tb').focus(function () {
            });
            $('#zk_gdzctzqkb_tb').click(function () {
            });
        }
    });
}

/**
 * sheet 24
 * 加载<h3>固定资产增减表</h3>
 */
function load_gdzczjb(datas) {

    $('#zk_gdzczjb_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '固定资产增减表',
            worksheetName: '固定资产增减表'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    title: '项目',
                    field: 'fprojectName',
                    halign: 'center',
                    align: 'center'
                },
                {
                    title: '年初结余',
                    field: 'fbeginBalance',
                    halign: 'center',
                    align: 'center',
                    formatter: function (value, row, index) {

                        if (value === 0 || value === '0' || typeof value === 'undefined') {
                            return '-';
                        }
                        return value;
                    }
                },
                {
                    title: '本年增加',
                    field: 'fthisYearAdd',
                    halign: 'center',
                    align: 'center',
                    formatter: function (value, row, index) {

                        if (value === 0 || value === '0' || typeof value === 'undefined') {
                            return '-';
                        }
                        return value;
                    }
                },
                {
                    title: '本年减少',
                    field: 'fthisYearFalling',
                    halign: 'center',
                    align: 'center',
                    formatter: function (value, row, index) {

                        if (value === 0 || value === '0' || typeof value === 'undefined') {
                            return '-';
                        }
                        return value;
                    }
                },
                {
                    title: '期末结余',
                    field: 'fendBalance',
                    halign: 'center',
                    align: 'center',
                    formatter: function (value, row, index) {

                        if (value === 0 || value === '0' || typeof value === 'undefined') {
                            return '-';
                        }
                        return value;
                    }
                }
            ]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_gdzczjb_tb').focus(function () {
            });
            $('#zk_gdzczjb_tb').click(function () {
            });
        }
    });
}

/**
 * 加载25<h3>存货增减表</h3>
 */
function load_chzjb(datas) {

    $('#zk_chzjb_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '存货增减表',
            worksheetName: '存货增减表'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    title: '存货项目',
                    field: 'fprojectName',
                    halign: 'center',
                    align: 'center',
                    rowspan: 3
                },
                {
                    title: '期初结存',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '本年增加',
                    halign: 'center',
                    align: 'center',
                    colspan: 4
                },
                {
                    title: '本年减少',
                    halign: 'center',
                    align: 'center',
                    colspan: 4
                },
                {
                    title: '期末结存',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                }
            ],
            [{
                field: 'fbeginNumber',
                valign: "middle",
                title: '数量',
                rowspan: 2,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fbeginAmount',
                valign: "middle",
                title: '金额',
                rowspan: 2,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                valign: "middle",
                title: "本月",
                colspan: 2
            }, {
                valign: "middle",
                title: "累计",
                colspan: 2
            }, {
                valign: "middle",
                title: "本月",
                colspan: 2
            }, {
                valign: "middle",
                title: "累计",
                colspan: 2
            }, {
                field: "flastNumber",
                valign: "middle",
                title: "数量",
                rowspan: 2,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: "flastAmount",
                valign: "middle",
                title: "金额",
                rowspan: 2,
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }],
            [{
                field: "fthisAddNumber",
                valign: "middle",
                title: "数量",
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: "fthisAddAmount",
                valign: "middle",
                title: "金额",
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: "ftotalAddNumber",
                valign: "middle",
                title: "数量",
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: "ftotalAddAmount",
                valign: "middle",
                title: "金额",
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: "fthisFallingNumber",
                valign: "middle",
                title: "数量",
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: "fthisFallingAmount",
                valign: "middle",
                title: "金额",
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: "ftotalFallingNumber",
                valign: "middle",
                title: "本月减少",
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: "ftotalFallingAmount",
                valign: "middle",
                title: "本年减少",
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_chzjb_tb').focus(function () {
            });
            $('#zk_chzjb_tb').click(function () {
            });
        }
    });
}

/**
 * 加载<h3>产品增减表</h3>
 */
function load_cpzjb(datas) {

    $('#zk_cpzjb_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: true,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        exportDataType: 'all',
        exportTypes: ['xls'],
        exportOptions: {
            fileName: '产品增减表',
            worksheetName: '产品增减表'
        },
        // toolbar: '#toolbar',
        columns: [
            [
                {
                    field: 'fseq',
                    title: '序号',
                    halign: 'center',
                    valign: "middle",
                    align: 'center',
                    rowspan: 2
                },
                {
                    title: '产品',
                    field: 'fproductName',
                    halign: 'center',
                    align: 'center',
                    rowspan: 2
                },
                {
                    title: '期初结余',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '生产',
                    halign: 'center',
                    align: 'center',
                    colspan: 4
                },
                {
                    title: '销售',
                    halign: 'center',
                    align: 'center',
                    colspan: 4
                },
                {
                    title: '其它发出',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                },
                {
                    title: '期末结余',
                    halign: 'center',
                    align: 'center',
                    colspan: 2
                }
            ],
            [{
                field: 'fquantity',
                valign: "middle",
                title: '数量',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'famount',
                valign: "middle",
                title: '金额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisYield',
                title: '本月产量',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'ftotalYield',
                title: '累计产量',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisCost',
                title: '本月成本',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'ftotalCost',
                title: '累计成本',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisSales',
                title: '本月销量',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'ftotalSales',
                title: '累计销量',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fthisAmount',
                title: '本月金额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'ftotalAmount',
                title: '累计金额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fotherQuantity',
                title: '数量',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'fotherAmount',
                title: '金额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'flastQuantity',
                title: '数量',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }, {
                field: 'flastAmount',
                title: '金额',
                formatter: function (value, row, index) {

                    if (value === 0 || value === '0' || typeof value === 'undefined') {
                        return '-';
                    }
                    return value;
                }
            }]
        ],
        data: datas,
        onAll: function (name, args) {
            $('#zk_cpzjb_tb').focus(function () {
            });
            $('#zk_cpzjb_tb').click(function () {
            });
        }
    });
}

/**
 * 资产负债表(差额表)
 * @param jsonDatas
 */
function load_zcfzb_ceb(jsonDatas) {

    $('#zk_zcfzb_ceb_tb').bootstrapTable('destroy').bootstrapTable({
        striped: true,
        pagination: false,
        pageNumber: 1,
        pageSize: 40,
        pageList: [20, 50, 100],
        search: false,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showExport: false,
        columns: [
            {
                field: 'fproject',
                title: "项目",
                halign: 'center',
                align: 'left',
                valign: "middle"
            }, {
                field: 'frowNum',
                title: '行次',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                field: 'periodEndAccount',
                title: '期末金额',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                field: 'periodBeginAccount',
                title: '年初金额',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                field: 'fproject2',
                title: "项目",
                halign: 'center',
                align: 'left',
                valign: "middle"
            }, {
                field: 'frowNum2',
                title: '行次',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                field: 'periodEndAccount2',
                title: '期末金额',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }, {
                field: 'periodBeginAccount2',
                title: '年初金额',
                halign: 'center',
                valign: "middle",
                align: 'center'
            }
        ],
        data: jsonDatas
    });
}