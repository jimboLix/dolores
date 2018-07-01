package com.microservice.product.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.message
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/6/17
 */
public interface ProductMessageCLient {

     final String MESSAGENAME = "ProductOutPut";

    @Input(ProductMessageCLient.MESSAGENAME)
    MessageChannel input();
}
