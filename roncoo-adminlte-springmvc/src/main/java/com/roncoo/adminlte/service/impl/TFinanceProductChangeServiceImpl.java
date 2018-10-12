package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.bean.entity.TFinanceProductChange;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.TFinanceProductChangeService;
import com.roncoo.adminlte.service.impl.dao.TFinanceProductChangeDao;
import com.roncoo.adminlte.util.Tools;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品增减表业务实现类
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/11 16:07
 */
@Service
public class TFinanceProductChangeServiceImpl implements TFinanceProductChangeService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinanceProductChangeDao dao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insert(TFinanceProductChange productChange) {
        return dao.insert(productChange);
    }

    @Override
    public int insertBatch(List<TFinanceProductChange> list) {
        return dao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public int deleteByHeadId(Long tfheadid) {
        return dao.deleteByHeadId(tfheadid);
    }

    @Override
    public JSONObject queryByHeadId(Long fheadid) {
        TFinanceProductChange productChange = new TFinanceProductChange();
        productChange.setFheadId(fheadid);
        List<TFinanceProductChange> list = dao.queryByProperty(productChange);

        JSONObject object = new JSONObject();
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            for (int i = 0; i <list.size(); i++) {
                list.get(i).setFquantity(list.get(i).getFquantity().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFamount(list.get(i).getFamount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisYield(list.get(i).getFthisYield().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFtotalYield(list.get(i).getFtotalYield().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisCost(list.get(i).getFthisCost().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFtotalCost(list.get(i).getFtotalCost().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisSales(list.get(i).getFthisSales().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFtotalSales(list.get(i).getFtotalSales().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisAmount(list.get(i).getFthisAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFtotalAmount(list.get(i).getFtotalAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFotherQuantity(list.get(i).getFotherQuantity().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFotherAmount(list.get(i).getFotherAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFlastQuantity(list.get(i).getFlastQuantity().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFlastAmount(list.get(i).getFlastAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));

            }
            String text = JSON.toJSONString(list);
            object.put("datas", JSONArray.parseArray(text));
            object.put("stateCode", 200);
        }
        return object;
    }

    @Override
    public JSONObject importHandler(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser) {
        Sheet sheet = wb.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();
        List<TFinanceProductChange> indiceList = new ArrayList<TFinanceProductChange>();
        JSONObject object = new JSONObject();
        System.out.println("行数 rowCount="+rowCount);
        if(rowCount<8){
            object.put("stateCode", 0);
            object.put("error", "导入的模板数据有误");
            System.out.println("导入的模板数据有误");
        }else{
            for (int r = 6; r < rowCount; r++) { //遍历有数据的行
                Row row = sheet.getRow(r);
                if(row!=null){
                    String rowIndex = null;
                    try {
                        rowIndex = Tools.getCellValue(row.getCell(0), wb);
                        logger.info("row index: {}, column 1: {}", r, rowIndex);
                        if (rowIndex != null && rowIndex.contains("财务负责人")) {
                            break;//默认读取到财务负责人时表示表格已读完
                        } else if (rowIndex != null && rowIndex.contains(".")) {
                            rowIndex = rowIndex.substring(0, rowIndex.lastIndexOf("."));
                        }
                    } catch (Exception e) {
                        logger.warn("行号格式异常, error:{}", e.getMessage(), e);
                    }
                    String fproject = Tools.getCellValue(row.getCell(1), wb);
                    BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
                    BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), wb));
                    BigDecimal c4 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4), wb));
                    BigDecimal c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5), wb));
                    BigDecimal c6 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(6), wb));
                    BigDecimal c7 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(7), wb));
                    BigDecimal c8 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(8), wb));
                    BigDecimal c9 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(9), wb));
                    BigDecimal c10 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(10), wb));
                    BigDecimal c11 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(11), wb));
                    BigDecimal c12 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(12), wb));
                    BigDecimal c13 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(13), wb));
                    BigDecimal c14 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(14), wb));
                    BigDecimal c15 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(15), wb));

                    TFinanceProductChange productChange = new TFinanceProductChange();
                    productChange.setFrowIndex(r);
                    productChange.setFseq(rowIndex);//此字段可能读取到中文，因此使用String类型存储
                    productChange.setFproductName(fproject);
                    productChange.setFquantity(c2);
                    productChange.setFamount(c3);
                    productChange.setFthisYield(c4);
                    productChange.setFtotalYield(c5);
                    productChange.setFthisCost(c6);
                    productChange.setFtotalCost(c7);
                    productChange.setFthisSales(c8);
                    productChange.setFtotalSales(c9);
                    productChange.setFthisAmount(c10);
                    productChange.setFtotalAmount(c11);
                    productChange.setFotherQuantity(c12);
                    productChange.setFotherAmount(c13);
                    productChange.setFlastQuantity(c14);
                    productChange.setFlastAmount(c15);

                    indiceList.add(productChange);
                }
            }

            TFinanceMain mainIndic = mainService.selectByProperty(companyNumber,period,sheetName);
            Long tfheadId = 0L;
            if(mainIndic!=null && mainIndic.getFid()!=0){
                System.out.println("主要记录表有导入记录");
                tfheadId = mainIndic.getFid();
            }else{
                System.out.println("主要记录表没有导入记录");
                tfheadId =  mainService.addFinanceMain(companyNumber,sheetName,period,rcUser);
            }
            if(tfheadId!=0){
                for (TFinanceProductChange indic : indiceList) {
                    indic.setFheadId(tfheadId);
                }
                int row = dao.deleteByHeadId(tfheadId);
                System.out.println("删除"+sheetName+"记录表数据：row="+row);
                int row1 = dao.insertBatch(indiceList);
                System.out.println("批量插入"+sheetName+"模板数据，影响行数 row1="+row1);
                //查询主列表并返回页面
                object = queryByHeadId(tfheadId);
            }else{
                System.out.println("主导入记录新增失败");
                object.put("error","主导入记录新增失败");
                object.put("stateCode",0);
            }
        }
        return object;
    }
}
