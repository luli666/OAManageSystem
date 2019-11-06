package com.offcn.sys.mapper;

import com.offcn.sys.bean.RoleSourcesExample;
import com.offcn.sys.bean.RoleSourcesKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleSourcesMapper {
    int countByExample(RoleSourcesExample example);

    int deleteByExample(RoleSourcesExample example);

    int deleteByPrimaryKey(RoleSourcesKey key);

    int insert(RoleSourcesKey record);

    int insertSelective(RoleSourcesKey record);

    List<RoleSourcesKey> selectByExample(RoleSourcesExample example);

    int updateByExampleSelective(@Param("record") RoleSourcesKey record, @Param("example") RoleSourcesExample example);

    int updateByExample(@Param("record") RoleSourcesKey record, @Param("example") RoleSourcesExample example);
}