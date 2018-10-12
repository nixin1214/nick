package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFmainIndices2;
import com.roncoo.adminlte.service.TFinanceMainIndices2Service;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.TFinaceMainIndices2Dao;
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
 * Created by lx on 2017/11/3.
 */
@Service
public class TFinanceMainIndices2ServiceImpl implements TFinanceMainIndices2Service {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinaceMainIndices2Dao tFinaceMainIndices2Dao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insert(TFmainIndices2 t) {
        return tFinaceMainIndices2Dao.insert(t);
    }

    @Override
    public int insertBatch(List<TFmainIndices2> list) {
        return tFinaceMainIndices2Dao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return tFinaceMainIndices2Dao.deleteById(id);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        TFmainIndices2 tFmainIndices2 = new TFmainIndices2();
        tFmainIndices2.setFhead_id(tfheadid);
        return tFinaceMainIndices2Dao.deleteByProperty(tFmainIndices2);
    }

    @Override
    public List<TFmainIndices2> queryByProperty(Long fheadid) {
        Map map = new HashMap();
        map.put("fhead_id",fheadid);
        return tFinaceMainIndices2Dao.queryByProperty(map);
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
                //具体解析过程
                List<TFmainIndices2> tfislist = new ArrayList<TFmainIndices2>();
                int size = rowCount-1;
                for (int r = 3; r < size; r++) {
                    Row row = sheet.getRow(r);
                    if(row!=null){
                        logger.debug("row index: {}", r);
                        String fproject = Tools.getCellValue(row.getCell(0), workbook);
                        if (StringUtils.trimToNull(fproject) == null) {
                            break;
                        }
                        BigDecimal c1 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(1), workbook));
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
                        BigDecimal c33 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(33), workbook));
                        BigDecimal c34 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(34), workbook));
                        BigDecimal c35 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(35), workbook));
                        BigDecimal c36 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(36), workbook));
                        BigDecimal c37 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(37), workbook));
                        BigDecimal c38 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(38), workbook));
                        BigDecimal c39 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(39), workbook));
                        BigDecimal c40 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(40), workbook));
                        BigDecimal c41 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(41), workbook));
                        BigDecimal c42 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(42), workbook));
                        BigDecimal c43 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(43), workbook));
                        BigDecimal c44 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(44), workbook));
                        String c45 = Tools.getCellValue(row.getCell(45), workbook);
                        /*System.out.println(fproject+" / "+c1+" / "+c2+" / "+c3+" / "+c4+" / "+c5+" / "+c6
                                +" / "+c7+" / "+c8+" / "+c9+" / "+c10+" / "+c11+" / "+c12+" / "+c13
                                +" / "+c14+" / "+c15+" / "+c16+" / "+c17+" / "+c18+" / "+c19+" / c20="+c20
                                +" / "+c21+" / "+c22+" / "+c23+" / c24="+c24+" / "+c25+" / "+c26+" / "+c27
                                +" / "+c28+" / "+c29+" / "+c30+" / "+c31+" / "+c32+" / "+c33+" / "+c34
                                +" / "+c35+" / "+c36+" / "+c37+" / "+c38+" / "+c39+" / "+c40+" / "+c41
                                +" / "+c42+" / "+c43+" / "+c44+" / "+c45);*/
                        TFmainIndices2 tfi2 = new TFmainIndices2();
                        tfi2.setFproject(fproject);
                        tfi2.setBudget1(c1);
                        tfi2.setActual1(c2);
                        tfi2.setBudget2(c3);
                        tfi2.setActual2(c4);
                        tfi2.setBudget3(c5);
                        tfi2.setActual3(c6);
                        tfi2.setBudget4(c7);
                        tfi2.setActual4(c8);
                        tfi2.setBudget5(c9);
                        tfi2.setActual5(c10);
                        tfi2.setBudget6(c11);
                        tfi2.setActual6(c12);
                        tfi2.setBudget7(c13);
                        tfi2.setActual7(c14);
                        tfi2.setBudget8(c15);
                        tfi2.setActual8(c16);
                        tfi2.setBudget9(c17);
                        tfi2.setActual9(c18);
                        tfi2.setBudget10(c19);
                        tfi2.setActual10(c20);
                        tfi2.setBudget11(c21);
                        tfi2.setActual11(c22);
                        tfi2.setBudget12(c23);
                        tfi2.setActual12(c24);
                        tfi2.setQ1_aim(c25);
                        tfi2.setQ1_done(c26);
                        tfi2.setQ1_done_ratio(c27);
                        tfi2.setQ1_cost_ratio(c28);
                        tfi2.setQ2_aim(c29);
                        tfi2.setQ2_done(c30);
                        tfi2.setQ2_done_ratio(c31);
                        tfi2.setQ2_cost_ratio(c32);
                        tfi2.setQ3_aim(c33);
                        tfi2.setQ3_done(c34);
                        tfi2.setQ3_done_ratio(c35);
                        tfi2.setQ3_cost_ratio(c36);
                        tfi2.setQ4_aim(c37);
                        tfi2.setQ4_done(c38);
                        tfi2.setQ4_done_ratio(c39);
                        tfi2.setQ4_cost_ratio(c40);
                        tfi2.setY_aim(c41);
                        tfi2.setY_done(c42);
                        tfi2.setY_done_ratio(c43);
                        tfi2.setY_cost_ratio(c44);
                        tfi2.setFinace_warrning(c45);
                        tfi2.setFrow_index(r);
                        tfislist.add(tfi2);
                    }
                    System.out.println();
                }

                Long tfheadId = mainService.getOrAddFinanceMainId(companyNumber, sheetName, period, rcUser);
                if(tfheadId!=0){
                    for (TFmainIndices2 tfi : tfislist) {
                        tfi.setFhead_id(tfheadId);
                    }
                    int row2 = deleteByProperty(tfheadId);
                    System.out.println("删除主要指标2记录表中的记录数据：row2="+row2);
                    int row3 = insertBatch(tfislist);
                    System.out.println("批量插入主要指标2数据：row3="+row3);
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
        List<TFmainIndices2> indices = queryByProperty(fheadid);
        if(indices==null || indices.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            String text = JSON.toJSONString(indices);
            object.put("datas",JSONArray.parseArray(text));
            object.put("stateCode", 200);
        }
        return object;
    }
}
