package com.microservice.account.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.entity.vo
 * @Description: Http请求返回信息封装类
 * @date 2018/5/9
 */
@Data
public class ResultVo<T> implements Serializable{
    private static final long serialVersionUID = 3681175382719728084L;

    private Integer code;

    private String message;

    private List<T> data;
}
