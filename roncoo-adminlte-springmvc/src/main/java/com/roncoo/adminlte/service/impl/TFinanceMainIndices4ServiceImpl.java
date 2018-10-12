package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFmainIndices4;
import com.roncoo.adminlte.service.TFinanceMainIndices4Service;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.TFinaceMainIndices4Dao;
import com.roncoo.adminlte.service.impl.dao.impl.TFinaceMainIndices4DaoImpl;
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
public class TFinanceMainIndices4ServiceImpl implements TFinanceMainIndices4Service {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinaceMainIndices4Dao mainIndices4Dao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insert(TFmainIndices4 obj) {
        return mainIndices4Dao.insert(obj);
    }

    @Override
    public int insertBatch(List<TFmainIndices4> list) {
        return mainIndices4Dao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mainIndices4Dao.deleteById(id);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        TFmainIndices4 obj = new TFmainIndices4();
        obj.setFhead_id(tfheadid);
        return mainIndices4Dao.deleteByProperty(obj);
    }

    @Override
    public List<TFmainIndices4> queryByProperty(Long fheadid) {
        Map map = new HashMap();
        map.put("fhead_id",fheadid);
        return mainIndices4Dao.queryByProperty(map);
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
                List<TFmainIndices4> indiceList = new ArrayList<TFmainIndices4>();
                int size = rowCount-1;
                for (int r = 2; r < size; r++) {
                    Row row = sheet.getRow(r);
                    if(row!=null){
                        logger.debug("row index: {}", r);
                        String fproject = Tools.getCellValue(row.getCell(0), wb);
                        if (StringUtils.trimToNull(fproject) == null || fproject.startsWith("单位：万元")) {
                            break;
                        }
                        TFmainIndices4 indic = new TFmainIndices4();
                        BigDecimal c1 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(1), wb));
                        String c2 = Tools.getCellValue(row.getCell(2), wb);
                        BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), wb));
                        BigDecimal c4 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4), wb));
                        BigDecimal c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5), wb));
                        String c6 = Tools.getCellValue(row.getCell(6), wb);
                        BigDecimal c7 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(7), wb));
                        BigDecimal c8 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(8), wb));
                        BigDecimal c9 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(9), wb));
                        String c10 = Tools.getCellValue(row.getCell(10), wb);
                        BigDecimal c11= Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(11), wb));
                        BigDecimal c12 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(12), wb));
                        BigDecimal c13 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(13), wb));
                        String c14 = Tools.getCellValue(row.getCell(14), wb);
                        BigDecimal c15 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(15), wb));
                        BigDecimal c16 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(16), wb));
                        BigDecimal c17 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(17), wb));
                        String c18 = Tools.getCellValue(row.getCell(18), wb);
                        BigDecimal c19 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(19), wb));
                        BigDecimal c20 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(20), wb));

//                        System.out.println(fproject+" / "+c1+" / "+c2+" / "+c3+" / "+c4+" / "+c5+" / "+c6
//                                +" / "+c7+" / "+c8+" / "+c9+" / "+c10+" / "+c11+" / "+c12+" / "+c13
//                                +" / "+c14+" / "+c15+" / c16="+c16+" / "+c17+" / "+c18+" / "+c19+" / c20="+c20);

                        indic.setFproject(fproject);
                        indic.setFrow_index(r);
                        indic.setYear_flag_mine(c1);
                        indic.setYear_flag_company(c2);
                        indic.setYear_flag_cost_ratio(c3);
                        indic.setYear_flag_variance(c4);
                        indic.setQ1_flag_mine(c5);
                        indic.setQ1_flag_company(c6);
                        indic.setQ1_flag_cost_ratio(c7);
                        indic.setQ1_flag_variance(c8);
                        indic.setQ2_flag_mine(c9);
                        indic.setQ2_flag_company(c10);
                        indic.setQ2_flag_cost_ratio(c11);
                        indic.setQ2_flag_variance(c12);
                        indic.setQ3_flag_mine(c13);
                        indic.setQ3_flag_company(c14);
                        indic.setQ3_flag_cost_ratio(c15);
                        indic.setQ3_flag_variance(c16);
                        indic.setQ4_flag_mine(c17);
                        indic.setQ4_flag_company(c18);
                        indic.setQ4_flag_cost_ratio(c19);
                        indic.setQ4_flag_variance(c20);
                        indic.setFrow_index(r);
                        indiceList.add(indic);
                    }
                    System.out.println();
                }

                Long tfheadId =  mainService.getOrAddFinanceMainId(companyNumber,sheetName,period,rcUser);
                if(tfheadId!=0){
                    for (TFmainIndices4 indic : indiceList) {
                        indic.setFhead_id(tfheadId);
                    }
                    //删除上次导入数据
                    int row1 = deleteByProperty(tfheadId);
                    System.out.println("删除"+sheetName+"记录表中的记录数据：row1="+row1);
                    //添加新数据
                    int row2 = insertBatch(indiceList);
                    System.out.println("批量插入"+sheetName+"数据：row2="+row2);
                    //查询列表并返回页面
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
        List<TFmainIndices4> indices = queryByProperty(fheadid);
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
