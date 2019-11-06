package com.offcn.info.service;

import com.offcn.info.bean.ForumPost;

import java.util.List;

public interface ForumPostService {
    void insertForumPost(ForumPost forumPost);

    List<ForumPost> infoInMain();
}
