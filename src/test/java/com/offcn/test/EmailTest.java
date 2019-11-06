package com.offcn.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

public class EmailTest {

    @Test
    public void test01() throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-email.xml");
        JavaMailSenderImpl bean = context.getBean(JavaMailSenderImpl.class);
        //邮件对象
        MimeMessage mimeMessage = bean.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"UTF-8");

        helper.setFrom("13513840355@163.com");
        helper.setTo("525265378@qq.com");
        helper.setSubject("网易邮件测试");
        /*helper.setText("<html><body><span style='color:red;'>发送html样式</span></body></html>",true);*/
        helper.setText("<html><body><span style='color:red;'>发送html样式</span><img src=cid:img /><p>这是一个晴朗的早晨，。。</p></body></html>",true);

        /*添加附件*/
        FileSystemResource resource = new FileSystemResource(new File("C:\\Users\\Administrator\\Desktop\\dlrb.jpg"));
        helper.addAttachment("dlrb.jpg", resource);
        FileSystemResource resource1 = new FileSystemResource(new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));
        helper.addInline("img", resource1);

        //发送邮件
        bean.send(mimeMessage);

        System.out.println("发送成功");
    }
}
