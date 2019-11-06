package com.offcn.info.mapper;

import com.offcn.info.bean.Benchmarking;
import com.offcn.info.bean.BenchmarkingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BenchmarkingMapper {
    int countByExample(BenchmarkingExample example);

    int deleteByExample(BenchmarkingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Benchmarking record);

    int insertSelective(Benchmarking record);

    List<Benchmarking> selectByExample(BenchmarkingExample example);

    Benchmarking selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Benchmarking record, @Param("example") BenchmarkingExample example);

    int updateByExample(@Param("record") Benchmarking record, @Param("example") BenchmarkingExample example);

    int updateByPrimaryKeySelective(Benchmarking record);

    int updateByPrimaryKey(Benchmarking record);
}