package com.microservice.order.util;


import com.microservice.order.entity.vo.ResultVo;

import java.io.Serializable;
import java.util.List;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.util
 * @Description: 用于封装返回结果
 * @date 2018/5/10
 */
public class ResultVoUtil implements Serializable {
    private static final long serialVersionUID = 2754236880693984992L;

    public static ResultVo success(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMessage("成功");
        resultVo.setData(data);
        return resultVo;
    }
}
