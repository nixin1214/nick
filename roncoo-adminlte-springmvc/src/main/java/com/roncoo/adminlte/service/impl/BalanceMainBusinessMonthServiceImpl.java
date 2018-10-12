package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.FinanceMainBusinessMonth;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.service.BalanceMainBusinessMonthService;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessMonthDao;
import com.roncoo.adminlte.util.IndicesTool;
import com.roncoo.adminlte.util.Tools;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析主营业务收支总(本月)
 * Created by lx on 2017/11/14.
 */
@Service
public class BalanceMainBusinessMonthServiceImpl implements BalanceMainBusinessMonthService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BalanceMainBusinessMonthDao mainBusinessMonthDao;
    @Autowired
    private TFinanceMainService mainService;

    /**
     * sheet页，需要写入数据的行号,{开始，结束}
     * 从0下标开始计数，包含首尾两行
     */
    private final int[] sheetCellArr = {5,53};

    @Override
    public int insert(FinanceMainBusinessMonth obj) {
        return mainBusinessMonthDao.insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<FinanceMainBusinessMonth> list) {
        return mainBusinessMonthDao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mainBusinessMonthDao.deleteById(id);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        FinanceMainBusinessMonth obj = new FinanceMainBusinessMonth();
        obj.setFhead_id(tfheadid);
        return mainBusinessMonthDao.deleteByProperty(obj);
    }

    @Override
    public List<FinanceMainBusinessMonth> queryByProperty(Long tfheadid) {
        Map map = new HashMap();
        map.put("fhead_id",tfheadid);
        return mainBusinessMonthDao.queryByProperty(map);
    }

    @Override
    public JSONObject importHandler(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser) {
        Sheet sheet = wb.getSheet(sheetName);
        JSONObject object = new JSONObject();
        if (sheet==null){
            object.put("stateCode", 0);
            object.put("error", "模板为空");
        }else{
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("行数 rowCount="+rowCount);
            if(rowCount==0){
                object.put("stateCode", 0);
                object.put("error", "模板为空");
                System.out.println("模板为空");
            }else{
                List<FinanceMainBusinessMonth> bslist = new ArrayList<>();
                for (int r = sheetCellArr[0]; r <= sheetCellArr[1]; r++) {
                    Row row = sheet.getRow(r);
                    if(row!=null){
                        String rowNum = Tools.getCellValue(row.getCell(0), wb);
                        if (rowNum!=null && rowNum.contains("单位负责人")){
                            break;
                        }
                        String fproject = Tools.getCellValue(row.getCell(1), wb);
                        if(fproject==""){
                            fproject = "-";
                        }
                        if (fproject!=null && fproject.contains("单位负责人")){
                            break;
                        }
                        logger.debug("row index: {}", r);
                        FinanceMainBusinessMonth bc = new FinanceMainBusinessMonth();
                        BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
                        BigDecimal c3 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(3), wb));
                        BigDecimal c4 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(4), wb));
                        BigDecimal c5 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(5), wb));
                        BigDecimal c6 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(6), wb));
                        BigDecimal c7 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(7), wb));
                        BigDecimal c8 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(8), wb));
                        BigDecimal c9 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(9), wb));
                        BigDecimal c10 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(10), wb));
                        BigDecimal c11 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(11), wb));
                        BigDecimal c12 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(12), wb));
                        BigDecimal c13 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(13), wb));
                        BigDecimal c14 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(14), wb));

