package com.microservice.account;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/6/4
 */
public class RabbirSendMessage extends OrderApplicationTests {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void sendMesage(){
        amqpTemplate.convertAndSend("myQueue","消息发送测试");
    }

    @Test
    public void sendComputer(){
        amqpTemplate.convertAndSend("myOrder","computer","电脑服务订单");
    }

    @Test
    public void sendFruit(){
        amqpTemplate.convertAndSend("myOrder","fruit","水果服务订单");
    }
}
