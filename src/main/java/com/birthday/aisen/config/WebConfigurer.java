package com.birthday.aisen.config;

import org.springframework.context.annotation.Configuration;
import com.birthday.aisen.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 添加拦截；excludePathPatterns 排除拦截
        registry.addInterceptor(loginInterceptor).addPathPatterns("/api/user/**");
    }

}
