package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFmainIndices3;
import com.roncoo.adminlte.service.TFinanceMainIndices3Service;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.TFinaceMainIndices3Dao;
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
 * Created by lx on 2017/11/9.
 */
@Service
public class TFinanceMainIndices3ServiceImpl implements TFinanceMainIndices3Service {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinaceMainIndices3Dao indices3Dao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insert(TFmainIndices3 obj) {
        return indices3Dao.insert(obj);
    }

    @Override
    public int insertBatch(List<TFmainIndices3> list) {
        return indices3Dao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return indices3Dao.deleteById(id);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        TFmainIndices3 obj = new TFmainIndices3();
        obj.setFhead_id(tfheadid);
        return indices3Dao.deleteByProperty(obj);
    }

    @Override
    public List<TFmainIndices3> queryByProperty(Long fheadid) {
        Map map = new HashMap();
        map.put("fhead_id",fheadid);
        return indices3Dao.queryByProperty(map);
    }

    @Override
    public JSONObject importHandler(Workbook workbook, String sheetName, String companyNumber, String period, RcUser rcUser) {
        Sheet sheet = workbook.getSheet(sheetName);
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
                List<TFmainIndices3> tfislist = new ArrayList<TFmainIndices3>();
                int size = rowCount-1;
                for (int r = 2; r < size; r++) {
                    Row row = sheet.getRow(r);
                    if(row!=null){
                        logger.debug("row index: {}", r);
                        String fproject = Tools.getCellValue(row.getCell(0), workbook);
                        if (StringUtils.trimToNull(fproject) == null || fproject.startsWith("单位：万元")) {
                            break;
                        }
                        TFmainIndices3 indis3 = new TFmainIndices3();
                        BigDecimal c1 =  Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(1), workbook));
                        BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), workbook));
                        BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), workbook));
                        BigDecimal c4 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4), workbook));
                        BigDecimal c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5), workbook));
                        BigDecimal c6 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(6), workbook));
                        BigDecimal c7 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(7), workbook));
                        BigDecimal c8 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(8), workbook));
                        BigDecimal c9 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(9), workbook));
                        BigDecimal c10 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(10), workbook));
                        BigDecimal c11= Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(11), workbook));
                        BigDecimal c12 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(12), workbook));
                        BigDecimal c13 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(13), workbook));
                        BigDecimal c14 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(14), workbook));
                        BigDecimal c15 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(15), workbook));
                        BigDecimal c16 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(16), workbook));
                        BigDecimal c17 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(17), workbook));
                        BigDecimal c18 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(18), workbook));
                        BigDecimal c19 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(19), workbook));
                        BigDecimal c20 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(20), workbook));
                        BigDecimal c21 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(21), workbook));
                        BigDecimal c22 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(22), workbook));
                        BigDecimal c23 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(23), workbook));
                        BigDecimal c24 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(24), workbook));
                        BigDecimal c25 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(25), workbook));
                        BigDecimal c26 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(26), workbook));
                        BigDecimal c27 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(27), workbook));
                        BigDecimal c28 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(28), workbook));
                        BigDecimal c29 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(29), workbook));
                        BigDecimal c30 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(30), workbook));
                        BigDecimal c31 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(31), workbook));
                        BigDecimal c32 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(32), workbook));

                        /*System.out.println(fproject+" / "+c1+" / "+c2+" / "+c3+" / "+c4+" / "+c5+" / "+c6
                                +" / "+c7+" / "+c8+" / "+c9+" / "+c10+" / "+c11+" / "+c12+" / "+c13
                                +" / "+c14+" / "+c15+" / "+c16+" / "+c17+" / "+c18+" / "+c19+" / c20="+c20
                                +" / "+c21+" / "+c22+" / "+c23+" / c24="+c24+" / "+c25+" / "+c26+" / "+c27
                                +" / "+c28+" / "+c29+" / "+c30+" / "+c31+" / "+c32);*/

                        indis3.setFproject(fproject);
                        indis3.setFperoid1(c1);
                        indis3.setFperoid2(c2);
                        indis3.setFperoid3(c3);
                        indis3.setFperoid4(c4);
                        indis3.setFperoid5(c5);
                        indis3.setFperoid6(c6);
                        indis3.setFperoid7(c7);
                        indis3.setFperoid8(c8);
                        indis3.setFperoid9(c9);
                        indis3.setFperoid10(c10);
                        indis3.setFperoid11(c11);
                        indis3.setFperoid12(c12);
                        indis3.setThis_year_count(c13);
                        indis3.setLast_year_count(c14);
                        indis3.setYear_count(c15);
                        indis3.setYear_ratio(c16);
                        indis3.setQ1_this_done(c17);
                        indis3.setQ1_last_done(c18);
                        indis3.setQ1_count(c19);
                        indis3.setQ1_ratio(c20);
                        indis3.setQ2_this_done(c21);
                        indis3.setQ2_last_done(c22);
                        indis3.setQ2_count(c23);
                        indis3.setQ2_ratio(c24);
                        indis3.setQ3_this_done(c25);
                        indis3.setQ3_last_done(c26);
                        indis3.setQ3_count(c27);
                        indis3.setQ3_ratio(c28);
                        indis3.setQ4_this_done(c29);
                        indis3.setQ4_last_done(c30);
                        indis3.setQ4_count(c31);
                        indis3.setQ4_ratio(c32);
                        indis3.setFrow_index(r);
                        tfislist.add(indis3);
                    }
                    System.out.println();
                }
                Long tfheadId =  mainService.getOrAddFinanceMainId(companyNumber,sheetName,period,rcUser);
                if(tfheadId!=0){
                    for (TFmainIndices3 indic : tfislist) { indic.setFhead_id(tfheadId); }
                    //删除表中对应的数据
                    int row2 = deleteByProperty(tfheadId);
                    System.out.println("删除"+sheetName+"记录表中的记录数据：row2="+row2);
                    //添加列表数据到数据库中
                    int row3 = insertBatch(tfislist);
                    System.out.println("批量插入"+sheetName+"数据：row3="+row3);
                    //查询列表并返回页面
                    object = queryByHeadId(tfheadId);
                }else{
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
        List<TFmainIndices3> indices = queryByProperty(fheadid);
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
