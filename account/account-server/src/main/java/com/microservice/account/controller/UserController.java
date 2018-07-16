package com.microservice.account.controller;

import com.microservice.account.common.CookieConstant;
import com.microservice.account.common.ResultNum;
import com.microservice.account.common.RoleEnum;
import com.microservice.account.entity.UserInfo;
import com.microservice.account.entity.vo.ResultVo;
import com.microservice.account.service.UserService;
import com.microservice.account.util.CookieUtil;
import com.microservice.account.util.KeyUtil;
import com.microservice.account.util.ResultVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.controller
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/7/3
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 买家端登录
     *
     * @param openId
     * @param response
     * @return
     */
    @RequestMapping("/login/buyer")
    public ResultVo buyerLogin(String openId, HttpServletResponse response) {
        UserInfo userInfo = userService.getByOpenId(openId);

        if (null != userInfo) {
            if (RoleEnum.SALLER.getCode().equals(userInfo.getRole())) {
                return ResultVoUtil.loginFail(ResultNum.ROLE_ERROR);
            } else {
                //登录成功,设置cookie的openid为openid
                CookieUtil.setCookie(response, CookieConstant.OPENID, openId, CookieConstant.expire);
                return ResultVoUtil.success();
            }
        } else {
            return ResultVoUtil.loginFail(ResultNum.LOGIN_FAIL);
        }
    }

    @RequestMapping("/login/saller")
    public ResultVo sallerLogin(String openId, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);
        if (null != cookie) {
            String s = stringRedisTemplate.opsForValue().get(String.format(CookieConstant.TOKEN_TEMPLTE, cookie.getValue()));
            if (!StringUtils.isEmpty(cookie) && openId.equals(s)) {
                return ResultVoUtil.success();
            }
        } else {
            UserInfo userInfo = userService.getByOpenId(openId);
            if (RoleEnum.BUYER.getCode().equals(userInfo.getRole())) {
                return ResultVoUtil.loginFail(ResultNum.ROLE_ERROR);
            } else {
                //登录成功,设置cookie的openid为openid
                String token = KeyUtil.getUniqueKey();
                CookieUtil.setCookie(response, CookieConstant.TOKEN,token, CookieConstant.expire);
                //设置到Redis中
                stringRedisTemplate.opsForValue().set(String.format(CookieConstant.TOKEN_TEMPLTE, token), openId, CookieConstant.expire, TimeUnit.SECONDS);
                return ResultVoUtil.success();
            }
        }
        return ResultVoUtil.loginFail(ResultNum.LOGIN_FAIL);
    }


}
