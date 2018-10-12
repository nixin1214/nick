package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.Payrecord;
import com.roncoo.adminlte.bean.entity.PayrecordExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface HSMCPayrecordMapper {

    long countByExample(PayrecordExample example);

    int deleteByExample(PayrecordExample example);

    int insert(Payrecord record);

    int insertSelective(Payrecord record);

    List<Payrecord> selectByExample(PayrecordExample example);

    int updateByExampleSelective(@Param("record") Payrecord record, @Param("example") PayrecordExample example);

    int updateByExample(@Param("record") Payrecord record, @Param("example") PayrecordExample example);
}
