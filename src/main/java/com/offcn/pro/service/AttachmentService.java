package com.offcn.pro.service;

import com.offcn.pro.bean.Attachment;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface AttachmentService {
    void insertAttachment(Attachment attachment);

    List<Map<String, Object>> listAttachment();

    Boolean deleteAllAttachment(Integer[] ids, HttpSession session);

    Map<String, Object> lookAttachment(Integer id);

    ResponseEntity<byte[]> downloadAttachment(Integer id, HttpSession session);

    Attachment backfillAttachment(Integer id);

    void updateAttachment(Attachment attachment);

    void deleteFile(Integer id, String oldpath);

    List<Map<String, Object>> searchAttachment(Integer cid, String keyword, Integer orderby);
}
