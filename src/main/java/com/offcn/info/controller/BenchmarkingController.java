package com.offcn.info.controller;

import com.offcn.info.bean.Benchmarking;
import com.offcn.info.service.BenchmarkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bench")
public class BenchmarkingController {
    @Autowired
    private BenchmarkingService benchmarkingService;

    @RequestMapping("/insert")
    public String insertBenchmarking(Benchmarking benchmarking){
        benchmarkingService.insertBenchmarking(benchmarking);
        return "redirect:/indexvalue-base.jsp";
    }
    @RequestMapping("/info")
    @ResponseBody
    public List<Benchmarking> infoBenchmarking(){
        return benchmarkingService.infoBenchmarking();
    }
}
