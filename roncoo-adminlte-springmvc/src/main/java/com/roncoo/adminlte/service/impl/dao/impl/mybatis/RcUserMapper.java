package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.RcUserExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface RcUserMapper {
    int countByExample(RcUserExample example);

    int deleteByExample(RcUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcUser record);

    int insertSelective(RcUser record);

    List<RcUser> selectByExample(RcUserExample example);

    RcUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcUser record, @Param("example") RcUserExample example);

    int updateByExample(@Param("record") RcUser record, @Param("example") RcUserExample example);

    int updateByPrimaryKeySelective(RcUser record);

    int updateByPrimaryKey(RcUser record);
}