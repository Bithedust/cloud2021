package com.nick.springcloud.service.impl;

import com.nick.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @author Nick4Supreme
 * @date 2021/12/12
 */
@EnableBinding(Source.class) // 定义消息的推送通道
public class MessageProviderImpl implements IMessageProvider {

    private MessageChannel output;// 消息发送管道

    @Autowired
    public void setOutput(MessageChannel output) {
        this.output = output;
    }

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("******serial:" + serial);
        return null;
    }
}
