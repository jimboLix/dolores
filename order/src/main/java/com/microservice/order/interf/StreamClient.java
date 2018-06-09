package com.microservice.order.interf;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.order.interf
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/6/7
 */

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
public interface StreamClient {
    String INPUT = "message";
    String OUTPUT = "message1";
    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();


}
