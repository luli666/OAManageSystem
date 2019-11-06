package com.offcn.commons;

import com.offcn.info.bean.Email;
import org.quartz.*;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

public class EmailJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        Email email = (Email) jobDataMap.get("email");
        JavaMailSenderImpl javaMailSender = (JavaMailSenderImpl) jobDataMap.get("JavaMailSenderImpl");
        Scheduler sched = (Scheduler) jobDataMap.get("sched");

        try{
            //邮件对象
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"UTF-8");

            helper.setFrom("13513840355@163.com");
            helper.setTo(email.getEname());
            helper.setSubject(email.getTitle());
            helper.setText(email.getContent());

            /*附件处理*/
            String filename = (String) jobDataMap.get("filename");
            String path = (String) jobDataMap.get("path");
            File file = new File(path + filename);
            helper.addAttachment(filename, file);

            //发送邮件
            javaMailSender.send(mimeMessage);
            sched.shutdown(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
