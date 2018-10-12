package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TBusinessQuota;
import com.roncoo.adminlte.util.base.Page;

import java.util.List;
import java.util.Map;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 业务指标DAO
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/10/31 12:09
 */
public interface BusinessQuotaDao {

    /**
     * 执行动态SQL
     * @param sql
     * @return 结果集
     */
    public List<Map<String, Object>> dynamicSql(String sql);



    /**
     * 添加
     *
     * @param businessQuota
     * @return
     */
    int insert(TBusinessQuota businessQuota);

    /**
     * 分页查询
     * @param pageCurrent
     * @param pageSize
     * @param orgCode 组织编码
     * @param yearMonth 期间
     * @param quotaName 指标中文名称
     * @return
     */
    Page<TBusinessQuota> listForPage(int pageCurrent, int pageSize, String orgCode, String yearMonth, List<String> quotaName);

    /**
     * 分页查询
     * @param pageCurrent
     * @param pageSize
     * @param orgCode 组织编码
     * @param yearMonth 期间
     * @param quotaName 指标中文名称
     * @return
     */
    Page<TBusinessQuota> listForPage(int pageCurrent, int pageSize, String orgCode, String yearMonth, String quotaName, List<String> companyList);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    TBusinessQuota selectById(Long id);

    /**
     * 根据id删除
     *
     * @param id
     */
    int deleteById(Long id);

    /**
     * 更新
     *
     * @param quota
     * @return
     */
    int updateById(TBusinessQuota quota);

    /**
     * 更新指标值
     * @param quota
     * @return
     */
    int updateByExample(TBusinessQuota quota);

    int deleteByProperty(TBusinessQuota quota);

    int insertBatch(List<TBusinessQuota> list);
}
