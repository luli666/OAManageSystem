package com.offcn.usual.controller;

import com.github.pagehelper.PageInfo;
import com.offcn.sys.bean.Employee;
import com.offcn.usual.bean.BaoXiao;
import com.offcn.usual.service.BaoXiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/bx")
public class BaoXiaoController {

    @Autowired
    private BaoXiaoService baoXiaoService;

    @RequestMapping("/insert")
    public String insertBaoXiao(BaoXiao baoXiao, HttpSession session) {
        /*获取报销人的id*/
        Employee employee = (Employee) session.getAttribute("employee");
        baoXiao.setEmpFk(employee.getEid());
        baoXiaoService.insertBaoXiao(baoXiao);
        return "redirect:/bx/list";
    }

    @RequestMapping("/list")
    public String listBaoXiao(Model model, HttpServletRequest request, HttpSession session, @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum) {
        String requestURI = request.getRequestURI();
        /*实现搜索查询的代码*/
        Map<String, Object> map = WebUtils.getParametersStartingWith(request, "search_");
        String cid = (String) map.get("cid");
        String keyword = (String) map.get("keyword");
        String orderby = (String) map.get("orderby");
        String params = "";
        if (cid != null || keyword != null || orderby != null) {
            params = "&search_cid=" + cid + "&search_keyword=" + keyword + "&search_orderby=" + orderby;
        }

        /*默认查询所有的代码*/
        Employee employee = (Employee) session.getAttribute("employee");
        /*错误代码，暂时使用*/
        if (employee == null) {
            return "redirect:/login.jsp";
        }
        PageInfo<BaoXiao> page = baoXiaoService.listBaoXiao(employee.getEid(), pageNum, map);
        model.addAttribute("page", page);
        model.addAttribute("params", params);
        model.addAttribute("requestURI", requestURI);
        return "mybaoxiao-base";
    }

}
