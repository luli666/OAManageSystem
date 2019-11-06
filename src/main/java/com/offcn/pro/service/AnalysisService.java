package com.offcn.pro.service;

import com.offcn.pro.bean.Analysis;

import java.util.List;

public interface AnalysisService {
    List<Analysis> findAllAnalysis();

    void insertAnalysis(Analysis analysis);

    Boolean deleteAnalysis(Integer[] ids);

    Analysis lookanalysis(Integer id);

    Analysis infoAnalysis(Integer id);

    void updateAnalysis(Analysis analysis);

    List<Analysis> likeAllAnalysis(Integer cid, String keyword, Integer orderby);
}
