package com.offcn.pro.controller;
import com.offcn.commons.Load;
import com.offcn.pro.bean.Attachment;
import com.offcn.pro.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    /*同步方式添加数据，上传文件*/
    @RequestMapping("/insert")
    public String insertAttachment(Attachment attachment, MultipartFile multipart, HttpSession session){
        ServletContext servletContext = session.getServletContext();
        /*获取上传文件的绝对路径*/
        String realPath = servletContext.getRealPath("\\upload");
        /*上传文件*/
        String path = Load.upload(multipart,realPath);
        attachment.setPath(path);

        attachmentService.insertAttachment(attachment);
        return "project-file";
    }
    /*异步方式上传文件*/
    @RequestMapping("/insert1")
    @ResponseBody
    public Map<String,Object> insertAttachment1(Attachment attachment, MultipartFile multipart, HttpSession session){
        ServletContext servletContext = session.getServletContext();
        /*获取上传文件的绝对路径*/
        String realPath = servletContext.getRealPath("\\upload");
        /*上传文件*/
        String path = Load.upload(multipart,realPath);
        attachment.setPath(path);

        attachmentService.insertAttachment(attachment);

        Map<String,Object> map = new HashMap<>();
        map.put("statusCode", 200);
        map.put("msg", "保存成功");
        return map;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Map<String,Object>> listAttachment(){
        return attachmentService.listAttachment();
    }
    @RequestMapping("/deleteAll/{ids}")
    @ResponseBody
    public Map<String,Object> deleteAllAttachment(@PathVariable("ids") Integer[] ids,HttpSession session){
        Map<String,Object> map = new HashMap<>();
        Boolean info = attachmentService.deleteAllAttachment(ids,session);
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
    public String lookAttachment(@PathVariable("id") Integer id, Model model){
        Map<String,Object> map = attachmentService.lookAttachment(id);
        model.addAttribute("map", map);
        return "project-file-look";
    }
    @RequestMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadAttachment(@PathVariable("id") Integer id, HttpSession session){
        return attachmentService.downloadAttachment(id, session);
    }
    @RequestMapping("/backfill/{id}")
    public String backfillAttachment(@PathVariable("id")Integer id,Model model){
        Attachment attachment = attachmentService.backfillAttachment(id);
        model.addAttribute("attachment", attachment);
        return "project-file-edit";
    }
    @RequestMapping("/update")
    public String updateAttachment(Attachment attachment,MultipartFile multipart,HttpSession session){
        //若multipart不为空时，重写
        if(!multipart.getOriginalFilename().equals("")){
            //获取真实路径
            String realPath = session.getServletContext().getRealPath("\\upload");
            //删除源文件文件
            attachmentService.deleteFile(attachment.getId(),realPath);
            //上传
            String path = Load.upload(multipart, realPath);
            //设置新的path属性
            attachment.setPath(path);
        }
        attachmentService.updateAttachment(attachment);
        return "project-file";
    }
    /*查找*/
    @RequestMapping("/search")
    public String searchAttachment(Integer cid,String keyword,Integer orderby,Model model){
        List<Map<String, Object>> list = attachmentService.searchAttachment(cid, keyword, orderby);
        model.addAttribute("list", list);
        model.addAttribute("info", 1);
        return "project-file";
    }

}
