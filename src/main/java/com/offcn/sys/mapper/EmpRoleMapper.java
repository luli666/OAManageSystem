package com.offcn.sys.mapper;

import com.offcn.sys.bean.EmpRoleExample;
import com.offcn.sys.bean.EmpRoleKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpRoleMapper {
    int countByExample(EmpRoleExample example);

    int deleteByExample(EmpRoleExample example);

    int deleteByPrimaryKey(EmpRoleKey key);

    int insert(EmpRoleKey record);

    int insertSelective(EmpRoleKey record);

    List<EmpRoleKey> selectByExample(EmpRoleExample example);

    int updateByExampleSelective(@Param("record") EmpRoleKey record, @Param("example") EmpRoleExample example);

    int updateByExample(@Param("record") EmpRoleKey record, @Param("example") EmpRoleExample example);
}