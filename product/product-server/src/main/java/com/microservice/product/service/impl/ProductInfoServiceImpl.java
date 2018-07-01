package com.microservice.product.service.impl;

import com.microservice.product.common.ProductStatus;
import com.microservice.product.entity.DecreaseStockInput;
import com.microservice.product.entity.ProductInfo;
import com.microservice.product.entity.ProductInfoOutput;
import com.microservice.product.entity.util.JsonUtil;
import com.microservice.product.entity.util.MessageKeyUtil;
import com.microservice.product.exception.ProductException;
import com.microservice.product.reponsitory.ProductInfoRepository;
import com.microservice.product.service.ProductInfoService;
import com.microservice.product.util.ResultEnum;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.color.ProfileDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    @Autowired
    private AmqpTemplate amqpTemplate;

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

    @Override
    public void decreaseStock(List<DecreaseStockInput> inputs) {
        List<ProductInfo> productInfoList = this.decreaseStockProcess(inputs);
        //转换为outputInfo并发送MQ消息
        List<ProductInfoOutput> productInfoOutputList = productInfoList.stream().map(info -> {
            ProductInfoOutput po = new ProductInfoOutput();
            BeanUtils.copyProperties(info, po);
            return po;
        }).collect(Collectors.toList());

        amqpTemplate.convertAndSend(MessageKeyUtil.OUTPUTINFOKEY, JsonUtil.toJson(productInfoOutputList));
    }

    /**
     * 放在同一事务下保证全部扣除库存成功
     * @param inputs
     * @return
     */
    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> inputs) {
        List<ProductInfo> productInfoList = new ArrayList<>();
        if (null != inputs && inputs.size() > 0) {
            for (DecreaseStockInput decreaseStock : inputs) {
                //查询是否存在该商品
                Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStock.getProductId());
                if (!productInfoOptional.isPresent()) {
                    throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
                }
                ProductInfo productInfo = productInfoOptional.get();
                Integer result = productInfo.getProductStock() - decreaseStock.getProductQuantity();
                //库存不足
                if(result < 0){
                    throw  new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
                }

                productInfo.setProductStock(result);
                productInfoRepository.save(productInfo);
                productInfoList.add(productInfo);
            }
        }

        return  productInfoList;
    }
}
