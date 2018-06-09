package com.microservice.product.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.entity
 * @Description:
 * @date 2018/5/6
 */
@Data
@Entity
public class ProductInfo implements Serializable {

    @Id
    private String productId;

    private String productName;

    private double productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

}
