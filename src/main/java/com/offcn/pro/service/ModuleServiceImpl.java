package com.offcn.pro.service;

import com.offcn.pro.bean.Module;
import com.offcn.pro.bean.ModuleExample;
import com.offcn.pro.mapper.ModuleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService{
    @Resource
    private ModuleMapper moduleMapper;
    @Override
    public List<Module> info(Integer id) {
        ModuleExample example = new ModuleExample();
        ModuleExample.Criteria criteria = example.createCriteria();
        criteria.andAnalysisFkEqualTo(id);
        List<Module> modules = moduleMapper.selectByExample(example);
        return modules;
    }
}
