package com.microservice.account.dao;

import com.microservice.account.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.dao
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/7/1
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {

    UserInfo getByOpenId(String openId);
}
