package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.BalanceSheet;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.service.BalanceSheetService;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.BalanceSheetDao;
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
 * Created by lx on 2017/11/11.
 */
@Service
public class BalanceSheetServiceImpl implements BalanceSheetService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BalanceSheetDao balanceSheetDao;
    @Autowired
    private TFinanceMainService mainService;

    /**
     * sheet页，需要写入数据的行号,{开始，结束}
     * 从0下标开始计数，包含首尾两行
     */
    private final int[] sheetCellArr = {4,75};

    @Override
    public int insert(BalanceSheet obj) {
        return balanceSheetDao.insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<BalanceSheet> list) {
        return balanceSheetDao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return balanceSheetDao.deleteById(id);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        BalanceSheet obj = new BalanceSheet();
        obj.setFhead_id(tfheadid);
        return balanceSheetDao.deleteByProperty(obj);
    }

    @Override
    public List<BalanceSheet> queryByProperty(Long tfheadid) {
        Map map = new HashMap();
        map.put("fhead_id",tfheadid);
        return balanceSheetDao.queryByProperty(map);
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
                List<BalanceSheet> bslist = new ArrayList<>();
                int size = rowCount;
                for (int r = sheetCellArr[0]; r <= sheetCellArr[1]; r++) { //遍历有数据的行
                    Row row = sheet.getRow(r);
                    if(row!=null){
                        BalanceSheet bs = new BalanceSheet();
                        String fproject = Tools.getCellValue(row.getCell(0), wb);
                        if(fproject!=null && fproject.contains("注:")){
                            //解析完成，跳出
                            break;
                        }
                        Integer c1;
                        try {
                            c1 = Integer.parseInt(Tools.getCellValue(row.getCell(1), wb));
                        }catch (Exception e){
                            c1 = 0;
                        }
                        logger.debug("row index: {}", r);
                        String cellValue2 = Tools.getCellValue(row.getCell(2), wb);
                        BigDecimal c2 = Tools.getDecimalCellValue(cellValue2);
                        String cellValue3 = Tools.getCellValue(row.getCell(3), wb);
                        BigDecimal c3 = Tools.getDecimalCellValue(cellValue3);
                        String c4 = Tools.getCellValue(row.getCell(4), wb);
                        Integer c5 = Integer.parseInt(Tools.getRowNumIntString(Tools.getCellValue(row.getCell(5), wb)));
                        String cellValue6 = Tools.getCellValue(row.getCell(6), wb);
                        BigDecimal c6 = Tools.getDecimalCellValue(cellValue6);
                        String cellValue7 = Tools.getCellValue(row.getCell(7), wb);
                        BigDecimal c7 = Tools.getDecimalCellValue(cellValue7);
                        //System.out.println(fproject+" / "+c1+" / "+c2+" / "+c3+" / "+c4+" / "+c5+" / "+c6+" / "+c7);
                        bs.setFproject(fproject);
                        bs.setFrow_num(c1);
                        bs.setPeriod_end_account(c2);
                        bs.setPeriod_begin_account(c3);
                        bs.setFproject2(c4);
                        bs.setFrow_num2(c5);
                        bs.setPeriod_end_account2(c6);
                        bs.setPeriod_begin_account2(c7);
                        bs.setFrow_index(r);
                        bslist.add(bs);
                    }
                    System.out.println();
                }

                Long tfheadId =  mainService.getOrAddFinanceMainId(companyNumber,sheetName,period,rcUser);
                if(tfheadId!=0){
                    for (BalanceSheet bs : bslist) {
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
        List<BalanceSheet> indices = queryByProperty(fheadid);
        if(indices==null || indices.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            for (int i = 0; i < indices.size(); i++) {
                indices.get(i).setPeriod_end_account(indices.get(i).getPeriod_end_account().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                indices.get(i).setPeriod_begin_account(indices.get(i).getPeriod_begin_account().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                indices.get(i).setPeriod_begin_account2(indices.get(i).getPeriod_begin_account2().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                indices.get(i).setPeriod_end_account2(indices.get(i).getPeriod_end_account2().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
            }
            String text = JSON.toJSONString(indices);
            object.put("datas", JSONArray.parseArray(text));
            object.put("stateCode", 200);
        }
        return object;
    }

    @Override
    public List<BalanceSheet> queryByPropertyAll(List<Long> tfheadids) {
        return balanceSheetDao.queryByPropertyAll(tfheadids);
    }

    @Override
    public void exportHandler(Sheet sheet, List<Long> tfheadids,String fileName){
        List<BalanceSheet> indices = queryByPropertyAll(tfheadids);
        if (indices.size() == 0) {
            return;
        }
        //按组织分解结果集
        Map<Long,List<BalanceSheet>> resultMap = new HashMap<>();
        for (Long fheadid : tfheadids) {
            List<BalanceSheet> item = new ArrayList<>();
            for (BalanceSheet balance : indices) {
                if (balance.getFhead_id().equals(fheadid)) {
                    item.add(balance);
                }
            }
            resultMap.put(fheadid,item);
        }

        if (fileName.contains("2017")){
            sheetCellArr[1] = 68;
        }

        //将数据写入sheet页
        for (int j = sheetCellArr[0]; j <= sheetCellArr[1]; j++) {//遍历sheet页中的指定行
            Row row = sheet.getRow(j);///获取行对象
            Cell cell_c = row.getCell(2);//获取 C 列对象
            Cell cell_d = row.getCell(3);//获取 D 列对象
            Cell cell_g = row.getCell(6);//获取 G 列对象
            Cell cell_h = row.getCell(7);//获取 H 列对象
            BigDecimal item_c = new BigDecimal("0");
            BigDecimal item_d = new BigDecimal("0");
            BigDecimal item_g = new BigDecimal("0");
            BigDecimal item_h = new BigDecimal("0");

            System.out.println(item_c);
            if(j<sheetCellArr[1]){
                for (Long fheadid : tfheadids){//累加
                    if((resultMap.get(fheadid).size()>0)){
                        BalanceSheet bal = resultMap.get(fheadid).get(j-sheetCellArr[0]);//从0下标开始读取
                        item_c = item_c.add(bal.getPeriod_end_account());//C-期末金额
                        item_d = item_d.add(bal.getPeriod_begin_account());//D-年初金额
                        item_g = item_g.add(bal.getPeriod_end_account2());//G-期末金额
                        item_h = item_h.add(bal.getPeriod_begin_account2());//H-年初金额
                    }
                }

                cell_c.setCellValue(item_c.doubleValue());//写入值
                cell_d.setCellValue(item_d.doubleValue());//写入值
                cell_g.setCellValue(item_g.doubleValue());//写入值
                cell_h.setCellValue(item_h.doubleValue());//写入值
            }else {
                cell_c.setCellFormula("C25+C50");//写入值
                cell_d.setCellFormula("D25+D50");//写入值
                cell_g.setCellFormula("G42+G68");//写入值
                cell_h.setCellFormula("H42+H68");//写入值
            }
        }
    }
}
