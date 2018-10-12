<!DOCTYPE html>
<html>
<head>
<#include "/macro/static.ftl" />
<#include "/macro/base.ftl" />
    <base href="${ctx}/static/roncoo-adminlte/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>每日产销量</title>
<@style/>
</head>
<body class="hold-transition skin-blue layout-top-nav ajax-template" id="tabs">
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
            ${companyName}
                <small>每日产销量</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 中垦</a></li>
                <li class="active">${companyName}</li>
            </ol>
        </section>
        <input type="hidden" id="orgCode" value="${companyNumber}">
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">每日产销明细</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <table id="quota_tab" class="table table-bordered table-hover" style="border-width: 3px;border-color: #0c0c0c">
                                <tbody>
                                <tr>
                                    <th class="text-center" colspan="10" style="font-size: 18px;border: 1px solid">牧场${yearMonth?substring(0,4)}年${yearMonth?substring(4,6)}月${yearMonth?substring(6)}日产销量日报表</th>
                                </tr>
                                <tr>
                                    <th class="text-center" rowspan="6" style="line-height: 230px;border: 1px solid">牧场生产状况</th>
                                    <th class="text-center" colspan="2" rowspan="2" style="line-height: 80px;border: 1px solid">生产状况</th>
                                    <th class="text-center" rowspan="2" style="line-height: 80px;border: 1px solid">当日产销量（吨）</th>
                                    <th class="text-center" colspan="3" style="border: 1px solid">本月日均完成情况</th>
                                    <th class="text-center" colspan="3" style="border: 1px solid">本月累计完成情况</th>
                                </tr>
                                <tr>
                                    <th class="text-center" style="border: 1px solid">累计日均<br>（吨）</th>
                                    <th class="text-center" style="border: 1px solid">当月预算日均<br>（吨）</th>
                                    <th class="text-center" style="border: 1px solid">预算同步<br>达成率</th>
                                    <th class="text-center" style="border: 1px solid">本月累计<br>（吨）</th>
                                    <th class="text-center" style="border: 1px solid">本月预算<br>（吨）</th>
                                    <th class="text-center" style="border: 1px solid">本月累计<br>完成率</th>
                                </tr>
                                <tr >
                                    <th class="text-center" rowspan="2" style="line-height: 54px;border: 1px solid">华山牧场</th>
                                    <th class="text-center" style="border: 1px solid">产奶总量</th>
                                    <th class="text-center" style="border: 1px solid">
                                    ${resultlists["QN"]/1000}
                                    </th>
                                        <#assign hsljrj = 0>
                                            <#assign hsljrj = data["QP"]/nowday/1000>
                                    <th class="text-center" style="border: 1px solid">
                                        ${hsljrj}
                                    </th>

                                    <#assign hsdycn = data["RJCN"]>
                                    <th class="text-center" style="border: 1px solid">
                                        ${hsdycn}
                                    </th>
                                    <#assign hsystb = 0>
                                    <#if hsdycn!=0>
                                        <#assign hsystb = hsljrj/hsdycn*100>
                                    </#if>
                                    <th class="text-center" style="border: 1px solid">
                                        ${hsystb}%
                                    </th>
                                    <th class="text-center" style="border: 1px solid">
                                    ${data["QP"]/1000}
                                    </th>
                                    <#assign hsbyys = data["BYCN"]>
                                    <th class="text-center" style="border: 1px solid">
                                    ${hsbyys}
                                    </th>
                                    <#assign hsbylj = 0>
                                    <#if hsbyys!=0>
                                        <#assign hsbylj = data["QP"]/1000/hsbyys*100>
                                    </#if>
                                    <th class="text-center" style="border: 1px solid">
                                        ${hsbylj}%
                                    </th>
                                </tr>
                                <tr >
                                    <th class="text-center" style="border: 1px solid">销售量</th>
                                    <th class="text-center" style="border: 1px solid">
                                    ${resultlists["XL"]/1000}
                                    </th>

                                        <th class="text-center" style="border: 1px solid">
                                        ${data["XSL"]/nowday/1000}
                                        </th>
                                    <#assign hsxsrj = data["RJXL"]>
                                    <th class="text-center" style="border: 1px solid">
                                        ${hsxsrj}
                                    </th>
                                        <#assign hsxstb = 0>
                                        <#if hsxsrj!=0>
                                            <#assign hsxstb = data["XSL"]/nowday/1000/hsxsrj*100>
                                        </#if>
                                    <th class="text-center" style="border: 1px solid">
                                        ${hsxstb}%
                                    </th>

                                    <th class="text-center" style="border: 1px solid">
                                    ${data["XSL"]/1000}
                                    </th>
                                    <#assign hsxsys = data["BYXL"]>
                                    <th class="text-center" style="border: 1px solid">
                                    ${hsxsys}
                                    </th>
                                    <#assign hsxslj = 0>
                                    <#if hsxsys!=0>
                                        <#assign hsxslj = data["XSL"]/1000/hsxsys*100>
                                    </#if>
                                    <th class="text-center" style="border: 1px solid">
                                        ${hsxslj}%
                                    </th>
                                </tr>
                                <tr >
                                    <th class="text-center" rowspan="2" style="line-height: 54px;border: 1px solid">天宁牧场</th>
                                    <th class="text-center" style="border: 1px solid">产奶总量</th>

                                    <th class="text-center" style="border: 1px solid">
                                        ${resultlist["QN"]/1000}
                                    </th>
                                        <th class="text-center" style="border: 1px solid">
                                        ${result["QP"]/nowday/1000}
                                        </th>
                                    <#assign tncnys = result["RJCN"]>
                                    <th class="text-center" style="border: 1px solid">
                                        ${tncnys}
                                    </th>
                                    <#assign tncntb = 0>
                                    <#if tncnys!=0>
                                        <#assign tncntb = result["QP"]/nowday/1000/tncnys*100>
                                    </#if>
                                    <th class="text-center" style="border: 1px solid">
                                        ${tncntb}%
                                    </th>

                                    <th class="text-center" style="border: 1px solid">
                                    ${result["QP"]/1000}
                                    </th>
                                    <#assign tncnby = result["BYCN"]>
                                    <th class="text-center" style="border: 1px solid">
                                        ${tncnby}
                                    </th>
                                    <#assign tncnwc = 0>
                                    <#if tncnby!=0>
                                        <#assign tncnwc = result["QP"]/1000/tncnby*100>
                                    </#if>
                                    <th class="text-center" style="border: 1px solid">
                                        ${tncnwc}%
                                    </th>
                                </tr>
                                <tr >
                                    <th class="text-center" style="border: 1px solid">销售量</th>

                                    <th class="text-center" style="border: 1px solid">
                                    ${resultlist["XL"]/1000}
                                    </th>
                                        <th class="text-center" style="border: 1px solid">
                                        ${result["XSL"]/nowday/1000}
                                        </th>
                                    <#assign tnxlrj = result["RJXL"]>
                                    <th class="text-center" style="border: 1px solid">
                                    ${tnxlrj}
                                    </th>
                                    <#assign tnxltb = 0>
                                    <#if tnxlrj!=0>
                                        <#assign tnxltb = result["XSL"]/nowday/1000/tnxlrj*100>
                                    </#if>
                                    <th class="text-center" style="border: 1px solid">
                                        ${tnxltb}%
                                    </th>
                                    <th class="text-center" style="border: 1px solid">
                                    ${result["XSL"]/1000}
                                    </th>
                                    <#assign tnxlys = result["BYXL"]>
                                    <th class="text-center" style="border: 1px solid">
                                        ${tnxlys}
                                    </th>
                                    <#assign tnxlwc = 0>
                                    <#if tnxlys!=0>
                                        <#assign tnxlwc = result["XSL"]/1000/tnxlys*100>
                                    </#if>
                                    <th class="text-center" style="border: 1px solid">
                                        ${tnxlwc}%
                                    </th>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
<@common/>
</div>
<@jsFile/>
<script type="text/javascript" src="dist/layer/layer.js" ></script>
<script type="text/javascript">



</script>
</body>
<@footer/>
</html>