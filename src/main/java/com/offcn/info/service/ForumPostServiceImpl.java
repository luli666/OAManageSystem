package com.offcn.info.service;

import com.offcn.info.bean.ForumPost;
import com.offcn.info.bean.ForumPostExample;
import com.offcn.info.mapper.ForumPostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ForumPostServiceImpl implements ForumPostService {

    @Resource
    private ForumPostMapper forumPostMapper;
    @Override
    public void insertForumPost(ForumPost forumPost) {
        forumPostMapper.insertSelective(forumPost);
    }

    @Override
    public List<ForumPost> infoInMain() {
        ForumPostExample example = new ForumPostExample();
        example.setOrderByClause("createtime desc limit 4");
        return forumPostMapper.selectByExample(example);
    }
}
