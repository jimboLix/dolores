package com.microservice.account.service.impl;

import com.microservice.account.dao.UserInfoRepository;
import com.microservice.account.entity.UserInfo;
import com.microservice.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.service.impl
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/7/3
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo getByOpenId(String openId) {
        return userInfoRepository.getByOpenId(openId);
    }
}
