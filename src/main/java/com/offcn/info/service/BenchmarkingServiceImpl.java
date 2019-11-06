package com.offcn.info.service;

import com.offcn.info.bean.Benchmarking;
import com.offcn.info.bean.BenchmarkingExample;
import com.offcn.info.mapper.BenchmarkingMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BenchmarkingServiceImpl implements BenchmarkingService{

    @Resource
    private BenchmarkingMapper benchmarkingMapper;
    @Override
    public void insertBenchmarking(Benchmarking benchmarking) {
        benchmarkingMapper.insertSelective(benchmarking);
    }

    @Override
    public List<Benchmarking> infoBenchmarking() {
        int year = new Date().getYear();
        BenchmarkingExample example = new BenchmarkingExample();
        BenchmarkingExample.Criteria criteria = example.createCriteria();
        criteria.andYearNotEqualTo(year-1);

        return benchmarkingMapper.selectByExample(example);
    }
}
