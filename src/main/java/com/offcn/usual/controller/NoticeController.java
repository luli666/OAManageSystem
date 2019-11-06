package com.offcn.usual.controller;

import com.github.pagehelper.PageInfo;
import com.offcn.commons.ResultMap;
import com.offcn.usual.bean.Notice;
import com.offcn.usual.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/insert")
    public String insertNotice(Notice notice){
        noticeService.insertNotice(notice);
        return "redirect:/notice.jsp";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultMap listNotice(@RequestParam(value = "pageNum",defaultValue = "0")Integer pageNum, HttpServletRequest request){
        /*获取参数*/
        Map<String, Object> map = WebUtils.getParametersStartingWith(request, "search_");
        String cid = (String) map.get("cid");
        String keyword = (String) map.get("keyword");
        String orderby = (String) map.get("orderby");
        String params = "";
        if(cid != null || keyword != null || orderby != null){
            params = "&search_cid=" + cid+ "&search_keyword="+keyword + "&search_orderby="+orderby;
        }
        PageInfo<Notice> page = noticeService.listNotice(pageNum,map);
        String requestURI = request.getRequestURI();
        return ResultMap.success().put("page", page).put("requestURI", requestURI).put("params", params);
    }
    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public ResultMap deleteNotice(@PathVariable("ids")Integer[] ids){
        boolean info = noticeService.deleteNotice(ids);
        if(info){
            return ResultMap.success();
        }else{
            return ResultMap.error();
        }
    }

    @RequestMapping("/show")
    @ResponseBody
    public ResultMap showNotice(){
        List<Notice> notices = noticeService.showNotice();
        return ResultMap.success().put("notices", notices);
    }
    @RequestMapping("/look/{id}")
    @ResponseBody
    public ResultMap lookNotice(@PathVariable("id")Integer id){
        Notice notice = noticeService.lookNotice(id);
        return ResultMap.success().put("notice", notice);
    }
}
