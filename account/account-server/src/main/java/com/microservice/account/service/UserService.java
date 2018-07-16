package com.microservice.account.service;

import com.microservice.account.entity.UserInfo;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.service.impl
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/7/3
 */
public interface UserService {

    UserInfo getByOpenId(String openId);
}
