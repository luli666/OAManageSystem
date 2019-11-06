package com.offcn.info.mapper;

import com.offcn.info.bean.Email;
import com.offcn.info.bean.EmailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmailMapper {
    int countByExample(EmailExample example);

    int deleteByExample(EmailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Email record);

    int insertSelective(Email record);

    List<Email> selectByExample(EmailExample example);

    Email selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Email record, @Param("example") EmailExample example);

    int updateByExample(@Param("record") Email record, @Param("example") EmailExample example);

    int updateByPrimaryKeySelective(Email record);

    int updateByPrimaryKey(Email record);
}