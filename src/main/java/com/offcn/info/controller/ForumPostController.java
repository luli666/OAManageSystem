package com.offcn.info.controller;

import com.offcn.commons.ResultMap;
import com.offcn.info.bean.ForumPost;
import com.offcn.info.service.ForumPostService;
import com.offcn.sys.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/forumpost")
public class ForumPostController {
    @Autowired
    private ForumPostService forumPostService;

    @RequestMapping("/insert")
    public String insertForumPost(ForumPost forumPost, HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        forumPost.setEmpFk3(employee.getEid());
        forumPost.setCreatetime(new Date());
        forumPost.setStatus(0);
        forumPostService.insertForumPost(forumPost);
        return "redirect:/main.jsp";
    }
    @RequestMapping("/infoInMain")
    @ResponseBody
    public ResultMap infoInMain(){
        List<ForumPost> list = forumPostService.infoInMain();
        return ResultMap.success().put("list", list);
    }

}
