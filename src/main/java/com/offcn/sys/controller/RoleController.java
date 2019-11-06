package com.offcn.sys.controller;

import com.offcn.commons.ResultMap;
import com.offcn.sys.bean.Role;
import com.offcn.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/insert")
    @ResponseBody
    public ResultMap insertRole(Role role,Integer[] ids){
        roleService.insertRole(role,ids);
        return ResultMap.success();
    }
    @RequestMapping("/info")
    @ResponseBody
    public List<Role> infoRole(){
        return roleService.infoRole();
    }
}
