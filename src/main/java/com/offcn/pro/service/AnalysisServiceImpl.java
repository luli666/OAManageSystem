package com.offcn.pro.service;

import com.offcn.pro.bean.Analysis;
import com.offcn.pro.bean.AnalysisExample;
import com.offcn.pro.mapper.AnalysisMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Resource
    private AnalysisMapper analysisMapper;

    @Override
    public List<Analysis> findAllAnalysis() {
        AnalysisExample example = new AnalysisExample();
        return analysisMapper.selectByExample(example);
    }

    @Override
    public void insertAnalysis(Analysis analysis) {
        analysisMapper.insertSelective(analysis);
    }

    @Override
    public Boolean deleteAnalysis(Integer[] ids) {
        List<Integer> list = Arrays.asList(ids);
        AnalysisExample example = new AnalysisExample();
        AnalysisExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(list);
        int row = analysisMapper.deleteByExample(example);
        return row == ids.length;
    }

    @Override
    public Analysis lookanalysis(Integer id) {
        return analysisMapper.selectByPrimaryKey(id);
    }

    @Override
    public Analysis infoAnalysis(Integer id) {
        return analysisMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateAnalysis(Analysis analysis) {
        analysis.setUpdatetime(new Date());
        analysisMapper.updateByPrimaryKeySelective(analysis);
    }

    @Override
    public List<Analysis> likeAllAnalysis(Integer cid, String keyword, Integer orderby) {
        AnalysisExample example = new AnalysisExample();
        AnalysisExample.Criteria criteria = example.createCriteria();
        if(cid == 0){
            criteria.andPronameLike("%"+keyword+"%");
            AnalysisExample.Criteria criteria1 = example.createCriteria();
            criteria1.andTitleLike("%"+keyword+"%");
            example.or(criteria1);
        }else if(cid ==1){
            criteria.andPronameLike("%"+keyword+"%");
        }else{
            criteria.andTitleLike("%"+keyword+"%");
        }
        if(orderby == 1){
            example.setOrderByClause("addtime");
        }else if(orderby ==2){
            example.setOrderByClause("updatetime");
        }
        return analysisMapper.selectByExample(example);
    }
}
