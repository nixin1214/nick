package com.roncoo.adminlte.service;

import com.roncoo.adminlte.bean.entity.Payrecord;
import com.roncoo.adminlte.bean.entity.TBusinessQuota;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.util.base.Page;

import java.util.List;

/**
 * createUser 杨北平 to 2017-12-2
 * 油料消耗指标查询
 */

public interface PayrecordService {

    /**
     * 分页查询
     * @param cardName
     * @param orgCode
     * @param finishTime
     * @return
     */
    Result<Page<Payrecord>> listForPage(int pageCurrent, int pageSize, String cardName, String  finishTime, String orgCode,String endTime);

}
