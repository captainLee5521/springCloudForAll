package com.captain.cloudmail.service;

/**
 * 邮件发送interface
 * Author: captain
 * Date: 2019/8/15
 */
public interface EmailService {

    /**
     * 发送单个简单文本邮箱
     * @param targetEmail 接收邮箱
     * @param subject 标题
     * @param text 内容
     * @return
     */
    Boolean sendSingleSimpleTextEmail(String targetEmail, String subject, String text);
}
