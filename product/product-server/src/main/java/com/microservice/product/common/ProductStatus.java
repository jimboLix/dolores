package com.microservice.product.common;

import lombok.Getter;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.common
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/6
 */
@Getter
public enum ProductStatus {
    UP(0,"在线"),
    DOWN(1,"下线"),
    ;

    private Integer status;
    private String msg;

    ProductStatus(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
