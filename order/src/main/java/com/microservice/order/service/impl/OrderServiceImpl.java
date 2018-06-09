package com.microservice.order.service.impl;

import com.microservice.order.common.OrderDTO;
import com.microservice.order.common.OrderStatusEnum;
import com.microservice.order.common.PayStatusEumn;
import com.microservice.order.dao.OrderDetailRepositry;
import com.microservice.order.dao.OrderMasterRepositry;
import com.microservice.order.entity.OrderDetail;
import com.microservice.order.entity.OrderMaster;
import com.microservice.order.service.OrderService;
import com.microservice.order.util.KeyUtil;
import com.microservice.product.clients.ProductClients;
import com.microservice.product.entity.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.order.service.impl
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/13
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMasterRepositry orderMasterRepositry;
    @Autowired
    private OrderDetailRepositry orderDetailRepositry;
    @Autowired
    private ProductClients productClients;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDTO create(OrderDTO orderDTO) throws Exception {
        String orderId = KeyUtil.getUniqueKey();
        List<String> productIdList = orderDTO.getItems().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfoOutput> productInfoOutputs = productClients.listForOrder(productIdList);
        orderDTO.setOrderId(KeyUtil.getUniqueKey());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEumn.UNPAYED.getCode());

        //计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail: orderDTO.getItems()) {
            for (ProductInfoOutput productInfo: productInfoOutputs) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    //单价*数量
                    orderAmout = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.getUniqueKey());
                    //订单详情入库
                    orderDetailRepositry.save(orderDetail);
                }
            }
        }
        //扣除库存

        //订单入库
        orderMasterRepositry.save(orderMaster);
        return null;
    }
}
