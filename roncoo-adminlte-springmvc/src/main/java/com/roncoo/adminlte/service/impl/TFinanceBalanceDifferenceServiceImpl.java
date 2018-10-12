package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceBalanceDifference;
import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.service.TFinanceBalanceDifferenceService;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.TFinanceBalanceDifferenceDao;
import com.roncoo.adminlte.util.Tools;
import org.apache.ibatis.annotations.Param;
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
 * Created by Andrew on 2017/11/11.
 */
@Service
public class TFinanceBalanceDifferenceServiceImpl implements TFinanceBalanceDifferenceService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinanceBalanceDifferenceDao TFinanceBalanceDifferenceDao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insert(TFinanceBalanceDifference obj) {
        return TFinanceBalanceDifferenceDao.insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<TFinanceBalanceDifference> list) {
        return TFinanceBalanceDifferenceDao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return TFinanceBalanceDifferenceDao.deleteById(id);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        return TFinanceBalanceDifferenceDao.deleteByHeadId(tfheadid);
    }

    @Override
    public JSONObject queryByHeadId(Long headId) {
        List<TFinanceBalanceDifference> list = TFinanceBalanceDifferenceDao.queryByHeadId(headId);

        JSONObject object = new JSONObject();
        if (list == null || list.isEmpty()) {
            object.put("error", "暂无数据");
            object.put("stateCode", 0);
        } else {
            String text = JSON.toJSONString(list);
            object.put("datas", JSONArray.parseArray(text));
            object.put("stateCode", 200);
        }
        return object;
    }

    public JSONObject importHandler(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser) {
        Sheet sheet = wb.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();
        List<TFinanceBalanceDifference> bslist = new ArrayList<>();
        JSONObject object = new JSONObject();
        logger.debug("行数 rowCount={}", rowCount);
        if (rowCount == 0 || rowCount < 69) {
            object.put("stateCode", 0);
            object.put("error", "导入的模板数据有误");
            logger.error("导入的模板数据有误");
        } else {
            for (int r = 4; r < 69; r++) { //遍历有数据的行
                Row row = sheet.getRow(r);
                if (row != null) {
                    logger.debug("row index: {}", r);
                    TFinanceBalanceDifference bs = new TFinanceBalanceDifference();
                    String project = Tools.getCellValue(row.getCell(0), wb);
                    Integer c1 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(1), wb)).intValue();
                    String cellValue2 = Tools.getCellValue(row.getCell(2), wb);
                    BigDecimal c2 = Tools.getDecimalCellValue(cellValue2);
                    String cellValue3 = Tools.getCellValue(row.getCell(3), wb);
                    BigDecimal c3 = Tools.getDecimalCellValue(cellValue3);
                    String c4 = Tools.getCellValue(row.getCell(4), wb);
                    Integer c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5), wb)).intValue();
                    String cellValue6 = Tools.getCellValue(row.getCell(6), wb);
                    BigDecimal c6 = Tools.getDecimalCellValue(cellValue6);
                    String cellValue7 = Tools.getCellValue(row.getCell(7), wb);
                    BigDecimal c7 = Tools.getDecimalCellValue(cellValue7);

                    bs.setFproject(project);
                    bs.setFrowNum(c1);
                    bs.setPeriodBeginAccount(c2);
                    bs.setPeriodEndAccount(c3);
                    bs.setFproject2(c4);
                    bs.setFrowNum2(c5);
                    bs.setPeriodBeginAccount2(c6);
                    bs.setPeriodEndAccount2(c7);
                    bs.setFrowIndex(r);
                    bslist.add(bs);
                }
            }

            TFinanceMain mainIndic = mainService.selectByProperty(companyNumber, period, sheetName);
            Long headId;
            if (mainIndic != null && mainIndic.getFid() != 0) {
                logger.info("主要记录表有导入记录");
                headId = mainIndic.getFid();
            } else {
                logger.info("主要记录表有导入记录");
                headId = mainService.addFinanceMain(companyNumber, sheetName, period, rcUser);
            }
            if (headId != 0) {
                for (TFinanceBalanceDifference bs : bslist) {
                    bs.setFheadId(headId);
                }
                int row = deleteByProperty(headId);
                logger.debug("删除{}记录表数据：row={}", sheetName, row);
                int row1 = insertBatch(bslist);
                logger.debug("插入{}记录表数据：row1={}", sheetName, row1);
                //查询主列表并返回页面
                object = queryByHeadId(headId);
            } else {
                logger.info("主导入记录新增失败");
                object.put("error", "主导入记录新增失败");
                object.put("stateCode", 0);
            }
        }
        return object;
    }
}
