package com.microservice.order.common;

import com.microservice.order.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.order.common
 * @Description: 对订单进行数据传输的封装类
 * @date 2018/5/13
 */
@Data
public class OrderDTO {
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;//订单总金额

    private Integer orderStatus = 0;//订单状态，默认为新下单

    private Integer payStatus = 0;//支付状态，默认为未支付

    private List<OrderDetail> items = new ArrayList<>();
}
