package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceMainIndices;
import com.roncoo.adminlte.service.TFinanceMainIndicesService;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.TFinaceMainIndicesDao;
import com.roncoo.adminlte.util.IndicesTool;
import com.roncoo.adminlte.util.Tools;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
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
 * Created by lx on 2017/11/1.
 */
@Service
public class TFinanceMainIndicesServiceImpl implements TFinanceMainIndicesService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinaceMainIndicesDao tFinaceMainIndicesDao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insert(TFinanceMainIndices tFinanceMainIndices) {
        return tFinaceMainIndicesDao.insert(tFinanceMainIndices);
    }

    @Override
    public int insertBatch(List<TFinanceMainIndices> list) {
        return tFinaceMainIndicesDao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return tFinaceMainIndicesDao.deleteById(id);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        TFinanceMainIndices tFinanceMainIndices = new TFinanceMainIndices();
        tFinanceMainIndices.setFhead_id(tfheadid);
        return tFinaceMainIndicesDao.deleteByProperty(tFinanceMainIndices);
    }

    @Override
    public List<TFinanceMainIndices> queryByProperty(List<Long> fheadid) {
        Map map = new HashMap();
        map.put("fhead_id",fheadid);
        return tFinaceMainIndicesDao.queryByProperty(map);
    }

    @Override
    public int update(TFinanceMainIndices tFinanceMainIndices) {
        return tFinaceMainIndicesDao.update(tFinanceMainIndices);
    }

    /**
     * 导入主要指标1 sheet页数据
     * @param wb excel对象
     * @param sheetName sheet页名称
     * @param companyNumber 公司编码
     * @param period 期间
     * @param rcUser 操作用户
     * @return
     */
    @Override
    public JSONObject importHandler(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser) {
        Sheet sheet = wb.getSheet(sheetName);
        JSONObject object = new JSONObject();
        if (sheet == null) {
            object.put("stateCode", 0);
            object.put("error", "模板为空");
        } else {
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("行数 rowCount=" + rowCount);
            if (rowCount == 0) {
                object.put("stateCode", 0);
                object.put("error", "模板为空");
            } else {
                //第一步：解析excel
                List<TFinanceMainIndices> tfis = new ArrayList<TFinanceMainIndices>();
                int size = rowCount;
                for (int r = 5; r < size; r++) {
                    Row row = sheet.getRow(r);
                    if (row != null) {
                        String c0 = Tools.getCellValue(row.getCell(0), wb);//分类
                        if (c0 != null && c0.contains("单位负责人")) {
                            break;
                        }
                        String c1 = Tools.getCellValue(row.getCell(1), wb);//项目
                        if (c1 != null && c1.contains("单位负责人")) {
                            break;
                        }
                        logger.debug("row index: {}", r);
                        String cellValue = Tools.getCellValue(row.getCell(2), wb);
                        int c2 = Integer.parseInt(Tools.getRowNumIntString(cellValue));//行次
                        BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), wb));//本期预算(2017 的为预算,2018 的为上年)
                        BigDecimal c4 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4), wb));//本期上年(2017 的为上年,2018 的为预算)
                        BigDecimal c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5), wb));//本期实际
                        BigDecimal c6 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(6), wb));//累计预算(2017 的为预算,2018 的为上年)
                        BigDecimal c7 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(7), wb));//累计上年(2017 的为上年,2018 的为预算)
                        BigDecimal c8 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(8), wb));//累计实际

                        TFinanceMainIndices tfi = new TFinanceMainIndices();
                        tfi.setFcategory(c0);
                        tfi.setFproject(c1);
                        tfi.setFrow_index(c2);
                        tfi.setFthis_period_budget(c3);
                        tfi.setFthis_period_last_year(c4);
                        tfi.setFthis_period_actual(c5);
                        tfi.setFcum_budget(c6);
                        tfi.setFcum_last_year(c7);
                        tfi.setFcum_actual(c8);
                        tfi.setFsheet_row_index(r);
                        if (Tools.isRowStrong(1, tfi.getFrow_index())) {
                            tfi.setFis_strong(1);
                        }
                        tfis.add(tfi);
                    }
                }
                //第二步 解析数据入库
                Long tfheadId = mainService.getOrAddFinanceMainId(companyNumber, sheetName, period, rcUser);
                if (tfheadId != 0) {
                    for (TFinanceMainIndices tfi : tfis) {
                        tfi.setFhead_id(tfheadId);
                    }
                    //删除历史数据
                    int row2 = deleteByProperty(tfheadId);
                    System.out.println("删除主要指标1记录表中的记录数据：row2=" + row2);
                    //添加列表数据到数据库中
                    int row3 = insertBatch(tfis);
                    System.out.println("批量插入主要指标数据：row3=" + row3);
                    //查询主导入的记录表并组装JSON数据返回
                    object = queryByHeadId(tfheadId);
                }
            }
        }
        return object;
    }

    @Override
    public JSONObject queryByHeadId(Long fheadid) {
        JSONObject object = new JSONObject();
        List<Long> fheadids = new ArrayList<>();
        fheadids.add(fheadid);
        List<TFinanceMainIndices> indices = queryByProperty(fheadids);
        if(indices==null || indices.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            JSONArray array = IndicesTool.listToJsonArray(indices);
            object.put("datas",array);
            object.put("stateCode", 200);
        }
        return object;
    }

    /**
     * 合并导出查询
     * @param fhead_ids
     * @return
     */
    @Override
    public void queryByMonth(Workbook wb,List<Long> fhead_ids,Map<Long,String> map,String fileName) {
        List<TFinanceMainIndices> indices = queryByProperty(fhead_ids);
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);//设置内容水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//设置内容垂直居中
        cellStyle.setBorderTop(BorderStyle.THIN);//设置单元格边框
        cellStyle.setBorderLeft(BorderStyle.THIN);//设置单元格边框
        cellStyle.setBorderRight(BorderStyle.THIN);//设置单元格边框
        cellStyle.setBorderBottom(BorderStyle.THIN);//设置单元格边框
        for (int n = 4; n < 6; n++) {
            Sheet sheet = wb.getSheetAt(n);
            for (int i = 3; i <= 4; i++) {
                Row projectRow = sheet.getRow(i);
                if (i==3){
                    int j = 0;
                    CellRangeAddress region = null;//合并单元格
                    //向表中写入数据
                    for (int k = 0; k < fhead_ids.size(); k++) {
                        if (!map.get(fhead_ids.get(k)).equals("XNZZ")&&!map.get(fhead_ids.get(k)).equals("TYRY")) {
                            switch (map.get(fhead_ids.get(k))) {
                                case "ZKRY":
                                    Cell cell1 = projectRow.createCell((j + 1) * 3);
                                    cell1.setCellStyle(cellStyle);
                                    cell1.setCellValue("中垦本部");
                                    //合并单元格
                                    region = new CellRangeAddress(3,3,(j + 1) * 3,(j + 1) * 3+2);
                                    sheet.addMergedRegion(region);
                                    //添加公司数据
                                    addRowData(indices,sheet,map,j,"ZKRY",n,cellStyle);
                                    break;
                                case "HSMRY":
                                    Cell cell2 = projectRow.createCell((j + 1) * 3);
                                    cell2.setCellStyle(cellStyle);
                                    cell2.setCellValue("华山牧乳业");
                                    region = new CellRangeAddress(3,3,(j + 1) * 3,(j + 1) * 3+2);
                                    sheet.addMergedRegion(region);
                                    addRowData(indices,sheet,map,j,"HSMRY",n,cellStyle);
                                    break;
                                case "TNMC":
                                    Cell cell3 = projectRow.createCell((j + 1) * 3);
                                    cell3.setCellStyle(cellStyle);
                                    cell3.setCellValue("天宁牧场");
                                    region = new CellRangeAddress(3,3,(j + 1) * 3,(j + 1) * 3+2);
                                    sheet.addMergedRegion(region);
                                    addRowData(indices,sheet,map,j,"TNMC",n,cellStyle);
                                    break;
                                case "HSMC":
                                    Cell cell4 = projectRow.createCell((j + 1) * 3);
                                    cell4.setCellStyle(cellStyle);
                                    cell4.setCellValue("华山牧场");
                                    region = new CellRangeAddress(3,3,(j + 1) * 3,(j + 1) * 3+2);
                                    sheet.addMergedRegion(region);
                                    addRowData(indices,sheet,map,j,"HSMC",n,cellStyle);
                                    break;
                                case "ZKGYL":
                                    Cell cell5 = projectRow.createCell((j + 1) * 3);
                                    cell5.setCellStyle(cellStyle);
                                    cell5.setCellValue("中垦供应链");
                                    region = new CellRangeAddress(3,3,(j + 1) * 3,(j + 1) * 3+2);
                                    sheet.addMergedRegion(region);
                                    addRowData(indices,sheet,map,j,"ZKGYL",n,cellStyle);
                                    break;
                            }
                            j++;
                        }
                    }
                    Cell cell6 = projectRow.createCell((j+1)*3);
                    cell6.setCellStyle(cellStyle);
                    region = new CellRangeAddress(3,3,(j + 1) * 3,(j + 1) * 3+2);
                    sheet.addMergedRegion(region);
                    cell6.setCellValue("考核小计");
                    //添加考核小计数据
                    for (int l = 5; l < 38; l++) {
                        Row dataRow = sheet.getRow(l);
                        Cell cell_budget = dataRow.createCell((j + 1) * 3);//获取预算列对象
                        Cell cell_lastYear = dataRow.createCell((j + 1) * 3+1);//获取上年列对象
                        Cell cell_actual = dataRow.createCell((j + 1) * 3+2);//获取实际列对象
                        cell_budget.setCellStyle(cellStyle);
                        cell_lastYear.setCellStyle(cellStyle);
                        cell_actual.setCellStyle(cellStyle);
                        BigDecimal item_budget = new BigDecimal("0");
                        BigDecimal item_lastYear = new BigDecimal("0");
                        BigDecimal item_actual = new BigDecimal("0");
                        for (int k = 0; k < indices.size(); k++) {
                            if (!map.get(indices.get(k).getFhead_id()).equals("XNZZ")&&!map.get(indices.get(k).getFhead_id()).equals("TYRY")){
                                if (indices.get(k).getFsheet_row_index()==l) {
                                    if (n==4) {
                                        item_budget = item_budget.add(indices.get(k).getFthis_period_budget());
                                        item_lastYear = item_lastYear.add(indices.get(k).getFthis_period_last_year());
                                        item_actual = item_actual.add(indices.get(k).getFthis_period_actual());
                                    }else {
                                        item_budget = item_budget.add(indices.get(k).getFcum_budget());
                                        item_lastYear = item_lastYear.add(indices.get(k).getFcum_last_year());
                                        item_actual = item_actual.add(indices.get(k).getFcum_actual());
                                    }
                                }
                            }
                        }
                        cell_budget.setCellValue(item_budget.doubleValue());
                        cell_lastYear.setCellValue(item_lastYear.doubleValue());
                        cell_actual.setCellValue(item_actual.doubleValue());
                    }
                    boolean boo = true;
                    for (String value:map.values()) {
                        if (value.equals("TYRY")){
                            Cell cell7 = projectRow.createCell((j+2)*3);
                            cell7.setCellStyle(cellStyle);
                            region = new CellRangeAddress(3,3,(j + 2) * 3,(j + 2) * 3+2);
                            sheet.addMergedRegion(region);
                            cell7.setCellValue("天友乳业");
                            addRowData(indices,sheet,map,j+1,"TYRY",n,cellStyle);
                            Cell cell8 = projectRow.createCell((j+3)*3);
                            cell8.setCellStyle(cellStyle);
                            region = new CellRangeAddress(3,3,(j + 3) * 3,(j + 3) * 3+2);
                            sheet.addMergedRegion(region);
                            cell8.setCellValue("中垦乳业合并");
                            totalData(indices,sheet,j+3,n,cellStyle);
                            boo = false;
                        }
                    }
                    if (boo){
                        Cell cell8 = projectRow.createCell((j+2)*3);
                        cell8.setCellStyle(cellStyle);
                        region = new CellRangeAddress(3,3,(j + 2) * 3,(j + 2) * 3+2);
                        sheet.addMergedRegion(region);
                        cell8.setCellValue("中垦乳业合并");
                        totalData(indices,sheet,j+2,n,cellStyle);
                    }
                    Row titleRow = sheet.createRow(0);
                    Cell titleCell = titleRow.createCell(0);
                    CellStyle style = wb.createCellStyle();
                    style.setAlignment(HorizontalAlignment.CENTER);
                    style.setVerticalAlignment(VerticalAlignment.CENTER);
                    Font font = wb.createFont();
                    font.setFontHeightInPoints((short)20);
                    style.setFont(font);
                    titleCell.setCellStyle(style);
                    region = new CellRangeAddress(0,0,0,(j+4)*3-1);
                    sheet.addMergedRegion(region);
                    //添加表头
                    if (n==4){
                        titleCell.setCellValue("中垦乳业主要经营指标表(本期）");
                    }else {
                        titleCell.setCellValue("中垦乳业主要经营指标表（累计）");
                    }
                    Row dateRow = sheet.getRow(1);
                    CellStyle dateStyle = wb.createCellStyle();
                    dateStyle.setAlignment(HorizontalAlignment.CENTER);
                    dateStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                    Cell dateCell = dateRow.getCell(0);
                    DataFormat format = wb.createDataFormat();
                    region = new CellRangeAddress(1,1,0,(j+4)*3-1);
                    sheet.addMergedRegion(region);
                    //设置单元格格式
                    dateStyle.setDataFormat(format.getFormat("yyyy年m月"));
                    dateCell.setCellStyle(dateStyle);
                }else {
                    for (int j = 0; j <= fhead_ids.size() ; j++) {
                        Cell cell1 = projectRow.createCell((j+1)*3);
                        if (fileName.contains("2017")) {
                            cell1.setCellValue("预算");
                        }else {
                            cell1.setCellValue("上年");
                        }
                        Cell cell2 = projectRow.createCell((j+1)*3+1);
                        if (fileName.contains("2017")) {
                            cell2.setCellValue("上年");
                        }else {
                            cell2.setCellValue("预算");
                        }
                        cell2.setCellValue("上年");
                        Cell cell3 = projectRow.createCell((j+1)*3+2);
                        cell3.setCellValue("实际");
                        cell1.setCellStyle(cellStyle);
                        cell2.setCellStyle(cellStyle);
                        cell3.setCellStyle(cellStyle);
                    }
                }
            }
            sheet.setForceFormulaRecalculation(true);
        }
    }

    /**
     *  合并导出===》添加所有公司数据
     * @param indices
     * @param sheet
     * @param map
     * @param j
     * @param orgCOde
     */
    public void addRowData(List<TFinanceMainIndices> indices,Sheet sheet,Map<Long,String> map,int j,String orgCOde,int sheetId,CellStyle cellStyle){
        for (int l = 5; l < 38; l++) {
            Row dataRow = sheet.getRow(l);
            Cell cell_budget = dataRow.createCell((j + 1) * 3);//获取预算列对象
            Cell cell_lastYear = dataRow.createCell((j + 1) * 3+1);//获取上年列对象
            Cell cell_actual = dataRow.createCell((j + 1) * 3+2);//获取实际列对象
            cell_budget.setCellStyle(cellStyle);
            cell_lastYear.setCellStyle(cellStyle);
            cell_actual.setCellStyle(cellStyle);
            for (int m = 0; m < indices.size(); m++) {
                if (map.get(indices.get(m).getFhead_id()).equals(orgCOde)){
                    if (l==indices.get(m).getFsheet_row_index()) {
                        if (sheetId==4) {
                            //添加 中垦乳业主要经营指标表(本期）数据
                            cell_budget.setCellValue(indices.get(m).getFthis_period_budget().doubleValue());
                            cell_lastYear.setCellValue(indices.get(m).getFthis_period_last_year().doubleValue());
                            cell_actual.setCellValue(indices.get(m).getFthis_period_actual().doubleValue());
                        }else {
                            //添加 中垦乳业主要经营指标表(累计）数据
                            cell_budget.setCellValue(indices.get(m).getFcum_budget().doubleValue());
                            cell_lastYear.setCellValue(indices.get(m).getFcum_last_year().doubleValue());
                            cell_actual.setCellValue(indices.get(m).getFcum_actual().doubleValue());
                        }
                    }
                }
            }
        }
    }

    /**
     * 合并导出===》添加合计数据
     * @param indices
     * @param sheet
     * @param j
     */
    public void totalData(List<TFinanceMainIndices> indices,Sheet sheet,int j,int sheetId,CellStyle cellStyle){
        for (int l = 5; l < 38; l++) { // sheet 对应的行
            Row dataRow = sheet.getRow(l);
            Cell cell_budget = dataRow.createCell(j * 3);//获取预算列对象
            Cell cell_lastYear = dataRow.createCell(j * 3+1);//获取上年列对象
            Cell cell_actual = dataRow.createCell(j * 3+2);//获取实际列对象
            cell_budget.setCellStyle(cellStyle);
            cell_lastYear.setCellStyle(cellStyle);
            cell_actual.setCellStyle(cellStyle);
            BigDecimal item_budget = new BigDecimal("0");
            BigDecimal item_lastYear = new BigDecimal("0");
            BigDecimal item_actual = new BigDecimal("0");
            String item_actualS = "";
            for (int k = 0; k < indices.size(); k++) {
                if (indices.get(k).getFsheet_row_index()==l) {
                    if (sheetId==4) {
                        //添加 中垦乳业主要经营指标表(本期）数据
                        item_budget = item_budget.add(indices.get(k).getFthis_period_budget());
                        item_lastYear = item_lastYear.add(indices.get(k).getFthis_period_last_year());
                        if(l<25) {
                            item_actual = item_actual.add(indices.get(k).getFthis_period_actual());
                        }
                        switch (l){
                            case 25:
                                item_actualS = "AA11/AA6";
                                break;
                            case 26:
                                item_actualS = "'资产负债表（合并）'!C25/'资产负债表（合并）'!G31";
                                break;
                            case 27:
                                item_actualS = "('资产负债表（合并）'!C25-'资产负债表（合并）'!C20)/'资产负债表（合并）'!G31";
                                break;
                            case 28:
                                item_actualS = "'利润表（合并）'!G7/(('资产负债表（合并）'!C11+'资产负债表（合并）'!D11)/2)";
                                break;
                            case 29:
                                item_actualS = "('利润表（合并）'!G8-'利润表（合并）'!G11)/'利润表（合并）'!G8";
                                break;
                            case 30:
                                item_actualS = "'利润表（合并）'!G21/'利润表（合并）'!G7";
                                break;
                            case 31:
                                item_actualS = "'利润表（合并）'!G25/('利润表（合并）'!G10+'利润表（合并）'!G13+'利润表（合并）'!G14+'利润表（合并）'!G15+'利润表（合并）'!G16)";
                                break;
                            case 32:
                                item_actualS = "AA20/AA18";
                                break;
                            case 33:
                                item_actualS = "('利润表（合并）'!G27-'利润表（合并）'!G19+'折旧金额'!D10+'税费统计表（合并）'!C28+'员工薪酬表（合并）'!C18)/10000/'全部从业人员平均人数'!D10";
                                break;
                            case 34:
                                item_actualS = "'利润表（合并）'!G8/'资产负债表（合并）'!C69";
                                break;
                            case 35:
                                item_actualS = "IF(Z6<0,1-AA6/Z6,(AA6-Z6)/Z6)";
                                break;
                            case 36:
                                item_actualS = "IF(Z18<0,1-AA18/Z18,(AA18-Z18)/Z18)";
                                break;
                            case 37:
                                item_actualS = "IF(Z25<0,1-AA25/Z25,(AA25-Z25)/Z25)";
                                break;
                        }
                    }else {
                        //添加 中垦乳业主要经营指标表(累计）数据
                        item_budget = item_budget.add(indices.get(k).getFcum_budget());
                        item_lastYear = item_lastYear.add(indices.get(k).getFcum_last_year());
                        if(l<25) {
                            item_actual = item_actual.add(indices.get(k).getFcum_actual());
                        }
                        switch (l){
                            case 25:
                                item_actualS = "AA11/AA6";
                                break;
                            case 26:
                                item_actualS = "'资产负债表（合并）'!C25/'资产负债表（合并）'!G31";
                                break;
                            case 27:
                                item_actualS = "('资产负债表（合并）'!C25-'资产负债表（合并）'!C20)/'资产负债表（合并）'!G31";
                                break;
                            case 28:
                                item_actualS = "'利润表（合并）'!H7/(('资产负债表（合并）'!C11+'资产负债表（合并）'!D11)/2)";
                                break;
                            case 29:
                                item_actualS = "('利润表（合并）'!H8-'利润表（合并）'!H11)/'利润表（合并）'!H8";
                                break;
                            case 30:
                                item_actualS = "'利润表（合并）'!H21/'利润表（合并）'!H7";
                                break;
                            case 31:
                                item_actualS = "'利润表（合并）'!H25/('利润表（合并）'!H10+'利润表（合并）'!H13+'利润表（合并）'!H14+'利润表（合并）'!H15+'利润表（合并）'!H16)";
                                break;
                            case 32:
                                item_actualS = "AA20/AA18";
                                break;
                            case 33:
                                item_actualS = "('利润表（合并）'!G27-'利润表（合并）'!G19+'折旧金额'!D10+'税费统计表（合并）'!C28+'员工薪酬表（合并）'!C18)/10000/'全部从业人员平均人数'!D10";
                                break;
                            case 34:
                                item_actualS = "'利润表（合并）'!G8/'资产负债表（合并）'!C69";
                                break;
                            case 35:
                                item_actualS = "IF(Z6<0,1-AA6/Z6,(AA6-Z6)/Z6)";
                                break;
                            case 36:
                                item_actualS = "IF(Z18<0,1-AA18/Z18,(AA18-Z18)/Z18)";
                                break;
                            case 37:
                                item_actualS = "IF(Z25<0,1-AA25/Z25,(AA25-Z25)/Z25)";
                                break;
                        }
                    }
                }
            }
            cell_budget.setCellValue(item_budget.doubleValue());
            cell_lastYear.setCellValue(item_lastYear.doubleValue());
            if (l<25) {
                cell_actual.setCellValue(item_actual.doubleValue());
            }else {
                cell_actual.setCellFormula(item_actualS);
            }
        }
    }
}
