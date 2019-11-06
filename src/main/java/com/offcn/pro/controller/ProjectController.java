package com.offcn.pro.controller;

import com.offcn.pro.bean.Project;
import com.offcn.pro.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/list")
    public String findAllProject(Model model){
        List<Project> projects = projectService.findAllProject();
        model.addAttribute("projects", projects);
        return "project-base";
    }
    @RequestMapping("/insert")
    public String insertProject(Project project){
        projectService.insertProject(project);
        return "redirect:/project/list";
    }
    @RequestMapping("/look/{pid}")
    public String lookProject(@PathVariable("pid") Integer pid,Model model){
        Project project = projectService.lookProject(pid);
        model.addAttribute("project", project);
        return "project-base-look";
    }
    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public HashMap<String,Object> deleteProject(@PathVariable("ids") String ids){
        Boolean info = projectService.deleteProject(ids);
        HashMap<String,Object> map = new HashMap<>();
        if(info){
            map.put("status", 200);
            map.put("msg", "删除成功");
        }else{
            map.put("status", 500);
            map.put("msg", "删除失败");
        }
        return map;
    }
    @RequestMapping("/edit/{pid}")
    public String editProject(@PathVariable("pid") Integer pid, Model model){
        Project project = projectService.editProject(pid);
        model.addAttribute("project", project);
        return "project-base-edit";
    }
    @RequestMapping("/update")
    public String updateProject(Project project){
        projectService.updateProject(project);
        return "redirect:/project/list";
    }
    @RequestMapping("/search")
    public String searchProject(Integer cid,String keyword,Integer orderby,Model model){
        List<Project> projects = projectService.searchProject(cid,keyword,orderby);
        model.addAttribute("projects", projects);
        return "project-base";
    }
    @RequestMapping("/info")
    @ResponseBody
    public List<Map<String, Object>> infoProject(){
        return projectService.infoProject();
    }
    @RequestMapping("/infoAndAtta")
    @ResponseBody
    public List<Project> infoAndAtta(){
        return projectService.infoAndAtta();
    }
}
