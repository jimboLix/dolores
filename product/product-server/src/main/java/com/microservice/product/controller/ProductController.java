package com.microservice.product.controller;

import com.microservice.product.entity.DecreaseStockInput;
import com.microservice.product.entity.ProductCategory;
import com.microservice.product.entity.ProductInfo;
import com.microservice.product.entity.ProductInfoOutput;
import com.microservice.product.entity.vo.ProductInfoVo;
import com.microservice.product.entity.vo.ProductVo;
import com.microservice.product.entity.vo.ResultVo;
import com.microservice.product.service.ProductCategoryService;
import com.microservice.product.service.ProductInfoService;
import com.microservice.product.util.ResultVoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.controller
 * @Description: 商品控制层
 * @date 2018/5/9
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/list")
    public ResultVo<ProductVo> getProductList() {
        List<ProductInfo> productInfoList = productInfoService.getAllUp();
        //java 8的lambada表达式，请学习
        List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> categoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        List<ProductVo> productVoList = new ArrayList<>();

        for (ProductCategory category : categoryList) {
            ProductVo productVo = new ProductVo();

            for (ProductInfo info : productInfoList) {

                if (info.getCategoryType().equals(category.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(info, productInfoVo);
                    productVo.getFoods().add(productInfoVo);
                }
            }
            BeanUtils.copyProperties(category, productVo);
            productVoList.add(productVo);
        }

        return ResultVoUtil.success(productVoList);
    }

    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIds){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productInfoService.productListForOrder(productIds);
    }

    /**
     *  @requestBody 注解常用来处理content-type不是默认的application/x-www-form-urlcoded编码的内容，
     *  比如说：application/json或者是application/xml等。一般情况下来说常用其来处理application/json类型。
     *  通过@requestBody可以将请求体中的JSON字符串绑定到相应的bean上
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList){
        productInfoService.decreaseStock(decreaseStockInputList);
    }
}
