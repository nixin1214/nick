package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.FinanceMainBusinessDetialTotal;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.service.BalanceMainBusinessDetailTotalService;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessDetailTotalDao;
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
 * 解析主营业务收支明细(累计)
 * Created by lx on 2017/11/15.
 */
@Service
public class BalanceMainBusinessDetailTotalServiceImpl implements BalanceMainBusinessDetailTotalService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BalanceMainBusinessDetailTotalDao businessDetailTotalDao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insertBatch(@Param("list") List<FinanceMainBusinessDetialTotal> list) {
        return businessDetailTotalDao.insertBatch(list);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        FinanceMainBusinessDetialTotal obj = new FinanceMainBusinessDetialTotal();
        obj.setFhead_id(tfheadid);
        return businessDetailTotalDao.deleteByProperty(obj);
    }

    @Override
    public List<FinanceMainBusinessDetialTotal> queryByProperty(Long tfheadid) {
        Map map = new HashMap();
        map.put("fhead_id",tfheadid);
        return businessDetailTotalDao.queryByProperty(map);
    }

    @Override
    public JSONObject importHandler(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser) {
        Sheet sheet = wb.getSheet(sheetName);
        JSONObject object = new JSONObject();
        if (sheet!=null){
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("行数 rowCount="+rowCount);
            if(rowCount==0){
                object.put("stateCode", 0);
                object.put("error", "模板没有数据");
                System.out.println("模板没有数据");
            }else{
                List<FinanceMainBusinessDetialTotal> bslist = new ArrayList<>();
                int size = rowCount;
                for (int r = 5; r < size; r++) {
                    Row row = sheet.getRow(r);
                    if(row!=null){
                        String rowNum = Tools.getCellValue(row.getCell(0), wb);
                        if(rowNum==""){
                            rowNum = "-";
                        }
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
                        FinanceMainBusinessDetialTotal bc = new FinanceMainBusinessDetialTotal();
                        BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
                        BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), wb));
                        BigDecimal c4 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4), wb));
                        BigDecimal c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5), wb));
                        BigDecimal c6 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(6), wb));
                        BigDecimal c7 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(7), wb));
                        BigDecimal c8 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(8), wb));
                        BigDecimal c9 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(9), wb));
                        BigDecimal c10 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(10), wb));

//                        System.out.println("rowNum="+rowNum+" / fproject="+fproject+" / c2="+c2+" / "+c3+" / "+c4+" / "+c5+" / "+c6+" / "+c7+" / "+c8+" / "+
//                                c9+" / "+c10);

                        bc.setFrow_num(Tools.getRowNumIntString(rowNum));
                        bc.setFproject(fproject);
                        bc.setSales_volume(c2);
                        bc.setSelling_unit_price(c3);
                        bc.setSelling_amont(c4);
                        bc.setCost_unit(c5);
                        bc.setCost_last_month(c6);
                        bc.setCost_amont(c7);
                        bc.setSale_profit_unit(c8);
                        bc.setSale_profit_count(c9);
                        bc.setSale_profit_ratio(c10);
                        bc.setFrow_index(r);
                        if (Tools.isRowStrong(11,r)){
                            bc.setFstrong(1);
                        }
                        bslist.add(bc);
                    }
                    System.out.println();
                }
                Long tfheadId = mainService.getOrAddFinanceMainId(companyNumber,sheetName,period,rcUser);;
                if(tfheadId!=0){
                    bslist.forEach(bc -> bc.setFhead_id(tfheadId));
                    int row = deleteByProperty(tfheadId);
                    System.out.println("删除"+sheetName+"记录表数据：row="+row);
                    int row1 = insertBatch(bslist);
                    System.out.println("批量插入"+sheetName+"模板数据，影响行数 row1="+row1);
                    //查询主列表并返回页面
                    object = queryByHeadId(tfheadId);
                }else{
                    object.put("error","新增导入记录失败");
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
        List<FinanceMainBusinessDetialTotal> list = queryByProperty(fheadid);
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            for (int i = 0; i <list.size(); i++) {
                list.get(i).setSales_volume(list.get(i).getSales_volume().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSelling_unit_price(list.get(i).getSelling_unit_price().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSelling_amont(list.get(i).getSelling_amont().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setCost_unit(list.get(i).getCost_unit().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setCost_last_month(list.get(i).getCost_last_month().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setCost_amont(list.get(i).getCost_amont().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSale_profit_unit(list.get(i).getSale_profit_unit().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSale_profit_count(list.get(i).getSale_profit_count().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setSale_profit_ratio(list.get(i).getSale_profit_ratio().divide(new BigDecimal(1),2,BigDecimal.ROUND_FLOOR));
            }
            JSONArray array = IndicesTool.balanceMainBusinessDetialTotalToArray(list);
            object.put("datas",array);
            object.put("stateCode", 200);
        }
        return object;
    }
}
