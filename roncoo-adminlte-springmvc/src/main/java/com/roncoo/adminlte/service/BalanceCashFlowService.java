package com.roncoo.adminlte.service;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.BalanceCashFlow;
import com.roncoo.adminlte.bean.entity.BalanceProfit;
import com.roncoo.adminlte.bean.entity.RcUser;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 *
 * 现金流量表
 *
 * Created by lx on 2017/11/11.
 */
public interface BalanceCashFlowService {

    int insert(BalanceCashFlow obj);

    int insertBatch(@Param("list") List<BalanceCashFlow> list);

    int deleteById(Long id);

    int deleteByProperty(Long tfheadid);

    List<BalanceCashFlow> queryByProperty(Long tfheadid);

    /**
     * 数据导入
     * @param wb excel对象
     * @param sheetName sheet页名称
     * @param companyNumber 公司编码
     * @param period 期间
     * @param rcUser 操作用户
     * @return JSON格式表格数据
     */
    JSONObject importHandler(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser);

    /**
     * 根据表头查询表格数据
     * @param fheadid 表头ID
     * @return JSON格式TABLE数据及状态
     */
    JSONObject queryByHeadId(Long fheadid);

    List<BalanceCashFlow> queryByPropertyAll(List<Long> tfheadids);

    /**
     * 根据表头查询数据，并写入sheet页
     * @param sheet 表
     * @param tfheadids 头ID集合
     */
    void exportHandler(Sheet sheet, List<Long> tfheadids);
}
