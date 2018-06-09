package com.microservice.product.service.impl;

import com.microservice.product.common.ProductStatus;
import com.microservice.product.entity.ProductInfo;
import com.microservice.product.entity.ProductInfoOutput;
import com.microservice.product.reponsitory.ProductInfoRepository;
import com.microservice.product.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.service
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/6
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * 获取所有上架的商品
     *
     * @return
     */
    @Override
    public List<ProductInfo> getAllUp() {
        return productInfoRepository.findByProductStatus(ProductStatus.UP.getStatus());
    }

    @Override
    public List<ProductInfoOutput> productListForOrder(List<String> productIdList) {
        productInfoRepository.findByProductIdIn(productIdList).stream().map(e -> {
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(e, productInfoOutput);
            return productInfoOutput;
        }).collect(Collectors.toList());
        return null;
    }
}
