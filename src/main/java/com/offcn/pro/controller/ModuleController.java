package com.offcn.pro.controller;

import com.offcn.pro.bean.Module;
import com.offcn.pro.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/moduls")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @RequestMapping("/info/{id}")
    @ResponseBody
    public List<Module> info(@PathVariable("id") Integer id){
        return moduleService.info(id);
    }
}
