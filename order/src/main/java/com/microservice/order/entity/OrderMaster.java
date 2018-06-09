package com.microservice.order.entity;

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
 * @Package com.microservice.order.entity
 * @Description:
 * @date 2018/5/10
 */
@Data
@Entity(name = "order_master")
public class OrderMaster implements Serializable{
    private static final long serialVersionUID = 6817058089454716212L;

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;//订单总金额

    private Integer orderStatus = 0;//订单状态，默认为新下单

    private Integer payStatus = 0;//支付状态，默认为未支付

    private Date createTime;//创建时间

    private Date updateTime;//更新时间
}
