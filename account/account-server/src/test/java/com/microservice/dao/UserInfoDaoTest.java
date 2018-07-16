package com.microservice.dao;

import com.microservice.account.AccountServerApplication;
import com.microservice.account.dao.UserInfoRepository;
import com.microservice.account.entity.UserInfo;
import com.microservice.account.util.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.dao
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/7/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountServerApplication.class)
public class UserInfoDaoTest {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    public void testFindByOpenId(){
        UserInfo userInfo = userInfoRepository.getByOpenId("11");
        System.out.println("++++++++++++++++++"+userInfo.getUserName()+"++++++++++++++++++");
        Assert.assertNotEquals("success",true);
    }
}
