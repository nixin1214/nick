package com.roncoo.adminlte.service.impl.dao.impl;

import com.github.pagehelper.PageHelper;
import com.roncoo.adminlte.bean.entity.TDailyReport;
import com.roncoo.adminlte.bean.entity.TDailyReportExample;
import com.roncoo.adminlte.service.impl.dao.TDailyReportDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TDailyReportMapper;
import com.roncoo.adminlte.util.base.SqlUtil;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class TDailyReportDaoImpl implements TDailyReportDao{

    @Autowired
    private TDailyReportMapper tDailyReportMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int deleteByExample(String yearMonth, BigDecimal difference) {
        TDailyReportExample example = new TDailyReportExample();
        TDailyReportExample.Criteria criteria = example.createCriteria();
        criteria.andYearMonthEqualTo(yearMonth);
        int num = tDailyReportMapper.deleteByExample(example);
        return num;
    }

    @Override
    public int insertBatch(List<TDailyReport> tDailyReports) {
        return tDailyReportMapper.insertBatch(tDailyReports);
    }


    @Override
    public List<TDailyReport> selectByExample(TDailyReportExample example) {
        return this.tDailyReportMapper.selectByExample(example);
    }

    @Override
    public List<TDailyReport> listForPage(int pageCurrent, int pageSize, String yearMonth,int type) {
        TDailyReportExample example = new TDailyReportExample();
        TDailyReportExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("year_month asc,fsheet_row_index asc");
        if (StringUtils.hasText(yearMonth)) {
            criteria.andYearMonthLike(SqlUtil.like(yearMonth));
        }
        criteria.andFdifferenceEqualTo(new BigDecimal(type));
        PageHelper.startPage(pageCurrent, pageSize);
        List<TDailyReport> list = this.tDailyReportMapper.selectByExample(example);
        return list;
    }
}
