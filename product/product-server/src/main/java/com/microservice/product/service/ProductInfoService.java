package com.microservice.product.service;

import com.microservice.product.entity.DecreaseStockInput;
import com.microservice.product.entity.ProductInfo;
import com.microservice.product.entity.ProductInfoOutput;

import java.util.List;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.service
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/6
 */
public interface ProductInfoService {

    /**
     * 获取所有的在线商品
     * @return
     */
    List<ProductInfo> getAllUp();

    List<ProductInfoOutput> productListForOrder(List<String> productIdList);

    void decreaseStock(List<DecreaseStockInput> inputs);
}
