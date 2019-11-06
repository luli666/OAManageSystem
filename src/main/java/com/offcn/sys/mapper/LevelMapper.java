package com.offcn.sys.mapper;

import java.util.List;

import com.offcn.sys.bean.Level;
import com.offcn.sys.bean.LevelExample;
import org.apache.ibatis.annotations.Param;

public interface LevelMapper {
    int countByExample(LevelExample example);

    int deleteByExample(LevelExample example);

    int deleteByPrimaryKey(Integer jid);

    int insert(Level record);

    int insertSelective(Level record);

    List<Level> selectByExample(LevelExample example);

    Level selectByPrimaryKey(Integer jid);

    int updateByExampleSelective(@Param("record") Level record, @Param("example") LevelExample example);

    int updateByExample(@Param("record") Level record, @Param("example") LevelExample example);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);
}