//                        System.out.println("rowNum="+rowNum+" / fproject="+fproject+" / c2="+c2+" / "+c3+" / "+c4+" / "+c5+" / "+c6+" / "+c7+" / "+c8+" / "+
//                                c9+" / "+c10+" / "+c11+" / "+c12+" / "+c13+" / "+c14);

                        bc.setFrow_num(Tools.getRowNumIntString(rowNum));
                        bc.setFproject(fproject);
                        bc.setSale_budget(c2);
                        bc.setSale_actual(c3);
                        bc.setIncome_budget(c4);
                        bc.setIncome_actual(c5);
                        bc.setIncome_total(c6);
                        bc.setCost_budget(c7);
                        bc.setCost_actual(c8);
                        bc.setCost_total(c9);
                        bc.setSale_profit_budget(c10);
                        bc.setSale_profit_actual(c11);
                        bc.setSale_profit_budget_ratio(c12);
                        bc.setSale_profit_actual_ratio(c13);
                        bc.setSale_total(c14);
                        bc.setFrow_index(r);
                        if (Tools.isRowStrong(9,r)){
                            bc.setFstrong(1);
                        }
                        bslist.add(bc);
                    }
                    System.out.println();
                }
                Long tfheadId =  mainService.getOrAddFinanceMainId(companyNumber,sheetName,period,rcUser);
                if(tfheadId!=0){
                    for (FinanceMainBusinessMonth bc : bslist) { bc.setFhead_id(tfheadId); }
                    int row = deleteByProperty(tfheadId);
                    System.out.println("删除"+sheetName+"记录表数据：row="+row);
                    int row1 = insertBatch(bslist);
                    System.out.println("批量插入"+sheetName+"模板数据，影响行数 row1="+row1);
                    //查询主列表并返回页面
                    object = queryByHeadId(tfheadId);
                }else{
                    object.put("error","导入记录新增失败");
                    object.put("stateCode",0);
                }
            }
        }
        return object;
    }

    @Override
    public JSONObject queryByHeadId(Long fheadid) {
        JSONObject object = new JSONObject();
        List<FinanceMainBusinessMonth> list = queryByProperty(fheadid);
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            for (int i = 0; i <list.size(); i++) {
                list.get(i).setSale_budget(list.get(i).getSale_budget().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSale_actual(list.get(i).getSale_actual().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setIncome_budget(list.get(i).getIncome_budget().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setIncome_actual(list.get(i).getIncome_actual().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setIncome_total(list.get(i).getIncome_total().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setCost_budget(list.get(i).getCost_budget().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setCost_actual(list.get(i).getCost_actual().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setCost_total(list.get(i).getCost_total().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSale_profit_budget(list.get(i).getSale_profit_budget().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSale_profit_actual(list.get(i).getSale_profit_actual().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSale_profit_budget_ratio(list.get(i).getSale_profit_budget_ratio().divide(new BigDecimal(1),2,BigDecimal.ROUND_FLOOR));
                list.get(i).setSale_profit_actual_ratio(list.get(i).getSale_profit_actual_ratio().divide(new BigDecimal(1),2,BigDecimal.ROUND_FLOOR));
                list.get(i).setSale_total(list.get(i).getSale_total().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
            }
            JSONArray array = IndicesTool.balanceMainBusinessMonthToArray(list);
            object.put("datas",array);
            object.put("stateCode", 200);
        }
        return object;
    }

    @Override
    public List<FinanceMainBusinessMonth> queryByPropertyAll(List<Long> tfheadids) {
        return mainBusinessMonthDao.queryByPropertyAll(tfheadids);
    }

    @Override
    public void exportHandler(Sheet sheet, List<Long> tfheadids){
        List<FinanceMainBusinessMonth> indices = queryByPropertyAll(tfheadids);
        if (indices.size() == 0) {
            return;
        }
        //按组织分解结果集
        Map<Long,List<FinanceMainBusinessMonth>> resultMap = new HashMap<>();
        for (Long fheadid : tfheadids) {
            List<FinanceMainBusinessMonth> item = new ArrayList<>();
            for (FinanceMainBusinessMonth balance : indices) {
                if (balance.getFhead_id().equals(fheadid)) {
                    item.add(balance);
                }
            }
            resultMap.put(fheadid,item);
        }
        //将数据写入sheet页
        for (int j = sheetCellArr[0]; j <= sheetCellArr[1]; j++) {//遍历sheet页中的指定行
            Row row = sheet.getRow(j);///获取行对象
            Cell cell_c = row.getCell(2);//获取 C 列对象
            Cell cell_d = row.getCell(3);//获取 D 列对象
            Cell cell_e = row.getCell(4);//获取 E 列对象
            Cell cell_f = row.getCell(5);//获取 F 列对象
            Cell cell_g = row.getCell(6);//获取 G 列对象
            Cell cell_h = row.getCell(7);//获取 H 列对象
            Cell cell_i = row.getCell(8);//获取 I 列对象
            Cell cell_j = row.getCell(9);//获取 J 列对象
            Cell cell_k = row.getCell(10);//获取 K 列对象
            Cell cell_l = row.getCell(11);//获取 L 列对象
            Cell cell_m = row.getCell(12);//获取 M 列对象
            Cell cell_n = row.getCell(13);//获取 N 列对象
            Cell cell_o = row.getCell(14);//获取 O 列对象
            BigDecimal item_c = new BigDecimal("0");
            BigDecimal item_d = new BigDecimal("0");
            BigDecimal item_e = new BigDecimal("0");
            BigDecimal item_f = new BigDecimal("0");
            BigDecimal item_g = new BigDecimal("0");
            BigDecimal item_h = new BigDecimal("0");
            BigDecimal item_i = new BigDecimal("0");
            BigDecimal item_j = new BigDecimal("0");
            BigDecimal item_k = new BigDecimal("0");
            BigDecimal item_l = new BigDecimal("0");
            BigDecimal item_m = new BigDecimal("0");
            BigDecimal item_n = new BigDecimal("0");
            BigDecimal item_o = new BigDecimal("0");
            for (Long fheadid : tfheadids){//累加
                if((resultMap.get(fheadid).size()>0)){
                    FinanceMainBusinessMonth bal = resultMap.get(fheadid).get(j-sheetCellArr[0]);//从0下标开始读取
                    item_c = item_c.add(bal.getSale_budget());//产品销量-预算
                    item_d = item_d.add(bal.getSale_actual());//产品销量-实际
                    item_e = item_e.add(bal.getIncome_budget());//主营业务净收入-单位预算
                    item_f = item_f.add(bal.getIncome_actual());//主营业务净收入-单位实际
                    item_g = item_g.add(bal.getIncome_total());//主营业务净收入-总额
                    item_h = item_h.add(bal.getCost_budget());//主营业务成本-单位预算
                    item_i = item_i.add(bal.getCost_actual());//主营业务成本-单位实际
                    item_j = item_j.add(bal.getCost_total());//主营业务成本-总额
                    item_k = item_k.add(bal.getSale_profit_budget());//销售毛利-单位预算
                    item_l = item_l.add(bal.getSale_profit_actual());//销售毛利-单位实际
                    item_m = item_m.add(bal.getSale_profit_budget_ratio());//销售毛利-预算毛利
                    item_n = item_n.add(bal.getSale_profit_actual_ratio());//销售毛利-实际毛利
                    item_o = item_o.add(bal.getSale_total());//销售毛利-总额
                }
            }
            if(j == 5||j == 6||j == 14||j == 22||j == 29||j == 37||j == 43){
                cell_c.setCellValue(item_c.doubleValue());//写入值
                cell_d.setCellValue(item_d.doubleValue());//写入值
                cell_f.setCellValue(item_f.doubleValue());//写入值
                cell_g.setCellValue(item_g.doubleValue());//写入值
                cell_i.setCellValue(item_i.doubleValue());//写入值
                cell_j.setCellValue(item_j.doubleValue());//写入值
                cell_l.setCellValue(item_l.doubleValue());//写入值
                cell_m.setCellValue(item_m.doubleValue());//写入值
                cell_n.setCellValue(item_n.doubleValue());//写入值
                cell_o.setCellValue(item_o.doubleValue());//写入值
            }else{
                cell_c.setCellValue(item_c.doubleValue());//写入值
                cell_d.setCellValue(item_d.doubleValue());//写入值
                cell_e.setCellValue(item_e.doubleValue());//写入值
                cell_f.setCellValue(item_f.doubleValue());//写入值
                cell_g.setCellValue(item_g.doubleValue());//写入值
                cell_h.setCellValue(item_h.doubleValue());//写入值
                cell_i.setCellValue(item_i.doubleValue());//写入值
                cell_j.setCellValue(item_j.doubleValue());//写入值
                cell_k.setCellValue(item_k.doubleValue());//写入值
                cell_l.setCellValue(item_l.doubleValue());//写入值
                cell_m.setCellValue(item_m.doubleValue());//写入值
                cell_n.setCellValue(item_n.doubleValue());//写入值
                cell_o.setCellValue(item_o.doubleValue());//写入值
            }

        }
    }
}
