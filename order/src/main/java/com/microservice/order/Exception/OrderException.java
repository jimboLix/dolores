package com.microservice.order.Exception;

import com.microservice.order.common.ResultEnum;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.order.Exception
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/13
 */
public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum r){
        super(r.getMessage());
        this.code = r.getCode();
    }

}
