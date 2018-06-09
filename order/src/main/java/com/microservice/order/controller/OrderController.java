package com.microservice.order.controller;

import com.microservice.order.Exception.OrderException;
import com.microservice.order.common.OrderDTO;
import com.microservice.order.common.OrderForm;
import com.microservice.order.common.ResultEnum;
import com.microservice.order.entity.vo.ResultVo;
import com.microservice.order.service.OrderService;
import com.microservice.order.util.CovertFormToDTO;
import com.microservice.order.util.ResultVoUtil;
import com.microservice.product.clients.ProductClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.order.controller
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/13
 */
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/create")
    public ResultVo<Map> create(@Validated OrderForm orderForm, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单参数错误】,orderFomrm ={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = CovertFormToDTO.convert(orderForm, null);
        if (CollectionUtils.isEmpty(orderDTO.getItems())) {
            log.error("【购物信息为空】");
            throw new OrderException(ResultEnum.CAR_EMPTY);
        }

        OrderDTO dto = orderService.create(orderDTO);
        Map resultMap = new HashMap();
        resultMap.put("orderId", dto.getOrderId());
        ResultVo resultVo = ResultVoUtil.success(resultMap);
        return resultVo;
    }
    @Autowired
    private ProductClients productClients;
    @RequestMapping("/test")
    public Object test(){
        return productClients.getProductList();
    }
}
