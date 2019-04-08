package com.swust.question.config;

import com.swust.question.utils.token.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TokenConfig
 * @Package com.swust.question.config
 * @description: token配置，主要是注册拦截器
 * @date 2019/4/7 9:40
 */
@Configuration
public class TokenConfig extends WebMvcConfigurationSupport {
    @Autowired
    private TokenInterceptor tokenInterceptor;

    /**
     * 添加token拦截器
     * @author pang
     * @date 2019/4/7
     * @param registry
     * @return void
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor);
        super.addInterceptors(registry);
    }
}
