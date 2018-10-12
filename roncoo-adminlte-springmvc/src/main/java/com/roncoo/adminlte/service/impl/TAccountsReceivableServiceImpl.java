package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TAccountsReceivable;
import com.roncoo.adminlte.bean.entity.TAccountsReceivableExample;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.service.TAccountsReceivableService;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.TAccountsReceivableDao;
import com.roncoo.adminlte.util.Tools;
import com.roncoo.adminlte.util.base.Page;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TAccountsReceivableServiceImpl implements TAccountsReceivableService {

    @Autowired
    private TFinanceMainService mainService;

    @Autowired
    private TAccountsReceivableDao receivableDao;

    /**
     * 导入应收账款数据
     * @param wb
     * @param sheetName
     * @param companyNumber
     * @param yearMonth
     * @param rcUser
     * @return
     */
    @Override
    public JSONObject importAccounts(Workbook wb, String sheetName, String companyNumber, String yearMonth, RcUser rcUser) {
        Sheet sheet = wb.getSheet(sheetName);
        JSONObject object = new JSONObject();
        if (sheet==null){
            object.put("stateCode", 0);
            object.put("error", "模板为空");
        }else {
            int rowCount = sheet.getPhysicalNumberOfRows();
            if(rowCount==0) {
                object.put("stateCode", 0);
                object.put("error", "模板为空");
            }else {
                List<TAccountsReceivable> receivables = new ArrayList<>();
                int size = rowCount;
                for (int i = 2;i<size;i++){
                    Row row = sheet.getRow(i);
                    TAccountsReceivable receivable = new TAccountsReceivable();
                    receivable.setFrowIndex(new Long(i));
                    receivable.setDistributor(Tools.getCellValue(row.getCell(0),wb));
                    receivable.setAccountsReceivable(Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(1),wb)));
                    receivable.setGrowthRate(Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2),wb)));
                    receivable.setRingRatio(Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3),wb)));
                    receivable.setYearOn(Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4),wb)));
                    receivables.add(receivable);
                }
                Long headId = mainService.getOrAddFinanceMainId(companyNumber,sheetName,yearMonth,rcUser);
                if (headId!=0) {
                    for (TAccountsReceivable receivable : receivables) {
                        receivable.setFheadId(new BigDecimal(headId));
                    }
                    int num = deleteByProperty(new BigDecimal(headId));//删除原有数据
                    int num1 = this.receivableDao.insertBatch(receivables);
//                    List<TAccountsReceivable> receivableList = this.receivableDao.selectByHeadId(new BigDecimal(headId));
//                    object.put("datas",receivableList);
                    object.put("stateCode", 200);
                }else {
                    object.put("error","新增导入记录失败");
                    object.put("stateCode",0);
                }
            }
        }
        return object;
    }

    public int deleteByProperty(BigDecimal theadId){
        TAccountsReceivableExample example = new TAccountsReceivableExample();
        TAccountsReceivableExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(theadId);
        return this.receivableDao.deleteByExample(example);
    }

    @Override
    public Result<Page<TAccountsReceivable>> listForPage(int start, int pageSize,  List<BigDecimal> headId) {
        Result<Page<TAccountsReceivable>> result = new Result<Page<TAccountsReceivable>>();
        if (start < 1) {
            result.setErrMsg("pageCurrent有误");
            return result;
        }
        if (pageSize < 1) {
            result.setErrMsg("pageSize有误");
            return result;
        }
        Page<TAccountsReceivable> resultData = receivableDao.listForPage(start, pageSize, headId);
        result.setResultData(resultData);
        result.setErrCode(0);
        result.setStatus(true);
        result.setErrMsg("查询成功");
        return result;
    }

    @Override
    public List<TAccountsReceivable> queryByExmple(List<BigDecimal> headIds) {
        TAccountsReceivableExample example = new TAccountsReceivableExample();
        TAccountsReceivableExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(headIds);
        example.setOrderByClause("accounts_receivable desc");
        List<TAccountsReceivable> resultList = this.receivableDao.selectByExample(example);
        List<TAccountsReceivable> result = new ArrayList<>();
        for (int i= 0;i<5;i++){
            if (resultList.size()>i){
                result.add(resultList.get(i));
            }else {
                result.add(new TAccountsReceivable());
            }
        }
        return result;
    }



    public List<TAccountsReceivable> fillNull(){
        List<TAccountsReceivable> resultList = new ArrayList<>();
        for (int i = 0;i<5;i++){
            resultList.add(new TAccountsReceivable());
        }
        return resultList;
    }

}
