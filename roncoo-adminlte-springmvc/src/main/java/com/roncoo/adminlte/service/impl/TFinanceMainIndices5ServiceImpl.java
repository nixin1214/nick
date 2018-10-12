package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFmainIndices5;
import com.roncoo.adminlte.service.TFinanceMainIndices5Service;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.TFinaceMainIndices5Dao;
import com.roncoo.adminlte.util.Tools;
import org.apache.commons.lang.StringUtils;
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
 * Created by lx on 2017/11/10.
 */
@Service
public class TFinanceMainIndices5ServiceImpl implements TFinanceMainIndices5Service {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinaceMainIndices5Dao indices5Dao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insert(TFmainIndices5 obj) {
        return indices5Dao.insert(obj);
    }

    @Override
    public int insertBatch(List<TFmainIndices5> list) {
        return indices5Dao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return indices5Dao.deleteById(id);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        TFmainIndices5 obj = new TFmainIndices5();
        obj.setFhead_id(tfheadid);
        return indices5Dao.deleteByProperty(obj);
    }

    @Override
    public List<TFmainIndices5> queryByProperty(Long fheadid) {
        Map map = new HashMap();
        map.put("fhead_id",fheadid);
        return indices5Dao.queryByProperty(map);
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
                List<TFmainIndices5> indiceList = new ArrayList<TFmainIndices5>();
                int size = rowCount-1;
                for (int r = 2; r < size; r++) { //遍历有数据的行
                    Row row = sheet.getRow(r);
                    if(row!=null){
                        logger.debug("row index: {}", r);
                        String fproject = Tools.getCellValue(row.getCell(0), wb);
                        if (StringUtils.trimToNull(fproject) == null || fproject.startsWith("单位：万元")) {
                            break;
                        }
                        TFmainIndices5 indic = new TFmainIndices5();
                        BigDecimal c1 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(1), wb));
                        BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
                        BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), wb));
                        BigDecimal c4 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4), wb));
                        BigDecimal c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5), wb));
                        BigDecimal c6 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(6), wb));
                        BigDecimal c7 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(7), wb));
                        BigDecimal c8 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(8), wb));
                        BigDecimal c9 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(9), wb));
//                        System.out.println(fproject+" / "+c1+" / "+c2+" / "+c3+" / "+c4+" / "+c5+" / "+c6);
                        indic.setFproject(fproject);
                        indic.setYear_plan(c1);
                        indic.setQ1_done(c2);
                        indic.setQ2_done(c3);
                        indic.setQ3_done(c4);
                        indic.setQ4_done(c5);
                        indic.setYear_done(c6);
                        indic.setYear_done_count(c7);
                        indic.setYear_done_ratio(c8);
                        indic.setYear_done_variance(c9);
                        indic.setFrow_index(r);
                        indiceList.add(indic);
                    }
                    System.out.println();
                }

                Long tfheadId =  mainService.getOrAddFinanceMainId(companyNumber,sheetName,period,rcUser);
                if(tfheadId!=0){
                    for (TFmainIndices5 indic : indiceList) { indic.setFhead_id(tfheadId); }
                    int row = deleteByProperty(tfheadId);
                    System.out.println("删除"+sheetName+"记录表数据：row="+row);
                    int row1 = insertBatch(indiceList);
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
        List<TFmainIndices5> indices = queryByProperty(fheadid);
        if(indices==null || indices.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            String text = JSON.toJSONString(indices);
            object.put("datas", JSONArray.parseArray(text));
            object.put("stateCode", 200);
        }
        return object;
    }
}
