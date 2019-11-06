package com.offcn.sys.controller;

import com.offcn.commons.ResultMap;
import com.offcn.sys.bean.Sources;
import com.offcn.sys.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/source")
public class SourcesController {

    @Autowired
    private SourcesService sourcesService;

    @RequestMapping("/info")
    @ResponseBody
    public List<Sources> infoSources(){
        List<Sources> sources = sourcesService.infoSource(0);
        ergodicSource(sources.get(0));
        return sources;
    }
    //遍历所有
    private void ergodicSource(Sources sources) {
        Integer id = sources.getId();
        List<Sources> list = sourcesService.infoSource(id);
        for (Sources source : list) {
            ergodicSource(source);
        }
        sources.setChildren(list);
    }

    @RequestMapping("/insert")
    public String insertSource(Sources sources){
        sourcesService.insertSource(sources);
        return "redirect:/pm.jsp";
    }
    @RequestMapping("/look/{id}")
    public String lookSource(@PathVariable("id")Integer id, Model model){
        Sources sources = sourcesService.lookSource(id);
        model.addAttribute("onesource", sources);
        return "pm-edit";
    }
    @RequestMapping("/update")
    public String updateSource(Sources sources){
        sourcesService.updateSource(sources);
        return "redirect:/pm.jsp";
    }
    @RequestMapping("/delete")
    @ResponseBody
    public ResultMap deleteSource(Integer id){
        sourcesService.deleteSource(id);
        return ResultMap.success();
    }
}
