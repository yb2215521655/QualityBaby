package com.swust.question.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author pang
 * @version V1.0
 * @ClassName: CommonConst
 * @Package com.swust.question.common
 * @description: 常量集合
 * @date 2019/3/20 23:45
 */
@Component
public class CommonConst {
    /**
     * 微信接口基础url
     * */
    @Value("${weixin.base-url}")
    private static String baseURL;

    public static String getBaseURL() {
        return baseURL;
    }
}
