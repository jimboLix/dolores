package com.microservice.order.dao;

import com.microservice.order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.order.dao
 * @Description:
 * @date 2018/5/13
 */
public interface OrderDetailRepositry extends JpaRepository<OrderDetail,String> {
}
