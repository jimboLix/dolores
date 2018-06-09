package com.microservice.order.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microservice.order.common.OrderDTO;
import com.microservice.order.common.OrderForm;
import com.microservice.order.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.order.util
 * @Description: 将OrderForm对象转化为OrderDTO对象
 * @date 2018/5/13
 */
@Slf4j
public class CovertFormToDTO {

    public static OrderDTO convert(OrderForm orderForm, OrderDTO orderDTO) {
        if (null == orderForm) {
            return null;
        }

        if (null == orderDTO) {
            orderDTO = new OrderDTO();
        }
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setOrderId(orderForm.getOpenId());
        Gson gson = new Gson();
        List<OrderDetail> orderDetails = null;
        try {
            orderDetails = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("【json转换错误】,string={}", orderForm.getItems());
        }

        orderDTO.setItems(orderDetails);
        return orderDTO;
    }
}
