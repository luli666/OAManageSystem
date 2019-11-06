package com.offcn.sys.service;

import com.offcn.sys.bean.Role;
import com.offcn.sys.bean.RoleExample;
import com.offcn.sys.bean.RoleSourcesKey;
import com.offcn.sys.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleSourcesService roleSourcesService;

    @Override
    public void insertRole(Role role, Integer[] ids) {
        roleMapper.insertRole(role);
        for (Integer id : ids) {
            RoleSourcesKey sourcesKey = new RoleSourcesKey();
            sourcesKey.setRid(role.getRoleid());
            sourcesKey.setSid(id);
            roleSourcesService.insertRoleSources(sourcesKey);
        }
    }

    @Override
    public List<Role> infoRole() {
        RoleExample example = new RoleExample();
        return roleMapper.selectByExample(example);
    }
}
