package com.offcn.info.service;

import com.offcn.info.bean.Benchmarking;

import java.util.List;

public interface BenchmarkingService {
    void insertBenchmarking(Benchmarking benchmarking);

    List<Benchmarking> infoBenchmarking();
}
