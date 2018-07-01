package com.microservice.product.clients;

import com.microservice.product.entity.DecreaseStockInput;
import com.microservice.product.entity.ProductInfoOutput;
import com.microservice.product.entity.vo.ProductVo;
import com.microservice.product.entity.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.clients
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/20
 */
@FeignClient(name = "product")
public interface ProductClients {

    @RequestMapping("/product/list")
    ResultVo<ProductVo> getProductList();

    @RequestMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIds);

    @RequestMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInput);
}
