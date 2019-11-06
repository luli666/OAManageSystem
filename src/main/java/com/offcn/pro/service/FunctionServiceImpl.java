package com.offcn.pro.service;

import com.offcn.pro.bean.Function;
import com.offcn.pro.bean.FunctionExample;
import com.offcn.pro.mapper.FunctionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Resource
    private FunctionMapper functionMapper;

    @Override
    public List<Function> info(Integer id) {
        FunctionExample example = new FunctionExample();
        FunctionExample.Criteria criteria = example.createCriteria();
        criteria.andModeleFkEqualTo(id);
        List<Function> functions = functionMapper.selectByExample(example);
        return functions;
    }
}
