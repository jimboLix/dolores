package com.microservice.account.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microservice.product.entity.ProductInfoOutput;
import com.microservice.product.entity.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.message
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/6/18
 */
@Component
@Slf4j
public class ProductMessageReciver {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private final String REDISKEY = "product_quantity_%s";

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void reciveStock(String productOut) {
        log.info("接受到的消息队列是{}", productOut);
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>) JsonUtil.fromJson(productOut,
                new TypeReference<List<ProductInfoOutput>>() {
                });
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            stringRedisTemplate.opsForValue().set(String.format(REDISKEY, productInfoOutput.getProductId()), String.valueOf(productInfoOutput.getProductStock()));
        }
    }
}
