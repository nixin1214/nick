package com.roncoo.adminlte.service.impl.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roncoo.adminlte.bean.entity.Payrecord;
import com.roncoo.adminlte.bean.entity.PayrecordExample;
import com.roncoo.adminlte.service.impl.dao.PayrecordDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.HSMCPayrecordMapper;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TNMCPayrecordMapper;
import com.roncoo.adminlte.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class PayrecordDaoImpl implements PayrecordDao {

    @Autowired
    private TNMCPayrecordMapper tnmcPayrecordMapper;
    @Autowired
    private HSMCPayrecordMapper hsmcPayrecordMapper;

    @Override
    public Page<Payrecord> listForPage( int pageCurrent, int pageSize,String cardName, String  FinishTime, String  orgCode,String endTime) {
        PayrecordExample example = new PayrecordExample();
        PayrecordExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("FINISHTIME DESC");
        if (!StringUtils.isEmpty(cardName)&&!cardName.equals("all")){
            criteria.andCardnameEqualTo(cardName);
        }
        if (StringUtils.hasText(FinishTime)&&!FinishTime.equals("all")&&StringUtils.hasText(endTime)&&endTime.equals("all")){
            criteria.andFinishtimeLike(FinishTime+"%");
        }
        if (StringUtils.hasText(endTime)&&!endTime.equals("all")&&StringUtils.hasText(FinishTime)&&FinishTime.equals("all")){
            criteria.andFinishtimeLike(endTime+"%");
        }
        if (StringUtils.hasText(endTime)&&!endTime.equals("all")&&StringUtils.hasText(FinishTime)&&!FinishTime.equals("all")){
            String startTime = FinishTime+" 00:00:00";
            String end = endTime+" 23:59:59";
            criteria.andFinishtimeBetween(startTime,end);
        }
        PageHelper.startPage(pageCurrent, pageSize);
        List<Payrecord> list;
        if (orgCode.equals("TNMC")) {
            list = tnmcPayrecordMapper.selectByExample(example);
        }else {
            list = hsmcPayrecordMapper.selectByExample(example);
            for(int i = 0;i<list.size();i++){
                list.get(i).setCardname("-");
            }
        }
        PageInfo<Payrecord> pageInfo = new PageInfo<>(list);
        return new Page<>((int)pageInfo.getTotal(), pageInfo.getPages(), pageCurrent, pageSize, list);
    }
}
