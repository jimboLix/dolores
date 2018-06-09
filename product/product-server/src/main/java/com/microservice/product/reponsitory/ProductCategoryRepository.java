package com.microservice.product.reponsitory;

import com.microservice.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.reponsitory
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/6
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,String> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
