package com.microservice.order.common;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.order.common
 * @Description: 用于传输页面数据
 * @date 2018/5/13
 */
@Data
public class OrderForm {

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号码必填")
    private String phone;

    @NotEmpty(message = "收货地址必填")
    private String address;

    private String openId;

    @NotEmpty(message = "购买的商品必填")
    private String items;
}
