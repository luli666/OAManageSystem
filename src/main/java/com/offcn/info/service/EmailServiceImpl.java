package com.offcn.info.service;

import com.offcn.info.bean.Email;
import com.offcn.info.mapper.EmailMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    private EmailMapper emailMapper;
    @Override
    public void insertEmail(Email email) {
        emailMapper.insertSelective(email);
    }
}
