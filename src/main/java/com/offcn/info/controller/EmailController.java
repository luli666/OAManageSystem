package com.offcn.info.controller;

import com.offcn.commons.EmailJob;
import com.offcn.info.bean.Email;
import com.offcn.info.service.EmailService;
import com.offcn.sys.bean.Employee;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @Autowired
    private EmailService emailService;

    @RequestMapping("/insert")
    public String insertEmail(Email email, MultipartFile multipart, HttpSession session) throws Exception{
        String filename = multipart.getOriginalFilename();
        String path = "D:\\wrokspace\\ideaspace\\pms\\src\\main\\webapp\\upload\\";
        multipart.transferTo(new File(path+filename));

        //创建JobDetail对象，指定对象的任务名称、组名
        JobDetail job = JobBuilder.newJob(EmailJob.class).withIdentity("job1", "group1").build();

        JobDataMap jobDataMap = job.getJobDataMap();
        jobDataMap.put("email", email);
        jobDataMap.put("JavaMailSenderImpl", javaMailSender);
        jobDataMap.put("filename", filename);
        jobDataMap.put("path", path);


        //创建SimpleTrigger对象，指定对象名称、组名  设置任务重复执行间隔时间，重复执行次数 启动时间
        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(SimpleScheduleBuilder.simpleSchedule()).startAt(new Date()).build();
                //withIntervalInSeconds(10).//重复间隔
                        //withRepeatCount(3)).//重复次数，一直重复的话设置repeatForever()

        //创建任务管理器Scheduler对象
        Scheduler sched= StdSchedulerFactory.getDefaultScheduler();
        jobDataMap.put("sched", sched);
        //为Scheduler对象新增JOB以及对应的SimpleTrigger
        Date ft = sched.scheduleJob(job, trigger);
        //启动定时任务管理器
        sched.start();

        /*保存数据库*/
        email.setSendtime(new Date());
        Employee employee = (Employee) session.getAttribute("employee");
        email.setEmpFk(employee.getEid());
        email.setPath("D:\\wrokspace\\ideaspace\\pms\\src\\main\\webapp\\upload\\" + multipart.getOriginalFilename());
        emailService.insertEmail(email);
        return "redirect:/message.jsp";
    }
}
