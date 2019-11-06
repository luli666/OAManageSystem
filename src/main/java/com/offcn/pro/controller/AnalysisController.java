package com.offcn.pro.controller;

import com.offcn.pro.bean.Analysis;
import com.offcn.pro.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    /*@RequestMapping("/list")
    @ResponseBody
    public List<Analysis> findAllAnalysis(){
        return analysisService.findAllAnalysis();
    }*/
    @RequestMapping("/list")
    @ResponseBody
    public List<Analysis> findAllAnalysis(Integer cid,String keyword,Integer orderby){
        if(cid == null && keyword == null && orderby == null){
            return analysisService.findAllAnalysis();
        }else{
            return analysisService.likeAllAnalysis(cid,keyword,orderby);
        }
    }
    @RequestMapping("/insert")
    public String insertAnalysis(Analysis analysis){
        /*处理id*/
        String proname = analysis.getProname();
        String[] split = proname.split(",");
        analysis.setId(Integer.valueOf(split[0]));
        analysis.setProname(split[1]);

        analysis.setAddtime(new Date());
        analysis.setUpdatetime(new Date());
        analysisService.insertAnalysis(analysis);
        return "project-need";
    }
    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public HashMap<String, Object> deleteAnalysis(@PathVariable("ids") Integer[] ids){
        HashMap<String, Object> map = new HashMap<>();
        Boolean info = analysisService.deleteAnalysis(ids);
        if(info){
            map.put("status", 200);
            map.put("msg", "删除成功");
        }else{
            map.put("status", 500);
            map.put("msg", "删除失败");
        }
        return map;
    }
    @RequestMapping("/look/{id}")
    public String lookAnalysis(@PathVariable("id")Integer id, Model model){
        Analysis analysis = analysisService.lookanalysis(id);
        model.addAttribute("analysis", analysis);
        return "project-need-look";
    }
    @RequestMapping("/info/{id}")
    public String infoAnalysis(@PathVariable("id") Integer id,Model model){
        Analysis analysis = analysisService.infoAnalysis(id);
        model.addAttribute("analysis", analysis);
        return "project-need-edit";
    }
    @RequestMapping("/update")
    public String updateAnalysis(Analysis analysis){
        analysisService.updateAnalysis(analysis);
        return "redirect:/project-need.jsp";
    }
    /*回填task表信息*/
    @RequestMapping("/info1/{id}")
    @ResponseBody
    public Analysis info1(@PathVariable("id")Integer id){
        return analysisService.infoAnalysis(id);
    }

}
