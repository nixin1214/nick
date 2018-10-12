package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.FinanceMainBusinessDetialMonth;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.service.BalanceMainBusinessDetailMonthService;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessDetailMonthDao;
import com.roncoo.adminlte.util.IndicesTool;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析主营业务收支明细(本月)
 * Created by lx on 2017/11/15.
 */
@Service
public class BalanceMainBusinessDetailMonthServiceImpl implements BalanceMainBusinessDetailMonthService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BalanceMainBusinessDetailMonthDao businessDetailMonthDao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insertBatch(@Param("list") List<FinanceMainBusinessDetialMonth> list) {
        return businessDetailMonthDao.insertBatch(list);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        FinanceMainBusinessDetialMonth obj = new FinanceMainBusinessDetialMonth();
        obj.setFhead_id(tfheadid);
        return businessDetailMonthDao.deleteByProperty(obj);
    }

    @Override
    public List<FinanceMainBusinessDetialMonth> queryByProperty(Long tfheadid) {
        Map map = new HashMap();
        map.put("fhead_id",tfheadid);
        return businessDetailMonthDao.queryByProperty(map);
    }

    @Override
    public JSONObject importHandler(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser) {
        Sheet sheet = wb.getSheet(sheetName);
        JSONObject object = new JSONObject();
        if(sheet!=null){
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("行数 rowCount="+rowCount);
            if(rowCount==0){
                object.put("stateCode", 0);
                object.put("error", "模板为空");
                System.out.println("模板为空");
            }else{
                List<FinanceMainBusinessDetialMonth> bslist = new ArrayList<>();
                int size = rowCount;
                for (int r = 5; r < size; r++) {
                    Row row = sheet.getRow(r);
                    if(row!=null){
                        String rowNum = Tools.getCellValue(row.getCell(0), wb);
                        if (rowNum!=null && rowNum.contains("单位负责人")){
                            break;
                        }
                        String fproject = Tools.getCellValue(row.getCell(1), wb);
                        if(fproject==""){
                            fproject = "-";
                        }
                        if (fproject!=null && fproject.contains("单位负责人")){
                            break;
                        }
                        logger.debug("row index: {}", r);
                        FinanceMainBusinessDetialMonth bc = new FinanceMainBusinessDetialMonth();
                        BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
                        BigDecimal c3 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(3), wb));
                        BigDecimal c4 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(4), wb));
                        BigDecimal c5 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(5), wb));
                        BigDecimal c6 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(6), wb));
                        BigDecimal c7 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(7), wb));
                        BigDecimal c8 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(8), wb));
                        BigDecimal c9 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(9), wb));

//                        System.out.println("rowNum="+rowNum+" / fproject="+fproject+" / c2="+c2+" / "+c3+" / "+c4+" / "+c5+" / "+c6+" / "+c7+" / "+c8+" / "+
//                                c9);

                        bc.setFrow_num(Tools.getRowNumIntString(rowNum));
                        bc.setFproject(fproject);
                        bc.setSales_volume(c2);
                        bc.setSelling_unit_price(c3);
                        bc.setSelling_amont(c4);
                        bc.setCost_unit(c5);
                        bc.setCost_amont(c6);
                        bc.setSale_profit_unit(c7);
                        bc.setSale_profit_count(c8);
                        bc.setSale_profit_ratio(c9);
                        bc.setFrow_index(r);
                        if (Tools.isRowStrong(11,r)){ bc.setFstrong(1); }
                        bslist.add(bc);
                    }
                    System.out.println();
                }

                Long tfheadId = mainService.getOrAddFinanceMainId(companyNumber,sheetName,period,rcUser);
                if(tfheadId!=0){
                    bslist.forEach(bc -> bc.setFhead_id(tfheadId));
                    int row = deleteByProperty(tfheadId);
                    System.out.println("删除"+sheetName+"记录表数据：row="+row);
                    int row1 = insertBatch(bslist);
                    System.out.println("批量插入"+sheetName+"模板数据，影响行数 row1="+row1);
                    //查询主列表并返回页面
                    object = queryByHeadId(tfheadId);
                }else{
                    object.put("error","导入记录新增失败");
                    object.put("stateCode",0);
                }
            }
        }else{
            object.put("stateCode", 0);
            object.put("error", "模板为空");
        }
        return object;
    }

    @Override
    public JSONObject queryByHeadId(Long fheadid) {
        JSONObject object = new JSONObject();
        List<FinanceMainBusinessDetialMonth> list = queryByProperty(fheadid);
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            for (int i = 0; i <list.size(); i++) {
                list.get(i).setSales_volume(list.get(i).getSales_volume().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSelling_unit_price(list.get(i).getSelling_unit_price().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSelling_amont(list.get(i).getSelling_amont().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setCost_unit(list.get(i).getCost_unit().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setCost_amont(list.get(i).getCost_amont().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSale_profit_unit(list.get(i).getSale_profit_unit().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSale_profit_count(list.get(i).getSale_profit_count().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSale_profit_ratio(list.get(i).getSale_profit_ratio().divide(new BigDecimal(1),2,BigDecimal.ROUND_FLOOR));
            }
            JSONArray array = IndicesTool.balanceMainBusinessDetailMonthToArray(list);
            object.put("datas",array);
            object.put("stateCode", 200);
        }
        return object;
    }
}
