package com.captain.cloudmail.web;

import com.captain.cloudmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 邮件发送
 * Author: captain
 * Date: 2019/8/15
 */
@RestController
@RequestMapping(value = "/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping(value = "/simple-text")
    public String sendSingleSimpleText(@RequestBody Map<String, String> map) {
        if (!map.containsKey("targetEmail") || !map.containsKey("subject") || !map.containsKey("text")) {
            return "Please enter the completed information ";
        }
        // 目标邮箱
        String targetEmail = map.get("targetEmail");
        // 标题
        String subject = map.get("subject");
        // 发送内容
        String text = map.get("text");
        Boolean result = emailService.sendSingleSimpleTextEmail(targetEmail, subject, text);
        return result ? "send email success" : "send email fail";
    }

}
