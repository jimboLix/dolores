package com.microservice.account.common;

import lombok.Getter;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.common
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/7/3
 */
@Getter
public enum ResultNum {
    LOGIN_FAIL(1,"登录失败"),
    ROLE_ERROR(2,"角色错误")
    ;

    private Integer code;
    private String message;

    ResultNum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
