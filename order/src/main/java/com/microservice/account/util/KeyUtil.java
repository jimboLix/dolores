package com.microservice.account.util;

import java.util.Random;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.util
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/5/13
 */
public class KeyUtil {

    public static String getUniqueKey() {
        Random random = new Random();
        int i = random.nextInt(90000);
        long l = System.currentTimeMillis();
        return new StringBuilder(String.valueOf(l)).append(i).toString();
    }
}
