package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.RcCompany;
import com.roncoo.adminlte.bean.entity.RcCompanyExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface RcCompanyMapper {
    int countByExample(RcCompanyExample example);

    int deleteByExample(RcCompanyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcCompany record);

    int insertSelective(RcCompany record);

    List<RcCompany> selectByExample(RcCompanyExample example);

    RcCompany selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcCompany record, @Param("example") RcCompanyExample example);

    int updateByExample(@Param("record") RcCompany record, @Param("example") RcCompanyExample example);

    int updateByPrimaryKeySelective(RcCompany record);

    int updateByPrimaryKey(RcCompany record);
}