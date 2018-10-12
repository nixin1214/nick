package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.BalanceProfit;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.service.BalanceProfitService;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.BalanceProfitDao;
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
 * 利润表
 * Created by lx on 2017/11/11.
 */
@Service
public class BalanceProfitServiceImpl implements BalanceProfitService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BalanceProfitDao balanceProfitDao;
    @Autowired
    private TFinanceMainService mainService;

    /**
     * sheet页，需要写入数据的行号,{开始，结束}
     * 从0下标开始计数，包含首尾两行
     */
    private final int[] sheetCellArr = {5,32};

    @Override
    public int insert(BalanceProfit obj) {
        return balanceProfitDao.insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<BalanceProfit> list) {
        return balanceProfitDao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return balanceProfitDao.deleteById(id);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        BalanceProfit obj = new BalanceProfit();
        obj.setFhead_id(tfheadid);
        return balanceProfitDao.deleteByProperty(obj);
    }

    @Override
    public List<BalanceProfit> queryByProperty(Long tfheadid) {
        Map map = new HashMap();
        map.put("fhead_id",tfheadid);
        return balanceProfitDao.queryByProperty(map);
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
            }else{
                List<BalanceProfit> bslist = new ArrayList<>();
                int size = rowCount;
                for (int r = sheetCellArr[0]; r <= sheetCellArr[1]; r++) {
                    Row row = sheet.getRow(r);
                    if(row!=null){
                        BalanceProfit bs = new BalanceProfit();
                        String fproject = Tools.getCellValue(row.getCell(0), wb);
                        if (fproject!=null && fproject.contains("单位负责人")){
                            break;
                        }
                        String cellValue1 = Tools.getCellValue(row.getCell(1), wb);
                        Integer c1;
                        if(Tools.isEmpty(cellValue1)){
                            c1=0;
                        }else{
                            c1 = Integer.parseInt(Tools.getRowNumIntString(cellValue1));
                        }
                        logger.debug("row index: {}", r);
                        String cellValue2 = Tools.getCellValue(row.getCell(2), wb);
                        BigDecimal c2 = Tools.getDecimalCellValue(cellValue2);
                        String cellValue3 = Tools.getCellValue(row.getCell(3), wb);
                        BigDecimal c3 = Tools.getDecimalCellValue(cellValue3);
                        String cellValue4 = Tools.getCellValue(row.getCell(4), wb);
                        BigDecimal c4 = Tools.getDecimalCellValue(cellValue4);
                        String cellValue5 = Tools.getCellValue(row.getCell(5), wb);
                        BigDecimal c5 = Tools.getDecimalCellValue(cellValue5);
                        String cellValue6 = Tools.getCellValue(row.getCell(6), wb);
                        BigDecimal c6 = Tools.getDecimalCellValue(cellValue6);
                        String cellValue7 = Tools.getCellValue(row.getCell(7), wb);
                        BigDecimal c7 = Tools.getDecimalCellValue(cellValue7);

//                        System.out.println(fproject+" / "+c1+" / "+c2+" / "+c3+" / "+c4+" / "+c5+" / "+c6+" / "+c7);

                        bs.setFproject(fproject);
                        bs.setFrow_num(c1);
                        bs.setLast_year_actual(c2);
                        bs.setLast_year_total(c3);
                        bs.setThis_year_budget(c4);
                        bs.setThis_year_budget_total(c5);
                        bs.setThis_year_actual(c6);
                        bs.setThis_year_actual_total(c7);
                        bs.setFrow_index(r);
                        if(Tools.isRowStrong(7,bs.getFrow_index())){bs.setFstrong(1);}
                        bslist.add(bs);
                    }
                }

                Long tfheadId =  mainService.getOrAddFinanceMainId(companyNumber,sheetName,period,rcUser);
                if(tfheadId!=0){
                    for (BalanceProfit bs : bslist) {
                        bs.setFhead_id(tfheadId);
                    }
                    int row = deleteByProperty(tfheadId);
                    System.out.println("删除"+sheetName+"记录表数据：row="+row);
                    int row1 = insertBatch(bslist);
                    System.out.println("批量插入"+sheetName+"模板数据，影响行数 row1="+row1);
                    //查询主列表并返回页面
                    object = queryByHeadId(tfheadId);
                }else{
                    System.out.println("新增导入记录失败");
                    object.put("error","新增导入记录失败");
                    object.put("stateCode",0);
                }
            }
        }
        return object;
    }

    @Override
    public JSONObject queryByHeadId(Long fheadid) {
        JSONObject object = new JSONObject();
        List<BalanceProfit> indices = queryByProperty(fheadid);
        if(indices==null || indices.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            for(int i =0;i<indices.size();i++){
                if(i==0){
                    indices.get(0).setLast_year_actual(indices.get(0).getLast_year_actual().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                    indices.get(0).setLast_year_total(indices.get(0).getLast_year_total().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                    indices.get(0).setThis_year_budget(indices.get(0).getThis_year_budget().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                    indices.get(0).setThis_year_budget_total(indices.get(0).getThis_year_budget_total().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                    indices.get(0).setThis_year_actual(indices.get(0).getThis_year_actual().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                    indices.get(0).setThis_year_actual_total(indices.get(0).getThis_year_actual_total().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                }else {
                    indices.get(i).setLast_year_actual(indices.get(i).getLast_year_actual().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                    indices.get(i).setLast_year_total(indices.get(i).getLast_year_total().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                    indices.get(i).setThis_year_budget(indices.get(i).getThis_year_budget().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                    indices.get(i).setThis_year_budget_total(indices.get(i).getThis_year_budget_total().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                    indices.get(i).setThis_year_actual(indices.get(i).getThis_year_actual().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                    indices.get(i).setThis_year_actual_total(indices.get(i).getThis_year_actual_total().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                 }
                }
            JSONArray array = IndicesTool.balanceProfitListToJsonArray(indices);
            object.put("datas",array);
            object.put("stateCode", 200);
        }
        return object;
    }

    @Override
    public List<BalanceProfit> queryByPropertyAll(List<Long> tfheadids) {
        return balanceProfitDao.queryByPropertyAll(tfheadids);
    }

    @Override
    public void exportHandler(Sheet sheet, List<Long> tfheadids,String fileName){
        List<BalanceProfit> indices = queryByPropertyAll(tfheadids);
        if (indices.size() == 0) {
            return;
        }
        //按组织分解结果集
        Map<Long,List<BalanceProfit>> resultMap = new HashMap<>();
        for (Long fheadid : tfheadids) {
            List<BalanceProfit> item = new ArrayList<>();
            for (BalanceProfit balance : indices) {
                if (balance.getFhead_id().equals(fheadid)) {
                    item.add(balance);
                }
            }
            resultMap.put(fheadid,item);
        }

        if (fileName.contains("2017")){
            sheetCellArr[1] = 31;
        }

        //将数据写入sheet页
        for (int j = sheetCellArr[0]; j <= sheetCellArr[1]; j++) {//遍历sheet页中的指定行
            Row row = sheet.getRow(j);///获取行对象
            Cell cell_c = row.getCell(2);//获取 C 列对象
            Cell cell_d = row.getCell(3);//获取 D 列对象
            Cell cell_e = row.getCell(4);//获取 G 列对象
            Cell cell_f = row.getCell(5);//获取 H 列对象
            Cell cell_g = row.getCell(6);//获取 G 列对象
            Cell cell_h = row.getCell(7);//获取 H 列对象
            BigDecimal item_c = new BigDecimal("0");
            BigDecimal item_d = new BigDecimal("0");
            BigDecimal item_e = new BigDecimal("0");
            BigDecimal item_f = new BigDecimal("0");
            BigDecimal item_g = new BigDecimal("0");
            BigDecimal item_h = new BigDecimal("0");
            for (Long fheadid : tfheadids){//累加
                if((resultMap.get(fheadid).size()>0)){
                    BalanceProfit bal = resultMap.get(fheadid).get(j-sheetCellArr[0]);//从0下标开始读取
                    item_c = item_c.add(bal.getLast_year_actual());//上年实际-本月
                    item_d = item_d.add(bal.getLast_year_total());//上年实际-累计
                    item_e = item_e.add(bal.getThis_year_budget());//本年预算-本月
                    item_f = item_f.add(bal.getThis_year_budget_total());//本年预算-累计
                    item_g = item_g.add(bal.getThis_year_actual());//本年实际-本月
                    item_h = item_h.add(bal.getThis_year_actual_total());//本年实际-累计
                }

            }
            cell_c.setCellValue(item_c.doubleValue());//写入值
            cell_d.setCellValue(item_d.doubleValue());//写入值
            cell_e.setCellValue(item_e.doubleValue());//写入值
            cell_f.setCellValue(item_f.doubleValue());//写入值
            cell_g.setCellValue(item_g.doubleValue());//写入值
            cell_h.setCellValue(item_h.doubleValue());//写入值
        }
    }
}
