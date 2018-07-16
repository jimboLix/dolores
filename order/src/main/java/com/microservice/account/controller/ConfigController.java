package com.microservice.account.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.controller
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/30
 */
@RequestMapping("/config")
@RestController
@RefreshScope
public class ConfigController {

    @Value("${env}")
    private String env;

    @GetMapping("/pringEnv")
    public String pringEnv(){
        return env;
    }
}
