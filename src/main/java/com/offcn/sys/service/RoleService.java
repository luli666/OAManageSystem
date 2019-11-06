package com.offcn.sys.service;

import com.offcn.sys.bean.Role;

import java.util.List;

public interface RoleService {
    void insertRole(Role role, Integer[] ids);

    List<Role> infoRole();
}
