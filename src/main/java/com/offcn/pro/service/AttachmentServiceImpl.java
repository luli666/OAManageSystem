package com.offcn.pro.service;

import com.offcn.commons.Load;
import com.offcn.pro.bean.Attachment;
import com.offcn.pro.bean.AttachmentExample;
import com.offcn.pro.mapper.AttachmentMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Resource
    private AttachmentMapper attachmentMapper;

    @Override
    public void insertAttachment(Attachment attachment) {
        attachmentMapper.insertSelective(attachment);
    }

    @Override
    public List<Map<String, Object>> listAttachment() {
        return attachmentMapper.listAttachment();
    }

    @Override
    public Boolean deleteAllAttachment(Integer[] ids, HttpSession session) {
        String realPath = session.getServletContext().getRealPath("\\upload");
        List<Integer> list = Arrays.asList(ids);
        AttachmentExample example = new AttachmentExample();
        AttachmentExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(list);
        /*获取删除的全部信息，用于删除附件*/
        List<Attachment> attachments = attachmentMapper.selectByExample(example);
        for (Attachment attachment : attachments) {
            File file = new File(realPath+"\\"+attachment.getPath());
            file.delete();
        }
        /*删除数据库数据*/
        int row = attachmentMapper.deleteByExample(example);
        return row == ids.length;
    }

    @Override
    public Map<String, Object> lookAttachment(Integer id) {
        return attachmentMapper.lookAttachment(id);
    }

    @Override
    public ResponseEntity<byte[]> downloadAttachment(Integer id, HttpSession session) {
        Attachment attachment = attachmentMapper.selectByPrimaryKey(id);
        //路径前置
        String realpath = session.getServletContext().getRealPath("\\upload");
        //文件名
        String filepath = attachment.getPath();
        return Load.download(realpath,filepath);
    }

    @Override
    public Attachment backfillAttachment(Integer id) {
        Attachment attachment = attachmentMapper.selectByPrimaryKey(id);
        return attachment;
    }

    @Override
    public void updateAttachment(Attachment attachment) {
        attachmentMapper.updateByPrimaryKeySelective(attachment);
    }

    @Override
    public void deleteFile(Integer id, String realpath) {
        Attachment attachment = attachmentMapper.selectByPrimaryKey(id);
        String path = realpath + "\\" + attachment.getPath();
        File file = new File(path);
        file.delete();
    }

    @Override
    public List<Map<String, Object>> searchAttachment(Integer cid, String keyword, Integer orderby) {
        return attachmentMapper.searchAttachment(cid, keyword, orderby);
    }
}
