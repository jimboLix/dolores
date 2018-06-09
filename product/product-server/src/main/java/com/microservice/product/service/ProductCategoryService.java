package com.microservice.product.service;

import com.microservice.product.entity.ProductCategory;

import java.util.List;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.service
 * @Description:
 * @date 2018/5/6
 */
public interface ProductCategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
