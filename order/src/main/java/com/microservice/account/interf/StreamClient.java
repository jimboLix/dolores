package com.microservice.account.interf;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.interf
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/6/7
 */

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface StreamClient {
    String INPUT = "message";
//    @Input(StreamClient.INPUT)
//    SubscribableChannel input();

    @Output(StreamClient.INPUT)
    MessageChannel output();


}
