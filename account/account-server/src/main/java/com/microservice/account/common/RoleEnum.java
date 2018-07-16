package com.microservice.account.common;

import lombok.Data;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.common
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/7/3
 */
public enum RoleEnum {
    BUYER(1,"buyer"),
    SALLER(2,"saller")
    ;

    private Integer code;
    private String role;

    RoleEnum(Integer code, String role) {
        this.code = code;
        this.role = role;
    }

    public Integer getCode() {
        return code;
    }

    public String getRole() {
        return role;
    }
}
