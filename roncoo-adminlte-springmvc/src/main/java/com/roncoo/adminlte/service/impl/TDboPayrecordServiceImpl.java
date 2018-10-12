package com.roncoo.adminlte.service.impl;

import com.roncoo.adminlte.bean.entity.Payrecord;
import com.roncoo.adminlte.bean.entity.TBusinessQuota;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.service.PayrecordService;
import com.roncoo.adminlte.service.impl.dao.PayrecordDao;
import com.roncoo.adminlte.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * createUser 杨北平 to 2017-12-2
 * 油料消耗指标查询
 */
@Service
public class TDboPayrecordServiceImpl implements PayrecordService {

    @Autowired
    private PayrecordDao PayrecordDao;

    /**
     * 分页查询
     * @param cardName
     * @param FinishTime
     * @return
     */
    @Override
    public Result<Page<Payrecord>> listForPage(int pageCurrent, int pageSize, String cardName, String  FinishTime, String orgCode,String endTime) {
        Page<Payrecord> resultData = PayrecordDao.listForPage( pageCurrent,pageSize,cardName, FinishTime,orgCode,endTime);
        Result<Page<Payrecord>> result = new Result<>();
        if (pageCurrent < 1) {
            result.setErrMsg("pageCurrent有误");
            return result;
        }
        if (pageSize < 1) {
            result.setErrMsg("pageSize有误");
            return result;
        }
        result.setResultData(resultData);
        result.setErrCode(0);
        result.setStatus(true);
        result.setErrMsg("查询成功");
        return result;
    }
}
