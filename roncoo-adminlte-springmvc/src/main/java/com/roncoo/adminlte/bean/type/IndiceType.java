package com.roncoo.adminlte.bean.type;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 导入的财务指标类型
 * Created by lx on 2017/11/3.
 */
public class IndiceType {

    private static Map<Integer, String> typeMap = new HashMap<>();
    private static Map<Integer, String> unionReportMap = new HashMap<>();
    private static Map<Integer, String> hsmryProductList = new HashMap<>();
    private static Map<Integer, String> hsmryProductIndex = new HashMap<>();

    static{
        typeMap.put(1, "主要指标1");
//        typeMap.put(2, "主要指标2");
//        typeMap.put(3, "主要指标3");
//        typeMap.put(4, "主要指标4");
//        typeMap.put(5, "主要指标5");
        typeMap.put(6, "资产负债表");
        typeMap.put(7, "利润表");
        typeMap.put(8, "现金流量表");
        typeMap.put(9, "主营收支总(本月)");
        typeMap.put(10, "主营收支总(累计)");

        typeMap.put(11, "主营收支明细表(本月天友乳业)");
        typeMap.put(12, "主营收支明细表(累计天友乳业)");
        typeMap.put(13, "产品成本汇总表(本月)");
        typeMap.put(14, "产品成本汇总表(累计)");
        typeMap.put(15, "乳制品成本明细表(本月天友乳业)");
        typeMap.put(16, "乳制品成本明细表(累计天友乳业)");
        typeMap.put(17, "销售费用");
        typeMap.put(18, "管理费用");
        typeMap.put(19, "制造费用");
        typeMap.put(20, "财务费用");
        typeMap.put(21, "税费统计表");
        typeMap.put(22, "员工薪酬");
        typeMap.put(23, "固定资产投资情况表");
        typeMap.put(24, "固定资产增减表");
        typeMap.put(25, "存货增减表");
        typeMap.put(26, "产品增减表");
        typeMap.put(27, "资产负债表(差额表)");
        typeMap.put(28, "利润表(差额表)");
        typeMap.put(29, "现金流量表(差额表)");
        typeMap.put(30, "主营收支总(本月差额表)");
        typeMap.put(31, "主营收支总(累计差额表)");
        typeMap.put(32, "销售费用(差额表)");
        typeMap.put(33, "管理费用(差额表)");
        typeMap.put(34, "制造费用(差额表)");
        typeMap.put(35, "财务费用(差额表)");
        typeMap.put(36, "税费统计表(差额表)");
        typeMap.put(37, "主营收支明细(本月华山牧乳业)");
        typeMap.put(38, "主营收支明细牧场(本月含运费)");
        typeMap.put(39, "主营收支明细牧场(本月不含运费)");
        typeMap.put(40, "主营收支明细(本月供应链)");
        typeMap.put(41, "主营收支明细(累计华山牧乳业)");
        typeMap.put(42, "主营收支明细(累计牧场含运费)");
        typeMap.put(43, "主营收支明细(累计牧场不含运费)");
        typeMap.put(44, "主营收支明细(累计供应链)");
        typeMap.put(45, "乳制品成本明细(本月华山牧乳业)");
        typeMap.put(46, "乳制品成本明细(本月牧场)");
        typeMap.put(47, "乳制品成本明细(累计华山牧乳业)");
        typeMap.put(48, "乳制品成本明细(累计牧场)");
        unionReportMap.put(1, "主要指标(本期)");
        unionReportMap.put(2, "主要指标(累计)");
        unionReportMap.put(3, "资产负债表(合并)");
        unionReportMap.put(4, "利润表(合并)");
        unionReportMap.put(5, "现金流量表(合并)");
        unionReportMap.put(6, "主营收支总(本月合并)");
        unionReportMap.put(7, "主营收支总(累计合并)");
        unionReportMap.put(8, "产品成本汇总表(本月)");
        unionReportMap.put(9, "产品成本汇总表(累计)");
        unionReportMap.put(10, "销售费用表(合并)");
        unionReportMap.put(11, "管理费用表(合并)");
        unionReportMap.put(12, "制造费用(合并)");
        unionReportMap.put(13, "财务费用(合并)");
        unionReportMap.put(14, "税费统计表(合并)");
        unionReportMap.put(15, "员工薪酬表(合并)");
        unionReportMap.put(16, "固定资产投资情况表(合并)");
        unionReportMap.put(17, "固定资产增减表(合并)");

        //华山牧乳业品类细项
        hsmryProductList.put(1,"205ml玻璃瓶高品鲜牛奶(本月预算产量)");
        hsmryProductList.put(2,"250ml屋形高品鲜牛奶(本月预算产量)");
        hsmryProductList.put(3,"950ml屋形高品鲜牛奶(本月预算产量)");
        hsmryProductList.put(4,"250mlPET瓶高品鲜牛奶(本月预算产量)");
        hsmryProductList.put(5,"250ml屋形高品鲜牛奶3包装(本月预算产量)");
        hsmryProductList.put(6,"250mlPET瓶高品鲜牛奶3包装(本月预算产量)");
        hsmryProductList.put(7,"205g玻璃瓶原味纯品优酪乳(本月预算产量)");
        hsmryProductList.put(8,"180g纸塑杯原味纯品优酪乳(本月预算产量)");
        hsmryProductList.put(9,"180g纸塑杯燕麦纯品优酪乳(本月预算产量)");
        hsmryProductList.put(10,"180g纸塑杯混合莓纯品优酪乳(本月预算产量)");
        hsmryProductList.put(11,"180g纸塑杯原味纯品优酪乳4包装(本月预算产量)");
        hsmryProductList.put(12,"180g纸塑杯混合莓纯品优酪乳4包装(本月预算产量)");
        hsmryProductList.put(13,"180g纸塑杯燕麦纯品优酪乳4包装(本月预算产量)");
        hsmryProductList.put(14,"250g轻AIR益生菌发酵乳(原味)(本月预算产量)");
        hsmryProductList.put(15,"250g轻AIR益生菌发酵乳(海盐西柚)(本月预算产量)");
        hsmryProductList.put(16,"华山牧挚简风味酸牛乳(蓝莓)(本月预算产量)");
        hsmryProductList.put(17,"华山牧挚简风味酸牛乳(黄桃+芒果)(本月预算产量)");
        hsmryProductList.put(18,"华山牧场纯牛奶(本月预算产量)");
        hsmryProductList.put(19,"华山牧奶气风味酸奶(本月预算产量)");
        hsmryProductList.put(20,"轻young乳酸菌饮料(原味)(本月预算产量)");
        hsmryProductList.put(21,"轻young乳酸菌饮料(芒果味)(本月预算产量)");
        hsmryProductList.put(22,"轻young乳酸菌饮料(苹果味)(本月预算产量)");
        hsmryProductList.put(23,"200ml康美包学生核桃奶(标准型)(本月预算产量)");
        hsmryProductList.put(24,"200ml康美包学生纯牛奶(标准型)(本月预算产量)");
        hsmryProductList.put(25,"205ml玻璃瓶高品鲜牛奶(本月预算销售额)");
        hsmryProductList.put(26,"250ml屋形高品鲜牛奶(本月预算销售额)");
        hsmryProductList.put(27,"950ml屋形高品鲜牛奶(本月预算销售额)");
        hsmryProductList.put(28,"250mlPET瓶高品鲜牛奶(本月预算销售额)");
        hsmryProductList.put(29,"250ml屋形高品鲜牛奶3包装(本月预算销售额)");
        hsmryProductList.put(30,"250mlPET瓶高品鲜牛奶3包装(本月预算销售额)");
        hsmryProductList.put(31,"205g玻璃瓶原味纯品优酪乳(本月预算销售额)");
        hsmryProductList.put(32,"180g纸塑杯原味纯品优酪乳(本月预算销售额)");
        hsmryProductList.put(33,"180g纸塑杯燕麦纯品优酪乳(本月预算销售额)");
        hsmryProductList.put(34,"180g纸塑杯混合莓纯品优酪乳(本月预算销售额)");
        hsmryProductList.put(35,"180g纸塑杯原味纯品优酪乳4包装(本月预算销售额)");
        hsmryProductList.put(36,"180g纸塑杯混合莓纯品优酪乳4包装(本月预算销售额)");
        hsmryProductList.put(37,"180g纸塑杯燕麦纯品优酪乳4包装(本月预算销售额)");
        hsmryProductList.put(38,"250g轻AIR益生菌发酵乳(原味)(本月预算销售额)");
        hsmryProductList.put(39,"250g轻AIR益生菌发酵乳(海盐西柚)(本月预算销售额)");
        hsmryProductList.put(40,"华山牧挚简风味酸牛乳(蓝莓)(本月预算销售额)");
        hsmryProductList.put(41,"华山牧挚简风味酸牛乳(黄桃+芒果)(本月预算销售额)");
        hsmryProductList.put(42,"华山牧场纯牛奶(本月预算销售额)");
        hsmryProductList.put(43,"华山牧奶气风味酸奶(本月预算销售额)");
        hsmryProductList.put(44,"轻young乳酸菌饮料(原味)(本月预算销售额)");
        hsmryProductList.put(45,"轻young乳酸菌饮料(芒果味)(本月预算销售额)");
        hsmryProductList.put(46,"轻young乳酸菌饮料(苹果味)(本月预算销售额)");
        hsmryProductList.put(47,"200ml康美包学生核桃奶(标准型)(本月预算销售额)");
        hsmryProductList.put(48,"200ml康美包学生纯牛奶(标准型)(本月预算销售额)");

        //华山牧乳业品类细项指标
        hsmryProductIndex.put(1,"HSMRY-XL-DWBLXN");
        hsmryProductIndex.put(2,"HSMRY-XL-DWWXXN");
        hsmryProductIndex.put(3,"HSMRY-XL-DWGPXN");
        hsmryProductIndex.put(4,"HSMRY-XL-DWPEXN");
        hsmryProductIndex.put(5,"HSMRY-XL-DWPAXN");
        hsmryProductIndex.put(6,"HSMRY-XL-DWPBXN");
        hsmryProductIndex.put(7,"HSMRY-XL-DWYCXN");
        hsmryProductIndex.put(8,"HSMRY-XL-DWZSXN");
        hsmryProductIndex.put(9,"HSMRY-XL-DWYMXN");
        hsmryProductIndex.put(10,"HSMRY-XL-DWHHXN");
        hsmryProductIndex.put(11,"HSMRY-XL-DWYWXN");
        hsmryProductIndex.put(12,"HSMRY-XL-DWHMXN");
        hsmryProductIndex.put(13,"HSMRY-XL-DWYMYS");
        hsmryProductIndex.put(14,"HSMRY-XL-DWYSFJ");
        hsmryProductIndex.put(15,"HSMRY-XL-DWYAFJ");
        hsmryProductIndex.put(16,"HSMRY-XL-DWCMFJ");
        hsmryProductIndex.put(17,"HSMRY-XL-DWMGFJ");
        hsmryProductIndex.put(18,"HSMRY-XL-CWHSCN");
        hsmryProductIndex.put(19,"HSMRY-XL-CWHSSN");
        hsmryProductIndex.put(20,"HSMRY-XL-CWRJYL");
        hsmryProductIndex.put(21,"HSMRY-XL-CWRMGYL");
        hsmryProductIndex.put(22,"HSMRY-XL-CWRPGYL");
        hsmryProductIndex.put(23,"HSMRY-XL-XSRPGHT");
        hsmryProductIndex.put(24,"HSMRY-XL-XSRPGCN");
        hsmryProductIndex.put(25,"HSMRY-XLE-DWBLBY");
        hsmryProductIndex.put(26,"HSMRY-XLE-DWWXBY");
        hsmryProductIndex.put(27,"HSMRY-XLE-DWGPBY");
        hsmryProductIndex.put(28,"HSMRY-XLE-DWPEBY");
        hsmryProductIndex.put(29,"HSMRY-XLE-DWPABY");
        hsmryProductIndex.put(30,"HSMRY-XLE-DWPBBY");
        hsmryProductIndex.put(31,"HSMRY-XLE-DWYCBY");
        hsmryProductIndex.put(32,"HSMRY-XLE-DWZSBY");
        hsmryProductIndex.put(33,"HSMRY-XLE-DWYMBY");
        hsmryProductIndex.put(34,"HSMRY-XLE-DWHHBY");
        hsmryProductIndex.put(35,"HSMRY-XLE-DWYWBY");
        hsmryProductIndex.put(36,"HSMRY-XLE-DWHMBY");
        hsmryProductIndex.put(37,"HSMRY-XLE-DWYLBY");
        hsmryProductIndex.put(38,"HSMRY-XLE-DWYSBY");
        hsmryProductIndex.put(39,"HSMRY-XLE-DWYABY");
        hsmryProductIndex.put(40,"HSMRY-XLE-DWCMBY");
        hsmryProductIndex.put(41,"HSMRY-XLE-DWMGBY");
        hsmryProductIndex.put(42,"HSMRY-XLE-CWHSBY");
        hsmryProductIndex.put(43,"HSMRY-XLE-CWHQBY");
        hsmryProductIndex.put(44,"HSMRY-XLE-CWRJBY");
        hsmryProductIndex.put(45,"HSMRY-XLE-CWRMGBY");
        hsmryProductIndex.put(46,"HSMRY-XLE-CWRPGBY");
        hsmryProductIndex.put(47,"HSMRY-XLE-XSRGBY");
        hsmryProductIndex.put(48,"HSMRY-XLE-XSRPBY");
    }

    public static String getIndiceTypeStr(int type) {
        String typeStr = typeMap.get(type);
        if (StringUtils.hasText(typeStr)) {
            return typeStr;
        }
        return "";
    }

    public static Map<Integer, String> getTypeMap() {
        return typeMap;
    }

    public static Map<Integer, String> getUnionReport() {
        return unionReportMap;
    }

    public static Map<Integer, String> getHsmryProductList() {
        return hsmryProductList;
    }

    public static Map<Integer, String> getHsmryProductIndex() {
        return hsmryProductIndex;
    }

}
