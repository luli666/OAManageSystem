package com.offcn.usual.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.commons.Page;
import com.offcn.usual.bean.Notice;
import com.offcn.usual.bean.NoticeExample;
import com.offcn.usual.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeMapper noticeMapper;
    @Override
    public void insertNotice(Notice notice) {
        notice.setNdate(new Date());
        noticeMapper.insertSelective(notice);
    }

    @Override
    public PageInfo<Notice> listNotice(Integer pageNum, Map<String, Object> map) {
        PageHelper.startPage(pageNum, Page.PAGESIZE);
        /*获取参数*/
        String param1 = (String) map.get("cid");
        String keyword = (String) map.get("keyword");
        String param2 = (String) map.get("orderby");

        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        if(param1 != null || keyword != null ||param2 != null){
            Integer cid = -1;
            Integer orderby = -1;
            if(param1 != null){
                cid = Integer.valueOf(param1);
            }
            if(param2 != null){
                orderby = Integer.valueOf(param2);
            }
            if(cid == 0){
                criteria.andNtitleLike("%"+keyword + "%");
                NoticeExample.Criteria criteria1 = example.createCriteria();
                criteria1.andRemarkLike("%"+keyword + "%");
                example.or(criteria1);
            }else if(cid == 1){
                criteria.andNtitleLike("%"+keyword + "%");
            }else{
                criteria.andRemarkLike("%"+keyword + "%");
            }
            if(orderby == 1){
                example.setOrderByClause("ndate asc");
            }else if(orderby == 2){
                example.setOrderByClause("ndate desc");
            }
        }
        List<Notice> notices = noticeMapper.selectByExample(example);
        PageInfo<Notice> page = new PageInfo<>(notices, 3);
        return page;
    }

    @Override
    public boolean deleteNotice(Integer[] ids) {
        List<Integer> list = Arrays.asList(ids);
        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        criteria.andNidIn(list);
        int row = noticeMapper.deleteByExample(example);
        return row == ids.length;
    }

    @Override
    public List<Notice> showNotice() {
        NoticeExample example = new NoticeExample();
        example.setOrderByClause("ndate desc limit 3");
        List<Notice> notices = noticeMapper.selectByExample(example);
        return notices;
    }

    @Override
    public Notice lookNotice(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }
}
