package com.offcn.usual.controller;

import com.offcn.sys.bean.Employee;
import com.offcn.usual.bean.Task;
import com.offcn.usual.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/insert")
    public String insertTask(Task task, HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        task.setEmpFk(employee.getEid());
        //设置初始化状态
        task.setStatus(0);
        taskService.insertTask(task);

        return "redirect:/task.jsp";
    }
    @RequestMapping("/list")
    @ResponseBody
    public List<Map<String,Object>> listTask(){
        return taskService.listTask();
    }
    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public Map<String,Object> deleteTask(@PathVariable("ids")Integer[] ids){
        Boolean info = taskService.deleteTask(ids);
        Map<String,Object> map = new HashMap<>();
        if(info){
            map.put("statusCode", 200);
            map.put("msg", "删除成功");
        }else{
            map.put("statusCode", 500);
            map.put("msg", "删除失败");
        }
        return map;
    }
    @RequestMapping("/look/{id}")
    public String lookTask(@PathVariable("id")Integer id, Model model){
        /*获取所有的信息及分配任务的人*/
        Map<String,Object> task = taskService.lookTask(id);
        /*获取执行任务的人*/
        Map<String,Object> task1 = taskService.lookTask1(id);
        model.addAttribute("task", task);
        model.addAttribute("task1", task1);
        return "task-look";
    }
}
