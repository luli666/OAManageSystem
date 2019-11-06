package com.offcn.sys.controller;

import com.offcn.commons.ResultMap;
import com.offcn.sys.bean.Employee;
import com.offcn.sys.bean.Sources;
import com.offcn.sys.service.EmployeeService;
import com.offcn.sys.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SourcesService sourcesService;

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return null;
    }

    @RequestMapping("/login")
    public String login(Employee employee, String code, HttpSession session, RedirectAttributes redirectAttributes){
        String validateCode = (String) session.getAttribute("validateCode");
        if(code.equalsIgnoreCase(validateCode)){
            //移除验证码
            session.removeAttribute("validateCode");
            Employee emp = employeeService.login(employee);
            if(emp != null){
                session.setAttribute("employee",emp);
                List<Sources> list = sourcesService.lookMenu(emp.getEid());
                session.setAttribute("sources", list);
                return "redirect:/index.jsp";
            }else{
                redirectAttributes.addFlashAttribute("info", "用户名或密码错误");
                return "redirect:/login";
            }
        }
        redirectAttributes.addFlashAttribute("info", "验证码错误");
        return "redirect:/login";
    }

    @RequestMapping("/list")
    public String findAllEmployee(Model model){
        List<Employee> employees = employeeService.findAllEmployee();
        model.addAttribute("employees", employees);
        return "user";
    }
    @RequestMapping("/info")
    @ResponseBody
    public List<Employee> infoEmployee(){
        List<Employee> employees = employeeService.infoEmployee();
        return employees;
    }
    @RequestMapping("/infoAndEmail")
    @ResponseBody
    public ResultMap infoAndEmail(HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        List<Map<String,Object>> list = employeeService.infoAndEmail(employee.getEid());
        return ResultMap.success().put("list", list);
    }
    @RequestMapping("/insert")
    public String insertEmployee(Employee employee,Integer[] ids){
        employeeService.insertEmployee(employee,ids);
        return "redirect:/user.jsp";
    }
}
