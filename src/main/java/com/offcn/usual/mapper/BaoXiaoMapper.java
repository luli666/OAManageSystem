package com.offcn.usual.mapper;

import com.offcn.usual.bean.BaoXiao;
import com.offcn.usual.bean.BaoXiaoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaoXiaoMapper {
    int countByExample(BaoXiaoExample example);

    int deleteByExample(BaoXiaoExample example);

    int deleteByPrimaryKey(String bxid);

    int insert(BaoXiao record);

    int insertSelective(BaoXiao record);

    List<BaoXiao> selectByExample(BaoXiaoExample example);

    BaoXiao selectByPrimaryKey(String bxid);

    int updateByExampleSelective(@Param("record") BaoXiao record, @Param("example") BaoXiaoExample example);

    int updateByExample(@Param("record") BaoXiao record, @Param("example") BaoXiaoExample example);

    int updateByPrimaryKeySelective(BaoXiao record);

    int updateByPrimaryKey(BaoXiao record);
}