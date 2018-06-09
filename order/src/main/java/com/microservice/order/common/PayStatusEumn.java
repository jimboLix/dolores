package com.microservice.order.common;

import lombok.Getter;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.order.common
 * @Description: 支付状态枚举
 * @date 2018/5/13
 */
@Getter
public enum PayStatusEumn {
    PAYED(0, "已支付"),
    UNPAYED(1, "未支付");


    private Integer code;

    private String messgae;

    PayStatusEumn(Integer code, String messgae) {
        this.code = code;
        this.messgae = messgae;
    }
}
