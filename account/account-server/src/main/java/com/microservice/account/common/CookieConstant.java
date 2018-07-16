package com.microservice.account.common;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.common
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/7/3
 */
public interface CookieConstant {

    String TOKEN = "token";
    String OPENID = "openId";
    int expire = 7200;

    String TOKEN_TEMPLTE = "token_%s";
}
