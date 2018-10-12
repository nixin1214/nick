package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.Payrecord;
import com.roncoo.adminlte.util.base.Page;

import java.util.List;

/**
 * createUser 杨北平 to 2017-12-2
 * 油料消耗指标查询
 */
public interface PayrecordDao {

    /**
     * 分页查询
     * @param cardName 持卡人
     * @param FinishTime 时间
     * @return
     */
    Page<Payrecord> listForPage(int pageCurrent, int pageSize, String cardName, String  FinishTime, String  orgCode,String endTime);


}
