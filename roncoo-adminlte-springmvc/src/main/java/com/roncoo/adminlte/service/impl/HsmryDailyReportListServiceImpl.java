package com.roncoo.adminlte.service.impl;

import com.roncoo.adminlte.bean.entity.HsmryDailyReportList;
import com.roncoo.adminlte.bean.entity.HsmryDailyReportListExample;
import com.roncoo.adminlte.service.HsmryDailyReportListService;
import com.roncoo.adminlte.service.impl.dao.HsmryDailyReportListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HsmryDailyReportListServiceImpl implements HsmryDailyReportListService{

    @Autowired
    private HsmryDailyReportListDao listDao;

    @Override
    public Map<String,Object> selectByExample() {
        HsmryDailyReportListExample example = new HsmryDailyReportListExample();
        HsmryDailyReportListExample.Criteria criteria = example.createCriteria();
        List<HsmryDailyReportList> reportLists = listDao.selectByExample(example);
        Map<String,Object> resultMap = new HashMap<>();
        String[] categorys = {"低温","常温","学生奶"};
        BigDecimal base = new BigDecimal(10000);
        HsmryDailyReportList reportTotal = new HsmryDailyReportList();//存储总计
        reportTotal.setClassification("全司合计");
        for(String category:categorys){
            List<HsmryDailyReportList> cateList = new ArrayList<>();
            HsmryDailyReportList report = new HsmryDailyReportList();
            report.setProductName("小计");
            for(HsmryDailyReportList reportList:reportLists){
                if (reportList.getClassification().contains(category)){
                    reportList.setSalesAmountTatal(reportList.getSalesAmountTatal().divide(base,2,BigDecimal.ROUND_HALF_UP));
                    reportList.setSalesAmountActual(reportList.getSalesAmountActual().divide(base,2,BigDecimal.ROUND_HALF_UP));
                    cateList.add(reportList);
                    report.setSalesVolumeTotal(report.getSalesVolumeTotal().add(reportList.getSalesVolumeTotal()));
                    report.setSalesAmountTatal(report.getSalesAmountTatal().add(reportList.getSalesAmountTatal()));
                    report.setSalesVolumeBudget(report.getSalesVolumeBudget().add(reportList.getSalesVolumeBudget()));
                    report.setSalesAmountBudget(report.getSalesAmountBudget().add(reportList.getSalesAmountBudget()));
                    report.setSalesVolumeActual(report.getSalesVolumeActual().add(reportList.getSalesVolumeActual()));
                    report.setSalesAmountActual(report.getSalesAmountActual().add(reportList.getSalesAmountActual()));
                    report.setDays(reportList.getDays());
                }
            }
            cateList.add(report);
            reportTotal.setSalesVolumeTotal(reportTotal.getSalesVolumeTotal().add(report.getSalesVolumeTotal()));
            reportTotal.setSalesAmountTatal(reportTotal.getSalesAmountTatal().add(report.getSalesAmountTatal()));
            reportTotal.setSalesVolumeBudget(reportTotal.getSalesVolumeBudget().add(report.getSalesVolumeBudget()));
            reportTotal.setSalesAmountBudget(reportTotal.getSalesAmountBudget().add(report.getSalesAmountBudget()));
            reportTotal.setSalesVolumeActual(reportTotal.getSalesVolumeActual().add(report.getSalesVolumeActual()));
            reportTotal.setSalesAmountActual(reportTotal.getSalesAmountActual().add(report.getSalesAmountActual()));
            if (reportLists.size()>0) {
                reportTotal.setDays(reportLists.get(0).getDays());
            }else {
                reportTotal.setDays(new Long(1));
            }
            if (cateList.size()>1) {
                resultMap.put(category, cateList);
                resultMap.put(category+"size",cateList.size());
            }
            resultMap.put("合计",reportTotal);
        }
        return resultMap;
    }
}
