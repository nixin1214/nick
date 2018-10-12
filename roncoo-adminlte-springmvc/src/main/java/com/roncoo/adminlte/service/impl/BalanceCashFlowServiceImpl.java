package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.BalanceCashFlow;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.service.BalanceCashFlowService;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.BalanceCashFlowDao;
import com.roncoo.adminlte.util.IndicesTool;
import com.roncoo.adminlte.util.Tools;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Cell;
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
 * 解析现金流量表
 * Created by lx on 2017/11/11.
 */
@Service
public class BalanceCashFlowServiceImpl implements BalanceCashFlowService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BalanceCashFlowDao balanceCashFlowDao;
    @Autowired
    private TFinanceMainService mainService;

    /**
     * sheet页，需要写入数据的行号,{开始，结束}
     * 从0下标开始计数，包含首尾两行
     */
    private final int[] sheetCellArr = {4,48};

    @Override
    public int insert(BalanceCashFlow obj) {
        return balanceCashFlowDao.insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<BalanceCashFlow> list) {
        return balanceCashFlowDao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return balanceCashFlowDao.deleteById(id);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        BalanceCashFlow obj = new BalanceCashFlow();
        obj.setFhead_id(tfheadid);
        return balanceCashFlowDao.deleteByProperty(obj);
    }

    @Override
    public List<BalanceCashFlow> queryByProperty(Long tfheadid) {
        Map map = new HashMap();
        map.put("fhead_id",tfheadid);
        return balanceCashFlowDao.queryByProperty(map);
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
            if(rowCount==0 ){
                object.put("stateCode", 0);
                object.put("error", "模板为空");
                System.out.println("模板为空");
            }else{
                List<BalanceCashFlow> bslist = new ArrayList<>();
                int size = rowCount;
                for (int r = sheetCellArr[0]; r <= sheetCellArr[1]; r++) {
                    Row row = sheet.getRow(r);
                    if(row!=null){
                        BalanceCashFlow bc = new BalanceCashFlow();
                        String fproject = Tools.getCellValue(row.getCell(0), wb);
                        if (fproject!=null && fproject.contains("单位负责人")){
                            break;
                        }
                        logger.debug("row index: {}", r);
                        String cellValue1 = Tools.getCellValue(row.getCell(1), wb);
                        BigDecimal c1 = Tools.getDecimalCellValue(cellValue1);
                        String cellValue2 = Tools.getCellValue(row.getCell(2), wb);
                        BigDecimal c2 = Tools.getDecimalCellValue(cellValue2);
                        String c3 = Tools.getCellValue(row.getCell(3), wb);
                        String cellValue4 = Tools.getCellValue(row.getCell(4), wb);
                        BigDecimal c4 = Tools.getDecimalCellValue(cellValue4);
                        String cellValue5 = Tools.getCellValue(row.getCell(5), wb);
                        BigDecimal c5 = Tools.getDecimalCellValue(cellValue5);
                        //System.out.println(fproject+" / "+c1+" / "+c2+" / "+c3+" / "+c4+" / "+c5);
                        bc.setFproject(fproject);
                        bc.setFthis_period_cum(c1);
                        bc.setFlast_year_cum(c2);
                        bc.setFother_data(c3);
                        bc.setFthis_period_cum2(c4);
                        bc.setFlast_year_cum2(c5);
                        bc.setFsheet_row_index(r);
                        if(Tools.isRowStrong(8,bc.getFsheet_row_index())){bc.setFis_strong(1);}
                        bslist.add(bc);
                    }
                    System.out.println();
                }
                Long tfheadId = mainService.getOrAddFinanceMainId(companyNumber,sheetName,period,rcUser);
                if(tfheadId!=0){
                    for (BalanceCashFlow bc : bslist) { bc.setFhead_id(tfheadId); }
                    int row = deleteByProperty(tfheadId);
                    System.out.println("删除"+sheetName+"记录表数据：row="+row);
                    int row1 = insertBatch(bslist);
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
        List<BalanceCashFlow> list = queryByProperty(fheadid);
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            for(int i =0;i<list.size();i++) {
                list.get(i).setFthis_period_cum(list.get(i).getFthis_period_cum().divide(new BigDecimal(10000), 0, BigDecimal.ROUND_FLOOR));
                list.get(i).setFlast_year_cum(list.get(i).getFlast_year_cum().divide(new BigDecimal(10000), 0, BigDecimal.ROUND_FLOOR));
                list.get(i).setFthis_period_cum2(list.get(i).getFthis_period_cum2().divide(new BigDecimal(10000), 0, BigDecimal.ROUND_FLOOR));
                list.get(i).setFlast_year_cum2(list.get(i).getFlast_year_cum2().divide(new BigDecimal(10000), 0, BigDecimal.ROUND_FLOOR));
            }
            JSONArray array = IndicesTool.balanceCashFlowToArray(list);
            object.put("datas",array);
            object.put("stateCode", 200);
        }
        return object;
    }

    @Override
    public List<BalanceCashFlow> queryByPropertyAll(List<Long> tfheadids) {
        return balanceCashFlowDao.queryByPropertyAll(tfheadids);
    }

    @Override
    public void exportHandler(Sheet sheet, List<Long> tfheadids){
        List<BalanceCashFlow> indices = queryByPropertyAll(tfheadids);
        if (indices.size() == 0) {
            return;
        }
        //按组织分解结果集
        Map<Long,List<BalanceCashFlow>> resultMap = new HashMap<>();
        for (Long fheadid : tfheadids) {
            List<BalanceCashFlow> item = new ArrayList<>();
            for (BalanceCashFlow balance : indices) {
                if (balance.getFhead_id().equals(fheadid)) {
                    item.add(balance);
                }
            }
            resultMap.put(fheadid,item);
        }
        //将数据写入sheet页
        for (int j = sheetCellArr[0]; j <= sheetCellArr[1]; j++) {//遍历sheet页中的指定行
            Row row = sheet.getRow(j);///获取行对象
            Cell cell_b = row.getCell(1);//获取 B 列对象
            Cell cell_c = row.getCell(2);//获取 C 列对象
            BigDecimal item_b = new BigDecimal("0");
            BigDecimal item_c = new BigDecimal("0");
            for (Long fheadid : tfheadids){//累加
                if((resultMap.get(fheadid).size()>0)){
                    BalanceCashFlow bal = resultMap.get(fheadid).get(j-sheetCellArr[0]);//从0下标开始读取
                    item_b = item_b.add(bal.getFthis_period_cum());//本期累计
                    item_c = item_c.add(bal.getFlast_year_cum());//上年累计
                }
            }
            cell_b.setCellValue(item_b.doubleValue());//写入值
            cell_c.setCellValue(item_c.doubleValue());//写入值
        }
    }
}
