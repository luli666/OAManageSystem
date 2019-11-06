package com.offcn.sys.service;

import com.offcn.sys.bean.RoleSourcesKey;
import com.offcn.sys.mapper.RoleSourcesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleSourcesServiceImpl implements RoleSourcesService {
    @Resource
    private RoleSourcesMapper roleSourcesMapper;
    @Override
    public void insertRoleSources(RoleSourcesKey sourcesKey) {
        roleSourcesMapper.insertSelective(sourcesKey);
    }
}
