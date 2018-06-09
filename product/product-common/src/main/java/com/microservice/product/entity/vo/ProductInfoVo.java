package com.microservice.product.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.entity.vo
 * @Description: 用于封装商品返回信息
 * @date 2018/5/9
 */
@Data
public class ProductInfoVo implements Serializable {
    private static final long serialVersionUID = 5684696840255920370L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private double productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
