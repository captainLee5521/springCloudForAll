package com.captain.cloudmail.service.impl;

import com.captain.cloudmail.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * 邮件发送实现类
 * Author: captain
 * Date: 2019/8/15
 */
@Service
public class EmailServiceImpl implements EmailService {

    // slf简单门面日志
    private final static Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    MailProperties mailProperties; // 邮箱配置类

    @Autowired
    JavaMailSender javaMailSender; // 邮件发送服务

    @Override
    public Boolean sendSingleSimpleTextEmail(String targetEmail, String subject, String text) {
        logger.info(String.format("[send-single-simple-text-email-begin]，目标邮箱：%s", targetEmail));
        // 构建SimpleMailMessage
        try {
            SimpleMailMessage simpleMailMessage = getSimpleMailMessage(targetEmail, subject, text);
            javaMailSender.send(simpleMailMessage);
        } catch (MailException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 构建SimpleMailMessage
     * @param targetEmail 目标邮箱
     * @param subject 主题
     * @param text 文本内容
     * @return
     */
    private SimpleMailMessage getSimpleMailMessage(String targetEmail, String subject, String text){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailProperties.getUsername());
        simpleMailMessage.setTo(targetEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        return simpleMailMessage;
    }
}
