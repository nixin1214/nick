package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TSysResource;
import com.roncoo.adminlte.bean.entity.TSysResourceExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TSysResourceMapper {
    int countByExample(TSysResourceExample example);

    int deleteByExample(TSysResourceExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TSysResource record);

    int insertSelective(TSysResource record);

    List<TSysResource> selectByExample(TSysResourceExample example);

    TSysResource selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TSysResource record, @Param("example") TSysResourceExample example);

    int updateByExample(@Param("record") TSysResource record, @Param("example") TSysResourceExample example);

    int updateByPrimaryKeySelective(TSysResource record);

    int updateByPrimaryKey(TSysResource record);
}