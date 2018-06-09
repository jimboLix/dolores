package com.microservice.order.message;

import com.microservice.order.interf.StreamClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.order.message
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/6/7
 */
@EnableBinding(StreamClient.class)
@Slf4j
@Component
public class StreamMessageReceiver {

    @StreamListener(StreamClient.INPUT)
    public void receive(Object message){
        log.info("接收的消息内容是{}",message.toString());
    }

}
