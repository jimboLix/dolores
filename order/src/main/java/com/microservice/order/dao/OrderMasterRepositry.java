package com.microservice.order.dao;

import com.microservice.order.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.order.dao
 * @Description:
 * @date 2018/5/13
 */
public interface OrderMasterRepositry extends JpaRepository<OrderMaster,String> {
}
