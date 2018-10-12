package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.bean.entity.TFinanceProductChange;
import com.roncoo.adminlte.bean.entity.TFinanceStockChange;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.TFinanceStockChangeService;
import com.roncoo.adminlte.service.impl.dao.TFinanceStockChangeDao;
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
 * @Description: 存货增减表
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/11 16:05
 */
@Service
public class TFinanceStockChangeServiceImpl implements TFinanceStockChangeService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinanceStockChangeDao dao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insert(TFinanceStockChange stockChange) {
        return dao.insert(stockChange);
    }

    @Override
    public int insertBatch(List<TFinanceStockChange> list) {
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
        TFinanceStockChange stockChange = new TFinanceStockChange();
        stockChange.setFheadId(fheadid);
        List<TFinanceStockChange> list = dao.queryByProperty(stockChange);

        JSONObject object = new JSONObject();
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            for (int i = 0; i <list.size(); i++) {
                list.get(i).setFbeginNumber(list.get(i).getFbeginNumber().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFbeginAmount(list.get(i).getFbeginAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFlastNumber(list.get(i).getFlastNumber().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFlastAmount(list.get(i).getFlastAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisAddNumber(list.get(i).getFthisAddNumber().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisAddAmount(list.get(i).getFthisAddAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFtotalAddNumber(list.get(i).getFtotalAddNumber().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFtotalAddAmount(list.get(i).getFtotalAddAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisFallingNumber(list.get(i).getFthisFallingNumber().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisFallingAmount(list.get(i).getFthisFallingAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFtotalFallingNumber(list.get(i).getFtotalFallingNumber().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFtotalFallingAmount(list.get(i).getFtotalFallingAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
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
        List<TFinanceStockChange> stockChanges = new ArrayList<TFinanceStockChange>();
        JSONObject object = new JSONObject();
        logger.info("行数 rowCount={}", rowCount);
        if(rowCount<8){
            object.put("stateCode", 0);
            object.put("error", "导入的模板数据有误");
            logger.error("导入的模板数据有误");
        }else{
            for (int r = 6; r < 19; r++) { //遍历有数据的行
                Row row = sheet.getRow(r);
                if(row!=null){
                    logger.debug("row index:{}", r);
                    TFinanceStockChange stockChange = new TFinanceStockChange();
                    String fproject = Tools.getCellValue(row.getCell(0), wb);
                    BigDecimal c1 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(1), wb));
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

                    stockChange.setFrowIndex(r);
                    stockChange.setFprojectName(fproject);
                    stockChange.setFbeginNumber(c1);
                    stockChange.setFbeginAmount(c2);
                    stockChange.setFthisAddNumber(c3);
                    stockChange.setFthisAddAmount(c4);
                    stockChange.setFtotalAddNumber(c5);
                    stockChange.setFtotalAddAmount(c6);
                    stockChange.setFthisFallingNumber(c7);
                    stockChange.setFthisFallingAmount(c8);
                    stockChange.setFtotalFallingNumber(c9);
                    stockChange.setFtotalFallingAmount(c10);
                    stockChange.setFlastNumber(c11);
                    stockChange.setFlastAmount(c12);

                    stockChanges.add(stockChange);
                }
            }

            TFinanceMain mainIndic = mainService.selectByProperty(companyNumber,period,sheetName);
            Long headId = 0L;
            if(mainIndic!=null && mainIndic.getFid()!=0){
                logger.info("主要记录表有导入记录");
                headId = mainIndic.getFid();
            }else{
                logger.info("主要记录表没有导入记录");
                headId =  mainService.addFinanceMain(companyNumber,sheetName,period,rcUser);
            }
            if(headId!=0){
                for (TFinanceStockChange stockChange : stockChanges) {
                    stockChange.setFheadId(headId);
                }
                int row = dao.deleteByHeadId(headId);
                logger.debug("删除{}记录表数据：row={}", sheetName, row);
                int row1 = dao.insertBatch(stockChanges);
                logger.debug("删除{}记录表数据：row1={}", sheetName, row1);
                //查询主列表并返回页面
                object = queryByHeadId(headId);
            }else{
                logger.info("主导入记录新增失败");
                object.put("error","主导入记录新增失败");
                object.put("stateCode",0);
            }
        }
        return object;
    }
}
