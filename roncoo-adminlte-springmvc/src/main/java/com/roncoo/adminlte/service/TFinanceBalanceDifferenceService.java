package com.roncoo.adminlte.service;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceBalanceDifference;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * 资产负债表(差额表)
 * Created by Andrew on 2017/11/11.
 */
public interface TFinanceBalanceDifferenceService {

    int insert(TFinanceBalanceDifference obj);

    int insertBatch(@Param("list") List<TFinanceBalanceDifference> list);

    int deleteById(Long id);

    int deleteByProperty(Long headId);

    /**
     * 根据表头ID查询列表
     *
     * @param headId
     * @return JSON格式列表对象
     */
    JSONObject queryByHeadId(Long headId);

    /**
     * 导入资产负债表(差额表)
     * @param wb excel对象
     * @param sheetName sheet页名称
     * @param companyNumber 公司编码
     * @param period 期间
     * @param rcUser 操作用户
     * @return JSON列表对象
     */
    JSONObject importHandler(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser);
}
