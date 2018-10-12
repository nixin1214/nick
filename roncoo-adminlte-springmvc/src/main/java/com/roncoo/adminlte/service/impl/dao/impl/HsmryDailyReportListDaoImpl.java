package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.HsmryDailyReportList;
import com.roncoo.adminlte.bean.entity.HsmryDailyReportListExample;
import com.roncoo.adminlte.service.impl.dao.HsmryDailyReportListDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.HsmryDailyReportListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class HsmryDailyReportListDaoImpl implements HsmryDailyReportListDao{

    @Autowired
    private HsmryDailyReportListMapper mapper;

    @Override
    public long countByExample(HsmryDailyReportListExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(HsmryDailyReportListExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(BigDecimal fid) {
        return 0;
    }

    @Override
    public int insert(HsmryDailyReportList record) {
        return 0;
    }

    @Override
    public int insertSelective(HsmryDailyReportList record) {
        return 0;
    }

    @Override
    public List<HsmryDailyReportList> selectByExample(HsmryDailyReportListExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public HsmryDailyReportList selectByPrimaryKey(BigDecimal fid) {
        return null;
    }

    @Override
    public int updateByExampleSelective(HsmryDailyReportList record, HsmryDailyReportListExample example) {
        return 0;
    }

    @Override
    public int updateByExample(HsmryDailyReportList record, HsmryDailyReportListExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(HsmryDailyReportList record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(HsmryDailyReportList record) {
        return 0;
    }
}
