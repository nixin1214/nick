package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.bean.entity.TFinanceSaleExpensesDiff;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.TFinanceSaleExpensesDiffService;
import com.roncoo.adminlte.service.impl.dao.TFinanceSaleExpensesDiffDao;
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
 * @Description: 销售费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 12:05
 */
@Service
public class TFinanceSaleExpensesDiffServiceImpl implements TFinanceSaleExpensesDiffService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TFinanceMainService mainService;

    @Autowired
    private TFinanceSaleExpensesDiffDao dao;

    @Override
    public int insert(TFinanceSaleExpensesDiff empSalary) {
        return dao.insert(empSalary);
    }

    @Override
    public int insertBatch(List<TFinanceSaleExpensesDiff> list) {
        return dao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public int deleteByHeadId(Long headId) {
        return dao.deleteByHeadId(headId);
    }

    @Override
    public JSONObject queryByHeadId(Long fheadid) {
        List<TFinanceSaleExpensesDiff> list = dao.queryByHeadId(fheadid);

        JSONObject object = new JSONObject();
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
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
        List<TFinanceSaleExpensesDiff> indiceList = new ArrayList<TFinanceSaleExpensesDiff>();
        JSONObject object = new JSONObject();
        logger.debug("行数 rowCount={}", rowCount);
        if(rowCount<20){
            object.put("stateCode", 0);
            object.put("error", "导入的模板数据有误");
            logger.error("导入的模板数据有误");
        }else{
            for (int r = 6; r < 48; r++) { //遍历有数据的行
                Row row = sheet.getRow(r);
                if(row!=null){
                    TFinanceSaleExpensesDiff fixedAssetsChange = new TFinanceSaleExpensesDiff();
                    String seq = Tools.getCellValue(row.getCell(0), wb);
                    logger.debug("row index: {}, seq:{}", r, seq);
                    String projectName = Tools.getCellValue(row.getCell(1), wb);
                    BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
                    BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), wb));
                    BigDecimal c4 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4), wb));
                    BigDecimal c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5), wb));
                    BigDecimal c6 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(6), wb));
                    BigDecimal c7 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(7), wb));

                    fixedAssetsChange.setFrowIndex(Long.parseLong(r + ""));
                    fixedAssetsChange.setFseq(seq);
                    fixedAssetsChange.setFprojectName(projectName);
                    fixedAssetsChange.setFafterYearThis(c2);
                    fixedAssetsChange.setFafterYearTotal(c3);
                    fixedAssetsChange.setFthisYearBudgetThis(c4);
                    fixedAssetsChange.setFthisYearBudgetTotal(c5);
                    fixedAssetsChange.setFthisYearActualThis(c6);
                    fixedAssetsChange.setFthisYearActualTotal(c7);

                    indiceList.add(fixedAssetsChange);
                }
            }

            TFinanceMain mainIndic = mainService.selectByProperty(companyNumber,period,sheetName);
            Long tfheadId = 0L;
            if(mainIndic!=null && mainIndic.getFid()!=0){
                logger.info("主要记录表有导入记录");
                tfheadId = mainIndic.getFid();
            }else{
                logger.info("主要记录表没有导入记录");
                tfheadId =  mainService.addFinanceMain(companyNumber,sheetName,period,rcUser);
            }
            if(tfheadId!=0){
                for (TFinanceSaleExpensesDiff fixedAssetsChange : indiceList) {
                    fixedAssetsChange.setFheadId(tfheadId);
                }
                int row = dao.deleteByHeadId(tfheadId);
                logger.debug("删除{}记录表数据：row={}", sheetName, row);
                int row1 = dao.insertBatch(indiceList);
                logger.debug("删除{}记录表数据：row1={}", sheetName, row1);
                //查询主列表并返回页面
                object = queryByHeadId(tfheadId);
            }else{
                logger.info("主导入记录新增失败");
                object.put("error","主导入记录新增失败");
                object.put("stateCode",0);
            }
        }
        return object;
    }
}
