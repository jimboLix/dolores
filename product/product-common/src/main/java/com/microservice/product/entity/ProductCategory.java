package com.microservice.product.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.entity
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/6
 */
@Data
@Entity
public class ProductCategory implements Serializable {

    @Id
    @Column(name = "category_id")
    private String id;

    @Column
    private String categoryName;

    @Column
    private Integer categoryType;

    @Column
    private Date createTime;

    @Column
    private Date updateTime;


}
