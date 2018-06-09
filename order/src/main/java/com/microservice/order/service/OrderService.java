package com.microservice.order.service;

import com.microservice.order.common.OrderDTO;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.order.service
 * @Description:
 * @date 2018/5/13
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     * @throws Exception
     */
    OrderDTO create(OrderDTO orderDTO)throws Exception;
}
