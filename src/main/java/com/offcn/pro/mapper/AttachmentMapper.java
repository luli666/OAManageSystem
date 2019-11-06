package com.offcn.pro.mapper;

import com.offcn.pro.bean.Attachment;
import com.offcn.pro.bean.AttachmentExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AttachmentMapper {
    int countByExample(AttachmentExample example);

    int deleteByExample(AttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    List<Attachment> selectByExample(AttachmentExample example);

    Attachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Attachment record, @Param("example") AttachmentExample example);

    int updateByExample(@Param("record") Attachment record, @Param("example") AttachmentExample example);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);

    List<Map<String, Object>> listAttachment();

    Map<String, Object> lookAttachment(Integer id);
    List<Map<String, Object>> searchAttachment(@Param("cid") Integer cid,@Param("keyword") String keyword,@Param("orderby") Integer orderby);
}