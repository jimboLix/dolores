package com.microservice.product.entity.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.product.entity.util
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/6/18
 */
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object o){
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object fromJson(String jsonString,TypeReference typeReference){
        try {
            return objectMapper.readValue(jsonString,typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
