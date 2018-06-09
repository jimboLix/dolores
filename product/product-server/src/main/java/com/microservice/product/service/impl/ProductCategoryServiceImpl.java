package com.microservice.product.service.impl;

import com.microservice.product.entity.ProductCategory;
import com.microservice.product.reponsitory.ProductCategoryRepository;
import com.microservice.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.service.impl
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/6
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
