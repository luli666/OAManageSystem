package com.offcn.pro.controller;

import com.offcn.pro.bean.Function;
import com.offcn.pro.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    /*回填task表数据*/
    @RequestMapping("/info/{id}")
    @ResponseBody
    public List<Function> info(@PathVariable("id")Integer id){
        return functionService.info(id);
    }
}
