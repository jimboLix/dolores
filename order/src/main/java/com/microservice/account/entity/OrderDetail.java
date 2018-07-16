package com.microservice.account.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.entity
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/10
 */
@Entity(name = "order_detail" )
@Data
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = -1758867123739232297L;

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;//数量

    private String productIcon;//小图标

    private Date createTime;

    private Date updateTime;
}
