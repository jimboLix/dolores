package com.microservice.account.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.message
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/6/4
 */
@Slf4j
@Component
public class MessageReciver {

    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    public void reciver(String message){
        System.out.println("接受到消息"+message);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue("computer"),
                    exchange = @Exchange("myOrder"),
                    key = "computer"
            )
    )
    public void computerRecive(String message){
        log.info("电脑消息接受{}",message);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue("fruit"),
                    exchange = @Exchange("myOrder"),
                    key = "fruit"
            )
    )
    public void fruitReciver(String message){
        log.info("水果服务接受消息{}",message);
    }
}
