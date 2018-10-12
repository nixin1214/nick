package com.roncoo.adminlte.service;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceMainIndices;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Map;

/**
 * 主要指标1 Service
 * Created by lx on 2017/11/1.
 */
public interface TFinanceMainIndicesService {

    int insert(TFinanceMainIndices tFinanceMainIndices);

    int insertBatch(List<TFinanceMainIndices> list);

    int deleteById(Long id);

    int deleteByProperty(Long tfheadid);

    List<TFinanceMainIndices> queryByProperty(List<Long> fheadid);

    int update(TFinanceMainIndices tFinanceMainIndices);

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

    /**
     * 合并导出查询
     * @param fhead_ids
     * @param wb
     * @return
     */
    void queryByMonth(Workbook wb,List<Long> fhead_ids,Map<Long,String> map,String fileName);
}
