package com.microservice.order.controller;

import com.microservice.order.interf.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.order.controller
 * @Description: 发送消息
 * @date 2018/6/7
 */
@RestController
@RequestMapping("/send")
public class SendMessageController {
    @Autowired
    private StreamClient streamFance;

    @RequestMapping("/{message}")
    public void send(@PathVariable String message) {
        streamFance.output().send(MessageBuilder.withPayload(message).build());
    }
}
