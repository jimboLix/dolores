package com.microservice.account.common;

import lombok.Getter;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.common
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/13
 */
@Getter
public enum  ResultEnum {
    PARAM_ERROR(-1,"参数错误"),
    CAR_EMPTY(-2,"购物车为空")
    ;

    private Integer code;

    private String message;

     ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
