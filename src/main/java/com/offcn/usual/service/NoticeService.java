package com.offcn.usual.service;

import com.github.pagehelper.PageInfo;
import com.offcn.usual.bean.Notice;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    void insertNotice(Notice notice);

    PageInfo<Notice> listNotice(Integer pageNum, Map<String, Object> map);

    boolean deleteNotice(Integer[] ids);

    List<Notice> showNotice();

    Notice lookNotice(Integer id);
}
