package com.microservice.account.dao;

import com.microservice.account.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.dao
 * @Description:
 * @date 2018/5/13
 */
public interface OrderDetailRepositry extends JpaRepository<OrderDetail,String> {
}
