package com.microservice.product.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.entity.vo
 * @Description:
 * @date 2018/5/9
 */
@Data
public class ProductVo implements Serializable {
    private static final long serialVersionUID = 2735397562843163589L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    private List<ProductInfoVo> foods = new ArrayList<>(10);
}
