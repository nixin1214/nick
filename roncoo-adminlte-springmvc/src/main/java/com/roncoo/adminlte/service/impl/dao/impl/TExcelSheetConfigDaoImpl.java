package com.roncoo.adminlte.service.impl.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roncoo.adminlte.bean.entity.TExcelSheetConfig;
import com.roncoo.adminlte.bean.entity.TExcelSheetConfigExample;
import com.roncoo.adminlte.service.impl.dao.TExcelSheetConfigDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TExcelSheetConfigMapper;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: EXCEL SHEET配置类
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/11 11:45
 */
@Repository
public class TExcelSheetConfigDaoImpl implements TExcelSheetConfigDao {

    @Autowired
    private TExcelSheetConfigMapper mapper;

    @Override
    public TExcelSheetConfig selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public TExcelSheetConfig selectBySheetName(String name) {
        TExcelSheetConfigExample example = new TExcelSheetConfigExample();
        TExcelSheetConfigExample.Criteria criteria = example.createCriteria();
        criteria.andFsheetNameEqualTo(name);
        List<TExcelSheetConfig> list = mapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public TExcelSheetConfig selectByIndex(int number) {
        TExcelSheetConfigExample example = new TExcelSheetConfigExample();
        TExcelSheetConfigExample.Criteria criteria = example.createCriteria();
        criteria.andFsheetIndexEqualTo(number);
        List<TExcelSheetConfig> list = mapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int insert(TExcelSheetConfig role) {
        return mapper.insert(role);
    }

    @Override
    public int update(TExcelSheetConfig role) {
        return mapper.updateByPrimaryKey(role);
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<TExcelSheetConfig> listForPage(int pageCurrent, int pageSize, String date, String search) {

        TExcelSheetConfigExample example = new TExcelSheetConfigExample();
        example.setOrderByClause("fsheet_index asc");
        TExcelSheetConfigExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(search)) {
            criteria.andFsheetNameEqualTo(SqlUtil.like(search));
        }
        PageHelper.startPage(pageCurrent, pageSize);
        List<TExcelSheetConfig> list = mapper.selectByExample(example);
        PageInfo<TExcelSheetConfig> pageInfo = new PageInfo<>(list);
        return new Page<>((int)pageInfo.getTotal(), pageInfo.getPages(), pageCurrent, pageSize, list);
    }

    @Override
    public List<TExcelSheetConfig> listForId(List<Long> idList) {
        TExcelSheetConfigExample example = new TExcelSheetConfigExample();
        example.setOrderByClause("fsheet_index asc");
        TExcelSheetConfigExample.Criteria criteria = example.createCriteria();
        criteria.andFidIn(idList);
        return mapper.selectByExample(example);
    }

    @Override
    public List<TExcelSheetConfig> listByHeadId(long headId) {
        TExcelSheetConfigExample example = new TExcelSheetConfigExample();
        example.setOrderByClause("fsheet_index asc");
        TExcelSheetConfigExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.selectByExample(example);
    }

    @Override
    public List<TExcelSheetConfig> list() {
        TExcelSheetConfigExample example = new TExcelSheetConfigExample();
        example.setOrderByClause("fsheet_index asc");
        return mapper.selectByExample(example);
    }
}
