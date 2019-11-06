package com.offcn.info.mapper;

import com.offcn.info.bean.ForumPost;
import com.offcn.info.bean.ForumPostExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ForumPostMapper {
    int countByExample(ForumPostExample example);

    int deleteByExample(ForumPostExample example);

    int deleteByPrimaryKey(Integer forumid);

    int insert(ForumPost record);

    int insertSelective(ForumPost record);

    List<ForumPost> selectByExample(ForumPostExample example);

    ForumPost selectByPrimaryKey(Integer forumid);

    int updateByExampleSelective(@Param("record") ForumPost record, @Param("example") ForumPostExample example);

    int updateByExample(@Param("record") ForumPost record, @Param("example") ForumPostExample example);

    int updateByPrimaryKeySelective(ForumPost record);

    int updateByPrimaryKey(ForumPost record);
}