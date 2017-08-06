package com.aaron.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Aaron on 2017/8/5.
 * 配置拦截器类
 */
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 多个拦截器组成一个拦截器链,可注册多个
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("*Page$");
//        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
//        super.addInterceptors(registry);

    }
}
