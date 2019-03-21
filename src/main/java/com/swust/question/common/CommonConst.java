package com.swust.question.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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
    public static String baseURL;

    @Value("${weixin.base.url}")
    private String tempURL;

    @PostConstruct
    public void getValue(){
        baseURL=this.tempURL;
    }

    public String getBaseURL() {
        return baseURL;
    }
}
